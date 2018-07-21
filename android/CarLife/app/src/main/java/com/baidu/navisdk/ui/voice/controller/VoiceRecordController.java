package com.baidu.navisdk.ui.voice.controller;

import android.os.Bundle;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.model.OrgVoiceItem;
import com.baidu.navisdk.ui.voice.model.OrgVoiceSet;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.navisdk.vi.VJavaAudioRecorder;
import com.baidu.navisdk.vi.VJavaAudioRecorder.AudioRecorderListener;
import java.util.ArrayList;

public class VoiceRecordController
{
  private static final int MAX_ITEM_VOICE_DATA_SIZE = 1638400;
  private static final long MAX_ITEM_VOICE_LEN = 10000L;
  private static final long MIN_ITEM_VOICE_LEN = 1000L;
  private static final int POSITION_DELAY_MILLIS = 1000;
  public static final int RECORD_RESULT_ERROR = 3;
  public static final int RECORD_RESULT_SUCCESS = 0;
  public static final int RECORD_RESULT_TOO_SHORT = 2;
  public static final int RECORD_RESULT_UNKNOWN = 1;
  private boolean bRecord = false;
  private boolean hasError = false;
  private VJavaAudioRecorder mAudioRecorder = new VJavaAudioRecorder();
  private VJavaAudioRecorder.AudioRecorderListener mAudioRecorderListener = new VJavaAudioRecorder.AudioRecorderListener()
  {
    public void onReadData(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
    {
      synchronized (VoiceRecordController.this.mMutex)
      {
        LogUtil.e("BNVoice", "record===111   mVoiceBufferLength " + VoiceRecordController.this.mVoiceBufferLength + "len = " + paramAnonymousInt + " mVoiceBuffer " + VoiceRecordController.this.mVoiceBuffer.length);
        if (paramAnonymousInt > 0)
        {
          if (VoiceRecordController.this.mVoiceBufferLength + paramAnonymousInt <= VoiceRecordController.this.mVoiceBuffer.length)
          {
            System.arraycopy(paramAnonymousArrayOfShort, 0, VoiceRecordController.this.mVoiceBuffer, VoiceRecordController.this.mVoiceBufferLength, paramAnonymousInt);
            VoiceRecordController.access$202(VoiceRecordController.this, VoiceRecordController.this.mVoiceBufferLength + paramAnonymousInt);
          }
        }
        else {
          return;
        }
        VoiceRecordController.access$402(VoiceRecordController.this, true);
      }
    }
    
    public void onReadError() {}
  };
  private Object mMutex = new Object();
  private boolean mNeedSave = false;
  private String mOrgWord = null;
  private long mStartRecordTime = 0L;
  private String mTaskId = null;
  private short[] mVoiceBuffer = null;
  private int mVoiceBufferLength = 0;
  private final BNWorkerNormalTask<String, String> recordRefreshTask = new BNWorkerNormalTask("recordRefreshTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      long l = VoiceRecordController.this.getRecordTime();
      BNVoice.getInstance().notifyObservers(2, 33, Long.valueOf(l));
      if (VoiceRecordController.this.getRecordTime() > 10000L)
      {
        int i = VoiceRecordController.this.stopRecord();
        BNVoice.getInstance().notifyObservers(2, 32, Integer.valueOf(i));
      }
      for (;;)
      {
        return null;
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(VoiceRecordController.this.recordRefreshTask, new BNWorkerConfig(100, 0), 1000L);
      }
    }
  };
  
  private void cancelRefreshTimer()
  {
    BNWorkerCenter.getInstance().cancelTask(this.recordRefreshTask, false);
  }
  
  public static VoiceRecordController getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private long getRecordTime()
  {
    return System.currentTimeMillis() - this.mStartRecordTime;
  }
  
  private boolean saveRecordVoiceData(boolean paramBoolean, OrgVoiceSet paramOrgVoiceSet, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("taskId", paramOrgVoiceSet.taskId);
    localBundle.putString("name", paramOrgVoiceSet.name);
    localBundle.putString("tag", paramOrgVoiceSet.tag);
    localBundle.putString("bduss", paramString);
    return JNIVoicePersonalityControl.sInstance.saveRecordVoiceData(paramBoolean, localBundle);
  }
  
  private void startRefreshTimer()
  {
    cancelRefreshTimer();
    this.mStartRecordTime = System.currentTimeMillis();
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.recordRefreshTask, new BNWorkerConfig(100, 0), 1000L);
  }
  
  public boolean cleanRecordVoice(String paramString)
  {
    OrgVoiceSet localOrgVoiceSet = new OrgVoiceSet();
    localOrgVoiceSet.taskId = paramString;
    return getInstance().saveRecordVoiceData(false, localOrgVoiceSet, null);
  }
  
  public void initRecord()
  {
    LogUtil.e("VoiceRecordView", "  MyClickListener isLongClick mAudioRecorder " + this.mAudioRecorder);
    if (this.mAudioRecorder != null)
    {
      this.mAudioRecorder.setRecorderListener(this.mAudioRecorderListener);
      if (this.mAudioRecorder.init())
      {
        LogUtil.e("VoiceRecordView", "  MyClickListener isLongClick mAudioRecorder.init() suceess ");
        this.mVoiceBuffer = new short[1638400];
      }
      this.mVoiceBufferLength = 0;
      this.mTaskId = null;
    }
  }
  
  public boolean isRecord()
  {
    return this.bRecord;
  }
  
  public void releaseRecord()
  {
    if (this.mAudioRecorder != null)
    {
      this.mAudioRecorder.stop();
      this.mAudioRecorder.release();
      this.mAudioRecorder.setRecorderListener(null);
      this.mVoiceBuffer = null;
      this.mVoiceBufferLength = 0;
      this.bRecord = false;
      this.mTaskId = null;
    }
  }
  
  public void resetSaveState()
  {
    this.mNeedSave = false;
  }
  
  public boolean saveRecordVoice(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    OrgVoiceSet localOrgVoiceSet = new OrgVoiceSet();
    localOrgVoiceSet.taskId = paramString1;
    localOrgVoiceSet.name = paramString2;
    localOrgVoiceSet.tag = paramString3;
    return getInstance().saveRecordVoiceData(true, localOrgVoiceSet, paramString4);
  }
  
  public boolean shouldSaveRecord()
  {
    return this.mNeedSave;
  }
  
  public boolean startRecord(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mAudioRecorder != null)
    {
      bool1 = bool2;
      if (!this.bRecord)
      {
        bool1 = bool2;
        if (this.mAudioRecorder.isCanRecord())
        {
          this.mVoiceBufferLength = 0;
          this.mOrgWord = paramString2;
          this.mTaskId = paramString1;
          this.hasError = false;
          bool1 = bool2;
          if (this.mAudioRecorder.start())
          {
            this.bRecord = true;
            startRefreshTimer();
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int stopRecord()
  {
    int k = 1;
    int j = 1;
    cancelRefreshTimer();
    int i = j;
    if (this.mAudioRecorder != null)
    {
      i = j;
      if (this.bRecord)
      {
        i = j;
        if (this.mAudioRecorder.isCanRecord())
        {
          this.mAudioRecorder.stop();
          if (!this.hasError) {
            break label80;
          }
          LogUtil.e("BNVoice", "record error");
          i = 3;
        }
      }
    }
    this.mVoiceBufferLength = 0;
    this.bRecord = false;
    this.hasError = false;
    return i;
    for (;;)
    {
      label80:
      synchronized (this.mMutex)
      {
        if (getRecordTime() < 1000L) {
          i = 2;
        }
      }
      i = k;
      if (this.mVoiceBufferLength > 0)
      {
        ArrayList localArrayList = new ArrayList();
        OrgVoiceItem localOrgVoiceItem = new OrgVoiceItem();
        localOrgVoiceItem.orgWrod = this.mOrgWord;
        localOrgVoiceItem.orgLen = this.mVoiceBufferLength;
        localOrgVoiceItem.orgData = new short[this.mVoiceBufferLength];
        LogUtil.e("BNVoice", "record len = " + this.mVoiceBufferLength + " orgword:" + this.mOrgWord);
        System.arraycopy(this.mVoiceBuffer, 0, localOrgVoiceItem.orgData, 0, this.mVoiceBufferLength);
        localArrayList.add(localOrgVoiceItem);
        if (JNIVoicePersonalityControl.sInstance.recordVoiceData(localArrayList, localArrayList.size(), this.mTaskId))
        {
          i = 0;
          this.mNeedSave = true;
        }
        else
        {
          i = 3;
          LogUtil.e("BNVoice", "stop Record save error");
        }
      }
    }
  }
  
  private static class LazyHolder
  {
    public static final VoiceRecordController sInstance = new VoiceRecordController(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/controller/VoiceRecordController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */