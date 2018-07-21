package com.baidu.tts.tools;

import android.content.Context;
import android.text.TextUtils;

public class CommonParam
{
  private static final String a = CommonParam.class.getSimpleName();
  
  private static String a(Context paramContext)
  {
    return DeviceId.getDeviceID(paramContext);
  }
  
  public static String getCUID(Context paramContext)
  {
    String str2 = a(paramContext);
    String str1 = DeviceId.getIMEI(paramContext);
    paramContext = str1;
    if (TextUtils.isEmpty(str1)) {
      paramContext = "0";
    }
    paramContext = new StringBuffer(paramContext).reverse().toString();
    return str2 + "|" + paramContext;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/CommonParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */