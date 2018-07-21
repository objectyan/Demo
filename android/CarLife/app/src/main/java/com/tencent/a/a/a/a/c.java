package com.tencent.a.a.a.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  String a = null;
  String b = null;
  String c = "0";
  long d = 0L;
  
  static c a(String paramString)
  {
    c localc = new c();
    if (h.a(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("ui")) {
        localc.a = paramString.getString("ui");
      }
      if (!paramString.isNull("mc")) {
        localc.b = paramString.getString("mc");
      }
      if (!paramString.isNull("mid")) {
        localc.c = paramString.getString("mid");
      }
      if (!paramString.isNull("ts")) {
        localc.d = paramString.getLong("ts");
      }
      return localc;
    }
    catch (JSONException paramString)
    {
      Log.w("MID", paramString);
    }
    return localc;
  }
  
  private JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      h.a(localJSONObject, "ui", this.a);
      h.a(localJSONObject, "mc", this.b);
      h.a(localJSONObject, "mid", this.c);
      localJSONObject.put("ts", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Log.w("MID", localJSONException);
    }
    return localJSONObject;
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return b().toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */