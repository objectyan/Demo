package com.baidu.carlife.wechat.b;

import android.text.TextUtils;
import org.json.JSONObject;

public class g
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public static g a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      g localg = new g();
      localg.a = paramJSONObject.optInt("Uin");
      localg.b = paramJSONObject.getString("UserName");
      String str = paramJSONObject.optString("DisplayName");
      if (!TextUtils.isEmpty(str)) {}
      for (localg.c = str;; localg.c = paramJSONObject.getString("NickName"))
      {
        localg.e = paramString;
        localg.d = ("/cgi-bin/mmwebwx-bin/webwxgeticon?seq=0&username=" + localg.b + "&chatroomid=" + paramString + "&skey=" + c.a().g().a());
        return localg;
      }
      return null;
    }
    catch (Exception paramJSONObject)
    {
      com.baidu.carlife.wechat.a.b.c.e("contact parse failed");
      paramJSONObject.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */