package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import com.baidu.navisdk.util.common.HttpsClient;
import com.indooratlas.android.sdk._internal.bx.C5829a;
import com.indooratlas.android.sdk._internal.jj.C5991b;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLSocket;

public final class bu implements bx {
    /* renamed from: a */
    C5829a f23270a = null;
    /* renamed from: b */
    final Object f23271b = new Object();
    /* renamed from: c */
    private C5830a f23272c;

    /* renamed from: com.indooratlas.android.sdk._internal.bu$a */
    class C5830a extends bv {
        /* renamed from: a */
        final /* synthetic */ bu f23269a;

        C5830a(bu buVar, URI uri) {
            this.f23269a = buVar;
            super(uri, new jq());
        }

        /* renamed from: a */
        public final void mo4640a(km kmVar) {
            super.mo4640a(kmVar);
            synchronized (this.f23269a.f23271b) {
                if (this.f23269a.f23270a != null) {
                    this.f23269a.f23270a.mo4635c();
                }
            }
        }

        /* renamed from: a */
        public final void m20171a(jj jjVar, kf kfVar) throws ju {
            super.a(jjVar, kfVar);
            synchronized (this.f23269a.f23271b) {
                if (this.f23269a.f23270a != null) {
                    this.f23269a.f23270a.mo4636d();
                }
            }
        }

        /* renamed from: a */
        public final void m20174a(ByteBuffer byteBuffer) {
            super.a(byteBuffer);
            synchronized (this.f23269a.f23271b) {
                if (this.f23269a.f23270a != null) {
                    this.f23269a.f23270a.mo4634a(byteBuffer);
                }
            }
        }

        /* renamed from: a */
        public final void mo4637a() {
        }

        /* renamed from: a */
        public final void mo4639a(int i, String str, boolean z) {
            super.mo4639a(i, str, z);
            synchronized (this.f23269a.f23271b) {
                if (this.f23269a.f23270a != null) {
                    Object[] objArr = new Object[]{Integer.valueOf(i), this.f23269a};
                    this.f23269a.f23270a.mo4632a(i, str, z);
                } else {
                    new Object[1][0] = this.f23269a;
                }
            }
        }

        /* renamed from: a */
        public final void m20173a(Exception exception) {
            new StringBuilder("onError: ").append(exception);
        }

        /* renamed from: a */
        protected final void mo4638a(int i) {
            super.mo4638a(i);
            synchronized (this.f23269a.f23271b) {
                if (this.f23269a.f23270a != null) {
                    this.f23269a.f23270a.mo4631a(i);
                }
            }
        }
    }

    @TargetApi(17)
    public bu(bf bfVar, URI uri, String str, int i) throws IOException {
        Object[] objArr = new Object[]{uri, str, Integer.valueOf(i), Integer.valueOf(30000), Integer.valueOf(0), Long.valueOf(HttpsClient.CONN_MGR_TIMEOUT), Integer.valueOf(bfVar.f23165j.f23073b.optInt("positioningPingPongTimeout", 5000))};
        this.f23272c = new C5830a(this, uri);
        jn jnVar = this.f23272c;
        jnVar.f23266b = HttpsClient.CONN_MGR_TIMEOUT;
        if (jnVar.f24504f.d()) {
            if (jnVar.f23266b > 0) {
                jnVar.m20166b();
            } else {
                jnVar.f23268d.removeMessages(0);
            }
        }
        this.f23272c.f23267c = r0;
        String scheme = uri.getScheme();
        int i2 = (scheme == null || !scheme.startsWith("wss")) ? 0 : 1;
        if (i2 != 0) {
            Socket socket;
            String host = uri.getHost();
            int port = uri.getPort() != -1 ? uri.getPort() : "wss".equals(uri.getScheme()) ? 443 : 80;
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
            if (str == null || i <= 0) {
                socket = null;
            } else {
                socket = m20180a(sSLCertificateSocketFactory, host, port, str, i);
            }
            if (socket == null) {
                socket = (SSLSocket) sSLCertificateSocketFactory.createSocket();
            }
            if (VERSION.SDK_INT >= 17) {
                new Object[1][0] = host;
                sSLCertificateSocketFactory.setHostname(socket, host);
            } else {
                Object[] objArr2 = new Object[]{socket.getClass().getName(), host};
                try {
                    socket.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(socket, new Object[]{host});
                } catch (Throwable e) {
                    throw new IllegalStateException(e);
                }
            }
            jn jnVar2 = this.f23272c;
            if (jnVar2.f24505g != null) {
                throw new IllegalStateException("socket has already been set");
            }
            jnVar2.f24505g = socket;
        }
    }

    /* renamed from: a */
    private static SSLSocket m20180a(SSLCertificateSocketFactory sSLCertificateSocketFactory, String str, int i, String str2, int i2) {
        try {
            Socket socket = new Socket(new Proxy(Type.SOCKS, new InetSocketAddress(str2, i2)));
            socket.connect(new InetSocketAddress(str, i));
            return (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, str2, i2, true);
        } catch (IOException e) {
            ee.m20409a("IAWire", "IOException when creating proxy socket: " + e, new Object[0]);
        } catch (SecurityException e2) {
            ee.m20409a("IAWire", "SecurityException when creating proxy socket: " + e2, new Object[0]);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo4642a(C5829a c5829a) {
        synchronized (this.f23271b) {
            this.f23270a = c5829a;
        }
    }

    /* renamed from: a */
    public final void mo4641a() {
        jn jnVar = this.f23272c;
        if (jnVar.f24506h != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        jnVar.f24506h = new Thread(jnVar);
        jnVar.f24506h.start();
        new Object[1][0] = this;
    }

    /* renamed from: b */
    public final void mo4644b() {
        Object[] objArr = new Object[]{this, Boolean.valueOf(this.f23272c.f24504f.d())};
        jn jnVar = this.f23272c;
        if (jnVar.f24506h != null) {
            jnVar.f24504f.a(1000, "", false);
        }
        synchronized (this.f23271b) {
            this.f23270a = null;
            this.f23272c = null;
        }
    }

    /* renamed from: a */
    public final void mo4643a(byte[] bArr) {
        jl jlVar = this.f23272c.f24504f;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        boolean z;
        jo joVar = jlVar.f24487k;
        if (jlVar.f24488l == C5991b.f24473a) {
            z = true;
        } else {
            z = false;
        }
        jlVar.a(joVar.a(wrap, z));
    }

    /* renamed from: c */
    public final boolean mo4645c() {
        return this.f23272c.f24504f.f() || this.f23272c.f24504f.e();
    }
}
