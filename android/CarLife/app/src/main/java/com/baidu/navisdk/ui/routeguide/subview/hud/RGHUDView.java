package com.baidu.navisdk.ui.routeguide.subview.hud;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.routeguide.subview.widget.CircleProgressImageView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGHUDView extends LinearLayout {
    private View gpsView;
    private boolean isMirror;
    private TextView mAlongDistance;
    private TextView mArrivingTime;
    private TextView mCarSpeed;
    private CircleProgressImageView mCarSpeedProgress;
    private TextView mDirectCurrentRoad;
    private RelativeLayout mDirectRoadLayout;
    private TextView mHighWayEnter;
    private TextView mHighWayExitCode;
    private TextView mHighWayGoTo;
    private TextView mHighWayGoWhere;
    private RelativeLayout mHighWayLayout;
    private TextView mHighWayLeftDistance;
    private TextView mHighWayLeftDistanceLable;
    private ImageView mHighWayTurnIcon;
    private RelativeLayout mHudLayout;
    private int mLastResId = -1;
    private RelativeLayout mLeftDistanceLayout;
    private CircleProgressImageView mLeftDistanceProgress;
    private TextView mLeftTotalDistance;
    private TextView mNormalCurrentRoad;
    private TextView mNormalGoMeters;
    private TextView mNormalGoMetersLable;
    private RelativeLayout mNormalLayout;
    private ImageView mNormalTurnIcon;
    private RelativeLayout mSpeedLayout;
    private int mTextSizeFirst = 42;
    private int mTextSizeSecond = 38;
    private ViewGroup mViewGroup;
    private RelativeLayout mYawLayout;
    private View uiView;

    public RGHUDView(Context context) {
        super(context);
        initView();
    }

    public RGHUDView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        if (this.mViewGroup != null) {
            this.mViewGroup.removeAllViews();
        }
        if (1 == RGViewController.getInstance().getOrientation()) {
            this.mViewGroup = (ViewGroup) JarUtils.inflate((Activity) getContext(), C4048R.layout.nsdk_layout_rg_hud_view, null);
        } else {
            this.mViewGroup = (ViewGroup) JarUtils.inflate((Activity) getContext(), C4048R.layout.nsdk_layout_rg_hud_view_land, null);
        }
        if (this.mViewGroup != null) {
            addView(this.mViewGroup, new LayoutParams(-1, -1));
            findView();
        }
    }

    public void findView() {
        this.mHudLayout = (RelativeLayout) this.mViewGroup.findViewById(C4048R.id.nav_hud_ui);
        this.mNormalLayout = (RelativeLayout) this.mViewGroup.findViewById(C4048R.id.rl_bnav_simle_not_along);
        this.mNormalTurnIcon = (ImageView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_sg_turn_icon);
        this.mNormalGoMeters = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_sg_after_meters_info);
        this.mNormalGoMetersLable = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_sg_after_label_info);
        this.mNormalCurrentRoad = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_sg_go_where_info);
        this.mDirectRoadLayout = (RelativeLayout) this.mViewGroup.findViewById(C4048R.id.bnav_rg_sg_along_road);
        this.mAlongDistance = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_sg_cur_road_remain_dist_tv);
        this.mDirectCurrentRoad = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_sg_cur_road_name_tv);
        this.mHighWayLayout = (RelativeLayout) this.mViewGroup.findViewById(C4048R.id.ll_bnav_hw);
        this.mHighWayTurnIcon = (ImageView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_hw_turn_icon);
        this.mHighWayLeftDistance = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_hw_after_meters_info);
        this.mHighWayExitCode = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_hw_ic_code);
        this.mHighWayGoTo = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_hw_go_to_word);
        this.mHighWayEnter = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_hw_enter_word);
        this.mHighWayGoWhere = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_hw_go_where_multi_tv);
        this.mHighWayLeftDistanceLable = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_hw_after_meters_lable);
        this.mCarSpeedProgress = (CircleProgressImageView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_cur_car_speed_progress);
        this.mLeftDistanceProgress = (CircleProgressImageView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_left_distance_progress);
        this.mCarSpeed = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_current_speed);
        this.mLeftTotalDistance = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_left_distance);
        this.mArrivingTime = (TextView) this.mViewGroup.findViewById(C4048R.id.bnav_rg_about_reach_time);
        if (getCurrentOrientation() == 2) {
            this.mSpeedLayout = (RelativeLayout) this.mViewGroup.findViewById(C4048R.id.rl_bnav_rg_hud_speed);
            this.mLeftDistanceLayout = (RelativeLayout) this.mViewGroup.findViewById(C4048R.id.rl_nsdk_rg_hud_left_distance);
        }
        this.mYawLayout = (RelativeLayout) this.mViewGroup.findViewById(C4048R.id.rl_bnav_rg_hud_yaw);
        this.gpsView = this.mViewGroup.findViewById(C4048R.id.nav_hud_gps_status);
        this.uiView = this.mViewGroup.findViewById(C4048R.id.nav_hud_ui);
    }

    private int getCurrentOrientation() {
        return RGViewController.getInstance().getOrientation();
    }

    public void setDirection(String dirction) {
    }

    public void setNormalTurnIcon(int resId) {
        if (RightHandResourcesProvider.getEnNaviType() == 0) {
            this.mNormalTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(resId));
        } else {
            this.mNormalTurnIcon.setImageDrawable(RightHandResourcesProvider.getDrawableIncludeRightHandIcon(resId));
        }
    }

    public void setNormalGoMeters(String goMeters) {
        if ("0米".equals(goMeters)) {
            this.mNormalGoMeters.setText("现在");
            this.mNormalGoMetersLable.setText("");
            return;
        }
        this.mNormalGoMeters.setText(goMeters);
        this.mNormalGoMetersLable.setText("后");
    }

    public void setHighWayExitCode(String exitCode) {
        if (!exitCode.equals(this.mHighWayExitCode.getText().toString())) {
            this.mHighWayExitCode.setText(exitCode);
        }
    }

    public void setHighWayTurnIcon(int resId) {
        if (resId != this.mLastResId) {
            this.mLastResId = resId;
            this.mHighWayTurnIcon.setImageDrawable(RGHighwayModel.getInstance().getTurnIconDrawable(resId, true));
        }
    }

    public void setNormalCurrentRoad(String currentRoad) {
        if (!currentRoad.equals(this.mNormalCurrentRoad.getText().toString())) {
            this.mNormalCurrentRoad.setText(currentRoad);
        }
    }

    public void setDirectDistance(String distance) {
        if (!distance.equals(this.mAlongDistance.getText().toString())) {
            this.mAlongDistance.setText(distance);
        }
    }

    public void setDirectCurrentRoad(String name) {
        if (!name.equals(this.mDirectCurrentRoad.getText().toString())) {
            this.mDirectCurrentRoad.setText(name);
        }
    }

    public void setHighWayRemainDistance(String distance) {
        if (!distance.equals(this.mHighWayLeftDistance)) {
            if ("0米".equals(distance)) {
                this.mHighWayLeftDistance.setText("现在");
                this.mHighWayLeftDistanceLable.setText("");
                return;
            }
            this.mHighWayLeftDistance.setText(distance);
            this.mHighWayLeftDistanceLable.setText("后");
        }
    }

    public void setHighWayExitRoad(String roads) {
        if (!roads.equals(this.mHighWayGoWhere.getText().toString())) {
            this.mHighWayGoWhere.setText(roads);
        }
    }

    public boolean isMirror() {
        return this.isMirror;
    }

    public void setMirror(boolean isMirror) {
        this.isMirror = isMirror;
    }

    public void updateHudYaw(boolean isYaw) {
        if (isYaw) {
            updateHudView(isYaw);
            this.mYawLayout.setVisibility(0);
            return;
        }
        updateHudView(isYaw);
        this.mYawLayout.setVisibility(8);
    }

    public void updateHudView(boolean show) {
        int visibility = !show ? 0 : 8;
        if (getCurrentOrientation() == 2) {
            this.mSpeedLayout.setVisibility(visibility);
            this.mLeftDistanceLayout.setVisibility(visibility);
        }
        this.mHudLayout.setVisibility(visibility);
    }

    public void updateNormalRoadInfoVisibility(boolean show) {
        this.mNormalLayout.setVisibility(show ? 0 : 8);
    }

    public void updateDirectRoadInfoVisibility(boolean show) {
        this.mDirectRoadLayout.setVisibility(show ? 0 : 8);
    }

    public void updateHighWayVisibility(boolean show) {
        this.mHighWayLayout.setVisibility(show ? 0 : 8);
    }

    public void updateHighWayAlongVisibility(boolean show) {
        this.mHighWayTurnIcon.setVisibility(0);
        this.mHighWayLeftDistance.setVisibility(0);
        this.mHighWayGoWhere.setVisibility(0);
        if (show) {
            this.mHighWayGoTo.setVisibility(8);
            this.mHighWayExitCode.setVisibility(0);
            this.mHighWayEnter.setVisibility(0);
            return;
        }
        this.mHighWayGoTo.setVisibility(0);
        this.mHighWayExitCode.setVisibility(8);
        this.mHighWayEnter.setVisibility(8);
    }

    public void updateCurrentCarSpeed() {
        if (this.mCarSpeed != null) {
            this.mCarSpeedProgress.setMainProgress(RGHUDDataModel.getProgress(RGAssistGuideModel.getInstance().getCurCarSpeedInt(), RGHUDDataModel.MAX_CAR_SPEED));
            this.mCarSpeedProgress.setSubProgress(RGHUDDataModel.MAX_CAR_SPEED);
            this.mCarSpeed.setText(RGAssistGuideModel.getInstance().getCurCarSpeed());
        }
    }

    public void updateTotalRemainInfo() {
        if (this.mArrivingTime != null) {
            String arriveString = RGSimpleGuideModel.getInstance().getArriveTimeString();
            this.mArrivingTime.setText(String.format(BNStyleManager.getString(C4048R.string.nsdk_string_hud_arrive_time), new Object[]{arriveString}));
        }
        if (this.mLeftTotalDistance != null) {
            int remainDistanceInt = RGSimpleGuideModel.getInstance().getTotalRemainDist();
            if (remainDistanceInt / 1000 >= 1000) {
                this.mLeftTotalDistance.setTextSize((float) this.mTextSizeSecond);
            } else {
                this.mLeftTotalDistance.setTextSize((float) this.mTextSizeFirst);
            }
            int progress = RGHUDDataModel.getProgress(remainDistanceInt, RGHUDDataModel.totalDistance);
            if (remainDistanceInt < 50) {
                this.mLeftDistanceProgress.setMainProgress(0);
            } else {
                this.mLeftDistanceProgress.setMainProgress(progress);
            }
            this.mLeftDistanceProgress.setSubProgress(100);
            this.mLeftTotalDistance.setText(RGHUDDataModel.getFormatDistance(remainDistanceInt));
        }
    }

    public void onOrientationChanged() {
        if (this.mViewGroup != null) {
            this.mViewGroup.removeAllViews();
        }
        if (getCurrentOrientation() == 1) {
            JarUtils.inflate((Activity) getContext(), C4048R.layout.nsdk_layout_rg_hud_view, this.mViewGroup);
            findView();
            return;
        }
        JarUtils.inflate((Activity) getContext(), C4048R.layout.nsdk_layout_rg_hud_view_land, this.mViewGroup);
        findView();
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.isMirror) {
            canvas.translate(0.0f, (float) getMeasuredHeight());
            canvas.scale(1.0f, -1.0f);
        }
        super.dispatchDraw(canvas);
    }

    public void lostGPSSignal() {
        this.gpsView.setVisibility(0);
        this.uiView.setVisibility(8);
    }

    public void gpsSignalRecover() {
        this.uiView.setVisibility(0);
        this.gpsView.setVisibility(8);
    }
}
