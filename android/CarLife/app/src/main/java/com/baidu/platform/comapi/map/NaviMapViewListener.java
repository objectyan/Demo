package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;

public abstract interface NaviMapViewListener
{
  public abstract void onAction(int paramInt, Object paramObject);
  
  public abstract boolean onItemClick(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onMapAnimationFinish();
  
  public abstract void onMapRenderModeChange(int paramInt);
  
  public abstract Point onTapInterception(Point paramPoint);
  
  public abstract void resizeScreen(int paramInt1, int paramInt2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/NaviMapViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */