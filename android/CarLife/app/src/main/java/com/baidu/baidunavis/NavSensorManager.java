package com.baidu.baidunavis;

import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.util.logic.BNSysSensorManager;

public class NavSensorManager
{
  private ISensorChangeListener mSensorChangeListener = new ISensorChangeListener()
  {
    public void onSensorChange(int paramAnonymousInt)
    {
      BaiduNaviManager.getInstance().setSensor(paramAnonymousInt);
    }
  };
  
  public static NavSensorManager getInstence()
  {
    return LazyHolder.sSensorManager;
  }
  
  public void addSensorChangeListener()
  {
    BNSysSensorManager.getInstance().addSensorChangeListener(this.mSensorChangeListener);
  }
  
  public void removeSensorChangeListener()
  {
    BNSysSensorManager.getInstance().removeSensorChangeListener(this.mSensorChangeListener);
  }
  
  private static class LazyHolder
  {
    private static NavSensorManager sSensorManager = new NavSensorManager(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/NavSensorManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */