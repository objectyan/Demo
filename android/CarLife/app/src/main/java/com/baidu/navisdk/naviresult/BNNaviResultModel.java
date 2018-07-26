package com.baidu.navisdk.naviresult;

import com.baidu.mobstat.Config;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.logic.BNSysLocationManager;

public class BNNaviResultModel {
    private static final String TAG = BNNaviResultModel.class.getSimpleName();
    private int accelerateNum;
    private float averageSpeed;
    private int brakeNum;
    private boolean destArrived;
    private int estimatedRemainDist;
    private long estimatedRemainTimeMillis;
    public int instantNum;
    public int isSwitch;
    private float maxSpeed;
    private float naviCompletePercentage;
    private boolean showWalkNavi;
    private int speedNum;
    private float totalDistance;
    private long totalTimeSecs;
    private int turnNum;
    private int walkNaviRemainDist;
    public int yawNum;

    private static class LazyLoader {
        private static BNNaviResultModel instance = new BNNaviResultModel();

        private LazyLoader() {
        }
    }

    private BNNaviResultModel() {
        this.estimatedRemainTimeMillis = 0;
        this.estimatedRemainDist = 0;
        this.totalTimeSecs = 0;
        this.totalDistance = 0.0f;
        this.maxSpeed = 0.0f;
        this.averageSpeed = 0.0f;
        this.speedNum = 0;
        this.brakeNum = 0;
        this.turnNum = 0;
        this.accelerateNum = 0;
        this.destArrived = false;
        this.naviCompletePercentage = 0.0f;
        this.showWalkNavi = false;
        this.walkNaviRemainDist = 0;
        this.yawNum = 0;
        this.instantNum = 0;
        this.isSwitch = 0;
    }

    public static BNNaviResultModel getInstance() {
        return LazyLoader.instance;
    }

    public void reset() {
        this.estimatedRemainTimeMillis = 0;
        this.estimatedRemainDist = 0;
        this.totalTimeSecs = 0;
        this.totalDistance = 0.0f;
        this.maxSpeed = 0.0f;
        this.averageSpeed = 0.0f;
        this.speedNum = 0;
        this.brakeNum = 0;
        this.turnNum = 0;
        this.accelerateNum = 0;
        this.destArrived = false;
        this.naviCompletePercentage = 0.0f;
        this.showWalkNavi = false;
        this.walkNaviRemainDist = 0;
        this.yawNum = 0;
        this.instantNum = 0;
        this.isSwitch = 0;
    }

    public void setYawNum() {
        LocData locData = null;
        if (BNSysLocationManager.getInstance().isSysLocationValid()) {
            locData = BNSysLocationManager.getInstance().getCurLocation();
        }
        if (BNRoutePlaner.getInstance().getLineDist2RpNode(locData, true) > 100 && BNRoutePlaner.getInstance().getLineDist2RpNode(locData, false) > 100) {
            this.yawNum++;
        }
    }

    public long getTotalTimeSecs() {
        return this.totalTimeSecs;
    }

    public void setTotalTimeSecs(long totalTimeSecs) {
        this.totalTimeSecs = totalTimeSecs;
    }

    public String getTotalTimeFormatedStr() {
        String timeText = StringUtils.customedFormatTime((int) this.totalTimeSecs, "天", "小时", "分");
        if (StringUtils.lessOneMinute.equals(timeText)) {
            return "1分";
        }
        return timeText;
    }

    public int getSpeedNum() {
        return this.speedNum;
    }

    public void setSpeedNum(int speedNum) {
        this.speedNum = speedNum;
    }

    public int getBrakeNum() {
        return this.brakeNum;
    }

    public void setBrakeNum(int brakeNum) {
        this.brakeNum = brakeNum;
    }

    public int getTurnNum() {
        return this.turnNum;
    }

    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }

    public int getAccelerateNum() {
        return this.accelerateNum;
    }

    public void setAccelerateNum(int accelerateNum) {
        this.accelerateNum = accelerateNum;
    }

    public float getTotalDistance() {
        return this.totalDistance;
    }

    public String getTotalDistanceStr() {
        if (this.totalDistance < 1000.0f) {
            return Math.round(this.totalDistance) + Config.MODEL;
        }
        return ((int) ((double) (this.totalDistance / 1000.0f))) + "km";
    }

    public void setTotalDistance(float totalDistance) {
        this.totalDistance = totalDistance;
    }

    public float getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getAverageSpeed() {
        return this.averageSpeed;
    }

    public void setAverageSpeed(float averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public boolean isDestArrived() {
        return this.destArrived;
    }

    public void setDestArrived(boolean destArrived) {
        this.destArrived = destArrived;
    }

    public float getNaviCompletePercentage() {
        return this.naviCompletePercentage;
    }

    public void setNaviCompletePercentage(float naviCompletePercentage) {
        this.naviCompletePercentage = naviCompletePercentage;
    }

    public boolean isShowWalkNavi() {
        return this.showWalkNavi;
    }

    public void setShowWalkNavi(boolean isWalkNaviNeeded) {
        this.showWalkNavi = isWalkNaviNeeded;
    }

    public int getWalkNaviRemainDist() {
        return this.walkNaviRemainDist;
    }

    public void setWalkNaviRemainDist(int walkNaviRemainDist) {
        this.walkNaviRemainDist = walkNaviRemainDist;
    }

    public long getEstimatedRemainTimeMillis() {
        return this.estimatedRemainTimeMillis;
    }

    public void setEstimatedRemainTimeMillis(long estimatedRemainTimeMillis) {
        this.estimatedRemainTimeMillis = estimatedRemainTimeMillis;
    }

    public int getEstimatedRemainDist() {
        return this.estimatedRemainDist;
    }

    public void setEstimatedRemainDist(int estimatedRemainDist) {
        this.estimatedRemainDist = estimatedRemainDist;
    }

    public String toString() {
        return "estimatedRemainTimeMillis: " + this.estimatedRemainTimeMillis + ", estimatedRemainDist: " + this.estimatedRemainDist + ", totalTimeSecs: " + this.totalTimeSecs + ", totalDistance: " + this.totalDistance + ", maxSpeed: " + this.maxSpeed + ", averageSpeed: " + this.averageSpeed + ", speedNum: " + this.speedNum + ", brakeNum: " + this.brakeNum + ", turnNum: " + this.turnNum + ", accelerateNum: " + this.accelerateNum + ", destArrived: " + this.destArrived + ", naviCompletePercentage: " + this.naviCompletePercentage + ", showWalkNavi: " + this.showWalkNavi + ", walkNaviRemainDist: " + this.walkNaviRemainDist;
    }
}
