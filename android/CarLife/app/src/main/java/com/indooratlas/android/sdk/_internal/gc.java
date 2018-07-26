package com.indooratlas.android.sdk._internal;

import com.baidu.navi.fragment.NaviFragmentManager;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class gc {
    /* renamed from: a */
    public final fu f23840a;
    /* renamed from: b */
    public final List<Certificate> f23841b;
    /* renamed from: c */
    private final gp f23842c;
    /* renamed from: d */
    private final List<Certificate> f23843d;

    private gc(gp gpVar, fu fuVar, List<Certificate> list, List<Certificate> list2) {
        this.f23842c = gpVar;
        this.f23840a = fuVar;
        this.f23841b = list;
        this.f23843d = list2;
    }

    /* renamed from: a */
    public static gc m20609a(SSLSession sSLSession) {
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        fu a = fu.m20574a(cipherSuite);
        cipherSuite = sSLSession.getProtocol();
        if (cipherSuite == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        Object[] peerCertificates;
        List a2;
        List a3;
        gp a4 = gp.m20742a(cipherSuite);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerCertificates = null;
        }
        if (peerCertificates != null) {
            a2 = gy.m20786a(peerCertificates);
        } else {
            a2 = Collections.emptyList();
        }
        Object[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            a3 = gy.m20786a(localCertificates);
        } else {
            a3 = Collections.emptyList();
        }
        return new gc(a4, a, a2, a3);
    }

    public final boolean equals(Object other) {
        if (!(other instanceof gc)) {
            return false;
        }
        gc gcVar = (gc) other;
        if (gy.m20796a(this.f23840a, gcVar.f23840a) && this.f23840a.equals(gcVar.f23840a) && this.f23841b.equals(gcVar.f23841b) && this.f23843d.equals(gcVar.f23843d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.f23842c != null ? this.f23842c.hashCode() : 0) + NaviFragmentManager.TYPE_PHONE_END) * 31) + this.f23840a.hashCode()) * 31) + this.f23841b.hashCode()) * 31) + this.f23843d.hashCode();
    }
}
