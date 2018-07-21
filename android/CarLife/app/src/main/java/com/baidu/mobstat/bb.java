package com.baidu.mobstat;

import android.os.Build.VERSION;

public final class bb
{
  public static boolean a = true;
  public static final String b;
  public static final String c;
  
  static
  {
    if (Build.VERSION.SDK_INT < 9)
    {
      str = "http://datax.baidu.com/xs.gif";
      b = str;
      if (Build.VERSION.SDK_INT >= 9) {
        break label41;
      }
    }
    label41:
    for (String str = "http://dxp.baidu.com/upgrade";; str = "https://dxp.baidu.com/upgrade")
    {
      c = str;
      return;
      str = "https://datax.baidu.com/xs.gif";
      break;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */