package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.baidu.android.pushservice.k.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class d
{
  private static String a = "NotificationBuilderManager";
  private static String b = "notification_builder_storage";
  private static Object c = new Object();
  private static int d = 0;
  
  public static Notification a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (c)
      {
        PushNotificationBuilder localPushNotificationBuilder = a(paramContext, paramInt1);
        localPushNotificationBuilder.setNotificationTitle(paramString1);
        localPushNotificationBuilder.setNotificationText(paramString2);
        paramContext = localPushNotificationBuilder.construct(paramContext);
        if ((paramInt2 & 0x1) != 0)
        {
          paramContext.flags &= 0xFFFFFFDF;
          if (paramBoolean)
          {
            paramContext.defaults = 0;
            return paramContext;
          }
        }
        else
        {
          paramContext.flags |= 0x20;
        }
      }
      paramContext.defaults = -1;
      if ((paramInt2 & 0x4) != 0) {}
      for (paramContext.defaults |= 0x1;; paramContext.defaults &= 0xFFFFFFFE)
      {
        if ((paramInt2 & 0x2) == 0) {
          break label141;
        }
        paramContext.defaults |= 0x2;
        break;
      }
      label141:
      paramContext.defaults &= 0xFFFFFFFD;
    }
  }
  
  public static Notification a(Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    synchronized (c)
    {
      PushNotificationBuilder localPushNotificationBuilder = a(paramContext, paramInt);
      localPushNotificationBuilder.setNotificationTitle(paramString1);
      localPushNotificationBuilder.setNotificationText(paramString2);
      paramContext = localPushNotificationBuilder.construct(paramContext);
      if (paramBoolean)
      {
        paramContext.defaults = -1;
        return paramContext;
      }
      paramContext.defaults = 0;
    }
  }
  
  private static PushNotificationBuilder a(Context paramContext)
  {
    BasicPushNotificationBuilder localBasicPushNotificationBuilder = new BasicPushNotificationBuilder();
    localBasicPushNotificationBuilder.setNotificationFlags(16);
    localBasicPushNotificationBuilder.setNotificationDefaults(3);
    localBasicPushNotificationBuilder.setStatusbarIcon(paramContext.getApplicationInfo().icon);
    return localBasicPushNotificationBuilder;
  }
  
  private static PushNotificationBuilder a(Context paramContext, int paramInt)
  {
    Object localObject = paramContext.getSharedPreferences(b, 0).getString("" + paramInt, null);
    if (localObject != null) {
      localObject = new ByteArrayInputStream(b.a(((String)localObject).getBytes()));
    }
    try
    {
      localObjectInputStream = new ObjectInputStream((InputStream)localObject);
      paramContext = (PushNotificationBuilder)localObjectInputStream.readObject();
    }
    catch (Exception paramContext)
    {
      ObjectInputStream localObjectInputStream;
      return null;
    }
    try
    {
      localObjectInputStream.close();
      ((ByteArrayInputStream)localObject).close();
      return paramContext;
    }
    catch (Exception localException) {}
    return b(paramContext);
    return paramContext;
  }
  
  public static void a(Context paramContext, int paramInt, PushNotificationBuilder paramPushNotificationBuilder)
  {
    try
    {
      synchronized (c)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
        localObjectOutputStream.writeObject(paramPushNotificationBuilder);
        paramPushNotificationBuilder = b.a(localByteArrayOutputStream.toByteArray(), "US-ASCII");
        paramContext = paramContext.getSharedPreferences(b, 0).edit();
        paramContext.putString("" + paramInt, paramPushNotificationBuilder);
        paramContext.commit();
        localByteArrayOutputStream.close();
        localObjectOutputStream.close();
        return;
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public static void a(Context paramContext, PushNotificationBuilder paramPushNotificationBuilder)
  {
    try
    {
      synchronized (c)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
        localObjectOutputStream.writeObject(paramPushNotificationBuilder);
        paramPushNotificationBuilder = b.a(localByteArrayOutputStream.toByteArray(), "US-ASCII");
        paramContext = paramContext.getSharedPreferences(b, 0).edit();
        paramContext.putString("" + d, paramPushNotificationBuilder);
        paramContext.commit();
        localByteArrayOutputStream.close();
        localObjectOutputStream.close();
        return;
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  private static PushNotificationBuilder b(Context paramContext)
  {
    Object localObject = paramContext.getSharedPreferences(b, 0).getString("" + d, null);
    if (localObject != null) {
      localObject = new ByteArrayInputStream(b.a(((String)localObject).getBytes()));
    }
    try
    {
      localObjectInputStream = new ObjectInputStream((InputStream)localObject);
      paramContext = (PushNotificationBuilder)localObjectInputStream.readObject();
    }
    catch (Exception paramContext)
    {
      ObjectInputStream localObjectInputStream;
      return null;
    }
    try
    {
      localObjectInputStream.close();
      ((ByteArrayInputStream)localObject).close();
      return paramContext;
    }
    catch (Exception localException) {}
    return a(paramContext);
    return paramContext;
  }
  
  public static void b(Context paramContext, PushNotificationBuilder paramPushNotificationBuilder)
  {
    a(paramContext, 8888, paramPushNotificationBuilder);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */