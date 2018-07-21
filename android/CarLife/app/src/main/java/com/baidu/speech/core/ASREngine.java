package com.baidu.speech.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.speech.asr.ASRListener;
import com.baidu.speech.asr.EventContext;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.speech.utils.AsrError;
import com.baidu.speech.utils.LogUtil;
import com.baidu.speech.utils.Policy;
import com.baidu.speech.utils.Utility;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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

public class ASREngine
  implements BDSSDKLoader.BDSCoreEventListener
{
  private static String ASR_CMD_CANCEL;
  private static String ASR_CMD_CONFIG = "asr.config";
  private static String ASR_CMD_LOAD_ENGINE;
  private static String ASR_CMD_START = "asr.start";
  private static String ASR_CMD_STOP = "asr.stop";
  private static String ASR_CMD_UNLOAD_ENGINE;
  private static String ASR_CMD_UPLOAD_CANCEL;
  private static String ASR_CMD_UPLOAD_CONTRACT;
  private static String ASR_CMD_UPLOAD_WORDS;
  private static String ASR_PARAM_KEY_ACCEPT_AUDIO_DATA;
  private static String ASR_PARAM_KEY_API_SECRET_KEYS;
  private static String ASR_PARAM_KEY_APP;
  private static String ASR_PARAM_KEY_AUDIO_FILE_PATH;
  private static String ASR_PARAM_KEY_AUDIO_mills;
  private static String ASR_PARAM_KEY_BACKTRACK_TIME_INT;
  private static String ASR_PARAM_KEY_BROWSER_USER_AGENT;
  private static String ASR_PARAM_KEY_BUA;
  private static String ASR_PARAM_KEY_CHUNK_ENABLE;
  private static String ASR_PARAM_KEY_CHUNK_KEY;
  private static String ASR_PARAM_KEY_CHUNK_PARAM;
  private static String ASR_PARAM_KEY_CITY_ID;
  private static String ASR_PARAM_KEY_COK;
  private static String ASR_PARAM_KEY_COMPRESSION_TYPE;
  private static String ASR_PARAM_KEY_DEV;
  private static String ASR_PARAM_KEY_DISABLE_PUNCTUATION;
  private static String ASR_PARAM_KEY_DNN_HEAD_SIL_DURATION;
  private static String ASR_PARAM_KEY_DNN_MIN_SP_DURATION;
  private static String ASR_PARAM_KEY_DNN_SIL_THRESHOLD;
  private static String ASR_PARAM_KEY_DNN_SPEECH_THRESHOLD;
  private static String ASR_PARAM_KEY_EARLY_CONNECTION;
  private static String ASR_PARAM_KEY_ENABLE_CONTACTS;
  private static String ASR_PARAM_KEY_ENABLE_DRC;
  private static String ASR_PARAM_KEY_ENABLE_EARLY_RETURN;
  private static String ASR_PARAM_KEY_ENABLE_HTTPDNS;
  private static String ASR_PARAM_KEY_ENABLE_LOCAL_VAD;
  private static String ASR_PARAM_KEY_ENABLE_LONG_SPEECH;
  private static String ASR_PARAM_KEY_ENABLE_MODEL_VAD;
  private static String ASR_PARAM_KEY_ENABLE_NLU;
  private static String ASR_PARAM_KEY_ENABLE_SERVER_VAD;
  private static String ASR_PARAM_KEY_FRM;
  private static String ASR_PARAM_KEY_GLB;
  private static String ASR_PARAM_KEY_IS_ONESHOT_INT;
  private static String ASR_PARAM_KEY_KWS_PROTOCOL;
  private static String ASR_PARAM_KEY_LANGUAGE;
  private static String ASR_PARAM_KEY_LTP;
  private static String ASR_PARAM_KEY_MAX_WAIT_DURATION;
  private static String ASR_PARAM_KEY_MODEL_VAD_DAT_FILE;
  private static String ASR_PARAM_KEY_MULTI_START_AND_END;
  private static String ASR_PARAM_KEY_NETWORK_STATUS;
  private static String ASR_PARAM_KEY_OFFLINE_APP_CODE;
  private static String ASR_PARAM_KEY_OFFLINE_ENGINE_DAT_FILE_PATH;
  private static String ASR_PARAM_KEY_OFFLINE_ENGINE_GRAMMER_FILE_PATH;
  private static String ASR_PARAM_KEY_OFFLINE_ENGINE_TYPE;
  private static String ASR_PARAM_KEY_PAM;
  private static String ASR_PARAM_KEY_PLATFORM;
  private static String ASR_PARAM_KEY_PRODUCT_ID;
  private static String ASR_PARAM_KEY_PROPERTY_LIST;
  private static String ASR_PARAM_KEY_PROTOCOL;
  private static String ASR_PARAM_KEY_PU;
  private static String ASR_PARAM_KEY_PUNCTUATION_EXT_MODE;
  private static String ASR_PARAM_KEY_REALTIME_DATA;
  private static String ASR_PARAM_KEY_RSV;
  private static String ASR_PARAM_KEY_SAMPLE_RATE;
  private static String ASR_PARAM_KEY_SDK_VERSION;
  private static String ASR_PARAM_KEY_SERVER_AGENT_URL;
  private static String ASR_PARAM_KEY_SERVER_URL;
  private static String ASR_PARAM_KEY_START_TONE;
  private static String ASR_PARAM_KEY_STC;
  private static String ASR_PARAM_KEY_STRATEGY;
  private static String ASR_PARAM_KEY_TXT;
  private static String ASR_PARAM_KEY_UID_STRING;
  private static String ASR_PARAM_KEY_VAD_ENABLE_LONG_PRESS;
  private static String ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT;
  private static String ASR_PARAM_KEY_WAKEUP_STATUS_INT;
  private static String ASR_PARAM_KEY_WAKEUP_WORDS_STRING;
  private static String BDS_ASR_OFFLINE_ENGINE_GRAMMER_SLOT;
  private static String BDS_ASR_OFFLINE_ENGINE_TRIGGERED_WAKEUP_WORD;
  private static String COMMON_PARAM_KEY_DEBUG_LOG_LEVEL;
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
  private static String MIC_PARAM_KEY_SOCKET_PORT;
  private static String OFFLINE_PARAM_KEY_LICENSE_FILE_PATH;
  private static final String TAG = "ASREngine";
  private static boolean hasBegin = false;
  private static boolean hasEnd = false;
  private static boolean hasPartialResult;
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
  private BDSSDKLoader.BDSSDKInterface m_ASRcore;
  private Future<JSONObject> nlpFeature;
  private ExecutorService nluBuilderThread = Executors.newSingleThreadExecutor();
  private JSONObject usingSimpleNlp;
  
  static
  {
    ASR_CMD_CANCEL = "asr.cancel";
    ASR_CMD_LOAD_ENGINE = "asr.kws.load";
    ASR_CMD_UNLOAD_ENGINE = "asr.kws.unload";
    ASR_CMD_UPLOAD_CONTRACT = "asr.upload.contract";
    ASR_CMD_UPLOAD_WORDS = "asr.upload.words";
    ASR_CMD_UPLOAD_CANCEL = "asr.upload.cancel";
    ASR_PARAM_KEY_SDK_VERSION = "asr_param_key_sdk_version.string";
    ASR_PARAM_KEY_START_TONE = "asr_param_key_start_tone.int";
    ASR_PARAM_KEY_SAMPLE_RATE = "asr_param_key_sample_rate.int";
    MIC_PARAM_KEY_SOCKET_PORT = "mic_param_key_socket_port.int";
    ASR_PARAM_KEY_AUDIO_FILE_PATH = "mic_audio_file_path.string";
    ASR_PARAM_KEY_DEV = "asr_param_key_dev.string";
    ASR_PARAM_KEY_ACCEPT_AUDIO_DATA = "asr_param_key_accept_audio_data.bool";
    ASR_PARAM_KEY_AUDIO_mills = "mic_audio_mills.string";
    ASR_PARAM_KEY_MAX_WAIT_DURATION = "asr_param_key_max_wait_duration.int";
    ASR_PARAM_KEY_VAD_ENABLE_LONG_PRESS = "vad_enable_long_press.bool";
    ASR_PARAM_KEY_DISABLE_PUNCTUATION = "asr_param_key_disable_punctuation.bool";
    ASR_PARAM_KEY_PUNCTUATION_EXT_MODE = "asr_param_key_punctuation_ext_mode.int";
    ASR_PARAM_KEY_ENABLE_SERVER_VAD = "asr_param_key_enable_server_vad.bool";
    ASR_PARAM_KEY_ENABLE_CONTACTS = "asr_param_key_enable_contacts.bool";
    ASR_PARAM_KEY_ENABLE_EARLY_RETURN = "asr_param_key_enable_early_return.bool";
    ASR_PARAM_KEY_API_SECRET_KEYS = "asr_param_key_api_secret_key.vector<string>";
    ASR_PARAM_KEY_SERVER_URL = "asr_param_key_server_url.string";
    ASR_PARAM_KEY_BROWSER_USER_AGENT = "asr_param_key_browser_user_agent.string";
    ASR_PARAM_KEY_SERVER_AGENT_URL = "asr_param_key_server_agent_url.string";
    ASR_PARAM_KEY_PROPERTY_LIST = "asr_param_key_property_list.vector<int>";
    ASR_PARAM_KEY_PRODUCT_ID = "asr_param_key_product_id.string";
    ASR_PARAM_KEY_CITY_ID = "asr_param_key_city_id.int";
    ASR_PARAM_KEY_PROTOCOL = "asr_param_key_protocol.int";
    ASR_PARAM_KEY_KWS_PROTOCOL = "asr_param_key_kws_protocol.int";
    ASR_PARAM_KEY_LANGUAGE = "asr_param_key_language.int";
    ASR_PARAM_KEY_ENABLE_NLU = "asr_param_key_enable_nlu.bool";
    ASR_PARAM_KEY_ENABLE_LOCAL_VAD = "asr_param_key_enable_local_vad.bool";
    ASR_PARAM_KEY_COMPRESSION_TYPE = "asr_param_key_compression_type.int";
    ASR_PARAM_KEY_ENABLE_DRC = "asr_param_key_enable_drc.bool";
    ASR_PARAM_KEY_PAM = "asr_param_key_pam.string";
    ASR_PARAM_KEY_STC = "asr_param_key_stc.string";
    ASR_PARAM_KEY_LTP = "asr_param_key_ltp.string";
    ASR_PARAM_KEY_TXT = "asr_param_key_txt.string";
    ASR_PARAM_KEY_NETWORK_STATUS = "asr_param_key_network_status.int";
    ASR_PARAM_KEY_APP = "asr_param_key_app.string";
    ASR_PARAM_KEY_PLATFORM = "asr_param_key_platform.string";
    ASR_PARAM_KEY_BUA = "asr_param_key_bua.string";
    ASR_PARAM_KEY_COK = "asr_param_key_cok.string";
    ASR_PARAM_KEY_PU = "asr_param_key_pu.string";
    ASR_PARAM_KEY_FRM = "asr_param_key_frm.string";
    ASR_PARAM_KEY_RSV = "asr_param_key_rsv.map<string,string>";
    ASR_PARAM_KEY_GLB = "asr_param_key_glb.string";
    ASR_PARAM_KEY_MODEL_VAD_DAT_FILE = "asr_param_key_model_vad_dat_file.string";
    ASR_PARAM_KEY_ENABLE_MODEL_VAD = "asr_param_key_enable_model_vad.int";
    ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT = "asr_param_key_vad_endpoint_timeout.int";
    BDS_ASR_OFFLINE_ENGINE_TRIGGERED_WAKEUP_WORD = "kws_param_key_triggered_wakeup_word.string";
    ASR_PARAM_KEY_DNN_SPEECH_THRESHOLD = "asr_param_key_dnn_speech_threshold.float";
    ASR_PARAM_KEY_DNN_MIN_SP_DURATION = "asr_param_key_dnn_min_sp_duration.int";
    ASR_PARAM_KEY_DNN_HEAD_SIL_DURATION = "asr_param_key_dnn_head_sil_duration.int";
    ASR_PARAM_KEY_DNN_SIL_THRESHOLD = "asr_param_key_dnn_sil_threshold.float";
    ASR_PARAM_KEY_OFFLINE_ENGINE_TYPE = "kws_param_key_type.int";
    ASR_PARAM_KEY_STRATEGY = "asr_param_key_strategy.int";
    ASR_PARAM_KEY_OFFLINE_APP_CODE = "offline_param_key_app_code.string";
    ASR_PARAM_KEY_OFFLINE_ENGINE_DAT_FILE_PATH = "kws_param_key_dat_filepath.string";
    ASR_PARAM_KEY_OFFLINE_ENGINE_GRAMMER_FILE_PATH = "kws_param_key_grammer_filepath.string";
    OFFLINE_PARAM_KEY_LICENSE_FILE_PATH = "offline_param_key_license_filepath.string";
    BDS_ASR_OFFLINE_ENGINE_GRAMMER_SLOT = "kws_param_key_slot.string";
    COMMON_PARAM_KEY_DEBUG_LOG_LEVEL = "common_param_key_debug_log_level.int";
    ASR_PARAM_KEY_UID_STRING = "uid.string";
    ASR_PARAM_KEY_CHUNK_KEY = "asr_param_key_chunk_key.string";
    ASR_PARAM_KEY_CHUNK_PARAM = "asr_param_key_chunk_param.string";
    ASR_PARAM_KEY_CHUNK_ENABLE = "asr_param_key_chunk_enable.bool";
    ASR_PARAM_KEY_REALTIME_DATA = "asr_param_key_realtime_data.string";
    ASR_PARAM_KEY_ENABLE_LONG_SPEECH = "asr_param_key_enable_long_speech.bool";
    ASR_PARAM_KEY_MULTI_START_AND_END = "asr_param_key_multi_start_and_end.bool";
    ASR_PARAM_KEY_ENABLE_HTTPDNS = "asr_param_key_enable_httpdns.bool";
    ASR_PARAM_KEY_EARLY_CONNECTION = "asr_param_key_early_connection.bool";
    ASR_PARAM_KEY_WAKEUP_WORDS_STRING = "asr_param_key_wakeup_words.string";
    ASR_PARAM_KEY_WAKEUP_STATUS_INT = "asr_param_key_wakeup_status.int";
    ASR_PARAM_KEY_IS_ONESHOT_INT = "asr_param_key_is_oneshot.int";
    ASR_PARAM_KEY_BACKTRACK_TIME_INT = "asr_param_key_backtrack_time.int";
    hasPartialResult = false;
  }
  
  public ASREngine(Context paramContext)
    throws Exception
  {
    this.mContext = paramContext;
    this.mEventContext = new EventContext(paramContext);
    try
    {
      BDSSDKLoader.loadLibraries();
      try
      {
        this.m_ASRcore = BDSSDKLoader.getSDKObjectForSDKType("ASRCore", this.mContext);
        if (this.m_ASRcore == null) {
          throw new Exception("ASR core support is not linked in package");
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        throw new Exception("Can't found ASR Core native method");
      }
      if (this.m_ASRcore.instanceInitialized()) {
        break label220;
      }
    }
    catch (Throwable paramContext)
    {
      throw new Exception(generateErrorResult(5001));
    }
    throw new Exception("Failed initialize ASR Core native layer");
    label220:
    this.m_ASRcore.setListener(this);
  }
  
  private String adaptiveOfflineResult(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).getJSONObject("origin_result");
      String str = paramString;
      if (localJSONObject.has("raw_text"))
      {
        str = localJSONObject.getString("raw_text");
        str = new JSONObject(paramString).put("results_recognition", new JSONArray().put(str)).toString();
      }
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramString;
  }
  
  private void asrCallBack(BDSMessage paramBDSMessage, ASRListener paramASRListener)
  {
    if (!paramBDSMessage.m_messageName.equals("ASR.callback")) {}
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      LogUtil.i("ASREngine", new String[] { "ASRCallBack:" + paramBDSMessage.toString() });
                      switch (((BDSParamBase.BDSIntParam)paramBDSMessage.m_messageParams.get("cb.asr.status.int")).iValue)
                      {
                      case 15: 
                      case 16: 
                      default: 
                        return;
                      case 0: 
                        hasBegin = false;
                        hasPartialResult = false;
                        hasEnd = false;
                        paramASRListener.onEvent("asr.ready", null, null, 0, 0);
                        return;
                      case 1: 
                        this.mSerialNumber = ((String)((BDSParamBase.BDSObjectParam)paramBDSMessage.m_messageParams.get("cb.asr.result.string")).iValue);
                        paramBDSMessage = new HashMap();
                        paramBDSMessage.put("sn", this.mSerialNumber);
                        new Thread(new Runnable()
                        {
                          public void run()
                          {
                            ASREngine.this.generateEndResult();
                          }
                        }).start();
                        paramASRListener.onEvent("asr.sn", new JSONObject(paramBDSMessage).toString(), null, 0, 0);
                      }
                    } while (hasBegin);
                    paramASRListener.onEvent("asr.begin", null, null, 0, 0);
                    hasBegin = true;
                    return;
                  } while (hasEnd);
                  play(this.mContext, Integer.valueOf(this.mParams.optInt("sound_end", -1)), false);
                  JSONObject localJSONObject;
                  try
                  {
                    paramBDSMessage = (String)((BDSParamBase.BDSObjectParam)paramBDSMessage.m_messageParams.get("cb.asr.result.string")).iValue;
                    localJSONObject = new JSONObject();
                    localJSONObject.put("vad_silent_start", paramBDSMessage);
                    paramASRListener.onEvent("asr.end", localJSONObject.toString(), null, 0, 0);
                    hasEnd = true;
                    return;
                  }
                  catch (JSONException paramBDSMessage)
                  {
                    paramBDSMessage.printStackTrace();
                    return;
                  }
                  paramBDSMessage = paramBDSMessage.m_messageData;
                  if ((this.mFeedBackAudio) && (paramBDSMessage != null)) {
                    paramASRListener.onEvent("asr.audio", null, paramBDSMessage, 0, paramBDSMessage.length);
                  }
                  saveOutFile(paramBDSMessage);
                  return;
                  hasPartialResult = true;
                  if (!hasBegin)
                  {
                    paramASRListener.onEvent("asr.begin", null, null, 0, 0);
                    hasBegin = true;
                  }
                  paramBDSMessage = (String)((BDSParamBase.BDSObjectParam)paramBDSMessage.m_messageParams.get("cb.asr.result.string")).iValue;
                  this.mLastRecognitionResult = paramBDSMessage;
                  paramASRListener.onEvent("asr.partial", generateChunkPartialResult(adaptiveOfflineResult(paramBDSMessage)), null, 0, 0);
                  return;
                  if (!hasEnd)
                  {
                    play(this.mContext, Integer.valueOf(this.mParams.optInt("sound_end", -1)), false);
                    paramASRListener.onEvent("asr.end", null, null, 0, 0);
                    hasEnd = true;
                  }
                  play(this.mContext, Integer.valueOf(this.mParams.optInt("sound_success", -1)), false);
                  this.mLastRecognitionResult = "";
                  paramBDSMessage = adaptiveOfflineResult((String)((BDSParamBase.BDSObjectParam)paramBDSMessage.m_messageParams.get("cb.asr.result.string")).iValue);
                  for (;;)
                  {
                    try
                    {
                      i = new JSONObject(paramBDSMessage).optJSONArray("results_recognition").length();
                      if (i != 0) {
                        continue;
                      }
                      i = 1;
                    }
                    catch (JSONException localJSONException)
                    {
                      i = 1;
                      continue;
                      paramBDSMessage = generateChunkFinalResult(paramBDSMessage);
                      if (!this.mEnableChunk) {
                        continue;
                      }
                      paramASRListener.onEvent("asr.partial", paramBDSMessage, null, 0, 0, true);
                      if (!this.isOfflineLast) {
                        continue;
                      }
                      paramBDSMessage = new HashMap();
                      paramBDSMessage.put("error", Integer.valueOf(0));
                      paramBDSMessage.put("desc", "Speech Recognize success.");
                      localObject = new HashMap();
                      ((HashMap)localObject).put("err_no", Integer.valueOf(0));
                      ((HashMap)localObject).put("error", "Speech Recognize success.");
                      paramBDSMessage.put("origin_result", new JSONObject((Map)localObject));
                      paramASRListener.onEvent("asr.finish", new JSONObject(paramBDSMessage).toString(), null, 0, 0);
                      this.mIsWorking = false;
                      this.isOfflineLast = false;
                      hasPartialResult = false;
                      return;
                      try
                      {
                        paramBDSMessage = new JSONObject(paramBDSMessage);
                        paramBDSMessage.put("desc", "success");
                        paramBDSMessage.put("error", 0);
                        paramASRListener.onEvent("asr.finish", paramBDSMessage.toString(), null, 0, 0, true);
                        this.mIsWorking = false;
                      }
                      catch (Exception paramBDSMessage)
                      {
                        paramBDSMessage.printStackTrace();
                        paramBDSMessage = new JSONObject();
                        continue;
                      }
                    }
                    if (i == 0) {
                      continue;
                    }
                    play(this.mContext, Integer.valueOf(this.mParams.optInt("sound_error", -1)), false);
                    try
                    {
                      paramBDSMessage = new JSONObject();
                      localJSONObject = new JSONObject();
                      localJSONObject.put("sn", this.mSerialNumber);
                      localJSONObject.put("error", 7);
                      paramBDSMessage.put("desc", "Speech Quality Problem");
                      paramBDSMessage.put("origin_result", localJSONObject);
                      paramBDSMessage.put("error", 7);
                      paramBDSMessage.put("desc", "Speech Quality Problem");
                      paramASRListener.onEvent("asr.finish", paramBDSMessage.toString(), null, 0, 0, true);
                      this.mIsWorking = false;
                      return;
                    }
                    catch (Exception paramBDSMessage)
                    {
                      paramBDSMessage.printStackTrace();
                      return;
                    }
                    i = 0;
                  }
                  this.mVolumeFeedbackCount += 1;
                } while (this.mVolumeFeedbackCount % 5 != 0);
                int i = ((BDSParamBase.BDSIntParam)paramBDSMessage.m_messageParams.get("cb.asr.level.int")).iValue / 100;
                int j = (int)(Math.min(5000.0F, i) / 50.0F);
                paramBDSMessage = new HashMap();
                paramBDSMessage.put("volume", Integer.valueOf(i));
                paramBDSMessage.put("volume-percent", Integer.valueOf(j));
                paramASRListener.onEvent("asr.volume", new JSONObject(paramBDSMessage).toString(), null, 0, 0);
                return;
                play(this.mContext, Integer.valueOf(this.mParams.optInt("sound_cancel", -1)), false);
                paramASRListener.onEvent("asr.cancel", null, null, 0, 0);
                hasBegin = false;
                return;
                play(this.mContext, Integer.valueOf(this.mParams.optInt("sound_error", -1)), false);
                hasBegin = false;
                i = ((BDSParamBase.BDSIntParam)paramBDSMessage.m_messageParams.get("cb.error.domain.int16_t")).iValue;
                localObject = (String)((BDSParamBase.BDSObjectParam)paramBDSMessage.m_messageParams.get("cb.error.desc.string")).iValue;
                j = ((BDSParamBase.BDSIntParam)paramBDSMessage.m_messageParams.get("cb.error.code.int16_t")).iValue;
                paramBDSMessage = "";
                if (!Log.isLoggable("ASREngine", 3)) {}
                Log.e("ASREngine", "EVoiceRecognitionClientWorkStatusError errorDomain : " + i + " errorCode : " + j + " desc : " + (String)localObject + " mLastRecognitionResult: " + this.mLastRecognitionResult);
                if ((!this.mLastRecognitionResult.isEmpty()) && (i == 20) && (j != 1) && (hasPartialResult))
                {
                  play(this.mContext, Integer.valueOf(this.mParams.optInt("sound_end", -1)), false);
                  paramASRListener.onEvent("asr.end", null, null, 0, 0);
                  if (this.mEnableChunk)
                  {
                    paramASRListener.onEvent("asr.partial", generateChunkFinalResult(this.mLastRecognitionResult), null, 0, 0, true);
                    play(this.mContext, Integer.valueOf(this.mParams.optInt("sound_success", -1)), false);
                    paramASRListener.onEvent("asr.finish", this.mChunkFinishResult, null, 0, 0);
                  }
                  for (;;)
                  {
                    this.mIsWorking = false;
                    return;
                    play(this.mContext, Integer.valueOf(this.mParams.optInt("sound_success", -1)), false);
                    paramASRListener.onEvent("asr.finish", this.mLastRecognitionResult, null, 0, 0);
                  }
                }
                try
                {
                  localObject = generateErrorResult(i, j);
                  paramBDSMessage = (BDSMessage)localObject;
                }
                catch (Exception localException)
                {
                  for (;;) {}
                }
                paramASRListener.onEvent("asr.finish", paramBDSMessage, null, 0, 0);
                this.mIsWorking = false;
                return;
                paramASRListener.onEvent("asr.loaded", null, null, 0, 0);
                return;
                paramASRListener.onEvent("asr.unloaded", null, null, 0, 0);
                return;
              } while (!this.mEnableChunk);
              localObject = generateThirdResult();
              paramBDSMessage = paramBDSMessage.m_messageData;
            } while (paramBDSMessage == null);
            paramASRListener.onEvent("asr.partial", (String)localObject, paramBDSMessage, 0, paramBDSMessage.length);
            return;
          } while (!this.mEnableChunk);
          localObject = generateNluResult();
          paramBDSMessage = paramBDSMessage.m_messageData;
        } while (paramBDSMessage == null);
        paramASRListener.onEvent("asr.partial", (String)localObject, paramBDSMessage, 0, paramBDSMessage.length);
        return;
        paramASRListener.onEvent("asr.finish", this.mChunkFinishResult, null, 0, 0);
      } while (this.enableLongSpeech);
      this.mIsWorking = false;
      play(this.mContext, Integer.valueOf(this.mParams.optInt("sound_success", -1)), false);
      return;
    } while (!this.mEnableLogFeedBack);
    paramASRListener.onEvent("asr.log", (String)((BDSParamBase.BDSObjectParam)paramBDSMessage.m_messageParams.get("cb.asr.result.string")).iValue, null, 0, 0);
    return;
    paramASRListener.onEvent("asr.long-speech.finish", null, null, 0, 0);
    this.mIsWorking = false;
    return;
    paramASRListener.onEvent("asr.exit", null, null, 0, 0);
  }
  
  /* Error */
  private void clearOutFile()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 535	com/baidu/speech/core/ASREngine:mOutFile	Ljava/lang/String;
    //   4: ifnull +48 -> 52
    //   7: aload_0
    //   8: getfield 535	com/baidu/speech/core/ASREngine:mOutFile	Ljava/lang/String;
    //   11: ldc_w 529
    //   14: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifne +35 -> 52
    //   20: new 903	java/io/FileOutputStream
    //   23: dup
    //   24: aload_0
    //   25: getfield 535	com/baidu/speech/core/ASREngine:mOutFile	Ljava/lang/String;
    //   28: invokespecial 904	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: ldc_w 529
    //   38: invokevirtual 908	java/lang/String:getBytes	()[B
    //   41: invokevirtual 913	java/io/OutputStream:write	([B)V
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 916	java/io/OutputStream:close	()V
    //   52: return
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   58: return
    //   59: astore_3
    //   60: aconst_null
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   68: aload_2
    //   69: ifnull -17 -> 52
    //   72: aload_2
    //   73: invokevirtual 916	java/io/OutputStream:close	()V
    //   76: return
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   82: return
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 916	java/io/OutputStream:close	()V
    //   94: aload_2
    //   95: athrow
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   101: goto -7 -> 94
    //   104: astore_2
    //   105: goto -19 -> 86
    //   108: astore_3
    //   109: goto -47 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	ASREngine
    //   33	1	1	localFileOutputStream1	java.io.FileOutputStream
    //   53	2	1	localIOException1	java.io.IOException
    //   63	1	1	localFileOutputStream2	java.io.FileOutputStream
    //   77	2	1	localIOException2	java.io.IOException
    //   85	6	1	localObject1	Object
    //   96	2	1	localIOException3	java.io.IOException
    //   31	42	2	localFileOutputStream3	java.io.FileOutputStream
    //   83	12	2	localObject2	Object
    //   104	1	2	localObject3	Object
    //   59	6	3	localIOException4	java.io.IOException
    //   108	1	3	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   48	52	53	java/io/IOException
    //   20	32	59	java/io/IOException
    //   72	76	77	java/io/IOException
    //   20	32	83	finally
    //   90	94	96	java/io/IOException
    //   34	44	104	finally
    //   64	68	104	finally
    //   34	44	108	java/io/IOException
  }
  
  private void fillNlpResult(String paramString, JSONObject paramJSONObject)
    throws Exception
  {
    if (this.nlpFeature != null)
    {
      this.usingSimpleNlp = ((JSONObject)this.nlpFeature.get());
      this.nlpFeature = null;
    }
    if (this.usingSimpleNlp == null) {}
    do
    {
      do
      {
        return;
      } while (paramJSONObject.optInt("error", 0) != 0);
      localObject1 = paramJSONObject.optJSONArray("results_recognition");
    } while ((localObject1 == null) || (((JSONArray)localObject1).length() == 0));
    Object localObject1 = ((JSONArray)localObject1).optString(0);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramString)) && (((String)localObject1).length() > paramString.length())) {}
    for (paramString = ((String)localObject1).substring(paramString.length());; paramString = (String)localObject1)
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject1 = this.usingSimpleNlp.getJSONObject("rules");
      Iterator localIterator = localJSONObject1.keys();
      int i;
      label175:
      Object localObject3;
      Object localObject2;
      JSONArray localJSONArray3;
      Matcher localMatcher;
      label223:
      JSONObject localJSONObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        JSONArray localJSONArray2 = localJSONObject1.getJSONArray((String)localObject1);
        i = 0;
        if (i < localJSONArray2.length())
        {
          localObject3 = localJSONArray2.getJSONObject(i);
          localObject2 = ((JSONObject)localObject3).getString("pattern");
          localJSONArray3 = ((JSONObject)localObject3).getJSONArray("groups");
          localMatcher = Pattern.compile((String)localObject2).matcher(paramString);
          if (localMatcher.find())
          {
            localJSONObject2 = new JSONObject();
            localObject2 = ((String)localObject1).split("\\.");
            if (localObject2.length < 2) {
              break label523;
            }
            localObject3 = localObject2[0];
            localObject2 = localObject2[1];
          }
        }
      }
      for (;;)
      {
        localJSONObject2.put("domain", localObject3);
        localJSONObject2.put("intent", localObject2);
        localJSONObject2.put("parser", "bsg");
        localObject2 = new JSONObject();
        localJSONObject2.put("object", localObject2);
        int k = localMatcher.groupCount();
        int j = 0;
        while (j < k)
        {
          ((JSONObject)localObject2).put(localJSONArray3.getString(j), localMatcher.group(j + 1));
          j += 1;
        }
        localJSONArray1.put(localJSONObject2);
        break label223;
        i += 1;
        break label175;
        break;
        localObject1 = new JSONObject(paramJSONObject.optString("origin_result"));
        localObject1 = (String)this.mEventContext.searchItemFromJson((JSONObject)localObject1, "json_res");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONObject((String)localObject1).optJSONArray("results");
          if (localObject1 != null)
          {
            i = 0;
            while (i < ((JSONArray)localObject1).length())
            {
              localJSONArray1.put(((JSONArray)localObject1).getJSONObject(i));
              i += 1;
            }
          }
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("raw_text", paramString);
        ((JSONObject)localObject1).put("results", localJSONArray1);
        paramJSONObject.put("results_nlu", localObject1);
        return;
        label523:
        localObject2 = localObject1;
        localObject3 = localObject1;
      }
    }
  }
  
  private String generateChunkFinalResult(String paramString)
  {
    String str4 = "";
    if (paramString != null) {}
    for (String str2 = paramString;; str2 = "") {
      for (;;)
      {
        String str1;
        try
        {
          JSONObject localJSONObject = new JSONObject(str2).optJSONObject("origin_result");
          paramString = "";
          str1 = paramString;
          String str3 = str4;
          if (localJSONObject != null)
          {
            str1 = paramString;
            if (localJSONObject.optJSONObject("result") != null)
            {
              if (localJSONObject.optJSONObject("result").optJSONArray("word") != null) {
                str1 = localJSONObject.optJSONObject("result").optJSONArray("word").optString(0);
              }
            }
            else
            {
              if (!localJSONObject.has("raw_text")) {
                continue;
              }
              str1 = localJSONObject.optString("raw_text");
              paramString = str1;
              if (isIllegalResult(str1)) {
                paramString = str1.replace("1。00。", "");
              }
              this.isOfflineLast = true;
              str1 = paramString;
              str3 = str4;
              if (this.mParams == null) {
                break label472;
              }
              if (!"enable".equals(this.mParams.optString("nlu")))
              {
                str1 = paramString;
                str3 = str4;
                if (!"enable-all".equals(this.mParams.optString("nlu"))) {
                  break label472;
                }
              }
              str3 = getNlpResult(this.mParams.optString("keyword"), new JSONObject(str2));
              str1 = paramString;
              break label472;
              paramString = new HashMap();
              paramString.put("result_type", "final_result");
              paramString.put("best_result", str1);
              paramString.put("origin_result", localJSONObject);
              paramString.put("error", Integer.valueOf(0));
              paramString.put("results_recognition", new JSONArray().put(str1));
              if (!TextUtils.isEmpty(str3)) {
                paramString.put("results_nlu", str3);
              }
              return new JSONObject(paramString).toString();
            }
            str1 = paramString;
            if (localJSONObject.optJSONObject("content") == null) {
              continue;
            }
            str1 = paramString;
            if (localJSONObject.optJSONObject("content").optJSONArray("item") == null) {
              continue;
            }
            str1 = localJSONObject.optJSONObject("content").optJSONArray("item").optString(0);
            continue;
            paramString = str1;
            if (localJSONObject.optJSONObject("result") == null) {
              continue;
            }
            paramString = str1;
            if (localJSONObject.optJSONObject("result").optString("raw_text") == null) {
              continue;
            }
            paramString = str1;
            if (!"KWS".equals(localJSONObject.optJSONObject("result").optString("sn"))) {
              continue;
            }
            paramString = localJSONObject.optJSONObject("result").optString("raw_text");
            this.isOfflineLast = true;
            continue;
            str1 = "";
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return "";
        }
        label472:
        do
        {
          break;
        } while (str1 == null);
      }
    }
  }
  
  private String generateChunkPartialResult(String paramString)
  {
    String str3 = "";
    if (paramString != null) {}
    for (Object localObject = paramString;; localObject = "") {
      label433:
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject((String)localObject).optJSONObject("origin_result");
          String str2 = "";
          paramString = str2;
          if (localJSONObject != null)
          {
            str1 = str2;
            if (localJSONObject.optJSONObject("result") != null)
            {
              if (localJSONObject.optJSONObject("result").optJSONArray("word") == null) {
                continue;
              }
              str1 = localJSONObject.optJSONObject("result").optJSONArray("word").optString(0);
            }
            if (!localJSONObject.has("raw_text")) {
              continue;
            }
            str1 = localJSONObject.optString("raw_text");
            paramString = str1;
            if (isIllegalResult(str1)) {
              paramString = str1.replace("1。00。", "");
            }
          }
          String str1 = str3;
          if (this.mParams != null)
          {
            str1 = str3;
            if ("enable-all".equals(this.mParams.optString("nlu")))
            {
              str1 = getNlpResult(this.mParams.optString("keyword"), new JSONObject((String)localObject));
              break label433;
              localObject = new HashMap();
              ((HashMap)localObject).put("result_type", "partial_result");
              ((HashMap)localObject).put("best_result", paramString);
              ((HashMap)localObject).put("origin_result", localJSONObject);
              ((HashMap)localObject).put("error", Integer.valueOf(0));
              ((HashMap)localObject).put("results_recognition", new JSONArray().put(paramString));
              if (!TextUtils.isEmpty(str1)) {
                ((HashMap)localObject).put("results_nlu", str1);
              }
              return new JSONObject((Map)localObject).toString();
              str1 = str2;
              if (localJSONObject.optJSONObject("content") == null) {
                continue;
              }
              str1 = str2;
              if (localJSONObject.optJSONObject("content").optJSONArray("item") == null) {
                continue;
              }
              str1 = localJSONObject.optJSONObject("content").optJSONArray("item").optString(0);
              continue;
              paramString = str1;
              if (localJSONObject.optJSONObject("result") == null) {
                continue;
              }
              paramString = str1;
              if (localJSONObject.optJSONObject("result").optString("raw_text") == null) {
                continue;
              }
              paramString = str1;
              if (!"KWS".equals(localJSONObject.optJSONObject("result").optString("sn"))) {
                continue;
              }
              paramString = localJSONObject.optJSONObject("result").optString("raw_text");
              continue;
              paramString = "";
              continue;
            }
          }
          if (paramString == null) {}
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return "";
        }
      }
    }
  }
  
  private void generateEndResult()
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("error", Integer.valueOf(0));
    localHashMap1.put("desc", "Speech Recognize success.");
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("sn", this.mSerialNumber);
    localHashMap2.put("err_no", Integer.valueOf(0));
    localHashMap2.put("error", "Speech Recognize success.");
    localHashMap1.put("origin_result", new JSONObject(localHashMap2));
    this.mChunkFinishResult = new JSONObject(localHashMap1).toString();
  }
  
  private String generateErrorResult(int paramInt)
    throws Exception
  {
    String str = AsrError.getDescFromCode(paramInt);
    int i = paramInt / 1000;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("sn", this.mSerialNumber);
    localJSONObject2.put("error", i);
    localJSONObject2.put("desc", str);
    localJSONObject2.put("sub_error", paramInt);
    localJSONObject1.put("origin_result", localJSONObject2);
    localJSONObject1.put("error", i);
    localJSONObject1.put("desc", str);
    localJSONObject1.put("sub_error", paramInt);
    return localJSONObject1.toString();
  }
  
  private String generateErrorResult(int paramInt1, int paramInt2)
    throws Exception
  {
    if (!Log.isLoggable("ASREngine", 3)) {}
    Log.d("ASREngine", "generateErrorResult errDomain = " + paramInt1 + " errCode = " + paramInt2);
    if ((Utility.getWifiOr2gOr3G(this.mContext) == 0) && (this.decodertemp == 0)) {
      return generateErrorResult(2100);
    }
    int i;
    if (AsrError.getDescFromCode(paramInt2) != null) {
      i = paramInt2;
    }
    for (;;)
    {
      return generateErrorResult(i);
      i = paramInt2;
      if (paramInt1 != 10)
      {
        if (paramInt1 == 20)
        {
          if (1 == paramInt2)
          {
            i = 3100;
            continue;
          }
          if ((2 == paramInt2) && (!hasPartialResult))
          {
            i = 3101;
            continue;
          }
          if ((3 == paramInt2) && (!hasPartialResult)) {
            i = 3102;
          }
        }
        else if (paramInt1 == 30)
        {
          if (paramInt2 == 1)
          {
            i = 8001;
            continue;
          }
          if (paramInt2 == 2)
          {
            i = 2100;
            continue;
          }
          if (paramInt2 == 3)
          {
            i = 5003;
            continue;
          }
          if (paramInt2 == 4) {
            i = 5004;
          }
        }
        else
        {
          if (paramInt1 == 31)
          {
            i = 2100;
            continue;
          }
          i = paramInt2;
          if (paramInt1 == 32) {
            continue;
          }
          if (paramInt1 == 33)
          {
            if (paramInt2 == 62535)
            {
              i = 4001;
              continue;
            }
            if (paramInt2 == 62534)
            {
              i = 4002;
              continue;
            }
            if (paramInt2 == 62533)
            {
              i = 4003;
              continue;
            }
            if (paramInt2 == 62532)
            {
              i = 4004;
              continue;
            }
            if (paramInt2 == 62531)
            {
              i = 7001;
              continue;
            }
            i = paramInt2;
            if (paramInt2 != 62530) {
              continue;
            }
            i = 6001;
            continue;
          }
          if (paramInt1 == 34)
          {
            if (paramInt2 == 1)
            {
              i = 10001;
              continue;
            }
            if (paramInt2 == 2)
            {
              i = 10002;
              continue;
            }
            if (paramInt2 == 3)
            {
              i = 10003;
              continue;
            }
            if (paramInt2 == 4)
            {
              i = 10004;
              continue;
            }
            if (paramInt2 == 5)
            {
              i = 10005;
              continue;
            }
            if (paramInt2 == 6)
            {
              i = paramInt2;
              if (this.decodertemp == 4) {
                continue;
              }
              i = 10006;
              continue;
            }
            if (paramInt2 == 7)
            {
              i = 10007;
              continue;
            }
            if (paramInt2 == 8)
            {
              i = 10008;
              continue;
            }
            if (paramInt2 == 9)
            {
              i = 10009;
              continue;
            }
            if (paramInt2 == 10)
            {
              i = 10010;
              continue;
            }
            if (paramInt2 == 11)
            {
              i = 10011;
              continue;
            }
            i = paramInt2;
            if (paramInt2 != 12) {
              continue;
            }
            i = paramInt2;
            if (hasPartialResult) {
              continue;
            }
            i = 10012;
            continue;
          }
          i = 7001;
          continue;
        }
        i = -1;
      }
    }
  }
  
  private String generateNluResult()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("result_type", "nlu_result");
    localHashMap.put("best_result", "");
    localHashMap.put("origin_result", "");
    return new JSONObject(localHashMap).toString();
  }
  
  private String generateThirdResult()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("result_type", "third_result");
    localHashMap.put("best_result", "");
    localHashMap.put("origin_result", "");
    return new JSONObject(localHashMap).toString();
  }
  
  private int getLanguageFlag(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    do
    {
      do
      {
        return 0;
      } while (paramString.equals("cmn-Hans-CN"));
      if (paramString.equals("yue-Hans-CN")) {
        return 1;
      }
      if (paramString.equals("en-GB")) {
        return 2;
      }
    } while (!paramString.equals("sichuan-Hans-CN"));
    return 3;
  }
  
  private String getNlpResult(String paramString, JSONObject paramJSONObject)
    throws Exception
  {
    if (this.nlpFeature != null)
    {
      this.usingSimpleNlp = ((JSONObject)this.nlpFeature.get());
      this.nlpFeature = null;
    }
    if (this.usingSimpleNlp == null) {
      return null;
    }
    if (paramJSONObject.optInt("error", 0) != 0) {
      return null;
    }
    Object localObject1 = paramJSONObject.optJSONArray("results_recognition");
    if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0)) {
      return null;
    }
    localObject1 = ((JSONArray)localObject1).optString(0);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramString)) && (((String)localObject1).length() > paramString.length())) {}
    for (paramString = ((String)localObject1).substring(paramString.length());; paramString = (String)localObject1)
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject1 = this.usingSimpleNlp.getJSONObject("rules");
      Iterator localIterator = localJSONObject1.keys();
      int i;
      label180:
      Object localObject3;
      Object localObject2;
      JSONArray localJSONArray3;
      Matcher localMatcher;
      label228:
      JSONObject localJSONObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        JSONArray localJSONArray2 = localJSONObject1.getJSONArray((String)localObject1);
        i = 0;
        if (i < localJSONArray2.length())
        {
          localObject3 = localJSONArray2.getJSONObject(i);
          localObject2 = ((JSONObject)localObject3).getString("pattern");
          localJSONArray3 = ((JSONObject)localObject3).getJSONArray("groups");
          localMatcher = Pattern.compile((String)localObject2).matcher(paramString);
          if (localMatcher.find())
          {
            localJSONObject2 = new JSONObject();
            localObject2 = ((String)localObject1).split("\\.");
            if (localObject2.length < 2) {
              break label519;
            }
            localObject3 = localObject2[0];
            localObject2 = localObject2[1];
          }
        }
      }
      for (;;)
      {
        localJSONObject2.put("domain", localObject3);
        localJSONObject2.put("intent", localObject2);
        localJSONObject2.put("parser", "bsg");
        localObject2 = new JSONObject();
        localJSONObject2.put("object", localObject2);
        int k = localMatcher.groupCount();
        int j = 0;
        while (j < k)
        {
          ((JSONObject)localObject2).put(localJSONArray3.getString(j), localMatcher.group(j + 1));
          j += 1;
        }
        localJSONArray1.put(localJSONObject2);
        break label228;
        i += 1;
        break label180;
        break;
        paramJSONObject = new JSONObject(paramJSONObject.optString("origin_result"));
        paramJSONObject = (String)this.mEventContext.searchItemFromJson(paramJSONObject, "json_res");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramJSONObject = new JSONObject(paramJSONObject);
          paramJSONObject = (JSONArray)this.mEventContext.searchItemFromJson(paramJSONObject, "results");
          if (paramJSONObject != null)
          {
            i = 0;
            while (i < paramJSONObject.length())
            {
              localJSONArray1.put(paramJSONObject.getJSONObject(i));
              i += 1;
            }
          }
        }
        paramJSONObject = new JSONObject();
        paramJSONObject.put("raw_text", paramString);
        paramJSONObject.put("results", localJSONArray1);
        return paramJSONObject.toString();
        label519:
        localObject2 = localObject1;
        localObject3 = localObject1;
      }
    }
  }
  
  private int getSampleRateFlag(int paramInt)
  {
    if (paramInt == 8000) {
      return 1;
    }
    if (paramInt == 16000) {
      return 2;
    }
    return 0;
  }
  
  private BDSErrorDescription initConfig(BDSErrorDescription paramBDSErrorDescription, JSONObject paramJSONObject)
    throws Exception
  {
    BDSMessage localBDSMessage = new BDSMessage();
    localBDSMessage.m_messageName = ASR_CMD_CONFIG;
    localBDSMessage.m_messageParams = new HashMap();
    Object localObject3 = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
    String str = paramJSONObject.optString("decoder-server.pdt", paramJSONObject.optString("pid"));
    localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_PRODUCT_ID, BDSParamBase.objectParam(str, "java.lang.String"));
    Object localObject2 = paramJSONObject.optString("decoder-server.agent.url", paramJSONObject.optString("agent.url", ""));
    if (TextUtils.isEmpty(str))
    {
      if (((ApplicationInfo)localObject3).metaData != null) {
        break label1251;
      }
      str = null;
    }
    for (;;)
    {
      Object localObject1;
      label138:
      label280:
      label371:
      int i;
      int j;
      label673:
      boolean bool;
      if (((ApplicationInfo)localObject3).metaData == null)
      {
        localObject1 = "";
        str = paramJSONObject.optString("key", paramJSONObject.optString("apikey", str));
        localObject1 = paramJSONObject.optString("secret", (String)localObject1);
        if ((str != null) && (localObject1 != null))
        {
          localObject4 = new Vector();
          ((Vector)localObject4).add(str);
          ((Vector)localObject4).add(localObject1);
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_API_SECRET_KEYS, BDSParamBase.objectParam(localObject4, "java.util.Vector;"));
        }
        str = paramJSONObject.optString("decoder-server.fix-app", "");
        localObject1 = paramJSONObject.optString("decoder-server.app", Policy.app(this.mContext));
        Object localObject4 = new StringBuilder();
        if ((str != null) && (!"".equals(str))) {
          break label1283;
        }
        str = "";
        this.mApp = (str + (String)localObject1);
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_APP, BDSParamBase.objectParam(this.mApp, "java.lang.String"));
        str = paramJSONObject.optString("decoder-server.key", paramJSONObject.optString("key", ""));
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_CHUNK_KEY, BDSParamBase.objectParam(str, "java.lang.String"));
        if (((ApplicationInfo)localObject3).metaData != null) {
          break label1309;
        }
        str = null;
        str = paramJSONObject.optString("appid", str);
        if (str != null) {
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_APP_CODE, BDSParamBase.objectParam(str, "java.lang.String"));
        }
        i = paramJSONObject.optInt("log_level", -1);
        if (i != -1) {
          localBDSMessage.m_messageParams.put(COMMON_PARAM_KEY_DEBUG_LOG_LEVEL, BDSParamBase.intParam(i));
        }
        j = paramJSONObject.optInt("basic.decoder", paramJSONObject.optInt("decoder", 0));
        this.decodertemp = j;
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_STRATEGY, BDSParamBase.intParam(j));
        i = paramJSONObject.optInt("audio.sample", paramJSONObject.optInt("sample", 16000));
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_SAMPLE_RATE, BDSParamBase.intParam(getSampleRateFlag(i)));
        str = paramJSONObject.optString("decoder-offline.language", paramJSONObject.optString("language", "cmn-Hans-CN"));
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_LANGUAGE, BDSParamBase.intParam(getLanguageFlag(str)));
        localObject1 = paramJSONObject.optString("vad", paramJSONObject.optString("vad", "model-vad"));
        if (!Log.isLoggable("ASREngine", 3)) {}
        Log.e("ASREngine", "VAD Model=" + (String)localObject1);
        str = String.format("%s/%s", new Object[] { this.mContext.getApplicationInfo().nativeLibraryDir, "libbd_easr_s1_merge_normal_20151216.dat.so" });
        if (!((String)localObject1).equals("touch")) {
          break label1344;
        }
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(false));
        if (localObject2 != "") {
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_SERVER_AGENT_URL, BDSParamBase.objectParam(localObject2, "java.lang.String"));
        }
        localObject3 = paramJSONObject.optString("dev", "");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_DEV, BDSParamBase.objectParam(localObject3, "java.lang.String"));
        }
        localObject3 = paramJSONObject.optString("audio.file", paramJSONObject.optString("infile", ""));
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_AUDIO_FILE_PATH, BDSParamBase.objectParam(localObject3, "java.lang.String"));
        localObject3 = paramJSONObject.optString("audio.mills", "");
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_AUDIO_mills, BDSParamBase.objectParam(localObject3, "java.lang.String"));
        i = paramJSONObject.optInt("audio.socketport");
        localBDSMessage.m_messageParams.put(MIC_PARAM_KEY_SOCKET_PORT, BDSParamBase.intParam(i));
        if (paramJSONObject.has("audio.stream-type"))
        {
          this.mStreamType = paramJSONObject.optInt("audio.stream-type");
          if (!Log.isLoggable("ASREngine", 3)) {}
          Log.d("ASREngine", "audio stream type = " + this.mStreamType);
        }
        bool = paramJSONObject.optBoolean("accept-audio-volume", true);
        if (!bool) {
          localBDSMessage.m_messageParams.put("mic_accept_audio_volume.bool", BDSParamBase.boolParam(bool));
        }
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_NETWORK_STATUS, BDSParamBase.intParam(Utility.getWifiOr2gOr3G(this.mContext)));
        localObject3 = paramJSONObject.optString("decoder-server.url", paramJSONObject.optString("url", "http://vop.baidu.com/v2"));
      }
      try
      {
        com.baidu.speech.utils.CommonParam.REQUEST_URL = new URL((String)localObject3).getHost();
        com.baidu.speech.utils.CommonParam.AGENT_URL = (String)localObject2;
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_SERVER_URL, BDSParamBase.objectParam(localObject3, "java.lang.String"));
        localObject2 = paramJSONObject.optString("decoder-server.uid", Policy.uid(this.mContext));
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_UID_STRING, BDSParamBase.objectParam(localObject2, "java.lang.String"));
        localObject2 = paramJSONObject.optString("decoder-server.glb", UUID.randomUUID().toString());
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_GLB, BDSParamBase.objectParam(localObject2, "java.lang.String"));
        localObject2 = paramJSONObject.optString("decoder-server.stc");
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_STC, BDSParamBase.objectParam(localObject2, "java.lang.String"));
        this.mPlatform = paramJSONObject.optString("decoder-server.pfm", Policy.pfm(this.mContext));
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_PLATFORM, BDSParamBase.objectParam(this.mPlatform, "java.lang.String"));
        this.mVersion = paramJSONObject.optString("decoder-server.ver", Policy.ver(this.mContext));
        localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_SDK_VERSION, BDSParamBase.objectParam(this.mVersion, "java.lang.String"));
        localObject2 = paramJSONObject.optJSONArray("prop");
        localObject3 = new Vector();
        if (localObject2 != null)
        {
          i = 0;
          if (i >= ((JSONArray)localObject2).length()) {}
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        try
        {
          for (;;)
          {
            ((Vector)localObject3).add(Integer.valueOf(((JSONArray)localObject2).getInt(i)));
            i += 1;
          }
          label1251:
          str = ((ApplicationInfo)localObject3).metaData.getString("com.baidu.speech.API_KEY");
          continue;
          localObject1 = ((ApplicationInfo)localObject3).metaData.getString("com.baidu.speech.SECRET_KEY");
          break label138;
          label1283:
          str = str + "/";
          break label280;
          label1309:
          str = ((ApplicationInfo)localObject3).metaData.getInt("com.baidu.speech.APP_ID") + "";
          break label371;
          label1344:
          if (((String)localObject1).equals("input"))
          {
            localObject3 = paramJSONObject.optString("vad.res-file", paramJSONObject.optString("res-file", str));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(true));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(0));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_MODEL_VAD_DAT_FILE, BDSParamBase.objectParam(loadSourceFromUri((String)localObject3), "java.lang.String"));
            i = paramJSONObject.optInt("vad.endpoint-timeout", paramJSONObject.optInt("vad.end-frame", 2500));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT, BDSParamBase.intParam(i));
            break label673;
          }
          if ((((String)localObject1).equals("model-vad")) || (((String)localObject1).equals("model_vad")))
          {
            localObject3 = paramJSONObject.optString("vad.res-file", paramJSONObject.optString("res-file", str));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(true));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(1));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_MODEL_VAD_DAT_FILE, BDSParamBase.objectParam(loadSourceFromUri((String)localObject3), "java.lang.String"));
            i = paramJSONObject.optInt("vad.endpoint-timeout", paramJSONObject.optInt("vad.end-frame", 0));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT, BDSParamBase.intParam(i));
            break label673;
          }
          if (((String)localObject1).equals("dnn"))
          {
            localObject3 = paramJSONObject.optString("vad.res-file", paramJSONObject.optString("res-file", String.format("%s/%s", new Object[] { this.mContext.getApplicationInfo().nativeLibraryDir, "libvad.dnn.so" })));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(true));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(2));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_MODEL_VAD_DAT_FILE, BDSParamBase.objectParam(loadSourceFromUri((String)localObject3), "java.lang.String"));
            i = paramJSONObject.optInt("vad.endpoint-timeout", paramJSONObject.optInt("vad.end-frame", 0));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT, BDSParamBase.intParam(i));
            float f = (float)paramJSONObject.optDouble("vad.speech-threshold", 0.0D);
            if (f > 0.0F) {
              localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_DNN_SPEECH_THRESHOLD, BDSParamBase.floatParam(f));
            }
            i = paramJSONObject.optInt("vad.min-speech-duration", 0);
            if (i > 0) {
              localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_DNN_MIN_SP_DURATION, BDSParamBase.intParam(i));
            }
            i = paramJSONObject.optInt("vad.head-sil-duration", 0);
            if (i > 0) {
              localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_DNN_HEAD_SIL_DURATION, BDSParamBase.intParam(i));
            }
            i = paramJSONObject.optInt("vad.max-wait-duration", 0);
            if (i > 0) {
              localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_MAX_WAIT_DURATION, BDSParamBase.intParam(i));
            }
            f = (float)paramJSONObject.optDouble("vad.sil-threshold", 0.0D);
            if (f <= 0.0F) {
              break label673;
            }
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_DNN_SIL_THRESHOLD, BDSParamBase.floatParam(f));
            break label673;
          }
          if (((String)localObject1).equals("search"))
          {
            localObject3 = paramJSONObject.optString("vad.res-file", paramJSONObject.optString("res-file", str));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(true));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(0));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_MODEL_VAD_DAT_FILE, BDSParamBase.objectParam(loadSourceFromUri((String)localObject3), "java.lang.String"));
            i = paramJSONObject.optInt("vad.endpoint-timeout", 1000);
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_VAD_ENDPOINT_TIMEOUT, BDSParamBase.intParam(i));
            break label673;
          }
          if (!"mfe".equals(localObject1)) {
            break label673;
          }
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LOCAL_VAD, BDSParamBase.boolParam(true));
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_MODEL_VAD, BDSParamBase.intParam(0));
          break label673;
          localMalformedURLException = localMalformedURLException;
          localMalformedURLException.printStackTrace();
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        if (((String)localObject1).equals("input"))
        {
          localObject1 = new Vector();
          ((Vector)localObject1).add(Integer.valueOf(20000));
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_PROPERTY_LIST, BDSParamBase.objectParam(localObject1, "java.util.Vector;"));
          bool = paramJSONObject.optBoolean("decoder-server-fun.disable-punctuation", paramJSONObject.optBoolean("disable-punctuation", false));
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_DISABLE_PUNCTUATION, BDSParamBase.boolParam(bool));
          i = paramJSONObject.optInt("punctuation-mode", 0);
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_PUNCTUATION_EXT_MODE, BDSParamBase.intParam(i));
          bool = paramJSONObject.optBoolean("server-vad", true);
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_SERVER_VAD, BDSParamBase.boolParam(bool));
          bool = paramJSONObject.optBoolean("decoder-server-fun.contact", paramJSONObject.optBoolean("contact", false));
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_CONTACTS, BDSParamBase.boolParam(bool));
          bool = paramJSONObject.optBoolean("enable-early-return", false);
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_EARLY_RETURN, BDSParamBase.boolParam(bool));
          i = paramJSONObject.optInt("cid");
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_CITY_ID, BDSParamBase.intParam(i));
          localObject1 = paramJSONObject.optString("decoder-server.pam", "");
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_CHUNK_PARAM, BDSParamBase.objectParam(localObject1, "java.lang.String"));
          if (1 != paramJSONObject.optInt("dec-type", paramJSONObject.optInt("basic.dec-type", 1))) {
            break label3335;
          }
          bool = true;
          label2374:
          this.mEnableChunk = bool;
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_CHUNK_ENABLE, BDSParamBase.boolParam(this.mEnableChunk));
          bool = paramJSONObject.optString("nlu", "disable").equals("enable");
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_NLU, BDSParamBase.boolParam(bool));
          if (!bool) {
            break label3341;
          }
          i = 305;
          label2444:
          i = paramJSONObject.optInt("decoder-server.ptc", i);
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_PROTOCOL, BDSParamBase.intParam(i));
          i = paramJSONObject.optInt("decoder-offline.ptc", 0);
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_KWS_PROTOCOL, BDSParamBase.intParam(i));
          if (paramJSONObject.optInt("vad.endpoint-timeout", 1000) != 0) {
            break label3347;
          }
          bool = true;
          label2515:
          this.enableLongSpeech = bool;
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_LONG_SPEECH, BDSParamBase.boolParam(this.enableLongSpeech));
          bool = paramJSONObject.optBoolean("long-speech.multi-start-end", false);
          if (bool) {
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_MULTI_START_AND_END, BDSParamBase.boolParam(bool));
          }
          bool = paramJSONObject.optBoolean("enable-httpdns", true);
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ENABLE_HTTPDNS, BDSParamBase.boolParam(bool));
          bool = paramJSONObject.optBoolean("early-connection", true);
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_EARLY_CONNECTION, BDSParamBase.boolParam(bool));
          localObject1 = paramJSONObject.optString("keyword");
          if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
            localBDSMessage.m_messageParams.put(BDS_ASR_OFFLINE_ENGINE_TRIGGERED_WAKEUP_WORD, BDSParamBase.objectParam(localObject1, "java.lang.String"));
          }
          localObject1 = paramJSONObject.optString("grammar");
          str = paramJSONObject.optString("decoder-offline.asr-base-file-path", paramJSONObject.optString("asr-base-file-path", paramJSONObject.optString("kws.res-file", paramJSONObject.optString("res-file", str))));
          localObject2 = paramJSONObject.optString("decoder-offline.license-file-path", paramJSONObject.optString("license-file-path", paramJSONObject.optString("license")));
          localObject3 = paramJSONObject.optString("decoder-offline.slot-data", paramJSONObject.optString("slot-data"));
          i = 0;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            i = 2;
          }
          if (j != 0)
          {
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_ENGINE_TYPE, BDSParamBase.intParam(i));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_ENGINE_GRAMMER_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri((String)localObject1), "java.lang.String"));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_ENGINE_DAT_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(str), "java.lang.String"));
            localBDSMessage.m_messageParams.put(OFFLINE_PARAM_KEY_LICENSE_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri((String)localObject2), "java.lang.String"));
            localBDSMessage.m_messageParams.put(BDS_ASR_OFFLINE_ENGINE_GRAMMER_SLOT, BDSParamBase.objectParam(localObject3, "java.lang.String"));
          }
          if (SpeechConstant.PUBLIC_DECODER)
          {
            if ((localObject1 == null) || (((String)localObject1).equals(""))) {
              break label3353;
            }
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_STRATEGY, BDSParamBase.intParam(j));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_ENGINE_DAT_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri(str), "java.lang.String"));
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_OFFLINE_ENGINE_GRAMMER_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri((String)localObject1), "java.lang.String"));
            localBDSMessage.m_messageParams.put(OFFLINE_PARAM_KEY_LICENSE_FILE_PATH, BDSParamBase.objectParam(loadSourceFromUri((String)localObject2), "java.lang.String"));
            localBDSMessage.m_messageParams.put(BDS_ASR_OFFLINE_ENGINE_GRAMMER_SLOT, BDSParamBase.objectParam(localObject3, "java.lang.String"));
          }
        }
        for (;;)
        {
          str = paramJSONObject.optString("wakeup-words", "小度小度");
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_WAKEUP_WORDS_STRING, BDSParamBase.objectParam(str, "java.lang.String"));
          i = paramJSONObject.optInt("wakeup-status", 0);
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_WAKEUP_STATUS_INT, BDSParamBase.intParam(i));
          i = paramJSONObject.optInt("isoneshot", 0);
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_IS_ONESHOT_INT, BDSParamBase.intParam(i));
          i = paramJSONObject.optInt("backtrack-time");
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_BACKTRACK_TIME_INT, BDSParamBase.intParam(i));
          this.mOutFile = paramJSONObject.optString("audio.outfile", paramJSONObject.optString("outfile"));
          this.mEnableLogFeedBack = paramJSONObject.optBoolean("feedback-log", false);
          this.mFeedBackAudio = paramJSONObject.optBoolean("accept-audio-data", false);
          if (this.mFeedBackAudio) {
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_ACCEPT_AUDIO_DATA, BDSParamBase.boolParam(this.mFeedBackAudio));
          }
          try
          {
            i = this.m_ASRcore.postMessage(localBDSMessage);
            if (i != 0)
            {
              paramBDSErrorDescription = new BDSErrorDescription();
              paramBDSErrorDescription.errorCode = -2;
              paramBDSErrorDescription.errorDomain = 1;
              paramBDSErrorDescription.errorDescription = ("JNI: initConfig Call to Native layer returned error! err( " + i + " )");
            }
            return paramBDSErrorDescription;
          }
          catch (Throwable paramBDSErrorDescription)
          {
            label3335:
            label3341:
            label3347:
            label3353:
            paramBDSErrorDescription.printStackTrace();
            paramBDSErrorDescription = new BDSErrorDescription();
            paramBDSErrorDescription.errorCode = -2;
            paramBDSErrorDescription.errorDomain = 1;
            paramBDSErrorDescription.errorDescription = "JNI: initConfig Call to Native layer returned error! err";
          }
          if (((Vector)localObject3).size() > 0)
          {
            localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_PROPERTY_LIST, BDSParamBase.objectParam(localObject3, "java.util.Vector;"));
            break;
          }
          localObject1 = new Vector();
          ((Vector)localObject1).add(Integer.valueOf(10005));
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_PROPERTY_LIST, BDSParamBase.objectParam(localObject1, "java.util.Vector;"));
          break;
          bool = false;
          break label2374;
          i = 1;
          break label2444;
          bool = false;
          break label2515;
          localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_STRATEGY, BDSParamBase.intParam(j));
        }
      }
    }
    return paramBDSErrorDescription;
  }
  
  private void initGrammer(final String paramString)
    throws Exception
  {
    Object localObject3 = new JSONObject(paramString);
    Object localObject2 = ((JSONObject)localObject3).optString("grammar");
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      return;
      final Object localObject1 = (JSONObject)this.mOriginNlp.get(localObject2);
      paramString = (String)localObject1;
      if (localObject1 == null) {}
      try
      {
        paramString = this.mEventContext.loadJsonFromUri((String)localObject2, false, true);
        if (paramString != null) {}
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          try
          {
            localObject1 = this.mEventContext.loadJsonFromUri((String)localObject2, false, false);
            paramString = (String)localObject1;
            if ((paramString != null) && (this.mOriginNlp.get(localObject2) == null)) {
              this.mOriginNlp.put(localObject2, paramString);
            }
            if (paramString == null) {
              break;
            }
            localObject2 = ((JSONObject)localObject3).optJSONObject("slot-data");
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject3 = ((JSONObject)localObject3).optString("slot-data");
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject1 = new JSONObject((String)localObject3);
              }
            }
            this.nlpFeature = this.nluBuilderThread.submit(new Callable()
            {
              public JSONObject call()
                throws Exception
              {
                ASREngine.resetNlpGrammar(ASREngine.this.mEventContext, paramString, localObject1);
                return paramString;
              }
            });
            return;
          }
          catch (Exception localException)
          {
            Log.i("ASREngine", "bad grammar(as text): " + (String)localObject2);
          }
          paramString = paramString;
          Log.i("ASREngine", "bad grammar(as base64): " + (String)localObject2);
          paramString = (String)localObject1;
        }
      }
    }
  }
  
  private boolean isIllegalResult(String paramString)
  {
    return (paramString != null) && (paramString.contains("1。00。"));
  }
  
  private void loadGrammar(String paramString)
  {
    int j = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      i = j;
      if (localJSONObject != null) {
        if (!"enable".equals(localJSONObject.optString("nlu")))
        {
          boolean bool = "enable-all".equals(localJSONObject.optString("nlu"));
          i = j;
          if (!bool) {}
        }
        else
        {
          i = 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          initGrammer(paramString);
          return;
        }
        catch (Exception paramString)
        {
          int i;
          paramString.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
        i = j;
      }
    }
    if (i != 0) {}
  }
  
  /* Error */
  private String loadSourceFromUri(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: ldc_w 529
    //   8: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +7 -> 18
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_3
    //   17: areturn
    //   18: aload_1
    //   19: astore_3
    //   20: new 1482	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 1483	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: invokevirtual 1486	java/io/File:exists	()Z
    //   31: ifne -15 -> 16
    //   34: ldc_w 1488
    //   37: invokestatic 970	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   40: aload_1
    //   41: invokevirtual 974	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   44: astore_3
    //   45: aload_3
    //   46: invokevirtual 979	java/util/regex/Matcher:find	()Z
    //   49: ifeq +320 -> 369
    //   52: aload_3
    //   53: iconst_1
    //   54: invokevirtual 1003	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   57: astore_1
    //   58: aload_3
    //   59: iconst_2
    //   60: invokevirtual 1003	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   63: astore_3
    //   64: aload_1
    //   65: ldc_w 1490
    //   68: invokevirtual 1493	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   71: ifeq +60 -> 131
    //   74: new 1495	java/io/FileInputStream
    //   77: dup
    //   78: aload_3
    //   79: invokespecial 1496	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   82: astore_1
    //   83: aload_1
    //   84: ifnonnull +138 -> 222
    //   87: new 901	java/io/IOException
    //   90: dup
    //   91: ldc_w 1498
    //   94: invokespecial 1499	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   97: athrow
    //   98: astore 6
    //   100: aconst_null
    //   101: astore_3
    //   102: aload_3
    //   103: astore 5
    //   105: aload_1
    //   106: astore 4
    //   108: aload 6
    //   110: invokevirtual 822	java/lang/Exception:printStackTrace	()V
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 1502	java/io/InputStream:close	()V
    //   121: aload_3
    //   122: ifnull +7 -> 129
    //   125: aload_3
    //   126: invokevirtual 1505	java/io/RandomAccessFile:close	()V
    //   129: aconst_null
    //   130: areturn
    //   131: aload_1
    //   132: ldc_w 1507
    //   135: invokevirtual 1493	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   138: ifne +13 -> 151
    //   141: aload_1
    //   142: ldc_w 1509
    //   145: invokevirtual 1493	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   148: ifeq +52 -> 200
    //   151: aload_3
    //   152: ldc_w 1304
    //   155: invokevirtual 1512	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   158: ifeq +337 -> 495
    //   161: ldc_w 529
    //   164: astore_1
    //   165: aload_0
    //   166: invokevirtual 1516	java/lang/Object:getClass	()Ljava/lang/Class;
    //   169: new 688	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 689	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1518
    //   179: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_1
    //   183: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_3
    //   187: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 697	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 1524	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   196: astore_1
    //   197: goto -114 -> 83
    //   200: aload_1
    //   201: ldc_w 1526
    //   204: invokevirtual 1493	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   207: ifeq +283 -> 490
    //   210: aload_0
    //   211: invokevirtual 1516	java/lang/Object:getClass	()Ljava/lang/Class;
    //   214: aload_3
    //   215: invokevirtual 1524	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   218: astore_1
    //   219: goto -136 -> 83
    //   222: sipush 1024
    //   225: newarray <illegal type>
    //   227: astore 6
    //   229: new 1482	java/io/File
    //   232: dup
    //   233: new 688	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 689	java/lang/StringBuilder:<init>	()V
    //   240: aload_0
    //   241: getfield 527	com/baidu/speech/core/ASREngine:mContext	Landroid/content/Context;
    //   244: invokevirtual 1530	android/content/Context:getFilesDir	()Ljava/io/File;
    //   247: invokevirtual 1533	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   250: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_3
    //   254: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 697	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokespecial 1483	java/io/File:<init>	(Ljava/lang/String;)V
    //   263: astore_3
    //   264: new 1504	java/io/RandomAccessFile
    //   267: dup
    //   268: aload_3
    //   269: ldc_w 1535
    //   272: invokespecial 1538	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   275: astore 7
    //   277: aload 7
    //   279: astore 5
    //   281: aload_1
    //   282: astore 4
    //   284: aload_1
    //   285: aload 6
    //   287: invokevirtual 1542	java/io/InputStream:read	([B)I
    //   290: istore_2
    //   291: iload_2
    //   292: ifle +22 -> 314
    //   295: aload 7
    //   297: astore 5
    //   299: aload_1
    //   300: astore 4
    //   302: aload 7
    //   304: aload 6
    //   306: iconst_0
    //   307: iload_2
    //   308: invokevirtual 1545	java/io/RandomAccessFile:write	([BII)V
    //   311: goto -34 -> 277
    //   314: aload 7
    //   316: astore 5
    //   318: aload_1
    //   319: astore 4
    //   321: aload_3
    //   322: invokevirtual 1533	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   325: astore_3
    //   326: aload_3
    //   327: astore 4
    //   329: aload_1
    //   330: ifnull +7 -> 337
    //   333: aload_1
    //   334: invokevirtual 1502	java/io/InputStream:close	()V
    //   337: aload 4
    //   339: astore_3
    //   340: aload 7
    //   342: ifnull -326 -> 16
    //   345: aload 7
    //   347: invokevirtual 1505	java/io/RandomAccessFile:close	()V
    //   350: aload 4
    //   352: areturn
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   358: aload 4
    //   360: areturn
    //   361: astore_1
    //   362: aload_1
    //   363: invokevirtual 822	java/lang/Exception:printStackTrace	()V
    //   366: goto -29 -> 337
    //   369: iconst_0
    //   370: ifeq +11 -> 381
    //   373: new 1547	java/lang/NullPointerException
    //   376: dup
    //   377: invokespecial 1548	java/lang/NullPointerException:<init>	()V
    //   380: athrow
    //   381: iconst_0
    //   382: ifeq -253 -> 129
    //   385: new 1547	java/lang/NullPointerException
    //   388: dup
    //   389: invokespecial 1548	java/lang/NullPointerException:<init>	()V
    //   392: athrow
    //   393: astore_1
    //   394: aload_1
    //   395: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   398: goto -269 -> 129
    //   401: astore_1
    //   402: aload_1
    //   403: invokevirtual 822	java/lang/Exception:printStackTrace	()V
    //   406: goto -25 -> 381
    //   409: astore_1
    //   410: aload_1
    //   411: invokevirtual 822	java/lang/Exception:printStackTrace	()V
    //   414: goto -293 -> 121
    //   417: astore_1
    //   418: aload_1
    //   419: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   422: goto -293 -> 129
    //   425: astore_3
    //   426: aconst_null
    //   427: astore 5
    //   429: aconst_null
    //   430: astore_1
    //   431: aload_1
    //   432: ifnull +7 -> 439
    //   435: aload_1
    //   436: invokevirtual 1502	java/io/InputStream:close	()V
    //   439: aload 5
    //   441: ifnull +8 -> 449
    //   444: aload 5
    //   446: invokevirtual 1505	java/io/RandomAccessFile:close	()V
    //   449: aload_3
    //   450: athrow
    //   451: astore_1
    //   452: aload_1
    //   453: invokevirtual 822	java/lang/Exception:printStackTrace	()V
    //   456: goto -17 -> 439
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   464: goto -15 -> 449
    //   467: astore_3
    //   468: aconst_null
    //   469: astore 5
    //   471: goto -40 -> 431
    //   474: astore_3
    //   475: aload 4
    //   477: astore_1
    //   478: goto -47 -> 431
    //   481: astore 6
    //   483: aconst_null
    //   484: astore_3
    //   485: aconst_null
    //   486: astore_1
    //   487: goto -385 -> 102
    //   490: aconst_null
    //   491: astore_1
    //   492: goto -409 -> 83
    //   495: ldc_w 1304
    //   498: astore_1
    //   499: goto -334 -> 165
    //   502: astore 6
    //   504: aload 7
    //   506: astore_3
    //   507: goto -405 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	this	ASREngine
    //   0	510	1	paramString	String
    //   290	18	2	i	int
    //   15	325	3	localObject1	Object
    //   425	25	3	localObject2	Object
    //   467	1	3	localObject3	Object
    //   474	1	3	localObject4	Object
    //   484	23	3	localObject5	Object
    //   106	370	4	localObject6	Object
    //   103	367	5	localObject7	Object
    //   98	11	6	localException1	Exception
    //   227	78	6	arrayOfByte	byte[]
    //   481	1	6	localException2	Exception
    //   502	1	6	localException3	Exception
    //   275	230	7	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   87	98	98	java/lang/Exception
    //   222	277	98	java/lang/Exception
    //   345	350	353	java/io/IOException
    //   333	337	361	java/lang/Exception
    //   385	393	393	java/io/IOException
    //   373	381	401	java/lang/Exception
    //   117	121	409	java/lang/Exception
    //   125	129	417	java/io/IOException
    //   34	83	425	finally
    //   131	151	425	finally
    //   151	161	425	finally
    //   165	197	425	finally
    //   200	219	425	finally
    //   435	439	451	java/lang/Exception
    //   444	449	459	java/io/IOException
    //   87	98	467	finally
    //   222	277	467	finally
    //   108	113	474	finally
    //   284	291	474	finally
    //   302	311	474	finally
    //   321	326	474	finally
    //   34	83	481	java/lang/Exception
    //   131	151	481	java/lang/Exception
    //   151	161	481	java/lang/Exception
    //   165	197	481	java/lang/Exception
    //   200	219	481	java/lang/Exception
    //   284	291	502	java/lang/Exception
    //   302	311	502	java/lang/Exception
    //   321	326	502	java/lang/Exception
  }
  
  private int parseDecoder(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("basic.decoder", paramString.optInt("decoder"));
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  /* Error */
  private void play(Context paramContext, Object paramObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: instanceof 765
    //   9: ifeq +22 -> 31
    //   12: aload_2
    //   13: checkcast 765	java/lang/Integer
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull -16 -> 4
    //   23: aload 4
    //   25: invokevirtual 1554	java/lang/Integer:intValue	()I
    //   28: ifle -24 -> 4
    //   31: new 688	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 689	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 529
    //   41: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_2
    //   45: invokevirtual 1557	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 697	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_2
    //   52: aload_2
    //   53: ldc_w 1559
    //   56: invokevirtual 1562	java/lang/String:matches	(Ljava/lang/String;)Z
    //   59: ifeq +104 -> 163
    //   62: getstatic 518	com/baidu/speech/core/ASREngine:player	Landroid/media/MediaPlayer;
    //   65: invokevirtual 1565	android/media/MediaPlayer:reset	()V
    //   68: aload_1
    //   69: invokevirtual 1569	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   72: aload_2
    //   73: invokestatic 1572	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   76: invokevirtual 1578	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   79: astore_1
    //   80: getstatic 518	com/baidu/speech/core/ASREngine:player	Landroid/media/MediaPlayer;
    //   83: aload_1
    //   84: invokevirtual 1584	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   87: aload_1
    //   88: invokevirtual 1588	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   91: aload_1
    //   92: invokevirtual 1591	android/content/res/AssetFileDescriptor:getLength	()J
    //   95: invokevirtual 1595	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   98: aload_1
    //   99: invokevirtual 1596	android/content/res/AssetFileDescriptor:close	()V
    //   102: aload_0
    //   103: getfield 555	com/baidu/speech/core/ASREngine:mStreamType	I
    //   106: iflt +13 -> 119
    //   109: getstatic 518	com/baidu/speech/core/ASREngine:player	Landroid/media/MediaPlayer;
    //   112: aload_0
    //   113: getfield 555	com/baidu/speech/core/ASREngine:mStreamType	I
    //   116: invokevirtual 1600	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   119: getstatic 518	com/baidu/speech/core/ASREngine:player	Landroid/media/MediaPlayer;
    //   122: invokevirtual 1603	android/media/MediaPlayer:prepare	()V
    //   125: getstatic 518	com/baidu/speech/core/ASREngine:player	Landroid/media/MediaPlayer;
    //   128: invokevirtual 1604	android/media/MediaPlayer:start	()V
    //   131: iload_3
    //   132: ifeq -128 -> 4
    //   135: getstatic 518	com/baidu/speech/core/ASREngine:player	Landroid/media/MediaPlayer;
    //   138: invokevirtual 1607	android/media/MediaPlayer:isPlaying	()Z
    //   141: ifeq -137 -> 4
    //   144: lconst_1
    //   145: invokestatic 1611	java/lang/Thread:sleep	(J)V
    //   148: goto -13 -> 135
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 1612	java/lang/InterruptedException:printStackTrace	()V
    //   156: return
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 822	java/lang/Exception:printStackTrace	()V
    //   162: return
    //   163: getstatic 518	com/baidu/speech/core/ASREngine:player	Landroid/media/MediaPlayer;
    //   166: invokevirtual 1565	android/media/MediaPlayer:reset	()V
    //   169: getstatic 518	com/baidu/speech/core/ASREngine:player	Landroid/media/MediaPlayer;
    //   172: aload_1
    //   173: aload_2
    //   174: invokestatic 1618	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   177: invokevirtual 1621	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   180: aload_0
    //   181: getfield 555	com/baidu/speech/core/ASREngine:mStreamType	I
    //   184: iflt +13 -> 197
    //   187: getstatic 518	com/baidu/speech/core/ASREngine:player	Landroid/media/MediaPlayer;
    //   190: aload_0
    //   191: getfield 555	com/baidu/speech/core/ASREngine:mStreamType	I
    //   194: invokevirtual 1600	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   197: getstatic 518	com/baidu/speech/core/ASREngine:player	Landroid/media/MediaPlayer;
    //   200: invokevirtual 1603	android/media/MediaPlayer:prepare	()V
    //   203: goto -78 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	ASREngine
    //   0	206	1	paramContext	Context
    //   0	206	2	paramObject	Object
    //   0	206	3	paramBoolean	boolean
    //   16	8	4	localInteger	Integer
    // Exception table:
    //   from	to	target	type
    //   135	148	151	java/lang/InterruptedException
    //   31	119	157	java/lang/Exception
    //   119	125	157	java/lang/Exception
    //   125	131	157	java/lang/Exception
    //   135	148	157	java/lang/Exception
    //   152	156	157	java/lang/Exception
    //   163	197	157	java/lang/Exception
    //   197	203	157	java/lang/Exception
  }
  
  private BDSErrorDescription postEvent(BDSErrorDescription paramBDSErrorDescription, String paramString)
  {
    Object localObject = new BDSMessage();
    ((BDSMessage)localObject).m_messageName = paramString;
    ((BDSMessage)localObject).m_messageParams = new HashMap();
    ((BDSMessage)localObject).m_messageParams.put(ASR_PARAM_KEY_PLATFORM, BDSParamBase.objectParam(this.mPlatform, "java.lang.String"));
    ((BDSMessage)localObject).m_messageParams.put(ASR_PARAM_KEY_SDK_VERSION, BDSParamBase.objectParam(this.mVersion, "java.lang.String"));
    ((BDSMessage)localObject).m_messageParams.put(ASR_PARAM_KEY_APP, BDSParamBase.objectParam(this.mApp, "java.lang.String"));
    ((BDSMessage)localObject).m_messageParams.put(ASR_PARAM_KEY_NETWORK_STATUS, BDSParamBase.intParam(Utility.getWifiOr2gOr3G(this.mContext)));
    if (((paramString.equals(ASR_CMD_START)) || (paramString.equals(ASR_CMD_STOP)) || (paramString.equals(ASR_CMD_CANCEL))) && (this.mUserData != null))
    {
      ((BDSMessage)localObject).m_messageParams.put(ASR_PARAM_KEY_REALTIME_DATA, BDSParamBase.objectParam(this.mUserData, "java.lang.String"));
      this.mUserData = null;
    }
    if (paramString.equals(ASR_CMD_CONFIG)) {
      ((BDSMessage)localObject).m_messageParams.put(ASR_PARAM_KEY_VAD_ENABLE_LONG_PRESS, BDSParamBase.boolParam(this.mEnableLongPress));
    }
    LogUtil.i("ASREngine", new String[] { " cmd:" + paramString + " msg:" + ((BDSMessage)localObject).toString() });
    do
    {
      try
      {
        int i = this.m_ASRcore.postMessage((BDSMessage)localObject);
        if (i != 0)
        {
          localObject = new BDSErrorDescription();
          ((BDSErrorDescription)localObject).errorCode = -2;
          ((BDSErrorDescription)localObject).errorDomain = 1;
          ((BDSErrorDescription)localObject).errorDescription = ("JNI: readyParamsAsrStart Call to Native layer returned error! err( " + i + " )");
          return (BDSErrorDescription)localObject;
        }
      }
      catch (Throwable paramBDSErrorDescription)
      {
        paramBDSErrorDescription.printStackTrace();
        paramBDSErrorDescription = new BDSErrorDescription();
        paramBDSErrorDescription.errorCode = -2;
        paramBDSErrorDescription.errorDomain = 1;
        paramBDSErrorDescription.errorDescription = "JNI: readyParamsAsrStart Call to Native layer returned error! err";
        return paramBDSErrorDescription;
      }
      if (paramString.equals(ASR_CMD_START)) {
        this.mIsWorking = true;
      }
      localObject = paramBDSErrorDescription;
    } while (!paramString.equals(ASR_CMD_CANCEL));
    this.mIsWorking = false;
    return paramBDSErrorDescription;
  }
  
  private static void resetNlpGrammar(EventContext paramEventContext, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
    throws JSONException
  {
    System.currentTimeMillis();
    Object localObject3;
    if (paramJSONObject2 != null)
    {
      localObject1 = paramJSONObject1.getJSONObject("slots");
      localObject2 = paramJSONObject2.keys();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        ((JSONObject)localObject1).put((String)localObject3, paramJSONObject2.getJSONArray((String)localObject3));
      }
    }
    paramJSONObject2 = new HashMap();
    Object localObject1 = paramJSONObject1.getJSONObject("slots");
    Object localObject2 = ((JSONObject)localObject1).keys();
    Object localObject4;
    Object localObject5;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = ((JSONObject)localObject1).getJSONArray((String)localObject3);
      localObject5 = new ArrayList();
      i = 0;
      if (i < ((JSONArray)localObject4).length())
      {
        String str = ((JSONArray)localObject4).getString(i);
        if (str.equals(".+")) {
          ((ArrayList)localObject5).add(str);
        }
        for (;;)
        {
          i += 1;
          break;
          ((ArrayList)localObject5).add(str.replaceAll("[\000-/]|[:-@]|[\\[-`]|[{-­]", ""));
        }
      }
      localObject4 = paramEventContext.join((List)localObject5, "|");
      paramJSONObject2.put(String.format("<%s>", new Object[] { localObject3 }), String.format("(%s)", new Object[] { localObject4 }));
    }
    paramJSONObject1 = paramJSONObject1.getJSONObject("rules");
    localObject1 = paramJSONObject1.keys();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = paramJSONObject1.getJSONArray((String)((Iterator)localObject1).next());
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getJSONObject(i);
        paramEventContext = ((JSONObject)localObject3).getString("origin");
        localObject4 = paramJSONObject2.entrySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          paramEventContext = paramEventContext.replaceAll((String)((Map.Entry)localObject5).getKey(), (String)((Map.Entry)localObject5).getValue());
        }
        ((JSONObject)localObject3).put("pattern", "^" + paramEventContext + "$");
        i += 1;
      }
    }
  }
  
  /* Error */
  private void saveOutFile(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 535	com/baidu/speech/core/ASREngine:mOutFile	Ljava/lang/String;
    //   4: ifnull +50 -> 54
    //   7: aload_0
    //   8: getfield 535	com/baidu/speech/core/ASREngine:mOutFile	Ljava/lang/String;
    //   11: ldc_w 529
    //   14: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifne +37 -> 54
    //   20: aload_1
    //   21: ifnull +33 -> 54
    //   24: aconst_null
    //   25: astore_2
    //   26: new 903	java/io/FileOutputStream
    //   29: dup
    //   30: aload_0
    //   31: getfield 535	com/baidu/speech/core/ASREngine:mOutFile	Ljava/lang/String;
    //   34: iconst_1
    //   35: invokespecial 1685	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   38: astore_3
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: aload_1
    //   43: invokevirtual 913	java/io/OutputStream:write	([B)V
    //   46: aload_3
    //   47: ifnull +7 -> 54
    //   50: aload_3
    //   51: invokevirtual 916	java/io/OutputStream:close	()V
    //   54: return
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   60: return
    //   61: astore 4
    //   63: aconst_null
    //   64: astore_1
    //   65: aload_1
    //   66: astore_2
    //   67: aload 4
    //   69: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   72: aload_1
    //   73: ifnull -19 -> 54
    //   76: aload_1
    //   77: invokevirtual 916	java/io/OutputStream:close	()V
    //   80: return
    //   81: astore_1
    //   82: aload_1
    //   83: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   86: return
    //   87: astore_1
    //   88: aload_2
    //   89: ifnull +7 -> 96
    //   92: aload_2
    //   93: invokevirtual 916	java/io/OutputStream:close	()V
    //   96: aload_1
    //   97: athrow
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual 917	java/io/IOException:printStackTrace	()V
    //   103: goto -7 -> 96
    //   106: astore_1
    //   107: goto -19 -> 88
    //   110: astore 4
    //   112: aload_3
    //   113: astore_1
    //   114: goto -49 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ASREngine
    //   0	117	1	paramArrayOfByte	byte[]
    //   25	68	2	localObject	Object
    //   98	2	2	localIOException1	java.io.IOException
    //   38	75	3	localFileOutputStream	java.io.FileOutputStream
    //   61	7	4	localIOException2	java.io.IOException
    //   110	1	4	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   50	54	55	java/io/IOException
    //   26	39	61	java/io/IOException
    //   76	80	81	java/io/IOException
    //   26	39	87	finally
    //   92	96	98	java/io/IOException
    //   41	46	106	finally
    //   67	72	106	finally
    //   41	46	110	java/io/IOException
  }
  
  private void updateUserData(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.equals(""))
      {
        this.mUserData = null;
        return;
      }
      this.mUserData = new JSONObject(paramString).optString("realtime-data");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.mUserData = null;
    }
  }
  
  /* Error */
  public BDSErrorDescription postEvent(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc -116
    //   5: iconst_1
    //   6: anewarray 682	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: new 688	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 689	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1691
    //   21: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 1693
    //   31: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 697	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: aastore
    //   42: invokestatic 703	com/baidu/speech/utils/LogUtil:i	(Ljava/lang/String;[Ljava/lang/String;)V
    //   45: aload_1
    //   46: ifnull +13 -> 59
    //   49: aload_1
    //   50: ldc_w 529
    //   53: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +35 -> 91
    //   59: new 1431	com/baidu/speech/core/BDSErrorDescription
    //   62: dup
    //   63: invokespecial 1432	com/baidu/speech/core/BDSErrorDescription:<init>	()V
    //   66: astore 6
    //   68: aload 6
    //   70: iconst_m1
    //   71: putfield 1435	com/baidu/speech/core/BDSErrorDescription:errorCode	I
    //   74: aload 6
    //   76: iconst_1
    //   77: putfield 1438	com/baidu/speech/core/BDSErrorDescription:errorDomain	I
    //   80: aload 6
    //   82: ldc_w 1695
    //   85: putfield 1445	com/baidu/speech/core/BDSErrorDescription:errorDescription	Ljava/lang/String;
    //   88: aload 6
    //   90: areturn
    //   91: aload_1
    //   92: getstatic 193	com/baidu/speech/core/ASREngine:ASR_CMD_START	Ljava/lang/String;
    //   95: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   98: ifeq +368 -> 466
    //   101: aload_0
    //   102: getfield 551	com/baidu/speech/core/ASREngine:mIsWorking	Z
    //   105: ifeq +29 -> 134
    //   108: aload_0
    //   109: getfield 1697	com/baidu/speech/core/ASREngine:mListener	Lcom/baidu/speech/asr/ASRListener;
    //   112: ldc_w 818
    //   115: aload_0
    //   116: sipush 8001
    //   119: invokespecial 607	com/baidu/speech/core/ASREngine:generateErrorResult	(I)Ljava/lang/String;
    //   122: aconst_null
    //   123: iconst_0
    //   124: iconst_0
    //   125: invokeinterface 726 6 0
    //   130: aconst_null
    //   131: areturn
    //   132: astore 5
    //   134: aload_0
    //   135: aload_2
    //   136: invokespecial 1699	com/baidu/speech/core/ASREngine:parseDecoder	(Ljava/lang/String;)I
    //   139: istore_3
    //   140: iload_3
    //   141: ifne +102 -> 243
    //   144: aload_0
    //   145: getfield 527	com/baidu/speech/core/ASREngine:mContext	Landroid/content/Context;
    //   148: invokestatic 1077	com/baidu/speech/utils/Utility:getWifiOr2gOr3G	(Landroid/content/Context;)I
    //   151: ifne +92 -> 243
    //   154: new 638	org/json/JSONObject
    //   157: dup
    //   158: aload_2
    //   159: invokespecial 639	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   162: astore 5
    //   164: aload 5
    //   166: ifnull +24 -> 190
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 527	com/baidu/speech/core/ASREngine:mContext	Landroid/content/Context;
    //   174: aload 5
    //   176: ldc_w 807
    //   179: iconst_m1
    //   180: invokevirtual 763	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   183: invokestatic 769	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: iconst_0
    //   187: invokespecial 773	com/baidu/speech/core/ASREngine:play	(Landroid/content/Context;Ljava/lang/Object;Z)V
    //   190: aload_0
    //   191: getfield 1697	com/baidu/speech/core/ASREngine:mListener	Lcom/baidu/speech/asr/ASRListener;
    //   194: ldc_w 818
    //   197: aload_0
    //   198: sipush 2100
    //   201: invokespecial 607	com/baidu/speech/core/ASREngine:generateErrorResult	(I)Ljava/lang/String;
    //   204: aconst_null
    //   205: iconst_0
    //   206: iconst_0
    //   207: invokeinterface 726 6 0
    //   212: aload_0
    //   213: getfield 1697	com/baidu/speech/core/ASREngine:mListener	Lcom/baidu/speech/asr/ASRListener;
    //   216: ldc_w 898
    //   219: aload_0
    //   220: sipush 2100
    //   223: invokespecial 607	com/baidu/speech/core/ASREngine:generateErrorResult	(I)Ljava/lang/String;
    //   226: aconst_null
    //   227: iconst_0
    //   228: iconst_0
    //   229: invokeinterface 726 6 0
    //   234: aload_0
    //   235: iconst_0
    //   236: putfield 551	com/baidu/speech/core/ASREngine:mIsWorking	Z
    //   239: aconst_null
    //   240: areturn
    //   241: astore 5
    //   243: aload_0
    //   244: getfield 527	com/baidu/speech/core/ASREngine:mContext	Landroid/content/Context;
    //   247: ldc_w 1701
    //   250: invokestatic 1705	com/baidu/speech/utils/Utility:checkPermission	(Landroid/content/Context;Ljava/lang/String;)Z
    //   253: ifne +97 -> 350
    //   256: new 638	org/json/JSONObject
    //   259: dup
    //   260: aload_2
    //   261: invokespecial 639	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   264: astore 5
    //   266: aload 5
    //   268: ifnull +24 -> 292
    //   271: aload_0
    //   272: aload_0
    //   273: getfield 527	com/baidu/speech/core/ASREngine:mContext	Landroid/content/Context;
    //   276: aload 5
    //   278: ldc_w 807
    //   281: iconst_m1
    //   282: invokevirtual 763	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   285: invokestatic 769	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: iconst_0
    //   289: invokespecial 773	com/baidu/speech/core/ASREngine:play	(Landroid/content/Context;Ljava/lang/Object;Z)V
    //   292: aload_0
    //   293: getfield 1697	com/baidu/speech/core/ASREngine:mListener	Lcom/baidu/speech/asr/ASRListener;
    //   296: ldc_w 818
    //   299: aload_0
    //   300: sipush 2101
    //   303: invokespecial 607	com/baidu/speech/core/ASREngine:generateErrorResult	(I)Ljava/lang/String;
    //   306: aconst_null
    //   307: iconst_0
    //   308: iconst_0
    //   309: invokeinterface 726 6 0
    //   314: aload_0
    //   315: getfield 1697	com/baidu/speech/core/ASREngine:mListener	Lcom/baidu/speech/asr/ASRListener;
    //   318: ldc_w 898
    //   321: aload_0
    //   322: sipush 2101
    //   325: invokespecial 607	com/baidu/speech/core/ASREngine:generateErrorResult	(I)Ljava/lang/String;
    //   328: aconst_null
    //   329: iconst_0
    //   330: iconst_0
    //   331: invokeinterface 726 6 0
    //   336: aload_0
    //   337: iconst_0
    //   338: putfield 551	com/baidu/speech/core/ASREngine:mIsWorking	Z
    //   341: aconst_null
    //   342: areturn
    //   343: astore 5
    //   345: aload 5
    //   347: invokevirtual 822	java/lang/Exception:printStackTrace	()V
    //   350: aload_0
    //   351: getfield 527	com/baidu/speech/core/ASREngine:mContext	Landroid/content/Context;
    //   354: ldc_w 1707
    //   357: invokestatic 1705	com/baidu/speech/utils/Utility:checkPermission	(Landroid/content/Context;Ljava/lang/String;)Z
    //   360: ifne +97 -> 457
    //   363: new 638	org/json/JSONObject
    //   366: dup
    //   367: aload_2
    //   368: invokespecial 639	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   371: astore 5
    //   373: aload 5
    //   375: ifnull +24 -> 399
    //   378: aload_0
    //   379: aload_0
    //   380: getfield 527	com/baidu/speech/core/ASREngine:mContext	Landroid/content/Context;
    //   383: aload 5
    //   385: ldc_w 807
    //   388: iconst_m1
    //   389: invokevirtual 763	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   392: invokestatic 769	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: iconst_0
    //   396: invokespecial 773	com/baidu/speech/core/ASREngine:play	(Landroid/content/Context;Ljava/lang/Object;Z)V
    //   399: aload_0
    //   400: getfield 1697	com/baidu/speech/core/ASREngine:mListener	Lcom/baidu/speech/asr/ASRListener;
    //   403: ldc_w 818
    //   406: aload_0
    //   407: sipush 9001
    //   410: invokespecial 607	com/baidu/speech/core/ASREngine:generateErrorResult	(I)Ljava/lang/String;
    //   413: aconst_null
    //   414: iconst_0
    //   415: iconst_0
    //   416: invokeinterface 726 6 0
    //   421: aload_0
    //   422: getfield 1697	com/baidu/speech/core/ASREngine:mListener	Lcom/baidu/speech/asr/ASRListener;
    //   425: ldc_w 898
    //   428: aload_0
    //   429: sipush 9001
    //   432: invokespecial 607	com/baidu/speech/core/ASREngine:generateErrorResult	(I)Ljava/lang/String;
    //   435: aconst_null
    //   436: iconst_0
    //   437: iconst_0
    //   438: invokeinterface 726 6 0
    //   443: aload_0
    //   444: iconst_0
    //   445: putfield 551	com/baidu/speech/core/ASREngine:mIsWorking	Z
    //   448: aconst_null
    //   449: areturn
    //   450: astore 5
    //   452: aload 5
    //   454: invokevirtual 822	java/lang/Exception:printStackTrace	()V
    //   457: iload_3
    //   458: ifne +8 -> 466
    //   461: aload_0
    //   462: aload_2
    //   463: invokespecial 1709	com/baidu/speech/core/ASREngine:loadGrammar	(Ljava/lang/String;)V
    //   466: aload_1
    //   467: getstatic 193	com/baidu/speech/core/ASREngine:ASR_CMD_START	Ljava/lang/String;
    //   470: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   473: ifne +23 -> 496
    //   476: aload_1
    //   477: getstatic 197	com/baidu/speech/core/ASREngine:ASR_CMD_STOP	Ljava/lang/String;
    //   480: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   483: ifne +13 -> 496
    //   486: aload_1
    //   487: getstatic 201	com/baidu/speech/core/ASREngine:ASR_CMD_CANCEL	Ljava/lang/String;
    //   490: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   493: ifeq +8 -> 501
    //   496: aload_0
    //   497: aload_2
    //   498: invokespecial 1711	com/baidu/speech/core/ASREngine:updateUserData	(Ljava/lang/String;)V
    //   501: aload_1
    //   502: getstatic 193	com/baidu/speech/core/ASREngine:ASR_CMD_START	Ljava/lang/String;
    //   505: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   508: ifne +13 -> 521
    //   511: aload_1
    //   512: getstatic 205	com/baidu/speech/core/ASREngine:ASR_CMD_LOAD_ENGINE	Ljava/lang/String;
    //   515: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   518: ifeq +237 -> 755
    //   521: aload_0
    //   522: new 638	org/json/JSONObject
    //   525: dup
    //   526: aload_2
    //   527: invokespecial 639	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   530: putfield 757	com/baidu/speech/core/ASREngine:mParams	Lorg/json/JSONObject;
    //   533: aload_1
    //   534: getstatic 193	com/baidu/speech/core/ASREngine:ASR_CMD_START	Ljava/lang/String;
    //   537: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   540: ifeq +198 -> 738
    //   543: aload_0
    //   544: getfield 757	com/baidu/speech/core/ASREngine:mParams	Lorg/json/JSONObject;
    //   547: ldc_w 1713
    //   550: iconst_1
    //   551: invokevirtual 1238	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   554: istore 4
    //   556: aload_0
    //   557: aload_0
    //   558: getfield 527	com/baidu/speech/core/ASREngine:mContext	Landroid/content/Context;
    //   561: aload_0
    //   562: getfield 757	com/baidu/speech/core/ASREngine:mParams	Lorg/json/JSONObject;
    //   565: ldc_w 1715
    //   568: iconst_m1
    //   569: invokevirtual 763	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   572: invokestatic 769	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   575: iload 4
    //   577: invokespecial 773	com/baidu/speech/core/ASREngine:play	(Landroid/content/Context;Ljava/lang/Object;Z)V
    //   580: aload_0
    //   581: getfield 757	com/baidu/speech/core/ASREngine:mParams	Lorg/json/JSONObject;
    //   584: ldc_w 1226
    //   587: invokevirtual 651	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   590: ifne +58 -> 648
    //   593: aload_0
    //   594: getfield 757	com/baidu/speech/core/ASREngine:mParams	Lorg/json/JSONObject;
    //   597: ldc_w 1222
    //   600: invokevirtual 1005	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   603: astore 5
    //   605: aload_0
    //   606: getfield 757	com/baidu/speech/core/ASREngine:mParams	Lorg/json/JSONObject;
    //   609: ldc_w 1717
    //   612: invokevirtual 651	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   615: ifeq +233 -> 848
    //   618: aload_0
    //   619: getfield 757	com/baidu/speech/core/ASREngine:mParams	Lorg/json/JSONObject;
    //   622: ldc_w 1717
    //   625: invokevirtual 1228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   628: istore_3
    //   629: aload 5
    //   631: iload_3
    //   632: invokestatic 1722	com/baidu/speech/audio/MicrophoneServer:create	(Ljava/lang/String;I)I
    //   635: istore_3
    //   636: aload_0
    //   637: getfield 757	com/baidu/speech/core/ASREngine:mParams	Lorg/json/JSONObject;
    //   640: ldc_w 1226
    //   643: iload_3
    //   644: invokevirtual 812	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   647: pop
    //   648: aload_0
    //   649: aconst_null
    //   650: aload_0
    //   651: getfield 757	com/baidu/speech/core/ASREngine:mParams	Lorg/json/JSONObject;
    //   654: invokespecial 1724	com/baidu/speech/core/ASREngine:initConfig	(Lcom/baidu/speech/core/BDSErrorDescription;Lorg/json/JSONObject;)Lcom/baidu/speech/core/BDSErrorDescription;
    //   657: astore 5
    //   659: aload 5
    //   661: astore 6
    //   663: aload_1
    //   664: getstatic 193	com/baidu/speech/core/ASREngine:ASR_CMD_START	Ljava/lang/String;
    //   667: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   670: ifeq +11 -> 681
    //   673: aload 5
    //   675: astore 6
    //   677: aload_0
    //   678: invokespecial 1726	com/baidu/speech/core/ASREngine:clearOutFile	()V
    //   681: aload 5
    //   683: astore 6
    //   685: aload_0
    //   686: getfield 549	com/baidu/speech/core/ASREngine:mExceptioned	Z
    //   689: istore 4
    //   691: aload 5
    //   693: astore 6
    //   695: iload 4
    //   697: ifne -609 -> 88
    //   700: aload 5
    //   702: astore 6
    //   704: aload 5
    //   706: ifnull +52 -> 758
    //   709: aload 5
    //   711: areturn
    //   712: astore 5
    //   714: aload_0
    //   715: new 638	org/json/JSONObject
    //   718: dup
    //   719: invokespecial 774	org/json/JSONObject:<init>	()V
    //   722: putfield 757	com/baidu/speech/core/ASREngine:mParams	Lorg/json/JSONObject;
    //   725: goto -192 -> 533
    //   728: astore 5
    //   730: aload 5
    //   732: invokevirtual 822	java/lang/Exception:printStackTrace	()V
    //   735: goto -87 -> 648
    //   738: aload_0
    //   739: aload_2
    //   740: invokespecial 1709	com/baidu/speech/core/ASREngine:loadGrammar	(Ljava/lang/String;)V
    //   743: goto -95 -> 648
    //   746: astore 5
    //   748: aload 6
    //   750: astore 5
    //   752: goto -52 -> 700
    //   755: aconst_null
    //   756: astore 6
    //   758: aload_1
    //   759: getstatic 189	com/baidu/speech/core/ASREngine:ASR_CMD_CONFIG	Ljava/lang/String;
    //   762: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   765: ifeq +47 -> 812
    //   768: aload_2
    //   769: ifnull +13 -> 782
    //   772: aload_2
    //   773: ldc_w 529
    //   776: invokevirtual 686	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   779: ifeq +41 -> 820
    //   782: new 638	org/json/JSONObject
    //   785: dup
    //   786: invokespecial 774	org/json/JSONObject:<init>	()V
    //   789: astore_2
    //   790: aload_2
    //   791: ldc_w 259
    //   794: invokevirtual 651	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   797: ifeq +15 -> 812
    //   800: aload_0
    //   801: aload_2
    //   802: ldc_w 259
    //   805: iconst_1
    //   806: invokevirtual 1238	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   809: putfield 547	com/baidu/speech/core/ASREngine:mEnableLongPress	Z
    //   812: aload_0
    //   813: aload 6
    //   815: aload_1
    //   816: invokespecial 1728	com/baidu/speech/core/ASREngine:postEvent	(Lcom/baidu/speech/core/BDSErrorDescription;Ljava/lang/String;)Lcom/baidu/speech/core/BDSErrorDescription;
    //   819: areturn
    //   820: new 638	org/json/JSONObject
    //   823: dup
    //   824: aload_2
    //   825: invokespecial 639	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   828: astore_2
    //   829: goto -39 -> 790
    //   832: astore_2
    //   833: aload_2
    //   834: invokevirtual 822	java/lang/Exception:printStackTrace	()V
    //   837: new 638	org/json/JSONObject
    //   840: dup
    //   841: invokespecial 774	org/json/JSONObject:<init>	()V
    //   844: astore_2
    //   845: goto -55 -> 790
    //   848: iconst_1
    //   849: istore_3
    //   850: goto -221 -> 629
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	853	0	this	ASREngine
    //   0	853	1	paramString1	String
    //   0	853	2	paramString2	String
    //   139	711	3	i	int
    //   554	142	4	bool	boolean
    //   132	1	5	localException1	Exception
    //   162	13	5	localJSONObject1	JSONObject
    //   241	1	5	localException2	Exception
    //   264	13	5	localJSONObject2	JSONObject
    //   343	3	5	localException3	Exception
    //   371	13	5	localJSONObject3	JSONObject
    //   450	3	5	localException4	Exception
    //   603	107	5	localObject1	Object
    //   712	1	5	localException5	Exception
    //   728	3	5	localException6	Exception
    //   746	1	5	localException7	Exception
    //   750	1	5	localObject2	Object
    //   1	813	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   108	130	132	java/lang/Exception
    //   154	164	241	java/lang/Exception
    //   169	190	241	java/lang/Exception
    //   190	239	241	java/lang/Exception
    //   256	266	343	java/lang/Exception
    //   271	292	343	java/lang/Exception
    //   292	341	343	java/lang/Exception
    //   363	373	450	java/lang/Exception
    //   378	399	450	java/lang/Exception
    //   399	448	450	java/lang/Exception
    //   521	533	712	java/lang/Exception
    //   580	629	728	java/lang/Exception
    //   629	648	728	java/lang/Exception
    //   648	659	746	java/lang/Exception
    //   663	673	746	java/lang/Exception
    //   677	681	746	java/lang/Exception
    //   685	691	746	java/lang/Exception
    //   772	782	832	java/lang/Exception
    //   782	790	832	java/lang/Exception
    //   820	829	832	java/lang/Exception
  }
  
  public void receiveCoreEvent(BDSMessage paramBDSMessage, BDSSDKLoader.BDSSDKInterface paramBDSSDKInterface)
  {
    if ((this.mListener != null) && (paramBDSMessage != null)) {
      asrCallBack(paramBDSMessage, this.mListener);
    }
  }
  
  public void setListener(ASRListener paramASRListener)
  {
    this.mListener = paramASRListener;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/core/ASREngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */