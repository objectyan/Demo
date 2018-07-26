package com.baidu.sapi2.result;

public class FaceLoginResult extends SapiResult {
    public static final int RESULT_CODE_PWD_VERIFY_FAILURE = 4;
    public static final String RESULT_MSG_PWD_VERIFY_FAILURE = "密码验证错误";

    public FaceLoginResult() {
        this.msgMap.put(4, RESULT_MSG_PWD_VERIFY_FAILURE);
    }
}
