package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.VoiceRecogniseDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceRecognisePacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = "";
        if (ds != null) {
            VoiceRecogniseDataStruct voiceDS = (VoiceRecogniseDataStruct) ds;
            JSONObject extDataObj = new JSONObject();
            try {
                extDataObj.put(VoiceRecogniseDataStruct.KEY_FILE_PATH, voiceDS.filePath);
                JSONObject obj = PackerUtil.createProtocolJSON(voiceDS.mCmd, extDataObj);
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
        VoiceRecogniseDataStruct ds = new VoiceRecogniseDataStruct();
        ds.filePath = extDataObj.optString(VoiceRecogniseDataStruct.KEY_FILE_PATH, "");
        return ds;
    }

    public String packResult(DataStruct ds) {
        String result = null;
        if (ds != null) {
            JSONObject extDataObj = new JSONObject();
            prePackResult(extDataObj, ds);
            Bundle params = ds.commandResult.params;
            if (params != null) {
                String list = params.getString("list", "[]");
                int type = params.getInt("type", 0);
                try {
                    extDataObj.put("list", new JSONArray(list));
                    extDataObj.put("type", type);
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
