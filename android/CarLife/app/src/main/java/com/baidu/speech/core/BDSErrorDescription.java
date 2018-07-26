package com.baidu.speech.core;

public class BDSErrorDescription {
    public int errorCode;
    public String errorDescription;
    public int errorDomain;

    public int getDetailCode() {
        return (this.errorDomain << 16) | (65535 & this.errorCode);
    }
}
