package com.baidu.android.pushservice.h;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends n
{
  public String a;
  public String b;
  public String c;
  
  public b() {}
  
  public b(n paramn)
  {
    super(paramn);
  }
  
  public JSONObject a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("action_name", this.d);
    localJSONObject.put("timestamp", this.e);
    localJSONObject.put("network_status", this.f);
    localJSONObject.put("msg_result", this.a);
    localJSONObject.put("request_id", this.b);
    localJSONObject.put("err_code", this.g);
    if (!TextUtils.isEmpty(this.c)) {
      localJSONObject.put("channel", this.c);
    }
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */