package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.model.GetStatusDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetStatusPacker
  extends BasePacker
{
  public String packResult(DataStruct paramDataStruct)
  {
    String str = "";
    Object localObject1 = str;
    Object localObject2;
    if (paramDataStruct != null)
    {
      localObject2 = ((GetStatusDataStruct)paramDataStruct).commandResult.params;
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        prePackResult((JSONObject)localObject1, paramDataStruct);
      }
    }
    try
    {
      boolean bool = ((Bundle)localObject2).getBoolean("isNaviBegin", false);
      paramDataStruct = ((Bundle)localObject2).getString("start", "");
      localObject2 = ((Bundle)localObject2).getString("end", "");
      ((JSONObject)localObject1).put("isNaviBegin", bool);
      ((JSONObject)localObject1).put("start", paramDataStruct);
      ((JSONObject)localObject1).put("end", localObject2);
      paramDataStruct = PackerUtil.createResultJSON((JSONObject)localObject1);
      localObject1 = str;
      if (paramDataStruct != null) {
        localObject1 = paramDataStruct.toString();
      }
      return (String)localObject1;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/GetStatusPacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */