package com.facebook.imagepipeline.p153l;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: LocalAssetFetchProducer */
/* renamed from: com.facebook.imagepipeline.l.u */
public class C5607u extends C5552y {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22692a = "LocalAssetFetchProducer";
    /* renamed from: b */
    private final AssetManager f22693b;

    public C5607u(Executor executor, C5642z pooledByteBufferFactory, AssetManager assetManager, boolean decodeFileDescriptorEnabled) {
        super(executor, pooledByteBufferFactory, decodeFileDescriptorEnabled);
        this.f22693b = assetManager;
    }

    /* renamed from: a */
    protected C2952d mo4123a(C2959c imageRequest) throws IOException {
        return m19152b(this.f22693b.open(C5607u.m19409c(imageRequest), 2), m19408b(imageRequest));
    }

    /* renamed from: b */
    private int m19408b(C2959c imageRequest) {
        int length;
        AssetFileDescriptor fd = null;
        try {
            fd = this.f22693b.openFd(C5607u.m19409c(imageRequest));
            length = (int) fd.getLength();
            if (fd != null) {
                try {
                    fd.close();
                } catch (IOException e) {
                }
            }
        } catch (IOException e2) {
            length = -1;
            if (fd != null) {
                try {
                    fd.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (fd != null) {
                try {
                    fd.close();
                } catch (IOException e4) {
                }
            }
        }
        return length;
    }

    /* renamed from: a */
    protected String mo4124a() {
        return f22692a;
    }

    /* renamed from: c */
    private static String m19409c(C2959c imageRequest) {
        return imageRequest.b().getPath().substring(1);
    }
}
