package com.baidu.navi.protocol.util;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PackerUtil
{
  public static final String KEY_COMMAND = "command";
  public static final String KEY_EXT_DATA = "extData";
  public static final String KEY_METHOD = "method";
  public static final String KEY_MODULE_NAME = "moduleName";
  public static final String KEY_RESULT = "result";
  public static final String KEY_VERSION = "version";
  
  public static JSONObject createJSONWithoutParam(String paramString)
  {
    return createProtocolJSON(paramString, new JSONObject());
  }
  
  public static JSONObject createProtocolJSON(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1 = null;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      if (paramJSONObject != null) {
        localJSONObject2.put("extData", paramJSONObject);
      }
      localJSONObject2.put("method", paramString);
      localJSONObject1.put("moduleName", BNaviProtocolDef.moduleName);
      localJSONObject1.put("version", 2);
      localJSONObject1.put("command", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject createResultJSON(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1 = null;
    if (paramJSONObject != null) {}
    try
    {
      localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      if (paramJSONObject != null) {
        localJSONObject2.put("extData", paramJSONObject);
      }
      localJSONObject2.put("method", "result");
      localJSONObject1.put("moduleName", BNaviProtocolDef.moduleName);
      localJSONObject1.put("version", 2);
      localJSONObject1.put("command", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static String getCommand(JSONObject paramJSONObject)
  {
    String str = null;
    if (paramJSONObject != null) {}
    try
    {
      str = paramJSONObject.getJSONObject("command").getString("method");
      return str;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject getExtDataObj(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject != null) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("command");
      localObject1 = localObject2;
      if (paramJSONObject != null) {
        localObject1 = paramJSONObject.getJSONObject("extData");
      }
      return (JSONObject)localObject1;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static int getVersion(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject != null) {
      i = paramJSONObject.optInt("version", 0);
    }
    return i;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/util/PackerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */