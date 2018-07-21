package com.baidu.che.codriver.platform;

import com.baidu.che.codriver.platform.navi.NaviAddressData;
import com.baidu.che.codriver.util.INoProguard;
import com.baidu.che.codriver.util.h;
import org.json.JSONException;
import org.json.JSONObject;

public class NaviCmdData
  implements INoProguard
{
  private static final String TAG = "NaviCmdData";
  private String mFunc;
  private String mParams;
  
  public NaviCmdData(String paramString1, String paramString2)
  {
    this.mFunc = paramString1;
    this.mParams = paramString2;
  }
  
  public static String createParams(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString, paramInt);
      h.b("NaviCmdData", "params: " + localJSONObject.toString());
      return localJSONObject.toString();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String createParams(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString1, paramString2);
      h.b("NaviCmdData", "params: " + localJSONObject.toString());
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String createParamsAddress(NaviAddressData paramNaviAddressData)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (paramNaviAddressData.getType().equals("office")) {
        localJSONObject1.put("order", "type_company_address");
      }
      for (;;)
      {
        localJSONObject2.put("name", paramNaviAddressData.getName());
        localJSONObject2.put("address", paramNaviAddressData.getAddress());
        localJSONObject2.put("lat", paramNaviAddressData.getLat());
        localJSONObject2.put("lng", paramNaviAddressData.getLng());
        localJSONObject2.put("type", paramNaviAddressData.getType());
        localJSONObject1.put("data", localJSONObject2);
        h.b("NaviCmdData", "params: " + localJSONObject1.toString());
        return localJSONObject1.toString();
        if (!paramNaviAddressData.getType().equals("home")) {
          break;
        }
        localJSONObject1.put("order", "type_home_address");
      }
      h.b("NaviCmdData", "set address type error");
    }
    catch (Exception paramNaviAddressData)
    {
      paramNaviAddressData.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static String createParamsPoi(NaviCmdOriginalData.ExtInfo paramExtInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      if ((paramExtInfo.lat != null) && (paramExtInfo.lng != null))
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("lat", paramExtInfo.lat);
        localJSONObject2.put("lng", paramExtInfo.lng);
        localJSONObject1.put("dest", localJSONObject2);
        if (paramExtInfo.poiName != null)
        {
          localJSONObject1.put("dest_name", paramExtInfo.poiName);
          h.b("NaviCmdData", "params: " + localJSONObject1.toString());
          return localJSONObject1.toString();
        }
      }
      else
      {
        h.b("NaviCmdData", "lng or lat is null");
        return null;
      }
    }
    catch (Exception paramExtInfo)
    {
      paramExtInfo.printStackTrace();
      return null;
    }
    h.b("NaviCmdData", "poiName is null");
    return null;
  }
  
  public static String createParamsPoi(NaviAddressData paramNaviAddressData)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      if ((paramNaviAddressData.getLat() != null) && (paramNaviAddressData.getLng() != null))
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("lat", paramNaviAddressData.getLat());
        localJSONObject2.put("lng", paramNaviAddressData.getLng());
        localJSONObject1.put("dest", localJSONObject2);
        if (paramNaviAddressData.getName() != null)
        {
          localJSONObject1.put("dest_name", paramNaviAddressData.getName());
          h.b("NaviCmdData", "params: " + localJSONObject1.toString());
          return localJSONObject1.toString();
        }
      }
      else
      {
        h.b("NaviCmdData", "lng or lat is null");
        return null;
      }
    }
    catch (Exception paramNaviAddressData)
    {
      paramNaviAddressData.printStackTrace();
      return null;
    }
    h.b("NaviCmdData", "poiName is null");
    return null;
  }
  
  public static String createParamsResetNaviByPreference(String paramString)
  {
    return "{\"order\":\"type_reset_navi_bypreference\",\"data\":{\"navi_preference\":\"" + paramString + "\"}}";
  }
  
  public String getFunc()
  {
    return this.mFunc;
  }
  
  public String getParams()
  {
    return this.mParams;
  }
  
  public void setFunc(String paramString)
  {
    this.mFunc = paramString;
  }
  
  public void setParams(String paramString)
  {
    this.mParams = paramString;
  }
  
  public String toString()
  {
    return "CmdNaviData { func = " + this.mFunc + ", params = " + this.mParams + " }";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/platform/NaviCmdData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */