package com.facebook.drawee.p143c;

import com.facebook.p138c.C2918d;
import com.facebook.p138c.C5289c;

/* compiled from: AbstractDraweeController */
/* renamed from: com.facebook.drawee.c.a$1 */
class a$1 extends C5289c<T> {
    /* renamed from: a */
    final /* synthetic */ String f22039a;
    /* renamed from: b */
    final /* synthetic */ boolean f22040b;
    /* renamed from: c */
    final /* synthetic */ C2926a f22041c;

    a$1(C2926a this$0, String str, boolean z) {
        this.f22041c = this$0;
        this.f22039a = str;
        this.f22040b = z;
    }

    /* renamed from: e */
    public void mo4022e(C2918d<T> dataSource) {
        boolean isFinished = dataSource.b();
        float progress = dataSource.g();
        T image = dataSource.d();
        if (image != null) {
            C2926a.a(this.f22041c, this.f22039a, dataSource, image, progress, isFinished, this.f22040b);
        } else if (isFinished) {
            C2926a.a(this.f22041c, this.f22039a, dataSource, new NullPointerException(), true);
        }
    }

    /* renamed from: a */
    public void mo4021a(C2918d<T> dataSource) {
        C2926a.a(this.f22041c, this.f22039a, dataSource, dataSource.f(), true);
    }

    /* renamed from: d */
    public void mo3986d(C2918d<T> dataSource) {
        boolean isFinished = dataSource.b();
        C2926a.a(this.f22041c, this.f22039a, dataSource, dataSource.g(), isFinished);
    }
}
