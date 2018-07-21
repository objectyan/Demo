package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.model.SearchByKeywordDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchByKeywordPacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    String str = "";
    Object localObject = str;
    if (paramDataStruct != null)
    {
      paramDataStruct = (SearchByKeywordDataStruct)paramDataStruct;
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
        paramDataStruct = paramDataStruct.getString("poiList");
      }
    }
    try
    {
      localJSONObject.put("poiList", new JSONArray(paramDataStruct));
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
        localObject1 = new SearchByKeywordDataStruct();
        ((SearchByKeywordDataStruct)localObject1).keyword = paramJSONObject.optString("keyword", "");
        ((SearchByKeywordDataStruct)localObject1).districtId = paramJSONObject.optInt("districtId", 0);
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/SearchByKeywordPacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */