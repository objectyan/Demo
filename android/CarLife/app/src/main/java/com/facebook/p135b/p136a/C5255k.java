package com.facebook.p135b.p136a;

import com.facebook.common.internal.C5341b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: WriterCallbacks */
/* renamed from: com.facebook.b.a.k */
public class C5255k {
    /* renamed from: a */
    public static C5252j m17855a(final InputStream is) {
        return new C5252j() {
            /* renamed from: a */
            public void mo3945a(OutputStream os) throws IOException {
                C5341b.m18269a(is, os);
            }
        };
    }

    /* renamed from: a */
    public static C5252j m17856a(final byte[] data) {
        return new C5252j() {
            /* renamed from: a */
            public void mo3945a(OutputStream os) throws IOException {
                os.write(data);
            }
        };
    }
}
