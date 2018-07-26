package com.baidu.sapi2.result;

public class GetUserInfoResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "用户信息获取失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 400021;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public String displayname;
    public boolean havePwd = true;
    public boolean incompleteUser;
    public boolean isInitialPortrait = false;
    public String portrait;
    public String portraitSign;
    public String secureEmail;
    public String secureMobile;
    public String uid;
    public String username;

    public GetUserInfoResult() {
        this.msgMap.put(400021, "用户登录状态失效，请重新登录");
        this.msgMap.put(SapiResult.ERROR_CODE_UNKNOWN, ERROR_MSG_UNKNOWN);
    }

    public String toString() {
        return "GetUserInfoResult{username='" + this.username + '\'' + ", displayname='" + this.displayname + '\'' + ", uid='" + this.uid + '\'' + ", secureMobile='" + this.secureMobile + '\'' + ", secureEmail='" + this.secureEmail + '\'' + ", incompleteUser=" + this.incompleteUser + ", portrait='" + this.portrait + '\'' + ", portraitSign='" + this.portraitSign + '\'' + ", isInitialPortrait=" + this.isInitialPortrait + ", havePwd=" + this.havePwd + '}';
    }
}
