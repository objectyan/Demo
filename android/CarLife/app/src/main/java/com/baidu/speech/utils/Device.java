package com.baidu.speech.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

public final class Device
{
  private static final String TAG = "Device";
  
  public static String getDevID(Context paramContext)
  {
    String str = PreferenceSetting.getString(paramContext, "device_id", "");
    if (TextUtils.isEmpty(str))
    {
      str = CommonParam.getCUID(paramContext);
      PreferenceSetting.setString(paramContext, "device_id", str);
      return str;
    }
    Log.d("Device", "read deviceID:" + str);
    return str;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/utils/Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */