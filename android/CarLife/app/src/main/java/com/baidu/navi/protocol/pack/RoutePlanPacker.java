package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.GeoPointInfo;
import com.baidu.navi.protocol.model.RoutePlanDataStruct;
import com.baidu.navi.protocol.model.RoutePlanDataStruct.ResultKey;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RoutePlanPacker extends BasePacker {
    private static final String TAG = RoutePlanPacker.class.getSimpleName();

    public String pack(DataStruct ds) {
        String result = null;
        if (ds != null && (ds instanceof RoutePlanDataStruct)) {
            RoutePlanDataStruct guideDs = (RoutePlanDataStruct) ds;
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
                JSONObject obj = PackerUtil.createProtocolJSON("route", extDataObj);
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
        RoutePlanDataStruct ds = null;
        if (obj != null) {
            JSONObject extDataObj = PackerUtil.getExtDataObj(obj);
            if (extDataObj != null) {
                JSONObject startObj = extDataObj.optJSONObject("start");
                JSONObject endObj = extDataObj.optJSONObject("end");
                JSONArray viaObj = extDataObj.optJSONArray(RoutePlanDataStruct.KEY_VIA);
                int calMode = extDataObj.optInt(RoutePlanDataStruct.KEY_CALMODE, 1);
                boolean addHistory = extDataObj.optBoolean(RoutePlanDataStruct.KEY_ADD_HISTORY, false);
                ds = new RoutePlanDataStruct();
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

    public String packResult(DataStruct ds) {
        String result = null;
        if (ds != null) {
            try {
                JSONObject extDataObj = new JSONObject();
                prePackResult(extDataObj, ds);
                Bundle params = ds.commandResult.params;
                if (params != null) {
                    String key = ResultKey.TOTAL_TIME;
                    if (params.containsKey(key)) {
                        String totalTime = params.getString(key);
                        if (!TextUtils.isEmpty(totalTime)) {
                            extDataObj.put(key, totalTime);
                        }
                    }
                    key = "distance";
                    if (params.containsKey(key)) {
                        String distance = params.getString(key);
                        if (!TextUtils.isEmpty(distance)) {
                            extDataObj.put(key, distance);
                        }
                    }
                }
                JSONObject obj = PackerUtil.createResultJSON(extDataObj);
                if (obj != null) {
                    result = obj.toString();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
