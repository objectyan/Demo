package com.baidu.ufosdk.util;

import android.util.Log;
import com.baidu.ufosdk.a;

public final class c
{
  public static String a = "UFO";
  
  public static int a(String paramString)
  {
    if (a.m <= 1) {
      return Log.d(a, paramString);
    }
    return 0;
  }
  
  public static int a(String paramString, Throwable paramThrowable)
  {
    if (a.m <= 4) {
      return Log.e(a, paramString, paramThrowable);
    }
    return 0;
  }
  
  public static int b(String paramString)
  {
    if (a.m <= 2) {
      return Log.i(a, paramString);
    }
    return 0;
  }
  
  public static int c(String paramString)
  {
    if (a.m <= 3) {
      return Log.w(a, paramString);
    }
    return 0;
  }
  
  public static int d(String paramString)
  {
    if (a.m <= 4) {
      return Log.e(a, paramString);
    }
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */