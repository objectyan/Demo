package com.baidu.sapi2.result;

public class GetDynamicPwdResult extends SapiResult {
    public static final int ERROR_CODE_EMPTY_PHONE_NUMBER = -101;
    public static final String ERROR_MSG_EMPTY_PHONE_NUMBER = "请输入手机号";
    public static final int RESULT_CODE_CAPTCHA_REQUIRED = 5;
    public static final String RESULT_MSG_SUCCESS = "动态密码发送成功";

    public GetDynamicPwdResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(-101, "请输入手机号");
    }
}
