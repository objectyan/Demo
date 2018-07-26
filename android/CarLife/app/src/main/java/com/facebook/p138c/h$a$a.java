package com.facebook.p138c;

/* compiled from: IncreasingQualityDataSourceSupplier */
/* renamed from: com.facebook.c.h$a$a */
class h$a$a implements C5287f<T> {
    /* renamed from: a */
    final /* synthetic */ h$a f21868a;
    /* renamed from: b */
    private int f21869b;

    public h$a$a(h$a h_a, int index) {
        this.f21868a = h_a;
        this.f21869b = index;
    }

    public void a_(C2918d<T> dataSource) {
        if (dataSource.c()) {
            h$a.a(this.f21868a, this.f21869b, dataSource);
        } else if (dataSource.b()) {
            h$a.b(this.f21868a, this.f21869b, dataSource);
        }
    }

    /* renamed from: b */
    public void mo3984b(C2918d<T> dataSource) {
        h$a.b(this.f21868a, this.f21869b, dataSource);
    }

    /* renamed from: c */
    public void mo3985c(C2918d<T> c2918d) {
    }

    /* renamed from: d */
    public void mo3986d(C2918d<T> dataSource) {
        if (this.f21869b == 0) {
            this.f21868a.a(dataSource.g());
        }
    }
}
