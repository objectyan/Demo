package com.baidu.tts.client;

import android.content.Context;
import android.os.Bundle;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.p213a.p215b.C4957a;
import com.baidu.tts.p233f.C5081b;
import com.baidu.tts.p233f.C5085c;
import com.baidu.tts.p233f.C5086d;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5090h;
import com.baidu.tts.p233f.C5092j;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.List;

public class SpeechSynthesizer {
    public static final String AUDIO_BITRATE_AMR_12K65 = C5085c.AMR_12K65.m17266a();
    public static final String AUDIO_BITRATE_AMR_14K25 = C5085c.AMR_14K25.m17266a();
    public static final String AUDIO_BITRATE_AMR_15K85 = C5085c.AMR_15K85.m17266a();
    public static final String AUDIO_BITRATE_AMR_18K25 = C5085c.AMR_18K25.m17266a();
    public static final String AUDIO_BITRATE_AMR_19K85 = C5085c.AMR_19K85.m17266a();
    public static final String AUDIO_BITRATE_AMR_23K05 = C5085c.AMR_23K05.m17266a();
    public static final String AUDIO_BITRATE_AMR_23K85 = C5085c.AMR_23K85.m17266a();
    public static final String AUDIO_BITRATE_AMR_6K6 = C5085c.AMR_6K6.m17266a();
    public static final String AUDIO_BITRATE_AMR_8K85 = C5085c.AMR_8K85.m17266a();
    public static final String AUDIO_BITRATE_BV_16K = C5085c.BV_16K.m17266a();
    public static final String AUDIO_BITRATE_OPUS_16K = C5085c.OPUS_16K.m17266a();
    public static final String AUDIO_BITRATE_OPUS_18K = C5085c.OPUS_18K.m17266a();
    public static final String AUDIO_BITRATE_OPUS_20K = C5085c.OPUS_20K.m17266a();
    public static final String AUDIO_BITRATE_OPUS_24K = C5085c.OPUS_24K.m17266a();
    public static final String AUDIO_BITRATE_OPUS_32K = C5085c.OPUS_32K.m17266a();
    public static final String AUDIO_BITRATE_OPUS_8K = C5085c.OPUS_8K.m17266a();
    public static final String AUDIO_ENCODE_AMR = C5081b.AMR.m17257a();
    public static final String AUDIO_ENCODE_BV = C5081b.BV.m17257a();
    public static final String AUDIO_ENCODE_OPUS = C5081b.OPUS.m17257a();
    public static final int ERROR_APP_ID_IS_INVALID = C5097n.TTS_APP_ID_IS_INVALID.m17284b();
    public static final int ERROR_LIST_IS_TOO_LONG = C5097n.TTS_LIST_IS_TOO_LONG.m17284b();
    public static final int ERROR_QUEUE_IS_FULL = C5097n.TTS_QUEUE_IS_FULL.m17284b();
    public static final int ERROR_TEXT_ENCODE_IS_WRONG = C5097n.TEXT_ENCODE_IS_WRONG.m17284b();
    public static final int ERROR_TEXT_IS_EMPTY = C5097n.TEXT_IS_EMPTY.m17284b();
    public static final int ERROR_TEXT_IS_TOO_LONG = C5097n.TEXT_IS_TOO_LONG.m17284b();
    public static final String LANGUAGE_ZH = C5090h.ZH.m17276a();
    public static final int MAX_LIST_SIZE = 100;
    public static final int MAX_QUEUE_SIZE = 15000;
    public static final String MIX_MODE_DEFAULT = C5092j.DEFAULT.name();
    public static final String MIX_MODE_HIGH_SPEED_NETWORK = C5092j.HIGH_SPEED_NETWORK.name();
    public static final String MIX_MODE_HIGH_SPEED_SYNTHESIZE = C5092j.HIGH_SPEED_SYNTHESIZE.name();
    public static final String MIX_MODE_HIGH_SPEED_SYNTHESIZE_WIFI = C5092j.HIGH_SPEED_SYNTHESIZE_WIFI.name();
    public static final String PARAM_AUDIO_ENCODE = C5089g.m17272a(C5089g.AUDIO_ENCODE);
    public static final String PARAM_AUDIO_RATE = C5089g.m17272a(C5089g.BITRATE);
    public static final String PARAM_CUSTOM_SYNTH = C5089g.m17272a(C5089g.CUSTOM_SYNTH);
    public static final String PARAM_LANGUAGE = C5089g.m17272a(C5089g.LANGUAGE);
    public static final String PARAM_MIX_MODE = C5089g.m17272a(C5089g.MIX_MODE);
    public static final String PARAM_OPEN_XML = C5089g.m17272a(C5089g.OPEN_XML);
    public static final String PARAM_PITCH = C5089g.m17272a(C5089g.PITCH);
    public static final String PARAM_PRODUCT_ID = C5089g.m17272a(C5089g.PRODUCT_ID);
    public static final String PARAM_SPEAKER = C5089g.m17272a(C5089g.SPEAKER);
    public static final String PARAM_SPEED = C5089g.m17272a(C5089g.SPEED);
    public static final String PARAM_TTS_LICENCE_FILE = C5089g.m17272a(C5089g.TTS_LICENSE_FILE_PATH);
    public static final String PARAM_TTS_SPEECH_MODEL_FILE = C5089g.m17272a(C5089g.SPEECH_DAT_PATH);
    public static final String PARAM_TTS_TEXT_MODEL_FILE = C5089g.m17272a(C5089g.TEXT_DAT_PATH);
    public static final String PARAM_VOCODER_OPTIM_LEVEL = C5089g.m17272a(C5089g.TTS_VOCODER_OPTIMIZATION);
    public static final String PARAM_VOLUME = C5089g.m17272a(C5089g.VOLUME);
    public static final String TEXT_ENCODE_BIG5 = C5086d.BIG5.m17270b();
    public static final String TEXT_ENCODE_GBK = C5086d.GB18030.m17270b();
    public static final String TEXT_ENCODE_UTF8 = C5086d.UTF8.m17270b();
    /* renamed from: a */
    private static volatile SpeechSynthesizer f20836a = null;
    /* renamed from: b */
    private C4957a f20837b = new C4957a();

    private SpeechSynthesizer() {
    }

    public static SpeechSynthesizer getInstance() {
        if (f20836a == null) {
            synchronized (SpeechSynthesizer.class) {
                if (f20836a == null) {
                    f20836a = new SpeechSynthesizer();
                }
            }
        }
        return f20836a;
    }

    public void setSpeechSynthesizerListener(SpeechSynthesizerListener speechSynthesizerListener) {
        this.f20837b.m16462a(speechSynthesizerListener);
    }

    public void setContext(Context context) {
        this.f20837b.m16461a(context);
    }

    public synchronized int initTts(TtsMode ttsMode) {
        TtsError a;
        a = this.f20837b.m16459a(ttsMode);
        return a == null ? 0 : a.getDetailCode();
    }

    public String libVersion() {
        return this.f20837b.m16460a();
    }

    public int setApiKey(String apiKey, String secretKey) {
        setParam(C5089g.API_KEY.name(), apiKey);
        setParam(C5089g.SECRET_KEY.name(), secretKey);
        return 0;
    }

    public int setAppId(String appId) {
        if (!StringTool.isAllNumber(appId)) {
            return ERROR_APP_ID_IS_INVALID;
        }
        setParam(C5089g.APP_CODE.name(), appId);
        return 0;
    }

    public int setParam(String key, String value) {
        return this.f20837b.m16456a(key, value);
    }

    public synchronized int pause() {
        return this.f20837b.m16463b();
    }

    public synchronized int resume() {
        return this.f20837b.m16467c();
    }

    public synchronized int stop() {
        return this.f20837b.m16469d();
    }

    public synchronized int release() {
        this.f20837b.m16470e();
        f20836a = null;
        return 0;
    }

    public int loadCustomResource(String customModelPath) {
        return this.f20837b.m16455a(customModelPath);
    }

    public int freeCustomResource() {
        return this.f20837b.m16471f();
    }

    public int loadModel(String speechModelPath, String textModelPath) {
        return this.f20837b.m16464b(speechModelPath, textModelPath);
    }

    public int loadEnglishModel(String englishTextModelPath, String englishSpeechModelPath) {
        return this.f20837b.m16468c(englishTextModelPath, englishSpeechModelPath);
    }

    public int speak(String text) {
        return speak(text, null);
    }

    public int speak(SpeechSynthesizeBag speechSynthesizeBag) {
        try {
            return speak(speechSynthesizeBag.getText(), speechSynthesizeBag.getUtteranceId());
        } catch (Exception e) {
            return C5097n.TTS_PARAMETER_INVALID.m17284b();
        }
    }

    public int speak(String text, String utteranceId) {
        return speak(text, utteranceId, null);
    }

    public int speak(String text, String utteranceId, Bundle params) {
        return this.f20837b.m16457a(text, utteranceId, params);
    }

    public int synthesize(String text) {
        return synthesize(text, null);
    }

    public int synthesize(SpeechSynthesizeBag speechSynthesizeBag) {
        try {
            return synthesize(speechSynthesizeBag.getText(), speechSynthesizeBag.getUtteranceId());
        } catch (Exception e) {
            return C5097n.TTS_PARAMETER_INVALID.m17284b();
        }
    }

    public int synthesize(String text, String utteranceId) {
        return synthesize(text, utteranceId, null);
    }

    public int synthesize(String text, String utteranceId, Bundle params) {
        return this.f20837b.m16465b(text, utteranceId, params);
    }

    public int batchSpeak(List<SpeechSynthesizeBag> speechSynthesizeBags) {
        if (DataTool.isListEmpty(speechSynthesizeBags)) {
            return C5097n.TTS_PARAMETER_INVALID.m17284b();
        }
        return this.f20837b.m16458a((List) speechSynthesizeBags);
    }

    public AuthInfo auth(TtsMode ttsMode) {
        return this.f20837b.m16466b(ttsMode);
    }

    public int setStereoVolume(float leftVolume, float rightVolume) {
        return this.f20837b.m16453a(leftVolume, rightVolume);
    }

    public int setAudioStreamType(int streamType) {
        return this.f20837b.m16454a(streamType);
    }
}
