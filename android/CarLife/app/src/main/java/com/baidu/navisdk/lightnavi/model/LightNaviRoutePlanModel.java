package com.baidu.navisdk.lightnavi.model;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;

public class LightNaviRoutePlanModel
{
  private int currentETASecs = 0;
  private int currentPlanedDistance = 0;
  private int maxETA = 0;
  
  public static LightNaviRoutePlanModel getInstance()
  {
    return LazyLoader.instance;
  }
  
  public int getCurrentETASecs()
  {
    return this.currentETASecs;
  }
  
  public int getCurrentPlanedDistance()
  {
    return this.currentPlanedDistance;
  }
  
  public int getMaxETA()
  {
    return this.maxETA;
  }
  
  public void parseRouteResultOutlineLightNavi()
  {
    this.currentETASecs = 0;
    this.currentPlanedDistance = 0;
    this.maxETA = 0;
    Bundle localBundle = new Bundle();
    BNLightNaviManager.getInstance().getRemianDisAndTime(localBundle);
    this.currentPlanedDistance = localBundle.getInt("remainDis");
    this.currentETASecs = localBundle.getInt("remainTime");
    int j = BNRoutePlaner.getInstance().getRouteCnt();
    int i = 0;
    while (i < j)
    {
      localBundle = new Bundle();
      BNRoutePlaner.getInstance().getRouteInfo(i, localBundle);
      int k = localBundle.getInt("totaltime");
      if (this.maxETA < k) {
        this.maxETA = k;
      }
      i += 1;
    }
  }
  
  public void setCurrentETASecs(int paramInt)
  {
    this.currentETASecs = paramInt;
  }
  
  public void setCurrentPlanedDistance(int paramInt)
  {
    this.currentPlanedDistance = paramInt;
  }
  
  public void setMaxETA(int paramInt)
  {
    this.maxETA = paramInt;
  }
  
  private static class LazyLoader
  {
    private static LightNaviRoutePlanModel instance = new LightNaviRoutePlanModel(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/model/LightNaviRoutePlanModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */