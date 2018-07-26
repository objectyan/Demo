package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class gq {
    /* renamed from: a */
    public boolean f23992a;
    /* renamed from: b */
    public boolean f23993b;
    /* renamed from: c */
    private final List<fx> f23994c;
    /* renamed from: d */
    private int f23995d = 0;

    public gq(List<fx> list) {
        this.f23994c = list;
    }

    /* renamed from: a */
    public final fx m20744a(SSLSocket sSLSocket) throws IOException {
        fx fxVar;
        int i = this.f23995d;
        int size = this.f23994c.size();
        for (int i2 = i; i2 < size; i2++) {
            fxVar = (fx) this.f23994c.get(i2);
            if (fxVar.m20587a(sSLSocket)) {
                this.f23995d = i2 + 1;
                break;
            }
        }
        fxVar = null;
        if (fxVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f23993b + ", modes=" + this.f23994c + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f23992a = m20743b(sSLSocket);
        gs.f23877b.mo4685a(fxVar, sSLSocket, this.f23993b);
        return fxVar;
    }

    /* renamed from: b */
    private boolean m20743b(SSLSocket sSLSocket) {
        for (int i = this.f23995d; i < this.f23994c.size(); i++) {
            if (((fx) this.f23994c.get(i)).m20587a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
