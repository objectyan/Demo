package com.baidu.mobstat;

import android.content.Context;

class am implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f19388a;
    /* renamed from: b */
    final /* synthetic */ Context f19389b;
    /* renamed from: c */
    final /* synthetic */ al f19390c;

    am(al alVar, String str, Context context) {
        this.f19390c = alVar;
        this.f19388a = str;
        this.f19389b = context;
    }

    public void run() {
        try {
            this.f19390c.m15341a(this.f19388a);
            if (this.f19389b != null) {
                this.f19390c.m15338a(this.f19389b.getApplicationContext());
            }
        } catch (Throwable th) {
            bd.m15432b(th);
        }
    }
}
