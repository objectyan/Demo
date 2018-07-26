package com.indooratlas.android.sdk._internal;

import com.baidu.navi.fragment.NaviFragmentManager;
import java.net.InetSocketAddress;
import java.net.Proxy;

public final class go {
    /* renamed from: a */
    public final fn f23983a;
    /* renamed from: b */
    public final Proxy f23984b;
    /* renamed from: c */
    public final InetSocketAddress f23985c;

    public go(fn fnVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (fnVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.f23983a = fnVar;
            this.f23984b = proxy;
            this.f23985c = inetSocketAddress;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof go)) {
            return false;
        }
        go goVar = (go) obj;
        if (this.f23983a.equals(goVar.f23983a) && this.f23984b.equals(goVar.f23984b) && this.f23985c.equals(goVar.f23985c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f23983a.hashCode() + NaviFragmentManager.TYPE_PHONE_END) * 31) + this.f23984b.hashCode()) * 31) + this.f23985c.hashCode();
    }
}
