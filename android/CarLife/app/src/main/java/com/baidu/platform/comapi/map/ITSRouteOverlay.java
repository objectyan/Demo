package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class ITSRouteOverlay
  extends InnerOverlay
{
  static ITSRouteOverlay itsRouteOverlay = null;
  
  public ITSRouteOverlay()
  {
    super(13);
  }
  
  public ITSRouteOverlay(AppBaseMap paramAppBaseMap)
  {
    super(13, paramAppBaseMap);
  }
  
  public String getLayerTag()
  {
    return "itsroute";
  }
  
  public int getType()
  {
    return -2;
  }
  
  public int getUpdateTimeInterval()
  {
    return 180000;
  }
  
  public int getUpdateType()
  {
    return 10;
  }
  
  public boolean switchLayer(int paramInt)
  {
    return this.mBaseMap.SwitchLayer(paramInt, this.mLayerID);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/ITSRouteOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */