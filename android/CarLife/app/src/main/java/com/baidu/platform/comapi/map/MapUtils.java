package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;

public class MapUtils {
    public static GeoPoint mc2ll(GeoPoint pt) {
        Point p = CoordinateUtil.bd09mcTobd09ll(pt.getLongitude(), pt.getLatitude());
        if (p != null) {
            return new GeoPoint(p.getDoubleY(), p.getDoubleX());
        }
        return null;
    }

    public static GeoPoint ll2mc(GeoPoint point) {
        Point p = CoordinateUtil.bd09llTobd09mc(point.getLongitude(), point.getLatitude());
        if (p != null) {
            return new GeoPoint(p.getDoubleY(), p.getDoubleX());
        }
        return null;
    }
}
