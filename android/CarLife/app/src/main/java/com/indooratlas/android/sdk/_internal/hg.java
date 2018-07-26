package com.indooratlas.android.sdk._internal;

import android.net.http.Headers;
import android.support.v4.media.TransportMediator;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.navi.protocol.model.RoutePlanDataStruct;
import com.facebook.common.p141m.C2924g;
import com.indooratlas.android.sdk._internal.hi.C5960a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class hg {
    /* renamed from: a */
    private static final he[] f24184a = new he[]{new he(he.f24164e, ""), new he(he.f24161b, "GET"), new he(he.f24161b, "POST"), new he(he.f24162c, "/"), new he(he.f24162c, "/index.html"), new he(he.f24163d, "http"), new he(he.f24163d, C2924g.f12888b), new he(he.f24160a, "200"), new he(he.f24160a, "204"), new he(he.f24160a, "206"), new he(he.f24160a, "304"), new he(he.f24160a, "400"), new he(he.f24160a, "404"), new he(he.f24160a, "500"), new he("accept-charset", ""), new he("accept-encoding", "gzip, deflate"), new he("accept-language", ""), new he(Headers.ACCEPT_RANGES, ""), new he("accept", ""), new he("access-control-allow-origin", ""), new he("age", ""), new he("allow", ""), new he("authorization", ""), new he(Headers.CACHE_CONTROL, ""), new he(Headers.CONTENT_DISPOSITION, ""), new he(Headers.CONTENT_ENCODING, ""), new he("content-language", ""), new he(Headers.CONTENT_LEN, ""), new he("content-location", ""), new he("content-range", ""), new he(Headers.CONTENT_TYPE, ""), new he("cookie", ""), new he("date", ""), new he(Headers.ETAG, ""), new he("expect", ""), new he("expires", ""), new he(PlatformConstants.CONNECT_EXTRA_KEY, ""), new he("host", ""), new he("if-match", ""), new he("if-modified-since", ""), new he("if-none-match", ""), new he("if-range", ""), new he("if-unmodified-since", ""), new he(Headers.LAST_MODIFIED, ""), new he("link", ""), new he("location", ""), new he("max-forwards", ""), new he(Headers.PROXY_AUTHENTICATE, ""), new he("proxy-authorization", ""), new he("range", ""), new he("referer", ""), new he(Headers.REFRESH, ""), new he("retry-after", ""), new he("server", ""), new he(Headers.SET_COOKIE, ""), new he("strict-transport-security", ""), new he(Headers.TRANSFER_ENCODING, ""), new he("user-agent", ""), new he("vary", ""), new he(RoutePlanDataStruct.KEY_VIA, ""), new he(Headers.WWW_AUTHENTICATE, "")};
    /* renamed from: b */
    private static final Map<iq, Integer> f24185b;

    /* renamed from: com.indooratlas.android.sdk._internal.hg$a */
    static final class C5954a {
        /* renamed from: a */
        final List<he> f24175a = new ArrayList();
        /* renamed from: b */
        final ip f24176b;
        /* renamed from: c */
        int f24177c = 4096;
        /* renamed from: d */
        int f24178d = 4096;
        /* renamed from: e */
        he[] f24179e = new he[8];
        /* renamed from: f */
        int f24180f = (this.f24179e.length - 1);
        /* renamed from: g */
        int f24181g = 0;
        /* renamed from: h */
        int f24182h = 0;

        C5954a(jd jdVar) {
            this.f24176b = ix.a(jdVar);
        }

        /* renamed from: a */
        final void m20926a() {
            if (this.f24178d >= this.f24182h) {
                return;
            }
            if (this.f24178d == 0) {
                m20920c();
            } else {
                m20923d(this.f24182h - this.f24178d);
            }
        }

        /* renamed from: c */
        private void m20920c() {
            this.f24175a.clear();
            Arrays.fill(this.f24179e, null);
            this.f24180f = this.f24179e.length - 1;
            this.f24181g = 0;
            this.f24182h = 0;
        }

        /* renamed from: d */
        private int m20923d(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.f24179e.length - 1; length >= this.f24180f && i > 0; length--) {
                    i -= this.f24179e[length].f24169j;
                    this.f24182h -= this.f24179e[length].f24169j;
                    this.f24181g--;
                    i2++;
                }
                System.arraycopy(this.f24179e, this.f24180f + 1, this.f24179e, (this.f24180f + 1) + i2, this.f24181g);
                this.f24180f += i2;
            }
            return i2;
        }

        /* renamed from: a */
        final int m20924a(int i) {
            return (this.f24180f + 1) + i;
        }

        /* renamed from: b */
        final iq m20929b(int i) {
            if (C5954a.m20921c(i)) {
                return hg.f24184a[i].f24167h;
            }
            return this.f24179e[m20924a(i - hg.f24184a.length)].f24167h;
        }

        /* renamed from: c */
        static boolean m20921c(int i) {
            return i >= 0 && i <= hg.f24184a.length - 1;
        }

        /* renamed from: a */
        final void m20927a(he heVar) {
            this.f24175a.add(heVar);
            int i = heVar.f24169j;
            if (i > this.f24178d) {
                m20920c();
                return;
            }
            m20923d((this.f24182h + i) - this.f24178d);
            if (this.f24181g + 1 > this.f24179e.length) {
                Object obj = new he[(this.f24179e.length * 2)];
                System.arraycopy(this.f24179e, 0, obj, this.f24179e.length, this.f24179e.length);
                this.f24180f = this.f24179e.length - 1;
                this.f24179e = obj;
            }
            int i2 = this.f24180f;
            this.f24180f = i2 - 1;
            this.f24179e[i2] = heVar;
            this.f24181g++;
            this.f24182h = i + this.f24182h;
        }

        /* renamed from: d */
        private int m20922d() throws IOException {
            return this.f24176b.e() & 255;
        }

        /* renamed from: a */
        final int m20925a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            i3 = 0;
            while (true) {
                int d = m20922d();
                if ((d & 128) == 0) {
                    return (d << i3) + i2;
                }
                i2 += (d & TransportMediator.KEYCODE_MEDIA_PAUSE) << i3;
                i3 += 7;
            }
        }

        /* renamed from: b */
        final iq m20928b() throws IOException {
            int i = 0;
            int d = m20922d();
            int i2 = (d & 128) == 128 ? 1 : 0;
            d = m20925a(d, TransportMediator.KEYCODE_MEDIA_PAUSE);
            if (i2 == 0) {
                return this.f24176b.c((long) d);
            }
            hi a = hi.m20968a();
            byte[] e = this.f24176b.e((long) d);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            d = 0;
            C5960a c5960a = a.f24213a;
            i2 = 0;
            while (i < e.length) {
                d = (d << 8) | (e[i] & 255);
                i2 += 8;
                while (i2 >= 8) {
                    c5960a = c5960a.f24207a[(d >>> (i2 - 8)) & 255];
                    if (c5960a.f24207a == null) {
                        byteArrayOutputStream.write(c5960a.f24208b);
                        i2 -= c5960a.f24209c;
                        c5960a = a.f24213a;
                    } else {
                        i2 -= 8;
                    }
                }
                i++;
            }
            while (i2 > 0) {
                C5960a c5960a2 = c5960a.f24207a[(d << (8 - i2)) & 255];
                if (c5960a2.f24207a != null || c5960a2.f24209c > i2) {
                    break;
                }
                byteArrayOutputStream.write(c5960a2.f24208b);
                i2 -= c5960a2.f24209c;
                c5960a = a.f24213a;
            }
            return iq.a(byteArrayOutputStream.toByteArray());
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hg$b */
    static final class C5955b {
        /* renamed from: a */
        private final in f24183a;

        C5955b(in inVar) {
            this.f24183a = inVar;
        }

        /* renamed from: a */
        final void m20932a(List<he> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                iq c = ((he) list.get(i)).f24167h.c();
                Integer num = (Integer) hg.f24185b.get(c);
                if (num != null) {
                    m20930a(num.intValue() + 1, 15);
                    m20931a(((he) list.get(i)).f24168i);
                } else {
                    this.f24183a.b(0);
                    m20931a(c);
                    m20931a(((he) list.get(i)).f24168i);
                }
            }
        }

        /* renamed from: a */
        private void m20930a(int i, int i2) throws IOException {
            if (i < i2) {
                this.f24183a.b(i | 0);
                return;
            }
            this.f24183a.b(i2 | 0);
            int i3 = i - i2;
            while (i3 >= 128) {
                this.f24183a.b((i3 & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
                i3 >>>= 7;
            }
            this.f24183a.b(i3);
        }

        /* renamed from: a */
        private void m20931a(iq iqVar) throws IOException {
            m20930a(iqVar.f24395c.length, TransportMediator.KEYCODE_MEDIA_PAUSE);
            this.f24183a.a(iqVar);
        }
    }

    static {
        int i = 0;
        Map linkedHashMap = new LinkedHashMap(f24184a.length);
        while (i < f24184a.length) {
            if (!linkedHashMap.containsKey(f24184a[i].f24167h)) {
                linkedHashMap.put(f24184a[i].f24167h, Integer.valueOf(i));
            }
            i++;
        }
        f24185b = Collections.unmodifiableMap(linkedHashMap);
    }

    /* renamed from: a */
    static /* synthetic */ iq m20933a(iq iqVar) throws IOException {
        int i = 0;
        int length = iqVar.f24395c.length;
        while (i < length) {
            byte b = iqVar.f24395c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + iqVar.a());
            }
        }
        return iqVar;
    }
}
