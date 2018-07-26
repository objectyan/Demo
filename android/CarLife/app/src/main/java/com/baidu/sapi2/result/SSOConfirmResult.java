package com.baidu.sapi2.result;

public class SSOConfirmResult extends SapiResult {
    public static final int RESULT_CODE_ANTISPAM = 4;
    public static final int RESULT_CODE_CHANNEL_ERROR = 1;
    public static final int RESULT_CODE_CHANNEL_NOT_EXIST = 2;
    public static final int RESULT_CODE_IP_CHANGED = 3;
    public static final String RESULT_MSG_ANTISPAM = "操作太频繁，请稍后再试";
    public static final String RESULT_MSG_CHANNEL_ERROR = "系统繁忙，请稍后再试";
    public static final String RESULT_MSG_CHANNEL_NOT_EXIST = "请求已过期";
    public static final String RESULT_MSG_IP_CHANGED = "网络环境异常";

    public SSOConfirmResult() {
        this.msgMap.put(1, RESULT_MSG_CHANNEL_ERROR);
        this.msgMap.put(2, RESULT_MSG_CHANNEL_NOT_EXIST);
        this.msgMap.put(3, RESULT_MSG_IP_CHANGED);
        this.msgMap.put(4, RESULT_MSG_ANTISPAM);
    }
}
