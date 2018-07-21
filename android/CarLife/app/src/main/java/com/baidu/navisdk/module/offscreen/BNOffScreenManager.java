package com.baidu.navisdk.module.offscreen;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.provider.Settings.System;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGOffScreenModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class BNOffScreenManager
{
  public static final String MODULE_NAME = "offScreen";
  private static BNOffScreenManager mInstance = null;
  public static boolean sIsBrightOffEffect;
  public static boolean sIsInNavi = false;
  public static boolean sIsInOffScreenMode;
  public static boolean sIsModelueActive = false;
  public static boolean sIsReallyLeave;
  private static long sLastEnterTime = -100000L;
  public boolean isEnterOffScreen = false;
  public boolean isInCheckingTime = false;
  public boolean isOffScreenDelaying = false;
  private float mHalfBright = 102.0F;
  private Handler mHandler = new Handler();
  private IOffScreenListener mOffScreenListener;
  
  static
  {
    sIsInOffScreenMode = false;
    sIsBrightOffEffect = false;
    sIsReallyLeave = false;
  }
  
  private void backResetBrightness()
  {
    Context localContext = BNaviModuleManager.getContext();
    if (localContext != null) {
      try
      {
        if (Settings.System.getInt(localContext.getContentResolver(), "screen_brightness_mode") == 1)
        {
          int i = (int)(BNOffScreenParams.BACK_AUTO_BRIGHTNESS * 255.0F);
          LogUtil.e("MODULE_NAME", "backResetBrightness mode is automode bright ness is " + i);
          BNPowerSaver.setBrightness(BNaviModuleManager.getNaviActivity(), i);
          return;
        }
        BNPowerSaver.setBrightness(BNaviModuleManager.getNaviActivity(), BNSettingManager.getNormalBrightness());
        LogUtil.e("MODULE_NAME", "backResetBrightness mode is mannully mode bright ness is " + BNSettingManager.getNormalBrightness());
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private void darkScreen()
  {
    setOffScreenBackground(true);
  }
  
  public static String getCallStack()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      int i = 0;
      while (i < arrayOfStackTraceElement.length)
      {
        localStringBuffer.append("at " + arrayOfStackTraceElement[i].getClassName() + "." + arrayOfStackTraceElement[i].getMethodName() + "(" + arrayOfStackTraceElement[i].getFileName() + ":" + arrayOfStackTraceElement[i].getLineNumber() + ")\n");
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static BNOffScreenManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNOffScreenManager();
    }
    return mInstance;
  }
  
  private static String makeLogDetailInfoString(String paramString1, String paramString2, StackTraceElement paramStackTraceElement)
  {
    paramString1 = "[" + paramString1 + "]-" + paramStackTraceElement.getFileName() + "(" + paramStackTraceElement.getLineNumber() + "): ";
    return paramString1 + paramString2;
  }
  
  public static void printCallStatck()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      testPrint("printCallStatck", "----start----");
      int i = 0;
      while (i < arrayOfStackTraceElement.length)
      {
        testPrint("printCallStatck", "at " + arrayOfStackTraceElement[i].getClassName() + "." + arrayOfStackTraceElement[i].getMethodName() + "(" + arrayOfStackTraceElement[i].getFileName() + ":" + arrayOfStackTraceElement[i].getLineNumber() + ")\n");
        i += 1;
      }
      testPrint("printCallStatck", "----end----");
    }
  }
  
  public static void test()
  {
    LogUtil.e("offScreen", "start test");
  }
  
  public static void testPrint(String paramString1, String paramString2) {}
  
  public void backToNormalGuide()
  {
    BNPowerSaver.setBrightness(BNaviModuleManager.getNaviActivity(), BNSettingManager.getNormalBrightness());
  }
  
  public boolean canEnterOffScreenState()
  {
    boolean bool3 = true;
    if (!sIsModelueActive) {
      return false;
    }
    boolean bool4 = canOffScreenShow();
    if (BNPowerSaver.getInstance().getmBatteryLevel() < 35)
    {
      bool1 = true;
      boolean bool2 = true;
      if (BNSettingManager.getPowerSaveMode() == 2) {
        bool2 = false;
      }
      boolean bool5 = BNPowerSaver.getInstance().ismIsBatteryCharging();
      boolean bool6 = sIsBrightOffEffect;
      LogUtil.e("offScreen", "manger ret 0 ,ret2, ret3, ret4 , ret5 is " + bool4 + bool1 + ", " + bool2 + "," + bool5 + "," + bool6);
      testPrint("offScreen", "manager ret 0,ret2, ret3, ret4 , ret5 is " + bool4 + bool1 + ", " + bool2 + "," + bool5 + "," + bool6);
      if ((!bool4) || (!bool1) || (!bool2) || (bool5) || (!bool6)) {
        break label201;
      }
    }
    label201:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public boolean canOffScreenShow()
  {
    return !RGMapModeViewController.getInstance().getHudShowStatus();
  }
  
  public void enterOffScreenState()
  {
    if ((this.isInCheckingTime) || (RGOffScreenModel.getInstance().isInCounting) || (sIsInOffScreenMode))
    {
      testPrint("offScreen", "failed enterOffScreenState , isInCheckingTime is , isInCounting is , sIsInOffScreenMode " + this.isInCheckingTime + RGOffScreenModel.getInstance().isInCounting);
      LogUtil.e("offScreen", "failed enterOffScreenState , isInCheckingTime is , isInCounting is , sIsInOffScreenMode " + this.isInCheckingTime + RGOffScreenModel.getInstance().isInCounting);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = sLastEnterTime;
    sLastEnterTime = l1;
    if (l1 - l2 < 10000L)
    {
      testPrint("offScreen", "time stop it");
      return;
    }
    test();
    this.isInCheckingTime = true;
    LogUtil.e("offScreen", "enter in enterOffScreenState");
    testPrint("offScreen", "enter in enterOffScreenState");
    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("enterOffScreenState-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        TTSPlayerControl.playTTS("电量低是否进入黑屏导航", 0);
        return null;
      }
    }, new BNWorkerConfig(2, 0));
    RGOffScreenModel.getInstance().isCurrentLocationActive = true;
    RGMapModeViewController.getInstance().requestShowExpendView(1, true);
    this.isInCheckingTime = false;
  }
  
  protected void exitOffScreenState()
  {
    BNPowerSaver.setBrightness(BNaviModuleManager.getNaviActivity(), (int)this.mHalfBright);
    BNMapController.getInstance().onResume();
    setOffScreenBackground(false);
    sIsInOffScreenMode = false;
    this.isOffScreenDelaying = false;
  }
  
  public void handeMsgBrightAction(int paramInt)
  {
    if (!sIsModelueActive) {
      return;
    }
    if (RGOffScreenModel.getInstance().isInCounting)
    {
      testPrint("offScreen", "handeMsgBrightAction isincounting");
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("HandeMsgBrightAction-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          if ((BNOffScreenManager.sIsInOffScreenMode) && (RGOffScreenModel.sCurrentMsgType == 2))
          {
            BNOffScreenManager.testPrint("offScreen", "handeMsgBrightAction in it,haha");
            BNOffScreenManager.this.handleOffScreenMsg(2);
          }
          return null;
        }
      }, new BNWorkerConfig(2, 0), 6000L);
      return;
    }
    handleOffScreenMsg(2);
  }
  
  public void handleExitOffScreen()
  {
    if ((!sIsModelueActive) || (!sIsInOffScreenMode)) {}
    do
    {
      return;
      LogUtil.e("offScreen", "handleExitOffScreen");
      testPrint("offScreen", "handleExitOffScreen");
      exitOffScreenState();
    } while (sIsReallyLeave);
    LogUtil.e("offScreen", "not sIsReallyLeave");
    testPrint("offScreen", "not sIsReallyLeave");
    this.isOffScreenDelaying = true;
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("HandleExitOffScreen-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        BNOffScreenManager.this.isOffScreenDelaying = false;
        if (BNOffScreenManager.this.canEnterOffScreenState()) {
          BNOffScreenManager.this.enterOffScreenState();
        }
        return null;
      }
    }, new BNWorkerConfig(2, 0), 30000L);
  }
  
  public void handleOffScreenInterupt(boolean paramBoolean)
  {
    if ((!sIsModelueActive) || (!sIsInOffScreenMode)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = BNaviModuleManager.getNaviActivity();
      if (paramBoolean)
      {
        BNPowerSaver.setBrightness(localActivity, (int)(BNOffScreenParams.OFF_INTERUPT_BRIGHTNESS * 255.0F));
        return;
      }
    } while (!sIsInOffScreenMode);
    BNPowerSaver.setBrightness(localActivity, (int)(BNOffScreenParams.OFF_MIN_BRIGHTNESS * 255.0F));
  }
  
  public void handleOffScreenMsg(int paramInt)
  {
    if (paramInt == 1) {
      if (canEnterOffScreenState()) {
        enterOffScreenState();
      }
    }
    while (paramInt != 2) {
      return;
    }
    handleExitOffScreen();
  }
  
  public void initOffScreen()
  {
    BNSettingManager.setNormalBrightness(BNPowerSaver.getBrightness(BNaviModuleManager.getNaviActivity()));
    testPrint("offScreen", "initOffScreen");
    sIsInNavi = true;
    this.isEnterOffScreen = false;
  }
  
  public void offScreenAction()
  {
    LogUtil.e("offScreen", "original brightness is " + BNPowerSaver.getBrightness(BNaviModuleManager.getNaviActivity()));
    sIsInOffScreenMode = true;
    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("offScreenAction-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        TTSPlayerControl.playTTS("电量低是否进入黑屏导航", 0);
        return null;
      }
    }, new BNWorkerConfig(2, 0));
    BNPowerSaver.setBrightness(BNaviModuleManager.getNaviActivity(), (int)(BNOffScreenParams.OFF_MIN_BRIGHTNESS * 255.0F));
    BNMapController.getInstance().onPause();
    darkScreen();
  }
  
  public void onChargedAction()
  {
    if ((!sIsModelueActive) || (!sIsInOffScreenMode)) {
      return;
    }
    sIsReallyLeave = true;
    LogUtil.e("offScreen", "onChargedAction");
    testPrint("offScreen", "onChargedAction");
    setOffScreenBackground(false);
    backToNormalGuide();
    BNMapController.getInstance().onResume();
    sIsInOffScreenMode = false;
    RGOffScreenModel.getInstance().isCurrentLocationActive = false;
  }
  
  public void setOffScreenBackground(boolean paramBoolean)
  {
    if (this.mOffScreenListener != null) {
      this.mOffScreenListener.setOffScreenBackground(paramBoolean);
    }
  }
  
  public void setOffScreenListener(IOffScreenListener paramIOffScreenListener)
  {
    this.mOffScreenListener = paramIOffScreenListener;
  }
  
  public void uninitOffScreen()
  {
    RGOffScreenModel.getInstance().isCurrentLocationActive = false;
    sIsReallyLeave = true;
    sIsInOffScreenMode = false;
    sIsBrightOffEffect = false;
    setOffScreenBackground(false);
    if (this.isEnterOffScreen) {
      backResetBrightness();
    }
    testPrint("offScreen", "uninit off screen");
    test();
    testPrint("offScreen", "uninitOffScreen");
    sIsInNavi = false;
  }
  
  public static abstract interface IOffScreenListener
  {
    public abstract boolean setOffScreenBackground(boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/offscreen/BNOffScreenManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */