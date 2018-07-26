package com.baidu.mapframework.nirvana;

import java.util.concurrent.ThreadFactory;

/* compiled from: NirvanaThreadFactory */
/* renamed from: com.baidu.mapframework.nirvana.i */
public class C3544i implements ThreadFactory {
    /* renamed from: a */
    private String f19172a;

    public C3544i(String name) {
        this.f19172a = "Nirvana-ThreadFactory-" + name;
    }

    public Thread newThread(Runnable r) {
        return new C3543h(r, this.f19172a);
    }
}
