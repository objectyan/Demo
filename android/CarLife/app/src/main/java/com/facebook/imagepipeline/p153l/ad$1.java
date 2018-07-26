package com.facebook.imagepipeline.p153l;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkFetchProducer */
/* renamed from: com.facebook.imagepipeline.l.ad$1 */
class ad$1 implements ae$a {
    /* renamed from: a */
    final /* synthetic */ C5453r f22498a;
    /* renamed from: b */
    final /* synthetic */ ad f22499b;

    ad$1(ad this$0, C5453r c5453r) {
        this.f22499b = this$0;
        this.f22498a = c5453r;
    }

    /* renamed from: a */
    public void mo4132a(InputStream response, int responseLength) throws IOException {
        ad.a(this.f22499b, this.f22498a, response, responseLength);
    }

    /* renamed from: a */
    public void mo4133a(Throwable throwable) {
        ad.a(this.f22499b, this.f22498a, throwable);
    }

    /* renamed from: a */
    public void mo4131a() {
        ad.a(this.f22499b, this.f22498a);
    }
}
