package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: LocalFileFetchProducer */
/* renamed from: com.facebook.imagepipeline.l.z */
public class C5614z extends C5552y {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22710a = "LocalFileFetchProducer";

    public C5614z(Executor executor, C5642z pooledByteBufferFactory, boolean decodeFileDescriptorEnabled) {
        super(executor, pooledByteBufferFactory, decodeFileDescriptorEnabled);
    }

    /* renamed from: a */
    protected C2952d mo4123a(C2959c imageRequest) throws IOException {
        return m19152b(new FileInputStream(imageRequest.m().toString()), (int) imageRequest.m().length());
    }

    /* renamed from: a */
    protected String mo4124a() {
        return f22710a;
    }
}
