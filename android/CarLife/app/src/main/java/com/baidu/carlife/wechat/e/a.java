package com.baidu.carlife.wechat.e;

public class a
{
  private static final String a = "http://api.map.baidu.com/geocoder/v2/?output=json&coordtype=gcj02ll&pois=0&ak=A3d07d115c18359fe9545517a5321727&location={location}";
  
  public static final String a(String paramString1, String paramString2)
  {
    return "http://api.map.baidu.com/geocoder/v2/?output=json&coordtype=gcj02ll&pois=0&ak=A3d07d115c18359fe9545517a5321727&location={location}".replace("{location}", paramString1 + "," + paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */