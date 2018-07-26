package com.indooratlas.android.sdk._internal;

import java.io.IOException;

/* renamed from: com.indooratlas.android.sdk._internal.j */
public final class C5987j extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    private C5987j(String str) {
        super(str);
    }

    /* renamed from: a */
    static C5987j m21297a() {
        return new C5987j("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static C5987j m21298b() {
        return new C5987j("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static C5987j m21299c() {
        return new C5987j("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static C5987j m21300d() {
        return new C5987j("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static C5987j m21301e() {
        return new C5987j("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static C5987j m21302f() {
        return new C5987j("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static C5987j m21303g() {
        return new C5987j("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
