package com.baidu.navisdk.model.datastruct;

public class RoutePlanTime
{
  public int hour;
  public int minute;
  public boolean valid;
  
  public RoutePlanTime() {}
  
  public RoutePlanTime(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.hour = paramInt1;
    this.minute = paramInt2;
    this.valid = paramBoolean;
  }
  
  public int getHour()
  {
    return this.hour;
  }
  
  public int getMinute()
  {
    return this.minute;
  }
  
  public void setHour(int paramInt)
  {
    this.hour = paramInt;
  }
  
  public void setMinute(int paramInt)
  {
    this.minute = paramInt;
  }
  
  public void setValid(boolean paramBoolean)
  {
    this.valid = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/RoutePlanTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */