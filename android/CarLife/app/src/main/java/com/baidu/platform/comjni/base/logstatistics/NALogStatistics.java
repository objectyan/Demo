package com.baidu.platform.comjni.base.logstatistics;

import com.baidu.platform.comjni.C2913c;

public class NALogStatistics extends C2913c {
    public static native boolean nativeAddLog(long j, int i, int i2, String str, String str2, String str3);

    public static native long nativeCreate();

    public static native int nativeRelease(long j);

    public static native boolean nativeSave(long j);

    public NALogStatistics() {
        create();
    }

    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    public int dispose() {
        if (this.mNativePointer == 0) {
            return 0;
        }
        int ret = nativeRelease(this.mNativePointer);
        this.mNativePointer = 0;
        return ret;
    }

    public boolean addLog(int type, int level, String netType, String action, String actionParam) {
        return nativeAddLog(this.mNativePointer, type, level, netType, action, actionParam);
    }

    public boolean saveLog() {
        return nativeSave(this.mNativePointer);
    }
}
