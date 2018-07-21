package com.baidu.platform.comjni.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.platform.comapi.c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class a
{
  private static final int a = 1024;
  private static final int b = 20480;
  private static final String c = a.class.getName();
  private static Handler d = new Handler(Looper.getMainLooper());
  
  public static String a()
  {
    int i = 0;
    Object localObject1 = c.f();
    if (localObject1 == null) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    try
    {
      localObject1 = (ActivityManager)((Context)localObject1).getSystemService("activity");
      localStringBuilder.append("HeapMax:").append(((ActivityManager)localObject1).getMemoryClass()).append(",");
      localStringBuilder.append("DvmTotal:").append(Runtime.getRuntime().totalMemory() / 1024L).append(",");
      localStringBuilder.append("DvmFree:").append(Runtime.getRuntime().freeMemory() / 1024L).append(",");
      localObject1 = ((ActivityManager)localObject1).getProcessMemoryInfo(new int[] { Process.myPid() });
      if (localObject1 != null)
      {
        int j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          localStringBuilder.append("Pss:").append(((Debug.MemoryInfo)localObject2).getTotalPss()).append(",");
          localStringBuilder.append("Private:").append(((Debug.MemoryInfo)localObject2).getTotalPrivateDirty()).append(",");
          localStringBuilder.append("Shared:").append(((Debug.MemoryInfo)localObject2).getTotalSharedDirty());
          i += 1;
        }
      }
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      localStringBuilder.append("get memory info error");
    }
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    do
    {
      return paramString1;
      paramString2 = paramString1.getBytes();
    } while (paramString2.length <= 20480);
    return new String(paramString2, 0, 20480);
  }
  
  public static void a(Throwable paramThrowable)
  {
    d.post(new Runnable()
    {
      public void run()
      {
        a.c(this.a);
      }
    });
  }
  
  public static String b(Throwable paramThrowable)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new ByteArrayOutputStream();
      localObject1 = localObject2;
      paramThrowable.printStackTrace(new PrintStream((OutputStream)localObject3));
      localObject1 = localObject2;
      ((ByteArrayOutputStream)localObject3).close();
      localObject1 = localObject2;
      paramThrowable = ((ByteArrayOutputStream)localObject3).toString();
      localObject1 = paramThrowable;
      localObject2 = new StringBuilder();
      localObject1 = paramThrowable;
      localObject3 = paramThrowable.split("Caused by: ");
      localObject1 = paramThrowable;
      i = localObject3.length - 1;
      while (i >= 0)
      {
        localObject1 = paramThrowable;
        ((StringBuilder)localObject2).append(localObject3[i]);
        i -= 1;
      }
      localObject1 = paramThrowable;
      paramThrowable = a(((StringBuilder)localObject2).toString(), paramThrowable);
      localObject1 = paramThrowable;
    }
    catch (Exception paramThrowable)
    {
      int i;
      int j;
      for (;;) {}
    }
    paramThrowable = new StringBuilder();
    localObject1 = ((String)localObject1).split("\\n\\t");
    i = 0;
    j = localObject1.length;
    if (i < j)
    {
      if ((localObject1[i].startsWith("...")) || ((i > 0) && (!localObject1[i].startsWith("at")))) {}
      for (;;)
      {
        i += 1;
        break;
        if (localObject1[i].startsWith("at")) {
          paramThrowable.append("<br>");
        }
        paramThrowable.append(localObject1[i].trim());
      }
    }
    return paramThrowable.toString();
  }
  
  private static String d(Throwable paramThrowable)
  {
    paramThrowable = e(paramThrowable);
    com.baidu.platform.comapi.e.a.a().a("exception_type", "error");
    com.baidu.platform.comapi.e.a.a().a("exceptionlog");
    return paramThrowable;
  }
  
  private static String e(Throwable paramThrowable)
  {
    Object localObject2 = paramThrowable;
    for (Object localObject1 = paramThrowable; localObject1 != null; localObject1 = ((Throwable)localObject1).getCause()) {
      localObject2 = localObject1;
    }
    localObject1 = b((Throwable)localObject2);
    com.baidu.platform.comapi.e.a.a().a("reason", paramThrowable.toString());
    com.baidu.platform.comapi.e.a.a().a("detail", (String)localObject1);
    com.baidu.platform.comapi.e.a.a().a("mem_info", a());
    com.baidu.platform.comapi.e.a.a().a("cpu_abi", Build.CPU_ABI);
    if (8 <= Build.VERSION.SDK_INT) {
      com.baidu.platform.comapi.e.a.a().a("cpu_abi2", Build.CPU_ABI2);
    }
    com.baidu.platform.comapi.e.a.a().a("active_thread", String.valueOf(Thread.activeCount()));
    return (String)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */