package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStruct.CommandResult;
import com.baidu.navi.protocol.model.GetFavoriteDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetFavoritePacker
  extends BasePacker
{
  public String packResult(DataStruct paramDataStruct)
  {
    String str = "";
    Object localObject2 = ((GetFavoriteDataStruct)paramDataStruct).commandResult.params;
    Object localObject1 = str;
    JSONObject localJSONObject;
    if (((Bundle)localObject2).containsKey("favoriteList"))
    {
      localObject2 = ((Bundle)localObject2).getString("favoriteList", "");
      localJSONObject = new JSONObject();
      localObject1 = str;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = new JSONArray((String)localObject2);
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    prePackResult(localJSONObject, paramDataStruct);
    try
    {
      localJSONObject.put("favoriteList", localObject1);
      paramDataStruct = PackerUtil.createResultJSON(localJSONObject);
      localObject1 = str;
      if (paramDataStruct != null) {
        localObject1 = paramDataStruct.toString();
      }
      return (String)localObject1;
    }
    catch (JSONException paramDataStruct)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/GetFavoritePacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */