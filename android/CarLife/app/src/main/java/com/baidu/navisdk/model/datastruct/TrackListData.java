package com.baidu.navisdk.model.datastruct;

public class TrackListData
{
  public String mTrackEnd = "shenzhen ";
  public String mTrackKey;
  public String mTrackMileage = "12";
  public String mTrackName;
  public String mTrackSpeed = "50";
  public String mTrackStart = "baidu ";
  public String mTrackTime = "11.23";
  public String mTrackTimeLength = "1h30min";
  
  public TrackListData() {}
  
  public TrackListData(String paramString)
  {
    this.mTrackKey = paramString;
  }
  
  public String toString()
  {
    return "mTrackStart=" + this.mTrackStart + ", mTrackEnd=" + this.mTrackEnd + ", mTrackMileage=" + this.mTrackMileage + ", mTrackTimeLength=" + this.mTrackTimeLength + ", mTrackSpeed=" + this.mTrackSpeed + ", mTrackTime=" + this.mTrackTime;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/TrackListData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */