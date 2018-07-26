package com.baidu.sapi2.result;

public class SetPortraitResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "设置头像失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 160103;
    public static final int RESULT_CODE_FORMAT_ERROR = 1605001;
    public static final int RESULT_CODE_SYSTEM_ERROR = 1605002;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public static final String RESULT_MSG_FORMAT_ERROR = "头像格式错误";
    public static final String RESULT_MSG_SUCCESS = "设置头像成功";
    public static final String RESULT_MSG_SYSTEM_ERROR = "系统错误";

    public SetPortraitResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(110000, RESULT_MSG_SUCCESS);
        this.msgMap.put(160103, "用户登录状态失效，请重新登录");
        this.msgMap.put(1605001, RESULT_MSG_FORMAT_ERROR);
        this.msgMap.put(1605002, RESULT_MSG_SYSTEM_ERROR);
        this.msgMap.put(SapiResult.ERROR_CODE_UNKNOWN, ERROR_MSG_UNKNOWN);
    }
}
