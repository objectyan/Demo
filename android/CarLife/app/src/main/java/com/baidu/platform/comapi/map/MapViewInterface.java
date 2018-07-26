package com.baidu.platform.comapi.map;

import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.map.MapStatus.GeoBound;
import com.baidu.platform.comapi.map.MapStatus.WinRound;
import java.util.List;

public interface MapViewInterface {
    boolean addOverlay(Overlay overlay);

    boolean enable3D();

    MapController getController();

    GeoBound getGeoRound();

    int getLatitudeSpan();

    int getLongitudeSpan();

    GeoPoint getMapCenter();

    int getMapRotation();

    MapStatus getMapStatus();

    List<Overlay> getOverlays();

    int getOverlooking();

    Projection getProjection();

    WinRound getWinRound();

    float getZoomLevel();

    float getZoomToBound(MapBound mapBound);

    float getZoomToBound(MapBound mapBound, int i, int i2);

    float getZoomToBoundF(MapBound mapBound);

    float getZoomToBoundF(MapBound mapBound, int i, int i2);

    boolean isSatellite();

    boolean isStreetRoad();

    boolean isTraffic();

    boolean onTouchEvent(MotionEvent motionEvent);

    void refresh(Overlay overlay);

    boolean removeOverlay(Overlay overlay);

    void saveScreenToLocal(String str);

    void setGeoRound(GeoBound geoBound);

    void setMapCenter(GeoPoint geoPoint);

    void setMapStatus(MapStatus mapStatus);

    void setMapTo2D(boolean z);

    void setOverlooking(int i);

    void setRotation(int i);

    void setSatellite(boolean z);

    void setStreetRoad(boolean z);

    void setTraffic(boolean z);

    void setWinRound(WinRound winRound);

    void setZoomLevel(float f);

    void setZoomLevel(int i);
}
