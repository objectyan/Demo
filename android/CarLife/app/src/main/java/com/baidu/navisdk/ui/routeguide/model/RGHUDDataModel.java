package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.HUDInfo;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.HighWayInfo;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Locale;

public class RGHUDDataModel {
    public static final int DEFAULT_UPDATE_TYPE = -1;
    private static final int[] DIRECTION_RES_ARRAY = new int[]{C4048R.string.nsdk_string_rg_nav_direction_north, C4048R.string.nsdk_string_rg_nav_direction_northeast, C4048R.string.nsdk_string_rg_nav_direction_east, C4048R.string.nsdk_string_rg_nav_direction_southeast, C4048R.string.nsdk_string_rg_nav_direction_south, C4048R.string.nsdk_string_rg_nav_direction_southwest, C4048R.string.nsdk_string_rg_nav_direction_west, C4048R.string.nsdk_string_rg_nav_direction_northwest};
    public static final int HIGHWAY_UPDATE = 2;
    public static final int MAX_CAR_SPEED = 240;
    public static final int NORMAL_ROAD_UPDATE = 1;
    public static final String TAG = "RGHUDDataModel";
    private static boolean isHighWayModel = false;
    public static int latestUpdateType = -1;
    private static RGHUDDataModel mInstance = null;
    public static int totalDistance = 0;
    private boolean hasExitCode = false;
    private boolean isSimpleGuideAlong = false;
    private boolean mIsYaw = false;
    private Bundle mLastestHUDData = null;

    public static RGHUDDataModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGHUDDataModel();
        }
        return mInstance;
    }

    public boolean isHasExitCode() {
        return this.hasExitCode;
    }

    public void setHasExitCode(boolean hasExitCode) {
        this.hasExitCode = hasExitCode;
    }

    public boolean isSimpleGuideAlong() {
        return this.isSimpleGuideAlong;
    }

    public void setSimpleGuideAlong(boolean isSimpleGuideAlong) {
        this.isSimpleGuideAlong = isSimpleGuideAlong;
    }

    public boolean isYaw() {
        return this.mIsYaw;
    }

    public void setIsYaw(boolean isYaw) {
        this.mIsYaw = isYaw;
    }

    public static int getProgress(int part, int total) {
        if (total <= 0) {
            return 100;
        }
        if (part <= 0) {
            return 0;
        }
        if (part >= total) {
            return 100;
        }
        int progress = (part * 100) / total;
        if (progress == 0) {
            return 1;
        }
        return progress;
    }

    public static String getFormatDistance(int distance) {
        if (distance >= 1000) {
            return String.valueOf(distance / 1000);
        }
        if (distance < 50) {
            return String.valueOf(0);
        }
        if (distance >= 950) {
            return String.valueOf(1);
        }
        if ((distance + 100) % 100 >= 50) {
            distance += 50;
        }
        return String.format(Locale.getDefault(), "%.1f", new Object[]{Float.valueOf(((float) distance) / 1000.0f)});
    }

    public Bundle getData() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getHUDData(bundle);
        Bundle b = new Bundle();
        if (bundle != null) {
            int direction = bundle.getInt(HUDInfo.Direction);
            if (direction > -1 && direction < DIRECTION_RES_ARRAY.length) {
                b.putString(HUDInfo.Direction, JarUtils.getResources().getString(DIRECTION_RES_ARRAY[direction]));
            }
        }
        return b;
    }

    public static boolean isHighWayModel() {
        return isHighWayModel;
    }

    public static void setHighWayModel(boolean isHighWayModel) {
        isHighWayModel = isHighWayModel;
    }

    public Bundle simpleGuideToHUD(Bundle bundle) {
        LogUtil.m15791e(TAG, "simpleGuideToHUD");
        Bundle result = new Bundle();
        int remainDist = bundle.getInt(SimpleGuideInfo.RemainDist);
        if (remainDist >= 0) {
            LogUtil.m15791e(NaviStatConstants.K_NSC_KEY_HUDSDK, "containKey RemainDist");
            result.putInt(HUDInfo.RemainDist, remainDist);
        }
        if (bundle.containsKey("resid")) {
            LogUtil.m15791e(NaviStatConstants.K_NSC_KEY_HUDSDK, "containKey ResId");
            result.putInt(HUDInfo.ResId, simpleGuideResToHUDRes(bundle.getInt("resid")));
        }
        if (bundle.containsKey("road_name")) {
            LogUtil.m15791e(NaviStatConstants.K_NSC_KEY_HUDSDK, "containKey RoadName");
            result.putString(HUDInfo.NextRoad, bundle.getString("road_name"));
        }
        result.putString(HUDInfo.Direction, getInstance().getData().getString(HUDInfo.Direction));
        if (bundle.containsKey(SimpleGuideInfo.CurRoadName)) {
            LogUtil.m15791e(NaviStatConstants.K_NSC_KEY_HUDSDK, "containKey CurRoadName");
            result.putString(HUDInfo.CurrentRoad, bundle.getString(SimpleGuideInfo.CurRoadName));
        }
        if (bundle.containsKey("straight")) {
            LogUtil.m15791e(NaviStatConstants.K_NSC_KEY_HUDSDK, "containKey Straight");
            result.putBoolean(HUDInfo.Straight, bundle.getBoolean("straight"));
        }
        result.putInt(HUDInfo.UpdateType, 1);
        latestUpdateType = 1;
        return result;
    }

    public Bundle highWayDataToHUD(Bundle bundle) {
        LogUtil.m15791e(TAG, "highWayDataToHUD");
        Bundle result = new Bundle();
        int exitDirection = bundle.getInt(HighWayInfo.ExitDirection, -1);
        if (exitDirection != -1) {
            result.putInt(HUDInfo.ExitDirection, exitDirection);
        }
        int distance = bundle.getInt(HighWayInfo.ExitRemainDist);
        if (distance >= 0) {
            LogUtil.m15791e(NaviStatConstants.K_NSC_KEY_HUDSDK, "containKey ExitRemainDist");
            result.putInt(HUDInfo.EixtRemainDistance, distance);
        }
        String exitRoad = bundle.getString(HighWayInfo.ExitNextRoadName);
        if (exitRoad != null) {
            LogUtil.m15791e(NaviStatConstants.K_NSC_KEY_HUDSDK, "containKey ExitNextRoad");
            result.putString(HUDInfo.ExitNextRoad, exitRoad);
        }
        String exitIcCode = bundle.getString(HighWayInfo.ExitICCode);
        if (!StringUtils.isEmpty(exitIcCode)) {
            result.putString(HUDInfo.ExitICode, exitIcCode);
        }
        String exitDirections = bundle.getString(HighWayInfo.ExitDirectionName);
        if (!StringUtils.isEmpty(exitDirections)) {
            LogUtil.m15791e(NaviStatConstants.K_NSC_KEY_HUDSDK, "containKey ExitDirectionName");
            result.putString(HUDInfo.ExitDirectionName, exitDirections);
        }
        result.putBoolean(HUDInfo.HighAlong, bundle.getBoolean(HighWayInfo.HideInfo));
        result.putInt(HUDInfo.UpdateType, 2);
        latestUpdateType = 2;
        return result;
    }

    private int simpleGuideResToHUDRes(int resId) {
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_back) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_back;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_branch_center) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_branch_center;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_branch_left) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_branch_left;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_branch_right) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_branch_right;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_dest) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_dest;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_front) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_front;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left_back) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left_back;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left_front) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_front;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left_side) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left_side;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left_side_ic) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left_side_ic;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left_side_main) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left_side_main;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right_side) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_side;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right_back) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_back;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right_front) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_front;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right_side_ic) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_side_ic;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right_side_main) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_side_main;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_branch_left_straight) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_branch_left_straight;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_branch_right_straight) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_branch_right_straight;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_tollgate) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_tollgate;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left_2branch_left) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left_2branch_left;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left_2branch_right) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left_2branch_right;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left_3branch_left) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left_3branch_left;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left_3branch_middle) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left_3branch_middle;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_left_3branch_right) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left_3branch_right;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right_2branch_left) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_2branch_left;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right_2branch_right) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_2branch_right;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right_3branch_left) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_3branch_left;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right_3branch_middle) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_3branch_middle;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_right_3branch_right) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_3branch_right;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_front_2branch_left) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_left_side;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_front_2branch_right) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_right_side;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_front_3branch_left) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_branch_left;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_front_3branch_middle) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_branch_center;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_front_3branch_right) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_branch_right;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_lf_2branch_left) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_lf_2branch_left;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_lf_2branch_right) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_lf_2branch_right;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_rf_2branch_left) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_rf_2branch_left;
        }
        if (resId == C4048R.drawable.nsdk_drawable_rg_ic_turn_rf_2branch_right) {
            return C4048R.drawable.nsdk_drawable_rg_hud_turn_rf_2branch_right;
        }
        return resId;
    }
}
