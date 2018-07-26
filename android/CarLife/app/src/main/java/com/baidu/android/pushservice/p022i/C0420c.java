package com.baidu.android.pushservice.p022i;

import android.text.TextUtils;

/* renamed from: com.baidu.android.pushservice.i.c */
public abstract class C0420c implements Runnable {
    /* renamed from: a */
    private String f1321a;
    /* renamed from: b */
    private short f1322b = (short) 99;

    public C0420c(String str, short s) {
        this.f1321a = str;
        this.f1322b = s;
    }

    /* renamed from: a */
    public abstract void mo1272a();

    /* renamed from: a */
    public void m1793a(short s) {
        this.f1322b = s;
    }

    /* renamed from: c */
    public void m1794c(String str) {
        this.f1321a = str;
    }

    /* renamed from: d */
    public short m1795d() {
        return this.f1322b;
    }

    public final void run() {
        if (!TextUtils.isEmpty(this.f1321a)) {
            Thread.currentThread().setName(this.f1321a);
        }
        mo1272a();
    }
}
