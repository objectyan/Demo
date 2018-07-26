package com.baidu.platform.comapi.location;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

public class CoordinateUtil {
    @Nullable
    public static native Point bd09llTobd09mc(double d, double d2);

    @Nullable
    public static native Point bd09llTogcj02ll(double d, double d2);

    @Nullable
    public static native Point bd09mcTobd09ll(double d, double d2);

    @Nullable
    public static native Point gcj02Tobd09ll(double d, double d2);

    public static native double getDistanceByMc(double d, double d2, double d3, double d4);

    private static native Point nativeComplexPtToPoint(String str);

    private static native boolean nativeGeoStringToComplexPt(String str, Bundle bundle);

    private static native boolean nativeGeoStringToComplexPtBound(String str, Bundle bundle);

    private static native Point nativeGeoStringToPoint(String str);

    private static native String nativePointToGeoString(double d, double d2);

    @Nullable
    public static native Point wgs84Togcj02(double d, double d2);

    public static Point geoStringToPoint(String strGeo) {
        if (strGeo == null || strGeo.equals("")) {
            return null;
        }
        return nativeGeoStringToPoint(strGeo);
    }

    public static String pointToGeoString(Point pt) {
        if (pt == null) {
            return "";
        }
        return nativePointToGeoString(pt.getDoubleX(), pt.getDoubleY());
    }

    public static ComplexPt geoStringToComplexPt(String strGeo) {
        if (strGeo == null || strGeo.equals("")) {
            return null;
        }
        Bundle b = new Bundle();
        if (!nativeGeoStringToComplexPt(strGeo, b)) {
            return null;
        }
        ComplexPt p = new ComplexPt();
        Bundle mapBundle = b.getBundle("map_bound");
        if (mapBundle != null) {
            Bundle ll = mapBundle.getBundle("ll");
            if (ll != null) {
                p.mLL = new Point((double) ((int) ll.getDouble(MapObjKey.OBJ_SL_PTX)), (double) ((int) ll.getDouble(MapObjKey.OBJ_SL_PTY)));
            }
            Bundle ru = mapBundle.getBundle("ru");
            if (ru != null) {
                p.mRu = new Point((double) ((int) ru.getDouble(MapObjKey.OBJ_SL_PTX)), (double) ((int) ru.getDouble(MapObjKey.OBJ_SL_PTY)));
            }
        }
        for (ParcelItem aPartArray : (ParcelItem[]) b.getParcelableArray("poly_line")) {
            if (p.mGeoPt == null) {
                p.mGeoPt = new ArrayList();
            }
            Bundle bb = aPartArray.getBundle();
            if (bb != null) {
                ParcelItem[] pointArray = (ParcelItem[]) bb.getParcelableArray("point_array");
                ArrayList<Point> ptArray = new ArrayList();
                for (ParcelItem bundle : pointArray) {
                    Bundle bbb = bundle.getBundle();
                    if (bbb != null) {
                        ptArray.add(new Point((double) ((int) bbb.getDouble(MapObjKey.OBJ_SL_PTX)), (double) ((int) bbb.getDouble(MapObjKey.OBJ_SL_PTY))));
                    }
                }
                ptArray.trimToSize();
                p.mGeoPt.add(ptArray);
            }
        }
        p.mGeoPt.trimToSize();
        p.eType = (int) b.getDouble("type");
        return p;
    }

    public static Point complexPtToPoint(String complexPtStr) {
        if (complexPtStr == null || complexPtStr.equals("")) {
            return null;
        }
        return nativeComplexPtToPoint(complexPtStr);
    }

    public static ComplexPt geoStringToComplexPtBound(String strGeo) {
        ComplexPt complexPt = null;
        if (!(strGeo == null || strGeo.equals(""))) {
            Bundle b = new Bundle();
            if (nativeGeoStringToComplexPtBound(strGeo, b)) {
                complexPt = new ComplexPt();
                Bundle mapBundle = b.getBundle("map_bound");
                if (mapBundle != null) {
                    Bundle ll = mapBundle.getBundle("ll");
                    if (ll != null) {
                        complexPt.mLL = new Point((double) ((int) ll.getDouble(MapObjKey.OBJ_SL_PTX)), (double) ((int) ll.getDouble(MapObjKey.OBJ_SL_PTY)));
                    }
                    Bundle ru = mapBundle.getBundle("ru");
                    if (ru != null) {
                        complexPt.mRu = new Point((double) ((int) ru.getDouble(MapObjKey.OBJ_SL_PTX)), (double) ((int) ru.getDouble(MapObjKey.OBJ_SL_PTY)));
                    }
                }
                complexPt.eType = (int) b.getDouble("type");
            }
        }
        return complexPt;
    }

    @Nullable
    public static Point wgs84Tobd09mc(double x, double y) {
        Point gcj = wgs84Togcj02(x, y);
        if (gcj != null) {
            Point ll = gcj02Tobd09ll(gcj.getDoubleX(), gcj.getDoubleY());
            if (ll != null) {
                return bd09llTobd09mc(ll.getDoubleX(), ll.getDoubleY());
            }
        }
        return null;
    }

    @Nullable
    public static Point wgs84Tobd09ll(double x, double y) {
        Point gcj = wgs84Togcj02(x, y);
        if (gcj != null) {
            return gcj02Tobd09ll(gcj.getDoubleX(), gcj.getDoubleY());
        }
        return null;
    }

    @Nullable
    public static Point gcj02Tobd09mc(double x, double y) {
        Point bd09ll = gcj02Tobd09ll(x, y);
        if (bd09ll != null) {
            return bd09llTobd09mc(bd09ll.getDoubleX(), bd09ll.getDoubleY());
        }
        return null;
    }

    @Nullable
    public static Point bd09mcTogcj02ll(double x, double y) {
        Point bd09ll = bd09mcTobd09ll(x, y);
        if (bd09ll != null) {
            return bd09llTogcj02ll(bd09ll.getDoubleX(), bd09ll.getDoubleY());
        }
        return null;
    }
}
