package com.baidu.speech.core;

import android.util.Log;

public class LogUtil
{
  public static boolean DEBUG = false;
  public static final String TAG = "Android_Audio";
  
  public static void log_d(String paramString)
  {
    if (DEBUG) {
      Log.d("Android_Audio", paramString);
    }
  }
  
  public static void log_e(String paramString)
  {
    if (DEBUG) {
      Log.e("Android_Audio", paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/core/LogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */