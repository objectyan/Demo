package com.baidu.navi.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.MapControlPanel;
import com.baidu.navi.view.MapControlPanel.IItsClickListener;
import com.baidu.navi.view.MapControlPanel.ILocationBtnClickListener;
import com.baidu.navi.view.ZoomButtonView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.comapi.userdata.IBNFavUpdateListener;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.navisdk.model.modelfactory.FavoriteModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.PreferenceHelperConst;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysSensorManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.MapController.MapControlMode;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import java.util.ArrayList;

public abstract class MapContentFragment extends ContentFragment {
    private static final String TAG = "MapHome";
    private boolean ifFavReaded = false;
    private boolean isMapControlVIewFirstVisible = false;
    private BNMapObserver mBNMapObserver = new C37965();
    private C1953c mDataDownloadAlertDialog;
    private boolean mDayStyle = true;
    private DistrictInfo mDistrict;
    private IBNFavUpdateListener mFavUpdateListener = new C37921();
    private C1953c mFirstItsDialog;
    private boolean mFirstItsOn = false;
    private Handler mHandler = new Handler();
    protected boolean mIsForRouteDetails = false;
    public IItsClickListener mItsClickListener = new C37976();
    private C1953c mItsSettingAlertDialog;
    private ILocationBtnClickListener mLocationBtnClickListener = new C37987();
    private LocationChangeListener mLocationChangeListener = new C37954();
    protected MapControlPanel mMapControlPanel;
    private ISensorChangeListener mSensorChangeListener = new C37943();
    protected boolean mbAddMapCtrlPanelView = false;
    protected boolean mbMoveToLocationPoint = false;
    protected View view;

    /* renamed from: com.baidu.navi.fragment.MapContentFragment$1 */
    class C37921 implements IBNFavUpdateListener {

        /* renamed from: com.baidu.navi.fragment.MapContentFragment$1$1 */
        class C37911 implements Runnable {
            C37911() {
            }

            public void run() {
                MapContentFragment.this.fillFavAndPoiList();
                MapContentFragment.this.ifFavReaded = true;
            }
        }

        C37921() {
        }

        public void onFavUpdateComplete() {
            MapContentFragment.this.mHandler.post(new C37911());
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapContentFragment$2 */
    class C37932 implements Runnable {
        C37932() {
        }

        public void run() {
            MapGLSurfaceView bnMapView = MapViewFactory.getInstance().getMapView();
            if (bnMapView != null) {
                BaseFragment.mResumeMapView = false;
                bnMapView.onResume();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapContentFragment$3 */
    class C37943 implements ISensorChangeListener {
        C37943() {
        }

        public void onSensorChange(int angleX) {
            if (MapContentFragment.this.mMapControlPanel != null) {
                MapContentFragment.this.mMapControlPanel.updateMapBySensorAngle(angleX);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapContentFragment$4 */
    class C37954 implements LocationChangeListener {
        C37954() {
        }

        public void onLocationChange(LocData locData) {
            if (MapContentFragment.this.mMapControlPanel != null) {
                MapContentFragment.this.mMapControlPanel.onLocationChange(locData, MapContentFragment.this.mbMoveToLocationPoint);
            }
        }

        public CoordType onGetCoordType() {
            return CoordType.CoordType_BD09;
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapContentFragment$5 */
    class C37965 implements BNMapObserver {
        C37965() {
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            if (1 == type) {
                switch (event) {
                    case 257:
                        LogUtil.m15791e(MapContentFragment.TAG, "MapObserver update: EVENT_MAP_ANIMATION_FINISHED");
                        if (MapContentFragment.this.mMapControlPanel != null) {
                            MapContentFragment.this.mMapControlPanel.updateView();
                        }
                        MapContentFragment.this.saveMapZoomLevel();
                        break;
                    case 262:
                        MapContentFragment.this.handleCompassClicked();
                        break;
                    case 274:
                        LogUtil.m15791e(MapContentFragment.TAG, "MapObserver update: EVENT_MAP_ZOOM_UPDATE");
                        if (MapContentFragment.this.mMapControlPanel != null) {
                            MapContentFragment.this.mMapControlPanel.updateView();
                        }
                        MapContentFragment.this.saveMapZoomLevel();
                        break;
                }
            }
            if (2 == type) {
                switch (event) {
                    case 514:
                        MapContentFragment.this.mMapControlPanel.handleSingleTouchGesture();
                        MapContentFragment.this.switchMapcontrolVisible();
                        return;
                    case 518:
                        MapContentFragment.this.mMapControlPanel.handleScrollGesture();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapContentFragment$6 */
    class C37976 implements IItsClickListener {
        C37976() {
        }

        public void onClickIts() {
            StatisticManager.onEvent("NAVI_0005", "NAVI_0005");
            MapContentFragment.this.mFirstItsOn = BNSettingManager.isFirstItsOn();
            GeoPoint screenCenter = BNMapController.getInstance().getGeoPosByScreenPos(BaseFragment.mActivity.getWindowManager().getDefaultDisplay().getWidth() / 2, BaseFragment.mActivity.getWindowManager().getDefaultDisplay().getHeight() / 2);
            if (screenCenter != null && BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
                MapContentFragment.this.mDistrict = BNPoiSearcher.getInstance().getDistrictByPoint(screenCenter, 0);
            }
            if (BNSettingManager.isRoadCondOnOrOff()) {
                MapContentFragment.this.showTrafficMap(false);
                BNSettingManager.setRoadCondOnOff(false);
                TipTool.onCreateToastDialog(C1157a.a(), (int) C0965R.string.its_online_is_off);
                return;
            }
            StatisticManager.onEvent("NAVI_0006", "NAVI_0006");
            if (PreferenceHelper.getInstance(C1157a.a()).getBoolean(Key.NAVI_REAL_HISTORY_ITS, true)) {
                if (MapContentFragment.this.mFirstItsOn) {
                    BNSettingManager.setFirstItsOn(false);
                }
                if (NetworkUtils.isNetworkAvailable(C1157a.a())) {
                    MapContentFragment.this.showTrafficMap(true);
                    BNSettingManager.setRoadCondOnOff(true);
                    if (MapContentFragment.this.mDistrict == null || BNMapController.getInstance().checkRoadConditionSupport(MapContentFragment.this.mDistrict.mId)) {
                        TipTool.onCreateToastDialog(C1157a.a(), (int) C0965R.string.its_online_is_on);
                        return;
                    } else {
                        TipTool.onCreateToastDialog(C1157a.a(), (int) C0965R.string.its_online_missing_data);
                        return;
                    }
                }
                MapContentFragment.this.showItsSettingDialog();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapContentFragment$7 */
    class C37987 implements ILocationBtnClickListener {
        C37987() {
        }

        public void onClick(PositionStatus curLocMode) {
            MapContentFragment.this.onLocationBtnClicked(curLocMode);
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapContentFragment$8 */
    class C37998 implements C0672b {
        C37998() {
        }

        public void onClick() {
            if (BaseFragment.mActivity != null && MapContentFragment.this.isAdded()) {
                MapContentFragment.this.dismissDialog(MapContentFragment.this.mItsSettingAlertDialog);
            }
        }
    }

    protected abstract void onInitMap();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = super.onCreateView(inflater, container, savedInstanceState);
        if (this.view != null) {
            this.view.setClickable(false);
        }
        if (this.mbAddMapCtrlPanelView && this.view != null) {
            this.mMapControlPanel = new MapControlPanel(mActivity, this.view, getNaviFragmentManager());
            this.mMapControlPanel.onUpdateStyle(StyleManager.getDayStyle());
            this.mMapControlPanel.updateView();
            this.mMapControlPanel.setItsClickListener(this.mItsClickListener);
            this.mMapControlPanel.setLocationBtnClickListener(this.mLocationBtnClickListener);
            initFocusChain(this.view);
            this.mMapControlPanel.setOnDialogListener(this);
        }
        if (BaseFragment.mUpdateIts && PreferenceHelper.getInstance(C1157a.a()).getBoolean("NAVI_ROADCOND_ON_OFF", false)) {
            BNMapController.getInstance().showTrafficMap(true);
        }
        initLocationLayer();
        return this.view;
    }

    private void loadFavDataList() {
        BNFavoriteManager.getInstance().asyncLoadFavListData(this.mFavUpdateListener);
        this.ifFavReaded = true;
    }

    public void onResume() {
        if (BaseFragment.mResumeMapView) {
            this.mHandler.postDelayed(new C37932(), 100);
        }
        MapViewFactory.getInstance().getMapView().onResume();
        MapViewFactory.getInstance().getMapView().onForeground();
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.onResume();
        }
        if (this.mbAddMapCtrlPanelView) {
            BNMapController.getInstance().setObserver(this.mBNMapObserver);
            LocationManager.getInstance().addLocationChangeLister(this.mLocationChangeListener);
            BNSysSensorManager.getInstance().initSensor(C1157a.a());
            BNSysSensorManager.getInstance().addSensorChangeListener(this.mSensorChangeListener);
        }
        if (BaseFragment.mUpdateIts) {
            if (!BNSettingManager.isRoadCondOnOrOff()) {
                BNMapController.getInstance().showTrafficMap(false);
            } else if (PreferenceHelper.getInstance(C1157a.a()).getBoolean(Key.NAVI_REAL_HISTORY_ITS, true)) {
                BNMapController.getInstance().switchITSMode(true);
                BNMapController.getInstance().showTrafficMap(true);
            } else {
                BNMapController.getInstance().switchITSMode(false);
                BNMapController.getInstance().showTrafficMap(true);
            }
            BaseFragment.mUpdateIts = false;
        }
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void onDestroyView() {
        MapStatus mapstatus = BNMapController.getInstance().getMapStatus();
        if (mapstatus != null) {
            Bundle b = CoordinateTransformUtil.MC2LL(mapstatus._CenterPtX, mapstatus._CenterPtY);
            if (b != null) {
                saveMapInfo((int) (b.getDouble("LLx") * 100000.0d), (int) (b.getDouble("LLy") * 100000.0d));
            }
        }
        saveMapZoomLevel();
        super.onDestroyView();
    }

    private void saveMapZoomLevel() {
        PreferenceHelper.getInstance(BaiduNaviApplication.getInstance().getApplicationContext()).putInt(PreferenceHelperConst.SP_LAST_SCALE, BNMapController.getInstance().getZoomLevel());
    }

    private void saveMapInfo(int longitude, int latitude) {
        PreferenceHelper helper = PreferenceHelper.getInstance(BaiduNaviApplication.getInstance().getApplicationContext());
        helper.putInt(PreferenceHelperConst.SP_LAST_LONGITUDE, longitude);
        helper.putInt(PreferenceHelperConst.SP_LAST_LATITUDE, latitude);
    }

    protected void onInit() {
        super.onInit();
        onInitMap();
    }

    public void moveMapToPoint(int longitude, int latitude) {
        MapStatus mapstatus = BNMapController.getInstance().getMapStatus();
        Bundle b = CoordinateTransformUtil.LLE62MC(longitude, latitude);
        mapstatus._CenterPtX = b.getInt("MCx");
        mapstatus._CenterPtY = b.getInt("MCy");
        BNMapController.getInstance().setMapStatus(mapstatus, AnimationType.eAnimationNone);
        BNMapController.getInstance().updateLayer(14);
    }

    protected void switchMapcontrolVisible() {
        if (this.mMapControlPanel == null) {
            return;
        }
        if (this.mMapControlPanel.isVisible()) {
            this.mMapControlPanel.setVisible(false);
        } else {
            this.mMapControlPanel.setVisible(true);
        }
    }

    public void setLeftTopPanelVisible(boolean isVisible) {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setLeftTopPanelVisible(isVisible);
        }
    }

    public void setLeftRightPanelVisible(boolean isVisible) {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setLeftRightPanelVisible(isVisible);
        }
    }

    public void setMapFocusViewVisible(boolean isVisible) {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setMapFocusViewVisible(isVisible);
        }
    }

    protected void loadMapCtrlPanel(boolean isMapControlVIewFirstVisible) {
        this.mbAddMapCtrlPanelView = true;
        this.isMapControlVIewFirstVisible = isMapControlVIewFirstVisible;
    }

    protected void setIsForRouteDetails(boolean isFor) {
        this.mIsForRouteDetails = isFor;
    }

    protected void hideMapCtrlPanel() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.hide();
        }
    }

    protected void showMapCtrlPanel() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.show();
        }
    }

    protected void setMapCtrlPanel(MapControlPanel mapControlPanel) {
        if (mapControlPanel != null) {
            this.mMapControlPanel = mapControlPanel;
        }
    }

    public void onStop() {
        super.onStop();
        if (this.mbAddMapCtrlPanelView) {
            BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
            LocationManager.getInstance().removeLocationChangeLister(this.mLocationChangeListener);
            BNSysSensorManager.getInstance().removeSensorChangeListener(this.mSensorChangeListener);
        }
    }

    public void handleCompassClicked() {
        MapStatus mapstatus = BNMapController.getInstance().getMapStatus();
        mapstatus._Rotation = 0;
        mapstatus._Overlooking = 0;
        BNMapController.getInstance().setMapStatus(mapstatus, AnimationType.eAnimationNone);
    }

    protected void showTrafficMap(boolean show) {
    }

    protected void onLocationBtnClicked(PositionStatus curLocMode) {
    }

    private void showItsSettingDialog() {
        if (this.mItsSettingAlertDialog == null) {
            this.mItsSettingAlertDialog = new C1953c(mActivity).b(C0965R.string.alert_notification).a(C0965R.string.its_switch_to_history).c(C0965R.string.alert_know).q().a(new C37998());
        }
        showDialog(this.mItsSettingAlertDialog);
    }

    protected void setMapLayerMode(int mode) {
        BNMapController.getInstance().setLayerMode(mode);
        BNMapController.getInstance().showLayer(24, false);
        BNMapController.getInstance().showLayer(25, false);
        BNMapController.getInstance().showLayer(26, false);
        BNMapController.getInstance().showLayer(27, false);
        BNMapController.getInstance().showLayer(10, false);
    }

    protected void onUpdateStyle(boolean dayStyle) {
        LogUtil.m15791e("StyleDebug", "MapContentFragment dayStyle = " + dayStyle);
        this.mDayStyle = dayStyle;
        if (this.mMapControlPanel != null && this.mbAddMapCtrlPanelView && this.mMapControlPanel != null) {
            this.mMapControlPanel.onUpdateStyle(this.mDayStyle);
        }
    }

    private void fillFavAndPoiList() {
        ArrayList<FavoritePoiInfo> favDataList = FavoriteModel.getInstance().getFavDataList();
        ArrayList<GeoPoint> pointList = new ArrayList();
        ArrayList<String> favNameList = new ArrayList();
        ArrayList<String> favAddressList = new ArrayList();
        for (int i = 0; i < favDataList.size(); i++) {
            FavoritePoiInfo favoriteNode = (FavoritePoiInfo) favDataList.get(i);
            if (!(favoriteNode == null || favoriteNode.mViewPoint == null)) {
                pointList.add(i, BNFavoriteManager.getInstance().MCTogcjPoint(favoriteNode.mViewPoint));
                favNameList.add(i, favoriteNode.mFavName);
                favAddressList.add(i, favoriteNode.mFavAddr);
            }
        }
        if (pointList.size() <= 0 || BNMapController.getInstance().getMapController().getMapControlMode() != MapControlMode.DEFAULT) {
            BNMapController.getInstance().showLayer(16, false);
            BNPoiSearcher.getInstance().clearFavPoiCache();
            BNMapController.getInstance().updateLayer(16);
            return;
        }
        BNMapController.getInstance().showLayer(16, true);
        BNPoiSearcher.getInstance().updateFavPoiCache(pointList, favNameList, favAddressList);
        BNMapController.getInstance().updateLayer(16);
    }

    private void initLocationLayer() {
        com.baidu.navisdk.model.datastruct.LocData locData = BNLocationManagerProxy.getInstance().getCurLocation();
        if (locData != null) {
            LocationCallback.setData(locData.toLocationOverlayJsonString(MainMapModel.getInstance().getCurLocMode() == 2));
        }
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        LogUtil.m15791e(TAG, "onVoiceCommand: type " + type + ", subType " + subType + ", " + arg1 + ", " + arg2);
        switch (type) {
            case 0:
                LogUtil.m15791e(TAG, "onVoiceCommand: type INVALID");
                break;
            case 2:
                LogUtil.m15791e(TAG, "onVoiceCommand: type UI");
                ZoomButtonView view;
                switch (subType) {
                    case 2:
                        if (this.mMapControlPanel == null) {
                            return false;
                        }
                        view = this.mMapControlPanel.getZoomButtonView();
                        if (view != null) {
                            view.handleZoomOut();
                        }
                        replyVoiceCommand(type, 1, needResponse);
                        return true;
                    case 3:
                        if (this.mMapControlPanel == null) {
                            return false;
                        }
                        view = this.mMapControlPanel.getZoomButtonView();
                        if (view != null) {
                            view.handleZoomIn();
                        }
                        replyVoiceCommand(type, 1, needResponse);
                        return true;
                    case 7:
                        onITSChanged(true);
                        if (this.mMapControlPanel == null) {
                            return true;
                        }
                        this.mMapControlPanel.updateMenuDialog();
                        return true;
                    case 8:
                        onITSChanged(false);
                        if (this.mMapControlPanel == null) {
                            return true;
                        }
                        this.mMapControlPanel.updateMenuDialog();
                        return true;
                    case 19:
                        int curMode = MainMapModel.getInstance().getCurLocMode();
                        if (this.mMapControlPanel != null && curMode == 1) {
                            this.mMapControlPanel.handleLocationBtnClick();
                        }
                        replyVoiceCommand(type, 1, needResponse);
                        return true;
                    case 29:
                    case 53:
                        if (this.mMapControlPanel != null) {
                            this.mMapControlPanel.changeLocationModeByVoice(PositionStatus.FOLLOWING);
                            return true;
                        }
                        break;
                    case 30:
                        if (this.mMapControlPanel != null) {
                            this.mMapControlPanel.changeLocationModeByVoice(PositionStatus.COMPASS);
                            return true;
                        }
                        break;
                    default:
                        break;
                }
            case 3:
                LogUtil.m15791e(TAG, "onVoiceCommand: type PAGE");
                break;
        }
        return false;
    }

    public boolean onITSChanged(boolean openITS) {
        if (!openITS || BNSettingManager.isRoadCondOnOrOff()) {
            if (!openITS && PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getBoolean("NAVI_ROADCOND_ON_OFF", false)) {
                showTrafficMap(false);
                BNSettingManager.setRoadCondOnOff(false);
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_is_off));
            }
        } else if (BNSettingManager.isNaviRealHistoryITS()) {
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                showTrafficMap(true);
                BNSettingManager.setRoadCondOnOff(true);
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_real_is_on));
            } else {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_real_offline));
            }
        }
        return true;
    }

    protected void forseReloadMapControlPanel(View view) {
        if (view != null && this.mbAddMapCtrlPanelView) {
            this.mMapControlPanel = new MapControlPanel(mActivity, view, getNaviFragmentManager());
            this.mMapControlPanel.onUpdateStyle(this.mDayStyle);
            this.mMapControlPanel.updateView();
            this.mMapControlPanel.setItsClickListener(this.mItsClickListener);
            this.mMapControlPanel.setLocationBtnClickListener(this.mLocationBtnClickListener);
            this.mMapControlPanel.setOnDialogListener(this);
        }
    }

    public boolean onVoiceCmdMyLocation() {
        int curMode = MainMapModel.getInstance().getCurLocMode();
        if (this.mMapControlPanel == null || curMode != 0) {
            return false;
        }
        this.mMapControlPanel.handleLocationBtnClick();
        return true;
    }

    public boolean switchMapFocus(boolean openFocus, boolean fromSingleTouch) {
        if (this.mMapControlPanel == null || !this.mMapControlPanel.isMapFocusOpen()) {
            return false;
        }
        this.mMapControlPanel.switchMapFocus(openFocus, fromSingleTouch);
        initFocusChain(this.view);
        return true;
    }

    public boolean isMapPage() {
        return true;
    }

    public void onInitFocusAreas() {
        super.onInitFocusAreas();
    }

    public void initFocusChain(View root) {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.initFocusChain(root);
            this.mMapControlPanel.switchMapFocus(false, false);
        }
    }
}
