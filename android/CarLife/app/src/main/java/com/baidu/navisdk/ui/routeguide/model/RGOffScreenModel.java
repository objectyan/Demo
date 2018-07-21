package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.util.common.LogUtil;

public class RGOffScreenModel
{
  public static final int MAX_COUNT = 5;
  public static final int MSG_CANCEL_COUNT = 3;
  public static final int MSG_STOP_COUNT = 2;
  public static final int MSG_TIME_COUNT = 1;
  private static RGOffScreenModel mInstance;
  public static int sCurrentMsgType = -1;
  public boolean isCurrentLocationActive = false;
  public boolean isInCounting = false;
  public int mOffScreenCount = 5;
  
  public static RGOffScreenModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGOffScreenModel();
    }
    return mInstance;
  }
  
  public boolean canEnterOffScreenShow()
  {
    boolean bool3 = true;
    if (!BNOffScreenManager.sIsModelueActive) {
      return false;
    }
    boolean bool4 = BNOffScreenManager.getInstance().canOffScreenShow();
    if (BNPowerSaver.getInstance().getmBatteryLevel() < 35)
    {
      bool1 = true;
      boolean bool2 = true;
      if (BNSettingManager.getPowerSaveMode() == 2) {
        bool2 = false;
      }
      boolean bool5 = BNPowerSaver.getInstance().ismIsBatteryCharging();
      boolean bool6 = BNOffScreenManager.sIsBrightOffEffect;
      LogUtil.e("offScreen", "ret 0 ,ret2, ret3, ret4 , ret5 is " + bool4 + bool1 + ", " + bool2 + "," + bool5 + "," + bool6);
      BNOffScreenManager.testPrint("offScreen", "ret 0,ret2, ret3, ret4 , ret5 is " + bool4 + bool1 + ", " + bool2 + "," + bool5 + "," + bool6);
      if ((!bool4) || (!bool1) || (!bool2) || (bool5) || (!bool6)) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGOffScreenModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */