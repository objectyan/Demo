package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.a;
import com.baidu.android.pushservice.b.b;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.p;
import java.util.HashMap;

public class f
  extends d
{
  protected int e = 0;
  private int f;
  private String g;
  private String h;
  
  public f(l paraml, Context paramContext, int paramInt1, int paramInt2)
  {
    super(paraml, paramContext);
    this.e = paramInt1;
    this.f = paramInt2;
    if (this.e == 0) {
      this.d = true;
    }
  }
  
  public f(l paraml, Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    super(paraml, paramContext);
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramString;
    this.h = paraml.j;
    if (this.e == 0) {
      this.d = true;
    }
  }
  
  protected void a(Intent paramIntent)
  {
    paramIntent.putExtra("bind_status", this.e);
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    super.a(paramHashMap);
    paramHashMap.put("method", "bind");
    paramHashMap.put("bind_name", Build.MODEL);
    paramHashMap.put("bind_status", this.e + "");
    paramHashMap.put("push_sdk_version", this.f + "");
    if ((!TextUtils.isEmpty(this.h)) && (this.h.equalsIgnoreCase("true"))) {
      paramHashMap.put("is_baidu_internal_bind", "true");
    }
    if (!TextUtils.isEmpty(this.g)) {
      paramHashMap.put("bind_notify_status", this.g);
    }
    if ((!TextUtils.isEmpty(this.b.l)) && (com.baidu.android.pushservice.c.d.g(this.a))) {
      paramHashMap.put("push_proxy", this.b.l);
    }
    try
    {
      paramHashMap.put("manufacture", Build.MANUFACTURER);
      if ((Build.MANUFACTURER.toLowerCase().contains("huawei")) || (Build.MANUFACTURER.toLowerCase().contains("xiaomi")) || (Build.MANUFACTURER.toLowerCase().contains("oppo"))) {
        paramHashMap.put("rom", p.C(this.a));
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (p.F(this.a)) {
      paramHashMap.put("connect_version", "3");
    }
    for (;;)
    {
      paramHashMap.put("sdk_int", Build.VERSION.SDK_INT + "");
      String str = this.b.e;
      if ((!TextUtils.isEmpty(str)) && (str.length() <= 128)) {
        paramHashMap.put("package_name", str);
      }
      if (!PushSettings.c(this.a)) {
        paramHashMap.put("check_sdk", m.a(this.a, "com.baidu.android.pushservice.CHECK_SDK"));
      }
      if (a.b() > 0) {
        q.a(this.a, "039903", 0, this.b.i);
      }
      return;
      paramHashMap.put("connect_version", "2");
    }
  }
  
  protected String b(String paramString)
  {
    paramString = super.b(paramString);
    if (!TextUtils.isEmpty(this.b.e))
    {
      b.a(this.a).g(this.b.e);
      if (!TextUtils.isEmpty(this.b.i))
      {
        g localg = new g(this.b.i, paramString);
        b.a(this.a).a(this.b.e, localg);
      }
    }
    return paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */