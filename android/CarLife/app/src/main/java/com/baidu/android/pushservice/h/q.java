package com.baidu.android.pushservice.h;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.d.a;
import com.baidu.android.pushservice.i.c;
import com.baidu.android.pushservice.i.d;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.a.l;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

public class q
{
  private final Context a;
  private g b;
  private final o c;
  
  public q(Context paramContext)
  {
    this.a = paramContext;
    this.c = new o(paramContext);
    this.b = g.a(paramContext);
  }
  
  public static long a(Context paramContext, b paramb)
  {
    return a.a(paramContext, paramb);
  }
  
  public static long a(Context paramContext, f paramf)
  {
    return a.a(paramContext, paramf);
  }
  
  public static long a(Context paramContext, i parami)
  {
    return a.a(paramContext, parami);
  }
  
  public static long a(Context paramContext, j paramj)
  {
    return a.a(paramContext, paramj);
  }
  
  public static long a(Context paramContext, k paramk)
  {
    return a.a(paramContext, paramk);
  }
  
  public static long a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    i locali = new i();
    locali.e = System.currentTimeMillis();
    locali.f = com.baidu.android.pushservice.h.a.b.b(paramContext);
    locali.g = paramInt;
    locali.i = paramString2;
    locali.d = paramString1;
    return a(paramContext, locali);
  }
  
  public static long a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    b localb = new b();
    localb.d = paramString1;
    localb.j = paramString2;
    localb.g = paramInt;
    localb.a = paramString3;
    localb.e = System.currentTimeMillis();
    localb.f = com.baidu.android.pushservice.h.a.b.b(paramContext);
    return a(paramContext, localb);
  }
  
  public static String a(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (localRunningAppProcessInfo.pid == i) {
            return localRunningAppProcessInfo.processName;
          }
        }
      }
    }
    return "";
  }
  
  public static void a(final Context paramContext, final String paramString)
  {
    d.a().a(new c("insertNetworkInfo", (short)95)
    {
      public void a()
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("pst", 4);
        long l = localSharedPreferences.getLong(paramString, 0L);
        if (System.currentTimeMillis() - l < 1800000L) {
          return;
        }
        if (paramString.equals("039912")) {}
        for (Object localObject = p.w(paramContext);; localObject = p.x(paramContext))
        {
          q.a(paramContext, paramString, 0, (String)localObject);
          localObject = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject).putLong(paramString, System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
      }
    });
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2)
  {
    d.a().a(new c("insertNotificationAction", (short)90)
    {
      public void a()
      {
        k localk = new k();
        localk.d = paramString2;
        localk.a = paramString1;
        localk.e = System.currentTimeMillis();
        localk.f = com.baidu.android.pushservice.h.a.b.b(paramContext);
        localk.c = l.f.a();
        localk.h = PushSettings.b(paramContext);
        localk.j = paramContext.getPackageName();
        q.a(paramContext, localk);
      }
    });
  }
  
  public static void a(Context paramContext, Throwable paramThrowable)
  {
    f localf = new f();
    localf.d = "040102";
    localf.e = System.currentTimeMillis();
    localf.f = com.baidu.android.pushservice.h.a.b.b(paramContext);
    localf.a = b(paramContext, paramThrowable);
    a(paramContext, localf);
  }
  
  public static long b(Context paramContext, i parami)
  {
    return a.b(paramContext, parami);
  }
  
  public static String b(Context paramContext, Throwable paramThrowable)
  {
    Object localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    while (paramThrowable != null)
    {
      paramThrowable.printStackTrace(localPrintWriter);
      paramThrowable = paramThrowable.getCause();
    }
    paramThrowable = localObject.toString();
    localObject = a(paramContext);
    paramContext = paramThrowable;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramContext = (String)localObject + "\n" + paramThrowable;
    }
    localPrintWriter.close();
    return paramContext;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    f localf = new f();
    localf.d = "040101";
    localf.e = System.currentTimeMillis();
    localf.f = com.baidu.android.pushservice.h.a.b.b(paramContext);
    localf.a = paramString;
    a(paramContext, localf);
  }
  
  private boolean b()
  {
    if ((PushSettings.i(this.a)) || (this.b.c())) {}
    for (;;)
    {
      return false;
      long l2 = System.currentTimeMillis();
      long l3 = com.baidu.android.pushservice.j.g.b(this.a);
      if (PushSettings.h(this.a)) {}
      for (long l1 = PushSettings.g(this.a); l2 - l3 > l1; l1 = 43200000L) {
        return true;
      }
    }
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.b();
    }
  }
  
  public void a(boolean paramBoolean, com.baidu.android.pushservice.j.f paramf)
  {
    if (this.b == null) {
      this.b = g.a(this.a);
    }
    this.b.a(paramf);
    if ((paramBoolean) || (b())) {
      this.b.b(paramBoolean);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */