package com.indooratlas.android.sdk;

public class IAExtraInfo {
    public final String traceId;
    public final String version;

    public IAExtraInfo(String version, String traceId) {
        this.version = version;
        this.traceId = traceId;
    }
}
