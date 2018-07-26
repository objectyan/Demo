package com.baidu.sapi2.result;

public class GetRegCodeResult extends SapiResult {
    public static final int ERROR_CODE_EMPTY_PHONE_NUMBER = -101;
    public static final String ERROR_MSG_EMPTY_PHONE_NUMBER = "请输入手机号";
    public static final int RESULT_CODE_PHONE_NUMBER_EXIST = 8;
    public static final String RESULT_MSG_SUCCESS = "激活码发送成功";

    public GetRegCodeResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(-101, "请输入手机号");
    }
}
