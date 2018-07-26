package com.baidu.sapi2.result;

public class VoiceCodeSetResult extends SapiResult {
    public static final int RESULT_CODE_BDUSS_EXPIRED = 1;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";

    public VoiceCodeSetResult() {
        this.msgMap.put(1, "用户登录状态失效，请重新登录");
    }
}
