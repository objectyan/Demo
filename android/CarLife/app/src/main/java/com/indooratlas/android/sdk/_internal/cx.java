package com.indooratlas.android.sdk._internal;

import com.baidu.sapi2.shell.SapiErrorCode;

public final class cx {
    /* renamed from: a */
    public cw f23358a;
    /* renamed from: b */
    public long f23359b;
    /* renamed from: c */
    public Object f23360c;
    /* renamed from: d */
    public long f23361d;

    /* renamed from: a */
    public final boolean m20276a() {
        return this.f23358a != null && this.f23358a.mo4658a() == SapiErrorCode.NETWORK_FAILED;
    }

    /* renamed from: b */
    public final boolean m20277b() {
        return this.f23358a != null && (this.f23358a.mo4658a() == -300 || this.f23358a.mo4658a() == -301 || this.f23358a.mo4658a() == -302);
    }

    public final String toString() {
        return "IASensorEvent{sensor=" + this.f23358a + ", timestamp=" + this.f23359b + ", data=" + this.f23360c + '}';
    }
}
