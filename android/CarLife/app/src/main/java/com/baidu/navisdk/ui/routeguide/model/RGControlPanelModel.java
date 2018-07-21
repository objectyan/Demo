package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.NaviStatItem;

public class RGControlPanelModel
{
  public static final int ADJUST_LEVEL = 0;
  public static final int Control_Manual_Panel_Auto_Hide_Timeout = 10000;
  public static final int INVALID = -1;
  public static final int LOCATE_STATUS_CAR_3D = 1;
  public static final int LOCATE_STATUS_LOC_CAR = 3;
  public static final int LOCATE_STATUS_NORTH_2D = 2;
  public static final int LOCATE_STATUS_QUIT_NAV = 4;
  public static final long LocView_Auto_Hide_Timeout = 5500L;
  public static final int NOT_ADJUST_LEVEL = 1;
  private static final String TAG = "RGControlPanelModel";
  private static RGControlPanelModel mInstance = null;
  public static boolean mIsMenuMoreVisible = false;
  public static boolean mIsMenuVisible = false;
  public static boolean mIsRouteSearchVisible = false;
  public static boolean sIsBlueToothUSBGuideVisible = false;
  public static boolean sIsRouteSortViewVisible = false;
  private int mCurLocateStatus;
  private boolean mHasChangeLevel = false;
  private boolean mIsAnologPlaying = true;
  private boolean mIsConfigChange = false;
  private boolean mIsFullviewBeforeEnlargeMap = false;
  private boolean mIsFullviewState = false;
  private boolean mIsParkSearching = false;
  private int mLevelBeforeParkSerach = 18;
  public boolean mNeedAnimForFullview = true;
  private String navState = "NAV_STATE_NAVING";
  public int sAdjustLevel = -1;
  
  public static RGControlPanelModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGControlPanelModel();
    }
    return mInstance;
  }
  
  public boolean getFullviewState()
  {
    return this.mIsFullviewState;
  }
  
  public int getLocateStatus()
  {
    return this.mCurLocateStatus;
  }
  
  public String getNavState()
  {
    return this.navState;
  }
  
  public int getmLevelBeforeParkSerach()
  {
    return this.mLevelBeforeParkSerach;
  }
  
  public boolean isAnologPlaying()
  {
    return this.mIsAnologPlaying;
  }
  
  public boolean isNeedAdjustLevel()
  {
    return this.sAdjustLevel == 0;
  }
  
  public boolean ismHasChangeLevel()
  {
    return this.mHasChangeLevel;
  }
  
  public boolean ismIsConfigChange()
  {
    return this.mIsConfigChange;
  }
  
  public boolean ismIsFullviewBeforeEnlargeMap()
  {
    return this.mIsFullviewBeforeEnlargeMap;
  }
  
  public boolean ismIsParkSearching()
  {
    return this.mIsParkSearching;
  }
  
  public void reset()
  {
    LogUtil.e("RGControlPanelModel", "reset");
    this.mIsAnologPlaying = true;
    resetAdjustLevel();
  }
  
  public void resetAdjustLevel()
  {
    this.sAdjustLevel = -1;
  }
  
  public void setNavState(String paramString)
  {
    this.navState = paramString;
  }
  
  public void setmHasChangeLevel(boolean paramBoolean)
  {
    this.mHasChangeLevel = paramBoolean;
  }
  
  public void setmIsConfigChange(boolean paramBoolean)
  {
    this.mIsConfigChange = paramBoolean;
  }
  
  public void setmIsFullviewBeforeEnlargeMap(boolean paramBoolean)
  {
    this.mIsFullviewBeforeEnlargeMap = paramBoolean;
  }
  
  public void setmIsParkSearching(boolean paramBoolean)
  {
    this.mIsParkSearching = paramBoolean;
  }
  
  public void setmLevelBeforeParkSerach(int paramInt)
  {
    this.mLevelBeforeParkSerach = paramInt;
  }
  
  public void updateAnologPlaying(boolean paramBoolean)
  {
    this.mIsAnologPlaying = paramBoolean;
  }
  
  public void updateFullviewState(boolean paramBoolean)
  {
    if (paramBoolean) {
      NaviStatItem.getInstance().setStartFullViewTime();
    }
    for (;;)
    {
      this.mIsFullviewState = paramBoolean;
      return;
      NaviStatItem.getInstance().setFullViewRealTime();
    }
  }
  
  public void updateLocateStatus(int paramInt)
  {
    this.mCurLocateStatus = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGControlPanelModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */