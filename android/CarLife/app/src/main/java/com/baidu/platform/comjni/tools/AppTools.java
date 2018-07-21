package com.baidu.platform.comjni.tools;

import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;

public class AppTools
{
  public static double getDistanceByMc(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    return CoordinateUtil.getDistanceByMc(paramGeoPoint1.getLongitude(), paramGeoPoint1.getLatitude(), paramGeoPoint2.getLongitude(), paramGeoPoint2.getLatitude());
  }
  
  public static double getDistanceByMc(Point paramPoint1, Point paramPoint2)
  {
    return CoordinateUtil.getDistanceByMc(paramPoint1.getDoubleX(), paramPoint1.getDoubleY(), paramPoint2.getDoubleX(), paramPoint2.getDoubleY());
  }
  
  @Deprecated
  public static ComplexPt getGeoComplexPointFromString(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    return CoordinateUtil.geoStringToComplexPt(paramString);
  }
  
  @Deprecated
  public static ComplexPt getGeoComplexPtBoundFromString(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    return CoordinateUtil.geoStringToComplexPtBound(paramString);
  }
  
  public static Point getGeoPointFromString(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    return CoordinateUtil.geoStringToPoint(paramString);
  }
  
  public static String getStringFromGeoPoint(Point paramPoint)
  {
    return CoordinateUtil.pointToGeoString(paramPoint);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comjni/tools/AppTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */