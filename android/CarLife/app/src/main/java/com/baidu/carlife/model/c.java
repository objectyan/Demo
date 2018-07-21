package com.baidu.carlife.model;

import com.baidu.carlife.core.i;
import org.json.JSONObject;

public class c
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 0;
  public static final int f = 1;
  public int g;
  public int h;
  public int i;
  public int j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public static c a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    i.b("AppModel", paramJSONObject.toString());
    c localc = new c();
    localc.g = paramJSONObject.optInt("hasNewVersion");
    localc.h = paramJSONObject.optInt("updateType");
    localc.i = paramJSONObject.optInt("downloadType");
    localc.j = paramJSONObject.optInt("newAppSize");
    localc.k = paramJSONObject.optString("newAppDescription");
    localc.l = paramJSONObject.optString("newAppVersionName");
    localc.m = paramJSONObject.optString("url");
    localc.n = paramJSONObject.optString("checkSum");
    return localc;
  }
  
  public String toString()
  {
    return "hasNewVersion:" + this.g + ", updateType:" + this.h + ", downloadType:" + this.i + ", newAppSize:" + this.j + ", newAppDescription:" + this.k + ", newAppVersionName:" + this.l + ", url:" + this.m + ", checkSum:" + this.n;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */