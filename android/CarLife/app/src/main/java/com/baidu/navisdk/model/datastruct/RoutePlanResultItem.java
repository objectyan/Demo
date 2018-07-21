package com.baidu.navisdk.model.datastruct;

public class RoutePlanResultItem
{
  public int angle = 0;
  private String mBubleDesc;
  private int mIconResId;
  private int mLatitude;
  private int mLongitude;
  private int mRoadCondition;
  private String mRouteNodeDesc;
  private String mRouteNodeDescNight;
  public String roadName = "";
  
  public RoutePlanResultItem(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mIconResId = paramInt1;
    this.mRouteNodeDesc = paramString1;
    this.mRouteNodeDescNight = paramString2;
    this.mBubleDesc = paramString3;
    this.mLongitude = paramInt2;
    this.mLatitude = paramInt3;
    this.mRoadCondition = paramInt4;
  }
  
  public int getIconResId()
  {
    return this.mIconResId;
  }
  
  public int getLatitude()
  {
    return this.mLatitude;
  }
  
  public int getLongitude()
  {
    return this.mLongitude;
  }
  
  public String getNextRoadName()
  {
    return this.mBubleDesc;
  }
  
  public String getNodeDesc()
  {
    return this.mRouteNodeDesc;
  }
  
  public String getNodeDescNight()
  {
    return this.mRouteNodeDescNight;
  }
  
  public int getRoadCondition()
  {
    return this.mRoadCondition;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/RoutePlanResultItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */