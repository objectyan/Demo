package com.baidu.android.pushservice.h;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends n
{
  public String a = "";
  public int b = -1;
  public int c = -1;
  public String k;
  
  public k() {}
  
  public k(n paramn)
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
    if (this.c != -1) {
      localJSONObject.put("msg_type", this.c);
    }
    if (!TextUtils.isEmpty(this.a)) {
      localJSONObject.put("msg_id", this.a);
    }
    if (this.b > 0) {
      localJSONObject.put("msg_len", this.b);
    }
    if (this.k != null) {
      localJSONObject.put("msg_open_by", this.k);
    }
    localJSONObject.put("err_code", this.g);
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */