package com.baidu.carlife.util;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class o
{
  public static String a = o.class.getSimpleName();
  
  public static void a(Context paramContext)
  {
    j = 0;
    try
    {
      paramContext = c(paramContext);
      i = j;
      if (paramContext != null)
      {
        Method localMethod = paramContext.getClass().getMethod("endCall", new Class[0]);
        localMethod.setAccessible(true);
        localMethod.invoke(paramContext, new Object[0]);
        i = 1;
      }
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        i = j;
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        i = j;
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        i = j;
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        i = j;
      }
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        i = j;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        int i = j;
      }
    }
    if (i == 0) {
      w.a("请使用系统电话挂断!", 0);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramString)));
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      e(paramContext);
      return;
    }
    d(paramContext);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString)));
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static Object c(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      Method localMethod = paramContext.getClass().getDeclaredMethod("getITelephony", new Class[0]);
      localMethod.setAccessible(true);
      paramContext = localMethod.invoke(paramContext, new Object[0]);
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static void d(Context paramContext)
  {
    try
    {
      paramContext = c(paramContext);
      if (paramContext != null)
      {
        Method localMethod = paramContext.getClass().getMethod("answerRingingCall", new Class[0]);
        localMethod.setAccessible(true);
        localMethod.invoke(paramContext, new Object[0]);
      }
      return;
    }
    catch (SecurityException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void e(Context paramContext)
  {
    if (!((AudioManager)paramContext.getSystemService("audio")).isWiredHeadsetOn())
    {
      localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
      localIntent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79));
      paramContext.sendOrderedBroadcast(localIntent, null);
      return;
    }
    Intent localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
    localIntent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79));
    paramContext.sendOrderedBroadcast(localIntent, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */