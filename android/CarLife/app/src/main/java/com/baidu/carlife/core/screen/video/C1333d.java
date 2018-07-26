package com.baidu.carlife.core.screen.video;

import com.baidu.carlife.core.C1260i;

/* compiled from: ReceiverAndConverterThreadInternal */
/* renamed from: com.baidu.carlife.core.screen.video.d */
public class C1333d extends C1330a {
    /* renamed from: h */
    private static final String f3850h = "Recorder";
    /* renamed from: i */
    private static final String f3851i = "--QA-TEST--";
    /* renamed from: j */
    private static byte[] f3852j;
    /* renamed from: k */
    private static C1338e f3853k = C1338e.m4826b();
    /* renamed from: l */
    private long f3854l = ((long) C1338e.f3864e);
    /* renamed from: m */
    private long f3855m = 0;

    public C1333d() {
        d = f3853k.f3906g;
        e = f3853k.f3907h;
        f = f3853k.f3905f;
    }

    /* renamed from: a */
    public void mo1523a() {
        this.a = false;
        f3853k.m4891v();
    }

    /* renamed from: a */
    public void mo1524a(int newRate) {
        this.f3854l = (long) (1000 / newRate);
    }

    /* renamed from: c */
    private void m4807c() {
        C1260i.m4435b(f3850h, "ReceiverAndConverterThreadInternal  stopThreadInner");
        this.a = false;
        f3853k.m4891v();
        f3853k.m4836C();
    }

    public void run() {
        if (f3853k.m4879j() || f3853k.m4840G()) {
            this.f3854l = (long) C1338e.f3864e;
            try {
                f3853k.m4874g(true);
                C1260i.m4435b(f3850h, "ReceiverAndConverterThreadInternal isRunning=" + this.a);
                int mColorFormat = f3853k.m4886q();
                C1260i.m4435b(f3850h, "isJPEGMode=" + f3853k.m4879j() + ", mColorFormat=" + mColorFormat);
                if (!f3853k.m4879j()) {
                    if (mColorFormat == 15 || mColorFormat == 16) {
                        if (f3853k.m4837D() || C1341g.m4915b()) {
                            f3853k.m4876h(false);
                        } else {
                            m4806a(false);
                            C1341g.m4912a(d);
                        }
                        f3853k.m4834A();
                        while (this.a) {
                            m4809e();
                        }
                        C1260i.m4435b(f3850h, "ReceiverAndConverterThreadInternal  run finished.");
                        m4807c();
                    }
                    if ((f3853k.m4837D() && f3852j == null) || C1341g.m4915b()) {
                        if (mColorFormat == 6 || mColorFormat == 7) {
                            f3852j = new byte[((C1338e.f3861b * C1338e.f3862c) * 2)];
                        } else {
                            f3852j = new byte[(((C1338e.f3861b * C1338e.f3862c) * 3) / 2)];
                        }
                        f3853k.m4876h(false);
                        C1260i.m4440c(f3850h, "run mColorFormat == 6 || mColorFormat == 7");
                    } else {
                        m4806a(true);
                        C1341g.m4912a(f3852j);
                        C1260i.m4440c(f3850h, "VideoOutputThread.firstSendEncodeFrame(mDestFormatBuf);");
                    }
                    f3853k.m4834A();
                    while (this.a) {
                        C1260i.m4440c(f3850h, "enter  readAndConvert, isRunning=" + this.a);
                        m4808d();
                    }
                    C1260i.m4435b(f3850h, "ReceiverAndConverterThreadInternal  run finished.");
                    m4807c();
                }
            } catch (NullPointerException e) {
                C1260i.m4440c(f3850h, "Output Thread closeLocalSocket lead to");
            }
        } else {
            m4807c();
        }
    }

    /* renamed from: d */
    private void m4808d() {
        if (f3853k.m4870e()) {
            if (f3853k.m4846M() == -1) {
                m4807c();
            }
            try {
                Thread.sleep(50);
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        m4810f();
        JniMethod.convert(d, f3852j, C1338e.f3861b, C1338e.f3862c);
        int flag = f3853k.m4852a(f3852j);
        if (flag == -2 && !f3853k.m4843J()) {
            m4807c();
        }
        C1260i.m4440c(f3850h, "input2Encoder success flag= " + flag);
    }

    /* renamed from: e */
    private void m4809e() {
        if (f3853k.m4870e()) {
            if (f3853k.m4846M() == -1) {
                m4807c();
            }
            try {
                Thread.sleep(50);
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        long startTime = System.currentTimeMillis();
        m4810f();
        C1260i.m4440c(f3851i, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        if (f3853k.m4852a(d) == -2 && !f3853k.m4843J()) {
            m4807c();
        }
        C1260i.m4440c(f3851i, "JAVA encode time = " + (System.currentTimeMillis() - startTime));
    }

    /* renamed from: a */
    private void m4806a(boolean needConvert) {
        m4810f();
        if (needConvert) {
            JniMethod.convert(d, f3852j, C1338e.f3861b, C1338e.f3862c);
        }
    }

    /* renamed from: f */
    private void m4810f() {
        long startTime = System.currentTimeMillis();
        if (startTime - this.f3855m < this.f3854l) {
            try {
                Thread.sleep((this.f3854l - startTime) + this.f3855m);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f3855m = System.currentTimeMillis();
        synchronized (f) {
            e.clear();
            f.copyPixelsToBuffer(e);
        }
    }
}
