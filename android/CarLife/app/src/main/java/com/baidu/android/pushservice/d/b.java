package com.baidu.android.pushservice.d;

import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public long a = 0L;
  public long b = 0L;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  
  public JSONObject a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (this.a > -1L) {
      localJSONObject.put("push_priority", this.a);
    }
    if (this.b > -1L) {
      localJSONObject.put("push_version", this.b);
    }
    localJSONObject.put("push_channelid", this.c);
    localJSONObject.put("push_curpkgname", this.d);
    localJSONObject.put("push_webappbindinfo", this.e);
    localJSONObject.put("push_lightappbindinfo", this.f);
    localJSONObject.put("push_sdkclientbindinfo", this.g);
    localJSONObject.put("push_clientsbindinfo", this.h);
    localJSONObject.put("push_selfbindinfo", this.i);
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */