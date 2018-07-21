package com.baidu.vi;

import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.os.Process;

public class AudioRecorder
{
  private static final int CHANNEL_DOUBLE = 2;
  private static final int CHANNEL_SINGLE = 1;
  private static final int ERR_CODE_PARAMS_ILLEGAL = 1;
  private static final int ERR_CODE_SUCCESS = 0;
  private static final int MSG_READ_DATA = 1;
  private static final int MSG_READ_ERROR = 2;
  private static final int WAY_ASYNC = 1;
  private static final int WAY_SYNC = 0;
  private static Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      AudioRecorder localAudioRecorder = ((AudioRecorder.ReadData)paramAnonymousMessage.obj).a;
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        do
        {
          return;
        } while (!AudioRecorder.a(localAudioRecorder));
        localAudioRecorder.onReadData(((AudioRecorder.ReadData)paramAnonymousMessage.obj).b, ((AudioRecorder.ReadData)paramAnonymousMessage.obj).c);
        return;
      } while (!AudioRecorder.a(localAudioRecorder));
      localAudioRecorder.onReadError();
    }
  };
  private boolean isAsync = true;
  private volatile boolean isRecording = false;
  private int mBufferSize;
  private int mCallBackBufferSize;
  private int mChannel;
  private int mFormat;
  private int mJniData;
  private Object mMutex = new Object();
  private int mRate;
  private Thread mRecordThread = new Thread(AudioRecorder.class.getSimpleName() + "-Record")
  {
    public void run()
    {
      Process.setThreadPriority(-19);
      AudioRecorder.b(AudioRecorder.this).startRecording();
      int i = 0;
      while (AudioRecorder.a(AudioRecorder.this))
      {
        byte[] arrayOfByte = new byte[AudioRecorder.c(AudioRecorder.this)];
        if (AudioRecorder.b(AudioRecorder.this) != null) {
          i = AudioRecorder.b(AudioRecorder.this).read(arrayOfByte, 0, AudioRecorder.c(AudioRecorder.this));
        }
        if ((i == -3) || (i == -2) || (i == -1) || (i == 0)) {
          AudioRecorder.d(AudioRecorder.this);
        } else {
          AudioRecorder.a(AudioRecorder.this, arrayOfByte, i);
        }
      }
    }
  };
  private volatile AudioRecord mRecorder;
  
  public AudioRecorder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramInt3 == 8)
    {
      this.mFormat = 3;
      if (paramInt4 != 2) {
        break label123;
      }
      this.mChannel = 3;
      label85:
      if (paramInt7 != 1) {
        break label131;
      }
    }
    for (;;)
    {
      this.isAsync = bool;
      this.mRate = paramInt2;
      this.mBufferSize = paramInt5;
      this.mCallBackBufferSize = paramInt6;
      return;
      this.mFormat = 2;
      break;
      label123:
      this.mChannel = 2;
      break label85;
      label131:
      bool = false;
    }
  }
  
  private static int getMinBufferSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 == 8) {
      paramInt1 = 3;
    }
    for (;;)
    {
      if (paramInt4 == 2) {
        paramInt3 = 3;
      }
      try
      {
        for (;;)
        {
          paramInt1 = AudioRecord.getMinBufferSize(paramInt2, paramInt3, paramInt1);
          if (paramInt1 <= 0) {
            break label38;
          }
          return paramInt1;
          paramInt1 = 2;
          break;
          paramInt3 = 2;
        }
        label38:
        return 0;
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  private void handleReadData(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.isAsync)
    {
      paramArrayOfByte = new ReadData(this, paramArrayOfByte, paramInt);
      mHandler.sendMessage(mHandler.obtainMessage(1, paramArrayOfByte));
    }
    while (!this.isRecording) {
      return;
    }
    onReadData(paramArrayOfByte, paramInt);
  }
  
  private void handleReadError()
  {
    if (this.isAsync)
    {
      localReadData = new ReadData(this, null, 0);
      mHandler.sendMessage(mHandler.obtainMessage(2, localReadData));
    }
    while (!this.isRecording)
    {
      ReadData localReadData;
      return;
    }
    onReadError();
  }
  
  private void release()
  {
    if (this.mRecorder != null) {
      this.mRecorder.release();
    }
    this.mRecorder = null;
  }
  
  private void setWay(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1) {}
    for (;;)
    {
      this.isAsync = bool;
      return;
      bool = false;
    }
  }
  
  private int start()
  {
    if (this.mRecorder != null)
    {
      this.mRecorder.stop();
      this.mRecorder.release();
      this.mRecorder = null;
    }
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      if (i >= 7) {
        this.mRecorder = new AudioRecord(1, this.mRate, this.mChannel, this.mFormat, this.mBufferSize);
      }
      if ((i < 7) || (this.mRecorder.getState() == 0)) {
        this.mRecorder = new AudioRecord(1, this.mRate, this.mChannel, this.mFormat, this.mBufferSize);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    if ((this.mRecorder.getState() == 0) || (this.mRecorder == null)) {
      return 1;
    }
    this.isRecording = true;
    this.mRecordThread.start();
    return 0;
  }
  
  private void stop()
  {
    this.isRecording = false;
    if (this.mRecorder != null) {
      this.mRecorder.stop();
    }
  }
  
  native void onReadData(byte[] paramArrayOfByte, int paramInt);
  
  native void onReadError();
  
  private class ReadData
  {
    AudioRecorder a;
    byte[] b;
    int c;
    
    public ReadData(AudioRecorder paramAudioRecorder, byte[] paramArrayOfByte, int paramInt)
    {
      this.a = paramAudioRecorder;
      this.b = paramArrayOfByte;
      this.c = paramInt;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/vi/AudioRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */