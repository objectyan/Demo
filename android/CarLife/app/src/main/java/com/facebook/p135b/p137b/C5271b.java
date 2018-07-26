package com.facebook.p135b.p137b;

import com.facebook.p135b.p137b.C5266d.C5259c;

/* compiled from: DefaultEntryEvictionComparatorSupplier */
/* renamed from: com.facebook.b.b.b */
public class C5271b implements C5270i {

    /* compiled from: DefaultEntryEvictionComparatorSupplier */
    /* renamed from: com.facebook.b.b.b$1 */
    class C52691 implements C5268h {
        /* renamed from: a */
        final /* synthetic */ C5271b f21794a;

        C52691(C5271b this$0) {
            this.f21794a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m17928a((C5259c) obj, (C5259c) obj2);
        }

        /* renamed from: a */
        public int m17928a(C5259c e1, C5259c e2) {
            long time1 = e1.mo3950b();
            long time2 = e2.mo3950b();
            if (time1 < time2) {
                return -1;
            }
            return time2 == time1 ? 0 : 1;
        }
    }

    /* renamed from: a */
    public C5268h mo3968a() {
        return new C52691(this);
    }
}
