package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.HUDGuideDataStruct;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class HUDPacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = null;
        if (ds != null) {
            HUDGuideDataStruct hudDs = (HUDGuideDataStruct) ds;
            try {
                JSONObject extDataObj = new JSONObject();
                extDataObj.put("name", hudDs.nextRoadName);
                extDataObj.put("direction", hudDs.direction);
                extDataObj.put(HUDGuideDataStruct.KEY_DISTANCE, hudDs.distance);
                extDataObj.put(HUDGuideDataStruct.KEY_ICON_NAME, hudDs.iconName);
                extDataObj.put("remainDistance", hudDs.remainDistance);
                extDataObj.put("remainTime", hudDs.remainTime);
                JSONObject obj = PackerUtil.createProtocolJSON(BNaviProtocolDef.COMMAND_NOTIFY_GUIDE_INFO, extDataObj);
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
        HUDGuideDataStruct ds = new HUDGuideDataStruct();
        ds.nextRoadName = extDataObj.optString("name", "");
        ds.direction = extDataObj.optString("direction", "");
        ds.distance = extDataObj.optString(HUDGuideDataStruct.KEY_DISTANCE, "");
        ds.iconName = extDataObj.optString(HUDGuideDataStruct.KEY_ICON_NAME, "");
        ds.remainDistance = extDataObj.optString("remainDistance", "");
        ds.remainTime = extDataObj.optString("remainTime", "");
        return ds;
    }
}
