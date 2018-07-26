package com.indooratlas.android.sdk._internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class kl implements kh {
    /* renamed from: a */
    private byte[] f24554a;
    /* renamed from: b */
    private TreeMap<String, String> f24555b = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    /* renamed from: b */
    public final Iterator<String> mo4822b() {
        return Collections.unmodifiableSet(this.f24555b.keySet()).iterator();
    }

    /* renamed from: b */
    public final String mo4821b(String str) {
        String str2 = (String) this.f24555b.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    /* renamed from: c */
    public final byte[] mo4824c() {
        return this.f24554a;
    }

    /* renamed from: a */
    public final void mo4820a(byte[] bArr) {
        this.f24554a = bArr;
    }

    /* renamed from: a */
    public final void mo4819a(String str, String str2) {
        this.f24555b.put(str, str2);
    }

    /* renamed from: c */
    public final boolean mo4823c(String str) {
        return this.f24555b.containsKey(str);
    }
}
