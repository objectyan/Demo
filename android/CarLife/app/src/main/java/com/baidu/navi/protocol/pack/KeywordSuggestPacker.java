package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.model.KeywordSuggestDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KeywordSuggestPacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    String str = "";
    Object localObject = str;
    if (paramDataStruct != null)
    {
      paramDataStruct = (KeywordSuggestDataStruct)paramDataStruct;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("keyword", paramDataStruct.keyword);
      ((JSONObject)localObject).put("districtId", paramDataStruct.districtId);
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
    if (paramDataStruct != null)
    {
      localJSONObject = new JSONObject();
      prePackResult(localJSONObject, paramDataStruct);
      paramDataStruct = paramDataStruct.commandResult.params;
      localObject1 = localObject2;
      if (paramDataStruct != null) {
        paramDataStruct = (String)paramDataStruct.get("keywordList");
      }
    }
    try
    {
      localJSONObject.put("keyword", new JSONArray(paramDataStruct));
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
        localObject1 = new KeywordSuggestDataStruct();
        ((KeywordSuggestDataStruct)localObject1).keyword = paramJSONObject.optString("keyword", "");
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/KeywordSuggestPacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */