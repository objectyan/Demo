package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.jj.C5990a;
import com.indooratlas.android.sdk._internal.jj.C5991b;
import com.indooratlas.android.sdk._internal.jo.C5993a;
import com.indooratlas.android.sdk._internal.jo.C5994b;
import com.indooratlas.android.sdk._internal.kd.C5997a;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class jl implements jj {
    /* renamed from: a */
    public static int f24476a = 16384;
    /* renamed from: b */
    public static boolean f24477b = false;
    /* renamed from: c */
    public static final List<jo> f24478c;
    /* renamed from: p */
    public static final /* synthetic */ boolean f24479p = (!jl.class.desiredAssertionStatus());
    /* renamed from: d */
    public SelectionKey f24480d;
    /* renamed from: e */
    public ByteChannel f24481e;
    /* renamed from: f */
    public final BlockingQueue<ByteBuffer> f24482f;
    /* renamed from: g */
    public final BlockingQueue<ByteBuffer> f24483g;
    /* renamed from: h */
    public volatile boolean f24484h = false;
    /* renamed from: i */
    public int f24485i = C5990a.f24467a;
    /* renamed from: j */
    public final jm f24486j;
    /* renamed from: k */
    public jo f24487k = null;
    /* renamed from: l */
    public int f24488l;
    /* renamed from: m */
    public ByteBuffer f24489m = ByteBuffer.allocate(0);
    /* renamed from: n */
    public kf f24490n = null;
    /* renamed from: o */
    public String f24491o = null;
    /* renamed from: q */
    private List<jo> f24492q;
    /* renamed from: r */
    private C5997a f24493r = null;
    /* renamed from: s */
    private String f24494s = null;
    /* renamed from: t */
    private Integer f24495t = null;
    /* renamed from: u */
    private Boolean f24496u = null;

    static {
        List arrayList = new ArrayList(4);
        f24478c = arrayList;
        arrayList.add(new jq());
        f24478c.add(new jp());
        f24478c.add(new js());
        f24478c.add(new jr());
    }

    public jl(jm jmVar, jo joVar) {
        if (jmVar == null || (joVar == null && this.f24488l == C5991b.f24474b)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.f24482f = new LinkedBlockingQueue();
        this.f24483g = new LinkedBlockingQueue();
        this.f24486j = jmVar;
        this.f24488l = C5991b.f24473a;
        if (joVar != null) {
            this.f24487k = joVar.mo4805c();
        }
    }

    /* renamed from: a */
    public final boolean m21358a(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.f24489m.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.f24489m.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.f24489m.capacity() + byteBuffer.remaining());
                this.f24489m.flip();
                allocate.put(this.f24489m);
                this.f24489m = allocate;
            }
            this.f24489m.put(byteBuffer);
            this.f24489m.flip();
            byteBuffer2 = this.f24489m;
        }
        byteBuffer2.mark();
        int i;
        try {
            if (this.f24487k == null) {
                byteBuffer2.mark();
                if (byteBuffer2.limit() > jo.f24520c.length) {
                    i = C5994b.f24516b;
                } else if (byteBuffer2.limit() < jo.f24520c.length) {
                    throw new jt(jo.f24520c.length);
                } else {
                    i = 0;
                    while (byteBuffer2.hasRemaining()) {
                        if (jo.f24520c[i] != byteBuffer2.get()) {
                            byteBuffer2.reset();
                            i = C5994b.f24516b;
                            break;
                        }
                        i++;
                    }
                    i = C5994b.f24515a;
                }
                if (i == C5994b.f24515a) {
                    try {
                        m21353c(ByteBuffer.wrap(kp.m21499a(this.f24486j.mo4778a((jj) this))));
                        m21355a(-3, "", false);
                    } catch (ju e) {
                        m21355a(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
                    }
                    return false;
                }
            }
            try {
                kk b;
                if (this.f24488l != C5991b.f24474b) {
                    if (this.f24488l == C5991b.f24473a) {
                        this.f24487k.m21404b(this.f24488l);
                        b = this.f24487k.mo4807b(byteBuffer2);
                        if (b instanceof km) {
                            b = (km) b;
                            if (this.f24487k.mo4797a(this.f24490n, (km) b) == C5994b.f24515a) {
                                m21351a(b);
                                return true;
                            }
                            m21355a(1002, "draft " + this.f24487k + " refuses handshake", false);
                        } else {
                            m21352c(1002, "wrong http function", false);
                            return false;
                        }
                    }
                    return false;
                } else if (this.f24487k == null) {
                    for (jo c : this.f24492q) {
                        jo c2 = c.mo4805c();
                        try {
                            c2.m21404b(this.f24488l);
                            byteBuffer2.reset();
                            b = c2.mo4807b(byteBuffer2);
                            if (b instanceof kf) {
                                b = (kf) b;
                                if (c2.mo4796a((kf) b) == C5994b.f24515a) {
                                    this.f24491o = b.mo4825a();
                                    try {
                                        m21357a(jo.m21392b(c2.mo4799a((kf) b, this.f24486j.mo4783g())));
                                        this.f24487k = c2;
                                        m21351a(b);
                                        return true;
                                    } catch (ju e2) {
                                        m21352c(e2.f24537a, e2.getMessage(), false);
                                        return false;
                                    } catch (Exception e3) {
                                        this.f24486j.mo4792b(e3);
                                        m21352c(-1, e3.getMessage(), false);
                                        return false;
                                    }
                                }
                                continue;
                            } else {
                                m21352c(1002, "wrong http function", false);
                                return false;
                            }
                        } catch (jw e4) {
                        }
                    }
                    if (this.f24487k == null) {
                        m21355a(1002, "no draft matches", false);
                    }
                    return false;
                } else {
                    b = this.f24487k.mo4807b(byteBuffer2);
                    if (b instanceof kf) {
                        b = (kf) b;
                        if (this.f24487k.mo4796a((kf) b) == C5994b.f24515a) {
                            m21351a(b);
                            return true;
                        }
                        m21355a(1002, "the handshake did finaly not match", false);
                        return false;
                    }
                    m21352c(1002, "wrong http function", false);
                    return false;
                }
            } catch (ju e22) {
                m21350a(e22);
            }
        } catch (jt e5) {
            jt jtVar = e5;
            if (this.f24489m.capacity() == 0) {
                byteBuffer2.reset();
                i = jtVar.f24536a;
                if (i == 0) {
                    i = byteBuffer2.capacity() + 16;
                } else if (!f24479p && jtVar.f24536a < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.f24489m = ByteBuffer.allocate(i);
                this.f24489m.put(byteBuffer);
            } else {
                this.f24489m.position(this.f24489m.limit());
                this.f24489m.limit(this.f24489m.capacity());
            }
        }
    }

    /* renamed from: b */
    public final void m21361b(ByteBuffer byteBuffer) {
        try {
            for (kd kdVar : this.f24487k.mo4801a(byteBuffer)) {
                if (f24477b) {
                    System.out.println("matched frame: " + kdVar);
                }
                C5997a f = kdVar.mo4815f();
                boolean d = kdVar.mo4813d();
                if (f == C5997a.CLOSING) {
                    int a;
                    String b;
                    String str = "";
                    if (kdVar instanceof ka) {
                        ka kaVar = (ka) kdVar;
                        a = kaVar.mo4816a();
                        b = kaVar.mo4817b();
                    } else {
                        b = str;
                        a = 1005;
                    }
                    if (this.f24485i == C5990a.f24470d) {
                        m21359b(a, b, true);
                    } else if (this.f24487k.mo4804b() == C5993a.f24513c) {
                        m21355a(a, b, true);
                    } else {
                        m21352c(a, b, false);
                    }
                } else if (f == C5997a.PING) {
                    this.f24486j.mo4779a((jj) this, kdVar);
                } else if (f == C5997a.PONG) {
                    this.f24486j.mo4781b(this, kdVar);
                } else if (!d || f == C5997a.CONTINUOUS) {
                    if (f != C5997a.CONTINUOUS) {
                        if (this.f24493r != null) {
                            throw new ju(1002, "Previous continuous frame sequence not completed.");
                        }
                        this.f24493r = f;
                    } else if (d) {
                        if (this.f24493r == null) {
                            throw new ju(1002, "Continuous frame sequence was not started.");
                        }
                        this.f24493r = null;
                    } else if (this.f24493r == null) {
                        throw new ju(1002, "Continuous frame sequence was not started.");
                    }
                    try {
                        this.f24486j.mo4782c(kdVar);
                    } catch (Exception e) {
                        this.f24486j.mo4792b(e);
                    }
                } else if (this.f24493r != null) {
                    throw new ju(1002, "Continuous frame sequence not completed.");
                } else if (f == C5997a.TEXT) {
                    try {
                        jm jmVar = this.f24486j;
                        kp.m21497a(kdVar.mo4812c());
                        jmVar.mo4794h();
                    } catch (Exception e2) {
                        this.f24486j.mo4792b(e2);
                    }
                } else if (f == C5997a.BINARY) {
                    try {
                        this.f24486j.mo4793b(kdVar.mo4812c());
                    } catch (Exception e22) {
                        this.f24486j.mo4792b(e22);
                    }
                } else {
                    throw new ju(1002, "non control or continious frame expected");
                }
            }
        } catch (ju e3) {
            this.f24486j.mo4792b((Exception) e3);
            m21350a(e3);
        }
    }

    /* renamed from: a */
    public final void m21355a(int i, String str, boolean z) {
        if (this.f24485i != C5990a.f24470d && this.f24485i != C5990a.f24471e) {
            if (this.f24485i == C5990a.f24469c) {
                if (i != 1006) {
                    if (this.f24487k.mo4804b() != C5993a.f24511a) {
                        try {
                            mo4784b(new kb(i, str));
                        } catch (Exception e) {
                            this.f24486j.mo4792b(e);
                            m21352c(1006, "generated frame is invalid", false);
                        }
                    }
                    m21352c(i, str, z);
                } else if (f24479p || !z) {
                    this.f24485i = C5990a.f24470d;
                    m21352c(i, str, false);
                    return;
                } else {
                    throw new AssertionError();
                }
            } else if (i != -3) {
                m21352c(-1, str, false);
            } else if (f24479p || z) {
                m21352c(-3, str, true);
            } else {
                throw new AssertionError();
            }
            if (i == 1002) {
                m21352c(i, str, z);
            }
            this.f24485i = C5990a.f24470d;
            this.f24489m = null;
        }
    }

    /* renamed from: b */
    public final synchronized void m21359b(int i, String str, boolean z) {
        if (this.f24485i != C5990a.f24471e) {
            if (this.f24480d != null) {
                this.f24480d.cancel();
            }
            if (this.f24481e != null) {
                try {
                    this.f24481e.close();
                } catch (Exception e) {
                    this.f24486j.mo4792b(e);
                }
            }
            try {
                this.f24486j.mo4791b(i, str, z);
            } catch (Exception e2) {
                this.f24486j.mo4792b(e2);
            }
            if (this.f24487k != null) {
                this.f24487k.mo4803a();
            }
            this.f24490n = null;
            this.f24485i = C5990a.f24471e;
            this.f24482f.clear();
        }
    }

    /* renamed from: a */
    private void m21349a(int i) {
        m21359b(i, "", true);
    }

    /* renamed from: c */
    private synchronized void m21352c(int i, String str, boolean z) {
        if (!this.f24484h) {
            this.f24495t = Integer.valueOf(i);
            this.f24494s = str;
            this.f24496u = Boolean.valueOf(z);
            this.f24484h = true;
            try {
                this.f24486j.mo4789a(this, i, str, z);
            } catch (Exception e) {
                this.f24486j.mo4792b(e);
            }
            if (this.f24487k != null) {
                this.f24487k.mo4803a();
            }
            this.f24490n = null;
        }
    }

    /* renamed from: a */
    public final void m21354a() {
        if (this.f24485i == C5990a.f24467a) {
            m21349a(-1);
        } else if (this.f24484h) {
            m21359b(this.f24495t.intValue(), this.f24494s, this.f24496u.booleanValue());
        } else if (this.f24487k.mo4804b() == C5993a.f24511a) {
            m21349a(1000);
        } else if (this.f24487k.mo4804b() != C5993a.f24512b || this.f24488l == C5991b.f24474b) {
            m21349a(1006);
        } else {
            m21349a(1000);
        }
    }

    /* renamed from: a */
    public final void m21356a(Collection<kd> collection) {
        if (mo4786d()) {
            for (kd b : collection) {
                mo4784b(b);
            }
            return;
        }
        throw new jz();
    }

    /* renamed from: b */
    public final void mo4784b(kd kdVar) {
        if (f24477b) {
            System.out.println("send frame: " + kdVar);
        }
        m21353c(this.f24487k.mo4800a(kdVar));
    }

    /* renamed from: c */
    private void m21353c(ByteBuffer byteBuffer) {
        if (f24477b) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + "}");
        }
        this.f24482f.add(byteBuffer);
    }

    /* renamed from: a */
    public final void m21357a(List<ByteBuffer> list) {
        for (ByteBuffer c : list) {
            m21353c(c);
        }
    }

    /* renamed from: a */
    private void m21351a(kk kkVar) {
        if (f24477b) {
            System.out.println("open using draft: " + this.f24487k.getClass().getSimpleName());
        }
        this.f24485i = C5990a.f24469c;
        try {
            this.f24486j.mo4790a(kkVar);
        } catch (Exception e) {
            this.f24486j.mo4792b(e);
        }
    }

    /* renamed from: d */
    public final boolean mo4786d() {
        if (f24479p || this.f24485i != C5990a.f24469c || !this.f24484h) {
            return this.f24485i == C5990a.f24469c;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: e */
    public final boolean mo4787e() {
        return this.f24485i == C5990a.f24470d;
    }

    /* renamed from: f */
    public final boolean mo4788f() {
        return this.f24485i == C5990a.f24471e;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    /* renamed from: c */
    public final InetSocketAddress mo4785c() {
        return this.f24486j.mo4795i();
    }

    /* renamed from: a */
    private void m21350a(ju juVar) {
        m21355a(juVar.f24537a, juVar.getMessage(), false);
    }
}
