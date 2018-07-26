package com.indooratlas.android.sdk._internal;

import com.baidu.mobstat.Config;
import com.indooratlas.android.sdk._internal.fx.C5913a;
import com.indooratlas.android.sdk._internal.gd.C5917a;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class gh implements Cloneable {
    /* renamed from: y */
    private static final List<gi> f23902y = gy.m20786a(gi.HTTP_2, gi.SPDY_3, gi.HTTP_1_1);
    /* renamed from: z */
    private static final List<fx> f23903z = gy.m20786a(fx.f23810a, fx.f23811b, fx.f23812c);
    /* renamed from: a */
    final ga f23904a;
    /* renamed from: b */
    public final Proxy f23905b;
    /* renamed from: c */
    public final List<gi> f23906c;
    /* renamed from: d */
    public final List<fx> f23907d;
    /* renamed from: e */
    final List<gf> f23908e;
    /* renamed from: f */
    public final List<gf> f23909f;
    /* renamed from: g */
    public final ProxySelector f23910g;
    /* renamed from: h */
    public final fz f23911h;
    /* renamed from: i */
    final fp f23912i;
    /* renamed from: j */
    final gt f23913j;
    /* renamed from: k */
    public final SocketFactory f23914k;
    /* renamed from: l */
    public final SSLSocketFactory f23915l;
    /* renamed from: m */
    public final HostnameVerifier f23916m;
    /* renamed from: n */
    public final ft f23917n;
    /* renamed from: o */
    public final fo f23918o;
    /* renamed from: p */
    public final fo f23919p;
    /* renamed from: q */
    public final fw f23920q;
    /* renamed from: r */
    public final gb f23921r;
    /* renamed from: s */
    public final boolean f23922s;
    /* renamed from: t */
    public final boolean f23923t;
    /* renamed from: u */
    public final boolean f23924u;
    /* renamed from: v */
    public final int f23925v;
    /* renamed from: w */
    public final int f23926w;
    /* renamed from: x */
    public final int f23927x;

    /* renamed from: com.indooratlas.android.sdk._internal.gh$1 */
    static class C59211 extends gs {
        C59211() {
        }

        /* renamed from: a */
        public final gx mo4683a(fw fwVar) {
            return fwVar.f23803e;
        }

        /* renamed from: a */
        public final void mo4686a(C5917a c5917a, String str) {
            int indexOf = str.indexOf(Config.TRACE_TODAY_VISIT_SPLIT, 1);
            if (indexOf != -1) {
                c5917a.m20614b(str.substring(0, indexOf), str.substring(indexOf + 1));
            } else if (str.startsWith(Config.TRACE_TODAY_VISIT_SPLIT)) {
                c5917a.m20614b("", str.substring(1));
            } else {
                c5917a.m20614b("", str);
            }
        }

        /* renamed from: a */
        public final gt mo4682a(gh ghVar) {
            return ghVar.f23912i != null ? ghVar.f23912i.f23719a : ghVar.f23913j;
        }

        /* renamed from: a */
        public final boolean mo4687a(fw fwVar, ii iiVar) {
            if (!fw.f23799g && !Thread.holdsLock(fwVar)) {
                throw new AssertionError();
            } else if (iiVar.f24365j || fwVar.f23800b == 0) {
                fwVar.f23802d.remove(iiVar);
                return true;
            } else {
                fwVar.notifyAll();
                return false;
            }
        }

        /* renamed from: a */
        public final ii mo4684a(fw fwVar, fn fnVar, ig igVar) {
            if (fw.f23799g || Thread.holdsLock(fwVar)) {
                for (ii iiVar : fwVar.f23802d) {
                    int size = iiVar.f24364i.size();
                    hc hcVar = iiVar.f24360e;
                    if (size < (hcVar != null ? hcVar.m20877a() : 1) && fnVar.equals(iiVar.f24356a.f23983a) && !iiVar.f24365j) {
                        igVar.a(iiVar);
                        return iiVar;
                    }
                }
                return null;
            }
            throw new AssertionError();
        }

        /* renamed from: b */
        public final void mo4688b(fw fwVar, ii iiVar) {
            if (fw.f23799g || Thread.holdsLock(fwVar)) {
                if (!fwVar.f23804f) {
                    fwVar.f23804f = true;
                    fw.f23798a.execute(fwVar.f23801c);
                }
                fwVar.f23802d.add(iiVar);
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public final void mo4685a(fx fxVar, SSLSocket sSLSocket, boolean z) {
            String[] strArr;
            String[] strArr2;
            if (fxVar.f23815e != null) {
                strArr = (String[]) gy.m20798a(String.class, fxVar.f23815e, sSLSocket.getEnabledCipherSuites());
            } else {
                strArr = sSLSocket.getEnabledCipherSuites();
            }
            if (fxVar.f23816f != null) {
                strArr2 = (String[]) gy.m20798a(String.class, fxVar.f23816f, sSLSocket.getEnabledProtocols());
            } else {
                strArr2 = sSLSocket.getEnabledProtocols();
            }
            if (z && gy.m20797a(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
                strArr = gy.m20801b(strArr, "TLS_FALLBACK_SCSV");
            }
            fx b = new C5913a(fxVar).m20579a(strArr).m20580b(strArr2).m20581b();
            if (b.f23816f != null) {
                sSLSocket.setEnabledProtocols(b.f23816f);
            }
            if (b.f23815e != null) {
                sSLSocket.setEnabledCipherSuites(b.f23815e);
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.gh$a */
    public static final class C5922a {
        /* renamed from: a */
        ga f23878a;
        /* renamed from: b */
        Proxy f23879b;
        /* renamed from: c */
        List<gi> f23880c;
        /* renamed from: d */
        List<fx> f23881d;
        /* renamed from: e */
        final List<gf> f23882e;
        /* renamed from: f */
        final List<gf> f23883f;
        /* renamed from: g */
        ProxySelector f23884g;
        /* renamed from: h */
        fz f23885h;
        /* renamed from: i */
        fp f23886i;
        /* renamed from: j */
        gt f23887j;
        /* renamed from: k */
        SocketFactory f23888k;
        /* renamed from: l */
        SSLSocketFactory f23889l;
        /* renamed from: m */
        HostnameVerifier f23890m;
        /* renamed from: n */
        ft f23891n;
        /* renamed from: o */
        fo f23892o;
        /* renamed from: p */
        fo f23893p;
        /* renamed from: q */
        fw f23894q;
        /* renamed from: r */
        gb f23895r;
        /* renamed from: s */
        boolean f23896s;
        /* renamed from: t */
        boolean f23897t;
        /* renamed from: u */
        boolean f23898u;
        /* renamed from: v */
        int f23899v;
        /* renamed from: w */
        int f23900w;
        /* renamed from: x */
        int f23901x;

        public C5922a() {
            this.f23882e = new ArrayList();
            this.f23883f = new ArrayList();
            this.f23878a = new ga();
            this.f23880c = gh.f23902y;
            this.f23881d = gh.f23903z;
            this.f23884g = ProxySelector.getDefault();
            this.f23885h = fz.f23831a;
            this.f23888k = SocketFactory.getDefault();
            this.f23890m = ik.f24375a;
            this.f23891n = ft.f23743a;
            this.f23892o = fo.f23718a;
            this.f23893p = fo.f23718a;
            this.f23894q = new fw();
            this.f23895r = gb.f23839a;
            this.f23896s = true;
            this.f23897t = true;
            this.f23898u = true;
            this.f23899v = 10000;
            this.f23900w = 10000;
            this.f23901x = 10000;
        }

        C5922a(gh ghVar) {
            this.f23882e = new ArrayList();
            this.f23883f = new ArrayList();
            this.f23878a = ghVar.f23904a;
            this.f23879b = ghVar.f23905b;
            this.f23880c = ghVar.f23906c;
            this.f23881d = ghVar.f23907d;
            this.f23882e.addAll(ghVar.f23908e);
            this.f23883f.addAll(ghVar.f23909f);
            this.f23884g = ghVar.f23910g;
            this.f23885h = ghVar.f23911h;
            this.f23887j = ghVar.f23913j;
            this.f23886i = ghVar.f23912i;
            this.f23888k = ghVar.f23914k;
            this.f23889l = ghVar.f23915l;
            this.f23890m = ghVar.f23916m;
            this.f23891n = ghVar.f23917n;
            this.f23892o = ghVar.f23918o;
            this.f23893p = ghVar.f23919p;
            this.f23894q = ghVar.f23920q;
            this.f23895r = ghVar.f23921r;
            this.f23896s = ghVar.f23922s;
            this.f23897t = ghVar.f23923t;
            this.f23898u = ghVar.f23924u;
            this.f23899v = ghVar.f23925v;
            this.f23900w = ghVar.f23926w;
            this.f23901x = ghVar.f23927x;
        }

        /* renamed from: a */
        public final C5922a m20673a(TimeUnit timeUnit) {
            if (10 < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(10);
                if (toMillis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (toMillis != 0 || 10 <= 0) {
                    this.f23899v = (int) toMillis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        /* renamed from: b */
        public final C5922a m20676b(TimeUnit timeUnit) {
            if (30 < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(30);
                if (toMillis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (toMillis != 0 || 30 <= 0) {
                    this.f23900w = (int) toMillis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        /* renamed from: c */
        public final C5922a m20678c(TimeUnit timeUnit) {
            if (10 < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(10);
                if (toMillis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (toMillis != 0 || 10 <= 0) {
                    this.f23901x = (int) toMillis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        /* renamed from: a */
        public final C5922a m20672a(gf gfVar) {
            this.f23882e.add(gfVar);
            return this;
        }

        /* renamed from: a */
        public final List<gf> m20674a() {
            return this.f23883f;
        }

        /* renamed from: b */
        public final C5922a m20675b(gf gfVar) {
            this.f23883f.add(gfVar);
            return this;
        }

        /* renamed from: b */
        public final gh m20677b() {
            return new gh();
        }
    }

    static {
        gs.f23877b = new C59211();
    }

    public gh() {
        this(new C5922a());
    }

    private gh(C5922a c5922a) {
        this.f23904a = c5922a.f23878a;
        this.f23905b = c5922a.f23879b;
        this.f23906c = c5922a.f23880c;
        this.f23907d = c5922a.f23881d;
        this.f23908e = gy.m20785a(c5922a.f23882e);
        this.f23909f = gy.m20785a(c5922a.f23883f);
        this.f23910g = c5922a.f23884g;
        this.f23911h = c5922a.f23885h;
        this.f23912i = c5922a.f23886i;
        this.f23913j = c5922a.f23887j;
        this.f23914k = c5922a.f23888k;
        if (c5922a.f23889l != null) {
            this.f23915l = c5922a.f23889l;
        } else {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.f23915l = instance.getSocketFactory();
            } catch (GeneralSecurityException e) {
                throw new AssertionError();
            }
        }
        this.f23916m = c5922a.f23890m;
        this.f23917n = c5922a.f23891n;
        this.f23918o = c5922a.f23892o;
        this.f23919p = c5922a.f23893p;
        this.f23920q = c5922a.f23894q;
        this.f23921r = c5922a.f23895r;
        this.f23922s = c5922a.f23896s;
        this.f23923t = c5922a.f23897t;
        this.f23924u = c5922a.f23898u;
        this.f23925v = c5922a.f23899v;
        this.f23926w = c5922a.f23900w;
        this.f23927x = c5922a.f23901x;
    }

    /* renamed from: a */
    public final ga m20682a() {
        return this.f23904a;
    }

    /* renamed from: a */
    public final fr m20681a(gk gkVar) {
        return new gj(this, gkVar);
    }

    /* renamed from: b */
    public final C5922a m20683b() {
        return new C5922a(this);
    }
}
