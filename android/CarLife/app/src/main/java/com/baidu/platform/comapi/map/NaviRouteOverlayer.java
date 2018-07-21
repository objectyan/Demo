package com.baidu.platform.comapi.map;

import android.os.Bundle;

public class NaviRouteOverlayer
  extends InnerOverlay
{
  static NaviRouteOverlayer naviRouteOverlayer = null;
  
  public NaviRouteOverlayer(int paramInt)
  {
    super(paramInt);
  }
  
  public static InnerOverlay getInstance()
  {
    if (naviRouteOverlayer == null) {
      naviRouteOverlayer = new NaviRouteOverlayer(26);
    }
    return naviRouteOverlayer;
  }
  
  public void clear() {}
  
  public String getData()
  {
    return null;
  }
  
  public Bundle getParam()
  {
    return null;
  }
  
  public void setData(String paramString) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/NaviRouteOverlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */