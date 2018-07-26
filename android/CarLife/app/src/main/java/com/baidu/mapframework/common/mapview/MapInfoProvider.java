package com.baidu.mapframework.common.mapview;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapInfoProvider implements MapInfo {
    /* renamed from: a */
    private static final MapInfo f18772a = new MapInfoProvider();

    public static MapInfo getMapInfo() {
        return f18772a;
    }

    private MapInfoProvider() {
    }

    public MapStatus getMapStatus() {
        return MapViewFactory.getInstance().getMapView().getMapStatus();
    }

    public GeoPoint getMapCenter() {
        return MapViewFactory.getInstance().getMapView().getMapCenter();
    }

    public float getMapLevel() {
        return getMapStatus().level;
    }

    public MapBound getMapBound() {
        MapBound bound = new MapBound();
        if (getMapStatus() != null) {
            bound.setLeftBottomPt((int) getMapStatus().geoRound.left, (int) getMapStatus().geoRound.bottom);
            bound.setRightTopPt((int) getMapStatus().geoRound.right, (int) getMapStatus().geoRound.top);
        }
        return bound;
    }

    public float getZoomToBound(MapBound bound) {
        return MapViewFactory.getInstance().getMapView().getZoomToBound(bound);
    }

    public float getZoomToBound(MapBound bound, int width, int height) {
        return MapViewFactory.getInstance().getMapView().getZoomToBound(bound, width, height);
    }

    public int getMapCenterCity() {
        int roamCityID = GlobalConfig.getInstance().getRoamCityId();
        if (roamCityID > 0) {
            return roamCityID;
        }
        MapViewFactory factory = MapViewFactory.getInstance();
        if (factory == null) {
            return 1;
        }
        MapGLSurfaceView mapView = factory.getMapView();
        if (mapView == null) {
            return 1;
        }
        MapController mapController = mapView.getController();
        if (mapController == null) {
            return 1;
        }
        AppBaseMap baseMap = mapController.getBaseMap();
        if (baseMap == null) {
            return 1;
        }
        Bundle b = new Bundle();
        b.putString("querytype", "map");
        baseMap.GetVMPMapCityInfo(b);
        return b.getInt("code");
    }

    public int[] getPoiCitys(double x, double y) {
        MapViewFactory factory = MapViewFactory.getInstance();
        if (factory == null) {
            return null;
        }
        MapGLSurfaceView mapView = factory.getMapView();
        if (mapView == null) {
            return null;
        }
        MapController mapController = mapView.getController();
        if (mapController == null) {
            return null;
        }
        AppBaseMap baseMap = mapController.getBaseMap();
        if (baseMap == null) {
            return null;
        }
        Bundle b = new Bundle();
        b.putString("querytype", "map");
        b.putDouble("x", x);
        b.putDouble("y", y);
        baseMap.GetVMPMapCityInfo(b);
        String citys = b.getString("cities");
        if (TextUtils.isEmpty(citys)) {
            return null;
        }
        try {
            JSONArray arr = new JSONObject(citys).getJSONArray("cities");
            if (arr == null || arr.length() <= 0) {
                return null;
            }
            int[] cityIds = new int[arr.length()];
            for (int i = 0; i < arr.length(); i++) {
                if (arr.getJSONObject(i) != null) {
                    cityIds[i] = arr.getJSONObject(i).optInt("code");
                }
            }
            return cityIds;
        } catch (JSONException e) {
            return null;
        }
    }

    public String getMapCenterCityName() {
        return GlobalConfig.getInstance().getRoamCityName();
    }

    public int getMapCenterCityType() {
        return GlobalConfig.getInstance().getRoamCityType();
    }
}
