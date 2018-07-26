package com.baidu.navi.protocol.pack;

import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.DataStructFactory;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BasePacker {
    public String pack(DataStruct ds) {
        if (ds == null) {
            return null;
        }
        JSONObject obj = PackerUtil.createJSONWithoutParam(ds.mCmd);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public DataStruct unpack(JSONObject obj) {
        return DataStructFactory.createDataStruct(PackerUtil.getCommand(obj));
    }

    public DataStruct unpack(String json) {
        DataStruct ds = null;
        if (!TextUtils.isEmpty(json)) {
            try {
                ds = unpack(new JSONObject(json));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ds;
    }

    public String packResult(DataStruct ds) {
        JSONObject extDataObj = new JSONObject();
        prePackResult(extDataObj, ds);
        return PackerUtil.createResultJSON(extDataObj).toString();
    }

    public void prePackResult(JSONObject obj, DataStruct ds) {
        try {
            obj.put(DataStruct.KEY_METHOD_NAME, ds.mCmd);
            obj.put(DataStruct.KEY_ERROR_CODE, ds.commandResult.errCode);
            obj.put(DataStruct.KEY_ERROR_STRING, ds.commandResult.errString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
