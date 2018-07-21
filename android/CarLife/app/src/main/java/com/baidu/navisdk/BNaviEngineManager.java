package com.baidu.navisdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNINaviManager;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.model.datastruct.EngineCommonConfig;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.RespTimeStatItem;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comjni.engine.AppEngine;

public class BNaviEngineManager
{
  private static final String TAG = "Common";
  private static EngineCommonConfig mEngineCommonConfig;
  private static volatile BNaviEngineManager mInstance = null;
  public boolean mIsEngineInitSucc = false;
  private JNINaviManager mJNINaviManager = null;
  
  /* Error */
  public static BNaviEngineManager getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/baidu/navisdk/BNaviEngineManager:mInstance	Lcom/baidu/navisdk/BNaviEngineManager;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 20	com/baidu/navisdk/BNaviEngineManager:mInstance	Lcom/baidu/navisdk/BNaviEngineManager;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/baidu/navisdk/BNaviEngineManager
    //   21: dup
    //   22: invokespecial 36	com/baidu/navisdk/BNaviEngineManager:<init>	()V
    //   25: putstatic 20	com/baidu/navisdk/BNaviEngineManager:mInstance	Lcom/baidu/navisdk/BNaviEngineManager;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 20	com/baidu/navisdk/BNaviEngineManager:mInstance	Lcom/baidu/navisdk/BNaviEngineManager;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localBNaviEngineManager	BNaviEngineManager
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public void changeNaviStatisticsNetworkStatus(int paramInt)
  {
    try
    {
      if (isEngineInitSucc()) {
        this.mJNINaviManager.initNaviStatistics(paramInt);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public int getFavoriteHandle()
  {
    return 1000;
  }
  
  public String getIPByHost(String paramString)
  {
    try
    {
      paramString = this.mJNINaviManager.getIPByHost(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public boolean initEngine(EngineCommonConfig paramEngineCommonConfig, Handler paramHandler)
  {
    return initEngineBySync(paramEngineCommonConfig);
  }
  
  public boolean initEngineBySync(EngineCommonConfig paramEngineCommonConfig)
  {
    LogUtil.e("Common", "initEngineBySync");
    if (PerformStatItem.sUserTest) {
      PerformStatisticsController.peByType(3, "sdk_initEngineBySync_start", System.currentTimeMillis());
    }
    RespTimeStatItem.getInstance().setStartEngineTime();
    SysOSAPI.getInstance().setAppFolderName(paramEngineCommonConfig.mStrAppFolderName);
    paramEngineCommonConfig.mStrPath = SysOSAPI.getInstance().GetSDCardPath();
    SysOSAPI.getInstance().initEngineRes(BNaviModuleManager.getContext());
    Object localObject = SysOSAPI.getInstance().initPhoneInfo();
    ((Bundle)localObject).putBoolean("showlog", BNSettingManager.isShowNativeLog());
    if (PerformStatItem.sUserTest) {
      PerformStatisticsController.peByType(3, "sdk_initEngineBySync_lib_start", System.currentTimeMillis());
    }
    LogUtil.e("Common", "initEngineBySync InitEngine start");
    boolean bool = AppEngine.InitEngine((Bundle)localObject);
    LogUtil.e("Common", "initEngineBySync InitEngine flag :" + bool);
    if (!bool)
    {
      AppEngine.UnInitEngine();
      return false;
    }
    LogUtil.e("Common", "NaviEngineManager initNaviManager");
    if (PerformStatItem.sUserTest) {
      PerformStatisticsController.peByType(3, "sdk_initEngineBySync.3", System.currentTimeMillis());
    }
    int i = JNINaviManager.sInstance.initNaviManager(paramEngineCommonConfig);
    LogUtil.e("Common", "NaviEngineManager initNaviManager ret : " + i);
    if (PerformStatItem.sUserTest) {
      PerformStatisticsController.peByType(3, "sdk_initEngineBySync_lib_end", System.currentTimeMillis());
    }
    BNRouteGuider localBNRouteGuider;
    if (i == 0)
    {
      getInstance().mIsEngineInitSucc = true;
      LogUtil.e("Common", "NaviEngineManager initSubSysHandle GUIDANCE");
      getInstance().initSubSysHandle(1);
      LogUtil.e("Common", "NaviEngineManager initSubSysHandle VOICE_TTS");
      getInstance().initSubSysHandle(8);
      LogUtil.e("Common", "NaviEngineManager mMengMengDa");
      if ((paramEngineCommonConfig.mMengMengDaTTSPath != null) && (paramEngineCommonConfig.mMengMengDaTTSPath.length() > 0))
      {
        LogUtil.e("", "NaviEngineManager copy mengmengda.path=" + paramEngineCommonConfig.mMengMengDaTTSPath);
        long l = SystemClock.elapsedRealtime();
        bool = JNIVoicePersonalityControl.sInstance.CopyMaiDouPath(paramEngineCommonConfig.mMengMengDaTTSPath);
        LogUtil.e("", "NaviEngineManager copy mengmengda.copyOK=" + bool + ", time=" + (SystemClock.elapsedRealtime() - l) + "ms");
      }
      LogUtil.e("Common", "NaviEngineManager setSpecVoiceTaskId");
      int j = BNSettingManager.getVoicePersonality();
      paramEngineCommonConfig = null;
      if (j != 0) {
        paramEngineCommonConfig = BNSettingManager.getVoiceTaskId();
      }
      if (j != 4) {
        break label456;
      }
      localBNRouteGuider = BNRouteGuider.getInstance();
      localObject = paramEngineCommonConfig;
      if (paramEngineCommonConfig == null) {
        localObject = "0";
      }
      localBNRouteGuider.setSpecVoiceTaskId((String)localObject, true);
    }
    for (;;)
    {
      LogUtil.e("Common", "NaviEngineManager after init Engine");
      BNRoutePlaner.destory();
      BNRoutePlaner.getInstance();
      RespTimeStatItem.getInstance().setEndEngineTime();
      if (PerformStatItem.sUserTest) {
        PerformStatisticsController.peByType(3, "sdk_initEngineBySync_end", System.currentTimeMillis());
      }
      if (i != 0) {
        break;
      }
      return true;
      label456:
      localBNRouteGuider = BNRouteGuider.getInstance();
      localObject = paramEngineCommonConfig;
      if (paramEngineCommonConfig == null) {
        localObject = "0";
      }
      localBNRouteGuider.setSpecVoiceTaskId((String)localObject);
    }
    return false;
  }
  
  public void initNaviStatistics()
  {
    if (VDeviceAPI.isWifiConnected() == 1) {}
    try
    {
      this.mJNINaviManager.initNaviStatistics(2);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public int initSubSysHandle(int paramInt)
  {
    if (this.mJNINaviManager == null) {
      return 0;
    }
    try
    {
      this.mJNINaviManager.initSubSystem(paramInt);
      return 0;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public boolean isEngineInitSucc()
  {
    return this.mIsEngineInitSucc;
  }
  
  public boolean reload()
  {
    uninitSubSysHandle(1);
    initSubSysHandle(1);
    return 0 == 0;
  }
  
  /* Error */
  public boolean reloadSubSystem(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokevirtual 279	com/baidu/navisdk/BNaviEngineManager:uninitSubSysHandle	(I)V
    //   7: aload_0
    //   8: iload_1
    //   9: invokevirtual 192	com/baidu/navisdk/BNaviEngineManager:initSubSysHandle	(I)I
    //   12: pop
    //   13: iconst_0
    //   14: ifne +9 -> 23
    //   17: iconst_1
    //   18: istore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_2
    //   25: goto -6 -> 19
    //   28: astore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	BNaviEngineManager
    //   0	33	1	paramInt	int
    //   18	7	2	bool	boolean
    //   28	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
  }
  
  /* Error */
  public boolean uninit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/baidu/navisdk/BNaviEngineManager:mJNINaviManager	Lcom/baidu/navisdk/jni/nativeif/JNINaviManager;
    //   6: invokevirtual 285	com/baidu/navisdk/jni/nativeif/JNINaviManager:uninitNaviManager	()I
    //   9: ifne +18 -> 27
    //   12: iconst_1
    //   13: istore_1
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 26	com/baidu/navisdk/BNaviEngineManager:mJNINaviManager	Lcom/baidu/navisdk/jni/nativeif/JNINaviManager;
    //   19: aconst_null
    //   20: putstatic 20	com/baidu/navisdk/BNaviEngineManager:mInstance	Lcom/baidu/navisdk/BNaviEngineManager;
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -15 -> 14
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	BNaviEngineManager
    //   13	16	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	32	finally
    //   14	23	32	finally
  }
  
  public boolean uninitEngine()
  {
    try
    {
      if (this.mJNINaviManager != null) {
        this.mJNINaviManager.uninitNaviManager();
      }
      this.mJNINaviManager = null;
      mInstance = null;
      return true;
    }
    finally {}
  }
  
  public void uninitGuidanceEngine()
  {
    try
    {
      uninitSubSysHandle(1);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void uninitNaviStatistics()
  {
    this.mJNINaviManager.uninitNaviStatistics();
  }
  
  public void uninitSubSysHandle(int paramInt)
  {
    if (this.mJNINaviManager == null) {
      return;
    }
    try
    {
      this.mJNINaviManager.uninitSubSystem(paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void updateAppSource(int paramInt)
  {
    if (this.mJNINaviManager == null) {
      return;
    }
    try
    {
      this.mJNINaviManager.updateAppSource(paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/BNaviEngineManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */