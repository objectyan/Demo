package com.baidu.navisdk.model.datastruct;

import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;

public class RoutePlanOutlineItem
{
  public static int ROADCONDITION_TYPE_INVALID = 0;
  public static int ROADCONDITION_TYPE_OBSTRUCTION = 3;
  public static int ROADCONDITION_TYPE_SLOW;
  public static int ROADCONDITION_TYPE_STRAIGHTWAY = 1;
  private double mLength;
  private int mLights;
  private String mMainroads;
  private double mPassTime;
  private int mRouteId;
  private String mStrTotalRoadCondition;
  private boolean mTipsHasClosed = false;
  private int mToll;
  private int mTotalRoadCondition;
  private int pusLabelID;
  private String pusLabelName;
  private String pusLabelTips;
  
  static
  {
    ROADCONDITION_TYPE_SLOW = 2;
  }
  
  public RoutePlanOutlineItem(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2, String paramString2, String paramString3, int paramInt5)
  {
    this.mRouteId = paramInt1;
    this.mMainroads = paramString1;
    this.mTotalRoadCondition = paramInt4;
    this.mLength = paramDouble1;
    this.mPassTime = paramDouble2;
    this.mToll = paramInt2;
    this.mLights = paramInt3;
    this.pusLabelName = paramString2;
    this.pusLabelTips = paramString3;
    this.pusLabelID = paramInt5;
    if (paramInt4 == ROADCONDITION_TYPE_INVALID)
    {
      this.mStrTotalRoadCondition = "无效";
      return;
    }
    if (paramInt4 == ROADCONDITION_TYPE_STRAIGHTWAY)
    {
      this.mStrTotalRoadCondition = "顺畅";
      return;
    }
    if (paramInt4 == ROADCONDITION_TYPE_SLOW)
    {
      this.mStrTotalRoadCondition = "缓慢";
      return;
    }
    if (paramInt4 == ROADCONDITION_TYPE_OBSTRUCTION)
    {
      this.mStrTotalRoadCondition = "拥堵";
      return;
    }
    this.mStrTotalRoadCondition = "无效";
  }
  
  public double getLength()
  {
    return this.mLength;
  }
  
  public String getLengthStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringUtils.formatDistance((int)this.mLength, StringUtils.UnitLangEnum.ZH, localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public int getLights()
  {
    return this.mLights;
  }
  
  public String getMainroads()
  {
    return this.mMainroads;
  }
  
  public double getPassTime()
  {
    return this.mPassTime;
  }
  
  public String getPassTimeStr()
  {
    return StringUtils.formatTime2((int)this.mPassTime, 2);
  }
  
  public int getPusLabelID()
  {
    return this.pusLabelID;
  }
  
  public String getPusLabelName()
  {
    return this.pusLabelName;
  }
  
  public String getPusLabelTips()
  {
    return this.pusLabelTips;
  }
  
  public int getRoutId()
  {
    return this.mRouteId;
  }
  
  public String getStrTotalRoadCondition()
  {
    return this.mStrTotalRoadCondition;
  }
  
  public int getToll()
  {
    return this.mToll;
  }
  
  public int getTotalRoadCondition()
  {
    return this.mTotalRoadCondition;
  }
  
  public boolean isTipsHasClosed()
  {
    return this.mTipsHasClosed;
  }
  
  public void setPusLabelName(String paramString)
  {
    this.pusLabelName = paramString;
  }
  
  public void setPusLabelTips(String paramString)
  {
    this.pusLabelTips = paramString;
  }
  
  public void setTipsHasClosed(boolean paramBoolean)
  {
    this.mTipsHasClosed = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/RoutePlanOutlineItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */