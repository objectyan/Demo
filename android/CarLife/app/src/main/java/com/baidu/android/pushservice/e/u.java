package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class u
  extends d
{
  protected String e = null;
  
  public u(l paraml, Context paramContext, String paramString)
  {
    super(paraml, paramContext);
    this.e = paramString;
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    super.a(paramHashMap);
    paramHashMap.put("method", "sendmsgtoserver");
    if (this.e != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.e);
      if (localJSONObject.has("to")) {
        paramHashMap.put("cb_url", localJSONObject.getString("to"));
      }
      if (localJSONObject.has("data")) {
        paramHashMap.put("cb_data", localJSONObject.getString("data"));
      }
      return;
    }
    catch (JSONException paramHashMap) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */