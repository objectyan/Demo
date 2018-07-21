package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class StreetPopupOverlay
  extends InnerOverlay
{
  public StreetPopupOverlay()
  {
    super(30);
  }
  
  public StreetPopupOverlay(AppBaseMap paramAppBaseMap)
  {
    super(30, paramAppBaseMap);
  }
  
  public boolean addedToMapView()
  {
    if (this.mBaseMap == null) {}
    do
    {
      return false;
      this.mLayerID = this.mBaseMap.AddLayer(2, 0, "streetpopup");
    } while (this.mLayerID == 0);
    this.mBaseMap.SetLayersClickable(this.mLayerID, true);
    this.mBaseMap.ShowLayers(this.mLayerID, false);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/StreetPopupOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */