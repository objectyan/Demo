package com.baidu.carlife.logic.voice;

import android.media.AudioTrack;
import com.baidu.carlife.core.i;
import com.baidu.carlife.l.a;

public class ReceiveDataThread
  extends Thread
{
  private static final int AUDIO_PACKET_MAX_LENGTH = 5000;
  private static final int FILTER_PAKCAGE_NUM = 20;
  public static final int RECORD_STATUS_IDLE = 1;
  public static final int RECORD_STATUS_RECOG = 3;
  public static final int RECORD_STATUS_WAKEUP = 2;
  public static final int SAMPLE_RATE_16K = 16000;
  private static final String TAG = "CarLifeVoice";
  public static boolean isPlayMicAudio = false;
  private static f mRecordInputStream;
  int dataLength = 0;
  int flag = -1;
  byte[] inputData = new byte['ᎈ'];
  private int mFilterIndex = 0;
  private int mRecordStatus = 1;
  
  public static f getExtSource()
  {
    return mRecordInputStream;
  }
  
  public void run()
  {
    int i = AudioTrack.getMinBufferSize(16000, 4, 2);
    for (;;)
    {
      try
      {
        AudioTrack localAudioTrack = new AudioTrack(3, 16000, 4, 2, i, 1);
        this.flag = a.a().e(this.inputData, 12);
        if ((this.flag == -1) || (this.flag != 12))
        {
          i.e("CarLifeVoice", "-- get data length failed");
          this.inputData = null;
        }
        this.dataLength = ((this.inputData[0] << 24 & 0xFF000000) + (this.inputData[1] << 16 & 0xFF0000) + (this.inputData[2] << 8 & 0xFF00) + (this.inputData[3] << 0 & 0xFF));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        try
        {
          localAudioTrack.stop();
          return;
        }
        catch (IllegalStateException localIllegalStateException) {}
        localIllegalArgumentException = localIllegalArgumentException;
        return;
      }
      if (this.dataLength > 5000)
      {
        i.e("CarLifeVoice", "---- get data too long!!!-len:" + this.dataLength);
      }
      else
      {
        this.flag = a.a().e(this.inputData, this.dataLength);
        if (this.flag < 0)
        {
          i.e("CarLifeVoice", "-- get data failed---");
        }
        else
        {
          i.b("CarLifeVoice", "- get data OK!!-dataLength:" + this.dataLength);
          if ((a.a().V()) && (this.dataLength > 0))
          {
            this.inputData = a.a().g(this.inputData, this.dataLength);
            if (this.inputData == null)
            {
              i.e("CarLifeVoice", "decrypt failed!");
              return;
            }
            this.dataLength = this.inputData.length;
          }
          i = this.mFilterIndex;
          this.mFilterIndex = (i + 1);
          if (i > 20) {
            if (isPlayMicAudio)
            {
              localIllegalArgumentException.write(this.inputData, 0, this.dataLength);
              if (localIllegalArgumentException.getPlayState() != 3) {
                localIllegalArgumentException.play();
              }
            }
            else if (this.mRecordStatus == 3)
            {
              if (mRecordInputStream != null) {
                mRecordInputStream.a(this.inputData, 0, this.dataLength);
              }
            }
            else if ((this.mRecordStatus == 2) && (mRecordInputStream != null))
            {
              mRecordInputStream.a(this.inputData, 0, this.dataLength);
            }
          }
        }
      }
    }
  }
  
  public void setRecordStatus(int paramInt)
  {
    this.mRecordStatus = paramInt;
    this.mFilterIndex = 0;
    if (mRecordInputStream != null) {
      mRecordInputStream.close();
    }
    mRecordInputStream = new f();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/voice/ReceiveDataThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */