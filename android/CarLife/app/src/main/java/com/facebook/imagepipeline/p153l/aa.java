package com.facebook.imagepipeline.p153l;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: LocalResourceFetchProducer */
/* renamed from: com.facebook.imagepipeline.l.aa */
public class aa extends C5552y {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22480a = "LocalResourceFetchProducer";
    /* renamed from: b */
    private final Resources f22481b;

    public aa(Executor executor, C5642z pooledByteBufferFactory, Resources resources, boolean decodeFileDescriptorEnabled) {
        super(executor, pooledByteBufferFactory, decodeFileDescriptorEnabled);
        this.f22481b = resources;
    }

    /* renamed from: a */
    protected C2952d mo4123a(C2959c imageRequest) throws IOException {
        return m19152b(this.f22481b.openRawResource(aa.m19154c(imageRequest)), m19153b(imageRequest));
    }

    /* renamed from: b */
    private int m19153b(C2959c imageRequest) {
        int length;
        AssetFileDescriptor fd = null;
        try {
            fd = this.f22481b.openRawResourceFd(aa.m19154c(imageRequest));
            length = (int) fd.getLength();
            if (fd != null) {
                try {
                    fd.close();
                } catch (IOException e) {
                }
            }
        } catch (NotFoundException e2) {
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
        return f22480a;
    }

    /* renamed from: c */
    private static int m19154c(C2959c imageRequest) {
        return Integer.parseInt(imageRequest.b().getPath().substring(1));
    }
}
