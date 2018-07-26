package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.GeoPointInfo;
import com.baidu.navi.protocol.model.RerouteDataStruct;
import com.baidu.navi.protocol.model.RoutePlanDataStruct;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReroutePacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = null;
        if (ds != null && (ds instanceof RerouteDataStruct)) {
            RerouteDataStruct guideDs = (RerouteDataStruct) ds;
            try {
                JSONObject extDataObj = new JSONObject();
                JSONObject startObj = GeoPointInfo.toJSONObject(guideDs.startPoint, false, false);
                JSONObject endObj = GeoPointInfo.toJSONObject(guideDs.endPoint, false, false);
                JSONArray viaObj = GeoPointInfo.toJSONArray(guideDs.mViaPoints);
                extDataObj.put("start", startObj);
                extDataObj.put("end", endObj);
                extDataObj.put(RoutePlanDataStruct.KEY_VIA, viaObj);
                extDataObj.put(RoutePlanDataStruct.KEY_CALMODE, guideDs.calMode);
                extDataObj.put(RoutePlanDataStruct.KEY_ADD_HISTORY, guideDs.addHistory);
                JSONObject obj = PackerUtil.createProtocolJSON(BNaviProtocolDef.COMMAND_REROUTE, extDataObj);
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
        RerouteDataStruct ds = null;
        if (obj != null) {
            JSONObject extDataObj = PackerUtil.getExtDataObj(obj);
            if (extDataObj != null) {
                JSONObject startObj = extDataObj.optJSONObject("start");
                JSONObject endObj = extDataObj.optJSONObject("end");
                JSONArray viaObj = extDataObj.optJSONArray(RoutePlanDataStruct.KEY_VIA);
                int calMode = extDataObj.optInt(RoutePlanDataStruct.KEY_CALMODE, 1);
                boolean addHistory = extDataObj.optBoolean(RoutePlanDataStruct.KEY_ADD_HISTORY, false);
                ds = new RerouteDataStruct();
                ds.calMode = calMode;
                ds.addHistory = addHistory;
                if (startObj != null) {
                    ds.startPoint = GeoPointInfo.jsonToGeo(startObj);
                }
                if (endObj != null) {
                    ds.endPoint = GeoPointInfo.jsonToGeo(endObj);
                }
                if (viaObj != null) {
                    ds.mViaPoints = GeoPointInfo.jsonToList(viaObj);
                }
            }
        }
        return ds;
    }
}
