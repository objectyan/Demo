package com.baidu.mapframework.location;

public class FailLocationEvent
{
  public String diagnosticMessage;
  public int diagnosticType;
  public int locType;
  
  public FailLocationEvent(int paramInt1, int paramInt2, String paramString)
  {
    this.locType = paramInt1;
    this.diagnosticMessage = paramString;
    this.diagnosticType = paramInt2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/location/FailLocationEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */