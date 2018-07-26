package com.baidu.navisdk.util.db.object;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;

public class RouteCustomDBObject implements BaseDBObject {
    private long mCustomTime;
    private int mDestType;
    private int mHisRouteId;
    private int mId;
    private int mIsOpen;
    private int mIsRepeat;
    private long mModifiedTime;
    private String mName;
    private int mPUshTimeMinute;
    private int mPushTimeHour;
    private long mPushTimeMills;
    private String mRepeatDate;
    private ArrayList<RoutePlanNodeDBObject> mRoutePlanNodes;

    public int getId() {
        return this.mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public int getHisRouteId() {
        return this.mHisRouteId;
    }

    public void setHisRouteId(int hisRouteDBId) {
        this.mHisRouteId = hisRouteDBId;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getOpen() {
        return this.mIsOpen;
    }

    public void setOpen(int isOpen) {
        this.mIsOpen = isOpen;
    }

    public int getPushTimeHour() {
        return this.mPushTimeHour;
    }

    public void setPushTimeHour(int hour) {
        this.mPushTimeHour = hour;
    }

    public int getPushTimeMinute() {
        return this.mPUshTimeMinute;
    }

    public void setPushTimeMinute(int minute) {
        this.mPUshTimeMinute = minute;
    }

    public long getPushTimeMills() {
        return this.mPushTimeMills;
    }

    public void setPushTimeMills(long mills) {
        this.mPushTimeMills = mills;
    }

    public long getCustomTime() {
        return this.mCustomTime;
    }

    public void setCustomTime(long time) {
        this.mCustomTime = time;
    }

    public long getModifiedTime() {
        return this.mModifiedTime;
    }

    public void setModifiedTime(long time) {
        this.mModifiedTime = time;
    }

    public int getDestType() {
        return this.mDestType;
    }

    public void setDestType(int type) {
        this.mDestType = type;
    }

    public int getIsRepeat() {
        return this.mIsRepeat;
    }

    public void setIsRepeat(int isRepeat) {
        this.mIsRepeat = isRepeat;
    }

    public String getRepeatDate() {
        return this.mRepeatDate;
    }

    public void setRepeatDate(String dates) {
        this.mRepeatDate = dates;
    }

    public ArrayList<RoutePlanNodeDBObject> getRoutePlanDBNodes() {
        return this.mRoutePlanNodes;
    }

    public ArrayList<RoutePlanNode> getRoutePlanNodes() {
        return RoutePlanNodeDBObject.convertToRoutePlanNodeList(this.mRoutePlanNodes);
    }

    public void setRoutePlanNodes(ArrayList<RoutePlanNodeDBObject> nodes) {
        this.mRoutePlanNodes = nodes;
    }
}
