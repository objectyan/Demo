package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.GetStatusDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetStatusPacker extends BasePacker {
    public String packResult(DataStruct ds) {
        String result = "";
        if (ds == null) {
            return result;
        }
        Bundle params = ((GetStatusDataStruct) ds).commandResult.params;
        if (params == null) {
            return result;
        }
        JSONObject extData = new JSONObject();
        prePackResult(extData, ds);
        try {
            boolean isNaviBegin = params.getBoolean(GetStatusDataStruct.KEY_IS_NAVI_BEGIN, false);
            String strStart = params.getString("start", "");
            String strEnd = params.getString("end", "");
            extData.put(GetStatusDataStruct.KEY_IS_NAVI_BEGIN, isNaviBegin);
            extData.put("start", strStart);
            extData.put("end", strEnd);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject obj = PackerUtil.createResultJSON(extData);
        if (obj != null) {
            return obj.toString();
        }
        return result;
    }
}
