package com.baidu.navisdk.util.logic;

import android.content.Context;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class BNLocationManagerProxy
{
  private static BNLocationManagerProxy sProxy;
  
  public static BNLocationManagerProxy getInstance()
  {
    if (sProxy == null) {}
    try
    {
      if (sProxy == null) {
        sProxy = new BNLocationManagerProxy();
      }
      return sProxy;
    }
    finally {}
  }
  
  public LocData getCurLocation()
  {
    LocData localLocData = BNExtGPSLocationManager.getInstance().getCurLocation();
    if ((localLocData != null) && (localLocData.isValid())) {
      return localLocData;
    }
    localLocData = BNSysLocationManager.getInstance().getCurLocation();
    if ((localLocData != null) && (localLocData.isValid())) {
      return localLocData;
    }
    return localLocData;
  }
  
  public RoutePlanNode getCurLocationNode()
  {
    GeoPoint localGeoPoint = getLastValidLocation();
    if (localGeoPoint != null) {
      return new RoutePlanNode(localGeoPoint, 3, null, null);
    }
    return null;
  }
  
  public int getGpsState()
  {
    int i;
    if (BNExtGPSLocationManager.getInstance().isGpsEnabled()) {
      if (BNExtGPSLocationManager.getInstance().isGpsAvailable()) {
        i = 1;
      }
    }
    while (i == 1)
    {
      return i;
      i = 2;
      continue;
      i = 0;
    }
    if (BNSysLocationManager.getInstance().isGpsEnabled()) {
      if (BNSysLocationManager.getInstance().isGpsAvailable()) {
        i = 1;
      }
    }
    while (i == 1)
    {
      return i;
      i = 2;
      continue;
      i = 0;
    }
    return i;
  }
  
  public GeoPoint getLastValidLocation()
  {
    GeoPoint localGeoPoint = BNExtGPSLocationManager.getInstance().getLastValidLocation();
    if ((localGeoPoint != null) && (localGeoPoint.isValid())) {
      return localGeoPoint;
    }
    localGeoPoint = BNSysLocationManager.getInstance().getLastValidLocation();
    if ((localGeoPoint != null) && (localGeoPoint.isValid())) {
      return localGeoPoint;
    }
    return localGeoPoint;
  }
  
  public boolean isLocationValid()
  {
    boolean bool = BNExtGPSLocationManager.getInstance().isGpsAvailable();
    if (bool) {
      return bool;
    }
    bool = BNSysLocationManager.getInstance().isSysLocationValid();
    if (bool) {
      return bool;
    }
    return bool;
  }
  
  public void startNaviLocate(Context paramContext) {}
  
  public void stopNaviLocate() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/logic/BNLocationManagerProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */