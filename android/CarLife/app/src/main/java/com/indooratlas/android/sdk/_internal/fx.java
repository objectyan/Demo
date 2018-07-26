package com.indooratlas.android.sdk._internal;

import com.baidu.navi.fragment.NaviFragmentManager;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;

public final class fx {
    /* renamed from: a */
    public static final fx f23810a;
    /* renamed from: b */
    public static final fx f23811b = new C5913a(f23810a).m20578a(gp.TLS_1_0).m20577a().m20581b();
    /* renamed from: c */
    public static final fx f23812c = new C5913a(false).m20581b();
    /* renamed from: g */
    private static final fu[] f23813g = new fu[]{fu.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, fu.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, fu.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, fu.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, fu.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, fu.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, fu.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, fu.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, fu.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, fu.TLS_RSA_WITH_AES_128_GCM_SHA256, fu.TLS_RSA_WITH_AES_128_CBC_SHA, fu.TLS_RSA_WITH_AES_256_CBC_SHA, fu.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    /* renamed from: d */
    public final boolean f23814d;
    /* renamed from: e */
    final String[] f23815e;
    /* renamed from: f */
    final String[] f23816f;
    /* renamed from: h */
    private final boolean f23817h;

    /* renamed from: com.indooratlas.android.sdk._internal.fx$a */
    public static final class C5913a {
        /* renamed from: a */
        boolean f23806a;
        /* renamed from: b */
        String[] f23807b;
        /* renamed from: c */
        String[] f23808c;
        /* renamed from: d */
        boolean f23809d;

        C5913a(boolean z) {
            this.f23806a = z;
        }

        public C5913a(fx fxVar) {
            this.f23806a = fxVar.f23817h;
            this.f23807b = fxVar.f23815e;
            this.f23808c = fxVar.f23816f;
            this.f23809d = fxVar.f23814d;
        }

        /* renamed from: a */
        public final C5913a m20579a(String... strArr) {
            if (!this.f23806a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            } else {
                this.f23807b = (String[]) strArr.clone();
                return this;
            }
        }

        /* renamed from: a */
        public final C5913a m20578a(gp... gpVarArr) {
            if (this.f23806a) {
                String[] strArr = new String[gpVarArr.length];
                for (int i = 0; i < gpVarArr.length; i++) {
                    strArr[i] = gpVarArr[i].f23991e;
                }
                return m20580b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: b */
        public final C5913a m20580b(String... strArr) {
            if (!this.f23806a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            } else {
                this.f23808c = (String[]) strArr.clone();
                return this;
            }
        }

        /* renamed from: a */
        public final C5913a m20577a() {
            if (this.f23806a) {
                this.f23809d = true;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: b */
        public final fx m20581b() {
            return new fx();
        }
    }

    static {
        C5913a c5913a = new C5913a(true);
        fu[] fuVarArr = f23813g;
        if (c5913a.f23806a) {
            String[] strArr = new String[fuVarArr.length];
            for (int i = 0; i < fuVarArr.length; i++) {
                strArr[i] = fuVarArr[i].aS;
            }
            f23810a = c5913a.m20579a(strArr).m20578a(gp.TLS_1_2, gp.TLS_1_1, gp.TLS_1_0).m20577a().m20581b();
            return;
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }

    private fx(C5913a c5913a) {
        this.f23817h = c5913a.f23806a;
        this.f23815e = c5913a.f23807b;
        this.f23816f = c5913a.f23808c;
        this.f23814d = c5913a.f23809d;
    }

    /* renamed from: a */
    public final boolean m20587a(SSLSocket sSLSocket) {
        if (!this.f23817h) {
            return false;
        }
        if (this.f23816f != null && !m20583a(this.f23816f, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f23815e == null || m20583a(this.f23815e, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m20583a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String a : strArr) {
            if (gy.m20797a(strArr2, a)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object other) {
        if (!(other instanceof fx)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        fx fxVar = (fx) other;
        if (this.f23817h != fxVar.f23817h) {
            return false;
        }
        if (!this.f23817h || (Arrays.equals(this.f23815e, fxVar.f23815e) && Arrays.equals(this.f23816f, fxVar.f23816f) && this.f23814d == fxVar.f23814d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (!this.f23817h) {
            return 17;
        }
        return (this.f23814d ? 0 : 1) + ((((Arrays.hashCode(this.f23815e) + NaviFragmentManager.TYPE_PHONE_END) * 31) + Arrays.hashCode(this.f23816f)) * 31);
    }

    public final String toString() {
        Object obj = null;
        int i = 0;
        if (!this.f23817h) {
            return "ConnectionSpec()";
        }
        String obj2;
        String obj3;
        if (this.f23815e != null) {
            Object obj4;
            if (this.f23815e == null) {
                obj4 = null;
            } else {
                Object[] objArr = new fu[this.f23815e.length];
                for (int i2 = 0; i2 < this.f23815e.length; i2++) {
                    objArr[i2] = fu.m20574a(this.f23815e[i2]);
                }
                obj4 = gy.m20786a(objArr);
            }
            obj2 = obj4.toString();
        } else {
            obj2 = "[all enabled]";
        }
        if (this.f23816f != null) {
            if (this.f23816f != null) {
                Object[] objArr2 = new gp[this.f23816f.length];
                while (i < this.f23816f.length) {
                    objArr2[i] = gp.m20742a(this.f23816f[i]);
                    i++;
                }
                obj = gy.m20786a(objArr2);
            }
            obj3 = obj.toString();
        } else {
            obj3 = "[all enabled]";
        }
        return "ConnectionSpec(cipherSuites=" + obj2 + ", tlsVersions=" + obj3 + ", supportsTlsExtensions=" + this.f23814d + ")";
    }
}
