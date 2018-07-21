package com.baidu.navisdk.util.logic;

import android.content.Context;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BNLocationManager
{
  public static final int GPS_STATUS_CLOSE = 5;
  public static final int GPS_STATUS_OPEN = 4;
  private static final String TAG = BNLocationManager.class.getSimpleName();
  private LocData mCurLocation = null;
  protected boolean mIsNaviStarted = false;
  private List<ILocationListener> mLocationListenerList = new ArrayList();
  private long mLocationUpdatedTime = 0L;
  
  protected BNLocationManager()
  {
    com.baidu.navisdk.debug.NavSDKDebug.sShowDebugToast = BNSettingManager.isShowLocationEnable();
  }
  
  private boolean startLocate()
  {
    return false;
  }
  
  private boolean stopLocate()
  {
    return false;
  }
  
  private void updateGeoLocateModel()
  {
    GeoLocateModel.getInstance().updateLocation(this.mCurLocation);
  }
  
  public void addLocationListener(ILocationListener paramILocationListener)
  {
    if (paramILocationListener != null) {
      synchronized (this.mLocationListenerList)
      {
        if (!this.mLocationListenerList.contains(paramILocationListener))
        {
          this.mLocationListenerList.add(paramILocationListener);
          paramILocationListener.onGpsStatusChange(isGpsEnabled(), isGpsAvailable());
        }
        return;
      }
    }
  }
  
  public void clearLocationListeners()
  {
    synchronized (this.mLocationListenerList)
    {
      this.mLocationListenerList.clear();
      return;
    }
  }
  
  public LocData getCurLocation()
  {
    return this.mCurLocation;
  }
  
  public RoutePlanNode getCurLocationNode()
  {
    GeoPoint localGeoPoint = getLastValidLocation();
    if (localGeoPoint != null) {
      return new RoutePlanNode(localGeoPoint, 3, null, null);
    }
    return null;
  }
  
  public GeoPoint getLastValidLocation()
  {
    if (this.mCurLocation != null)
    {
      GeoPoint localGeoPoint = new GeoPoint();
      localGeoPoint.setLongitudeE6((int)(this.mCurLocation.longitude * 100000.0D));
      localGeoPoint.setLatitudeE6((int)(this.mCurLocation.latitude * 100000.0D));
      return localGeoPoint;
    }
    return null;
  }
  
  public int getLocationListenerNum()
  {
    synchronized (this.mLocationListenerList)
    {
      int i = this.mLocationListenerList.size();
      return i;
    }
  }
  
  public long getLocationUpdatedTime()
  {
    return this.mLocationUpdatedTime;
  }
  
  public abstract void init(Context paramContext);
  
  public boolean isGpsAvailable()
  {
    return true;
  }
  
  public abstract boolean isGpsEnabled();
  
  protected void notifyGpsStatusChanged(boolean paramBoolean1, boolean paramBoolean2)
  {
    synchronized (this.mLocationListenerList)
    {
      Iterator localIterator = this.mLocationListenerList.iterator();
      while (localIterator.hasNext())
      {
        ILocationListener localILocationListener = (ILocationListener)localIterator.next();
        if (localILocationListener != null) {
          localILocationListener.onGpsStatusChange(paramBoolean1, paramBoolean2);
        }
      }
    }
  }
  
  protected void notifyLocationChanged(LocData arg1)
  {
    if (??? != null)
    {
      this.mCurLocation = ???;
      this.mLocationUpdatedTime = System.currentTimeMillis();
      updateGeoLocateModel();
      synchronized (this.mLocationListenerList)
      {
        Iterator localIterator = this.mLocationListenerList.iterator();
        while (localIterator.hasNext())
        {
          ILocationListener localILocationListener = (ILocationListener)localIterator.next();
          if (localILocationListener != null) {
            localILocationListener.onLocationChange(this.mCurLocation);
          }
        }
      }
    }
  }
  
  protected void notifyLocationNotChanged(LocData arg1)
  {
    if (??? != null)
    {
      LogUtil.e(TAG, "notify " + ???.toString());
      synchronized (this.mLocationListenerList)
      {
        Iterator localIterator = this.mLocationListenerList.iterator();
        while (localIterator.hasNext())
        {
          ILocationListener localILocationListener = (ILocationListener)localIterator.next();
          if (localILocationListener != null) {
            localILocationListener.onLocationChange(this.mCurLocation);
          }
        }
      }
    }
  }
  
  protected void notifyWGS84LocationChanged(LocData paramLocData1, LocData paramLocData2)
  {
    if (paramLocData1 != null) {
      synchronized (this.mLocationListenerList)
      {
        Iterator localIterator = this.mLocationListenerList.iterator();
        while (localIterator.hasNext())
        {
          ILocationListener localILocationListener = (ILocationListener)localIterator.next();
          if (localILocationListener != null) {
            localILocationListener.onWGS84LocationChange(paramLocData1, paramLocData2);
          }
        }
      }
    }
  }
  
  public void removeLocationListener(ILocationListener paramILocationListener)
  {
    synchronized (this.mLocationListenerList)
    {
      this.mLocationListenerList.remove(paramILocationListener);
      return;
    }
  }
  
  public boolean startNaviLocate(Context paramContext)
  {
    try
    {
      LogUtil.e(TAG, "startNaviLocate");
      this.mIsNaviStarted = true;
      return true;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void stopNaviLocate()
  {
    try
    {
      LogUtil.e(TAG, "stopNaviLocate");
      this.mIsNaviStarted = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public abstract void unInit();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navisdk/util/logic/BNLocationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */