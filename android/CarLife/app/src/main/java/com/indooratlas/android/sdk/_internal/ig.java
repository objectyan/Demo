package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;

public final class ig {
    /* renamed from: a */
    public final fn f24347a;
    /* renamed from: b */
    public final fw f24348b;
    /* renamed from: c */
    ie f24349c;
    /* renamed from: d */
    public ii f24350d;
    /* renamed from: e */
    public boolean f24351e;
    /* renamed from: f */
    public hx f24352f;
    /* renamed from: g */
    private go f24353g;
    /* renamed from: h */
    private boolean f24354h;

    public ig(fw fwVar, fn fnVar) {
        this.f24348b = fwVar;
        this.f24347a = fnVar;
        this.f24349c = new ie(fnVar, m21103c());
    }

    /* renamed from: a */
    public final hx m21104a(int i, int i2, int i3, boolean z, boolean z2) throws id, IOException {
        try {
            hx htVar;
            ii b = m21102b(i, i2, i3, z, z2);
            if (b.f24360e != null) {
                htVar = new ht(this, b.f24360e);
            } else {
                b.f24358c.setSoTimeout(i2);
                b.f24362g.mo4731a().mo4767a((long) i2, TimeUnit.MILLISECONDS);
                b.f24363h.mo4733a().mo4767a((long) i3, TimeUnit.MILLISECONDS);
                htVar = new hs(this, b.f24362g, b.f24363h);
            }
            synchronized (this.f24348b) {
                this.f24352f = htVar;
            }
            return htVar;
        } catch (IOException e) {
            throw new id(e);
        }
    }

    /* renamed from: b */
    private ii m21102b(int i, int i2, int i3, boolean z, boolean z2) throws IOException, id {
        ii a;
        while (true) {
            a = m21101a(i, i2, i3, z);
            synchronized (this.f24348b) {
                if (a.f24361f != 0) {
                    if (a.m21115a(z2)) {
                        break;
                    }
                    m21107a(new IOException());
                } else {
                    break;
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    private ii m21101a(int i, int i2, int i3, boolean z) throws IOException, id {
        ii iiVar;
        synchronized (this.f24348b) {
            if (this.f24354h) {
                throw new IllegalStateException("released");
            } else if (this.f24352f != null) {
                throw new IllegalStateException("stream != null");
            } else if (this.f24351e) {
                throw new IOException("Canceled");
            } else {
                iiVar = this.f24350d;
                if (iiVar == null || iiVar.f24365j) {
                    iiVar = gs.f23877b.a(this.f24348b, this.f24347a, this);
                    if (iiVar != null) {
                        this.f24350d = iiVar;
                    } else {
                        go goVar;
                        go goVar2 = this.f24353g;
                        if (goVar2 == null) {
                            goVar2 = this.f24349c.m21096a();
                            synchronized (this.f24348b) {
                                this.f24353g = goVar2;
                            }
                            goVar = goVar2;
                        } else {
                            goVar = goVar2;
                        }
                        iiVar = new ii(goVar);
                        m21106a(iiVar);
                        synchronized (this.f24348b) {
                            gs.f23877b.b(this.f24348b, iiVar);
                            this.f24350d = iiVar;
                            if (this.f24351e) {
                                throw new IOException("Canceled");
                            }
                        }
                        iiVar.m21114a(i, i2, i3, this.f24347a.f23712f, z);
                        m21103c().b(iiVar.f24356a);
                    }
                }
            }
        }
        return iiVar;
    }

    /* renamed from: a */
    public final void m21108a(boolean z, hx hxVar) {
        synchronized (this.f24348b) {
            if (hxVar != null) {
                if (hxVar == this.f24352f) {
                    if (!z) {
                        ii iiVar = this.f24350d;
                        iiVar.f24361f++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.f24352f + " but was " + hxVar);
        }
        m21109a(z, false, true);
    }

    /* renamed from: c */
    private gx m21103c() {
        return gs.f23877b.a(this.f24348b);
    }

    /* renamed from: a */
    public final synchronized ii m21105a() {
        return this.f24350d;
    }

    /* renamed from: b */
    public final void m21110b() {
        m21109a(false, true, false);
    }

    /* renamed from: a */
    public final void m21109a(boolean z, boolean z2, boolean z3) {
        ii iiVar;
        synchronized (this.f24348b) {
            if (z3) {
                this.f24352f = null;
            }
            if (z2) {
                this.f24354h = true;
            }
            if (this.f24350d != null) {
                if (z) {
                    this.f24350d.f24365j = true;
                }
                if (this.f24352f == null && (this.f24354h || this.f24350d.f24365j)) {
                    ii iiVar2 = this.f24350d;
                    int size = iiVar2.f24364i.size();
                    int i = 0;
                    while (i < size) {
                        if (((Reference) iiVar2.f24364i.get(i)).get() == this) {
                            iiVar2.f24364i.remove(i);
                            if (this.f24350d.f24364i.isEmpty()) {
                                this.f24350d.f24366k = System.nanoTime();
                                if (gs.f23877b.a(this.f24348b, this.f24350d)) {
                                    iiVar = this.f24350d;
                                    this.f24350d = null;
                                }
                            }
                            iiVar = null;
                            this.f24350d = null;
                        } else {
                            i++;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
            iiVar = null;
        }
        if (iiVar != null) {
            gy.a(iiVar.f24358c);
        }
    }

    /* renamed from: a */
    public final void m21107a(IOException iOException) {
        synchronized (this.f24348b) {
            if (this.f24350d != null && this.f24350d.f24361f == 0) {
                if (!(this.f24353g == null || iOException == null)) {
                    ie ieVar = this.f24349c;
                    go goVar = this.f24353g;
                    if (!(goVar.f23984b.type() == Type.DIRECT || ieVar.f24335a.f23713g == null)) {
                        ieVar.f24335a.f23713g.connectFailed(ieVar.f24335a.f23707a.a(), goVar.f23984b.address(), iOException);
                    }
                    ieVar.f24336b.a(goVar);
                }
                this.f24353g = null;
            }
        }
        m21109a(true, false, true);
    }

    /* renamed from: a */
    public final void m21106a(ii iiVar) {
        iiVar.f24364i.add(new WeakReference(this));
    }

    public final String toString() {
        return this.f24347a.toString();
    }
}
