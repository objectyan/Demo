package com.baidu.navisdk.jni.nativeif;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.trajectory.MileageInfo;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectory;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectoryGPSData;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectoryStatusInfo;
import java.util.ArrayList;
import java.util.UUID;

public class JNITrajectoryControl {
    public static final int TRAJECTORY_FAILED = -1;
    public static final int TRAJECTORY_SUCCESS = 0;
    public static JNITrajectoryControl sInstance = new JNITrajectoryControl();
    public boolean isCarRecodingFromCLoud = false;
    private String mCarNaviUUID;
    private String mUUID;

    public native int GetTrajectoryGPSListDirect(String str, ArrayList<NaviTrajectoryGPSData> arrayList);

    public native int cancelSync();

    public native void checkNaviDistForBusiness(String str, Bundle bundle);

    public native int delete(String str);

    public native int endRecord(String str, String str2, boolean z, Bundle bundle);

    public native int endRecordCarNavi(String str, String str2, boolean z, Bundle bundle);

    public native int getGpsListBound(String str, Rect rect);

    public native int getLastSyncTime(String str, Bundle bundle);

    public native int getMileageDataById(String str, MileageInfo mileageInfo);

    public native int getNotSyncMileageByUser(String str, String str2, ArrayList<Bundle> arrayList);

    public native void getPostParams(int i, Bundle bundle);

    public native void getPostParamsForBdussUpdated(Bundle bundle, String str);

    public native int getPostParamsForNavingUpload(String str, Bundle bundle);

    public native String getTrajecotryFilePath(String str);

    public native int getTrajectoryById(String str, NaviTrajectory naviTrajectory);

    public native int getTrajectoryCnt(String str, String str2);

    public native long getTrajectoryLength(String str);

    public native int getTrajectoryList(String str, String str2, ArrayList<NaviTrajectory> arrayList);

    public native int getTrajectoryStatusById(String str, NaviTrajectoryStatusInfo naviTrajectoryStatusInfo);

    public native int getUnSyncTrajectoryCnt(String str, String str2);

    public native String getUrlParamsSign(String str);

    public native int logoutCleanUp();

    public native int patchDelete(ArrayList<String> arrayList);

    public native int recording(double d, double d2, float f, float f2, float f3, long j);

    public native int recordingCarNavi(double d, double d2, float f, float f2, float f3, long j);

    public native int rename(String str, String str2);

    public native int startRecord(String str, String str2, String str3, int i, boolean z);

    public native int startRecordCarNavi(String str, String str2, String str3, int i, boolean z);

    public native int startSync(String str, String str2);

    public native int updateEndName(String str, String str2);

    public native int updateStartName(String str, String str2);

    public native void updateUserInfo(String str, String str2, int i);

    private JNITrajectoryControl() {
    }

    public int startRecord(String userId, String startPointName, int fromType, boolean enableA) {
        if (TextUtils.isEmpty(userId)) {
            String uid = "";
        }
        this.mUUID = UUID.randomUUID().toString();
        int result = -1;
        try {
            result = startRecord(userId, this.mUUID, startPointName, fromType, enableA);
        } catch (Throwable th) {
        }
        return result;
    }

    public String getCurrentUUID() {
        return this.mUUID;
    }

    public String getLastSyncTime(String userId) {
        Bundle output = new Bundle();
        if (getLastSyncTime(userId, output) != 0) {
            return "";
        }
        return output.getString("count");
    }

    public int startRecordCarNavi(String userId, String startPointName, int fromType, boolean isFromCloud) {
        if (TextUtils.isEmpty(userId)) {
            String uid = "";
        }
        this.mCarNaviUUID = UUID.randomUUID().toString();
        try {
            startRecordCarNavi(userId, this.mCarNaviUUID, startPointName, fromType, isFromCloud);
        } catch (Exception e) {
        }
        return -1;
    }

    public String getCurrentCarNaviUUID() {
        return this.mCarNaviUUID;
    }
}
