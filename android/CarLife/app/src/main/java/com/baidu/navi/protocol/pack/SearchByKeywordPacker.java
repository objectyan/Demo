package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.SearchByKeywordDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchByKeywordPacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = "";
        if (ds != null) {
            SearchByKeywordDataStruct keywordDS = (SearchByKeywordDataStruct) ds;
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
        SearchByKeywordDataStruct ds = new SearchByKeywordDataStruct();
        ds.keyword = extDataObj.optString("keyword", "");
        ds.districtId = extDataObj.optInt("districtId", 0);
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
                    extDataObj.put("poiList", new JSONArray(params.getString("poiList")));
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
