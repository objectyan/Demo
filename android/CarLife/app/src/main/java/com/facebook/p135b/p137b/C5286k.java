package com.facebook.p135b.p137b;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.p135b.p137b.C5266d.C5259c;

/* compiled from: ScoreBasedEvictionComparatorSupplier */
/* renamed from: com.facebook.b.b.k */
public class C5286k implements C5270i {
    /* renamed from: a */
    private final float f21853a;
    /* renamed from: b */
    private final float f21854b;

    /* compiled from: ScoreBasedEvictionComparatorSupplier */
    /* renamed from: com.facebook.b.b.k$1 */
    class C52851 implements C5268h {
        /* renamed from: a */
        long f21851a = System.currentTimeMillis();
        /* renamed from: b */
        final /* synthetic */ C5286k f21852b;

        C52851(C5286k this$0) {
            this.f21852b = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m18020a((C5259c) obj, (C5259c) obj2);
        }

        /* renamed from: a */
        public int m18020a(C5259c lhs, C5259c rhs) {
            float score1 = this.f21852b.m18021a(lhs, this.f21851a);
            float score2 = this.f21852b.m18021a(rhs, this.f21851a);
            if (score1 < score2) {
                return 1;
            }
            return score2 == score1 ? 0 : -1;
        }
    }

    public C5286k(float ageWeight, float sizeWeight) {
        this.f21853a = ageWeight;
        this.f21854b = sizeWeight;
    }

    /* renamed from: a */
    public C5268h mo3968a() {
        return new C52851(this);
    }

    @VisibleForTesting
    /* renamed from: a */
    float m18021a(C5259c entry, long now) {
        return (this.f21853a * ((float) (now - entry.mo3950b()))) + (this.f21854b * ((float) entry.mo3951d()));
    }
}
