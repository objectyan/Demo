package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.map.provider.StreetscapeWalkRouteProvider;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class StreetRouteOverlay
  extends InnerOverlay
{
  public static final int PAGE_FROM_BASELINE = 0;
  public static final int PAGE_FROM_WALK_NAVI = 1;
  private WalkNaviUpdateListener mListeners;
  private int mPageFrom;
  private StreetscapeWalkRouteProvider mProvider;
  
  public StreetRouteOverlay()
  {
    super(35);
  }
  
  public StreetRouteOverlay(AppBaseMap paramAppBaseMap)
  {
    super(35, paramAppBaseMap);
  }
  
  public void addListener(WalkNaviUpdateListener paramWalkNaviUpdateListener)
  {
    this.mListeners = paramWalkNaviUpdateListener;
  }
  
  public boolean addedToMapView()
  {
    if (this.mBaseMap == null) {}
    do
    {
      return false;
      this.mLayerID = this.mBaseMap.AddLayer(1, 0, "streetroute");
    } while (this.mLayerID == 0);
    this.mBaseMap.SetLayersClickable(this.mLayerID, false);
    this.mBaseMap.ShowLayers(this.mLayerID, false);
    return true;
  }
  
  public String getData()
  {
    if (this.mListeners != null) {
      this.mListeners.onWNStreetRouteLayerUpdate();
    }
    if ((this.mProvider == null) || (this.mProvider.getWalkPosBundle().getInt("unNodeCnt") == 0)) {
      return "";
    }
    return this.mProvider.getRenderData();
  }
  
  public void show(boolean paramBoolean)
  {
    if (this.mLayerID != 0) {
      this.mBaseMap.ShowLayers(this.mLayerID, paramBoolean);
    }
  }
  
  public boolean updateData(Bundle paramBundle)
  {
    if (paramBundle.getInt("unNodeCnt") == 0) {
      return false;
    }
    if (this.mProvider == null)
    {
      this.mProvider = new StreetscapeWalkRouteProvider(paramBundle);
      return true;
    }
    this.mProvider.setWalkPosBundle(paramBundle);
    return true;
  }
  
  public static abstract interface WalkNaviUpdateListener
  {
    public abstract boolean onWNStreetRouteLayerUpdate();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/StreetRouteOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */