package com.baidu.carlife.logic.p082b.p094d;

import android.os.Bundle;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.p059c.C1105d;
import com.baidu.carlife.p059c.p067g.C1148b;

/* compiled from: JumpTask */
/* renamed from: com.baidu.carlife.logic.b.d.b */
public class C1744b extends C1105d<Void, Void> {
    /* renamed from: a */
    private int f5273a;
    /* renamed from: b */
    private Bundle f5274b;

    /* compiled from: JumpTask */
    /* renamed from: com.baidu.carlife.logic.b.d.b$1 */
    class C17431 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1744b f5272a;

        C17431(C1744b this$0) {
            this.f5272a = this$0;
        }

        public void run() {
            FragmentManagerCallbackProxy.m4757a().showFragment(this.f5272a.f5273a, this.f5272a.f5274b);
        }
    }

    public C1744b(int fragmentType, Bundle bundle) {
        this.f5273a = fragmentType;
        this.f5274b = bundle;
    }

    /* renamed from: a */
    public void m6329a(Void input) {
        C1148b.m3848a().m3849a(new C17431(this));
    }
}
