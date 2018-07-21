package com.baidu.platform.comapi.map;

import android.util.Log;

public final class MapTrace
{
  static boolean enableTrace = false;
  
  public static void enable(boolean paramBoolean)
  {
    enableTrace = paramBoolean;
  }
  
  static void trace(String paramString1, String paramString2)
  {
    if (enableTrace) {
      Log.d("MapTrace-" + paramString1, "thread:" + Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + "," + paramString2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/MapTrace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */