package com.baidu.speech.utils;

import android.content.Context;
import android.text.TextUtils;

public class CommonParam
{
  public static String AGENT_URL = "";
  private static final boolean DEBUG = false;
  public static String REQUEST_URL;
  private static final String TAG = CommonParam.class.getSimpleName();
  
  static
  {
    REQUEST_URL = "";
  }
  
  public static String getCUID(Context paramContext)
  {
    String str2 = getDevId(paramContext);
    String str1 = DeviceId.getIntlMobEqId(paramContext);
    paramContext = str1;
    if (TextUtils.isEmpty(str1)) {
      paramContext = "0";
    }
    paramContext = new StringBuffer(paramContext).reverse().toString();
    return str2 + "|" + paramContext;
  }
  
  private static String getDevId(Context paramContext)
  {
    return DeviceId.getDevID(paramContext);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/utils/CommonParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */