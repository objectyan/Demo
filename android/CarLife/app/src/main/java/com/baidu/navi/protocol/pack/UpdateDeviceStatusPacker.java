package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.UpdateDeviceStatusDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateDeviceStatusPacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = "";
        if (ds != null) {
            UpdateDeviceStatusDataStruct udsDS = (UpdateDeviceStatusDataStruct) ds;
            JSONObject extDataObj = new JSONObject();
            try {
                extDataObj.put(UpdateDeviceStatusDataStruct.KEY_DEVICE, udsDS.device);
                extDataObj.put(UpdateDeviceStatusDataStruct.KEY_ENABLED, udsDS.enabled);
                JSONObject obj = PackerUtil.createProtocolJSON(udsDS.mCmd, extDataObj);
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
        UpdateDeviceStatusDataStruct ds = new UpdateDeviceStatusDataStruct();
        ds.device = extDataObj.optString(UpdateDeviceStatusDataStruct.KEY_DEVICE, "");
        ds.enabled = extDataObj.optBoolean(UpdateDeviceStatusDataStruct.KEY_ENABLED, false);
        return ds;
    }
}
