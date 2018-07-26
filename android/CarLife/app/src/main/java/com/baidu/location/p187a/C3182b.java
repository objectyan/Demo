package com.baidu.location.p187a;

import android.os.Bundle;

/* renamed from: com.baidu.location.a.b */
public class C3182b {
    /* renamed from: a */
    private static Object f17279a = new Object();
    /* renamed from: b */
    private static C3182b f17280b = null;
    /* renamed from: c */
    private int f17281c = -1;

    /* renamed from: a */
    public static C3182b m13285a() {
        C3182b c3182b;
        synchronized (f17279a) {
            if (f17280b == null) {
                f17280b = new C3182b();
            }
            c3182b = f17280b;
        }
        return c3182b;
    }

    /* renamed from: a */
    public void m13286a(int i, int i2, String str) {
        if (i2 != this.f17281c) {
            this.f17281c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            C3181a.m13265a().m13270a(bundle, 303);
        }
    }

    /* renamed from: b */
    public void m13287b() {
        this.f17281c = -1;
    }
}
