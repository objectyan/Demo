package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.model.datastruct.RoadConditionItem;
import com.baidu.navisdk.ui.routeguide.subview.AssistantMapTypeConstDefine;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;

public class RGAssistGuideModel {
    public static final String KEY_ASSIST_INDEX = "key_assist_index";
    public static final int MAX_ASSIST_INFO = 3;
    private static final String TAG = RGAssistGuideModel.class.getSimpleName();
    public static final int UPDATE_TYPE_HIDE = 3;
    public static final int UPDATE_TYPE_SHOW = 1;
    public static final int UPDATE_TYPE_UPDATE = 2;
    private static RGAssistGuideModel mInstance = null;
    private List<AssistInfo> mAssistInfos = new ArrayList();
    private double mCurCarDriveProgress = 0.0d;
    private int mCurCarSpeed = 0;
    public boolean mIsGPSEnable = false;
    public boolean mIsGPSFix = false;
    private long mLastRefreshRoadConditionTime = -1;
    private Bundle mLastestData = new Bundle();
    private boolean mMainAuxiliary = false;
    public int mOverSpeed = -1;

    public static class AssistInfo implements Comparable<AssistInfo> {
        public int mAssistType;
        public int mIconResId;
        public int mProgress;
        public int mSpeedLimit;
        public int mUpdateType;

        public AssistInfo cloneTo() {
            AssistInfo newAI = new AssistInfo();
            newAI.mUpdateType = this.mUpdateType;
            newAI.mAssistType = this.mAssistType;
            newAI.mSpeedLimit = this.mSpeedLimit;
            newAI.mProgress = this.mProgress;
            newAI.mIconResId = this.mIconResId;
            return newAI;
        }

        public int compareTo(AssistInfo another) {
            int compare = this.mAssistType - another.mAssistType;
            if (compare > 0) {
                return 1;
            }
            if (compare < 0) {
                return -1;
            }
            return 0;
        }

        public int hashCode() {
            return this.mAssistType + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (this.mAssistType != ((AssistInfo) obj).mAssistType) {
                return false;
            }
            return true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AssistType: ").append(this.mAssistType).append(" SpeedLimit: ").append(this.mSpeedLimit);
            return sb.toString();
        }
    }

    public interface EnlargeMapI {
        public static final int DEFAULT_TYPE = 0;
        public static final int ENLARGE_TYPE = 1;
    }

    public static RGAssistGuideModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGAssistGuideModel();
        }
        return mInstance;
    }

    public Bundle updateAssistData(int nUpdateType, int nAssistType, int nSpeed) {
        this.mLastestData.clear();
        this.mLastestData.putInt("updatetype", nUpdateType);
        this.mLastestData.putInt("assisttype", nAssistType);
        this.mLastestData.putInt("speed", nSpeed);
        Bundle data = new Bundle();
        data.putInt(KEY_ASSIST_INDEX, updateAssistInfo(nUpdateType, nAssistType, nSpeed));
        return data;
    }

    public AssistInfo getAssistInfo(int index) {
        if (index < 0 || index >= this.mAssistInfos.size()) {
            return null;
        }
        return (AssistInfo) this.mAssistInfos.get(index);
    }

    public void reset() {
        LogUtil.m15791e(TAG, "reset");
        this.mMainAuxiliary = false;
        this.mCurCarDriveProgress = 0.0d;
        this.mLastRefreshRoadConditionTime = -1;
        this.mCurCarSpeed = 0;
        this.mOverSpeed = -1;
        if (this.mAssistInfos != null) {
            this.mAssistInfos.clear();
        }
        if (this.mLastestData != null) {
            this.mLastestData.clear();
        }
    }

    public Bundle getLastestData() {
        return this.mLastestData;
    }

    public void updateMainAuxiliary(boolean value) {
        this.mMainAuxiliary = value;
    }

    public boolean getMainAuxiliary() {
        return this.mMainAuxiliary;
    }

    public void updateCurCarSpeed(double speed) {
        double realSpeed = speed * 3.6d;
        LogUtil.m15791e(TAG, "updateCurCarSpeed realSpeed = " + realSpeed);
        if (realSpeed < 30.0d) {
            realSpeed += realSpeed / 10.0d;
        } else if (realSpeed >= 30.0d && realSpeed < 80.0d) {
            realSpeed += 3.0d;
        } else if (realSpeed < 80.0d || realSpeed >= 100.0d) {
            realSpeed += 5.0d;
        } else {
            realSpeed += 4.0d;
        }
        this.mCurCarSpeed = (int) realSpeed;
        LogUtil.m15791e(TAG, "updateCurCarSpeed mCurCarSpeed = " + this.mCurCarSpeed);
    }

    public String getCurCarSpeed() {
        LogUtil.m15791e(TAG, "getCurCarSpeed mIsGPSEnable = " + this.mIsGPSEnable + ", mIsGPSFix = " + this.mIsGPSFix);
        if (this.mIsGPSEnable && this.mIsGPSFix) {
            return "" + this.mCurCarSpeed;
        }
        return "- -";
    }

    public boolean isCarSpeedRight() {
        return this.mIsGPSEnable && this.mIsGPSFix;
    }

    public int getCurCarSpeedInt() {
        return this.mCurCarSpeed;
    }

    public boolean isOverSpeed() {
        if (this.mOverSpeed != -1 && this.mCurCarSpeed > this.mOverSpeed) {
            return true;
        }
        return false;
    }

    public int getCurLimitSpeed() {
        int s = 0;
        int i = 0;
        while (i < this.mAssistInfos.size()) {
            if ((3 != ((AssistInfo) this.mAssistInfos.get(i)).mUpdateType && 8 == ((AssistInfo) this.mAssistInfos.get(i)).mAssistType) || 11 == ((AssistInfo) this.mAssistInfos.get(i)).mAssistType) {
                s = ((AssistInfo) this.mAssistInfos.get(i)).mSpeedLimit / 1000;
            }
            i++;
        }
        return s;
    }

    public void updateCarProgress() {
        this.mCurCarDriveProgress = (double) BNRouteGuider.getInstance().getCarProgress();
    }

    public double getCarProgress() {
        return this.mCurCarDriveProgress;
    }

    public List<RoadConditionItem> getRoadConditionData() {
        this.mLastRefreshRoadConditionTime = System.currentTimeMillis();
        List<Bundle> blist = BNRouteGuider.getInstance().getRoadCondition();
        if (blist == null || blist.size() == 0) {
            return null;
        }
        List<RoadConditionItem> list = new ArrayList();
        for (int i = 0; i < blist.size(); i++) {
            Bundle b = (Bundle) blist.get(i);
            if (b.containsKey("unEndShapeIdx") && b.containsKey("enRoadCondition")) {
                int index = b.getInt("unEndShapeIdx", -1);
                int type = b.getInt("enRoadCondition");
                if (type < 0 || type > 4) {
                    type = 0;
                }
                RoadConditionItem item = new RoadConditionItem();
                item.curItemEndIndex = index;
                item.roadConditionType = type;
                list.add(item);
            }
        }
        return list;
    }

    public boolean isTimeToRefreshRoadCondition() {
        if (this.mLastRefreshRoadConditionTime > 0 && System.currentTimeMillis() - this.mLastRefreshRoadConditionTime <= 60000) {
            return false;
        }
        return true;
    }

    public int getCurCarPointRoadCondition() {
        List<RoadConditionItem> list = getRoadConditionData();
        if (list == null) {
            return -1;
        }
        int curIndex = (int) (getCarProgress() * ((double) ((RoadConditionItem) list.get(list.size() - 1)).curItemEndIndex));
        for (int i = 0; i < list.size(); i++) {
            if (curIndex < ((RoadConditionItem) list.get(i)).curItemEndIndex) {
                return ((RoadConditionItem) list.get(i)).roadConditionType;
            }
        }
        return -1;
    }

    public String getCurCarPointRoadConditionChineseWord() {
        switch (getCurCarPointRoadCondition()) {
            case 1:
                return "顺畅";
            case 2:
                return "缓慢行驶";
            case 3:
                return "拥堵";
            default:
                return "没有路况数据";
        }
    }

    private int updateAssistInfo(int nUpdateType, int nAssistType, int nSpeed) {
        switch (nUpdateType) {
            case 1:
                int resId = getResourceIdByType(nAssistType, nSpeed);
                LogUtil.m15791e(TAG, "AssistantIconUpdate UPDATE_TYPE_SHOW! nAssistType:" + nAssistType + ",nSpeed:" + nSpeed);
                return recieveShowInfo(resId, nAssistType, nSpeed);
            case 2:
                LogUtil.m15791e(TAG, "AssistantIconUpdate UPDATE_TYPE_UPDATE! nAssistType:" + nAssistType + ",nSpeed:" + nSpeed);
                return recieveUpdateInfo(0, nAssistType, nSpeed);
            case 3:
                LogUtil.m15791e(TAG, "AssistantIconUpdate UPDATE_TYPE_HIDE! nAssistType:" + nAssistType + ",nSpeed:" + nSpeed);
                return recieveHideInfo(0, nAssistType, nSpeed);
            default:
                return -1;
        }
    }

    private int recieveShowInfo(int resId, int nAssistType, int nSpeed) {
        int size = this.mAssistInfos.size();
        LogUtil.m15791e(TAG, "recieveShowInfo  size=" + size);
        if (size == 0) {
            AssistInfo info = new AssistInfo();
            info.mUpdateType = 1;
            info.mAssistType = nAssistType;
            info.mSpeedLimit = nSpeed;
            info.mProgress = 0;
            info.mIconResId = resId;
            this.mAssistInfos.add(info);
            return 0;
        }
        int index = indexOfAssistType(nAssistType);
        if (index < 0) {
            index = indexOfHideAssistInfo();
        }
        if (index != -1) {
            ((AssistInfo) this.mAssistInfos.get(index)).mUpdateType = 1;
            ((AssistInfo) this.mAssistInfos.get(index)).mAssistType = nAssistType;
            ((AssistInfo) this.mAssistInfos.get(index)).mSpeedLimit = nSpeed;
            ((AssistInfo) this.mAssistInfos.get(index)).mIconResId = resId;
            ((AssistInfo) this.mAssistInfos.get(index)).mProgress = 0;
            return index;
        } else if (size < 3) {
            index = size;
            info = new AssistInfo();
            info.mUpdateType = 1;
            info.mAssistType = nAssistType;
            info.mSpeedLimit = nSpeed;
            info.mIconResId = resId;
            info.mProgress = 0;
            this.mAssistInfos.add(info);
            return index;
        } else {
            int assistSize = this.mAssistInfos.size();
            if (index < 0 || index >= assistSize) {
                return -1;
            }
            for (int i = 0; i < assistSize; i++) {
                if (nAssistType < ((AssistInfo) this.mAssistInfos.get(i)).mAssistType) {
                    ((AssistInfo) this.mAssistInfos.get(index)).mUpdateType = 1;
                    ((AssistInfo) this.mAssistInfos.get(index)).mAssistType = nAssistType;
                    ((AssistInfo) this.mAssistInfos.get(index)).mSpeedLimit = nSpeed;
                    ((AssistInfo) this.mAssistInfos.get(index)).mIconResId = resId;
                    ((AssistInfo) this.mAssistInfos.get(index)).mProgress = 0;
                    return index;
                }
            }
            return -1;
        }
    }

    private int recieveUpdateInfo(int resId, int nAssistType, int nSpeed) {
        int index = indexOfAssistType(nAssistType);
        if (index == -1 || index >= this.mAssistInfos.size()) {
            return -1;
        }
        ((AssistInfo) this.mAssistInfos.get(index)).mUpdateType = 2;
        ((AssistInfo) this.mAssistInfos.get(index)).mAssistType = nAssistType;
        AssistInfo assistInfo = (AssistInfo) this.mAssistInfos.get(index);
        if (nSpeed >= 95) {
            nSpeed = 100;
        }
        assistInfo.mProgress = nSpeed;
        return index;
    }

    private int indexOfAssistType(int type) {
        int size = this.mAssistInfos.size();
        for (int i = 0; i < size; i++) {
            if (((AssistInfo) this.mAssistInfos.get(i)).mAssistType == type) {
                return i;
            }
        }
        return -1;
    }

    private int indexOfHideAssistInfo() {
        int size = this.mAssistInfos.size();
        for (int i = 0; i < size; i++) {
            if (((AssistInfo) this.mAssistInfos.get(i)).mUpdateType == 3) {
                return i;
            }
        }
        return -1;
    }

    private int recieveHideInfo(int resId, int nAssistType, int nSpeed) {
        int index = indexOfAssistType(nAssistType);
        if (index != -1) {
            ((AssistInfo) this.mAssistInfos.get(index)).mUpdateType = 3;
        }
        return index;
    }

    public int getResourceIdByType(int nAssistType, int nSpeed) {
        return AssistantMapTypeConstDefine.getResourceIdByType(nAssistType, nSpeed);
    }
}
