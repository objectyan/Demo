package com.baidu.navisdk.model;

public class MainMapModel
{
  private static volatile MainMapModel mInstance;
  public boolean bFirstLoc = true;
  public boolean bFirstShowLoc;
  public boolean haveSensor = false;
  public float mAngleX = 0.0F;
  public float mAngleY = 0.0F;
  public float mAngleZ = 0.0F;
  public int mCurLatitude;
  public int mCurLocMode = 0;
  public int mCurLongitude;
  public int mFirstAutoLocMode = 1;
  public int mLastAngle = 64512;
  public double mLastLatitude = 0.0D;
  public int mLastLocMode = 0;
  public double mLastLongitude = 0.0D;
  public int mScreenRotation = 0;
  public boolean mbFirstMapviewContent = true;
  
  private int changeToNextLocMode()
  {
    this.mCurLocMode = getNextLocMode();
    return getCurLocMode();
  }
  
  public static MainMapModel getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new MainMapModel();
      }
      return mInstance;
    }
    finally {}
  }
  
  public int getCurLocMode()
  {
    return this.mCurLocMode;
  }
  
  public int getNextLocMode()
  {
    switch (getCurLocMode())
    {
    default: 
      return 0;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 1;
  }
  
  public int setLocMode(int paramInt)
  {
    if (paramInt == -1) {
      changeToNextLocMode();
    }
    for (;;)
    {
      return getCurLocMode();
      this.mCurLocMode = paramInt;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/MainMapModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */