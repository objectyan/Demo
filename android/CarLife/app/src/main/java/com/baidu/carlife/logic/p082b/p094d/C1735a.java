package com.baidu.carlife.logic.p082b.p094d;

import android.os.Bundle;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.p059c.C1105d;
import com.baidu.carlife.p059c.p067g.C1148b;

/* compiled from: ExecuteAndJumpTask */
/* renamed from: com.baidu.carlife.logic.b.d.a */
public class C1735a extends C1105d<Void, Void> {
    /* renamed from: a */
    private int f5261a;
    /* renamed from: b */
    private Bundle f5262b;

    /* compiled from: ExecuteAndJumpTask */
    /* renamed from: com.baidu.carlife.logic.b.d.a$1 */
    class C17421 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1735a f5271a;

        C17421(C1735a this$0) {
            this.f5271a = this$0;
        }

        public void run() {
            C1328h.m4757a().showFragment(this.f5271a.f5261a, this.f5271a.f5262b);
        }
    }

    public C1735a(int fragmentType, Bundle bundle) {
        this.f5261a = fragmentType;
        this.f5262b = bundle;
    }

    /* renamed from: a */
    public void m6318a(Void input) {
        mo1626b();
        C1148b.m3848a().m3849a(new C17421(this));
    }

    /* renamed from: b */
    protected void mo1626b() {
    }
}
