package com.baidu.baidunavis.tts;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.mapframework.a.a.a;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SynthesizerTool;
import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class GlobalTTS
{
  private static final String DEFAULT_VOICE_PATH_SUFFIX = "bd_etts_ch_speech.dat";
  private static final String GLOBAL_VOICE_PATH_SUFFIX = "2-201526.dat";
  private static final String K_TTS_DATA_EN_FILE = "bd_etts_en_speech.dat";
  private static final String K_TTS_TEXT_DATA_EN_FILE = "bd_etts_en_text_default.dat";
  private static String SP_NAME = "international";
  private static String SP_TASK_ID_KEY = "globalVoiceTaskId";
  private Context mContext;
  private boolean mIsLoadedEnglish = false;
  
  @NotNull
  private String getTtsGlobalVoiceDirPath()
  {
    return NavMapAdapter.getInstance().getDataPath() + File.separator + "baiduvoicedata" + File.separator + getGlobalVoiceTaskId();
  }
  
  @NotNull
  private String getTtsGlobalVoiceTextPath()
  {
    return getTtsGlobalVoiceDirPath() + File.separator + "bd_etts_en_text_default.dat";
  }
  
  public String getGlobalVoiceTaskId()
  {
    return "2-201526";
  }
  
  @NotNull
  public String getTtsGlobalVoiceSpeechPath()
  {
    return getTtsGlobalVoiceDirPath() + File.separator + "bd_etts_en_speech.dat";
  }
  
  @NotNull
  public String getTtsGlobalVoiceZipPath()
  {
    return getTtsGlobalVoiceDirPath() + File.separator + getGlobalVoiceTaskId() + ".dat";
  }
  
  boolean isGlobalVoice(String paramString)
  {
    return getTtsGlobalVoiceZipPath().equals(paramString);
  }
  
  public boolean isGlobalVoiceExist()
  {
    boolean bool2 = false;
    String str1 = getTtsGlobalVoiceSpeechPath();
    File localFile1 = new File(str1);
    String str2 = getTtsGlobalVoiceTextPath();
    File localFile2 = new File(str2);
    boolean bool1 = bool2;
    try
    {
      if (localFile1.exists())
      {
        bool1 = bool2;
        if (localFile2.exists())
        {
          bool1 = bool2;
          if (SynthesizerTool.verifyModelFile(str1))
          {
            boolean bool3 = SynthesizerTool.verifyModelFile(str2);
            bool1 = bool2;
            if (bool3) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean isSupportEnglish(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.endsWith("bd_etts_ch_speech.dat")) || (paramString.endsWith("2-201526.dat"));
  }
  
  int loadEnglishModel(SpeechSynthesizer paramSpeechSynthesizer, String paramString)
  {
    if (paramSpeechSynthesizer != null) {
      try
      {
        if (!getTtsGlobalVoiceZipPath().equals(paramString)) {
          return -1;
        }
        this.mIsLoadedEnglish = true;
        int i = paramSpeechSynthesizer.loadEnglishModel(getTtsGlobalVoiceTextPath(), getTtsGlobalVoiceSpeechPath());
        return i;
      }
      catch (Error paramSpeechSynthesizer)
      {
        paramSpeechSynthesizer.printStackTrace();
      }
    }
    return -1;
  }
  
  boolean releaseEnglishModel(SpeechSynthesizer paramSpeechSynthesizer)
  {
    if (paramSpeechSynthesizer != null) {
      try
      {
        if (!this.mIsLoadedEnglish) {
          return false;
        }
        paramSpeechSynthesizer.release();
        this.mIsLoadedEnglish = false;
        return true;
      }
      catch (Error paramSpeechSynthesizer) {}
    }
    return false;
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void unzip()
  {
    if (new File(getTtsGlobalVoiceSpeechPath()).exists()) {}
    File localFile;
    do
    {
      return;
      localFile = new File(getTtsGlobalVoiceZipPath());
    } while (!localFile.exists());
    try
    {
      a.a(localFile, getTtsGlobalVoiceDirPath());
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void updateGlobalTTSActive(boolean paramBoolean)
  {
    if (BaiduNaviManager.sIsBaseEngineInitialized) {}
    try
    {
      JNIGuidanceControl.getInstance().setEngTTSActive(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  boolean verifyGlobalVoice(String paramString)
  {
    try
    {
      boolean bool;
      if (getTtsGlobalVoiceZipPath().equals(paramString))
      {
        unzip();
        if ((SynthesizerTool.verifyModelFile(getTtsGlobalVoiceSpeechPath())) && (SynthesizerTool.verifyModelFile(getTtsGlobalVoiceTextPath()))) {
          bool = true;
        }
      }
      for (;;)
      {
        updateGlobalTTSActive(bool);
        return bool;
        bool = false;
        continue;
        bool = false;
      }
      return false;
    }
    catch (Error paramString) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/tts/GlobalTTS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */