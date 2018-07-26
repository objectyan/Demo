package com.baidu.platform.comapi.location;

import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;

public class LocationMgr {

    private static final class HOLDER {
        private static final LocationMgr INSTANCE = new LocationMgr();

        private HOLDER() {
        }
    }

    public static LocationMgr getInstance() {
        return HOLDER.INSTANCE;
    }

    private LocationMgr() {
    }

    public Point Coordinate_encryptEx(float x, float y, String bType) {
        if (bType == null) {
            return null;
        }
        if (bType.equals("")) {
            bType = "bd09ll";
        }
        Object obj = -1;
        switch (bType.hashCode()) {
            case -1395470197:
                if (bType.equals("bd09ll")) {
                    obj = 2;
                    break;
                }
                break;
            case -1395470175:
                if (bType.equals("bd09mc")) {
                    obj = 3;
                    break;
                }
                break;
            case 98175376:
                if (bType.equals("gcj02")) {
                    obj = 1;
                    break;
                }
                break;
            case 113079775:
                if (bType.equals("wgs84")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return CoordinateUtil.wgs84Tobd09mc((double) x, (double) y);
            case 1:
                return CoordinateUtil.gcj02Tobd09mc((double) x, (double) y);
            case 2:
                return CoordinateUtil.bd09llTobd09mc((double) x, (double) y);
            case 3:
                return new Point((double) x, (double) y);
            default:
                return null;
        }
    }

    public ArrayList<Point> Coordinate_encryptExArray(ArrayList<Point> pointArrayList, String bType) {
        ArrayList<Point> arrayList = null;
        if (bType != null) {
            if (bType.equals("")) {
                bType = "bd09ll";
            }
            if (bType.equals("bd09ll") || bType.equals("bd09mc") || bType.equals("gcj02") || bType.equals("wgs84")) {
                int i;
                float[] x = new float[pointArrayList.size()];
                float[] y = new float[pointArrayList.size()];
                for (i = 0; i < pointArrayList.size(); i++) {
                    x[i] = ((float) ((Point) pointArrayList.get(i)).getIntX()) / 100000.0f;
                    y[i] = ((float) ((Point) pointArrayList.get(i)).getIntY()) / 100000.0f;
                }
                arrayList = new ArrayList();
                for (i = 0; i < x.length; i++) {
                    Point p = null;
                    Object obj = -1;
                    switch (bType.hashCode()) {
                        case -1395470197:
                            if (bType.equals("bd09ll")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case -1395470175:
                            if (bType.equals("bd09mc")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 98175376:
                            if (bType.equals("gcj02")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 113079775:
                            if (bType.equals("wgs84")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            p = CoordinateUtil.wgs84Tobd09mc((double) x[i], (double) y[i]);
                            break;
                        case 1:
                            p = CoordinateUtil.gcj02Tobd09mc((double) x[i], (double) y[i]);
                            break;
                        case 2:
                            p = CoordinateUtil.bd09llTobd09mc((double) x[i], (double) y[i]);
                            break;
                        case 3:
                            p = new Point((double) x[i], (double) y[i]);
                            break;
                    }
                    if (p != null) {
                        arrayList.add(p);
                    }
                }
            }
        }
        return arrayList;
    }
}
