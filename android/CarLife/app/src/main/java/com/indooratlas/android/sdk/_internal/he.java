package com.indooratlas.android.sdk._internal;

import com.baidu.navi.fragment.NaviFragmentManager;

public final class he {
    /* renamed from: a */
    public static final iq f24160a = iq.a(":status");
    /* renamed from: b */
    public static final iq f24161b = iq.a(":method");
    /* renamed from: c */
    public static final iq f24162c = iq.a(":path");
    /* renamed from: d */
    public static final iq f24163d = iq.a(":scheme");
    /* renamed from: e */
    public static final iq f24164e = iq.a(":authority");
    /* renamed from: f */
    public static final iq f24165f = iq.a(":host");
    /* renamed from: g */
    public static final iq f24166g = iq.a(":version");
    /* renamed from: h */
    public final iq f24167h;
    /* renamed from: i */
    public final iq f24168i;
    /* renamed from: j */
    final int f24169j;

    public he(String str, String str2) {
        this(iq.a(str), iq.a(str2));
    }

    public he(iq iqVar, String str) {
        this(iqVar, iq.a(str));
    }

    public he(iq iqVar, iq iqVar2) {
        this.f24167h = iqVar;
        this.f24168i = iqVar2;
        this.f24169j = (iqVar.f24395c.length + 32) + iqVar2.f24395c.length;
    }

    public final boolean equals(Object other) {
        if (!(other instanceof he)) {
            return false;
        }
        he heVar = (he) other;
        if (this.f24167h.equals(heVar.f24167h) && this.f24168i.equals(heVar.f24168i)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f24167h.hashCode() + NaviFragmentManager.TYPE_PHONE_END) * 31) + this.f24168i.hashCode();
    }

    public final String toString() {
        return String.format("%s: %s", new Object[]{this.f24167h.a(), this.f24168i.a()});
    }
}
