package com.baidu.navi.track.model;

public class CarNavi
{
  private double avgSpeed = 0.0D;
  private int ctime = 0;
  private int distance = 0;
  private int duration = 0;
  private NaviPoint endPoint;
  private String guid = "";
  private boolean hasAvgSpeed;
  private boolean hasCtime;
  private boolean hasDistance;
  private boolean hasDuration;
  private boolean hasEndPoint;
  private boolean hasGuid;
  private boolean hasMaxSpeed;
  private boolean hasModifyTime;
  private boolean hasSid;
  private boolean hasSign;
  private boolean hasStartPoint;
  private boolean hasType;
  private double maxSpeed = 0.0D;
  private int modifyTime = 0;
  private String sid = "";
  private String sign = "";
  private NaviPoint startPoint;
  private String type = "";
  
  public CarNavi clearEndPoint()
  {
    this.hasEndPoint = false;
    this.endPoint = null;
    return this;
  }
  
  public CarNavi clearStartPoint()
  {
    this.hasStartPoint = false;
    this.startPoint = null;
    return this;
  }
  
  public double getAvgSpeed()
  {
    return this.avgSpeed;
  }
  
  public int getCtime()
  {
    return this.ctime;
  }
  
  public int getDistance()
  {
    return this.distance;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public NaviPoint getEndPoint()
  {
    return this.endPoint;
  }
  
  public String getGuid()
  {
    return this.guid;
  }
  
  public double getMaxSpeed()
  {
    return this.maxSpeed;
  }
  
  public int getModifyTime()
  {
    return this.modifyTime;
  }
  
  public String getSid()
  {
    return this.sid;
  }
  
  public String getSign()
  {
    return this.sign;
  }
  
  public NaviPoint getStartPoint()
  {
    return this.startPoint;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public boolean hasAvgSpeed()
  {
    return this.hasAvgSpeed;
  }
  
  public boolean hasCtime()
  {
    return this.hasCtime;
  }
  
  public boolean hasDistance()
  {
    return this.hasDistance;
  }
  
  public boolean hasDuration()
  {
    return this.hasDuration;
  }
  
  public boolean hasEndPoint()
  {
    return this.hasEndPoint;
  }
  
  public boolean hasGuid()
  {
    return this.hasGuid;
  }
  
  public boolean hasMaxSpeed()
  {
    return this.hasMaxSpeed;
  }
  
  public boolean hasModifyTtime()
  {
    return this.hasModifyTime;
  }
  
  public boolean hasSid()
  {
    return this.hasSid;
  }
  
  public boolean hasSign()
  {
    return this.hasSign;
  }
  
  public boolean hasStartPoint()
  {
    return this.hasStartPoint;
  }
  
  public boolean hasType()
  {
    return this.hasType;
  }
  
  public CarNavi setAvgSpeed(double paramDouble)
  {
    this.hasAvgSpeed = true;
    this.avgSpeed = paramDouble;
    return this;
  }
  
  public CarNavi setCtime(int paramInt)
  {
    this.hasCtime = true;
    this.ctime = paramInt;
    return this;
  }
  
  public CarNavi setDistance(int paramInt)
  {
    this.hasDistance = true;
    this.distance = paramInt;
    return this;
  }
  
  public CarNavi setDuration(int paramInt)
  {
    this.hasDuration = true;
    this.duration = paramInt;
    return this;
  }
  
  public CarNavi setEndPoint(NaviPoint paramNaviPoint)
  {
    this.hasEndPoint = true;
    this.endPoint = paramNaviPoint;
    return this;
  }
  
  public CarNavi setGuid(String paramString)
  {
    this.hasGuid = true;
    this.guid = paramString;
    return this;
  }
  
  public CarNavi setMaxSpeed(double paramDouble)
  {
    this.hasMaxSpeed = true;
    this.maxSpeed = paramDouble;
    return this;
  }
  
  public CarNavi setModifyTime(int paramInt)
  {
    this.hasModifyTime = true;
    this.modifyTime = paramInt;
    return this;
  }
  
  public CarNavi setSid(String paramString)
  {
    this.hasSid = true;
    this.sid = paramString;
    return this;
  }
  
  public CarNavi setSign(String paramString)
  {
    this.hasSign = true;
    this.sign = paramString;
    return this;
  }
  
  public CarNavi setStartPoint(NaviPoint paramNaviPoint)
  {
    this.hasStartPoint = true;
    this.startPoint = paramNaviPoint;
    return this;
  }
  
  public CarNavi setType(String paramString)
  {
    this.hasType = true;
    this.type = paramString;
    return this;
  }
  
  public String toString()
  {
    return "CarNavi [sid=" + this.sid + ", guid=" + this.guid + ", ctime=" + this.ctime + ", distance=" + this.distance + ", duration=" + this.duration + ", avgSpeed=" + this.avgSpeed + ", maxSpeed=" + this.maxSpeed + ", sign=" + this.sign + ",type =" + this.type + ", modifyTime=" + this.modifyTime + ", startPoint=" + this.startPoint + ", endPoint=" + this.endPoint + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/model/CarNavi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */