package com.baidu.che.codriver.vr;

import com.baidu.che.codriver.a.a;

public final class n
{
  private static boolean a = false;
  private static a b = a.a;
  private static boolean c = false;
  private static String d = "123456";
  private static String e = "123456";
  private static final String f = "http://api.codriver.baidu.com/codriverapi";
  private static final String g = "http://sandbox.codriverapi.baidu.com/codriverapi";
  private static String h = "http://10.52.185.183:8080/codriverapi";
  private static String i = "http://api.codriver.baidu.com/codriverapi";
  private static final String j = "/robokit";
  private static final String k = "123456";
  private static final String l = a.c();
  private static final String m = "123456";
  private static final String n = a.d();
  
  public static void a(a parama)
  {
    b = parama;
  }
  
  public static void a(String paramString)
  {
    h = paramString;
  }
  
  public static final void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static final boolean a()
  {
    return a;
  }
  
  public static void b(String paramString)
  {
    d = paramString;
  }
  
  public static final void b(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static final boolean b()
  {
    return c;
  }
  
  public static String c()
  {
    switch (1.a[b.ordinal()])
    {
    default: 
      i = "http://api.codriver.baidu.com/codriverapi";
    }
    for (;;)
    {
      return i;
      i = "http://api.codriver.baidu.com/codriverapi";
      continue;
      i = h;
      continue;
      i = "http://sandbox.codriverapi.baidu.com/codriverapi";
    }
  }
  
  public static void c(String paramString)
  {
    e = paramString;
  }
  
  public static String d()
  {
    return c() + "/robokit";
  }
  
  public static String e()
  {
    if ((c().equals(h)) || (c().equals("http://sandbox.codriverapi.baidu.com/codriverapi"))) {
      return d;
    }
    return l;
  }
  
  public static String f()
  {
    if ((c().equals(h)) || (c().equals("http://sandbox.codriverapi.baidu.com/codriverapi"))) {
      return e;
    }
    return n;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */