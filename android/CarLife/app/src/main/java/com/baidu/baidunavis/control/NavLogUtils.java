package com.baidu.baidunavis.control;

import com.baidu.navisdk.util.common.LogUtil;

public class NavLogUtils
{
  public static boolean LOGGABLE = false;
  
  public static void e(String paramString1, String paramString2)
  {
    try
    {
      LogUtil.e(paramString1, paramString2);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static String getCallStack()
  {
    return LogUtil.getCallStack();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavLogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */