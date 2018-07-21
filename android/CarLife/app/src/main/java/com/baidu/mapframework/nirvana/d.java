package com.baidu.mapframework.nirvana;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class d
{
  private static final String a = "DEFAULT";
  private static final int b = 60;
  private static final int c = Runtime.getRuntime().availableProcessors();
  private static final int d = Math.max(2, Math.min(c - 1, 4));
  private static final int e = Math.min(c * 2 + 1, 8);
  private static ExecutorService f = a("DEFAULT");
  
  public static int a(int paramInt)
  {
    return Math.min(e, paramInt);
  }
  
  public static ExecutorService a()
  {
    return f;
  }
  
  public static ExecutorService a(String paramString)
  {
    paramString = new j(e, e, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new i(paramString));
    try
    {
      paramString.setKeepAliveTime(60L, TimeUnit.SECONDS);
      paramString.allowCoreThreadTimeOut(true);
      return paramString;
    }
    catch (Exception localException)
    {
      n.a("NirvanaExecutors newFixedThreadPool allowCoreThreadTimeOut", localException);
    }
    return paramString;
  }
  
  public static ExecutorService a(String paramString, int paramInt)
  {
    return new j(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new i(paramString));
  }
  
  public static ExecutorService b(String paramString)
  {
    return new j(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new SynchronousQueue(), new i(paramString));
  }
  
  public static ScheduledThreadPoolExecutor b(String paramString, int paramInt)
  {
    return new f(paramInt, new i(paramString));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */