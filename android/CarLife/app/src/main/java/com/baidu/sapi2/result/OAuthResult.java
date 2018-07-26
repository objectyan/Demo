package com.baidu.sapi2.result;

public class OAuthResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "授权失败";
    public static final String RESULT_MSG_SUCCESS = "授权成功";
    public String accessToken;
    public int expiresIn;
    public String extra;
    public String refreshToken;
    public String scope;
    public String sessionKey;
    public String sessionSecret;

    public OAuthResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(SapiResult.ERROR_CODE_UNKNOWN, ERROR_MSG_UNKNOWN);
    }

    public String toString() {
        return "OAuthResult{accessToken='" + this.accessToken + '\'' + ", expiresIn=" + this.expiresIn + ", refreshToken='" + this.refreshToken + '\'' + ", scope='" + this.scope + '\'' + ", sessionKey='" + this.sessionKey + '\'' + ", sessionSecret='" + this.sessionSecret + '\'' + ", extra='" + this.extra + '\'' + '}';
    }
}
