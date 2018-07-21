package com.baidu.android.pushservice.h;

import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends n
{
  public String a;
  public int b;
  public int c;
  
  public h() {}
  
  public h(n paramn)
  {
    super(paramn);
  }
  
  public h(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this.j = paramString1;
    this.b = paramInt1;
    this.a = paramString2;
    this.c = paramInt2;
    this.d = "050101";
    this.e = System.currentTimeMillis();
  }
  
  public JSONObject a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("action_name", this.d);
    localJSONObject.put("timestamp", this.e);
    localJSONObject.put("msg_type", this.c);
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */