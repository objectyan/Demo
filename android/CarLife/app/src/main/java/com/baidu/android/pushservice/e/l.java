package com.baidu.android.pushservice.e;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;

public class l
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public boolean k = false;
  public String l = "";
  public boolean m = true;
  
  public l() {}
  
  public l(Intent paramIntent)
  {
    PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("app");
    if (localPendingIntent != null) {
      this.e = localPendingIntent.getTargetPackage();
    }
    if (TextUtils.isEmpty(this.e)) {
      this.e = paramIntent.getStringExtra("pkg_name");
    }
    this.d = paramIntent.getStringExtra("access_token");
    this.i = paramIntent.getStringExtra("secret_key");
    this.a = paramIntent.getStringExtra("method");
    this.b = paramIntent.getStringExtra("method_type");
    this.c = paramIntent.getStringExtra("method_version");
    this.h = paramIntent.getStringExtra("bduss");
    this.f = paramIntent.getStringExtra("appid");
    this.j = paramIntent.getStringExtra("is_baidu_internal_bind");
    this.k = paramIntent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
    this.l = paramIntent.getStringExtra("push_proxy");
    this.m = paramIntent.getBooleanExtra("should_notify_user", true);
  }
  
  public String toString()
  {
    return "method=" + this.a + ", accessToken=" + this.d + ", packageName=" + this.e + ", appId=" + this.f + ", userId=" + this.g + ", rsaBduss=" + this.h + ", isInternalBind=" + this.j;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */