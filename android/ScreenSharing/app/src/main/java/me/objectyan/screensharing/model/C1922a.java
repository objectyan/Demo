package com.baidu.carlife.model;

import com.baidu.carlife.R;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;

/* compiled from: AppAdminModel */
/* renamed from: com.baidu.carlife.model.a */
public class C1922a extends C1921b {
    /* renamed from: h */
    private static final String f5933h = "AppsAdministrationFragment";
    /* renamed from: a */
    public String f5934a;
    /* renamed from: b */
    public String f5935b;
    /* renamed from: c */
    public int f5936c = 0;
    /* renamed from: d */
    public C1920a f5937d;
    /* renamed from: e */
    public int f5938e = R.drawable.douban_fm;

    /* compiled from: AppAdminModel */
    /* renamed from: com.baidu.carlife.model.a$a */
    private class C1920a extends Thread {
        /* renamed from: a */
        final /* synthetic */ C1922a f5928a;
        /* renamed from: b */
        private boolean f5929b;
        /* renamed from: c */
        private boolean f5930c;

        private C1920a(C1922a c1922a) {
            this.f5928a = c1922a;
            this.f5929b = false;
            this.f5930c = false;
        }

        public void run() {
            while (!this.f5930c) {
                if (!this.f5929b) {
                    C1922a c1922a = this.f5928a;
                    c1922a.f5936c++;
                }
                if (100 == this.f5928a.f5936c) {
                    this.f5930c = true;
                    this.f5928a.mo1723a(3);
                }
                LogUtil.e(C1922a.f5933h, "-----download-------progress:" + this.f5928a.f5936c);
                try {
                    MsgHandlerCenter.dispatchMessage(600);
                    C1920a.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: a */
        public void m7378a(boolean isPaused) {
            this.f5929b = isPaused;
        }
    }

    /* renamed from: a */
    public void mo1723a(int curStatus) {
        this.f = curStatus;
        switch (this.f) {
            case 0:
                this.f5934a = CommonParams.gp;
                this.f5935b = CommonParams.gu;
                return;
            case 1:
                this.f5934a = CommonParams.gq;
                this.f5935b = CommonParams.gr;
                return;
            case 2:
                this.f5934a = CommonParams.gr;
                this.f5935b = CommonParams.gu;
                return;
            case 3:
                this.f5934a = CommonParams.gs;
                this.f5935b = CommonParams.gv;
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m7380a() {
        if (this.f5937d == null) {
            this.f5937d = new C1920a();
        }
        if (this.f == 0) {
            this.f5937d.start();
        } else if (2 == this.f) {
            this.f5937d.m7378a(false);
        }
    }

    /* renamed from: b */
    public void m7382b() {
        if (this.f5937d == null) {
            this.f5937d = new C1920a();
        }
        this.f5937d.m7378a(true);
    }
}
