package com.baidu.carlife.logic.music.p098c;

import com.baidu.carlife.logic.music.C1790b;
import com.baidu.carlife.p059c.C1105d;
import com.baidu.carlife.p059c.p067g.C1148b;

/* compiled from: SwitchToPlayerTask */
/* renamed from: com.baidu.carlife.logic.music.c.a */
public class C1794a extends C1105d<Integer, Void> {
    /* renamed from: a */
    private C1790b f5509a;

    public C1794a(C1790b dataManager) {
        this.f5509a = dataManager;
    }

    /* renamed from: a */
    public void m6658a(final Integer position) {
        C1148b.m3848a().m3849a(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C1794a f5508b;

            public void run() {
                this.f5508b.f5509a.m6633h(position.intValue());
            }
        });
    }
}
