package com.baidu.navisdk.ui.voice.controller;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import java.util.ArrayList;

public class VoicePlayController
{
  private AudioPlayer mAudioPlayer = new AudioPlayer();
  private PlayAllAudioEndListener mPlayAllEndListener = null;
  private PlayHandler mPlayHandler = null;
  
  public static VoicePlayController getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private boolean play(String paramString)
  {
    this.mAudioPlayer.stop();
    return this.mAudioPlayer.start(paramString);
  }
  
  public void initPlayAllVoice()
  {
    this.mPlayHandler = new PlayHandler();
    this.mPlayHandler.init();
  }
  
  public boolean initPlayer()
  {
    return this.mAudioPlayer.init();
  }
  
  public void playAllVoice(ArrayList<String> paramArrayList)
  {
    if (this.mPlayHandler != null)
    {
      this.mPlayHandler.start(paramArrayList);
      LogUtil.e("BNVoice", "start play all voice");
    }
  }
  
  public void playVoice(String paramString)
  {
    stopPlayVoice();
    paramString = VoiceHelper.getInstance().getVoiceSetPath(paramString);
    if (!StringUtils.isEmpty(paramString)) {
      play(paramString);
    }
  }
  
  public void playVoice(String paramString1, String paramString2)
  {
    stopPlayVoice();
    paramString1 = VoiceHelper.getInstance().getVoiceItemPath(paramString1, paramString2);
    if (!StringUtils.isEmpty(paramString1)) {
      play(paramString1);
    }
  }
  
  public void releasePlayAllVoice()
  {
    if (this.mPlayHandler != null) {
      this.mPlayHandler.destory();
    }
  }
  
  public void releasePlayer()
  {
    this.mAudioPlayer.stop();
    this.mAudioPlayer.release();
  }
  
  public void setAudioPlayCompleteListener(AudioPlayer.OnVoicePlayCompletedListener paramOnVoicePlayCompletedListener)
  {
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setPlayCompletedListener(paramOnVoicePlayCompletedListener);
    }
  }
  
  public void setPlayAllAudioEndListener(PlayAllAudioEndListener paramPlayAllAudioEndListener)
  {
    this.mPlayAllEndListener = paramPlayAllAudioEndListener;
  }
  
  public void stopAllVoice()
  {
    if (this.mPlayHandler != null)
    {
      this.mPlayHandler.stop();
      LogUtil.e("BNVoice", "stop play all voice");
    }
  }
  
  public void stopPlayVoice()
  {
    this.mAudioPlayer.stop();
  }
  
  private static class LazyHolder
  {
    public static final VoicePlayController sInstance = new VoicePlayController(null);
  }
  
  public static abstract interface PlayAllAudioEndListener
  {
    public abstract void onPlayAllEnd();
  }
  
  class PlayHandler
    extends Handler
  {
    private static final int MSG_END_PALY_AUDIO = 2;
    private static final int MSG_NEXT_PALY_AUDIO = 1;
    private static final int MSG_STOP_PLAY_AUDIO = 0;
    private AudioPlayer audioPlayer = new AudioPlayer();
    private ArrayList<String> auidoPaths = new ArrayList();
    private long delayMillis = 500L;
    private boolean init = false;
    private Object mutex = new Object();
    private int playPos = 0;
    private int playSize = 0;
    private boolean start = false;
    private boolean stop = false;
    
    PlayHandler() {}
    
    private void handleNextPlay()
    {
      if (this.stop) {
        return;
      }
      for (;;)
      {
        synchronized (this.mutex)
        {
          LogUtil.e("BNVoice", "playHandler play end " + this.playPos);
          this.playPos += 1;
          if (this.playPos < this.playSize)
          {
            sendEmptyMessageDelayed(1, this.delayMillis);
            return;
          }
        }
        sendEmptyMessage(2);
      }
    }
    
    public void destory()
    {
      if (this.start) {
        sendEmptyMessage(0);
      }
      if (this.init)
      {
        this.audioPlayer.release();
        this.init = false;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        for (;;)
        {
          return;
          LogUtil.e("BNVoice", "handle msg stop play all voice");
          removeMessages(1);
          this.audioPlayer.stop();
          return;
          LogUtil.e("BNVoice", "handle msg next play all voice");
          if (!this.stop)
          {
            paramMessage = null;
            synchronized (this.mutex)
            {
              if (this.auidoPaths.size() > this.playPos) {
                paramMessage = (String)this.auidoPaths.get(this.playPos);
              }
              if (!this.audioPlayer.start(paramMessage))
              {
                handleNextPlay();
                return;
              }
            }
          }
        }
        LogUtil.e("BNVoice", "handle msg end play all voice");
        this.start = false;
        this.stop = true;
      } while (VoicePlayController.this.mPlayAllEndListener == null);
      VoicePlayController.this.mPlayAllEndListener.onPlayAllEnd();
    }
    
    public void init()
    {
      if (!this.init) {
        this.init = this.audioPlayer.init();
      }
    }
    
    public void start(ArrayList<String> paramArrayList)
    {
      if (!this.start)
      {
        this.auidoPaths.clear();
        this.auidoPaths.addAll(paramArrayList);
        this.playPos = 0;
        this.playSize = this.auidoPaths.size();
        this.audioPlayer.setPlayCompletedListener(new AudioPlayer.OnVoicePlayCompletedListener()
        {
          public void onPlaycompleted()
          {
            VoicePlayController.PlayHandler.this.handleNextPlay();
          }
        });
        sendEmptyMessage(1);
        this.start = true;
        this.stop = false;
      }
    }
    
    public void stop()
    {
      if (this.start)
      {
        sendEmptyMessage(0);
        this.stop = true;
        this.start = false;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/controller/VoicePlayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */