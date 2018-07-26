package com.baidu.navisdk.comapi.userdata;

public class SapiConfigInfo {
    public String mAppId;
    public String mSignKey;
    public String mTpl;

    public String toString() {
        return "mTpl:" + this.mTpl + ", mAppId:" + this.mAppId + ", mSignKey:" + this.mSignKey;
    }
}
