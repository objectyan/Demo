package com.indooratlas.android.sdk._internal;

import android.os.Message;
import android.util.SparseArray;

public final class bm {
    /* renamed from: a */
    final SparseArray<bp> f23206a = new SparseArray();
    /* renamed from: b */
    C5796b f23207b;
    /* renamed from: c */
    C5820a f23208c = new C5820a(this);

    /* renamed from: com.indooratlas.android.sdk._internal.bm$b */
    public interface C5796b {
        /* renamed from: a */
        void mo4615a(bp bpVar);
    }

    /* renamed from: com.indooratlas.android.sdk._internal.bm$c */
    public static class C5797c implements C5796b {
        /* renamed from: a */
        public void mo4615a(bp bpVar) {
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.bm$a */
    static class C5820a extends ek<bm> {
        /* renamed from: a */
        protected final /* bridge */ /* synthetic */ void mo4629a(Object obj, Message message) {
            ((bm) obj).m20115a(message.what, ((C5821d) message.obj).f23205b);
        }

        protected C5820a(bm bmVar) {
            super(bmVar);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.bm$d */
    static class C5821d {
        /* renamed from: a */
        final bp f23204a;
        /* renamed from: b */
        final bp f23205b;

        C5821d(bp bpVar, bp bpVar2) {
            this.f23204a = bpVar;
            this.f23205b = bpVar2;
        }
    }

    /* renamed from: a */
    public final boolean m20116a(int i, long j) {
        return m20114a(new bp(i), j);
    }

    /* renamed from: a */
    private boolean m20114a(bp bpVar, long j) {
        boolean z;
        int i = bpVar.f23220a;
        this.f23208c.removeMessages(i);
        synchronized (this.f23206a) {
            bp bpVar2 = (bp) this.f23206a.get(i);
            if (bpVar2 == null || !(bpVar2.f23221b == bpVar.f23221b || this.f23207b == null)) {
                Object[] objArr = new Object[]{Integer.valueOf(i), bpVar2, bpVar, Long.valueOf(j)};
                if (j >= 0) {
                    this.f23208c.sendMessageDelayed(this.f23208c.obtainMessage(i, new C5821d(bpVar2, bpVar)), j);
                    z = true;
                } else {
                    m20115a(i, bpVar);
                    z = true;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: a */
    final void m20115a(int i, bp bpVar) {
        synchronized (this.f23206a) {
            Object[] objArr = new Object[]{Integer.valueOf(i), bpVar};
            this.f23206a.put(i, bpVar);
            this.f23207b.mo4615a(bpVar);
        }
    }
}
