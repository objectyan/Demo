package com.baidu.baidunavis.model;

import android.os.Bundle;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.NetworkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NavRoutePlanModel
{
  private static NavRoutePlanModel sInstance = null;
  public String mCarPANumber = null;
  public String mCurMrsl = "";
  private int mDriveRefTimeDuration = -1;
  private int mDriveRefTimeInterval = -1;
  private RouteNode mEndRouteNode = null;
  public int mEntry = 3;
  public Bundle mExtBundle = null;
  public boolean mIsContainsAllNodeOfflineData = false;
  public boolean mIsGPSNav = true;
  public boolean mIsRedirector = true;
  public String mLastMrsl = "";
  private long mLastestTimeSetSensor = -1L;
  public long mLastestTimeToSelectRoute = -1L;
  private int mMapSensorAngle = -1;
  private String mNavEnter = "nav_nav";
  public boolean mNotBuildReady = false;
  private int mPreference = -1;
  private int mRouteInfoStatus = -1;
  public int mRoutePlanResultFailedType = -1;
  public boolean mRoutePlanResultOK = false;
  private ArrayList<ISensorChangeListener> mSensorObservers = new ArrayList();
  public boolean mStartDriv = false;
  private RouteNode mStartRouteNode = null;
  private int mStrategy = -1;
  private List<RouteNode> mViaNodes = null;
  public byte[] pbData;
  public int pbDataLen;
  public String routePlanStatistcsUrl = "";
  
  public static NavRoutePlanModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavRoutePlanModel();
    }
    return sInstance;
  }
  
  public void addSensorChangeListener(ISensorChangeListener paramISensorChangeListener)
  {
    synchronized (this.mSensorObservers)
    {
      if (!this.mSensorObservers.contains(paramISensorChangeListener)) {
        this.mSensorObservers.add(paramISensorChangeListener);
      }
      return;
    }
  }
  
  public int getDriveRefTimeDuration()
  {
    return this.mDriveRefTimeDuration;
  }
  
  public int getDriveRefTimeInterval()
  {
    return this.mDriveRefTimeInterval;
  }
  
  public RouteNode getEndRouteNode()
  {
    return this.mEndRouteNode;
  }
  
  public int getEntry()
  {
    return this.mEntry;
  }
  
  public Bundle getExtBundle()
  {
    return this.mExtBundle;
  }
  
  public int getPreference()
  {
    return this.mPreference;
  }
  
  public int getRPNodeCount()
  {
    if (this.mViaNodes == null) {
      return 2;
    }
    return this.mViaNodes.size() + 2;
  }
  
  public int getRouteInfoStatus()
  {
    return this.mRouteInfoStatus;
  }
  
  public RouteNode getStartRouteNode()
  {
    return this.mStartRouteNode;
  }
  
  public int getStrategy()
  {
    return this.mStrategy;
  }
  
  public String getStrategyForUserBeh()
  {
    String str = null;
    if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      if (BNSettingManager.getPrefRoutPlanMode() == 3) {
        str = "online";
      }
      while (BNSettingManager.getPrefRoutPlanMode() != 2) {
        return str;
      }
      return "offline";
    }
    return "offline";
  }
  
  public List<RouteNode> getViaNodes()
  {
    return this.mViaNodes;
  }
  
  public String getmNavEnter()
  {
    return this.mNavEnter;
  }
  
  public float getmSensorAngle()
  {
    long l = System.currentTimeMillis();
    NavLogUtils.e("", "mSensorChangeListener getmSensorAngle ctime " + l + ", mLastestTimeSetSensor=" + this.mLastestTimeSetSensor + ", mMapSensorAngle=" + this.mMapSensorAngle);
    float f = -1.0F;
    if (l - this.mLastestTimeSetSensor <= 5000L) {
      f = this.mMapSensorAngle;
    }
    return f;
  }
  
  public boolean isEntryToCarResultScene()
  {
    switch (getEntry())
    {
    case 5: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 22: 
    case 26: 
    case 28: 
    case 31: 
    case 32: 
    default: 
      return false;
    }
    return true;
  }
  
  public void removeSensorChangeListener(ISensorChangeListener paramISensorChangeListener)
  {
    synchronized (this.mSensorObservers)
    {
      this.mSensorObservers.remove(paramISensorChangeListener);
      return;
    }
  }
  
  public void setDriveRefTime(int paramInt1, int paramInt2)
  {
    this.mDriveRefTimeInterval = paramInt1;
    this.mDriveRefTimeDuration = paramInt2;
  }
  
  public void setEndRouteNode(RouteNode paramRouteNode)
  {
    this.mEndRouteNode = paramRouteNode;
  }
  
  public void setEntry(int paramInt)
  {
    this.mEntry = paramInt;
  }
  
  public void setExtBundle(Bundle paramBundle)
  {
    this.mExtBundle = paramBundle;
  }
  
  public void setPreference(int paramInt)
  {
    this.mPreference = paramInt;
  }
  
  public void setRouteInfoStatus(int paramInt)
  {
    this.mRouteInfoStatus = paramInt;
  }
  
  public void setStartRouteNode(RouteNode paramRouteNode)
  {
    this.mStartRouteNode = paramRouteNode;
  }
  
  public void setStrategy(int paramInt)
  {
    this.mStrategy = paramInt;
  }
  
  public void setViaNodes(List<RouteNode> paramList)
  {
    this.mViaNodes = paramList;
  }
  
  public void setmMapSensorAngle(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.mLastestTimeSetSensor = System.currentTimeMillis();
      this.mMapSensorAngle = paramInt;
    }
    try
    {
      BNRoutePlaner.getInstance().triggerSensorAngle(paramInt, 1.0D);
      Iterator localIterator = this.mSensorObservers.iterator();
      while (localIterator.hasNext()) {
        ((ISensorChangeListener)localIterator.next()).onSensorChange(paramInt);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setmNavEnter(String paramString)
  {
    this.mNavEnter = paramString;
  }
  
  public void triggerStartSensorData(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    try
    {
      BNRoutePlaner.getInstance().triggerStartSensorData(paramFloat1, paramFloat2, paramFloat3);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/model/NavRoutePlanModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */