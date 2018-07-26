package com.tencent.mm.sdk.p287b;

import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.sdk.p287b.C6101g.C6098a;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sdk.b.e */
final class C6099e extends Handler implements C6098a {
    private Looper aN = getLooper();
    private Callback aO;
    C6096a aP;

    /* renamed from: com.tencent.mm.sdk.b.e$a */
    public interface C6096a {
        /* renamed from: a */
        void mo4981a(Runnable runnable, C6101g c6101g);

        /* renamed from: b */
        void mo4982b(Runnable runnable, C6101g c6101g);
    }

    C6099e(Looper looper, C6096a c6096a) {
        super(looper);
        this.aP = c6096a;
    }

    C6099e(C6096a c6096a) {
        this.aP = c6096a;
    }

    /* renamed from: c */
    public final void mo4983c(Runnable runnable, C6101g c6101g) {
        if (this.aP != null) {
            this.aP.mo4982b(runnable, c6101g);
        }
    }

    public final void dispatchMessage(Message message) {
        if (message.getCallback() == null && this.aO == null) {
            System.currentTimeMillis();
            Debug.threadCpuTimeNanos();
            handleMessage(message);
            if (this.aP != null) {
                this.aN.getThread();
                System.currentTimeMillis();
                Debug.threadCpuTimeNanos();
                return;
            }
            return;
        }
        super.dispatchMessage(message);
    }

    public final void handleMessage(Message message) {
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        Assert.assertTrue("msg is null", message != null);
        Runnable callback = message.getCallback();
        if (callback == null) {
            return super.sendMessageAtTime(message, j);
        }
        long uptimeMillis = j - SystemClock.uptimeMillis();
        C6101g c6101g = new C6101g(this.aN.getThread(), message.getTarget() == null ? this : message.getTarget(), callback, message.obj, this);
        if (uptimeMillis > 0) {
            c6101g.aY = uptimeMillis;
        }
        Message obtain = Message.obtain(message.getTarget(), c6101g);
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.setData(message.getData());
        message.recycle();
        if (this.aP != null) {
            this.aP.mo4981a(callback, c6101g);
        }
        boolean sendMessageAtTime = super.sendMessageAtTime(obtain, j);
        if (!(sendMessageAtTime || this.aP == null)) {
            this.aP.mo4982b(callback, c6101g);
        }
        return sendMessageAtTime;
    }

    public final String toString() {
        return "MMInnerHandler{listener = " + this.aP + "}";
    }
}
