package com.baidu.navi.routedetails.proxy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.routedetails.BNMapControlPanelSimple;
import com.baidu.navi.routedetails.RGRouteDetailsOutlineItemView;
import com.baidu.navi.routedetails.RGRouteDetailsView;
import com.baidu.navi.routedetails.proxy.BNRouteDetail.BNRouteDetailNavListener;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.comapi.voicecommand.VoiceCommandHelper;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routedetails.IBNRouteDetailsListener;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.IItsClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.util.ArrayList;

public class RouteDetailMapView {
    protected static final String TAG = "RouteDetailMapView";
    private Activity mActivity;
    private boolean mAddMapCtrlPanel = true;
    private BNMapObserver mBNMapObserver = new C39573();
    private IBNRouteDetailsListener mBNRouteDetailsListener = new C39551();
    private Context mContext;
    private DistrictInfo mDistrict;
    private boolean mFirstItsOn = false;
    public IItsClickListener mItsClickListener = new C39562();
    private long mLastSingleTapTime = 0;
    private BNMapControlPanelSimple mMapControlPanel;
    private ViewGroup mParentView;
    private RGRouteDetailsView mRGRouteDetailsView;
    private BNRouteDetailNavListener mRouteDetailNavListener;
    private RoutePlanModel mRoutePlanModel = null;
    private ISensorChangeListener mSensorChangeListener = new C39584();

    /* renamed from: com.baidu.navi.routedetails.proxy.RouteDetailMapView$1 */
    class C39551 implements IBNRouteDetailsListener {
        C39551() {
        }

        public void onPageJump(int jumpTiming, Object arg) {
            switch (jumpTiming) {
                case 1:
                    if (RouteDetailMapView.this.mRouteDetailNavListener != null) {
                        RouteDetailMapView.this.mRouteDetailNavListener.onJumpBack();
                        return;
                    }
                    return;
                case 2:
                    if (RouteDetailMapView.this.mRouteDetailNavListener != null) {
                        RouteDetailMapView.this.mRouteDetailNavListener.onJumpHome();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onStartNavi(boolean isAnologNavi) {
            RouteDetailMapView.this.startNavi(isAnologNavi);
        }

        public void onStartRealNavi() {
            RouteDetailMapView.this.startRealNavi();
        }

        public void onSwitchOtherRoute(int index) {
        }

        public void onNotifySwitchResult(int result) {
        }

        public void onHideSidePanel() {
        }

        public void onShowSidePanel() {
        }

        public void onResetMapCtrlPanel() {
            if (RouteDetailMapView.this.mRGRouteDetailsView != null) {
                RouteDetailMapView.this.reloadMapControlPanel(RouteDetailMapView.this.mRGRouteDetailsView.getRootView());
            }
            if (RouteDetailMapView.this.mMapControlPanel != null) {
                RouteDetailMapView.this.mMapControlPanel.setVisible(false);
            }
        }

        public void onYawingBackGuiding() {
        }

        public void onUpdate(int type, int arg1, int arg2, Object obj) {
            switch (type) {
                case 2:
                    if (RouteDetailMapView.this.mRouteDetailNavListener != null) {
                        RouteDetailMapView.this.mRouteDetailNavListener.onUpdate();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.navi.routedetails.proxy.RouteDetailMapView$2 */
    class C39562 implements IItsClickListener {
        C39562() {
        }

        public void onClickIts() {
            StatisticManager.onEvent("NAVI_0005", "NAVI_0005");
            RouteDetailMapView.this.mFirstItsOn = BNSettingManager.isFirstItsOn();
            GeoPoint screenCenter = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getWidthPixels() / 2, ScreenUtil.getInstance().getHeightPixels() / 2);
            if (screenCenter != null && BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
                RouteDetailMapView.this.mDistrict = BNPoiSearcher.getInstance().getDistrictByPoint(screenCenter, 0);
            }
            if (BNSettingManager.isRoadCondOnOrOff()) {
                BNMapController.getInstance().showTrafficMap(false);
                BNSettingManager.setRoadCondOnOff(false);
                return;
            }
            StatisticManager.onEvent("NAVI_0006", "NAVI_0006");
            if (PreferenceHelper.getInstance(RouteDetailMapView.this.mContext).getBoolean(Key.NAVI_REAL_HISTORY_ITS, true)) {
                if (RouteDetailMapView.this.mFirstItsOn) {
                    BNSettingManager.setFirstItsOn(false);
                }
                if (NetworkUtils.isNetworkAvailable(RouteDetailMapView.this.mContext)) {
                    BNMapController.getInstance().switchITSMode(true);
                    BNMapController.getInstance().showTrafficMap(true);
                    BNSettingManager.setRoadCondOnOff(true);
                    if (RouteDetailMapView.this.mDistrict == null || BNMapController.getInstance().checkRoadConditionSupport(RouteDetailMapView.this.mDistrict.mId)) {
                        TipTool.onCreateToastDialog(RouteDetailMapView.this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_its_online_is_on));
                        return;
                    } else {
                        TipTool.onCreateToastDialog(RouteDetailMapView.this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_its_online_missing_data));
                        return;
                    }
                }
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_real_offline));
            }
        }
    }

    /* renamed from: com.baidu.navi.routedetails.proxy.RouteDetailMapView$3 */
    class C39573 implements BNMapObserver {
        C39573() {
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            if (1 == type) {
                switch (event) {
                    case 257:
                        LogUtil.m15791e(RouteDetailMapView.TAG, "MapObserver update: EVENT_MAP_ANIMATION_FINISHED");
                        if (RouteDetailMapView.this.mMapControlPanel != null) {
                            RouteDetailMapView.this.mMapControlPanel.updateView();
                            break;
                        }
                        break;
                    case 262:
                        RouteDetailMapView.this.handleCompassClicked();
                        break;
                    case 274:
                        LogUtil.m15791e(RouteDetailMapView.TAG, "MapObserver update: EVENT_MAP_ZOOM_UPDATE");
                        if (RouteDetailMapView.this.mMapControlPanel != null) {
                            RouteDetailMapView.this.mMapControlPanel.updateView();
                            break;
                        }
                        break;
                }
            }
            if (2 == type) {
                switch (event) {
                    case 514:
                        if (System.currentTimeMillis() - RouteDetailMapView.this.mLastSingleTapTime >= 500) {
                            RouteDetailMapView.this.mLastSingleTapTime = System.currentTimeMillis();
                            if (RouteDetailMapView.this.mMapControlPanel != null) {
                                RouteDetailMapView.this.mMapControlPanel.handleSingleTouchGesture();
                            }
                            RouteDetailMapView.this.switchMapcontrolVisible();
                            return;
                        }
                        return;
                    case 518:
                        if (RouteDetailMapView.this.mMapControlPanel != null) {
                            RouteDetailMapView.this.mMapControlPanel.handleScrollGesture();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.routedetails.proxy.RouteDetailMapView$4 */
    class C39584 implements ISensorChangeListener {
        C39584() {
        }

        public void onSensorChange(int sensorAngle) {
            if (RouteDetailMapView.this.mMapControlPanel != null) {
                RouteDetailMapView.this.mMapControlPanel.updateMapBySensorAngle(sensorAngle);
            }
        }
    }

    public RouteDetailMapView(Activity activity, ViewGroup parentView, C1277e listener) {
        this.mActivity = activity;
        this.mContext = activity.getApplicationContext();
        this.mParentView = parentView;
        this.mRGRouteDetailsView = new RGRouteDetailsView(activity, listener);
        this.mRGRouteDetailsView.onUpdateOrientation();
        if (firstRoutePlan()) {
            BNSettingManager.setFirstRoutePlanTag(false);
        }
        this.mRGRouteDetailsView.setBNRouteDetailsListener(this.mBNRouteDetailsListener);
        View routeDetail = this.mRGRouteDetailsView.getRootView();
        loadMapCtrlPanel(routeDetail, true);
        if (!(this.mParentView == null || routeDetail == null)) {
            this.mParentView.addView(routeDetail);
        }
        this.mRoutePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        RGParkPointModel.getInstance().reset();
    }

    private boolean firstRoutePlan() {
        return BNSettingManager.getFirstRoutePlanTag();
    }

    public void onResume() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.onResume();
        }
        if (this.mAddMapCtrlPanel) {
            BNMapController.getInstance().addObserver(this.mBNMapObserver);
            BNaviModuleManager.addOrRemoveSensorListener(6, this.mSensorChangeListener);
            if (this.mMapControlPanel != null) {
                this.mMapControlPanel.onResume();
            }
        }
        if (this.mRGRouteDetailsView != null && this.mMapControlPanel != null) {
            this.mRGRouteDetailsView.onShow();
        }
    }

    public void onPause() {
        if (this.mRGRouteDetailsView != null) {
            this.mRGRouteDetailsView.onHide();
        }
        if (this.mAddMapCtrlPanel && this.mMapControlPanel != null) {
            this.mMapControlPanel.onPause();
            BNaviModuleManager.addOrRemoveSensorListener(7, this.mSensorChangeListener);
        }
        BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
        BNMapController.getInstance().onPause();
        if (MapViewFactory.getInstance().getMapView() == null) {
        }
    }

    public void onDestory() {
        if (this.mRGRouteDetailsView != null) {
            this.mRGRouteDetailsView.hide();
            this.mRGRouteDetailsView.destory();
        }
        if (this.mAddMapCtrlPanel && this.mMapControlPanel != null) {
            this.mMapControlPanel.hide();
        }
    }

    public void cancleCountDownTask() {
        if (this.mRGRouteDetailsView != null) {
            this.mRGRouteDetailsView.cancleCountDownTask();
        }
    }

    public boolean onBackPressed() {
        if (this.mRGRouteDetailsView != null) {
            return this.mRGRouteDetailsView.onBackPressed();
        }
        return false;
    }

    public void onUpdateStyle(boolean dayStyle) {
        if (this.mRGRouteDetailsView != null) {
            this.mRGRouteDetailsView.onUpdateStyle(dayStyle);
        }
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.onUpdateStyle(dayStyle);
        }
    }

    public void reloadMapControlPanel(View view) {
        if (view != null && this.mContext != null && this.mAddMapCtrlPanel) {
            this.mMapControlPanel = new BNMapControlPanelSimple(this.mContext, view);
            this.mMapControlPanel.setNoNightStyle(true);
            this.mMapControlPanel.updateView();
            this.mMapControlPanel.setItsClickListener(this.mItsClickListener);
        }
    }

    public void loadMapCtrlPanel(View view, boolean showMapCtrlPanel) {
        this.mAddMapCtrlPanel = showMapCtrlPanel;
        reloadMapControlPanel(view);
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setVisible(false);
        }
    }

    private void switchMapcontrolVisible() {
        if (this.mMapControlPanel == null) {
            return;
        }
        if (this.mMapControlPanel.isVisible()) {
            this.mMapControlPanel.setVisible(false);
        } else {
            this.mMapControlPanel.setVisible(true);
        }
    }

    public void handleCompassClicked() {
        MapStatus mapstatus = BNMapController.getInstance().getMapStatus();
        mapstatus._Rotation = 0;
        mapstatus._Overlooking = 0;
        BNMapController.getInstance().setMapStatus(mapstatus, AnimationType.eAnimationNone);
    }

    public void onUpdateOrientation(int orientation) {
        if (this.mRGRouteDetailsView != null) {
            this.mRGRouteDetailsView.onUpdateOrientation();
        }
    }

    private void startRealNavi() {
        BNRoutePlaner.getInstance().triggerGPSStatus(BNLocationManagerProxy.getInstance().getGpsState());
        startNavi(false);
    }

    private void startNavi(boolean isAnologNavi) {
        if (this.mActivity != null) {
            RoutePlanNode startNode = this.mRoutePlanModel.getStartNode();
            RoutePlanNode endNode = this.mRoutePlanModel.getEndNode();
            if (startNode != null && endNode != null) {
                Bundle bundle = new Bundle();
                bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_VIEW_MODE, 1);
                bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_CALCROUTE_DONE, 0);
                bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_START_X, startNode.getLongitudeE6());
                bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_START_Y, startNode.getLatitudeE6());
                bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_END_X, endNode.getLongitudeE6());
                bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_END_Y, endNode.getLatitudeE6());
                bundle.putString("start_name", this.mRoutePlanModel.getStartName(this.mActivity, false));
                bundle.putString("end_name", this.mRoutePlanModel.getEndName(this.mActivity, false));
                bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_MENU_TYPE, 0);
                if (isAnologNavi) {
                    bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE, 2);
                } else {
                    bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE, 1);
                }
                if (this.mRouteDetailNavListener != null) {
                    this.mRouteDetailNavListener.onStartNavi(bundle, isAnologNavi);
                }
            }
        }
    }

    public void setNaviListener(BNRouteDetailNavListener listener) {
        this.mRouteDetailNavListener = listener;
    }

    public void initFocus(C1443g leftArea, C1443g rightArea, boolean isReSet) {
        if (this.mRGRouteDetailsView != null && this.mMapControlPanel != null) {
            if (leftArea == null || isReSet) {
                leftArea = new C1443g(this.mRGRouteDetailsView.getRootView(), 3, true);
                leftArea.d(this.mRGRouteDetailsView.getBtnBack()).d(this.mRGRouteDetailsView.getBtnOpenPreference()).d(this.mMapControlPanel.getITSButtonView()).d(this.mMapControlPanel.getZoomInBtnView()).d(this.mMapControlPanel.getZoomOutBtnView()).d(this.mMapControlPanel.getLocationBtn());
            }
            if (rightArea == null || isReSet) {
                rightArea = new C1443g(this.mRGRouteDetailsView.getRootView(), 5);
                ArrayList<RGRouteDetailsOutlineItemView> viewList = this.mRGRouteDetailsView.getViewList();
                for (int i = 0; i < viewList.size(); i++) {
                    rightArea.d(((RGRouteDetailsOutlineItemView) viewList.get(i)).getDetailItem());
                }
                rightArea.d(this.mRGRouteDetailsView.getStartNaviLL());
                rightArea.b(this.mRGRouteDetailsView.getStartNaviLL());
            }
            C1440d.a().b(new C1436a[]{leftArea, rightArea});
            C1440d.a().h(rightArea);
        }
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        if (type == 2) {
            if (subType == 29 || subType == 53) {
                if (this.mMapControlPanel != null) {
                    this.mMapControlPanel.changeLocationModeByVoice(PositionStatus.FOLLOWING);
                    return true;
                }
            } else if (subType == 30) {
                if (this.mMapControlPanel != null) {
                    this.mMapControlPanel.changeLocationModeByVoice(PositionStatus.COMPASS);
                    return true;
                }
            } else if (subType == 7) {
                VoiceCommandHelper.onITSChanged(true);
                if (this.mMapControlPanel == null) {
                    return true;
                }
                this.mMapControlPanel.updateItsBtn();
                return true;
            } else if (subType == 8) {
                VoiceCommandHelper.onITSChanged(false);
                if (this.mMapControlPanel == null) {
                    return true;
                }
                this.mMapControlPanel.updateItsBtn();
                return true;
            } else if (subType == 2) {
                if (this.mMapControlPanel == null) {
                    return false;
                }
                view = this.mMapControlPanel.getZoomButtonView();
                if (view == null) {
                    return true;
                }
                view.handleZoomOut();
                return true;
            } else if (subType == 3) {
                if (this.mMapControlPanel == null) {
                    return false;
                }
                view = this.mMapControlPanel.getZoomButtonView();
                if (view == null) {
                    return true;
                }
                view.handleZoomIn();
                return true;
            }
        }
        return this.mRGRouteDetailsView != null ? this.mRGRouteDetailsView.onVoiceCommand(type, subType, arg1, arg2, needResponse) : false;
    }
}
