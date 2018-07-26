package com.baidu.tts.p232e;

import android.content.Context;

/* compiled from: StatThread */
/* renamed from: com.baidu.tts.e.b */
public class C5076b extends Thread {
    /* renamed from: a */
    private Context f20988a;
    /* renamed from: b */
    private String f20989b;

    public C5076b(Context context, String str) {
        this.f20988a = context;
        this.f20989b = str;
    }

    public void run() {
        C5075a.m17228a(this.f20988a, this.f20989b);
        this.f20988a = null;
    }
}
