package com.baidu.android.pushservice.h;

import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends n
{
  public String a;
  
  public f() {}
  
  public f(n paramn)
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
    localJSONObject.put("crash_stack", this.a);
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */