package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class BusLineOverlay
  extends InnerOverlay
{
  private Bundle poiDetailBusLineBundle = null;
  
  public BusLineOverlay()
  {
    super(17);
  }
  
  public BusLineOverlay(AppBaseMap paramAppBaseMap)
  {
    super(17, paramAppBaseMap);
  }
  
  public Bundle getParam()
  {
    if (this.poiDetailBusLineBundle != null) {
      return this.poiDetailBusLineBundle;
    }
    return super.getParam();
  }
  
  public void setPoiDetailBusLineBundle(Bundle paramBundle)
  {
    this.poiDetailBusLineBundle = paramBundle;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/BusLineOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */