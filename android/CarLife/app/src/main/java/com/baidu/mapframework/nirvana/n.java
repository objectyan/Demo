package com.baidu.mapframework.nirvana;

import android.util.Log;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import org.jetbrains.annotations.NotNull;

public class n
{
  private static final String a = "NIRVANA";
  
  public static void a(@NotNull String paramString)
  {
    if (e.a()) {
      Log.d("NIRVANA", paramString);
    }
  }
  
  public static void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    if (e.a()) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void a(@NotNull String paramString, @NotNull Throwable paramThrowable)
  {
    Log.e("NIRVANA", paramString, paramThrowable);
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if ((e.a()) && (!paramBoolean)) {
      throw new AssertionError(paramString);
    }
  }
  
  public static boolean a(Module paramModule, g paramg, ScheduleConfig paramScheduleConfig)
  {
    boolean bool2 = true;
    if (paramModule != null)
    {
      bool1 = true;
      a(bool1, "executeTask module 不能为空");
      if (paramg == null) {
        break label75;
      }
      bool1 = true;
      label21:
      a(bool1, "executeTask task 不能为空");
      if (paramScheduleConfig == null) {
        break label80;
      }
    }
    label75:
    label80:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(bool1, "executeTask config 不能为空");
      if ((paramModule != null) && (paramg != null))
      {
        bool1 = bool2;
        if (paramScheduleConfig != null) {}
      }
      else
      {
        a("executeTask param error", new Throwable());
        bool1 = false;
      }
      return bool1;
      bool1 = false;
      break;
      bool1 = false;
      break label21;
    }
  }
  
  public static void b(@NotNull String paramString1, @NotNull String paramString2)
  {
    if (e.a()) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void c(@NotNull String paramString1, @NotNull String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */