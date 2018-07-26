package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.IItsClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.ILocationBtnClickListener;
import com.baidu.navisdk.ui.widget.BNZoomButtonViewSimple.OnZoomBtnClickListener;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SensorAlgoFilter;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;

public class BNMapControlPanelSimple implements OnClickListener {
    private static final int AUTO_HIDE_MAP_NETWORK = 1;
    private boolean isVisible = true;
    private BNMapObserver mBNMapObserver = new C45863();
    private Context mContext;
    private DistrictInfo mDistrict;
    private Handler mHandler = new Handler();
    private View mITSButtonView;
    private ImageView mITSImageView;
    private IItsClickListener mItsClickListener;
    private View mLeftLayout;
    private ProgressBar mLocProgressBar;
    private RelativeLayout mLocationBtn;
    private ILocationBtnClickListener mLocationBtnClickListener;
    private ImageView mLocationImg;
    private ImageView mMapNetStatusIcon;
    private MapNetworkHandler mMapNetworkHandler = new MapNetworkHandler();
    private View mRightLayout;
    private View mRootView;
    private BNScaleLevelView mScaleLevelView;
    private SensorAlgoFilter mSensorFilter = new SensorAlgoFilter();
    private BNZoomButtonViewSimple mZoomButtonView;
    private LinearLayout mZoomPanel;
    private boolean noNightStyle = false;

    /* renamed from: com.baidu.navisdk.ui.widget.BNMapControlPanelSimple$3 */
    class C45863 implements BNMapObserver {
        C45863() {
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            if (1 == type) {
                switch (event) {
                    case 258:
                        if (BNMapControlPanelSimple.this.mContext != null && NetworkUtils.isNetworkAvailable(BNMapControlPanelSimple.this.mContext)) {
                            BNMapControlPanelSimple.this.mMapNetStatusIcon.setVisibility(8);
                            BNMapControlPanelSimple.this.mMapNetworkHandler.removeMessages(1);
                            BNMapControlPanelSimple.this.mMapNetworkHandler.sendEmptyMessageDelayed(1, Config.BPLUS_DELAY_TIME);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private static class MapNetworkHandler extends Handler {
        private BNMapControlPanelSimple mPanel;

        private MapNetworkHandler(BNMapControlPanelSimple panel) {
            this.mPanel = panel;
        }

        public void handleMessage(Message msg) {
            this.mPanel.handleMessage(msg);
            super.handleMessage(msg);
        }
    }

    public BNMapControlPanelSimple(Context ctx, View viewGroup, boolean showTwoBtn) {
        this.mContext = ctx;
        this.mRootView = viewGroup.findViewById(C4048R.id.map_control_panel);
        if (this.mRootView != null) {
            this.mScaleLevelView = new BNScaleLevelView();
            this.mScaleLevelView.initView(this.mContext, this.mRootView);
            this.mLocationBtn = (RelativeLayout) this.mRootView.findViewById(C4048R.id.location_layout);
            this.mLocationBtn.setOnClickListener(this);
            this.mLocationImg = (ImageView) this.mRootView.findViewById(C4048R.id.location_btn);
            this.mLocProgressBar = (ProgressBar) this.mRootView.findViewById(C4048R.id.locProgress);
            this.mZoomButtonView = new BNZoomButtonViewSimple();
            this.mZoomButtonView.initView(this.mContext, this.mRootView, showTwoBtn);
            this.mITSButtonView = this.mRootView.findViewById(C4048R.id.layout_its_switch);
            this.mITSButtonView.setOnClickListener(this);
            this.mITSImageView = (ImageView) this.mRootView.findViewById(C4048R.id.image_its_switch);
            this.mMapNetStatusIcon = (ImageView) this.mRootView.findViewById(C4048R.id.btn_map_net_status);
            this.mMapNetStatusIcon.setVisibility(8);
            updateCompassLocation(this.mContext);
            this.mLeftLayout = this.mRootView.findViewById(C4048R.id.map_control_left_panel);
            this.mRightLayout = this.mRootView.findViewById(C4048R.id.map_control_right_panel);
            this.mZoomPanel = (LinearLayout) this.mRootView.findViewById(C4048R.id.nav_zoom_panel);
        }
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

    public void updateFullViewState(boolean isFullView) {
        LogUtil.m15791e("jzc", "onZoomFullViewBtnClick FullView=" + isFullView);
        this.mZoomButtonView.updateFullViewState(isFullView);
    }

    public boolean isFullView() {
        return this.mZoomButtonView.isFullView();
    }

    public void show() {
        this.mScaleLevelView.show();
        this.mLocationBtn.setVisibility(0);
        this.mZoomButtonView.show();
        this.mITSButtonView.setVisibility(0);
    }

    public void hide() {
        this.mScaleLevelView.hide();
        this.mLocationBtn.setVisibility(4);
        this.mZoomButtonView.hide();
        this.mITSButtonView.setVisibility(4);
        this.mMapNetStatusIcon.setVisibility(8);
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
            txt = (dist / 1000) + JarUtils.getResources().getString(C4048R.string.nsdk_string_mapcontrol_panel_kilometer);
        } else {
            txt = dist + JarUtils.getResources().getString(C4048R.string.nsdk_string_mapcontrol_panel_meter);
        }
        if (this.mScaleLevelView != null) {
            this.mScaleLevelView.updateScaleView(txt, pxLen);
        }
    }

    public void setZoomBtnMode(boolean showTwoBtn) {
        this.mZoomButtonView.setTwoBtnMode(showTwoBtn);
    }

    private void updateZoomButton() {
        if (this.mZoomButtonView != null) {
            this.mZoomButtonView.setNoNightStyle(this.noNightStyle);
            int level = BNMapController.getInstance().getZoomLevel();
            LogUtil.m15791e(ModuleName.MAP, "updateZoomButton. level = " + level);
            if (level <= 3) {
                this.mZoomButtonView.updateZoomBtn(true, false);
            } else if (level >= 20) {
                this.mZoomButtonView.updateZoomBtn(false, true);
            } else {
                this.mZoomButtonView.updateZoomBtn(true, true);
            }
        }
    }

    public void handleLocationBtnClick() {
        if (this.mLocationBtnClickListener != null) {
            this.mLocationBtnClickListener.onClick(MainMapModel.getInstance().getCurLocMode());
        }
        if (RouteGuideParams.getRouteGuideMode() != 2) {
            changeLocationMode(-1);
            updateFullViewState(false);
        }
    }

    private void changeLocationMode(int mode) {
        MainMapModel.getInstance().mFirstAutoLocMode = mode;
        if (mode != MainMapModel.getInstance().getCurLocMode()) {
            if (BNLocationManagerProxy.getInstance().isLocationValid()) {
                int lastMode = MainMapModel.getInstance().getCurLocMode();
                int locMode = MainMapModel.getInstance().setLocMode(mode);
                updateLocationBtn();
                LocData locData = BNLocationManagerProxy.getInstance().getCurLocation();
                final MapStatus st;
                Bundle b;
                if (locMode == 1) {
                    st = BNMapController.getInstance().getMapStatus();
                    if (st != null) {
                        b = CoordinateTransformUtil.LL2MC(locData.longitude, locData.latitude);
                        if (b != null) {
                            st._CenterPtX = b.getInt("MCx");
                            st._CenterPtY = b.getInt("MCy");
                            if (st._Level < 14.0f) {
                                st._Level = 14.0f;
                            }
                            if (lastMode == 2) {
                                st._Overlooking = 0;
                                st._Rotation = 0;
                            }
                            st._Level = -1.0f;
                            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>(getClass().getSimpleName(), null) {
                                protected String execute() {
                                    BNMapController.getInstance().setMapStatus(st, AnimationType.eAnimationAll);
                                    return null;
                                }
                            }, new BNWorkerConfig(100, 0));
                            if (this.mLocProgressBar.getVisibility() == 0) {
                                this.mLocProgressBar.setVisibility(8);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } else if (locMode == 2) {
                    st = BNMapController.getInstance().getMapStatus();
                    if (st != null) {
                        b = CoordinateTransformUtil.LL2MC(locData.longitude, locData.latitude);
                        st._CenterPtX = b.getInt("MCx");
                        st._CenterPtY = b.getInt("MCy");
                        st._Overlooking = -45;
                        if (locData.speed > 10.0f) {
                            st._Rotation = (int) locData.direction;
                        } else {
                            st._Rotation = (int) MainMapModel.getInstance().mAngleX;
                        }
                        st._Level = -1.0f;
                        BNMapController.getInstance().setMapStatus(st, AnimationType.eAnimationAll);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            MainMapModel.getInstance().setLocMode(0);
            TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_mapcontrol_panel_locate_begin));
            this.mLocationImg.setImageDrawable(null);
            this.mLocProgressBar.setVisibility(0);
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>(getClass().getSimpleName(), null) {
                protected String execute() {
                    BNMapControlPanelSimple.this.updateLocationTip();
                    return null;
                }
            }, new BNWorkerConfig(100, 0), 15000);
        }
    }

    public void updateLocationBtn() {
        switch (MainMapModel.getInstance().getCurLocMode()) {
            case 0:
                if (this.noNightStyle) {
                    this.mLocationImg.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_locate_car_point));
                    return;
                } else {
                    this.mLocationImg.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_locate_car_point));
                    return;
                }
            case 1:
                if (this.noNightStyle) {
                    this.mLocationImg.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_ic_locate_car));
                    return;
                } else {
                    this.mLocationImg.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_locate_car));
                    return;
                }
            case 2:
                if (this.noNightStyle) {
                    this.mLocationImg.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_ic_mapview_car_3d));
                    return;
                } else {
                    this.mLocationImg.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_mapview_car_3d));
                    return;
                }
            default:
                return;
        }
    }

    public void setZoomBtnClickListener(OnZoomBtnClickListener listener) {
        this.mZoomButtonView.setZoomBtnClickListener(listener);
    }

    public void setItsClickListener(IItsClickListener mListener) {
        this.mItsClickListener = mListener;
    }

    public void setLocationBtnClickListener(ILocationBtnClickListener listener) {
        this.mLocationBtnClickListener = listener;
    }

    public void notifyItsClicked() {
        if (this.mItsClickListener != null) {
            this.mItsClickListener.onClickIts();
            updateItsBtn();
        }
    }

    private void handleMessage(Message msg) {
        switch (msg.what) {
            case 1:
                this.mMapNetStatusIcon.setVisibility(8);
                return;
            default:
                return;
        }
    }

    private void updateLocationTip() {
        this.mLocProgressBar.setVisibility(8);
        TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_mapcontrol_panel_locate_failed));
        MainMapModel.getInstance().setLocMode(0);
    }

    public void handleScrollGesture() {
        resetLocMode();
        updateFullViewState(false);
    }

    public void handleSingleTouchGesture() {
        resetLocMode();
        updateFullViewState(false);
    }

    public void resetLocMode() {
        if (this.mLocProgressBar != null && this.mLocProgressBar.getVisibility() != 0) {
            MainMapModel.getInstance().setLocMode(0);
        }
    }

    private void updateLocOverlay(LocData locData, boolean forceUpdate) {
        LocationCallback.setData(locData.toLocationOverlayJsonString(true));
        if (forceUpdate) {
            BNMapController.getInstance().updateLayer(14);
        }
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == C4048R.id.location_layout) {
            handleLocationBtnClick();
        } else if (id == C4048R.id.layout_its_switch) {
            notifyItsClicked();
        }
    }

    public void updateCompassLocation(Context context) {
    }

    public void onResume() {
        initItsLayout();
        updateItsBtn();
        BNMapController.getInstance().addObserver(this.mBNMapObserver);
    }

    public void onPause() {
        BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
    }

    private void initItsLayout() {
        GeoPoint screenCenter = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getWidthPixels() / 2, ScreenUtil.getInstance().getHeightPixels() / 2);
        if (screenCenter != null && BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            this.mDistrict = BNPoiSearcher.getInstance().getDistrictByPoint(screenCenter, 0);
        }
        if (!BNSettingManager.isRoadCondOnOrOff()) {
            BNMapController.getInstance().showTrafficMap(false);
            BNSettingManager.setRoadCondOnOff(false);
        } else if (!PreferenceHelper.getInstance(this.mContext).getBoolean(Key.NAVI_REAL_HISTORY_ITS, true)) {
        } else {
            if (NetworkUtils.isNetworkAvailable(this.mContext)) {
                BNMapController.getInstance().switchITSMode(true);
                BNMapController.getInstance().showTrafficMap(true);
                BNSettingManager.setRoadCondOnOff(true);
                if (this.mDistrict != null && !BNMapController.getInstance().checkRoadConditionSupport(this.mDistrict.mId)) {
                    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_its_online_missing_data));
                    return;
                }
                return;
            }
            BNSettingManager.setRoadCondOnOff(false);
        }
    }

    private void updateItsBtn() {
        if (BNSettingManager.isRoadCondOnOrOff()) {
            if (RouteGuideParams.getRouteGuideMode() == 2) {
                this.mITSImageView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_ipo_road_condition_on));
            } else {
                this.mITSImageView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_rg_ic_lights_on));
            }
        } else if (RouteGuideParams.getRouteGuideMode() == 2) {
            this.mITSImageView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_ipo_road_condition_off));
        } else {
            this.mITSImageView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_rg_ic_lights_off));
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        LogUtil.m15791e("StyleDebug", "MapControlPanel dayStyle = " + dayStyle);
        if (this.mZoomButtonView != null && this.mLocationBtn != null && this.mITSButtonView != null && this.mMapNetStatusIcon != null) {
            this.mZoomButtonView.onUpdateStyle(dayStyle);
            if (RouteGuideParams.getRouteGuideMode() != 2) {
                this.mZoomPanel.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_cp_button_selector));
                this.mITSButtonView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_cp_button_selector));
                this.mLocationBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_cp_button_selector));
            }
            updateItsBtn();
            this.mMapNetStatusIcon.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_map_networking));
            this.mScaleLevelView.onUpdateStyle(dayStyle);
        }
    }

    public BNZoomButtonViewSimple getZoomButtonView() {
        return this.mZoomButtonView;
    }

    public void setVisible(boolean visible) {
        Animation animationLeft;
        Animation animationRight;
        int i = 0;
        if (visible) {
            animationLeft = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_LEFT_IN, 0, 300);
            animationRight = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_RIGHT_IN, 0, 300);
        } else {
            animationLeft = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_LEFT_OUT, 0, 300);
            animationRight = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_RIGHT_OUT, 0, 300);
        }
        this.mLeftLayout.startAnimation(animationLeft);
        this.mRightLayout.startAnimation(animationRight);
        this.isVisible = visible;
        if (visible) {
            this.mLeftLayout.setVisibility(0);
        } else {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("setVisible-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNMapControlPanelSimple.this.mLeftLayout.setVisibility(8);
                    return null;
                }
            }, new BNWorkerConfig(2, 0), 200);
        }
        View view = this.mRightLayout;
        if (!this.isVisible) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public boolean isNoNightStyle() {
        return this.noNightStyle;
    }

    public void setNoNightStyle(boolean noNightStyle) {
        this.noNightStyle = noNightStyle;
    }
}
