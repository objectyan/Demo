package com.baidu.android.pushservice.h;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.i.c;
import com.baidu.android.pushservice.i.d;
import com.baidu.android.pushservice.j.k;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
{
  public static String a = "";
  private Context b = null;
  private p c = null;
  private boolean d;
  
  public o(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = p.a(paramContext);
    this.d = false;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!k.a(this.b)) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("stats", paramString2);
    localHashMap.put("pbVer", paramString3);
    localHashMap.put("os", "android");
    paramString2 = null;
    long l = 1000L;
    int i = 0;
    for (;;)
    {
      paramString3 = paramString2;
      String str;
      if (i < 2)
      {
        paramString3 = paramString2;
        str = paramString2;
      }
      try
      {
        Object localObject = com.baidu.android.pushservice.f.b.a(paramString1, "POST", localHashMap);
        paramString3 = paramString2;
        str = paramString2;
        int j = ((com.baidu.android.pushservice.f.a)localObject).b();
        paramString3 = paramString2;
        str = paramString2;
        paramString2 = ((com.baidu.android.pushservice.f.a)localObject).a();
        paramString3 = paramString2;
        str = paramString2;
        localObject = com.baidu.android.pushservice.h.a.b.a(paramString2);
        if (j == 200)
        {
          com.baidu.android.pushservice.f.b.a(new Closeable[] { paramString2 });
          return true;
        }
        if (j == 201)
        {
          paramString3 = paramString2;
          str = paramString2;
          a((String)localObject);
        }
        for (paramString3 = paramString2;; paramString3 = paramString2)
        {
          com.baidu.android.pushservice.f.b.a(new Closeable[] { paramString3 });
          return false;
          if (j != 403) {
            break;
          }
          paramString3 = paramString2;
          str = paramString2;
          b((String)localObject);
        }
      }
      catch (Exception paramString1)
      {
        try
        {
          q.a(this.b, paramString1);
          com.baidu.android.pushservice.f.b.a(new Closeable[] { paramString3 });
          return false;
        }
        finally {}
        l += i * 300;
        paramString3 = paramString2;
        str = paramString2;
        Thread.sleep(l);
        i += 1;
      }
      finally
      {
        paramString3 = str;
      }
    }
    com.baidu.android.pushservice.f.b.a(new Closeable[] { paramString3 });
    throw paramString1;
  }
  
  private boolean d()
  {
    long l1 = 259200000L;
    if ((!com.baidu.android.pushservice.h.a.b.c(this.b)) || (this.d) || (PushSettings.f(this.b))) {
      return false;
    }
    long l4 = System.currentTimeMillis();
    long l2 = PushSettings.d(this.b);
    long l3 = l4 - l2;
    if (l3 > 259200000L)
    {
      l2 = l4 - 259200000L;
      PushSettings.a(this.b, l2);
    }
    for (;;)
    {
      if (!k.b(this.b))
      {
        if (l1 < PushSettings.e(this.b)) {
          return false;
        }
      }
      else if (l1 < 21600000L) {
        return false;
      }
      return com.baidu.android.pushservice.d.a.b(this.b, l4, l2);
      l1 = l3;
    }
  }
  
  public String a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("user_device", com.baidu.android.pushservice.h.a.b.e(this.b));
      localJSONObject1.put("user_network", com.baidu.android.pushservice.h.a.b.d(this.b));
      localJSONObject2.put("channel_id", PushSettings.a(this.b));
      localJSONObject2.put("push_running_version", com.baidu.android.pushservice.a.a());
      localJSONObject1.put("push_channel", localJSONObject2);
      return localJSONObject1.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public String a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("version", "1.0");
        String str = a();
        if (!TextUtils.isEmpty(str)) {
          ((JSONObject)localObject1).put("common", new JSONObject(str));
        }
        str = this.c.a(paramLong1, paramLong2, paramInt);
        if (!TextUtils.isEmpty(str)) {
          ((JSONObject)localObject1).put("application_info", new JSONArray(str));
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        continue;
      }
      try
      {
        localObject1 = com.baidu.android.pushservice.h.a.a.a(((JSONObject)localObject1).toString());
        localObject1[0] = 117;
        localObject1[1] = 123;
      }
      catch (IOException localIOException)
      {
        localObject2 = null;
        continue;
        try
        {
          localObject2 = com.baidu.android.pushservice.k.b.a((byte[])localObject2, "utf-8");
          return (String)localObject2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          return null;
        }
      }
    }
    if (localObject1 == null) {
      return null;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.getInt("config_type");
      int j = paramString.getInt("interval");
      if (i == 0)
      {
        if (j > 0) {
          PushSettings.b(this.b, j * 1000);
        }
      }
      else
      {
        if (i == 1)
        {
          this.d = true;
          return;
        }
        if (i == 2)
        {
          if (j > 0)
          {
            PushSettings.a(this.b, 1);
            paramString = new Intent("com.baidu.android.pushservice.action.METHOD");
            paramString.putExtra("method", "com.baidu.android.pushservice.action.ENBALE_APPSTAT");
            paramString.setClass(this.b, PushService.class);
            paramString = PendingIntent.getService(this.b.getApplicationContext(), 0, paramString, 268435456);
            long l1 = SystemClock.elapsedRealtime();
            long l2 = j;
            AlarmManager localAlarmManager = (AlarmManager)this.b.getSystemService("alarm");
            localAlarmManager.cancel(paramString);
            localAlarmManager.set(1, l1 + l2, paramString);
          }
        }
        else
        {
          if (i == 10)
          {
            PushSettings.j(this.b);
            return;
          }
          if (i == 11) {
            PushSettings.k(this.b);
          }
        }
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void b()
  {
    d.a().a(new c("checkSendStatisticData", (short)90)
    {
      public void a()
      {
        if (!o.a(o.this)) {}
        for (;;)
        {
          return;
          long l = System.currentTimeMillis();
          int i = (int)(l / 60000L % 5L);
          int j = (int)(l / 1000L);
          if ((i == 0) && (j % 60 < 15)) {
            l = (Math.random() * 60.0D * 1000.0D);
          }
          try
          {
            Thread.sleep(l);
            if (!com.baidu.android.pushservice.h.a.b.c(o.b(o.this))) {
              continue;
            }
            o.this.c();
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
        }
      }
    });
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.getInt("error_code");
      paramString.getString("error_msg");
      if (i == 50009) {
        PushSettings.a(this.b, 1);
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public boolean b(long paramLong1, long paramLong2, int paramInt)
  {
    String str = a(paramLong1, paramLong2, paramInt);
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        boolean bool = a("https://statsonline.pushct.baidu.com/pushlog_special", str, "1.0");
        return bool;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return false;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 128	java/lang/System:currentTimeMillis	()J
    //   5: lstore_2
    //   6: aload_0
    //   7: getfield 27	com/baidu/android/pushservice/h/o:b	Landroid/content/Context;
    //   10: invokestatic 131	com/baidu/android/pushservice/PushSettings:d	(Landroid/content/Context;)J
    //   13: lstore 4
    //   15: aload_0
    //   16: getfield 27	com/baidu/android/pushservice/h/o:b	Landroid/content/Context;
    //   19: lload_2
    //   20: lload 4
    //   22: invokestatic 323	com/baidu/android/pushservice/d/a:a	(Landroid/content/Context;JJ)I
    //   25: istore_1
    //   26: iconst_1
    //   27: istore 6
    //   29: iload_1
    //   30: ifle +15 -> 45
    //   33: aload_0
    //   34: lload_2
    //   35: lload 4
    //   37: sipush 1000
    //   40: invokevirtual 325	com/baidu/android/pushservice/h/o:b	(JJI)Z
    //   43: istore 6
    //   45: iload 6
    //   47: ifeq +21 -> 68
    //   50: aload_0
    //   51: getfield 27	com/baidu/android/pushservice/h/o:b	Landroid/content/Context;
    //   54: invokestatic 128	java/lang/System:currentTimeMillis	()J
    //   57: invokestatic 134	com/baidu/android/pushservice/PushSettings:a	(Landroid/content/Context;J)V
    //   60: aload_0
    //   61: getfield 27	com/baidu/android/pushservice/h/o:b	Landroid/content/Context;
    //   64: invokestatic 326	com/baidu/android/pushservice/d/a:d	(Landroid/content/Context;)J
    //   67: pop2
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore 7
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 7
    //   77: athrow
    //   78: astore 7
    //   80: goto -12 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	o
    //   25	5	1	i	int
    //   5	30	2	l1	long
    //   13	23	4	l2	long
    //   27	19	6	bool	boolean
    //   71	5	7	localObject	Object
    //   78	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	26	71	finally
    //   33	45	71	finally
    //   50	60	71	finally
    //   60	68	71	finally
    //   60	68	78	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */