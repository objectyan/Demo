package com.baidu.mapframework.common.p202a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mapframework.common.p202a.C3465a.C3464a;

/* compiled from: AsyncLoggerHandler */
/* renamed from: com.baidu.mapframework.common.a.c */
class C3468c extends Handler {
    /* renamed from: a */
    private C3465a f18745a;

    public C3468c(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message msg) {
        if (msg != null && msg.obj != null && (msg.obj instanceof C3474i)) {
            C3474i event = msg.obj;
            C3465a appender = m14905b();
            if (appender != null) {
                appender.mo2546a(event);
            }
        }
    }

    /* renamed from: a */
    public void m14906a() {
        if (this.f18745a != null) {
            this.f18745a.mo2545a();
        }
    }

    /* renamed from: b */
    private C3465a m14905b() {
        C3473h conf = C3475j.f18764a;
        if (conf == null) {
            conf = new C3473h().m14913a(C3464a.LOGCAT);
        }
        if (this.f18745a == null) {
            this.f18745a = C3472g.m14911a(conf);
        } else if (!this.f18745a.mo2547b().equals(conf.m14912a())) {
            this.f18745a.mo2545a();
            this.f18745a = C3472g.m14911a(conf);
        }
        return this.f18745a;
    }
}
