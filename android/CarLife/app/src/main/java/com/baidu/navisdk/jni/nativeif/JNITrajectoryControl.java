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

public class JNITrajectoryControl
{
  public static final int TRAJECTORY_FAILED = -1;
  public static final int TRAJECTORY_SUCCESS = 0;
  public static JNITrajectoryControl sInstance = new JNITrajectoryControl();
  public boolean isCarRecodingFromCLoud = false;
  private String mCarNaviUUID;
  private String mUUID;
  
  public native int GetTrajectoryGPSListDirect(String paramString, ArrayList<NaviTrajectoryGPSData> paramArrayList);
  
  public native int cancelSync();
  
  public native void checkNaviDistForBusiness(String paramString, Bundle paramBundle);
  
  public native int delete(String paramString);
  
  public native int endRecord(String paramString1, String paramString2, boolean paramBoolean, Bundle paramBundle);
  
  public native int endRecordCarNavi(String paramString1, String paramString2, boolean paramBoolean, Bundle paramBundle);
  
  public String getCurrentCarNaviUUID()
  {
    return this.mCarNaviUUID;
  }
  
  public String getCurrentUUID()
  {
    return this.mUUID;
  }
  
  public native int getGpsListBound(String paramString, Rect paramRect);
  
  public native int getLastSyncTime(String paramString, Bundle paramBundle);
  
  public String getLastSyncTime(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (getLastSyncTime(paramString, localBundle) != 0) {
      return "";
    }
    return localBundle.getString("count");
  }
  
  public native int getMileageDataById(String paramString, MileageInfo paramMileageInfo);
  
  public native int getNotSyncMileageByUser(String paramString1, String paramString2, ArrayList<Bundle> paramArrayList);
  
  public native void getPostParams(int paramInt, Bundle paramBundle);
  
  public native void getPostParamsForBdussUpdated(Bundle paramBundle, String paramString);
  
  public native int getPostParamsForNavingUpload(String paramString, Bundle paramBundle);
  
  public native String getTrajecotryFilePath(String paramString);
  
  public native int getTrajectoryById(String paramString, NaviTrajectory paramNaviTrajectory);
  
  public native int getTrajectoryCnt(String paramString1, String paramString2);
  
  public native long getTrajectoryLength(String paramString);
  
  public native int getTrajectoryList(String paramString1, String paramString2, ArrayList<NaviTrajectory> paramArrayList);
  
  public native int getTrajectoryStatusById(String paramString, NaviTrajectoryStatusInfo paramNaviTrajectoryStatusInfo);
  
  public native int getUnSyncTrajectoryCnt(String paramString1, String paramString2);
  
  public native String getUrlParamsSign(String paramString);
  
  public native int logoutCleanUp();
  
  public native int patchDelete(ArrayList<String> paramArrayList);
  
  public native int recording(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
  
  public native int recordingCarNavi(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
  
  public native int rename(String paramString1, String paramString2);
  
  public int startRecord(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    this.mUUID = UUID.randomUUID().toString();
    try
    {
      paramInt = startRecord(paramString1, this.mUUID, paramString2, paramInt, paramBoolean);
      return paramInt;
    }
    catch (Throwable paramString1) {}
    return -1;
  }
  
  public native int startRecord(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean);
  
  public int startRecordCarNavi(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    this.mCarNaviUUID = UUID.randomUUID().toString();
    try
    {
      startRecordCarNavi(paramString1, this.mCarNaviUUID, paramString2, paramInt, paramBoolean);
      return -1;
    }
    catch (Exception paramString1) {}
    return -1;
  }
  
  public native int startRecordCarNavi(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean);
  
  public native int startSync(String paramString1, String paramString2);
  
  public native int updateEndName(String paramString1, String paramString2);
  
  public native int updateStartName(String paramString1, String paramString2);
  
  public native void updateUserInfo(String paramString1, String paramString2, int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/nativeif/JNITrajectoryControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */