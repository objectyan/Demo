package com.baidu.android.pushservice.h;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends n
{
  public int a;
  public String b;
  public String c;
  
  public i() {}
  
  public i(n paramn)
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
    localJSONObject.put("heart", this.a);
    localJSONObject.put("err_code", this.g);
    localJSONObject.put("msg_result", this.i);
    if (!TextUtils.isEmpty(this.b)) {
      localJSONObject.put("msg_id", this.b);
    }
    if (!TextUtils.isEmpty(this.c)) {
      localJSONObject.put("msg_open_by", this.c);
    }
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */