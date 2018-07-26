package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.UpdateLocationDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateLocationPacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = "";
        if (ds != null) {
            UpdateLocationDataStruct ulDS = (UpdateLocationDataStruct) ds;
            JSONObject extDataObj = new JSONObject();
            try {
                extDataObj.put("longitude", ulDS.longitude);
                extDataObj.put("latitude", ulDS.latitude);
                extDataObj.put("speed", (double) ulDS.speed);
                extDataObj.put(UpdateLocationDataStruct.KEY_ACCURACY, (double) ulDS.accuracy);
                extDataObj.put(UpdateLocationDataStruct.KEY_BEARING, (double) ulDS.bearing);
                extDataObj.put(UpdateLocationDataStruct.KEY_ALTITUDE, ulDS.altitude);
                extDataObj.put(UpdateLocationDataStruct.KEY_SATELLITES, ulDS.satellites);
                JSONObject obj = PackerUtil.createProtocolJSON(ulDS.mCmd, extDataObj);
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
        UpdateLocationDataStruct ds = new UpdateLocationDataStruct();
        ds.longitude = extDataObj.optDouble("longitude", 0.0d);
        ds.latitude = extDataObj.optDouble("latitude", 0.0d);
        ds.speed = (float) extDataObj.optDouble("speed", 0.0d);
        ds.accuracy = (float) extDataObj.optDouble(UpdateLocationDataStruct.KEY_ACCURACY, 0.0d);
        ds.bearing = (float) extDataObj.optDouble(UpdateLocationDataStruct.KEY_BEARING, 0.0d);
        ds.altitude = extDataObj.optDouble(UpdateLocationDataStruct.KEY_ALTITUDE, 0.0d);
        ds.satellites = extDataObj.optInt(UpdateLocationDataStruct.KEY_SATELLITES, 0);
        return ds;
    }
}
