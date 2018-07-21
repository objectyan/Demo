package com.baidu.platform.comapi.map;

public class BMBarHiddeEvent
{
  public byte[] data;
  public String uid;
  
  public BMBarHiddeEvent() {}
  
  public BMBarHiddeEvent(String paramString, byte[] paramArrayOfByte)
  {
    this.uid = paramString;
    this.data = paramArrayOfByte;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/BMBarHiddeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */