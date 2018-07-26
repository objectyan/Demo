package com.indooratlas.android.sdk._internal;

import android.net.http.Headers;
import com.indooratlas.android.sdk._internal.gd.C5917a;
import com.indooratlas.android.sdk._internal.gm.C5927a;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class ht implements hx {
    /* renamed from: a */
    private static final iq f24274a = iq.a(Headers.CONN_DIRECTIVE);
    /* renamed from: b */
    private static final iq f24275b = iq.a("host");
    /* renamed from: c */
    private static final iq f24276c = iq.a("keep-alive");
    /* renamed from: d */
    private static final iq f24277d = iq.a(Headers.PROXY_CONNECTION);
    /* renamed from: e */
    private static final iq f24278e = iq.a(Headers.TRANSFER_ENCODING);
    /* renamed from: f */
    private static final iq f24279f = iq.a("te");
    /* renamed from: g */
    private static final iq f24280g = iq.a("encoding");
    /* renamed from: h */
    private static final iq f24281h = iq.a("upgrade");
    /* renamed from: i */
    private static final List<iq> f24282i = gy.m20786a(f24274a, f24275b, f24276c, f24277d, f24278e, he.f24161b, he.f24162c, he.f24163d, he.f24164e, he.f24165f, he.f24166g);
    /* renamed from: j */
    private static final List<iq> f24283j = gy.m20786a(f24274a, f24275b, f24276c, f24277d, f24278e);
    /* renamed from: k */
    private static final List<iq> f24284k = gy.m20786a(f24274a, f24275b, f24276c, f24277d, f24279f, f24278e, f24280g, f24281h, he.f24161b, he.f24162c, he.f24163d, he.f24164e, he.f24165f, he.f24166g);
    /* renamed from: l */
    private static final List<iq> f24285l = gy.m20786a(f24274a, f24275b, f24276c, f24277d, f24279f, f24278e, f24280g, f24281h);
    /* renamed from: m */
    private final ig f24286m;
    /* renamed from: n */
    private final hc f24287n;
    /* renamed from: o */
    private hv f24288o;
    /* renamed from: p */
    private hd f24289p;

    /* renamed from: com.indooratlas.android.sdk._internal.ht$a */
    class C5973a extends is {
        /* renamed from: a */
        final /* synthetic */ ht f24273a;

        public C5973a(ht htVar, jd jdVar) {
            this.f24273a = htVar;
            super(jdVar);
        }

        public final void close() throws IOException {
            this.f24273a.f24286m.a(false, this.f24273a);
            super.close();
        }
    }

    public ht(ig igVar, hc hcVar) {
        this.f24286m = igVar;
        this.f24287n = hcVar;
    }

    /* renamed from: a */
    public final void m21036a(hv hvVar) {
        this.f24288o = hvVar;
    }

    /* renamed from: a */
    public final jc m21033a(gk gkVar, long j) throws IOException {
        return this.f24289p.m20918d();
    }

    /* renamed from: a */
    public final void m21035a(gk gkVar) throws IOException {
        if (this.f24289p == null) {
            List arrayList;
            this.f24288o.a();
            boolean a = hv.a(gkVar);
            if (this.f24287n.f24112a == gi.HTTP_2) {
                gd gdVar = gkVar.f23954c;
                arrayList = new ArrayList((gdVar.f23845a.length / 2) + 4);
                arrayList.add(new he(he.f24161b, gkVar.f23953b));
                arrayList.add(new he(he.f24162c, ib.a(gkVar.f23952a)));
                arrayList.add(new he(he.f24164e, gy.m20783a(gkVar.f23952a)));
                arrayList.add(new he(he.f24163d, gkVar.f23952a.f23861a));
                int length = gdVar.f23845a.length / 2;
                for (int i = 0; i < length; i++) {
                    iq a2 = iq.a(gdVar.m20617a(i).toLowerCase(Locale.US));
                    if (!f24284k.contains(a2)) {
                        arrayList.add(new he(a2, gdVar.m20619b(i)));
                    }
                }
            } else {
                arrayList = m21031b(gkVar);
            }
            this.f24289p = this.f24287n.m20879a(arrayList, a);
            this.f24289p.f24156h.a((long) this.f24288o.f24303b.f23926w, TimeUnit.MILLISECONDS);
            this.f24289p.f24157i.a((long) this.f24288o.f24303b.f23927x, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    public final void m21037a(ic icVar) throws IOException {
        icVar.a(this.f24289p.m20918d());
    }

    /* renamed from: c */
    public final void m21039c() throws IOException {
        this.f24289p.m20918d().close();
    }

    /* renamed from: b */
    public final C5927a m21038b() throws IOException {
        if (this.f24287n.f24112a != gi.HTTP_2) {
            return m21029a(this.f24289p.m20916c());
        }
        List c = this.f24289p.m20916c();
        String str = null;
        C5917a c5917a = new C5917a();
        int size = c.size();
        int i = 0;
        while (i < size) {
            iq iqVar = ((he) c.get(i)).f24167h;
            String a = ((he) c.get(i)).f24168i.a();
            if (!iqVar.equals(he.f24160a)) {
                if (!f24285l.contains(iqVar)) {
                    c5917a.m20612a(iqVar.a(), a);
                }
                a = str;
            }
            i++;
            str = a;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        C5979if a2 = C5979if.a("HTTP/1.1 " + str);
        C5927a c5927a = new C5927a();
        c5927a.f23963b = gi.HTTP_2;
        c5927a.f23964c = a2.f24345b;
        c5927a.f23965d = a2.f24346c;
        return c5927a.m20721a(c5917a.m20613a());
    }

    /* renamed from: b */
    private static List<he> m21031b(gk gkVar) {
        gd gdVar = gkVar.f23954c;
        List<he> arrayList = new ArrayList((gdVar.f23845a.length / 2) + 5);
        arrayList.add(new he(he.f24161b, gkVar.f23953b));
        arrayList.add(new he(he.f24162c, ib.a(gkVar.f23952a)));
        arrayList.add(new he(he.f24166g, "HTTP/1.1"));
        arrayList.add(new he(he.f24165f, gy.m20783a(gkVar.f23952a)));
        arrayList.add(new he(he.f24163d, gkVar.f23952a.f23861a));
        Set linkedHashSet = new LinkedHashSet();
        int length = gdVar.f23845a.length / 2;
        for (int i = 0; i < length; i++) {
            iq a = iq.a(gdVar.m20617a(i).toLowerCase(Locale.US));
            if (!f24282i.contains(a)) {
                String b = gdVar.m20619b(i);
                if (linkedHashSet.add(a)) {
                    arrayList.add(new he(a, b));
                } else {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (((he) arrayList.get(i2)).f24167h.equals(a)) {
                            arrayList.set(i2, new he(a, new StringBuilder(((he) arrayList.get(i2)).f24168i.a()).append('\u0000').append(b).toString()));
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static C5927a m21029a(List<he> list) throws IOException {
        String str = null;
        String str2 = "HTTP/1.1";
        C5917a c5917a = new C5917a();
        int size = list.size();
        int i = 0;
        while (i < size) {
            iq iqVar = ((he) list.get(i)).f24167h;
            String a = ((he) list.get(i)).f24168i.a();
            String str3 = str2;
            int i2 = 0;
            while (i2 < a.length()) {
                int indexOf = a.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = a.length();
                }
                str2 = a.substring(i2, indexOf);
                if (!iqVar.equals(he.f24160a)) {
                    if (iqVar.equals(he.f24166g)) {
                        str3 = str2;
                        str2 = str;
                    } else {
                        if (!f24283j.contains(iqVar)) {
                            c5917a.m20612a(iqVar.a(), str2);
                        }
                        str2 = str;
                    }
                }
                str = str2;
                i2 = indexOf + 1;
            }
            i++;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        C5979if a2 = C5979if.a(str2 + " " + str);
        C5927a c5927a = new C5927a();
        c5927a.f23963b = gi.SPDY_3;
        c5927a.f23964c = a2.f24345b;
        c5927a.f23965d = a2.f24346c;
        return c5927a.m20721a(c5917a.m20613a());
    }

    /* renamed from: a */
    public final gn m21032a(gm gmVar) throws IOException {
        return new hz(gmVar.f23977f, ix.a(new C5973a(this, this.f24289p.f24154f)));
    }

    /* renamed from: a */
    public final void m21034a() {
        if (this.f24289p != null) {
            this.f24289p.m20914b(gz.CANCEL);
        }
    }
}
