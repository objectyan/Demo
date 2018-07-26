package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.GetPluginInfoDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetPluginInfoPacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = "";
        if (ds != null) {
            GetPluginInfoDataStruct gpiDs = (GetPluginInfoDataStruct) ds;
            JSONObject extDataObj = new JSONObject();
            try {
                extDataObj.put(GetPluginInfoDataStruct.KEY_PLUGIN_ID, gpiDs.pluginId);
                JSONObject obj = PackerUtil.createProtocolJSON(gpiDs.mCmd, extDataObj);
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
        GetPluginInfoDataStruct ds = new GetPluginInfoDataStruct();
        ds.pluginId = extDataObj.optInt(GetPluginInfoDataStruct.KEY_PLUGIN_ID, -1);
        return ds;
    }

    public String packResult(DataStruct ds) {
        String result = "";
        if (ds == null) {
            return result;
        }
        Bundle params = ((GetPluginInfoDataStruct) ds).commandResult.params;
        if (params == null) {
            return result;
        }
        JSONObject extData = new JSONObject();
        prePackResult(extData, ds);
        try {
            String name = params.getString("name");
            String version = params.getString("version");
            String summary = params.getString(GetPluginInfoDataStruct.KEY_SUMMARY);
            boolean running = params.getBoolean(GetPluginInfoDataStruct.KEY_IS_RUNNING, false);
            extData.put("name", name);
            extData.put("version", version);
            extData.put(GetPluginInfoDataStruct.KEY_SUMMARY, summary);
            extData.put(GetPluginInfoDataStruct.KEY_IS_RUNNING, running);
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
