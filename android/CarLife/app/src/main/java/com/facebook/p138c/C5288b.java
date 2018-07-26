package com.facebook.p138c;

/* compiled from: BaseBooleanSubscriber */
/* renamed from: com.facebook.c.b */
public abstract class C5288b implements C5287f<Boolean> {
    /* renamed from: a */
    protected abstract void m18026a(boolean z);

    /* renamed from: e */
    protected abstract void m18030e(C2918d<Boolean> c2918d);

    public void a_(C2918d<Boolean> dataSource) {
        try {
            m18026a(((Boolean) dataSource.d()).booleanValue());
        } finally {
            dataSource.h();
        }
    }

    /* renamed from: b */
    public void mo3984b(C2918d<Boolean> dataSource) {
        try {
            m18030e(dataSource);
        } finally {
            dataSource.h();
        }
    }

    /* renamed from: c */
    public void mo3985c(C2918d<Boolean> c2918d) {
    }

    /* renamed from: d */
    public void mo3986d(C2918d<Boolean> c2918d) {
    }
}
