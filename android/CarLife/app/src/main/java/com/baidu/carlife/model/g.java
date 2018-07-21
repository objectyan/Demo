package com.baidu.carlife.model;

import org.json.JSONObject;

public class g
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public double h;
  public double i;
  public int j;
  public int k;
  public int l;
  
  public static g a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    g localg = new g();
    localg.a = paramJSONObject.optString("parkId");
    localg.b = paramJSONObject.optString("name");
    localg.c = paramJSONObject.optString("cityName");
    localg.d = paramJSONObject.optString("areaName");
    localg.e = paramJSONObject.optString("address");
    localg.f = paramJSONObject.optString("price");
    localg.g = paramJSONObject.optString("priceUnit");
    localg.j = paramJSONObject.optInt("leftNum");
    localg.k = paramJSONObject.optInt("total");
    localg.h = paramJSONObject.optDouble("latitude");
    localg.i = paramJSONObject.optDouble("longitude");
    localg.l = paramJSONObject.optInt("distance");
    return localg;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */