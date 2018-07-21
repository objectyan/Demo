package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class RgcOverlay
  extends InnerOverlay
{
  public static final int RGC_OVERLAY_TYPE_POIMARK = 3;
  public static final int RGC_OVERLAY_TYPE_POIRGCSHARE = 2;
  public static final int RGC_OVERLAY_TYPE_POISHARE = 1;
  public static final int RGC_OVERLAY_TYPE_REGEO = 0;
  static RgcOverlay rgcOverlay = null;
  int rgcIndex = 0;
  int rgcType = 0;
  
  public RgcOverlay()
  {
    super(18);
  }
  
  public RgcOverlay(AppBaseMap paramAppBaseMap)
  {
    super(18, paramAppBaseMap);
  }
  
  public Bundle getParam()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("rgcIndex", this.rgcIndex);
    localBundle.putInt("rgcType", this.rgcType);
    return localBundle;
  }
  
  public void setRgcPoiIndex(int paramInt)
  {
    this.rgcIndex = paramInt;
  }
  
  public void setRgcType(int paramInt)
  {
    this.rgcType = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/RgcOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */