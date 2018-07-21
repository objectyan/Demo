package com.baidu.navisdk.vi;

import android.media.AudioRecord;
import com.baidu.navisdk.util.common.LogUtil;

public class VJavaAudioRecorder
{
  private static final int AUDIO_FORMAT = 2;
  private static final int AUDIO_SOURCE = 1;
  protected static final int BUFFER_SIZE_IN_BYTES = Math.max(AudioRecord.getMinBufferSize(16000, 2, 2), 2048);
  private static final int CHANNEL_CONFIG = 2;
  private static final int SAMPLE_RATE = 16000;
  private static final String TAG = "VJavaAudioRecorder";
  private boolean isInit = false;
  private boolean isStart = false;
  private boolean isStop = true;
  private boolean isThreadStart = false;
  private short[] mBuffer = new short['ࠀ'];
  private int mJniData;
  private Object mMutex = new Object();
  AudioRecord mRecord;
  private RecordThread mRecordThread;
  private AudioRecorderListener mRecorderListener;
  
  private void onRecordReadData(short[] paramArrayOfShort, int paramInt)
  {
    if (this.isStop)
    {
      LogUtil.e("VJavaAudioRecorder", "onRecordReadData, has stopped");
      return;
    }
    if (this.mRecorderListener != null)
    {
      this.mRecorderListener.onReadData(paramArrayOfShort, paramInt);
      return;
    }
    onReadData(paramArrayOfShort, paramInt);
  }
  
  private void onRecordReadError()
  {
    try
    {
      if (this.mRecorderListener != null)
      {
        this.mRecorderListener.onReadError();
        return;
      }
      onReadError();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public int getAudioSessionId()
  {
    int j = 0;
    int i = j;
    if (this.mRecord != null)
    {
      i = j;
      if (this.mRecord.getRecordingState() == 3) {
        i = this.mRecord.getAudioSessionId();
      }
    }
    return i;
  }
  
  public boolean init()
  {
    for (;;)
    {
      try
      {
        LogUtil.e("VoiceRecordView", "  MyClickListener isLongClick isInit " + this.isInit);
        if (!this.isInit) {
          break label130;
        }
        return true;
      }
      catch (Exception localException)
      {
        LogUtil.e("VJavaAudioRecorder", "fail to init audio record for exception!");
        return false;
      }
      if (i >= 0)
      {
        this.mRecord = new AudioRecord(1, 16000, 2, 2, BUFFER_SIZE_IN_BYTES);
        if (this.mRecord.getState() == 1)
        {
          LogUtil.e("VJavaAudioRecorder", "success to init audio record!");
          this.isInit = true;
          this.mRecordThread = new RecordThread();
          this.mRecordThread.start();
          return true;
        }
      }
      else
      {
        LogUtil.e("VJavaAudioRecorder", "fail to init audio record!");
        return false;
      }
      i -= 1;
      continue;
      label130:
      int i = 6;
    }
  }
  
  public boolean isCanRecord()
  {
    return this.isInit;
  }
  
  native void onReadData(short[] paramArrayOfShort, int paramInt);
  
  native void onReadError();
  
  public void release()
  {
    if ((!this.isInit) || (this.mRecord == null)) {
      return;
    }
    this.isInit = false;
    this.mRecordThread = null;
    LogUtil.e("VJavaAudioRecorder", "release recod");
    this.mRecord.release();
    this.mRecord = null;
    synchronized (this.mMutex)
    {
      this.mMutex.notify();
      return;
    }
  }
  
  public void setRecorderListener(AudioRecorderListener paramAudioRecorderListener)
  {
    this.mRecorderListener = paramAudioRecorderListener;
  }
  
  public boolean start()
  {
    boolean bool = true;
    if ((!this.isInit) || (this.mRecord == null)) {
      bool = false;
    }
    while (this.isStart) {
      return bool;
    }
    LogUtil.e("VJavaAudioRecorder", "start recod");
    this.isStart = true;
    this.isStop = false;
    try
    {
      this.mRecord.startRecording();
      synchronized (this.mMutex)
      {
        this.mMutex.notify();
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean stop()
  {
    boolean bool = true;
    if ((!this.isInit) || (this.mRecord == null)) {
      bool = false;
    }
    while (this.isStop) {
      return bool;
    }
    LogUtil.e("VJavaAudioRecorder", "stop recod");
    this.isStart = false;
    this.isStop = true;
    return true;
  }
  
  public static abstract interface AudioRecorderListener
  {
    public abstract void onReadData(short[] paramArrayOfShort, int paramInt);
    
    public abstract void onReadError();
  }
  
  class RecordThread
    extends Thread
  {
    RecordThread() {}
    
    public void run()
    {
      for (;;)
      {
        if ((!VJavaAudioRecorder.this.isInit) || (VJavaAudioRecorder.this.mRecord == null) || (VJavaAudioRecorder.this.isStop)) {}
        synchronized (VJavaAudioRecorder.this.mMutex)
        {
          try
          {
            LogUtil.e("VJavaAudioRecorder", "java record thread read stop");
            VJavaAudioRecorder.this.mMutex.wait();
            LogUtil.e("VJavaAudioRecorder", "java record thread read start");
            if ((!VJavaAudioRecorder.this.isInit) || (VJavaAudioRecorder.this.mRecord == null))
            {
              LogUtil.e("VJavaAudioRecorder", "java record thread end");
              return;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
        if (VJavaAudioRecorder.this.isStop)
        {
          VJavaAudioRecorder.this.mRecord.stop();
        }
        else
        {
          int i = VJavaAudioRecorder.this.mRecord.read(VJavaAudioRecorder.this.mBuffer, 0, VJavaAudioRecorder.this.mBuffer.length);
          if (!VJavaAudioRecorder.this.isStop) {
            if (i > 0)
            {
              LogUtil.e("VJavaAudioRecorder", "java record thread read len:" + i);
              VJavaAudioRecorder.this.onRecordReadData(VJavaAudioRecorder.this.mBuffer, i);
            }
            else
            {
              LogUtil.e("VJavaAudioRecorder", "java record thread read error len = " + i);
              VJavaAudioRecorder.this.onRecordReadError();
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/vi/VJavaAudioRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */