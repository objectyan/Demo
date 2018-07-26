package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.GetMapImageDataStruct;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetMapImagePacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = null;
        if (ds != null) {
            GetMapImageDataStruct mapDS = (GetMapImageDataStruct) ds;
            try {
                JSONObject extDataObj = new JSONObject();
                extDataObj.put("width", mapDS.width);
                extDataObj.put("height", mapDS.height);
                JSONObject obj = PackerUtil.createProtocolJSON(BNaviProtocolDef.COMMAND_GET_MAP_IMAGE, extDataObj);
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
        GetMapImageDataStruct ds = new GetMapImageDataStruct();
        ds.width = extDataObj.optInt("width", 0);
        ds.height = extDataObj.optInt("height", 0);
        return ds;
    }

    public String packResult(DataStruct ds) {
        String result = "";
        Bundle params = ((GetMapImageDataStruct) ds).commandResult.params;
        if (params != null) {
            JSONObject extDataObj = new JSONObject();
            prePackResult(extDataObj, ds);
            try {
                extDataObj.put("image", params.getString("image"));
                extDataObj.put("imagetype", "jpg");
                extDataObj.put("width", params.getInt("width", 0));
                extDataObj.put("height", params.getInt("height", 0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject obj = PackerUtil.createResultJSON(extDataObj);
            if (obj != null) {
                result = obj.toString();
            }
        }
        if (TextUtils.isEmpty(result)) {
            return result;
        }
        return result.replace("\\", "");
    }
}
