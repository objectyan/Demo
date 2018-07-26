package com.baidu.navi.cache;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavRouteGuideController;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.entity.pb.Mrtl;
import com.baidu.entity.pb.Mrtl.Content;
import com.baidu.entity.pb.Mrtl.Content.Route;
import com.baidu.entity.pb.MultiNavi;
import com.baidu.entity.pb.NaviContent;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.basic.BMExecutorsManager;
import com.baidu.platform.comjni.tools.ProtobufUtils;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class RouteInfoCache {
    public static final String COMPANY_TYPE = "company";
    public static final String HOME_TYPE = "home";
    private static final double MAX_DISTANCE = 50000.0d;
    public static final int NUM_100 = 100;
    public static final int NUM_1000 = 1000;
    private static final int RETCODE_OK = 0;
    private Handler companyInfoHandler;
    private Handler homeInfoHandler;
    private Callback mCallback;
    private String mCompanyDistance;
    private int mCompanyDistanceInt;
    private RoutePlanNode mCompanyNode;
    private String mCompanyTime;
    private int mCompanyTimeInt;
    private long mCompanyTimestamp;
    private GeoPoint mCurrentPoint;
    private final Handler mHandler;
    private String mHomeDistance;
    private int mHomeDistanceInt;
    private RoutePlanNode mHomeNode;
    private String mHomeTime;
    private int mHomeTimeInt;
    private long mHomeTimestamp;

    /* renamed from: com.baidu.navi.cache.RouteInfoCache$3 */
    class C36743 implements Runnable {
        C36743() {
        }

        public void run() {
            if (RouteInfoCache.this.mHomeNode != null && RouteInfoCache.this.mHomeNode.mGeoPoint != null) {
                RouteNode startNode = NavMapAdapter.getInstance().getRouteNode(NavMapAdapter.getInstance().getGeoPoint(null, true), RoutePlanParams.MY_LOCATION, null);
                startNode.mFromType = 3;
                RouteInfoCache.this.getRouteTraffic(RouteInfoCache.this.getFromType("home"), startNode, RouteInfoCache.this.coverRoutePlanNodeToRouteNode(RouteInfoCache.this.mHomeNode), "home");
            }
        }
    }

    /* renamed from: com.baidu.navi.cache.RouteInfoCache$4 */
    class C36754 implements Runnable {
        C36754() {
        }

        public void run() {
            if (RouteInfoCache.this.mCompanyNode != null && RouteInfoCache.this.mCompanyNode.mGeoPoint != null) {
                RouteNode startNode = NavMapAdapter.getInstance().getRouteNode(NavMapAdapter.getInstance().getGeoPoint(null, true), RoutePlanParams.MY_LOCATION, null);
                startNode.mFromType = 3;
                RouteInfoCache.this.getRouteTraffic(RouteInfoCache.this.getFromType("company"), startNode, RouteInfoCache.this.coverRoutePlanNodeToRouteNode(RouteInfoCache.this.mCompanyNode), "company");
            }
        }
    }

    /* renamed from: com.baidu.navi.cache.RouteInfoCache$5 */
    class C36765 implements Runnable {
        C36765() {
        }

        public void run() {
            if (RouteInfoCache.this.mCallback != null) {
                RouteInfoCache.this.mCallback.onHomeInfo(RouteInfoCache.this.mHomeTime, RouteInfoCache.this.mHomeDistance);
            }
        }
    }

    /* renamed from: com.baidu.navi.cache.RouteInfoCache$6 */
    class C36776 implements Runnable {
        C36776() {
        }

        public void run() {
            if (RouteInfoCache.this.mCallback != null) {
                RouteInfoCache.this.mCallback.onCompanyInfo(RouteInfoCache.this.mCompanyTime, RouteInfoCache.this.mCompanyDistance);
            }
        }
    }

    public interface Callback {
        void onCompanyInfo(String str, String str2);

        void onHomeInfo(String str, String str2);
    }

    private static class InstanceHolder {
        static final RouteInfoCache INSTANCE = new RouteInfoCache();

        private InstanceHolder() {
        }
    }

    private RouteInfoCache() {
        this.mHomeNode = null;
        this.mHomeTime = "";
        this.mHomeDistance = "";
        this.mHomeTimeInt = 0;
        this.mHomeDistanceInt = 0;
        this.mHomeTimestamp = 0;
        this.mCompanyNode = null;
        this.mCompanyTime = "";
        this.mCompanyDistance = "";
        this.mCompanyTimeInt = 0;
        this.mCompanyDistanceInt = 0;
        this.mCompanyTimestamp = 0;
        this.homeInfoHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 4:
                        BNRoutePlaner.getInstance().removeRouteResultHandler(RouteInfoCache.this.homeInfoHandler);
                        RoutePlanModel routePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
                        if (routePlanModel != null) {
                            RouteInfoCache.this.mHomeTimeInt = routePlanModel.getTotalTimeInt();
                            RouteInfoCache.this.mHomeDistanceInt = routePlanModel.getTotalDistanceInt();
                            RouteInfoCache.this.mHomeTime = routePlanModel.getTotalTime();
                            RouteInfoCache.this.mHomeDistance = routePlanModel.getDistance();
                            RouteInfoCache.this.mHomeTimestamp = System.currentTimeMillis();
                        }
                        if (RouteInfoCache.this.mCallback != null) {
                            RouteInfoCache.this.mCallback.onHomeInfo(RouteInfoCache.this.mHomeTime, RouteInfoCache.this.mHomeDistance);
                        }
                        if (RouteInfoCache.this.mCompanyNode == null) {
                            return;
                        }
                        if (RouteInfoCache.this.mCompanyTimeInt == 0 || RouteInfoCache.this.mCompanyDistanceInt == 0) {
                            RouteInfoCache.this.asynGetCompanyInfo();
                            return;
                        }
                        return;
                    case 7:
                        BNRoutePlaner.getInstance().removeRouteResultHandler(RouteInfoCache.this.homeInfoHandler);
                        if (RouteInfoCache.this.mCompanyNode == null) {
                            return;
                        }
                        if (RouteInfoCache.this.mCompanyTimeInt == 0 || RouteInfoCache.this.mCompanyDistanceInt == 0) {
                            RouteInfoCache.this.asynGetCompanyInfo();
                            return;
                        }
                        return;
                    case 32:
                        BNRoutePlaner.getInstance().removeRouteResultHandler(RouteInfoCache.this.homeInfoHandler);
                        return;
                    default:
                        return;
                }
            }
        };
        this.companyInfoHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 4:
                        BNRoutePlaner.getInstance().removeRouteResultHandler(RouteInfoCache.this.companyInfoHandler);
                        RoutePlanModel routePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
                        if (routePlanModel != null) {
                            RouteInfoCache.this.mCompanyTimeInt = routePlanModel.getTotalTimeInt();
                            RouteInfoCache.this.mCompanyDistanceInt = routePlanModel.getTotalDistanceInt();
                            RouteInfoCache.this.mCompanyTime = routePlanModel.getTotalTime();
                            RouteInfoCache.this.mCompanyDistance = routePlanModel.getDistance();
                            RouteInfoCache.this.mCompanyTimestamp = System.currentTimeMillis();
                        }
                        if (RouteInfoCache.this.mCallback != null) {
                            RouteInfoCache.this.mCallback.onCompanyInfo(RouteInfoCache.this.mCompanyTime, RouteInfoCache.this.mCompanyDistance);
                            return;
                        }
                        return;
                    case 7:
                    case 32:
                        BNRoutePlaner.getInstance().removeRouteResultHandler(RouteInfoCache.this.companyInfoHandler);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public static RouteInfoCache getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void resetHomeInfo(RoutePlanNode homeNode) {
        this.mHomeNode = homeNode;
        this.mHomeTime = "";
        this.mHomeDistance = "";
        this.mHomeTimeInt = 0;
        this.mHomeDistanceInt = 0;
        this.mHomeTimestamp = 0;
    }

    public void resetCompanyInfo(RoutePlanNode companyNode) {
        this.mCompanyNode = companyNode;
        this.mCompanyTime = "";
        this.mCompanyDistance = "";
        this.mCompanyTimeInt = 0;
        this.mCompanyDistanceInt = 0;
        this.mCompanyTimestamp = 0;
    }

    public void getHomeAndCompanyInfo(RoutePlanNode homeNode, RoutePlanNode companyNode, Callback cb) {
        long currentTime = System.currentTimeMillis();
        if (!isPointValid() || currentTime - this.mHomeTimestamp > 60000) {
            resetHomeInfo(this.mHomeNode);
        }
        if (!isPointValid() || currentTime - this.mCompanyTimestamp > 60000) {
            resetCompanyInfo(this.mCompanyNode);
        }
        if (homeNode == null || this.mHomeNode == null || !homeNode.getGeoPoint().equals(this.mHomeNode.getGeoPoint())) {
            resetHomeInfo(homeNode);
        }
        if (companyNode == null || this.mCompanyNode == null || !companyNode.getGeoPoint().equals(this.mCompanyNode.getGeoPoint())) {
            resetCompanyInfo(companyNode);
        }
        this.mCallback = cb;
        if (this.mHomeNode != null && this.mHomeTimeInt > 0 && this.mHomeDistanceInt > 0 && this.mCallback != null) {
            this.mCallback.onHomeInfo(this.mHomeTime, this.mHomeDistance);
        }
        if (this.mCompanyNode != null && this.mCompanyTimeInt > 0 && this.mCompanyDistanceInt > 0 && this.mCallback != null) {
            this.mCallback.onCompanyInfo(this.mCompanyTime, this.mCompanyDistance);
        }
        if (this.mHomeNode != null && (this.mHomeTimeInt == 0 || this.mHomeDistanceInt == 0)) {
            asynGetHomeInfo();
        }
        if (this.mCompanyNode == null) {
            return;
        }
        if (this.mCompanyTimeInt == 0 || this.mCompanyDistanceInt == 0) {
            asynGetCompanyInfo();
        }
    }

    private void asynGetHomeInfo() {
        resetHomeInfo(this.mHomeNode);
        BMExecutorsManager.SINGLE_EXECUTOR_SERVICE.execute(new C36743());
    }

    private void asynGetCompanyInfo() {
        resetCompanyInfo(this.mCompanyNode);
        BMExecutorsManager.SINGLE_EXECUTOR_SERVICE.execute(new C36754());
    }

    private void asynGetRouteInfo(RoutePlanNode node, Handler handler) {
        NavRouteGuideController.getInstance().setBNavigatorListener(null);
        NavRouteGuideController.getInstance().setIsThirdServer(false);
        setDestCalcRoute(node, handler);
    }

    private void setDestCalcRoute(RoutePlanNode node, Handler handler) {
        BNRoutePlaner.getInstance().cancleCalcRouteRequest();
        BNRoutePlaner.getInstance().clearRouteInfoHandler();
        BNRoutePlaner.getInstance().setObserver(null);
        BNRoutePlaner.getInstance().addRouteResultHandler(handler);
        ArrayList<RoutePlanNode> nodes = new ArrayList(2);
        nodes.add(BNLocationManagerProxy.getInstance().getCurLocationNode());
        nodes.add(node);
        BNRoutePlaner.getInstance().setPointsToCalcRoute(nodes, 0);
    }

    private boolean isPointValid() {
        GeoPoint currentPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        boolean result = this.mCurrentPoint != null && getDistance(currentPoint, this.mCurrentPoint) <= 200.0d;
        this.mCurrentPoint = currentPoint;
        return result;
    }

    private double getDistance(GeoPoint start, GeoPoint end) {
        double dx = (double) (start.getLongitudeE6() - end.getLongitudeE6());
        double dy = (double) (start.getLatitudeE6() - end.getLatitudeE6());
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    private RouteNode coverRoutePlanNodeToRouteNode(RoutePlanNode routePlanNode) {
        return NavMapAdapter.getInstance().getRouteNode(new NavGeoPoint(routePlanNode.mGeoPoint.getLongitudeE6(), routePlanNode.mGeoPoint.getLatitudeE6()), routePlanNode.mName, routePlanNode.mUID);
    }

    private void getRouteTraffic(int fromType, RouteNode startNode, RouteNode endNode, String entryKey) {
        Bundle bundle = BaiduNaviManager.getInstance().getHomeAndCompanyRouteInfo(startNode, endNode, fromType, 1);
        Mrtl mrtl = null;
        if (bundle != null && bundle.containsKey("pb_data")) {
            mrtl = parseTrafficResult(bundle.getByteArray("pb_data"), entryKey);
        }
        if (mrtl != null && mrtl.getContentCount() != 0) {
            Content content = mrtl.getContent(0);
            if (content != null && !TextUtils.isEmpty(content.getLabel()) && content.getRetCode() == 0) {
                Route route;
                if (content.getLabel().equals("home")) {
                    route = content.getRoute();
                    this.mHomeDistanceInt = route.getDistance();
                    this.mHomeTimeInt = route.getDuration();
                    this.mHomeDistance = getDistanceString(this.mHomeDistanceInt);
                    this.mHomeTime = formatTimeString(this.mHomeTimeInt);
                    this.mHomeTimestamp = System.currentTimeMillis();
                    this.mHandler.post(new C36765());
                }
                if (content.getLabel().equals("company")) {
                    route = content.getRoute();
                    this.mCompanyDistanceInt = route.getDistance();
                    this.mCompanyTimeInt = route.getDuration();
                    this.mCompanyDistance = getDistanceString(this.mCompanyDistanceInt);
                    this.mCompanyTime = formatTimeString(this.mCompanyTimeInt);
                    this.mCompanyTimestamp = System.currentTimeMillis();
                    this.mHandler.post(new C36776());
                }
            }
        }
    }

    private Mrtl parseTrafficResult(byte[] pbDatas, String label) {
        Mrtl mrtl = null;
        List<MessageMicro> messageLiteList = null;
        try {
            messageLiteList = ProtobufUtils.getMessageLiteList(pbDatas);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (messageLiteList != null) {
            for (MessageMicro messageLite : messageLiteList) {
                if (messageLite instanceof NaviContent) {
                    NaviContent naviContent = (NaviContent) messageLite;
                    if (naviContent.hasOut()) {
                        MultiNavi multinavi = null;
                        try {
                            multinavi = MultiNavi.parseFrom(naviContent.getOut().toByteArray());
                        } catch (InvalidProtocolBufferMicroException e2) {
                            e2.printStackTrace();
                        }
                        if (multinavi != null && multinavi.hasMultianviStream()) {
                            try {
                                mrtl = Mrtl.parseFrom(multinavi.getMultianviStream().toByteArray());
                                if (!(mrtl == null || mrtl.getContentList().isEmpty())) {
                                    mrtl.getContent(0).setLabel(label);
                                }
                            } catch (InvalidProtocolBufferMicroException e22) {
                                e22.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return mrtl;
    }

    private int getFromType(String key) {
        if (!TextUtils.isEmpty(key)) {
            if (TextUtils.equals(key, "home")) {
                return 0;
            }
            if (TextUtils.equals(key, "company")) {
                return 1;
            }
        }
        return 2;
    }

    public static String getDistanceString(int nDistance) {
        if (nDistance < 1000) {
            return String.format("%d米", new Object[]{Integer.valueOf(nDistance)});
        } else if (nDistance % 1000 == 0) {
            return String.format("%d公里", new Object[]{Integer.valueOf(nDistance / 1000)});
        } else {
            return String.format("%d.%d公里", new Object[]{Integer.valueOf(nDistance / 1000), Integer.valueOf((nDistance % 1000) / 100)});
        }
    }

    public static String formatTimeString(int secs) {
        return formatTimeString(secs, false);
    }

    public static String formatTimeString(int secs, boolean secFull) {
        String strDay = "";
        String strHour = "";
        String strSec = "";
        int time = secs;
        int iDay = time / 86400;
        if (iDay > 0) {
            strDay = String.format("%d天", new Object[]{Integer.valueOf(iDay)});
            time %= 86400;
        }
        int iHour = time / 3600;
        if (iHour > 0) {
            strHour = String.format("%d小时", new Object[]{Integer.valueOf(iHour)});
            time %= 3600;
        }
        int iSec = time / 60;
        if (iDay == 0 && iHour == 0 && iSec == 0) {
            iSec = 1;
        }
        if (iDay > 0) {
            iSec = 0;
        }
        if (iSec > 0) {
            if (iHour <= 0 || secFull) {
                strSec = String.format("%d分钟", new Object[]{Integer.valueOf(iSec)});
            } else {
                strSec = String.format("%d分", new Object[]{Integer.valueOf(iSec)});
            }
        }
        return strDay + strHour + strSec;
    }
}
