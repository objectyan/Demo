package com.baidu.che.codriver.vr.record.outside;

import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.record.c;
import com.baidu.che.codriver.vr.record.d;
import java.io.InputStream;

public class OutsideRecordHelper
{
  public static final String ASR_INPUT_STREAM = "#com.baidu.che.codriver.vr.record.outside.OutsideRecordHelper.getAsrInputStream()";
  private static final String TAG = "OutsideRecordHelper";
  public static final String WAKEUP_INPUT_STREAM = "#com.baidu.che.codriver.vr.record.outside.OutsideRecordHelper.getWakeupInputStream()";
  private static c mRecordInputStream;
  private static c mRecordInputStreamWakeup;
  private a mOutsideDataReceiver;
  private com.baidu.che.codriver.vr.record.a mPcmWritor = new com.baidu.che.codriver.vr.record.a()
  {
    public void a(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt2 == -1)
      {
        if ((OutsideRecordHelper.mRecordInputStreamWakeup != null) && (!OutsideRecordHelper.mRecordInputStreamWakeup.a())) {
          OutsideRecordHelper.mRecordInputStreamWakeup.close();
        }
        if ((OutsideRecordHelper.mRecordInputStream != null) && (!OutsideRecordHelper.mRecordInputStream.a())) {
          OutsideRecordHelper.mRecordInputStream.close();
        }
      }
      do
      {
        return;
        if ((OutsideRecordHelper.mRecordInputStream != null) && (!OutsideRecordHelper.mRecordInputStream.a())) {
          OutsideRecordHelper.mRecordInputStream.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        }
      } while ((OutsideRecordHelper.mRecordInputStreamWakeup == null) || (OutsideRecordHelper.mRecordInputStreamWakeup.a()));
      OutsideRecordHelper.mRecordInputStreamWakeup.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
    }
  };
  
  public static InputStream getAsrInputStream()
  {
    return mRecordInputStream;
  }
  
  public static InputStream getWakeupInputStream()
  {
    return mRecordInputStreamWakeup;
  }
  
  public void closeRecordForAsr()
  {
    if ((mRecordInputStream != null) && (!mRecordInputStream.a())) {
      mRecordInputStream.close();
    }
  }
  
  public void closeRecordForWakeup()
  {
    if ((mRecordInputStreamWakeup != null) && (!mRecordInputStreamWakeup.a())) {
      mRecordInputStreamWakeup.close();
    }
  }
  
  public void release()
  {
    this.mOutsideDataReceiver = null;
    mRecordInputStream = null;
    mRecordInputStreamWakeup = null;
  }
  
  public void reset()
  {
    h.b("OutsideRecordHelper", "-----reset()----");
    if ((mRecordInputStream == null) || (mRecordInputStream.a()))
    {
      h.b("OutsideRecordHelper", "-----reset()--build RecordInputStream--");
      mRecordInputStream = new c();
    }
  }
  
  public void startRecordForAsr(d paramd)
  {
    if ((this.mOutsideDataReceiver == null) || (!this.mOutsideDataReceiver.isAlive()))
    {
      this.mOutsideDataReceiver = new a(this.mPcmWritor, paramd);
      this.mOutsideDataReceiver.start();
    }
    if ((mRecordInputStream == null) || (mRecordInputStream.a())) {
      mRecordInputStream = new c();
    }
  }
  
  public void startRecordForWakeup(d paramd)
  {
    if ((this.mOutsideDataReceiver == null) || (!this.mOutsideDataReceiver.isAlive()))
    {
      this.mOutsideDataReceiver = new a(this.mPcmWritor, paramd);
      this.mOutsideDataReceiver.start();
    }
    if ((mRecordInputStreamWakeup == null) || (mRecordInputStreamWakeup.a())) {
      mRecordInputStreamWakeup = new c();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/record/outside/OutsideRecordHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */