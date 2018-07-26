package com.baidu.mobstat;

import android.content.Context;

class bw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f19535a;
    /* renamed from: b */
    final /* synthetic */ bv f19536b;

    bw(bv bvVar, Context context) {
        this.f19536b = bvVar;
        this.f19535a = context;
    }

    public void run() {
        try {
            if (!ao.m15348b(this.f19535a)) {
                ao.m15347a(2).mo2725a(this.f19535a);
            }
        } catch (Throwable th) {
        }
        this.f19536b.f19532e = false;
    }
}
