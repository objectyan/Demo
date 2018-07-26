package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.GetMapScaleDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetMapScalePacker extends BasePacker {
    public String packResult(DataStruct ds) {
        String result = "";
        if (ds == null) {
            return result;
        }
        Bundle params = ((GetMapScaleDataStruct) ds).commandResult.params;
        if (params == null) {
            return result;
        }
        JSONObject extDataObj = new JSONObject();
        prePackResult(extDataObj, ds);
        try {
            extDataObj.put(GetMapScaleDataStruct.KEY_MAP_SCALE_LEVEL, params.getInt(GetMapScaleDataStruct.KEY_MAP_SCALE_LEVEL, 0));
            extDataObj.put(GetMapScaleDataStruct.KEY_MAP_SCALE_DIS, params.getInt(GetMapScaleDataStruct.KEY_MAP_SCALE_DIS, 0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject obj = PackerUtil.createResultJSON(extDataObj);
        if (obj != null) {
            return obj.toString();
        }
        return result;
    }
}
