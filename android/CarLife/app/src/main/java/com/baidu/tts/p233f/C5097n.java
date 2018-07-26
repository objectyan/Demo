package com.baidu.tts.p233f;

import com.baidu.navisdk.logic.NaviErrCode;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.SapiErrorCode;

/* compiled from: TtsErrorEnum */
/* renamed from: com.baidu.tts.f.n */
public enum C5097n {
    ONLINE_ENGINE_AUTH_FAILURE(C5096a.f21136b, -1, "online engine auth failure"),
    ONLINE_ENGINE_HTTP_REQUEST_FAILURE(C5096a.f21136b, -2, "request failure"),
    ONLINE_ENGINE_CANCEL_FAILURE(C5096a.f21136b, -3, "cancel failure"),
    ONLINE_AUTH_INTERRUPTED_EXCEPTION(C5096a.f21136b, -4, "InterruptedException"),
    ONLINE_AUTH_EXECUTION_EXCEPTION(C5096a.f21136b, -5, "ExecutionException"),
    ONLINE_AUTH_TIMEOUT_EXCEPTION(C5096a.f21136b, -6, "TimeoutException"),
    ONLINE_ENGINE_REQUEST_RESULT_ERROR(C5096a.f21136b, -7, "request result contains error message"),
    ONLINE_TOKEN_IS_NULL(C5096a.f21136b, -8, "access token is null, please check your apikey and secretkey or product id"),
    ONLINE_ENGINE_UNINITIALIZED(C5096a.f21136b, -9, "online engine is not initial"),
    ONLINE_ENGINE_CALL_EXCEPTION(C5096a.f21136b, -10, "online engine call synthesize exception"),
    ONLINE_UNSUPPORTED_OPERATION(C5096a.f21136b, -11, "this method is not supported by online mode(please use other mode)"),
    ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR(C5096a.f21136b, -12, "request result parse error may responsebag is null"),
    ONLINE_ENGINE_GET_INTERRUPTED(C5096a.f21136b, -13, "online synthesize get was interrupted"),
    ONLINE_ENGINE_GET_EXECUTION_EXCEPTION(C5096a.f21136b, -14, "online synthesize get exception"),
    ONLINE_ENGINE_GET_TIMEOUT(C5096a.f21136b, -15, "online synthesize get was timeout"),
    ONLINE_AUTH_CANCELLATION_EXCEPTION(C5096a.f21136b, -16, "CancellationException"),
    ONLINE_ENGINE_SERVER_IP_IS_NULL(C5096a.f21136b, -17, "online engine server ip is null"),
    OFFLINE_ENGINE_AUTH_FAILURE(C5096a.f21137c, -100, "offline engine auth failure,please check you offline auth params"),
    OFFLINE_ENGINE_CANCEL_FAILURE(C5096a.f21137c, -101, "offline engine cancel failure"),
    OFFLINE_ENGINE_DOWNLOAD_LICENSE_FAILED(C5096a.f21137c, -102, "offline engine download license failure"),
    OFFLINE_ENGINE_AUTH_NULL(C5096a.f21137c, -103, "offline engine auth authinfo is null"),
    OFFLINE_AUTH_INTERRUPTED_EXCEPTION(C5096a.f21137c, -105, "InterruptedException"),
    OFFLINE_AUTH_EXECUTION_EXCEPTION(C5096a.f21137c, -106, "ExecutionException"),
    OFFLINE_AUTH_TIMEOUT_EXCEPTION(C5096a.f21137c, -107, "TimeoutException"),
    OFFLINE_ENGINE_INIT_FAILED(C5096a.f21137c, -108, "bdTTSEngineInit failed,please check you offline params"),
    OFFLINE_ENGINE_UNINITIALIZED(C5096a.f21137c, -109, "offline engine is uninitialized,please invoke initTts() method"),
    OFFLINE_ENGINE_CALL_EXCEPTION(C5096a.f21137c, -110, "offline engine call synthesize exception"),
    OFFLINE_ENGINE_SYNTHESIZE_ERROR(C5096a.f21137c, -111, "offline engine synthesize result not 0"),
    OFFLINE_ENGINE_AUTH_EXPIRED(C5096a.f21137c, -112, "offline engine auth verify expired,formal expired or temp expired"),
    OFFLINE_ENGINE_AUTH_PACKAGE_UNMATCH(C5096a.f21137c, -113, "package name is unmatch"),
    OFFLINE_ENGINE_AUTH_SIGN_UNMATCH(C5096a.f21137c, -114, "app sign is unmatch"),
    OFFLINE_ENGINE_AUTH_CUID_UNMATCH(C5096a.f21137c, -115, "devices cuid is unmatch"),
    OFFLINE_ENGINE_AUTH_PLATFORM_ERROR(C5096a.f21137c, -116, "platform is unmatch"),
    OFFLINE_ENGINE_AUTH_LICENSE_FILE_INVALID(C5096a.f21137c, -117, "license file not exist or file length is 0 (download license fail)"),
    OFFLINE_AUTH_CANCELLATION_EXCEPTION(C5096a.f21136b, -118, "CancellationException"),
    MIX_ENGINE_AUTH_FAILURE(C5096a.f21135a, SapiErrorCode.NETWORK_FAILED, "both online and offline engine auth failue"),
    MIX_AUTH_INTERRUPTED_EXCEPTION(C5096a.f21135a, SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE, "InterruptedException"),
    MIX_AUTH_EXECUTION_EXCEPTION(C5096a.f21135a, SapiResult.ERROR_CODE_UNKNOWN, "ExecutionException"),
    MIX_AUTH_TIMEOUT_EXCEPTION(C5096a.f21135a, -203, "TimeoutException"),
    MIX_ENGINE_OFFLINE_INIT_FAILURE(C5096a.f21135a, -204, "mix engine initTTS, the offline init failure"),
    MIX_AUTH_CANCELLATION_EXCEPTION(C5096a.f21135a, -205, "CancellationException"),
    TEXT_IS_EMPTY(C5096a.f21138d, -300, "text is null or empty double quotation marks"),
    TEXT_IS_TOO_LONG(C5096a.f21138d, -301, "text length in gbk is more than 1024, the text is too long, cut it short than 1024"),
    TEXT_ENCODE_IS_WRONG(C5096a.f21138d, -302, "text encode is not gbk, please use gbk text"),
    TTS_UNINITIAL(C5096a.f21139e, -400, "tts has not been initialized,invoke in a wrong state"),
    TTS_MODE_ILLEGAL(C5096a.f21139e, -401, "tts mode unset or not the spechified value"),
    TTS_QUEUE_IS_FULL(C5096a.f21139e, -402, "队列长度小于MAX_QUEUE_SIZE时才能加入合成队列"),
    TTS_LIST_IS_TOO_LONG(C5096a.f21139e, -403, "list的size小于MAX_LIST_SIZE时才有效"),
    TTS_ENGINE_STOP_FAILURE(C5096a.f21139e, -404, "引擎停止失败"),
    TTS_APP_ID_IS_INVALID(C5096a.f21139e, -405, "app id is invalid,must be less than int(11)"),
    TTS_PARAMETER_INVALID(C5096a.f21139e, -406, "arguments of the method is invalid"),
    APP_RESOURCE_IS_NULL(C5096a.f21140f, -500, "context was released or persistent app value is null"),
    PLAYER_IS_NULL(C5096a.f21141g, -600, "player is null"),
    MODEL_PARAMS_ERROR(C5096a.f21142h, -1000, "params is wrong"),
    MODEL_REQUEST_ERROR(C5096a.f21142h, -1001, "request error"),
    MODEL_SERVER_ERROR(C5096a.f21142h, -1002, "server error"),
    MODEL_DB_MODEL_INVALID(C5096a.f21142h, -1003, "model item in db is invalid(fileids is empty)"),
    MODEL_DB_MODEL_FILE_PATHS_INVALID(C5096a.f21142h, -1004, "model file in db is invalid(abspath is empty)"),
    MODEL_EXISTS(C5096a.f21142h, -1005, "this model exists(have downloaded success ever)"),
    MODEL_BAGS_EMPTY(C5096a.f21142h, -1006, "can't get server model info,maybe modelid invalid or request failure"),
    MODEL_FILE_BAG_EMPTY(C5096a.f21142h, -1007, "can't get server file info,maybe fileid invalid or request failure"),
    MODEL_CHECK_EXCEPTION(C5096a.f21142h, -1008, "CheckWork exception happened"),
    MODEL_FILE_DOWNLOAD_EXCEPTION(C5096a.f21142h, -1009, "exception happens when file downloadwork execute"),
    TTS_ERROR_UNKNOW(C5096a.f21143i, NaviErrCode.RET_BUG, "unknow");
    
    private final C5096a am;
    private final int an;
    private final String ao;

    /* compiled from: TtsErrorEnum */
    /* renamed from: com.baidu.tts.f.n$a */
    public enum C5096a {
        /* renamed from: a */
        public static final C5096a f21135a = null;
        /* renamed from: b */
        public static final C5096a f21136b = null;
        /* renamed from: c */
        public static final C5096a f21137c = null;
        /* renamed from: d */
        public static final C5096a f21138d = null;
        /* renamed from: e */
        public static final C5096a f21139e = null;
        /* renamed from: f */
        public static final C5096a f21140f = null;
        /* renamed from: g */
        public static final C5096a f21141g = null;
        /* renamed from: h */
        public static final C5096a f21142h = null;
        /* renamed from: i */
        public static final C5096a f21143i = null;
        /* renamed from: j */
        private static final /* synthetic */ C5096a[] f21144j = null;

        private C5096a(String str, int i) {
        }

        public static C5096a valueOf(String name) {
            return (C5096a) Enum.valueOf(C5096a.class, name);
        }

        public static C5096a[] values() {
            return (C5096a[]) f21144j.clone();
        }

        static {
            f21135a = new C5096a("MIX_ERROR", 0);
            f21136b = new C5096a("ONLINE_ENGINE_ERROR", 1);
            f21137c = new C5096a("OFFLINE_ENGINE_ERROR", 2);
            f21138d = new C5096a("TEXT", 3);
            f21139e = new C5096a("TTS", 4);
            f21140f = new C5096a("APP", 5);
            f21141g = new C5096a("PLAYER", 6);
            f21142h = new C5096a("MODEL", 7);
            f21143i = new C5096a("UNKNOW", 8);
            f21144j = new C5096a[]{f21135a, f21136b, f21137c, f21138d, f21139e, f21140f, f21141g, f21142h, f21143i};
        }
    }

    private C5097n(C5096a c5096a, int i, String str) {
        this.am = c5096a;
        this.an = i;
        this.ao = str;
    }

    /* renamed from: a */
    public C5096a m17283a() {
        return this.am;
    }

    /* renamed from: b */
    public int m17284b() {
        return this.an;
    }

    /* renamed from: c */
    public String m17285c() {
        return this.ao;
    }
}
