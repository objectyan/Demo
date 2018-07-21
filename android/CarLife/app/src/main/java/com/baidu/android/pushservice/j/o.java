package com.baidu.android.pushservice.j;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.i;
import java.util.Iterator;
import java.util.List;

public class o
{
  public static void a(Context paramContext)
  {
    com.baidu.android.pushservice.g.a.a("ServiceUtils", "--- Start Service from " + paramContext.getPackageName(), paramContext.getApplicationContext());
    if (com.baidu.android.pushservice.a.b(paramContext))
    {
      b(paramContext);
      com.baidu.android.pushservice.a.a(paramContext, false);
      return;
    }
    d(paramContext);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    Intent localIntent;
    if (paramIntent != null)
    {
      localIntent = paramIntent;
      if (!TextUtils.isEmpty(paramIntent.getAction())) {}
    }
    else
    {
      localIntent = c(paramContext);
    }
    if (!com.baidu.android.pushservice.c.d.g(paramContext))
    {
      a(paramContext, localIntent, p.v(paramContext));
      return;
    }
    i.a(paramContext).a(localIntent);
  }
  
  private static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramIntent.setPackage(paramString);
    }
    com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService go on pkgName = " + paramString, paramContext.getApplicationContext());
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramIntent.setClassName(paramString, "com.baidu.android.pushservice.PushService");
        paramContext.startService(paramIntent);
        com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService by startService", paramContext.getApplicationContext());
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        com.baidu.android.pushservice.g.a.b("ServiceUtils", "START SERVICE E: " + localException, paramContext.getApplicationContext());
      } while ((p.G(paramContext)) || (!p.i(paramContext, paramString)));
      try
      {
        String str = p.c(paramContext, paramString, paramIntent.getAction());
        if (!TextUtils.isEmpty(str))
        {
          paramIntent.setClassName(paramString, str);
          paramContext.sendBroadcast(paramIntent);
          com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService by sendBroadcast", paramContext.getApplicationContext());
          return;
        }
      }
      catch (Exception paramString)
      {
        com.baidu.android.pushservice.g.a.b("ServiceUtils", "START SERVICE E-2: " + paramString, paramContext.getApplicationContext());
        paramContext.sendBroadcast(paramIntent);
        com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService by sendBroadcast all", paramContext.getApplicationContext());
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = c(paramContext);
    if (!p.F(paramContext))
    {
      localIntent.putExtra("method", "pushservice_restart_v2");
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramContext.getPackageName()))) {
        localIntent.putExtra("priority2", Long.MAX_VALUE);
      }
    }
    for (;;)
    {
      a(paramContext, localIntent, paramString);
      return;
      localIntent.putExtra("method", "pushservice_restart_v3");
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramContext.getPackageName()))) {
        localIntent.putExtra("priority3", Long.MAX_VALUE);
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      Object localObject = p.u(paramContext);
      long l = p.g(paramContext, (String)localObject);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(paramContext.getPackageName())) && (((com.baidu.android.pushservice.c.d.a(paramContext).b() != 4) && (l < p.h(paramContext))) || (com.baidu.android.pushservice.c.d.a(paramContext).b() == 3)))
      {
        a(paramContext, (String)localObject);
        return;
      }
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals(paramContext.getPackageName())))
      {
        localObject = p.r(paramContext);
        if (!((List)localObject).isEmpty())
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if ((!paramContext.getPackageName().equals(str)) && (((p.F(paramContext)) && (p.z(paramContext, str))) || ((!p.F(paramContext)) && (!p.z(paramContext, str))))) {
              a(paramContext, str);
            }
          }
        }
      }
    }
  }
  
  public static void b(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, paramContext.getPackageName());
  }
  
  public static Intent c(Context paramContext)
  {
    Intent localIntent = new Intent("com.baidu.android.pushservice.action.METHOD");
    localIntent.addFlags(32);
    try
    {
      localIntent.putExtra("pkg_name", paramContext.getPackageName());
      localIntent.putExtra("method_version", "V2");
      if (!p.F(paramContext))
      {
        localIntent.putExtra("priority2", p.h(paramContext));
        return localIntent;
      }
      localIntent.putExtra("priority3", p.h(paramContext));
      return localIntent;
    }
    catch (Exception paramContext) {}
    return localIntent;
  }
  
  public static void d(final Context paramContext)
  {
    com.baidu.android.pushservice.c.d.a(paramContext).e();
    if (com.baidu.android.pushservice.c.d.g(paramContext)) {
      return;
    }
    String str2 = p.u(paramContext);
    final String str1 = p.v(paramContext);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      a(paramContext, str2);
    }
    paramContext = paramContext.getApplicationContext();
    com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("checkAndStartPushService", (short)98)
    {
      public void a()
      {
        bool2 = false;
        boolean bool3 = false;
        label178:
        do
        {
          do
          {
            do
            {
              try
              {
                localObject1 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(1000);
                if (!p.F(paramContext)) {
                  break label178;
                }
                if (!p.r(paramContext).contains(str1)) {
                  break;
                }
                localObject1 = com.baidu.android.pushservice.k.c.a("netstat -ant", null).iterator();
                do
                {
                  do
                  {
                    if (!((Iterator)localObject1).hasNext()) {
                      break;
                    }
                    localObject2 = (String)((Iterator)localObject1).next();
                  } while (!((String)localObject2).toUpperCase().contains("ESTABLISHED"));
                  bool1 = ((String)localObject2).contains(String.valueOf(h.b));
                } while (!bool1);
                bool1 = true;
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  Object localObject1;
                  Object localObject2;
                  Object localObject3;
                  boolean bool1 = bool2;
                  com.baidu.android.pushservice.g.a.b("ServiceUtils", localException1.getMessage(), paramContext);
                  continue;
                  bool1 = false;
                  continue;
                  bool1 = bool2;
                }
              }
              com.baidu.android.pushservice.g.a.a("ServiceUtils", "checkAndStartPushService, running is " + bool1, paramContext.getApplicationContext());
              if (!bool1) {
                o.a(paramContext, new Intent());
              }
              o.e(paramContext);
              return;
              bool1 = bool3;
            } while (TextUtils.isEmpty(str1));
            bool1 = bool3;
          } while (localObject1 == null);
          bool1 = bool3;
        } while (((List)localObject1).isEmpty());
        localObject1 = ((List)localObject1).iterator();
        do
        {
          bool1 = bool3;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ActivityManager.RunningServiceInfo)((Iterator)localObject1).next();
          localObject3 = ((ActivityManager.RunningServiceInfo)localObject2).service.getPackageName();
        } while ((!((ActivityManager.RunningServiceInfo)localObject2).service.getClassName().equals("com.baidu.android.pushservice.PushService")) || (!str1.equals(localObject3)));
        localObject1 = com.baidu.android.pushservice.k.c.a("netstat -ant", null).iterator();
        bool1 = false;
        bool2 = bool1;
        for (;;)
        {
          try
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label446;
            }
            localObject2 = (String)((Iterator)localObject1).next();
            if (bool1)
            {
              bool2 = bool1;
              break label446;
            }
            if (!((String)localObject2).toUpperCase().contains("ESTABLISHED")) {
              continue;
            }
            if (((String)localObject2).contains(String.valueOf(h.a)))
            {
              bool2 = true;
              break label446;
            }
            localObject3 = h.c;
            int j = localObject3.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            bool2 = ((String)localObject2).contains(localObject3[i]);
            if (bool2) {
              bool1 = true;
            }
          }
          catch (Exception localException2)
          {
            int i;
            continue;
            continue;
          }
          i += 1;
        }
      }
    });
  }
  
  public static void e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (p.F(paramContext))
        {
          Object localObject1 = p.r(paramContext);
          Object localObject2 = p.n(paramContext.getApplicationContext());
          Iterator localIterator = ((List)localObject2).iterator();
          if (!localIterator.hasNext()) {
            break label118;
          }
          if (!((List)localObject1).contains(((ResolveInfo)localIterator.next()).activityInfo.packageName)) {
            continue;
          }
          i = 1;
          if (i == 0)
          {
            localObject1 = ((List)localObject2).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ResolveInfo)((Iterator)localObject1).next();
              a(paramContext, new Intent(), ((ResolveInfo)localObject2).activityInfo.packageName);
              continue;
            }
          }
        }
        return;
      }
      catch (Exception paramContext) {}
      label118:
      int i = 0;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */