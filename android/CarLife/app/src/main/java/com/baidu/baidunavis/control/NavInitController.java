package com.baidu.baidunavis.control;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavLocationManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.NavNetworkListener;
import com.baidu.baidunavis.NavSensorManager;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.navirecover.NaviRecoveryManager;
import com.baidu.baidunavis.stat.NavUserBehaviour;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.tts.OnTTSVoiceDataSwitchListener;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.baidunavis.wrapper.NaviEngineInitListener;
import com.baidu.mapframework.tts.OnTTSStateChangedListener;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener.AudioPlayerListener;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNIOfflineDataControl;
import com.baidu.navisdk.jni.nativeif.JNITTSPlayer;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.EngineCommonConfig;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.module.tingphone.control.TingPhoneFileManager;
import com.baidu.navisdk.ui.download.BNDownloadNotifyManager;
import com.baidu.navisdk.ui.download.BNDownloadUIManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoice.VoiceAccountListener;
import com.baidu.navisdk.ui.voice.BNVoice.VoiceDataSwitchListener;
import com.baidu.navisdk.ui.voice.BNVoice.VoiceSwitchData;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.logic.BNSysSensorManager;
import com.baidu.navisdk.util.statistic.IBNStatisticsListener;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.RespTimeStatItem;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.navisdk.util.worker.loop.BNPerformceFramework;
import com.baidu.platform.a.b;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class NavInitController
{
  private static final int MSG_CLEAN_TINGPHONE_FILE = 3;
  public static final int MSG_INIT_BASE_ENGINE_INNER = 100;
  private static final int MSG_INIT_CLOUD_CONFIG = 2;
  private static final int MSG_UPDATE_SWITCH_TTS_RESULT = 0;
  public static final String TAG = NavInitController.class.getSimpleName();
  private static NavInitController sInstance = null;
  private BNVoice.VoiceAccountListener mAccountListener = new BNVoice.VoiceAccountListener()
  {
    public void asynGetAccountHeadUrl() {}
    
    public String onGetAccountBduss()
    {
      String str = NavMapAdapter.getInstance().getBduss();
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      return null;
    }
  };
  private CommonHandlerThread.Callback mChildThreadCallback = new CommonHandlerThread.Callback()
  {
    public void careAbouts()
    {
      careAbout(50);
      careAbout(51);
      careAbout(55);
      careAbout(150);
    }
    
    public void execute(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        return;
        if (NavCommonFuncModel.getInstance().getActivity() != null)
        {
          if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof NaviEngineInitListener)))
          {
            NavInitController.this.initBaseEngineStepOne(NavCommonFuncModel.getInstance().getActivity(), (NaviEngineInitListener)paramAnonymousMessage.obj);
            return;
          }
          NavInitController.this.initBaseEngineStepOne(NavCommonFuncModel.getInstance().getActivity(), null);
          return;
          NavInitController.this.delayInitModule();
          return;
          BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-StartRecordTraj", null)new BNWorkerConfig
          {
            protected String execute()
            {
              int j = 1;
              Object localObject1 = TAG;
              Object localObject2 = new StringBuilder().append("initAfterEngineInited()  updateUserInfo, bduss=").append(NavMapAdapter.getInstance().getBduss()).append(", uid=").append(NavMapAdapter.getInstance().getUid()).append(", islogin=");
              int i;
              if (NavMapAdapter.getInstance().isLogin())
              {
                i = 1;
                NavLogUtils.e((String)localObject1, i);
              }
              for (;;)
              {
                try
                {
                  localObject1 = JNITrajectoryControl.sInstance;
                  localObject2 = NavMapAdapter.getInstance().getBduss();
                  String str = NavMapAdapter.getInstance().getUid();
                  if (!NavMapAdapter.getInstance().isLogin()) {
                    continue;
                  }
                  i = j;
                  ((JNITrajectoryControl)localObject1).updateUserInfo((String)localObject2, str, i);
                }
                catch (Throwable localThrowable)
                {
                  continue;
                }
                return null;
                i = 0;
                break;
                i = 0;
              }
            }
          }, new BNWorkerConfig(100, 0));
          return;
          try
          {
            if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof Bundle)))
            {
              Bundle localBundle = (Bundle)paramAnonymousMessage.obj;
              paramAnonymousMessage = "";
              if (localBundle.containsKey("userId")) {
                paramAnonymousMessage = localBundle.getString("userId");
              }
              String str = "";
              if (localBundle.containsKey("startPointName")) {
                str = localBundle.getString("startPointName");
              }
              int i = localBundle.getInt("fromType");
              boolean bool1 = localBundle.getBoolean("selfRegisterLocation");
              boolean bool2 = localBundle.getBoolean("notInputStartEndGeo");
              NavTrajectoryController.getInstance().startRecordInner(paramAnonymousMessage, str, i, bool1, bool2);
              NavLogUtils.e(NavInitController.TAG, "initAfterEngineInited()  MSG_START_RECORD_TRAJECTORY");
              return;
            }
          }
          catch (Throwable paramAnonymousMessage) {}
        }
      }
    }
    
    public String getName()
    {
      return "Navi-SDK-Init";
    }
  };
  private Handler mHandler = new Handler(CommonHandlerThread.getInstance().getLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool = true;
      if (paramAnonymousMessage.what == 100) {
        NavInitController.this.initBaseEngineStepTwoForEngine(NavInitController.this.mOutNaviEngineInitListener);
      }
      do
      {
        return;
        if (paramAnonymousMessage.what == 0)
        {
          BNVoice localBNVoice = BNVoice.getInstance();
          if (paramAnonymousMessage.arg1 == 1) {}
          for (;;)
          {
            localBNVoice.handleVoiceDataSwitchResult(bool);
            return;
            bool = false;
          }
        }
        if (paramAnonymousMessage.what == 2)
        {
          new CloudConfigObtainManager().initCloudConfigOutline();
          return;
        }
      } while (paramAnonymousMessage.what != 3);
      TingPhoneFileManager.cleanPathFileAndConfig();
    }
  };
  private Object mInitObj = new Object();
  private Object mNaviEngineInitListenerObj = new Object();
  private List<NaviEngineInitListener> mNaviEngineInitListeners = new ArrayList();
  private NaviEngineInitListener mOutNaviEngineInitListener = null;
  private BNVoice.VoiceDataSwitchListener mSwitchTTSListener = new BNVoice.VoiceDataSwitchListener()
  {
    public boolean isCanSwitchVoice()
    {
      return BaseTTSPlayer.getInstance().canSwitchVoice();
    }
    
    public boolean onFreeCustom(BNVoice.VoiceSwitchData paramAnonymousVoiceSwitchData)
    {
      boolean bool1 = false;
      if (!BaseTTSPlayer.getInstance().getTTSVoiceDataCustom())
      {
        LogUtil.e(NavInitController.TAG, "onFreeCustom custom is false");
        bool1 = true;
      }
      boolean bool2;
      do
      {
        return bool1;
        bool2 = BaseTTSPlayer.getInstance().setCustomParams(false);
        boolean bool3 = BaseTTSPlayer.getInstance().loadCustomResource("");
        LogUtil.e(NavInitController.TAG, "onFreeCustom :" + bool2 + " resultSetPath" + bool3);
      } while (!bool2);
      return BaseTTSPlayer.getInstance().freeCustomTTSVoiceData(paramAnonymousVoiceSwitchData.subPath, NavInitController.this.mTtsSwitchListener);
    }
    
    public boolean onLoadCustom(BNVoice.VoiceSwitchData paramAnonymousVoiceSwitchData)
    {
      if (paramAnonymousVoiceSwitchData == null) {
        LogUtil.e("BNVoice", "onLoadCustom data is null");
      }
      boolean bool1;
      boolean bool2;
      do
      {
        return false;
        LogUtil.e("BNVoice", "onLoadCustom mainPath :" + paramAnonymousVoiceSwitchData.mainPath + " subPath:" + paramAnonymousVoiceSwitchData.subPath);
        if ((BaseTTSPlayer.getInstance().getTTSVoiceDataCustom()) && (paramAnonymousVoiceSwitchData.subPath != null) && (paramAnonymousVoiceSwitchData.subPath.equals(BaseTTSPlayer.getInstance().getCustomVoiceDataPath())))
        {
          LogUtil.e(NavInitController.TAG, "onLoadCustom has loaded");
          return true;
        }
        bool1 = BaseTTSPlayer.getInstance().setCustomParams(true);
        bool2 = BaseTTSPlayer.getInstance().loadCustomResource(paramAnonymousVoiceSwitchData.subPath);
        LogUtil.e(NavInitController.TAG, "onLoadCustom :" + bool1 + " resultSetPath " + bool2);
      } while ((!bool1) || (!bool2));
      return BaseTTSPlayer.getInstance().loadCustomTTSVoiceData(paramAnonymousVoiceSwitchData.subPath, NavInitController.this.mTtsSwitchListener);
    }
    
    public boolean onVoiceDataSwitch(BNVoice.VoiceSwitchData paramAnonymousVoiceSwitchData)
    {
      if (paramAnonymousVoiceSwitchData == null)
      {
        LogUtil.e("BNVoice", "onVoiceDataSwitch data is null");
        return false;
      }
      LogUtil.e("BNVoice", "onVoiceDataSwitch id :" + paramAnonymousVoiceSwitchData.taskId);
      LogUtil.e("BNVoice", "onVoiceDataSwitch mainPath :" + paramAnonymousVoiceSwitchData.mainPath + " subPath:" + paramAnonymousVoiceSwitchData.subPath);
      if (paramAnonymousVoiceSwitchData.type == 0)
      {
        BaseTTSPlayer.getInstance().setCustomParams(false);
        BaseTTSPlayer.getInstance().loadCustomResource("");
        BaseTTSPlayer.getInstance().switchTTSVoiceData(null, NavInitController.this.mTtsSwitchListener);
      }
      for (;;)
      {
        return true;
        if (2 == paramAnonymousVoiceSwitchData.type)
        {
          boolean bool1 = BaseTTSPlayer.getInstance().setCustomParams(true);
          boolean bool2 = BaseTTSPlayer.getInstance().loadCustomResource(paramAnonymousVoiceSwitchData.mainPath);
          boolean bool3 = BaseTTSPlayer.getInstance().switchTTSVoiceData(null, NavInitController.this.mTtsSwitchListener);
          if ((!bool2) || (!bool1) || (!bool3)) {
            LogUtil.e("BNVoice", "onVoiceDataSwitch result :" + bool2 + bool1 + bool3);
          }
        }
        else if ((1 == paramAnonymousVoiceSwitchData.type) || (3 == paramAnonymousVoiceSwitchData.type))
        {
          BaseTTSPlayer.getInstance().setCustomParams(false);
          BaseTTSPlayer.getInstance().loadCustomResource("");
          BaseTTSPlayer.getInstance().switchTTSVoiceData(paramAnonymousVoiceSwitchData.mainPath, NavInitController.this.mTtsSwitchListener);
        }
        else if (4 == paramAnonymousVoiceSwitchData.type)
        {
          BaseTTSPlayer.getInstance().setCustomParams(true);
          BaseTTSPlayer.getInstance().loadCustomResource(paramAnonymousVoiceSwitchData.subPath);
          BaseTTSPlayer.getInstance().switchTTSVoiceData(paramAnonymousVoiceSwitchData.mainPath, NavInitController.this.mTtsSwitchListener);
        }
      }
    }
  };
  private OnTTSVoiceDataSwitchListener mTtsSwitchListener = new OnTTSVoiceDataSwitchListener()
  {
    public void onTTSVoiceDataSwitched(boolean paramAnonymousBoolean)
    {
      int i = 0;
      if (NavInitController.this.mHandler != null)
      {
        Message localMessage = NavInitController.this.mHandler.obtainMessage();
        localMessage.what = 0;
        if (paramAnonymousBoolean) {
          i = 1;
        }
        localMessage.arg1 = i;
        NavInitController.this.mHandler.sendMessage(localMessage);
      }
    }
  };
  
  private void checkXiJiang()
  {
    BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask("CarNavi-checkXiJiang", null)new BNWorkerConfig
    {
      protected String execute()
      {
        try
        {
          if ((NetworkUtils.isNetworkAvailable(NavCommonFuncModel.getInstance().getActivity())) && (JNIOfflineDataControl.getInstance().checkNewVer(new Bundle(), new int[35]))) {
            return null;
          }
          NavInitController.this.checkXiJiang();
          return null;
        }
        catch (Throwable localThrowable) {}
        return null;
      }
    }, new BNWorkerConfig(100, 0), 43200000L);
  }
  
  private void delayInitModule()
  {
    try
    {
      initNaviTTSListener();
      BNVoice.getInstance().setVoiceDataSwitchListener(this.mSwitchTTSListener);
      BNVoice.getInstance().setVoiceAccountListener(this.mAccountListener);
      for (;;)
      {
        try
        {
          BNOfflineDataManager.getInstance().initDownloadInfo(true);
          if (NavCommonFuncModel.getInstance().getActivity() != null) {
            NavMapAdapter.getInstance().checkNewVerData(NavCommonFuncModel.getInstance().getActivity());
          }
          BaiduNaviManager.getInstance().downLoadCityMapData(NavCommonFuncController.getInstance().getLocationCityId());
        }
        catch (Throwable localThrowable4)
        {
          continue;
        }
        try
        {
          BNSysLocationManager.getInstance().init(BNaviModuleManager.getContext());
          BNSysSensorManager.getInstance().initSensor(BNaviModuleManager.getContext());
          NavSensorManager.getInstence().addSensorChangeListener();
          NavLocationManager.getInstance().addLocationListener();
          if (BaiduNaviManager.getInstance().mIsMapUseGPS) {
            BaiduNaviManager.getInstance().notifyMapGPSEnable(true);
          }
          if ((NavCommonFuncModel.getInstance().getActivity() != null) && (NavRoutePlanModel.getInstance().getEntry() != 7))
          {
            NavMapAdapter.importSettingToNaviSDK(NavCommonFuncModel.getInstance().getActivity());
            BNRecoverNaviHelper.getInstance().init();
          }
          NaviRecoveryManager.getInstance().resetCrashAndKillTime(NavCommonFuncModel.getInstance().getActivity());
          NavMapManager.getInstance().init();
          NavNetworkListener.getInstance().registNetworkTypeChangeEvent();
          try
          {
            NavDayNightController.getInstance().init();
            BNStatisticsManager.getInstance().init();
            BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask("CarNavi-UpdateUserInfo", null)new BNWorkerConfig
            {
              protected String execute()
              {
                int j = 1;
                Object localObject1 = TAG;
                Object localObject2 = new StringBuilder().append("initAfterEngineInited()  updateUserInfo, bduss=").append(NavMapAdapter.getInstance().getBduss()).append(", uid=").append(NavMapAdapter.getInstance().getUid()).append(", islogin=");
                int i;
                if (NavMapAdapter.getInstance().isLogin())
                {
                  i = 1;
                  NavLogUtils.e((String)localObject1, i);
                }
                for (;;)
                {
                  try
                  {
                    localObject1 = JNITrajectoryControl.sInstance;
                    localObject2 = NavMapAdapter.getInstance().getBduss();
                    String str = NavMapAdapter.getInstance().getUid();
                    if (!NavMapAdapter.getInstance().isLogin()) {
                      continue;
                    }
                    i = j;
                    ((JNITrajectoryControl)localObject1).updateUserInfo((String)localObject2, str, i);
                  }
                  catch (Throwable localThrowable)
                  {
                    continue;
                  }
                  return null;
                  i = 0;
                  break;
                  i = 0;
                }
              }
            }, new BNWorkerConfig(100, 0), 10000L);
            checkXiJiang();
            BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask("CarNavi-CloudConfig", null)new BNWorkerConfig
            {
              protected String execute()
              {
                new CloudConfigObtainManager().initCloudConfigOutline();
                return null;
              }
            }, new BNWorkerConfig(100, 0), 1000L);
            BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask("CarNavi-TingPhone", null)new BNWorkerConfig
            {
              protected String execute()
              {
                TingPhoneFileManager.cleanPathFileAndConfig();
                return null;
              }
            }, new BNWorkerConfig(100, 0), 12000L);
            NavMapAdapter.sMonkey = BNSettingManager.isMonkey();
            if (NavMapAdapter.sMonkey) {}
            try
            {
              NavRouteGuideController.getInstance().runMonkey();
              UserOPController.getInstance().add("8.2.8", "3", null, null);
              if (NavCommonFuncModel.getInstance().mIsOnRestoreInstanceData)
              {
                NavCommonFuncModel.getInstance().mIsOnRestoreInstanceData = false;
                UserOPController.getInstance().add("1.q");
              }
              if ((PerformStatItem.sBatchTestNetworkAndServerTime) && (this.mHandler != null)) {
                BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask("CarNavi-BatchNetworkTest", null)new BNWorkerConfig
                {
                  protected String execute()
                  {
                    PerformStatisticsController.getInstance().startBatchTestNetworkAndServer();
                    if (NavCommonFuncModel.getInstance().getActivity() != null) {
                      Toast.makeText(NavCommonFuncModel.getInstance().getActivity(), "开始批量测试百度网络和服务端耗时", 0).show();
                    }
                    return null;
                  }
                }, new BNWorkerConfig(100, 0), 10000L);
              }
              return;
            }
            catch (Throwable localThrowable1) {}
          }
          catch (Throwable localThrowable2) {}
        }
        catch (Throwable localThrowable3) {}
      }
    }
    catch (Throwable localThrowable5)
    {
      for (;;) {}
    }
  }
  
  public static void destroy()
  {
    BNDownloadUIManager.pauseAllDownload();
    BNDownloadNotifyManager.getInstance().clearNotification();
    if (NavUserBehaviour.isInitialized()) {
      NavUserBehaviour.destory();
    }
    BaiduNaviManager.getInstance().uninitEngine();
  }
  
  private EngineCommonConfig getEngineCommonConfig()
  {
    String str = SysOSAPIv2.getInstance().getSdcardPath();
    SysOSAPI.getInstance().setAppFolderName(NavMapAdapter.getInstance().getDataFolderName());
    SysOSAPI.getInstance().initSDcardPath(str);
    SysOSAPI.getInstance().setOfflineDataPath(SysOSAPI.getInstance().GetSDCardPath());
    EngineCommonConfig localEngineCommonConfig = new EngineCommonConfig();
    localEngineCommonConfig.mSearchNetMode = BNSettingManager.getPrefSearchMode();
    localEngineCommonConfig.mGuidanceNetMode = 0;
    localEngineCommonConfig.mMapEngineNetMode = 0;
    localEngineCommonConfig.mOtherEngineNetMode = 0;
    localEngineCommonConfig.mStrProductName = "baiduNavi_SDK_FOR_Map";
    localEngineCommonConfig.mRootPath = str;
    localEngineCommonConfig.mStrMapPath = NavMapAdapter.getInstance().getDataPath();
    localEngineCommonConfig.mStrAppFolderName = NavMapAdapter.getInstance().getDataFolderName();
    try
    {
      localEngineCommonConfig.mMengMengDaTTSPath = NavMapAdapter.getInstance().getMengMengDaTTSPath();
      return localEngineCommonConfig;
    }
    catch (Throwable localThrowable) {}
    return localEngineCommonConfig;
  }
  
  public static NavInitController getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavInitController();
    }
    return sInstance;
  }
  
  private void handleEngineInitFailed()
  {
    LogUtil.e(TAG, "handleEngineInitFailed()");
    UserOPController.getInstance().add("7.2", "1", null, null);
    BaiduNaviManager.sIsBaseEngineInitial = false;
    BaiduNaviManager.sIsBaseEngineInitialized = false;
    BaiduNaviManager.sIsEngineInitialFailed = true;
    if (PerformStatItem.sUserTest) {
      PerformStatisticsController.peByType(3, "ad_init_failed", System.currentTimeMillis());
    }
    BNEyeSpyPaperController.getInstance().endInitMonitor(false);
    if (this.mOutNaviEngineInitListener != null) {
      this.mOutNaviEngineInitListener.engineInitFail();
    }
    synchronized (this.mNaviEngineInitListenerObj)
    {
      int i = this.mNaviEngineInitListeners.size() - 1;
      while (i >= 0)
      {
        ((NaviEngineInitListener)this.mNaviEngineInitListeners.get(i)).engineInitFail();
        this.mNaviEngineInitListeners.remove(i);
        i -= 1;
      }
      return;
    }
  }
  
  private void handleEngineInitStart()
  {
    LogUtil.e(TAG, "handleEngineInitStart()");
    if (this.mOutNaviEngineInitListener != null) {
      this.mOutNaviEngineInitListener.engineInitStart();
    }
    if (this.mNaviEngineInitListeners.size() > 0) {
      synchronized (this.mNaviEngineInitListenerObj)
      {
        int i = this.mNaviEngineInitListeners.size() - 1;
        while (i >= 0)
        {
          ((NaviEngineInitListener)this.mNaviEngineInitListeners.get(i)).engineInitStart();
          i -= 1;
        }
        return;
      }
    }
  }
  
  private void handleEngineInitSuccess()
  {
    LogUtil.e(TAG, "handleEngineInitSuccess()");
    if (testNaviResourceLoad())
    {
      BaiduNaviManager.sIsBaseEngineInitial = false;
      BaiduNaviManager.sIsBaseEngineInitialized = true;
      BaiduNaviManager.sIsEngineInitialFailed = false;
      if (NavCommonFuncModel.getInstance().getActivity() == null)
      {
        handleEngineInitFailed();
        return;
      }
    }
    try
    {
      BNaviModuleManager.setupBase(true);
      getInstance().initAfterEngineInited();
      if (PerformStatItem.sUserTest) {
        PerformStatisticsController.peByType(3, "ad_init_ok", System.currentTimeMillis());
      }
      BNEyeSpyPaperController.getInstance().endInitMonitor(true);
      if (this.mOutNaviEngineInitListener != null) {
        this.mOutNaviEngineInitListener.engineInitSuccess();
      }
      if (this.mNaviEngineInitListeners.size() > 0) {}
      synchronized (this.mNaviEngineInitListenerObj)
      {
        int i = this.mNaviEngineInitListeners.size() - 1;
        while (i >= 0)
        {
          NavLogUtils.e(TAG, "handleEngineInitSuccess() dispatch to listen" + i);
          ((NaviEngineInitListener)this.mNaviEngineInitListeners.get(i)).engineInitSuccess();
          this.mNaviEngineInitListeners.remove(i);
          i -= 1;
        }
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-Init-Delay", null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavInitController.this.delayInitModule();
            return null;
          }
        }, new BNWorkerConfig(2, 1));
        return;
      }
      LogUtil.e(TAG, "failed to load jar resource.");
      handleEngineInitFailed();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private boolean init(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    return NavCommonFuncModel.getInstance().initParams(paramActivity);
  }
  
  private void initAfterEngineInited()
  {
    handleAppSource();
    NavCommonFuncController.getInstance().registerNaviEventListener();
    initMTJStatisticsService();
    BNRoutePlaner.getInstance().init(BNaviModuleManager.getContext());
    BNRoutePlaner.getInstance().setCalcPrference(PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt("calc_preference", 1));
    setRoutePlanStatistcsUrl();
    try
    {
      NavRoutePlanController.getInstance().init();
      BNaviModuleManager.setupNaviCommonCallBackListener(NavCommonFuncController.getInstance().mNaviCommonCallBack);
      RespTimeStatItem.getInstance().addSDKInitTime();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private void initBaseEngineStepOne(Activity arg1, NaviEngineInitListener paramNaviEngineInitListener)
  {
    NavLogUtils.e(TAG, "initBaseEngineStepOne() ");
    loadNaviSO();
    if ((!BaiduNaviManager.isNaviSoLoadSuccess()) || (??? == null))
    {
      BaiduNaviManager.sIsBaseEngineInitial = false;
      BaiduNaviManager.sIsBaseEngineInitialized = false;
      BaiduNaviManager.sIsEngineInitialFailed = true;
      if (paramNaviEngineInitListener != null) {
        paramNaviEngineInitListener.engineInitFail();
      }
      NavLogUtils.e(TAG, "initBaseEngine() return 1 so not loaded or activity is null");
      return;
    }
    synchronized (this.mInitObj)
    {
      if (BaiduNaviManager.sIsBaseEngineInitialized)
      {
        if (paramNaviEngineInitListener != null) {
          paramNaviEngineInitListener.engineInitSuccess();
        }
        NavLogUtils.e(TAG, "initBaseEngine() return 2 inited");
        return;
      }
    }
    if (BaiduNaviManager.sIsBaseEngineInitial)
    {
      if (paramNaviEngineInitListener != null) {
        NavLogUtils.e(TAG, "initBaseEngine() return 3 , listen is added to list.");
      }
      synchronized (this.mNaviEngineInitListenerObj)
      {
        this.mNaviEngineInitListeners.add(paramNaviEngineInitListener);
        NavLogUtils.e(TAG, "initBaseEngine() return 3 is initing.");
        return;
      }
    }
    BaiduNaviManager.sIsBaseEngineInitial = true;
    BaiduNaviManager.sIsBaseEngineInitialized = false;
    BaiduNaviManager.sIsEngineInitialFailed = false;
    this.mOutNaviEngineInitListener = paramNaviEngineInitListener;
    if ((??? != null) && (!NavMapAdapter.getInstance().isExternalStorageEnabled()))
    {
      NavTipTool.onCreateToastDialog(???, 2131296667);
      handleEngineInitFailed();
      NavLogUtils.e(TAG, "initBaseEngine() return 4 sdcard error.");
      return;
    }
    RespTimeStatItem.getInstance().setStartAppTime();
    RespTimeStatItem.getInstance().startCountSDKInitTime();
    if (!getInstance().init(???))
    {
      handleEngineInitFailed();
      NavLogUtils.e(TAG, "initBaseEngine() return 5");
      return;
    }
    paramNaviEngineInitListener = SysOSAPIv2.getInstance().getSdcardPath();
    SysOSAPI.getInstance().init();
    SysOSAPI.getInstance().setAppFolderName(NavMapAdapter.getInstance().getDataFolderName());
    SysOSAPI.getInstance().initSDcardPath(paramNaviEngineInitListener);
    com.baidu.navisdk.util.common.LogUtil.LOGGABLE = BNSettingManager.isShowJavaLog();
    PackageUtil.setCuid(SysOSAPIv2.getInstance().getCuid());
    BNHttpCenter.init(new NavHttpCenter());
    BNaviModuleManager.initListenersForMap(???);
    Log.e(TAG, "initpack-------------");
    BNaviModuleManager.initContext(???);
    HttpURLManager.getInstance().initUrlData();
    initBaseEngineStepTwoForEngine(this.mOutNaviEngineInitListener);
  }
  
  private void initBaseEngineStepTwoForEngine(NaviEngineInitListener paramNaviEngineInitListener)
  {
    BNEyeSpyPaperController.getInstance().startInitMonitor();
    if (NavCommonFuncModel.getInstance().getActivity() == null)
    {
      handleEngineInitFailed();
      return;
    }
    handleEngineInitStart();
    try
    {
      paramNaviEngineInitListener = getEngineCommonConfig();
      if (BNaviEngineManager.getInstance().initEngine(paramNaviEngineInitListener, this.mHandler))
      {
        handleEngineInitSuccess();
        return;
      }
    }
    catch (Throwable paramNaviEngineInitListener)
    {
      handleEngineInitFailed();
      return;
    }
    handleEngineInitFailed();
  }
  
  private void initMTJStatisticsService()
  {
    BNStatisticsManager.getInstance().setStatisticsListener(new IBNStatisticsListener()
    {
      public void onEvent(Context paramAnonymousContext, String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onEvent(String paramAnonymousString1, String paramAnonymousString2)
      {
        StatisticManager.onEvent(paramAnonymousString1, paramAnonymousString2);
      }
      
      public void onEventDuration(Context paramAnonymousContext, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt) {}
      
      public void onEventDuration(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt) {}
      
      public void onEventEnd(Context paramAnonymousContext, String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onEventStart(Context paramAnonymousContext, String paramAnonymousString1, String paramAnonymousString2) {}
    });
  }
  
  private void initNaviTTSListener()
  {
    TTSPlayerControl.setTTSPlayerListener(new IBNTTSPlayerListener()
    {
      public int cancelAudio()
      {
        return BaseTTSPlayer.getInstance().cancelAudio();
      }
      
      public int getTTSState()
      {
        return BaseTTSPlayer.getInstance().getTTSState();
      }
      
      public void initTTSPlayer() {}
      
      public boolean isNaviMuteState()
      {
        return BaseTTSPlayer.getInstance().isNaviMuteState();
      }
      
      public void pauseTTS()
      {
        BaseTTSPlayer.getInstance().pauseTTS();
        LogUtil.e(NavInitController.TAG, "tts -- pauseTTS");
      }
      
      public void phoneCalling()
      {
        BaseTTSPlayer.getInstance().setPhoneIn(true);
        BaseTTSPlayer.getInstance().stopTTS();
        BaseTTSPlayer.getInstance().stopSound();
      }
      
      public void phoneHangUp()
      {
        BaseTTSPlayer.getInstance().setPhoneIn(false);
      }
      
      public int playAudio(String paramAnonymousString, IBNTTSPlayerListener.AudioPlayerListener paramAnonymousAudioPlayerListener)
      {
        return BaseTTSPlayer.getInstance().playAudio(paramAnonymousString, paramAnonymousAudioPlayerListener);
      }
      
      public int playTTSText(String paramAnonymousString, int paramAnonymousInt)
      {
        boolean bool = true;
        LogUtil.e(NavInitController.TAG, "tts -- playTTSText arg0 = " + paramAnonymousString + ", arg1 = " + paramAnonymousInt);
        if ((!BNavigator.getInstance().isNaviBegin()) && (paramAnonymousString != null) && ("GPS信号弱,位置刷新可能不及时，请谨慎驾驶".equals(paramAnonymousString))) {
          return 1;
        }
        BaseTTSPlayer localBaseTTSPlayer = BaseTTSPlayer.getInstance();
        if (paramAnonymousInt == 1) {}
        for (;;)
        {
          return localBaseTTSPlayer.playTTSText(paramAnonymousString, bool);
          bool = false;
        }
      }
      
      public int playTTSText(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        boolean bool = true;
        LogUtil.e(NavInitController.TAG, "tts -- playTTSText arg0 = " + paramAnonymousString1 + ", arg1 = " + paramAnonymousInt + ", arg2 = " + paramAnonymousString2);
        if ((!BNavigator.getInstance().isNaviBegin()) && (paramAnonymousString1 != null) && ("GPS信号弱,位置刷新可能不及时，请谨慎驾驶".equals(paramAnonymousString1))) {
          return 1;
        }
        BaseTTSPlayer localBaseTTSPlayer = BaseTTSPlayer.getInstance();
        if (paramAnonymousInt == 1) {}
        for (;;)
        {
          return localBaseTTSPlayer.playTTSText(paramAnonymousString1, paramAnonymousString2, bool);
          bool = false;
        }
      }
      
      public int playXDTTSText(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        LogUtil.e(NavInitController.TAG, "tts -- playTTSText arg0 = " + paramAnonymousString1 + ", arg1 = " + paramAnonymousInt + ", arg2 = " + paramAnonymousString2);
        return 0;
      }
      
      public void releaseTTSPlayer() {}
      
      public void resumeTTS()
      {
        BaseTTSPlayer.getInstance().resumeTTS();
        JNIGuidanceControl.getInstance().setTTSPlayEnd();
        LogUtil.e(NavInitController.TAG, "tts -- resumeTTS");
      }
      
      public void setNaviMuteState(boolean paramAnonymousBoolean)
      {
        BaseTTSPlayer.getInstance().setNaviMuteState(paramAnonymousBoolean);
      }
      
      public void stopTTS()
      {
        BaseTTSPlayer.getInstance().stopTTS();
        LogUtil.e(NavInitController.TAG, "tts -- stopTTS");
      }
    });
    TTSPlayerControl.init();
    BaseTTSPlayer.getInstance().setOnTTSStateChangedListener(new OnTTSStateChangedListener()
    {
      public void onPlayEnd()
      {
        JNITTSPlayer.sInstance.PlayOver();
        JNIGuidanceControl.getInstance().setTTSPlayEnd();
        LogUtil.e(NavInitController.TAG, "tts -- onPlayEnd");
      }
      
      public void onPlayError(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onPlayStart()
      {
        LogUtil.e(NavInitController.TAG, "tts -- onPlayStart");
      }
    });
  }
  
  private void setRoutePlanStatistcsUrl()
  {
    Object localObject = "";
    try
    {
      String str = "&mb=" + URLEncoder.encode(com.baidu.navisdk.vi.VDeviceAPI.getPhoneType(), "UTF-8");
      localObject = str;
      str = str + "&sv=" + URLEncoder.encode(com.baidu.navisdk.vi.VDeviceAPI.getAppPackageVersion(), "UTF-8");
      localObject = str;
      str = str + "&pcn=" + URLEncoder.encode(com.baidu.navisdk.vi.VDeviceAPI.getAppPackageName(), "UTF-8");
      localObject = str;
      str = str + "&kv=" + URLEncoder.encode(com.baidu.navisdk.vi.VDeviceAPI.getSDKVersion(), "UTF-8");
      localObject = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    localObject = (String)localObject + "&os=android";
    localObject = (String)localObject + "&net=" + com.baidu.vi.VDeviceAPI.getCurrentNetworkType();
    localObject = (String)localObject + "&channel=" + SysOSAPIv2.getInstance().getChannel();
    NavRoutePlanModel.getInstance().routePlanStatistcsUrl = ((String)localObject);
    BNRoutePlaner.getInstance().setRoutePlanStatistcsUrl((String)localObject);
    NavLogUtils.e(TAG, "setRoutePlanStatistcsUrl() url=" + (String)localObject);
  }
  
  private boolean testNaviResourceLoad()
  {
    return true;
  }
  
  public void handleAppSource()
  {
    BNaviModuleManager.sAppSourceStr = "others";
    BNaviModuleManager.updateAppSource();
  }
  
  public void initBaseEngine(Activity paramActivity, final NaviEngineInitListener paramNaviEngineInitListener)
  {
    BNPerformceFramework.init(new NavPerformanceFramework());
    BNWorkerCenter.init(new NavWorkerCenter());
    if (PerformStatItem.sUserTest) {
      PerformStatisticsController.peByType(3, "ad_init_start", System.currentTimeMillis());
    }
    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-Init", null)new BNWorkerConfig
    {
      protected String execute()
      {
        if (Looper.myLooper() == null) {
          Looper.prepare();
        }
        NavInitController.this.initBaseEngineStepOne(NavCommonFuncModel.getInstance().getActivity(), paramNaviEngineInitListener);
        return null;
      }
    }, new BNWorkerConfig(2, 1));
    if (this.mChildThreadCallback != null) {
      CommonHandlerThread.getInstance().registerCallback(this.mChildThreadCallback);
    }
  }
  
  public void loadNaviSO()
  {
    int i = 0;
    for (;;)
    {
      if (i < 2) {}
      try
      {
        if ((b.a().a("gnustl_shared")) && (b.a().a("app_BaiduVIlib")) && (b.a().a("BDSpeechDecoder_V1")) && (b.a().a("etts_domain_data_builder")) && (b.a().a("app_BaiduNaviApplib")) && (b.a().a("audiomessage-jni")))
        {
          BaiduNaviManager.sIsNaviSoLoadSuccess = true;
          NavLogUtils.e(TAG, "static load so. sIsNaviSoLoadSuccess=" + BaiduNaviManager.sIsNaviSoLoadSuccess);
          return;
        }
        BaiduNaviManager.sIsNaviSoLoadSuccess = false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          BaiduNaviManager.sIsNaviSoLoadSuccess = false;
        }
      }
      i += 1;
    }
  }
  
  public void uninitEngine()
  {
    LogUtil.e("uninitEngine", null);
    NavNetworkListener.getInstance().unregistNetworkTypeChangeEvent();
    BNRoutePlaner.destory();
    BNaviModuleManager.destory();
    BaiduNaviManager.sIsBaseEngineInitial = false;
    BaiduNaviManager.sIsBaseEngineInitialized = false;
    BaiduNaviManager.sIsEngineInitialFailed = false;
    NavCommonFuncController.getInstance().unregisterNaviEventListener();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavInitController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */