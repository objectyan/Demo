package com.baidu.platform.comapi.util;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;

public class k
{
  private String a;
  private long b;
  private long c;
  private String d;
  private String e;
  private String f;
  private int g;
  
  public k()
  {
    this("Profiler");
  }
  
  public k(String paramString)
  {
    this.a = paramString;
    this.g = Process.myPid();
  }
  
  public static void a(Runnable paramRunnable)
  {
    a("Profiler", 3, paramRunnable);
  }
  
  private static void a(String paramString, int paramInt, Runnable paramRunnable)
  {
    paramString = new k(paramString);
    paramString.a(paramInt);
    paramRunnable.run();
    paramString.b();
  }
  
  public static void a(String paramString, Runnable paramRunnable)
  {
    a(paramString, 3, paramRunnable);
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("[").append(this.e).append("() <- ").append(this.d).append("] ");
    StringBuilder localStringBuilder = paramStringBuilder.append("[");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (String str = "on UI thread";; str = "not on UI thread")
    {
      localStringBuilder.append(str).append("] ");
      paramStringBuilder.append(" <").append(this.f).append("> ");
      return;
    }
  }
  
  private k c()
  {
    if (this.b == 0L)
    {
      this.b = SystemClock.uptimeMillis();
      return this;
    }
    this.c = (SystemClock.uptimeMillis() - this.b);
    this.b = 0L;
    return this;
  }
  
  private k d()
  {
    if (this.b == 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("[%5d ms]", new Object[] { Long.valueOf(this.c) })).append(" ");
      a(localStringBuilder);
      f.b(this.a, localStringBuilder.toString());
    }
    return this;
  }
  
  public k a()
  {
    return a(1);
  }
  
  public k a(int paramInt)
  {
    StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[paramInt];
    this.d = localStackTraceElement.getClassName();
    paramInt = this.d.lastIndexOf('.');
    if (paramInt != -1) {
      this.d = this.d.substring(paramInt + 1);
    }
    this.e = localStackTraceElement.getMethodName();
    this.f = localStackTraceElement.getFileName();
    return c();
  }
  
  public k b()
  {
    c();
    return d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */