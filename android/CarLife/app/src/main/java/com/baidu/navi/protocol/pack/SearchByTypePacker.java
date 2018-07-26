package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.SearchByTypeDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchByTypePacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = "";
        if (ds != null) {
            SearchByTypeDataStruct keywordDS = (SearchByTypeDataStruct) ds;
            JSONObject extDataObj = new JSONObject();
            try {
                extDataObj.put("type", keywordDS.type);
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
        SearchByTypeDataStruct ds = new SearchByTypeDataStruct();
        ds.type = extDataObj.optInt("type", 0);
        return ds;
    }

    public String packResult(DataStruct ds) {
        String result = null;
        if (ds != null) {
            JSONObject extDataObj = new JSONObject();
            prePackResult(extDataObj, ds);
            Bundle params = ds.commandResult.params;
            if (params != null) {
                String strList = (String) params.get("poiList");
                boolean onlineSearch = params.getBoolean(SearchByTypeDataStruct.KEY_ONLINE_SEARCH, false);
                try {
                    extDataObj.put("poiList", new JSONArray(strList));
                    extDataObj.put(SearchByTypeDataStruct.KEY_ONLINE_SEARCH, onlineSearch);
                    if (onlineSearch && ds.commandResult.errCode != 0) {
                        extDataObj.put(SearchByTypeDataStruct.KEY_FIRST_TIME_ONLINE_SEARCH, params.getBoolean(SearchByTypeDataStruct.KEY_FIRST_TIME_ONLINE_SEARCH, false));
                    }
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
