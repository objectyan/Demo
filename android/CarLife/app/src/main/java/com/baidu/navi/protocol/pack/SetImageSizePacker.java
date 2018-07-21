package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.SetImageSizeDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class SetImageSizePacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataStruct != null) {
      paramDataStruct = (SetImageSizeDataStruct)paramDataStruct;
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("width", paramDataStruct.imageWidth);
      ((JSONObject)localObject1).put("height", paramDataStruct.imageHeight);
      paramDataStruct = PackerUtil.createProtocolJSON("setImageSize", (JSONObject)localObject1);
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
        localObject1 = new SetImageSizeDataStruct();
        int j = paramJSONObject.optInt("width", 0);
        int k = paramJSONObject.optInt("height", 0);
        int i = j;
        if (j <= 0) {
          i = 400;
        }
        j = k;
        if (k <= 0) {
          j = 480;
        }
        ((SetImageSizeDataStruct)localObject1).imageWidth = i;
        ((SetImageSizeDataStruct)localObject1).imageHeight = j;
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/SetImageSizePacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */