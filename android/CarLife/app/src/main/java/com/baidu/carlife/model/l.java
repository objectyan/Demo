package com.baidu.carlife.model;

import org.json.JSONObject;

public class l
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public String d;
  public int e;
  public String f;
  public String g;
  public String h;
  public int i;
  public int j = 2;
  public int k = 2130838597;
  public a l = a.b;
  
  public static l a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    l locall = new l();
    locall.d = paramJSONObject.optString("name");
    locall.e = paramJSONObject.optInt("version");
    locall.f = paramJSONObject.optString("thumb");
    locall.g = paramJSONObject.optString("download_link");
    locall.h = paramJSONObject.optString("pkg_name");
    locall.i = paramJSONObject.optInt("size");
    return locall;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */