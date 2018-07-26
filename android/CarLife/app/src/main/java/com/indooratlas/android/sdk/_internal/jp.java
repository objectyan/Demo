package com.indooratlas.android.sdk._internal;

import android.support.v4.media.TransportMediator;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.indooratlas.android.sdk._internal.jj.C5991b;
import com.indooratlas.android.sdk._internal.jo.C5993a;
import com.indooratlas.android.sdk._internal.jo.C5994b;
import com.indooratlas.android.sdk._internal.kd.C5997a;
import cz.msebera.android.httpclient.C6591q;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class jp extends jo {
    /* renamed from: f */
    static final /* synthetic */ boolean f24525f = (!jp.class.desiredAssertionStatus());
    /* renamed from: g */
    private ByteBuffer f24526g;
    /* renamed from: h */
    private kd f24527h = null;
    /* renamed from: i */
    private final Random f24528i = new Random();

    /* renamed from: com.indooratlas.android.sdk._internal.jp$a */
    class C5995a extends Throwable {
        private static final long serialVersionUID = 7330519489840500997L;
        /* renamed from: a */
        int f24523a;
        /* renamed from: b */
        final /* synthetic */ jp f24524b;

        public C5995a(jp jpVar, int i) {
            this.f24524b = jpVar;
            this.f24523a = i;
        }
    }

    /* renamed from: c */
    public static int m21408c(kk kkVar) {
        int i = -1;
        String b = kkVar.mo4821b("Sec-WebSocket-Version");
        if (b.length() > 0) {
            try {
                i = new Integer(b.trim()).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    /* renamed from: a */
    public final int mo4797a(kf kfVar, km kmVar) throws jw {
        if (!kfVar.mo4823c("Sec-WebSocket-Key") || !kmVar.mo4823c("Sec-WebSocket-Accept")) {
            return C5994b.f24516b;
        }
        if (m21406a(kfVar.mo4821b("Sec-WebSocket-Key")).equals(kmVar.mo4821b("Sec-WebSocket-Accept"))) {
            return C5994b.f24515a;
        }
        return C5994b.f24516b;
    }

    /* renamed from: a */
    public int mo4796a(kf kfVar) throws jw {
        int c = m21408c((kk) kfVar);
        if (c == 7 || c == 8) {
            return jo.m21391a((kk) kfVar) ? C5994b.f24515a : C5994b.f24516b;
        } else {
            return C5994b.f24516b;
        }
    }

    /* renamed from: a */
    public final ByteBuffer mo4800a(kd kdVar) {
        int i;
        int i2 = -128;
        int i3 = 0;
        ByteBuffer c = kdVar.mo4812c();
        int i4 = this.d == C5991b.f24473a ? 1 : 0;
        int i5 = c.remaining() <= RouteLineResConst.LINE_FOOT_GREEN_NORMAL ? 1 : c.remaining() <= 65535 ? 2 : 8;
        if (i5 > 1) {
            i = i5 + 1;
        } else {
            i = i5;
        }
        int i6 = i + 1;
        if (i4 != 0) {
            i = 4;
        } else {
            i = 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate((i + i6) + c.remaining());
        C5997a f = kdVar.mo4815f();
        if (f == C5997a.CONTINUOUS) {
            i = 0;
        } else if (f == C5997a.TEXT) {
            i = 1;
        } else if (f == C5997a.BINARY) {
            i = 2;
        } else if (f == C5997a.CLOSING) {
            i = 8;
        } else if (f == C5997a.PING) {
            i = 9;
        } else if (f == C5997a.PONG) {
            i = 10;
        } else {
            throw new RuntimeException("Don't know how to handle " + f.toString());
        }
        allocate.put((byte) (i | ((byte) (kdVar.mo4813d() ? -128 : 0))));
        byte[] a = m21407a((long) c.remaining(), i5);
        if (f24525f || a.length == i5) {
            if (i5 == 1) {
                byte b = a[0];
                if (i4 == 0) {
                    i2 = 0;
                }
                allocate.put((byte) (b | i2));
            } else if (i5 == 2) {
                if (i4 == 0) {
                    i2 = 0;
                }
                allocate.put((byte) (i2 | 126));
                allocate.put(a);
            } else if (i5 == 8) {
                if (i4 == 0) {
                    i2 = 0;
                }
                allocate.put((byte) (i2 | TransportMediator.KEYCODE_MEDIA_PAUSE));
                allocate.put(a);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (i4 != 0) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.f24528i.nextInt());
                allocate.put(allocate2.array());
                while (c.hasRemaining()) {
                    allocate.put((byte) (c.get() ^ allocate2.get(i3 % 4)));
                    i3++;
                }
            } else {
                allocate.put(c);
            }
            if (f24525f || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public final List<kd> mo4802a(ByteBuffer byteBuffer, boolean z) {
        kc keVar = new ke();
        try {
            keVar.mo4809a(byteBuffer);
            keVar.mo4810a(true);
            keVar.mo4808a(C5997a.BINARY);
            keVar.mo4811b(z);
            return Collections.singletonList(keVar);
        } catch (Throwable e) {
            throw new jy(e);
        }
    }

    /* renamed from: a */
    private static String m21406a(String str) {
        String str2 = str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            return ko.m21494a(MessageDigest.getInstance("SHA1").digest(str2.getBytes()));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public kg mo4798a(kg kgVar) {
        kgVar.mo4819a(C6591q.f26541X, "websocket");
        kgVar.mo4819a("Connection", C6591q.f26541X);
        kgVar.mo4819a("Sec-WebSocket-Version", NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL);
        byte[] bArr = new byte[16];
        this.f24528i.nextBytes(bArr);
        kgVar.mo4819a("Sec-WebSocket-Key", ko.m21494a(bArr));
        return kgVar;
    }

    /* renamed from: a */
    public final kh mo4799a(kf kfVar, kn knVar) throws jw {
        knVar.mo4819a(C6591q.f26541X, "websocket");
        knVar.mo4819a("Connection", kfVar.mo4821b("Connection"));
        knVar.mo4828a("Switching Protocols");
        String b = kfVar.mo4821b("Sec-WebSocket-Key");
        if (b == null) {
            throw new jw("missing Sec-WebSocket-Key");
        }
        knVar.mo4819a("Sec-WebSocket-Accept", m21406a(b));
        return knVar;
    }

    /* renamed from: a */
    private static byte[] m21407a(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    /* renamed from: a */
    public final List<kd> mo4801a(ByteBuffer byteBuffer) throws jx, ju {
        while (true) {
            List<kd> linkedList = new LinkedList();
            if (this.f24526g == null) {
                break;
            }
            try {
                break;
            } catch (C5995a e) {
                this.f24526g.limit();
                r0 = ByteBuffer.allocate(jo.m21389a(e.f24523a));
                if (f24525f || r0.limit() > this.f24526g.limit()) {
                    ByteBuffer allocate;
                    this.f24526g.rewind();
                    allocate.put(this.f24526g);
                    this.f24526g = allocate;
                } else {
                    throw new AssertionError();
                }
            }
        }
        byteBuffer.mark();
        int remaining = byteBuffer.remaining();
        int remaining2 = this.f24526g.remaining();
        if (remaining2 > remaining) {
            this.f24526g.put(byteBuffer.array(), byteBuffer.position(), remaining);
            byteBuffer.position(remaining + byteBuffer.position());
            return Collections.emptyList();
        }
        this.f24526g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
        byteBuffer.position(byteBuffer.position() + remaining2);
        linkedList.add(m21409c((ByteBuffer) this.f24526g.duplicate().position(0)));
        this.f24526g = null;
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(m21409c(byteBuffer));
            } catch (C5995a e2) {
                byteBuffer.reset();
                this.f24526g = ByteBuffer.allocate(jo.m21389a(e2.f24523a));
                this.f24526g.put(byteBuffer);
            }
        }
        return linkedList;
    }

    /* renamed from: c */
    private kd m21409c(ByteBuffer byteBuffer) throws C5995a, ju {
        int i = 10;
        int i2 = 0;
        int remaining = byteBuffer.remaining();
        if (remaining < 2) {
            throw new C5995a(this, 2);
        }
        boolean z;
        byte b = byteBuffer.get();
        if ((b >> 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        byte b2 = (byte) ((b & TransportMediator.KEYCODE_MEDIA_PAUSE) >> 4);
        if (b2 != (byte) 0) {
            throw new jv("bad rsv " + b2);
        }
        C5997a c5997a;
        b2 = byteBuffer.get();
        int i3 = (b2 & -128) != 0 ? 1 : 0;
        b2 = (byte) (b2 & TransportMediator.KEYCODE_MEDIA_PAUSE);
        b = (byte) (b & 15);
        switch (b) {
            case (byte) 0:
                c5997a = C5997a.CONTINUOUS;
                break;
            case (byte) 1:
                c5997a = C5997a.TEXT;
                break;
            case (byte) 2:
                c5997a = C5997a.BINARY;
                break;
            case (byte) 8:
                c5997a = C5997a.CLOSING;
                break;
            case (byte) 9:
                c5997a = C5997a.PING;
                break;
            case (byte) 10:
                c5997a = C5997a.PONG;
                break;
            default:
                throw new jv("unknow optcode " + ((short) b));
        }
        if (z || !(c5997a == C5997a.PING || c5997a == C5997a.PONG || c5997a == C5997a.CLOSING)) {
            int intValue;
            int i4;
            if (b2 >= (byte) 0 && b2 <= (byte) 125) {
                i = 2;
                byte b3 = b2;
            } else if (c5997a == C5997a.PING || c5997a == C5997a.PONG || c5997a == C5997a.CLOSING) {
                throw new jv("more than 125 octets");
            } else if (b2 == (byte) 126) {
                if (remaining < 4) {
                    throw new C5995a(this, 4);
                }
                byte[] bArr = new byte[3];
                bArr[1] = byteBuffer.get();
                bArr[2] = byteBuffer.get();
                intValue = new BigInteger(bArr).intValue();
                i = 4;
            } else if (remaining < 10) {
                throw new C5995a(this, 10);
            } else {
                byte[] bArr2 = new byte[8];
                for (i4 = 0; i4 < 8; i4++) {
                    bArr2[i4] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr2).longValue();
                if (longValue > 2147483647L) {
                    throw new jx("Payloadsize is to big...");
                }
                intValue = (int) longValue;
            }
            if (i3 != 0) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            i4 = (i4 + i) + intValue;
            if (remaining < i4) {
                throw new C5995a(this, i4);
            }
            kd kbVar;
            ByteBuffer allocate = ByteBuffer.allocate(jo.m21389a(intValue));
            if (i3 != 0) {
                byte[] bArr3 = new byte[4];
                byteBuffer.get(bArr3);
                while (i2 < intValue) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr3[i2 % 4]));
                    i2++;
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (c5997a == C5997a.CLOSING) {
                kbVar = new kb();
            } else {
                kbVar = new ke();
                kbVar.mo4810a(z);
                kbVar.mo4808a(c5997a);
            }
            allocate.flip();
            kbVar.mo4809a(allocate);
            return kbVar;
        }
        throw new jv("control frames may no be fragmented");
    }

    /* renamed from: a */
    public final void mo4803a() {
        this.f24526g = null;
    }

    /* renamed from: c */
    public jo mo4805c() {
        return new jp();
    }

    /* renamed from: b */
    public final int mo4804b() {
        return C5993a.f24513c;
    }
}
