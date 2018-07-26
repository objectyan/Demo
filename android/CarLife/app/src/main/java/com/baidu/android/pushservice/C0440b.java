package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p031j.C0578p;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.baidu.android.pushservice.b */
class C0440b implements UncaughtExceptionHandler {
    /* renamed from: a */
    private String f1379a = "DefaultExceptionHandler";
    /* renamed from: b */
    private Context f1380b = null;

    public C0440b(Context context) {
        this.f1380b = context;
    }

    /* renamed from: a */
    private void m1907a(Throwable th) {
        String b = C0553q.m2364b(this.f1380b, th);
        C0578p.m2546b("exception " + b + " at Time " + System.currentTimeMillis(), this.f1380b.getApplicationContext());
        C0553q.m2365b(this.f1380b, b);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m1907a(th);
        C0578p.m2571f(this.f1380b, this.f1380b.getPackageName());
    }
}
