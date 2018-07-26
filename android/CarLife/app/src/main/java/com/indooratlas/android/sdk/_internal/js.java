package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.jj.C5991b;
import com.indooratlas.android.sdk._internal.jo.C5993a;
import com.indooratlas.android.sdk._internal.jo.C5994b;
import com.indooratlas.android.sdk._internal.kd.C5997a;
import cz.msebera.android.httpclient.C6591q;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class js extends jr {
    /* renamed from: j */
    private static final byte[] f24533j = new byte[]{(byte) -1, (byte) 0};
    /* renamed from: i */
    private boolean f24534i = false;
    /* renamed from: k */
    private final Random f24535k = new Random();

    /* renamed from: a */
    private static byte[] m21435a(String str, String str2, byte[] bArr) throws jw {
        byte[] a = m21434a(str);
        byte[] a2 = m21434a(str2);
        try {
            return MessageDigest.getInstance("MD5").digest(new byte[]{a[0], a[1], a[2], a[3], a2[0], a2[1], a2[2], a2[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: d */
    private static String m21436d() {
        Random random = new Random();
        long nextInt = (long) (random.nextInt(12) + 1);
        String l = Long.toString(((long) (random.nextInt(Math.abs(new Long(4294967295L / nextInt).intValue())) + 1)) * nextInt);
        int nextInt2 = random.nextInt(12) + 1;
        for (int i = 0; i < nextInt2; i++) {
            int abs = Math.abs(random.nextInt(l.length()));
            char nextInt3 = (char) (random.nextInt(95) + 33);
            if (nextInt3 >= '0' && nextInt3 <= '9') {
                nextInt3 = (char) (nextInt3 - 15);
            }
            l = abs;
        }
        String str = l;
        for (int i2 = 0; ((long) i2) < nextInt; i2++) {
            str = Math.abs(random.nextInt(str.length() - 1) + 1);
        }
        return str;
    }

    /* renamed from: a */
    private static byte[] m21434a(String str) throws jw {
        try {
            long parseLong = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = (long) (str.split(" ").length - 1);
            if (length == 0) {
                throw new jw("invalid Sec-WebSocket-Key (/key2/)");
            }
            parseLong = new Long(parseLong / length).longValue();
            return new byte[]{(byte) ((int) (parseLong >> 24)), (byte) ((int) ((parseLong << 8) >> 24)), (byte) ((int) ((parseLong << 16) >> 24)), (byte) ((int) ((parseLong << 24) >> 24))};
        } catch (NumberFormatException e) {
            throw new jw("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    /* renamed from: a */
    public final int mo4797a(kf kfVar, km kmVar) {
        if (this.f24534i) {
            return C5994b.f24516b;
        }
        try {
            if (!kmVar.mo4821b("Sec-WebSocket-Origin").equals(kfVar.mo4821b("Origin")) || !jo.m21391a((kk) kmVar)) {
                return C5994b.f24516b;
            }
            byte[] c = kmVar.mo4824c();
            if (c == null || c.length == 0) {
                throw new jt();
            } else if (Arrays.equals(c, m21435a(kfVar.mo4821b("Sec-WebSocket-Key1"), kfVar.mo4821b("Sec-WebSocket-Key2"), kfVar.mo4824c()))) {
                return C5994b.f24515a;
            } else {
                return C5994b.f24516b;
            }
        } catch (Throwable e) {
            throw new RuntimeException("bad handshakerequest", e);
        }
    }

    /* renamed from: a */
    public final int mo4796a(kf kfVar) {
        if (kfVar.mo4821b(C6591q.f26541X).equals("WebSocket") && kfVar.mo4821b("Connection").contains(C6591q.f26541X) && kfVar.mo4821b("Sec-WebSocket-Key1").length() > 0 && !kfVar.mo4821b("Sec-WebSocket-Key2").isEmpty() && kfVar.mo4823c("Origin")) {
            return C5994b.f24515a;
        }
        return C5994b.f24516b;
    }

    /* renamed from: a */
    public final kg mo4798a(kg kgVar) {
        kgVar.mo4819a(C6591q.f26541X, "WebSocket");
        kgVar.mo4819a("Connection", C6591q.f26541X);
        kgVar.mo4819a("Sec-WebSocket-Key1", m21436d());
        kgVar.mo4819a("Sec-WebSocket-Key2", m21436d());
        if (!kgVar.mo4823c("Origin")) {
            kgVar.mo4819a("Origin", "random" + this.f24535k.nextInt());
        }
        byte[] bArr = new byte[8];
        this.f24535k.nextBytes(bArr);
        kgVar.mo4820a(bArr);
        return kgVar;
    }

    /* renamed from: a */
    public final kh mo4799a(kf kfVar, kn knVar) throws jw {
        knVar.mo4828a("WebSocket Protocol Handshake");
        knVar.mo4819a(C6591q.f26541X, "WebSocket");
        knVar.mo4819a("Connection", kfVar.mo4821b("Connection"));
        knVar.mo4819a("Sec-WebSocket-Origin", kfVar.mo4821b("Origin"));
        knVar.mo4819a("Sec-WebSocket-Location", "ws://" + kfVar.mo4821b("Host") + kfVar.mo4825a());
        String b = kfVar.mo4821b("Sec-WebSocket-Key1");
        String b2 = kfVar.mo4821b("Sec-WebSocket-Key2");
        byte[] c = kfVar.mo4824c();
        if (b == null || b2 == null || c == null || c.length != 8) {
            throw new jw("Bad keys");
        }
        knVar.mo4820a(m21435a(b, b2, c));
        return knVar;
    }

    /* renamed from: b */
    public final kk mo4807b(ByteBuffer byteBuffer) throws jw {
        kk a = jo.m21390a(byteBuffer, this.d);
        if ((a.mo4823c("Sec-WebSocket-Key1") || this.d == C5991b.f24473a) && !a.mo4823c("Sec-WebSocket-Version")) {
            byte[] bArr = new byte[(this.d == C5991b.f24474b ? 8 : 16)];
            try {
                byteBuffer.get(bArr);
                a.mo4820a(bArr);
            } catch (BufferUnderflowException e) {
                throw new jt(byteBuffer.capacity() + 16);
            }
        }
        return a;
    }

    /* renamed from: a */
    public final List<kd> mo4801a(ByteBuffer byteBuffer) throws ju {
        byteBuffer.mark();
        List<kd> c = super.mo4806c(byteBuffer);
        if (c == null) {
            byteBuffer.reset();
            c = this.g;
            this.f = true;
            if (this.h == null) {
                this.h = ByteBuffer.allocate(2);
                if (byteBuffer.remaining() > this.h.remaining()) {
                    throw new jv();
                }
                this.h.put(byteBuffer);
                if (this.h.hasRemaining()) {
                    this.g = new LinkedList();
                } else if (Arrays.equals(this.h.array(), f24533j)) {
                    c.add(new kb((byte) 0));
                } else {
                    throw new jv();
                }
            }
            throw new jv();
        }
        return c;
    }

    /* renamed from: a */
    public final ByteBuffer mo4800a(kd kdVar) {
        if (kdVar.mo4815f() == C5997a.CLOSING) {
            return ByteBuffer.wrap(f24533j);
        }
        return super.mo4800a(kdVar);
    }

    /* renamed from: b */
    public final int mo4804b() {
        return C5993a.f24512b;
    }

    /* renamed from: c */
    public final jo mo4805c() {
        return new js();
    }
}
