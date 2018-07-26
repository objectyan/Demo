package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.ha.C5936a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;

public final class hn implements ho {
    /* renamed from: a */
    static final byte[] f24235a;

    /* renamed from: com.indooratlas.android.sdk._internal.hn$a */
    static final class C5964a implements ha {
        /* renamed from: a */
        private final ip f24227a;
        /* renamed from: b */
        private final boolean f24228b;
        /* renamed from: c */
        private final hj f24229c = new hj(this.f24227a);

        C5964a(ip ipVar, boolean z) {
            this.f24227a = ipVar;
            this.f24228b = z;
        }

        /* renamed from: a */
        public final void mo4711a() {
        }

        /* renamed from: a */
        public final boolean mo4712a(C5936a c5936a) throws IOException {
            boolean z = false;
            try {
                int g = this.f24227a.g();
                int g2 = this.f24227a.g();
                int i = (-16777216 & g2) >>> 24;
                int i2 = 16777215 & g2;
                int i3;
                if ((Integer.MIN_VALUE & g) != 0) {
                    i3 = (2147418112 & g) >>> 16;
                    g &= 65535;
                    if (i3 != 3) {
                        throw new ProtocolException("version != 3: " + i3);
                    }
                    List a;
                    boolean z2;
                    switch (g) {
                        case 1:
                            i3 = this.f24227a.g();
                            this.f24227a.g();
                            g2 = i3 & Integer.MAX_VALUE;
                            this.f24227a.f();
                            a = this.f24229c.m20972a(i2 - 10);
                            if ((i & 1) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if ((i & 2) != 0) {
                                z = true;
                            }
                            c5936a.mo4710a(z, z2, g2, a, hf.SPDY_SYN_STREAM);
                            return true;
                        case 2:
                            g2 = this.f24227a.g() & Integer.MAX_VALUE;
                            a = this.f24229c.m20972a(i2 - 4);
                            if ((i & 1) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            c5936a.mo4710a(false, z2, g2, a, hf.SPDY_REPLY);
                            return true;
                        case 3:
                            if (i2 != 8) {
                                throw C5964a.m20986a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
                            }
                            i3 = this.f24227a.g() & Integer.MAX_VALUE;
                            gz a2 = gz.m20803a(this.f24227a.g());
                            if (a2 == null) {
                                throw C5964a.m20986a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(g));
                            }
                            c5936a.mo4704a(i3, a2);
                            return true;
                        case 4:
                            m20987a(c5936a, i, i2);
                            return true;
                        case 6:
                            if (i2 != 4) {
                                throw C5964a.m20986a("TYPE_PING length: %d != 4", Integer.valueOf(i2));
                            }
                            boolean z3;
                            g = this.f24227a.g();
                            boolean z4 = this.f24228b;
                            if ((g & 1) == 1) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            c5936a.mo4707a(z4 == z3, g, 0);
                            return true;
                        case 7:
                            if (i2 != 8) {
                                throw C5964a.m20986a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
                            }
                            i3 = this.f24227a.g() & Integer.MAX_VALUE;
                            if (gz.m20805c(this.f24227a.g()) == null) {
                                throw C5964a.m20986a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(this.f24227a.g()));
                            }
                            c5936a.mo4705a(i3, iq.f24394b);
                            return true;
                        case 8:
                            c5936a.mo4710a(false, false, this.f24227a.g() & Integer.MAX_VALUE, this.f24229c.m20972a(i2 - 4), hf.SPDY_HEADERS);
                            return true;
                        case 9:
                            if (i2 != 8) {
                                throw C5964a.m20986a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
                            }
                            i3 = this.f24227a.g() & Integer.MAX_VALUE;
                            long g3 = (long) (this.f24227a.g() & Integer.MAX_VALUE);
                            if (g3 == 0) {
                                throw C5964a.m20986a("windowSizeIncrement was 0", Long.valueOf(g3));
                            }
                            c5936a.mo4703a(i3, g3);
                            return true;
                        default:
                            this.f24227a.f((long) i2);
                            return true;
                    }
                }
                i3 = g & Integer.MAX_VALUE;
                if ((i & 1) != 0) {
                    z = true;
                }
                c5936a.mo4708a(z, i3, this.f24227a, i2);
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* renamed from: a */
        private void m20987a(C5936a c5936a, int i, int i2) throws IOException {
            boolean z = true;
            int g = this.f24227a.g();
            if (i2 != (g * 8) + 4) {
                throw C5964a.m20986a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(g));
            }
            hm hmVar = new hm();
            for (int i3 = 0; i3 < g; i3++) {
                int g2 = this.f24227a.g();
                int i4 = (-16777216 & g2) >>> 24;
                hmVar.m20982a(g2 & 16777215, i4, this.f24227a.g());
            }
            if ((i & 1) == 0) {
                z = false;
            }
            c5936a.mo4709a(z, hmVar);
        }

        /* renamed from: a */
        private static IOException m20986a(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        public final void close() throws IOException {
            this.f24229c.f24217b.close();
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hn$b */
    static final class C5965b implements hb {
        /* renamed from: a */
        private final io f24230a;
        /* renamed from: b */
        private final in f24231b = new in();
        /* renamed from: c */
        private final io f24232c;
        /* renamed from: d */
        private final boolean f24233d;
        /* renamed from: e */
        private boolean f24234e;

        C5965b(io ioVar, boolean z) {
            this.f24230a = ioVar;
            this.f24233d = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(hn.f24235a);
            this.f24232c = ix.a(new ir(this.f24231b, deflater));
        }

        /* renamed from: a */
        public final void mo4717a(hm hmVar) {
        }

        /* renamed from: a */
        public final synchronized void mo4713a() {
        }

        /* renamed from: b */
        public final synchronized void mo4721b() throws IOException {
            if (this.f24234e) {
                throw new IOException("closed");
            }
            this.f24230a.flush();
        }

        /* renamed from: a */
        public final synchronized void mo4720a(boolean z, int i, List<he> list) throws IOException {
            int i2 = 0;
            synchronized (this) {
                if (this.f24234e) {
                    throw new IOException("closed");
                }
                m20990a((List) list);
                int i3 = (int) (10 + this.f24231b.f24392b);
                if (z) {
                    i2 = 1;
                }
                i2 |= 0;
                this.f24230a.h(-2147287039);
                this.f24230a.h(((i2 & 255) << 24) | (i3 & 16777215));
                this.f24230a.h(Integer.MAX_VALUE & i);
                this.f24230a.h(0);
                this.f24230a.i(0);
                this.f24230a.a(this.f24231b);
                this.f24230a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo4715a(int i, gz gzVar) throws IOException {
            if (this.f24234e) {
                throw new IOException("closed");
            } else if (gzVar.f24065t == -1) {
                throw new IllegalArgumentException();
            } else {
                this.f24230a.h(-2147287037);
                this.f24230a.h(8);
                this.f24230a.h(Integer.MAX_VALUE & i);
                this.f24230a.h(gzVar.f24065t);
                this.f24230a.flush();
            }
        }

        /* renamed from: c */
        public final int mo4723c() {
            return 16383;
        }

        /* renamed from: a */
        public final synchronized void mo4719a(boolean z, int i, in inVar, int i2) throws IOException {
            int i3;
            if (z) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (this.f24234e) {
                throw new IOException("closed");
            } else if (((long) i2) > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i2);
            } else {
                this.f24230a.h(Integer.MAX_VALUE & i);
                this.f24230a.h(((i3 & 255) << 24) | (16777215 & i2));
                if (i2 > 0) {
                    this.f24230a.a_(inVar, (long) i2);
                }
            }
        }

        /* renamed from: a */
        private void m20990a(List<he> list) throws IOException {
            this.f24232c.h(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                iq iqVar = ((he) list.get(i)).f24167h;
                this.f24232c.h(iqVar.f24395c.length);
                this.f24232c.b(iqVar);
                iqVar = ((he) list.get(i)).f24168i;
                this.f24232c.h(iqVar.f24395c.length);
                this.f24232c.b(iqVar);
            }
            this.f24232c.flush();
        }

        /* renamed from: b */
        public final synchronized void mo4722b(hm hmVar) throws IOException {
            if (this.f24234e) {
                throw new IOException("closed");
            }
            int bitCount = Integer.bitCount(hmVar.f24223a);
            int i = (bitCount * 8) + 4;
            this.f24230a.h(-2147287036);
            this.f24230a.h((i & 16777215) | 0);
            this.f24230a.h(bitCount);
            for (bitCount = 0; bitCount <= 10; bitCount++) {
                if (hmVar.m20983a(bitCount)) {
                    this.f24230a.h(((hmVar.m20985b(bitCount) & 255) << 24) | (bitCount & 16777215));
                    this.f24230a.h(hmVar.f24226d[bitCount]);
                }
            }
            this.f24230a.flush();
        }

        /* renamed from: a */
        public final synchronized void mo4718a(boolean z, int i, int i2) throws IOException {
            boolean z2 = true;
            synchronized (this) {
                if (this.f24234e) {
                    throw new IOException("closed");
                }
                boolean z3;
                boolean z4 = this.f24233d;
                if ((i & 1) == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z4 == z3) {
                    z2 = false;
                }
                if (z != z2) {
                    throw new IllegalArgumentException("payload != reply");
                }
                this.f24230a.h(-2147287034);
                this.f24230a.h(4);
                this.f24230a.h(i);
                this.f24230a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo4716a(int i, gz gzVar, byte[] bArr) throws IOException {
            if (this.f24234e) {
                throw new IOException("closed");
            } else if (gzVar.f24066u == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            } else {
                this.f24230a.h(-2147287033);
                this.f24230a.h(8);
                this.f24230a.h(i);
                this.f24230a.h(gzVar.f24066u);
                this.f24230a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo4714a(int i, long j) throws IOException {
            if (this.f24234e) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            } else {
                this.f24230a.h(-2147287031);
                this.f24230a.h(8);
                this.f24230a.h(i);
                this.f24230a.h((int) j);
                this.f24230a.flush();
            }
        }

        public final synchronized void close() throws IOException {
            this.f24234e = true;
            gy.m20791a(this.f24230a, this.f24232c);
        }
    }

    static {
        try {
            f24235a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(gy.f24042c.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public final ha mo4724a(ip ipVar, boolean z) {
        return new C5964a(ipVar, z);
    }

    /* renamed from: a */
    public final hb mo4725a(io ioVar, boolean z) {
        return new C5965b(ioVar, z);
    }
}
