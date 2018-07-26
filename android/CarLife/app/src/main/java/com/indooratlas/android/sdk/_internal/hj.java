package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

final class hj {
    /* renamed from: a */
    int f24216a;
    /* renamed from: b */
    final ip f24217b = ix.a(this.f24218c);
    /* renamed from: c */
    private final iw f24218c;

    /* renamed from: com.indooratlas.android.sdk._internal.hj$2 */
    class C59622 extends Inflater {
        /* renamed from: a */
        final /* synthetic */ hj f24215a;

        C59622(hj hjVar) {
            this.f24215a = hjVar;
        }

        public final int inflate(byte[] buffer, int offset, int count) throws DataFormatException {
            int inflate = super.inflate(buffer, offset, count);
            if (inflate != 0 || !needsDictionary()) {
                return inflate;
            }
            setDictionary(hn.f24235a);
            return super.inflate(buffer, offset, count);
        }
    }

    public hj(ip ipVar) {
        this.f24218c = new iw(new is(this, ipVar) {
            /* renamed from: a */
            final /* synthetic */ hj f24214a;

            /* renamed from: a */
            public final long m20970a(in inVar, long j) throws IOException {
                if (this.f24214a.f24216a == 0) {
                    return -1;
                }
                long a = super.a(inVar, Math.min(j, (long) this.f24214a.f24216a));
                if (a == -1) {
                    return -1;
                }
                this.f24214a.f24216a = (int) (((long) this.f24214a.f24216a) - a);
                return a;
            }
        }, new C59622(this));
    }

    /* renamed from: a */
    public final List<he> m20972a(int i) throws IOException {
        this.f24216a += i;
        int g = this.f24217b.g();
        if (g < 0) {
            throw new IOException("numberOfPairs < 0: " + g);
        } else if (g > 1024) {
            throw new IOException("numberOfPairs > 1024: " + g);
        } else {
            List<he> arrayList = new ArrayList(g);
            for (int i2 = 0; i2 < g; i2++) {
                iq c = m20971a().c();
                iq a = m20971a();
                if (c.f24395c.length == 0) {
                    throw new IOException("name.size == 0");
                }
                arrayList.add(new he(c, a));
            }
            if (this.f24216a > 0) {
                this.f24218c.b();
                if (this.f24216a != 0) {
                    throw new IOException("compressedLimit > 0: " + this.f24216a);
                }
            }
            return arrayList;
        }
    }

    /* renamed from: a */
    private iq m20971a() throws IOException {
        return this.f24217b.c((long) this.f24217b.g());
    }
}
