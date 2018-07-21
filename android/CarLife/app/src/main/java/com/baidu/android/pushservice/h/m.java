package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.i.c;
import com.baidu.android.pushservice.j;
import com.baidu.android.pushservice.j.k;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class m
{
  protected Context a;
  protected String b;
  private boolean c = false;
  private boolean d;
  
  public m(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.d = false;
  }
  
  private void c(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.b)) {
      return;
    }
    localObject4 = null;
    localObject5 = null;
    localInputStream = null;
    l = 1000L;
    localObject3 = localObject5;
    try
    {
      String str = a(paramBoolean);
      localObject3 = localObject5;
      if (TextUtils.isEmpty(str)) {
        break label232;
      }
      localObject3 = localObject5;
      if (!b())
      {
        localObject3 = localObject5;
        this.b += j.a(this.a).a();
      }
      localObject3 = localObject5;
      localHashMap = new HashMap();
      localObject3 = localObject5;
      com.baidu.android.pushservice.e.b.a(localHashMap);
      localObject3 = localObject5;
      a(str, localHashMap);
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        HashMap localHashMap;
        int i;
        int j;
        tmp322_319[0] = localObject4;
        com.baidu.android.pushservice.f.b.a(tmp322_319);
        throw ((Throwable)localObject1);
        l += i * 300;
        localObject3 = localObject1;
        localObject4 = localObject1;
        Thread.sleep(l);
        i += 1;
      }
    }
    finally
    {
      for (;;)
      {
        localObject4 = null;
      }
    }
    localObject4 = localInputStream;
    if (i < 2)
    {
      localObject3 = localInputStream;
      localObject4 = localInputStream;
    }
  }
  
  abstract String a(boolean paramBoolean);
  
  abstract void a(String paramString);
  
  abstract void a(String paramString, HashMap<String, String> paramHashMap);
  
  abstract boolean a();
  
  public void b(String paramString)
  {
    a(paramString);
  }
  
  /* Error */
  public void b(final boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/baidu/android/pushservice/h/m:c	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 125	com/baidu/android/pushservice/h/m:a	()Z
    //   18: ifeq -7 -> 11
    //   21: aload_0
    //   22: getfield 28	com/baidu/android/pushservice/h/m:a	Landroid/content/Context;
    //   25: invokestatic 66	com/baidu/android/pushservice/j:a	(Landroid/content/Context;)Lcom/baidu/android/pushservice/j;
    //   28: invokevirtual 127	com/baidu/android/pushservice/j:c	()Z
    //   31: ifeq -20 -> 11
    //   34: aload_0
    //   35: iconst_1
    //   36: putfield 20	com/baidu/android/pushservice/h/m:c	Z
    //   39: invokestatic 132	com/baidu/android/pushservice/i/d:a	()Lcom/baidu/android/pushservice/i/d;
    //   42: new 6	com/baidu/android/pushservice/h/m$1
    //   45: dup
    //   46: aload_0
    //   47: ldc -122
    //   49: bipush 90
    //   51: iload_1
    //   52: invokespecial 137	com/baidu/android/pushservice/h/m$1:<init>	(Lcom/baidu/android/pushservice/h/m;Ljava/lang/String;SZ)V
    //   55: invokevirtual 140	com/baidu/android/pushservice/i/d:a	(Lcom/baidu/android/pushservice/i/c;)Z
    //   58: pop
    //   59: goto -48 -> 11
    //   62: astore_3
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_3
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	m
    //   0	67	1	paramBoolean	boolean
    //   6	2	2	bool	boolean
    //   62	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	62	finally
    //   14	59	62	finally
  }
  
  abstract boolean b();
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.getInt("config_type");
      int j = paramString.getInt("interval");
      if (i == 0) {
        if (j > 0) {
          PushSettings.b(this.a, j);
        }
      }
      while ((i == 1) || (i != 2)) {
        return;
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.getInt("error_code");
      paramString.getString("error_msg");
      if (i == 50009) {
        PushSettings.j(this.a);
      }
      return;
    }
    catch (JSONException paramString) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */