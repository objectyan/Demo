package com.baidu.android.pushservice.message;

import android.content.Context;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.baidu.android.pushservice.message.d */
public abstract class C0618d {
    /* renamed from: a */
    protected Context f1931a;
    /* renamed from: b */
    private LinkedList<C0619e> f1932b = new LinkedList();

    public C0618d(Context context) {
        this.f1931a = context;
    }

    /* renamed from: a */
    public abstract C0619e mo1296a(byte[] bArr, int i) throws IOException;

    /* renamed from: a */
    public LinkedList<C0619e> m2714a() {
        return this.f1932b;
    }

    /* renamed from: a */
    public abstract void mo1297a(int i);

    /* renamed from: a */
    public void m2716a(C0619e c0619e) {
        synchronized (this.f1932b) {
            try {
                this.f1932b.add(c0619e);
                this.f1932b.notify();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    public abstract void mo1298b();

    /* renamed from: b */
    public abstract void mo1299b(C0619e c0619e) throws Exception;

    /* renamed from: c */
    public abstract void mo1300c();
}
