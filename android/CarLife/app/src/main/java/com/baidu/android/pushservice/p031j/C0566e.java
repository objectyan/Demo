package com.baidu.android.pushservice.p031j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;

/* renamed from: com.baidu.android.pushservice.j.e */
public class C0566e {
    /* renamed from: c */
    private static int f1852c = 1000;
    /* renamed from: f */
    private static final Object f1853f = new Object();
    /* renamed from: a */
    private long f1854a = System.currentTimeMillis();
    /* renamed from: b */
    private C0563c f1855b;
    /* renamed from: d */
    private Context f1856d;
    /* renamed from: e */
    private Intent f1857e;
    /* renamed from: g */
    private Intent f1858g;

    public C0566e(Context context, Intent intent) {
        this.f1856d = context;
        this.f1857e = intent;
    }

    /* renamed from: a */
    long m2432a() {
        return this.f1854a;
    }

    /* renamed from: a */
    public void m2433a(Intent intent) {
        if (this.f1855b != null) {
            this.f1855b.m2425a(0, intent);
        }
        this.f1858g = intent;
        synchronized (f1853f) {
            f1853f.notifyAll();
        }
    }

    /* renamed from: b */
    public C0621g m2434b() {
        this.f1857e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.f1856d.getPackageName());
        this.f1857e.putExtra("bd.cross.request.ID", this.f1854a);
        this.f1857e.putExtra("bd.cross.request.NEED_CALLBACK", true);
        this.f1857e.putExtra("bd.cross.request.SENDING", true);
        C0564d.m2428a(this);
        try {
            this.f1856d.startService(this.f1857e);
        } catch (Exception e) {
        }
        C0621g c0621g = new C0621g();
        C0559d.m2387a().m2388a(new C0420c(this, "timeOutRunnable-" + this.f1854a, (short) 50) {
            /* renamed from: a */
            final /* synthetic */ C0566e f1851a;

            /* renamed from: a */
            public void mo1272a() {
                try {
                    Thread.sleep((long) C0566e.f1852c);
                    synchronized (C0566e.f1853f) {
                        C0566e.f1853f.notifyAll();
                    }
                } catch (InterruptedException e) {
                }
            }
        });
        if (this.f1855b == null) {
            synchronized (f1853f) {
                try {
                    f1853f.wait();
                } catch (Exception e2) {
                }
            }
            m2435c();
            if (this.f1858g != null) {
                if (C0430a.m1857b() > 0 && this.f1858g.getBooleanExtra("bd.message.rate.MH", false)) {
                    this.f1858g.putExtra("bd.message.rate.END", System.currentTimeMillis());
                    C0571j.m2456a(this.f1856d, this.f1857e, this.f1858g);
                }
                c0621g.m2740a(this.f1858g.getIntExtra("bd.cross.request.RESULT_CODE", 10));
                if (this.f1858g.hasExtra("bd.cross.request.RESULT_DATA")) {
                    Object stringExtra = this.f1858g.getStringExtra("bd.cross.request.RESULT_DATA");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        c0621g.m2741a(stringExtra.getBytes());
                    }
                }
            } else {
                if (C0430a.m1857b() > 0 && this.f1857e.getBooleanExtra("bd.message.rate.MH", false)) {
                    this.f1857e.putExtra("bd.message.rate.TIMEOUT", System.currentTimeMillis());
                    C0571j.m2456a(this.f1856d, this.f1857e, null);
                }
                c0621g.m2740a(11);
            }
        }
        return c0621g;
    }

    /* renamed from: c */
    synchronized void m2435c() {
        this.f1855b = null;
        this.f1856d = null;
        C0564d.m2426a(this.f1854a);
    }
}
