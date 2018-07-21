package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.ResultDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultPacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataStruct != null)
    {
      localObject1 = localObject2;
      if ((paramDataStruct instanceof ResultDataStruct)) {
        paramDataStruct = (ResultDataStruct)paramDataStruct;
      }
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("errCode", paramDataStruct.errCode);
      ((JSONObject)localObject1).put("errString", paramDataStruct.errString);
      paramDataStruct = PackerUtil.createProtocolJSON("result", (JSONObject)localObject1);
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
        int i = paramJSONObject.optInt("errCode", 0);
        paramJSONObject = paramJSONObject.optString("errString");
        localObject1 = new ResultDataStruct();
        ((ResultDataStruct)localObject1).errCode = i;
        ((ResultDataStruct)localObject1).errString = paramJSONObject;
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/ResultPacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */