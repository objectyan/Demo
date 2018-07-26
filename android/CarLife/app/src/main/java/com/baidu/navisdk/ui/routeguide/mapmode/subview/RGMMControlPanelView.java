package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.NavState;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drawable.UrlDrawableContainForNav;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGMMControlPanelView extends BNBaseView {
    private ImageView mAnologControlIcon = null;
    private View mAnologControlRl = null;
    private View mAnologQuit = null;
    private View mBridgeRoadView = null;
    private Runnable mCancelSwitch = new Runnable() {
        public void run() {
            if (BNLightNaviSwitchManager.getInstance().isSwitching()) {
                RGMapModeViewController.getInstance().dismissSwitchProgressDialog();
                BNLightNaviSwitchManager.getInstance().cancleRoutePlan();
                BNLightNaviSwitchManager.getInstance().setIsSwitching(false);
            }
        }
    };
    private View mControlPanelView = null;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private View mMainRoadView = null;
    private ImageView mMapControllIv = null;
    private View mMapControllView = null;
    private ImageView mMenuRedGuide = null;
    private ImageView mNavingSafeViewIv = null;
    private ImageView mRefreshRoadIv = null;
    private View mRefreshRoadLinear = null;
    private TextView mRefreshRoadTv = null;
    private View mRefreshRoadView = null;
    private View mRouteSearch = null;
    private ImageView mRouteSearchIv = null;
    private View mZoomDivider = null;
    private View mZoomLl = null;
    private ImageView mZoominIv = null;
    private ImageView mZoominOut = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMControlPanelView$1 */
    class C43611 implements OnTouchListener {
        C43611() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (!(event.getAction() != 0 || ForbidDaulClickUtils.isFastDoubleClick() || RightHandResourcesProvider.isInternationalWithToast(RGMMControlPanelView.this.mContext))) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_y_1, "1", null, null);
                BusinessActivityManager.getInstance().safetyUpload(0, true);
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMControlPanelView$2 */
    class C43622 implements OnClickListener {
        C43622() {
        }

        public void onClick(View v) {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMControlPanelView$3 */
    class C43633 implements OnTouchListener {
        C43633() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == 0 && RGMMControlPanelView.this.mSubViewListener != null) {
                RGMMControlPanelView.this.mSubViewListener.onShowQuitNaviView();
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMControlPanelView$4 */
    class C43644 implements OnClickListener {
        C43644() {
        }

        public void onClick(View v) {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMControlPanelView$5 */
    class C43655 implements OnClickListener {
        C43655() {
        }

        public void onClick(View v) {
            if (RGMMControlPanelView.this.mSubViewListener != null) {
                RGMMControlPanelView.this.mSubViewListener.onRefreshRoadAction();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMControlPanelView$6 */
    class C43666 implements OnClickListener {
        C43666() {
        }

        public void onClick(View v) {
            if (RGMMControlPanelView.this.mSubViewListener != null) {
                RGMMControlPanelView.this.mSubViewListener.onZoominAction();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMControlPanelView$7 */
    class C43677 implements OnFocusChangeListener {
        C43677() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus && RGMMControlPanelView.this.mSubViewListener != null) {
                RGMMControlPanelView.this.mSubViewListener.onZoomInGetFocus();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMControlPanelView$8 */
    class C43688 implements OnClickListener {
        C43688() {
        }

        public void onClick(View v) {
            if (RGMMControlPanelView.this.mSubViewListener != null) {
                RGMMControlPanelView.this.mSubViewListener.onZoomoutAction();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMControlPanelView$9 */
    class C43699 implements OnFocusChangeListener {
        C43699() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus && RGMMControlPanelView.this.mSubViewListener != null) {
                RGMMControlPanelView.this.mSubViewListener.onZoomOutGetFocus();
            }
        }
    }

    public RGMMControlPanelView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
    }

    public void orientationChanged(ViewGroup p, int orien) {
        super.orientationChanged(p, orien);
        this.mIsCurDay = true;
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            this.mControlPanelView = ((ViewStub) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_control_panel_stub)).inflate();
            this.mMainRoadView = this.mControlPanelView.findViewById(C4048R.id.bnav_rg_rl_main_auxiliary_switch);
            this.mBridgeRoadView = this.mControlPanelView.findViewById(C4048R.id.bnav_rg_rl_bridge_switch);
            this.mRefreshRoadView = this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_refresh_road);
            this.mRefreshRoadLinear = this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_refresh_road2);
            this.mRefreshRoadIv = (ImageView) this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_refresh_road_iv);
            this.mRefreshRoadTv = (TextView) this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_refresh_road_tv);
            this.mNavingSafeViewIv = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_naving_safety_iv);
            this.mMapControllView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_mapcontroll_rc);
            this.mMapControllIv = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_mapcontroll_iv);
            if (this.mNavingSafeViewIv != null) {
                if (!CloudlConfigDataModel.getInstance().mCommonConfig.safetyNavingShow || BNavConfig.pRGLocateMode == 2) {
                    this.mNavingSafeViewIv.setVisibility(8);
                } else {
                    this.mNavingSafeViewIv.setVisibility(0);
                    UrlDrawableContainForNav.getSrcDrawable(CloudlConfigDataModel.getInstance().mCommonConfig.safetyNavingIcon, C4048R.drawable.nsdk_drawable_common_ic_naving_safe, this.mNavingSafeViewIv, null);
                }
                this.mNavingSafeViewIv.setOnTouchListener(new C43611());
                this.mNavingSafeViewIv.setOnClickListener(new C43622());
            }
            this.mZoominIv = (ImageView) this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_zoomin);
            this.mZoominOut = (ImageView) this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_zoomout);
            this.mZoomLl = this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_zoom_ll);
            this.mZoomDivider = this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_zoom_divider);
            this.mAnologControlRl = this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_anolog_rl);
            this.mAnologControlIcon = (ImageView) this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_anolog_control_icon_a);
            this.mAnologQuit = this.mControlPanelView.findViewById(C4048R.id.bnav_rg_cp_anolog_quit);
            this.mRouteSearch = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_route_search);
            this.mRouteSearchIv = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_route_search_iv);
            this.mAnologQuit.setOnTouchListener(new C43633());
            this.mAnologQuit.setOnClickListener(new C43644());
            this.mRefreshRoadView.setOnClickListener(new C43655());
            this.mZoominIv.setOnClickListener(new C43666());
            this.mZoominIv.setOnFocusChangeListener(new C43677());
            this.mZoominOut.setOnClickListener(new C43688());
            this.mZoominOut.setOnFocusChangeListener(new C43699());
            if (this.mAnologControlIcon != null) {
                this.mAnologControlIcon.setOnTouchListener(new OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == 0 && RGMMControlPanelView.this.mSubViewListener != null) {
                            RGMMControlPanelView.this.mSubViewListener.onAnologControlAction(RGControlPanelModel.getInstance().isAnologPlaying());
                        }
                        return false;
                    }
                });
            }
            this.mAnologControlIcon.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                }
            });
            if (this.mRouteSearch != null) {
                this.mRouteSearch.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (RGMMControlPanelView.this.mSubViewListener != null) {
                            RGMMControlPanelView.this.mSubViewListener.onOtherAction(14, 1, 1, null);
                        }
                    }
                });
                this.mRouteSearch.setOnFocusChangeListener(new OnFocusChangeListener() {
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus && RGMMControlPanelView.this.mSubViewListener != null) {
                            RGMMControlPanelView.this.mSubViewListener.onViaPointGetFocus();
                        }
                    }
                });
            }
            if (this.mMapControllView != null) {
                this.mMapControllView.setOnClickListener(new OnClickListener() {
                    public void onClick(View arg0) {
                        RouteGuideFSM.getInstance().run(FsmEvent.TOUCH_MAP);
                        if (RGMMControlPanelView.this.mSubViewListener != null) {
                            RGMMControlPanelView.this.mSubViewListener.onFocusMoreMenu();
                        }
                    }
                });
                this.mMapControllView.setOnFocusChangeListener(new OnFocusChangeListener() {
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus && RGMMControlPanelView.this.mSubViewListener != null) {
                            RGMMControlPanelView.this.mSubViewListener.onFocusMoreMenuGetFocus();
                        }
                    }
                });
            }
            updateDataByLastest();
            showManualOperateArea(false);
        }
    }

    public void showManualOperateArea(boolean show) {
        int showValue;
        int i = 0;
        RGControlPanelModel.getInstance().setNavState(show ? NavState.NAV_STATE_OPERATE : NavState.NAV_STATE_NAVING);
        if (show) {
            showValue = 0;
        } else {
            showValue = 8;
        }
        if (BNavConfig.pRGLocateMode == 2) {
            showValue = 8;
        }
        if (this.mRefreshRoadView != null) {
            LogUtil.m15791e(ModuleName.MAP, "mRefreshRoadView. BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() = " + BNRoutePlaner.getInstance().getEngineCalcRouteNetMode());
            if (showValue == 0 && NetworkUtils.isNetworkAvailable(this.mContext) && RGMultiRouteModel.getInstance().isEnable() && BNRouteGuider.getInstance().isCurDriveRouteOnline() && JNIGuidanceControl.getInstance().getViaCnt() == 0) {
                this.mRefreshRoadView.setVisibility(0);
            } else {
                this.mRefreshRoadView.setVisibility(8);
            }
        }
        if (this.mRouteSearch != null) {
            if (!NetworkUtils.isNetworkAvailable(this.mContext) || RGRouteSearchModel.getInstance().isRouteSearchMode()) {
                this.mRouteSearch.setVisibility(8);
            } else {
                this.mRouteSearch.setVisibility(showValue);
            }
        }
        if (this.mZoominIv != null) {
            this.mZoominIv.setVisibility(showValue);
        }
        if (this.mZoominOut != null) {
            this.mZoominOut.setVisibility(showValue);
        }
        if (this.mZoomLl != null) {
            this.mZoomLl.setVisibility(showValue);
        }
        if (this.mNavingSafeViewIv != null) {
            if (!CloudlConfigDataModel.getInstance().mCommonConfig.safetyNavingShow || BNavConfig.pRGLocateMode == 2 || show || RGViewController.getInstance().isShowEnlargeRoadMap()) {
                this.mNavingSafeViewIv.setVisibility(8);
            } else {
                this.mNavingSafeViewIv.setVisibility(0);
            }
        }
        if (this.mMapControllView != null) {
            View view = this.mMapControllView;
            if (show || !BNaviModuleManager.isFocusUIenable()) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public void updateDataByLastest() {
        if (!BNavigator.getInstance().hasCalcRouteOk()) {
            RGControlPanelModel.getInstance().updateLocateStatus(4);
        }
        switchAnologNaviControlState(!RGControlPanelModel.getInstance().isAnologPlaying());
        setTrafficStatus(BNSettingManager.isRoadCondOnOrOff());
    }

    public void updateZoomViewState() {
        int level = NMapControlProxy.getInstance().getZoomLevel();
        LogUtil.m15791e(ModuleName.MAP, "updateZoomButton. level = " + level);
        if (level <= 3) {
            zoomInEnabled(true);
            zoomOutEnabled(false);
        } else if (level >= 20) {
            zoomInEnabled(false);
            zoomOutEnabled(true);
        } else {
            zoomInEnabled(true);
            zoomOutEnabled(true);
        }
    }

    private void zoomInEnabled(boolean bEnable) {
        if (this.mZoominIv == null) {
            return;
        }
        if (bEnable) {
            this.mZoominIv.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.map_ic_home_enlarge));
        } else {
            this.mZoominIv.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.map_ic_home_enlarge_disable));
        }
    }

    private void zoomOutEnabled(boolean bEnable) {
        if (this.mZoominOut == null) {
            return;
        }
        if (bEnable) {
            this.mZoominOut.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.map_ic_home_narrow));
        } else {
            this.mZoominOut.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.map_ic_home_narrow_disable));
        }
    }

    public void showAnologNavi(boolean show) {
        int i = 0;
        if (this.mAnologControlRl != null) {
            this.mAnologControlRl.setVisibility(show ? 0 : 8);
        }
        if (this.mAnologQuit != null) {
            View view = this.mAnologQuit;
            if (!show) {
                i = 8;
            }
            view.setVisibility(i);
        }
        if (show && this.mControlPanelView != null) {
            LayoutParams lp = this.mControlPanelView.getLayoutParams();
            if (lp != null && (lp instanceof MarginLayoutParams)) {
                ((MarginLayoutParams) lp).bottomMargin = ScreenUtil.getInstance().dip2px(8);
            }
            this.mControlPanelView.setLayoutParams(lp);
        }
    }

    public void switchAnologNaviControlState(boolean showPlay) {
        if (showPlay) {
            if (this.mAnologControlIcon != null) {
                this.mAnologControlIcon.setImageDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.nsdk_drawable_anolog_play));
            }
        } else if (this.mAnologControlIcon != null) {
            this.mAnologControlIcon.setImageDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.nsdk_drawable_anolog_pause));
        }
    }

    public void show() {
        super.show();
        if (BNavConfig.pRGLocateMode == 2) {
            showAnologNavi(true);
        }
    }

    public void updateStyle(boolean day) {
        if (!getIsTrueCurDay(day)) {
            super.updateStyle(day);
            if (this.mZoominIv != null && this.mZoominOut != null && this.mRefreshRoadView != null && this.mAnologControlRl != null && this.mBridgeRoadView != null && this.mMainRoadView != null && this.mAnologControlIcon != null && this.mAnologQuit != null && this.mZoomLl != null && this.mZoomDivider != null && this.mRouteSearch != null && this.mRouteSearchIv != null) {
                if (RGControlPanelModel.getInstance().isAnologPlaying()) {
                    if (this.mAnologControlIcon != null) {
                        this.mAnologControlIcon.setImageDrawable(getDrawable(C4048R.drawable.nsdk_drawable_anolog_pause));
                    }
                } else if (this.mAnologControlIcon != null) {
                    this.mAnologControlIcon.setImageDrawable(getDrawable(C4048R.drawable.nsdk_drawable_anolog_play));
                }
                this.mAnologControlRl.setBackgroundDrawable(getDrawable(C4048R.drawable.bnav_common_cp_button_selector));
                this.mAnologQuit.setBackgroundDrawable(getDrawable(C4048R.drawable.bnav_common_cp_button_selector));
                this.mRefreshRoadLinear.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.map_bg_selector));
                this.mMapControllIv.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.map_bg_btn_selector));
                this.mZoominIv.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.common_btn_bg_zoom_in_selector));
                this.mZoominOut.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.common_btn_bg_zoom_out_selector));
                this.mZoomLl.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.map_bg_btn));
                this.mZoomDivider.setBackgroundColor(BNStyleManager.getDayStyle() ? 14277081 : -13814976);
                this.mRouteSearchIv.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.map_bg_btn_selector));
                this.mRefreshRoadIv.setImageDrawable(getDrawable(C4048R.drawable.nsdk_drawable_common_ic_avoid_traffic_refresh));
                setTrafficStatus(BNSettingManager.isRoadCondOnOrOff());
                this.mRefreshRoadTv.setTextColor(getColor(C4048R.color.cl_text_h));
            }
        }
    }

    private boolean getIsTrueCurDay(boolean day) {
        if (this.mRefreshRoadTv != null) {
            int color = this.mRefreshRoadTv.getCurrentTextColor();
            if (JarUtils.getResources() != null) {
                boolean z;
                if (color == JarUtils.getResources().getColor(C4048R.color.cl_text_h)) {
                    z = true;
                } else {
                    z = false;
                }
                this.mIsCurDay = z;
            }
        }
        if (day == this.mIsCurDay) {
            return true;
        }
        return false;
    }

    public void hide() {
        super.hide();
        showAnologNavi(false);
        showManualOperateArea(false);
    }

    public void setTrafficStatus(boolean on) {
    }

    public void removeCancelSwitch() {
        this.mHandler.removeCallbacks(this.mCancelSwitch);
    }

    private void setVoiceSpeakSetting(int settingType, int value) {
        if (this.mSubViewListener != null) {
            this.mSubViewListener.onOtherAction(6, settingType, value, null);
        }
    }

    public void disMissSDKUI() {
    }

    public void updateNaviStatus() {
        if (BNSettingManager.isRoadCondOnOrOff()) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_2, "", null, null);
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                this.mSubViewListener.onITSAction(true);
            }
            setTrafficStatus(BNSettingManager.isRoadCondOnOrOff());
        }
    }

    public void refreshRedGuide() {
        if (BNSettingManager.getFirstVoiceGuide() && BNSettingManager.getFirstMoreMenuGuide()) {
            BNSettingManager.setFristMenuGuide(true);
            this.mMenuRedGuide.setVisibility(8);
            return;
        }
        this.mMenuRedGuide.setVisibility(0);
    }

    public void setRefreshButtonEnable(boolean enable) {
        if (enable) {
            this.mRefreshRoadIv.setAlpha(1.0f);
            this.mRefreshRoadTv.setAlpha(1.0f);
            this.mRefreshRoadView.setEnabled(true);
            return;
        }
        this.mRefreshRoadIv.setAlpha(0.5f);
        this.mRefreshRoadTv.setAlpha(0.5f);
        this.mRefreshRoadView.setEnabled(false);
    }

    public void dispose() {
        if (this.mNavingSafeViewIv != null) {
            UIUtils.releaseImageView(this.mNavingSafeViewIv);
        }
        UrlDrawableContainForNav.recycleBitmap();
        super.dispose();
    }

    public void moveUpBottomButton(boolean isMoveUp) {
        if (this.mControlPanelView != null) {
            int defaultBottomMargin;
            if (BNavConfig.pRGLocateMode == 2) {
                defaultBottomMargin = ScreenUtil.getInstance().dip2px(8);
            } else {
                defaultBottomMargin = JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_control_panel_bottom_margin);
            }
            LayoutParams lp = this.mControlPanelView.getLayoutParams();
            if (lp != null && (lp instanceof MarginLayoutParams)) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) lp;
                if (isMoveUp) {
                    defaultBottomMargin += JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_operable_notify_height);
                }
                marginLayoutParams.bottomMargin = defaultBottomMargin;
            }
            this.mControlPanelView.setLayoutParams(lp);
        }
    }
}
