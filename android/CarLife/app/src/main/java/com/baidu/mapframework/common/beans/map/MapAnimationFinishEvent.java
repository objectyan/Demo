package com.baidu.mapframework.common.beans.map;

import com.baidu.mapframework.common.beans.BaseEvent;

public class MapAnimationFinishEvent
  extends BaseEvent
{
  public boolean ontouch;
  
  public MapAnimationFinishEvent() {}
  
  public MapAnimationFinishEvent(boolean paramBoolean)
  {
    this.ontouch = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/beans/map/MapAnimationFinishEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */