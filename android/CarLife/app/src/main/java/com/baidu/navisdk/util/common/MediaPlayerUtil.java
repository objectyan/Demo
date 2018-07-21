package com.baidu.navisdk.util.common;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.text.TextUtils;
import java.util.Timer;
import java.util.TimerTask;

public class MediaPlayerUtil
{
  public static final String TAG = MediaPlayerUtil.class.getSimpleName();
  private static MediaPlayerUtil sInstance;
  private boolean isNeedReInit = true;
  private boolean isPlaying = false;
  private boolean isPreparing = false;
  private MediaPlayer mMediaPlayer = null;
  private Timer mTimer = null;
  private TimerTask mTimerTask = null;
  
  public static MediaPlayerUtil getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MediaPlayerUtil();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void cancelPlayAudio(PlayCallback paramPlayCallback)
  {
    if (this.mMediaPlayer != null) {}
    try
    {
      if (this.mTimerTask != null)
      {
        this.mTimerTask.cancel();
        this.mTimerTask = null;
      }
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (paramPlayCallback != null) {
        paramPlayCallback.responsePlayPos(this.mMediaPlayer.getCurrentPosition());
      }
      if (this.mMediaPlayer.isPlaying()) {
        this.mMediaPlayer.stop();
      }
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e(TAG, "cancelPlayAudio catch start");
        if (LogUtil.LOGGABLE) {
          localException.printStackTrace();
        }
        LogUtil.e(TAG, "cancelPlayAudio catch end");
      }
    }
    this.isNeedReInit = true;
    this.isPlaying = false;
    this.isPreparing = false;
    if (paramPlayCallback != null) {
      paramPlayCallback.stopPrepare();
    }
  }
  
  public MediaPlayer getMediaPlayer()
  {
    return this.mMediaPlayer;
  }
  
  public boolean isPlaying()
  {
    return this.isPlaying;
  }
  
  public boolean isPreparing()
  {
    return this.isPreparing;
  }
  
  public void pauseAudio()
  {
    if (this.mMediaPlayer != null) {}
    try
    {
      if (this.mTimerTask != null)
      {
        this.mTimerTask.cancel();
        this.mTimerTask = null;
      }
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (this.mMediaPlayer.isPlaying()) {
        this.mMediaPlayer.pause();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e(TAG, "pauseAudio catch start");
        if (LogUtil.LOGGABLE) {
          localException.printStackTrace();
        }
        LogUtil.e(TAG, "pauseAudio catch end");
      }
    }
    this.isPlaying = false;
  }
  
  public void playAudio(String paramString, final int paramInt, final boolean paramBoolean, final PlayCallback paramPlayCallback)
  {
    LogUtil.e(TAG, "playAudio");
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    label223:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              if (this.mMediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
              }
              LogUtil.e(TAG, "isNeedReInit = " + this.isNeedReInit);
              if (!this.isNeedReInit) {
                break label223;
              }
              this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
              {
                public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
                {
                  LogUtil.e(MediaPlayerUtil.TAG, "onPrepared");
                  MediaPlayerUtil.access$002(MediaPlayerUtil.this, false);
                  if (paramPlayCallback != null) {
                    paramPlayCallback.stopPrepare();
                  }
                  MediaPlayerUtil.this.mMediaPlayer.seekTo(paramInt);
                }
              });
              this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
              {
                public void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
                {
                  try
                  {
                    if (paramBoolean)
                    {
                      if (MediaPlayerUtil.this.mTimer == null) {
                        MediaPlayerUtil.access$202(MediaPlayerUtil.this, new Timer());
                      }
                      if (MediaPlayerUtil.this.mTimerTask == null) {
                        MediaPlayerUtil.access$302(MediaPlayerUtil.this, new TimerTask()
                        {
                          public void run()
                          {
                            if ((MediaPlayerUtil.this.mMediaPlayer != null) && (MediaPlayerUtil.2.this.val$callback != null) && (MediaPlayerUtil.this.isPlaying)) {
                              MediaPlayerUtil.2.this.val$callback.responsePlayPos(MediaPlayerUtil.this.mMediaPlayer.getCurrentPosition());
                            }
                          }
                        });
                      }
                      MediaPlayerUtil.this.mTimer.schedule(MediaPlayerUtil.this.mTimerTask, 0L, 1000L);
                    }
                    MediaPlayerUtil.this.mMediaPlayer.start();
                    if (MediaPlayerUtil.this.mMediaPlayer.isPlaying())
                    {
                      MediaPlayerUtil.access$402(MediaPlayerUtil.this, true);
                      MediaPlayerUtil.access$502(MediaPlayerUtil.this, false);
                      if (paramPlayCallback != null)
                      {
                        paramPlayCallback.startPlay();
                        paramPlayCallback.startPlayFirstTime();
                      }
                    }
                    LogUtil.e(MediaPlayerUtil.TAG, "mMediaPlayer.start()");
                    return;
                  }
                  catch (Exception paramAnonymousMediaPlayer)
                  {
                    LogUtil.e(MediaPlayerUtil.TAG, "playAudio catch onSeekComplete start");
                    if (LogUtil.LOGGABLE) {
                      paramAnonymousMediaPlayer.printStackTrace();
                    }
                    LogUtil.e(MediaPlayerUtil.TAG, "playAudio catch onSeekComplete end");
                  }
                }
              });
              this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
              {
                public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
                {
                  LogUtil.e(MediaPlayerUtil.TAG, "onCompletion");
                  if (paramPlayCallback != null) {
                    paramPlayCallback.responsePlayComplete();
                  }
                }
              });
              this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
              {
                public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
                {
                  LogUtil.e(MediaPlayerUtil.TAG, "onError what = " + paramAnonymousInt1 + ", extra = " + paramAnonymousInt2);
                  if (paramPlayCallback != null)
                  {
                    paramPlayCallback.responsePlayError();
                    paramPlayCallback.stopPrepare();
                  }
                  return true;
                }
              });
              this.mMediaPlayer.reset();
              this.mMediaPlayer.setDataSource(paramString);
              this.mMediaPlayer.prepareAsync();
              this.isPreparing = true;
              if (paramPlayCallback != null)
              {
                paramPlayCallback.startPrepare();
                return;
              }
            }
            catch (Exception paramString)
            {
              LogUtil.e(TAG, "playAudio catch start");
              if (LogUtil.LOGGABLE) {
                paramString.printStackTrace();
              }
              LogUtil.e(TAG, "playAudio catch end");
            }
          }
        } while (paramPlayCallback == null);
        paramPlayCallback.stopPrepare();
        return;
        if (paramBoolean)
        {
          if (this.mTimer == null) {
            this.mTimer = new Timer();
          }
          if (this.mTimerTask == null) {
            this.mTimerTask = new TimerTask()
            {
              public void run()
              {
                if ((MediaPlayerUtil.this.mMediaPlayer != null) && (paramPlayCallback != null) && (MediaPlayerUtil.this.isPlaying)) {
                  paramPlayCallback.responsePlayPos(MediaPlayerUtil.this.mMediaPlayer.getCurrentPosition());
                }
              }
            };
          }
          this.mTimer.schedule(this.mTimerTask, 0L, 1000L);
        }
        this.mMediaPlayer.start();
      } while (!this.mMediaPlayer.isPlaying());
      this.isPlaying = true;
    } while (paramPlayCallback == null);
    paramPlayCallback.startPlay();
  }
  
  public void setPreparing(boolean paramBoolean)
  {
    this.isPreparing = paramBoolean;
  }
  
  public static abstract interface PlayCallback
  {
    public abstract void responsePlayComplete();
    
    public abstract void responsePlayError();
    
    public abstract void responsePlayPos(int paramInt);
    
    public abstract void startPlay();
    
    public abstract void startPlayFirstTime();
    
    public abstract void startPrepare();
    
    public abstract void stopPrepare();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/MediaPlayerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */