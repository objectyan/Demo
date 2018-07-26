package com.baidu.sapi2.result;

import com.baidu.sapi2.SapiAccount;

public class FillUserProfileResult extends SapiResult {
    public static final int ERROR_CODE_SIM_UNAVAILABLE = -101;
    public static final String ERROR_MSG_SIM_UNAVAILABLE = "SIM卡不可用，请使用其他绑定方式";
    public static final String ERROR_MSG_UNKNOWN = "绑定失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 1;
    public static final int RESULT_CODE_COMPLETE_USER = 61002;
    public static final int RESULT_CODE_PHONE_UNAVAILABLE = 8;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public static final String RESULT_MSG_COMPLETE_USER = "用户已绑定手机或邮箱";
    public static final String RESULT_MSG_PHONE_UNAVAILABLE = "手机号被占用，请使用其他绑定方式";
    public static final String RESULT_MSG_SUCCESS = "绑定成功";
    public SapiAccount session;

    public FillUserProfileResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(1, "用户登录状态失效，请重新登录");
        this.msgMap.put(8, RESULT_MSG_PHONE_UNAVAILABLE);
        this.msgMap.put(RESULT_CODE_COMPLETE_USER, RESULT_MSG_COMPLETE_USER);
        this.msgMap.put(-101, ERROR_MSG_SIM_UNAVAILABLE);
        this.msgMap.put(SapiResult.ERROR_CODE_UNKNOWN, ERROR_MSG_UNKNOWN);
    }
}
