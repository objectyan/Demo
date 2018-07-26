package com.baidu.sapi2.result;

import com.baidu.sapi2.SapiAccount;

public class FillUsernameResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "用户名设置失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 160103;
    public static final int RESULT_CODE_USERNAME_ALREADY_EXIST = 160111;
    public static final int RESULT_CODE_USERNAME_FORMAT_INVALID = 160110;
    public static final int RESULT_CODE_USERNAME_UNAVAILABLE = 160105;
    public static final int RESULT_CODE_USER_HAVE_USERNAME = 160104;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public static final String RESULT_MSG_SUCCESS = "用户名设置成功";
    public static final String RESULT_MSG_USERNAME_ALREADY_EXIST = "该用户名已被注册,请更换其他用户名";
    public static final String RESULT_MSG_USERNAME_FORMAT_INVALID = "仅支持中英文、数字和下划线";
    public static final String RESULT_MSG_USERNAME_UNAVAILABLE = "该用户名已被注册,请更换其他用户名";
    public static final String RESULT_MSG_USER_HAVE_USERNAME = "该用户已有用户名";
    public SapiAccount session;

    public FillUsernameResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(110000, RESULT_MSG_SUCCESS);
        this.msgMap.put(160103, "用户登录状态失效，请重新登录");
        this.msgMap.put(160104, RESULT_MSG_USER_HAVE_USERNAME);
        this.msgMap.put(160105, "该用户名已被注册,请更换其他用户名");
        this.msgMap.put(160110, RESULT_MSG_USERNAME_FORMAT_INVALID);
        this.msgMap.put(160111, "该用户名已被注册,请更换其他用户名");
        this.msgMap.put(SapiResult.ERROR_CODE_UNKNOWN, ERROR_MSG_UNKNOWN);
    }
}
