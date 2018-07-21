package com.baidu.platform.comapi.map;

import android.os.Bundle;

public class NaviNodeOverlayer
  extends InnerOverlay
{
  static NaviNodeOverlayer naviNodeOverlayer = null;
  
  public NaviNodeOverlayer(int paramInt)
  {
    super(paramInt);
  }
  
  public static InnerOverlay getInstance()
  {
    if (naviNodeOverlayer == null) {
      naviNodeOverlayer = new NaviNodeOverlayer(25);
    }
    return naviNodeOverlayer;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/NaviNodeOverlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */