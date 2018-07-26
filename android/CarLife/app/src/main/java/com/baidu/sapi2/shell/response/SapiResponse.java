package com.baidu.sapi2.shell.response;

public class SapiResponse {
    public int errorCode;
    public String errorMsg;

    public SapiResponse() {
        this.errorCode = -100;
        this.errorMsg = "";
    }

    public SapiResponse(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
