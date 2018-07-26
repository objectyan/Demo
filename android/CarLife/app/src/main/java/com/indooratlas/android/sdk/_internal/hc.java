package com.indooratlas.android.sdk._internal;

import com.facebook.common.p262l.C5361b;
import com.indooratlas.android.sdk._internal.ha.C5936a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class hc implements Closeable {
    /* renamed from: k */
    static final /* synthetic */ boolean f24110k;
    /* renamed from: l */
    private static final ExecutorService f24111l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), gy.m20788a("OkHttp FramedConnection", true));
    /* renamed from: a */
    public final gi f24112a;
    /* renamed from: b */
    final boolean f24113b;
    /* renamed from: c */
    long f24114c;
    /* renamed from: d */
    long f24115d;
    /* renamed from: e */
    public hm f24116e;
    /* renamed from: f */
    final hm f24117f;
    /* renamed from: g */
    final ho f24118g;
    /* renamed from: h */
    final Socket f24119h;
    /* renamed from: i */
    public final hb f24120i;
    /* renamed from: j */
    final C5950c f24121j;
    /* renamed from: m */
    private final C5945b f24122m;
    /* renamed from: n */
    private final Map<Integer, hd> f24123n;
    /* renamed from: o */
    private final String f24124o;
    /* renamed from: p */
    private int f24125p;
    /* renamed from: q */
    private int f24126q;
    /* renamed from: r */
    private boolean f24127r;
    /* renamed from: s */
    private long f24128s;
    /* renamed from: t */
    private final ExecutorService f24129t;
    /* renamed from: u */
    private Map<Integer, hk> f24130u;
    /* renamed from: v */
    private final hl f24131v;
    /* renamed from: w */
    private int f24132w;
    /* renamed from: x */
    private boolean f24133x;
    /* renamed from: y */
    private final Set<Integer> f24134y;

    /* renamed from: com.indooratlas.android.sdk._internal.hc$a */
    public static class C5944a {
        /* renamed from: a */
        public Socket f24094a;
        /* renamed from: b */
        public String f24095b;
        /* renamed from: c */
        public ip f24096c;
        /* renamed from: d */
        public io f24097d;
        /* renamed from: e */
        C5945b f24098e = C5945b.f24102a;
        /* renamed from: f */
        public gi f24099f = gi.SPDY_3;
        /* renamed from: g */
        hl f24100g = hl.f24222a;
        /* renamed from: h */
        boolean f24101h = true;
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hc$b */
    public static abstract class C5945b {
        /* renamed from: a */
        public static final C5945b f24102a = new C59461();

        /* renamed from: com.indooratlas.android.sdk._internal.hc$b$1 */
        static class C59461 extends C5945b {
            C59461() {
            }

            /* renamed from: a */
            public final void mo4702a(hd hdVar) throws IOException {
                hdVar.m20912a(gz.REFUSED_STREAM);
            }
        }

        /* renamed from: a */
        public abstract void mo4702a(hd hdVar) throws IOException;

        /* renamed from: a */
        public static void m20837a() {
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hc$c */
    class C5950c extends gu implements C5936a {
        /* renamed from: a */
        final ha f24108a;
        /* renamed from: c */
        final /* synthetic */ hc f24109c;

        private C5950c(hc hcVar, ha haVar) {
            this.f24109c = hcVar;
            super("OkHttp %s", hcVar.f24124o);
            this.f24108a = haVar;
        }

        /* renamed from: b */
        protected final void mo4692b() {
            gz gzVar;
            Throwable th;
            gz gzVar2 = gz.INTERNAL_ERROR;
            gz gzVar3 = gz.INTERNAL_ERROR;
            try {
                if (!this.f24109c.f24113b) {
                    this.f24108a.mo4711a();
                }
                do {
                } while (this.f24108a.mo4712a(this));
                try {
                    this.f24109c.m20853a(gz.NO_ERROR, gz.CANCEL);
                } catch (IOException e) {
                }
                gy.m20790a(this.f24108a);
            } catch (IOException e2) {
                gzVar = gz.PROTOCOL_ERROR;
                try {
                    this.f24109c.m20853a(gzVar, gz.PROTOCOL_ERROR);
                } catch (IOException e3) {
                }
                gy.m20790a(this.f24108a);
            } catch (Throwable th2) {
                th = th2;
                this.f24109c.m20853a(gzVar, gzVar3);
                gy.m20790a(this.f24108a);
                throw th;
            }
        }

        /* renamed from: a */
        public final void mo4708a(boolean z, int i, ip ipVar, int i2) throws IOException {
            if (hc.m20862a(this.f24109c, i)) {
                hc.m20856a(this.f24109c, i, ipVar, i2, z);
                return;
            }
            hd a = this.f24109c.m20878a(i);
            if (a == null) {
                this.f24109c.m20881a(i, gz.INVALID_STREAM);
                ipVar.f((long) i2);
            } else if (hd.f24148j || !Thread.holdsLock(a)) {
                a.f24154f.m20897a(ipVar, (long) i2);
                if (z) {
                    a.m20919e();
                }
            } else {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo4710a(boolean r9, boolean r10, int r11, java.util.List<com.indooratlas.android.sdk._internal.he> r12, com.indooratlas.android.sdk._internal.hf r13) {
            /*
            r8 = this;
            r2 = 0;
            r0 = 1;
            r1 = r8.f24109c;
            r1 = com.indooratlas.android.sdk._internal.hc.m20862a(r1, r11);
            if (r1 == 0) goto L_0x0010;
        L_0x000a:
            r0 = r8.f24109c;
            com.indooratlas.android.sdk._internal.hc.m20858a(r0, r11, r12, r10);
        L_0x000f:
            return;
        L_0x0010:
            r6 = r8.f24109c;
            monitor-enter(r6);
            r1 = r8.f24109c;	 Catch:{ all -> 0x001d }
            r1 = r1.f24127r;	 Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x0020;
        L_0x001b:
            monitor-exit(r6);	 Catch:{ all -> 0x001d }
            goto L_0x000f;
        L_0x001d:
            r0 = move-exception;
            monitor-exit(r6);	 Catch:{ all -> 0x001d }
            throw r0;
        L_0x0020:
            r1 = r8.f24109c;	 Catch:{ all -> 0x001d }
            r3 = r1.m20878a(r11);	 Catch:{ all -> 0x001d }
            if (r3 != 0) goto L_0x0096;
        L_0x0028:
            r1 = com.indooratlas.android.sdk._internal.hf.SPDY_REPLY;	 Catch:{ all -> 0x001d }
            if (r13 == r1) goto L_0x0030;
        L_0x002c:
            r1 = com.indooratlas.android.sdk._internal.hf.SPDY_HEADERS;	 Catch:{ all -> 0x001d }
            if (r13 != r1) goto L_0x0031;
        L_0x0030:
            r2 = r0;
        L_0x0031:
            if (r2 == 0) goto L_0x003c;
        L_0x0033:
            r0 = r8.f24109c;	 Catch:{ all -> 0x001d }
            r1 = com.indooratlas.android.sdk._internal.gz.INVALID_STREAM;	 Catch:{ all -> 0x001d }
            r0.m20881a(r11, r1);	 Catch:{ all -> 0x001d }
            monitor-exit(r6);	 Catch:{ all -> 0x001d }
            goto L_0x000f;
        L_0x003c:
            r0 = r8.f24109c;	 Catch:{ all -> 0x001d }
            r0 = r0.f24125p;	 Catch:{ all -> 0x001d }
            if (r11 > r0) goto L_0x0046;
        L_0x0044:
            monitor-exit(r6);	 Catch:{ all -> 0x001d }
            goto L_0x000f;
        L_0x0046:
            r0 = r11 % 2;
            r1 = r8.f24109c;	 Catch:{ all -> 0x001d }
            r1 = r1.f24126q;	 Catch:{ all -> 0x001d }
            r1 = r1 % 2;
            if (r0 != r1) goto L_0x0054;
        L_0x0052:
            monitor-exit(r6);	 Catch:{ all -> 0x001d }
            goto L_0x000f;
        L_0x0054:
            r0 = new com.indooratlas.android.sdk._internal.hd;	 Catch:{ all -> 0x001d }
            r2 = r8.f24109c;	 Catch:{ all -> 0x001d }
            r1 = r11;
            r3 = r9;
            r4 = r10;
            r5 = r12;
            r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x001d }
            r1 = r8.f24109c;	 Catch:{ all -> 0x001d }
            r1.f24125p = r11;	 Catch:{ all -> 0x001d }
            r1 = r8.f24109c;	 Catch:{ all -> 0x001d }
            r1 = r1.f24123n;	 Catch:{ all -> 0x001d }
            r2 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x001d }
            r1.put(r2, r0);	 Catch:{ all -> 0x001d }
            r1 = com.indooratlas.android.sdk._internal.hc.f24111l;	 Catch:{ all -> 0x001d }
            r2 = new com.indooratlas.android.sdk._internal.hc$c$1;	 Catch:{ all -> 0x001d }
            r3 = "OkHttp %s stream %d";
            r4 = 2;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x001d }
            r5 = 0;
            r7 = r8.f24109c;	 Catch:{ all -> 0x001d }
            r7 = r7.f24124o;	 Catch:{ all -> 0x001d }
            r4[r5] = r7;	 Catch:{ all -> 0x001d }
            r5 = 1;
            r7 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x001d }
            r4[r5] = r7;	 Catch:{ all -> 0x001d }
            r2.<init>(r8, r3, r4, r0);	 Catch:{ all -> 0x001d }
            r1.execute(r2);	 Catch:{ all -> 0x001d }
            monitor-exit(r6);	 Catch:{ all -> 0x001d }
            goto L_0x000f;
        L_0x0096:
            monitor-exit(r6);	 Catch:{ all -> 0x001d }
            r1 = com.indooratlas.android.sdk._internal.hf.SPDY_SYN_STREAM;
            if (r13 != r1) goto L_0x00aa;
        L_0x009b:
            r1 = r0;
        L_0x009c:
            if (r1 == 0) goto L_0x00ac;
        L_0x009e:
            r0 = com.indooratlas.android.sdk._internal.gz.PROTOCOL_ERROR;
            r3.m20914b(r0);
            r0 = r8.f24109c;
            r0.m20883b(r11);
            goto L_0x000f;
        L_0x00aa:
            r1 = r2;
            goto L_0x009c;
        L_0x00ac:
            r1 = com.indooratlas.android.sdk._internal.hd.f24148j;
            if (r1 != 0) goto L_0x00bc;
        L_0x00b0:
            r1 = java.lang.Thread.holdsLock(r3);
            if (r1 == 0) goto L_0x00bc;
        L_0x00b6:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x00bc:
            r1 = 0;
            monitor-enter(r3);
            r4 = r3.f24153e;	 Catch:{ all -> 0x00e2 }
            if (r4 != 0) goto L_0x00e5;
        L_0x00c2:
            r4 = com.indooratlas.android.sdk._internal.hf.SPDY_HEADERS;	 Catch:{ all -> 0x00e2 }
            if (r13 != r4) goto L_0x00c7;
        L_0x00c6:
            r2 = r0;
        L_0x00c7:
            if (r2 == 0) goto L_0x00d8;
        L_0x00c9:
            r1 = com.indooratlas.android.sdk._internal.gz.PROTOCOL_ERROR;	 Catch:{ all -> 0x00e2 }
        L_0x00cb:
            monitor-exit(r3);	 Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x00ff;
        L_0x00ce:
            r3.m20914b(r1);
        L_0x00d1:
            if (r10 == 0) goto L_0x000f;
        L_0x00d3:
            r3.m20919e();
            goto L_0x000f;
        L_0x00d8:
            r3.f24153e = r12;	 Catch:{ all -> 0x00e2 }
            r0 = r3.m20913a();	 Catch:{ all -> 0x00e2 }
            r3.notifyAll();	 Catch:{ all -> 0x00e2 }
            goto L_0x00cb;
        L_0x00e2:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x00e2 }
            throw r0;
        L_0x00e5:
            r4 = com.indooratlas.android.sdk._internal.hf.SPDY_REPLY;	 Catch:{ all -> 0x00e2 }
            if (r13 != r4) goto L_0x00ea;
        L_0x00e9:
            r2 = r0;
        L_0x00ea:
            if (r2 == 0) goto L_0x00ef;
        L_0x00ec:
            r1 = com.indooratlas.android.sdk._internal.gz.STREAM_IN_USE;	 Catch:{ all -> 0x00e2 }
            goto L_0x00cb;
        L_0x00ef:
            r2 = new java.util.ArrayList;	 Catch:{ all -> 0x00e2 }
            r2.<init>();	 Catch:{ all -> 0x00e2 }
            r4 = r3.f24153e;	 Catch:{ all -> 0x00e2 }
            r2.addAll(r4);	 Catch:{ all -> 0x00e2 }
            r2.addAll(r12);	 Catch:{ all -> 0x00e2 }
            r3.f24153e = r2;	 Catch:{ all -> 0x00e2 }
            goto L_0x00cb;
        L_0x00ff:
            if (r0 != 0) goto L_0x00d1;
        L_0x0101:
            r0 = r3.f24152d;
            r1 = r3.f24151c;
            r0.m20883b(r1);
            goto L_0x00d1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.hc.c.a(boolean, boolean, int, java.util.List, com.indooratlas.android.sdk._internal.hf):void");
        }

        /* renamed from: a */
        public final void mo4704a(int i, gz gzVar) {
            if (hc.m20862a(this.f24109c, i)) {
                hc.m20855a(this.f24109c, i, gzVar);
                return;
            }
            hd b = this.f24109c.m20883b(i);
            if (b != null) {
                b.m20917c(gzVar);
            }
        }

        /* renamed from: a */
        public final void mo4709a(boolean z, final hm hmVar) {
            hd[] hdVarArr;
            long j;
            synchronized (this.f24109c) {
                int i;
                int b = this.f24109c.f24117f.m20984b();
                if (z) {
                    hm hmVar2 = this.f24109c.f24117f;
                    hmVar2.f24225c = 0;
                    hmVar2.f24224b = 0;
                    hmVar2.f24223a = 0;
                    Arrays.fill(hmVar2.f24226d, 0);
                }
                hm hmVar3 = this.f24109c.f24117f;
                for (i = 0; i < 10; i++) {
                    if (hmVar.m20983a(i)) {
                        hmVar3.m20982a(i, hmVar.m20985b(i), hmVar.f24226d[i]);
                    }
                }
                if (this.f24109c.f24112a == gi.HTTP_2) {
                    hc.f24111l.execute(new gu(this, "OkHttp %s ACK Settings", new Object[]{this.f24109c.f24124o}) {
                        /* renamed from: c */
                        final /* synthetic */ C5950c f24107c;

                        /* renamed from: b */
                        public final void mo4692b() {
                            try {
                                this.f24107c.f24109c.f24120i.mo4717a(hmVar);
                            } catch (IOException e) {
                            }
                        }
                    });
                }
                i = this.f24109c.f24117f.m20984b();
                if (i == -1 || i == b) {
                    hdVarArr = null;
                    j = 0;
                } else {
                    long j2 = (long) (i - b);
                    if (!this.f24109c.f24133x) {
                        hc hcVar = this.f24109c;
                        hcVar.f24115d += j2;
                        if (j2 > 0) {
                            hcVar.notifyAll();
                        }
                        this.f24109c.f24133x = true;
                    }
                    if (this.f24109c.f24123n.isEmpty()) {
                        j = j2;
                        hdVarArr = null;
                    } else {
                        j = j2;
                        hdVarArr = (hd[]) this.f24109c.f24123n.values().toArray(new hd[this.f24109c.f24123n.size()]);
                    }
                }
                hc.f24111l.execute(new gu(this, "OkHttp %s settings", this.f24109c.f24124o) {
                    /* renamed from: a */
                    final /* synthetic */ C5950c f24105a;

                    /* renamed from: b */
                    public final void mo4692b() {
                        this.f24105a.f24109c.f24122m;
                        C5945b.m20837a();
                    }
                });
            }
            if (hdVarArr != null && j != 0) {
                for (hd hdVar : hdVarArr) {
                    synchronized (hdVar) {
                        hdVar.m20911a(j);
                    }
                }
            }
        }

        /* renamed from: a */
        public final void mo4707a(boolean z, int i, int i2) {
            if (z) {
                hk c = this.f24109c.m20866c(i);
                if (c == null) {
                    return;
                }
                if (c.f24221c != -1 || c.f24220b == -1) {
                    throw new IllegalStateException();
                }
                c.f24221c = System.nanoTime();
                c.f24219a.countDown();
                return;
            }
            hc.m20854a(this.f24109c, i, i2);
        }

        /* renamed from: a */
        public final void mo4703a(int i, long j) {
            if (i == 0) {
                synchronized (this.f24109c) {
                    hc hcVar = this.f24109c;
                    hcVar.f24115d += j;
                    this.f24109c.notifyAll();
                }
                return;
            }
            hd a = this.f24109c.m20878a(i);
            if (a != null) {
                synchronized (a) {
                    a.m20911a(j);
                }
            }
        }

        /* renamed from: a */
        public final void mo4706a(int i, List<he> list) {
            hc.m20857a(this.f24109c, i, (List) list);
        }

        /* renamed from: a */
        public final void mo4705a(int i, iq iqVar) {
            byte[] bArr = iqVar.f24395c;
            synchronized (this.f24109c) {
                hd[] hdVarArr = (hd[]) this.f24109c.f24123n.values().toArray(new hd[this.f24109c.f24123n.size()]);
                this.f24109c.f24127r = true;
            }
            for (hd hdVar : hdVarArr) {
                if (hdVar.f24151c > i && hdVar.m20915b()) {
                    hdVar.m20917c(gz.REFUSED_STREAM);
                    this.f24109c.m20883b(hdVar.f24151c);
                }
            }
        }
    }

    static {
        boolean z;
        if (hc.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f24110k = z;
    }

    private hc(C5944a c5944a) throws IOException {
        int i;
        int i2 = 2;
        this.f24123n = new HashMap();
        this.f24128s = System.nanoTime();
        this.f24114c = 0;
        this.f24116e = new hm();
        this.f24117f = new hm();
        this.f24133x = false;
        this.f24134y = new LinkedHashSet();
        this.f24112a = c5944a.f24099f;
        this.f24131v = c5944a.f24100g;
        this.f24113b = c5944a.f24101h;
        this.f24122m = c5944a.f24098e;
        if (c5944a.f24101h) {
            i = 1;
        } else {
            i = 2;
        }
        this.f24126q = i;
        if (c5944a.f24101h && this.f24112a == gi.HTTP_2) {
            this.f24126q += 2;
        }
        if (c5944a.f24101h) {
            i2 = 1;
        }
        this.f24132w = i2;
        if (c5944a.f24101h) {
            this.f24116e.m20982a(7, 0, 16777216);
        }
        this.f24124o = c5944a.f24095b;
        if (this.f24112a == gi.HTTP_2) {
            this.f24118g = new hh();
            this.f24129t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), gy.m20788a(String.format("OkHttp %s Push Observer", new Object[]{this.f24124o}), true));
            this.f24117f.m20982a(7, 0, 65535);
            this.f24117f.m20982a(5, 0, 16384);
        } else if (this.f24112a == gi.SPDY_3) {
            this.f24118g = new hn();
            this.f24129t = null;
        } else {
            throw new AssertionError(this.f24112a);
        }
        this.f24115d = (long) this.f24117f.m20984b();
        this.f24119h = c5944a.f24094a;
        this.f24120i = this.f24118g.mo4725a(c5944a.f24097d, this.f24113b);
        this.f24121j = new C5950c(this.f24118g.mo4724a(c5944a.f24096c, this.f24113b));
        new Thread(this.f24121j).start();
    }

    /* renamed from: a */
    final synchronized hd m20878a(int i) {
        return (hd) this.f24123n.get(Integer.valueOf(i));
    }

    /* renamed from: b */
    final synchronized hd m20883b(int i) {
        hd hdVar;
        hdVar = (hd) this.f24123n.remove(Integer.valueOf(i));
        if (hdVar != null && this.f24123n.isEmpty()) {
            m20861a(true);
        }
        notifyAll();
        return hdVar;
    }

    /* renamed from: a */
    private synchronized void m20861a(boolean z) {
        this.f24128s = z ? System.nanoTime() : C5361b.f21945a;
    }

    /* renamed from: a */
    public final synchronized int m20877a() {
        hm hmVar;
        hmVar = this.f24117f;
        return (hmVar.f24223a & 16) != 0 ? hmVar.f24226d[4] : Integer.MAX_VALUE;
    }

    /* renamed from: a */
    public final hd m20879a(List<he> list, boolean z) throws IOException {
        hd hdVar;
        boolean z2 = false;
        if (!z) {
            z2 = true;
        }
        synchronized (this.f24120i) {
            int i;
            synchronized (this) {
                if (this.f24127r) {
                    throw new IOException("shutdown");
                }
                i = this.f24126q;
                this.f24126q += 2;
                hdVar = new hd(i, this, z2, false, list);
                if (hdVar.m20913a()) {
                    this.f24123n.put(Integer.valueOf(i), hdVar);
                    m20861a(false);
                }
            }
            this.f24120i.mo4720a(z2, i, (List) list);
        }
        if (!z) {
            this.f24120i.mo4721b();
        }
        return hdVar;
    }

    /* renamed from: a */
    public final void m20882a(int i, boolean z, in inVar, long j) throws IOException {
        if (j == 0) {
            this.f24120i.mo4719a(z, i, inVar, 0);
            return;
        }
        while (j > 0) {
            int min;
            boolean z2;
            synchronized (this) {
                while (this.f24115d <= 0) {
                    try {
                        if (this.f24123n.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.f24115d), this.f24120i.mo4723c());
                this.f24115d -= (long) min;
            }
            j -= (long) min;
            hb hbVar = this.f24120i;
            if (z && j == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            hbVar.mo4719a(z2, i, inVar, min);
        }
    }

    /* renamed from: a */
    final void m20881a(int i, gz gzVar) {
        final int i2 = i;
        final gz gzVar2 = gzVar;
        f24111l.submit(new gu(this, "OkHttp %s stream %d", new Object[]{this.f24124o, Integer.valueOf(i)}) {
            /* renamed from: d */
            final /* synthetic */ hc f24070d;

            /* renamed from: b */
            public final void mo4692b() {
                try {
                    this.f24070d.m20885b(i2, gzVar2);
                } catch (IOException e) {
                }
            }
        });
    }

    /* renamed from: b */
    final void m20885b(int i, gz gzVar) throws IOException {
        this.f24120i.mo4715a(i, gzVar);
    }

    /* renamed from: a */
    final void m20880a(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        f24111l.execute(new gu(this, "OkHttp Window Update %s stream %d", new Object[]{this.f24124o, Integer.valueOf(i)}) {
            /* renamed from: d */
            final /* synthetic */ hc f24073d;

            /* renamed from: b */
            public final void mo4692b() {
                try {
                    this.f24073d.f24120i.mo4714a(i2, j2);
                } catch (IOException e) {
                }
            }
        });
    }

    /* renamed from: c */
    private synchronized hk m20866c(int i) {
        return this.f24130u != null ? (hk) this.f24130u.remove(Integer.valueOf(i)) : null;
    }

    /* renamed from: b */
    public final void m20884b() throws IOException {
        this.f24120i.mo4721b();
    }

    public final void close() throws IOException {
        m20853a(gz.NO_ERROR, gz.CANCEL);
    }

    /* renamed from: a */
    private void m20853a(gz gzVar, gz gzVar2) throws IOException {
        IOException iOException;
        if (f24110k || !Thread.holdsLock(this)) {
            IOException iOException2;
            hd[] hdVarArr;
            hk[] hkVarArr;
            try {
                synchronized (this.f24120i) {
                    synchronized (this) {
                        if (this.f24127r) {
                            iOException2 = null;
                        } else {
                            this.f24127r = true;
                            this.f24120i.mo4716a(this.f24125p, gzVar, gy.f24040a);
                            iOException2 = null;
                        }
                    }
                    if (hdVarArr != null) {
                        iOException = iOException2;
                        for (hd a : hdVarArr) {
                            try {
                                a.m20912a(gzVar2);
                            } catch (IOException iOException22) {
                                if (iOException != null) {
                                    iOException = iOException22;
                                }
                            }
                        }
                        iOException22 = iOException;
                    }
                    if (hkVarArr != null) {
                        for (hk hkVar : hkVarArr) {
                            if (hkVar.f24221c == -1 || hkVar.f24220b == -1) {
                                throw new IllegalStateException();
                            }
                            hkVar.f24221c = hkVar.f24220b - 1;
                            hkVar.f24219a.countDown();
                        }
                    }
                    this.f24120i.close();
                    iOException = iOException22;
                    this.f24119h.close();
                    if (iOException != null) {
                        throw iOException;
                    }
                    return;
                }
            } catch (IOException iOException3) {
                iOException22 = iOException3;
            }
            synchronized (this) {
                if (this.f24123n.isEmpty()) {
                    hdVarArr = null;
                } else {
                    hd[] hdVarArr2 = (hd[]) this.f24123n.values().toArray(new hd[this.f24123n.size()]);
                    this.f24123n.clear();
                    m20861a(false);
                    hdVarArr = hdVarArr2;
                }
                if (this.f24130u != null) {
                    hk[] hkVarArr2 = (hk[]) this.f24130u.values().toArray(new hk[this.f24130u.size()]);
                    this.f24130u = null;
                    hkVarArr = hkVarArr2;
                } else {
                    hkVarArr = null;
                }
            }
            if (hdVarArr != null) {
                iOException3 = iOException22;
                while (r2 < r6) {
                    a.m20912a(gzVar2);
                }
                iOException22 = iOException3;
            }
            if (hkVarArr != null) {
                while (r0 < r2) {
                    if (hkVar.f24221c == -1) {
                    }
                    throw new IllegalStateException();
                }
            }
            try {
                this.f24120i.close();
                iOException3 = iOException22;
            } catch (IOException e) {
                iOException3 = e;
                if (iOException22 != null) {
                    iOException3 = iOException22;
                }
            }
            try {
                this.f24119h.close();
            } catch (IOException e2) {
                iOException3 = e2;
            }
            if (iOException3 != null) {
                throw iOException3;
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    static /* synthetic */ void m20860a(hc hcVar, boolean z, int i, int i2, hk hkVar) throws IOException {
        synchronized (hcVar.f24120i) {
            if (hkVar != null) {
                if (hkVar.f24220b != -1) {
                    throw new IllegalStateException();
                }
                hkVar.f24220b = System.nanoTime();
            }
            hcVar.f24120i.mo4718a(z, i, i2);
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m20862a(hc hcVar, int i) {
        return hcVar.f24112a == gi.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    /* renamed from: a */
    static /* synthetic */ void m20856a(hc hcVar, int i, ip ipVar, int i2, boolean z) throws IOException {
        final in inVar = new in();
        ipVar.a((long) i2);
        ipVar.a(inVar, (long) i2);
        if (inVar.f24392b != ((long) i2)) {
            throw new IOException(inVar.f24392b + " != " + i2);
        }
        hc hcVar2 = hcVar;
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        hcVar.f24129t.execute(new gu(hcVar2, "OkHttp %s Push Data[%s]", new Object[]{hcVar.f24124o, Integer.valueOf(i)}) {
            /* renamed from: f */
            final /* synthetic */ hc f24090f;

            /* renamed from: b */
            public final void mo4692b() {
                try {
                    this.f24090f.f24131v.mo4727a(inVar, i4);
                    this.f24090f.f24120i.mo4715a(i3, gz.CANCEL);
                    synchronized (this.f24090f) {
                        this.f24090f.f24134y.remove(Integer.valueOf(i3));
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m20858a(hc hcVar, int i, List list, boolean z) {
        hc hcVar2 = hcVar;
        final int i2 = i;
        final List list2 = list;
        final boolean z2 = z;
        hcVar.f24129t.execute(new gu(hcVar2, "OkHttp %s Push Headers[%s]", new Object[]{hcVar.f24124o, Integer.valueOf(i)}) {
            /* renamed from: e */
            final /* synthetic */ hc f24085e;

            /* renamed from: b */
            public final void mo4692b() {
                this.f24085e.f24131v.mo4728b();
                try {
                    this.f24085e.f24120i.mo4715a(i2, gz.CANCEL);
                    synchronized (this.f24085e) {
                        this.f24085e.f24134y.remove(Integer.valueOf(i2));
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m20855a(hc hcVar, int i, gz gzVar) {
        hc hcVar2 = hcVar;
        final int i2 = i;
        final gz gzVar2 = gzVar;
        hcVar.f24129t.execute(new gu(hcVar2, "OkHttp %s Push Reset[%s]", new Object[]{hcVar.f24124o, Integer.valueOf(i)}) {
            /* renamed from: d */
            final /* synthetic */ hc f24093d;

            /* renamed from: b */
            public final void mo4692b() {
                this.f24093d.f24131v.mo4729c();
                synchronized (this.f24093d) {
                    this.f24093d.f24134y.remove(Integer.valueOf(i2));
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m20854a(hc hcVar, int i, int i2) {
        hc hcVar2 = hcVar;
        final int i3 = i;
        final int i4 = i2;
        f24111l.execute(new gu(hcVar2, "OkHttp %s ping %08x%08x", new Object[]{hcVar.f24124o, Integer.valueOf(i), Integer.valueOf(i2)}) {
            /* renamed from: a */
            final /* synthetic */ boolean f24074a = true;
            /* renamed from: e */
            final /* synthetic */ hk f24077e;
            /* renamed from: f */
            final /* synthetic */ hc f24078f;

            /* renamed from: b */
            public final void mo4692b() {
                try {
                    hc.m20860a(this.f24078f, this.f24074a, i3, i4, this.f24077e);
                } catch (IOException e) {
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m20857a(hc hcVar, int i, List list) {
        synchronized (hcVar) {
            if (hcVar.f24134y.contains(Integer.valueOf(i))) {
                hcVar.m20881a(i, gz.PROTOCOL_ERROR);
                return;
            }
            hcVar.f24134y.add(Integer.valueOf(i));
            hc hcVar2 = hcVar;
            final int i2 = i;
            final List list2 = list;
            hcVar.f24129t.execute(new gu(hcVar2, "OkHttp %s Push Request[%s]", new Object[]{hcVar.f24124o, Integer.valueOf(i)}) {
                /* renamed from: d */
                final /* synthetic */ hc f24081d;

                /* renamed from: b */
                public final void mo4692b() {
                    this.f24081d.f24131v.mo4726a();
                    try {
                        this.f24081d.f24120i.mo4715a(i2, gz.CANCEL);
                        synchronized (this.f24081d) {
                            this.f24081d.f24134y.remove(Integer.valueOf(i2));
                        }
                    } catch (IOException e) {
                    }
                }
            });
        }
    }
}
