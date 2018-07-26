package com.baidu.mapframework.common.mapview;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.map.MapStatus;

public interface MapInfo {
    MapBound getMapBound();

    GeoPoint getMapCenter();

    int getMapCenterCity();

    String getMapCenterCityName();

    int getMapCenterCityType();

    float getMapLevel();

    MapStatus getMapStatus();

    int[] getPoiCitys(double d, double d2);

    float getZoomToBound(MapBound mapBound);

    float getZoomToBound(MapBound mapBound, int i, int i2);
}
