package com.baidu.carlife.wechat.b;

import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static i a(JSONObject paramJSONObject)
    throws JSONException
  {
    i locali = new i();
    locali.a(paramJSONObject.getString("Uin"));
    locali.b(paramJSONObject.getString("UserName"));
    locali.c(paramJSONObject.getString("NickName"));
    locali.d(paramJSONObject.getString("HeadImgUrl"));
    return locali;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public b e()
  {
    b localb = new b();
    localb.a(this.b);
    localb.b(this.c);
    localb.c(this.d);
    return localb;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */