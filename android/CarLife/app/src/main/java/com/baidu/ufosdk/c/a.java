package com.baidu.ufosdk.c;

import android.annotation.SuppressLint;
import com.baidu.ufosdk.util.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  @SuppressLint({"NewApi"})
  public static String a(Map paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        c.b("json is " + localJSONObject.toString());
        return localJSONObject.toString();
      }
      String str = (String)localIterator.next();
      try
      {
        Object localObject = paramMap.get(str);
        if (!(localObject instanceof String)) {
          break label132;
        }
        localJSONObject.put(str, (String)localObject);
      }
      catch (JSONException localJSONException)
      {
        c.a("Could not create JSON object for key " + str, localJSONException);
      }
      continue;
      label132:
      if ((localJSONException instanceof Integer)) {
        localJSONObject.put(str, (Integer)localJSONException);
      } else if ((localJSONException instanceof Long)) {
        localJSONObject.put(str, (Long)localJSONException);
      } else if ((localJSONException instanceof Float)) {
        localJSONObject.put(str, (Float)localJSONException);
      } else {
        c.d("mapRecord2JSON: unexpected key[" + str + "]'s value " + localJSONException);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */