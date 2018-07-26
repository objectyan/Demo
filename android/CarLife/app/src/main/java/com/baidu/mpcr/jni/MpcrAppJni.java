package com.baidu.mpcr.jni;

public class MpcrAppJni {
    private MpcrJni mMpcrJni;

    public MpcrAppJni() {
        this.mMpcrJni = null;
        this.mMpcrJni = new MpcrJni();
    }

    public String encryptStr(String jsonString) {
        return this.mMpcrJni.encryptStr(jsonString);
    }

    public String decryptStr(String jsonString) {
        return this.mMpcrJni.decryptStr(jsonString);
    }

    public void init() {
        this.mMpcrJni.init();
    }

    public void unInit() {
        this.mMpcrJni.unInit();
    }
}
