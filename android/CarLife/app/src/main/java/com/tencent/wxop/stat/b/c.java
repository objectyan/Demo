package com.tencent.wxop.stat.b;

import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private String a = null;
  private String b = null;
  private String c = null;
  private String d = "0";
  private int e;
  private int f = 0;
  private long g = 0L;
  
  public c() {}
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = paramInt;
  }
  
  JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      s.a(localJSONObject, "ui", this.a);
      s.a(localJSONObject, "mc", this.b);
      s.a(localJSONObject, "mid", this.d);
      s.a(localJSONObject, "aid", this.c);
      localJSONObject.put("ts", this.g);
      localJSONObject.put("ver", this.f);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */