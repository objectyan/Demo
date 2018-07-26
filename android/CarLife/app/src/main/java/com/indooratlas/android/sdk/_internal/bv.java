package com.indooratlas.android.sdk._internal;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.indooratlas.android.sdk._internal.kd.C5997a;
import java.net.URI;
import java.nio.ByteBuffer;

abstract class bv extends jn {
    /* renamed from: a */
    private long f23265a;
    /* renamed from: b */
    long f23266b;
    /* renamed from: c */
    int f23267c;
    /* renamed from: d */
    Handler f23268d = new C5831a(this);

    /* renamed from: com.indooratlas.android.sdk._internal.bv$a */
    static class C5831a extends ek<bv> {
        /* renamed from: a */
        protected final /* bridge */ /* synthetic */ void mo4629a(Object obj, Message message) {
            bv bvVar = (bv) obj;
            switch (message.what) {
                case 0:
                    bv.m20158a(bvVar);
                    return;
                case 1:
                    bvVar.mo4638a(message.arg1);
                    return;
                default:
                    return;
            }
        }

        protected C5831a(bv bvVar) {
            super(bvVar);
        }
    }

    bv(URI uri, jo joVar) {
        super(uri, joVar);
    }

    /* renamed from: a */
    public final void m20163a(jj jjVar, kd kdVar) {
        this.f23265a = SystemClock.elapsedRealtime();
        super.a(jjVar, kdVar);
    }

    /* renamed from: a */
    public final void m20162a(jj jjVar, int i, String str, boolean z) {
        this.f23268d.removeCallbacksAndMessages(null);
        super.a(jjVar, i, str, z);
    }

    /* renamed from: a */
    public void mo4639a(int i, String str, boolean z) {
        this.f23268d.removeCallbacksAndMessages(null);
    }

    /* renamed from: b */
    public final void m20167b(jj jjVar, kd kdVar) {
        this.f23265a = SystemClock.elapsedRealtime();
        this.f23268d.removeMessages(1);
        ByteBuffer c = kdVar.c();
        if (c != null) {
            try {
                new Object[1][0] = Long.valueOf(SystemClock.elapsedRealtime() - c.getLong(0));
            } catch (Exception e) {
                a(e);
            }
        }
        super.b(jjVar, kdVar);
    }

    /* renamed from: a */
    public void mo4640a(km kmVar) {
        this.f23265a = SystemClock.elapsedRealtime();
        m20166b();
    }

    /* renamed from: a */
    public void mo4637a() {
        this.f23265a = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public final void m20164a(kd kdVar) {
        this.f23265a = SystemClock.elapsedRealtime();
        super.a(kdVar);
    }

    /* renamed from: b */
    final void m20166b() {
        new Object[1][0] = Long.valueOf(this.f23266b);
        this.f23268d.sendEmptyMessageDelayed(0, this.f23266b + 500);
    }

    /* renamed from: a */
    protected void mo4638a(int i) {
        new Object[1][0] = Integer.valueOf(i);
    }

    /* renamed from: a */
    static /* synthetic */ void m20158a(bv bvVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - bvVar.f23265a;
        if (elapsedRealtime >= bvVar.f23266b) {
            Object[] objArr = new Object[]{Long.valueOf(elapsedRealtime), Long.valueOf(bvVar.f23266b)};
            if (bvVar.f24504f.d()) {
                try {
                    kd keVar = new ke(C5997a.f24550d);
                    keVar.a(true);
                    ByteBuffer allocate = ByteBuffer.allocate(64);
                    allocate.putLong(0, SystemClock.elapsedRealtime());
                    keVar.a(allocate);
                    bvVar.b(keVar);
                    if (bvVar.f23267c > 0) {
                        bvVar.f23268d.removeMessages(1);
                        bvVar.f23268d.sendMessageDelayed(Message.obtain(null, 1, bvVar.f23267c, -1), (long) bvVar.f23267c);
                    }
                } catch (Exception e) {
                    bvVar.a(e);
                }
            }
            bvVar.f23268d.sendEmptyMessageDelayed(0, bvVar.f23266b + 500);
            return;
        }
        Object[] objArr2 = new Object[]{Long.valueOf(elapsedRealtime), Long.valueOf(bvVar.f23266b - elapsedRealtime)};
        bvVar.f23268d.sendEmptyMessageDelayed(0, (bvVar.f23266b - elapsedRealtime) + 500);
    }
}
