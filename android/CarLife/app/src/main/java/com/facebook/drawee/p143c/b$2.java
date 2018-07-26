package com.facebook.drawee.p143c;

import com.facebook.common.internal.C2923j;
import com.facebook.common.internal.C5273m;
import com.facebook.p138c.C2918d;

/* compiled from: AbstractDraweeControllerBuilder */
/* renamed from: com.facebook.drawee.c.b$2 */
class b$2 implements C5273m<C2918d<IMAGE>> {
    /* renamed from: a */
    final /* synthetic */ Object f22045a;
    /* renamed from: b */
    final /* synthetic */ Object f22046b;
    /* renamed from: c */
    final /* synthetic */ boolean f22047c;
    /* renamed from: d */
    final /* synthetic */ C2928b f22048d;

    b$2(C2928b this$0, Object obj, Object obj2, boolean z) {
        this.f22048d = this$0;
        this.f22045a = obj;
        this.f22046b = obj2;
        this.f22047c = z;
    }

    /* renamed from: b */
    public /* synthetic */ Object mo3969b() {
        return m18485a();
    }

    /* renamed from: a */
    public C2918d<IMAGE> m18485a() {
        return this.f22048d.a(this.f22045a, this.f22046b, this.f22047c);
    }

    public String toString() {
        return C2923j.a(this).m18305a("request", this.f22045a.toString()).toString();
    }
}
