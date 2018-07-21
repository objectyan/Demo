package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.model.datastruct.RoadConditionItem;
import com.baidu.navisdk.ui.routeguide.subview.AssistantMapTypeConstDefine;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;

public class RGAssistGuideModel
{
  public static final String KEY_ASSIST_INDEX = "key_assist_index";
  public static final int MAX_ASSIST_INFO = 3;
  private static final String TAG = RGAssistGuideModel.class.getSimpleName();
  public static final int UPDATE_TYPE_HIDE = 3;
  public static final int UPDATE_TYPE_SHOW = 1;
  public static final int UPDATE_TYPE_UPDATE = 2;
  private static RGAssistGuideModel mInstance = null;
  private List<AssistInfo> mAssistInfos = new ArrayList();
  private double mCurCarDriveProgress = 0.0D;
  private int mCurCarSpeed = 0;
  public boolean mIsGPSEnable = false;
  public boolean mIsGPSFix = false;
  private long mLastRefreshRoadConditionTime = -1L;
  private Bundle mLastestData = new Bundle();
  private boolean mMainAuxiliary = false;
  public int mOverSpeed = -1;
  
  public static RGAssistGuideModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGAssistGuideModel();
    }
    return mInstance;
  }
  
  private int indexOfAssistType(int paramInt)
  {
    int j = this.mAssistInfos.size();
    int i = 0;
    while (i < j)
    {
      if (((AssistInfo)this.mAssistInfos.get(i)).mAssistType == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int indexOfHideAssistInfo()
  {
    int j = this.mAssistInfos.size();
    int i = 0;
    while (i < j)
    {
      if (((AssistInfo)this.mAssistInfos.get(i)).mUpdateType == 3) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int recieveHideInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = indexOfAssistType(paramInt2);
    if (paramInt1 != -1) {
      ((AssistInfo)this.mAssistInfos.get(paramInt1)).mUpdateType = 3;
    }
    return paramInt1;
  }
  
  private int recieveShowInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = -1;
    int k = this.mAssistInfos.size();
    LogUtil.e(TAG, "recieveShowInfo  size=" + k);
    AssistInfo localAssistInfo;
    int j;
    if (k == 0)
    {
      localAssistInfo = new AssistInfo();
      localAssistInfo.mUpdateType = 1;
      localAssistInfo.mAssistType = paramInt2;
      localAssistInfo.mSpeedLimit = paramInt3;
      localAssistInfo.mProgress = 0;
      localAssistInfo.mIconResId = paramInt1;
      this.mAssistInfos.add(localAssistInfo);
      j = 0;
    }
    int i;
    int n;
    do
    {
      do
      {
        return j;
        j = indexOfAssistType(paramInt2);
        i = j;
        if (j < 0) {
          i = indexOfHideAssistInfo();
        }
        if (i != -1)
        {
          ((AssistInfo)this.mAssistInfos.get(i)).mUpdateType = 1;
          ((AssistInfo)this.mAssistInfos.get(i)).mAssistType = paramInt2;
          ((AssistInfo)this.mAssistInfos.get(i)).mSpeedLimit = paramInt3;
          ((AssistInfo)this.mAssistInfos.get(i)).mIconResId = paramInt1;
          ((AssistInfo)this.mAssistInfos.get(i)).mProgress = 0;
          return i;
        }
        if (k < 3)
        {
          localAssistInfo = new AssistInfo();
          localAssistInfo.mUpdateType = 1;
          localAssistInfo.mAssistType = paramInt2;
          localAssistInfo.mSpeedLimit = paramInt3;
          localAssistInfo.mIconResId = paramInt1;
          localAssistInfo.mProgress = 0;
          this.mAssistInfos.add(localAssistInfo);
          return k;
        }
        n = this.mAssistInfos.size();
        j = m;
      } while (i < 0);
      j = m;
    } while (i >= n);
    k = 0;
    for (;;)
    {
      j = m;
      if (k >= n) {
        break;
      }
      if (paramInt2 < ((AssistInfo)this.mAssistInfos.get(k)).mAssistType)
      {
        ((AssistInfo)this.mAssistInfos.get(i)).mUpdateType = 1;
        ((AssistInfo)this.mAssistInfos.get(i)).mAssistType = paramInt2;
        ((AssistInfo)this.mAssistInfos.get(i)).mSpeedLimit = paramInt3;
        ((AssistInfo)this.mAssistInfos.get(i)).mIconResId = paramInt1;
        ((AssistInfo)this.mAssistInfos.get(i)).mProgress = 0;
        return i;
      }
      k += 1;
    }
  }
  
  private int recieveUpdateInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = -1;
    int i = indexOfAssistType(paramInt2);
    paramInt1 = j;
    if (i != -1)
    {
      paramInt1 = j;
      if (i < this.mAssistInfos.size())
      {
        ((AssistInfo)this.mAssistInfos.get(i)).mUpdateType = 2;
        ((AssistInfo)this.mAssistInfos.get(i)).mAssistType = paramInt2;
        AssistInfo localAssistInfo = (AssistInfo)this.mAssistInfos.get(i);
        paramInt1 = paramInt3;
        if (paramInt3 >= 95) {
          paramInt1 = 100;
        }
        localAssistInfo.mProgress = paramInt1;
        paramInt1 = i;
      }
    }
    return paramInt1;
  }
  
  private int updateAssistInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      return -1;
    case 1: 
      paramInt1 = getResourceIdByType(paramInt2, paramInt3);
      LogUtil.e(TAG, "AssistantIconUpdate UPDATE_TYPE_SHOW! nAssistType:" + paramInt2 + ",nSpeed:" + paramInt3);
      return recieveShowInfo(paramInt1, paramInt2, paramInt3);
    case 2: 
      LogUtil.e(TAG, "AssistantIconUpdate UPDATE_TYPE_UPDATE! nAssistType:" + paramInt2 + ",nSpeed:" + paramInt3);
      return recieveUpdateInfo(0, paramInt2, paramInt3);
    }
    LogUtil.e(TAG, "AssistantIconUpdate UPDATE_TYPE_HIDE! nAssistType:" + paramInt2 + ",nSpeed:" + paramInt3);
    return recieveHideInfo(0, paramInt2, paramInt3);
  }
  
  public AssistInfo getAssistInfo(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mAssistInfos.size())) {
      return (AssistInfo)this.mAssistInfos.get(paramInt);
    }
    return null;
  }
  
  public double getCarProgress()
  {
    return this.mCurCarDriveProgress;
  }
  
  public int getCurCarPointRoadCondition()
  {
    List localList = getRoadConditionData();
    if (localList == null) {
      return -1;
    }
    int j = (int)(getCarProgress() * ((RoadConditionItem)localList.get(localList.size() - 1)).curItemEndIndex);
    int i = 0;
    while (i < localList.size())
    {
      if (j < ((RoadConditionItem)localList.get(i)).curItemEndIndex) {
        return ((RoadConditionItem)localList.get(i)).roadConditionType;
      }
      i += 1;
    }
    return -1;
  }
  
  public String getCurCarPointRoadConditionChineseWord()
  {
    switch (getCurCarPointRoadCondition())
    {
    default: 
      return "没有路况数据";
    case 1: 
      return "顺畅";
    case 2: 
      return "缓慢行驶";
    }
    return "拥堵";
  }
  
  public String getCurCarSpeed()
  {
    LogUtil.e(TAG, "getCurCarSpeed mIsGPSEnable = " + this.mIsGPSEnable + ", mIsGPSFix = " + this.mIsGPSFix);
    if ((this.mIsGPSEnable) && (this.mIsGPSFix)) {
      return "" + this.mCurCarSpeed;
    }
    return "- -";
  }
  
  public int getCurCarSpeedInt()
  {
    return this.mCurCarSpeed;
  }
  
  public int getCurLimitSpeed()
  {
    int j = 0;
    int i = 0;
    while (i < this.mAssistInfos.size())
    {
      if (((3 != ((AssistInfo)this.mAssistInfos.get(i)).mUpdateType) && (8 == ((AssistInfo)this.mAssistInfos.get(i)).mAssistType)) || (11 == ((AssistInfo)this.mAssistInfos.get(i)).mAssistType)) {
        j = ((AssistInfo)this.mAssistInfos.get(i)).mSpeedLimit / 1000;
      }
      i += 1;
    }
    return j;
  }
  
  public Bundle getLastestData()
  {
    return this.mLastestData;
  }
  
  public boolean getMainAuxiliary()
  {
    return this.mMainAuxiliary;
  }
  
  public int getResourceIdByType(int paramInt1, int paramInt2)
  {
    return AssistantMapTypeConstDefine.getResourceIdByType(paramInt1, paramInt2);
  }
  
  public List<RoadConditionItem> getRoadConditionData()
  {
    this.mLastRefreshRoadConditionTime = System.currentTimeMillis();
    List localList = BNRouteGuider.getInstance().getRoadCondition();
    Object localObject;
    if ((localList == null) || (localList.size() == 0))
    {
      localObject = null;
      return (List<RoadConditionItem>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= localList.size()) {
        break;
      }
      localObject = (Bundle)localList.get(i);
      if ((((Bundle)localObject).containsKey("unEndShapeIdx")) && (((Bundle)localObject).containsKey("enRoadCondition")))
      {
        int m = ((Bundle)localObject).getInt("unEndShapeIdx", -1);
        int k = ((Bundle)localObject).getInt("enRoadCondition");
        int j;
        if (k >= 0)
        {
          j = k;
          if (k <= 4) {}
        }
        else
        {
          j = 0;
        }
        localObject = new RoadConditionItem();
        ((RoadConditionItem)localObject).curItemEndIndex = m;
        ((RoadConditionItem)localObject).roadConditionType = j;
        localArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public boolean isCarSpeedRight()
  {
    return (this.mIsGPSEnable) && (this.mIsGPSFix);
  }
  
  public boolean isOverSpeed()
  {
    if (this.mOverSpeed == -1) {}
    while (this.mCurCarSpeed <= this.mOverSpeed) {
      return false;
    }
    return true;
  }
  
  public boolean isTimeToRefreshRoadCondition()
  {
    if (this.mLastRefreshRoadConditionTime <= 0L) {}
    while (System.currentTimeMillis() - this.mLastRefreshRoadConditionTime > 60000L) {
      return true;
    }
    return false;
  }
  
  public void reset()
  {
    LogUtil.e(TAG, "reset");
    this.mMainAuxiliary = false;
    this.mCurCarDriveProgress = 0.0D;
    this.mLastRefreshRoadConditionTime = -1L;
    this.mCurCarSpeed = 0;
    this.mOverSpeed = -1;
    if (this.mAssistInfos != null) {
      this.mAssistInfos.clear();
    }
    if (this.mLastestData != null) {
      this.mLastestData.clear();
    }
  }
  
  public Bundle updateAssistData(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLastestData.clear();
    this.mLastestData.putInt("updatetype", paramInt1);
    this.mLastestData.putInt("assisttype", paramInt2);
    this.mLastestData.putInt("speed", paramInt3);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_assist_index", updateAssistInfo(paramInt1, paramInt2, paramInt3));
    return localBundle;
  }
  
  public void updateCarProgress()
  {
    this.mCurCarDriveProgress = BNRouteGuider.getInstance().getCarProgress();
  }
  
  public void updateCurCarSpeed(double paramDouble)
  {
    paramDouble *= 3.6D;
    LogUtil.e(TAG, "updateCurCarSpeed realSpeed = " + paramDouble);
    if (paramDouble < 30.0D) {
      paramDouble += paramDouble / 10.0D;
    }
    for (;;)
    {
      this.mCurCarSpeed = ((int)paramDouble);
      LogUtil.e(TAG, "updateCurCarSpeed mCurCarSpeed = " + this.mCurCarSpeed);
      return;
      if ((paramDouble >= 30.0D) && (paramDouble < 80.0D)) {
        paramDouble += 3.0D;
      } else if ((paramDouble >= 80.0D) && (paramDouble < 100.0D)) {
        paramDouble += 4.0D;
      } else {
        paramDouble += 5.0D;
      }
    }
  }
  
  public void updateMainAuxiliary(boolean paramBoolean)
  {
    this.mMainAuxiliary = paramBoolean;
  }
  
  public static class AssistInfo
    implements Comparable<AssistInfo>
  {
    public int mAssistType;
    public int mIconResId;
    public int mProgress;
    public int mSpeedLimit;
    public int mUpdateType;
    
    public AssistInfo cloneTo()
    {
      AssistInfo localAssistInfo = new AssistInfo();
      localAssistInfo.mUpdateType = this.mUpdateType;
      localAssistInfo.mAssistType = this.mAssistType;
      localAssistInfo.mSpeedLimit = this.mSpeedLimit;
      localAssistInfo.mProgress = this.mProgress;
      localAssistInfo.mIconResId = this.mIconResId;
      return localAssistInfo;
    }
    
    public int compareTo(AssistInfo paramAssistInfo)
    {
      int i = this.mAssistType - paramAssistInfo.mAssistType;
      if (i > 0) {
        return 1;
      }
      if (i < 0) {
        return -1;
      }
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (AssistInfo)paramObject;
      } while (this.mAssistType == ((AssistInfo)paramObject).mAssistType);
      return false;
    }
    
    public int hashCode()
    {
      return this.mAssistType + 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AssistType: ").append(this.mAssistType).append(" SpeedLimit: ").append(this.mSpeedLimit);
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface EnlargeMapI
  {
    public static final int DEFAULT_TYPE = 0;
    public static final int ENLARGE_TYPE = 1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGAssistGuideModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */