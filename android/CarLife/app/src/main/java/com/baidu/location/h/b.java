package com.baidu.location.h;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.baidu.android.bbalbs.common.a.a;
import com.baidu.android.bbalbs.common.a.c;
import com.baidu.location.a.i;
import com.baidu.location.f;
import java.util.Locale;

public class b
{
  public static String d = null;
  public static String e = null;
  public static String f = null;
  public static String g = null;
  private static b h = null;
  public String a = null;
  public String b = null;
  public String c = null;
  private boolean i = false;
  
  private b()
  {
    if (f.getServiceContext() != null) {
      a(f.getServiceContext());
    }
  }
  
  public static b a()
  {
    if (h == null) {
      h = new b();
    }
    return h;
  }
  
  public String a(boolean paramBoolean)
  {
    return a(paramBoolean, null);
  }
  
  public String a(boolean paramBoolean, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("&sdk=");
    localStringBuffer.append(7.32F);
    if (paramBoolean)
    {
      if (g.g.equals("all")) {
        localStringBuffer.append("&addr=allj");
      }
      if ((g.h) || (g.j) || (g.k) || (g.i))
      {
        localStringBuffer.append("&sema=");
        if (g.h) {
          localStringBuffer.append("aptag|");
        }
        if (g.i) {
          localStringBuffer.append("aptagd|");
        }
        if (g.j) {
          localStringBuffer.append("poiregion|");
        }
        if (g.k) {
          localStringBuffer.append("regular");
        }
      }
    }
    if (paramBoolean)
    {
      if (paramString == null) {
        localStringBuffer.append("&coor=gcj02");
      }
    }
    else
    {
      if (this.b != null) {
        break label427;
      }
      localStringBuffer.append("&im=");
      localStringBuffer.append(this.a);
    }
    for (;;)
    {
      if (this.c != null)
      {
        localStringBuffer.append("&Aid=");
        localStringBuffer.append(this.c);
      }
      localStringBuffer.append("&fw=");
      localStringBuffer.append(f.getFrameVersion());
      localStringBuffer.append("&lt=1");
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      paramString = g.d();
      if (paramString != null)
      {
        localStringBuffer.append("&laip=");
        localStringBuffer.append(paramString);
      }
      float f1 = i.a().e();
      if (f1 != 0.0F)
      {
        localStringBuffer.append("&altv=");
        localStringBuffer.append(String.format(Locale.US, "%.2f", new Object[] { Float.valueOf(f1) }));
      }
      localStringBuffer.append("&resid=");
      localStringBuffer.append("13");
      localStringBuffer.append("&os=A");
      localStringBuffer.append(Build.VERSION.SDK);
      if (paramBoolean)
      {
        localStringBuffer.append("&sv=");
        String str = Build.VERSION.RELEASE;
        paramString = str;
        if (str != null)
        {
          paramString = str;
          if (str.length() > 6) {
            paramString = str.substring(0, 6);
          }
        }
        localStringBuffer.append(paramString);
      }
      return localStringBuffer.toString();
      localStringBuffer.append("&coor=");
      localStringBuffer.append(paramString);
      break;
      label427:
      localStringBuffer.append("&cu=");
      localStringBuffer.append(this.b);
      if ((this.a != null) && (!this.a.equals("NULL")) && (!this.b.contains(new StringBuffer(this.a).reverse().toString())))
      {
        localStringBuffer.append("&Aim=");
        localStringBuffer.append(this.a);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if ((paramContext == null) || (this.i)) {
      return;
    }
    try
    {
      this.a = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    catch (Exception localException3)
    {
      try
      {
        this.b = a.a(paramContext);
      }
      catch (Exception localException3)
      {
        try
        {
          this.c = c.b(paramContext);
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              d = paramContext.getPackageName();
              g.n = "" + this.b;
              this.i = true;
              return;
              localException1 = localException1;
              this.a = "NULL";
              continue;
              localException2 = localException2;
              this.b = null;
              continue;
              localException3 = localException3;
              this.c = null;
            }
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              d = null;
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    e = paramString1;
    d = paramString2;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    if (this.b != null) {
      return "v7.32|" + this.b + "|" + Build.MODEL;
    }
    return "v7.32|" + this.a + "|" + Build.MODEL;
  }
  
  public String d()
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    if (this.b != null)
    {
      localStringBuffer.append("&cu=");
      localStringBuffer.append(this.b);
    }
    try
    {
      for (;;)
      {
        localStringBuffer.append("&mb=");
        localStringBuffer.append(Build.MODEL);
        localStringBuffer.append("&pack=");
        try
        {
          localStringBuffer.append(d);
          localStringBuffer.append("&sdk=");
          localStringBuffer.append(7.32F);
          return localStringBuffer.toString();
          localStringBuffer.append("&im=");
          localStringBuffer.append(this.a);
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public String e()
  {
    return "&sdk=7.32" + d();
  }
  
  public String f()
  {
    if (d != null) {
      return c() + "|" + d;
    }
    return c();
  }
  
  public String g()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.b == null)
    {
      localStringBuffer.append("&im=");
      localStringBuffer.append(this.a);
    }
    for (;;)
    {
      localStringBuffer.append("&sdk=");
      localStringBuffer.append(7.32F);
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      localStringBuffer.append("&os=A");
      localStringBuffer.append(Build.VERSION.SDK);
      localStringBuffer.append("&prod=");
      localStringBuffer.append(e + ":" + d);
      localStringBuffer.append(g.e(f.getServiceContext()));
      localStringBuffer.append("&resid=");
      localStringBuffer.append("13");
      return localStringBuffer.toString();
      localStringBuffer.append("&cu=");
      localStringBuffer.append(this.b);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */