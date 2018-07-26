package com.tencent.mm.sdk.p287b;

import android.os.Looper;
import com.tencent.mm.sdk.p287b.C6099e.C6096a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.sdk.b.d */
public final class C6097d implements C6096a {
    private C6099e aJ;
    private ConcurrentHashMap<Runnable, WeakReference<C6101g>> aK;
    private int aL;
    private LinkedList<WeakReference<C6101g>> aM;

    public C6097d() {
        this.aK = new ConcurrentHashMap();
        this.aM = new LinkedList();
        this.aJ = new C6099e(this);
        if (this.aJ.getLooper().getThread().getName().equals("initThread")) {
            C6094b.m21681a("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", C6102h.m21698u());
        }
    }

    public C6097d(Looper looper) {
        this.aK = new ConcurrentHashMap();
        this.aM = new LinkedList();
        this.aJ = new C6099e(looper, this);
        if (looper.getThread().getName().equals("initThread")) {
            C6094b.m21681a("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", C6102h.m21698u());
        }
    }

    /* renamed from: a */
    public final void mo4981a(Runnable runnable, C6101g c6101g) {
        this.aK.put(runnable, new WeakReference(c6101g));
    }

    /* renamed from: b */
    public final void mo4982b(Runnable runnable, C6101g c6101g) {
        WeakReference weakReference = (WeakReference) this.aK.get(runnable);
        if (weakReference != null && weakReference.get() != null && weakReference.get() == c6101g) {
            this.aK.remove(runnable);
            if (this.aL > 0) {
                if (this.aM.size() == this.aL) {
                    this.aM.pop();
                }
                this.aM.add(weakReference);
            }
        }
    }

    public final boolean post(Runnable runnable) {
        return this.aJ.post(runnable);
    }

    public final String toString() {
        return "MMHandler(" + getClass().getName() + ")";
    }
}
