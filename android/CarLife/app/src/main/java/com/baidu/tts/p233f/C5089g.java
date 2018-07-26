package com.baidu.tts.p233f;

import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.speech.asr.SpeechConstant;

/* compiled from: KeyEnum */
/* renamed from: com.baidu.tts.f.g */
public enum C5089g {
    STATE(null, "state", null),
    CODE(null, "code", null),
    DATA(null, "data", null),
    IVERSION(null, "iversion", null),
    URL(null, "url", null),
    MD5(null, "md5", null),
    LENGTH(null, "length", null),
    ABS_PATH(null, "absPath", null),
    ID(null, "id", null),
    GENDER(null, "gender", null),
    DOMAIN(null, "domain", null),
    QUALITY(null, "quality", null),
    DATA_COUNT(null, "data_count", null),
    DATA_LIST(null, "data_list", null),
    NAME(null, "name", null),
    VERSION_MIN(null, "version_min", null),
    VERSION_MAX(null, "version_max", null),
    TEXT_DATA_ID(null, "text_data_id", null),
    SPEECH_DATA_ID(null, "speech_data_id", null),
    FUNCTION("func", "function", ""),
    ERROR_NUMBER("err_no", "errorNumber", ""),
    ERROR_MESSAGE("err_msg", ParamKey.KEY_MSG_ERROR_STR, ""),
    MIX_MODE(null, "mixMode", null),
    NOTIFICATION_COUNT_PER_SECOND("ncps", "notificationCountPerSecond", ""),
    PERCENT("pct", "percent", ""),
    APP_CODE("ac", "appCode", ""),
    PACKAGE_NAME("pn", ParamKey.KEY_AUTH_APP_NAME, "app_name"),
    PLATFORM("", "platform", ""),
    SPEED("spd", "speed", ""),
    VOLUME("vol", C1981b.f6362b, ""),
    PITCH("pit", "pitch", ""),
    LANGUAGE("lan", SpeechConstant.LANGUAGE, ""),
    TEXT_ENCODE("cod", "textEncode", ""),
    STREAM_TYPE("st", "streamType", ""),
    AUDIO_ENCODE("aue", "audioEncode", ""),
    BITRATE("rate", "audioRate", ""),
    SPEAKER("per", "speaker", ""),
    STYLE("sty", OVERLAY_KEY.AREA_STYLE, ""),
    BACKGROUND("bcg", "background", ""),
    PRODUCT_ID("pdt", "productId", ""),
    TEXT_DAT_PATH("tdp", "textDatPath", ""),
    SPEECH_DAT_PATH("sdp", "speechDatPath", ""),
    TTS_LICENSE_FILE_PATH("tlfp", "ttsLicenseFilePath", ""),
    CUSTOM_SYNTH("cs", "custom_synth", ""),
    OPEN_XML("xml", "open_xml", ""),
    TTS_VOCODER_OPTIMIZATION("tvo", "ttsVocoderOptimzation", ""),
    SAMPLE_RATE("sr", "sampleRate", ""),
    SERIAL_NUMBER(NaviStatConstants.K_NSC_KEY_SN, "serialNumber", ""),
    INDEX("idx", "index", ""),
    TEXT("tex", "text", ""),
    CTP("ctp", "clientPath", ""),
    CUID("cuid", "deviceId", "wise_cuid"),
    VERSION("ver", "version", "sdk_version"),
    NUMBER("num", C2848p.aL, ""),
    ENGINE(NaviStatConstants.K_NSC_KEY_EN, "engine", ""),
    TERRITORY("ter", "territory", ""),
    PUNCTUATION("puc", "punctuation", ""),
    CONTEXT("ctx", "context", ""),
    API_KEY("", "apiKey", ""),
    SECRET_KEY("", "secretKey", ""),
    TOKEN("tok", "token", "");
    
    private final String aj;
    private final String ak;
    private final String al;

    private C5089g(String str, String str2, String str3) {
        this.aj = str;
        this.ak = str2;
        this.al = str3;
    }

    /* renamed from: a */
    public String m17273a() {
        return this.aj;
    }

    /* renamed from: b */
    public String m17274b() {
        return this.ak;
    }

    /* renamed from: a */
    public static String m17272a(C5089g c5089g) {
        return c5089g == null ? null : c5089g.name();
    }
}
