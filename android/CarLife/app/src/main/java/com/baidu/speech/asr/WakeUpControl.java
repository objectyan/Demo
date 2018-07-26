package com.baidu.speech.asr;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.p123i.C2546c;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.speech.EventListener;
import com.baidu.speech.audio.MicrophoneServer;
import com.baidu.speech.core.BDSErrorDescription;
import com.baidu.speech.core.BDSMessage;
import com.baidu.speech.core.BDSParamBase;
import com.baidu.speech.core.BDSParamBase.BDSIntParam;
import com.baidu.speech.core.BDSParamBase.BDSObjectParam;
import com.baidu.speech.core.BDSSDKLoader;
import com.baidu.speech.core.BDSSDKLoader.BDSCoreEventListener;
import com.baidu.speech.core.BDSSDKLoader.BDSSDKInterface;
import com.baidu.speech.utils.AsrError;
import com.baidu.speech.utils.LogUtil;
import com.baidu.speech.utils.Policy;
import com.facebook.common.p141m.C2924g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WakeUpControl implements BDSCoreEventListener {
    private static String ASR_PARAM_KEY_OFFLINE_APP_CODE = "offline_param_key_app_code.string";
    private static String ASR_PARAM_KEY_PLATFORM = "asr_param_key_platform.string";
    private static String ASR_PARAM_KEY_SDK_VERSION = "asr_param_key_sdk_version.string";
    private static String COMMON_PARAM_KEY_DEBUG_LOG_LEVEL = "common_param_key_debug_log_level.int";
    private static final int EWakeupEngineWorkStatusError = 6;
    private static final int EWakeupEngineWorkStatusKwdConfig = 9;
    private static final int EWakeupEngineWorkStatusLoaded = 3;
    private static final int EWakeupEngineWorkStatusNewData = 7;
    private static final int EWakeupEngineWorkStatusOneshot = 8;
    private static final int EWakeupEngineWorkStatusReadyed = 1;
    private static final int EWakeupEngineWorkStatusStarted = 0;
    private static final int EWakeupEngineWorkStatusStopped = 2;
    private static final int EWakeupEngineWorkStatusTriggered = 5;
    private static final int EWakeupEngineWorkStatusUnLoaded = 4;
    private static String KWD_CMD_DYNAMIC_CONFIG = C2546c.an;
    private static String MIC_PARAM_KEY_AUDIO_FILE_PATH = "mic_audio_file_path.string";
    private static String MIC_PARAM_KEY_SOCKET_PORT = "mic_param_key_socket_port.int";
    private static String OFFLINE_PARAM_KEY_LICENSE_FILE_PATH = "offline_param_key_license_filepath.string";
    private static final String TAG = "WakeUpControl";
    private static String WAK_CMD_CONFIG = "wak.config";
    private static String WAK_CMD_DATA = "wak.data";
    private static String WAK_CMD_LOAD_ENGINE = "wak.load";
    private static String WAK_CMD_START = "wak.start";
    private static String WAK_CMD_STOP = "wak.stop";
    private static String WAK_CMD_UNLOAD_ENGINE = "wak.unload";
    private static String WP_PARAM_KEY_ENABLE_MODEL_VAD = "wakeup_param_key_mode.int";
    private static String WP_PARAM_KEY_ENABLE_VAD = "wakeup_param_key_enable_vad.bool";
    private static String WP_PARAM_KEY_KWD_DISABLE_KEYWORD = "wakeup_param_kwd_disable_keyword.vector<string>";
    private static String WP_PARAM_KEY_KWD_ENABLE_ALL_KEYWORDS = "wakeup_param_kwd_enable_all_keywords.bool";
    private static String WP_PARAM_KEY_KWD_ENABLE_KEYWORD = "wakeup_param_kwd_enable_keyword.vector<string>";
    private static String WP_PARAM_KEY_KWD_VOLUME = "wakeup_param_kwd_volume.int";
    private static String WP_PARAM_KEY_VAD_DAT_FILE_PATH = "wakeup_param_key_vad_dat_file_path.string";
    private static String WP_PARAM_KEY_WAKEUP_ACCEPT_AUDIO_DATA = "wakeup_param_key_accept_audio_data.bool";
    private static String WP_PARAM_KEY_WAKEUP_DAT_FILE_PATH = "wakeup_param_key_dat_filepath.string";
    private static String WP_PARAM_KEY_WAKEUP_ENABLE_ONESHOT = "wakeup_param_key_enable_oneshot.bool";
    private static String WP_PARAM_KEY_WAKEUP_KWD = "wakeup_param_key_kwd.bool";
    private static String WP_PARAM_KEY_WAKEUP_MODE = "wakeup_param_key_mode.int";
    private static String WP_PARAM_KEY_WAKEUP_WORDS = "wakeup_param_key_words.vector<string>";
    private static String WP_PARAM_KEY_WAKEUP_WORDS_FILE_PATH = "wakeup_param_key_words_filepath.string";
    private Context context;
    private boolean mFeedBackAudio;
    private boolean mIsWorking = false;
    private EventListener mListener;
    private JSONObject mParams;
    private BDSSDKInterface m_Wakeupcore;
    private String outFile = null;

    enum DebugLogLevel {
        EVRDebugLogLevelOff,
        EVRDebugLogLevelFatal,
        EVRDebugLogLevelError,
        EVRDebugLogLevelWarning,
        EVRDebugLogLevelInformation,
        EVRDebugLogLevelDebug,
        EVRDebugLogLevelTrace
    }

    public WakeUpControl(Context context) throws Exception {
        Exception exception;
        this.context = context;
        try {
            BDSSDKLoader.loadLibraries();
            try {
                this.m_Wakeupcore = BDSSDKLoader.getSDKObjectForSDKType("WakeupCore", context);
                if (this.m_Wakeupcore == null) {
                    throw new Exception("ASR core support is not linked in package");
                } else if (this.m_Wakeupcore.instanceInitialized()) {
                    this.m_Wakeupcore.setListener(this);
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

    private void asrCallBack(BDSMessage bDSMessage, EventListener eventListener) {
        if (bDSMessage.m_messageName.equals(SpeechConstant.WAKEUP_CALLBACK_NAME)) {
            int i = ((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_WAK_STATUS)).iValue;
            LogUtil.m16427i(TAG, "WPCallBack:" + bDSMessage.toString());
            String str;
            int i2;
            Map hashMap;
            switch (i) {
                case 0:
                    eventListener.onEvent("wp.enter", null, null, 0, 0);
                    return;
                case 1:
                    eventListener.onEvent("wp.ready", null, null, 0, 0);
                    return;
                case 2:
                    this.mIsWorking = false;
                    eventListener.onEvent("wp.exit", null, null, 0, 0);
                    return;
                case 5:
                    str = (String) ((BDSObjectParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_WAK_RESULT)).iValue;
                    i2 = ((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_WAK_WORD_FRAME_LENGTH)).iValue;
                    hashMap = new HashMap();
                    hashMap.put("word", str);
                    hashMap.put("frameLen", Integer.valueOf(i2));
                    hashMap.put("errorCode", Integer.valueOf(0));
                    hashMap.put("errorDesc", "wakup success");
                    eventListener.onEvent("wp.data", new JSONObject(hashMap).toString(), null, 0, 0);
                    return;
                case 6:
                    this.mIsWorking = false;
                    str = (String) ((BDSObjectParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_DESC)).iValue;
                    String str2 = "";
                    try {
                        str2 = generateErrorResult(((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_DOMAIN)).iValue, ((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_CODE)).iValue);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    eventListener.onEvent("wp.error", str2, null, 0, 0);
                    return;
                case 7:
                    byte[] bArr = bDSMessage.m_messageData;
                    if (this.mFeedBackAudio && bArr != null) {
                        eventListener.onEvent(SpeechConstant.CALLBACK_EVENT_WAKEUP_AUDIO, null, bArr, 0, bArr.length);
                    }
                    saveOutFile(bArr);
                    return;
                case 8:
                    i = ((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_WAK_ONESHOT_CODE)).iValue;
                    Map hashMap2 = new HashMap();
                    hashMap2.put("oneshot", Integer.valueOf(i));
                    eventListener.onEvent(SpeechConstant.CALLBACK_EVENT_WAKEUP_ONESHOT, new JSONObject(hashMap2).toString(), null, 0, 0);
                    return;
                case 9:
                    str = (String) ((BDSObjectParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_DESC)).iValue;
                    i2 = ((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_CODE)).iValue;
                    hashMap = new HashMap();
                    hashMap.put("errorCode", Integer.valueOf(i2));
                    hashMap.put("errorDesc", str);
                    eventListener.onEvent(SpeechConstant.CALLBACK_EVENT_WAKEUP_KWD_CONFIG, new JSONObject(hashMap).toString(), null, 0, 0);
                    return;
                default:
                    return;
            }
        }
    }

    private void clearOutFile() {
        OutputStream fileOutputStream;
        IOException e;
        Throwable th;
        if (this.outFile != null && !this.outFile.equals("")) {
            try {
                fileOutputStream = new FileOutputStream(this.outFile);
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

    private String generateErrorResult(int i) {
        String descFromCode = AsrError.getDescFromCode(i);
        int i2 = i / 1000;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ParamKey.KEY_MSG_ERRORS, i2);
            jSONObject.put("desc", descFromCode);
            jSONObject.put("sub_error", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private String generateErrorResult(int i, int i2) {
        String str = "";
        if (AsrError.getDescFromCode(i2) == null) {
            if (i == 38) {
                if (1 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_ENGINE_EXCEPTION;
                } else if (2 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_NO_LICENSE;
                } else if (3 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_INVALID_LICENSE;
                } else if (4 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_EXCEPTION;
                } else if (5 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_MODEL_EXCEPTION;
                } else if (6 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_ENGINE_INITIAL_FAIL;
                } else if (7 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_MEM_ALLOC_FAIL;
                } else if (8 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_ENGINE_RESET_FAIL;
                } else if (9 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_ENGINE_FREE_FAIL;
                } else if (10 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_ENGINE_NOT_SUPPORT;
                } else if (11 == i2) {
                    i2 = AsrError.ERROR_WAKEUP_RECOGNIZE_FAIL;
                }
            } else if (i == 20 && 1 == i2) {
                i2 = 3100;
            }
            i2 = -1;
        }
        return generateErrorResult(i2);
    }

    private File getDiskCacheDir(Context context) {
        return context.getCacheDir();
    }

    private BDSErrorDescription initWp(BDSErrorDescription bDSErrorDescription, JSONObject jSONObject) {
        int i;
        String str = null;
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            str = applicationInfo.metaData == null ? null : applicationInfo.metaData.getInt("com.baidu.speech.APP_ID") + "";
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        String optString = jSONObject.optString(SpeechConstant.APP_ID, str);
        JSONArray optJSONArray = jSONObject.optJSONArray("words");
        Vector vector = new Vector();
        if (optJSONArray != null) {
            for (i = 0; i < optJSONArray.length(); i++) {
                try {
                    vector.add(optJSONArray.getString(i));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        str = jSONObject.optString(SpeechConstant.WP_DAT_FILEPATH, jSONObject.optString("wp.res-file", jSONObject.optString(C2546c.av, String.format("%s/%s", new Object[]{this.context.getApplicationInfo().nativeLibraryDir, "libbd_easr_s1_merge_normal_20151216.dat.so"}))));
        String optString2 = jSONObject.optString("wp.kws-file", jSONObject.optString(SpeechConstant.WP_WORDS_FILE));
        String optString3 = jSONObject.optString(SpeechConstant.IN_FILE);
        String optString4 = jSONObject.optString("decoder-offline.license-file-path", jSONObject.optString("license-file-path", jSONObject.optString(C2546c.au)));
        int optInt = jSONObject.optInt(SpeechConstant.LOG_LEVEL, -1);
        this.mFeedBackAudio = jSONObject.optBoolean(SpeechConstant.ACCEPT_AUDIO_DATA, false);
        this.outFile = jSONObject.optString(SpeechConstant.OUT_FILE);
        BDSMessage bDSMessage = new BDSMessage();
        bDSMessage.m_messageName = WAK_CMD_CONFIG;
        bDSMessage.m_messageParams = new HashMap();
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_APP_CODE, BDSParamBase.objectParam(optString, "java.lang.String"));
        bDSMessage.m_messageParams.put(WP_PARAM_KEY_WAKEUP_DAT_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(str), "java.lang.String"));
        bDSMessage.m_messageParams.put(WP_PARAM_KEY_WAKEUP_WORDS, BDSParamBase.objectParam(vector, "java.util.Vector;"));
        bDSMessage.m_messageParams.put(WP_PARAM_KEY_WAKEUP_WORDS_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(optString2), "java.lang.String"));
        bDSMessage.m_messageParams.put(OFFLINE_PARAM_KEY_LICENSE_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(optString4), "java.lang.String"));
        bDSMessage.m_messageParams.put(MIC_PARAM_KEY_AUDIO_FILE_PATH, BDSParamBase.objectParam(optString3, "java.lang.String"));
        boolean optBoolean = jSONObject.optBoolean(SpeechConstant.WP_VAD_ENABLE, false);
        bDSMessage.m_messageParams.put(WP_PARAM_KEY_VAD_DAT_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(jSONObject.optString(SpeechConstant.ASR_VAD_RES_FILE_PATH, String.format("%s/%s", new Object[]{this.context.getApplicationInfo().nativeLibraryDir, C2546c.f8429Y}))), "java.lang.String"));
        if (optBoolean) {
            bDSMessage.m_messageParams.put(WP_PARAM_KEY_ENABLE_VAD, BDSParamBase.boolParam(true));
            bDSMessage.m_messageParams.put(WP_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(2));
        } else {
            bDSMessage.m_messageParams.put(WP_PARAM_KEY_ENABLE_VAD, BDSParamBase.boolParam(false));
        }
        if (jSONObject.optBoolean(SpeechConstant.WP_KWD_ENABLE, false)) {
            bDSMessage.m_messageParams.put(WP_PARAM_KEY_WAKEUP_KWD, BDSParamBase.boolParam(true));
        }
        bDSMessage.m_messageParams.put(MIC_PARAM_KEY_SOCKET_PORT, BDSParamBase.intParam(jSONObject.optInt("audio.socketport")));
        if (optInt != -1) {
            bDSMessage.m_messageParams.put(COMMON_PARAM_KEY_DEBUG_LOG_LEVEL, BDSParamBase.intParam(optInt));
        }
        bDSMessage.m_messageParams.put(WP_PARAM_KEY_WAKEUP_ACCEPT_AUDIO_DATA, BDSParamBase.boolParam(this.mFeedBackAudio));
        optBoolean = jSONObject.optBoolean(SpeechConstant.ACCEPT_AUDIO_VOLUME, true);
        if (!optBoolean) {
            bDSMessage.m_messageParams.put("mic_accept_audio_volume.bool", BDSParamBase.boolParam(optBoolean));
        }
        i = jSONObject.optInt(C2546c.aw, 0);
        if (i > 0) {
            bDSMessage.m_messageParams.put(WP_PARAM_KEY_WAKEUP_MODE, BDSParamBase.intParam(i));
        }
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PLATFORM, BDSParamBase.objectParam(C1253f.jb, "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_SDK_VERSION, BDSParamBase.objectParam("C++ ASR core", "java.lang.String"));
        try {
            i = this.m_Wakeupcore.postMessage(bDSMessage);
            if (i == 0) {
                return bDSErrorDescription;
            }
            bDSErrorDescription = new BDSErrorDescription();
            bDSErrorDescription.errorCode = -2;
            bDSErrorDescription.errorDomain = 1;
            bDSErrorDescription.errorDescription = "JNI: readyParamsWpStart Call to Native layer returned error! err( " + i + " )";
            return bDSErrorDescription;
        } catch (Throwable th) {
            th.printStackTrace();
            bDSErrorDescription = new BDSErrorDescription();
            bDSErrorDescription.errorCode = -2;
            bDSErrorDescription.errorDomain = 1;
            bDSErrorDescription.errorDescription = "JNI: readyParamsWpStart Call to Native layer returned error! err";
            return bDSErrorDescription;
        }
    }

    private String loadSourceFromUri(String str) {
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
        InputStream fileInputStream;
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
                File file = new File(this.context.getFilesDir().getAbsolutePath() + group2);
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

    private BDSErrorDescription postEvent(BDSErrorDescription bDSErrorDescription, String str) {
        BDSMessage bDSMessage = new BDSMessage();
        if (str.contains(C2546c.am)) {
            bDSMessage.m_messageName = str.replace(C2546c.am, "wak");
        } else {
            bDSMessage.m_messageName = str;
        }
        bDSMessage.m_messageParams = new HashMap();
        this.mParams.optString(SpeechConstant.APP_NAME, Policy.app(this.context));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PLATFORM, BDSParamBase.objectParam(C1253f.jb, "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_SDK_VERSION, BDSParamBase.objectParam("C++ ASR core", "java.lang.String"));
        LogUtil.m16427i(TAG, " wakeup postEvent to c++  cmd:" + str + " Message:" + bDSMessage.toString());
        try {
            if (this.m_Wakeupcore.postMessage(bDSMessage) == 0) {
                return bDSErrorDescription;
            }
            bDSErrorDescription = new BDSErrorDescription();
            bDSErrorDescription.errorCode = -2;
            bDSErrorDescription.errorDomain = 1;
            bDSErrorDescription.errorDescription = "JNI: readyParamsAsrStart Call to Native layer returned error! err";
            return bDSErrorDescription;
        } catch (Throwable th) {
            th.printStackTrace();
            bDSErrorDescription = new BDSErrorDescription();
            bDSErrorDescription.errorCode = -2;
            bDSErrorDescription.errorDomain = 1;
            bDSErrorDescription.errorDescription = "JNI: readyParamsWpStart Call to Native layer returned error! err";
            return bDSErrorDescription;
        }
    }

    private void saveOutFile(byte[] bArr) {
        OutputStream fileOutputStream;
        IOException e;
        Throwable th;
        if (this.outFile != null && !this.outFile.equals("") && bArr != null) {
            OutputStream outputStream = null;
            try {
                fileOutputStream = new FileOutputStream(this.outFile, true);
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

    private void setKwDynamicConfig(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            BDSMessage bDSMessage = new BDSMessage();
            bDSMessage.m_messageName = KWD_CMD_DYNAMIC_CONFIG;
            bDSMessage.m_messageParams = new HashMap();
            int optInt = jSONObject.optInt(C2546c.aC, -1);
            if (optInt >= 0) {
                bDSMessage.m_messageParams.put(WP_PARAM_KEY_KWD_VOLUME, BDSParamBase.intParam(optInt));
            }
            if (jSONObject.has(SpeechConstant.WP_ONESHOT_ENABLE)) {
                bDSMessage.m_messageParams.put(WP_PARAM_KEY_WAKEUP_ENABLE_ONESHOT, BDSParamBase.boolParam(jSONObject.optBoolean(SpeechConstant.WP_ONESHOT_ENABLE)));
            }
            optInt = jSONObject.optInt(C2546c.aD, -1);
            if (optInt != -1) {
                bDSMessage.m_messageParams.put(WP_PARAM_KEY_KWD_ENABLE_ALL_KEYWORDS, BDSParamBase.boolParam(optInt != 0));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(C2546c.aE);
            if (optJSONArray != null) {
                Vector vector = new Vector();
                for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                    try {
                        vector.add(optJSONArray.getString(optInt));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                bDSMessage.m_messageParams.put(WP_PARAM_KEY_KWD_ENABLE_KEYWORD, BDSParamBase.objectParam(vector, "java.util.Vector;"));
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("kwd.disable-keyword");
            if (optJSONArray2 != null) {
                Vector vector2 = new Vector();
                while (i < optJSONArray2.length()) {
                    try {
                        vector2.add(optJSONArray2.getString(i));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    i++;
                }
                bDSMessage.m_messageParams.put(WP_PARAM_KEY_KWD_DISABLE_KEYWORD, BDSParamBase.objectParam(vector2, "java.util.Vector;"));
            }
            this.m_Wakeupcore.postMessage(bDSMessage);
        }
    }

    public BDSErrorDescription postEvent(String str, String str2) {
        if (!this.mIsWorking && KWD_CMD_DYNAMIC_CONFIG.equals(str)) {
            return null;
        }
        LogUtil.m16427i(TAG, " wakeup postEvent  cmd:" + str + " params:" + str2 + " isWorking=" + this.mIsWorking);
        BDSErrorDescription bDSErrorDescription;
        try {
            if (this.m_Wakeupcore.instanceInitialized()) {
                if (str2 != null) {
                    try {
                        if (!str2.equals("")) {
                            this.mParams = new JSONObject(str2);
                            if (KWD_CMD_DYNAMIC_CONFIG.equals(str)) {
                                if (str.equals(SpeechConstant.WAKEUP_START)) {
                                    if (str.equals(SpeechConstant.WAKEUP_STOP)) {
                                        postEvent(null, WAK_CMD_UNLOAD_ENGINE);
                                    }
                                } else if (!this.mIsWorking) {
                                    return null;
                                } else {
                                    this.mIsWorking = true;
                                    try {
                                        if (!this.mParams.has("audio.socketport")) {
                                            this.mParams.put("audio.socketport", MicrophoneServer.create(this.mParams.optString(SpeechConstant.IN_FILE), this.mParams.has(SpeechConstant.AUDIO_SOURCE) ? this.mParams.optInt(SpeechConstant.AUDIO_SOURCE) : 1));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    initWp(null, this.mParams);
                                    postEvent(null, WAK_CMD_LOAD_ENGINE);
                                    clearOutFile();
                                }
                                return postEvent(null, str);
                            }
                            setKwDynamicConfig(this.mParams);
                            return null;
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        this.mParams = new JSONObject();
                    }
                }
                this.mParams = new JSONObject();
                if (KWD_CMD_DYNAMIC_CONFIG.equals(str)) {
                    if (str.equals(SpeechConstant.WAKEUP_START)) {
                        if (str.equals(SpeechConstant.WAKEUP_STOP)) {
                            postEvent(null, WAK_CMD_UNLOAD_ENGINE);
                        }
                    } else if (!this.mIsWorking) {
                        return null;
                    } else {
                        this.mIsWorking = true;
                        if (this.mParams.has("audio.socketport")) {
                            if (this.mParams.has(SpeechConstant.AUDIO_SOURCE)) {
                            }
                            this.mParams.put("audio.socketport", MicrophoneServer.create(this.mParams.optString(SpeechConstant.IN_FILE), this.mParams.has(SpeechConstant.AUDIO_SOURCE) ? this.mParams.optInt(SpeechConstant.AUDIO_SOURCE) : 1));
                        }
                        initWp(null, this.mParams);
                        postEvent(null, WAK_CMD_LOAD_ENGINE);
                        clearOutFile();
                    }
                    return postEvent(null, str);
                }
                setKwDynamicConfig(this.mParams);
                return null;
            }
            bDSErrorDescription = new BDSErrorDescription();
            bDSErrorDescription.errorCode = -1;
            bDSErrorDescription.errorDomain = 1;
            bDSErrorDescription.errorDescription = "JNI: ASR Core native layer is not initialized!";
            return bDSErrorDescription;
        } catch (Throwable th) {
            th.printStackTrace();
            bDSErrorDescription = new BDSErrorDescription();
            bDSErrorDescription.errorCode = -1;
            bDSErrorDescription.errorDomain = 1;
            bDSErrorDescription.errorDescription = "JNI: ASR Core native layer is not initialized!";
            return bDSErrorDescription;
        }
    }

    public void receiveCoreEvent(BDSMessage bDSMessage, BDSSDKInterface bDSSDKInterface) {
        if (this.mListener != null && bDSMessage != null) {
            asrCallBack(bDSMessage, this.mListener);
        }
    }

    public void setListener(EventListener eventListener) {
        this.mListener = eventListener;
    }
}
