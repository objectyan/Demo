package com.indooratlas.android.sdk._internal;

import com.baidu.mobstat.Config;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.facebook.common.p262l.C5361b;
import com.indooratlas.android.sdk._internal.gk.C5925a;
import com.indooratlas.android.sdk._internal.gm.C5927a;
import com.indooratlas.android.sdk._internal.hc.C5944a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class ii implements fv {
    /* renamed from: a */
    public final go f24356a;
    /* renamed from: b */
    public Socket f24357b;
    /* renamed from: c */
    public Socket f24358c;
    /* renamed from: d */
    public gc f24359d;
    /* renamed from: e */
    public volatile hc f24360e;
    /* renamed from: f */
    public int f24361f;
    /* renamed from: g */
    public ip f24362g;
    /* renamed from: h */
    public io f24363h;
    /* renamed from: i */
    public final List<Reference<ig>> f24364i = new ArrayList();
    /* renamed from: j */
    public boolean f24365j;
    /* renamed from: k */
    public long f24366k = C5361b.f21945a;
    /* renamed from: l */
    private gi f24367l;

    public ii(go goVar) {
        this.f24356a = goVar;
    }

    /* renamed from: a */
    public final void m21114a(int i, int i2, int i3, List<fx> list, boolean z) throws id {
        Socket createSocket;
        Throwable th;
        Throwable th2;
        IOException e;
        id idVar;
        if (this.f24367l != null) {
            throw new IllegalStateException("already connected");
        }
        gq gqVar = new gq(list);
        Proxy proxy = this.f24356a.f23984b;
        fn fnVar = this.f24356a.f23983a;
        if (this.f24356a.f23983a.f23715i == null) {
            if (!list.contains(fx.f23812c)) {
                throw new id(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
            }
        }
        id idVar2 = null;
        while (this.f24367l == null) {
            Socket socket;
            if (proxy.type() == Type.DIRECT || proxy.type() == Type.HTTP) {
                createSocket = fnVar.f23709c.createSocket();
            } else {
                createSocket = new Socket(proxy);
            }
            this.f24357b = createSocket;
            this.f24357b.setSoTimeout(i2);
            try {
                gw.a().a(this.f24357b, this.f24356a.f23985c, i);
                this.f24362g = ix.m21259a(ix.m21262b(this.f24357b));
                this.f24363h = ix.m21258a(ix.m21260a(this.f24357b));
                if (this.f24356a.f23983a.f23715i != null) {
                    Object obj;
                    String str;
                    go goVar = this.f24356a;
                    if (goVar.f23983a.f23715i == null || goVar.f23984b.type() != Type.HTTP) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        gk a = new C5925a().a(this.f24356a.f23983a.f23707a).a("Host", gy.a(this.f24356a.f23983a.f23707a)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", "okhttp/3.0.1").a();
                        ge geVar = a.f23952a;
                        str = "CONNECT " + geVar.f23862b + Config.TRACE_TODAY_VISIT_SPLIT + geVar.f23863c + " HTTP/1.1";
                        hs hsVar = new hs(null, this.f24362g, this.f24363h);
                        this.f24362g.mo4731a().mo4767a((long) i2, TimeUnit.MILLISECONDS);
                        this.f24363h.mo4733a().mo4767a((long) i3, TimeUnit.MILLISECONDS);
                        hsVar.a(a.f23954c, str);
                        hsVar.c();
                        C5927a d = hsVar.d();
                        d.f23962a = a;
                        gm a2 = d.a();
                        long a3 = hy.m21080a(a2);
                        if (a3 == -1) {
                            a3 = 0;
                        }
                        jd a4 = hsVar.a(a3);
                        gy.a(a4, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
                        a4.close();
                        switch (a2.f23974c) {
                            case 200:
                                if (!(this.f24362g.mo4741b().mo4748d() && this.f24363h.mo4741b().mo4748d())) {
                                    throw new IOException("TLS tunnel buffered too many bytes!");
                                }
                            case 407:
                                this.f24356a.f23983a.f23710d.a();
                                throw new IOException("Failed to authenticate with proxy");
                            default:
                                throw new IOException("Unexpected response code for CONNECT: " + a2.f23974c);
                        }
                    }
                    fn fnVar2 = this.f24356a.f23983a;
                    socket = null;
                    try {
                        createSocket = (SSLSocket) fnVar2.f23715i.createSocket(this.f24357b, fnVar2.f23707a.f23862b, fnVar2.f23707a.f23863c, true);
                        fx a5 = gqVar.a(createSocket);
                        if (a5.f23814d) {
                            gw.a().a(createSocket, fnVar2.f23707a.f23862b, fnVar2.f23711e);
                        }
                        createSocket.startHandshake();
                        gc a6 = gc.a(createSocket.getSession());
                        if (fnVar2.f23716j.verify(fnVar2.f23707a.f23862b, createSocket.getSession())) {
                            fnVar2.f23717k.a(fnVar2.f23707a.f23862b, a6.f23841b);
                            str = a5.f23814d ? gw.a().b(createSocket) : null;
                            try {
                                this.f24358c = createSocket;
                                this.f24362g = ix.m21259a(ix.m21262b(this.f24358c));
                                this.f24363h = ix.m21258a(ix.m21260a(this.f24358c));
                                this.f24359d = a6;
                                this.f24367l = str != null ? gi.a(str) : gi.HTTP_1_1;
                                if (createSocket != null) {
                                    gw.a().a(createSocket);
                                }
                            } catch (Throwable e2) {
                                th = e2;
                                socket = createSocket;
                                th2 = th;
                            } catch (Throwable e22) {
                                th = e22;
                                socket = createSocket;
                                th2 = th;
                            }
                        } else {
                            X509Certificate x509Certificate = (X509Certificate) a6.f23841b.get(0);
                            throw new SSLPeerUnverifiedException("Hostname " + fnVar2.f23707a.f23862b + " not verified:\n    certificate: " + ft.a(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + ik.m21122a(x509Certificate));
                        }
                    } catch (AssertionError e3) {
                        th2 = e3;
                    }
                } else {
                    this.f24367l = gi.HTTP_1_1;
                    this.f24358c = this.f24357b;
                }
                if (this.f24367l == gi.SPDY_3 || this.f24367l == gi.HTTP_2) {
                    this.f24358c.setSoTimeout(0);
                    C5944a c5944a = new C5944a();
                    socket = this.f24358c;
                    String str2 = this.f24356a.f23983a.f23707a.f23862b;
                    ip ipVar = this.f24362g;
                    io ioVar = this.f24363h;
                    c5944a.f24094a = socket;
                    c5944a.f24095b = str2;
                    c5944a.f24096c = ipVar;
                    c5944a.f24097d = ioVar;
                    c5944a.f24099f = this.f24367l;
                    hc hcVar = new hc(c5944a, (byte) 0);
                    hcVar.f24120i.a();
                    hcVar.f24120i.b(hcVar.f24116e);
                    int b = hcVar.f24116e.b();
                    if (b != 65536) {
                        hcVar.f24120i.a(0, (long) (b - 65536));
                    }
                    this.f24360e = hcVar;
                }
            } catch (ConnectException e4) {
                throw new ConnectException("Failed to connect to " + this.f24356a.f23985c);
            } catch (IOException e5) {
                r3 = e5;
                gy.a(this.f24358c);
                gy.a(this.f24357b);
                this.f24358c = null;
                this.f24357b = null;
                this.f24362g = null;
                this.f24363h = null;
                this.f24359d = null;
                this.f24367l = null;
                IOException iOException;
                if (idVar2 == null) {
                    idVar = new id(iOException);
                } else {
                    e5 = idVar2.f24334b;
                    if (id.f24333a != null) {
                        try {
                            id.f24333a.invoke(iOException, new Object[]{e5});
                        } catch (InvocationTargetException e6) {
                        } catch (IllegalAccessException e7) {
                        }
                    }
                    idVar2.f24334b = iOException;
                    idVar = idVar2;
                }
                if (z) {
                    Object obj2;
                    gqVar.f23993b = true;
                    if (!gqVar.f23992a || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || !((iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException)))) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        idVar2 = idVar;
                    }
                }
                throw idVar;
            }
        }
        return;
        try {
            if (gy.a(th2)) {
                throw new IOException(th2);
            }
            throw th2;
        } catch (Throwable th3) {
            th2 = th3;
        }
        if (socket != null) {
            gw.a().a(socket);
        }
        gy.a(socket);
        throw th2;
    }

    /* renamed from: a */
    public final go m21113a() {
        return this.f24356a;
    }

    /* renamed from: a */
    public final boolean m21115a(boolean z) {
        if (this.f24358c.isClosed() || this.f24358c.isInputShutdown() || this.f24358c.isOutputShutdown()) {
            return false;
        }
        if (this.f24360e != null || !z) {
            return true;
        }
        int soTimeout;
        try {
            soTimeout = this.f24358c.getSoTimeout();
            this.f24358c.setSoTimeout(1);
            if (this.f24362g.mo4748d()) {
                this.f24358c.setSoTimeout(soTimeout);
                return false;
            }
            this.f24358c.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            this.f24358c.setSoTimeout(soTimeout);
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder append = new StringBuilder("Connection{").append(this.f24356a.f23983a.f23707a.f23862b).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.f24356a.f23983a.f23707a.f23863c).append(", proxy=").append(this.f24356a.f23984b).append(" hostAddress=").append(this.f24356a.f23985c).append(" cipherSuite=");
        if (this.f24359d != null) {
            obj = this.f24359d.f23840a;
        } else {
            obj = BNavConfig.INVALID_STRING_VALUE;
        }
        return append.append(obj).append(" protocol=").append(this.f24367l).append('}').toString();
    }
}
