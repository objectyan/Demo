package com.baidu.navi.controller;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.baidunavis.control.NavRouteGuideController;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.StatisticUtils;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.util.ArrayList;

public class QuickRoutePlanController {
    private static final String TAG = "QuickRoute";
    public static int TYPE_COMPANY_ROUTE_COND = 2;
    public static int TYPE_HOME_AND_COMPANY_ROUTE_COND = 3;
    public static int TYPE_HOME_ROUTE_COND = 1;
    private Handler calcRouteHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(QuickRoutePlanController.this.calcRouteHandler);
                    RoutePlanModel routePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
                    if (routePlanModel != null && QuickRoutePlanController.this.mRouteInfoCallback != null) {
                        QuickRoutePlanController.this.mRouteInfoCallback.onSuccess(routePlanModel.getTotalTime(), routePlanModel.getDistance());
                        return;
                    }
                    return;
                case 7:
                case 32:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(QuickRoutePlanController.this.calcRouteHandler);
                    return;
                default:
                    return;
            }
        }
    };
    public Context mContext;
    private QuickFragmentListener mListener;
    private ContentFragmentManager mNaviFragmentManager;
    private C1277e mOnDialogListener;
    private Handler mRPHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4:
                    QuickRoutePlanController.this.mNaviFragmentManager.showFragment(52, null);
                    BNRoutePlaner.getInstance().removeRouteResultHandler(QuickRoutePlanController.this.mRPHandler);
                    return;
                case 7:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(QuickRoutePlanController.this.mRPHandler);
                    QuickRoutePlanController.this.mListener.onRefreshHistoryList();
                    return;
                case 32:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(QuickRoutePlanController.this.mRPHandler);
                    QuickRoutePlanController.this.mListener.onRefreshHistoryList();
                    return;
                case 36:
                    QuickRoutePlanController.this.mListener.onRefreshHistoryList();
                    return;
                default:
                    return;
            }
        }
    };
    private AsyncGetRouteInfoCallback mRouteInfoCallback;

    public interface AsyncGetRouteInfoCallback {
        void onSuccess(String str, String str2);
    }

    public QuickRoutePlanController(Context context, QuickFragmentListener listener, ContentFragmentManager contentFragmentManager, C1277e dialogListener) {
        this.mContext = context;
        this.mListener = listener;
        this.mNaviFragmentManager = contentFragmentManager;
        this.mOnDialogListener = dialogListener;
    }

    public void addRouteResultObserver() {
        BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
    }

    public void removeRouteResultObserver() {
        BNRoutePlaner.getInstance().removeRouteResultHandler(this.mRPHandler);
    }

    public boolean hasSetCompAddr() {
        return AddressSettingModel.hasSetCompAddr(this.mContext);
    }

    public boolean hasSetHomeAddr() {
        return AddressSettingModel.hasSetHomeAddr(this.mContext);
    }

    public RoutePlanNode getHomeAddress() {
        return AddressSettingModel.getHomeAddrNode(this.mContext);
    }

    public RoutePlanNode getCompAddress() {
        return AddressSettingModel.getCompAddrNode(this.mContext);
    }

    public String getHomeDescription() {
        return AddressSettingModel.getHomeName(this.mContext);
    }

    public String getCompDescription() {
        return AddressSettingModel.getCompName(this.mContext);
    }

    public void goHomeNavi() {
        if (hasSetHomeAddr()) {
            startRoutePlan(getHomeAddress());
            StatisticUtils.statSetDestFromQuickLink();
            StatisticManager.onEvent(StatisticConstants.WILLINGGO_HOME, StatisticConstants.WILLINGGO_HOME);
            return;
        }
        this.mListener.showSetHomeAddrDialog();
        StatisticManager.onEvent(StatisticConstants.WILLINGGO_SETHOME, StatisticConstants.WILLINGGO_SETHOME);
    }

    public void goCompNavi() {
        if (hasSetCompAddr()) {
            startRoutePlan(getCompAddress());
            StatisticUtils.statSetDestFromQuickLink();
            StatisticManager.onEvent(StatisticConstants.WILLINGGO_COMPANY, StatisticConstants.WILLINGGO_COMPANY);
            return;
        }
        this.mListener.showSetCompAddrDialog();
        StatisticManager.onEvent(StatisticConstants.WILLINGGO_SETCOMPANY, StatisticConstants.WILLINGGO_SETCOMPANY);
    }

    public void goSettingFragment(int action) {
        Bundle bundle = new Bundle();
        bundle.putInt(BundleKey.FROM_FRAGMENT, 49);
        bundle.putInt(BundleKey.SELECT_POINT_ACTION, action);
        this.mNaviFragmentManager.showFragment(51, bundle);
    }

    public void startRoutePlan(RoutePlanNode node) {
        NavPoiController.getInstance().startCalcRoute(node);
    }

    public void delHomeAddress() {
        if (AddressSettingModel.removeHomeAddress(this.mContext)) {
            this.mListener.showToast(C0965R.string.del_home_addr_sucess);
        } else {
            this.mListener.showToast(C0965R.string.del_home_addr_fail);
        }
    }

    public void delCompAddress() {
        if (AddressSettingModel.removeCompAddress(this.mContext)) {
            this.mListener.showToast(C0965R.string.del_comp_addr_sucess);
        } else {
            this.mListener.showToast(C0965R.string.del_comp_addr_fail);
        }
    }

    public void asyncGetRouteInfo(RoutePlanNode node, AsyncGetRouteInfoCallback cb) {
        this.mRouteInfoCallback = cb;
        NavRouteGuideController.getInstance().setBNavigatorListener(null);
        NavRouteGuideController.getInstance().setIsThirdServer(false);
        if (node != null) {
            setDestCalcRoute(node, this.calcRouteHandler);
        }
    }

    public void setDestCalcRoute(RoutePlanNode node, Handler handler) {
        BNRoutePlaner.getInstance().cancleCalcRouteRequest();
        BNRoutePlaner.getInstance().clearRouteInfoHandler();
        BNRoutePlaner.getInstance().addRouteResultHandler(handler);
        ArrayList<RoutePlanNode> nodes = new ArrayList(2);
        nodes.add(BNLocationManagerProxy.getInstance().getCurLocationNode());
        nodes.add(node);
        BNRoutePlaner.getInstance().setPointsToCalcRoute(nodes, 0);
    }

    public void removeCalcRouteHandler() {
        BNRoutePlaner.getInstance().removeRouteResultHandler(this.calcRouteHandler);
    }

    public int getHomeCityId() {
        return AddressSettingModel.getHomeCityId(this.mContext);
    }

    public void setHomeCityId(int cityId) {
        AddressSettingModel.setHomeCityId(this.mContext, cityId);
    }

    public int getCompCityId() {
        return AddressSettingModel.getCompCityId(this.mContext);
    }

    public void setCompCityId(int cityId) {
        AddressSettingModel.setCompCityId(this.mContext, cityId);
    }
}
