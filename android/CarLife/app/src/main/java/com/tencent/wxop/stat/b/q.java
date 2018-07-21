package com.tencent.wxop.stat.b;

import java.io.File;

class q
{
  private static int a = -1;
  
  public static boolean a()
  {
    if (a == 1) {
      return true;
    }
    if (a == 0) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i < 6)
      {
        try
        {
          if (!new File(new String[] { "/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/" }[i] + "su").exists()) {
            break label106;
          }
          a = 1;
          return true;
        }
        catch (Exception localException) {}
      }
      else
      {
        a = 0;
        return false;
      }
      label106:
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */