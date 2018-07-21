package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;

class bj
  extends bk
{
  static bj a = new bj();
  
  public static bj a()
  {
    return a;
  }
  
  public SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("__Baidu_Stat_SDK_SendRem", 0);
  }
  
  protected void a(Context paramContext, int paramInt)
  {
    b(paramContext, "sendLogtype", paramInt);
  }
  
  protected void a(Context paramContext, String paramString)
  {
    b(paramContext, "device_id_1", paramString);
  }
  
  protected void a(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, "onlywifi", paramBoolean);
  }
  
  protected int b(Context paramContext)
  {
    return a(paramContext, "sendLogtype", 0);
  }
  
  protected void b(Context paramContext, int paramInt)
  {
    b(paramContext, "timeinterval", paramInt);
  }
  
  protected void b(Context paramContext, String paramString)
  {
    if (a(paramContext, "cuid", null) != null) {
      g(paramContext, "cuid");
    }
    b(paramContext, "cuidsec_1", paramString);
  }
  
  protected void b(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, "setchannelwithcode", paramBoolean);
  }
  
  protected int c(Context paramContext)
  {
    return a(paramContext, "timeinterval", 1);
  }
  
  protected void c(Context paramContext, String paramString)
  {
    b(paramContext, "setchannelwithcodevalue", paramString);
  }
  
  protected void c(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, "mtjtv", paramBoolean);
  }
  
  protected void d(Context paramContext, String paramString)
  {
    b(paramContext, "mtjsdkmacss2_1", paramString);
  }
  
  protected void d(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, "mtjsdkmactrick", paramBoolean);
  }
  
  protected boolean d(Context paramContext)
  {
    return a(paramContext, "onlywifi", false);
  }
  
  protected String e(Context paramContext)
  {
    return a(paramContext, "device_id_1", null);
  }
  
  protected void e(Context paramContext, String paramString)
  {
    b(paramContext, "mtjsdkmacsstv_1", paramString);
  }
  
  protected String f(Context paramContext)
  {
    return a(paramContext, "cuidsec_1", null);
  }
  
  protected void f(Context paramContext, String paramString)
  {
    b(paramContext, "he.ext", paramString);
  }
  
  protected String g(Context paramContext)
  {
    return a(paramContext, "setchannelwithcodevalue", null);
  }
  
  protected boolean h(Context paramContext)
  {
    return a(paramContext, "setchannelwithcode", false);
  }
  
  protected String i(Context paramContext)
  {
    return a(paramContext, "mtjsdkmacss2_1", null);
  }
  
  protected boolean j(Context paramContext)
  {
    return a(paramContext, "mtjtv", false);
  }
  
  protected String k(Context paramContext)
  {
    return a(paramContext, "mtjsdkmacsstv_1", null);
  }
  
  protected String l(Context paramContext)
  {
    return a(paramContext, "he.ext", null);
  }
  
  protected boolean m(Context paramContext)
  {
    return a(paramContext, "mtjsdkmactrick", true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */