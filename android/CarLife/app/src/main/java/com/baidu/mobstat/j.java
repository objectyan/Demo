package com.baidu.mobstat;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class j
{
  public String a;
  public String b;
  public int c = 2;
  
  public static j a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).getString("deviceid");
        String str = ((JSONObject)localObject).getString("imei");
        int i = ((JSONObject)localObject).getInt("ver");
        if ((!TextUtils.isEmpty(paramString)) && (str != null))
        {
          localObject = new j();
          ((j)localObject).a = paramString;
          ((j)localObject).b = str;
          ((j)localObject).c = i;
          return (j)localObject;
        }
      }
      catch (JSONException paramString)
      {
        g.a(paramString);
      }
    }
    return null;
  }
  
  public String a()
  {
    try
    {
      String str = new JSONObject().put("deviceid", this.a).put("imei", this.b).put("ver", this.c).toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      g.a(localJSONException);
    }
    return null;
  }
  
  public String b()
  {
    String str2 = this.b;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    str1 = new StringBuffer(str1).reverse().toString();
    return this.a + "|" + str1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */