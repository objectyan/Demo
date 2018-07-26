package com.baidu.navisdk.model;

import android.content.Context;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.PreferenceHelperConst;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class AddressSettingModel {
    private static final String DEFAULT_NAME = "地图上的点";

    public static boolean setHomeAddress(Context ctx, String address, String name, int lon, int lat, String poiOriginUID) {
        PreferenceHelper.getInstance(ctx).putString(PreferenceHelperConst.HOME_ADDR_ADDRESS, address);
        PreferenceHelper.getInstance(ctx).putString(PreferenceHelperConst.HOME_ADDR_NAME, name);
        PreferenceHelper.getInstance(ctx).putInt(PreferenceHelperConst.HOME_ADDR_LONGITUDE, lon);
        PreferenceHelper.getInstance(ctx).putInt(PreferenceHelperConst.HOME_ADDR_LATITUDE, lat);
        if (poiOriginUID == null || poiOriginUID.trim().length() == 0) {
            PreferenceHelper.getInstance(ctx).putString(PreferenceHelperConst.HOME_ADDR_POI_ORIGIN_UID, "");
        } else {
            PreferenceHelper.getInstance(ctx).putString(PreferenceHelperConst.HOME_ADDR_POI_ORIGIN_UID, poiOriginUID);
        }
        PreferenceHelper.getInstance(ctx).putBoolean(PreferenceHelperConst.FAMILY_HAS_SYNCED, true);
        return true;
    }

    public static boolean setCompAddress(Context ctx, String address, String name, int lon, int lat, String poiOriginUID) {
        PreferenceHelper.getInstance(ctx).putString(PreferenceHelperConst.COMP_ADDR_ADDRESS, address);
        PreferenceHelper.getInstance(ctx).putString(PreferenceHelperConst.COMP_ADDR_NAME, name);
        PreferenceHelper.getInstance(ctx).putInt(PreferenceHelperConst.COMP_ADDR_LONGITUDE, lon);
        PreferenceHelper.getInstance(ctx).putInt(PreferenceHelperConst.COMP_ADDR_LATITUDE, lat);
        if (poiOriginUID == null || poiOriginUID.trim().length() == 0) {
            PreferenceHelper.getInstance(ctx).putString(PreferenceHelperConst.COMP_ADDR_POI_ORIGIN_UID, "");
        } else {
            PreferenceHelper.getInstance(ctx).putString(PreferenceHelperConst.COMP_ADDR_POI_ORIGIN_UID, poiOriginUID);
        }
        PreferenceHelper.getInstance(ctx).putBoolean(PreferenceHelperConst.COMPANY_HAS_SYNCED, true);
        return true;
    }

    public static boolean removeCompAddress(Context ctx) {
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.COMP_ADDR_LONGITUDE);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.COMP_ADDR_LATITUDE);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.COMP_ADDR_ADDRESS);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.COMP_ADDR_NAME);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.COMP_ADDR_POI_ORIGIN_UID);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.COMP_CITY_ID);
        PreferenceHelper.getInstance(ctx).putBoolean(PreferenceHelperConst.COMPANY_HAS_SYNCED, true);
        return true;
    }

    public static boolean removeHomeAddress(Context ctx) {
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.HOME_ADDR_LONGITUDE);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.HOME_ADDR_LATITUDE);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.HOME_ADDR_ADDRESS);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.HOME_ADDR_NAME);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.HOME_ADDR_POI_ORIGIN_UID);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.HOME_CITY_ID);
        PreferenceHelper.getInstance(ctx).remove(PreferenceHelperConst.FAMILY_HAS_SYNCED);
        PreferenceHelper.getInstance(ctx).putBoolean(PreferenceHelperConst.FAMILY_HAS_SYNCED, true);
        return true;
    }

    public static int getCompLon(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getInt(PreferenceHelperConst.COMP_ADDR_LONGITUDE, 0);
    }

    public static int getCompLat(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getInt(PreferenceHelperConst.COMP_ADDR_LATITUDE, 0);
    }

    public static String getCompAddress(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getString(PreferenceHelperConst.COMP_ADDR_ADDRESS, DEFAULT_NAME);
    }

    public static String getCompPoiOriginUID(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getString(PreferenceHelperConst.COMP_ADDR_POI_ORIGIN_UID, null);
    }

    public static String getCompName(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getString(PreferenceHelperConst.COMP_ADDR_NAME, DEFAULT_NAME);
    }

    public static int getCompCityId(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getInt(PreferenceHelperConst.COMP_CITY_ID, -1);
    }

    public static void setCompCityId(Context ctx, int cityId) {
        PreferenceHelper.getInstance(ctx).putInt(PreferenceHelperConst.COMP_CITY_ID, cityId);
    }

    public static int getHomeLon(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getInt(PreferenceHelperConst.HOME_ADDR_LONGITUDE, 0);
    }

    public static int getHomeLat(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getInt(PreferenceHelperConst.HOME_ADDR_LATITUDE, 0);
    }

    public static String getHomeAddress(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getString(PreferenceHelperConst.HOME_ADDR_ADDRESS, "");
    }

    public static String getHomePoiOriginUID(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getString(PreferenceHelperConst.HOME_ADDR_POI_ORIGIN_UID, null);
    }

    public static String getHomeName(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getString(PreferenceHelperConst.HOME_ADDR_NAME, DEFAULT_NAME);
    }

    public static int getHomeCityId(Context ctx) {
        return PreferenceHelper.getInstance(ctx).getInt(PreferenceHelperConst.HOME_CITY_ID, -1);
    }

    public static void setHomeCityId(Context ctx, int cityId) {
        PreferenceHelper.getInstance(ctx).putInt(PreferenceHelperConst.HOME_CITY_ID, cityId);
    }

    public static boolean hasSetCompAddr(Context ctx) {
        return getCompLat(ctx) > 0 && getCompLon(ctx) > 0;
    }

    public static boolean hasSetHomeAddr(Context ctx) {
        return getHomeLat(ctx) > 0 && getHomeLon(ctx) > 0;
    }

    public static RoutePlanNode getCompAddrNode(Context ctx) {
        if (hasSetCompAddr(ctx)) {
            return new RoutePlanNode(new GeoPoint(getCompLon(ctx), getCompLat(ctx)), 5, getCompName(ctx), getCompAddress(ctx), getCompPoiOriginUID(ctx));
        }
        RoutePlanNode node = new RoutePlanNode();
        node.setFrom(5);
        return node;
    }

    public static RoutePlanNode getHomeAddrNode(Context ctx) {
        if (hasSetHomeAddr(ctx)) {
            return new RoutePlanNode(new GeoPoint(getHomeLon(ctx), getHomeLat(ctx)), 4, getHomeName(ctx), getHomeAddress(ctx), getHomePoiOriginUID(ctx));
        }
        RoutePlanNode node = new RoutePlanNode();
        node.setFrom(4);
        return node;
    }

    public static boolean setHomeAddress(Context ctx, RoutePlanNode node) {
        setHomeCityId(ctx, -1);
        return setHomeAddress(ctx, node.mDescription, node.mName, node.getLongitudeE6(), node.getLatitudeE6(), node.mUID);
    }

    public static boolean setCompAddress(Context ctx, RoutePlanNode node) {
        setCompCityId(ctx, -1);
        return setCompAddress(ctx, node.mDescription, node.mName, node.getLongitudeE6(), node.getLatitudeE6(), node.mUID);
    }
}
