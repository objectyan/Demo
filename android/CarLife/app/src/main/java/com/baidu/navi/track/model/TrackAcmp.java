package com.baidu.navi.track.model;

public class TrackAcmp
{
  private int carMaxDuration = 0;
  private int carNaviDistance = 0;
  private int carWeekMileage = 0;
  private boolean hasCarMaxDuration;
  private boolean hasCarNaviDistance;
  private boolean hasCarWeekMileage;
  
  public int getCarMaxDuration()
  {
    return this.carMaxDuration;
  }
  
  public int getCarNintaviDistance()
  {
    return this.carNaviDistance;
  }
  
  public int getCarWeekMileage()
  {
    return this.carWeekMileage;
  }
  
  public boolean hasCarNaviDistance()
  {
    return this.hasCarNaviDistance;
  }
  
  public TrackAcmp setCarMaxDuration(int paramInt)
  {
    this.hasCarMaxDuration = true;
    this.carMaxDuration = paramInt;
    return this;
  }
  
  public TrackAcmp setCarNaviDistance(int paramInt)
  {
    this.hasCarNaviDistance = true;
    this.carNaviDistance = paramInt;
    return this;
  }
  
  public TrackAcmp setCarWeekMileage(int paramInt)
  {
    this.hasCarWeekMileage = true;
    this.carWeekMileage = paramInt;
    return this;
  }
  
  public String toString()
  {
    return "TrackAcmp[carNaviDistance=" + this.carNaviDistance + ", carWeekMileage=" + this.carWeekMileage + ", carMaxDuration=" + this.carMaxDuration + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/model/TrackAcmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */