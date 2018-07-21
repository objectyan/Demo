package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class CompassOverlay
  extends InnerOverlay
{
  public CompassOverlay()
  {
    super(20);
  }
  
  public CompassOverlay(AppBaseMap paramAppBaseMap)
  {
    super(20, paramAppBaseMap);
  }
  
  public boolean getDefaultShowStatus()
  {
    return true;
  }
  
  public String getLayerTag()
  {
    return "compass";
  }
  
  public void setData(String paramString)
  {
    super.setData(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/CompassOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */