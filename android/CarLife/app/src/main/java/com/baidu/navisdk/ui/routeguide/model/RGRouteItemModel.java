package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.ui.routeguide.subview.BNavR;
import java.util.ArrayList;
import java.util.List;

public class RGRouteItemModel
{
  private static RGRouteItemModel sInstance = null;
  private int mFocusRouteItemIndex = 0;
  private List<RouteItem> mRouteItems = new ArrayList();
  
  public static RGRouteItemModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new RGRouteItemModel();
    }
    return sInstance;
  }
  
  public int getFocusItemIndex()
  {
    return this.mFocusRouteItemIndex;
  }
  
  public List<RouteItem> getRouteItems()
  {
    return this.mRouteItems;
  }
  
  public void reset()
  {
    if (this.mRouteItems != null) {
      this.mRouteItems.clear();
    }
  }
  
  public void updateFocusItemIndex(int paramInt)
  {
    this.mFocusRouteItemIndex = paramInt;
  }
  
  public void updateRouteItems(List<RouteItem> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    while (this.mRouteItems == null) {
      return;
    }
    this.mRouteItems.clear();
    this.mRouteItems.addAll(paramList);
  }
  
  public static class RouteItem
  {
    public static final int Type_End = 3;
    public static final int Type_Normal = 0;
    public static final int Type_Start = 1;
    public static final int Type_Via = 2;
    public int curRoadDist = -1;
    public int latitude = 0;
    public int longitude = 0;
    public String nextRoadName = null;
    public int originTurnType = -1;
    public int turnIconResId = -1;
    public int type = 0;
    
    public RouteItem() {}
    
    public RouteItem(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
    {
      this.originTurnType = paramInt1;
      this.curRoadDist = paramInt2;
      this.nextRoadName = paramString;
      this.longitude = paramInt3;
      this.latitude = paramInt4;
      if ((this.originTurnType >= 0) && (this.originTurnType < BNavR.gTurnIconID.length)) {
        this.turnIconResId = BNavR.gTurnIconID[this.originTurnType];
      }
    }
    
    public boolean isValid()
    {
      return (this.turnIconResId != -1) && (this.curRoadDist != -1) && (this.nextRoadName != null);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGRouteItemModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */