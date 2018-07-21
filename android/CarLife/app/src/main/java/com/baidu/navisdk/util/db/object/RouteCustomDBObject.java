package com.baidu.navisdk.util.db.object;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;

public class RouteCustomDBObject
  implements BaseDBObject
{
  private long mCustomTime;
  private int mDestType;
  private int mHisRouteId;
  private int mId;
  private int mIsOpen;
  private int mIsRepeat;
  private long mModifiedTime;
  private String mName;
  private int mPUshTimeMinute;
  private int mPushTimeHour;
  private long mPushTimeMills;
  private String mRepeatDate;
  private ArrayList<RoutePlanNodeDBObject> mRoutePlanNodes;
  
  public long getCustomTime()
  {
    return this.mCustomTime;
  }
  
  public int getDestType()
  {
    return this.mDestType;
  }
  
  public int getHisRouteId()
  {
    return this.mHisRouteId;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public int getIsRepeat()
  {
    return this.mIsRepeat;
  }
  
  public long getModifiedTime()
  {
    return this.mModifiedTime;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getOpen()
  {
    return this.mIsOpen;
  }
  
  public int getPushTimeHour()
  {
    return this.mPushTimeHour;
  }
  
  public long getPushTimeMills()
  {
    return this.mPushTimeMills;
  }
  
  public int getPushTimeMinute()
  {
    return this.mPUshTimeMinute;
  }
  
  public String getRepeatDate()
  {
    return this.mRepeatDate;
  }
  
  public ArrayList<RoutePlanNodeDBObject> getRoutePlanDBNodes()
  {
    return this.mRoutePlanNodes;
  }
  
  public ArrayList<RoutePlanNode> getRoutePlanNodes()
  {
    return RoutePlanNodeDBObject.convertToRoutePlanNodeList(this.mRoutePlanNodes);
  }
  
  public void setCustomTime(long paramLong)
  {
    this.mCustomTime = paramLong;
  }
  
  public void setDestType(int paramInt)
  {
    this.mDestType = paramInt;
  }
  
  public void setHisRouteId(int paramInt)
  {
    this.mHisRouteId = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public void setIsRepeat(int paramInt)
  {
    this.mIsRepeat = paramInt;
  }
  
  public void setModifiedTime(long paramLong)
  {
    this.mModifiedTime = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setOpen(int paramInt)
  {
    this.mIsOpen = paramInt;
  }
  
  public void setPushTimeHour(int paramInt)
  {
    this.mPushTimeHour = paramInt;
  }
  
  public void setPushTimeMills(long paramLong)
  {
    this.mPushTimeMills = paramLong;
  }
  
  public void setPushTimeMinute(int paramInt)
  {
    this.mPUshTimeMinute = paramInt;
  }
  
  public void setRepeatDate(String paramString)
  {
    this.mRepeatDate = paramString;
  }
  
  public void setRoutePlanNodes(ArrayList<RoutePlanNodeDBObject> paramArrayList)
  {
    this.mRoutePlanNodes = paramArrayList;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/object/RouteCustomDBObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */