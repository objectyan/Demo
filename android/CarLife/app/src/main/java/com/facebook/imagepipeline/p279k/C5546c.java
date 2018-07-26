package com.facebook.imagepipeline.p279k;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.MemoryFile;
import com.facebook.common.internal.C5341b;
import com.facebook.common.internal.C5342c;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.C5354o;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p261k.C5357a;
import com.facebook.common.p263n.C5374b;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.memory.aa;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* compiled from: GingerbreadPurgeableDecoder */
/* renamed from: com.facebook.imagepipeline.k.c */
public class C5546c extends C5545b {
    /* renamed from: b */
    private static Method f22472b;
    /* renamed from: c */
    private final boolean f22473c;

    public C5546c(boolean webpSupportEnabled) {
        this.f22473c = webpSupportEnabled;
    }

    /* renamed from: a */
    protected Bitmap mo4120a(C2921a<C5640y> bytesRef, Options options) {
        return m19128a(bytesRef, ((C5640y) bytesRef.a()).mo4155a(), null, options);
    }

    /* renamed from: a */
    protected Bitmap mo4119a(C2921a<C5640y> bytesRef, int length, Options options) {
        return m19128a(bytesRef, length, C5545b.m19118a((C2921a) bytesRef, length) ? null : a, options);
    }

    /* renamed from: a */
    private static MemoryFile m19124a(C2921a<C5640y> bytesRef, int inputLength, @Nullable byte[] suffix) throws IOException {
        Throwable th;
        MemoryFile memoryFile = new MemoryFile(null, inputLength + (suffix == null ? 0 : suffix.length));
        memoryFile.allowPurging(false);
        InputStream pbbIs = null;
        InputStream is = null;
        try {
            InputStream pbbIs2 = new aa((C5640y) bytesRef.a());
            try {
                InputStream is2 = new C5357a(pbbIs2, inputLength);
                try {
                    OutputStream os = memoryFile.getOutputStream();
                    C5341b.m18269a(is2, os);
                    if (suffix != null) {
                        memoryFile.writeBytes(suffix, 0, inputLength, suffix.length);
                    }
                    C2921a.c(bytesRef);
                    C5342c.m18274a(pbbIs2);
                    C5342c.m18274a(is2);
                    C5342c.m18273a(os, true);
                    return memoryFile;
                } catch (Throwable th2) {
                    th = th2;
                    is = is2;
                    pbbIs = pbbIs2;
                    C2921a.c(bytesRef);
                    C5342c.m18274a(pbbIs);
                    C5342c.m18274a(is);
                    C5342c.m18273a(null, true);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                pbbIs = pbbIs2;
                C2921a.c(bytesRef);
                C5342c.m18274a(pbbIs);
                C5342c.m18274a(is);
                C5342c.m18273a(null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            C2921a.c(bytesRef);
            C5342c.m18274a(pbbIs);
            C5342c.m18274a(is);
            C5342c.m18273a(null, true);
            throw th;
        }
    }

    /* renamed from: a */
    private synchronized Method m19126a() {
        if (f22472b == null) {
            try {
                f22472b = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                throw C5354o.m18340b(e);
            }
        }
        return f22472b;
    }

    /* renamed from: a */
    private FileDescriptor m19125a(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) m19126a().invoke(memoryFile, new Object[0]);
        } catch (Exception e) {
            throw C5354o.m18340b(e);
        }
    }

    /* renamed from: a */
    protected Bitmap m19128a(C2921a<C5640y> bytesRef, int inputLength, byte[] suffix, Options options) {
        MemoryFile memoryFile = null;
        try {
            Object bitmap;
            memoryFile = C5546c.m19124a((C2921a) bytesRef, inputLength, suffix);
            FileDescriptor fd = m19125a(memoryFile);
            if (this.f22473c) {
                bitmap = C5374b.f21964d.m18397a(fd, null, options);
            } else {
                bitmap = BitmapFactory.decodeFileDescriptor(fd, null, options);
            }
            Bitmap bitmap2 = (Bitmap) C5350k.m18311a(bitmap, (Object) "BitmapFactory returned null");
            if (memoryFile != null) {
                memoryFile.close();
            }
            return bitmap2;
        } catch (IOException e) {
            throw C5354o.m18340b(e);
        } catch (Throwable th) {
            if (memoryFile != null) {
                memoryFile.close();
            }
        }
    }
}
