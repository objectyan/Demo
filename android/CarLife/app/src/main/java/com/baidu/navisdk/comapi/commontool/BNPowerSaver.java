package com.baidu.navisdk.comapi.commontool;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class BNPowerSaver
  extends BNSubject
{
  private static final int CHECK_BATTERY_INTERVAL = 60000;
  public static final int SAVE_MODE_BATTERY_LEVEL = 35;
  private static final String TAG = "PowerSaver";
  public static final int TYPE_START_POWER_SAVE_MODE = 1;
  public static final int TYPE_STOP_POWER_SAVE_MODE = 2;
  private boolean isSettingsWriteAuth = true;
  private Activity mActivity;
  private int mBatteryLevel = 0;
  private BatteryReceiver mBatteryReceiver;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage) {}
  };
  private boolean mIsAutoBrightnessBeforeInSaveMode = false;
  private boolean mIsBatteryCharging = false;
  private boolean mIsInit = false;
  private boolean mIsPowerSaveMode = false;
  private int mMode = 0;
  private BNWorkerNormalTask mOnBatteryChangedTask = new BNWorkerNormalTask("mOnBatteryChangedTask", null)
  {
    protected String execute()
    {
      BNPowerSaver.this.unregisterBatteryReceiver();
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("OnBatteryChangedTask-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNPowerSaver.this.registerBatteryReceiver();
          return null;
        }
      }, new BNWorkerConfig(100, 0), 60000L);
      if ((BNPowerSaver.this.mMode != 0) || ((!BNPowerSaver.this.mIsPowerSaveMode) || ((BNPowerSaver.this.mBatteryLevel >= 35) || (BNPowerSaver.this.mIsBatteryCharging)))) {}
      for (;;)
      {
        try
        {
          BNPowerSaver.this.stopSaveMode();
          return null;
        }
        catch (Throwable localThrowable2) {}
        if ((BNPowerSaver.this.mBatteryLevel < 35) && (!BNPowerSaver.this.mIsBatteryCharging)) {
          try
          {
            BNPowerSaver.this.startSaveMode();
            if (!BNOffScreenManager.sIsModelueActive)
            {
              if (BNSettingManager.getVoiceMode() != 2)
              {
                TipTool.onCreateToastDialog(BNPowerSaver.this.mActivity, BNStyleManager.getString(1711669515));
                return null;
              }
            }
            else if (BNOffScreenManager.getInstance().canEnterOffScreenState())
            {
              if (BNOffScreenManager.getInstance().isOffScreenDelaying)
              {
                BNOffScreenManager.getInstance().isOffScreenDelaying = false;
                return null;
              }
              if (!BNOffScreenManager.getInstance().isInCheckingTime)
              {
                BNOffScreenManager.getInstance().enterOffScreenState();
                return null;
              }
            }
            else if (BNOffScreenManager.sIsInNavi)
            {
              TipTool.onCreateToastDialog(BNPowerSaver.this.mActivity, BNStyleManager.getString(1711670257));
              return null;
              if (BNPowerSaver.this.mMode == 1) {
                return null;
              }
            }
          }
          catch (Throwable localThrowable1) {}
        }
      }
      return null;
    }
  };
  
  public static int getBrightness(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        int i = Settings.System.getInt(paramContext.getContentResolver(), "screen_brightness");
        return i;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return 0;
  }
  
  public static BNPowerSaver getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  public static boolean isAutoBrightness(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        int i = Settings.System.getInt(paramContext.getContentResolver(), "screen_brightness_mode");
        return i == 1;
      }
      catch (Settings.SettingNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  /* Error */
  private void registerBatteryReceiver()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 94	com/baidu/navisdk/comapi/commontool/BNPowerSaver:mActivity	Landroid/app/Activity;
    //   6: ifnull +53 -> 59
    //   9: aload_0
    //   10: getfield 151	com/baidu/navisdk/comapi/commontool/BNPowerSaver:mBatteryReceiver	Lcom/baidu/navisdk/comapi/commontool/BNPowerSaver$BatteryReceiver;
    //   13: ifnonnull +46 -> 59
    //   16: ldc 27
    //   18: ldc -104
    //   20: invokestatic 158	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: new 160	android/content/IntentFilter
    //   26: dup
    //   27: ldc -94
    //   29: invokespecial 165	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_0
    //   34: new 12	com/baidu/navisdk/comapi/commontool/BNPowerSaver$BatteryReceiver
    //   37: dup
    //   38: aload_0
    //   39: aconst_null
    //   40: invokespecial 168	com/baidu/navisdk/comapi/commontool/BNPowerSaver$BatteryReceiver:<init>	(Lcom/baidu/navisdk/comapi/commontool/BNPowerSaver;Lcom/baidu/navisdk/comapi/commontool/BNPowerSaver$1;)V
    //   43: putfield 151	com/baidu/navisdk/comapi/commontool/BNPowerSaver:mBatteryReceiver	Lcom/baidu/navisdk/comapi/commontool/BNPowerSaver$BatteryReceiver;
    //   46: aload_0
    //   47: getfield 94	com/baidu/navisdk/comapi/commontool/BNPowerSaver:mActivity	Landroid/app/Activity;
    //   50: aload_0
    //   51: getfield 151	com/baidu/navisdk/comapi/commontool/BNPowerSaver:mBatteryReceiver	Lcom/baidu/navisdk/comapi/commontool/BNPowerSaver$BatteryReceiver;
    //   54: aload_1
    //   55: invokevirtual 174	android/app/Activity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   58: pop
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: goto -9 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	BNPowerSaver
    //   32	23	1	localIntentFilter	android.content.IntentFilter
    //   62	4	1	localObject	Object
    //   67	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	46	62	finally
    //   46	59	62	finally
    //   46	59	67	java/lang/Exception
  }
  
  public static void saveBrightness(Context paramContext, int paramInt)
  {
    Uri localUri;
    if (paramContext != null)
    {
      paramContext = paramContext.getContentResolver();
      localUri = Settings.System.getUriFor("screen_brightness");
    }
    try
    {
      Settings.System.putInt(paramContext, "screen_brightness", paramInt);
      paramContext.notifyChange(localUri, null);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static void setBrightness(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null)
    {
      WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
      localLayoutParams.screenBrightness = (Float.valueOf(paramInt).floatValue() * 0.003921569F);
      paramActivity.getWindow().setAttributes(localLayoutParams);
    }
  }
  
  private void startSaveMode()
  {
    LogUtil.e("PowerSaver", "startSaveMode: isPowerSaveMode " + this.mIsPowerSaveMode);
    if (!this.mIsPowerSaveMode)
    {
      this.mIsPowerSaveMode = true;
      BNOffScreenManager.testPrint("offScreen", "startSaveMode");
      notifyObservers(1, this.mBatteryLevel, null);
      BNMapController.getInstance().setAnimationGlobalSwitch(false);
      this.mIsAutoBrightnessBeforeInSaveMode = isAutoBrightness(this.mActivity);
      if (!this.mIsAutoBrightnessBeforeInSaveMode) {
        BNaviModuleManager.mapToNaviSaveMode(this.mActivity, 1);
      }
    }
  }
  
  private void stopSaveMode()
  {
    LogUtil.e("PowerSaver", "stopSaveMode: isPowerSaveMode " + this.mIsPowerSaveMode);
    if (this.mIsPowerSaveMode)
    {
      this.mIsPowerSaveMode = false;
      notifyObservers(2, this.mBatteryLevel, null);
      BNMapController.getInstance().setAnimationGlobalSwitch(true);
      if (!this.mIsAutoBrightnessBeforeInSaveMode) {
        BNaviModuleManager.mapToNaviSaveMode(this.mActivity, 0);
      }
    }
  }
  
  /* Error */
  private void unregisterBatteryReceiver()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 94	com/baidu/navisdk/comapi/commontool/BNPowerSaver:mActivity	Landroid/app/Activity;
    //   6: ifnull +34 -> 40
    //   9: aload_0
    //   10: getfield 151	com/baidu/navisdk/comapi/commontool/BNPowerSaver:mBatteryReceiver	Lcom/baidu/navisdk/comapi/commontool/BNPowerSaver$BatteryReceiver;
    //   13: ifnull +27 -> 40
    //   16: ldc 27
    //   18: ldc_w 270
    //   21: invokestatic 158	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: getfield 94	com/baidu/navisdk/comapi/commontool/BNPowerSaver:mActivity	Landroid/app/Activity;
    //   28: aload_0
    //   29: getfield 151	com/baidu/navisdk/comapi/commontool/BNPowerSaver:mBatteryReceiver	Lcom/baidu/navisdk/comapi/commontool/BNPowerSaver$BatteryReceiver;
    //   32: invokevirtual 274	android/app/Activity:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 151	com/baidu/navisdk/comapi/commontool/BNPowerSaver:mBatteryReceiver	Lcom/baidu/navisdk/comapi/commontool/BNPowerSaver$BatteryReceiver;
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_1
    //   49: goto -14 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	BNPowerSaver
    //   43	4	1	localObject	Object
    //   48	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	24	43	finally
    //   24	35	43	finally
    //   35	40	43	finally
    //   24	35	48	java/lang/Exception
  }
  
  public int getmBatteryLevel()
  {
    return this.mBatteryLevel;
  }
  
  public void init(Activity paramActivity)
  {
    if ((!this.mIsInit) && (paramActivity != null))
    {
      this.mActivity = paramActivity;
      this.mMode = BNSettingManager.getPowerSaveMode();
      this.mIsInit = true;
      updatePowerSaveMode(this.mMode);
    }
  }
  
  public boolean isSettingsWriteAuth()
  {
    return this.isSettingsWriteAuth;
  }
  
  public boolean ismIsBatteryCharging()
  {
    return this.mIsBatteryCharging;
  }
  
  public void setSettingsWriteAuth(boolean paramBoolean)
  {
    this.isSettingsWriteAuth = paramBoolean;
  }
  
  public void uninit()
  {
    if (this.mIsInit)
    {
      unregisterBatteryReceiver();
      this.mHandler.removeCallbacksAndMessages(null);
      this.mIsInit = false;
    }
    try
    {
      stopSaveMode();
      this.mActivity = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void updatePowerSaveMode(int paramInt)
  {
    this.mMode = paramInt;
    if (this.mIsInit)
    {
      registerBatteryReceiver();
      if (paramInt != 0) {}
    }
    else
    {
      return;
    }
    if (paramInt == 1)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      try
      {
        startSaveMode();
        return;
      }
      catch (Throwable localThrowable1)
      {
        return;
      }
    }
    this.mHandler.removeCallbacksAndMessages(null);
    try
    {
      stopSaveMode();
      return;
    }
    catch (Throwable localThrowable2) {}
  }
  
  private class BatteryReceiver
    extends BroadcastReceiver
  {
    private BatteryReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      int j;
      if ("android.intent.action.BATTERY_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getExtras().getInt("level");
        j = paramIntent.getExtras().getInt("scale", 100);
        if ((100 != j) && (j != 0)) {
          break label174;
        }
        BNPowerSaver.access$302(BNPowerSaver.this, i);
        if (2 != paramIntent.getIntExtra("status", 1)) {
          break label192;
        }
        BNPowerSaver.access$402(BNPowerSaver.this, true);
        BNOffScreenManager.getInstance().onChargedAction();
      }
      for (;;)
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("BatteryReceiver-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            BCruiser.getInstance().setBatteryStatus(BNPowerSaver.this.mBatteryLevel, BNPowerSaver.this.mIsBatteryCharging);
            return null;
          }
        }, new BNWorkerConfig(100, 0));
        LogUtil.e("PowerSaver", "recv BATTERY_CHANGED: level " + i + ", charging " + BNPowerSaver.this.mIsBatteryCharging);
        return;
        label174:
        BNPowerSaver.access$302(BNPowerSaver.this, i * 100 / j);
        break;
        label192:
        BNPowerSaver.access$402(BNPowerSaver.this, false);
        if (BNOffScreenManager.sIsModelueActive)
        {
          LogUtil.e("offScreen", "late battery check");
          BNOffScreenManager.testPrint("offScreen", "late battery check");
          if (BNOffScreenManager.getInstance().canEnterOffScreenState())
          {
            if (BNOffScreenManager.getInstance().isOffScreenDelaying)
            {
              BNOffScreenManager.getInstance().isOffScreenDelaying = false;
              return;
            }
            if (!BNOffScreenManager.getInstance().isInCheckingTime) {
              BNOffScreenManager.getInstance().enterOffScreenState();
            }
          }
        }
      }
    }
  }
  
  private static class LazyHolder
  {
    private static BNPowerSaver sInstance = new BNPowerSaver(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/commontool/BNPowerSaver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */