package com.baidu.baidunavis.control;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavModelHelper;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviAction;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviEnter;
import com.baidu.baidunavis.ui.widget.RoutePlanObserver;
import com.baidu.baidunavis.ui.widget.RoutePlanObserver.IJumpToDownloadListener;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.view.dialog.C2278e;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.location.LocationManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.platform.comapi.C2907c;
import java.util.ArrayList;

public class NavPoiController {
    private static final String TAG = "NavPoiController";
    private static C2278e mWaitProgress = null;
    private Activity mActivity;
    private Context mContext;
    private int mDistrictId;
    private int mId;
    private Handler mRPHandler;
    private RoutePlanObserver mRoutePlanObserver;
    private SearchPoi mRoutePlanPoi;
    private String mSearchKey;
    private int mSearchRsultNetMode;
    private GeoPoint myPositionPoint;

    /* renamed from: com.baidu.baidunavis.control.NavPoiController$1 */
    class C08061 implements IJumpToDownloadListener {
        C08061() {
        }

        public void onJumpToDownloadOfflineData() {
            C1328h.m4757a().showFragment(NaviFragmentManager.TYPE_OFFLINE_DATA, null);
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavPoiController$2 */
    class C08072 extends BNMainLooperHandler {
        C08072() {
        }

        public void onMessage(Message msg) {
            switch (msg.what) {
                case 4:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(NavPoiController.this.mRPHandler);
                    BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_RPLAN, NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
                    NavRoutePlanController.getInstance().statisticsRoutePlanSuc();
                    int gpsState = NavMapAdapter.getInstance().isGpsEnabled() ? NavMapAdapter.getInstance().isGPSLocationValid() ? 1 : 2 : 0;
                    BNRoutePlaner.getInstance().triggerGPSStatus(gpsState);
                    NavRoutePlanModel.getInstance().setmNavEnter(NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
                    BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
                    if (BNStyleManager.getRealDayStyle() || NavMapManager.getInstance().isChangedMapMode()) {
                        NavPoiController.this.dismissWaitProgressDialog();
                        NavMapAdapter.getInstance().showFragment(52, null);
                        return;
                    }
                    sendEmptyMessageDelayed(222, 1000);
                    return;
                case 7:
                    NavPoiController.this.dismissWaitProgressDialog();
                    BNRoutePlaner.getInstance().removeRouteResultHandler(NavPoiController.this.mRPHandler);
                    return;
                case 8:
                    NavPoiController.this.showWaitProgressDialog();
                    return;
                case 32:
                    NavPoiController.this.dismissWaitProgressDialog();
                    BNRoutePlaner.getInstance().removeRouteResultHandler(NavPoiController.this.mRPHandler);
                    return;
                case 222:
                    NavPoiController.this.dismissWaitProgressDialog();
                    NavMapAdapter.getInstance().showFragment(52, null);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavPoiController$3 */
    class C08083 implements C0672b {
        C08083() {
        }

        public void onClick() {
            LogUtil.e("RoutePlan", "WaitProgress onCancel!");
            BNRoutePlaner.getInstance().cancleCalcRouteRequest();
            BNRoutePlaner.getInstance().clearRouteInfoHandler();
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavPoiController$4 */
    class C08094 implements C0690d {
        C08094() {
        }

        public void onCancel() {
            LogUtil.e("RoutePlan", "WaitProgress onCancel!");
            BNRoutePlaner.getInstance().cancleCalcRouteRequest();
            BNRoutePlaner.getInstance().clearRouteInfoHandler();
        }
    }

    static class InnerHolder {
        static NavPoiController mInstance = new NavPoiController();

        InnerHolder() {
        }
    }

    private NavPoiController() {
        this.mSearchRsultNetMode = 1;
        this.mRPHandler = new C08072();
        this.mContext = BNaviModuleManager.getContext();
        this.mRoutePlanObserver = new RoutePlanObserver(new C08061());
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public static NavPoiController getInstance() {
        return InnerHolder.mInstance;
    }

    public void setSearchKey(String key) {
        this.mSearchKey = key;
    }

    public void setMyPositionGeo(GeoPoint point) {
        if (point != null) {
            this.myPositionPoint = point;
            PoiSearchModel poiSearchModel = (PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH);
            if (poiSearchModel != null) {
                poiSearchModel.setMyPositionGeo(point);
            }
        }
    }

    public String getDistance2CurrentPoint(SearchPoi searchPoi) {
        if (searchPoi == null) {
            return "无数据";
        }
        return getDistance2CurrentPoint(searchPoi.mViewPoint);
    }

    public String getDistance2CurrentPoint(GeoPoint point) {
        if (point == null || !point.isValid()) {
            return "";
        }
        if (this.myPositionPoint == null || !this.myPositionPoint.isValid()) {
            return "";
        }
        return StringUtils.getDistance((double) (point.getLongitudeE6() - this.myPositionPoint.getLongitudeE6()), (double) (point.getLatitudeE6() - this.myPositionPoint.getLatitudeE6()));
    }

    public void setSearchNetMode(int searchNetMode) {
        this.mSearchRsultNetMode = searchNetMode;
    }

    public int getSearchNetMode() {
        return this.mSearchRsultNetMode;
    }

    public void updatePoiBkgLayer(ArrayList<SearchPoi> searchPois) {
        if (searchPois != null) {
            BNPoiSearcher.getInstance().clearBkgCache();
            ArrayList<GeoPoint> geoList = new ArrayList(searchPois.size());
            for (int i = 0; i < searchPois.size(); i++) {
                SearchPoi poi = (SearchPoi) searchPois.get(i);
                if (poi != null) {
                    geoList.add(poi.mViewPoint);
                }
            }
            BNPoiSearcher.getInstance().updateBkgCache(geoList, -1);
            BNMapController.getInstance().updateLayer(4);
            BNMapController.getInstance().updateLayer(3);
        }
    }

    public void focusPoi(SearchPoi poi) {
        if (poi != null) {
            focusPoi(poi.mViewPoint);
        }
    }

    public void focusPoi(ArrayList<SearchPoi> mPoiList, int id) {
        if (mPoiList != null) {
            this.mId = id;
            BNPoiSearcher.getInstance().clearPoiCache();
            BNPoiSearcher.getInstance().updatePoiCacheWithList(mPoiList);
            BNMapController.getInstance().showLayer(3, true);
            BNMapController.getInstance().updateLayer(3);
        }
    }

    public void focusPoi(GeoPoint geoPoint) {
        if (geoPoint != null && geoPoint.isValid()) {
            this.mId = 0;
            BNPoiSearcher.getInstance().clearPoiCache();
            BNPoiSearcher.getInstance().updatePoiCache(geoPoint);
            BNMapController.getInstance().showLayer(3, true);
            BNMapController.getInstance().updateLayer(3);
        }
    }

    public void focusMadianPoi(SearchPoi mCurrentPoi, boolean isMaDian, int index) {
        if (mCurrentPoi != null) {
            this.mId = 0;
            BNPoiSearcher.getInstance().clearPoiCache();
            BNPoiSearcher.getInstance().updateBkgPoiCache(mCurrentPoi.mViewPoint, isMaDian, index);
            BNMapController.getInstance().showLayer(3, true);
            BNMapController.getInstance().updateLayer(3);
        }
    }

    public void focusItem(boolean focusFlag) {
        BNMapController.getInstance().focusItem(3, this.mId, focusFlag);
    }

    public void clearPoiCache() {
        BNPoiSearcher.getInstance().clearPoiCache();
        BNMapController.getInstance().showLayer(3, false);
        BNMapController.getInstance().updateLayer(3);
    }

    public void setMapffset(long xOffset, long yOffset) {
        MapStatus st = NMapControlProxy.getInstance().getMapStatus();
        if (st != null) {
            st._Xoffset = xOffset;
            st._Yoffset = yOffset;
            NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationNone);
        }
    }

    public void animationByFrogleap(GeoPoint geopoint) {
        if (geopoint != null && geopoint.isValid()) {
            MapStatus curMapStatus = BNMapController.getInstance().getMapStatus();
            Bundle b = CoordinateTransformUtil.LLE62MC(geopoint.getLongitudeE6(), geopoint.getLatitudeE6());
            if (curMapStatus != null && b != null) {
                curMapStatus._CenterPtX = b.getInt("MCx");
                curMapStatus._CenterPtY = b.getInt("MCy");
                BNMapController.getInstance().setMapStatus(curMapStatus, AnimationType.eAnimationFrogleap);
            }
        }
    }

    public void animationByFrogleap(SearchPoi searchPoi) {
        if (searchPoi != null) {
            animationByFrogleap(searchPoi.mViewPoint);
        }
    }

    public void setDistrictId(int districtid) {
        this.mDistrictId = districtid;
    }

    public int getDistrictId() {
        return this.mDistrictId;
    }

    public void animationTo(GeoPoint geopoint) {
        if (geopoint != null && geopoint.isValid()) {
            MapStatus curMapStatus = BNMapController.getInstance().getMapStatus();
            Bundle b = CoordinateTransformUtil.LLE62MC(geopoint.getLongitudeE6(), geopoint.getLatitudeE6());
            if (!(b == null || b.isEmpty())) {
                curMapStatus._CenterPtX = b.getInt("MCx");
                curMapStatus._CenterPtY = b.getInt("MCy");
            }
            BNMapController.getInstance().setMapStatus(curMapStatus, AnimationType.eAnimationPos);
        }
    }

    public void animationTo(GeoPoint geopoint, long xOffset, long yOffset, int level) {
        animationTo(geopoint, xOffset, yOffset, level, true);
    }

    public void animationTo(GeoPoint geopoint, long xOffset, long yOffset, int level, boolean anim) {
        if (geopoint != null && geopoint.isValid()) {
            MapStatus curMapStatus = BNMapController.getInstance().getMapStatus();
            if (curMapStatus != null) {
                Bundle b = CoordinateTransformUtil.LLE62MC(geopoint.getLongitudeE6(), geopoint.getLatitudeE6());
                if (!(b == null || b.isEmpty())) {
                    curMapStatus._CenterPtX = b.getInt("MCx");
                    curMapStatus._CenterPtY = b.getInt("MCy");
                }
                curMapStatus._Xoffset = xOffset;
                curMapStatus._Yoffset = yOffset;
                if (level > 0) {
                    curMapStatus._Level = (float) level;
                }
                BNMapController.getInstance().setMapStatus(curMapStatus, anim ? AnimationType.eAnimationPos : AnimationType.eAnimationNone);
            }
        }
    }

    public void animationTo(GeoPoint geopoint, long xOffset, long yOffset) {
        animationTo(geopoint, xOffset, yOffset, -1);
    }

    public int getAntiPoiNetMode(GeoPoint geopoint) {
        int finalNetMode = -1;
        if (geopoint == null || !geopoint.isValid()) {
            return -1;
        }
        boolean hasDownloadData = false;
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            DistrictInfo childDistrictInfo = BNPoiSearcher.getInstance().getDistrictByPoint(geopoint, 0);
            if (childDistrictInfo != null) {
                DistrictInfo parentDistrict = BNPoiSearcher.getInstance().getParentDistrict(childDistrictInfo.mId);
                if (parentDistrict != null) {
                    hasDownloadData = BNOfflineDataManager.getInstance().isProvinceDataDownload(parentDistrict.mId);
                }
            }
        }
        if (hasDownloadData) {
            finalNetMode = 0;
        } else if (NetworkUtils.getConnectStatus()) {
            finalNetMode = 1;
        }
        return finalNetMode;
    }

    public boolean antiGeo(SearchPoi poi, int netMode, Handler handler) {
        if (poi == null) {
            return false;
        }
        return BNPoiSearcher.getInstance().asynGetPoiByPoint(poi.mViewPoint, netMode, 10000, handler);
    }

    private RoutePlanNode createRoutePlanNode(SearchPoi node) {
        return new RoutePlanNode(node.mGuidePoint, node.mViewPoint, 8, node.mName, node.mAddress, node.mOriginUID);
    }

    public void startCalcRoute(SearchPoi poi) {
        if (!NavRouteGuideController.getInstance().isThirdServer()) {
            NavRouteGuideController.getInstance().setBNavigatorListener(null);
        }
        NavRouteGuideController.getInstance().setIsThirdServer(false);
        if (poi != null) {
            this.mRoutePlanPoi = poi;
            LogUtil.e(TAG, "calc route");
            RoutePlanNode navNode = createRoutePlanNode(poi);
            navNode.mBusinessPoi = poi.mWanda;
            if (this.mSearchRsultNetMode == 0 && poi != null) {
                BNPoiSearcher.getInstance().inputIndex(this.mSearchKey, this.mDistrictId, poi.mId);
            }
            setDestCalcRoute(navNode, this.mRPHandler);
        }
    }

    public void startCalcRoute(RoutePlanNode navNode) {
        NavRouteGuideController.getInstance().setBNavigatorListener(null);
        NavRouteGuideController.getInstance().setIsThirdServer(false);
        if (navNode != null) {
            LogUtil.e(TAG, "calc route for navNode");
            setDestCalcRoute(navNode, this.mRPHandler);
        }
    }

    public boolean dismissWaitProgressDialog() {
        NavMapAdapter.getInstance().dismissWaitProgressDialog();
        return true;
    }

    public void showWaitProgressDialog() {
        dismissWaitProgressDialog();
        try {
            NavMapAdapter.getInstance().showProgressDialog(getRoutePlanTipsMsg(), new C08083(), new C08094());
        } catch (Exception e) {
        }
    }

    public String getRoutePlanTipsMsg() {
        String msg = "";
        switch (BNRoutePlaner.getInstance().getGuideSceneType()) {
            case 1:
                msg = this.mContext.getResources().getString(C0965R.string.route_plane);
                break;
            case 2:
                msg = this.mContext.getResources().getString(C0965R.string.route_dir_plane);
                break;
            case 4:
                msg = this.mContext.getResources().getString(C0965R.string.route_place_plane);
                break;
            default:
                msg = this.mContext.getResources().getString(C0965R.string.route_plane);
                break;
        }
        BNRoutePlaner.getInstance().setGuideSceneType(1);
        return msg;
    }

    public void setDestCalcRoute(RoutePlanNode node, Handler handler) {
        if (LocationManager.getInstance().isLocationValid()) {
            BNRoutePlaner.getInstance().cancleCalcRouteRequest();
            BNRoutePlaner.getInstance().clearRouteInfoHandler();
            NavRoutePlanModel.getInstance().setStartRouteNode(NavMapAdapter.getInstance().getRouteNode(NavMapAdapter.getInstance().getGeoPoint(null, true), RoutePlanParams.MY_LOCATION, null));
            NavRoutePlanModel.getInstance().setEndRouteNode(NavMapAdapter.getInstance().getRouteNode(NavModelHelper.convertGeoPoint(node.getGeoPoint()), node.getName(), node.getUID()));
            NavMapAdapter.getInstance().setPreferValue(NavMapAdapter.getInstance().onGetLastPreferValue());
            BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
            BNRoutePlaner.getInstance().addRouteResultHandler(handler);
            ArrayList<RoutePlanNode> nodes = new ArrayList(2);
            nodes.add(NavModelHelper.convertRouteNode(NavRoutePlanModel.getInstance().getStartRouteNode()));
            nodes.add(node);
            NavSearchController.getInstance().setRpEntry(6);
            BNRoutePlaner.getInstance().setPointsToCalcRoute(nodes, 0);
            return;
        }
        Toast.makeText(C2907c.m10977f(), "定位失败,请检查网络后重试!", 0).show();
    }
}
