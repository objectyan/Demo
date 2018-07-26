package com.baidu.navi.view;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1441e;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.view.TopBarView;
import com.baidu.carlife.view.dialog.C2276d;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig.MapMode;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.adapter.MapControlPanelAdapter;
import com.baidu.navi.cruise.control.ICruiseEnterQuiteLogic;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.ZoomButtonView.OnZoomBtnClickListener;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.baidu.platform.comapi.util.C4835n;

public class MapControlPanel implements OnClickListener, OnItemClickListener {
    private static final int FIVEK_LEVEL = 12;
    private static final int H_LEVEL = 17;
    private static final int LOCATION_ACC_THRESHOLD = 1;
    private static final int LOCATION_ANG_THRESHOLD = 3;
    private static final int LOCATION_DIS_THRESHOLD = 1;
    private static final double MAX_WALK_SPEED = 2.0d;
    private static final double WAIT_SPEED_TIME = 30000.0d;
    private boolean isDayStyle = true;
    private boolean isHomeMapPage = false;
    private boolean isVisible = false;
    private boolean isWatermarkEnable = true;
    private PositionStatus lastPositionStatus;
    private int locAngle = 0;
    private long locTime = 0;
    private CarlifeActivity mActivity;
    private int mAngleX = Integer.MIN_VALUE;
    private View mCarlifeLeftLayout;
    private ICruiseEnterQuiteLogic mCruiseEnterQuiteHandle;
    private double mCurLatitude;
    private double mCurLongitude;
    private C1443g mFocusArea;
    private NaviFragmentManager mFragmentManager;
    private Handler mHandler = new Handler();
    private boolean mIsMapFocusOpen = false;
    private IItsClickListener mItsClickListener;
    private int mLastAngle = Integer.MIN_VALUE;
    private LocData mLastLoc;
    private View mLayerView;
    private View mLeftLayout;
    private ProgressBar mLocProgressBar;
    private View mLocation;
    private ImageView mLocationBtn;
    private ILocationBtnClickListener mLocationBtnClickListener;
    private C1441e mMapFocusArea;
    private ImageView mMapFocusBtn;
    private View mMapFocusImage;
    private View mMapFocusView;
    private MapGLSurfaceView mMapView;
    private MapViewConfig mMapViewConfig;
    private MapControlPanelAdapter mMenuAdapter;
    private ImageView mMenuBtn;
    private C2276d mMenuDialog;
    private View mMenuView;
    private C1277e mOnDialogListener;
    private View mRightLayout;
    private View mRootView;
    private View mScaleLevelLayout;
    private ScaleLevelView mScaleLevelView;
    private ImageView mSearchIc;
    private TextView mSearchTextView;
    private View mSearchView;
    private TopBarView mTopBarView;
    private Thread mWaitingLocTimer = null;
    private ImageView mWatermark;
    OnZoomBtnClickListener mZoomBtnClickListener = new C40071();
    private ZoomButtonView mZoomButtonView;
    private ImageView mZoomInBtnView;
    private ImageView mZoomOutBtnView;
    private boolean overlookAnimEnd = true;
    private long overlookAnimTime = 0;
    private long sensorTime = 0;

    public interface IItsClickListener {
        void onClickIts();
    }

    public interface ILocationBtnClickListener {
        void onClick(PositionStatus positionStatus);
    }

    /* renamed from: com.baidu.navi.view.MapControlPanel$1 */
    class C40071 implements OnZoomBtnClickListener {
        C40071() {
        }

        public void onZoomOutBtnClick() {
            MapControlPanel.this.mZoomButtonView.handleZoomOut();
        }

        public void onZoomInBtnClick() {
            MapControlPanel.this.mZoomButtonView.handleZoomIn();
        }
    }

    public MapControlPanel(CarlifeActivity activity, View viewGroup, NaviFragmentManager fragmentManager) {
        if (viewGroup != null && activity != null) {
            this.mActivity = activity;
            this.mFragmentManager = fragmentManager;
            this.mMapViewConfig = MapViewConfig.getInstance();
            this.mMapView = MapViewFactory.getInstance().getMapView();
            this.mRootView = viewGroup.findViewById(C0965R.id.map_control_panel);
            this.isDayStyle = StyleManager.getDayStyle();
            if (this.mRootView != null) {
                this.mLayerView = this.mRootView.findViewById(C0965R.id.map_control_panel_layer);
                this.mMenuView = this.mRootView.findViewById(C0965R.id.map_control_left_panel_menu_layout);
                this.mMenuView.setOnClickListener(this);
                this.mMenuBtn = (ImageView) this.mRootView.findViewById(C0965R.id.map_control_left_panel_menu);
                this.mMenuBtn.setOnClickListener(this);
                this.mSearchView = this.mRootView.findViewById(C0965R.id.carlife_top_panel);
                this.mSearchView.setOnClickListener(this);
                this.mSearchIc = (ImageView) this.mRootView.findViewById(C0965R.id.iv_carlife_top_search_ic);
                this.mSearchTextView = (TextView) this.mRootView.findViewById(C0965R.id.et_ctrl_search);
                this.mSearchTextView.setOnClickListener(this);
                this.mScaleLevelLayout = this.mRootView.findViewById(C0965R.id.map_scale_level_layout);
                this.mWatermark = (ImageView) this.mRootView.findViewById(C0965R.id.map_control_left_panel_watermark);
                this.mScaleLevelView = new ScaleLevelView();
                this.mScaleLevelView.initView(this.mActivity, this.mRootView);
                this.mLocation = this.mRootView.findViewById(C0965R.id.location_layout);
                this.mLocationBtn = (ImageView) this.mRootView.findViewById(C0965R.id.location_btn);
                this.mLocationBtn.setOnClickListener(this);
                this.mLocation.setOnClickListener(this);
                this.mLocProgressBar = (ProgressBar) this.mRootView.findViewById(C0965R.id.locProgress);
                this.mZoomButtonView = new ZoomButtonView();
                this.mZoomButtonView.initView(this.mActivity, this.mRootView);
                this.mZoomInBtnView = (ImageView) this.mRootView.findViewById(C0965R.id.btn_zoom_in);
                this.mZoomOutBtnView = (ImageView) this.mRootView.findViewById(C0965R.id.btn_zoom_out);
                this.mMapFocusView = this.mRootView.findViewById(C0965R.id.layout_focus_switch);
                if (this.mMapFocusView != null) {
                    this.mMapFocusView.setVisibility(C1765g.a().c() ? 0 : 8);
                    this.mMapFocusView.setOnClickListener(this);
                }
                this.mMapFocusBtn = (ImageView) this.mRootView.findViewById(C0965R.id.image_focus_switch);
                this.mMapFocusImage = this.mRootView.findViewById(C0965R.id.mapfocus_layout);
                this.mLeftLayout = this.mRootView.findViewById(C0965R.id.map_control_left_panel);
                this.mRightLayout = this.mRootView.findViewById(C0965R.id.map_control_right_panel);
                this.mTopBarView = (TopBarView) this.mRootView.findViewById(C0965R.id.common_top_bar);
                this.mCarlifeLeftLayout = this.mRootView.findViewById(C0965R.id.carlife_left_panel);
            }
        }
    }

    public void setHomeMapPage(boolean isHomeMapPage) {
        this.isHomeMapPage = isHomeMapPage;
    }

    public boolean isMapFocusOpen() {
        return this.mIsMapFocusOpen;
    }

    public View getView() {
        return this.mRootView;
    }

    public void updateView() {
        updateScale();
        updateZoomButton();
        BNMapController.getInstance().updateLayer(10);
        BNMapController.getInstance().UpdataBaseLayers();
    }

    public void setLeftTopPanelVisible(boolean isVisible) {
        if (this.mCarlifeLeftLayout != null) {
            this.mCarlifeLeftLayout.setVisibility(isVisible ? 0 : 8);
        }
    }

    public void setLeftRightPanelVisible(boolean isVisible) {
        int i = 0;
        if (this.mLeftLayout != null) {
            this.mLeftLayout.setVisibility(isVisible ? 0 : 8);
        }
        if (this.mRightLayout != null) {
            View view = this.mRightLayout;
            if (!isVisible) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public void show() {
        this.mTopBarView.setVisibility(0);
        this.mMenuView.setVisibility(0);
        this.mSearchView.setVisibility(0);
    }

    public void showWatermark() {
        this.mWatermark.setVisibility(0);
        this.mScaleLevelLayout.setVisibility(8);
    }

    public void hide() {
        this.mTopBarView.setVisibility(8);
        this.mMenuView.setVisibility(8);
        this.mSearchView.setVisibility(8);
    }

    public void showLayerView() {
        this.mLayerView.setVisibility(0);
    }

    public void hideLayerView() {
        this.mLayerView.setVisibility(8);
    }

    public void showTopBarView() {
        this.mTopBarView.setVisibility(0);
    }

    public void hideShowTopBarView() {
        this.mTopBarView.setVisibility(8);
    }

    public void disableWatermark() {
        this.isWatermarkEnable = false;
    }

    public void registerCruiseHandler(ICruiseEnterQuiteLogic handle) {
        this.mCruiseEnterQuiteHandle = handle;
    }

    private void updateScale() {
        String txt;
        int scrWidht = BNMapController.getInstance().getScreenWidth();
        int level = BNMapController.getInstance().getZoomLevel();
        double u = BNMapController.getInstance().getZoomUnitsInMeter();
        int dist = MapController.getScaleDis(level);
        LogUtil.m15791e(ModuleName.MAP, "room updateScale dis=" + dist + " level=" + level + " u=" + u);
        int pxLen = (int) Math.ceil(((double) dist) / u);
        while (pxLen > scrWidht / 2 && level >= 3 && level <= 20) {
            level++;
            dist = MapController.getScaleDis(level);
            pxLen = (int) Math.ceil(((double) dist) / u);
        }
        if (dist >= 1000) {
            txt = (dist / 1000) + this.mActivity.getString(C0965R.string.kilometer);
        } else {
            txt = dist + this.mActivity.getString(C0965R.string.meter);
        }
        this.mScaleLevelView.updateScaleView(txt, pxLen);
        if (this.isWatermarkEnable) {
            this.mScaleLevelLayout.setVisibility(8);
            this.mWatermark.setVisibility(0);
            return;
        }
        this.mScaleLevelLayout.setVisibility(0);
        this.mWatermark.setVisibility(8);
    }

    private void updateZoomButton() {
        int level = BNMapController.getInstance().getZoomLevel();
        LogUtil.m15791e(ModuleName.MAP, "updateZoomButton. level = " + level);
        if (level <= 4) {
            this.mZoomButtonView.updateZoomBtn(true, false);
        } else if (level >= 21) {
            this.mZoomButtonView.updateZoomBtn(false, true);
        } else {
            this.mZoomButtonView.updateZoomBtn(true, true);
        }
    }

    public void handleLocationBtnClick() {
        if (this.mLocationBtnClickListener != null) {
            this.mLocationBtnClickListener.onClick(this.mMapViewConfig.getPositionStatus());
        }
        onLocationBtnClicked();
    }

    public void setZoomBtnClickListener(OnZoomBtnClickListener listener) {
        this.mZoomButtonView.setZoomBtnClickListener(listener);
    }

    private void handleMapFocusClicked() {
        this.mIsMapFocusOpen = false;
        switchMapFocus(true, false);
        if (this.mMapFocusArea == null) {
            this.mMapFocusArea = new C1441e(this.mRootView, 4);
            if (this.mMapFocusImage != null) {
                this.mMapFocusArea.c(this.mMapFocusImage);
            }
        }
        this.mMapFocusArea.a(this.mZoomBtnClickListener);
        C1440d.a().b(new C1436a[]{this.mMapFocusArea});
        this.mMapFocusImage.requestFocus();
    }

    public void setItsClickListener(IItsClickListener mListener) {
        this.mItsClickListener = mListener;
    }

    public void setLocationBtnClickListener(ILocationBtnClickListener listener) {
        this.mLocationBtnClickListener = listener;
    }

    private void updateLocationTip() {
        this.mLocProgressBar.setVisibility(8);
        switch (LocationManager.getInstance().getCurLocationType()) {
            case 62:
            case 162:
            case RouteLineResConst.LINE_ARR_RED_FOCUS /*163*/:
            case RouteLineResConst.LINE_ARR_YELLOW_NORMAL /*164*/:
            case RouteLineResConst.LINE_ARR_YELLOW_FOCUS /*165*/:
            case RouteLineResConst.LINE_ARR_FOOT_GREEN_NORMAL /*166*/:
            case 167:
                TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getResources().getString(C0965R.string.locate_failed));
                break;
            case 63:
                TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getResources().getString(C0965R.string.locate_network_error));
                break;
        }
        this.mMapViewConfig.setPositionStatus(PositionStatus.NORMAL);
        MainMapModel.getInstance().setLocMode(0);
        updateLocationBtn();
    }

    public void handleScrollGesture() {
        disableWatermark();
        resetLocMode();
        setVisible(true);
    }

    public void handleSingleTouchGesture() {
        resetLocMode();
        switchMapFocus(false, true);
    }

    public void changeLocationMode(int mode) {
        MainMapModel.getInstance().mFirstAutoLocMode = mode;
        if (mode != MainMapModel.getInstance().getCurLocMode()) {
            if (BNLocationManagerProxy.getInstance().isLocationValid()) {
                int locMode = MainMapModel.getInstance().setLocMode(mode);
                updateLocationBtn();
                if (locMode == 1 && this.mLocProgressBar.getVisibility() == 0) {
                    this.mLocProgressBar.setVisibility(8);
                    return;
                }
                return;
            }
            this.mMapViewConfig.setPositionStatus(PositionStatus.NORMAL);
            MainMapModel.getInstance().setLocMode(0);
            TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getResources().getString(C0965R.string.locate_begin));
            this.mLocationBtn.setImageDrawable(null);
            this.mLocProgressBar.setVisibility(0);
            if (this.mWaitingLocTimer == null) {
                this.mWaitingLocTimer = new Thread(getClass().getSimpleName()) {
                    public void run() {
                        MapControlPanel.this.updateLocationTip();
                    }
                };
            }
            this.mHandler.postDelayed(this.mWaitingLocTimer, 15000);
        }
    }

    public void resetLocMode() {
        if (this.mLocProgressBar != null && this.mLocProgressBar.getVisibility() != 0) {
            MainMapModel.getInstance().setLocMode(0);
            this.mMapViewConfig.setPositionStatus(PositionStatus.NORMAL);
            updateLocationBtn();
        }
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == C0965R.id.location_btn || id == C4048R.id.location_btn) {
            if (this.mCruiseEnterQuiteHandle != null) {
                this.mCruiseEnterQuiteHandle.enterCruise();
            }
            handleLocationBtnClick();
        } else if (id == C0965R.id.location_layout || id == C4048R.id.location_layout) {
            handleLocationBtnClick();
            if (this.mCruiseEnterQuiteHandle != null) {
                this.mCruiseEnterQuiteHandle.enterCruise();
            }
        } else if (id == C0965R.id.layout_focus_switch) {
            handleMapFocusClicked();
        } else if (id == C0965R.id.map_control_left_panel_menu || id == C0965R.id.map_control_left_panel_menu_layout) {
            showMenuDialog();
        } else if (id == C0965R.id.carlife_top_panel || id == C0965R.id.et_ctrl_search) {
            this.mFragmentManager.showFragment(49, null);
        }
    }

    public void onResume() {
        setMapFocusVisible(false);
    }

    public void updateLocationBtn() {
        switch (MainMapModel.getInstance().getCurLocMode()) {
            case 0:
                this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_backparking));
                return;
            case 1:
                this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_north));
                return;
            case 2:
                this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_orientation));
                return;
            default:
                return;
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        LogUtil.m15791e("StyleDebug", "MapControlPanel dayStyle = " + dayStyle);
        if (this.mZoomButtonView != null && this.mLocationBtn != null && this.mScaleLevelView != null && this.mMenuBtn != null && this.mLayerView != null && this.mSearchView != null && this.mMapFocusBtn != null && this.mSearchIc != null) {
            C1260i.b("StyleDebug", "MapControlPanel dayStyle = " + dayStyle);
            this.isDayStyle = dayStyle;
            this.mLayerView.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_top, this.isDayStyle));
            this.mSearchView.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn, this.isDayStyle));
            this.mMenuBtn.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector_nobackground, this.isDayStyle));
            this.mLocationBtn.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector, this.isDayStyle));
            this.mMapFocusBtn.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector, this.isDayStyle));
            updateLocationBtn();
            this.mZoomButtonView.onUpdateStyle(this.isDayStyle);
            this.mScaleLevelView.onUpdateStyle(this.isDayStyle);
        }
    }

    public ZoomButtonView getZoomButtonView() {
        return this.mZoomButtonView;
    }

    public void setVisible(boolean visible) {
        if (this.isVisible != visible) {
            this.isVisible = visible;
        }
    }

    public void switchMapFocus(boolean openFocus, boolean fromSingleTouch) {
        boolean z = true;
        if (this.mIsMapFocusOpen != openFocus) {
            boolean z2;
            this.mIsMapFocusOpen = openFocus;
            if (!fromSingleTouch) {
                if (openFocus) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                setVisible(z2);
            }
            if (openFocus) {
                z2 = false;
            } else {
                z2 = true;
            }
            setLeftTopPanelVisible(z2);
            if (openFocus) {
                z = false;
            }
            setLeftRightPanelVisible(z);
            setMapFocusVisible(openFocus);
        }
    }

    public void setMapFocusVisible(boolean openFocus) {
        if (this.mMapFocusImage != null) {
            this.mMapFocusImage.setVisibility(openFocus ? 0 : 8);
        }
    }

    public void setMapFocusViewVisible(boolean isVisible) {
        if (this.mMapFocusView != null) {
            boolean isSupportFocus = C1765g.a().c();
            View view = this.mMapFocusView;
            int i = (isVisible && isSupportFocus) ? 0 : 8;
            view.setVisibility(i);
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public C1443g initFocusChain(View root) {
        if (this.mFocusArea == null) {
            this.mFocusArea = new C1443g(root.findViewById(C0965R.id.map_control_panel), 4, true);
            this.mFocusArea.d(this.mMenuView).d(this.mSearchTextView);
            if (this.mMapFocusView != null) {
                this.mFocusArea.d(this.mMapFocusView);
            }
            this.mFocusArea.d(this.mZoomInBtnView).d(this.mZoomOutBtnView).d(this.mLocation);
            this.mFocusArea.b(true);
            this.mFocusArea.b(this.mSearchTextView);
        }
        return this.mFocusArea;
    }

    public ImageView getZoomInBtnView() {
        return this.mZoomInBtnView;
    }

    public ImageView getZoomOutBtnView() {
        return this.mZoomOutBtnView;
    }

    public View getLocationView() {
        return this.mLocation;
    }

    public void updateMenuDialog() {
        if (this.mMenuAdapter != null) {
            this.mMenuAdapter.notifyDataSetChanged();
        }
    }

    private void showMenuDialog() {
        cancelMenuDialog();
        if (this.mCruiseEnterQuiteHandle != null) {
            this.mCruiseEnterQuiteHandle.quitCruise();
        }
        if (this.mMenuAdapter == null) {
            this.mMenuAdapter = new MapControlPanelAdapter(this.mActivity);
        }
        if (C1663a.a().N() && (C1342a.a().b() || C1343b.a().b())) {
            this.mMenuAdapter.updateFavoriteItem();
        }
        if (this.mMenuDialog == null) {
            this.mMenuDialog = new C2276d(this.mActivity, this.mMenuAdapter, this);
            this.mMenuDialog.j();
        } else {
            this.mMenuDialog.i();
        }
        if (this.mOnDialogListener != null) {
            this.mOnDialogListener.showDialog(this.mMenuDialog, C1265a.left);
        }
    }

    private void cancelMenuDialog() {
        if (this.mOnDialogListener != null) {
            this.mOnDialogListener.dismissDialog(this.mMenuDialog);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        cancelMenuDialog();
        switch (position) {
            case 0:
                this.mFragmentManager.showFragment(304, null);
                return;
            case 1:
                if (this.mItsClickListener != null) {
                    this.mItsClickListener.onClickIts();
                    return;
                }
                return;
            case 2:
                StatisticManager.onEvent(StatisticConstants.NAVI_0003, StatisticConstants.NAVI_0003);
                C1915a.a().a(C1663a.a().N());
                this.mFragmentManager.showFragment(114, null);
                return;
            default:
                return;
        }
    }

    public void setOnDialogListener(C1277e listener) {
        this.mOnDialogListener = listener;
    }

    public void showSearchView() {
        this.mSearchView.setVisibility(0);
        if (this.mMenuDialog != null) {
            this.mMenuDialog.i();
        }
    }

    public void hideSearchView() {
        this.mSearchView.setVisibility(8);
        if (this.mMenuDialog != null) {
            this.mMenuDialog.i();
        }
    }

    protected void onLocationBtnClicked() {
        int nextMode = MainMapModel.getInstance().getCurLocMode();
        switch (this.mMapViewConfig.getPositionStatus()) {
            case NORMAL:
                nextMode = 1;
                this.mMapViewConfig.setPositionStatus(PositionStatus.FOLLOWING);
                changeMapByStatus(PositionStatus.NORMAL, false, false);
                break;
            case FOLLOWING:
                nextMode = 2;
                this.mMapViewConfig.setPositionStatus(PositionStatus.COMPASS);
                changeMapByStatus(PositionStatus.FOLLOWING, false, false);
                break;
            case COMPASS:
                nextMode = 1;
                this.mMapViewConfig.setPositionStatus(PositionStatus.FOLLOWING);
                changeMapByStatus(PositionStatus.COMPASS, false, false);
                break;
        }
        changeLocationMode(nextMode);
        this.overlookAnimTime = System.currentTimeMillis();
    }

    public void changeLocationModeByVoice(PositionStatus positionStatus) {
        int nextMode = MainMapModel.getInstance().getCurLocMode();
        if (this.mMapViewConfig != null) {
            PositionStatus lastStatus = this.mMapViewConfig.getPositionStatus();
            this.mMapViewConfig.setPositionStatus(positionStatus);
            changeMapByStatus(lastStatus, false, true);
            switch (positionStatus) {
                case NORMAL:
                    nextMode = 2;
                    break;
                case FOLLOWING:
                    nextMode = 1;
                    break;
                case COMPASS:
                    nextMode = 2;
                    break;
            }
            changeLocationMode(nextMode);
        }
        this.overlookAnimTime = System.currentTimeMillis();
    }

    private void changeMapByStatus(PositionStatus lastStatus, boolean isFirstLocated, boolean isFromVoice) {
        float f = 18.0f;
        LocData locData = LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09);
        MapStatus st = this.mMapView.getMapStatus();
        if (st != null) {
            if (!isFirstLocated) {
                switch (this.mMapViewConfig.getPositionStatus()) {
                    case FOLLOWING:
                        st.centerPtX = (double) ((int) locData.longitude);
                        st.centerPtY = (double) ((int) locData.latitude);
                        if (lastStatus != PositionStatus.NORMAL) {
                            if (MapViewConfig.getInstance().getMapMode() != MapMode._3D) {
                                st.overlooking = 0;
                            }
                            st.rotation = 0;
                        }
                        if (isFromVoice) {
                            st.overlooking = 0;
                            st.rotation = 0;
                            break;
                        }
                        break;
                    case COMPASS:
                        st.centerPtX = (double) ((int) locData.longitude);
                        st.centerPtY = (double) ((int) locData.latitude);
                        st.overlooking = -45;
                        if (this.isHomeMapPage) {
                            st.overlooking = -45;
                        }
                        if (locData.direction > 0.0f) {
                            st.rotation = (int) locData.direction;
                        } else if (this.mAngleX != Integer.MIN_VALUE) {
                            st.rotation = this.mAngleX;
                        }
                        if (locData.buildingId == null || locData.floorId == null) {
                            if (st.level >= 18.0f) {
                                f = st.level;
                            }
                            st.level = f;
                            break;
                        }
                    default:
                        break;
                }
            } else if (this.mMapViewConfig.getPositionStatus() == PositionStatus.FOLLOWING) {
                st.centerPtX = (double) ((int) locData.longitude);
                st.centerPtY = (double) ((int) locData.latitude);
                st.level = 17.0f;
                if (!(locData.floorId == null || locData.buildingId == null)) {
                    st.level = 20.0f;
                }
                if (lastStatus != PositionStatus.NORMAL) {
                    if (MapViewConfig.getInstance().getMapMode() != MapMode._3D) {
                        st.overlooking = 0;
                    }
                    st.rotation = 0;
                }
            }
            if (st.level < 12.0f) {
                st.level = 17.0f;
            }
            updateLocOverlay(locData, this.mMapViewConfig.getPositionStatus());
            PositionStatus positionStatus = this.mMapViewConfig.getPositionStatus();
            if (!isFirstLocated || !this.mMapView.getController().isMovedMap()) {
                if (positionStatus != PositionStatus.COMPASS && positionStatus != PositionStatus.FOLLOWING) {
                    return;
                }
                if (C4835n.m16035a()) {
                    if (isFirstLocated) {
                        this.mMapView.setMapStatus(st);
                    } else {
                        this.mMapView.animateTo(st, 1000);
                    }
                } else if (isFirstLocated) {
                    this.mMapView.setMapStatus(st);
                } else {
                    this.mMapView.animateTo(st, 1000);
                }
            }
        }
    }

    private void updateLocOverlay(LocData locData, PositionStatus status) {
        if ((locData.latitude != -1.0d || locData.longitude != -1.0d) && this.mMapViewConfig.getPositionStatus() != PositionStatus.TRACKING) {
            float direction = locData.direction;
            if (((double) locData.speed) <= MAX_WALK_SPEED || direction <= 0.0f) {
                direction = (float) this.mAngleX;
            }
            locData.direction = direction;
            if (isNeedRefreshLocationOverlay(locData, status)) {
                String strData = locData.toLocationOverlayJsonString(true);
                LocationOverlay locationOverlay = (LocationOverlay) this.mMapView.getOverlay(LocationOverlay.class);
                if (locationOverlay != null) {
                    locationOverlay.setData(strData);
                    locationOverlay.UpdateOverlay();
                }
                this.mLastLoc = locData;
                this.lastPositionStatus = status;
            }
        }
    }

    private boolean isNeedRefreshLocationOverlay(LocData locData, PositionStatus status) {
        return this.mLastLoc == null || Math.abs(this.mLastLoc.latitude - locData.latitude) >= 1.0d || Math.abs(this.mLastLoc.longitude - locData.longitude) >= 1.0d || Math.abs(this.mLastLoc.accuracy - locData.accuracy) >= 1.0f || Math.abs(this.mLastLoc.direction - locData.direction) >= 3.0f || this.lastPositionStatus == null || this.lastPositionStatus != status;
    }

    public void updateMapBySensorAngle(int iAngleX) {
        float speed = 0.0f;
        if (this.isHomeMapPage) {
            iAngleX += MainMapModel.getInstance().mScreenRotation;
            this.mAngleX = iAngleX;
            if (this.mMapViewConfig.getPositionStatus() != PositionStatus.TRACKING) {
                int anim = (int) (System.currentTimeMillis() - this.sensorTime);
                if (this.sensorTime == 0 || anim <= 500) {
                    anim = 500;
                }
                if (Math.abs(iAngleX - this.mLastAngle) >= 30) {
                    anim = 500;
                }
                this.sensorTime = System.currentTimeMillis();
                if (this.sensorTime - this.overlookAnimTime >= 3000) {
                    this.overlookAnimEnd = true;
                }
                if (iAngleX != this.mLastAngle && this.overlookAnimEnd) {
                    float direction;
                    this.mLastAngle = iAngleX;
                    LocData data = LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09);
                    if (data != null) {
                        direction = data.direction;
                    } else {
                        direction = 0.0f;
                    }
                    if (data != null) {
                        speed = data.speed;
                    }
                    MapStatus st = this.mMapView.getMapStatus();
                    if (st == null || this.mMapViewConfig.getPositionStatus() != PositionStatus.COMPASS) {
                        data.direction = ((double) speed) > MAX_WALK_SPEED ? (float) ((int) direction) : (float) iAngleX;
                    } else {
                        st.centerPtX = (double) ((int) data.longitude);
                        st.centerPtY = (double) ((int) data.latitude);
                        st.overlooking = -45;
                        if (this.isHomeMapPage) {
                            st.overlooking = -45;
                        }
                        if (((double) speed) > MAX_WALK_SPEED) {
                            this.locAngle = (int) direction;
                            this.locTime = System.currentTimeMillis();
                            st.rotation = this.locAngle;
                        } else {
                            st.rotation = ((double) (System.currentTimeMillis() - this.locTime)) <= WAIT_SPEED_TIME ? this.locAngle : iAngleX;
                        }
                        if (this.mMapView.getController() != null) {
                            this.mMapView.animateTo(st, anim);
                        }
                        data.direction = (float) st.rotation;
                    }
                    updateLocOverlay(data, this.mMapViewConfig.getPositionStatus());
                }
            }
        }
    }

    public void onLocationChange(LocData locData, boolean moveToLocationPoint) {
        if (LocationManager.getInstance().isLocationValid() && this.mMapView != null && System.currentTimeMillis() - this.overlookAnimTime >= 3000 && locData != null) {
            if (MainMapModel.getInstance().bFirstShowLoc || this.mCurLongitude != locData.longitude || this.mCurLatitude != locData.latitude) {
                MapStatus status = this.mMapView.getMapStatus();
                MainMapModel.getInstance().bFirstShowLoc = false;
                this.mCurLongitude = locData.longitude;
                this.mCurLatitude = locData.latitude;
                if (this.mCurLongitude <= 0.0d || this.mCurLatitude <= 0.0d) {
                    TipTool.onCreateToastDialog(this.mActivity, (int) C0965R.string.wait_for_loacte);
                } else if (MainMapModel.getInstance().bFirstLoc && moveToLocationPoint) {
                    MainMapModel.getInstance().bFirstLoc = false;
                    status.centerPtX = locData.longitude;
                    status.centerPtY = locData.latitude;
                    this.mMapView.animateTo(status, 0);
                }
                PositionStatus positionStatus = this.mMapViewConfig.getPositionStatus();
                if ((positionStatus == PositionStatus.COMPASS || positionStatus == PositionStatus.FOLLOWING) && moveToLocationPoint && this.isHomeMapPage) {
                    if (positionStatus == PositionStatus.COMPASS) {
                        status.overlooking = -45;
                        if (this.isHomeMapPage) {
                            status.overlooking = -45;
                        }
                        if (locData.direction > 0.0f) {
                            status.rotation = (int) locData.direction;
                        } else if (this.mAngleX != Integer.MIN_VALUE) {
                            status.rotation = this.mAngleX;
                        }
                    }
                    status.centerPtX = locData.longitude;
                    status.centerPtY = locData.latitude;
                    this.mMapView.animateTo(status, 0);
                }
                updateLocOverlay(locData, positionStatus);
            }
        }
    }
}
