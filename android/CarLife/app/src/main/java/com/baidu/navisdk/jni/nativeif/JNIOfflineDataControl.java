package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.BNaviEngineManager;

public class JNIOfflineDataControl
{
  private JNIOfflineDataControl()
  {
    BNaviEngineManager.getInstance().initSubSysHandle(3);
  }
  
  public static JNIOfflineDataControl getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  public native boolean CopyProvinceMapData(int paramInt);
  
  public native int DownLoadCityMapData(int paramInt);
  
  public native boolean GetUpdatedInfo(int paramInt, Bundle paramBundle);
  
  public native boolean UpdateCountryInfoFromCfg();
  
  public native int cancelUpdateData(int paramInt);
  
  public native boolean checkCitySpeakDataDownload(int paramInt1, int paramInt2);
  
  public native boolean checkNewVer(Bundle paramBundle, int[] paramArrayOfInt);
  
  public native int checkVer(int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int downLoadAppData();
  
  public native int downloadData(int paramInt);
  
  public native int downloadDataRequest(int paramInt);
  
  public native int getItemTable(int paramInt, Bundle[] paramArrayOfBundle);
  
  public native int getProvinceMapFileId(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int pauseAppDataDownLoad();
  
  public native int removeAppData();
  
  public native int removeDownloadData(int paramInt);
  
  public native boolean renameProvinceData(int paramInt);
  
  public native int suspendDownloadData(int paramInt);
  
  public native int updateData(int paramInt);
  
  private static class LazyHolder
  {
    private static JNIOfflineDataControl sInstance = new JNIOfflineDataControl(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/nativeif/JNIOfflineDataControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */