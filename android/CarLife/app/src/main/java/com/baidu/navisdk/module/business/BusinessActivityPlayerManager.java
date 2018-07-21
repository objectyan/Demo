package com.baidu.navisdk.module.business;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener.AudioPlayerListener;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.util.common.LogUtil;

public class BusinessActivityPlayerManager
{
  public static final int AUDIO_PLAY_TIMEOUT = 15000;
  private static final int MSG_FORCE_RESET_PLAY_AUDIO = 102;
  private static final int MSG_PLAY_AUDIO = 101;
  private static final int MSG_PLAY_TEXT = 100;
  private static final String TAG = BusinessActivityPlayerManager.class.getSimpleName();
  private static Object mSyncObj = new Object();
  private static BusinessActivityPlayerManager sInstance = null;
  private Handler mHD = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((100 == paramAnonymousMessage.what) && (paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof String))) {
        if ((paramAnonymousMessage.arg1 == 2) && (!BNaviModuleManager.isAppForeground())) {
          LogUtil.e(BusinessActivityPlayerManager.TAG, "handleMessage()1 return for background.");
        }
      }
      do
      {
        return;
        BusinessActivityPlayerManager.this.playText((String)paramAnonymousMessage.obj);
        return;
        if ((101 == paramAnonymousMessage.what) && (paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof String)))
        {
          if ((paramAnonymousMessage.arg1 == 2) && (!BNaviModuleManager.isAppForeground()))
          {
            LogUtil.e(BusinessActivityPlayerManager.TAG, "handleMessage()2 return for background.");
            return;
          }
          BusinessActivityPlayerManager.this.playAudio((String)paramAnonymousMessage.obj, paramAnonymousMessage.arg1);
          return;
        }
      } while (102 != paramAnonymousMessage.what);
      BusinessActivityPlayerManager.access$302(BusinessActivityPlayerManager.this, false);
      BusinessActivityPlayerManager.this.cancelPlayAudio();
    }
  };
  private boolean mIsAudioPlaying = false;
  
  public static BusinessActivityPlayerManager getInstance()
  {
    if (sInstance == null) {}
    synchronized (mSyncObj)
    {
      if (sInstance == null) {
        sInstance = new BusinessActivityPlayerManager();
      }
      return sInstance;
    }
  }
  
  private void playAudio(String paramString, int paramInt)
  {
    cancelPlayAudio();
    if (TTSPlayerControl.getTTSState() == 1)
    {
      this.mIsAudioPlaying = true;
      LogUtil.e(TAG, "playAudio() audio play true 1");
      try
      {
        TTSPlayerControl.stopVoiceTTSOutput();
        TTSPlayerControl.playAudio(paramString, new IBNTTSPlayerListener.AudioPlayerListener()
        {
          public void playCompletion()
          {
            BusinessActivityPlayerManager.this.cancelPlayAudio();
          }
        });
        this.mIsAudioPlaying = true;
        LogUtil.e(TAG, "playAudio() audio play true 2");
        if (this.mHD.hasMessages(102)) {
          this.mHD.removeMessages(102);
        }
        this.mHD.sendEmptyMessageDelayed(102, 15000L);
        return;
      }
      catch (Exception paramString)
      {
        this.mIsAudioPlaying = false;
        return;
      }
    }
    this.mIsAudioPlaying = false;
    Message localMessage = this.mHD.obtainMessage(101);
    localMessage.arg1 = paramInt;
    localMessage.obj = paramString;
    this.mHD.sendMessageDelayed(localMessage, 1000L);
  }
  
  private void playText(String paramString)
  {
    if (TTSPlayerControl.getTTSState() == 1)
    {
      TTSPlayerControl.playTTS(paramString, 0);
      return;
    }
    Message localMessage = this.mHD.obtainMessage(100);
    localMessage.obj = paramString;
    this.mHD.sendMessageDelayed(localMessage, 1000L);
  }
  
  public void cancelPlayAudio()
  {
    LogUtil.e(TAG, "cancelPlayAudio");
    if (this.mHD.hasMessages(102)) {
      this.mHD.removeMessages(102);
    }
    TTSPlayerControl.cancelAudio();
    this.mIsAudioPlaying = false;
  }
  
  public void cancelPlayAudioAndPlayMsg()
  {
    if (this.mHD.hasMessages(101)) {
      this.mHD.removeMessages(101);
    }
    if (this.mHD.hasMessages(100)) {
      this.mHD.removeMessages(100);
    }
    cancelPlayAudio();
  }
  
  public boolean isAudioPlaying()
  {
    return this.mIsAudioPlaying;
  }
  
  public void playContentWhenShowActivity()
  {
    if ((!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().showVoiceLink)) && (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().showVoicePath)))
    {
      playAudio(BusinessActivityManager.getInstance().getModel().showVoicePath, 3);
      LogUtil.e(TAG, "playContentWhenShowActivity() play audio");
    }
    while (TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().showVoiceText)) {
      return;
    }
    playText(BusinessActivityManager.getInstance().getModel().showVoiceText);
    LogUtil.e(TAG, "playContentWhenShowActivity() play text");
  }
  
  public void playHolidayRedGift()
  {
    if ((!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().envelopeSoundEffectLink)) && (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().envelopeSoundEffectPath)))
    {
      Message localMessage = this.mHD.obtainMessage(101);
      localMessage.arg1 = 1;
      localMessage.obj = BusinessActivityManager.getInstance().getModel().envelopeSoundEffectPath;
      this.mHD.sendMessage(localMessage);
      LogUtil.e(TAG, "playHolidayRedGift() play audio");
    }
  }
  
  public void playNaviEndContent()
  {
    if (!BNaviModuleManager.isAppForeground()) {
      LogUtil.e(TAG, "playNaviEndContent() return for background.");
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voiceLinkOnEndNavi)) && (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voicePathOnEndNavi)))
      {
        localMessage = this.mHD.obtainMessage(101);
        localMessage.arg1 = 2;
        localMessage.obj = BusinessActivityManager.getInstance().getModel().voicePathOnEndNavi;
        this.mHD.sendMessageDelayed(localMessage, 1200L);
        LogUtil.e(TAG, "playNaviEndContent() play audio");
        return;
      }
    } while (TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voiceTextOnEndNavi));
    Message localMessage = this.mHD.obtainMessage(100);
    localMessage.obj = BusinessActivityManager.getInstance().getModel().voiceTextOnEndNavi;
    this.mHD.sendMessageDelayed(localMessage, 1200L);
    LogUtil.e(TAG, "playNaviEndContent() play text");
  }
  
  public void playNaviStartContent()
  {
    if ((!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voiceLinkOnStartNavi)) && (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voicePathOnStartNavi)))
    {
      localMessage = this.mHD.obtainMessage(101);
      localMessage.arg1 = 1;
      localMessage.obj = BusinessActivityManager.getInstance().getModel().voicePathOnStartNavi;
      this.mHD.sendMessageDelayed(localMessage, 1200L);
      LogUtil.e(TAG, "playNaviStartContent() play audio");
    }
    while (TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voiceTextOnStartNavi)) {
      return;
    }
    Message localMessage = this.mHD.obtainMessage(100);
    localMessage.obj = BusinessActivityManager.getInstance().getModel().voiceTextOnStartNavi;
    this.mHD.sendMessageDelayed(localMessage, 1200L);
    LogUtil.e(TAG, "playNaviStartContent() play text");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/business/BusinessActivityPlayerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */