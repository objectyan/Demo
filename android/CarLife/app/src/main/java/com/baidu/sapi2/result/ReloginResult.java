package com.baidu.sapi2.result;

import com.baidu.sapi2.SapiAccount;

public class ReloginResult extends SapiResult {
    public static final int ERROR_CODE_EMPTY_BDUSS = -101;
    public static final int ERROR_CODE_EMPTY_PASSWORD = -102;
    public static final String ERROR_MSG_EMPTY_BDUSS = "BDUSS不能为空";
    public static final String ERROR_MSG_EMPTY_PASSWORD = "密码不能为空";
    public SapiAccount session;

    public ReloginResult() {
        this.msgMap.put(-101, ERROR_MSG_EMPTY_BDUSS);
        this.msgMap.put(-102, ERROR_MSG_EMPTY_PASSWORD);
    }
}
