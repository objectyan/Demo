package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONException;
import org.json.JSONObject;

class InternalProjection implements Projection {
    private MapController mMapController = null;

    public InternalProjection(MapController mapController) {
        this.mMapController = mapController;
    }

    public GeoPoint fromPixels(int x, int y) {
        AppBaseMap baseMap = this.mMapController.getBaseMap();
        if (baseMap == null) {
            return null;
        }
        String strGeoPt = baseMap.ScrPtToGeoPoint(x, y);
        GeoPoint geoPoint = new GeoPoint(0, 0);
        if (strGeoPt != null) {
            try {
                JSONObject jsonObj = new JSONObject(strGeoPt);
                geoPoint.setLongitude(jsonObj.getDouble("geox"));
                geoPoint.setLatitude(jsonObj.getDouble("geoy"));
                return geoPoint;
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public float metersToEquatorPixels(float meters) {
        return (float) (((double) meters) / this.mMapController.getZoomUnitsInMeter());
    }

    public Point toPixels(GeoPoint in, Point out) {
        if (out == null) {
            out = new Point(0.0d, 0.0d);
        }
        AppBaseMap baseMap = this.mMapController.getBaseMap();
        if (baseMap != null) {
            String strScrPt = baseMap.GeoPtToScrPoint((int) in.getLongitude(), (int) in.getLatitude());
            if (strScrPt != null) {
                try {
                    JSONObject jsonObj = new JSONObject(strScrPt);
                    out.setIntX(jsonObj.getInt("scrx"));
                    out.setIntY(jsonObj.getInt("scry"));
                } catch (JSONException e) {
                }
            }
        }
        return out;
    }

    public Point world2Screen(float x, float y, float z) {
        Point out = new Point(0.0d, 0.0d);
        AppBaseMap baseMap = this.mMapController.getBaseMap();
        if (baseMap == null) {
            return out;
        }
        String strScrPt = baseMap.worldPointToScreenPoint(x, y, z);
        if (strScrPt != null) {
            try {
                JSONObject jsonObj = new JSONObject(strScrPt);
                out.setDoubleX(jsonObj.optDouble("scrx"));
                out.setDoubleY(jsonObj.optDouble("scry"));
                return out;
            } catch (JSONException e) {
            }
        }
        return null;
    }
}
