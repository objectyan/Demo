package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.AddFavoriteByFileDataStruct;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AddFavoriteByFilePacker
  extends BasePacker
{
  public String packResult(DataStruct paramDataStruct)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataStruct != null) {
      paramDataStruct = paramDataStruct.commandResult.params;
    }
    try
    {
      localObject1 = new JSONObject();
      String str = paramDataStruct.getString(AddFavoriteByFileDataStruct.KEY_FAVFILEPATH);
      int i = paramDataStruct.getInt(AddFavoriteByFileDataStruct.KEY_FAVNUM);
      ((JSONObject)localObject1).put(AddFavoriteByFileDataStruct.KEY_FAVFILEPATH, str);
      ((JSONObject)localObject1).put(AddFavoriteByFileDataStruct.KEY_FAVNUM, i);
      ((JSONObject)localObject1).put(AddFavoriteByFileDataStruct.KEY_ERROR_CODE, paramDataStruct.get("errorCode"));
      paramDataStruct = PackerUtil.createProtocolJSON("addFavoriteByFile", (JSONObject)localObject1);
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
        localObject1 = new AddFavoriteByFileDataStruct();
        ((AddFavoriteByFileDataStruct)localObject1).mFavFile = paramJSONObject.optString(AddFavoriteByFileDataStruct.KEY_FAVFILEPATH, "");
        ((AddFavoriteByFileDataStruct)localObject1).mFavNum = paramJSONObject.optInt(AddFavoriteByFileDataStruct.KEY_FAVNUM);
        ((AddFavoriteByFileDataStruct)localObject1).commandResult.errCode = paramJSONObject.optInt(AddFavoriteByFileDataStruct.KEY_ERROR_CODE);
      }
    }
    return (DataStruct)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/AddFavoriteByFilePacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */