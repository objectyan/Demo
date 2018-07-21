package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.HUDGuideDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class HUDPacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataStruct != null) {
      paramDataStruct = (HUDGuideDataStruct)paramDataStruct;
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("name", paramDataStruct.nextRoadName);
      ((JSONObject)localObject1).put("direction", paramDataStruct.direction);
      ((JSONObject)localObject1).put("distanceToCurrPoint", paramDataStruct.distance);
      ((JSONObject)localObject1).put("icon", paramDataStruct.iconName);
      ((JSONObject)localObject1).put("remainDistance", paramDataStruct.remainDistance);
      ((JSONObject)localObject1).put("remainTime", paramDataStruct.remainTime);
      paramDataStruct = PackerUtil.createProtocolJSON("notifyGuideNodeInfo", (JSONObject)localObject1);
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
        localObject1 = new HUDGuideDataStruct();
        ((HUDGuideDataStruct)localObject1).nextRoadName = paramJSONObject.optString("name", "");
        ((HUDGuideDataStruct)localObject1).direction = paramJSONObject.optString("direction", "");
        ((HUDGuideDataStruct)localObject1).distance = paramJSONObject.optString("distanceToCurrPoint", "");
        ((HUDGuideDataStruct)localObject1).iconName = paramJSONObject.optString("icon", "");
        ((HUDGuideDataStruct)localObject1).remainDistance = paramJSONObject.optString("remainDistance", "");
        ((HUDGuideDataStruct)localObject1).remainTime = paramJSONObject.optString("remainTime", "");
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/HUDPacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */