package com.baidu.platform.comjni.base.networkdetect;

import com.baidu.platform.comjni.C2913c;

public class NANetworkDetect extends C2913c {
    private native long nativeCreate();

    private native boolean nativeNetworkDetect(long j, String str);

    private native int nativeRelease(long j);

    public NANetworkDetect() {
        create();
    }

    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    public int dispose() {
        return nativeRelease(this.mNativePointer);
    }

    public boolean networkDetect(String json) {
        return nativeNetworkDetect(this.mNativePointer, json);
    }
}
