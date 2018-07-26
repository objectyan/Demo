package com.baidu.platform.comjni.tools;

import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;

public class AppTools {
    public static Point getGeoPointFromString(String strGeo) {
        if (strGeo == null || strGeo.equals("")) {
            return null;
        }
        return CoordinateUtil.geoStringToPoint(strGeo);
    }

    public static String getStringFromGeoPoint(Point point) {
        return CoordinateUtil.pointToGeoString(point);
    }

    @Deprecated
    public static ComplexPt getGeoComplexPtBoundFromString(String strGeo) {
        if (strGeo == null || strGeo.equals("")) {
            return null;
        }
        return CoordinateUtil.geoStringToComplexPtBound(strGeo);
    }

    @Deprecated
    public static ComplexPt getGeoComplexPointFromString(String strGeo) {
        if (strGeo == null || strGeo.equals("")) {
            return null;
        }
        return CoordinateUtil.geoStringToComplexPt(strGeo);
    }

    public static double getDistanceByMc(Point pt1, Point pt2) {
        return CoordinateUtil.getDistanceByMc(pt1.getDoubleX(), pt1.getDoubleY(), pt2.getDoubleX(), pt2.getDoubleY());
    }

    public static double getDistanceByMc(GeoPoint pt1, GeoPoint pt2) {
        return CoordinateUtil.getDistanceByMc(pt1.getLongitude(), pt1.getLatitude(), pt2.getLongitude(), pt2.getLatitude());
    }
}
