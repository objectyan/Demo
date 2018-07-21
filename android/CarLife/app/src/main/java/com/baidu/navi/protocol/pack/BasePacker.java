package com.baidu.navi.protocol.pack;

import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.model.DataStructFactory;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BasePacker
{
  public String pack(DataStruct paramDataStruct)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataStruct != null)
    {
      paramDataStruct = PackerUtil.createJSONWithoutParam(paramDataStruct.mCmd);
      localObject1 = localObject2;
      if (paramDataStruct != null) {
        localObject1 = paramDataStruct.toString();
      }
    }
    return (String)localObject1;
  }
  
  public String packResult(DataStruct paramDataStruct)
  {
    JSONObject localJSONObject = new JSONObject();
    prePackResult(localJSONObject, paramDataStruct);
    return PackerUtil.createResultJSON(localJSONObject).toString();
  }
  
  public void prePackResult(JSONObject paramJSONObject, DataStruct paramDataStruct)
  {
    try
    {
      paramJSONObject.put(DataStruct.KEY_METHOD_NAME, paramDataStruct.mCmd);
      paramJSONObject.put(DataStruct.KEY_ERROR_CODE, paramDataStruct.commandResult.errCode);
      paramJSONObject.put(DataStruct.KEY_ERROR_STRING, paramDataStruct.commandResult.errString);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public DataStruct unpack(String paramString)
  {
    DataStruct localDataStruct = null;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localDataStruct = unpack(new JSONObject(paramString));
      return localDataStruct;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public DataStruct unpack(JSONObject paramJSONObject)
  {
    return DataStructFactory.createDataStruct(PackerUtil.getCommand(paramJSONObject));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/BasePacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */