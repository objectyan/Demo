package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.GeoPointInfo;
import com.baidu.navi.protocol.model.RerouteDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReroutePacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataStruct != null)
    {
      localObject1 = localObject2;
      if ((paramDataStruct instanceof RerouteDataStruct)) {
        paramDataStruct = (RerouteDataStruct)paramDataStruct;
      }
    }
    try
    {
      localObject1 = new JSONObject();
      JSONObject localJSONObject1 = GeoPointInfo.toJSONObject(paramDataStruct.startPoint, false, false);
      JSONObject localJSONObject2 = GeoPointInfo.toJSONObject(paramDataStruct.endPoint, false, false);
      JSONArray localJSONArray = GeoPointInfo.toJSONArray(paramDataStruct.mViaPoints);
      ((JSONObject)localObject1).put("start", localJSONObject1);
      ((JSONObject)localObject1).put("end", localJSONObject2);
      ((JSONObject)localObject1).put("via", localJSONArray);
      ((JSONObject)localObject1).put("calMode", paramDataStruct.calMode);
      ((JSONObject)localObject1).put("addHistory", paramDataStruct.addHistory);
      paramDataStruct = PackerUtil.createProtocolJSON("reRoute", (JSONObject)localObject1);
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
    JSONArray localJSONArray = null;
    Object localObject = localJSONArray;
    if (paramJSONObject != null)
    {
      paramJSONObject = PackerUtil.getExtDataObj(paramJSONObject);
      localObject = localJSONArray;
      if (paramJSONObject != null)
      {
        localObject = paramJSONObject.optJSONObject("start");
        JSONObject localJSONObject = paramJSONObject.optJSONObject("end");
        localJSONArray = paramJSONObject.optJSONArray("via");
        int i = paramJSONObject.optInt("calMode", 1);
        boolean bool = paramJSONObject.optBoolean("addHistory", false);
        paramJSONObject = new RerouteDataStruct();
        paramJSONObject.calMode = i;
        paramJSONObject.addHistory = bool;
        if (localObject != null) {
          paramJSONObject.startPoint = GeoPointInfo.jsonToGeo((JSONObject)localObject);
        }
        if (localJSONObject != null) {
          paramJSONObject.endPoint = GeoPointInfo.jsonToGeo(localJSONObject);
        }
        localObject = paramJSONObject;
        if (localJSONArray != null)
        {
          paramJSONObject.mViaPoints = GeoPointInfo.jsonToList(localJSONArray);
          localObject = paramJSONObject;
        }
      }
    }
    return (DataStruct)localObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/ReroutePacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */