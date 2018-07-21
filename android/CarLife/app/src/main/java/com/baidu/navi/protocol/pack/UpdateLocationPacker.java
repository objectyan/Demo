package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.UpdateLocationDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateLocationPacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    String str = "";
    Object localObject = str;
    if (paramDataStruct != null)
    {
      paramDataStruct = (UpdateLocationDataStruct)paramDataStruct;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("longitude", paramDataStruct.longitude);
      ((JSONObject)localObject).put("latitude", paramDataStruct.latitude);
      ((JSONObject)localObject).put("speed", paramDataStruct.speed);
      ((JSONObject)localObject).put("accuracy", paramDataStruct.accuracy);
      ((JSONObject)localObject).put("bearing", paramDataStruct.bearing);
      ((JSONObject)localObject).put("altitude", paramDataStruct.altitude);
      ((JSONObject)localObject).put("satellites", paramDataStruct.satellites);
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
        localObject1 = new UpdateLocationDataStruct();
        ((UpdateLocationDataStruct)localObject1).longitude = paramJSONObject.optDouble("longitude", 0.0D);
        ((UpdateLocationDataStruct)localObject1).latitude = paramJSONObject.optDouble("latitude", 0.0D);
        ((UpdateLocationDataStruct)localObject1).speed = ((float)paramJSONObject.optDouble("speed", 0.0D));
        ((UpdateLocationDataStruct)localObject1).accuracy = ((float)paramJSONObject.optDouble("accuracy", 0.0D));
        ((UpdateLocationDataStruct)localObject1).bearing = ((float)paramJSONObject.optDouble("bearing", 0.0D));
        ((UpdateLocationDataStruct)localObject1).altitude = paramJSONObject.optDouble("altitude", 0.0D);
        ((UpdateLocationDataStruct)localObject1).satellites = paramJSONObject.optInt("satellites", 0);
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/UpdateLocationPacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */