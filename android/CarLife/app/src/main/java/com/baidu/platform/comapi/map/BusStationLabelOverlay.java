package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class BusStationLabelOverlay
  extends InnerOverlay
{
  public BusStationLabelOverlay()
  {
    super(32);
  }
  
  public BusStationLabelOverlay(AppBaseMap paramAppBaseMap)
  {
    super(32, paramAppBaseMap);
  }
  
  public boolean addedToMapView()
  {
    if (this.mBaseMap == null) {}
    do
    {
      return false;
      this.mLayerID = this.mBaseMap.AddLayer(0, 0, "rtpopup");
    } while (this.mLayerID == 0);
    this.mBaseMap.SetLayersClickable(this.mLayerID, true);
    this.mBaseMap.ShowLayers(this.mLayerID, false);
    return true;
  }
  
  public int getType()
  {
    return -1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/BusStationLabelOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */