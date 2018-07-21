package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class PopupOverlay
  extends InnerOverlay
{
  public PopupOverlay()
  {
    super(21);
  }
  
  public PopupOverlay(AppBaseMap paramAppBaseMap)
  {
    super(21, paramAppBaseMap);
  }
  
  public boolean addedToMapView()
  {
    if (this.mBaseMap == null) {}
    do
    {
      return false;
      this.mLayerID = this.mBaseMap.AddLayer(0, 0, "popup");
    } while (this.mLayerID == 0);
    this.mBaseMap.SetLayersClickable(this.mLayerID, true);
    this.mBaseMap.ShowLayers(this.mLayerID, false);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/PopupOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */