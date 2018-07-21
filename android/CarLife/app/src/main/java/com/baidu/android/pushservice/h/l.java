package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.b.f;
import com.baidu.android.pushservice.j.p;

public class l
{
  private static void a(Context paramContext, f paramf, k paramk, j paramj)
  {
    j localj = paramj;
    if (paramf != null)
    {
      paramj.b(paramf.c());
      localj = p.a(paramj, paramContext, paramf.c());
      paramk.j = paramf.c();
    }
    try
    {
      q.a(paramContext, paramk);
      q.a(paramContext, localj);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    k localk = new k();
    localk.d = "010101";
    localk.a = paramString2;
    localk.e = System.currentTimeMillis();
    localk.f = com.baidu.android.pushservice.h.a.b.b(paramContext);
    localk.b = new String(paramArrayOfByte).length();
    localk.g = paramInt2;
    localk.c = paramInt1;
    localk.h = paramString1;
    paramString2 = new j(paramString1);
    paramString1 = com.baidu.android.pushservice.b.b.a(paramContext).d(paramString1);
    if (paramString1 != null)
    {
      paramString2.b(paramString1.c());
      if (p.D(paramContext, paramString1.c())) {
        if (p.c()) {
          paramString2.c(j.c);
        }
      }
    }
    for (;;)
    {
      a(paramContext, paramString1, localk, paramString2);
      return;
      if (p.a())
      {
        paramString2.c(j.d);
      }
      else if (p.b())
      {
        paramString2.c(j.e);
      }
      else
      {
        paramString2.c(j.b);
        continue;
        paramString2.c(j.b);
        continue;
        paramString2.b("NP");
        paramString2.c(paramInt3);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      try
      {
        k localk = new k();
        String str = null;
        if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(paramString3)) {
          str = "010601";
        }
        for (;;)
        {
          localk.d = str;
          localk.a = paramString1;
          localk.e = System.currentTimeMillis();
          localk.f = com.baidu.android.pushservice.h.a.b.b(paramContext);
          localk.c = com.baidu.android.pushservice.message.a.l.g.a();
          localk.h = paramString2;
          paramString1 = com.baidu.android.pushservice.b.b.a(paramContext).d(paramString2);
          if (paramString1 == null) {
            break;
          }
          a(paramContext, paramString1, localk, new j(paramString2));
          return;
          if ("com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(paramString3)) {
            str = "010602";
          } else if ("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(paramString3)) {
            str = "010603";
          }
        }
        return;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    k localk = new k();
    localk.d = "019901";
    localk.a = paramString2;
    localk.e = System.currentTimeMillis();
    localk.f = com.baidu.android.pushservice.h.a.b.b(paramContext);
    localk.b = new String(paramArrayOfByte).length();
    localk.g = paramInt2;
    localk.c = paramInt1;
    localk.h = paramString1;
    paramString2 = new j(paramString1);
    paramString1 = com.baidu.android.pushservice.b.b.a(paramContext).d(paramString1);
    if (paramString1 != null)
    {
      paramString2.b(paramString1.c());
      if (p.D(paramContext, paramString1.c())) {
        if (p.c()) {
          paramString2.c(j.c);
        }
      }
    }
    for (;;)
    {
      a(paramContext, paramString1, localk, paramString2);
      return;
      if (p.a())
      {
        paramString2.c(j.d);
      }
      else if (p.b())
      {
        paramString2.c(j.e);
      }
      else
      {
        paramString2.c(j.b);
        continue;
        paramString2.c(j.b);
        continue;
        paramString2.b("NP");
        paramString2.c(paramInt3);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */