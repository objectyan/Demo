package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends c
{
  public static int a = 0;
  public static int b = 10;
  public static int c = 11;
  public static int d = 12;
  public static int e = 13;
  private int f = 0;
  
  public j() {}
  
  public j(String paramString)
  {
    super(paramString);
  }
  
  public JSONObject a(Context paramContext)
    throws JSONException
  {
    paramContext = new JSONObject();
    paramContext.put("app_type", this.f);
    if (!TextUtils.isEmpty(b())) {
      paramContext.put("app_package_name", b());
    }
    if (!TextUtils.isEmpty(c())) {
      paramContext.put("app_name", c());
    }
    if (!TextUtils.isEmpty(d())) {
      paramContext.put("app_cfrom", d());
    }
    if (e() != -1) {
      paramContext.put("app_vercode", e());
    }
    if (!TextUtils.isEmpty(f())) {
      paramContext.put("app_vername", f());
    }
    if (g() != -1) {
      paramContext.put("app_push_version", g());
    }
    paramContext.put("app_appid", a());
    return paramContext;
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int h()
  {
    return this.f;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */