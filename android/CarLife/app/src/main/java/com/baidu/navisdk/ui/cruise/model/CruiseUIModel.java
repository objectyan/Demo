package com.baidu.navisdk.ui.cruise.model;

import com.baidu.navisdk.model.datastruct.LocData;

public class CruiseUIModel
{
  private static CruiseUIModel mInstance = null;
  private int mAssistType;
  private int mCameraDistance;
  private int mCameraIconResID;
  private String mCameraName;
  private int mCameraProgress;
  private int mCameraSpeed;
  private CruiseState mCruiseState = CruiseState.NORMAL;
  private String mCurrentRoadName;
  private int mCurrentSpeed;
  private boolean mIsConneted = false;
  private boolean mIsDayStyle = true;
  private boolean mIsProvinceDataDownloaded = false;
  private boolean mIsShowingMenu = false;
  private LocData mLastLocData;
  private int mSatelliteNum;
  
  public static CruiseUIModel getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new CruiseUIModel();
      }
      CruiseUIModel localCruiseUIModel = mInstance;
      return localCruiseUIModel;
    }
    finally {}
  }
  
  public int getAssistType()
  {
    return this.mAssistType;
  }
  
  public int getCameraDistance()
  {
    return this.mCameraDistance;
  }
  
  public int getCameraIconResID()
  {
    return this.mCameraIconResID;
  }
  
  public String getCameraName()
  {
    return this.mCameraName;
  }
  
  public int getCameraProgress()
  {
    return this.mCameraProgress;
  }
  
  public int getCameraSpeed()
  {
    return this.mCameraSpeed;
  }
  
  public CruiseState getCruiseState()
  {
    return this.mCruiseState;
  }
  
  public String getCurrentRoadName()
  {
    return this.mCurrentRoadName;
  }
  
  public int getCurrentSpeed()
  {
    return this.mCurrentSpeed;
  }
  
  public LocData getLastLocationData()
  {
    return this.mLastLocData;
  }
  
  public int getSatelliteNum()
  {
    return this.mSatelliteNum;
  }
  
  public boolean isConnected()
  {
    return this.mIsConneted;
  }
  
  public boolean isIsDayStyle()
  {
    return this.mIsDayStyle;
  }
  
  public boolean isProvinceDataDownloaded()
  {
    return this.mIsProvinceDataDownloaded;
  }
  
  public boolean isShowingMenu()
  {
    return this.mIsShowingMenu;
  }
  
  public void reset()
  {
    this.mAssistType = 0;
    this.mCameraIconResID = 0;
    this.mCameraSpeed = 0;
    this.mCameraName = null;
    this.mCameraDistance = 0;
    this.mCameraProgress = 0;
    this.mCurrentSpeed = 0;
    this.mCruiseState = CruiseState.NORMAL;
    this.mSatelliteNum = 0;
    this.mCurrentRoadName = null;
    this.mIsDayStyle = true;
    this.mIsShowingMenu = false;
  }
  
  public void setAssistType(int paramInt)
  {
    this.mAssistType = paramInt;
  }
  
  public void setCameraDistance(int paramInt)
  {
    this.mCameraDistance = paramInt;
  }
  
  public void setCameraIconResID(int paramInt)
  {
    this.mCameraIconResID = paramInt;
  }
  
  public void setCameraName(String paramString)
  {
    this.mCameraName = paramString;
  }
  
  public void setCameraProgress(int paramInt)
  {
    this.mCameraProgress = paramInt;
  }
  
  public void setCameraSpeed(int paramInt)
  {
    this.mCameraSpeed = paramInt;
  }
  
  public void setConnected(boolean paramBoolean)
  {
    this.mIsConneted = paramBoolean;
  }
  
  public void setCruiseState(CruiseState paramCruiseState)
  {
    this.mCruiseState = paramCruiseState;
  }
  
  public void setCurrentRoadName(String paramString)
  {
    this.mCurrentRoadName = paramString;
  }
  
  public void setCurrentSpeed(int paramInt)
  {
    this.mCurrentSpeed = paramInt;
  }
  
  public void setIsDayStyle(boolean paramBoolean)
  {
    this.mIsDayStyle = paramBoolean;
  }
  
  public void setIsShowingMenu(boolean paramBoolean)
  {
    this.mIsShowingMenu = paramBoolean;
  }
  
  public void setLastLocationData(LocData paramLocData)
  {
    this.mLastLocData = paramLocData;
  }
  
  public void setProvinceDataDownloaded(boolean paramBoolean)
  {
    this.mIsProvinceDataDownloaded = paramBoolean;
  }
  
  public void setSatelliteNum(int paramInt)
  {
    this.mSatelliteNum = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/model/CruiseUIModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */