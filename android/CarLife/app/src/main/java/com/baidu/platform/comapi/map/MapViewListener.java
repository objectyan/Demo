package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;

public abstract interface MapViewListener
{
  public abstract void onClickStreetArrow(MapObj paramMapObj);
  
  public abstract void onClickStreetSurface(MapObj paramMapObj);
  
  public abstract void onClickedBackground(int paramInt1, int paramInt2);
  
  public abstract void onClickedItem(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3);
  
  public abstract void onClickedItem(int paramInt1, GeoPoint paramGeoPoint, int paramInt2);
  
  public abstract void onClickedItsMapObj(List<ItsMapObj> paramList);
  
  public abstract void onClickedMapObj(List<MapObj> paramList);
  
  public abstract void onClickedOPPoiEventMapObj(MapObj paramMapObj);
  
  public abstract void onClickedParticleEventMapObj(List<MapObj> paramList);
  
  public abstract void onClickedPoiObj(List<MapObj> paramList);
  
  public abstract void onClickedPopup(int paramInt);
  
  public abstract void onClickedRouteLabelObj(List<MapObj> paramList);
  
  public abstract void onClickedRouteObj(List<MapObj> paramList);
  
  public abstract void onClickedStreetIndoorPoi(MapObj paramMapObj);
  
  public abstract void onClickedStreetPopup(String paramString);
  
  public abstract void onClickedTrafficUgcEventMapObj(MapObj paramMapObj, boolean paramBoolean);
  
  public abstract void onMapAnimationFinish();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/MapViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */