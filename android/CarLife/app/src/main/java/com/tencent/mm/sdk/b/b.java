package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;

public final class b
{
  private static a aG;
  private static a aH;
  private static final String aI;
  private static int level = 6;
  
  static
  {
    Object localObject = new c();
    aG = (a)localObject;
    aH = (a)localObject;
    localObject = new StringBuilder();
    try
    {
      ((StringBuilder)localObject).append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
      ((StringBuilder)localObject).append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
      ((StringBuilder)localObject).append("] BOARD:[" + Build.BOARD);
      ((StringBuilder)localObject).append("] DEVICE:[" + Build.DEVICE);
      ((StringBuilder)localObject).append("] DISPLAY:[" + Build.DISPLAY);
      ((StringBuilder)localObject).append("] FINGERPRINT:[" + Build.FINGERPRINT);
      ((StringBuilder)localObject).append("] HOST:[" + Build.HOST);
      ((StringBuilder)localObject).append("] MANUFACTURER:[" + Build.MANUFACTURER);
      ((StringBuilder)localObject).append("] MODEL:[" + Build.MODEL);
      ((StringBuilder)localObject).append("] PRODUCT:[" + Build.PRODUCT);
      ((StringBuilder)localObject).append("] TAGS:[" + Build.TAGS);
      ((StringBuilder)localObject).append("] TYPE:[" + Build.TYPE);
      ((StringBuilder)localObject).append("] USER:[" + Build.USER + "]");
      aI = ((StringBuilder)localObject).toString();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((aH != null) && (aH.getLogLevel() <= 4)) {
      if (paramVarArgs != null) {
        break label65;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = aH;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString2.i(paramString1, paramVarArgs);
      return;
      label65:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if ((aH != null) && (aH.getLogLevel() <= 3))
    {
      a locala = aH;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      locala.h(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if ((aH != null) && (aH.getLogLevel() <= 2))
    {
      a locala = aH;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      locala.f(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if ((aH != null) && (aH.getLogLevel() <= 1))
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      paramString2 = aH;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString2.g(paramString1, str);
    }
  }
  
  public static abstract interface a
  {
    public abstract void f(String paramString1, String paramString2);
    
    public abstract void g(String paramString1, String paramString2);
    
    public abstract int getLogLevel();
    
    public abstract void h(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */