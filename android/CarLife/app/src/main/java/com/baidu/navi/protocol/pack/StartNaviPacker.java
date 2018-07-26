package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.StartNaviDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class StartNaviPacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = "";
        if (ds != null) {
            StartNaviDataStruct startNaviDS = (StartNaviDataStruct) ds;
            JSONObject extDataObj = new JSONObject();
            try {
                extDataObj.put(StartNaviDataStruct.KEY_USE_CAR_GPS, startNaviDS.useCarGPS);
                JSONObject obj = PackerUtil.createProtocolJSON(startNaviDS.mCmd, extDataObj);
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
        StartNaviDataStruct ds = new StartNaviDataStruct();
        ds.useCarGPS = extDataObj.optBoolean(StartNaviDataStruct.KEY_USE_CAR_GPS, false);
        return ds;
    }
}
