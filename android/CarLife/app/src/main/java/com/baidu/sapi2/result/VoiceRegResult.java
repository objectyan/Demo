package com.baidu.sapi2.result;

public class VoiceRegResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "很遗憾，语音密码创建失败";
    public static final int RESULT_CODE_AUTH_EXPIRED = 62004;
    public static final String RESULT_MSG_AUTH_EXPIRED = "验证信息已过期";

    public VoiceRegResult() {
        this.msgMap.put(RESULT_CODE_AUTH_EXPIRED, RESULT_MSG_AUTH_EXPIRED);
        this.msgMap.put(SapiResult.ERROR_CODE_UNKNOWN, ERROR_MSG_UNKNOWN);
    }
}
