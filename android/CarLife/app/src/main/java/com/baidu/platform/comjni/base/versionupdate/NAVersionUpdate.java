package com.baidu.platform.comjni.base.versionupdate;

import com.baidu.platform.comjni.C2912a;

public class NAVersionUpdate extends C2912a {
    /* renamed from: a */
    private int f19998a = 0;

    private native int nativeCreate();

    private native int nativeRelease(int i);

    private native void nativeSetVerUpdateParams(int i, String str, String str2);

    public int create() {
        this.f19998a = nativeCreate();
        return this.f19998a;
    }

    public synchronized int release() {
        return nativeRelease(this.f19998a);
    }

    public synchronized void setVerUpdateParams(String strDownloadPath, String bundleParams) {
        nativeSetVerUpdateParams(this.f19998a, strDownloadPath, bundleParams);
    }
}
