package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.util.common.LogUtil;

public class RGCarPreferSettingController
{
  private static final String TAG = RGCarPreferSettingController.class.getSimpleName();
  private static RGCarPreferSettingController sInstance = null;
  public static boolean sIsSupportNoHighway = true;
  private static Object sObj = new Object();
  public boolean mIsSelectPlate = false;
  public int mLastRPPreferSetting = -1;
  
  public static RGCarPreferSettingController getInstance()
  {
    if (sInstance == null) {}
    synchronized (sObj)
    {
      if (sInstance == null) {
        sInstance = new RGCarPreferSettingController();
      }
      return sInstance;
    }
  }
  
  public int calcPreferenceValue(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((!paramBoolean) && ((paramInt1 & paramInt2) == 0)) {
      return paramInt1;
    }
    if (paramInt1 == 1)
    {
      paramInt1 = 0;
      if (!paramBoolean) {
        break label63;
      }
    }
    label63:
    for (paramInt2 = paramInt1 | paramInt2;; paramInt2 = paramInt1 ^ paramInt2)
    {
      paramInt1 = paramInt2;
      if (paramInt2 == 32) {
        paramInt1 = 33;
      }
      paramInt2 = paramInt1;
      if (paramInt1 == 0) {
        paramInt2 = 1;
      }
      return paramInt2;
      if (paramInt1 == 33)
      {
        paramInt1 = 32;
        break;
      }
      break;
    }
  }
  
  public boolean isCarLimitOpen()
  {
    return isOpenPrefer(32);
  }
  
  public boolean isOpenPrefer(int paramInt)
  {
    return (BNaviModuleManager.getLastPreferValue() & paramInt) != 0;
  }
  
  public boolean isRPPreferSettingValueChange(int paramInt)
  {
    if (this.mLastRPPreferSetting == -1) {}
    while (this.mLastRPPreferSetting == paramInt) {
      return false;
    }
    return true;
  }
  
  public void reset()
  {
    this.mIsSelectPlate = false;
    this.mLastRPPreferSetting = -1;
  }
  
  public void setCarLimitOpen(boolean paramBoolean)
  {
    BNaviModuleManager.resetPlateLimitCounter(paramBoolean);
    updatePreferValue(32, paramBoolean);
  }
  
  public void setLastRPPreferSettingValue(int paramInt)
  {
    this.mLastRPPreferSetting = paramInt;
  }
  
  public void updatePreferValue(int paramInt, boolean paramBoolean)
  {
    int i = BNaviModuleManager.getLastPreferValue();
    int j = calcPreferenceValue(i, paramInt, paramBoolean);
    BNaviModuleManager.setLastPreferValue(j);
    RGRouteSortController.getInstance().setPreferValue(j);
    BNRoutePlaner.getInstance().setCalcPrference(j);
    LogUtil.e(TAG, "updatePreferValue lastPreferValue = " + i + ", updatedPreferValue = " + j + ", changePrefer = " + paramInt + ", isPreferOpen = " + paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/control/RGCarPreferSettingController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */