package com.baidu.navi.protocol.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FavoriteDataInfo {
    public static String KEY_FAVADDR = "favaddr";
    public static String KEY_FAVCITYID = "favcityid";
    public static String KEY_FAVCITYNAME = "favcityname";
    public static String KEY_FAVKEY = "favkey";
    public static String KEY_FAVNAME = "favname";
    public static String KEY_FAVPHONE = "favphone";
    public static String KEY_FAVTIME = "favtime";
    public static String KEY_LATITUDE = "favlatitude";
    public static String KEY_LONGTITUDE = "favlongtitude";
    public String mFavAddr;
    public int mFavCityId;
    public String mFavCityName;
    public String mFavKey;
    public String mFavName;
    public String mFavTime;
    public int mLatitude;
    public int mLongtitude;
    public String mPhone;

    public FavoriteDataInfo(String favKey, String favName, String favAddr, String favPhone, String favCityName, int favCityId, String favTime, int favLongtitude, int favLatitude) {
        this.mFavKey = favKey;
        this.mFavName = favName;
        this.mFavAddr = favAddr;
        this.mPhone = favPhone;
        this.mFavCityName = favCityName;
        this.mFavCityId = favCityId;
        this.mFavTime = favTime;
        this.mLongtitude = favLongtitude;
        this.mLatitude = favLatitude;
    }

    public static JSONObject toJsonObject(FavoriteDataInfo info) {
        if (info == null) {
            return null;
        }
        JSONObject obj = new JSONObject();
        try {
            obj.put(KEY_FAVCITYNAME, info.mFavCityName);
            obj.put(KEY_FAVNAME, info.mFavName);
            obj.put(KEY_FAVADDR, info.mFavAddr);
            obj.put(KEY_FAVCITYID, info.mFavCityId);
            obj.put(KEY_FAVKEY, info.mFavKey);
            obj.put(KEY_FAVPHONE, info.mPhone);
            obj.put(KEY_FAVTIME, info.mFavTime);
            obj.put(KEY_LATITUDE, info.mLatitude);
            obj.put(KEY_LONGTITUDE, info.mLongtitude);
            return obj;
        } catch (JSONException e) {
            e.printStackTrace();
            return obj;
        }
    }

    public static JSONArray toJsonArray(List<FavoriteDataInfo> infoList) {
        if (infoList == null) {
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < infoList.size(); i++) {
            jsonArray.put(toJsonObject((FavoriteDataInfo) infoList.get(i)));
        }
        return jsonArray;
    }

    public static FavoriteDataInfo valueOf(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        try {
            String cityName = obj.getString(KEY_FAVCITYNAME);
            return new FavoriteDataInfo(obj.getString(KEY_FAVKEY), obj.getString(KEY_FAVNAME), obj.getString(KEY_FAVADDR), obj.getString(KEY_FAVPHONE), cityName, obj.getInt(KEY_FAVCITYID), obj.getString(KEY_FAVTIME), obj.getInt(KEY_LONGTITUDE), obj.getInt(KEY_LATITUDE));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<FavoriteDataInfo> valueOf(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        List<FavoriteDataInfo> infolist = new ArrayList(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                infolist.add(valueOf(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return infolist;
    }
}
