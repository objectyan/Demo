package com.indooratlas.android.sdk._internal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bz
{
  public int a = 1;
  public long b;
  public String[] c;
  public String d;
  public int e;
  public String f;
  public JSONObject g;
  public long[] h;
  
  bz(String paramString, long paramLong)
  {
    this.b = paramLong;
    this.d = paramString;
    this.g = new JSONObject();
  }
  
  public final String a()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    int j;
    Object localObject;
    int i;
    switch (this.a)
    {
    default: 
      throw new IllegalArgumentException("event type not implemented: " + this.a);
    case 1: 
      localJSONObject1.put("type", "histogram");
      this.g.put("name", this.d);
      if ((this.h != null) && (this.h.length > 0)) {
        this.g.put("values", new JSONArray().put(this.h[0]));
      }
      localJSONObject1.put("data", this.g);
      localJSONObject1.put("time", this.b / 1000.0D);
      if ((this.c != null) && (this.c.length > 0))
      {
        j = this.c.length;
        localObject = new JSONArray();
        i = 0;
      }
      break;
    case 2: 
      while (i < j)
      {
        ((JSONArray)localObject).put(i, this.c[i]);
        i += 1;
        continue;
        localJSONObject1.put("type", "log");
        JSONObject localJSONObject2 = this.g;
        switch (this.e)
        {
        case 3: 
        case 4: 
        default: 
          localObject = "debug";
        }
        for (;;)
        {
          localJSONObject2.put("level", localObject);
          this.g.put("msg", this.f);
          break;
          localObject = "warn";
          continue;
          localObject = "error";
          continue;
          localObject = "verbose";
        }
      }
      localJSONObject1.put("tags", localObject);
    }
    return localJSONObject1.toString();
  }
  
  public final String toString()
  {
    try
    {
      String str = a();
      return str;
    }
    catch (JSONException localJSONException) {}
    return super.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */