package com.indooratlas.android.sdk._internal;

import com.baidu.mobstat.Config;
import com.indooratlas.android.sdk._internal.jj.C5990a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;

public abstract class jn extends jk implements jj, Runnable {
    /* renamed from: i */
    static final /* synthetic */ boolean f24498i = (!jn.class.desiredAssertionStatus());
    /* renamed from: a */
    private InputStream f24499a;
    /* renamed from: b */
    private OutputStream f24500b;
    /* renamed from: c */
    private Proxy f24501c = Proxy.NO_PROXY;
    /* renamed from: d */
    private jo f24502d;
    /* renamed from: e */
    protected URI f24503e = null;
    /* renamed from: f */
    public jl f24504f = null;
    /* renamed from: g */
    public Socket f24505g = null;
    /* renamed from: h */
    public Thread f24506h;
    /* renamed from: j */
    private Map<String, String> f24507j;
    /* renamed from: k */
    private CountDownLatch f24508k = new CountDownLatch(1);
    /* renamed from: l */
    private CountDownLatch f24509l = new CountDownLatch(1);
    /* renamed from: m */
    private int f24510m = 0;

    /* renamed from: com.indooratlas.android.sdk._internal.jn$a */
    class C5992a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ jn f24497a;

        private C5992a(jn jnVar) {
            this.f24497a = jnVar;
        }

        public final void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) this.f24497a.f24504f.f24482f.take();
                    this.f24497a.f24500b.write(byteBuffer.array(), 0, byteBuffer.limit());
                    this.f24497a.f24500b.flush();
                } catch (IOException e) {
                    this.f24497a.f24504f.m21354a();
                    return;
                } catch (InterruptedException e2) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public abstract void m21370a();

    /* renamed from: a */
    public abstract void m21371a(int i, String str, boolean z);

    /* renamed from: a */
    public abstract void m21375a(km kmVar);

    /* renamed from: a */
    public abstract void m21376a(Exception exception);

    public jn(URI uri, jo joVar) {
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (joVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.f24503e = uri;
            this.f24502d = joVar;
            this.f24507j = null;
            this.f24510m = 30000;
            this.f24504f = new jl(this, joVar);
        }
    }

    public void run() {
        try {
            if (this.f24505g == null) {
                this.f24505g = new Socket(this.f24501c);
            } else if (this.f24505g.isClosed()) {
                throw new IOException();
            }
            if (!this.f24505g.isBound()) {
                this.f24505g.connect(new InetSocketAddress(this.f24503e.getHost(), m21367b()), this.f24510m);
            }
            this.f24499a = this.f24505g.getInputStream();
            this.f24500b = this.f24505g.getOutputStream();
            m21369j();
            this.f24506h = new Thread(new C5992a());
            this.f24506h.start();
            byte[] bArr = new byte[jl.f24476a];
            while (!this.f24504f.mo4788f()) {
                try {
                    int read = this.f24499a.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    jl jlVar = this.f24504f;
                    ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, read);
                    if (jl.f24479p || wrap.hasRemaining()) {
                        if (jl.f24477b) {
                            System.out.println("process(" + wrap.remaining() + "): {" + (wrap.remaining() > 1000 ? "too big to display" : new String(wrap.array(), wrap.position(), wrap.remaining())) + "}");
                        }
                        if (jlVar.f24485i != C5990a.f24467a) {
                            jlVar.m21361b(wrap);
                        } else if (jlVar.m21358a(wrap)) {
                            if (!jl.f24479p && jlVar.f24489m.hasRemaining() == wrap.hasRemaining() && wrap.hasRemaining()) {
                                throw new AssertionError();
                            } else if (wrap.hasRemaining()) {
                                jlVar.m21361b(wrap);
                            } else if (jlVar.f24489m.hasRemaining()) {
                                jlVar.m21361b(jlVar.f24489m);
                            }
                        }
                        if (!jl.f24479p && !jlVar.mo4787e() && !jlVar.f24484h && wrap.hasRemaining()) {
                            throw new AssertionError();
                        }
                    } else {
                        throw new AssertionError();
                    }
                } catch (IOException e) {
                    this.f24504f.m21354a();
                } catch (Exception e2) {
                    m21376a(e2);
                    this.f24504f.m21359b(1006, e2.getMessage(), false);
                }
            }
            this.f24504f.m21354a();
            if (!f24498i && !this.f24505g.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e22) {
            m21376a(e22);
            this.f24504f.m21359b(-1, e22.getMessage(), false);
        }
    }

    /* renamed from: b */
    private int m21367b() {
        int port = this.f24503e.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.f24503e.getScheme();
        if (scheme.equals("wss")) {
            return 443;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme" + scheme);
    }

    /* renamed from: j */
    private void m21369j() throws jw {
        String path = this.f24503e.getPath();
        String query = this.f24503e.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            path = path + "?" + query;
        }
        int b = m21367b();
        query = this.f24503e.getHost() + (b != 80 ? new StringBuilder(Config.TRACE_TODAY_VISIT_SPLIT).append(b).toString() : "");
        kg kiVar = new ki();
        kiVar.mo4826a(path);
        kiVar.mo4819a("Host", query);
        if (this.f24507j != null) {
            for (Entry entry : this.f24507j.entrySet()) {
                kiVar.mo4819a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        jj jjVar = this.f24504f;
        if (jl.f24479p || jjVar.f24485i != C5990a.f24468b) {
            jjVar.f24490n = jjVar.f24487k.mo4798a(kiVar);
            jjVar.f24491o = kiVar.mo4825a();
            if (jl.f24479p || jjVar.f24491o != null) {
                try {
                    jjVar.f24486j.mo4780a(jjVar, jjVar.f24490n);
                    jo joVar = jjVar.f24487k;
                    kk kkVar = jjVar.f24490n;
                    int i = jjVar.f24488l;
                    jjVar.m21357a(jo.m21392b(kkVar));
                    return;
                } catch (ju e) {
                    throw new jw("Handshake data rejected by client.");
                } catch (Exception e2) {
                    jjVar.f24486j.mo4792b(e2);
                    throw new jw("rejected because of" + e2);
                }
            }
            throw new AssertionError();
        }
        throw new AssertionError("shall only be called once");
    }

    /* renamed from: h */
    public final void mo4794h() {
        m21370a();
    }

    /* renamed from: b */
    public final void mo4793b(ByteBuffer byteBuffer) {
        m21377a(byteBuffer);
    }

    /* renamed from: c */
    public final void mo4782c(kd kdVar) {
        m21373a(kdVar);
    }

    /* renamed from: a */
    public final void mo4790a(kk kkVar) {
        this.f24508k.countDown();
        m21375a((km) kkVar);
    }

    /* renamed from: b */
    public final void mo4791b(int i, String str, boolean z) {
        this.f24508k.countDown();
        this.f24509l.countDown();
        if (this.f24506h != null) {
            this.f24506h.interrupt();
        }
        try {
            if (this.f24505g != null) {
                this.f24505g.close();
            }
        } catch (Exception e) {
            m21376a(e);
        }
        m21371a(i, str, z);
    }

    /* renamed from: b */
    public final void mo4792b(Exception exception) {
        m21376a(exception);
    }

    /* renamed from: a */
    public void mo4789a(jj jjVar, int i, String str, boolean z) {
    }

    /* renamed from: i */
    public final InetSocketAddress mo4795i() {
        if (this.f24505g != null) {
            return (InetSocketAddress) this.f24505g.getLocalSocketAddress();
        }
        return null;
    }

    /* renamed from: a */
    public void m21377a(ByteBuffer byteBuffer) {
    }

    /* renamed from: a */
    public void m21373a(kd kdVar) {
    }

    /* renamed from: d */
    public final boolean mo4786d() {
        return this.f24504f.mo4786d();
    }

    /* renamed from: f */
    public final boolean mo4788f() {
        return this.f24504f.mo4788f();
    }

    /* renamed from: e */
    public final boolean mo4787e() {
        return this.f24504f.mo4787e();
    }

    /* renamed from: b */
    public final void mo4784b(kd kdVar) {
        this.f24504f.mo4784b(kdVar);
    }

    /* renamed from: c */
    public final InetSocketAddress mo4785c() {
        return this.f24504f.mo4785c();
    }
}
