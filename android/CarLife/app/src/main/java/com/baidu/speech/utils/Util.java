package com.baidu.speech.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;

public final class Util
{
  public static String getDevId(TelephonyManager paramTelephonyManager)
  {
    if (paramTelephonyManager == null) {
      return "";
    }
    try
    {
      paramTelephonyManager = paramTelephonyManager.getClass().getMethod("get" + getDevName() + "Id", new Class[0]).invoke(paramTelephonyManager, new Object[0]);
      if ((paramTelephonyManager instanceof String))
      {
        paramTelephonyManager = (String)paramTelephonyManager;
        return paramTelephonyManager;
      }
    }
    catch (Exception paramTelephonyManager)
    {
      paramTelephonyManager.printStackTrace();
    }
    return "";
  }
  
  private static String getDevName()
  {
    return "Device";
  }
  
  public static String pfm(Context paramContext)
    throws SecurityException
  {
    boolean bool = Utility.isUsingWifi(paramContext);
    String str = Utility.generatePlatformString();
    if (bool) {}
    Object localObject1;
    for (str = str + "&1";; str = str + "&3")
    {
      localObject1 = str;
      try
      {
        Object localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
        paramContext = str;
        if (localObject2 != null)
        {
          localObject1 = str;
          localObject2 = getDevId((TelephonyManager)localObject2);
          paramContext = str;
          localObject1 = str;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = str;
            paramContext = str + "&";
            localObject1 = paramContext;
            paramContext = paramContext + (String)localObject2;
          }
        }
        return paramContext;
      }
      catch (Exception paramContext) {}
    }
    return (String)localObject1;
  }
  
  public static String toMd5(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return MD5Util.toMd5(paramArrayOfByte, paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/utils/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */