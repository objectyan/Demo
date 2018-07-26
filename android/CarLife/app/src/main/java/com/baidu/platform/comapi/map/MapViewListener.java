package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;

public interface MapViewListener {
    void onClickStreetArrow(MapObj mapObj);

    void onClickStreetSurface(MapObj mapObj);

    void onClickedBackground(int i, int i2);

    void onClickedItem(int i, int i2, GeoPoint geoPoint, int i3);

    void onClickedItem(int i, GeoPoint geoPoint, int i2);

    void onClickedItsMapObj(List<ItsMapObj> list);

    void onClickedMapObj(List<MapObj> list);

    void onClickedOPPoiEventMapObj(MapObj mapObj);

    void onClickedParticleEventMapObj(List<MapObj> list);

    void onClickedPoiObj(List<MapObj> list);

    void onClickedPopup(int i);

    void onClickedRouteLabelObj(List<MapObj> list);

    void onClickedRouteObj(List<MapObj> list);

    void onClickedStreetIndoorPoi(MapObj mapObj);

    void onClickedStreetPopup(String str);

    void onClickedTrafficUgcEventMapObj(MapObj mapObj, boolean z);

    void onMapAnimationFinish();
}
