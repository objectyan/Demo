package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.baidu.android.pushservice.e.a.a;
import com.baidu.android.pushservice.e.x;
import com.baidu.android.pushservice.j.m;

public final class j
{
  private static j a;
  private String b = null;
  private String c = null;
  private Thread d = null;
  private boolean e;
  private Context f;
  
  private j(Context paramContext)
  {
    this.c = m.a(paramContext, "com.baidu.pushservice.channel_token");
    this.b = PushSettings.a(paramContext);
    this.e = false;
    this.f = paramContext;
  }
  
  public static j a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new j(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(Context paramContext, boolean paramBoolean, a.a parama)
  {
    if ((this.d == null) || (!this.d.isAlive()))
    {
      paramContext = new x(paramContext, parama);
      if (!paramBoolean) {
        paramContext.a(0);
      }
      this.d = new Thread(paramContext);
      this.d.start();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.b = paramString1;
      this.c = paramString2;
      PushSettings.a(this.f, paramString1);
      m.a(this.f, "com.baidu.pushservice.channel_token", paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public String b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c));
  }
  
  public boolean d()
  {
    try
    {
      Object localObject = this.f.getSharedPreferences("pushclient", 0);
      if (((SharedPreferences)localObject).getInt("isFirstReqChannelIDVcode", 0) == a.a()) {
        return false;
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("isFirstReqChannelIDVcode", a.a());
      ((SharedPreferences.Editor)localObject).commit();
      return true;
    }
    catch (Exception localException) {}
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */