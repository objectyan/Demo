package com.baidu.navisdk.naviresult;

import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.logic.BNSysLocationManager;

public class BNNaviResultModel
{
  private static final String TAG = BNNaviResultModel.class.getSimpleName();
  private int accelerateNum = 0;
  private float averageSpeed = 0.0F;
  private int brakeNum = 0;
  private boolean destArrived = false;
  private int estimatedRemainDist = 0;
  private long estimatedRemainTimeMillis = 0L;
  public int instantNum = 0;
  public int isSwitch = 0;
  private float maxSpeed = 0.0F;
  private float naviCompletePercentage = 0.0F;
  private boolean showWalkNavi = false;
  private int speedNum = 0;
  private float totalDistance = 0.0F;
  private long totalTimeSecs = 0L;
  private int turnNum = 0;
  private int walkNaviRemainDist = 0;
  public int yawNum = 0;
  
  public static BNNaviResultModel getInstance()
  {
    return LazyLoader.instance;
  }
  
  public int getAccelerateNum()
  {
    return this.accelerateNum;
  }
  
  public float getAverageSpeed()
  {
    return this.averageSpeed;
  }
  
  public int getBrakeNum()
  {
    return this.brakeNum;
  }
  
  public int getEstimatedRemainDist()
  {
    return this.estimatedRemainDist;
  }
  
  public long getEstimatedRemainTimeMillis()
  {
    return this.estimatedRemainTimeMillis;
  }
  
  public float getMaxSpeed()
  {
    return this.maxSpeed;
  }
  
  public float getNaviCompletePercentage()
  {
    return this.naviCompletePercentage;
  }
  
  public int getSpeedNum()
  {
    return this.speedNum;
  }
  
  public float getTotalDistance()
  {
    return this.totalDistance;
  }
  
  public String getTotalDistanceStr()
  {
    if (this.totalDistance < 1000.0F) {
      return Math.round(this.totalDistance) + "m";
    }
    double d = this.totalDistance / 1000.0F;
    return (int)d + "km";
  }
  
  public String getTotalTimeFormatedStr()
  {
    String str2 = StringUtils.customedFormatTime((int)this.totalTimeSecs, "天", "小时", "分");
    String str1 = str2;
    if ("少于1分钟".equals(str2)) {
      str1 = "1分";
    }
    return str1;
  }
  
  public long getTotalTimeSecs()
  {
    return this.totalTimeSecs;
  }
  
  public int getTurnNum()
  {
    return this.turnNum;
  }
  
  public int getWalkNaviRemainDist()
  {
    return this.walkNaviRemainDist;
  }
  
  public boolean isDestArrived()
  {
    return this.destArrived;
  }
  
  public boolean isShowWalkNavi()
  {
    return this.showWalkNavi;
  }
  
  public void reset()
  {
    this.estimatedRemainTimeMillis = 0L;
    this.estimatedRemainDist = 0;
    this.totalTimeSecs = 0L;
    this.totalDistance = 0.0F;
    this.maxSpeed = 0.0F;
    this.averageSpeed = 0.0F;
    this.speedNum = 0;
    this.brakeNum = 0;
    this.turnNum = 0;
    this.accelerateNum = 0;
    this.destArrived = false;
    this.naviCompletePercentage = 0.0F;
    this.showWalkNavi = false;
    this.walkNaviRemainDist = 0;
    this.yawNum = 0;
    this.instantNum = 0;
    this.isSwitch = 0;
  }
  
  public void setAccelerateNum(int paramInt)
  {
    this.accelerateNum = paramInt;
  }
  
  public void setAverageSpeed(float paramFloat)
  {
    this.averageSpeed = paramFloat;
  }
  
  public void setBrakeNum(int paramInt)
  {
    this.brakeNum = paramInt;
  }
  
  public void setDestArrived(boolean paramBoolean)
  {
    this.destArrived = paramBoolean;
  }
  
  public void setEstimatedRemainDist(int paramInt)
  {
    this.estimatedRemainDist = paramInt;
  }
  
  public void setEstimatedRemainTimeMillis(long paramLong)
  {
    this.estimatedRemainTimeMillis = paramLong;
  }
  
  public void setMaxSpeed(float paramFloat)
  {
    this.maxSpeed = paramFloat;
  }
  
  public void setNaviCompletePercentage(float paramFloat)
  {
    this.naviCompletePercentage = paramFloat;
  }
  
  public void setShowWalkNavi(boolean paramBoolean)
  {
    this.showWalkNavi = paramBoolean;
  }
  
  public void setSpeedNum(int paramInt)
  {
    this.speedNum = paramInt;
  }
  
  public void setTotalDistance(float paramFloat)
  {
    this.totalDistance = paramFloat;
  }
  
  public void setTotalTimeSecs(long paramLong)
  {
    this.totalTimeSecs = paramLong;
  }
  
  public void setTurnNum(int paramInt)
  {
    this.turnNum = paramInt;
  }
  
  public void setWalkNaviRemainDist(int paramInt)
  {
    this.walkNaviRemainDist = paramInt;
  }
  
  public void setYawNum()
  {
    LocData localLocData = null;
    if (BNSysLocationManager.getInstance().isSysLocationValid()) {
      localLocData = BNSysLocationManager.getInstance().getCurLocation();
    }
    if ((BNRoutePlaner.getInstance().getLineDist2RpNode(localLocData, true) > 100) && (BNRoutePlaner.getInstance().getLineDist2RpNode(localLocData, false) > 100)) {
      this.yawNum += 1;
    }
  }
  
  public String toString()
  {
    return "estimatedRemainTimeMillis: " + this.estimatedRemainTimeMillis + ", estimatedRemainDist: " + this.estimatedRemainDist + ", totalTimeSecs: " + this.totalTimeSecs + ", totalDistance: " + this.totalDistance + ", maxSpeed: " + this.maxSpeed + ", averageSpeed: " + this.averageSpeed + ", speedNum: " + this.speedNum + ", brakeNum: " + this.brakeNum + ", turnNum: " + this.turnNum + ", accelerateNum: " + this.accelerateNum + ", destArrived: " + this.destArrived + ", naviCompletePercentage: " + this.naviCompletePercentage + ", showWalkNavi: " + this.showWalkNavi + ", walkNaviRemainDist: " + this.walkNaviRemainDist;
  }
  
  private static class LazyLoader
  {
    private static BNNaviResultModel instance = new BNNaviResultModel(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/naviresult/BNNaviResultModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */