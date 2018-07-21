package com.baidu.platform.comapi.map;

public class BMBarShowEvent
{
  public String curfloor;
  public byte[] data;
  public String searchbound;
  public String uid;
  
  public BMBarShowEvent(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    this.uid = paramString1;
    this.searchbound = paramString2;
    this.data = paramArrayOfByte;
    this.curfloor = paramString3;
  }
  
  public BMBarShowEvent(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.uid = paramString1;
    this.data = paramArrayOfByte;
    this.curfloor = paramString2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/BMBarShowEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */