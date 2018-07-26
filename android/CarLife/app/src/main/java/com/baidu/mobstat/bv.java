package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

class bv {
    /* renamed from: a */
    private static final bv f19528a = new bv();
    /* renamed from: b */
    private Context f19529b;
    /* renamed from: c */
    private volatile boolean f19530c = false;
    /* renamed from: d */
    private volatile boolean f19531d = false;
    /* renamed from: e */
    private volatile boolean f19532e = false;
    /* renamed from: f */
    private HandlerThread f19533f;
    /* renamed from: g */
    private Handler f19534g;

    /* renamed from: a */
    public static bv m15511a() {
        return f19528a;
    }

    private bv() {
    }

    /* renamed from: a */
    public void m15516a(Context context, boolean z) {
        try {
            m15511a().m15518b(context.getApplicationContext());
        } catch (Throwable th) {
        }
        m15514b(context.getApplicationContext(), z);
    }

    /* renamed from: a */
    public void m15515a(Context context) {
        m15516a(context, false);
    }

    /* renamed from: b */
    public void m15518b(Context context) {
        if (!this.f19532e && context != null) {
            if (this.f19533f == null || !this.f19533f.isAlive()) {
                this.f19533f = new HandlerThread("dataAnalyzeThread");
                this.f19533f.start();
                Looper looper = this.f19533f.getLooper();
                if (looper != null) {
                    this.f19534g = new Handler(looper);
                }
            }
            if (this.f19534g != null) {
                this.f19534g.postDelayed(new bw(this, context), Config.BPLUS_DELAY_TIME);
                this.f19532e = true;
            }
        }
    }

    /* renamed from: b */
    private void m15514b(Context context, boolean z) {
        if (context != null && !this.f19530c) {
            this.f19529b = context.getApplicationContext();
            m15512a(z);
            this.f19530c = true;
        }
    }

    /* renamed from: b */
    public synchronized boolean m15519b() {
        return this.f19530c;
    }

    /* renamed from: c */
    public synchronized boolean m15520c() {
        return this.f19531d;
    }

    /* renamed from: a */
    private synchronized void m15512a(boolean z) {
        bx bxVar = new bx(this, z);
        bxVar.setPriority(10);
        bxVar.start();
    }

    /* renamed from: d */
    public void m15521d() {
        if (!this.f19531d) {
            synchronized (this) {
                while (!this.f19531d) {
                    try {
                        wait(50);
                    } catch (InterruptedException e) {
                        db.m15661b(e.getMessage());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m15517a(Context context, boolean z, boolean z2) {
        if (!this.f19531d) {
            PrefOperate.loadMetaDataConfig(context);
            DataCore.instance().loadStatData(context);
            DataCore.instance().loadLastSession(context);
            DataCore.instance().installHeader(context);
            if (z) {
                DataCore.instance().saveLogDataToSend(context, true, z2);
            }
            this.f19531d = true;
        }
    }
}
