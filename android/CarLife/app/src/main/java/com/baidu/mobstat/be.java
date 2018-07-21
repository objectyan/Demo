package com.baidu.mobstat;

import org.json.JSONException;
import org.json.JSONObject;

public class be
{
  public boolean a = false;
  public String b = "";
  public boolean c = false;
  
  public be() {}
  
  public be(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getBoolean("SDK_BPLUS_SERVICE");
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.b = paramJSONObject.getString("SDK_PRODUCT_LY");
          try
          {
            this.c = paramJSONObject.getBoolean("SDK_LOCAL_SERVER");
            return;
          }
          catch (Exception paramJSONObject)
          {
            bd.b(paramJSONObject);
          }
          localException1 = localException1;
          bd.b(localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          bd.b(localException2);
        }
      }
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("SDK_BPLUS_SERVICE", this.a);
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        for (;;)
        {
          localJSONObject.put("SDK_PRODUCT_LY", this.b);
          try
          {
            localJSONObject.put("SDK_LOCAL_SERVER", this.c);
            return localJSONObject;
          }
          catch (JSONException localJSONException3)
          {
            bd.b(localJSONException3);
          }
          localJSONException1 = localJSONException1;
          bd.b(localJSONException1);
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          bd.b(localJSONException2);
        }
      }
    }
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */