package com.baidu.navi.protocol.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GeoPointInfo {
    public static final String KEY_ADDR = "addr";
    public static final String KEY_DISTANCE = "distance";
    public static final String KEY_INDEX = "index";
    public static final String KEY_NAME = "name";
    public static final String KEY_X = "x";
    public static final String KEY_Y = "y";
    public String addr;
    public String distance = "";
    public int index;
    public String name;
    /* renamed from: x */
    public int f19676x;
    /* renamed from: y */
    public int f19677y;

    public GeoPointInfo(int x, int y, String name) {
        this.f19676x = x;
        this.f19677y = y;
        this.name = name;
    }

    public GeoPointInfo(int x, int y, String name, int index) {
        this.f19676x = x;
        this.f19677y = y;
        this.name = name;
        this.index = index;
    }

    public GeoPointInfo(int x, int y, String name, int index, String addr) {
        this.f19676x = x;
        this.f19677y = y;
        this.name = name;
        this.index = index;
        this.addr = addr;
    }

    public GeoPointInfo(int x, int y, String name, String addr) {
        this.f19676x = x;
        this.f19677y = y;
        this.name = name;
        this.addr = addr;
    }

    public GeoPointInfo(int x, int y, String name, String addr, String distance) {
        this.f19676x = x;
        this.f19677y = y;
        this.name = name;
        this.addr = addr;
        this.distance = distance;
    }

    public GeoPointInfo(int x, int y, String name, int index, String addr, String distance) {
        this.f19676x = x;
        this.f19677y = y;
        this.name = name;
        this.addr = addr;
        this.distance = distance;
    }

    public static JSONObject toJSONObject(GeoPointInfo info, boolean needIndex, boolean needAddr) {
        JSONObject obj = new JSONObject();
        if (info != null) {
            try {
                obj.put("x", info.f19676x);
                obj.put("y", info.f19677y);
                obj.put("name", info.name);
                obj.put("distance", info.distance);
                if (needIndex) {
                    obj.put("index", info.index);
                }
                if (needAddr) {
                    obj.put(KEY_ADDR, info.addr);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public static JSONArray toJSONArray(List<GeoPointInfo> infos, boolean needIndex, boolean needAddr) {
        JSONArray array = new JSONArray();
        if (infos != null && infos.size() > 0) {
            int count = infos.size();
            for (int i = 0; i < count; i++) {
                GeoPointInfo info = (GeoPointInfo) infos.get(i);
                if (info != null) {
                    info.index = i + 1;
                    array.put(toJSONObject(info, needIndex, needAddr));
                }
            }
        }
        return array;
    }

    public static JSONArray toJSONArray(List<GeoPointInfo> infos) {
        JSONArray array = new JSONArray();
        if (infos != null && infos.size() > 0) {
            int count = infos.size();
            for (int i = 0; i < count; i++) {
                GeoPointInfo info = (GeoPointInfo) infos.get(i);
                if (info != null) {
                    info.index = i + 1;
                    array.put(toJSONObject(info, true, false));
                }
            }
        }
        return array;
    }

    public static List<GeoPointInfo> jsonToList(JSONArray array) {
        List<GeoPointInfo> infos = null;
        if (array != null && array.length() > 0) {
            int count = array.length();
            infos = new ArrayList(count);
            int i = 0;
            while (i < count) {
                try {
                    GeoPointInfo info = jsonToGeo(array.getJSONObject(i));
                    if (info != null) {
                        infos.add(info);
                        infos.set(info.index - 1, info);
                    }
                    i++;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return infos;
    }

    public static GeoPointInfo jsonToGeo(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        return new GeoPointInfo(obj.optInt("x", 0), obj.optInt("y", 0), obj.optString("name", ""), obj.optInt("index", 0), obj.optString(KEY_ADDR, ""), obj.optString("distance", ""));
    }

    public String toString() {
        return "(x=" + this.f19676x + " y=" + this.f19677y + " name=" + this.name + " index=" + this.index + " addr=" + this.addr + ")";
    }

    public static String listToString(List<GeoPointInfo> infos) {
        StringBuilder sb = new StringBuilder();
        if (infos != null) {
            int count = infos.size();
            sb.append("[");
            for (int i = 0; i < count; i++) {
                sb.append(((GeoPointInfo) infos.get(i)).toString());
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public boolean isValid() {
        if (this.f19676x <= 0 || this.f19677y <= 0) {
            return false;
        }
        return true;
    }
}
