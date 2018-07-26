package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.gf.C5920a;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class ak implements gf {
    /* renamed from: a */
    private static final String f22950a = ee.m20406a(ak.class);
    /* renamed from: b */
    private volatile long f22951b = -1;
    /* renamed from: c */
    private long f22952c;

    ak() {
    }

    /* renamed from: a */
    public final gm mo4589a(C5920a c5920a) throws IOException {
        C6010v d = C6010v.d();
        if (this.f22951b != -1) {
            return m19817b(c5920a);
        }
        gm a = c5920a.mo4690a(c5920a.mo4689a());
        if (a == null) {
            return null;
        }
        this.f22951b = m19816a(a);
        if (this.f22951b == -1) {
            return a;
        }
        this.f22952c = d.a();
        long abs = Math.abs(this.f22951b - d.c());
        if (a.m20730b() < 400 || abs < 6000000) {
            return a;
        }
        String str = an.f22962d;
        Object[] objArr = new Object[]{new Date().toString(), new Date(this.f22951b).toString(), Long.valueOf(abs)};
        return m19817b(c5920a);
    }

    /* renamed from: b */
    private gm m19817b(C5920a c5920a) throws IOException {
        long a = this.f22951b + (C6010v.d().a() - this.f22952c);
        gk a2 = c5920a.mo4689a();
        gk a3 = a2.m20714e().m20704a("Date", new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US).format(new Date(a))).m20706a();
        if (ee.m20411a(f22950a, 2)) {
            String a4 = a2.m20710a("Date");
            String a5 = a3.m20710a("Date");
            Object[] objArr = new Object[]{a4, a5};
        }
        return c5920a.mo4690a(a3);
    }

    /* renamed from: a */
    private static long m19816a(gm gmVar) {
        CharSequence a = gmVar.m20729a("Date");
        if (af.m19798a(a)) {
            ee.m20409a(f22950a, "no date header from server, retry conditions not handled", new Object[0]);
            return -1;
        }
        try {
            return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US).parse(a).getTime();
        } catch (ParseException e) {
            ee.m20409a(f22950a, "parsing server date failed, retry conditions not handled", new Object[0]);
        }
    }
}
