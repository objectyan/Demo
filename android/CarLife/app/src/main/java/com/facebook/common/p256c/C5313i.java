package com.facebook.common.p256c;

import android.os.Handler;
import android.os.Looper;

/* compiled from: UiThreadImmediateExecutorService */
/* renamed from: com.facebook.common.c.i */
public class C5313i extends C5310e {
    /* renamed from: a */
    private static C5313i f21892a = null;

    private C5313i() {
        super(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: c */
    public static C5313i m18112c() {
        if (f21892a == null) {
            f21892a = new C5313i();
        }
        return f21892a;
    }

    public void execute(Runnable command) {
        if (mo3997b()) {
            command.run();
        } else {
            super.execute(command);
        }
    }
}
