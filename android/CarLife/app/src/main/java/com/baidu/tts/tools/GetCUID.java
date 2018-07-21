package com.baidu.tts.tools;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

public class GetCUID
{
  public static String getCUID(Context paramContext)
  {
    String str = SharedPreferencesUtils.getString(paramContext, "CUID", "");
    if (TextUtils.isEmpty(str))
    {
      str = CommonParam.getCUID(paramContext);
      SharedPreferencesUtils.putString(paramContext, "CUID", str);
      return str;
    }
    LoggerProxy.d("Device", "read deviceID:" + str);
    return str;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/GetCUID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */