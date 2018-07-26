package com.facebook.p138c;

/* compiled from: AbstractDataSource */
/* renamed from: com.facebook.c.a$1 */
class a$1 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f21855a;
    /* renamed from: b */
    final /* synthetic */ C5287f f21856b;
    /* renamed from: c */
    final /* synthetic */ boolean f21857c;
    /* renamed from: d */
    final /* synthetic */ C2919a f21858d;

    a$1(C2919a this$0, boolean z, C5287f c5287f, boolean z2) {
        this.f21858d = this$0;
        this.f21855a = z;
        this.f21856b = c5287f;
        this.f21857c = z2;
    }

    public void run() {
        if (this.f21855a) {
            this.f21856b.mo3984b(this.f21858d);
        } else if (this.f21857c) {
            this.f21856b.mo3985c(this.f21858d);
        } else {
            this.f21856b.a_(this.f21858d);
        }
    }
}
