package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.model.GetMapScaleDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetMapScalePacker
  extends BasePacker
{
  public String packResult(DataStruct paramDataStruct)
  {
    String str = "";
    Object localObject = str;
    Bundle localBundle;
    if (paramDataStruct != null)
    {
      localBundle = ((GetMapScaleDataStruct)paramDataStruct).commandResult.params;
      localObject = str;
      if (localBundle != null)
      {
        localObject = new JSONObject();
        prePackResult((JSONObject)localObject, paramDataStruct);
      }
    }
    try
    {
      ((JSONObject)localObject).put("scaleLevel", localBundle.getInt("scaleLevel", 0));
      ((JSONObject)localObject).put("scaleDis", localBundle.getInt("scaleDis", 0));
      paramDataStruct = PackerUtil.createResultJSON((JSONObject)localObject);
      localObject = str;
      if (paramDataStruct != null) {
        localObject = paramDataStruct.toString();
      }
      return (String)localObject;
    }
    catch (JSONException paramDataStruct)
    {
      for (;;)
      {
        paramDataStruct.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/GetMapScalePacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */