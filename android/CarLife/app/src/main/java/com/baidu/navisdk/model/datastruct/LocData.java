package com.baidu.navisdk.model.datastruct;

import com.baidu.navi.driveanalysis.CommonConstants;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocData implements Cloneable {
    public static final double LOCDEFAULT = -1.0d;
    public float accuracy;
    public double altitude;
    public float direction;
    public int indoorState;
    public double latitude = -1.0d;
    public int locType;
    public double longitude = -1.0d;
    public String networkLocType;
    public int satellitesNum;
    public float speed;
    public long time;
    public int type;

    public boolean isValid() {
        return (this.longitude == -1.0d || this.latitude == -1.0d) ? false : true;
    }

    public int getStartPointUpStreamLocType() {
        if (this.type == 61) {
            return 1;
        }
        if (this.type != 161) {
            return 0;
        }
        if ("wf".equalsIgnoreCase(this.networkLocType)) {
            return 2;
        }
        if ("cl".equalsIgnoreCase(this.networkLocType)) {
            return 3;
        }
        return 0;
    }

    public LocData clone() {
        LocData newLoc = new LocData();
        synchronized (this) {
            newLoc.accuracy = this.accuracy;
            newLoc.direction = this.direction;
            newLoc.latitude = this.latitude;
            newLoc.longitude = this.longitude;
            newLoc.satellitesNum = this.satellitesNum;
            newLoc.speed = this.speed;
            newLoc.altitude = this.altitude;
            newLoc.type = this.type;
            newLoc.time = this.time;
            newLoc.locType = this.locType;
        }
        return newLoc;
    }

    public String toString() {
        return String.format("LocData {longitude:%1$f latitude:%2$f direction:%3$.1f speed:%4$.1f sat:%5$d}", new Object[]{Double.valueOf(this.longitude), Double.valueOf(this.latitude), Float.valueOf(this.direction), Float.valueOf(this.speed), Integer.valueOf(this.satellitesNum)});
    }

    public String toLocationOverlayJsonString(boolean bShowWheel) {
        JSONObject dataset = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject elem = new JSONObject();
        JSONObject elemEx = new JSONObject();
        try {
            dataset.put("type", 0);
            if (null != null) {
                elem.put(MapObjKey.OBJ_SL_PTX, null.f19727x);
                elem.put(MapObjKey.OBJ_SL_PTY, null.f19728y);
            } else {
                elem.put(MapObjKey.OBJ_SL_PTX, this.longitude);
                elem.put(MapObjKey.OBJ_SL_PTY, this.latitude);
            }
            elem.put(CommonConstants.RADIUS, (double) this.accuracy);
            elem.put("direction", (double) this.direction);
            elem.put("iconarrownor", "NormalLocArrow");
            elem.put("iconarrownorid", 28);
            elem.put("iconarrowfoc", "FocusLocArrow");
            elem.put("iconarrowfocid", 29);
            jsonArray.put(elem);
            if (bShowWheel) {
                if (null != null) {
                    elemEx.put(MapObjKey.OBJ_SL_PTX, null.f19727x);
                    elemEx.put(MapObjKey.OBJ_SL_PTY, null.f19728y);
                } else {
                    elemEx.put(MapObjKey.OBJ_SL_PTX, this.longitude);
                    elemEx.put(MapObjKey.OBJ_SL_PTY, this.latitude);
                }
                elemEx.put(CommonConstants.RADIUS, 0);
                elemEx.put("direction", 0);
                elemEx.put("iconarrownor", "direction_wheel");
                elemEx.put("iconarrownorid", 54);
                elemEx.put("iconarrowfoc", "direction_wheel");
                elemEx.put("iconarrowfocid", 54);
                jsonArray.put(elemEx);
            }
            dataset.put("data", jsonArray);
        } catch (JSONException e) {
        }
        return dataset.toString();
    }

    public String toLocationOverlayJsonStringNoDir() {
        JSONObject dataset = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject elem = new JSONObject();
        try {
            dataset.put("type", 0);
            if (null != null) {
                elem.put(MapObjKey.OBJ_SL_PTX, null.f19727x);
                elem.put(MapObjKey.OBJ_SL_PTY, null.f19728y);
            } else {
                elem.put(MapObjKey.OBJ_SL_PTX, this.longitude);
                elem.put(MapObjKey.OBJ_SL_PTY, this.latitude);
            }
            elem.put(CommonConstants.RADIUS, (double) this.accuracy);
            elem.put("direction", 0);
            elem.put("iconarrownor", "NormalLocArrow");
            elem.put("iconarrownorid", 26);
            elem.put("iconarrowfoc", "FocusLocArrow");
            elem.put("iconarrowfocid", 27);
            jsonArray.put(elem);
            dataset.put("data", jsonArray);
        } catch (JSONException e) {
        }
        return dataset.toString();
    }

    public GeoPoint toGeoPoint() {
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLongitudeE6((int) (this.longitude * 100000.0d));
        geoPoint.setLatitudeE6((int) (this.latitude * 100000.0d));
        return geoPoint;
    }
}
