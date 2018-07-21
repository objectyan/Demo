package com.baidu.carlife.core.connect.a;

import java.util.UUID;

public class d
{
  public static final boolean a = true;
  public static final boolean b = false;
  public static int c = 20000;
  public static final String d = "RSA/ECB/PKCS1Padding";
  public static boolean e = false;
  private static d g;
  private String f = UUID.randomUUID().toString();
  
  public static d a()
  {
    if (g == null) {
      g = new d();
    }
    return g;
  }
  
  public String b()
  {
    String str = "";
    if (this.f.length() >= 16) {
      str = this.f.substring(0, 16);
    }
    return str;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */