package com.baidu.sapi2.result;

public class Web2NativeLoginResult extends SapiResult {
    public static final int ERROR_CODE_BDUSS_EMPTY = -101;
    public static final String ERROR_MSG_BDUSS_EMPTY = "BDUSS EMPTY";
    public static final String ERROR_MSG_UNKNOWN = "登录失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 400021;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";

    public Web2NativeLoginResult() {
        this.msgMap.put(400021, "用户登录状态失效，请重新登录");
        this.msgMap.put(-101, ERROR_MSG_BDUSS_EMPTY);
        this.msgMap.put(SapiResult.ERROR_CODE_UNKNOWN, "登录失败");
    }
}
