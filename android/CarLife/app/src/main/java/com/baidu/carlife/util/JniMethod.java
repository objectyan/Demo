package com.baidu.carlife.util;

public class JniMethod {
    public static native void convert(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void prepare(int i, int i2, int i3, boolean z);

    static {
        System.loadLibrary("bdpc");
    }
}
