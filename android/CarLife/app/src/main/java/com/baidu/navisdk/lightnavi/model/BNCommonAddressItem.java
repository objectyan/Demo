package com.baidu.navisdk.lightnavi.model;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class BNCommonAddressItem
{
  public static final int ADDR_TYPE_COMPANY = 2;
  public static final int ADDR_TYPE_CUR_LOCATION = 5;
  public static final int ADDR_TYPE_FAV = 3;
  public static final int ADDR_TYPE_HOME = 1;
  private String addressDesc;
  private int cityId = -1;
  private GeoPoint guideGeoPoint;
  private String name;
  private String poiOriginUID;
  private RoutePlanNode routePlanNodeGCJ = null;
  private int type;
  private GeoPoint viewGeoPoint;
  
  public BNCommonAddressItem(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String getAddressDesc()
  {
    return this.addressDesc;
  }
  
  public int getCityId()
  {
    return this.cityId;
  }
  
  public GeoPoint getGuideGeoPoint()
  {
    return this.guideGeoPoint;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPoiOriginUID()
  {
    return this.poiOriginUID;
  }
  
  public RoutePlanNode getRoutePlanNode()
  {
    if (this.routePlanNodeGCJ != null) {
      return this.routePlanNodeGCJ;
    }
    switch (this.type)
    {
    default: 
      this.routePlanNodeGCJ = new RoutePlanNode(this.guideGeoPoint, this.viewGeoPoint, 0, this.name, this.addressDesc);
    }
    for (;;)
    {
      return this.routePlanNodeGCJ;
      this.routePlanNodeGCJ = new RoutePlanNode(this.guideGeoPoint, this.viewGeoPoint, 4, this.name, this.addressDesc);
      continue;
      this.routePlanNodeGCJ = new RoutePlanNode(this.guideGeoPoint, this.viewGeoPoint, 5, this.name, this.addressDesc);
    }
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public GeoPoint getViewGeoPoint()
  {
    return this.viewGeoPoint;
  }
  
  public boolean isValid()
  {
    return (this.name != null) && (this.guideGeoPoint != null) && (this.guideGeoPoint.isValid());
  }
  
  public void setAddressDesc(String paramString)
  {
    this.addressDesc = paramString;
  }
  
  public void setCityId(int paramInt)
  {
    this.cityId = paramInt;
  }
  
  public void setGuideGeoPoint(GeoPoint paramGeoPoint)
  {
    this.guideGeoPoint = paramGeoPoint;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPoiOriginUID(String paramString)
  {
    this.poiOriginUID = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setViewGeoPoint(GeoPoint paramGeoPoint)
  {
    this.viewGeoPoint = paramGeoPoint;
  }
  
  public String toString()
  {
    return "type = " + this.type + ", name = " + this.name + ", cityId = " + this.cityId + ", guideGeoPoint = " + this.guideGeoPoint;
  }
  
  public static class LightNaviRoutePlanModel
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
      private static BNCommonAddressItem.LightNaviRoutePlanModel instance = new BNCommonAddressItem.LightNaviRoutePlanModel(null);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/model/BNCommonAddressItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */