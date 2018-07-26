package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.jo.C5993a;
import com.indooratlas.android.sdk._internal.jo.C5994b;
import com.indooratlas.android.sdk._internal.kd.C5997a;
import cz.msebera.android.httpclient.C6591q;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class jr extends jo {
    /* renamed from: f */
    protected boolean f24529f = false;
    /* renamed from: g */
    protected List<kd> f24530g = new LinkedList();
    /* renamed from: h */
    protected ByteBuffer f24531h;
    /* renamed from: i */
    private final Random f24532i = new Random();

    /* renamed from: a */
    public int mo4797a(kf kfVar, km kmVar) {
        return (kfVar.mo4821b("WebSocket-Origin").equals(kmVar.mo4821b("Origin")) && jo.m21391a((kk) kmVar)) ? C5994b.f24515a : C5994b.f24516b;
    }

    /* renamed from: a */
    public int mo4796a(kf kfVar) {
        if (kfVar.mo4823c("Origin") && jo.m21391a((kk) kfVar)) {
            return C5994b.f24515a;
        }
        return C5994b.f24516b;
    }

    /* renamed from: a */
    public ByteBuffer mo4800a(kd kdVar) {
        if (kdVar.mo4815f() != C5997a.TEXT) {
            throw new RuntimeException("only text frames supported");
        }
        ByteBuffer c = kdVar.mo4812c();
        ByteBuffer allocate = ByteBuffer.allocate(c.remaining() + 2);
        allocate.put((byte) 0);
        c.mark();
        allocate.put(c);
        c.reset();
        allocate.put((byte) -1);
        allocate.flip();
        return allocate;
    }

    /* renamed from: a */
    public final List<kd> mo4802a(ByteBuffer byteBuffer, boolean z) {
        throw new RuntimeException("not yet implemented");
    }

    /* renamed from: a */
    public kg mo4798a(kg kgVar) throws jw {
        kgVar.mo4819a(C6591q.f26541X, "WebSocket");
        kgVar.mo4819a("Connection", C6591q.f26541X);
        if (!kgVar.mo4823c("Origin")) {
            kgVar.mo4819a("Origin", "random" + this.f24532i.nextInt());
        }
        return kgVar;
    }

    /* renamed from: a */
    public kh mo4799a(kf kfVar, kn knVar) throws jw {
        knVar.mo4828a("Web Socket Protocol Handshake");
        knVar.mo4819a(C6591q.f26541X, "WebSocket");
        knVar.mo4819a("Connection", kfVar.mo4821b("Connection"));
        knVar.mo4819a("WebSocket-Origin", kfVar.mo4821b("Origin"));
        knVar.mo4819a("WebSocket-Location", "ws://" + kfVar.mo4821b("Host") + kfVar.mo4825a());
        return knVar;
    }

    /* renamed from: c */
    protected final List<kd> mo4806c(ByteBuffer byteBuffer) throws ju {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == (byte) 0) {
                if (this.f24529f) {
                    throw new jv("unexpected START_OF_FRAME");
                }
                this.f24529f = true;
            } else if (b == (byte) -1) {
                if (this.f24529f) {
                    if (this.f24531h != null) {
                        this.f24531h.flip();
                        ke keVar = new ke();
                        keVar.mo4809a(this.f24531h);
                        keVar.mo4810a(true);
                        keVar.mo4808a(C5997a.TEXT);
                        this.f24530g.add(keVar);
                        this.f24531h = null;
                        byteBuffer.mark();
                    }
                    this.f24529f = false;
                } else {
                    throw new jv("unexpected END_OF_FRAME");
                }
            } else if (!this.f24529f) {
                return null;
            } else {
                if (this.f24531h == null) {
                    this.f24531h = ByteBuffer.allocate(b);
                } else if (!this.f24531h.hasRemaining()) {
                    ByteBuffer byteBuffer2 = this.f24531h;
                    byteBuffer2.flip();
                    ByteBuffer allocate = ByteBuffer.allocate(jo.m21389a(byteBuffer2.capacity() * 2));
                    allocate.put(byteBuffer2);
                    this.f24531h = allocate;
                }
                this.f24531h.put(b);
            }
        }
        List<kd> list = this.f24530g;
        this.f24530g = new LinkedList();
        return list;
    }

    /* renamed from: a */
    public List<kd> mo4801a(ByteBuffer byteBuffer) throws ju {
        List<kd> c = mo4806c(byteBuffer);
        if (c != null) {
            return c;
        }
        throw new ju(1002);
    }

    /* renamed from: a */
    public final void mo4803a() {
        this.f24529f = false;
        this.f24531h = null;
    }

    /* renamed from: b */
    public int mo4804b() {
        return C5993a.f24511a;
    }

    /* renamed from: c */
    public jo mo4805c() {
        return new jr();
    }
}
