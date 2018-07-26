package com.baidu.navi.protocol.model;

public class ResultDataStruct extends DataStruct {
    public static final String KEY_ERROR_CODE = "errCode";
    public static final String KEY_ERROR_STRING = "errString";
    public int errCode;
    public String errString;

    public ResultDataStruct() {
        this.mCmd = "result";
    }

    public String toString() {
        return "errCode=" + this.errCode + " errString=" + this.errString;
    }
}
