package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.GetFavoriteDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetFavoritePacker extends BasePacker {
    public String packResult(DataStruct ds) {
        String result = "";
        Bundle params = ((GetFavoriteDataStruct) ds).commandResult.params;
        if (!params.containsKey(GetFavoriteDataStruct.KEY_FAVORITE_LIST)) {
            return result;
        }
        String strList = params.getString(GetFavoriteDataStruct.KEY_FAVORITE_LIST, "");
        JSONObject extDataObj = new JSONObject();
        if (TextUtils.isEmpty(strList)) {
            return result;
        }
        JSONArray array = null;
        try {
            array = new JSONArray(strList);
        } catch (JSONException e) {
        }
        prePackResult(extDataObj, ds);
        try {
            extDataObj.put(GetFavoriteDataStruct.KEY_FAVORITE_LIST, array);
        } catch (JSONException e2) {
        }
        JSONObject obj = PackerUtil.createResultJSON(extDataObj);
        if (obj != null) {
            return obj.toString();
        }
        return result;
    }
}
