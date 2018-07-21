package com.baidu.speech.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;

public class Policy
{
  public static String app(Context paramContext)
  {
    if ("com.baidu.speech.demo".equals(paramContext.getPackageName())) {
      return "";
    }
    return paramContext.getPackageName();
  }
  
  public static String modelVadDefaultResFile(Context paramContext)
  {
    return String.format("%s/%s", new Object[] { paramContext.getApplicationInfo().nativeLibraryDir, "libbd_easr_s1_merge_normal_20151216.dat.so" });
  }
  
  public static String pfm(Context paramContext)
  {
    return Util.pfm(paramContext);
  }
  
  public static int sample(Context paramContext)
  {
    if (Utility.is2G(paramContext)) {
      return 8000;
    }
    return 16000;
  }
  
  public static int taskTimeout()
  {
    return 30000;
  }
  
  public static String uiRetryFile(Context paramContext)
  {
    return new File(paramContext.getCacheDir(), "bd_asr_ui_repeat.pcm").toString();
  }
  
  public static String uid(Context paramContext)
  {
    return Device.getDevID(paramContext);
  }
  
  public static String ver(Context paramContext)
  {
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/utils/Policy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */