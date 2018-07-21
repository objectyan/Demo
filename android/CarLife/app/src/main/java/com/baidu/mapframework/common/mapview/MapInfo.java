package com.baidu.mapframework.common.mapview;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.map.MapStatus;

public abstract interface MapInfo
{
  public abstract MapBound getMapBound();
  
  public abstract GeoPoint getMapCenter();
  
  public abstract int getMapCenterCity();
  
  public abstract String getMapCenterCityName();
  
  public abstract int getMapCenterCityType();
  
  public abstract float getMapLevel();
  
  public abstract MapStatus getMapStatus();
  
  public abstract int[] getPoiCitys(double paramDouble1, double paramDouble2);
  
  public abstract float getZoomToBound(MapBound paramMapBound);
  
  public abstract float getZoomToBound(MapBound paramMapBound, int paramInt1, int paramInt2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/mapview/MapInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */