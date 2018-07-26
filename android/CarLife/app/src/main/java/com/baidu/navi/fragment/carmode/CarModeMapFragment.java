package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.baidu.baidumaps.p042f.p043a.p044a.C0705a;
import com.baidu.baidunavis.control.NavItemizedOverlayUtil;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p085i.C1609a;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.TopBarView;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navi.controller.CommonController;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.cruise.control.ICruiseEnterQuiteLogic;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.MapHomeBasicFragment;
import com.baidu.navi.protocol.model.HUDGuideDataStruct;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.HomePoiBasicView;
import com.baidu.navi.view.HomePoiSimpleView;
import com.baidu.navi.voice.NaviState;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.logic.BNLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.OnLongPressListener;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.map.event.MapMoveEvent;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.BMEventBus$OnEvent;
import java.util.ArrayList;
import java.util.List;

public class CarModeMapFragment extends MapHomeBasicFragment implements ICruiseEnterQuiteLogic, BMEventBus$OnEvent {
    public static final String BUNDLE_KEY_LOCATION = "location";
    public static String TAG = "CarModeMapFragment";
    private CommonController mCommonController;
    private BNLocationManager mLocationManager;
    private MapGLSurfaceView mMapView;
    private MapViewConfig mMapViewConfig;
    C1443g mMiddleFocusViewGroup;
    private HomePoiBasicView mPoiDetailView;
    C1443g mRightFocusViewGroup;
    private boolean mShowDialoged = false;
    private TopBarView mTopBarView;
    protected ViewGroup mViewGroup;

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeMapFragment$1 */
    class C38711 implements OnLongPressListener {
        C38711() {
        }

        public void onLongPress(MotionEvent e) {
            CarModeMapFragment.this.handleLongPress(e);
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeMapFragment$2 */
    class C38722 implements OnTouchListener {
        C38722() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeMapFragment$3 */
    class C38733 extends ConcurrentTask {
        C38733() {
        }

        public void run() {
            CarModeMapFragment.this.mLocationManager = BNSysLocationManager.getInstance();
            CarModeMapFragment.this.mLocationManager.init(BaseFragment.mActivity);
            CarModeMapFragment.this.mLocationManager.startNaviLocate(BaseFragment.mActivity);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EnterQuitLogicManager.getmInstance().setNaviFragmentManager(getNaviFragmentManager());
        this.mMapViewConfig = MapViewConfig.getInstance();
        this.mMapView = MapViewFactory.getInstance().getMapView();
        MapViewConfig.getInstance().setPositionStatus(PositionStatus.NORMAL);
        this.mMapView.setOnLongPressListener(new C38711());
        NavMapManager.getInstance().init();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.mMapControlPanel.registerCruiseHandler(this);
        this.mMapControlPanel.setHomeMapPage(true);
        this.mMapControlPanel.onUpdateStyle(StyleManager.getRealDayStyle());
        C1912n.a().a(this);
        this.mHandler = new Handler(Looper.getMainLooper());
        setBottomBarBackgroud(C2188r.b(C0965R.drawable.com_bottom_bg));
        return view;
    }

    protected ViewGroup initViews() {
        this.mViewGroup = (ViewGroup) LayoutInflater.from(mActivity).inflate(C0965R.layout.carmode_frag_map_home, null);
        this.mViewGroup.findViewById(C0965R.id.layout_poi_panel).setOnTouchListener(new C38722());
        this.mTopBarView = (TopBarView) this.mViewGroup.findViewById(C0965R.id.common_top_bar);
        this.mTopBarView.setAlpha(1.0f);
        this.mPoiDetailView = new HomePoiSimpleView(mActivity, this.mViewGroup, getNaviFragmentManager(), this);
        this.mCommonController = new CommonController(mActivity, this);
        initLocationManager();
        NaviState.getInstance().registerCustomCmd();
        return this.mViewGroup;
    }

    public void onAttach(Activity activity) {
        if (mActivity != null) {
            mActivity.setRequestedOrientation(0);
        }
        super.onAttach(activity);
    }

    protected void onUpdateStyle(boolean dayStyle) {
        super.onUpdateStyle(dayStyle);
        if (this.mTopBarView != null) {
            this.mTopBarView.a(dayStyle);
        }
    }

    private boolean isNeedShowDialog() {
        if (this.mShowDialoged) {
            return false;
        }
        if (this.mCommonController != null && this.mCommonController.isNeedShowDialog()) {
            return true;
        }
        if (mActivity != null && mActivity.i() > 0) {
            return true;
        }
        C1609a extGPSlm = C1609a.a();
        if ((extGPSlm.c() && extGPSlm.d()) || this.mLocationManager == null || this.mLocationManager.isGpsEnabled()) {
            return false;
        }
        return true;
    }

    private void handleDialogShowLogic() {
        if (this.mShowDialoged || !this.isDisplayed) {
            this.mShowDialoged = true;
            return;
        }
        this.mShowDialoged = true;
        if (this.mCommonController != null && mActivity != null) {
            this.mCommonController.checkOfflineDataOrNetwork();
            if (mActivity.i() > 0) {
                this.mCommonController.dismissNoNetAndOfflineDataDialog();
                mActivity.j();
                mActivity.a(0);
            }
            if (this.mLocationManager != null && this.mHomeController != null) {
                C1609a extGPSlm = C1609a.a();
                if (extGPSlm.c() && extGPSlm.d()) {
                    this.mHomeController.dismissGPSSettingDialog();
                } else if (this.mLocationManager.isGpsEnabled()) {
                    this.mHomeController.dismissGPSSettingDialog();
                } else {
                    this.mHomeController.showGPSSettingDialog();
                }
            }
        }
    }

    public void onResume() {
        NavItemizedOverlayUtil.getInstance().initWrapper(false, null);
        super.onResume();
        if (this.mTopBarView != null) {
            this.mTopBarView.a(StyleManager.getRealDayStyle());
        }
        setLeftTopPanelVisible(true);
        setLeftRightPanelVisible(true);
        setMapFocusViewVisible(true);
        if (this.mPoiDetailView != null) {
            this.mPoiDetailView.show(false);
            if (this.mPoiDetailView.isVisible()) {
                setMapFocusViewVisible(false);
            }
        }
        C1260i.b(TAG);
        initLocationManager();
        enterCruiseFollowModeDetect();
        handleDialogShowLogic();
        drivingSet();
        updateMap();
        if (!(this.mMapControlPanel == null || this.mMapViewConfig.getPositionStatus() == PositionStatus.NORMAL)) {
            this.mMapControlPanel.changeLocationModeByVoice(this.mMapViewConfig.getPositionStatus());
        }
        BMEventBus.getInstance().regist(this, MapMoveEvent.class, new Class[0]);
    }

    private void updateMap() {
        if (NavMapManager.getInstance().getNaviMapMode() == 5) {
            C0705a.a().e();
            C0705a.a().g();
            NavMapManager.getInstance().handleMapOverlays(0);
        }
        C0705a.a().g();
        NavMapManager.getInstance().setNaviMapMode(0);
        updateLocationIcon();
    }

    private void updateLocationIcon() {
        Bitmap iconBitmap;
        OverlayLocationData data;
        List<OverlayLocationData> list = new ArrayList();
        Drawable icon = StyleManager.getDrawable(C0965R.drawable.map_icon_center_image);
        if (icon != null) {
            iconBitmap = drawableToBitmap(icon);
            data = new OverlayLocationData();
            if (!(iconBitmap == null || iconBitmap.isRecycled())) {
                data.setImage(iconBitmap);
                data.setImgHeight(iconBitmap.getHeight());
                data.setImgWidth(iconBitmap.getWidth());
                data.setImgName(HUDGuideDataStruct.KEY_ICON_NAME);
                data.setRotation(1);
                list.add(data);
            }
        }
        icon = StyleManager.getDrawable(C0965R.drawable.map_icon_direction_wheel);
        if (icon != null) {
            iconBitmap = drawableToBitmap(icon);
            data = new OverlayLocationData();
            if (!(iconBitmap == null || iconBitmap.isRecycled())) {
                data.setImage(iconBitmap);
                data.setImgHeight(iconBitmap.getHeight());
                data.setImgWidth(iconBitmap.getWidth());
                data.setImgName("direction");
                data.setRotation(1);
                list.add(data);
            }
        }
        MapViewFactory.getInstance().getMapView().setDefaultLocationLayerData(list);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        int width = ScreenUtil.getInstance().px2dip(drawable.getIntrinsicWidth());
        int height = ScreenUtil.getInstance().px2dip(drawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(width, height, drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    public void showMapFocusView(boolean isShow) {
        if (this.mPoiDetailView == null || !this.mPoiDetailView.isVisible()) {
            setMapFocusViewVisible(isShow);
            if (!isShow) {
                switchMapFocus(false, false);
                return;
            }
            return;
        }
        setMapFocusViewVisible(false);
    }

    public void onPause() {
        super.onPause();
        BMEventBus.getInstance().unregist(this);
    }

    public void onDestroyView() {
        if (this.mHomeController != null) {
            this.mHomeController.dismissGPSSettingDialog();
        }
        if (mActivity != null) {
            mActivity.k();
        }
        if (this.mCommonController != null) {
            this.mCommonController.dismissNoNetAndOfflineDataDialog();
        }
        PoiController.getInstance().clearPoiCache();
        super.onDestroyView();
    }

    public boolean onBackPressed() {
        if (!switchMapFocus(false, false)) {
            if (this.mPoiDetailView != null && this.mPoiDetailView.isVisible()) {
                this.mPoiDetailView.hide();
                enterCruiseFollowModeDetect();
                setMapFocusViewVisible(true);
                if (this.mMiddleFocusViewGroup != null) {
                    C1440d.a().h(this.mMiddleFocusViewGroup);
                }
            } else if (mActivity != null) {
                mActivity.d();
            }
        }
        return true;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initLocationManager() {
        ConcurrentManager.executeTask(Module.NAV_MODULE, new C38733(), ScheduleConfig.forSetupData());
    }

    protected HomePoiBasicView initMapPoiDetailView() {
        return this.mPoiDetailView;
    }

    protected void onInitView() {
    }

    protected void onInitMap() {
        super.onInitMap();
    }

    protected void handleLongPress(MotionEvent e) {
        initFocusChain(this.mViewGroup);
        super.handleLongPress(e);
    }

    public void handleLongPress(GeoPoint geoPoint) {
        initFocusChain(this.mViewGroup);
        EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
        onShowMapGeoPoint(geoPoint);
    }

    protected void showTrafficMap(boolean show) {
        if (this.mMapView != null) {
            updateMapTheme(show);
            this.mMapView.forceSetTraffic(show);
        }
    }

    private void updateMapTheme(boolean show) {
        int sceneId;
        MapController mapController = this.mMapView.getController();
        int mapTheme = 10;
        if (show) {
            sceneId = 5;
        } else {
            sceneId = 0;
        }
        if (!StyleManager.getRealDayStyle()) {
            if (NavMapManager.getInstance().isChangedMapMode()) {
                mapTheme = 11;
                sceneId = show ? 13 : 9;
            } else {
                mapTheme = 12;
                sceneId = show ? 5 : 0;
            }
        }
        mapController.setMapThemeScene(mapTheme, sceneId, new Bundle());
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!(hidden || this.mMapControlPanel == null)) {
            this.mMapControlPanel.showWatermark();
        }
        if (hidden) {
            setBottomBarBackgroud(null);
            if (this.mHomeController != null) {
                this.mHomeController.dismissGPSSettingDialog();
            }
            if (mActivity != null) {
                mActivity.k();
            }
            if (this.mCommonController != null) {
                this.mCommonController.dismissNoNetAndOfflineDataDialog();
                return;
            }
            return;
        }
        setBottomBarBackgroud(C2188r.b(C0965R.drawable.com_bottom_bg));
        if (getCurrentFragmentType() == 17) {
            enterCruiseFollowModeDetect();
        }
        drivingSet();
    }

    public void showTopbarView() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.showTopBarView();
        }
    }

    public void hideTopbarView() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.hideShowTopBarView();
        }
    }

    public void onInitFocusAreas() {
        if (this.isDisplayed) {
            initFocusChain(this.mViewGroup);
        }
    }

    public void initFocusChain(View root) {
        C1440d focusManager = C1440d.a();
        focusManager.g();
        if (this.mMapControlPanel != null) {
            if (this.mMiddleFocusViewGroup == null) {
                this.mMiddleFocusViewGroup = this.mMapControlPanel.initFocusChain(root);
            }
            this.mMapControlPanel.switchMapFocus(false, false);
            boolean z = this.mPoiDetailView == null || !this.mPoiDetailView.isVisible();
            setMapFocusViewVisible(z);
        }
        if (this.mRightFocusViewGroup == null) {
            this.mRightFocusViewGroup = new C1443g(root.findViewById(C0965R.id.layout_poi_panel), 5);
            this.mRightFocusViewGroup.d(this.mViewGroup.findViewById(C0965R.id.carmode_map_poi_panel_right_place_layout));
            this.mRightFocusViewGroup.d(this.mViewGroup.findViewById(C0965R.id.carmode_map_poi_panel_right_phone_layout));
            this.mRightFocusViewGroup.d(this.mViewGroup.findViewById(C0965R.id.carmode_map_poi_panel_right_distance_layout));
        }
        this.mRightFocusViewGroup.c(null);
        this.mRightFocusViewGroup.b(this.mViewGroup.findViewById(C0965R.id.carmode_map_poi_panel_right_distance_layout));
        focusManager.b(new C1436a[]{this.mMiddleFocusViewGroup, this.mRightFocusViewGroup});
        if (!isNeedShowDialog() && !isDialogShown()) {
            focusManager.h(this.mMiddleFocusViewGroup);
        }
    }

    public void bnMapObserverUpdate(BNSubject o, int type, int event, Object arg) {
        if (2 == type) {
            enterCruiseFollowModeDetect();
        }
    }

    public void requestInitView() {
        super.requestInitView();
        enterCruiseFollowModeDetect();
    }

    public void enterCruise() {
        enterCruiseFollowModeDetect();
    }

    public void quitCruise() {
        EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
    }

    public void driving() {
        C1260i.b("yftech", "CarModeMapFragment driving");
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.hideSearchView();
        }
        if (this.mPoiDetailView != null) {
            this.mPoiDetailView.hide();
        }
    }

    public void stopDriving() {
        C1260i.b("yftech", "CarModeMapFragment stopDriving");
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.showSearchView();
        }
    }

    public void drivingSet() {
        if (getNaviFragmentManager().isDriving()) {
            C1260i.b("yftech", "CarModeMapFragment onResume driving");
            if (this.mMapControlPanel != null) {
                this.mMapControlPanel.hideSearchView();
                return;
            }
            return;
        }
        C1260i.b("yftech", "CarModeMapFragment onResume stopDriving");
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.showSearchView();
        }
    }

    public void onEvent(Object obj) {
        if (obj instanceof MapMoveEvent) {
            onEventMainThread((MapMoveEvent) obj);
        }
    }

    private void onEventMainThread(MapMoveEvent event) {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.handleScrollGesture();
            this.mMapControlPanel.updateView();
        }
        enterCruiseFollowModeDetect();
    }
}
