package com.baidu.baidunavis.control;

import android.os.Handler;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadController;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;

public class NavTTSController {
    public static final int MSG_DOWNLOAD_FIAL = 3;
    public static final int MSG_DOWNLOAD_FINISH = 4;
    public static final String TEST_ID = "20-89392";
    public static final String TTS_HIGH_TEXT_ID = "3-89395";
    public static final String TTS_SCENIC_ID = "20-";
    private static NavTTSController sInstant = null;

    public static NavTTSController getInstant() {
        if (sInstant == null) {
            sInstant = new NavTTSController();
        }
        return sInstant;
    }

    public String getVoicePath(String ttsId) {
        if (BaiduNaviManager.sIsBaseEngineInitialized && VoiceHelper.getInstance().isTaskDownloadFinish(ttsId)) {
            return VoiceHelper.getInstance().getVoiceSetPath(ttsId);
        }
        return null;
    }

    public boolean startDownload(String ttsId) {
        if (BaiduNaviManager.sIsBaseEngineInitialized) {
            return VoiceDownloadController.getInstance().startDownload(ttsId);
        }
        return false;
    }

    public boolean pauseDownload(String ttsId) {
        if (!BaiduNaviManager.sIsBaseEngineInitialized) {
            return false;
        }
        VoiceDownloadController.getInstance().pauseDownload(ttsId);
        return true;
    }

    public boolean pauseAllDownload() {
        if (!BaiduNaviManager.sIsBaseEngineInitialized) {
            return false;
        }
        VoiceDownloadController.getInstance().pauseAllDownload();
        return true;
    }

    public boolean switchVoice(String voicePath, String textPath) {
        return BaseTTSPlayer.getInstance().switchTTSVoiceDataSync(voicePath, textPath, false);
    }

    public boolean recoveryToNavVoice() {
        return BaseTTSPlayer.getInstance().recoveryToNavVoice();
    }

    public boolean registCallbackHandler(Handler handler) {
        if (!BaiduNaviManager.sIsBaseEngineInitialized) {
            return false;
        }
        VoiceDownloadController.getInstance().registCallbackHandler(handler);
        return true;
    }

    public boolean unregistCallbackHandler(Handler handler) {
        if (!BaiduNaviManager.sIsBaseEngineInitialized) {
            return false;
        }
        VoiceDownloadController.getInstance().unregistCallbackHandler(handler);
        return true;
    }
}
