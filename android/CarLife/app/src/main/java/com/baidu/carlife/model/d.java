package com.baidu.carlife.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public static List<d> a(String paramString)
  {
    JSONObject localJSONObject = null;
    Object localObject = null;
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      paramString = localJSONObject;
      int i;
      if (localJSONArray != null)
      {
        paramString = new ArrayList();
        i = 0;
      }
      return paramString;
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        while (i < localJSONArray.length())
        {
          localObject = new d();
          localJSONObject = localJSONArray.optJSONObject(i);
          ((d)localObject).a = localJSONObject.optString("car_factory_name");
          ((d)localObject).b = localJSONObject.optString("car_factory_channel_id");
          ((d)localObject).c = localJSONObject.optString("access_type");
          ((d)localObject).d = localJSONObject.optString("plugin_platform");
          ((d)localObject).e = localJSONObject.optString("plugin_version");
          ((d)localObject).f = localJSONObject.optString("package_address");
          ((d)localObject).g = localJSONObject.optString("plugin_bundle_id");
          ((d)localObject).h = localJSONObject.optString("logo_icon_address");
          paramString.add(localObject);
          i += 1;
        }
        localJSONException2 = localJSONException2;
        paramString = (String)localObject;
        localObject = localJSONException2;
      }
      catch (JSONException localJSONException1)
      {
        for (;;) {}
      }
      ((JSONException)localObject).printStackTrace();
    }
    return paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */