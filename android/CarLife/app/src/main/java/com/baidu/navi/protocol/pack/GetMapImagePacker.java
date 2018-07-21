package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.model.GetMapImageDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetMapImagePacker
  extends BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataStruct != null) {
      paramDataStruct = (GetMapImageDataStruct)paramDataStruct;
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("width", paramDataStruct.width);
      ((JSONObject)localObject1).put("height", paramDataStruct.height);
      paramDataStruct = PackerUtil.createProtocolJSON("getMapImage", (JSONObject)localObject1);
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
  
  public String packResult(DataStruct paramDataStruct)
  {
    String str = "";
    Bundle localBundle = ((GetMapImageDataStruct)paramDataStruct).commandResult.params;
    Object localObject = str;
    if (localBundle != null)
    {
      localObject = new JSONObject();
      prePackResult((JSONObject)localObject, paramDataStruct);
    }
    try
    {
      ((JSONObject)localObject).put("image", localBundle.getString("image"));
      ((JSONObject)localObject).put("imagetype", "jpg");
      ((JSONObject)localObject).put("width", localBundle.getInt("width", 0));
      ((JSONObject)localObject).put("height", localBundle.getInt("height", 0));
      paramDataStruct = PackerUtil.createResultJSON((JSONObject)localObject);
      localObject = str;
      if (paramDataStruct != null) {
        localObject = paramDataStruct.toString();
      }
      paramDataStruct = (DataStruct)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramDataStruct = ((String)localObject).replace("\\", "");
      }
      return paramDataStruct;
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
        localObject1 = new GetMapImageDataStruct();
        ((GetMapImageDataStruct)localObject1).width = paramJSONObject.optInt("width", 0);
        ((GetMapImageDataStruct)localObject1).height = paramJSONObject.optInt("height", 0);
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/GetMapImagePacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */