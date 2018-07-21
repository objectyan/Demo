package com.baidu.navisdk.util.common;

import android.os.Bundle;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comjni.tools.JNITools;

public class CoordinateTransformUtil
{
  public static final String BD09LL = "bd09ll";
  public static final String BD09MC = "bd09mc";
  public static final String GCJ02 = "gcj02";
  public static final String WGS84 = "wgs84";
  
  public static Bundle LL2MC(double paramDouble1, double paramDouble2)
  {
    try
    {
      Bundle localBundle1 = JNITools.LL2MC(paramDouble1, paramDouble2);
      if (localBundle1 != null) {
        return localBundle1;
      }
    }
    catch (Throwable localThrowable)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putInt("MCx", 0);
      localBundle2.putInt("MCy", 0);
      return localBundle2;
    }
  }
  
  public static Bundle LLE62MC(int paramInt1, int paramInt2)
  {
    double d1 = paramInt1 / 100000.0D;
    double d2 = paramInt2 / 100000.0D;
    try
    {
      Bundle localBundle1 = JNITools.LL2MC(d1, d2);
      if (localBundle1 != null) {
        return localBundle1;
      }
    }
    catch (Throwable localThrowable)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putInt("MCx", 0);
      localBundle2.putInt("MCy", 0);
      return localBundle2;
    }
  }
  
  public static Bundle MC2LL(int paramInt1, int paramInt2)
  {
    try
    {
      Bundle localBundle1 = JNITools.MC2LL(paramInt1, paramInt2);
      if (localBundle1 != null) {
        return localBundle1;
      }
    }
    catch (Throwable localThrowable)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putDouble("LLx", 0.0D);
      localBundle2.putDouble("LLy", 0.0D);
      return localBundle2;
    }
  }
  
  public static Bundle MC2LLE6(int paramInt1, int paramInt2)
  {
    Bundle localBundle = MC2LL(paramInt1, paramInt2);
    if (localBundle == null)
    {
      localBundle = new Bundle();
      localBundle.putInt("LLx", 0);
      localBundle.putInt("LLy", 0);
      return localBundle;
    }
    paramInt1 = (int)(localBundle.getDouble("LLx") * 100000.0D);
    paramInt2 = (int)(localBundle.getDouble("LLy") * 100000.0D);
    localBundle.putInt("LLx", paramInt1);
    localBundle.putInt("LLy", paramInt2);
    return localBundle;
  }
  
  public static GeoPoint coordSysChangeByType(int paramInt, double paramDouble1, double paramDouble2)
  {
    GeoPoint localGeoPoint = new GeoPoint();
    Bundle localBundle = JNITools.CoordSysChangeByType(paramInt, paramDouble1, paramDouble2);
    if (localBundle == null) {
      return localGeoPoint;
    }
    paramInt = (int)(localBundle.getDouble("x") * 100000.0D);
    localGeoPoint.setLatitudeE6((int)(localBundle.getDouble("y") * 100000.0D));
    localGeoPoint.setLongitudeE6(paramInt);
    return localGeoPoint;
  }
  
  public static GeoPoint transferBD09ToGCJ02(double paramDouble1, double paramDouble2)
  {
    GeoPoint localGeoPoint = new GeoPoint();
    Bundle localBundle = JNITools.BD2GCJ(paramDouble1, paramDouble2);
    if (localBundle == null) {
      return localGeoPoint;
    }
    int i = (int)(localBundle.getDouble("LLx") * 100000.0D);
    localGeoPoint.setLatitudeE6((int)(localBundle.getDouble("LLy") * 100000.0D));
    localGeoPoint.setLongitudeE6(i);
    return localGeoPoint;
  }
  
  public static GeoPoint transferGCJ02ToBD09(double paramDouble1, double paramDouble2)
  {
    GeoPoint localGeoPoint = new GeoPoint();
    Bundle localBundle = JNITools.GCJ2BD(paramDouble1, paramDouble2);
    if (localBundle == null) {
      return localGeoPoint;
    }
    int i = (int)(localBundle.getDouble("LLx") * 100000.0D);
    localGeoPoint.setLatitudeE6((int)(localBundle.getDouble("LLy") * 100000.0D));
    localGeoPoint.setLongitudeE6(i);
    return localGeoPoint;
  }
  
  public static Bundle transferGCJ02ToWGS84(double paramDouble1, double paramDouble2)
  {
    Bundle localBundle2 = JNITools.GCJ2WGS(paramDouble1, paramDouble2);
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null)
    {
      localBundle1 = new Bundle();
      localBundle1.putInt("LLx", 0);
      localBundle1.putInt("LLy", 0);
    }
    return localBundle1;
  }
  
  public static GeoPoint transferWGS84ToGCJ02(double paramDouble1, double paramDouble2)
  {
    GeoPoint localGeoPoint = new GeoPoint();
    Bundle localBundle = JNITools.WGS2GCJ(paramDouble1, paramDouble2);
    if (localBundle == null) {
      return localGeoPoint;
    }
    int i = (int)(localBundle.getDouble("LLx") * 100000.0D);
    localGeoPoint.setLatitudeE6((int)(localBundle.getDouble("LLy") * 100000.0D));
    localGeoPoint.setLongitudeE6(i);
    return localGeoPoint;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/CoordinateTransformUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */