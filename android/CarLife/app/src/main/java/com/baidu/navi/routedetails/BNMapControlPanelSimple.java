package com.baidu.navi.routedetails;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.carlife.C0965R;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig.MapMode;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.ScaleLevelView;
import com.baidu.navi.view.ZoomButtonView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.IItsClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.ILocationBtnClickListener;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.util.C4835n;

public class BNMapControlPanelSimple implements OnClickListener {
    private static final int FIVEK_LEVEL = 12;
    private static final int H_LEVEL = 17;
    private static final int LOCATION_ACC_THRESHOLD = 1;
    private static final int LOCATION_ANG_THRESHOLD = 3;
    private static final int LOCATION_DIS_THRESHOLD = 1;
    private static final double MAX_WALK_SPEED = 2.0d;
    private static final double WAIT_SPEED_TIME = 30000.0d;
    private boolean isVisible = true;
    private PositionStatus lastPositionStatus;
    private int locAngle = 0;
    private long locTime = 0;
    private int mAngleX = Integer.MIN_VALUE;
    private Context mContext;
    private DistrictInfo mDistrict;
    private Handler mHandler = new Handler();
    private View mITSButtonView;
    private ImageView mITSImageView;
    private IItsClickListener mItsClickListener;
    private int mLastAngle = Integer.MIN_VALUE;
    private LocData mLastLoc;
    private View mLeftLayout;
    private ProgressBar mLocProgressBar;
    private RelativeLayout mLocationBtn;
    private ILocationBtnClickListener mLocationBtnClickListener;
    private ImageView mLocationImg;
    private MapGLSurfaceView mMapView;
    private MapViewConfig mMapViewConfig;
    private View mRightLayout;
    private View mRootView;
    private ScaleLevelView mScaleLevelView;
    private Thread mWaitingLocTimer = null;
    private ZoomButtonView mZoomButtonView;
    private LinearLayout mZoomPanel;
    private boolean noNightStyle = false;
    private boolean overlookAnimEnd = true;
    private long overlookAnimTime = 0;
    private long sensorTime = 0;

    /* renamed from: com.baidu.navi.routedetails.BNMapControlPanelSimple$2 */
    class C39422 implements Runnable {
        C39422() {
        }

        public void run() {
            BNMapControlPanelSimple.this.mLeftLayout.setVisibility(8);
        }
    }

    public BNMapControlPanelSimple(Context ctx, View viewGroup) {
        this.mContext = ctx;
        this.mRootView = viewGroup.findViewById(C0965R.id.map_control_panel);
        if (this.mRootView != null) {
            this.mMapViewConfig = MapViewConfig.getInstance();
            this.mMapViewConfig.setPositionStatus(PositionStatus.NORMAL);
            this.mMapView = MapViewFactory.getInstance().getMapView();
            this.mScaleLevelView = new ScaleLevelView();
            this.mScaleLevelView.initView(this.mContext, this.mRootView);
            this.mLocationBtn = (RelativeLayout) this.mRootView.findViewById(C0965R.id.location_layout);
            this.mLocationBtn.setOnClickListener(this);
            this.mLocationImg = (ImageView) this.mRootView.findViewById(C0965R.id.location_btn);
            this.mLocProgressBar = (ProgressBar) this.mRootView.findViewById(C0965R.id.locProgress);
            this.mZoomButtonView = new ZoomButtonView();
            this.mZoomButtonView.initView(this.mContext, this.mRootView, true);
            this.mITSButtonView = this.mRootView.findViewById(C0965R.id.layout_its_switch);
            this.mITSButtonView.setOnClickListener(this);
            this.mITSImageView = (ImageView) this.mRootView.findViewById(C0965R.id.image_its_switch);
            this.mLeftLayout = this.mRootView.findViewById(C0965R.id.map_control_left_panel);
            this.mRightLayout = this.mRootView.findViewById(C0965R.id.map_control_right_panel);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void updateView() {
        updateScale();
        onUpdateStyle(StyleManager.getDayStyle());
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

    private void updateZoomButton() {
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

    public void handleLocationBtnClick() {
        onLocationBtnClicked();
    }

    public void changeLocationMode(int mode) {
        MainMapModel.getInstance().mFirstAutoLocMode = mode;
        if (mode != MainMapModel.getInstance().getCurLocMode()) {
            if (BNLocationManagerProxy.getInstance().isLocationValid()) {
                int locMode = MainMapModel.getInstance().setLocMode(mode);
                updateLocationBtn();
                com.baidu.navisdk.model.datastruct.LocData locData = BNLocationManagerProxy.getInstance().getCurLocation();
                if (locMode == 1 && this.mLocProgressBar.getVisibility() == 0) {
                    this.mLocProgressBar.setVisibility(8);
                    return;
                }
                return;
            }
            MainMapModel.getInstance().setLocMode(0);
            this.mMapViewConfig.setPositionStatus(PositionStatus.NORMAL);
            TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_mapcontrol_panel_locate_begin));
            this.mLocationImg.setImageDrawable(null);
            this.mLocProgressBar.setVisibility(0);
            if (this.mWaitingLocTimer == null) {
                this.mWaitingLocTimer = new Thread(getClass().getSimpleName()) {
                    public void run() {
                        BNMapControlPanelSimple.this.updateLocationTip();
                    }
                };
            }
            this.mHandler.postDelayed(this.mWaitingLocTimer, 15000);
        }
    }

    public void updateLocationBtn() {
        switch (MainMapModel.getInstance().getCurLocMode()) {
            case 0:
                this.mLocationImg.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_backparking));
                return;
            case 1:
                this.mLocationImg.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_north));
                return;
            case 2:
                this.mLocationImg.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_orientation));
                return;
            default:
                return;
        }
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

    private void updateLocationTip() {
        this.mLocProgressBar.setVisibility(8);
        TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_mapcontrol_panel_locate_failed));
        this.mMapViewConfig.setPositionStatus(PositionStatus.NORMAL);
        MainMapModel.getInstance().setLocMode(0);
    }

    public void handleScrollGesture() {
        resetLocMode();
    }

    public void handleSingleTouchGesture() {
        resetLocMode();
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
        if (id == C0965R.id.location_layout) {
            handleLocationBtnClick();
        } else if (id == C0965R.id.layout_its_switch) {
            notifyItsClicked();
        }
    }

    public void onResume() {
        updateItsBtn();
    }

    public void onPause() {
    }

    public void updateItsBtn() {
        LogUtil.m15791e("updateItsBtn", "updateItsBtn mIsItsOpen = " + BNSettingManager.isRoadCondOnOrOff());
        if (BNSettingManager.isRoadCondOnOrOff()) {
            this.mITSImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_com_traffic_on));
        } else {
            this.mITSImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_com_traffic_off));
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        LogUtil.m15791e("StyleDebug", "MapControlPanel dayStyle = " + dayStyle);
        if (this.mZoomButtonView != null && this.mLocationImg != null && this.mScaleLevelView != null && this.mITSImageView != null) {
            this.mZoomButtonView.onUpdateStyle(dayStyle);
            this.mScaleLevelView.onUpdateStyle(dayStyle);
            this.mLocationImg.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector));
            this.mITSImageView.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector));
            updateItsBtn();
            updateLocationBtn();
        }
    }

    public void setVisible(boolean visible) {
        Animation animationLeft;
        Animation animationRight;
        int i = 0;
        if (visible) {
            animationLeft = AnimationUtil.getAnimation(AnimationType.ANIM_LEFT_IN, 0, 300);
            animationRight = AnimationUtil.getAnimation(AnimationType.ANIM_RIGHT_IN, 0, 300);
        } else {
            animationLeft = AnimationUtil.getAnimation(AnimationType.ANIM_LEFT_OUT, 0, 300);
            animationRight = AnimationUtil.getAnimation(AnimationType.ANIM_RIGHT_OUT, 0, 300);
        }
        this.mLeftLayout.startAnimation(animationLeft);
        this.mRightLayout.startAnimation(animationRight);
        this.isVisible = visible;
        if (visible) {
            this.mLeftLayout.setVisibility(0);
        } else {
            new Handler().postDelayed(new C39422(), 200);
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

    public View getLocationBtn() {
        return this.mLocationBtn;
    }

    public View getITSButtonView() {
        return this.mITSButtonView;
    }

    public View getZoomInBtnView() {
        if (this.mZoomButtonView != null) {
            return this.mZoomButtonView.getZoomInBtnView();
        }
        return null;
    }

    public View getZoomOutBtnView() {
        if (this.mZoomButtonView != null) {
            return this.mZoomButtonView.getZoomOutBtnView();
        }
        return null;
    }

    public ZoomButtonView getZoomButtonView() {
        return this.mZoomButtonView;
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
                    if (((double) speed) > MAX_WALK_SPEED) {
                        this.locAngle = (int) direction;
                        this.locTime = System.currentTimeMillis();
                        st.rotation = this.locAngle;
                    } else {
                        if (((double) (System.currentTimeMillis() - this.locTime)) <= WAIT_SPEED_TIME) {
                            iAngleX = this.locAngle;
                        }
                        st.rotation = iAngleX;
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
