package com.tencent.wxop.stat;

import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private long a = 0L;
  private int b = 0;
  private String c = "";
  private int d = 0;
  private String e = "";
  
  public long a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public JSONObject f()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tm", this.a);
      localJSONObject.put("st", this.b);
      if (this.c != null) {
        localJSONObject.put("dm", this.c);
      }
      localJSONObject.put("pt", this.d);
      if (this.e != null) {
        localJSONObject.put("rip", this.e);
      }
      localJSONObject.put("ts", System.currentTimeMillis() / 1000L);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */