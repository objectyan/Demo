package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.m;
import com.tencent.wxop.stat.b.s;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  private String i = "";
  private int j = 0;
  private String k = "";
  private String l = "";
  
  public d(String paramString)
  {
    this.i = paramString;
  }
  
  public d(String paramString, int paramInt)
  {
    this.i = paramString;
    this.j = paramInt;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    if (m.c(this.i)) {}
    try
    {
      s.a(localJSONObject, "a", this.i);
      localJSONObject.put("t", this.j);
      s.a(localJSONObject, "e", this.k);
      s.a(localJSONObject, "e1", this.l);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public String b()
  {
    return this.i;
  }
  
  public void b(String paramString)
  {
    this.k = paramString;
  }
  
  public int c()
  {
    return this.j;
  }
  
  public void c(String paramString)
  {
    this.l = paramString;
  }
  
  public String d()
  {
    return this.k;
  }
  
  public String e()
  {
    return this.l;
  }
  
  public String toString()
  {
    return "StatAccount [account=" + this.i + ", accountType=" + this.j + ", ext=" + this.k + ", ext1=" + this.l + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */