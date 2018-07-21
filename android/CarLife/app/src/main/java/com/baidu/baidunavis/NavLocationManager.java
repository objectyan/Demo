package com.baidu.baidunavis;

import android.app.Activity;
import com.baidu.baidunavis.control.NavDrivingCarController;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.RespTimeStatItem;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class NavLocationManager
{
  private boolean isRouteDetailPage = false;
  private LocationChangeListener mLocationListener = new LocationChangeListener()
  {
    public LocationChangeListener.CoordType onGetCoordType()
    {
      return LocationChangeListener.CoordType.CoordType_GCJ02;
    }
    
    public void onLocationChange(LocationManager.LocData paramAnonymousLocData)
    {
      LocData localLocData = new LocData();
      localLocData.accuracy = paramAnonymousLocData.accuracy;
      localLocData.direction = paramAnonymousLocData.direction;
      localLocData.satellitesNum = paramAnonymousLocData.satellitesNum;
      localLocData.speed = (paramAnonymousLocData.speed / 3.6F);
      localLocData.type = paramAnonymousLocData.type;
      try
      {
        localLocData.latitude = paramAnonymousLocData.latitude;
        localLocData.longitude = paramAnonymousLocData.longitude;
        if (PerformStatItem.sEnableTestData)
        {
          GeoPoint localGeoPoint = CoordinateTransformUtil.transferWGS84ToGCJ02(116.30119D, 40.040642D);
          localLocData.longitude = (localGeoPoint.getLongitudeE6() / 100000.0D);
          localLocData.latitude = (localGeoPoint.getLatitudeE6() / 100000.0D);
        }
        localLocData.altitude = paramAnonymousLocData.altitude;
        localLocData.indoorState = paramAnonymousLocData.indoorState;
        localLocData.networkLocType = paramAnonymousLocData.networkLocType;
        BNExtGPSLocationManager.getInstance().updateLocation(localLocData);
        BNWorkerCenter.getInstance().cancelTask(NavLocationManager.this.mUpdateLocationOnBGTask, true);
        BNWorkerCenter.getInstance().submitNormalTask(NavLocationManager.this.mUpdateLocationOnBGTask, new BNWorkerConfig(100, 0));
      }
      catch (Throwable paramAnonymousLocData)
      {
        for (;;) {}
      }
      RespTimeStatItem.getInstance().setAppLocatedTime();
    }
  };
  private BNWorkerNormalTask mUpdateLocationOnBGTask = new BNWorkerNormalTask("onLocationChange", null)
  {
    protected Object execute()
    {
      LocData localLocData = BNExtGPSLocationManager.getInstance().getCurLocation();
      if (localLocData != null)
      {
        NavDrivingCarController.getInstance().getMapCarPoint(localLocData);
        BNExtGPSLocationManager.getInstance().notifyLocationChangedForEngine(localLocData);
        if (NavLocationManager.this.isRouteDetailPage) {
          BNExtGPSLocationManager.getInstance().triggerGPSDataChangeForDriving(localLocData);
        }
      }
      return null;
    }
  };
  
  public static NavLocationManager getInstance()
  {
    return LazyHolder.sLocationManager;
  }
  
  public void addLocationListener()
  {
    NavMapAdapter.getInstance().addLocationChangeLister(this.mLocationListener);
  }
  
  public void enterRouteDetailPage()
  {
    this.isRouteDetailPage = true;
  }
  
  public void exitRouteDetailPage()
  {
    this.isRouteDetailPage = false;
  }
  
  public void notifyMapGPSEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (NavCommonFuncModel.getInstance().getActivity() != null) {
        BNSysLocationManager.getInstance().startNaviLocateForRoutePlan(NavCommonFuncModel.getInstance().getActivity().getApplicationContext());
      }
      return;
    }
    BNSysLocationManager.getInstance().stopNaviLocateForRoutePlan();
  }
  
  public void removeLocationListener()
  {
    NavMapAdapter.getInstance().removeLocationChangeLister(this.mLocationListener);
  }
  
  private static class LazyHolder
  {
    private static NavLocationManager sLocationManager = new NavLocationManager(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/NavLocationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */