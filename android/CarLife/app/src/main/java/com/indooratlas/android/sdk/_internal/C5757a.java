package com.indooratlas.android.sdk._internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;

/* renamed from: com.indooratlas.android.sdk._internal.a */
public final class C5757a {
    /* renamed from: a */
    final byte[] f22909a;
    /* renamed from: b */
    int f22910b;
    /* renamed from: c */
    private int f22911c;
    /* renamed from: d */
    private int f22912d;
    /* renamed from: e */
    private int f22913e;
    /* renamed from: f */
    private int f22914f;
    /* renamed from: g */
    private int f22915g = Integer.MAX_VALUE;
    /* renamed from: h */
    private int f22916h;
    /* renamed from: i */
    private int f22917i = 64;
    /* renamed from: j */
    private int f22918j = 67108864;

    /* renamed from: a */
    public final int m19764a() throws IOException {
        int i;
        if (this.f22913e == this.f22911c) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            this.f22914f = 0;
            return 0;
        }
        this.f22914f = m19775f();
        if (this.f22914f != 0) {
            return this.f22914f;
        }
        throw C5987j.d();
    }

    /* renamed from: a */
    public final void m19765a(int i) throws C5987j {
        if (this.f22914f != i) {
            throw C5987j.e();
        }
    }

    /* renamed from: b */
    public final boolean m19768b(int i) throws IOException {
        switch (C6007s.a(i)) {
            case 0:
                m19775f();
                return true;
            case 1:
                m19778i();
                return true;
            case 2:
                m19761g(m19775f());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                m19777h();
                return true;
            default:
                throw C5987j.f();
        }
        int a;
        do {
            a = m19764a();
            if (a != 0) {
            }
            m19765a(C6007s.a(C6007s.b(i), 4));
            return true;
        } while (m19768b(a));
        m19765a(C6007s.a(C6007s.b(i), 4));
        return true;
    }

    /* renamed from: b */
    public final boolean m19767b() throws IOException {
        return m19775f() != 0;
    }

    /* renamed from: c */
    public final String m19770c() throws IOException {
        int f = m19775f();
        if (f > this.f22911c - this.f22913e || f <= 0) {
            return new String(m19760f(f), C5978i.f24327a);
        }
        String str = new String(this.f22909a, this.f22913e, f, C5978i.f24327a);
        this.f22913e = f + this.f22913e;
        return str;
    }

    /* renamed from: a */
    public final void m19766a(C6001m c6001m) throws IOException {
        int f = m19775f();
        if (this.f22916h >= this.f22917i) {
            throw C5987j.g();
        }
        f = m19769c(f);
        this.f22916h++;
        c6001m.a(this);
        m19765a(0);
        this.f22916h--;
        m19771d(f);
    }

    /* renamed from: d */
    public final byte[] m19772d() throws IOException {
        int f = m19775f();
        if (f <= this.f22911c - this.f22913e && f > 0) {
            Object obj = new byte[f];
            System.arraycopy(this.f22909a, this.f22913e, obj, 0, f);
            this.f22913e = f + this.f22913e;
            return obj;
        } else if (f == 0) {
            return C6007s.f24583h;
        } else {
            return m19760f(f);
        }
    }

    /* renamed from: e */
    public final int m19773e() throws IOException {
        int f = m19775f();
        return (-(f & 1)) ^ (f >>> 1);
    }

    /* renamed from: f */
    public final int m19775f() throws IOException {
        byte n = m19763n();
        if (n >= (byte) 0) {
            return n;
        }
        int i = n & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte n2 = m19763n();
        if (n2 >= (byte) 0) {
            return i | (n2 << 7);
        }
        i |= (n2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        n2 = m19763n();
        if (n2 >= (byte) 0) {
            return i | (n2 << 14);
        }
        i |= (n2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        n2 = m19763n();
        if (n2 >= (byte) 0) {
            return i | (n2 << 21);
        }
        i |= (n2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        n2 = m19763n();
        i |= n2 << 28;
        if (n2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m19763n() >= (byte) 0) {
                return i;
            }
        }
        throw C5987j.c();
    }

    /* renamed from: g */
    public final long m19776g() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte n = m19763n();
            j |= ((long) (n & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((n & 128) == 0) {
                return j;
            }
        }
        throw C5987j.c();
    }

    /* renamed from: h */
    public final int m19777h() throws IOException {
        return (((m19763n() & 255) | ((m19763n() & 255) << 8)) | ((m19763n() & 255) << 16)) | ((m19763n() & 255) << 24);
    }

    /* renamed from: i */
    public final long m19778i() throws IOException {
        byte n = m19763n();
        byte n2 = m19763n();
        return ((((((((((long) n2) & 255) << 8) | (((long) n) & 255)) | ((((long) m19763n()) & 255) << 16)) | ((((long) m19763n()) & 255) << 24)) | ((((long) m19763n()) & 255) << 32)) | ((((long) m19763n()) & 255) << 40)) | ((((long) m19763n()) & 255) << 48)) | ((((long) m19763n()) & 255) << 56);
    }

    C5757a(byte[] bArr, int i) {
        this.f22909a = bArr;
        this.f22910b = 0;
        this.f22911c = i + 0;
        this.f22913e = 0;
    }

    /* renamed from: c */
    public final int m19769c(int i) throws C5987j {
        if (i < 0) {
            throw C5987j.b();
        }
        int i2 = this.f22913e + i;
        int i3 = this.f22915g;
        if (i2 > i3) {
            throw C5987j.a();
        }
        this.f22915g = i2;
        m19762m();
        return i3;
    }

    /* renamed from: m */
    private void m19762m() {
        this.f22911c += this.f22912d;
        int i = this.f22911c;
        if (i > this.f22915g) {
            this.f22912d = i - this.f22915g;
            this.f22911c -= this.f22912d;
            return;
        }
        this.f22912d = 0;
    }

    /* renamed from: d */
    public final void m19771d(int i) {
        this.f22915g = i;
        m19762m();
    }

    /* renamed from: j */
    public final int m19779j() {
        if (this.f22915g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f22915g - this.f22913e;
    }

    /* renamed from: k */
    public final int m19780k() {
        return this.f22913e - this.f22910b;
    }

    /* renamed from: e */
    public final void m19774e(int i) {
        if (i > this.f22913e - this.f22910b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f22913e - this.f22910b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f22913e = this.f22910b + i;
        }
    }

    /* renamed from: n */
    private byte m19763n() throws IOException {
        if (this.f22913e == this.f22911c) {
            throw C5987j.a();
        }
        byte[] bArr = this.f22909a;
        int i = this.f22913e;
        this.f22913e = i + 1;
        return bArr[i];
    }

    /* renamed from: f */
    private byte[] m19760f(int i) throws IOException {
        if (i < 0) {
            throw C5987j.b();
        } else if (this.f22913e + i > this.f22915g) {
            m19761g(this.f22915g - this.f22913e);
            throw C5987j.a();
        } else if (i <= this.f22911c - this.f22913e) {
            Object obj = new byte[i];
            System.arraycopy(this.f22909a, this.f22913e, obj, 0, i);
            this.f22913e += i;
            return obj;
        } else {
            throw C5987j.a();
        }
    }

    /* renamed from: g */
    private void m19761g(int i) throws IOException {
        if (i < 0) {
            throw C5987j.b();
        } else if (this.f22913e + i > this.f22915g) {
            m19761g(this.f22915g - this.f22913e);
            throw C5987j.a();
        } else if (i <= this.f22911c - this.f22913e) {
            this.f22913e += i;
        } else {
            throw C5987j.a();
        }
    }

    /* renamed from: l */
    final Object m19781l() throws IOException {
        return m19770c();
    }
}
