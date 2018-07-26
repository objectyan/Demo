package com.baidu.speech.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.che.codriver.p123i.C2546c;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.speech.asr.ASRListener;
import com.baidu.speech.asr.EventContext;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.speech.audio.MicrophoneServer;
import com.baidu.speech.core.BDSParamBase.BDSIntParam;
import com.baidu.speech.core.BDSParamBase.BDSObjectParam;
import com.baidu.speech.core.BDSSDKLoader.BDSCoreEventListener;
import com.baidu.speech.core.BDSSDKLoader.BDSSDKInterface;
import com.baidu.speech.utils.AsrError;
import com.baidu.speech.utils.CommonParam;
import com.baidu.speech.utils.LogUtil;
import com.baidu.speech.utils.Policy;
import com.baidu.speech.utils.Utility;
import com.facebook.common.p141m.C2924g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ASREngine implements BDSCoreEventListener {
    private static String ASR_CMD_CANCEL = "asr.cancel";
    private static String ASR_CMD_CONFIG = "asr.config";
    private static String ASR_CMD_LOAD_ENGINE = SpeechConstant.ASR_KWS_LOAD_ENGINE;
    private static String ASR_CMD_START = SpeechConstant.ASR_START;
    private static String ASR_CMD_STOP = SpeechConstant.ASR_STOP;
    private static String ASR_CMD_UNLOAD_ENGINE = SpeechConstant.ASR_KWS_UNLOAD_ENGINE;
    private static String ASR_CMD_UPLOAD_CANCEL = SpeechConstant.ASR_UPLOAD_CANCEL;
    private static String ASR_CMD_UPLOAD_CONTRACT = SpeechConstant.ASR_UPLOAD_CONTRACT;
    private static String ASR_CMD_UPLOAD_WORDS = SpeechConstant.ASR_UPLOAD_WORDS;
    private static String ASR_PARAM_KEY_ACCEPT_AUDIO_DATA = "asr_param_key_accept_audio_data.bool";
    private static String ASR_PARAM_KEY_API_SECRET_KEYS = "asr_param_key_api_secret_key.vector<string>";
    private static String ASR_PARAM_KEY_APP = "asr_param_key_app.string";
    private static String ASR_PARAM_KEY_AUDIO_FILE_PATH = "mic_audio_file_path.string";
    private static String ASR_PARAM_KEY_AUDIO_mills = "mic_audio_mills.string";
    private static String ASR_PARAM_KEY_BACKTRACK_TIME_INT = "asr_param_key_backtrack_time.int";
    private static String ASR_PARAM_KEY_BROWSER_USER_AGENT = "asr_param_key_browser_user_agent.string";
    private static String ASR_PARAM_KEY_BUA = "asr_param_key_bua.string";
    private static String ASR_PARAM_KEY_CHUNK_ENABLE = "asr_param_key_chunk_enable.bool";
    private static String ASR_PARAM_KEY_CHUNK_KEY = "asr_param_key_chunk_key.string";
    private static String ASR_PARAM_KEY_CHUNK_PARAM = "asr_param_key_chunk_param.string";
    private static String ASR_PARAM_KEY_CITY_ID = "asr_param_key_city_id.int";
    private static String ASR_PARAM_KEY_COK = "asr_param_key_cok.string";
    private static String ASR_PARAM_KEY_COMPRESSION_TYPE = "asr_param_key_compression_type.int";
    private static String ASR_PARAM_KEY_DEV = "asr_param_key_dev.string";
    private static String ASR_PARAM_KEY_DISABLE_PUNCTUATION = "asr_param_key_disable_punctuation.bool";
    private static String ASR_PARAM_KEY_DNN_HEAD_SIL_DURATION = "asr_param_key_dnn_head_sil_duration.int";
    private static String ASR_PARAM_KEY_DNN_MIN_SP_DURATION = "asr_param_key_dnn_min_sp_duration.int";
    private static String ASR_PARAM_KEY_DNN_SIL_THRESHOLD = "asr_param_key_dnn_sil_threshold.float";
    private static String ASR_PARAM_KEY_DNN_SPEECH_THRESHOLD = "asr_param_key_dnn_speech_threshold.float";
    private static String ASR_PARAM_KEY_EARLY_CONNECTION = "asr_param_key_early_connection.bool";
    private static String ASR_PARAM_KEY_ENABLE_CONTACTS = "asr_param_key_enable_contacts.bool";
    private static String ASR_PARAM_KEY_ENABLE_DRC = "asr_param_key_enable_drc.bool";
    private static String ASR_PARAM_KEY_ENABLE_EARLY_RETURN = "asr_param_key_enable_early_return.bool";
    private static String ASR_PARAM_KEY_ENABLE_HTTPDNS = "asr_param_key_enable_httpdns.bool";
    private static String ASR_PARAM_KEY_ENABLE_LOCAL_VAD = "asr_param_key_enable_local_vad.bool";
    private static String ASR_PARAM_KEY_ENABLE_LONG_SPEECH = "asr_param_key_enable_long_speech.bool";
    private static String ASR_PARAM_KEY_ENABLE_MODEL_VAD = "asr_param_key_enable_model_vad.int";
    private static String ASR_PARAM_KEY_ENABLE_NLU = "asr_param_key_enable_nlu.bool";
    private static String ASR_PARAM_KEY_ENABLE_SERVER_VAD = "asr_param_key_enable_server_vad.bool";
    private static String ASR_PARAM_KEY_FRM = "asr_param_key_frm.string";
    private static String ASR_PARAM_KEY_GLB = "asr_param_key_glb.string";
    private static String ASR_PARAM_KEY_IS_ONESHOT_INT = "asr_param_key_is_oneshot.int";
    private static String ASR_PARAM_KEY_KWS_PROTOCOL = "asr_param_key_kws_protocol.int";
    private static String ASR_PARAM_KEY_LANGUAGE = "asr_param_key_language.int";
    private static String ASR_PARAM_KEY_LTP = "asr_param_key_ltp.string";
    private static String ASR_PARAM_KEY_MAX_WAIT_DURATION = "asr_param_key_max_wait_duration.int";
    private static String ASR_PARAM_KEY_MODEL_VAD_DAT_FILE = "asr_param_key_model_vad_dat_file.string";
    private static String ASR_PARAM_KEY_MULTI_START_AND_END = "asr_param_key_multi_start_and_end.bool";
    private static String ASR_PARAM_KEY_NETWORK_STATUS = "asr_param_key_network_status.int";
    private static String ASR_PARAM_KEY_OFFLINE_APP_CODE = "offline_param_key_app_code.string";
    private static String ASR_PARAM_KEY_OFFLINE_ENGINE_DAT_FILE_PATH = "kws_param_key_dat_filepath.string";
    private static String ASR_PARAM_KEY_OFFLINE_ENGINE_GRAMMER_FILE_PATH = "kws_param_key_grammer_filepath.string";
    private static String ASR_PARAM_KEY_OFFLINE_ENGINE_TYPE = "kws_param_key_type.int";
    private static String ASR_PARAM_KEY_PAM = "asr_param_key_pam.string";
    private static String ASR_PARAM_KEY_PLATFORM = "asr_param_key_platform.string";
    private static String ASR_PARAM_KEY_PRODUCT_ID = "asr_param_key_product_id.string";
    private static String ASR_PARAM_KEY_PROPERTY_LIST = "asr_param_key_property_list.vector<int>";
    private static String ASR_PARAM_KEY_PROTOCOL = "asr_param_key_protocol.int";
    private static String ASR_PARAM_KEY_PU = "asr_param_key_pu.string";
    private static String ASR_PARAM_KEY_PUNCTUATION_EXT_MODE = "asr_param_key_punctuation_ext_mode.int";
    private static String ASR_PARAM_KEY_REALTIME_DATA = "asr_param_key_realtime_data.string";
    private static String ASR_PARAM_KEY_RSV = "asr_param_key_rsv.map<string,string>";
    private static String ASR_PARAM_KEY_SAMPLE_RATE = "asr_param_key_sample_rate.int";
    private static String ASR_PARAM_KEY_SDK_VERSION = "asr_param_key_sdk_version.string";
    private static String ASR_PARAM_KEY_SERVER_AGENT_URL = "asr_param_key_server_agent_url.string";
    private static String ASR_PARAM_KEY_SERVER_URL = "asr_param_key_server_url.string";
    private static String ASR_PARAM_KEY_START_TONE = "asr_param_key_start_tone.int";
    private static String ASR_PARAM_KEY_STC = "asr_param_key_stc.string";
    private static String ASR_PARAM_KEY_STRATEGY = "asr_param_key_strategy.int";
    private static String ASR_PARAM_KEY_TXT = "asr_param_key_txt.string";
    private static String ASR_PARAM_KEY_UID_STRING = "uid.string";
    private static String ASR_PARAM_KEY_VAD_ENABLE_LONG_PRESS = "vad_enable_long_press.bool";
    private static String ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT = "asr_param_key_vad_endpoint_timeout.int";
    private static String ASR_PARAM_KEY_WAKEUP_STATUS_INT = "asr_param_key_wakeup_status.int";
    private static String ASR_PARAM_KEY_WAKEUP_WORDS_STRING = "asr_param_key_wakeup_words.string";
    private static String BDS_ASR_OFFLINE_ENGINE_GRAMMER_SLOT = "kws_param_key_slot.string";
    private static String BDS_ASR_OFFLINE_ENGINE_TRIGGERED_WAKEUP_WORD = "kws_param_key_triggered_wakeup_word.string";
    private static String COMMON_PARAM_KEY_DEBUG_LOG_LEVEL = "common_param_key_debug_log_level.int";
    private static final boolean DEBUG = true;
    public static final int ERROR_AUDIO = 3;
    public static final int ERROR_CLIENT = 5;
    public static final int ERROR_INSUFFICIENT_PERMISSIONS = 9;
    public static final int ERROR_NETWORK = 2;
    public static final int ERROR_NETWORK_TIMEOUT = 1;
    public static final int ERROR_NO_MATCH = 7;
    public static final int ERROR_RECOGNIZER_BUSY = 8;
    public static final int ERROR_SERVER = 4;
    public static final int ERROR_SPEECH_TIMEOUT = 6;
    private static final int EVoiceRecognitionClientWorkStatusCancel = 7;
    private static final int EVoiceRecognitionClientWorkStatusChunkEnd = 14;
    private static final int EVoiceRecognitionClientWorkStatusChunkNlu = 13;
    private static final int EVoiceRecognitionClientWorkStatusChunkThirdData = 12;
    private static final int EVoiceRecognitionClientWorkStatusEnd = 2;
    private static final int EVoiceRecognitionClientWorkStatusError = 8;
    private static final int EVoiceRecognitionClientWorkStatusExit = 18;
    private static final int EVoiceRecognitionClientWorkStatusFinish = 5;
    private static final int EVoiceRecognitionClientWorkStatusFlushData = 4;
    private static final int EVoiceRecognitionClientWorkStatusLOG = 11;
    private static final int EVoiceRecognitionClientWorkStatusLoaded = 9;
    private static final int EVoiceRecognitionClientWorkStatusLongSpeechEnd = 17;
    private static final int EVoiceRecognitionClientWorkStatusMeterLevel = 6;
    private static final int EVoiceRecognitionClientWorkStatusNewRecordData = 3;
    private static final int EVoiceRecognitionClientWorkStatusStart = 1;
    private static final int EVoiceRecognitionClientWorkStatusStartWorkIng = 0;
    private static final int EVoiceRecognitionClientWorkStatusUnLoaded = 10;
    private static String MIC_PARAM_KEY_SOCKET_PORT = "mic_param_key_socket_port.int";
    private static String OFFLINE_PARAM_KEY_LICENSE_FILE_PATH = "offline_param_key_license_filepath.string";
    private static final String TAG = "ASREngine";
    private static boolean hasBegin = false;
    private static boolean hasEnd = false;
    private static boolean hasPartialResult = false;
    static final MediaPlayer player = new MediaPlayer();
    private int decodertemp = 0;
    private boolean enableLongSpeech = false;
    private boolean isOfflineLast = false;
    private String mApp;
    private String mChunkFinishResult = "";
    private Context mContext = null;
    private boolean mEnableChunk = false;
    private boolean mEnableLogFeedBack = true;
    private boolean mEnableLongPress = false;
    private EventContext mEventContext;
    private boolean mExceptioned = false;
    private boolean mFeedBackAudio = false;
    private boolean mIsWorking = false;
    private String mLastRecognitionResult = "";
    private ASRListener mListener;
    private Map<String, JSONObject> mOriginNlp = new HashMap();
    private String mOutFile = null;
    private JSONObject mParams;
    private String mPlatform;
    private String mSerialNumber = "";
    private int mStreamType = -1;
    private String mUserData = null;
    private String mVersion;
    private int mVolumeFeedbackCount = 0;
    private BDSSDKInterface m_ASRcore;
    private Future<JSONObject> nlpFeature;
    private ExecutorService nluBuilderThread = Executors.newSingleThreadExecutor();
    private JSONObject usingSimpleNlp;

    /* renamed from: com.baidu.speech.core.ASREngine$1 */
    class C49441 implements Runnable {
        C49441() {
        }

        public void run() {
            ASREngine.this.generateEndResult();
        }
    }

    public ASREngine(Context context) throws Exception {
        Exception exception;
        this.mContext = context;
        this.mEventContext = new EventContext(context);
        try {
            BDSSDKLoader.loadLibraries();
            try {
                this.m_ASRcore = BDSSDKLoader.getSDKObjectForSDKType("ASRCore", this.mContext);
                if (this.m_ASRcore == null) {
                    throw new Exception("ASR core support is not linked in package");
                } else if (this.m_ASRcore.instanceInitialized()) {
                    this.m_ASRcore.setListener(this);
                } else {
                    throw new Exception("Failed initialize ASR Core native layer");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                exception = new Exception("Can't found ASR Core native method");
            }
        } catch (Throwable th2) {
            exception = new Exception(generateErrorResult(5001));
        }
    }

    private String adaptiveOfflineResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("origin_result");
            if (jSONObject.has("raw_text")) {
                str = new JSONObject(str).put("results_recognition", new JSONArray().put(jSONObject.getString("raw_text"))).toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str;
    }

    private void asrCallBack(BDSMessage bDSMessage, ASRListener aSRListener) {
        if (bDSMessage.m_messageName.equals(SpeechConstant.ASR_CALLBACk_NAME)) {
            LogUtil.m16427i(TAG, "ASRCallBack:" + bDSMessage.toString());
            Map hashMap;
            String str;
            byte[] bArr;
            String generateChunkFinalResult;
            int min;
            String generateThirdResult;
            switch (((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ASR_STATUS)).iValue) {
                case 0:
                    hasBegin = false;
                    hasPartialResult = false;
                    hasEnd = false;
                    aSRListener.onEvent("asr.ready", null, null, 0, 0);
                    return;
                case 1:
                    this.mSerialNumber = (String) ((BDSObjectParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ASR_RESULT)).iValue;
                    hashMap = new HashMap();
                    hashMap.put(NaviStatConstants.K_NSC_KEY_SN, this.mSerialNumber);
                    new Thread(new C49441()).start();
                    aSRListener.onEvent("asr.sn", new JSONObject(hashMap).toString(), null, 0, 0);
                    if (!hasBegin) {
                        aSRListener.onEvent("asr.begin", null, null, 0, 0);
                        hasBegin = true;
                        return;
                    }
                    return;
                case 2:
                    if (!hasEnd) {
                        play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_END, -1)), false);
                        try {
                            str = (String) ((BDSObjectParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ASR_RESULT)).iValue;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("vad_silent_start", str);
                            aSRListener.onEvent("asr.end", jSONObject.toString(), null, 0, 0);
                            hasEnd = true;
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 3:
                    bArr = bDSMessage.m_messageData;
                    if (this.mFeedBackAudio && bArr != null) {
                        aSRListener.onEvent("asr.audio", null, bArr, 0, bArr.length);
                    }
                    saveOutFile(bArr);
                    return;
                case 4:
                    hasPartialResult = true;
                    if (!hasBegin) {
                        aSRListener.onEvent("asr.begin", null, null, 0, 0);
                        hasBegin = true;
                    }
                    str = (String) ((BDSObjectParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ASR_RESULT)).iValue;
                    this.mLastRecognitionResult = str;
                    aSRListener.onEvent("asr.partial", generateChunkPartialResult(adaptiveOfflineResult(str)), null, 0, 0);
                    return;
                case 5:
                    boolean z;
                    if (!hasEnd) {
                        play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_END, -1)), false);
                        aSRListener.onEvent("asr.end", null, null, 0, 0);
                        hasEnd = true;
                    }
                    play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_SUCCESS, -1)), false);
                    this.mLastRecognitionResult = "";
                    String adaptiveOfflineResult = adaptiveOfflineResult((String) ((BDSObjectParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ASR_RESULT)).iValue);
                    try {
                        z = new JSONObject(adaptiveOfflineResult).optJSONArray("results_recognition").length() == 0;
                    } catch (JSONException e2) {
                        z = true;
                    }
                    JSONObject jSONObject2;
                    if (z) {
                        play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_ERROR, -1)), false);
                        try {
                            jSONObject2 = new JSONObject();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(NaviStatConstants.K_NSC_KEY_SN, this.mSerialNumber);
                            jSONObject3.put(ParamKey.KEY_MSG_ERRORS, 7);
                            jSONObject2.put("desc", "Speech Quality Problem");
                            jSONObject2.put("origin_result", jSONObject3);
                            jSONObject2.put(ParamKey.KEY_MSG_ERRORS, 7);
                            jSONObject2.put("desc", "Speech Quality Problem");
                            aSRListener.onEvent("asr.finish", jSONObject2.toString(), null, 0, 0, true);
                            this.mIsWorking = false;
                            return;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    generateChunkFinalResult = generateChunkFinalResult(adaptiveOfflineResult);
                    if (this.mEnableChunk) {
                        aSRListener.onEvent("asr.partial", generateChunkFinalResult, null, 0, 0, true);
                        if (this.isOfflineLast) {
                            hashMap = new HashMap();
                            hashMap.put(ParamKey.KEY_MSG_ERRORS, Integer.valueOf(0));
                            hashMap.put("desc", "Speech Recognize success.");
                            Map hashMap2 = new HashMap();
                            hashMap2.put("err_no", Integer.valueOf(0));
                            hashMap2.put(ParamKey.KEY_MSG_ERRORS, "Speech Recognize success.");
                            hashMap.put("origin_result", new JSONObject(hashMap2));
                            aSRListener.onEvent("asr.finish", new JSONObject(hashMap).toString(), null, 0, 0);
                            this.mIsWorking = false;
                            this.isOfflineLast = false;
                        }
                    } else {
                        try {
                            jSONObject2 = new JSONObject(generateChunkFinalResult);
                            jSONObject2.put("desc", "success");
                            jSONObject2.put(ParamKey.KEY_MSG_ERRORS, 0);
                        } catch (Exception e32) {
                            e32.printStackTrace();
                            jSONObject2 = new JSONObject();
                        }
                        aSRListener.onEvent("asr.finish", jSONObject2.toString(), null, 0, 0, true);
                        this.mIsWorking = false;
                    }
                    hasPartialResult = false;
                    return;
                case 6:
                    this.mVolumeFeedbackCount++;
                    if (this.mVolumeFeedbackCount % 5 == 0) {
                        int i = ((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.strCALLBACK_ASR_LEVEL)).iValue / 100;
                        min = (int) (Math.min(5000.0f, (float) i) / 50.0f);
                        Map hashMap3 = new HashMap();
                        hashMap3.put(C1981b.f6362b, Integer.valueOf(i));
                        hashMap3.put("volume-percent", Integer.valueOf(min));
                        aSRListener.onEvent("asr.volume", new JSONObject(hashMap3).toString(), null, 0, 0);
                        return;
                    }
                    return;
                case 7:
                    play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_CANCEL, -1)), false);
                    aSRListener.onEvent("asr.cancel", null, null, 0, 0);
                    hasBegin = false;
                    return;
                case 8:
                    play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_ERROR, -1)), false);
                    hasBegin = false;
                    int i2 = ((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_DOMAIN)).iValue;
                    str = (String) ((BDSObjectParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_DESC)).iValue;
                    min = ((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_CODE)).iValue;
                    generateChunkFinalResult = "";
                    if (Log.isLoggable(TAG, 3)) {
                        Log.e(TAG, "EVoiceRecognitionClientWorkStatusError errorDomain : " + i2 + " errorCode : " + min + " desc : " + str + " mLastRecognitionResult: " + this.mLastRecognitionResult);
                    } else {
                        Log.e(TAG, "EVoiceRecognitionClientWorkStatusError errorDomain : " + i2 + " errorCode : " + min + " desc : " + str + " mLastRecognitionResult: " + this.mLastRecognitionResult);
                    }
                    if (this.mLastRecognitionResult.isEmpty() || i2 != 20 || min == 1 || !hasPartialResult) {
                        try {
                            generateChunkFinalResult = generateErrorResult(i2, min);
                        } catch (Exception e4) {
                        }
                        aSRListener.onEvent("asr.finish", generateChunkFinalResult, null, 0, 0);
                        this.mIsWorking = false;
                        return;
                    }
                    play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_END, -1)), false);
                    aSRListener.onEvent("asr.end", null, null, 0, 0);
                    if (this.mEnableChunk) {
                        aSRListener.onEvent("asr.partial", generateChunkFinalResult(this.mLastRecognitionResult), null, 0, 0, true);
                        play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_SUCCESS, -1)), false);
                        aSRListener.onEvent("asr.finish", this.mChunkFinishResult, null, 0, 0);
                    } else {
                        play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_SUCCESS, -1)), false);
                        aSRListener.onEvent("asr.finish", this.mLastRecognitionResult, null, 0, 0);
                    }
                    this.mIsWorking = false;
                    return;
                case 9:
                    aSRListener.onEvent("asr.loaded", null, null, 0, 0);
                    return;
                case 10:
                    aSRListener.onEvent("asr.unloaded", null, null, 0, 0);
                    return;
                case 11:
                    if (this.mEnableLogFeedBack) {
                        aSRListener.onEvent("asr.log", (String) ((BDSObjectParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ASR_RESULT)).iValue, null, 0, 0);
                        return;
                    }
                    return;
                case 12:
                    if (this.mEnableChunk) {
                        generateThirdResult = generateThirdResult();
                        bArr = bDSMessage.m_messageData;
                        if (bArr != null) {
                            aSRListener.onEvent("asr.partial", generateThirdResult, bArr, 0, bArr.length);
                            return;
                        }
                        return;
                    }
                    return;
                case 13:
                    if (this.mEnableChunk) {
                        generateThirdResult = generateNluResult();
                        bArr = bDSMessage.m_messageData;
                        if (bArr != null) {
                            aSRListener.onEvent("asr.partial", generateThirdResult, bArr, 0, bArr.length);
                            return;
                        }
                        return;
                    }
                    return;
                case 14:
                    aSRListener.onEvent("asr.finish", this.mChunkFinishResult, null, 0, 0);
                    if (!this.enableLongSpeech) {
                        this.mIsWorking = false;
                        play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_SUCCESS, -1)), false);
                        return;
                    }
                    return;
                case 17:
                    aSRListener.onEvent(SpeechConstant.CALLBACK_EVENT_ASR_LONG_SPEECH, null, null, 0, 0);
                    this.mIsWorking = false;
                    return;
                case 18:
                    aSRListener.onEvent("asr.exit", null, null, 0, 0);
                    return;
                default:
                    return;
            }
        }
    }

    private void clearOutFile() {
        IOException e;
        Throwable th;
        if (this.mOutFile != null && !this.mOutFile.equals("")) {
            OutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(this.mOutFile);
                try {
                    fileOutputStream.write("".getBytes());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        e2.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = null;
                e22.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    private void fillNlpResult(String str, JSONObject jSONObject) throws Exception {
        if (this.nlpFeature != null) {
            this.usingSimpleNlp = (JSONObject) this.nlpFeature.get();
            this.nlpFeature = null;
        }
        if (this.usingSimpleNlp != null) {
            if (jSONObject.optInt(ParamKey.KEY_MSG_ERRORS, 0) == 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray("results_recognition");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    CharSequence substring;
                    String optString = optJSONArray.optString(0);
                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(str) || optString.length() <= str.length()) {
                        Object obj = optString;
                    } else {
                        substring = optString.substring(str.length());
                    }
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = this.usingSimpleNlp.getJSONObject("rules");
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        optString = (String) keys.next();
                        JSONArray jSONArray2 = jSONObject2.getJSONArray(optString);
                        for (int i = 0; i < jSONArray2.length(); i++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                            String string = jSONObject3.getString("pattern");
                            JSONArray jSONArray3 = jSONObject3.getJSONArray("groups");
                            Matcher matcher = Pattern.compile(string).matcher(substring);
                            while (matcher.find()) {
                                Object obj2;
                                Object obj3;
                                JSONObject jSONObject4 = new JSONObject();
                                String[] split = optString.split("\\.");
                                if (split.length >= 2) {
                                    obj2 = split[0];
                                    obj3 = split[1];
                                } else {
                                    String str2 = optString;
                                    string = optString;
                                }
                                jSONObject4.put("domain", obj2);
                                jSONObject4.put("intent", obj3);
                                jSONObject4.put("parser", "bsg");
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject4.put("object", jSONObject5);
                                int groupCount = matcher.groupCount();
                                for (int i2 = 0; i2 < groupCount; i2++) {
                                    jSONObject5.put(jSONArray3.getString(i2), matcher.group(i2 + 1));
                                }
                                jSONArray.put(jSONObject4);
                            }
                        }
                    }
                    optString = (String) this.mEventContext.searchItemFromJson(new JSONObject(jSONObject.optString("origin_result")), "json_res");
                    if (!TextUtils.isEmpty(optString)) {
                        JSONArray optJSONArray2 = new JSONObject(optString).optJSONArray("results");
                        if (optJSONArray2 != null) {
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                jSONArray.put(optJSONArray2.getJSONObject(i3));
                            }
                        }
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("raw_text", substring);
                    jSONObject6.put("results", jSONArray);
                    jSONObject.put("results_nlu", jSONObject6);
                }
            }
        }
    }

    private String generateChunkFinalResult(String str) {
        String str2 = "";
        CharSequence charSequence = "";
        if (str == null) {
            str = "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("origin_result");
            Object obj = "";
            if (optJSONObject != null) {
                if (optJSONObject.optJSONObject("result") != null) {
                    if (optJSONObject.optJSONObject("result").optJSONArray("word") != null) {
                        obj = optJSONObject.optJSONObject("result").optJSONArray("word").optString(0);
                    } else if (!(optJSONObject.optJSONObject("content") == null || optJSONObject.optJSONObject("content").optJSONArray("item") == null)) {
                        obj = optJSONObject.optJSONObject("content").optJSONArray("item").optString(0);
                    }
                }
                if (optJSONObject.has("raw_text")) {
                    obj = optJSONObject.optString("raw_text");
                    if (isIllegalResult(obj)) {
                        obj = obj.replace("1。00。", "");
                    }
                    this.isOfflineLast = true;
                } else if (!(optJSONObject.optJSONObject("result") == null || optJSONObject.optJSONObject("result").optString("raw_text") == null || !"KWS".equals(optJSONObject.optJSONObject("result").optString(NaviStatConstants.K_NSC_KEY_SN)))) {
                    obj = optJSONObject.optJSONObject("result").optString("raw_text");
                    this.isOfflineLast = true;
                }
                if (this.mParams != null && ("enable".equals(this.mParams.optString(SpeechConstant.NLU)) || C2546c.f8430Z.equals(this.mParams.optString(SpeechConstant.NLU)))) {
                    charSequence = getNlpResult(this.mParams.optString("keyword"), new JSONObject(str));
                }
            }
            if (obj == null) {
                obj = "";
            }
            Map hashMap = new HashMap();
            hashMap.put("result_type", "final_result");
            hashMap.put("best_result", obj);
            hashMap.put("origin_result", optJSONObject);
            hashMap.put(ParamKey.KEY_MSG_ERRORS, Integer.valueOf(0));
            hashMap.put("results_recognition", new JSONArray().put(obj));
            if (!TextUtils.isEmpty(charSequence)) {
                hashMap.put("results_nlu", charSequence);
            }
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    private String generateChunkPartialResult(String str) {
        String str2 = "";
        CharSequence charSequence = "";
        if (str == null) {
            str = "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("origin_result");
            Object obj = "";
            if (optJSONObject != null) {
                if (optJSONObject.optJSONObject("result") != null) {
                    if (optJSONObject.optJSONObject("result").optJSONArray("word") != null) {
                        obj = optJSONObject.optJSONObject("result").optJSONArray("word").optString(0);
                    } else if (!(optJSONObject.optJSONObject("content") == null || optJSONObject.optJSONObject("content").optJSONArray("item") == null)) {
                        obj = optJSONObject.optJSONObject("content").optJSONArray("item").optString(0);
                    }
                }
                if (optJSONObject.has("raw_text")) {
                    obj = optJSONObject.optString("raw_text");
                    if (isIllegalResult(obj)) {
                        obj = obj.replace("1。00。", "");
                    }
                } else if (!(optJSONObject.optJSONObject("result") == null || optJSONObject.optJSONObject("result").optString("raw_text") == null || !"KWS".equals(optJSONObject.optJSONObject("result").optString(NaviStatConstants.K_NSC_KEY_SN)))) {
                    obj = optJSONObject.optJSONObject("result").optString("raw_text");
                }
            }
            if (this.mParams != null && C2546c.f8430Z.equals(this.mParams.optString(SpeechConstant.NLU))) {
                charSequence = getNlpResult(this.mParams.optString("keyword"), new JSONObject(str));
            }
            if (obj == null) {
                obj = "";
            }
            Map hashMap = new HashMap();
            hashMap.put("result_type", "partial_result");
            hashMap.put("best_result", obj);
            hashMap.put("origin_result", optJSONObject);
            hashMap.put(ParamKey.KEY_MSG_ERRORS, Integer.valueOf(0));
            hashMap.put("results_recognition", new JSONArray().put(obj));
            if (!TextUtils.isEmpty(charSequence)) {
                hashMap.put("results_nlu", charSequence);
            }
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    private void generateEndResult() {
        Map hashMap = new HashMap();
        hashMap.put(ParamKey.KEY_MSG_ERRORS, Integer.valueOf(0));
        hashMap.put("desc", "Speech Recognize success.");
        Map hashMap2 = new HashMap();
        hashMap2.put(NaviStatConstants.K_NSC_KEY_SN, this.mSerialNumber);
        hashMap2.put("err_no", Integer.valueOf(0));
        hashMap2.put(ParamKey.KEY_MSG_ERRORS, "Speech Recognize success.");
        hashMap.put("origin_result", new JSONObject(hashMap2));
        this.mChunkFinishResult = new JSONObject(hashMap).toString();
    }

    private String generateErrorResult(int i) throws Exception {
        String descFromCode = AsrError.getDescFromCode(i);
        int i2 = i / 1000;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(NaviStatConstants.K_NSC_KEY_SN, this.mSerialNumber);
        jSONObject2.put(ParamKey.KEY_MSG_ERRORS, i2);
        jSONObject2.put("desc", descFromCode);
        jSONObject2.put("sub_error", i);
        jSONObject.put("origin_result", jSONObject2);
        jSONObject.put(ParamKey.KEY_MSG_ERRORS, i2);
        jSONObject.put("desc", descFromCode);
        jSONObject.put("sub_error", i);
        return jSONObject.toString();
    }

    private String generateErrorResult(int i, int i2) throws Exception {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "generateErrorResult errDomain = " + i + " errCode = " + i2);
        } else {
            Log.d(TAG, "generateErrorResult errDomain = " + i + " errCode = " + i2);
        }
        if (Utility.getWifiOr2gOr3G(this.mContext) == 0 && this.decodertemp == 0) {
            return generateErrorResult(2100);
        }
        String str = "";
        if (AsrError.getDescFromCode(i2) == null && i != 10) {
            if (i == 20) {
                if (1 == i2) {
                    i2 = 3100;
                } else if (2 == i2 && !hasPartialResult) {
                    i2 = AsrError.ERROR_AUDIO_VAD_NO_SPEECH;
                } else if (3 == i2 && !hasPartialResult) {
                    i2 = AsrError.ERROR_AUDIO_VAD_SPEAK_TOO_SHORT;
                }
            } else if (i == 30) {
                if (i2 == 1) {
                    i2 = AsrError.ERROR_ASR_ENGINE_BUSY;
                } else if (i2 == 2) {
                    i2 = 2100;
                } else if (i2 == 3) {
                    i2 = 5003;
                } else if (i2 == 4) {
                    i2 = AsrError.ERROR_CLIENT_RESOLVE_URL;
                }
            } else if (i == 31) {
                i2 = 2100;
            } else if (i != 32) {
                if (i == 33) {
                    if (i2 == -3001) {
                        i2 = 4001;
                    } else if (i2 == -3002) {
                        i2 = 4002;
                    } else if (i2 == -3003) {
                        i2 = 4003;
                    } else if (i2 == -3004) {
                        i2 = 4004;
                    } else if (i2 == -3005) {
                        i2 = AsrError.ERROR_NO_MATCH_RESULT;
                    } else if (i2 == -3006) {
                        i2 = 6001;
                    }
                } else if (i != 34) {
                    i2 = AsrError.ERROR_NO_MATCH_RESULT;
                } else if (i2 == 1) {
                    i2 = 10001;
                } else if (i2 == 2) {
                    i2 = 10002;
                } else if (i2 == 3) {
                    i2 = AsrError.ERROR_OFFLINE_INVALID_LICENSE;
                } else if (i2 == 4) {
                    i2 = AsrError.ERROR_OFFLINE_PARAM;
                } else if (i2 == 5) {
                    i2 = AsrError.ERROR_OFFLINE_NOT_INITIAL;
                } else if (i2 == 6) {
                    if (this.decodertemp != 4) {
                        i2 = AsrError.ERROR_OFFLINE_INVALID_MODEL;
                    }
                } else if (i2 == 7) {
                    i2 = AsrError.ERROR_OFFLINE_INVALID_GRAMMAR;
                } else if (i2 == 8) {
                    i2 = AsrError.ERROR_OFFLINE_ENGINE_RESET_FAIL;
                } else if (i2 == 9) {
                    i2 = AsrError.ERROR_OFFLINE_ENGINE_INITIAL_FAIL;
                } else if (i2 == 10) {
                    i2 = AsrError.ERROR_OFFLINE_ENGINE_FREE_FAIL;
                } else if (i2 == 11) {
                    i2 = AsrError.ERROR_OFFLINE_ENGINE_NOT_SUPPORT;
                } else if (i2 == 12 && !hasPartialResult) {
                    i2 = AsrError.ERROR_OFFLINE_RECOGNIZE_FAIL;
                }
            }
            i2 = -1;
        }
        return generateErrorResult(i2);
    }

    private String generateNluResult() {
        Map hashMap = new HashMap();
        hashMap.put("result_type", "nlu_result");
        hashMap.put("best_result", "");
        hashMap.put("origin_result", "");
        return new JSONObject(hashMap).toString();
    }

    private String generateThirdResult() {
        Map hashMap = new HashMap();
        hashMap.put("result_type", "third_result");
        hashMap.put("best_result", "");
        hashMap.put("origin_result", "");
        return new JSONObject(hashMap).toString();
    }

    private int getLanguageFlag(String str) {
        return (str == null || str.equals("") || str.equals("cmn-Hans-CN")) ? 0 : str.equals("yue-Hans-CN") ? 1 : str.equals("en-GB") ? 2 : str.equals("sichuan-Hans-CN") ? 3 : 0;
    }

    private String getNlpResult(String str, JSONObject jSONObject) throws Exception {
        if (this.nlpFeature != null) {
            this.usingSimpleNlp = (JSONObject) this.nlpFeature.get();
            this.nlpFeature = null;
        }
        if (this.usingSimpleNlp == null) {
            return null;
        }
        if (jSONObject.optInt(ParamKey.KEY_MSG_ERRORS, 0) != 0) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("results_recognition");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return null;
        }
        CharSequence substring;
        String optString = optJSONArray.optString(0);
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(str) || optString.length() <= str.length()) {
            Object obj = optString;
        } else {
            substring = optString.substring(str.length());
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = this.usingSimpleNlp.getJSONObject("rules");
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            int i;
            optString = (String) keys.next();
            JSONArray jSONArray2 = jSONObject2.getJSONArray(optString);
            for (i = 0; i < jSONArray2.length(); i++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                String string = jSONObject3.getString("pattern");
                JSONArray jSONArray3 = jSONObject3.getJSONArray("groups");
                Matcher matcher = Pattern.compile(string).matcher(substring);
                while (matcher.find()) {
                    Object obj2;
                    Object obj3;
                    JSONObject jSONObject4 = new JSONObject();
                    String[] split = optString.split("\\.");
                    if (split.length >= 2) {
                        obj2 = split[0];
                        obj3 = split[1];
                    } else {
                        String str2 = optString;
                        string = optString;
                    }
                    jSONObject4.put("domain", obj2);
                    jSONObject4.put("intent", obj3);
                    jSONObject4.put("parser", "bsg");
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject4.put("object", jSONObject5);
                    int groupCount = matcher.groupCount();
                    for (int i2 = 0; i2 < groupCount; i2++) {
                        jSONObject5.put(jSONArray3.getString(i2), matcher.group(i2 + 1));
                    }
                    jSONArray.put(jSONObject4);
                }
            }
        }
        optString = (String) this.mEventContext.searchItemFromJson(new JSONObject(jSONObject.optString("origin_result")), "json_res");
        if (!TextUtils.isEmpty(optString)) {
            optJSONArray = (JSONArray) this.mEventContext.searchItemFromJson(new JSONObject(optString), "results");
            if (optJSONArray != null) {
                for (i = 0; i < optJSONArray.length(); i++) {
                    jSONArray.put(optJSONArray.getJSONObject(i));
                }
            }
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("raw_text", substring);
        jSONObject6.put("results", jSONArray);
        return jSONObject6.toString();
    }

    private int getSampleRateFlag(int i) {
        return i == 8000 ? 1 : i == 16000 ? 2 : 0;
    }

    private BDSErrorDescription initConfig(BDSErrorDescription bDSErrorDescription, JSONObject jSONObject) throws Exception {
        String string;
        String string2;
        String format;
        BDSMessage bDSMessage = new BDSMessage();
        bDSMessage.m_messageName = ASR_CMD_CONFIG;
        bDSMessage.m_messageParams = new HashMap();
        ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
        CharSequence optString = jSONObject.optString(C2546c.at, jSONObject.optString("pid"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PRODUCT_ID, BDSParamBase.objectParam(optString, "java.lang.String"));
        String optString2 = jSONObject.optString(C2546c.aI, jSONObject.optString("agent.url", ""));
        if (TextUtils.isEmpty(optString)) {
            string = applicationInfo.metaData == null ? null : applicationInfo.metaData.getString("com.baidu.speech.API_KEY");
            string2 = applicationInfo.metaData == null ? "" : applicationInfo.metaData.getString("com.baidu.speech.SECRET_KEY");
            string = jSONObject.optString("key", jSONObject.optString("apikey", string));
            string2 = jSONObject.optString(SpeechConstant.SECRET, string2);
            if (!(string == null || string2 == null)) {
                Vector vector = new Vector();
                vector.add(string);
                vector.add(string2);
                bDSMessage.m_messageParams.put(ASR_PARAM_KEY_API_SECRET_KEYS, BDSParamBase.objectParam(vector, "java.util.Vector;"));
            }
        }
        string = jSONObject.optString(C2546c.ax, "");
        string2 = jSONObject.optString(SpeechConstant.APP_NAME, Policy.app(this.mContext));
        StringBuilder stringBuilder = new StringBuilder();
        string = (string == null || "".equals(string)) ? "" : string + "/";
        this.mApp = stringBuilder.append(string).append(string2).toString();
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_APP, BDSParamBase.objectParam(this.mApp, "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_CHUNK_KEY, BDSParamBase.objectParam(jSONObject.optString("decoder-server.key", jSONObject.optString("key", "")), "java.lang.String"));
        string = jSONObject.optString(SpeechConstant.APP_ID, applicationInfo.metaData == null ? null : applicationInfo.metaData.getInt("com.baidu.speech.APP_ID") + "");
        if (string != null) {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_APP_CODE, BDSParamBase.objectParam(string, "java.lang.String"));
        }
        int optInt = jSONObject.optInt(SpeechConstant.LOG_LEVEL, -1);
        if (optInt != -1) {
            bDSMessage.m_messageParams.put(COMMON_PARAM_KEY_DEBUG_LOG_LEVEL, BDSParamBase.intParam(optInt));
        }
        int optInt2 = jSONObject.optInt(C2546c.ay, jSONObject.optInt(SpeechConstant.DECODER, 0));
        this.decodertemp = optInt2;
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_STRATEGY, BDSParamBase.intParam(optInt2));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_SAMPLE_RATE, BDSParamBase.intParam(getSampleRateFlag(jSONObject.optInt("audio.sample", jSONObject.optInt(SpeechConstant.SAMPLE_RATE, 16000)))));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_LANGUAGE, BDSParamBase.intParam(getLanguageFlag(jSONObject.optString("decoder-offline.language", jSONObject.optString(SpeechConstant.LANGUAGE, "cmn-Hans-CN")))));
        String optString3 = jSONObject.optString(SpeechConstant.VAD, jSONObject.optString(SpeechConstant.VAD, "model-vad"));
        if (Log.isLoggable(TAG, 3)) {
            Log.e(TAG, "VAD Model=" + optString3);
            format = String.format("%s/%s", new Object[]{this.mContext.getApplicationInfo().nativeLibraryDir, "libbd_easr_s1_merge_normal_20151216.dat.so"});
        } else {
            Log.e(TAG, "VAD Model=" + optString3);
            format = String.format("%s/%s", new Object[]{this.mContext.getApplicationInfo().nativeLibraryDir, "libbd_easr_s1_merge_normal_20151216.dat.so"});
        }
        if (optString3.equals("touch")) {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(false));
        } else if (optString3.equals(C2546c.ad)) {
            string = jSONObject.optString(SpeechConstant.ASR_VAD_RES_FILE_PATH, jSONObject.optString(C2546c.av, format));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(true));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(0));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_MODEL_VAD_DAT_FILE, BDSParamBase.objectParam(loadSourceFromUri(string), "java.lang.String"));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT, BDSParamBase.intParam(jSONObject.optInt(SpeechConstant.VAD_ENDPOINT_TIMEOUT, jSONObject.optInt("vad.end-frame", 2500))));
        } else if (optString3.equals("model-vad") || optString3.equals("model_vad")) {
            string = jSONObject.optString(SpeechConstant.ASR_VAD_RES_FILE_PATH, jSONObject.optString(C2546c.av, format));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(true));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(1));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_MODEL_VAD_DAT_FILE, BDSParamBase.objectParam(loadSourceFromUri(string), "java.lang.String"));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT, BDSParamBase.intParam(jSONObject.optInt(SpeechConstant.VAD_ENDPOINT_TIMEOUT, jSONObject.optInt("vad.end-frame", 0))));
        } else if (optString3.equals("dnn")) {
            string = jSONObject.optString(SpeechConstant.ASR_VAD_RES_FILE_PATH, jSONObject.optString(C2546c.av, String.format("%s/%s", new Object[]{this.mContext.getApplicationInfo().nativeLibraryDir, C2546c.f8429Y})));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(true));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(2));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_MODEL_VAD_DAT_FILE, BDSParamBase.objectParam(loadSourceFromUri(string), "java.lang.String"));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT, BDSParamBase.intParam(jSONObject.optInt(SpeechConstant.VAD_ENDPOINT_TIMEOUT, jSONObject.optInt("vad.end-frame", 0))));
            float optDouble = (float) jSONObject.optDouble(SpeechConstant.VAD_SPEECH_THRESHOLD, 0.0d);
            if (optDouble > 0.0f) {
                bDSMessage.m_messageParams.put(ASR_PARAM_KEY_DNN_SPEECH_THRESHOLD, BDSParamBase.floatParam(optDouble));
            }
            optInt = jSONObject.optInt(SpeechConstant.VAD_MIN_SPEECH_THRESHOLD, 0);
            if (optInt > 0) {
                bDSMessage.m_messageParams.put(ASR_PARAM_KEY_DNN_MIN_SP_DURATION, BDSParamBase.intParam(optInt));
            }
            optInt = jSONObject.optInt(C2546c.aG, 0);
            if (optInt > 0) {
                bDSMessage.m_messageParams.put(ASR_PARAM_KEY_DNN_HEAD_SIL_DURATION, BDSParamBase.intParam(optInt));
            }
            optInt = jSONObject.optInt(C2546c.aF, 0);
            if (optInt > 0) {
                bDSMessage.m_messageParams.put(ASR_PARAM_KEY_MAX_WAIT_DURATION, BDSParamBase.intParam(optInt));
            }
            optDouble = (float) jSONObject.optDouble(SpeechConstant.VAD_SIL_THRESHOLD, 0.0d);
            if (optDouble > 0.0f) {
                bDSMessage.m_messageParams.put(ASR_PARAM_KEY_DNN_SIL_THRESHOLD, BDSParamBase.floatParam(optDouble));
            }
        } else if (optString3.equals("search")) {
            string = jSONObject.optString(SpeechConstant.ASR_VAD_RES_FILE_PATH, jSONObject.optString(C2546c.av, format));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(true));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(0));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_MODEL_VAD_DAT_FILE, BDSParamBase.objectParam(loadSourceFromUri(string), "java.lang.String"));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT, BDSParamBase.intParam(jSONObject.optInt(SpeechConstant.VAD_ENDPOINT_TIMEOUT, 1000)));
        } else if (SpeechConstant.VAD_MFE.equals(optString3)) {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(true));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(0));
        }
        if (optString2 != "") {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_SERVER_AGENT_URL, BDSParamBase.objectParam(optString2, "java.lang.String"));
        }
        optString = jSONObject.optString(SpeechConstant.DEV, "");
        if (!TextUtils.isEmpty(optString)) {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_DEV, BDSParamBase.objectParam(optString, "java.lang.String"));
        }
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_AUDIO_FILE_PATH, BDSParamBase.objectParam(jSONObject.optString("audio.file", jSONObject.optString(SpeechConstant.IN_FILE, "")), "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_AUDIO_mills, BDSParamBase.objectParam(jSONObject.optString("audio.mills", ""), "java.lang.String"));
        bDSMessage.m_messageParams.put(MIC_PARAM_KEY_SOCKET_PORT, BDSParamBase.intParam(jSONObject.optInt("audio.socketport")));
        if (jSONObject.has("audio.stream-type")) {
            this.mStreamType = jSONObject.optInt("audio.stream-type");
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "audio stream type = " + this.mStreamType);
            } else {
                Log.d(TAG, "audio stream type = " + this.mStreamType);
            }
        }
        boolean optBoolean = jSONObject.optBoolean(SpeechConstant.ACCEPT_AUDIO_VOLUME, true);
        if (!optBoolean) {
            bDSMessage.m_messageParams.put("mic_accept_audio_volume.bool", BDSParamBase.boolParam(optBoolean));
        }
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_NETWORK_STATUS, BDSParamBase.intParam(Utility.getWifiOr2gOr3G(this.mContext)));
        string2 = jSONObject.optString(SpeechConstant.URL, jSONObject.optString("url", "http://vop.baidu.com/v2"));
        try {
            CommonParam.REQUEST_URL = new URL(string2).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        CommonParam.AGENT_URL = optString2;
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_SERVER_URL, BDSParamBase.objectParam(string2, "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_UID_STRING, BDSParamBase.objectParam(jSONObject.optString("decoder-server.uid", Policy.uid(this.mContext)), "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_GLB, BDSParamBase.objectParam(jSONObject.optString("decoder-server.glb", UUID.randomUUID().toString()), "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_STC, BDSParamBase.objectParam(jSONObject.optString("decoder-server.stc"), "java.lang.String"));
        this.mPlatform = jSONObject.optString("decoder-server.pfm", Policy.pfm(this.mContext));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PLATFORM, BDSParamBase.objectParam(this.mPlatform, "java.lang.String"));
        this.mVersion = jSONObject.optString("decoder-server.ver", Policy.ver(this.mContext));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_SDK_VERSION, BDSParamBase.objectParam(this.mVersion, "java.lang.String"));
        JSONArray optJSONArray = jSONObject.optJSONArray(SpeechConstant.PROP);
        Vector vector2 = new Vector();
        if (optJSONArray != null) {
            for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                try {
                    vector2.add(Integer.valueOf(optJSONArray.getInt(optInt)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        Vector vector3;
        if (optString3.equals(C2546c.ad)) {
            vector3 = new Vector();
            vector3.add(Integer.valueOf(20000));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PROPERTY_LIST, BDSParamBase.objectParam(vector3, "java.util.Vector;"));
        } else if (vector2.size() > 0) {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PROPERTY_LIST, BDSParamBase.objectParam(vector2, "java.util.Vector;"));
        } else {
            vector3 = new Vector();
            vector3.add(Integer.valueOf(AsrError.ERROR_OFFLINE_NOT_INITIAL));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PROPERTY_LIST, BDSParamBase.objectParam(vector3, "java.util.Vector;"));
        }
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_DISABLE_PUNCTUATION, BDSParamBase.boolParam(jSONObject.optBoolean("decoder-server-fun.disable-punctuation", jSONObject.optBoolean(SpeechConstant.DISABLE_PUNCTUATION, false))));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PUNCTUATION_EXT_MODE, BDSParamBase.intParam(jSONObject.optInt("punctuation-mode", 0)));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_SERVER_VAD, BDSParamBase.boolParam(jSONObject.optBoolean("server-vad", true)));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_CONTACTS, BDSParamBase.boolParam(jSONObject.optBoolean(C2546c.az, jSONObject.optBoolean("contact", false))));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_EARLY_RETURN, BDSParamBase.boolParam(jSONObject.optBoolean(SpeechConstant.ENABLE_EARLY_RETURN, false)));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_CITY_ID, BDSParamBase.intParam(jSONObject.optInt("cid")));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_CHUNK_PARAM, BDSParamBase.objectParam(jSONObject.optString(SpeechConstant.PAM, ""), "java.lang.String"));
        this.mEnableChunk = 1 == jSONObject.optInt(SpeechConstant.DEC_TYPE, jSONObject.optInt("basic.dec-type", 1));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_CHUNK_ENABLE, BDSParamBase.boolParam(this.mEnableChunk));
        optBoolean = jSONObject.optString(SpeechConstant.NLU, C2546c.ab).equals("enable");
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_NLU, BDSParamBase.boolParam(optBoolean));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PROTOCOL, BDSParamBase.intParam(jSONObject.optInt(C2546c.aB, optBoolean ? 305 : 1)));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_KWS_PROTOCOL, BDSParamBase.intParam(jSONObject.optInt("decoder-offline.ptc", 0)));
        this.enableLongSpeech = jSONObject.optInt(SpeechConstant.VAD_ENDPOINT_TIMEOUT, 1000) == 0;
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LONG_SPEECH, BDSParamBase.boolParam(this.enableLongSpeech));
        optBoolean = jSONObject.optBoolean("long-speech.multi-start-end", false);
        if (optBoolean) {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_MULTI_START_AND_END, BDSParamBase.boolParam(optBoolean));
        }
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_HTTPDNS, BDSParamBase.boolParam(jSONObject.optBoolean(SpeechConstant.ENABLE_HTTPDNS, true)));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_EARLY_CONNECTION, BDSParamBase.boolParam(jSONObject.optBoolean("early-connection", true)));
        string = jSONObject.optString("keyword");
        if (!(string == null || string.equals(""))) {
            bDSMessage.m_messageParams.put(BDS_ASR_OFFLINE_ENGINE_TRIGGERED_WAKEUP_WORD, BDSParamBase.objectParam(string, "java.lang.String"));
        }
        string2 = jSONObject.optString(SpeechConstant.ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH);
        optString2 = jSONObject.optString("decoder-offline.asr-base-file-path", jSONObject.optString(SpeechConstant.ASR_OFFLINE_ENGINE_DAT_FILE_PATH, jSONObject.optString("kws.res-file", jSONObject.optString(C2546c.av, format))));
        optString3 = jSONObject.optString("decoder-offline.license-file-path", jSONObject.optString("license-file-path", jSONObject.optString(C2546c.au)));
        format = jSONObject.optString("decoder-offline.slot-data", jSONObject.optString(SpeechConstant.SLOT_DATA));
        optInt = 0;
        if (!TextUtils.isEmpty(string2)) {
            optInt = 2;
        }
        if (optInt2 != 0) {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_ENGINE_TYPE, BDSParamBase.intParam(optInt));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_ENGINE_GRAMMER_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(string2), "java.lang.String"));
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_ENGINE_DAT_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(optString2), "java.lang.String"));
            bDSMessage.m_messageParams.put(OFFLINE_PARAM_KEY_LICENSE_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(optString3), "java.lang.String"));
            bDSMessage.m_messageParams.put(BDS_ASR_OFFLINE_ENGINE_GRAMMER_SLOT, BDSParamBase.objectParam(format, "java.lang.String"));
        }
        if (SpeechConstant.PUBLIC_DECODER) {
            if (string2 == null || string2.equals("")) {
                bDSMessage.m_messageParams.put(ASR_PARAM_KEY_STRATEGY, BDSParamBase.intParam(optInt2));
            } else {
                bDSMessage.m_messageParams.put(ASR_PARAM_KEY_STRATEGY, BDSParamBase.intParam(optInt2));
                bDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_ENGINE_DAT_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(optString2), "java.lang.String"));
                bDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_ENGINE_GRAMMER_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(string2), "java.lang.String"));
                bDSMessage.m_messageParams.put(OFFLINE_PARAM_KEY_LICENSE_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(optString3), "java.lang.String"));
                bDSMessage.m_messageParams.put(BDS_ASR_OFFLINE_ENGINE_GRAMMER_SLOT, BDSParamBase.objectParam(format, "java.lang.String"));
            }
        }
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_WAKEUP_WORDS_STRING, BDSParamBase.objectParam(jSONObject.optString(SpeechConstant.ASR_PARAM_WAKEUP_WORDS, "小度小度"), "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_WAKEUP_STATUS_INT, BDSParamBase.intParam(jSONObject.optInt(SpeechConstant.ASR_PARAM_WAKEUP_STATUS, 0)));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_IS_ONESHOT_INT, BDSParamBase.intParam(jSONObject.optInt(SpeechConstant.ASR_PARAM_IS_ONESHOT, 0)));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_BACKTRACK_TIME_INT, BDSParamBase.intParam(jSONObject.optInt(SpeechConstant.ASR_PARAM_WAKEUP_BACKTRACKTIME)));
        this.mOutFile = jSONObject.optString("audio.outfile", jSONObject.optString(SpeechConstant.OUT_FILE));
        this.mEnableLogFeedBack = jSONObject.optBoolean("feedback-log", false);
        this.mFeedBackAudio = jSONObject.optBoolean(SpeechConstant.ACCEPT_AUDIO_DATA, false);
        if (this.mFeedBackAudio) {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_ACCEPT_AUDIO_DATA, BDSParamBase.boolParam(this.mFeedBackAudio));
        }
        try {
            optInt = this.m_ASRcore.postMessage(bDSMessage);
            if (optInt == 0) {
                return bDSErrorDescription;
            }
            bDSErrorDescription = new BDSErrorDescription();
            bDSErrorDescription.errorCode = -2;
            bDSErrorDescription.errorDomain = 1;
            bDSErrorDescription.errorDescription = "JNI: initConfig Call to Native layer returned error! err( " + optInt + " )";
            return bDSErrorDescription;
        } catch (Throwable th) {
            th.printStackTrace();
            bDSErrorDescription = new BDSErrorDescription();
            bDSErrorDescription.errorCode = -2;
            bDSErrorDescription.errorDomain = 1;
            bDSErrorDescription.errorDescription = "JNI: initConfig Call to Native layer returned error! err";
            return bDSErrorDescription;
        }
    }

    private void initGrammer(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(SpeechConstant.ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH);
        if (!TextUtils.isEmpty(optString)) {
            JSONObject loadJsonFromUri;
            Object optString2;
            JSONObject jSONObject2 = (JSONObject) this.mOriginNlp.get(optString);
            if (jSONObject2 == null) {
                try {
                    jSONObject2 = this.mEventContext.loadJsonFromUri(optString, false, true);
                } catch (Exception e) {
                    Log.i(TAG, "bad grammar(as base64): " + optString);
                }
            }
            if (jSONObject2 == null) {
                try {
                    loadJsonFromUri = this.mEventContext.loadJsonFromUri(optString, false, false);
                } catch (Exception e2) {
                    Log.i(TAG, "bad grammar(as text): " + optString);
                }
                if (loadJsonFromUri != null && this.mOriginNlp.get(optString) == null) {
                    this.mOriginNlp.put(optString, loadJsonFromUri);
                }
                if (loadJsonFromUri != null) {
                    jSONObject2 = jSONObject.optJSONObject(SpeechConstant.SLOT_DATA);
                    if (jSONObject2 == null) {
                        optString2 = jSONObject.optString(SpeechConstant.SLOT_DATA);
                        if (!TextUtils.isEmpty(optString2)) {
                            jSONObject2 = new JSONObject(optString2);
                        }
                    }
                    this.nlpFeature = this.nluBuilderThread.submit(new Callable<JSONObject>() {
                        public JSONObject call() throws Exception {
                            ASREngine.resetNlpGrammar(ASREngine.this.mEventContext, loadJsonFromUri, jSONObject2);
                            return loadJsonFromUri;
                        }
                    });
                }
            }
            loadJsonFromUri = jSONObject2;
            this.mOriginNlp.put(optString, loadJsonFromUri);
            if (loadJsonFromUri != null) {
                jSONObject2 = jSONObject.optJSONObject(SpeechConstant.SLOT_DATA);
                if (jSONObject2 == null) {
                    optString2 = jSONObject.optString(SpeechConstant.SLOT_DATA);
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject2 = new JSONObject(optString2);
                    }
                }
                this.nlpFeature = this.nluBuilderThread.submit(/* anonymous class already generated */);
            }
        }
    }

    private boolean isIllegalResult(String str) {
        return str != null && str.contains("1。00。");
    }

    private void loadGrammar(String str) {
        Object obj = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null && ("enable".equals(jSONObject.optString(SpeechConstant.NLU)) || C2546c.f8430Z.equals(jSONObject.optString(SpeechConstant.NLU)))) {
                obj = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (obj != null) {
            try {
                initGrammer(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private String loadSourceFromUri(String str) {
        InputStream fileInputStream;
        Exception e;
        Throwable th;
        if (str == null || str.equals("")) {
            return null;
        }
        if (new File(str).exists()) {
            return str;
        }
        InputStream inputStream = null;
        RandomAccessFile randomAccessFile = null;
        try {
            Matcher matcher = Pattern.compile("(.*?)://(.*)").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                if (group.equalsIgnoreCase(C2924g.f12889c)) {
                    fileInputStream = new FileInputStream(group2);
                } else if (group.equalsIgnoreCase(C2924g.f12891e) || group.equalsIgnoreCase("assets")) {
                    fileInputStream = getClass().getResourceAsStream("/assets" + (group2.startsWith("/") ? "" : "/") + group2);
                } else {
                    fileInputStream = group.equalsIgnoreCase(C2924g.f12892f) ? getClass().getResourceAsStream(group2) : null;
                }
                if (fileInputStream == null) {
                    try {
                        throw new IOException("bad data source");
                    } catch (Exception e2) {
                        e = e2;
                        randomAccessFile = null;
                        try {
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e32) {
                                    e32.printStackTrace();
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e42) {
                                    e42.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        randomAccessFile = null;
                        th = th3;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                }
                byte[] bArr = new byte[1024];
                File file = new File(this.mContext.getFilesDir().getAbsolutePath() + group2);
                randomAccessFile = new RandomAccessFile(file, "rw");
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, read);
                    } catch (Exception e5) {
                        e32 = e5;
                    }
                }
                str = file.getAbsolutePath();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (randomAccessFile == null) {
                    return str;
                }
                try {
                    randomAccessFile.close();
                    return str;
                } catch (IOException e7) {
                    e7.printStackTrace();
                    return str;
                }
            }
            if (null != null) {
                try {
                    inputStream.close();
                } catch (Exception e322) {
                    e322.printStackTrace();
                }
            }
            if (null != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e422) {
                    e422.printStackTrace();
                }
            }
            return null;
        } catch (Exception e8) {
            e322 = e8;
            randomAccessFile = null;
            fileInputStream = null;
            e322.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return null;
        } catch (Throwable th32) {
            randomAccessFile = null;
            fileInputStream = null;
            th = th32;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private int parseDecoder(String str) {
        int i = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i = jSONObject.optInt(C2546c.ay, jSONObject.optInt(SpeechConstant.DECODER));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    private void play(Context context, Object obj, boolean z) {
        if (obj != null) {
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                if (num == null || num.intValue() <= 0) {
                    return;
                }
            }
            try {
                String str = "" + obj;
                if (str.matches("^(0x)?\\d+$")) {
                    player.reset();
                    AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(Integer.parseInt(str));
                    player.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                    openRawResourceFd.close();
                    if (this.mStreamType >= 0) {
                        player.setAudioStreamType(this.mStreamType);
                    }
                    player.prepare();
                } else {
                    player.reset();
                    player.setDataSource(context, Uri.parse(str));
                    if (this.mStreamType >= 0) {
                        player.setAudioStreamType(this.mStreamType);
                    }
                    player.prepare();
                }
                player.start();
                if (z) {
                    while (player.isPlaying()) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private BDSErrorDescription postEvent(BDSErrorDescription bDSErrorDescription, String str) {
        BDSMessage bDSMessage = new BDSMessage();
        bDSMessage.m_messageName = str;
        bDSMessage.m_messageParams = new HashMap();
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PLATFORM, BDSParamBase.objectParam(this.mPlatform, "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_SDK_VERSION, BDSParamBase.objectParam(this.mVersion, "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_APP, BDSParamBase.objectParam(this.mApp, "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_NETWORK_STATUS, BDSParamBase.intParam(Utility.getWifiOr2gOr3G(this.mContext)));
        if ((str.equals(ASR_CMD_START) || str.equals(ASR_CMD_STOP) || str.equals(ASR_CMD_CANCEL)) && this.mUserData != null) {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_REALTIME_DATA, BDSParamBase.objectParam(this.mUserData, "java.lang.String"));
            this.mUserData = null;
        }
        if (str.equals(ASR_CMD_CONFIG)) {
            bDSMessage.m_messageParams.put(ASR_PARAM_KEY_VAD_ENABLE_LONG_PRESS, BDSParamBase.boolParam(this.mEnableLongPress));
        }
        LogUtil.m16427i(TAG, " cmd:" + str + " msg:" + bDSMessage.toString());
        try {
            int postMessage = this.m_ASRcore.postMessage(bDSMessage);
            if (postMessage != 0) {
                bDSErrorDescription = new BDSErrorDescription();
                bDSErrorDescription.errorCode = -2;
                bDSErrorDescription.errorDomain = 1;
                bDSErrorDescription.errorDescription = "JNI: readyParamsAsrStart Call to Native layer returned error! err( " + postMessage + " )";
                return bDSErrorDescription;
            }
            if (str.equals(ASR_CMD_START)) {
                this.mIsWorking = true;
            }
            if (!str.equals(ASR_CMD_CANCEL)) {
                return bDSErrorDescription;
            }
            this.mIsWorking = false;
            return bDSErrorDescription;
        } catch (Throwable th) {
            th.printStackTrace();
            bDSErrorDescription = new BDSErrorDescription();
            bDSErrorDescription.errorCode = -2;
            bDSErrorDescription.errorDomain = 1;
            bDSErrorDescription.errorDescription = "JNI: readyParamsAsrStart Call to Native layer returned error! err";
            return bDSErrorDescription;
        }
    }

    private static void resetNlpGrammar(EventContext eventContext, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        System.currentTimeMillis();
        if (jSONObject2 != null) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("slots");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                jSONObject3.put(str, jSONObject2.getJSONArray(str));
            }
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject4 = jSONObject.getJSONObject("slots");
        Iterator keys2 = jSONObject4.keys();
        while (keys2.hasNext()) {
            JSONArray jSONArray = jSONObject4.getJSONArray((String) keys2.next());
            List arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (string.equals(".+")) {
                    arrayList.add(string);
                } else {
                    arrayList.add(string.replaceAll("[\u0000-/]|[:-@]|[\\[-`]|[{-­]", ""));
                }
            }
            String join = eventContext.join(arrayList, "|");
            hashMap.put(String.format("<%s>", new Object[]{str}), String.format("(%s)", new Object[]{join}));
        }
        JSONObject jSONObject5 = jSONObject.getJSONObject("rules");
        Iterator keys3 = jSONObject5.keys();
        while (keys3.hasNext()) {
            JSONArray jSONArray2 = jSONObject5.getJSONArray((String) keys3.next());
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject6 = jSONArray2.getJSONObject(i2);
                str = jSONObject6.getString("origin");
                String str2 = str;
                for (Entry entry : hashMap.entrySet()) {
                    str2 = str2.replaceAll((String) entry.getKey(), (String) entry.getValue());
                }
                jSONObject6.put("pattern", "^" + str2 + "$");
            }
        }
    }

    private void saveOutFile(byte[] bArr) {
        IOException e;
        Throwable th;
        if (this.mOutFile != null && !this.mOutFile.equals("") && bArr != null) {
            OutputStream outputStream = null;
            OutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(this.mOutFile, true);
                try {
                    fileOutputStream.write(bArr);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        e2.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = fileOutputStream;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = null;
                e22.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        }
    }

    private void updateUserData(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    this.mUserData = new JSONObject(str).optString("realtime-data");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.mUserData = null;
                return;
            }
        }
        this.mUserData = null;
    }

    public BDSErrorDescription postEvent(String str, String str2) {
        LogUtil.m16427i(TAG, " postEvent params: cmd:" + str + " params:" + str2);
        if (str == null || str.equals("")) {
            BDSErrorDescription bDSErrorDescription = new BDSErrorDescription();
            bDSErrorDescription.errorCode = -1;
            bDSErrorDescription.errorDomain = 1;
            bDSErrorDescription.errorDescription = "ASR param can not empty!";
            return bDSErrorDescription;
        }
        BDSErrorDescription bDSErrorDescription2;
        if (str.equals(ASR_CMD_START)) {
            JSONObject jSONObject;
            if (this.mIsWorking) {
                try {
                    this.mListener.onEvent("asr.finish", generateErrorResult(AsrError.ERROR_ASR_ENGINE_BUSY), null, 0, 0);
                    return null;
                } catch (Exception e) {
                }
            }
            int parseDecoder = parseDecoder(str2);
            if (parseDecoder == 0 && Utility.getWifiOr2gOr3G(this.mContext) == 0) {
                try {
                    jSONObject = new JSONObject(str2);
                    if (jSONObject != null) {
                        play(this.mContext, Integer.valueOf(jSONObject.optInt(SpeechConstant.SOUND_ERROR, -1)), false);
                    }
                    this.mListener.onEvent("asr.finish", generateErrorResult(2100), null, 0, 0);
                    this.mListener.onEvent("asr.exit", generateErrorResult(2100), null, 0, 0);
                    this.mIsWorking = false;
                    return null;
                } catch (Exception e2) {
                }
            }
            if (!Utility.checkPermission(this.mContext, "android.permission.INTERNET")) {
                try {
                    jSONObject = new JSONObject(str2);
                    if (jSONObject != null) {
                        play(this.mContext, Integer.valueOf(jSONObject.optInt(SpeechConstant.SOUND_ERROR, -1)), false);
                    }
                    this.mListener.onEvent("asr.finish", generateErrorResult(AsrError.ERROR_NETWORK_NOT_GRANTED), null, 0, 0);
                    this.mListener.onEvent("asr.exit", generateErrorResult(AsrError.ERROR_NETWORK_NOT_GRANTED), null, 0, 0);
                    this.mIsWorking = false;
                    return null;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (!Utility.checkPermission(this.mContext, "android.permission.RECORD_AUDIO")) {
                try {
                    jSONObject = new JSONObject(str2);
                    if (jSONObject != null) {
                        play(this.mContext, Integer.valueOf(jSONObject.optInt(SpeechConstant.SOUND_ERROR, -1)), false);
                    }
                    this.mListener.onEvent("asr.finish", generateErrorResult(9001), null, 0, 0);
                    this.mListener.onEvent("asr.exit", generateErrorResult(9001), null, 0, 0);
                    this.mIsWorking = false;
                    return null;
                } catch (Exception e32) {
                    e32.printStackTrace();
                }
            }
            if (parseDecoder == 0) {
                loadGrammar(str2);
            }
        }
        if (str.equals(ASR_CMD_START) || str.equals(ASR_CMD_STOP) || str.equals(ASR_CMD_CANCEL)) {
            updateUserData(str2);
        }
        if (str.equals(ASR_CMD_START) || str.equals(ASR_CMD_LOAD_ENGINE)) {
            try {
                this.mParams = new JSONObject(str2);
            } catch (Exception e4) {
                this.mParams = new JSONObject();
            }
            if (str.equals(ASR_CMD_START)) {
                play(this.mContext, Integer.valueOf(this.mParams.optInt(SpeechConstant.SOUND_START, -1)), this.mParams.optBoolean("audio.sound-sync", true));
                try {
                    if (!this.mParams.has("audio.socketport")) {
                        this.mParams.put("audio.socketport", MicrophoneServer.create(this.mParams.optString(SpeechConstant.IN_FILE), this.mParams.has(SpeechConstant.AUDIO_SOURCE) ? this.mParams.optInt(SpeechConstant.AUDIO_SOURCE) : 1));
                    }
                } catch (Exception e322) {
                    e322.printStackTrace();
                }
            } else {
                loadGrammar(str2);
            }
            try {
                bDSErrorDescription = initConfig(null, this.mParams);
                if (str.equals(ASR_CMD_START)) {
                    clearOutFile();
                }
                if (this.mExceptioned) {
                    return bDSErrorDescription;
                }
                bDSErrorDescription2 = bDSErrorDescription;
                if (bDSErrorDescription2 != null) {
                    return bDSErrorDescription2;
                }
            } catch (Exception e5) {
                bDSErrorDescription2 = null;
            }
        } else {
            bDSErrorDescription2 = null;
        }
        if (str.equals(ASR_CMD_CONFIG)) {
            JSONObject jSONObject2;
            if (str2 != null) {
                try {
                    if (!str2.equals("")) {
                        jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.has("vad_enable_long_press.bool")) {
                            this.mEnableLongPress = jSONObject2.optBoolean("vad_enable_long_press.bool", true);
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                    jSONObject2 = new JSONObject();
                }
            }
            jSONObject2 = new JSONObject();
            if (jSONObject2.has("vad_enable_long_press.bool")) {
                this.mEnableLongPress = jSONObject2.optBoolean("vad_enable_long_press.bool", true);
            }
        }
        return postEvent(bDSErrorDescription2, str);
    }

    public void receiveCoreEvent(BDSMessage bDSMessage, BDSSDKInterface bDSSDKInterface) {
        if (this.mListener != null && bDSMessage != null) {
            asrCallBack(bDSMessage, this.mListener);
        }
    }

    public void setListener(ASRListener aSRListener) {
        this.mListener = aSRListener;
    }
}
