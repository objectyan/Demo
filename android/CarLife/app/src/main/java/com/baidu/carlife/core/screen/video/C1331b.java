package com.baidu.carlife.core.screen.video;

import android.graphics.Bitmap.CompressFormat;
import com.baidu.carlife.core.C1260i;

/* compiled from: ReceiverAndConverter50Thread */
/* renamed from: com.baidu.carlife.core.screen.video.b */
class C1331b extends C1330a {
    /* renamed from: h */
    private static final String f3839h = "Recorder";
    /* renamed from: i */
    private static C1338e f3840i = C1338e.m4826b();
    /* renamed from: j */
    private long f3841j = ((long) C1338e.f3864e);
    /* renamed from: k */
    private long f3842k = 0;

    public C1331b() {
        f = f3840i.f3905f;
    }

    /* renamed from: a */
    public void mo1523a() {
        this.a = false;
        f3840i.m4891v();
    }

    /* renamed from: a */
    public void mo1524a(int newRate) {
        this.f3841j = (long) (1000 / newRate);
    }

    /* renamed from: c */
    private void m4793c() {
        C1260i.m4435b(f3839h, "ReceiverAndConverter50Thread  stopThreadInner");
        this.a = false;
        f3840i.m4891v();
        f3840i.m4836C();
    }

    /* renamed from: d */
    private void m4794d() {
        m4795e();
        synchronized (f) {
            f.compress(CompressFormat.JPEG, 70, this.g);
        }
        if (f3840i.m4853a(this.g.toByteArray(), this.g.size()) == -1) {
            m4793c();
        }
        this.g.reset();
    }

    public void run() {
        if (f3840i.m4879j()) {
            this.f3841j = (long) C1338e.f3864e;
            try {
                f3840i.m4874g(true);
                C1260i.m4435b(f3839h, "ReceiverAndConverter50Thread isRunning=" + this.a);
                if (f3840i.m4879j()) {
                    while (this.a) {
                        m4794d();
                    }
                    return;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            C1260i.m4435b(f3839h, "ReceiverAndConverter50Thread  run finished.");
            m4793c();
        }
    }

    /* renamed from: e */
    private void m4795e() {
        long startTime = System.currentTimeMillis();
        if (startTime - this.f3842k < this.f3841j) {
            try {
                Thread.sleep((this.f3841j - startTime) + this.f3842k);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f3842k = System.currentTimeMillis();
    }
}
