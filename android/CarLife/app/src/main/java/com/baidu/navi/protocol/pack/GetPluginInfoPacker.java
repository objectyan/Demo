package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.model.GetPluginInfoDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetPluginInfoPacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    String str = "";
    Object localObject = str;
    if (paramDataStruct != null)
    {
      paramDataStruct = (GetPluginInfoDataStruct)paramDataStruct;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("pluginId", paramDataStruct.pluginId);
      paramDataStruct = PackerUtil.createProtocolJSON(paramDataStruct.mCmd, (JSONObject)localObject);
      localObject = str;
      if (paramDataStruct != null) {
        localObject = paramDataStruct.toString();
      }
      return (String)localObject;
    }
    catch (JSONException paramDataStruct)
    {
      paramDataStruct.printStackTrace();
    }
    return "";
  }
  
  public String packResult(DataStruct paramDataStruct)
  {
    String str1 = "";
    Object localObject = str1;
    Bundle localBundle;
    if (paramDataStruct != null)
    {
      localBundle = ((GetPluginInfoDataStruct)paramDataStruct).commandResult.params;
      localObject = str1;
      if (localBundle != null)
      {
        localObject = new JSONObject();
        prePackResult((JSONObject)localObject, paramDataStruct);
      }
    }
    try
    {
      paramDataStruct = localBundle.getString("name");
      String str2 = localBundle.getString("version");
      String str3 = localBundle.getString("summary");
      boolean bool = localBundle.getBoolean("isRunning", false);
      ((JSONObject)localObject).put("name", paramDataStruct);
      ((JSONObject)localObject).put("version", str2);
      ((JSONObject)localObject).put("summary", str3);
      ((JSONObject)localObject).put("isRunning", bool);
      paramDataStruct = PackerUtil.createResultJSON((JSONObject)localObject);
      localObject = str1;
      if (paramDataStruct != null) {
        localObject = paramDataStruct.toString();
      }
      return (String)localObject;
    }
    catch (JSONException paramDataStruct)
    {
      for (;;)
      {
        paramDataStruct.printStackTrace();
      }
    }
  }
  
  public DataStruct unpack(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject != null)
    {
      paramJSONObject = PackerUtil.getExtDataObj(paramJSONObject);
      localObject1 = localObject2;
      if (paramJSONObject != null)
      {
        localObject1 = new GetPluginInfoDataStruct();
        ((GetPluginInfoDataStruct)localObject1).pluginId = paramJSONObject.optInt("pluginId", -1);
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/GetPluginInfoPacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */