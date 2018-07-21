package com.baidu.che.codriver.vr.record.aec;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.che.codriver.util.INoProguard;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.n;
import com.baidu.che.codriver.vr.record.c.a;
import com.baidu.che.codriver.vr.record.d;
import java.io.InputStream;

public class RecordHelper
  implements INoProguard, c.a
{
  private static final String INPUT_STREAM = "#com.baidu.che.codriver.vr.record.aec.RecordHelper.getInputStream()";
  private static final int MSG_SOFTWARE_AEC_GET_ECHO = 1;
  private static boolean SAVE_FLAG = false;
  private static final String TAG = "RecordHelper";
  private static RecordHelper mInstance;
  private static com.baidu.che.codriver.vr.record.c mRecordInputStream;
  private byte[] inputData = new byte['਀'];
  private long lastDataPackageTime = 0L;
  private com.baidu.che.codriver.vr.record.b mAecResultData;
  private com.baidu.che.codriver.vr.record.b mBeforeAecMicData;
  private com.baidu.che.codriver.vr.record.b mBeforeAecSpkData;
  private Context mContext;
  private Handler mHandler;
  private byte[] mMicBuffer = new byte['਀'];
  private d mRecordTool;
  private a mRecordType = a.a;
  private byte[] mSpeakerBuffer = new byte['਀'];
  private b mState;
  private c mVolumeChangeListener;
  
  public static InputStream getInputStream()
  {
    if ((mRecordInputStream == null) || (mRecordInputStream.a()))
    {
      h.b("RecordHelper", "-----getInputStream()--build RecordInputStream--");
      mRecordInputStream = new com.baidu.che.codriver.vr.record.c();
      if (mInstance != null) {
        mInstance.startRecord();
      }
    }
    return mRecordInputStream;
  }
  
  private boolean isMicLeft()
  {
    return (this.mRecordType == a.c) || (this.mRecordType == a.f);
  }
  
  public void endRecord()
  {
    h.b("RecordHelper", "-----endRecord()----");
    this.mRecordTool.b();
    if (this.mAecResultData != null) {
      this.mAecResultData.d();
    }
    if (this.mBeforeAecMicData != null) {
      this.mBeforeAecMicData.d();
    }
    if (this.mBeforeAecSpkData != null) {
      this.mBeforeAecSpkData.d();
    }
  }
  
  public void feedAudioBuffer(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (i < paramArrayOfByte.length / 4)
    {
      if (isMicLeft())
      {
        this.mMicBuffer[(i * 2)] = paramArrayOfByte[(i * 4)];
        this.mMicBuffer[(i * 2 + 1)] = paramArrayOfByte[(i * 4 + 1)];
        this.mSpeakerBuffer[(i * 2)] = paramArrayOfByte[(i * 4 + 2)];
        this.mSpeakerBuffer[(i * 2 + 1)] = paramArrayOfByte[(i * 4 + 3)];
      }
      for (;;)
      {
        i += 1;
        break;
        this.mSpeakerBuffer[(i * 2)] = paramArrayOfByte[(i * 4)];
        this.mSpeakerBuffer[(i * 2 + 1)] = paramArrayOfByte[(i * 4 + 1)];
        this.mMicBuffer[(i * 2)] = paramArrayOfByte[(i * 4 + 2)];
        this.mMicBuffer[(i * 2 + 1)] = paramArrayOfByte[(i * 4 + 3)];
      }
    }
    feedAudioBuffer(this.mMicBuffer, this.mSpeakerBuffer);
  }
  
  public void feedAudioBuffer(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      h.e("RecordHelper", "-----feedAudioBuffer-----NULL Data!!!");
      a.b();
    }
    do
    {
      return;
      if (this.mBeforeAecMicData != null) {
        this.mBeforeAecMicData.b(paramArrayOfByte1);
      }
      if (this.mBeforeAecSpkData != null) {
        this.mBeforeAecSpkData.b(paramArrayOfByte2);
      }
      a.a(paramArrayOfByte1, paramArrayOfByte2, this.inputData);
      paramArrayOfByte1 = this.inputData;
      if (n.a()) {
        this.lastDataPackageTime = SystemClock.elapsedRealtime();
      }
      if (this.mAecResultData != null)
      {
        this.mAecResultData.b(paramArrayOfByte1);
        return;
      }
    } while ((mRecordInputStream == null) || (mRecordInputStream.a()) || (mRecordInputStream.a(paramArrayOfByte1, 0, 2560) != -1));
    h.e("RecordHelper", "--------feedAudioBuffer--ret == -1");
  }
  
  public String getInfile()
  {
    if ((this.mRecordType == a.a) || (this.mRecordType == a.b)) {
      return null;
    }
    if ((this.mRecordType == a.e) || (this.mRecordType == a.f) || (this.mRecordType == a.g)) {
      return "#com.baidu.che.codriver.vr.record.outside.OutsideRecordHelper.getAsrInputStream()";
    }
    return "#com.baidu.che.codriver.vr.record.aec.RecordHelper.getInputStream()";
  }
  
  public void init(Context paramContext, c paramc)
  {
    Object localObject = null;
    mInstance = this;
    this.mContext = paramContext;
    a.a();
    this.mRecordTool = new b();
    if (SAVE_FLAG)
    {
      paramContext = new com.baidu.che.codriver.vr.record.b(this.mContext);
      this.mAecResultData = paramContext;
      if (!SAVE_FLAG) {
        break label144;
      }
    }
    label144:
    for (paramContext = new com.baidu.che.codriver.vr.record.b(this.mContext);; paramContext = null)
    {
      this.mBeforeAecMicData = paramContext;
      paramContext = (Context)localObject;
      if (SAVE_FLAG) {
        paramContext = new com.baidu.che.codriver.vr.record.b(this.mContext);
      }
      this.mBeforeAecSpkData = paramContext;
      this.mVolumeChangeListener = paramc;
      paramContext = new HandlerThread("AecVolumeChangeListener");
      paramContext.start();
      this.mHandler = new Handler(paramContext.getLooper(), new Handler.Callback()
      {
        public boolean handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            return true;
            paramAnonymousMessage = Message.obtain(paramAnonymousMessage);
            int i = a.c();
            h.b("RecordHelper", "--MSG_SOFTWARE_AEC_GET_ECHO----volume:" + i);
            if (i != paramAnonymousMessage.arg1)
            {
              paramAnonymousMessage.arg1 = i;
              if (RecordHelper.this.mVolumeChangeListener != null) {
                RecordHelper.this.mVolumeChangeListener.a(i);
              }
            }
            RecordHelper.this.mHandler.sendMessageDelayed(paramAnonymousMessage, 1000L);
          }
        }
      });
      return;
      paramContext = null;
      break;
    }
  }
  
  public void onClose()
  {
    endRecord();
  }
  
  public void release()
  {
    mRecordInputStream = null;
    a.b();
    this.mRecordTool.b();
  }
  
  public void reset()
  {
    h.b("RecordHelper", "-----reset()----");
    if ((mRecordInputStream == null) || (mRecordInputStream.a()))
    {
      h.b("RecordHelper", "-----reset()--build RecordInputStream--");
      mRecordInputStream = new com.baidu.che.codriver.vr.record.c();
    }
    if (this.mAecResultData != null) {
      this.mAecResultData.a("_resultAfterAec");
    }
    if (this.mBeforeAecMicData != null) {
      this.mBeforeAecMicData.a("_MicDataBeforeAec");
    }
    if (this.mBeforeAecSpkData != null) {
      this.mBeforeAecSpkData.a("_SpkDataBeforeAec");
    }
    this.mRecordTool.c();
    mRecordInputStream.a(this);
  }
  
  public void setDspEchoEnergy(int paramInt)
  {
    int j = 1;
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    double d = 20.0D * Math.log10(i / 11584.0D);
    if (d < -9.0D) {
      paramInt = 1;
    }
    for (;;)
    {
      h.b("RecordHelper", "--MSG_HARDWARE_AEC_GET_ECHO---- echoEnergy:" + i + "(" + d + "dB) level:" + paramInt);
      if (this.mVolumeChangeListener != null) {
        this.mVolumeChangeListener.a(paramInt);
      }
      return;
      if (d < -4.5D)
      {
        paramInt = 2;
      }
      else
      {
        paramInt = j;
        if (d < 0.0D) {
          paramInt = 3;
        }
      }
    }
  }
  
  public void setRecordType(a parama, d paramd)
  {
    h.b("RecordHelper", "setRecordType() " + parama.name());
    if ((parama == this.mRecordType) && (this.mRecordType != a.a))
    {
      h.b("RecordHelper", "lastRecordType is " + this.mRecordType + " , setRecordType do nothing.");
      return;
    }
    this.mRecordType = parama;
    switch (2.a[this.mRecordType.ordinal()])
    {
    case 1: 
    default: 
      this.mRecordTool = new b();
      return;
    case 2: 
    case 3: 
      this.mRecordTool = new c();
      this.mHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.mRecordTool = paramd;
  }
  
  public void setState(b paramb)
  {
    this.mState = paramb;
  }
  
  public void startRecord()
  {
    h.b("RecordHelper", "-----startRecord()----");
    this.mRecordTool.a();
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/record/aec/RecordHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */