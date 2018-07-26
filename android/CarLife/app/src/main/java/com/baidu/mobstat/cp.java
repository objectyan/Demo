package com.baidu.mobstat;

import android.content.Context;
import android.support.v4.app.Fragment;
import java.lang.ref.WeakReference;

class cp implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ch f19614a;
    /* renamed from: b */
    private long f19615b;
    /* renamed from: c */
    private long f19616c;
    /* renamed from: d */
    private WeakReference<Context> f19617d;
    /* renamed from: e */
    private WeakReference<Fragment> f19618e;
    /* renamed from: f */
    private WeakReference<Object> f19619f;
    /* renamed from: g */
    private long f19620g;
    /* renamed from: h */
    private int f19621h;
    /* renamed from: i */
    private int f19622i = 1;

    public cp(ch chVar, long j, long j2, long j3, Context context, Fragment fragment, Object obj, int i, int i2) {
        this.f19614a = chVar;
        this.f19615b = j;
        this.f19616c = j2;
        this.f19617d = new WeakReference(context);
        this.f19618e = new WeakReference(fragment);
        this.f19619f = new WeakReference(obj);
        this.f19620g = j3;
        this.f19621h = i;
        this.f19622i = i2;
    }

    public void run() {
        Context context = (Context) this.f19617d.get();
        Fragment fragment = (Fragment) this.f19618e.get();
        Object obj = this.f19619f.get();
        if (context != null || fragment != null || obj != null) {
            Context context2;
            if (this.f19622i == 1) {
                context2 = context;
            } else if (this.f19622i == 2) {
                context2 = fragment.getActivity();
            } else if (this.f19622i == 3) {
                context2 = ch.m15569a(obj);
            } else {
                context2 = null;
            }
            if (context2 != null) {
                boolean z;
                if (this.f19616c - this.f19615b >= ((long) this.f19614a.m15601c())) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return;
                }
                if (this.f19615b > 0) {
                    if (this.f19622i == 3 || this.f19622i == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.f19614a.f19578i.m15559d(this.f19615b);
                    }
                    this.f19614a.m15572a(context2, true);
                    this.f19614a.m15585a(this.f19620g);
                    this.f19614a.m15595b(this.f19621h);
                } else if (this.f19615b == 0) {
                    this.f19614a.m15595b(this.f19621h);
                }
            }
        }
    }
}
