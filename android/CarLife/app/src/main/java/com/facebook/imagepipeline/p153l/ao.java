package com.facebook.imagepipeline.p153l;

import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p154m.c$b;
import com.facebook.imagepipeline.p276e.C5494c;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: SettableProducerContext */
/* renamed from: com.facebook.imagepipeline.l.ao */
public class ao extends C2954d {
    public ao(C2959c imageRequest, String id, al producerListener, Object callerContext, c$b lowestPermittedRequestLevel, boolean isPrefetch, boolean isIntermediateResultExpected, C5494c priority) {
        super(imageRequest, id, producerListener, callerContext, lowestPermittedRequestLevel, isPrefetch, isIntermediateResultExpected, priority);
    }

    /* renamed from: c */
    public void m19247c(boolean isPrefetch) {
        C2954d.b(a(isPrefetch));
    }

    /* renamed from: d */
    public void m19248d(boolean isIntermediateResultExpected) {
        C2954d.c(b(isIntermediateResultExpected));
    }

    /* renamed from: b */
    public void m19246b(C5494c priority) {
        C2954d.d(a(priority));
    }
}
