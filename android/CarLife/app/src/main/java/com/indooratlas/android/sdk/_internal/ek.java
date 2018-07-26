package com.indooratlas.android.sdk._internal;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class ek<T> extends Handler {
    /* renamed from: a */
    private final WeakReference<T> f23203a;

    /* renamed from: a */
    public abstract void mo4629a(T t, Message message);

    public ek(T t) {
        this.f23203a = new WeakReference(t);
    }

    public final void handleMessage(Message msg) {
        Object obj = this.f23203a.get();
        if (obj != null) {
            mo4629a(obj, msg);
        }
    }
}
