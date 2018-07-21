package com.baidu.navisdk.ui.cruise.model;

import android.os.Bundle;

public class CruiseCameraType
{
  public static final int UPDATE_TYPE_HIDE = 3;
  public static final int UPDATE_TYPE_SHOW = 1;
  public static final int UPDATE_TYPE_UPDATE = 2;
  private int mCameraType;
  private int mSpeed;
  private int mUpdateType;
  
  public CruiseCameraType(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mUpdateType = paramInt1;
    this.mCameraType = paramInt2;
    this.mSpeed = paramInt3;
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("updatetype", this.mUpdateType);
    localBundle.putInt("assisttype", this.mCameraType);
    localBundle.putInt("speed", this.mSpeed);
    return localBundle;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/model/CruiseCameraType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */