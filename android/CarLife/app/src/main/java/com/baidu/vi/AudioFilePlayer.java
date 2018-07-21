package com.baidu.vi;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import java.io.IOException;

public class AudioFilePlayer
{
  private static final String TAG = "test";
  private int mHandle;
  private MediaPlayer mMplayer = new MediaPlayer();
  
  private int GetCurrentPosition()
  {
    return this.mMplayer.getCurrentPosition() / 1000;
  }
  
  private int GetDuration()
  {
    return this.mMplayer.getDuration() / 1000;
  }
  
  private static int GetMaxVolume(AudioManager paramAudioManager)
  {
    return paramAudioManager.getStreamMaxVolume(3);
  }
  
  private static float GetVolume()
  {
    AudioManager localAudioManager = (AudioManager)VIContext.getContext().getSystemService("audio");
    int i = localAudioManager.getStreamVolume(3);
    int j = GetMaxVolume(localAudioManager);
    return i / j;
  }
  
  private boolean IsPlaying()
  {
    return this.mMplayer.isPlaying();
  }
  
  private void Pause()
  {
    this.mMplayer.pause();
  }
  
  private void Prepare()
    throws IllegalStateException, IOException
  {
    this.mMplayer.prepare();
  }
  
  private void Release()
  {
    this.mMplayer.release();
  }
  
  private void Reset()
  {
    this.mMplayer.reset();
  }
  
  private void SeekTo(int paramInt)
  {
    this.mMplayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
    {
      public void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        paramAnonymousMediaPlayer.start();
      }
    });
    if ((paramInt > GetDuration()) || (paramInt < 0)) {
      return;
    }
    this.mMplayer.seekTo(paramInt * 1000);
  }
  
  private void SetDataSource(String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this.mMplayer.setDataSource(paramString);
    Prepare();
  }
  
  private void SetOnErrorListener(int paramInt)
  {
    this.mMplayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return AudioFilePlayer.a(AudioFilePlayer.this, AudioFilePlayer.a(AudioFilePlayer.this), paramAnonymousInt1);
      }
    });
    this.mHandle = paramInt;
  }
  
  private void SetOnPlayCompletedListener(int paramInt)
  {
    this.mMplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AudioFilePlayer.a(AudioFilePlayer.this, AudioFilePlayer.a(AudioFilePlayer.this));
      }
    });
    this.mHandle = paramInt;
  }
  
  private static void SetVolume(float paramFloat)
  {
    AudioManager localAudioManager = (AudioManager)VIContext.getContext().getSystemService("audio");
    int i = GetMaxVolume(localAudioManager);
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F)) {
      return;
    }
    localAudioManager.setStreamVolume(3, (int)(i * paramFloat), 0);
  }
  
  private void Start()
    throws IllegalStateException, IOException
  {
    this.mMplayer.start();
  }
  
  private void Stop()
  {
    this.mMplayer.stop();
  }
  
  private native boolean onErrorOccured(int paramInt1, int paramInt2);
  
  private native void onPlayCompleted(int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/vi/AudioFilePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */