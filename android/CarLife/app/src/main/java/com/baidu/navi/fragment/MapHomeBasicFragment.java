package com.baidu.navi.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.navi.controller.HomeController;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.view.HomePoiBasicView;
import com.baidu.navi.view.ZoomButtonView.OnZoomBtnClickListener;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.PreferenceHelperConst;
import com.baidu.navisdk.util.logic.BNLocationManager;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.CruiseStatItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.lang.ref.WeakReference;

public class MapHomeBasicFragment extends BrowseMapFragment {
    private static final float ENTER_CRUISE_COND_SPEED = 10.0f;
    private static final int ENTER_CRUISE_COND_TIMEOUT = 30000;
    private static final int MAP_SCALE_DEFAULT = 14;
    private static final String TAG = "MapHomeBasic";
    protected Handler mHandler = new MapHomeBasicHandler(this);
    protected HomeController mHomeController;
    private boolean mIsCalcRoute = false;
    private boolean mIsGpsEnabled = false;
    private boolean mIsMapLocated = false;
    private long mLastTimeShowMapPoi = 0;
    private LocationChangeListener mLocationChangeListener = new C38033();
    private ILocationListener mLocationListener = new C38001();
    private BNLocationManager mLocationManager;
    private float mMaxSpeed = 0.0f;
    protected HomePoiBasicView mPoiDetailView;
    private Runnable mSaveMapScaleRunnable = new C38044();
    private Runnable mStartCruiseTask = new C38012();
    protected ViewGroup mViewGroup;
    private OnZoomBtnClickListener mZoomBtnClickListener = new C38055();

    /* renamed from: com.baidu.navi.fragment.MapHomeBasicFragment$1 */
    class C38001 implements ILocationListener {
        C38001() {
        }

        public void onLocationChange(LocData locData) {
            if (BNSysLocationManager.getInstance().isSysLocationValid()) {
                if (locData != null) {
                }
            } else if (locData != null && locData.isValid()) {
                float kmPerHour = (locData.speed * 3600.0f) / 1000.0f;
                if (kmPerHour > MapHomeBasicFragment.this.mMaxSpeed) {
                    MapHomeBasicFragment.this.mMaxSpeed = kmPerHour;
                }
            }
        }

        public void onGpsStatusChange(boolean enabled, boolean available) {
            LogUtil.m15791e(MapHomeBasicFragment.TAG, "recved GPS status change, enabled " + enabled + ", avail " + available);
            MapHomeBasicFragment.this.mIsGpsEnabled = enabled;
            if (enabled) {
                MapHomeBasicFragment.this.mHomeController.dismissGPSSettingDialog();
            }
        }

        public void onWGS84LocationChange(LocData arg0, LocData arg1) {
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapHomeBasicFragment$2 */
    class C38012 implements Runnable {
        C38012() {
        }

        public void run() {
            MapHomeBasicFragment.this.mHandler.removeCallbacks(MapHomeBasicFragment.this.mStartCruiseTask);
            boolean needStartCruise = false;
            boolean isDialogShowing;
            if (MapHomeBasicFragment.this.mHomeController.isOnlineUseDialogShowing() || MapHomeBasicFragment.this.mHomeController.isContinueLastNaviDialogShowing() || BaseFragment.mActivity.e() || MapHomeBasicFragment.this.mIsCalcRoute) {
                isDialogShowing = true;
            } else {
                isDialogShowing = false;
            }
            LogUtil.m15791e(MapHomeBasicFragment.TAG, "GPSIsEnabled " + MapHomeBasicFragment.this.mIsGpsEnabled + ", maxSpeed " + MapHomeBasicFragment.this.mMaxSpeed);
            if (MapHomeBasicFragment.this.mIsGpsEnabled && MapHomeBasicFragment.this.mMaxSpeed >= MapHomeBasicFragment.ENTER_CRUISE_COND_SPEED && !isDialogShowing) {
                if (NetworkUtils.isNetworkAvailable(BaseFragment.mActivity)) {
                    needStartCruise = true;
                    LogUtil.m15791e(MapHomeBasicFragment.TAG, "network is available");
                } else if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
                    needStartCruise = MapHomeBasicFragment.this.isOfflineDataDownloaded(MapHomeBasicFragment.this.mLocationManager.getLastValidLocation());
                    LogUtil.m15791e(MapHomeBasicFragment.TAG, "offline data is downloaded: " + needStartCruise);
                } else {
                    LogUtil.m15791e(MapHomeBasicFragment.TAG, "network is unavailable, or no common offline data exist!");
                }
            }
            MapHomeBasicFragment.this.mMaxSpeed = 0.0f;
            if (needStartCruise && MapHomeBasicFragment.this.getCurrentFragmentType() == 17) {
                MapHomeBasicFragment.this.showFragment(114, null);
                CruiseStatItem.getInstance().setCruiseFrom("1");
                return;
            }
            MapHomeBasicFragment.this.mHandler.postDelayed(MapHomeBasicFragment.this.mStartCruiseTask, HttpsClient.CONN_MGR_TIMEOUT);
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapHomeBasicFragment$3 */
    class C38033 implements LocationChangeListener {

        /* renamed from: com.baidu.navi.fragment.MapHomeBasicFragment$3$1 */
        class C38021 implements Runnable {
            C38021() {
            }

            public void run() {
                LocationManager.getInstance().removeLocationChangeLister(MapHomeBasicFragment.this.mLocationChangeListener);
            }
        }

        C38033() {
        }

        public void onLocationChange(LocationManager.LocData locData) {
            if (locData != null && LocationManager.getInstance().isLocationValid()) {
                TipTool.onCreateDebugToast(MapHomeBasicFragment.this.getContext(), "LocSDK: Got " + locData);
                if (!MapHomeBasicFragment.this.mIsMapLocated) {
                    MapHomeBasicFragment.this.initMapStatus();
                }
                if (MapHomeBasicFragment.this.mIsMapLocated) {
                    MapHomeBasicFragment.this.mHandler.post(new C38021());
                }
            }
        }

        public CoordType onGetCoordType() {
            return CoordType.CoordType_GCJ02;
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapHomeBasicFragment$4 */
    class C38044 implements Runnable {
        C38044() {
        }

        public void run() {
            int level = BNMapController.getInstance().getZoomLevel();
            LogUtil.m15791e(MapHomeBasicFragment.TAG, "saveMapScale: " + level);
            PreferenceHelper.getInstance(MapHomeBasicFragment.this.getContext()).putInt(PreferenceHelperConst.SP_LAST_SCALE, level);
        }
    }

    /* renamed from: com.baidu.navi.fragment.MapHomeBasicFragment$5 */
    class C38055 implements OnZoomBtnClickListener {
        C38055() {
        }

        public void onZoomOutBtnClick() {
            MapHomeBasicFragment.this.enterCruiseFollowModeDetect();
            MapHomeBasicFragment.this.saveMapScale(500);
            MapHomeBasicFragment.this.mMapControlPanel.disableWatermark();
        }

        public void onZoomInBtnClick() {
            MapHomeBasicFragment.this.enterCruiseFollowModeDetect();
            MapHomeBasicFragment.this.saveMapScale(500);
            MapHomeBasicFragment.this.mMapControlPanel.disableWatermark();
        }
    }

    private static class MapHomeBasicHandler extends Handler {
        private WeakReference<MapHomeBasicFragment> mWeakRef;

        public MapHomeBasicHandler(MapHomeBasicFragment frag) {
            this.mWeakRef = new WeakReference(frag);
        }

        public void handleMessage(Message msg) {
            MapHomeBasicFragment frag = (MapHomeBasicFragment) this.mWeakRef.get();
            if (frag != null) {
                frag.handleMessage(msg);
            } else {
                LogUtil.m15791e(MapHomeBasicFragment.TAG, "MapHomeBasicFragment is freed");
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        if (MainMapModel.getInstance().mbFirstMapviewContent) {
            LogUtil.m15791e(TAG, "GeoLocate position: " + BNLocationManagerProxy.getInstance().getLastValidLocation());
            MainMapModel.getInstance().mbFirstMapviewContent = false;
        }
        loadMapCtrlPanel(true);
        this.mbMoveToLocationPoint = true;
        this.mHomeController = new HomeController(mActivity, this);
        this.mViewGroup = initViews();
        this.mPoiDetailView = initMapPoiDetailView();
        return this.mViewGroup;
    }

    protected void onUpdateStyle(boolean dayStyle) {
        super.onUpdateStyle(dayStyle);
        this.mPoiDetailView.updateStyle();
    }

    public void onResume() {
        super.onResume();
        if (MainMapModel.getInstance().bFirstLoc) {
            initMapStatus();
            LocationManager.getInstance().addLocationChangeLister(this.mLocationChangeListener);
        }
        this.mPoiDetailView.onResume();
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setZoomBtnClickListener(this.mZoomBtnClickListener);
        }
    }

    public void onPause() {
        super.onPause();
        this.mPoiDetailView.onPause();
        LocationManager.getInstance().removeLocationChangeLister(this.mLocationChangeListener);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
        int fragType = getCurrentFragmentType();
        ContentFragment fragment = getCurrentFragment();
        LogUtil.m15791e(TAG, "onStop: current fragment type " + fragType);
    }

    public void onDestroyView() {
        this.mViewCreated = false;
        super.onDestroyView();
    }

    protected void onUpdateOrientation(int orientation) {
        super.onUpdateOrientation(orientation);
        this.mPoiDetailView.onUpdateOrientation(orientation);
    }

    protected ViewGroup initViews() {
        return null;
    }

    protected HomePoiBasicView initMapPoiDetailView() {
        return null;
    }

    protected void onInitView() {
    }

    protected void onInitMap() {
        super.onInitMap();
    }

    private void initLocationManager() {
        this.mLocationManager = BNSysLocationManager.getInstance();
        this.mLocationManager.init(mActivity);
    }

    private void startCheckToEnterCruise() {
        this.mIsGpsEnabled = this.mLocationManager.isGpsEnabled();
        this.mLocationManager.addLocationListener(this.mLocationListener);
        this.mLocationManager.startNaviLocate(mActivity);
    }

    private void stopCheckToEnterCruise() {
        this.mHandler.removeCallbacks(this.mStartCruiseTask);
        this.mMaxSpeed = 0.0f;
        this.mLocationManager.removeLocationListener(this.mLocationListener);
    }

    private void rescheduleCruiseTask() {
        this.mMaxSpeed = 0.0f;
    }

    private boolean isOfflineDataDownloaded(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return false;
        }
        DistrictInfo district = BNPoiSearcher.getInstance().getDistrictByPoint(geoPoint, 0);
        while (district != null && district.mType > 2) {
            district = BNPoiSearcher.getInstance().getParentDistrict(district.mId);
        }
        if (district != null) {
            return BNOfflineDataManager.getInstance().isProvinceDataDownload(district.mId);
        }
        return false;
    }

    protected void handleSingleTap(MotionEvent e) {
        long timeGap = System.currentTimeMillis() - this.mLastTimeShowMapPoi;
        LogUtil.m15791e(TAG, "handleSingleTap on map, time since show poi " + timeGap);
        if ((timeGap < 0 || timeGap >= 500) && this.mPoiDetailView.isVisible()) {
            this.mPoiDetailView.hide();
            enterCruiseFollowModeDetect();
            setMapFocusViewVisible(true);
        }
    }

    protected void onShowMapPoi(SearchPoi poi) {
        LogUtil.m15791e(TAG, "onShowMapPoi");
        if (poi != null) {
            ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setMapSearchPoi(poi);
            this.mPoiDetailView.showMapPoi();
            this.mLastTimeShowMapPoi = System.currentTimeMillis();
            setMapFocusViewVisible(false);
        }
    }

    protected void onShowFavPoi(SearchPoi poi) {
        LogUtil.m15791e(TAG, "onShowMapPoi");
        if (poi != null) {
            ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setMapSearchPoi(poi);
            this.mPoiDetailView.showFavPoi();
            this.mLastTimeShowMapPoi = System.currentTimeMillis();
            setMapFocusViewVisible(false);
        }
    }

    protected void onShowMapGeoPoint(GeoPoint geoPt) {
        if (!C1328h.a().getNaviFragmentManager().isDriving()) {
            LogUtil.m15791e(TAG, "onShowMapGeoPoint");
            if (geoPt != null) {
                ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setAntiGeoPoint(geoPt);
                this.mPoiDetailView.show(geoPt, false);
                this.mLastTimeShowMapPoi = System.currentTimeMillis();
                setMapFocusViewVisible(false);
            }
        }
    }

    protected void onLocationBtnClicked(PositionStatus curLocMode) {
        super.onLocationBtnClicked(curLocMode);
        if (curLocMode == PositionStatus.NORMAL) {
            GeoPoint geoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
            LogUtil.m15791e(TAG, "onLocationBtnClicked: " + geoPoint);
            if (geoPoint != null) {
                this.mPoiDetailView.show(geoPoint, true);
                setMapFocusViewVisible(false);
            }
        }
    }

    public boolean onBackPressed() {
        if (this.mPoiDetailView == null || !this.mPoiDetailView.isVisible()) {
            return false;
        }
        this.mPoiDetailView.hide();
        enterCruiseFollowModeDetect();
        return true;
    }

    private void initMapStatus() {
        MapStatus mapStatus = BNMapController.getInstance().getMapStatus();
        if (mapStatus != null) {
            mapStatus._Rotation = 0;
            mapStatus._Overlooking = 0;
            mapStatus._Xoffset = 0;
            mapStatus._Yoffset = 0;
            int savedLevel = PreferenceHelper.getInstance(getContext()).getInt(PreferenceHelperConst.SP_LAST_SCALE, 14);
            LogUtil.m15791e(TAG, "initMapScale: savedLevel " + savedLevel);
            if (savedLevel > 14) {
                mapStatus._Level = (float) savedLevel;
            } else {
                mapStatus._Level = 14.0f;
            }
            LocData locData = GeoLocateModel.getInstance().getLastLocation();
            if (locData == null || !locData.isValid()) {
                this.mIsMapLocated = false;
                LogUtil.m15791e(TAG, "initMapScale: null location data...");
                mapStatus._Level = 3.0f;
                TipTool.onCreateDebugToast(getContext(), "initMap: ***Invalid " + locData);
            } else {
                this.mIsMapLocated = true;
                MainMapModel.getInstance().bFirstLoc = false;
                Bundle b = CoordinateTransformUtil.LL2MC(locData.longitude, locData.latitude);
                mapStatus._CenterPtX = b.getInt("MCx");
                mapStatus._CenterPtY = b.getInt("MCy");
                TipTool.onCreateDebugToast(getContext(), "initMap: Got " + locData);
            }
            BNMapController.getInstance().setMapStatus(mapStatus, AnimationType.eAnimationAll);
            this.mMapControlPanel.updateView();
        }
    }

    private void saveMapScale(long delayMillis) {
        this.mHandler.postDelayed(this.mSaveMapScaleRunnable, delayMillis);
    }

    protected void handleMessage(Message msg) {
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        boolean processed = false;
        switch (type) {
            case 3:
                switch (subType) {
                    case 1:
                        onBackPressed();
                        replyVoiceCommand(type, 1, needResponse);
                        processed = true;
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
        }
        rescheduleCruiseTask();
        LogUtil.m15791e(TAG, "onVoiceCommand: type " + type + ", subType " + subType + ", " + arg1 + ", processed " + processed);
        if (processed) {
            return processed;
        }
        return super.onVoiceCommand(type, subType, arg1, arg2, needResponse);
    }

    protected void enterCruiseFollowModeDetect() {
        if (this.mPoiDetailView == null || !this.mPoiDetailView.isVisible()) {
            EnterQuitLogicManager.getmInstance().enterCruiseFollowModeDetect();
        }
    }
}
