package me.objectyan.screensharing.core.screen.video;

class JniMethod {
    static native void convert(byte[] bArr, byte[] bArr2, int i, int i2);

    static native void prepare(int i, int i2, int i3, boolean z);

    JniMethod() {
    }

    static {
        System.loadLibrary("bdpc");
    }
}
