package com.baidu.navi.protocol.pack;

import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.MapImageUpdateDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class MapImagePacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    localObject2 = null;
    localObject1 = localObject2;
    if (paramDataStruct != null) {
      paramDataStruct = (MapImageUpdateDataStruct)paramDataStruct;
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("image", paramDataStruct.imagePath);
      ((JSONObject)localObject1).put("imagetype", paramDataStruct.imageType);
      paramDataStruct = PackerUtil.createProtocolJSON("notifyMapImageUpdate", (JSONObject)localObject1);
      localObject1 = localObject2;
      if (paramDataStruct != null) {
        localObject1 = paramDataStruct.toString();
      }
    }
    catch (JSONException paramDataStruct)
    {
      for (;;)
      {
        paramDataStruct.printStackTrace();
        localObject1 = localObject2;
      }
    }
    paramDataStruct = (DataStruct)localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramDataStruct = ((String)localObject1).replace("\\", "");
    }
    return paramDataStruct;
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
        localObject1 = new MapImageUpdateDataStruct();
        ((MapImageUpdateDataStruct)localObject1).imagePath = paramJSONObject.optString("image", "");
        ((MapImageUpdateDataStruct)localObject1).imageType = paramJSONObject.optString("imagetype", "");
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/MapImagePacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */