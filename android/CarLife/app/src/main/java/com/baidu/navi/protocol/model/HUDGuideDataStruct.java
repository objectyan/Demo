package com.baidu.navi.protocol.model;

public class HUDGuideDataStruct
  extends DataStruct
{
  public static final String KEY_DIRECTION = "direction";
  public static final String KEY_DISTANCE = "distanceToCurrPoint";
  public static final String KEY_ICON_NAME = "icon";
  public static final String KEY_NAME = "name";
  public static final String KEY_REMAIN_DISTANCE = "remainDistance";
  public static final String KEY_REMAIN_TIME = "remainTime";
  public String direction;
  public String distance;
  public String iconName;
  public String nextRoadName;
  public String remainDistance;
  public String remainTime;
  
  public HUDGuideDataStruct()
  {
    this.mCmd = "notifyGuideNodeInfo";
  }
  
  public String toString()
  {
    return "cmd=" + this.mCmd + " nextRoadName=" + this.nextRoadName + " direction=" + this.direction + " distance=" + this.distance + " iconName=" + this.iconName + " remainDistance=" + this.remainDistance + " remainTime=" + this.remainTime;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/HUDGuideDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */