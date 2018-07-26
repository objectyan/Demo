package com.indooratlas.android.sdk._internal;

import android.support.v4.media.TransportMediator;
import com.indooratlas.android.sdk._internal.ha.C5936a;
import com.indooratlas.android.sdk._internal.hg.C5954a;
import com.indooratlas.android.sdk._internal.hg.C5955b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class hh implements ho {
    /* renamed from: a */
    private static final Logger f24205a = Logger.getLogger(C5957b.class.getName());
    /* renamed from: b */
    private static final iq f24206b = iq.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: com.indooratlas.android.sdk._internal.hh$a */
    static final class C5956a implements jd {
        /* renamed from: a */
        int f24186a;
        /* renamed from: b */
        byte f24187b;
        /* renamed from: c */
        int f24188c;
        /* renamed from: d */
        int f24189d;
        /* renamed from: e */
        short f24190e;
        /* renamed from: f */
        private final ip f24191f;

        public C5956a(ip ipVar) {
            this.f24191f = ipVar;
        }

        /* renamed from: a */
        public final long m20936a(in inVar, long j) throws IOException {
            while (this.f24189d == 0) {
                this.f24191f.f((long) this.f24190e);
                this.f24190e = (short) 0;
                if ((this.f24187b & 4) != 0) {
                    return -1;
                }
                int i = this.f24188c;
                int a = ((((this.f24191f.e() & 255) << 16) | ((this.f24191f.e() & 255) << 8)) | (this.f24191f.e() & 255));
                this.f24189d = a;
                this.f24186a = a;
                byte e = (byte) (this.f24191f.e() & 255);
                this.f24187b = (byte) (this.f24191f.e() & 255);
                if (hh.f24205a.isLoggable(Level.FINE)) {
                    hh.f24205a.fine(C5957b.m20938a(true, this.f24188c, this.f24186a, e, this.f24187b));
                }
                this.f24188c = this.f24191f.g() & Integer.MAX_VALUE;
                if (e != (byte) 9) {
                    throw hh.m20965c("%s != TYPE_CONTINUATION", Byte.valueOf(e));
                } else if (this.f24188c != i) {
                    throw hh.m20965c("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
            }
            long a2 = this.f24191f.a(inVar, Math.min(j, (long) this.f24189d));
            if (a2 == -1) {
                return -1;
            }
            this.f24189d = (int) (((long) this.f24189d) - a2);
            return a2;
        }

        /* renamed from: a */
        public final je m20937a() {
            return this.f24191f.a();
        }

        public final void close() throws IOException {
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hh$b */
    static final class C5957b {
        /* renamed from: a */
        private static final String[] f24192a = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        /* renamed from: b */
        private static final String[] f24193b = new String[64];
        /* renamed from: c */
        private static final String[] f24194c = new String[256];

        C5957b() {
        }

        /* renamed from: a */
        static String m20938a(boolean z, int i, int i2, byte b, byte b2) {
            Object obj;
            String str;
            if (b < f24192a.length) {
                obj = f24192a[b];
            } else {
                String format = String.format("0x%02x", new Object[]{Byte.valueOf(b)});
            }
            if (b2 != (byte) 0) {
                switch (b) {
                    case (byte) 2:
                    case (byte) 3:
                    case (byte) 7:
                    case (byte) 8:
                        str = f24194c[b2];
                        break;
                    case (byte) 4:
                    case (byte) 6:
                        if (b2 != (byte) 1) {
                            str = f24194c[b2];
                            break;
                        }
                        str = "ACK";
                        break;
                    default:
                        str = b2 < f24193b.length ? f24193b[b2] : f24194c[b2];
                        if (b != (byte) 5 || (b2 & 4) == 0) {
                            if (b == (byte) 0 && (b2 & 32) != 0) {
                                str = str.replace("PRIORITY", "COMPRESSED");
                                break;
                            }
                        }
                        str = str.replace("HEADERS", "PUSH_PROMISE");
                        break;
                        break;
                }
            }
            str = "";
            String str2 = "%s 0x%08x %5d %-13s %s";
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = obj;
            objArr[4] = str;
            return String.format(str2, objArr);
        }

        static {
            int i;
            int i2 = 0;
            for (i = 0; i < f24194c.length; i++) {
                f24194c[i] = String.format("%8s", new Object[]{Integer.toBinaryString(i)}).replace(' ', '0');
            }
            f24193b[0] = "";
            f24193b[1] = "END_STREAM";
            int[] iArr = new int[]{1};
            f24193b[8] = "PADDED";
            for (i = 0; i <= 0; i++) {
                int i3 = iArr[i];
                f24193b[i3 | 8] = f24193b[i3] + "|PADDED";
            }
            f24193b[4] = "END_HEADERS";
            f24193b[32] = "PRIORITY";
            f24193b[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = new int[]{4, 32, 36};
            for (i3 = 0; i3 < 3; i3++) {
                int i4 = iArr2[i3];
                for (i = 0; i <= 0; i++) {
                    int i5 = iArr[i];
                    f24193b[i5 | i4] = f24193b[i5] + '|' + f24193b[i4];
                    f24193b[(i5 | i4) | 8] = f24193b[i5] + '|' + f24193b[i4] + "|PADDED";
                }
            }
            while (i2 < f24193b.length) {
                if (f24193b[i2] == null) {
                    f24193b[i2] = f24194c[i2];
                }
                i2++;
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hh$c */
    static final class C5958c implements ha {
        /* renamed from: a */
        final C5954a f24195a = new C5954a(this.f24197c);
        /* renamed from: b */
        private final ip f24196b;
        /* renamed from: c */
        private final C5956a f24197c = new C5956a(this.f24196b);
        /* renamed from: d */
        private final boolean f24198d;

        C5958c(ip ipVar, boolean z) {
            this.f24196b = ipVar;
            this.f24198d = z;
        }

        /* renamed from: a */
        public final void mo4711a() throws IOException {
            if (!this.f24198d) {
                iq c = this.f24196b.c((long) hh.f24206b.f24395c.length);
                if (hh.f24205a.isLoggable(Level.FINE)) {
                    hh.f24205a.fine(String.format("<< CONNECTION %s", new Object[]{c.b()}));
                }
                if (!hh.f24206b.equals(c)) {
                    throw hh.m20965c("Expected a connection header but was %s", c.a());
                }
            }
        }

        /* renamed from: a */
        public final boolean mo4712a(C5936a c5936a) throws IOException {
            boolean z = false;
            try {
                this.f24196b.a(9);
                int a = ((((this.f24196b.e() & 255) << 16) | ((this.f24196b.e() & 255) << 8)) | (this.f24196b.e() & 255));
                if (a < 0 || a > 16384) {
                    throw hh.m20965c("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
                }
                byte e = (byte) (this.f24196b.e() & 255);
                byte e2 = (byte) (this.f24196b.e() & 255);
                int g = this.f24196b.g() & Integer.MAX_VALUE;
                if (hh.f24205a.isLoggable(Level.FINE)) {
                    hh.f24205a.fine(C5957b.m20938a(true, g, a, e, e2));
                }
                boolean z2;
                short e3;
                int f;
                switch (e) {
                    case (byte) 0:
                        boolean z3;
                        if ((e2 & 1) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if ((e2 & 32) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            throw hh.m20965c("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                        }
                        if ((e2 & 8) != 0) {
                            e3 = (short) (this.f24196b.e() & 255);
                        }
                        c5936a.mo4708a(z3, g, this.f24196b, hh.m20958a(a, e2, e3));
                        this.f24196b.f((long) e3);
                        return true;
                    case (byte) 1:
                        if (g == 0) {
                            throw hh.m20965c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                        }
                        short e4;
                        z2 = (e2 & 1) != 0;
                        if ((e2 & 8) != 0) {
                            e4 = (short) (this.f24196b.e() & 255);
                        } else {
                            e4 = (short) 0;
                        }
                        if ((e2 & 32) != 0) {
                            m20940b();
                            a -= 5;
                        }
                        c5936a.mo4710a(false, z2, g, m20939a(hh.m20958a(a, e2, e4), e4, e2, g), hf.HTTP_20_HEADERS);
                        return true;
                    case (byte) 2:
                        if (a != 5) {
                            throw hh.m20965c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(a));
                        } else if (g == 0) {
                            throw hh.m20965c("TYPE_PRIORITY streamId == 0", new Object[0]);
                        } else {
                            m20940b();
                            return true;
                        }
                    case (byte) 3:
                        if (a != 4) {
                            throw hh.m20965c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(a));
                        } else if (g == 0) {
                            throw hh.m20965c("TYPE_RST_STREAM streamId == 0", new Object[0]);
                        } else {
                            gz b = gz.m20804b(this.f24196b.g());
                            if (b == null) {
                                throw hh.m20965c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(a));
                            }
                            c5936a.mo4704a(g, b);
                            return true;
                        }
                    case (byte) 4:
                        if (g != 0) {
                            throw hh.m20965c("TYPE_SETTINGS streamId != 0", new Object[0]);
                        } else if ((e2 & 1) != 0) {
                            if (a == 0) {
                                return true;
                            }
                            throw hh.m20965c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                        } else if (a % 6 != 0) {
                            throw hh.m20965c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(a));
                        } else {
                            hm hmVar = new hm();
                            for (g = 0; g < a; g += 6) {
                                f = this.f24196b.f();
                                int g2 = this.f24196b.g();
                                switch (f) {
                                    case 1:
                                    case 6:
                                        break;
                                    case 2:
                                        if (!(g2 == 0 || g2 == 1)) {
                                            throw hh.m20965c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                        }
                                    case 3:
                                        f = 4;
                                        break;
                                    case 4:
                                        f = 7;
                                        if (g2 >= 0) {
                                            break;
                                        }
                                        throw hh.m20965c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                    case 5:
                                        if (g2 >= 16384 && g2 <= 16777215) {
                                            break;
                                        }
                                        throw hh.m20965c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(g2));
                                    default:
                                        throw hh.m20965c("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(f));
                                }
                                hmVar.m20982a(f, 0, g2);
                            }
                            c5936a.mo4709a(false, hmVar);
                            if (hmVar.m20981a() < 0) {
                                return true;
                            }
                            C5954a c5954a = this.f24195a;
                            int a2 = hmVar.m20981a();
                            c5954a.f24177c = a2;
                            c5954a.f24178d = a2;
                            c5954a.m20926a();
                            return true;
                        }
                    case (byte) 5:
                        if (g == 0) {
                            throw hh.m20965c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                        }
                        if ((e2 & 8) != 0) {
                            e3 = (short) (this.f24196b.e() & 255);
                        }
                        c5936a.mo4706a(this.f24196b.g() & Integer.MAX_VALUE, m20939a(hh.m20958a(a - 4, e2, e3), e3, e2, g));
                        return true;
                    case (byte) 6:
                        if (a != 8) {
                            throw hh.m20965c("TYPE_PING length != 8: %s", Integer.valueOf(a));
                        } else if (g != 0) {
                            throw hh.m20965c("TYPE_PING streamId != 0", new Object[0]);
                        } else {
                            a = this.f24196b.g();
                            f = this.f24196b.g();
                            if ((e2 & 1) != 0) {
                                z = true;
                            }
                            c5936a.mo4707a(z, a, f);
                            return true;
                        }
                    case (byte) 7:
                        if (a < 8) {
                            throw hh.m20965c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(a));
                        } else if (g != 0) {
                            throw hh.m20965c("TYPE_GOAWAY streamId != 0", new Object[0]);
                        } else {
                            f = this.f24196b.g();
                            int i = a - 8;
                            if (gz.m20804b(this.f24196b.g()) == null) {
                                throw hh.m20965c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(this.f24196b.g()));
                            }
                            iq iqVar = iq.f24394b;
                            if (i > 0) {
                                iqVar = this.f24196b.c((long) i);
                            }
                            c5936a.mo4705a(f, iqVar);
                            return true;
                        }
                    case (byte) 8:
                        if (a != 4) {
                            throw hh.m20965c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(a));
                        }
                        long g3 = ((long) this.f24196b.g()) & 2147483647L;
                        if (g3 == 0) {
                            throw hh.m20965c("windowSizeIncrement was 0", Long.valueOf(g3));
                        }
                        c5936a.mo4703a(g, g3);
                        return true;
                    default:
                        this.f24196b.f((long) a);
                        return true;
                }
            } catch (IOException e5) {
                return false;
            }
        }

        /* renamed from: a */
        private List<he> m20939a(int i, short s, byte b, int i2) throws IOException {
            C5956a c5956a = this.f24197c;
            this.f24197c.f24189d = i;
            c5956a.f24186a = i;
            this.f24197c.f24190e = s;
            this.f24197c.f24187b = b;
            this.f24197c.f24188c = i2;
            C5954a c5954a = this.f24195a;
            while (!c5954a.f24176b.d()) {
                int e = c5954a.f24176b.e() & 255;
                if (e == 128) {
                    throw new IOException("index == 0");
                } else if ((e & 128) == 128) {
                    e = c5954a.m20925a(e, TransportMediator.KEYCODE_MEDIA_PAUSE) - 1;
                    if (C5954a.m20921c(e)) {
                        c5954a.f24175a.add(hg.f24184a[e]);
                    } else {
                        int a = c5954a.m20924a(e - hg.f24184a.length);
                        if (a < 0 || a > c5954a.f24179e.length - 1) {
                            throw new IOException("Header index too large " + (e + 1));
                        }
                        c5954a.f24175a.add(c5954a.f24179e[a]);
                    }
                } else if (e == 64) {
                    c5954a.m20927a(new he(hg.m20933a(c5954a.m20928b()), c5954a.m20928b()));
                } else if ((e & 64) == 64) {
                    c5954a.m20927a(new he(c5954a.m20929b(c5954a.m20925a(e, 63) - 1), c5954a.m20928b()));
                } else if ((e & 32) == 32) {
                    c5954a.f24178d = c5954a.m20925a(e, 31);
                    if (c5954a.f24178d < 0 || c5954a.f24178d > c5954a.f24177c) {
                        throw new IOException("Invalid dynamic table size update " + c5954a.f24178d);
                    }
                    c5954a.m20926a();
                } else if (e == 16 || e == 0) {
                    c5954a.f24175a.add(new he(hg.m20933a(c5954a.m20928b()), c5954a.m20928b()));
                } else {
                    c5954a.f24175a.add(new he(c5954a.m20929b(c5954a.m20925a(e, 15) - 1), c5954a.m20928b()));
                }
            }
            c5954a = this.f24195a;
            List arrayList = new ArrayList(c5954a.f24175a);
            c5954a.f24175a.clear();
            return arrayList;
        }

        /* renamed from: b */
        private void m20940b() throws IOException {
            this.f24196b.g();
            this.f24196b.e();
        }

        public final void close() throws IOException {
            this.f24196b.close();
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hh$d */
    static final class C5959d implements hb {
        /* renamed from: a */
        private final io f24199a;
        /* renamed from: b */
        private final boolean f24200b;
        /* renamed from: c */
        private final in f24201c = new in();
        /* renamed from: d */
        private final C5955b f24202d = new C5955b(this.f24201c);
        /* renamed from: e */
        private int f24203e = 16384;
        /* renamed from: f */
        private boolean f24204f;

        C5959d(io ioVar, boolean z) {
            this.f24199a = ioVar;
            this.f24200b = z;
        }

        /* renamed from: b */
        public final synchronized void mo4721b() throws IOException {
            if (this.f24204f) {
                throw new IOException("closed");
            }
            this.f24199a.flush();
        }

        /* renamed from: a */
        public final synchronized void mo4717a(hm hmVar) throws IOException {
            if (this.f24204f) {
                throw new IOException("closed");
            }
            int i = this.f24203e;
            if ((hmVar.f24223a & 32) != 0) {
                i = hmVar.f24226d[5];
            }
            this.f24203e = i;
            m20943a(0, 0, (byte) 4, (byte) 1);
            this.f24199a.flush();
        }

        /* renamed from: a */
        public final synchronized void mo4713a() throws IOException {
            if (this.f24204f) {
                throw new IOException("closed");
            } else if (this.f24200b) {
                if (hh.f24205a.isLoggable(Level.FINE)) {
                    hh.f24205a.fine(String.format(">> CONNECTION %s", new Object[]{hh.f24206b.b()}));
                }
                this.f24199a.b(hh.f24206b.d());
                this.f24199a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo4720a(boolean z, int i, List<he> list) throws IOException {
            if (this.f24204f) {
                throw new IOException("closed");
            } else if (this.f24204f) {
                throw new IOException("closed");
            } else {
                this.f24202d.m20932a((List) list);
                long j = this.f24201c.f24392b;
                int min = (int) Math.min((long) this.f24203e, j);
                byte b = j == ((long) min) ? (byte) 4 : (byte) 0;
                if (z) {
                    b = (byte) (b | 1);
                }
                m20943a(i, min, (byte) 1, b);
                this.f24199a.a_(this.f24201c, (long) min);
                if (j > ((long) min)) {
                    m20944b(i, j - ((long) min));
                }
            }
        }

        /* renamed from: b */
        private void m20944b(int i, long j) throws IOException {
            while (j > 0) {
                int min = (int) Math.min((long) this.f24203e, j);
                j -= (long) min;
                m20943a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.f24199a.a_(this.f24201c, (long) min);
            }
        }

        /* renamed from: a */
        public final synchronized void mo4715a(int i, gz gzVar) throws IOException {
            if (this.f24204f) {
                throw new IOException("closed");
            } else if (gzVar.f24064s == -1) {
                throw new IllegalArgumentException();
            } else {
                m20943a(i, 4, (byte) 3, (byte) 0);
                this.f24199a.h(gzVar.f24064s);
                this.f24199a.flush();
            }
        }

        /* renamed from: c */
        public final int mo4723c() {
            return this.f24203e;
        }

        /* renamed from: a */
        public final synchronized void mo4719a(boolean z, int i, in inVar, int i2) throws IOException {
            byte b = (byte) 0;
            synchronized (this) {
                if (this.f24204f) {
                    throw new IOException("closed");
                }
                if (z) {
                    b = (byte) 1;
                }
                m20943a(i, i2, (byte) 0, b);
                if (i2 > 0) {
                    this.f24199a.a_(inVar, (long) i2);
                }
            }
        }

        /* renamed from: b */
        public final synchronized void mo4722b(hm hmVar) throws IOException {
            synchronized (this) {
                if (this.f24204f) {
                    throw new IOException("closed");
                }
                m20943a(0, Integer.bitCount(hmVar.f24223a) * 6, (byte) 4, (byte) 0);
                for (int i = 0; i < 10; i++) {
                    if (hmVar.m20983a(i)) {
                        int i2;
                        if (i == 4) {
                            i2 = 3;
                        } else if (i == 7) {
                            i2 = 4;
                        } else {
                            i2 = i;
                        }
                        this.f24199a.i(i2);
                        this.f24199a.h(hmVar.f24226d[i]);
                    }
                }
                this.f24199a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo4718a(boolean z, int i, int i2) throws IOException {
            byte b = (byte) 0;
            synchronized (this) {
                if (this.f24204f) {
                    throw new IOException("closed");
                }
                if (z) {
                    b = (byte) 1;
                }
                m20943a(0, 8, (byte) 6, b);
                this.f24199a.h(i);
                this.f24199a.h(i2);
                this.f24199a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo4716a(int i, gz gzVar, byte[] bArr) throws IOException {
            if (this.f24204f) {
                throw new IOException("closed");
            } else if (gzVar.f24064s == -1) {
                throw hh.m20963b("errorCode.httpCode == -1", new Object[0]);
            } else {
                m20943a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f24199a.h(i);
                this.f24199a.h(gzVar.f24064s);
                if (bArr.length > 0) {
                    this.f24199a.b(bArr);
                }
                this.f24199a.flush();
            }
        }

        /* renamed from: a */
        public final synchronized void mo4714a(int i, long j) throws IOException {
            if (this.f24204f) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw hh.m20963b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(j)});
            } else {
                m20943a(i, 4, (byte) 8, (byte) 0);
                this.f24199a.h((int) j);
                this.f24199a.flush();
            }
        }

        public final synchronized void close() throws IOException {
            this.f24204f = true;
            this.f24199a.close();
        }

        /* renamed from: a */
        private void m20943a(int i, int i2, byte b, byte b2) throws IOException {
            if (hh.f24205a.isLoggable(Level.FINE)) {
                hh.f24205a.fine(C5957b.m20938a(false, i, i2, b, b2));
            }
            if (i2 > this.f24203e) {
                throw hh.m20963b("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(this.f24203e), Integer.valueOf(i2)});
            } else if ((Integer.MIN_VALUE & i) != 0) {
                throw hh.m20963b("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
            } else {
                hh.m20962a(this.f24199a, i2);
                this.f24199a.j(b & 255);
                this.f24199a.j(b2 & 255);
                this.f24199a.h(Integer.MAX_VALUE & i);
            }
        }
    }

    /* renamed from: a */
    public final ha mo4724a(ip ipVar, boolean z) {
        return new C5958c(ipVar, z);
    }

    /* renamed from: a */
    public final hb mo4725a(io ioVar, boolean z) {
        return new C5959d(ioVar, z);
    }

    /* renamed from: c */
    private static IOException m20965c(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    /* renamed from: a */
    static /* synthetic */ int m20958a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw m20965c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(s2));
    }

    /* renamed from: b */
    static /* synthetic */ IllegalArgumentException m20963b(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    /* renamed from: a */
    static /* synthetic */ void m20962a(io ioVar, int i) throws IOException {
        ioVar.j((i >>> 16) & 255);
        ioVar.j((i >>> 8) & 255);
        ioVar.j(i & 255);
    }
}
