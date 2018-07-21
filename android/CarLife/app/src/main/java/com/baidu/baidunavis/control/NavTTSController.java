package com.baidu.baidunavis.control;

import android.os.Handler;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadController;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;

public class NavTTSController
{
  public static final int MSG_DOWNLOAD_FIAL = 3;
  public static final int MSG_DOWNLOAD_FINISH = 4;
  public static final String TEST_ID = "20-89392";
  public static final String TTS_HIGH_TEXT_ID = "3-89395";
  public static final String TTS_SCENIC_ID = "20-";
  private static NavTTSController sInstant = null;
  
  public static NavTTSController getInstant()
  {
    if (sInstant == null) {
      sInstant = new NavTTSController();
    }
    return sInstant;
  }
  
  public String getVoicePath(String paramString)
  {
    if (!BaiduNaviManager.sIsBaseEngineInitialized) {}
    while (!VoiceHelper.getInstance().isTaskDownloadFinish(paramString)) {
      return null;
    }
    return VoiceHelper.getInstance().getVoiceSetPath(paramString);
  }
  
  public boolean pauseAllDownload()
  {
    if (!BaiduNaviManager.sIsBaseEngineInitialized) {
      return false;
    }
    VoiceDownloadController.getInstance().pauseAllDownload();
    return true;
  }
  
  public boolean pauseDownload(String paramString)
  {
    if (!BaiduNaviManager.sIsBaseEngineInitialized) {
      return false;
    }
    VoiceDownloadController.getInstance().pauseDownload(paramString);
    return true;
  }
  
  public boolean recoveryToNavVoice()
  {
    return BaseTTSPlayer.getInstance().recoveryToNavVoice();
  }
  
  public boolean registCallbackHandler(Handler paramHandler)
  {
    if (!BaiduNaviManager.sIsBaseEngineInitialized) {
      return false;
    }
    VoiceDownloadController.getInstance().registCallbackHandler(paramHandler);
    return true;
  }
  
  public boolean startDownload(String paramString)
  {
    if (!BaiduNaviManager.sIsBaseEngineInitialized) {
      return false;
    }
    return VoiceDownloadController.getInstance().startDownload(paramString);
  }
  
  public boolean switchVoice(String paramString1, String paramString2)
  {
    return BaseTTSPlayer.getInstance().switchTTSVoiceDataSync(paramString1, paramString2, false);
  }
  
  public boolean unregistCallbackHandler(Handler paramHandler)
  {
    if (!BaiduNaviManager.sIsBaseEngineInitialized) {
      return false;
    }
    VoiceDownloadController.getInstance().unregistCallbackHandler(paramHandler);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavTTSController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */