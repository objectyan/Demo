package com.indooratlas.android.sdk._internal;

import com.baidu.mobstat.Config;
import com.indooratlas.android.sdk._internal.jj.C5991b;
import com.indooratlas.android.sdk._internal.kd.C5997a;
import cz.msebera.android.httpclient.C6591q;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class jo {
    /* renamed from: a */
    public static int f24518a = 1000;
    /* renamed from: b */
    public static int f24519b = 64;
    /* renamed from: c */
    public static final byte[] f24520c = kp.m21499a("<policy-file-request/>\u0000");
    /* renamed from: d */
    protected int f24521d = 0;
    /* renamed from: e */
    protected C5997a f24522e = null;

    /* renamed from: com.indooratlas.android.sdk._internal.jo$a */
    public enum C5993a {
        ;

        static {
            f24511a = 1;
            f24512b = 2;
            f24513c = 3;
            f24514d = new int[]{f24511a, f24512b, f24513c};
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.jo$b */
    public enum C5994b {
        ;

        static {
            f24515a = 1;
            f24516b = 2;
            f24517c = new int[]{f24515a, f24516b};
        }
    }

    /* renamed from: a */
    public abstract int mo4796a(kf kfVar) throws jw;

    /* renamed from: a */
    public abstract int mo4797a(kf kfVar, km kmVar) throws jw;

    /* renamed from: a */
    public abstract kg mo4798a(kg kgVar) throws jw;

    /* renamed from: a */
    public abstract kh mo4799a(kf kfVar, kn knVar) throws jw;

    /* renamed from: a */
    public abstract ByteBuffer mo4800a(kd kdVar);

    /* renamed from: a */
    public abstract List<kd> mo4801a(ByteBuffer byteBuffer) throws ju;

    /* renamed from: a */
    public abstract List<kd> mo4802a(ByteBuffer byteBuffer, boolean z);

    /* renamed from: a */
    public abstract void mo4803a();

    /* renamed from: b */
    public abstract int mo4804b();

    /* renamed from: c */
    public abstract jo mo4805c();

    /* renamed from: c */
    private static String mo4806c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = (byte) 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == (byte) 13 && b2 == (byte) 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                byteBuffer2 = allocate;
                break;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        byteBuffer2 = null;
        if (byteBuffer2 == null) {
            return null;
        }
        return kp.m21498a(byteBuffer2.array(), byteBuffer2.limit());
    }

    /* renamed from: a */
    public static kh m21390a(ByteBuffer byteBuffer, int i) throws jw, jt {
        String c = mo4806c(byteBuffer);
        if (c == null) {
            throw new jt(byteBuffer.capacity() + 128);
        }
        String[] split = c.split(" ", 3);
        if (split.length != 3) {
            throw new jw();
        }
        kh kjVar;
        if (i == C5991b.f24473a) {
            kjVar = new kj();
            kn knVar = (kn) kjVar;
            knVar.mo4829a(Short.parseShort(split[1]));
            knVar.mo4828a(split[2]);
        } else {
            kjVar = new ki();
            kjVar.mo4826a(split[1]);
        }
        while (true) {
            c = mo4806c(byteBuffer);
            if (c != null && c.length() > 0) {
                String[] split2 = c.split(Config.TRACE_TODAY_VISIT_SPLIT, 2);
                if (split2.length != 2) {
                    throw new jw("not an http header");
                }
                kjVar.mo4819a(split2[0], split2[1].replaceFirst("^ +", ""));
            } else if (c == null) {
                return kjVar;
            } else {
                throw new jt();
            }
        }
        if (c == null) {
            return kjVar;
        }
        throw new jt();
    }

    /* renamed from: a */
    protected static boolean m21391a(kk kkVar) {
        return kkVar.mo4821b(C6591q.f26541X).equalsIgnoreCase("websocket") && kkVar.mo4821b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    /* renamed from: b */
    public kk mo4807b(ByteBuffer byteBuffer) throws jw {
        return m21390a(byteBuffer, this.f24521d);
    }

    /* renamed from: a */
    public static int m21389a(int i) throws jx, ju {
        if (i >= 0) {
            return i;
        }
        throw new ju(1002, "Negative count");
    }

    /* renamed from: b */
    public final void m21404b(int i) {
        this.f24521d = i;
    }

    /* renamed from: b */
    public static List<ByteBuffer> m21392b(kk kkVar) {
        StringBuilder stringBuilder = new StringBuilder(100);
        if (kkVar instanceof kf) {
            stringBuilder.append("GET ");
            stringBuilder.append(((kf) kkVar).mo4825a());
            stringBuilder.append(" HTTP/1.1");
        } else if (kkVar instanceof km) {
            stringBuilder.append("HTTP/1.1 101 " + ((km) kkVar).mo4827a());
        } else {
            throw new RuntimeException("unknow role");
        }
        stringBuilder.append("\r\n");
        Iterator b = kkVar.mo4822b();
        while (b.hasNext()) {
            String str = (String) b.next();
            String b2 = kkVar.mo4821b(str);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(b2);
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        byte[] b3 = kp.m21500b(stringBuilder.toString());
        byte[] c = kkVar.mo4824c();
        ByteBuffer allocate = ByteBuffer.allocate((c == null ? 0 : c.length) + b3.length);
        allocate.put(b3);
        if (c != null) {
            allocate.put(c);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }
}
