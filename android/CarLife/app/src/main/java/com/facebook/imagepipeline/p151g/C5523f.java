package com.facebook.imagepipeline.p151g;

import com.facebook.imagepipeline.p153l.ai;
import com.facebook.imagepipeline.p153l.ao;
import com.facebook.imagepipeline.p278j.C5539c;
import com.facebook.p138c.C2918d;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: ProducerToDataSourceAdapter */
/* renamed from: com.facebook.imagepipeline.g.f */
public class C5523f<T> extends C5520a<T> {
    /* renamed from: a */
    public static <T> C2918d<T> m19023a(ai<T> producer, ao settableProducerContext, C5539c listener) {
        return new C5523f(producer, settableProducerContext, listener);
    }

    private C5523f(ai<T> producer, ao settableProducerContext, C5539c listener) {
        super(producer, settableProducerContext, listener);
    }
}
