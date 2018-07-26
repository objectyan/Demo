package com.indooratlas.android.sdk._internal;

import com.baidu.navi.fragment.NaviFragmentManager;
import com.facebook.common.p141m.C2924g;
import com.indooratlas.android.sdk._internal.ge.C5919a;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class fn {
    /* renamed from: a */
    public final ge f23707a;
    /* renamed from: b */
    public final gb f23708b;
    /* renamed from: c */
    public final SocketFactory f23709c;
    /* renamed from: d */
    public final fo f23710d;
    /* renamed from: e */
    public final List<gi> f23711e;
    /* renamed from: f */
    public final List<fx> f23712f;
    /* renamed from: g */
    public final ProxySelector f23713g;
    /* renamed from: h */
    public final Proxy f23714h;
    /* renamed from: i */
    public final SSLSocketFactory f23715i;
    /* renamed from: j */
    public final HostnameVerifier f23716j;
    /* renamed from: k */
    public final ft f23717k;

    public fn(String str, int i, gb gbVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ft ftVar, fo foVar, Proxy proxy, List<gi> list, List<fx> list2, ProxySelector proxySelector) {
        String str2;
        C5919a c5919a = new C5919a();
        if (sSLSocketFactory != null) {
            str2 = C2924g.f12888b;
        } else {
            str2 = "http";
        }
        if (str2.equalsIgnoreCase("http")) {
            c5919a.f23852a = "http";
        } else if (str2.equalsIgnoreCase(C2924g.f12888b)) {
            c5919a.f23852a = C2924g.f12888b;
        } else {
            throw new IllegalArgumentException("unexpected scheme: " + str2);
        }
        if (str == null) {
            throw new IllegalArgumentException("host == null");
        }
        str2 = C5919a.m20621a(str, 0, str.length());
        if (str2 == null) {
            throw new IllegalArgumentException("unexpected host: " + str);
        }
        c5919a.f23855d = str2;
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("unexpected port: " + i);
        }
        c5919a.f23856e = i;
        this.f23707a = c5919a.m20629b();
        if (gbVar == null) {
            throw new IllegalArgumentException("dns == null");
        }
        this.f23708b = gbVar;
        if (socketFactory == null) {
            throw new IllegalArgumentException("socketFactory == null");
        }
        this.f23709c = socketFactory;
        if (foVar == null) {
            throw new IllegalArgumentException("proxyAuthenticator == null");
        }
        this.f23710d = foVar;
        if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        this.f23711e = gy.m20785a((List) list);
        if (list2 == null) {
            throw new IllegalArgumentException("connectionSpecs == null");
        }
        this.f23712f = gy.m20785a((List) list2);
        if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        }
        this.f23713g = proxySelector;
        this.f23714h = proxy;
        this.f23715i = sSLSocketFactory;
        this.f23716j = hostnameVerifier;
        this.f23717k = ftVar;
    }

    public final boolean equals(Object other) {
        if (!(other instanceof fn)) {
            return false;
        }
        fn fnVar = (fn) other;
        if (this.f23707a.equals(fnVar.f23707a) && this.f23708b.equals(fnVar.f23708b) && this.f23710d.equals(fnVar.f23710d) && this.f23711e.equals(fnVar.f23711e) && this.f23712f.equals(fnVar.f23712f) && this.f23713g.equals(fnVar.f23713g) && gy.m20796a(this.f23714h, fnVar.f23714h) && gy.m20796a(this.f23715i, fnVar.f23715i) && gy.m20796a(this.f23716j, fnVar.f23716j) && gy.m20796a(this.f23717k, fnVar.f23717k)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (((((((((((this.f23707a.hashCode() + NaviFragmentManager.TYPE_PHONE_END) * 31) + this.f23708b.hashCode()) * 31) + this.f23710d.hashCode()) * 31) + this.f23711e.hashCode()) * 31) + this.f23712f.hashCode()) * 31) + this.f23713g.hashCode()) * 31;
        if (this.f23714h != null) {
            hashCode = this.f23714h.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f23715i != null) {
            hashCode = this.f23715i.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f23716j != null) {
            hashCode = this.f23716j.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.f23717k != null) {
            i = this.f23717k.hashCode();
        }
        return hashCode + i;
    }
}
