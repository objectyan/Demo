package com.baidu.navisdk.util.testtts;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TTSTestCenter
{
  public static final String TAG = TTSTestCenter.class.getSimpleName();
  public static final String TTSTEST_FOLDER = "/log/tts";
  public static final String[] TTS_TXT = { "tts_const.txt", "tts_var.txt", "tts_var_poi.txt", "tts_var_road.txt", "tts_var_dist.txt" };
  public static final int TYPE_ALL = 100;
  public static final int TYPE_CONST = 0;
  public static final int TYPE_DIST = 4;
  public static final int TYPE_POI = 2;
  public static final int TYPE_ROAD = 3;
  public static final int TYPE_VAR = 1;
  private static TTSTestCenter sInstance = null;
  private static Object sSyncObj = new Object();
  private List<String> mConsts = new ArrayList();
  private List<String> mDists = new ArrayList();
  private Handler mHD = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      TTSTestCenter.log("what=" + paramAnonymousMessage.what + ", arg1=" + paramAnonymousMessage.arg1 + ", stop=" + TTSTestCenter.this.mStopTest);
      if (TTSTestCenter.this.mStopTest) {}
      Message localMessage;
      do
      {
        do
        {
          do
          {
            return;
            if (1 == TTSPlayerControl.getTTSState()) {}
            for (int i = 1; i == 0; i = 0)
            {
              localMessage = TTSTestCenter.this.mHD.obtainMessage(paramAnonymousMessage.what);
              localMessage.what = paramAnonymousMessage.what;
              localMessage.arg1 = paramAnonymousMessage.arg1;
              TTSTestCenter.this.mHD.sendMessageDelayed(localMessage, 1000L);
              return;
            }
            if (100 != paramAnonymousMessage.what) {
              break;
            }
          } while ((paramAnonymousMessage.arg1 < 0) || (paramAnonymousMessage.arg1 >= TTSTestCenter.this.mPlayTexts.size()));
          TTSPlayerControl.playTTS((String)TTSTestCenter.this.mPlayTexts.get(paramAnonymousMessage.arg1), 1);
          TTSTestCenter.log("play=" + (String)TTSTestCenter.this.mPlayTexts.get(paramAnonymousMessage.arg1));
        } while (paramAnonymousMessage.arg1 + 1 >= TTSTestCenter.this.mPlayTexts.size());
        localMessage = TTSTestCenter.this.mHD.obtainMessage(100);
        localMessage.what = 100;
        paramAnonymousMessage.arg1 += 1;
        TTSTestCenter.this.mHD.sendMessageDelayed(localMessage, 1000L);
        return;
      } while ((paramAnonymousMessage.what != 0) || (paramAnonymousMessage.arg1 < 0) || (paramAnonymousMessage.arg1 >= TTSTestCenter.this.mConsts.size()));
      TTSPlayerControl.playTTS((String)TTSTestCenter.this.mConsts.get(paramAnonymousMessage.arg1), 1);
      if (paramAnonymousMessage.arg1 + 1 < TTSTestCenter.this.mConsts.size())
      {
        localMessage = TTSTestCenter.this.mHD.obtainMessage(0);
        localMessage.what = 0;
        paramAnonymousMessage.arg1 += 1;
        TTSTestCenter.this.mHD.sendMessageDelayed(localMessage, 1000L);
        return;
      }
      paramAnonymousMessage = TTSTestCenter.this.mHD.obtainMessage(1);
      paramAnonymousMessage.what = 1;
      paramAnonymousMessage.arg1 = 0;
      TTSTestCenter.this.mHD.sendMessageDelayed(paramAnonymousMessage, 1000L);
    }
  };
  private boolean mIsInitOK = false;
  private List<String> mPlayTexts = new ArrayList();
  private List<String> mPois = new ArrayList();
  private List<String> mRoads = new ArrayList();
  private boolean mStopTest = false;
  private List<String> mVars = new ArrayList();
  
  private void addTTSTxt(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > 4) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mConsts.add(paramString);
      return;
    case 1: 
      this.mVars.add(paramString);
      return;
    case 2: 
      this.mPois.add(paramString);
      return;
    case 3: 
      this.mRoads.add(paramString);
      return;
    }
    this.mDists.add(paramString);
  }
  
  private boolean generatePlayTexts()
  {
    this.mPlayTexts.clear();
    this.mPlayTexts.addAll(this.mConsts);
    int i = 0;
    while (i < this.mVars.size())
    {
      int j = 0;
      while (j < this.mPois.size())
      {
        int k = 0;
        while (k < this.mRoads.size())
        {
          int m = 0;
          while (m < this.mDists.size())
          {
            String str = ((String)this.mVars.get(i)).replaceAll("poi", (String)this.mPois.get(j)).replaceAll("road", (String)this.mRoads.get(k)).replaceAll("dist", (String)this.mDists.get(m));
            if (!this.mPlayTexts.contains(str))
            {
              log("generatePlayTexts() newS=" + str);
              this.mPlayTexts.add(str);
            }
            m += 1;
          }
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    this.mPlayTexts.add("tts测试模式已经完成");
    return true;
  }
  
  public static TTSTestCenter getInstance()
  {
    if (sInstance == null) {}
    synchronized (sSyncObj)
    {
      if (sInstance == null) {
        sInstance = new TTSTestCenter();
      }
      return sInstance;
    }
  }
  
  private static void initDirs()
  {
    File localFile = new File(SysOSAPI.getInstance().GetSDCardPath() + "/log/tts");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private boolean loadTXT()
  {
    boolean bool2 = true;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      BufferedReader localBufferedReader;
      if (i < TTS_TXT.length) {
        try
        {
          FileInputStream localFileInputStream = new FileInputStream(SysOSAPI.getInstance().GetSDCardPath() + "/log/tts" + File.separator + TTS_TXT[i]);
          localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
          for (;;)
          {
            String str = localBufferedReader.readLine();
            if (str == null) {
              break;
            }
            log("loadTXT=" + str);
            addTTSTxt(i, str);
          }
          return bool1;
        }
        catch (Exception localException)
        {
          bool1 = false;
          log("failed to load txt file. txt=" + TTS_TXT[i]);
        }
      }
      localException.close();
      localBufferedReader.close();
      log("success to load txt file. txt=" + TTS_TXT[i]);
      i += 1;
    }
  }
  
  public static void log(String paramString)
  {
    LogUtil.e(TAG, paramString);
  }
  
  private void testPlayTexts()
  {
    Message localMessage = this.mHD.obtainMessage(100);
    localMessage.what = 100;
    localMessage.arg1 = 0;
    this.mHD.sendMessageDelayed(localMessage, 1000L);
  }
  
  private void testTTSConst()
  {
    Message localMessage = this.mHD.obtainMessage(0);
    localMessage.what = 0;
    localMessage.arg1 = 0;
    this.mHD.sendMessageDelayed(localMessage, 1000L);
  }
  
  private void testTTSText(String paramString)
  {
    if (this.mStopTest) {}
    for (;;)
    {
      return;
      int i = 0;
      while ((!this.mStopTest) && (i < this.mConsts.size()))
      {
        while ((1 != TTSPlayerControl.getTTSState()) && (2 == TTSPlayerControl.getTTSState())) {
          try
          {
            log("sleep");
            Thread.sleep(500L);
          }
          catch (InterruptedException paramString) {}
        }
        if (0 != 0) {
          TTSPlayerControl.playTTS((String)this.mConsts.get(i), 1);
        }
        i += 1;
      }
    }
  }
  
  private void testTTSVar()
  {
    if (this.mStopTest) {}
  }
  
  public void init()
  {
    if (this.mIsInitOK) {
      return;
    }
    initDirs();
    this.mIsInitOK = loadTXT();
    this.mIsInitOK &= generatePlayTexts();
  }
  
  public void stopTest()
  {
    this.mStopTest = true;
  }
  
  public boolean test()
  {
    if (!this.mIsInitOK) {
      return false;
    }
    this.mStopTest = false;
    testPlayTexts();
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/testtts/TTSTestCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */