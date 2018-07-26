package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.KeywordSuggestDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KeywordSuggestPacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = "";
        if (ds != null) {
            KeywordSuggestDataStruct keywordDS = (KeywordSuggestDataStruct) ds;
            JSONObject extDataObj = new JSONObject();
            try {
                extDataObj.put("keyword", keywordDS.keyword);
                extDataObj.put("districtId", keywordDS.districtId);
                JSONObject obj = PackerUtil.createProtocolJSON(keywordDS.mCmd, extDataObj);
                if (obj != null) {
                    result = obj.toString();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public DataStruct unpack(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        JSONObject extDataObj = PackerUtil.getExtDataObj(obj);
        if (extDataObj == null) {
            return null;
        }
        KeywordSuggestDataStruct ds = new KeywordSuggestDataStruct();
        ds.keyword = extDataObj.optString("keyword", "");
        return ds;
    }

    public String packResult(DataStruct ds) {
        String result = null;
        if (ds != null) {
            JSONObject extDataObj = new JSONObject();
            prePackResult(extDataObj, ds);
            Bundle params = ds.commandResult.params;
            if (params != null) {
                try {
                    extDataObj.put("keyword", new JSONArray((String) params.get(KeywordSuggestDataStruct.KEY_KEYWORD_LIST)));
                    JSONObject obj = PackerUtil.createResultJSON(extDataObj);
                    if (obj != null) {
                        result = obj.toString();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
