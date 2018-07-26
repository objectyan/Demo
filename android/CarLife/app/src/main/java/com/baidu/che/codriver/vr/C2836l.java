package com.baidu.che.codriver.vr;

import android.text.TextUtils;

/* compiled from: RegCustomCmd */
/* renamed from: com.baidu.che.codriver.vr.l */
public class C2836l {
    /* renamed from: a */
    private String f9213a;
    /* renamed from: b */
    private C2571b f9214b;

    public C2836l(String query, C2571b listener) {
        this.f9213a = query;
        this.f9214b = listener;
    }

    /* renamed from: a */
    public boolean m10667a(String query) {
        if (TextUtils.isEmpty(query)) {
            return false;
        }
        return (this.f9213a + ",").contains(query + ",");
    }

    /* renamed from: b */
    public void m10668b(String word) {
        if (this.f9214b != null) {
            this.f9214b.mo1885a(word);
        }
    }

    /* renamed from: a */
    public String m10666a() {
        return this.f9213a;
    }
}
