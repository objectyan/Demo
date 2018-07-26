package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.HighWayInfo;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGHighwayModel {
    public static final int PANER_MODEL_DEFAULT = 0;
    public static final int PANER_MODEL_MINI = 1;
    private static final String TAG = "RGHighwayModel";
    public static final int TYPE_SIMPLE_BOARD_ENTRY = 0;
    public static final int TYPE_SIMPLE_BOARD_EXIT = 4;
    public static final int TYPE_SIMPLE_BOARD_EXIT_FASTWAY = 5;
    public static final int TYPE_SIMPLE_BOARD_GATE = 1;
    public static final int TYPE_SIMPLE_BOARD_SERVICE = 2;
    public static final int TYPE_SIMPLE_BOARD_SERVICE2 = 3;
    private static RGHighwayModel mInstance = null;
    private String curRoadName = null;
    private String entryName = null;
    private int entryRemainDist = -1;
    private String exitCode = null;
    private String[] exitDirections = null;
    private String exitFastwayId = null;
    private String exitFastwayName = null;
    private int exitFastwayRemainDist = -1;
    private String exitName = null;
    private String exitNextRoadName = null;
    private int exitRemainDist = -1;
    private int exitTotalDist = -1;
    private int exitTurnIconType = -1;
    private String gateName = "";
    private int gateRemainDist = -1;
    private int gateTotalDist = -1;
    private boolean isShowHighwayAlongInfo = true;
    private boolean mAutoShowMiniPanerAble = true;
    private int mCurrentPanerMode = 0;
    private int mDriveDistance;
    private boolean mIsExists = false;
    private boolean mMiniPanerDisplayable = false;
    private Bundle mNewHighWayData = new Bundle();
    private String[] nextExitDirections = null;
    private String nextExitName = null;
    private int nextExitRemainDist = -1;
    private int nextPointRemainDist = -1;
    private String optionalNextRoadName = null;
    private String service2Name = null;
    private int service2RemainDist = -1;
    private String serviceName = null;
    private int serviceRemainDist = -1;

    private RGHighwayModel() {
    }

    public static RGHighwayModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGHighwayModel();
        }
        return mInstance;
    }

    public boolean isExists() {
        return this.mIsExists;
    }

    public void updateExists(boolean exists) {
        this.mIsExists = exists;
    }

    public void updateExitFastwayData(Bundle data) {
        if (data == null) {
            LogUtil.m15791e(TAG, "updateExitFastwayData=null");
            this.exitFastwayName = null;
            this.exitFastwayRemainDist = -1;
            return;
        }
        LogUtil.m15791e(TAG, "updateExitFastwayData=" + data.toString());
        this.exitFastwayName = data.getString("fastway_exit_roadname");
        this.exitFastwayRemainDist = data.getInt("fastway_exit_remain_dist");
        this.exitFastwayId = data.getString("fastway_exit_road_id");
    }

    public void updateEntryData(Bundle data) {
        if (data == null) {
            LogUtil.m15791e(TAG, "updateEntryData=null");
            this.entryName = null;
            this.entryRemainDist = -1;
            return;
        }
        LogUtil.m15791e(TAG, "updateEntryData=" + data.toString());
        this.entryName = data.getString("highway_in_roadname");
        this.entryRemainDist = data.getInt("highway_in_remain_dist");
    }

    public void updateData(Bundle data) {
        boolean z = true;
        if (data == null) {
            LogUtil.m15791e(TAG, "updateData=null");
            return;
        }
        LogUtil.m15791e(TAG, "updateData=" + data.toString());
        this.exitName = data.getString(HighWayInfo.ExitIC);
        this.exitCode = data.getString(HighWayInfo.ExitICCode);
        if (this.exitCode != null && this.exitCode.trim().length() == 0) {
            this.exitCode = null;
        }
        if (this.exitCode != null) {
            this.mNewHighWayData.putString(HighWayInfo.ExitICCode, this.exitCode);
        }
        String tmpS = data.getString(HighWayInfo.ExitDirectionName);
        if (tmpS == null || tmpS.trim().length() <= 0) {
            this.exitDirections = null;
        } else {
            this.exitDirections = tmpS.trim().split(",");
        }
        if (this.exitDirections != null) {
            this.mNewHighWayData.putString(HighWayInfo.ExitDirectionName, tmpS);
        }
        this.exitNextRoadName = data.getString(HighWayInfo.ExitNextRoadName);
        if (this.exitNextRoadName != null) {
            this.mNewHighWayData.putString(HighWayInfo.ExitNextRoadName, this.exitNextRoadName);
        }
        this.exitRemainDist = data.getInt(HighWayInfo.ExitRemainDist, -1);
        if (this.exitRemainDist >= 0) {
            this.mNewHighWayData.putInt(HighWayInfo.ExitRemainDist, this.exitRemainDist);
        }
        this.exitTotalDist = data.getInt(HighWayInfo.ExitTotalDist, -1);
        this.exitTurnIconType = data.getInt(HighWayInfo.ExitDirection, -1);
        this.nextExitName = data.getString(HighWayInfo.NextExitIC);
        tmpS = data.getString(HighWayInfo.NextExitDirectionName);
        if (tmpS == null || tmpS.trim().length() <= 0) {
            this.nextExitDirections = null;
        } else {
            this.nextExitDirections = tmpS.trim().split(",");
        }
        this.nextExitRemainDist = data.getInt(HighWayInfo.NextExitRemainDist, -1);
        this.serviceName = null;
        if (data.containsKey(HighWayInfo.ServiceName)) {
            this.serviceName = data.getString(HighWayInfo.ServiceName);
        }
        this.serviceRemainDist = data.getInt(HighWayInfo.ServiceRemainDist, -1);
        this.service2Name = null;
        if (data.containsKey(HighWayInfo.NextServiceName)) {
            this.service2Name = data.getString(HighWayInfo.NextServiceName);
        }
        this.service2RemainDist = data.getInt(HighWayInfo.NextServiceRemainDist, -1);
        this.gateName = null;
        if (data.containsKey(HighWayInfo.NextGateName)) {
            this.gateName = data.getString(HighWayInfo.NextGateName);
        }
        this.gateRemainDist = data.getInt(HighWayInfo.NextGateRemainDist, -1);
        this.gateTotalDist = data.getInt(HighWayInfo.NextGateTotalDist, -1);
        if (data.getInt(HighWayInfo.HideInfo, 1) == 1) {
            z = false;
        }
        this.isShowHighwayAlongInfo = z;
        this.mNewHighWayData.putBoolean(HighWayInfo.HideInfo, this.isShowHighwayAlongInfo);
        this.curRoadName = data.getString(HighWayInfo.CurRoadName);
        miniPanerDisplayable();
    }

    private void miniPanerDisplayable() {
        if (!this.mMiniPanerDisplayable) {
            if (this.mDriveDistance <= 0 && this.exitRemainDist >= 20000) {
                this.mDriveDistance = this.exitRemainDist;
                LogUtil.m15791e("Highway", "满足20公里，开始计算行驶路程");
            }
            if (this.mDriveDistance != 0) {
                if (this.mDriveDistance - this.exitRemainDist >= 2000) {
                    this.mMiniPanerDisplayable = true;
                    LogUtil.m15791e("Highway", "满足条件，mini面板允许显示");
                }
                LogUtil.m15791e("Highway", "已经行走" + (this.mDriveDistance - this.exitRemainDist) + "米");
            }
        }
        if (this.mDriveDistance != 0 && this.exitRemainDist < 18000) {
            this.mDriveDistance = 0;
            LogUtil.m15791e("Highway", "离下一机动点路程小于18km mDriveDistance = 0");
        }
    }

    public boolean isAutoShowMiniPanerAble() {
        return this.mAutoShowMiniPanerAble;
    }

    public void setAutoShowMiniPanerAble(boolean mAutoShowMiniPanerAble) {
        this.mAutoShowMiniPanerAble = mAutoShowMiniPanerAble;
    }

    public int getCurrentPanerMode() {
        return this.mCurrentPanerMode;
    }

    public void setCurrentPanerMode(int mCurrentPanerMode) {
        this.mCurrentPanerMode = mCurrentPanerMode;
    }

    public boolean getMiniPanerDisplayable() {
        return this.mMiniPanerDisplayable;
    }

    public void setMiniPanerDisplayable(boolean mMiniPanerDisplayable) {
        this.mMiniPanerDisplayable = mMiniPanerDisplayable;
    }

    public Bundle getNewHighWayData() {
        return this.mNewHighWayData;
    }

    public void setNextPointRemainDist(int dist) {
        this.nextPointRemainDist = dist;
    }

    public boolean isNeedToShowGateInfo() {
        if (this.gateName == null || this.gateName.trim().length() <= 0 || this.gateRemainDist <= 0 || this.gateRemainDist > this.exitRemainDist) {
            return false;
        }
        return true;
    }

    public boolean isShowHighwayAlongInfo() {
        return this.isShowHighwayAlongInfo;
    }

    public static void destroy() {
        if (mInstance != null) {
            mInstance = null;
        }
    }

    public int getDefaultTurnIconType() {
        return 1;
    }

    public boolean isTurnIconTypeValid(int turnIconType) {
        if (turnIconType == 1 || turnIconType == 8 || turnIconType == 2) {
            return true;
        }
        return false;
    }

    public Drawable getTurnIconDrawable(int turnIconType, boolean dayStyle) {
        switch (turnIconType) {
            case 1:
                return BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_highway_straight_arrow);
            case 2:
                return BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_highway_right_arrow);
            case 8:
                return BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_highway_left_arrow);
            default:
                return null;
        }
    }

    public boolean hasExitCode() {
        if (this.exitCode == null || this.exitCode.length() <= 0) {
            return false;
        }
        return true;
    }

    public String getExitCode() {
        return this.exitCode == null ? "" : this.exitCode;
    }

    public String getExitFastwayId() {
        return this.exitFastwayId == null ? "" : this.exitFastwayId;
    }

    public String formatDirections() {
        String[] directions = getInstance().getExitDirections();
        if (directions == null || directions.length < 1 || TextUtils.isEmpty(directions[0])) {
            return null;
        }
        int len = directions.length;
        StringBuilder builder = new StringBuilder(directions[0]);
        for (int i = 1; i < len; i++) {
            builder.append(" ");
            builder.append(directions[i]);
        }
        return builder.toString();
    }

    public String[] getExitDirections() {
        if (this.exitDirections != null && this.exitDirections.length > 0) {
            return this.exitDirections;
        }
        if (TextUtils.isEmpty(this.exitNextRoadName)) {
            return null;
        }
        return new String[]{this.exitNextRoadName};
    }

    public String getFormatExitRemainDist() {
        if (this.exitRemainDist < 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        StringUtils.formatDistance(this.exitRemainDist, UnitLangEnum.ZH, sb);
        return sb.toString();
    }

    public int getExitTurnIconType() {
        return this.exitTurnIconType;
    }

    public boolean isSimpleBoardCanShow() {
        LogUtil.m15791e(TAG, "isSimpleBoardCanShow start");
        int[] typeArray = getSimpleBoardShowType();
        if (typeArray == null || typeArray.length == 0) {
            return false;
        }
        LogUtil.m15791e(TAG, "isSimpleBoardCanShow true");
        return true;
    }

    public int[] getSimpleBoardShowType() {
        int[] showArray = new int[5];
        int index = -1;
        if (isExitFastwayShowInSimpleBoard()) {
            index = -1 + 1;
            showArray[index] = 5;
        }
        if (isExitShowInSimpleBoard()) {
            index++;
            showArray[index] = 4;
        }
        if (this.gateRemainDist <= this.serviceRemainDist) {
            if (isGateShowInSimpleBoard()) {
                index++;
                showArray[index] = 1;
            }
            if (isService1ShowInSimpleBoard()) {
                index++;
                showArray[index] = 2;
            }
            if (isService2ShowInSimpleBoard()) {
                index++;
                showArray[index] = 3;
            }
        } else if (this.gateRemainDist <= this.service2RemainDist) {
            if (isService1ShowInSimpleBoard()) {
                index++;
                showArray[index] = 2;
            }
            if (isGateShowInSimpleBoard()) {
                index++;
                showArray[index] = 1;
            }
            if (isService2ShowInSimpleBoard()) {
                index++;
                showArray[index] = 3;
            }
        } else {
            if (isService1ShowInSimpleBoard()) {
                index++;
                showArray[index] = 2;
            }
            if (isService2ShowInSimpleBoard()) {
                index++;
                showArray[index] = 3;
            }
            if (isGateShowInSimpleBoard()) {
                index++;
                showArray[index] = 1;
            }
        }
        if (index == 0) {
            return new int[]{showArray[0]};
        } else if (index <= 0) {
            return null;
        } else {
            return new int[]{showArray[0], showArray[1]};
        }
    }

    private boolean isEntryShowInSimpleBoard() {
        if (TextUtils.isEmpty(this.entryName) || this.entryRemainDist > 2000 || this.entryRemainDist < 10) {
            return false;
        }
        LogUtil.m15791e(TAG, "isEntryShowInSimpleBoard true entryName:" + this.entryName + " entryRemainDist:" + this.entryRemainDist);
        return true;
    }

    private boolean isGateShowInSimpleBoard() {
        if (TextUtils.isEmpty(this.gateName) || this.gateRemainDist < 1) {
            return false;
        }
        LogUtil.m15791e(TAG, "isGateShowInSimpleBoard true gateName:" + this.gateName + " gateRemainDist:" + this.gateRemainDist);
        return true;
    }

    private boolean isService1ShowInSimpleBoard() {
        if (TextUtils.isEmpty(this.serviceName) || this.serviceRemainDist < 1) {
            return false;
        }
        LogUtil.m15791e(TAG, "isService1Show true serviceName:" + this.serviceName + " serviceRemainDist:" + this.serviceRemainDist);
        return true;
    }

    public boolean isService2ShowInSimpleBoard() {
        if (TextUtils.isEmpty(this.service2Name) || this.service2RemainDist < 1) {
            return false;
        }
        LogUtil.m15791e(TAG, "isService2Show true service2Name:" + this.service2Name + " service2RemainDist:" + this.service2RemainDist);
        return true;
    }

    private boolean isExitShowInSimpleBoard() {
        if (this.exitRemainDist < 1 || this.exitRemainDist > 3000) {
            return false;
        }
        String[] direction = getExitDirections();
        if (direction == null || direction.length < 1 || TextUtils.isEmpty(direction[0]) || "空".equals(direction[0])) {
            return false;
        }
        LogUtil.m15791e(TAG, "isExitShow true");
        return true;
    }

    private boolean isExitFastwayShowInSimpleBoard() {
        if (this.exitFastwayRemainDist < 1 || TextUtils.isEmpty(this.exitFastwayName) || this.exitFastwayRemainDist > 3000) {
            return false;
        }
        LogUtil.m15791e(TAG, "isExitFastwayShow exitFastwayName:" + this.exitFastwayName + " exitFastwayRemainDist:" + this.exitFastwayRemainDist);
        return true;
    }

    public String getTypeName(int type) {
        switch (type) {
            case 0:
                return this.entryName;
            case 1:
                return this.gateName;
            case 2:
                return this.serviceName;
            case 3:
                return this.service2Name;
            case 4:
                String[] directions = getExitDirections();
                if (directions == null || directions.length == 0) {
                    return this.exitNextRoadName;
                }
                String ds = getExitDirections()[0];
                for (int i = 1; i < getExitDirections().length; i++) {
                    ds = ds + " " + getExitDirections()[i];
                }
                return ds;
            case 5:
                if (this.exitFastwayName != null) {
                    return this.exitFastwayName.replace(",", " ");
                }
                return this.exitFastwayName;
            default:
                return null;
        }
    }

    public int getTypeRemainDist(int type) {
        switch (type) {
            case 0:
                return this.entryRemainDist;
            case 1:
                return this.gateRemainDist;
            case 2:
                return this.serviceRemainDist;
            case 3:
                return this.service2RemainDist;
            case 4:
                return this.exitRemainDist;
            case 5:
                return this.exitFastwayRemainDist;
            default:
                return 0;
        }
    }

    public Drawable getTypeIcon(int type) {
        switch (type) {
            case 0:
                return JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_hw_entry);
            case 1:
                return JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_hw_gate);
            case 2:
            case 3:
                return JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_hw_service_area);
            case 4:
            case 5:
                return JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_hw_exit);
            default:
                return null;
        }
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getServiceRemainDist() {
        return this.serviceRemainDist;
    }

    public void setCurRoadName(String name) {
        this.curRoadName = name;
    }

    public String getCurRoadName() {
        return this.curRoadName;
    }

    public void reset() {
        LogUtil.m15791e(TAG, "reset");
        this.entryName = null;
        this.entryRemainDist = -1;
        this.exitFastwayName = null;
        this.exitFastwayId = null;
        this.exitFastwayRemainDist = -1;
        this.exitName = null;
        this.exitCode = null;
        this.exitDirections = null;
        this.exitNextRoadName = null;
        this.exitRemainDist = -1;
        this.exitTotalDist = -1;
        this.exitTurnIconType = -1;
        this.optionalNextRoadName = null;
        this.serviceName = null;
        this.serviceRemainDist = -1;
        this.service2Name = null;
        this.service2RemainDist = -1;
        this.nextExitName = null;
        this.nextExitDirections = null;
        this.nextExitRemainDist = -1;
        this.gateName = "";
        this.gateRemainDist = -1;
        this.gateTotalDist = -1;
        this.mIsExists = false;
        this.mDriveDistance = 0;
        this.mMiniPanerDisplayable = false;
        this.mAutoShowMiniPanerAble = true;
        this.mCurrentPanerMode = 0;
    }
}
