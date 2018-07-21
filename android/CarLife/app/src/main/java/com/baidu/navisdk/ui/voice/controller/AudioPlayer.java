package com.baidu.navisdk.ui.voice.controller;

import android.media.AudioTrack;
import com.baidu.navisdk.util.common.LogUtil;

public class AudioPlayer
{
  private static final int AUDIO_TRACK_FREQUENCY = 16000;
  private static final int MIN_BUFFER_SIZE = AudioTrack.getMinBufferSize(16000, 2, 2);
  private AudioTrack mAudioTrack = null;
  private byte[] mDataBuffer = null;
  private Object mDataMutex = new Object();
  private boolean mDataReady = false;
  private boolean mIsInit = false;
  private boolean mIsStart = false;
  private boolean mIsStop = false;
  private OnVoicePlayCompletedListener mListener = null;
  private int mOffset = 0;
  private PlayThread mPlayThread = null;
  private Object mStateMutext = new Object();
  
  /* Error */
  private void setDataSource(java.io.File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 98	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 5
    //   13: aload_1
    //   14: invokevirtual 106	java/io/File:length	()J
    //   17: lstore_3
    //   18: aload_0
    //   19: getfield 63	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mDataMutex	Ljava/lang/Object;
    //   22: astore_1
    //   23: aload_1
    //   24: monitorenter
    //   25: lload_3
    //   26: l2i
    //   27: istore_2
    //   28: aload_0
    //   29: iload_2
    //   30: newarray <illegal type>
    //   32: putfield 57	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mDataBuffer	[B
    //   35: aload 5
    //   37: aload_0
    //   38: getfield 57	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mDataBuffer	[B
    //   41: invokevirtual 110	java/io/FileInputStream:read	([B)I
    //   44: pop
    //   45: ldc 112
    //   47: new 114	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   54: ldc 117
    //   56: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload_3
    //   60: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 134	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_1
    //   70: monitorexit
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield 55	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mDataReady	Z
    //   76: aload 5
    //   78: invokevirtual 137	java/io/FileInputStream:close	()V
    //   81: return
    //   82: astore 6
    //   84: aload_1
    //   85: monitorexit
    //   86: aload 6
    //   88: athrow
    //   89: astore_1
    //   90: aload 5
    //   92: invokevirtual 137	java/io/FileInputStream:close	()V
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: return
    //   99: astore 5
    //   101: goto -6 -> 95
    //   104: astore_1
    //   105: aload 6
    //   107: astore 5
    //   109: goto -19 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	AudioPlayer
    //   0	112	1	paramFile	java.io.File
    //   27	3	2	i	int
    //   17	43	3	l	long
    //   11	80	5	localFileInputStream	java.io.FileInputStream
    //   99	1	5	localIOException	java.io.IOException
    //   107	1	5	localObject1	Object
    //   1	1	6	localObject2	Object
    //   82	24	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   28	71	82	finally
    //   84	86	82	finally
    //   13	25	89	finally
    //   71	76	89	finally
    //   86	89	89	finally
    //   76	81	97	java/io/IOException
    //   90	95	99	java/io/IOException
    //   3	13	104	finally
  }
  
  public boolean canPlay()
  {
    return (this.mIsInit) && (this.mDataReady);
  }
  
  public boolean init()
  {
    if (this.mIsInit) {
      return true;
    }
    int i = 5;
    for (;;)
    {
      if (i > 0) {}
      try
      {
        this.mAudioTrack = new AudioTrack(3, 16000, 2, 2, MIN_BUFFER_SIZE, 1);
        if (this.mAudioTrack.getState() == 1)
        {
          this.mPlayThread = new PlayThread(null);
          this.mPlayThread.start();
          this.mIsInit = true;
          LogUtil.e("BNVoice", " player init");
          return this.mIsInit;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          this.mIsInit = false;
        }
        i -= 1;
      }
    }
  }
  
  public void release()
  {
    if ((!this.mIsInit) || (this.mAudioTrack == null)) {
      return;
    }
    synchronized (this.mDataMutex)
    {
      this.mIsInit = false;
      this.mDataReady = false;
      this.mDataBuffer = null;
      this.mAudioTrack.release();
      this.mAudioTrack = null;
      this.mPlayThread = null;
    }
    synchronized (this.mStateMutext)
    {
      this.mStateMutext.notify();
      LogUtil.e("BNVoice", " player release");
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public void setPlayCompletedListener(OnVoicePlayCompletedListener paramOnVoicePlayCompletedListener)
  {
    this.mListener = paramOnVoicePlayCompletedListener;
  }
  
  /* Error */
  public boolean start(String arg1)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_1
    //   3: ifnull +17 -> 20
    //   6: aload_0
    //   7: getfield 49	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mIsInit	Z
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 65	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mAudioTrack	Landroid/media/AudioTrack;
    //   17: ifnonnull +7 -> 24
    //   20: iconst_0
    //   21: istore_2
    //   22: iload_2
    //   23: ireturn
    //   24: aload_0
    //   25: getfield 51	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mIsStart	Z
    //   28: ifne -6 -> 22
    //   31: new 102	java/io/File
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 171	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_3
    //   40: aload_3
    //   41: invokevirtual 174	java/io/File:exists	()Z
    //   44: ifne +29 -> 73
    //   47: ldc 112
    //   49: new 114	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   56: ldc -80
    //   58: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 134	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_0
    //   74: aload_3
    //   75: invokespecial 178	com/baidu/navisdk/ui/voice/controller/AudioPlayer:setDataSource	(Ljava/io/File;)V
    //   78: aload_0
    //   79: iconst_1
    //   80: putfield 51	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mIsStart	Z
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 53	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mIsStop	Z
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 59	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mOffset	I
    //   93: aload_0
    //   94: getfield 65	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mAudioTrack	Landroid/media/AudioTrack;
    //   97: invokevirtual 181	android/media/AudioTrack:play	()V
    //   100: aload_0
    //   101: getfield 61	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mStateMutext	Ljava/lang/Object;
    //   104: astore_1
    //   105: aload_1
    //   106: monitorenter
    //   107: aload_0
    //   108: getfield 61	com/baidu/navisdk/ui/voice/controller/AudioPlayer:mStateMutext	Ljava/lang/Object;
    //   111: invokevirtual 163	java/lang/Object:notify	()V
    //   114: aload_1
    //   115: monitorexit
    //   116: ldc 112
    //   118: ldc -73
    //   120: invokestatic 134	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: iconst_1
    //   124: ireturn
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   130: goto -52 -> 78
    //   133: astore_3
    //   134: aload_1
    //   135: monitorexit
    //   136: aload_3
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	AudioPlayer
    //   1	22	2	bool	boolean
    //   39	36	3	localFile	java.io.File
    //   133	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	71	125	java/io/IOException
    //   73	78	125	java/io/IOException
    //   107	116	133	finally
    //   134	136	133	finally
  }
  
  public boolean stop()
  {
    boolean bool = true;
    if ((!this.mIsInit) || (this.mAudioTrack == null)) {
      bool = false;
    }
    while (this.mIsStop) {
      return bool;
    }
    this.mDataReady = false;
    this.mIsStart = false;
    this.mIsStop = true;
    LogUtil.e("BNVoice", " player stop");
    return true;
  }
  
  public static abstract interface OnVoicePlayCompletedListener
  {
    public abstract void onPlaycompleted();
  }
  
  private class PlayThread
    extends Thread
  {
    private PlayThread() {}
    
    public void run()
    {
      try
      {
        do
        {
          for (;;)
          {
            if ((!AudioPlayer.this.mIsInit) || (AudioPlayer.this.mAudioTrack == null) || (AudioPlayer.this.mIsStop)) {}
            synchronized (AudioPlayer.this.mStateMutext)
            {
              try
              {
                AudioPlayer.this.mStateMutext.wait();
                if (AudioPlayer.this.mIsInit)
                {
                  ??? = AudioPlayer.this.mAudioTrack;
                  if (??? != null) {}
                }
                else
                {
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
            if ((!AudioPlayer.this.mIsStop) || (AudioPlayer.this.mAudioTrack.getPlayState() == 1)) {
              break;
            }
            AudioPlayer.this.mAudioTrack.stop();
          }
        } while ((!AudioPlayer.this.mDataReady) || (AudioPlayer.this.mAudioTrack.getState() != 1));
        for (;;)
        {
          synchronized (AudioPlayer.this.mDataMutex)
          {
            if (AudioPlayer.this.mOffset + AudioPlayer.MIN_BUFFER_SIZE > AudioPlayer.this.mDataBuffer.length)
            {
              AudioPlayer.access$502(AudioPlayer.this, false);
              AudioPlayer.access$1002(AudioPlayer.this, false);
              AudioPlayer.access$302(AudioPlayer.this, true);
              LogUtil.e("BNVoice", "audio player end");
              if (AudioPlayer.this.mListener != null) {
                AudioPlayer.this.mListener.onPlaycompleted();
              }
            }
          }
          int i = AudioPlayer.this.mAudioTrack.write(AudioPlayer.this.mDataBuffer, AudioPlayer.this.mOffset, AudioPlayer.MIN_BUFFER_SIZE);
          if ((i == -3) || (i == -2))
          {
            LogUtil.e("BNVoice", "audio player write buffer ret = " + i);
            AudioPlayer.access$502(AudioPlayer.this, false);
          }
          else
          {
            AudioPlayer.this.mAudioTrack.flush();
            AudioPlayer.access$702(AudioPlayer.this, AudioPlayer.this.mOffset + i);
          }
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/controller/AudioPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */