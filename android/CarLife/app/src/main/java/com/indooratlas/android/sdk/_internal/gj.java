package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.gf.C5920a;
import java.io.IOException;
import java.util.logging.Level;

final class gj implements fr {
    /* renamed from: a */
    final gh f23942a;
    /* renamed from: b */
    volatile boolean f23943b;
    /* renamed from: c */
    gk f23944c;
    /* renamed from: d */
    hv f23945d;
    /* renamed from: e */
    private boolean f23946e;

    /* renamed from: com.indooratlas.android.sdk._internal.gj$a */
    class C5923a implements C5920a {
        /* renamed from: a */
        final /* synthetic */ gj f23934a;
        /* renamed from: b */
        private final int f23935b;
        /* renamed from: c */
        private final gk f23936c;
        /* renamed from: d */
        private final boolean f23937d;

        C5923a(gj gjVar, int i, gk gkVar, boolean z) {
            this.f23934a = gjVar;
            this.f23935b = i;
            this.f23936c = gkVar;
            this.f23937d = z;
        }

        /* renamed from: b */
        public final fv mo4691b() {
            return null;
        }

        /* renamed from: a */
        public final gk mo4689a() {
            return this.f23936c;
        }

        /* renamed from: a */
        public final gm mo4690a(gk gkVar) throws IOException {
            if (this.f23935b >= this.f23934a.f23942a.f23908e.size()) {
                return this.f23934a.m20693a(gkVar, this.f23937d);
            }
            gf gfVar = (gf) this.f23934a.f23942a.f23908e.get(this.f23935b);
            gm a = gfVar.mo4589a(new C5923a(this.f23934a, this.f23935b + 1, gkVar, this.f23937d));
            if (a != null) {
                return a;
            }
            throw new NullPointerException("application interceptor " + gfVar + " returned null");
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.gj$b */
    final class C5924b extends gu {
        /* renamed from: a */
        final /* synthetic */ gj f23939a;
        /* renamed from: c */
        private final fs f23940c;
        /* renamed from: d */
        private final boolean f23941d;

        private C5924b(gj gjVar, fs fsVar) {
            this.f23939a = gjVar;
            super("OkHttp %s", gjVar.f23944c.f23952a.toString());
            this.f23940c = fsVar;
            this.f23941d = false;
        }

        /* renamed from: a */
        final String m20689a() {
            return this.f23939a.f23944c.f23952a.f23862b;
        }

        /* renamed from: b */
        protected final void mo4692b() {
            Throwable e;
            Object obj = 1;
            Object obj2 = null;
            try {
                gm a = this.f23939a.m20694a(this.f23941d);
                if (this.f23939a.f23943b) {
                    try {
                        this.f23940c.mo4590a(this.f23939a, new IOException("Canceled"));
                    } catch (IOException e2) {
                        e = e2;
                        if (obj == null) {
                            this.f23940c.mo4590a(this.f23939a, e);
                        } else {
                            try {
                                gs.f23876a.log(Level.INFO, "Callback failure for " + gj.m20691a(this.f23939a), e);
                            } catch (Throwable th) {
                                this.f23939a.f23942a.f23904a.m20606b(this);
                            }
                        }
                        this.f23939a.f23942a.f23904a.m20606b(this);
                    }
                }
                this.f23940c.mo4591a(a);
                this.f23939a.f23942a.f23904a.m20606b(this);
            } catch (IOException e3) {
                e = e3;
                obj = obj2;
                if (obj == null) {
                    gs.f23876a.log(Level.INFO, "Callback failure for " + gj.m20691a(this.f23939a), e);
                } else {
                    this.f23940c.mo4590a(this.f23939a, e);
                }
                this.f23939a.f23942a.f23904a.m20606b(this);
            }
        }
    }

    protected gj(gh ghVar, gk gkVar) {
        this.f23942a = ghVar;
        this.f23944c = gkVar;
    }

    /* renamed from: a */
    public final gk mo4693a() {
        return this.f23944c;
    }

    /* renamed from: b */
    public final gm mo4695b() throws IOException {
        synchronized (this) {
            if (this.f23946e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f23946e = true;
        }
        try {
            this.f23942a.f23904a.m20605a(this);
            gm a = m20694a(false);
            if (a != null) {
                return a;
            }
            throw new IOException("Canceled");
        } finally {
            this.f23942a.f23904a.m20603a((fr) this);
        }
    }

    /* renamed from: c */
    public final void mo4696c() {
        this.f23943b = true;
        if (this.f23945d != null) {
            hx hxVar;
            ii iiVar;
            ig igVar = this.f23945d.f24304c;
            synchronized (igVar.f24348b) {
                igVar.f24351e = true;
                hxVar = igVar.f24352f;
                iiVar = igVar.f24350d;
            }
            if (hxVar != null) {
                hxVar.a();
            } else if (iiVar != null) {
                gy.m20792a(iiVar.f24357b);
            }
        }
    }

    /* renamed from: d */
    public final boolean mo4697d() {
        return this.f23943b;
    }

    /* renamed from: a */
    final gm m20694a(boolean z) throws IOException {
        return new C5923a(this, 0, this.f23944c, z).mo4690a(this.f23944c);
    }

    /* renamed from: a */
    public final void mo4694a(fs fsVar) {
        synchronized (this) {
            if (this.f23946e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f23946e = true;
        }
        this.f23942a.f23904a.m20604a(new C5924b(fsVar));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final com.indooratlas.android.sdk._internal.gm m20693a(com.indooratlas.android.sdk._internal.gk r21, boolean r22) throws java.io.IOException {
        /*
        r20 = this;
        r0 = r21;
        r2 = r0.f23955d;
        if (r2 == 0) goto L_0x07a1;
    L_0x0006:
        r3 = r21.m20714e();
        r4 = r2.mo4586a();
        if (r4 == 0) goto L_0x001a;
    L_0x0010:
        r5 = "Content-Type";
        r4 = r4.toString();
        r3.m20704a(r5, r4);
    L_0x001a:
        r4 = r2.mo4588b();
        r6 = -1;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x0068;
    L_0x0024:
        r2 = "Content-Length";
        r4 = java.lang.Long.toString(r4);
        r3.m20704a(r2, r4);
        r2 = "Transfer-Encoding";
        r3.m20707b(r2);
    L_0x0034:
        r4 = r3.m20706a();
    L_0x0038:
        r2 = new com.indooratlas.android.sdk._internal.hv;
        r0 = r20;
        r3 = r0.f23942a;
        r5 = 0;
        r6 = 0;
        r8 = 0;
        r9 = 0;
        r7 = r22;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);
        r0 = r20;
        r0.f23945d = r2;
        r2 = 0;
        r8 = r2;
    L_0x004d:
        r0 = r20;
        r2 = r0.f23943b;
        if (r2 == 0) goto L_0x0078;
    L_0x0053:
        r0 = r20;
        r2 = r0.f23945d;
        r2 = r2.f24304c;
        r3 = 0;
        r4 = 1;
        r5 = 0;
        r2.a(r3, r4, r5);
        r2 = new java.io.IOException;
        r3 = "Canceled";
        r2.<init>(r3);
        throw r2;
    L_0x0068:
        r2 = "Transfer-Encoding";
        r4 = "chunked";
        r3.m20704a(r2, r4);
        r2 = "Content-Length";
        r3.m20707b(r2);
        goto L_0x0034;
    L_0x0078:
        r9 = 1;
        r0 = r20;
        r11 = r0.f23945d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r11.f24319r;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x019a;
    L_0x0081:
        r2 = r11.f24306e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x00a4;
    L_0x0085:
        r2 = new java.lang.IllegalStateException;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.<init>();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        throw r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x008b:
        r2 = move-exception;
        r2 = r2.a();	 Catch:{ all -> 0x0091 }
        throw r2;	 Catch:{ all -> 0x0091 }
    L_0x0091:
        r2 = move-exception;
        r3 = r9;
    L_0x0093:
        if (r3 == 0) goto L_0x00a3;
    L_0x0095:
        r0 = r20;
        r3 = r0.f23945d;
        r3 = r3.b();
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r3.a(r4, r5, r6);
    L_0x00a3:
        throw r2;
    L_0x00a4:
        r2 = r11.f24310i;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r2.m20714e();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = "Host";
        r4 = r2.m20710a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 != 0) goto L_0x00bf;
    L_0x00b3:
        r4 = "Host";
        r5 = r2.f23952a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = com.indooratlas.android.sdk._internal.gy.m20783a(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3.m20704a(r4, r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x00bf:
        r4 = "Connection";
        r4 = r2.m20710a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 != 0) goto L_0x00d1;
    L_0x00c8:
        r4 = "Connection";
        r5 = "Keep-Alive";
        r3.m20704a(r4, r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x00d1:
        r4 = "Accept-Encoding";
        r4 = r2.m20710a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 != 0) goto L_0x00e6;
    L_0x00da:
        r4 = 1;
        r11.f24308g = r4;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = "Accept-Encoding";
        r5 = "gzip";
        r3.m20704a(r4, r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x00e6:
        r4 = r11.f24303b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.f23911h;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.mo4680b();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r4.isEmpty();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r5 != 0) goto L_0x00fe;
    L_0x00f4:
        r5 = "Cookie";
        r4 = com.indooratlas.android.sdk._internal.hv.a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3.m20704a(r5, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x00fe:
        r4 = "User-Agent";
        r2 = r2.m20710a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x0110;
    L_0x0107:
        r2 = "User-Agent";
        r4 = "okhttp/3.0.1";
        r3.m20704a(r2, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0110:
        r12 = r3.m20706a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = com.indooratlas.android.sdk._internal.gs.f23877b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r11.f24303b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.mo4682a(r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x01ca;
    L_0x011e:
        r2 = r2.m20752a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r10 = r2;
    L_0x0123:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r13 = new com.indooratlas.android.sdk._internal.hq$a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r13.<init>(r2, r12, r10);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r13.f24238c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x01ce;
    L_0x0130:
        r2 = new com.indooratlas.android.sdk._internal.hq;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r13.f24237b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = 0;
        r5 = 0;
        r2.<init>(r3, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0139:
        r3 = r2.f24248a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r3 == 0) goto L_0x014f;
    L_0x013d:
        r3 = r13.f24237b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r3.m20715f();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r3.f23738k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r3 == 0) goto L_0x014f;
    L_0x0147:
        r2 = new com.indooratlas.android.sdk._internal.hq;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r2.<init>(r3, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x014f:
        r11.f24319r = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r11.f24319r;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f24248a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r11.f24311j = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r11.f24319r;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f24249b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r11.f24312k = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r10 == 0) goto L_0x0168;
    L_0x015f:
        r2 = r11.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x0168;
    L_0x0163:
        r2 = r10.f23978g;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        com.indooratlas.android.sdk._internal.gy.m20790a(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0168:
        r2 = r11.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x03b7;
    L_0x016c:
        r2 = r11.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x03b7;
    L_0x0170:
        r2 = new com.indooratlas.android.sdk._internal.gm$a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.<init>();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r11.f24310i;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.f23962a = r3;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r11.f24305d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = com.indooratlas.android.sdk._internal.hv.a(r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20727c(r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = com.indooratlas.android.sdk._internal.gi.HTTP_1_1;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.f23963b = r3;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        r2.f23964c = r3;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = "Unsatisfiable Request (only-if-cached)";
        r2.f23965d = r3;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = com.indooratlas.android.sdk._internal.hv.f24302a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.f23968g = r3;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20724a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r11.f24313l = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x019a:
        r0 = r20;
        r3 = r0.f23945d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r3.f24313l;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x04fb;
    L_0x01a2:
        r2 = r3.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x047f;
    L_0x01a6:
        r2 = r3.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x047f;
    L_0x01aa:
        r2 = new java.lang.IllegalStateException;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = "call sendRequest() first!";
        r2.<init>(r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        throw r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x01b3:
        r2 = move-exception;
        r0 = r20;
        r3 = r0.f23945d;	 Catch:{ all -> 0x0091 }
        r4 = r2.f24334b;	 Catch:{ all -> 0x0091 }
        r4 = r3.a(r4);	 Catch:{ all -> 0x0091 }
        if (r4 == 0) goto L_0x0658;
    L_0x01c0:
        r3 = 0;
        r0 = r20;
        r0.f23945d = r4;	 Catch:{ all -> 0x01c7 }
        goto L_0x004d;
    L_0x01c7:
        r2 = move-exception;
        goto L_0x0093;
    L_0x01ca:
        r2 = 0;
        r10 = r2;
        goto L_0x0123;
    L_0x01ce:
        r2 = r13.f24237b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20716g();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x01f9;
    L_0x01d6:
        r2 = r13.f24238c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f23976e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x01f9;
    L_0x01dc:
        r2 = new com.indooratlas.android.sdk._internal.hq;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r13.f24237b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = 0;
        r5 = 0;
        r2.<init>(r3, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0139;
    L_0x01e7:
        r2 = move-exception;
        r0 = r20;
        r3 = r0.f23945d;	 Catch:{ all -> 0x0091 }
        r4 = r3.a(r2);	 Catch:{ all -> 0x0091 }
        if (r4 == 0) goto L_0x065b;
    L_0x01f2:
        r3 = 0;
        r0 = r20;
        r0.f23945d = r4;	 Catch:{ all -> 0x01c7 }
        goto L_0x004d;
    L_0x01f9:
        r2 = r13.f24238c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r13.f24237b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = com.indooratlas.android.sdk._internal.hq.m21006a(r2, r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x020e;
    L_0x0203:
        r2 = new com.indooratlas.android.sdk._internal.hq;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r13.f24237b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = 0;
        r5 = 0;
        r2.<init>(r3, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0139;
    L_0x020e:
        r2 = r13.f24237b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r14 = r2.m20715f();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r14.f23730c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x0220;
    L_0x0218:
        r2 = r13.f24237b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = com.indooratlas.android.sdk._internal.hq.C5966a.m21005a(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x022b;
    L_0x0220:
        r2 = new com.indooratlas.android.sdk._internal.hq;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r13.f24237b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = 0;
        r5 = 0;
        r2.<init>(r3, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0139;
    L_0x022b:
        r2 = r13.f24239d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x030e;
    L_0x022f:
        r2 = 0;
        r4 = r13.f24245j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = r13.f24239d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = r6.getTime();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4 - r6;
        r2 = java.lang.Math.max(r2, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x023e:
        r4 = r13.f24247l;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = -1;
        if (r4 == r5) goto L_0x0250;
    L_0x0243:
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r13.f24247l;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = (long) r5;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.toMillis(r6);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = java.lang.Math.max(r2, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0250:
        r4 = r13.f24245j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = r13.f24244i;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4 - r6;
        r6 = r13.f24236a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r0 = r13.f24245j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r16 = r0;
        r6 = r6 - r16;
        r2 = r2 + r4;
        r16 = r2 + r6;
        r2 = r13.f24238c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20736h();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r2.f23732e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = -1;
        if (r3 == r4) goto L_0x0312;
    L_0x026b:
        r3 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f23732e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = (long) r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r3.toMillis(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0274:
        r4 = r14.f23732e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = -1;
        if (r4 == r5) goto L_0x079e;
    L_0x0279:
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r14.f23732e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = (long) r5;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.toMillis(r6);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = r2;
    L_0x0287:
        r2 = 0;
        r4 = r14.f23737j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = -1;
        if (r4 == r5) goto L_0x079b;
    L_0x028e:
        r2 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r14.f23737j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = (long) r3;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.toMillis(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r2;
    L_0x0298:
        r2 = 0;
        r15 = r13.f24238c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r15 = r15.m20736h();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r0 = r15.f23735h;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r18 = r0;
        if (r18 != 0) goto L_0x02bf;
    L_0x02a6:
        r0 = r14.f23736i;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r18 = r0;
        r19 = -1;
        r0 = r18;
        r1 = r19;
        if (r0 == r1) goto L_0x02bf;
    L_0x02b2:
        r2 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r14.f23736i;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r0 = (long) r3;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r18 = r0;
        r0 = r18;
        r2 = r2.toMillis(r0);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x02bf:
        r14 = r15.f23730c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r14 != 0) goto L_0x036e;
    L_0x02c3:
        r14 = r16 + r4;
        r2 = r2 + r6;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x036e;
    L_0x02ca:
        r2 = r13.f24238c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r2.m20735g();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4 + r16;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 < 0) goto L_0x02df;
    L_0x02d6:
        r2 = "Warning";
        r4 = "110 HttpURLConnection \"Response is stale\"";
        r3.m20726b(r2, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x02df:
        r4 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r2 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0301;
    L_0x02e6:
        r2 = r13.f24238c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20736h();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f23732e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = -1;
        if (r2 != r4) goto L_0x036c;
    L_0x02f1:
        r2 = r13.f24243h;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x036c;
    L_0x02f5:
        r2 = 1;
    L_0x02f6:
        if (r2 == 0) goto L_0x0301;
    L_0x02f8:
        r2 = "Warning";
        r4 = "113 HttpURLConnection \"Heuristic expiration\"";
        r3.m20726b(r2, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0301:
        r2 = new com.indooratlas.android.sdk._internal.hq;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = 0;
        r3 = r3.m20724a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = 0;
        r2.<init>(r4, r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0139;
    L_0x030e:
        r2 = 0;
        goto L_0x023e;
    L_0x0312:
        r2 = r13.f24243h;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x0335;
    L_0x0316:
        r2 = r13.f24239d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x0332;
    L_0x031a:
        r2 = r13.f24239d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.getTime();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0320:
        r4 = r13.f24243h;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.getTime();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r4 - r2;
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 > 0) goto L_0x0274;
    L_0x032e:
        r2 = 0;
        goto L_0x0274;
    L_0x0332:
        r2 = r13.f24245j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0320;
    L_0x0335:
        r2 = r13.f24241f;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x0368;
    L_0x0339:
        r2 = r13.f24238c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f23972a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f23952a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20653g();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x0368;
    L_0x0345:
        r2 = r13.f24239d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x0361;
    L_0x0349:
        r2 = r13.f24239d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.getTime();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x034f:
        r4 = r13.f24241f;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.getTime();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2 - r4;
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0364;
    L_0x035c:
        r4 = 10;
        r2 = r2 / r4;
        goto L_0x0274;
    L_0x0361:
        r2 = r13.f24244i;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x034f;
    L_0x0364:
        r2 = 0;
        goto L_0x0274;
    L_0x0368:
        r2 = 0;
        goto L_0x0274;
    L_0x036c:
        r2 = 0;
        goto L_0x02f6;
    L_0x036e:
        r2 = r13.f24237b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20714e();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r13.f24246k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r3 == 0) goto L_0x0394;
    L_0x0378:
        r3 = "If-None-Match";
        r4 = r13.f24246k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.m20704a(r3, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0380:
        r3 = r2.m20706a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = com.indooratlas.android.sdk._internal.hq.C5966a.m21005a(r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x03ae;
    L_0x038a:
        r2 = new com.indooratlas.android.sdk._internal.hq;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r13.f24238c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = 0;
        r2.<init>(r3, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0139;
    L_0x0394:
        r3 = r13.f24241f;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r3 == 0) goto L_0x03a1;
    L_0x0398:
        r3 = "If-Modified-Since";
        r4 = r13.f24242g;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.m20704a(r3, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0380;
    L_0x03a1:
        r3 = r13.f24239d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r3 == 0) goto L_0x0380;
    L_0x03a5:
        r3 = "If-Modified-Since";
        r4 = r13.f24240e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.m20704a(r3, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0380;
    L_0x03ae:
        r2 = new com.indooratlas.android.sdk._internal.hq;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = 0;
        r5 = 0;
        r2.<init>(r3, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0139;
    L_0x03b7:
        r2 = r11.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x03e9;
    L_0x03bb:
        r2 = r11.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20735g();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r11.f24310i;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.f23962a = r3;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r11.f24305d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = com.indooratlas.android.sdk._internal.hv.a(r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20727c(r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = r11.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3 = com.indooratlas.android.sdk._internal.hv.a(r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20725b(r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20724a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r11.f24313l = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r11.f24313l;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r11.b(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r11.f24313l = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x019a;
    L_0x03e9:
        r2 = r11.f24311j;	 Catch:{ all -> 0x043f }
        r2 = r2.f23953b;	 Catch:{ all -> 0x043f }
        r3 = "GET";
        r2 = r2.equals(r3);	 Catch:{ all -> 0x043f }
        if (r2 != 0) goto L_0x0448;
    L_0x03f6:
        r7 = 1;
    L_0x03f7:
        r2 = r11.f24304c;	 Catch:{ all -> 0x043f }
        r3 = r11.f24303b;	 Catch:{ all -> 0x043f }
        r3 = r3.f23925v;	 Catch:{ all -> 0x043f }
        r4 = r11.f24303b;	 Catch:{ all -> 0x043f }
        r4 = r4.f23926w;	 Catch:{ all -> 0x043f }
        r5 = r11.f24303b;	 Catch:{ all -> 0x043f }
        r5 = r5.f23927x;	 Catch:{ all -> 0x043f }
        r6 = r11.f24303b;	 Catch:{ all -> 0x043f }
        r6 = r6.f23924u;	 Catch:{ all -> 0x043f }
        r2 = r2.a(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x043f }
        r11.f24306e = r2;	 Catch:{ all -> 0x043f }
        r2 = r11.f24306e;	 Catch:{ all -> 0x043f }
        r2.a(r11);	 Catch:{ all -> 0x043f }
        r2 = r11.f24316o;	 Catch:{ all -> 0x043f }
        if (r2 == 0) goto L_0x044a;
    L_0x0418:
        r2 = r11.f24311j;	 Catch:{ all -> 0x043f }
        r2 = com.indooratlas.android.sdk._internal.hv.a(r2);	 Catch:{ all -> 0x043f }
        if (r2 == 0) goto L_0x044a;
    L_0x0420:
        r2 = r11.f24314m;	 Catch:{ all -> 0x043f }
        if (r2 != 0) goto L_0x044a;
    L_0x0424:
        r2 = 1;
    L_0x0425:
        if (r2 == 0) goto L_0x019a;
    L_0x0427:
        r2 = com.indooratlas.android.sdk._internal.hy.a(r12);	 Catch:{ all -> 0x043f }
        r4 = r11.f24309h;	 Catch:{ all -> 0x043f }
        if (r4 == 0) goto L_0x046c;
    L_0x042f:
        r4 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x044c;
    L_0x0436:
        r2 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x043f }
        r3 = "Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.";
        r2.<init>(r3);	 Catch:{ all -> 0x043f }
        throw r2;	 Catch:{ all -> 0x043f }
    L_0x043f:
        r2 = move-exception;
        if (r10 == 0) goto L_0x0447;
    L_0x0442:
        r3 = r10.f23978g;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        com.indooratlas.android.sdk._internal.gy.m20790a(r3);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0447:
        throw r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0448:
        r7 = 0;
        goto L_0x03f7;
    L_0x044a:
        r2 = 0;
        goto L_0x0425;
    L_0x044c:
        r4 = -1;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0463;
    L_0x0452:
        r4 = r11.f24306e;	 Catch:{ all -> 0x043f }
        r5 = r11.f24311j;	 Catch:{ all -> 0x043f }
        r4.a(r5);	 Catch:{ all -> 0x043f }
        r4 = new com.indooratlas.android.sdk._internal.ic;	 Catch:{ all -> 0x043f }
        r2 = (int) r2;	 Catch:{ all -> 0x043f }
        r4.<init>(r2);	 Catch:{ all -> 0x043f }
        r11.f24314m = r4;	 Catch:{ all -> 0x043f }
        goto L_0x019a;
    L_0x0463:
        r2 = new com.indooratlas.android.sdk._internal.ic;	 Catch:{ all -> 0x043f }
        r2.<init>();	 Catch:{ all -> 0x043f }
        r11.f24314m = r2;	 Catch:{ all -> 0x043f }
        goto L_0x019a;
    L_0x046c:
        r4 = r11.f24306e;	 Catch:{ all -> 0x043f }
        r5 = r11.f24311j;	 Catch:{ all -> 0x043f }
        r4.a(r5);	 Catch:{ all -> 0x043f }
        r4 = r11.f24306e;	 Catch:{ all -> 0x043f }
        r5 = r11.f24311j;	 Catch:{ all -> 0x043f }
        r2 = r4.a(r5, r2);	 Catch:{ all -> 0x043f }
        r11.f24314m = r2;	 Catch:{ all -> 0x043f }
        goto L_0x019a;
    L_0x047f:
        r2 = r3.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x04fb;
    L_0x0483:
        r2 = r3.f24317p;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x0509;
    L_0x0487:
        r2 = r3.f24306e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r3.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x048e:
        r2 = r3.c();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0492:
        r4 = r2.f23977f;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3.a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r3.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 == 0) goto L_0x059f;
    L_0x049b:
        r4 = r3.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = com.indooratlas.android.sdk._internal.hv.a(r4, r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 == 0) goto L_0x0598;
    L_0x04a3:
        r4 = r3.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.m20735g();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r3.f24310i;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4.f23962a = r5;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r3.f24305d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = com.indooratlas.android.sdk._internal.hv.a(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.m20727c(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r3.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r5.f23977f;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = r2.f23977f;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = com.indooratlas.android.sdk._internal.hv.a(r5, r6);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.m20721a(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r3.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = com.indooratlas.android.sdk._internal.hv.a(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.m20725b(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = com.indooratlas.android.sdk._internal.hv.a(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.m20722a(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.m20724a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3.f24313l = r4;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f23978g;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.close();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r3.f24304c;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.b();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = com.indooratlas.android.sdk._internal.gs.f23877b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r3.f24303b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.mo4682a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r3.f24313l;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        com.indooratlas.android.sdk._internal.hv.a(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r3.f24313l;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r3.b(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3.f24313l = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x04fb:
        r0 = r20;
        r2 = r0.f23945d;
        r3 = r2.f24313l;
        if (r3 != 0) goto L_0x065c;
    L_0x0503:
        r2 = new java.lang.IllegalStateException;
        r2.<init>();
        throw r2;
    L_0x0509:
        r2 = r3.f24316o;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 != 0) goto L_0x051d;
    L_0x050d:
        r2 = new com.indooratlas.android.sdk._internal.hv$a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = 0;
        r5 = r3.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.<init>(r3, r4, r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r3.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0492;
    L_0x051d:
        r2 = r3.f24315n;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x0534;
    L_0x0521:
        r2 = r3.f24315n;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.b();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r2.f24392b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0534;
    L_0x052f:
        r2 = r3.f24315n;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.c();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0534:
        r4 = r3.f24307f;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = -1;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x0574;
    L_0x053c:
        r2 = r3.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = com.indooratlas.android.sdk._internal.hy.a(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = -1;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x056d;
    L_0x0548:
        r2 = r3.f24314m;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2 instanceof com.indooratlas.android.sdk._internal.ic;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x056d;
    L_0x054e:
        r2 = r3.f24314m;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = (com.indooratlas.android.sdk._internal.ic) r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f24330a;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r2.f24392b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r3.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20714e();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = "Content-Length";
        r4 = java.lang.Long.toString(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20704a(r6, r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20706a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3.f24311j = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x056d:
        r2 = r3.f24306e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r3.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0574:
        r2 = r3.f24314m;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x048e;
    L_0x0578:
        r2 = r3.f24315n;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x0592;
    L_0x057c:
        r2 = r3.f24315n;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.close();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0581:
        r2 = r3.f24314m;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2 instanceof com.indooratlas.android.sdk._internal.ic;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x048e;
    L_0x0587:
        r4 = r3.f24306e;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r3.f24314m;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = (com.indooratlas.android.sdk._internal.ic) r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4.a(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x048e;
    L_0x0592:
        r2 = r3.f24314m;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2.close();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0581;
    L_0x0598:
        r4 = r3.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.f23978g;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        com.indooratlas.android.sdk._internal.gy.m20790a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x059f:
        r4 = r2.m20735g();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r3.f24310i;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4.f23962a = r5;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r3.f24305d;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = com.indooratlas.android.sdk._internal.hv.a(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.m20727c(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r3.f24312k;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = com.indooratlas.android.sdk._internal.hv.a(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r4.m20725b(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = com.indooratlas.android.sdk._internal.hv.a(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r4.m20722a(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20724a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3.f24313l = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r3.f24313l;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = com.indooratlas.android.sdk._internal.hv.c(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x04fb;
    L_0x05d1:
        r2 = com.indooratlas.android.sdk._internal.gs.f23877b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r3.f24303b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.mo4682a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r2 == 0) goto L_0x0613;
    L_0x05db:
        r4 = r3.f24313l;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = r3.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = com.indooratlas.android.sdk._internal.hq.m21006a(r4, r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 != 0) goto L_0x0621;
    L_0x05e5:
        r2 = r3.f24311j;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f23953b;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = "POST";
        r4 = r2.equals(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 != 0) goto L_0x0613;
    L_0x05f2:
        r4 = "PATCH";
        r4 = r2.equals(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 != 0) goto L_0x0613;
    L_0x05fb:
        r4 = "PUT";
        r4 = r2.equals(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 != 0) goto L_0x0613;
    L_0x0604:
        r4 = "DELETE";
        r4 = r2.equals(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 != 0) goto L_0x0613;
    L_0x060d:
        r4 = "MOVE";
        r2.equals(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
    L_0x0613:
        r4 = r3.f24318q;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r3.f24313l;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r4 != 0) goto L_0x062d;
    L_0x0619:
        r2 = r3.b(r2);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3.f24313l = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x04fb;
    L_0x0621:
        r4 = r3.f24313l;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        com.indooratlas.android.sdk._internal.hv.a(r4);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.m20753b();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r3.f24318q = r2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0613;
    L_0x062d:
        r5 = r4.m21004a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        if (r5 == 0) goto L_0x0619;
    L_0x0633:
        r6 = r2.f23978g;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = r6.m20740c();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = com.indooratlas.android.sdk._internal.ix.a(r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r7 = new com.indooratlas.android.sdk._internal.hv$2;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r7.<init>(r3, r6, r4, r5);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4 = r2.m20735g();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5 = new com.indooratlas.android.sdk._internal.hz;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r2.f23977f;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r6 = com.indooratlas.android.sdk._internal.ix.a(r7);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r5.<init>(r2, r6);	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r4.f23968g = r5;	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        r2 = r4.m20724a();	 Catch:{ ia -> 0x008b, id -> 0x01b3, IOException -> 0x01e7 }
        goto L_0x0619;
    L_0x0658:
        r2 = r2.f24334b;	 Catch:{ all -> 0x0091 }
        throw r2;	 Catch:{ all -> 0x0091 }
    L_0x065b:
        throw r2;	 Catch:{ all -> 0x0091 }
    L_0x065c:
        r9 = r2.f24313l;
        r0 = r20;
        r3 = r0.f23945d;
        r2 = r3.f24313l;
        if (r2 != 0) goto L_0x066c;
    L_0x0666:
        r2 = new java.lang.IllegalStateException;
        r2.<init>();
        throw r2;
    L_0x066c:
        r2 = r3.f24304c;
        r2 = r2.a();
        if (r2 == 0) goto L_0x0692;
    L_0x0674:
        r2 = r2.m20575a();
    L_0x0678:
        r4 = r3.f24313l;
        r4 = r4.f23974c;
        r5 = r3.f24310i;
        r5 = r5.f23953b;
        switch(r4) {
            case 300: goto L_0x06cb;
            case 301: goto L_0x06cb;
            case 302: goto L_0x06cb;
            case 303: goto L_0x06cb;
            case 307: goto L_0x06b9;
            case 308: goto L_0x06b9;
            case 401: goto L_0x06ae;
            case 407: goto L_0x0694;
            default: goto L_0x0683;
        };
    L_0x0683:
        r4 = 0;
    L_0x0684:
        if (r4 != 0) goto L_0x0748;
    L_0x0686:
        if (r22 != 0) goto L_0x0691;
    L_0x0688:
        r0 = r20;
        r2 = r0.f23945d;
        r2 = r2.f24304c;
        r2.b();
    L_0x0691:
        return r9;
    L_0x0692:
        r2 = 0;
        goto L_0x0678;
    L_0x0694:
        if (r2 == 0) goto L_0x06a9;
    L_0x0696:
        r2 = r2.f23984b;
    L_0x0698:
        r2 = r2.type();
        r4 = java.net.Proxy.Type.HTTP;
        if (r2 == r4) goto L_0x06ae;
    L_0x06a0:
        r2 = new java.net.ProtocolException;
        r3 = "Received HTTP_PROXY_AUTH (407) code while not using proxy";
        r2.<init>(r3);
        throw r2;
    L_0x06a9:
        r2 = r3.f24303b;
        r2 = r2.f23905b;
        goto L_0x0698;
    L_0x06ae:
        r2 = r3.f24303b;
        r2 = r2.f23919p;
        r3 = r3.f24313l;
        r4 = r2.mo4678a();
        goto L_0x0684;
    L_0x06b9:
        r2 = "GET";
        r2 = r5.equals(r2);
        if (r2 != 0) goto L_0x06cb;
    L_0x06c2:
        r2 = "HEAD";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0683;
    L_0x06cb:
        r2 = r3.f24303b;
        r2 = r2.f23923t;
        if (r2 == 0) goto L_0x0683;
    L_0x06d1:
        r2 = r3.f24313l;
        r4 = "Location";
        r2 = r2.m20729a(r4);
        if (r2 == 0) goto L_0x0683;
    L_0x06dc:
        r4 = r3.f24310i;
        r4 = r4.f23952a;
        r4 = r4.m20648c(r2);
        if (r4 == 0) goto L_0x0683;
    L_0x06e6:
        r2 = r4.f23861a;
        r6 = r3.f24310i;
        r6 = r6.f23952a;
        r6 = r6.f23861a;
        r2 = r2.equals(r6);
        if (r2 != 0) goto L_0x06fa;
    L_0x06f4:
        r2 = r3.f24303b;
        r2 = r2.f23922s;
        if (r2 == 0) goto L_0x0683;
    L_0x06fa:
        r2 = r3.f24310i;
        r6 = r2.m20714e();
        r2 = com.indooratlas.android.sdk._internal.hw.b(r5);
        if (r2 == 0) goto L_0x072b;
    L_0x0706:
        r2 = "PROPFIND";
        r2 = r5.equals(r2);
        if (r2 != 0) goto L_0x0741;
    L_0x070f:
        r2 = 1;
    L_0x0710:
        if (r2 == 0) goto L_0x0743;
    L_0x0712:
        r2 = "GET";
        r5 = 0;
        r6.m20703a(r2, r5);
    L_0x0719:
        r2 = "Transfer-Encoding";
        r6.m20707b(r2);
        r2 = "Content-Length";
        r6.m20707b(r2);
        r2 = "Content-Type";
        r6.m20707b(r2);
    L_0x072b:
        r2 = r3.a(r4);
        if (r2 != 0) goto L_0x0737;
    L_0x0731:
        r2 = "Authorization";
        r6.m20707b(r2);
    L_0x0737:
        r2 = r6.m20699a(r4);
        r4 = r2.m20706a();
        goto L_0x0684;
    L_0x0741:
        r2 = 0;
        goto L_0x0710;
    L_0x0743:
        r2 = 0;
        r6.m20703a(r5, r2);
        goto L_0x0719;
    L_0x0748:
        r0 = r20;
        r2 = r0.f23945d;
        r2 = r2.b();
        r10 = r8 + 1;
        r3 = 20;
        if (r10 <= r3) goto L_0x0772;
    L_0x0756:
        r3 = 0;
        r4 = 1;
        r5 = 0;
        r2.a(r3, r4, r5);
        r2 = new java.net.ProtocolException;
        r3 = new java.lang.StringBuilder;
        r4 = "Too many follow-up requests: ";
        r3.<init>(r4);
        r3 = r3.append(r10);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0772:
        r0 = r20;
        r3 = r0.f23945d;
        r5 = r4.f23952a;
        r3 = r3.a(r5);
        if (r3 != 0) goto L_0x0799;
    L_0x077e:
        r3 = 0;
        r5 = 1;
        r6 = 0;
        r2.a(r3, r5, r6);
        r8 = 0;
    L_0x0785:
        r2 = new com.indooratlas.android.sdk._internal.hv;
        r0 = r20;
        r3 = r0.f23942a;
        r5 = 0;
        r6 = 0;
        r7 = r22;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);
        r0 = r20;
        r0.f23945d = r2;
        r8 = r10;
        goto L_0x004d;
    L_0x0799:
        r8 = r2;
        goto L_0x0785;
    L_0x079b:
        r4 = r2;
        goto L_0x0298;
    L_0x079e:
        r6 = r2;
        goto L_0x0287;
    L_0x07a1:
        r4 = r21;
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.gj.a(com.indooratlas.android.sdk._internal.gk, boolean):com.indooratlas.android.sdk._internal.gm");
    }

    /* renamed from: a */
    static /* synthetic */ String m20691a(gj gjVar) {
        return (gjVar.f23943b ? "canceled call" : "call") + " to " + gjVar.f23944c.f23952a.m20648c("/...");
    }
}
