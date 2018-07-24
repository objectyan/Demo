package com.baidu.carlife.logic.music;

import java.util.Random;

/* compiled from: PlayTimeCalculator */
/* renamed from: com.baidu.carlife.logic.music.p */
public class C1834p {
    /* renamed from: a */
    private long f5685a;
    /* renamed from: b */
    private C1833b f5686b;
    /* renamed from: c */
    private long f5687c;

    /* compiled from: PlayTimeCalculator */
    /* renamed from: com.baidu.carlife.logic.music.p$a */
    private static class C1832a {
        /* renamed from: a */
        private static final C1834p f5679a = new C1834p();

        private C1832a() {
        }
    }

    /* compiled from: PlayTimeCalculator */
    /* renamed from: com.baidu.carlife.logic.music.p$b */
    private enum C1833b {
        IDLE,
        START,
        PAUSE,
        RESUME
    }

    private C1834p() {
        this.f5685a = System.currentTimeMillis();
        this.f5686b = C1833b.IDLE;
        this.f5687c = 0;
    }

    /* renamed from: a */
    public static C1834p m6925a() {
        return C1832a.f5679a;
    }

    /* renamed from: b */
    public void m6926b() {
        if (this.f5686b == C1833b.IDLE) {
            this.f5687c = 0;
            this.f5685a = System.currentTimeMillis();
            this.f5686b = C1833b.RESUME;
        }
    }

    /* renamed from: c */
    public void m6927c() {
        if (this.f5686b == C1833b.RESUME) {
            this.f5687c += System.currentTimeMillis() - this.f5685a;
            this.f5686b = C1833b.PAUSE;
        }
    }

    /* renamed from: d */
    public void m6928d() {
        if (this.f5686b == C1833b.PAUSE) {
            this.f5685a = System.currentTimeMillis();
            this.f5686b = C1833b.RESUME;
        }
    }

    /* renamed from: e */
    public long m6929e() {
        long time = m6930f();
        this.f5686b = C1833b.IDLE;
        this.f5687c = 0;
        this.f5685a = System.currentTimeMillis();
        return time;
    }

    /* renamed from: f */
    public long m6930f() {
        if (this.f5686b == C1833b.PAUSE) {
            return m6924a(this.f5687c);
        }
        if (this.f5686b == C1833b.RESUME) {
            return m6924a((System.currentTimeMillis() - this.f5685a) + this.f5687c);
        }
        return 0;
    }

    /* renamed from: a */
    private long m6924a(long playTime) {
        if (playTime <= 0) {
            return m6923a(0, 100);
        }
        if (playTime >= 7200000) {
            return m6923a(0, 1000) + 7200000;
        }
        return playTime;
    }

    /* renamed from: a */
    private long m6923a(int min, int max) {
        return (long) (new Random().nextInt((max - min) + 1) + min);
    }
}
