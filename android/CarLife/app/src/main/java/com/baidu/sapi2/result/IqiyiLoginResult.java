package com.baidu.sapi2.result;

public class IqiyiLoginResult extends SapiResult {
    public static final int ERROR_CODE_ACCESSTOKEN_NULL_FAILURE = -101;
    public static final String ERROR_MSG_ACCESSTOKEN_NULL_FAILURE = "无权限（accesstoken == null)";
    public String nextUrl;

    public IqiyiLoginResult() {
        this.msgMap.put(-101, ERROR_MSG_ACCESSTOKEN_NULL_FAILURE);
    }
}
