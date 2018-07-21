package com.baidu.mapframework.commonlib.utils;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class JSONUtils
{
  public static JSONObject bundleTransferToSimpleJson(Bundle paramBundle)
  {
    localJSONObject = new JSONObject();
    if ((paramBundle == null) || (paramBundle.keySet() == null)) {}
    for (;;)
    {
      return localJSONObject;
      try
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject.put(str, paramBundle.get(str));
        }
        return localJSONObject;
      }
      catch (Exception paramBundle) {}
    }
  }
  
  public static String bundleTransferToSimpleJsonString(Bundle paramBundle)
  {
    paramBundle = bundleTransferToSimpleJson(paramBundle);
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.toString();
  }
  
  public static boolean isJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      new JSONObject(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static int parseInt(JSONObject paramJSONObject, String paramString)
  {
    return parseInt(paramJSONObject, paramString, 0);
  }
  
  public static int parseInt(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString)) || (!paramJSONObject.has(paramString))) {
      return paramInt;
    }
    return paramJSONObject.optInt(paramString);
  }
  
  public static String parseString(JSONObject paramJSONObject, String paramString)
  {
    return parseString(paramJSONObject, paramString, "");
  }
  
  public static String parseString(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString1)) || (!paramJSONObject.has(paramString1))) {
      return paramString2;
    }
    return paramJSONObject.optString(paramString1);
  }
  
  public static Bundle simpleJsonTransferToBundle(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      Bundle localBundle = new Bundle();
      for (;;)
      {
        paramString = localBundle;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (String)localIterator.next();
        localBundle.putString(paramString, localJSONObject.optString(paramString));
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/utils/JSONUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */