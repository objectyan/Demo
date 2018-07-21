package com.baidu.platform.comapi.map.event;

public class SensorCalibrationEvent
{
  private String from = null;
  private boolean ifNeed = false;
  
  public SensorCalibrationEvent(boolean paramBoolean)
  {
    this.ifNeed = paramBoolean;
  }
  
  public SensorCalibrationEvent(boolean paramBoolean, String paramString)
  {
    this.ifNeed = paramBoolean;
    this.from = paramString;
  }
  
  public String getFrom()
  {
    return this.from;
  }
  
  public boolean isIfNeed()
  {
    return this.ifNeed;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/event/SensorCalibrationEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */