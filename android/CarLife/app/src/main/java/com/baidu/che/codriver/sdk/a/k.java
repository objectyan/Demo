package com.baidu.che.codriver.sdk.a;

import com.baidu.che.codriver.util.h;

public class k
{
  private b a;
  
  public static k a()
  {
    return a.a();
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public void a(String paramString1, String paramString2)
  {
    h.e("CdSystemManager", "param:" + paramString1 + ";data:" + paramString2);
    l.a().a("system.tool", paramString1, paramString2);
  }
  
  public b b()
  {
    return this.a;
  }
  
  private static class a
  {
    private static k a = new k();
  }
  
  public static abstract interface b
  {
    public static final String b = "volume";
    public static final String c = "bluetooth";
    public static final String d = "light";
    public static final String e = "wifi";
    public static final String f = "radio";
    public static final String g = "network";
    public static final String h = "system_setting";
    public static final String i = "picture";
    public static final String j = "media_player";
    public static final String k = "telephone";
    public static final String l = "home";
    public static final String m = "map";
    public static final String n = "take_picture";
    
    public abstract void a(String paramString);
    
    public abstract void a(String paramString, boolean paramBoolean);
    
    public abstract void b(String paramString);
    
    public abstract void c(String paramString);
    
    public abstract void d(String paramString);
    
    public abstract void e(String paramString);
    
    public abstract void f(String paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */