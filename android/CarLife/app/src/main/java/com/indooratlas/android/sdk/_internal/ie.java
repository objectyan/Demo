package com.indooratlas.android.sdk._internal;

import com.baidu.mobstat.Config;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class ie {
    /* renamed from: a */
    final fn f24335a;
    /* renamed from: b */
    final gx f24336b;
    /* renamed from: c */
    private Proxy f24337c;
    /* renamed from: d */
    private InetSocketAddress f24338d;
    /* renamed from: e */
    private List<Proxy> f24339e = Collections.emptyList();
    /* renamed from: f */
    private int f24340f;
    /* renamed from: g */
    private List<InetSocketAddress> f24341g = Collections.emptyList();
    /* renamed from: h */
    private int f24342h;
    /* renamed from: i */
    private final List<go> f24343i = new ArrayList();

    public ie(fn fnVar, gx gxVar) {
        this.f24335a = fnVar;
        this.f24336b = gxVar;
        ge geVar = fnVar.f23707a;
        Proxy proxy = fnVar.f23714h;
        if (proxy != null) {
            this.f24339e = Collections.singletonList(proxy);
        } else {
            this.f24339e = new ArrayList();
            Collection select = this.f24335a.f23713g.select(geVar.a());
            if (select != null) {
                this.f24339e.addAll(select);
            }
            this.f24339e.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.f24339e.add(Proxy.NO_PROXY);
        }
        this.f24340f = 0;
    }

    /* renamed from: a */
    public final go m21096a() throws IOException {
        while (true) {
            if (!m21098c()) {
                if (!m21097b()) {
                    break;
                } else if (m21097b()) {
                    List list = this.f24339e;
                    int i = this.f24340f;
                    this.f24340f = i + 1;
                    Proxy proxy = (Proxy) list.get(i);
                    m21095a(proxy);
                    this.f24337c = proxy;
                } else {
                    throw new SocketException("No route to " + this.f24335a.f23707a.f23862b + "; exhausted proxy configurations: " + this.f24339e);
                }
            }
            if (m21098c()) {
                list = this.f24341g;
                i = this.f24342h;
                this.f24342h = i + 1;
                this.f24338d = (InetSocketAddress) list.get(i);
                go goVar = new go(this.f24335a, this.f24337c, this.f24338d);
                if (!this.f24336b.c(goVar)) {
                    return goVar;
                }
                this.f24343i.add(goVar);
            } else {
                throw new SocketException("No route to " + this.f24335a.f23707a.f23862b + "; exhausted inet socket addresses: " + this.f24341g);
            }
        }
        if (m21099d()) {
            return (go) this.f24343i.remove(0);
        }
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    final boolean m21097b() {
        return this.f24340f < this.f24339e.size();
    }

    /* renamed from: a */
    private void m21095a(Proxy proxy) throws IOException {
        String str;
        int i;
        this.f24341g = new ArrayList();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            str = this.f24335a.f23707a.f23862b;
            i = this.f24335a.f23707a.f23863c;
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                InetAddress address2 = inetSocketAddress.getAddress();
                if (address2 == null) {
                    str = inetSocketAddress.getHostName();
                } else {
                    str = address2.getHostAddress();
                }
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i <= 0 || i > 65535) {
            throw new SocketException("No route to " + str + Config.TRACE_TODAY_VISIT_SPLIT + i + "; port is out of range");
        }
        if (proxy.type() == Type.SOCKS) {
            this.f24341g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            List a = this.f24335a.f23708b.a(str);
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f24341g.add(new InetSocketAddress((InetAddress) a.get(i2), i));
            }
        }
        this.f24342h = 0;
    }

    /* renamed from: c */
    final boolean m21098c() {
        return this.f24342h < this.f24341g.size();
    }

    /* renamed from: d */
    final boolean m21099d() {
        return !this.f24343i.isEmpty();
    }
}
