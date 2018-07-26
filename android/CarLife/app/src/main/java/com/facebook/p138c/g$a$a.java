package com.facebook.p138c;

/* compiled from: FirstAvailableDataSourceSupplier */
/* renamed from: com.facebook.c.g$a$a */
class g$a$a implements C5287f<T> {
    /* renamed from: a */
    final /* synthetic */ g$a f21866a;

    private g$a$a(g$a g_a) {
        this.f21866a = g_a;
    }

    /* renamed from: b */
    public void mo3984b(C2918d<T> dataSource) {
        g$a.a(this.f21866a, dataSource);
    }

    /* renamed from: c */
    public void mo3985c(C2918d<T> c2918d) {
    }

    public void a_(C2918d<T> dataSource) {
        if (dataSource.c()) {
            g$a.b(this.f21866a, dataSource);
        } else if (dataSource.b()) {
            g$a.a(this.f21866a, dataSource);
        }
    }

    /* renamed from: d */
    public void mo3986d(C2918d<T> dataSource) {
        this.f21866a.a(Math.max(this.f21866a.g(), dataSource.g()));
    }
}
