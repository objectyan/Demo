package com.baidu.mpcr.jni;

public class MpcrJni {
    public native String decryptStr(String str);

    public native String encryptStr(String str);

    public native void init();

    public native void unInit();
}
