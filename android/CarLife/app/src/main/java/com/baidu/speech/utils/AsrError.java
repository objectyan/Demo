package com.baidu.speech.utils;

import java.util.HashMap;

public final class AsrError
{
  public static final int ERROR_ASR_ENGINE_BUSY = 8001;
  public static final int ERROR_AUDIO = 3;
  public static final int ERROR_AUDIO_FILE_CLOSE = 3010;
  public static final int ERROR_AUDIO_FILE_OPEN = 3008;
  public static final int ERROR_AUDIO_FILE_READ = 3009;
  public static final int ERROR_AUDIO_INCORRECT = 3000;
  public static final int ERROR_AUDIO_RECORDER_CLOSE = 3007;
  public static final int ERROR_AUDIO_RECORDER_NOT_AVAILABLE = 3003;
  public static final int ERROR_AUDIO_RECORDER_OPEN = 3001;
  public static final int ERROR_AUDIO_RECORDER_PARAM = 3002;
  public static final int ERROR_AUDIO_RECORDER_READ = 3006;
  public static final int ERROR_AUDIO_SAMPLE_ERROR = 3011;
  public static final int ERROR_AUDIO_VAD_INCORRECT = 3100;
  public static final int ERROR_AUDIO_VAD_NO_SPEECH = 3101;
  public static final int ERROR_AUDIO_VAD_SPEAK_TOO_SHORT = 3102;
  public static final int ERROR_CLIENT = 5;
  public static final int ERROR_CLIENT_GET_TOKEN = 5003;
  public static final int ERROR_CLIENT_NEED_HTTPS_URL = 5005;
  public static final int ERROR_CLIENT_PARAM = 5002;
  public static final int ERROR_CLIENT_RESOLVE_URL = 5004;
  public static final int ERROR_CLIENT_UNABLE_LOAD_LIBRARY = 5001;
  public static final int ERROR_INSUFFICIENT_PERMISSIONS = 9;
  public static final int ERROR_NETWORK = 2;
  public static final int ERROR_NETWORK_FAIL_AGENT_CONNECT_DOWN = 2103;
  public static final int ERROR_NETWORK_FAIL_AGENT_CONNECT_UP = 2106;
  public static final int ERROR_NETWORK_FAIL_AGENT_DATA_DOWN = 2105;
  public static final int ERROR_NETWORK_FAIL_AGENT_READ_DOWN = 2104;
  public static final int ERROR_NETWORK_FAIL_AGENT_READ_UP = 2102;
  public static final int ERROR_NETWORK_FAIL_CONNECT = 2000;
  public static final int ERROR_NETWORK_FAIL_CONNECT_DOWN = 2004;
  public static final int ERROR_NETWORK_FAIL_CONNECT_UP = 2002;
  public static final int ERROR_NETWORK_FAIL_DATA_DOWN = 2006;
  public static final int ERROR_NETWORK_FAIL_READ = 2001;
  public static final int ERROR_NETWORK_FAIL_READ_DOWN = 2005;
  public static final int ERROR_NETWORK_FAIL_READ_UP = 2003;
  public static final int ERROR_NETWORK_NOT_AVAILABLE = 2100;
  public static final int ERROR_NETWORK_NOT_GRANTED = 2101;
  public static final int ERROR_NETWORK_TIMEOUT = 1;
  public static final int ERROR_NETWORK_TIMEOUT_CONNECT = 1001;
  public static final int ERROR_NETWORK_TIMEOUT_CONNECT_DOWN = 1005;
  public static final int ERROR_NETWORK_TIMEOUT_CONNECT_UP = 1003;
  public static final int ERROR_NETWORK_TIMEOUT_DNS = 1000;
  public static final int ERROR_NETWORK_TIMEOUT_READ = 1002;
  public static final int ERROR_NETWORK_TIMEOUT_READ_DOWN = 1006;
  public static final int ERROR_NETWORK_TIMEOUT_READ_UP = 1004;
  public static final int ERROR_NO_MATCH = 7;
  public static final int ERROR_NO_MATCH_RESULT = 7001;
  public static final int ERROR_NO_RECORD_PERMISSION = 9001;
  public static final int ERROR_OFFLINE_ENGINE_FREE_FAIL = 10010;
  public static final int ERROR_OFFLINE_ENGINE_INITIAL_FAIL = 10009;
  public static final int ERROR_OFFLINE_ENGINE_NOT_SUPPORT = 10011;
  public static final int ERROR_OFFLINE_ENGINE_RESET_FAIL = 10008;
  public static final int ERROR_OFFLINE_EXCEPTION = 10001;
  public static final int ERROR_OFFLINE_INVALID_GRAMMAR = 10007;
  public static final int ERROR_OFFLINE_INVALID_LICENSE = 10003;
  public static final int ERROR_OFFLINE_INVALID_MODEL = 10006;
  public static final int ERROR_OFFLINE_NOT_INITIAL = 10005;
  public static final int ERROR_OFFLINE_NO_LICENSE = 10002;
  public static final int ERROR_OFFLINE_PARAM = 10004;
  public static final int ERROR_OFFLINE_RECOGNIZE_FAIL = 10012;
  public static final int ERROR_RECOGNIZER_BUSY = 8;
  public static final int ERROR_SERVER = 4;
  public static final int ERROR_SERVER_APP = 4004;
  public static final int ERROR_SERVER_BACKEND = 4002;
  public static final int ERROR_SERVER_PARAM = 4001;
  public static final int ERROR_SERVER_RECOGNITION = 4003;
  public static final int ERROR_SPEECH_TIMEOUT = 6;
  public static final int ERROR_SPEECH_TOO_LONG = 6001;
  public static final int ERROR_WAKEUP_ENGINE_EXCEPTION = 11001;
  public static final int ERROR_WAKEUP_ENGINE_FREE_FAIL = 11009;
  public static final int ERROR_WAKEUP_ENGINE_INITIAL_FAIL = 11006;
  public static final int ERROR_WAKEUP_ENGINE_NOT_SUPPORT = 11010;
  public static final int ERROR_WAKEUP_ENGINE_RESET_FAIL = 11008;
  public static final int ERROR_WAKEUP_EXCEPTION = 11004;
  public static final int ERROR_WAKEUP_INVALID_LICENSE = 11003;
  public static final int ERROR_WAKEUP_MEM_ALLOC_FAIL = 11007;
  public static final int ERROR_WAKEUP_MODEL_EXCEPTION = 11005;
  public static final int ERROR_WAKEUP_NO_LICENSE = 11002;
  public static final int ERROR_WAKEUP_RECOGNIZE_FAIL = 11011;
  static HashMap<Integer, String> sErrorMap = new HashMap();
  
  static
  {
    sErrorMap.put(Integer.valueOf(1000), "DNS resolve timeout");
    sErrorMap.put(Integer.valueOf(1001), "Network connect timeout");
    sErrorMap.put(Integer.valueOf(1002), "Network read timeout");
    sErrorMap.put(Integer.valueOf(1003), "Upload network connect timeout");
    sErrorMap.put(Integer.valueOf(1004), "Upload network read timeout");
    sErrorMap.put(Integer.valueOf(1005), "Download network connect timeout");
    sErrorMap.put(Integer.valueOf(1006), "Download network read timeout");
    sErrorMap.put(Integer.valueOf(2000), "Network connect failed");
    sErrorMap.put(Integer.valueOf(2001), "Network read failed");
    sErrorMap.put(Integer.valueOf(2002), "Upload network connect failed");
    sErrorMap.put(Integer.valueOf(2003), "Upload network read failed");
    sErrorMap.put(Integer.valueOf(2004), "Download network connect failed");
    sErrorMap.put(Integer.valueOf(2005), "Download network read failed");
    sErrorMap.put(Integer.valueOf(2006), "Download network data error");
    sErrorMap.put(Integer.valueOf(2106), "Agent model Upload network connect failed");
    sErrorMap.put(Integer.valueOf(2102), "Agent model Upload network read failed");
    sErrorMap.put(Integer.valueOf(2103), "Agent model Download network connect failed");
    sErrorMap.put(Integer.valueOf(2104), "Agent model Download network read failed");
    sErrorMap.put(Integer.valueOf(2105), "Agent model Download network data error");
    sErrorMap.put(Integer.valueOf(2100), "Network is not available");
    sErrorMap.put(Integer.valueOf(2101), "No internet permission");
    sErrorMap.put(Integer.valueOf(3000), "Audio is incorrect");
    sErrorMap.put(Integer.valueOf(3001), "Recorder open failed");
    sErrorMap.put(Integer.valueOf(3002), "Recorder param error");
    sErrorMap.put(Integer.valueOf(3003), "Recorder is not available");
    sErrorMap.put(Integer.valueOf(3006), "Recorder read data failed");
    sErrorMap.put(Integer.valueOf(3007), "Recorder close failed");
    sErrorMap.put(Integer.valueOf(3008), "File open failed");
    sErrorMap.put(Integer.valueOf(3009), "File read failed");
    sErrorMap.put(Integer.valueOf(3010), "File close failed");
    sErrorMap.put(Integer.valueOf(3011), "Sample error");
    sErrorMap.put(Integer.valueOf(3100), "VAD is not available");
    sErrorMap.put(Integer.valueOf(3101), "VAD detect no speech");
    sErrorMap.put(Integer.valueOf(3102), "VAD detect speech too short");
    sErrorMap.put(Integer.valueOf(4001), "Server param error");
    sErrorMap.put(Integer.valueOf(4002), "Server backend error");
    sErrorMap.put(Integer.valueOf(4003), "Server recognition error");
    sErrorMap.put(Integer.valueOf(4004), "App name unknown");
    sErrorMap.put(Integer.valueOf(5001), "Can not load so library");
    sErrorMap.put(Integer.valueOf(5002), "Client param error");
    sErrorMap.put(Integer.valueOf(5003), "Client get token error");
    sErrorMap.put(Integer.valueOf(5004), "Client resolve url error");
    sErrorMap.put(Integer.valueOf(5005), "Client need https url to ensure safety");
    sErrorMap.put(Integer.valueOf(6001), "Speech too long");
    sErrorMap.put(Integer.valueOf(7001), "No recognition result match");
    sErrorMap.put(Integer.valueOf(8001), "ASR Engine is busy");
    sErrorMap.put(Integer.valueOf(9001), "No recorder permission");
    sErrorMap.put(Integer.valueOf(10001), "Offline engine invalid");
    sErrorMap.put(Integer.valueOf(10002), "Offline engine has no license");
    sErrorMap.put(Integer.valueOf(10003), "Offline engine license invalid");
    sErrorMap.put(Integer.valueOf(10004), "Offline engine param error");
    sErrorMap.put(Integer.valueOf(10005), "Offline engine not initial");
    sErrorMap.put(Integer.valueOf(10006), "Offline engine model file invalid");
    sErrorMap.put(Integer.valueOf(10007), "Offline engine grammar file invalid");
    sErrorMap.put(Integer.valueOf(10008), "Offline engine reset fail");
    sErrorMap.put(Integer.valueOf(10009), "Offline engine initial fail");
    sErrorMap.put(Integer.valueOf(10010), "Offline engine free fail");
    sErrorMap.put(Integer.valueOf(10011), "Offline engine not support");
    sErrorMap.put(Integer.valueOf(10012), "Offline engine recognize fail");
    sErrorMap.put(Integer.valueOf(11001), "Wakeup engine invalid");
    sErrorMap.put(Integer.valueOf(11002), "Wakeup engine has no license");
    sErrorMap.put(Integer.valueOf(11003), "Wakeup engine license invalid");
    sErrorMap.put(Integer.valueOf(11004), "Wakeup exception");
    sErrorMap.put(Integer.valueOf(11005), "Wakeup engine model file invalid");
    sErrorMap.put(Integer.valueOf(11006), "Wakeup engine initial fail");
    sErrorMap.put(Integer.valueOf(11007), "Wakeup engine alloc mem fail");
    sErrorMap.put(Integer.valueOf(11008), "Wakeup engine reset fail");
    sErrorMap.put(Integer.valueOf(11009), "Wakeup engine free fail");
    sErrorMap.put(Integer.valueOf(11010), "Wakeup engine not support");
    sErrorMap.put(Integer.valueOf(11011), "Wakeup engine recognize fail");
  }
  
  public static String getDescFromCode(int paramInt)
  {
    return (String)sErrorMap.get(Integer.valueOf(paramInt));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/utils/AsrError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */