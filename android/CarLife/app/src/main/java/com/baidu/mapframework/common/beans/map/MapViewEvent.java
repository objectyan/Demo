package com.baidu.mapframework.common.beans.map;

import com.baidu.mapframework.common.beans.BaseEvent;

public class MapViewEvent
  extends BaseEvent
{
  public static final int ADD_BIRDEYE_MAPVIEW = 2;
  public static final int ADD_PHOTO_ALBUM = 4;
  public static final int ATTACH_MAPVIEW = 0;
  public static final int DELETE_BIRDEYE_MAPVIEW = 3;
  public static final int DELETE_PHOTO_ALBUM = 5;
  public static final int DETACH_MAPVIEW = 1;
  public int relayoutMapView;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/beans/map/MapViewEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */