package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;

public class MapUtils
{
  public static GeoPoint ll2mc(GeoPoint paramGeoPoint)
  {
    paramGeoPoint = CoordinateUtil.bd09llTobd09mc(paramGeoPoint.getLongitude(), paramGeoPoint.getLatitude());
    if (paramGeoPoint != null) {
      return new GeoPoint(paramGeoPoint.getDoubleY(), paramGeoPoint.getDoubleX());
    }
    return null;
  }
  
  public static GeoPoint mc2ll(GeoPoint paramGeoPoint)
  {
    paramGeoPoint = CoordinateUtil.bd09mcTobd09ll(paramGeoPoint.getLongitude(), paramGeoPoint.getLatitude());
    if (paramGeoPoint != null) {
      return new GeoPoint(paramGeoPoint.getDoubleY(), paramGeoPoint.getDoubleX());
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/MapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */