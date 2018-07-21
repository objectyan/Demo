package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.model.VoiceRecogniseDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceRecognisePacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    String str = "";
    Object localObject = str;
    if (paramDataStruct != null)
    {
      paramDataStruct = (VoiceRecogniseDataStruct)paramDataStruct;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("filePath", paramDataStruct.filePath);
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    JSONObject localJSONObject;
    int i;
    if (paramDataStruct != null)
    {
      localJSONObject = new JSONObject();
      prePackResult(localJSONObject, paramDataStruct);
      paramDataStruct = paramDataStruct.commandResult.params;
      localObject1 = localObject2;
      if (paramDataStruct != null)
      {
        localObject1 = paramDataStruct.getString("list", "[]");
        i = paramDataStruct.getInt("type", 0);
      }
    }
    try
    {
      localJSONObject.put("list", new JSONArray((String)localObject1));
      localJSONObject.put("type", i);
      paramDataStruct = PackerUtil.createResultJSON(localJSONObject);
      localObject1 = localObject2;
      if (paramDataStruct != null) {
        localObject1 = paramDataStruct.toString();
      }
      return (String)localObject1;
    }
    catch (JSONException paramDataStruct)
    {
      paramDataStruct.printStackTrace();
    }
    return null;
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
        localObject1 = new VoiceRecogniseDataStruct();
        ((VoiceRecogniseDataStruct)localObject1).filePath = paramJSONObject.optString("filePath", "");
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/VoiceRecognisePacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */