package com.baidu.sapi2.result;

public class VoiceLoginResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "登录失败";
    public static final int RESULT_CODE_PWD_VERIFY_FAILURE = 71042;
    public static final String RESULT_MSG_PWD_VERIFY_FAILURE = "再试一次";

    public VoiceLoginResult() {
        this.msgMap.put(RESULT_CODE_PWD_VERIFY_FAILURE, RESULT_MSG_PWD_VERIFY_FAILURE);
        this.msgMap.put(SapiResult.ERROR_CODE_UNKNOWN, "登录失败");
    }
}
