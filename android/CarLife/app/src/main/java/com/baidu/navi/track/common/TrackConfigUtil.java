package com.baidu.navi.track.common;

public class TrackConfigUtil
{
  private static TrackConfigUtil sInstance = new TrackConfigUtil();
  
  public static TrackConfigUtil getInstance()
  {
    return sInstance;
  }
  
  public boolean getRouteRecordFlag()
  {
    return TrackConfig.getInstance().isOpenNavigateRecord();
  }
  
  public void setRouteRecordFlag(boolean paramBoolean)
  {
    TrackConfig.getInstance().setOpenNavigateRecord(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/common/TrackConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */