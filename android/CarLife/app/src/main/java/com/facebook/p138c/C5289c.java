package com.facebook.p138c;

/* compiled from: BaseDataSubscriber */
/* renamed from: com.facebook.c.c */
public abstract class C5289c<T> implements C5287f<T> {
    /* renamed from: a */
    protected abstract void mo4021a(C2918d<T> c2918d);

    /* renamed from: e */
    protected abstract void mo4022e(C2918d<T> c2918d);

    public void a_(C2918d<T> dataSource) {
        boolean shouldClose = dataSource.b();
        try {
            mo4022e(dataSource);
        } finally {
            if (shouldClose) {
                dataSource.h();
            }
        }
    }

    /* renamed from: b */
    public void mo3984b(C2918d<T> dataSource) {
        try {
            mo4021a(dataSource);
        } finally {
            dataSource.h();
        }
    }

    /* renamed from: c */
    public void mo3985c(C2918d<T> c2918d) {
    }

    /* renamed from: d */
    public void mo3986d(C2918d<T> c2918d) {
    }
}
