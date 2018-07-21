package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.model.GetAddressDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAddressPacker
  extends BasePacker
{
  public String packResult(DataStruct paramDataStruct)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataStruct != null) {
      localObject1 = (GetAddressDataStruct)paramDataStruct;
    }
    try
    {
      paramDataStruct = new JSONObject();
      prePackResult(paramDataStruct, (DataStruct)localObject1);
      localObject1 = ((GetAddressDataStruct)localObject1).commandResult.params;
      if (localObject1 != null)
      {
        if (((Bundle)localObject1).containsKey("home"))
        {
          Object localObject3 = ((Bundle)localObject1).getString("home", "");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject3 = new JSONObject((String)localObject3);
            if (localObject3 != null) {
              paramDataStruct.put("home", localObject3);
            }
          }
        }
        if (((Bundle)localObject1).containsKey("company"))
        {
          localObject1 = ((Bundle)localObject1).getString("company", "");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            if (localObject1 != null) {
              paramDataStruct.put("company", localObject1);
            }
          }
        }
      }
      paramDataStruct = PackerUtil.createResultJSON(paramDataStruct);
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/GetAddressPacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */