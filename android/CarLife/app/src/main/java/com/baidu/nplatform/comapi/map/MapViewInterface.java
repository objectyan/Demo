package com.baidu.nplatform.comapi.map;

import android.view.MotionEvent;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.MapStatus.GeoBound;
import com.baidu.nplatform.comapi.basestruct.MapStatus.WinRound;

public interface MapViewInterface {
    boolean enable3D();

    MapController getController();

    GeoBound getGeoRound();

    int getLatitudeSpan();

    int getLongitudeSpan();

    GeoPoint getMapCenter();

    int getMapRotation();

    MapStatus getMapStatus();

    MapViewListener getMapViewListener();

    int getOverlooking();

    WinRound getWinRound();

    float getZoomLevel();

    boolean isSatellite();

    boolean isStreetRoad();

    boolean isTraffic();

    boolean onTouchEvent(MotionEvent motionEvent);

    void saveScreenToLocal(String str);

    void setGeoRound(GeoBound geoBound);

    void setMapCenter(GeoPoint geoPoint);

    void setMapStatus(MapStatus mapStatus);

    void setMapTo2D(boolean z);

    void setMapViewListener(MapViewListener mapViewListener);

    void setOverlooking(int i);

    void setRotation(int i);

    void setSatellite(boolean z);

    void setStreetRoad(boolean z);

    void setTraffic(boolean z);

    void setWinRound(WinRound winRound);

    void setZoomLevel(int i);
}
