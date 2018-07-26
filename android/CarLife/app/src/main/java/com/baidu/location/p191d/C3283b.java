package com.baidu.location.p191d;

import android.os.Handler;
import com.baidu.location.p187a.C3211m;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3218c;
import com.baidu.location.p194f.C3376f;

/* renamed from: com.baidu.location.d.b */
public class C3283b {
    /* renamed from: a */
    private static C3283b f17793a = null;
    /* renamed from: b */
    private Handler f17794b;
    /* renamed from: c */
    private boolean f17795c;
    /* renamed from: d */
    private boolean f17796d;

    /* renamed from: com.baidu.location.d.b$1 */
    class C32811 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3283b f17791a;

        C32811(C3283b c3283b) {
            this.f17791a = c3283b;
        }

        public void run() {
            this.f17791a.m13730d();
        }
    }

    /* renamed from: com.baidu.location.d.b$2 */
    class C32822 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3283b f17792a;

        C32822(C3283b c3283b) {
            this.f17792a = c3283b;
        }

        public void run() {
            this.f17792a.f17796d = false;
            if (this.f17792a.f17795c && C3218c.m13487a().m13494e()) {
                C3211m.m13441a().m13460d();
                if (C3376f.m14363j()) {
                    C3301g.m13879a().m13890f();
                }
                this.f17792a.f17794b.postDelayed(this, (long) C3391g.f18372Y);
                this.f17792a.f17796d = true;
            }
        }
    }

    private C3283b() {
        this.f17794b = null;
        this.f17795c = false;
        this.f17796d = false;
        this.f17794b = new Handler();
    }

    /* renamed from: a */
    public static C3283b m13725a() {
        if (f17793a == null) {
            f17793a = new C3283b();
        }
        return f17793a;
    }

    /* renamed from: d */
    private void m13730d() {
        this.f17795c = true;
        if (!this.f17796d) {
            this.f17794b.postDelayed(new C32822(this), 2000);
            this.f17796d = true;
        }
    }

    /* renamed from: b */
    public void m13731b() {
        this.f17794b.post(new C32811(this));
    }

    /* renamed from: c */
    public void m13732c() {
        this.f17795c = false;
    }
}
