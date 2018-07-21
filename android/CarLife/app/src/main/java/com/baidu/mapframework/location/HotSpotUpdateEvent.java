package com.baidu.mapframework.location;

public class HotSpotUpdateEvent
{
  public String connectWifiMac = null;
  public int hotSpotState = -1;
  
  public HotSpotUpdateEvent(String paramString, int paramInt)
  {
    this.connectWifiMac = paramString;
    this.hotSpotState = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/location/HotSpotUpdateEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */