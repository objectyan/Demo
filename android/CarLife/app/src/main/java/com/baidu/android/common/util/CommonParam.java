package com.baidu.android.common.util;

import android.content.Context;

public class CommonParam
{
  private static final boolean DEBUG = false;
  private static final String TAG = CommonParam.class.getSimpleName();
  
  public static String getCUID(Context paramContext)
  {
    return DeviceId.getCUID(paramContext);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/common/util/CommonParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */