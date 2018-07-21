package com.baidu.navisdk.jni.control;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.SDCardUtils;
import java.io.File;
import java.util.List;

public class EnvironmentUtil
{
  public static String getAppVersion()
  {
    return PackageUtil.getVersionName();
  }
  
  public static String getCachePath()
  {
    return BNaviModuleManager.getContext().getFilesDir().getAbsolutePath() + "/";
  }
  
  public static String getCuid()
  {
    return PackageUtil.getCuid();
  }
  
  public static String getImei()
  {
    return PackageUtil.getImeiNum();
  }
  
  public static int getNetStatus()
  {
    return NetworkUtils.getNetStatus();
  }
  
  public static String getOsVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String getSdcardPath()
  {
    return SDCardUtils.getExternalStoragePath();
  }
  
  public static int getsensortype()
  {
    Object localObject = (SensorManager)BNaviModuleManager.getContext().getSystemService("sensor");
    int i2 = 0;
    int n = 0;
    int i4 = 0;
    int k = 0;
    int i5 = 0;
    int j = 0;
    int i6 = 0;
    int i = 0;
    int i3 = 0;
    int m = 0;
    localObject = ((SensorManager)localObject).getSensorList(-1);
    int i7 = ((List)localObject).size();
    if (i7 > 0)
    {
      int i1 = 0;
      i2 = n;
      i3 = m;
      i4 = k;
      i5 = j;
      i6 = i;
      if (i1 < i7)
      {
        i2 = n;
        i3 = m;
        i4 = k;
        i5 = j;
        i6 = i;
        switch (((Sensor)((List)localObject).get(i1)).getType())
        {
        default: 
          i6 = i;
          i5 = j;
          i4 = k;
          i3 = m;
          i2 = n;
        }
        for (;;)
        {
          i1 += 1;
          n = i2;
          m = i3;
          k = i4;
          j = i5;
          i = i6;
          break;
          i4 = 2;
          i2 = n;
          i3 = m;
          i5 = j;
          i6 = i;
          continue;
          i2 = 1;
          i3 = m;
          i4 = k;
          i5 = j;
          i6 = i;
          continue;
          i5 = 4;
          i2 = n;
          i3 = m;
          i4 = k;
          i6 = i;
          continue;
          i6 = 8;
          i2 = n;
          i3 = m;
          i4 = k;
          i5 = j;
          continue;
          i3 = 16;
          i2 = n;
          i4 = k;
          i5 = j;
          i6 = i;
        }
      }
    }
    return i2 | i4 | i5 | i6 | i3;
  }
  
  public static String phonetype()
  {
    if ((Build.MODEL == null) || (TextUtils.isEmpty(Build.MODEL))) {
      return "unKnown";
    }
    return Build.MODEL;
  }
  
  public static void startSensor() {}
  
  public static void stopSensor() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/control/EnvironmentUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */