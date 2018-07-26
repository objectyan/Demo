package com.baidu.baidunavis.tts;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.mapframework.p200a.p201a.C3463a;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SynthesizerTool;
import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class GlobalTTS {
    private static final String DEFAULT_VOICE_PATH_SUFFIX = "bd_etts_ch_speech.dat";
    private static final String GLOBAL_VOICE_PATH_SUFFIX = "2-201526.dat";
    private static final String K_TTS_DATA_EN_FILE = "bd_etts_en_speech.dat";
    private static final String K_TTS_TEXT_DATA_EN_FILE = "bd_etts_en_text_default.dat";
    private static String SP_NAME = "international";
    private static String SP_TASK_ID_KEY = "globalVoiceTaskId";
    private Context mContext;
    private boolean mIsLoadedEnglish = false;

    @NotNull
    private String getTtsGlobalVoiceDirPath() {
        return NavMapAdapter.getInstance().getDataPath() + File.separator + "baiduvoicedata" + File.separator + getGlobalVoiceTaskId();
    }

    public String getGlobalVoiceTaskId() {
        return BNVoiceParams.GLOBAL;
    }

    @NotNull
    public String getTtsGlobalVoiceSpeechPath() {
        return getTtsGlobalVoiceDirPath() + File.separator + K_TTS_DATA_EN_FILE;
    }

    @NotNull
    private String getTtsGlobalVoiceTextPath() {
        return getTtsGlobalVoiceDirPath() + File.separator + K_TTS_TEXT_DATA_EN_FILE;
    }

    @NotNull
    public String getTtsGlobalVoiceZipPath() {
        return getTtsGlobalVoiceDirPath() + File.separator + getGlobalVoiceTaskId() + ".dat";
    }

    public void unzip() {
        if (!new File(getTtsGlobalVoiceSpeechPath()).exists()) {
            File file = new File(getTtsGlobalVoiceZipPath());
            if (file.exists()) {
                try {
                    C3463a.a(file, getTtsGlobalVoiceDirPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    boolean verifyGlobalVoice(String ttsPath) {
        try {
            boolean verifyResult;
            if (getTtsGlobalVoiceZipPath().equals(ttsPath)) {
                unzip();
                verifyResult = SynthesizerTool.verifyModelFile(getTtsGlobalVoiceSpeechPath()) && SynthesizerTool.verifyModelFile(getTtsGlobalVoiceTextPath());
            } else {
                verifyResult = false;
            }
            updateGlobalTTSActive(verifyResult);
            return verifyResult;
        } catch (Error e) {
            return false;
        }
    }

    int loadEnglishModel(SpeechSynthesizer ttsPlayer, String ttsPath) {
        int i = -1;
        if (ttsPlayer != null) {
            try {
                if (getTtsGlobalVoiceZipPath().equals(ttsPath)) {
                    this.mIsLoadedEnglish = true;
                    i = ttsPlayer.loadEnglishModel(getTtsGlobalVoiceTextPath(), getTtsGlobalVoiceSpeechPath());
                }
            } catch (Error e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    boolean isGlobalVoice(String ttsPath) {
        return getTtsGlobalVoiceZipPath().equals(ttsPath);
    }

    boolean releaseEnglishModel(SpeechSynthesizer ttsPlayer) {
        if (ttsPlayer == null) {
            return false;
        }
        try {
            if (!this.mIsLoadedEnglish) {
                return false;
            }
            ttsPlayer.release();
            this.mIsLoadedEnglish = false;
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void updateGlobalTTSActive(boolean isActive) {
        if (BaiduNaviManager.sIsBaseEngineInitialized) {
            try {
                JNIGuidanceControl.getInstance().setEngTTSActive(isActive);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isGlobalVoiceExist() {
        String speechPath = getTtsGlobalVoiceSpeechPath();
        File speechFile = new File(speechPath);
        String textPath = getTtsGlobalVoiceTextPath();
        File textFile = new File(textPath);
        try {
            if (speechFile.exists() && textFile.exists() && SynthesizerTool.verifyModelFile(speechPath) && SynthesizerTool.verifyModelFile(textPath)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean isSupportEnglish(String ttsPath) {
        return TextUtils.isEmpty(ttsPath) || ttsPath.endsWith(DEFAULT_VOICE_PATH_SUFFIX) || ttsPath.endsWith(GLOBAL_VOICE_PATH_SUFFIX);
    }
}
