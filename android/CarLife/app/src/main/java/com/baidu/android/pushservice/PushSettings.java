package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.d.c;
import com.baidu.android.pushservice.j.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import java.util.Iterator;
import java.util.List;

public class PushSettings
{
  private static int a = -1;
  private static int b = -1;
  private static int c = -1;
  private static int d = -1;
  private static int e = -1;
  
  public static String a(Context paramContext)
  {
    String str = b.a(paramContext, "com.baidu.pushservice.channel_id");
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      str = m.a(paramContext, "com.baidu.pushservice.channel_id");
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        str = c.d(paramContext);
        if (!TextUtils.isEmpty(str)) {
          return str;
        }
        if (!p.F(paramContext)) {
          break label115;
        }
      }
    }
    label115:
    for (localObject = p.o(paramContext.getApplicationContext());; localObject = p.n(paramContext.getApplicationContext()))
    {
      Iterator localIterator = ((List)localObject).iterator();
      localObject = str;
      while (localIterator.hasNext())
      {
        str = com.baidu.android.pushservice.d.d.a(paramContext, ((ResolveInfo)localIterator.next()).activityInfo.packageName);
        localObject = str;
        if (!TextUtils.isEmpty(str))
        {
          a(paramContext, str);
          localObject = str;
        }
      }
      return (String)localObject;
    }
    return str;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    m.a(paramContext, "com.baidu.pushservice.sd", paramInt);
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    m.a(paramContext, "com.baidu.pushservice.cst", paramLong);
  }
  
  protected static void a(Context paramContext, String paramString)
  {
    b.a(paramContext, "com.baidu.pushservice.channel_id", paramString);
    m.a(paramContext, "com.baidu.pushservice.channel_id", paramString);
    c.a(paramContext, paramString);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    int i = 0;
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramContext.getPackageName()));
      Object localObject = m.a(paramContext, "com.baidu.pushservice.le");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = ((String)localObject).trim().split(",");
        int m = localObject.length;
        int j = 0;
        if (j < m)
        {
          String str = localObject[j];
          if (str.equals(paramContext.getPackageName()))
          {
            i = 1;
            int k = 1;
            if (!paramBoolean) {
              i = k;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            localStringBuilder.append(str + ",");
          }
        }
        if (i == 0) {
          localStringBuilder.append(paramContext.getPackageName() + ",");
        }
        m.a(paramContext, "com.baidu.pushservice.le", localStringBuilder.toString());
        return;
      }
    } while (!paramBoolean);
    m.a(paramContext, "com.baidu.pushservice.le", paramContext.getPackageName() + ",");
  }
  
  public static String b(Context paramContext)
  {
    return m.a(paramContext, "com.baidu.pushservice.app_id");
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    m.a(paramContext, "com.baidu.pushservice.lsi", paramInt * 1000);
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    m.a(paramContext, "com.baidu.pushservice.st", paramLong);
  }
  
  protected static void b(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      m.a(paramContext, "com.baidu.pushservice.app_id", paramString);
    }
  }
  
  private static void b(Context paramContext, boolean paramBoolean)
  {
    for (;;)
    {
      String str1;
      try
      {
        String str2 = paramContext.getPackageName();
        String str3 = p.v(paramContext);
        str1 = "com.baidu.android.pushservice.action.OPENDEBUGMODE";
        if (TextUtils.isEmpty(str3)) {
          break label46;
        }
        if (!str2.equals(str3)) {
          break label47;
        }
        return;
      }
      catch (Exception paramContext) {}
      o.a(paramContext, new Intent(str1));
      return;
      label46:
      return;
      label47:
      if (!paramBoolean) {
        str1 = "com.baidu.android.pushservice.action.CLOSEDEBUGMODE";
      }
    }
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      localObject = m.a(paramContext, "com.baidu.pushservice.le");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = ((String)localObject).trim().split(",");
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      String str = localObject[i];
      if (str.equals(paramString)) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(str + ",");
      }
    }
    m.a(paramContext, "com.baidu.pushservice.le", localStringBuilder.toString());
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {}
    int i;
    do
    {
      return false;
      i = m.d(paramContext, "com.baidu.android.pushservice.PushSettings.debug_mode", -1);
      if (a != 1) {
        break;
      }
    } while ((i != -1) && (i != 1));
    return true;
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static long d(Context paramContext)
  {
    if (paramContext == null) {
      return 0L;
    }
    return m.c(paramContext, "com.baidu.pushservice.cst");
  }
  
  public static long e(Context paramContext)
  {
    long l2 = m.c(paramContext, "com.baidu.pushservice.st");
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 86400000L;
    }
    return l1;
  }
  
  public static void enableDebugMode(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      m.c(paramContext, "com.baidu.android.pushservice.PushSettings.debug_mode", 1);
    }
    for (;;)
    {
      if (!com.baidu.android.pushservice.c.d.g(paramContext)) {
        b(paramContext, paramBoolean);
      }
      return;
      m.c(paramContext, "com.baidu.android.pushservice.PushSettings.debug_mode", 0);
    }
  }
  
  public static boolean f(Context paramContext)
  {
    return m.b(paramContext, "com.baidu.pushservice.sd", 0) == 1;
  }
  
  public static int g(Context paramContext)
  {
    int i;
    if (paramContext == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = m.b(paramContext, "com.baidu.pushservice.lsi", -1);
      i = j;
    } while (j >= 0);
    return 1800000;
  }
  
  public static boolean h(Context paramContext)
  {
    return !TextUtils.isEmpty(m.a(paramContext, "com.baidu.pushservice.le"));
  }
  
  public static boolean i(Context paramContext)
  {
    return TextUtils.equals(m.a(paramContext, "com.baidu.pushservice.lms"), "off");
  }
  
  public static void j(Context paramContext)
  {
    if (paramContext == null) {}
    m.a(paramContext, "com.baidu.pushservice.lms", "off");
  }
  
  public static void k(Context paramContext)
  {
    if (paramContext == null) {}
    m.a(paramContext, "com.baidu.pushservice.lms", "");
  }
  
  public static void l(Context paramContext)
  {
    if (paramContext == null) {}
    Object localObject;
    do
    {
      return;
      localObject = m.a(paramContext, "com.baidu.pushservice.le");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = ((String)localObject).trim().split(",");
    PackageManager localPackageManager = paramContext.getPackageManager();
    int j = arrayOfString.length;
    int i = 0;
    String str;
    if (i < j)
    {
      str = arrayOfString[i];
      localObject = null;
    }
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(str, 0);
      localObject = localPackageInfo;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      localStringBuilder.append(str + ",");
    }
    m.a(paramContext, "com.baidu.pushservice.le", localStringBuilder.toString());
  }
  
  public static boolean m(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    if (b == -1) {
      b = m.b(paramContext, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", -1);
    }
    if (b == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean n(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    if (d == -1) {
      d = m.b(paramContext, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", -1);
    }
    if (d == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean o(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    if (e == -1) {
      e = m.b(paramContext, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", -1);
    }
    if (e == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean p(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    if (c == -1) {
      c = m.b(paramContext, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", -1);
    }
    if (c == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/PushSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */