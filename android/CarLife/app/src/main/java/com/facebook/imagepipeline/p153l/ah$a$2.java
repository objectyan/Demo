package com.facebook.imagepipeline.p153l;

import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p152i.C5534b;

/* compiled from: PostprocessorProducer */
/* renamed from: com.facebook.imagepipeline.l.ah$a$2 */
class ah$a$2 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ah$a f22510a;

    ah$a$2(ah$a this$1) {
        this.f22510a = this$1;
    }

    public void run() {
        synchronized (this.f22510a) {
            C2921a<C5534b> closeableImageRef = ah$a.b(this.f22510a);
            boolean isLast = ah$a.c(this.f22510a);
            ah$a.a(this.f22510a, null);
            ah$a.a(this.f22510a, false);
        }
        if (C2921a.a(closeableImageRef)) {
            try {
                ah$a.a(this.f22510a, closeableImageRef, isLast);
            } finally {
                C2921a.c(closeableImageRef);
            }
        }
        ah$a.d(this.f22510a);
    }
}
