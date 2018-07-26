package com.baidu.navisdk.ui.routeguide.subview.hud;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.HUDInfo;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.RGBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGHUDControlView extends RGBaseView {
    private static final String TAG = "HUD";
    private RGHUDDialog mHudDialog = null;
    private boolean mIsStraight = false;
    private ImageView trigger;

    public RGHUDControlView(Activity activity, View view, boolean isMirror) {
        if (view != null) {
        }
        if (this.mHudDialog == null) {
            this.mHudDialog = new RGHUDDialog(activity, 16973833, isMirror);
            updateLatestData();
            this.mHudDialog.setOnDismissListener(new RGHUDControlView$1(this));
        }
    }

    public void onOrientationChanged() {
        if (this.mHudDialog != null) {
            this.mHudDialog.onOrientationChanged();
            if (RGHUDDataModel.getInstance().isYaw()) {
                showSuitableView();
            } else {
                updateLatestData();
            }
        }
    }

    public void setMirrorFlagBeforeShow(boolean isMirror) {
        this.mHudDialog.setMirrorFlagBeforeShow(isMirror);
    }

    public void show() {
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_HUD, NaviStatConstants.NAVIGATION_HUD);
        this.mHudDialog.show();
        updateLatestData();
        LogUtil.e("HUD", "mHudDialog isShowing: " + this.mHudDialog.isShowing());
        BNMapController.getInstance().onPause();
        XDVoiceInstructManager.getInstance().closePanel();
        XDVoiceInstructManager.getInstance().setWakeupEnable(false);
    }

    public void hide() {
        if (this.mHudDialog != null && this.mHudDialog.isShowing()) {
            try {
                this.mHudDialog.hide();
                BNMapController.getInstance().onResume();
            } catch (Exception e) {
            }
            XDVoiceInstructManager.getInstance().setWakeupEnable(true);
        }
    }

    public void dismiss() {
        if (this.mHudDialog != null && this.mHudDialog.isShowing()) {
            try {
                this.mHudDialog.dismiss();
                BNMapController.getInstance().onResume();
            } catch (Exception e) {
            }
        }
    }

    public void updateLatestData() {
        int updateType = RGHUDDataModel.latestUpdateType;
        if (updateType != -1) {
            switch (updateType) {
                case 1:
                    updateData(RGHUDDataModel.getInstance().simpleGuideToHUD(RGSimpleGuideModel.getInstance().getNextGuideInfo()));
                    break;
                case 2:
                    updateData(RGHUDDataModel.getInstance().highWayDataToHUD(RGHighwayModel.getInstance().getNewHighWayData()));
                    break;
            }
            updateCurrentCarSpeed();
            updateTotalRemainInfo();
            showSuitableView();
        }
    }

    public void restoreHighWayData(Bundle b) {
        int exitDirection = b.getInt(HUDInfo.ExitDirection);
        if (RGHighwayModel.getInstance().isTurnIconTypeValid(exitDirection)) {
            this.mHudDialog.setHighWayTurnIcon(exitDirection);
        }
        int exitRemainDistance = b.getInt(HUDInfo.EixtRemainDistance);
        if (exitRemainDistance >= 0) {
            this.mHudDialog.setHighWayRemainDistance(RGSimpleGuideModel.getInstance().getFormatAfterMeters(exitRemainDistance));
        }
        String exitIcCode = b.getString(HUDInfo.ExitICode);
        if (StringUtils.isEmpty(exitIcCode)) {
            RGHUDDataModel.getInstance().setHasExitCode(false);
        } else {
            RGHUDDataModel.getInstance().setHasExitCode(true);
            this.mHudDialog.setHighWayExitCode(exitIcCode);
        }
        String exitDirections = b.getString(HUDInfo.ExitDirectionName);
        if (StringUtils.isEmpty(exitDirections)) {
            String exitRoad = b.getString(HUDInfo.ExitNextRoad);
            if (!StringUtils.isEmpty(exitRoad)) {
                this.mHudDialog.setHighWayExitRoad(exitRoad);
                return;
            }
            return;
        }
        String[] dirctionsArray = exitDirections.split(",");
        StringBuffer directionsBuffer = new StringBuffer();
        for (String append : dirctionsArray) {
            directionsBuffer.append(" ");
            directionsBuffer.append(append);
        }
        this.mHudDialog.setHighWayExitRoad(directionsBuffer.toString());
    }

    public void updateData(Bundle b) {
        if (b != null) {
            restoreData(b);
        }
    }

    public void restoreData(Bundle b) {
        if (b != null) {
            if (b.getInt(HUDInfo.UpdateType, -1) == 2) {
                restoreHighWayData(b);
                return;
            }
            int resId = b.getInt(HUDInfo.ResId, -1);
            if (-1 != resId) {
                LogUtil.e("HUD", "setTurnIcon ===> " + resId);
                this.mHudDialog.setTurnIcon(resId);
            }
            String distance = RGSimpleGuideModel.getInstance().getFormatAfterMeters(b.getInt(HUDInfo.RemainDist, -1));
            if (distance == null) {
                Bundle simpleGuideData = new Bundle();
                BNRouteGuider.getInstance().getSimpleMapInfo(simpleGuideData);
                if (TextUtils.isEmpty(distance) && simpleGuideData.containsKey(SimpleGuideInfo.RemainDist)) {
                    int remainDist = simpleGuideData.getInt(SimpleGuideInfo.RemainDist);
                    StringBuffer buffer = new StringBuffer();
                    StringUtils.formatDistance(remainDist, UnitLangEnum.ZH, buffer);
                    if (buffer != null) {
                        distance = buffer.toString();
                    }
                }
            }
            if (distance != null) {
                LogUtil.e("HUD", "setRemainDistance ===> " + distance);
                this.mHudDialog.setNormalGoMeters(distance);
            }
            String roadName = b.getString(HUDInfo.NextRoad);
            if (roadName == null || roadName.length() == 0) {
                roadName = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_no_name_road);
            }
            LogUtil.e("HUD", "setDirectRoadName ===> " + roadName);
            this.mHudDialog.setRoadName(roadName);
            String direction = b.getString(HUDInfo.Direction);
            if (direction != null) {
                LogUtil.e("HUD", "setDirection ===> " + direction);
                this.mHudDialog.setDirection(direction);
            }
            boolean isSimpleGuideAlong = b.getBoolean(HUDInfo.Straight);
            RGHUDDataModel.getInstance().setSimpleGuideAlong(isSimpleGuideAlong);
            if (isSimpleGuideAlong) {
                if (distance != null) {
                    this.mHudDialog.setDirectRemainDistance(distance);
                }
                String directRoadName = b.getString(HUDInfo.CurrentRoad);
                if (directRoadName != null) {
                    this.mHudDialog.setDirectRoadName(directRoadName);
                }
            }
            showSuitableView();
        }
    }

    public void updateTotalRemainInfo() {
        this.mHudDialog.updateTotalRemainInfo();
    }

    public void updateCurrentCarSpeed() {
        this.mHudDialog.updateCurrentCarSpeed();
    }

    public void updateHudYaw(boolean isYaw) {
        this.mHudDialog.updateHudYaw(isYaw);
    }

    public void showSuitableView() {
        try {
            if (BNavConfig.pRGLocateMode == 1 || BNavConfig.pRGLocateMode == 5) {
                this.mHudDialog.updateHudLocate(false);
            }
            if (RGHUDDataModel.getInstance().isYaw()) {
                this.mHudDialog.updateHudYaw(true);
                return;
            }
            this.mHudDialog.updateHudYaw(false);
            if (RGHUDDataModel.isHighWayModel()) {
                if (RGHUDDataModel.getInstance().isHasExitCode()) {
                    showDirectRoadInfoView(false);
                    showNormalRoadInfoView(false);
                    this.mHudDialog.justSetHighWayVisibility(true);
                    this.mHudDialog.updateHighWayAlongVisibility(true);
                    return;
                }
                showDirectRoadInfoView(false);
                showNormalRoadInfoView(false);
                this.mHudDialog.justSetHighWayVisibility(true);
                this.mHudDialog.updateHighWayAlongVisibility(false);
            } else if (RGHUDDataModel.getInstance().isSimpleGuideAlong()) {
                showDirectRoadInfoView(true);
                showNormalRoadInfoView(false);
                this.mHudDialog.justSetHighWayVisibility(false);
            } else {
                showDirectRoadInfoView(false);
                showNormalRoadInfoView(true);
                this.mHudDialog.justSetHighWayVisibility(false);
            }
        } catch (Exception e) {
        }
    }

    public void showNormalRoadInfoView(boolean show) {
        this.mHudDialog.justSetNormalRoadInfoVisibility(show);
    }

    public void showDirectRoadInfoView(boolean show) {
        this.mHudDialog.justSetDirectRoadInfoVisibility(show);
    }

    @Deprecated
    public void destory() {
        this.mHudDialog = null;
        if (this.trigger != null) {
            this.trigger.setImageDrawable(null);
            this.trigger.setBackgroundDrawable(null);
            this.trigger = null;
        }
    }

    public boolean isVisibility() {
        return this.mHudDialog.isShowing();
    }

    public RGHUDDialog getHudWidget() {
        return this.mHudDialog;
    }
}
