package com.baidu.platform.comapi.util.c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.platform.comapi.c;

public class d
  implements g
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public String a()
  {
    if (this.d == null) {
      a(c.f());
    }
    return this.d;
  }
  
  public void a(Context paramContext)
  {
    this.b = Build.MODEL;
    this.c = ("Android" + Build.VERSION.SDK_INT);
    if (Build.BRAND != null) {}
    for (paramContext = Build.BRAND;; paramContext = "")
    {
      this.d = paramContext;
      paramContext = System.getProperty("java.vm.version");
      if ((paramContext == null) || (!paramContext.startsWith("2"))) {
        break;
      }
      this.e = "1";
      return;
    }
    this.e = "0";
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.b)) {
      a(c.f());
    }
    return this.b;
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.c)) {
      a(c.f());
    }
    return this.c;
  }
  
  public String d()
  {
    if (TextUtils.isEmpty(this.a))
    {
      this.a = DeviceId.getDeviceID(c.f());
      a(c.f());
    }
    return this.a;
  }
  
  public String e()
  {
    if (TextUtils.isEmpty(this.e)) {
      a(c.f());
    }
    return this.e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */