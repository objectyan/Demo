package com.baidu.navisdk.util.common;

import android.os.Bundle;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comjni.tools.JNITools;

public class CoordinateTransformUtil {
    public static final String BD09LL = "bd09ll";
    public static final String BD09MC = "bd09mc";
    public static final String GCJ02 = "gcj02";
    public static final String WGS84 = "wgs84";

    public static Bundle LL2MC(double longtitude, double latitude) {
        Bundle bd;
        try {
            bd = JNITools.LL2MC(longtitude, latitude);
            if (bd != null) {
                return bd;
            }
        } catch (Throwable th) {
        }
        bd = new Bundle();
        bd.putInt("MCx", 0);
        bd.putInt("MCy", 0);
        return bd;
    }

    public static Bundle LLE62MC(int longtitudeE6, int latitudeE6) {
        Bundle bd;
        try {
            bd = JNITools.LL2MC(((double) longtitudeE6) / 100000.0d, ((double) latitudeE6) / 100000.0d);
            if (bd != null) {
                return bd;
            }
        } catch (Throwable th) {
        }
        bd = new Bundle();
        bd.putInt("MCx", 0);
        bd.putInt("MCy", 0);
        return bd;
    }

    public static Bundle MC2LL(int MCx, int MCy) {
        Bundle bd;
        try {
            bd = JNITools.MC2LL(MCx, MCy);
            if (bd != null) {
                return bd;
            }
        } catch (Throwable th) {
        }
        bd = new Bundle();
        bd.putDouble("LLx", 0.0d);
        bd.putDouble("LLy", 0.0d);
        return bd;
    }

    public static Bundle MC2LLE6(int MCx, int MCy) {
        Bundle bundle = MC2LL(MCx, MCy);
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putInt("LLx", 0);
            bundle.putInt("LLy", 0);
            return bundle;
        }
        int latE6 = (int) (bundle.getDouble("LLy") * 100000.0d);
        bundle.putInt("LLx", (int) (bundle.getDouble("LLx") * 100000.0d));
        bundle.putInt("LLy", latE6);
        return bundle;
    }

    public static GeoPoint transferWGS84ToGCJ02(double longtitude, double latitude) {
        GeoPoint point = new GeoPoint();
        Bundle bundle = JNITools.WGS2GCJ(longtitude, latitude);
        if (bundle != null) {
            int longtitudeE6 = (int) (bundle.getDouble("LLx") * 100000.0d);
            point.setLatitudeE6((int) (bundle.getDouble("LLy") * 100000.0d));
            point.setLongitudeE6(longtitudeE6);
        }
        return point;
    }

    public static Bundle transferGCJ02ToWGS84(double longtitude, double latitude) {
        Bundle bundle = JNITools.GCJ2WGS(longtitude, latitude);
        if (bundle != null) {
            return bundle;
        }
        bundle = new Bundle();
        bundle.putInt("LLx", 0);
        bundle.putInt("LLy", 0);
        return bundle;
    }

    public static GeoPoint transferBD09ToGCJ02(double longtitude, double latitude) {
        GeoPoint point = new GeoPoint();
        Bundle bundle = JNITools.BD2GCJ(longtitude, latitude);
        if (bundle != null) {
            int longtitudeE6 = (int) (bundle.getDouble("LLx") * 100000.0d);
            point.setLatitudeE6((int) (bundle.getDouble("LLy") * 100000.0d));
            point.setLongitudeE6(longtitudeE6);
        }
        return point;
    }

    public static GeoPoint transferGCJ02ToBD09(double longtitude, double latitude) {
        GeoPoint point = new GeoPoint();
        Bundle bundle = JNITools.GCJ2BD(longtitude, latitude);
        if (bundle != null) {
            int longtitudeE6 = (int) (bundle.getDouble("LLx") * 100000.0d);
            point.setLatitudeE6((int) (bundle.getDouble("LLy") * 100000.0d));
            point.setLongitudeE6(longtitudeE6);
        }
        return point;
    }

    public static GeoPoint coordSysChangeByType(int type, double x, double y) {
        GeoPoint point = new GeoPoint();
        Bundle bundle = JNITools.CoordSysChangeByType(type, x, y);
        if (bundle != null) {
            int longtitudeE6 = (int) (bundle.getDouble("x") * 100000.0d);
            point.setLatitudeE6((int) (bundle.getDouble("y") * 100000.0d));
            point.setLongitudeE6(longtitudeE6);
        }
        return point;
    }
}
