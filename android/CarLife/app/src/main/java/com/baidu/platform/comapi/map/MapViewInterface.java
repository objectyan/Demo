package com.baidu.platform.comapi.map;

import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import java.util.List;

public abstract interface MapViewInterface
{
  public abstract boolean addOverlay(Overlay paramOverlay);
  
  public abstract boolean enable3D();
  
  public abstract MapController getController();
  
  public abstract MapStatus.GeoBound getGeoRound();
  
  public abstract int getLatitudeSpan();
  
  public abstract int getLongitudeSpan();
  
  public abstract GeoPoint getMapCenter();
  
  public abstract int getMapRotation();
  
  public abstract MapStatus getMapStatus();
  
  public abstract List<Overlay> getOverlays();
  
  public abstract int getOverlooking();
  
  public abstract Projection getProjection();
  
  public abstract MapStatus.WinRound getWinRound();
  
  public abstract float getZoomLevel();
  
  public abstract float getZoomToBound(MapBound paramMapBound);
  
  public abstract float getZoomToBound(MapBound paramMapBound, int paramInt1, int paramInt2);
  
  public abstract float getZoomToBoundF(MapBound paramMapBound);
  
  public abstract float getZoomToBoundF(MapBound paramMapBound, int paramInt1, int paramInt2);
  
  public abstract boolean isSatellite();
  
  public abstract boolean isStreetRoad();
  
  public abstract boolean isTraffic();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void refresh(Overlay paramOverlay);
  
  public abstract boolean removeOverlay(Overlay paramOverlay);
  
  public abstract void saveScreenToLocal(String paramString);
  
  public abstract void setGeoRound(MapStatus.GeoBound paramGeoBound);
  
  public abstract void setMapCenter(GeoPoint paramGeoPoint);
  
  public abstract void setMapStatus(MapStatus paramMapStatus);
  
  public abstract void setMapTo2D(boolean paramBoolean);
  
  public abstract void setOverlooking(int paramInt);
  
  public abstract void setRotation(int paramInt);
  
  public abstract void setSatellite(boolean paramBoolean);
  
  public abstract void setStreetRoad(boolean paramBoolean);
  
  public abstract void setTraffic(boolean paramBoolean);
  
  public abstract void setWinRound(MapStatus.WinRound paramWinRound);
  
  public abstract void setZoomLevel(float paramFloat);
  
  public abstract void setZoomLevel(int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/MapViewInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */