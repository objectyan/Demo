package com.indooratlas.android.sdk._internal;

public enum gz {
    NO_ERROR(0, -1, 0),
    PROTOCOL_ERROR(1, 1, 1),
    INVALID_STREAM(1, 2, -1),
    UNSUPPORTED_VERSION(1, 4, -1),
    STREAM_IN_USE(1, 8, -1),
    STREAM_ALREADY_CLOSED(1, 9, -1),
    INTERNAL_ERROR(2, 6, 2),
    FLOW_CONTROL_ERROR(3, 7, -1),
    STREAM_CLOSED(5, -1, -1),
    FRAME_TOO_LARGE(6, 11, -1),
    REFUSED_STREAM(7, 3, -1),
    CANCEL(8, 5, -1),
    COMPRESSION_ERROR(9, -1, -1),
    CONNECT_ERROR(10, -1, -1),
    ENHANCE_YOUR_CALM(11, -1, -1),
    INADEQUATE_SECURITY(12, -1, -1),
    HTTP_1_1_REQUIRED(13, -1, -1),
    INVALID_CREDENTIALS(-1, 10, -1);
    
    /* renamed from: s */
    public final int f24064s;
    /* renamed from: t */
    public final int f24065t;
    /* renamed from: u */
    public final int f24066u;

    private gz(int i, int i2, int i3) {
        this.f24064s = i;
        this.f24065t = i2;
        this.f24066u = i3;
    }

    /* renamed from: a */
    public static gz m20803a(int i) {
        for (gz gzVar : values()) {
            if (gzVar.f24065t == i) {
                return gzVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static gz m20804b(int i) {
        for (gz gzVar : values()) {
            if (gzVar.f24064s == i) {
                return gzVar;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static gz m20805c(int i) {
        for (gz gzVar : values()) {
            if (gzVar.f24066u == i) {
                return gzVar;
            }
        }
        return null;
    }
}
