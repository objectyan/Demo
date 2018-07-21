package com.indooratlas.android.sdk._internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class bb
{
  int a;
  public JSONObject b;
  
  public bb(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public final String a()
  {
    try
    {
      String str = this.b.getString("url");
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalStateException("missing mandatory config key 'url'");
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    this.b = paramJSONObject;
    this.a = this.b.optInt("positioning.maxMetricsPerRequest", 5);
  }
  
  public final long b()
  {
    return this.b.optLong("positioningHibernateTimeout", 180000L);
  }
  
  public final String c()
  {
    return this.b.optString("key");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */