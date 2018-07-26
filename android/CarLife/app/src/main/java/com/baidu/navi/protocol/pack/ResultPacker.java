package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.ResultDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultPacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = null;
        if (ds != null && (ds instanceof ResultDataStruct)) {
            ResultDataStruct rds = (ResultDataStruct) ds;
            try {
                JSONObject extDataObj = new JSONObject();
                extDataObj.put(ResultDataStruct.KEY_ERROR_CODE, rds.errCode);
                extDataObj.put(ResultDataStruct.KEY_ERROR_STRING, rds.errString);
                JSONObject obj = PackerUtil.createProtocolJSON("result", extDataObj);
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
        int errCode = extDataObj.optInt(ResultDataStruct.KEY_ERROR_CODE, 0);
        String errString = extDataObj.optString(ResultDataStruct.KEY_ERROR_STRING);
        ResultDataStruct ds = new ResultDataStruct();
        ds.errCode = errCode;
        ds.errString = errString;
        return ds;
    }
}
