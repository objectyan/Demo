package com.tencent.wxop.stat;

import com.tencent.wxop.stat.p290a.C6123d;
import java.lang.Thread.UncaughtExceptionHandler;

class aa implements UncaughtExceptionHandler {
    aa() {
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (C6156f.m22003c() && C6160j.f25107t != null) {
            if (C6156f.m22040p()) {
                ag.m21760a(C6160j.f25107t).m21789a(new C6123d(C6160j.f25107t, C6160j.m22090a(C6160j.f25107t, false, null), 2, th, thread, null), null, false, true);
                C6160j.f25104q.m21833i("MTA has caught the following uncaught exception:");
                C6160j.f25104q.m21821a(th);
            }
            C6160j.m22143i(C6160j.f25107t);
            if (C6160j.f25105r != null) {
                C6160j.f25104q.m21834j("Call the original uncaught exception handler.");
                if (!(C6160j.f25105r instanceof aa)) {
                    C6160j.f25105r.uncaughtException(thread, th);
                }
            }
        }
    }
}
