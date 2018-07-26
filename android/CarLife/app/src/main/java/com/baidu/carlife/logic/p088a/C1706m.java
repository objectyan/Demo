package com.baidu.carlife.logic.p088a;

import com.baidu.carlife.core.C1262l;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.mobstat.Config;

/* compiled from: TimeOutCounter */
/* renamed from: com.baidu.carlife.logic.a.m */
public class C1706m {

    /* compiled from: TimeOutCounter */
    /* renamed from: com.baidu.carlife.logic.a.m$1 */
    class C17041 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1706m f5204a;

        C17041(C1706m this$0) {
            this.f5204a = this$0;
        }

        public void run() {
            if (this.f5204a.m6201c()) {
                C1702j.m6181a().m6189d().m6407a();
                C1818h.m6730b().m6767A();
                C1818h.m6730b().m6811f(true);
            }
        }
    }

    /* compiled from: TimeOutCounter */
    /* renamed from: com.baidu.carlife.logic.a.m$a */
    private static class C1705a {
        /* renamed from: a */
        private static final C1706m f5205a = new C1706m();

        private C1705a() {
        }
    }

    private C1706m() {
    }

    /* renamed from: a */
    public static C1706m m6199a() {
        return C1705a.f5205a;
    }

    /* renamed from: b */
    public void m6202b() {
        C1262l.m4465a().postDelayed(new C17041(this), Config.BPLUS_DELAY_TIME);
    }

    /* renamed from: c */
    private boolean m6201c() {
        return !C1818h.m6730b().m6834v() && C1702j.m6181a().m6192g();
    }
}
