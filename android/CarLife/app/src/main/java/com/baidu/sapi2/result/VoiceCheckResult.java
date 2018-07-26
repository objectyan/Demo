package com.baidu.sapi2.result;

import com.baidu.sapi2.utils.enums.Switch;

public class VoiceCheckResult extends SapiResult {
    public static final int ERROR_CODE_EMPTY_ACCOUNT = -101;
    public static final String ERROR_MSG_EMPTY_ACCOUNT = "请输入帐号";
    public static final int RESULT_CODE_ACCOUNT_NOT_EXIST = 2;
    public static final int RESULT_CODE_ACCOUNT_TYPE_CONFLICT = 400401;
    public static final int RESULT_CODE_BDUSS_EXPIRED = 400021;
    public static final int RESULT_CODE_INCOMPLETE_USER = 3;
    public static final int RESULT_CODE_USER_FORBIDDEN = 4;
    public static final String RESULT_MSG_ACCOUNT_NOT_EXIST = "您输入的帐号不存在";
    public static final String RESULT_MSG_ACCOUNT_TYPE_CONFLICT = "请确认您输入的是帐号是用户名还是手机号";
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public static final String RESULT_MSG_INCOMPLETE_USER = "用户尚未正常化，无法使用此功能";
    public static final String RESULT_MSG_USER_FORBIDDEN = "用户被封禁，无法使用此功能";
    public String authSid;
    public String authToken;
    public String displayname;
    public boolean needVerify;
    public boolean signUp;
    public Switch switchState;
    public String uid;
    public int voiceCode;

    public VoiceCheckResult() {
        this.msgMap.put(2, RESULT_MSG_ACCOUNT_NOT_EXIST);
        this.msgMap.put(3, "用户尚未正常化，无法使用此功能");
        this.msgMap.put(4, RESULT_MSG_USER_FORBIDDEN);
        this.msgMap.put(400021, "用户登录状态失效，请重新登录");
        this.msgMap.put(RESULT_CODE_ACCOUNT_TYPE_CONFLICT, RESULT_MSG_ACCOUNT_TYPE_CONFLICT);
        this.msgMap.put(-101, "请输入帐号");
    }
}
