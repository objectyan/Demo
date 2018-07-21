package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class v
{
  public static JSONObject a(Context paramContext)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("s", Build.VERSION.SDK_INT);
      localJSONObject.put("sv", Build.VERSION.RELEASE);
      localJSONObject.put("ii", de.a(2, paramContext));
      localJSONObject.put("w", de.b(paramContext));
      localJSONObject.put("h", de.c(paramContext));
      localJSONObject.put("ly", bc.c);
      localJSONObject.put("pv", "14");
      Object localObject1 = paramContext.getPackageName();
      Object localObject2 = paramContext.getPackageManager();
      try
      {
        localObject1 = ((PackageManager)localObject2).getPackageInfo((String)localObject1, 0);
        localJSONObject.put("pn", de.h(2, paramContext));
        localJSONObject.put("a", ((PackageInfo)localObject1).versionCode);
        localJSONObject.put("n", ((PackageInfo)localObject1).versionName);
        localJSONObject.put("mc", de.b(2, paramContext));
        localJSONObject.put("bm", de.f(2, paramContext));
        localJSONObject.put("m", Build.MODEL);
        localJSONObject.put("dn", de.a(paramContext, 2));
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("failed_cnt", 0);
        ((JSONObject)localObject2).put("send_index", 0);
        localObject1 = de.b();
        paramContext = (Context)localObject1;
        if (localObject1 == null) {
          paramContext = "";
        }
        ((JSONObject)localObject2).put("rom", paramContext);
        localJSONObject.put("trace", localObject2);
        return localJSONObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bd.a(localException);
        }
      }
      return localJSONObject;
    }
    catch (JSONException paramContext)
    {
      bd.b(paramContext);
    }
  }
  
  public static JSONObject a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("payload");
      if ((paramJSONObject == null) || (paramJSONObject.length() <= 0)) {
        break label60;
      }
      paramJSONObject = (JSONObject)paramJSONObject.get(0);
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject = null;
        continue;
        paramJSONObject = null;
        continue;
        paramJSONObject = null;
      }
    }
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.getJSONObject("he");
      return paramJSONObject;
    }
  }
  
  public static void b(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("trace");
      paramJSONObject.put("failed_cnt", paramJSONObject.getLong("failed_cnt") + 1L);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public static void c(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("trace");
      paramJSONObject.put("send_index", paramJSONObject.getLong("send_index") + 1L);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */