package com.indooratlas.android.sdk._internal;

import android.text.TextUtils;
import com.indooratlas.android.sdk._internal.gf.C5920a;
import java.io.IOException;

public final class aj implements gf {
    /* renamed from: a */
    public final gm mo4589a(C5920a c5920a) throws IOException {
        gk a = c5920a.mo4689a();
        Object a2 = a.m20710a("X-IA-Compress-Request");
        if (TextUtils.isEmpty(a2) || a.m20713d() == null) {
            return c5920a.mo4690a(a);
        }
        if (!a2.equalsIgnoreCase("true")) {
            return c5920a.mo4690a(a);
        }
        final gl d = a.m20713d();
        return c5920a.mo4690a(a.m20714e().m20704a("Content-Encoding", "gzip").m20703a(a.m20711b(), new gl(this) {
            /* renamed from: b */
            final /* synthetic */ aj f22949b;

            /* renamed from: a */
            public final gg mo4586a() {
                return d.mo4586a();
            }

            /* renamed from: b */
            public final long mo4588b() {
                return -1;
            }

            /* renamed from: a */
            public final void mo4587a(io ioVar) throws IOException {
                io a = ix.a(new iu(ioVar));
                d.mo4587a(a);
                a.close();
            }
        }).m20706a());
    }
}
