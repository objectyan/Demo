package com.baidu.baidunavis.tts;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.carlife.m.a.b;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.tts.OnTTSStateChangedListener;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener.AudioPlayerListener;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl.OnTTSPlayStateListener;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.platform.a.b;
import com.baidu.tts.client.SpeechSynthesizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BaseTTSPlayer
{
  private static final String CRUISERVOICEPREFIX = "嗒嗒嗒";
  private static final String DINGVOICEBUFFER = "叮";
  private static final String HIGHTWAYVOICEPREFIX = "嘀嘀嘀";
  public static final int MSG_REINIT_TTS = 6;
  public static final int MSG_RELOAD_SO = 5;
  public static final int PLAYER_STATE_ERROR = 4;
  public static final int PLAYER_STATE_IDLE = 1;
  public static final int PLAYER_STATE_NOT_INIT = 0;
  public static final int PLAYER_STATE_PAUSE = 3;
  public static final int PLAYER_STATE_PLAYING = 2;
  private static final int RELOAD_MAX_TIME = 5;
  private static final int SO_LOAD_MAX_TIME = 2;
  private static final String TAG = "TTS-BaseTTSPlayer";
  private static boolean bStopVoiceOutput;
  private static SoundUtils mCruiserPassSound = null;
  private static SoundUtils mDingSound;
  private static SoundUtils mHighwayDididiSound;
  private static BaseTTSPlayer mInstance;
  private static boolean sIsTTSSoLoadSuccess;
  private static int sReloadCnt = 0;
  private OnTTSStateChangedListener mBNTTSPlayerStatusChanged;
  private ConditionVariable mCV = new ConditionVariable();
  private Handler mHandler;
  private a.b mIBNTTSBtStatusInterface;
  private IBNTTSVoiceHintListener mIBNTTSVoiceHintListener;
  private IBNTTSPlayerPCMListener mIBNttsPlayerPCMListener;
  private Handler mInitHandler = new MainLooperHandler(Module.NAV_MODULE, ScheduleConfig.forData())
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 5: 
        for (;;)
        {
          try
          {
            if ((!b.a().a("BDSpeechDecoder_V1")) || (!b.a().a("bd_etts")) || (!b.a().a("bdtts"))) {
              continue;
            }
            BaseTTSPlayer.access$002(true);
            if (BaseTTSPlayer.this.mInitHandler.hasMessages(5)) {
              BaseTTSPlayer.this.mInitHandler.removeMessages(5);
            }
            BaseTTSPlayer.this.mInitHandler.sendEmptyMessage(6);
          }
          catch (Throwable paramAnonymousMessage)
          {
            BaseTTSPlayer.access$002(false);
            BaseTTSPlayer.access$208();
            continue;
          }
          SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer mInitHandler MSG_RELOAD_SO sIsTTSSoLoadSuccess : " + BaseTTSPlayer.sIsTTSSoLoadSuccess + ", sReloadCnt: " + BaseTTSPlayer.sReloadCnt);
          return;
          BaseTTSPlayer.access$002(false);
          BaseTTSPlayer.access$208();
        }
      }
      BaiduNaviManager.getInstance().initTTSModule(NavMapAdapter.getInstance().getJNIInitializerContext());
      if (BaseTTSPlayer.this.mInitHandler.hasMessages(6)) {
        BaseTTSPlayer.this.mInitHandler.removeMessages(6);
      }
      BaseTTSPlayer.access$208();
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer mInitHandler MSG_REINIT_TTS : , sReloadCnt: " + BaseTTSPlayer.sReloadCnt);
    }
  };
  public boolean mIsCarlifeConnected = false;
  private boolean mIsUseBt = false;
  private OnTTSStateChangedListener mTTSListener = new OnTTSStateChangedListener()
  {
    public void onPlayEnd()
    {
      if (BaseTTSPlayer.this.mBNTTSPlayerStatusChanged != null) {
        BaseTTSPlayer.this.mBNTTSPlayerStatusChanged.onPlayEnd();
      }
      int i = BaseTTSPlayer.this.mTTSStateChangedListenerList.size() - 1;
      while (i >= 0)
      {
        try
        {
          OnTTSStateChangedListener localOnTTSStateChangedListener = (OnTTSStateChangedListener)BaseTTSPlayer.this.mTTSStateChangedListenerList.get(i);
          if (localOnTTSStateChangedListener != null) {
            localOnTTSStateChangedListener.onPlayEnd();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.baidu.baidunavis.wrapper.LogUtil.e("TTS-BaseTTSPlayer", "onPlayEnd Exception:" + localException.getMessage());
          }
        }
        i -= 1;
      }
      Object localObject = TTSPlayerControl.getTTSPlayStateListener();
      ArrayList localArrayList = new ArrayList();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localArrayList.addAll((Collection)localObject);
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((TTSPlayerControl.OnTTSPlayStateListener)((Iterator)localObject).next()).onPlayEnd();
        }
      }
      localObject = NavCommonFuncModel.getInstance().getContext();
      if (localObject != null) {
        AudioUtils.releaseAudioFocus((Context)localObject);
      }
    }
    
    public void onPlayError(int paramAnonymousInt, String paramAnonymousString)
    {
      if (BaseTTSPlayer.this.mBNTTSPlayerStatusChanged != null) {
        BaseTTSPlayer.this.mBNTTSPlayerStatusChanged.onPlayError(paramAnonymousInt, paramAnonymousString);
      }
      int i = BaseTTSPlayer.this.mTTSStateChangedListenerList.size() - 1;
      while (i >= 0)
      {
        try
        {
          OnTTSStateChangedListener localOnTTSStateChangedListener = (OnTTSStateChangedListener)BaseTTSPlayer.this.mTTSStateChangedListenerList.get(i);
          if (localOnTTSStateChangedListener != null) {
            localOnTTSStateChangedListener.onPlayError(paramAnonymousInt, paramAnonymousString);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.baidu.baidunavis.wrapper.LogUtil.e("TTS-BaseTTSPlayer", "onPlayError Exception:" + localException.getMessage());
          }
        }
        i -= 1;
      }
    }
    
    public void onPlayStart()
    {
      if (BaseTTSPlayer.this.mBNTTSPlayerStatusChanged != null) {
        BaseTTSPlayer.this.mBNTTSPlayerStatusChanged.onPlayStart();
      }
      int i = BaseTTSPlayer.this.mTTSStateChangedListenerList.size() - 1;
      while (i >= 0)
      {
        try
        {
          OnTTSStateChangedListener localOnTTSStateChangedListener = (OnTTSStateChangedListener)BaseTTSPlayer.this.mTTSStateChangedListenerList.get(i);
          if (localOnTTSStateChangedListener != null) {
            localOnTTSStateChangedListener.onPlayStart();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.baidu.baidunavis.wrapper.LogUtil.e("TTS-BaseTTSPlayer", "onPlayStart Exception:" + localException.getMessage());
          }
        }
        i -= 1;
      }
      Object localObject = TTSPlayerControl.getTTSPlayStateListener();
      ArrayList localArrayList = new ArrayList();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localArrayList.addAll((Collection)localObject);
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((TTSPlayerControl.OnTTSPlayStateListener)((Iterator)localObject).next()).onPlayStart();
        }
      }
      localObject = NavCommonFuncModel.getInstance().getContext();
      if (localObject != null) {
        AudioUtils.requestAudioFocus((Context)localObject);
      }
    }
  };
  private BdTTSPlayer mTTSPlayer = null;
  private HandlerThread mTTSPlayerThread;
  private List<OnTTSStateChangedListener> mTTSStateChangedListenerList = Collections.synchronizedList(new ArrayList());
  private int mTmpTTSState = -99;
  private boolean needSwitch = false;
  
  static
  {
    sIsTTSSoLoadSuccess = false;
    bStopVoiceOutput = false;
    mDingSound = null;
    mHighwayDididiSound = null;
  }
  
  private boolean checkTTSInitStatu()
  {
    boolean bool = true;
    if (!isTTSSoLoadSuccess())
    {
      SDKDebugFileUtil localSDKDebugFileUtil = SDKDebugFileUtil.getInstance();
      StringBuilder localStringBuilder = new StringBuilder().append(" BaseTTSPlayer playTTSText !isTTSSoLoadSuccess(): ");
      if (!isTTSSoLoadSuccess())
      {
        localSDKDebugFileUtil.addCoreLog("CoreLog_TTS: ", bool + ", sReloadCnt: " + sReloadCnt);
        if (sReloadCnt < 5) {
          this.mInitHandler.sendEmptyMessage(5);
        }
      }
    }
    do
    {
      return false;
      bool = false;
      break;
      if ((!isTTSSoLoadSuccess()) || (getInitState() != 0)) {
        break label140;
      }
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer playTTSText getInitState() == BdTTSPlayer.INIT_STATE_NO , sReloadCnt: " + sReloadCnt);
    } while (sReloadCnt >= 5);
    this.mInitHandler.sendEmptyMessage(6);
    return false;
    label140:
    return true;
  }
  
  public static void destory()
  {
    if ((mInstance != null) && (isTTSSoLoadSuccess())) {}
    try
    {
      if (mInstance != null) {
        mInstance.dispose();
      }
      mInstance = null;
      return;
    }
    finally {}
  }
  
  private void dispose()
  {
    if (!isTTSSoLoadSuccess()) {}
    do
    {
      return;
      if (mDingSound != null) {
        mDingSound.release();
      }
      if (mHighwayDididiSound != null) {
        mHighwayDididiSound.release();
      }
      if (mCruiserPassSound != null) {
        mCruiserPassSound.release();
      }
    } while (this.mTTSPlayer == null);
    this.mTTSPlayer.releaseTTSPlayer();
  }
  
  public static BaseTTSPlayer getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BaseTTSPlayer();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static boolean isTTSSoLoadSuccess()
  {
    return sIsTTSSoLoadSuccess;
  }
  
  public static void loadTTSSO()
  {
    com.baidu.baidunavis.wrapper.LogUtil.e("test", "loadSO!!!!!");
    int i = 0;
    while (i < 2)
    {
      try
      {
        if ((b.a().a("BDSpeechDecoder_V1")) && (b.a().a("bd_etts")) && (b.a().a("bdtts")))
        {
          sIsTTSSoLoadSuccess = true;
          return;
        }
        sIsTTSSoLoadSuccess = false;
        UserOPController.getInstance().add("7.2", "2", null, null);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          sIsTTSSoLoadSuccess = false;
          UserOPController.getInstance().add("7.2", "2", null, null);
        }
      }
      i += 1;
    }
  }
  
  public void addOnTTSStateChangedListener(OnTTSStateChangedListener paramOnTTSStateChangedListener)
  {
    if (!this.mTTSStateChangedListenerList.contains(paramOnTTSStateChangedListener)) {
      this.mTTSStateChangedListenerList.add(paramOnTTSStateChangedListener);
    }
  }
  
  public boolean canSwitchVoice()
  {
    if (!isTTSSoLoadSuccess()) {}
    while (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.canSwitchVoice();
  }
  
  public int cancelAudio()
  {
    if (this.mTTSPlayer == null) {
      return -1;
    }
    return this.mTTSPlayer.cancelAudio();
  }
  
  public void changeTTSPlayerVolume(boolean paramBoolean) {}
  
  public boolean freeCustomTTSVoiceData(String paramString, OnTTSVoiceDataSwitchListener paramOnTTSVoiceDataSwitchListener)
  {
    if (!isTTSSoLoadSuccess()) {}
    while (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.freeCustomTTSVoice(paramString, paramOnTTSVoiceDataSwitchListener);
  }
  
  public int getCurrentProgress()
  {
    if (this.mTTSPlayer != null) {
      return this.mTTSPlayer.getCurrentProgress();
    }
    return -1;
  }
  
  public String getCurrentTTSVoiceDataPath()
  {
    if (this.mTTSPlayer != null) {
      return this.mTTSPlayer.getCurrentTTSVoiceDataPath();
    }
    return null;
  }
  
  public int getCurrentVolume()
  {
    if (this.mTTSPlayer != null) {
      return this.mTTSPlayer.getCurrentVolume();
    }
    return 1;
  }
  
  public String getCustomVoiceDataPath()
  {
    if (!isTTSSoLoadSuccess()) {
      return "";
    }
    if (this.mTTSPlayer == null) {
      return "";
    }
    return this.mTTSPlayer.getCustomVoiceDataPath();
  }
  
  public IBNTTSPlayerPCMListener getIBNttsPlayerPCMListener()
  {
    return this.mIBNttsPlayerPCMListener;
  }
  
  public int getInitState()
  {
    if (this.mTTSPlayer == null) {
      return 0;
    }
    return this.mTTSPlayer.getInitState();
  }
  
  public String getLastTTSVoiceDataPath()
  {
    if (this.mTTSPlayer != null) {
      return this.mTTSPlayer.getLastTTSVoiceDataPath();
    }
    return "bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat";
  }
  
  public int getTTSState()
  {
    boolean bool2 = true;
    int i = 0;
    for (;;)
    {
      try
      {
        if (!isTTSSoLoadSuccess())
        {
          Object localObject1 = SDKDebugFileUtil.getInstance();
          StringBuilder localStringBuilder = new StringBuilder().append(" BaseTTSPlayer getTTSState !isTTSSoLoadSuccess(): ");
          if (!isTTSSoLoadSuccess())
          {
            bool1 = true;
            ((SDKDebugFileUtil)localObject1).addCoreLog("CoreLog_TTS: ", bool1);
            localObject1 = new StringBuilder().append(" BaseTTSPlayer getTTSState !isTTSSoLoadSuccess(): ");
            if (!isTTSSoLoadSuccess())
            {
              bool1 = bool2;
              com.baidu.navisdk.util.common.LogUtil.e("TTS-BaseTTSPlayer", bool1);
              return i;
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          boolean bool1 = false;
          continue;
        }
        if ((this.mTTSPlayer == null) || (this.mHandler == null))
        {
          SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer getTTSState mTTSPlayer: " + this.mTTSPlayer + " mHandler: " + this.mHandler);
          com.baidu.navisdk.util.common.LogUtil.e("TTS-BaseTTSPlayer", "BaseTTSPlayer getTTSState mTTSPlayer: " + this.mTTSPlayer + " mHandler: " + this.mHandler);
          continue;
        }
        this.mTmpTTSState = -99;
      }
      finally {}
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (BaseTTSPlayer.this.mTTSPlayer != null)
          {
            BaseTTSPlayer.access$602(BaseTTSPlayer.this, BaseTTSPlayer.this.mTTSPlayer.getTTSState());
            com.baidu.navisdk.util.common.LogUtil.e("TTS-BaseTTSPlayer", "BaseTTSPlayer getTTSState in Handler -->mTmpTTSState = " + BaseTTSPlayer.this.mTmpTTSState);
          }
          BaseTTSPlayer.this.mCV.open();
        }
      });
      this.mCV.block(1000L);
      this.mCV.close();
      com.baidu.navisdk.util.common.LogUtil.e("TTS-BaseTTSPlayer", "BaseTTSPlayer mCV.close() --> mTmpTTSState = " + this.mTmpTTSState);
      if (this.mTmpTTSState != -99) {
        i = this.mTmpTTSState;
      }
    }
  }
  
  public boolean getTTSVoiceDataCustom()
  {
    if (!isTTSSoLoadSuccess()) {}
    while (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.getTTSVoiceDataCustom();
  }
  
  public boolean getVoiceState()
  {
    if (this.mTTSPlayer != null) {
      return this.mTTSPlayer.getVoiceState();
    }
    return false;
  }
  
  /* Error */
  public void initPlayer(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 368	com/baidu/navisdk/comapi/setting/BNSettingManager:init	(Landroid/content/Context;)V
    //   4: aload_1
    //   5: ifnull +174 -> 179
    //   8: invokestatic 170	com/baidu/baidunavis/tts/BaseTTSPlayer:isTTSSoLoadSuccess	()Z
    //   11: ifeq +168 -> 179
    //   14: aload_2
    //   15: ifnull +164 -> 179
    //   18: aload_2
    //   19: invokevirtual 373	java/lang/String:length	()I
    //   22: ifle +157 -> 179
    //   25: aload_0
    //   26: invokevirtual 212	com/baidu/baidunavis/tts/BaseTTSPlayer:getInitState	()I
    //   29: ifne +150 -> 179
    //   32: new 222	com/baidu/baidunavis/tts/SoundUtils
    //   35: dup
    //   36: ldc_w 374
    //   39: invokespecial 377	com/baidu/baidunavis/tts/SoundUtils:<init>	(I)V
    //   42: putstatic 87	com/baidu/baidunavis/tts/BaseTTSPlayer:mDingSound	Lcom/baidu/baidunavis/tts/SoundUtils;
    //   45: new 222	com/baidu/baidunavis/tts/SoundUtils
    //   48: dup
    //   49: ldc_w 378
    //   52: invokespecial 377	com/baidu/baidunavis/tts/SoundUtils:<init>	(I)V
    //   55: putstatic 89	com/baidu/baidunavis/tts/BaseTTSPlayer:mHighwayDididiSound	Lcom/baidu/baidunavis/tts/SoundUtils;
    //   58: new 222	com/baidu/baidunavis/tts/SoundUtils
    //   61: dup
    //   62: ldc_w 379
    //   65: invokespecial 377	com/baidu/baidunavis/tts/SoundUtils:<init>	(I)V
    //   68: putstatic 91	com/baidu/baidunavis/tts/BaseTTSPlayer:mCruiserPassSound	Lcom/baidu/baidunavis/tts/SoundUtils;
    //   71: aload_0
    //   72: getfield 97	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSPlayer	Lcom/baidu/baidunavis/tts/BdTTSPlayer;
    //   75: ifnonnull +104 -> 179
    //   78: aload_0
    //   79: invokevirtual 212	com/baidu/baidunavis/tts/BaseTTSPlayer:getInitState	()I
    //   82: istore_3
    //   83: iload_3
    //   84: ifne +95 -> 179
    //   87: aload_0
    //   88: new 227	com/baidu/baidunavis/tts/BdTTSPlayer
    //   91: dup
    //   92: invokespecial 380	com/baidu/baidunavis/tts/BdTTSPlayer:<init>	()V
    //   95: putfield 97	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSPlayer	Lcom/baidu/baidunavis/tts/BdTTSPlayer;
    //   98: aload_0
    //   99: new 382	android/os/HandlerThread
    //   102: dup
    //   103: ldc_w 384
    //   106: invokespecial 387	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   109: putfield 389	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSPlayerThread	Landroid/os/HandlerThread;
    //   112: aload_0
    //   113: getfield 389	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSPlayerThread	Landroid/os/HandlerThread;
    //   116: invokevirtual 392	android/os/HandlerThread:start	()V
    //   119: aload_0
    //   120: new 205	android/os/Handler
    //   123: dup
    //   124: aload_0
    //   125: getfield 389	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSPlayerThread	Landroid/os/HandlerThread;
    //   128: invokevirtual 396	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   131: invokespecial 399	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   134: putfield 327	com/baidu/baidunavis/tts/BaseTTSPlayer:mHandler	Landroid/os/Handler;
    //   137: aload_0
    //   138: getfield 97	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSPlayer	Lcom/baidu/baidunavis/tts/BdTTSPlayer;
    //   141: aload_1
    //   142: aload_2
    //   143: invokevirtual 401	com/baidu/baidunavis/tts/BdTTSPlayer:initPlayer	(Landroid/content/Context;Ljava/lang/String;)V
    //   146: aload_0
    //   147: getfield 97	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSPlayer	Lcom/baidu/baidunavis/tts/BdTTSPlayer;
    //   150: aload_0
    //   151: getfield 137	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSListener	Lcom/baidu/mapframework/tts/OnTTSStateChangedListener;
    //   154: invokevirtual 404	com/baidu/baidunavis/tts/BdTTSPlayer:setOnTTSStateChangedListener	(Lcom/baidu/mapframework/tts/OnTTSStateChangedListener;)V
    //   157: aload_0
    //   158: getfield 97	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSPlayer	Lcom/baidu/baidunavis/tts/BdTTSPlayer;
    //   161: aload_0
    //   162: getfield 313	com/baidu/baidunavis/tts/BaseTTSPlayer:mIBNttsPlayerPCMListener	Lcom/baidu/baidunavis/tts/IBNTTSPlayerPCMListener;
    //   165: invokevirtual 408	com/baidu/baidunavis/tts/BdTTSPlayer:setIBNTTSPlayerPCMListener	(Lcom/baidu/baidunavis/tts/IBNTTSPlayerPCMListener;)V
    //   168: aload_0
    //   169: getfield 97	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSPlayer	Lcom/baidu/baidunavis/tts/BdTTSPlayer;
    //   172: aload_0
    //   173: getfield 410	com/baidu/baidunavis/tts/BaseTTSPlayer:mIBNTTSVoiceHintListener	Lcom/baidu/baidunavis/tts/IBNTTSVoiceHintListener;
    //   176: invokevirtual 414	com/baidu/baidunavis/tts/BdTTSPlayer:setIBNTTSVoiceHintListener	(Lcom/baidu/baidunavis/tts/IBNTTSVoiceHintListener;)V
    //   179: return
    //   180: astore_1
    //   181: aload_0
    //   182: aconst_null
    //   183: putfield 97	com/baidu/baidunavis/tts/BaseTTSPlayer:mTTSPlayer	Lcom/baidu/baidunavis/tts/BdTTSPlayer;
    //   186: ldc_w 416
    //   189: aload_1
    //   190: invokevirtual 419	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   193: invokestatic 244	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: return
    //   197: astore_1
    //   198: return
    //   199: astore 4
    //   201: goto -197 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	BaseTTSPlayer
    //   0	204	1	paramContext	Context
    //   0	204	2	paramString	String
    //   82	2	3	i	int
    //   199	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   87	179	180	java/lang/Throwable
    //   8	14	197	java/lang/Throwable
    //   18	83	197	java/lang/Throwable
    //   181	196	197	java/lang/Throwable
    //   0	4	199	java/lang/Exception
  }
  
  public boolean isJinshaTTS()
  {
    if (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.isJinshaTTS();
  }
  
  public boolean isNaviMuteState()
  {
    if (this.mTTSPlayer != null) {
      return this.mTTSPlayer.isNaviMute();
    }
    return false;
  }
  
  public boolean loadCustomResource(String paramString)
  {
    if ((!isTTSSoLoadSuccess()) || (paramString == null)) {}
    while (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.loadCustomResource(paramString);
  }
  
  public boolean loadCustomTTSVoiceData(String paramString, OnTTSVoiceDataSwitchListener paramOnTTSVoiceDataSwitchListener)
  {
    if (!isTTSSoLoadSuccess()) {}
    while (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.loadCustomTTSVoice(paramString, paramOnTTSVoiceDataSwitchListener);
  }
  
  public int pauseTTS()
  {
    bStopVoiceOutput = true;
    if ((!isTTSSoLoadSuccess()) || (this.mTTSPlayer == null)) {
      return -1;
    }
    return this.mTTSPlayer.pauseTTS();
  }
  
  public int playAudio(String paramString, IBNTTSPlayerListener.AudioPlayerListener paramAudioPlayerListener)
  {
    if (this.mTTSPlayer == null) {
      return -1;
    }
    return this.mTTSPlayer.playAudio(paramString, paramAudioPlayerListener);
  }
  
  public int playTTSText(final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    if (((BNSettingManager.getVoiceMode() == 2) && (BNavigator.getInstance().isNaviBegin())) || (this.mTTSPlayer == null) || (this.mTTSPlayer.isNaviMute()))
    {
      NavLogUtils.e("BaseTTSPlayer", "voice mode is Quite, return");
      com.baidu.navisdk.util.common.LogUtil.e("TTS-BaseTTSPlayer", "voice mode is Quite, return");
      return 0;
    }
    if (!checkTTSInitStatu()) {
      return 0;
    }
    String str = EnterQuitLogicManager.getmInstance().cruiseEnterPromptTransfer(paramString1);
    switchTTSVolume();
    if ((this.mTTSPlayer == null) || (this.mTTSPlayer.getVoiceState()) || (this.mTTSPlayer.isNaviMute())) {
      return 0;
    }
    if ((str == null) || (str.length() == 0))
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer playTTSText speech == null || speech.length() == 0");
      com.baidu.navisdk.util.common.LogUtil.e("TTS-BaseTTSPlayer", " BaseTTSPlayer playTTSText speech == null || speech.length() == 0");
      return 0;
    }
    if (!bStopVoiceOutput)
    {
      if (str.startsWith("叮"))
      {
        if (mDingSound != null) {
          mDingSound.play();
        }
        return 1;
      }
      if (str.startsWith("嗒嗒嗒"))
      {
        if (mCruiserPassSound != null) {
          mCruiserPassSound.play();
        }
        com.baidu.navisdk.util.common.LogUtil.e("TTS-BaseTTSPlayer", "speech.startsWith(CRUISERVOICEPREFIX)");
        return 1;
      }
      paramString1 = str;
      if (str.startsWith("嘀嘀嘀"))
      {
        if (mHighwayDididiSound != null) {
          mHighwayDididiSound.play();
        }
        paramString1 = str.substring("嘀嘀嘀".length());
      }
      if ((this.mTTSPlayer == null) || (this.mHandler == null))
      {
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer playTTSText mTTSPlayer == null || mHandler == null");
        com.baidu.navisdk.util.common.LogUtil.e("TTS-BaseTTSPlayer", " BaseTTSPlayer playTTSText mTTSPlayer == null || mHandler == null");
        return 0;
      }
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          NavLogUtils.e("XDVoice", "playTTSText > " + paramString1);
          BdTTSPlayer localBdTTSPlayer = BaseTTSPlayer.this.mTTSPlayer;
          String str1 = paramString1;
          String str2 = paramString2;
          if (paramBoolean) {}
          for (int i = 1;; i = 0)
          {
            localBdTTSPlayer.playTTSText(str1, str2, i);
            return;
          }
        }
      }, 200L);
      return 1;
    }
    SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer playTTSText bStopVoiceOutput " + bStopVoiceOutput);
    com.baidu.navisdk.util.common.LogUtil.e("TTS-BaseTTSPlayer", " BaseTTSPlayer playTTSText bStopVoiceOutput " + bStopVoiceOutput);
    return 0;
  }
  
  public int playTTSText(String paramString, boolean paramBoolean)
  {
    return playTTSText(paramString, null, paramBoolean);
  }
  
  public int playVoiceTTSText(String paramString, int paramInt)
  {
    if (!checkTTSInitStatu())
    {
      com.baidu.baidunavis.wrapper.LogUtil.e("test", "TTS init error !!!!!");
      return 0;
    }
    switchTTSVolume();
    if ((paramString == null) || (paramString.length() == 0))
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer playTTSText speech == null || speech.length() == 0");
      return 0;
    }
    if (!bStopVoiceOutput)
    {
      if ((this.mTTSPlayer == null) || (this.mHandler == null))
      {
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer playTTSText mTTSPlayer == null || mHandler == null");
        return 0;
      }
      return this.mTTSPlayer.playVoiceTTSText(paramString, paramInt);
    }
    SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer playTTSText bStopVoiceOutput " + bStopVoiceOutput);
    return 0;
  }
  
  public int playWeChatTTSText(String paramString, int paramInt)
  {
    if (!checkTTSInitStatu()) {
      return 0;
    }
    switchTTSVolume();
    if ((this.mTTSPlayer == null) || (this.mTTSPlayer.getVoiceState())) {
      return 0;
    }
    if ((paramString == null) || (paramString.length() == 0))
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer playTTSText speech == null || speech.length() == 0");
      return 0;
    }
    if (!bStopVoiceOutput)
    {
      if ((this.mTTSPlayer == null) || (this.mHandler == null))
      {
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer playTTSText mTTSPlayer == null || mHandler == null");
        return 0;
      }
      return this.mTTSPlayer.playWeChatTTSText(paramString, paramInt);
    }
    SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer playTTSText bStopVoiceOutput " + bStopVoiceOutput);
    return 0;
  }
  
  public boolean recoveryToNavVoice()
  {
    if (!isTTSSoLoadSuccess()) {}
    while (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.recoveryToNavVoice();
  }
  
  public void releaseTTSPlayer()
  {
    bStopVoiceOutput = false;
    if ((!isTTSSoLoadSuccess()) || (this.mTTSPlayer == null)) {
      return;
    }
    this.mTTSPlayer.releaseTTSPlayer();
  }
  
  public void removeOnTTSStateChangedListener(OnTTSStateChangedListener paramOnTTSStateChangedListener)
  {
    if (this.mTTSStateChangedListenerList.contains(paramOnTTSStateChangedListener)) {
      this.mTTSStateChangedListenerList.remove(paramOnTTSStateChangedListener);
    }
  }
  
  public int resumeTTS()
  {
    bStopVoiceOutput = false;
    if ((!isTTSSoLoadSuccess()) || (this.mTTSPlayer == null)) {
      return -1;
    }
    return this.mTTSPlayer.resumeTTS();
  }
  
  public void setBNTTSPlayerStatusChangedWeChat(IBNTTSPlayerWeChatListener paramIBNTTSPlayerWeChatListener)
  {
    if (this.mTTSPlayer != null) {
      this.mTTSPlayer.setBNTTSPlayerStatusChangedWeChat(paramIBNTTSPlayerWeChatListener);
    }
  }
  
  public void setCarLifeConnected(boolean paramBoolean)
  {
    this.mIsCarlifeConnected = paramBoolean;
    if (this.mIBNTTSBtStatusInterface != null) {
      this.mIsUseBt = this.mIBNTTSBtStatusInterface.a();
    }
    if ((this.mIsCarlifeConnected) && (!this.mIsUseBt))
    {
      setStereoVolume(0.0F, 0.0F);
      return;
    }
    setStereoVolume(1.0F, 1.0F);
  }
  
  public void setCurrentSelectPath(String paramString)
  {
    if (this.mTTSPlayer != null) {
      this.mTTSPlayer.setCurrentSelectPath(paramString);
    }
  }
  
  public void setCurrentVolume(int paramInt)
  {
    if (this.mTTSPlayer != null)
    {
      int i = paramInt;
      if (paramInt > 15) {
        i = 15;
      }
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      com.baidu.baidunavis.wrapper.LogUtil.e("navSDK", "setCurrentVolume = " + paramInt);
      this.mTTSPlayer.setCurrentVolume(paramInt);
    }
  }
  
  public boolean setCustomParams(boolean paramBoolean)
  {
    if (!isTTSSoLoadSuccess()) {}
    while (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.setCustomParams(paramBoolean);
  }
  
  public void setEnableTimeOut(boolean paramBoolean)
  {
    if (this.mTTSPlayer == null) {
      return;
    }
    this.mTTSPlayer.setEnableTimeOut(paramBoolean);
  }
  
  public void setIBNTTSBtStatusInterface(a.b paramb)
  {
    this.mIBNTTSBtStatusInterface = paramb;
  }
  
  public void setIBNTTSPlayerPCMListener(IBNTTSPlayerPCMListener paramIBNTTSPlayerPCMListener)
  {
    this.mIBNttsPlayerPCMListener = paramIBNTTSPlayerPCMListener;
    if (this.mTTSPlayer != null) {
      this.mTTSPlayer.setIBNTTSPlayerPCMListener(paramIBNTTSPlayerPCMListener);
    }
  }
  
  public void setIBNTTSVoiceHintListener(IBNTTSVoiceHintListener paramIBNTTSVoiceHintListener)
  {
    this.mIBNTTSVoiceHintListener = paramIBNTTSVoiceHintListener;
    if (this.mTTSPlayer != null) {
      this.mTTSPlayer.setIBNTTSVoiceHintListener(paramIBNTTSVoiceHintListener);
    }
  }
  
  public void setNaviMuteState(boolean paramBoolean)
  {
    if (this.mTTSPlayer != null) {
      this.mTTSPlayer.setNaviMute(paramBoolean);
    }
  }
  
  public void setOnTTSStateChangedListener(OnTTSStateChangedListener paramOnTTSStateChangedListener)
  {
    this.mBNTTSPlayerStatusChanged = paramOnTTSStateChangedListener;
  }
  
  public void setPhoneIn(boolean paramBoolean)
  {
    if (this.mTTSPlayer == null) {
      return;
    }
    this.mTTSPlayer.setPhoneIn(paramBoolean);
  }
  
  public void setPlayModeAsync() {}
  
  public void setPlayModeSync() {}
  
  public int setPlaySpeed(int paramInt)
  {
    if (this.mTTSPlayer != null) {
      return this.mTTSPlayer.setPlaySpeed(paramInt);
    }
    return -1;
  }
  
  public int setStereoVolume(float paramFloat1, float paramFloat2)
  {
    if (this.mTTSPlayer == null) {
      return 0;
    }
    return this.mTTSPlayer.setStereoVolume(paramFloat1, paramFloat2);
  }
  
  public void setTTSStreamType(int paramInt)
  {
    if (this.mTTSPlayer != null) {
      this.mTTSPlayer.setTTSStreamType(paramInt);
    }
  }
  
  public void setTTSVocoderParam()
  {
    SpeechSynthesizer.getInstance().setParam(SpeechSynthesizer.PARAM_VOCODER_OPTIM_LEVEL, BNSettingManager.getTTSVocoderParam());
  }
  
  public boolean setTTSVoiceDataPath(String paramString)
  {
    if (!isTTSSoLoadSuccess()) {}
    while (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.setTTSVoiceDataPath(paramString);
  }
  
  public void setVoiceState(boolean paramBoolean)
  {
    if (this.mTTSPlayer != null) {
      this.mTTSPlayer.setVoiceState(paramBoolean);
    }
  }
  
  public void stopSound()
  {
    if (mDingSound != null) {
      mDingSound.stop();
    }
    if (mHighwayDididiSound != null) {
      mHighwayDididiSound.stop();
    }
    if (mCruiserPassSound != null) {
      mCruiserPassSound.stop();
    }
  }
  
  public void stopTTS()
  {
    if ((getTTSState() != 2) || (!isTTSSoLoadSuccess()) || (this.mTTSPlayer == null)) {
      return;
    }
    this.mTTSPlayer.stopTTS();
  }
  
  public void stopTTSVR()
  {
    if ((getTTSState() != 2) || (!isTTSSoLoadSuccess()) || (this.mTTSPlayer == null)) {
      return;
    }
    this.mTTSPlayer.stopTTSVR();
  }
  
  public void stopTTSWX()
  {
    if ((getTTSState() != 2) || (!isTTSSoLoadSuccess()) || (this.mTTSPlayer == null)) {
      return;
    }
    this.mTTSPlayer.stopTTSWX();
  }
  
  public boolean switchTTSVoiceData(String paramString, OnTTSVoiceDataSwitchListener paramOnTTSVoiceDataSwitchListener)
  {
    if (!isTTSSoLoadSuccess()) {}
    while (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.switchTTSVoiceDataAsync(paramString, null, true, paramOnTTSVoiceDataSwitchListener);
  }
  
  public boolean switchTTSVoiceDataSync(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!isTTSSoLoadSuccess()) {}
    while (this.mTTSPlayer == null) {
      return false;
    }
    return this.mTTSPlayer.switchTTSVoiceDataSync(paramString1, paramString2, paramBoolean);
  }
  
  public void switchTTSVolume()
  {
    if ((this.mIBNTTSBtStatusInterface != null) && (this.mIBNTTSBtStatusInterface.a() != this.mIsUseBt))
    {
      this.mIsUseBt = this.mIBNTTSBtStatusInterface.a();
      this.needSwitch = true;
    }
    if (this.needSwitch)
    {
      if ((!this.mIsCarlifeConnected) || (this.mIsUseBt)) {
        break label75;
      }
      setStereoVolume(0.0F, 0.0F);
    }
    for (;;)
    {
      this.needSwitch = false;
      return;
      label75:
      setStereoVolume(1.0F, 1.0F);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/tts/BaseTTSPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */