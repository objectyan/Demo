package com.baidu.location.p191d;

import com.baidu.location.p187a.C3181a;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3376f;
import java.util.Locale;

/* renamed from: com.baidu.location.d.m */
public class C3320m {
    /* renamed from: a */
    private long f17998a = 0;
    /* renamed from: b */
    private long f17999b = 0;
    /* renamed from: c */
    private long f18000c = 0;
    /* renamed from: d */
    private long f18001d = 0;
    /* renamed from: e */
    private int f18002e = 0;
    /* renamed from: f */
    private long f18003f = 0;
    /* renamed from: g */
    private long f18004g = 0;
    /* renamed from: h */
    private String f18005h = null;
    /* renamed from: i */
    private String f18006i = null;
    /* renamed from: j */
    private String f18007j = null;

    /* renamed from: a */
    public void m13962a() {
        this.f17998a = 0;
        this.f17999b = 0;
        this.f18000c = 0;
        this.f18001d = 0;
        this.f18002e = 0;
        this.f18003f = 0;
        this.f18004g = 0;
        this.f18005h = null;
        this.f18006i = null;
        this.f18007j = null;
    }

    /* renamed from: a */
    public void m13963a(long j) {
        this.f17998a = j;
    }

    /* renamed from: a */
    public void m13964a(String str) {
        this.f18006i = str;
    }

    /* renamed from: a */
    public void m13965a(boolean z) {
        if (z) {
            this.f18002e = 1;
        } else {
            this.f18002e = 0;
        }
    }

    /* renamed from: b */
    public long m13966b() {
        return this.f18004g;
    }

    /* renamed from: b */
    public void m13967b(long j) {
        this.f17999b = j;
    }

    /* renamed from: b */
    public void m13968b(String str) {
        if (this.f18007j == null) {
            this.f18007j = str;
            return;
        }
        this.f18007j = String.format("%s%s", new Object[]{this.f18007j, str});
    }

    /* renamed from: c */
    public String m13969c() {
        StringBuffer stringBuffer = new StringBuffer();
        C3376f.m14355a();
        if (C3376f.m14363j()) {
            this.f18005h = "&cn=32";
        } else {
            this.f18005h = String.format(Locale.CHINA, "&cn=%d", new Object[]{Integer.valueOf(C3364b.m14262a().m14279e())});
        }
        stringBuffer.append(this.f18005h);
        stringBuffer.append(String.format(Locale.CHINA, "&fir=%d&tim=%d&dsc=%d&det=%d&ded=%d&typ=%s", new Object[]{Integer.valueOf(this.f18002e), Long.valueOf(this.f17998a), Long.valueOf(this.f17999b - this.f17998a), Long.valueOf(this.f18000c - this.f17999b), Long.valueOf(this.f18001d - this.f18000c), this.f18006i}));
        if (this.f18007j != null) {
            stringBuffer.append(this.f18007j);
        }
        stringBuffer.append(C3381b.m14398a().m14399a(false));
        stringBuffer.append(C3181a.m13265a().m13283f());
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public void m13970c(long j) {
        this.f18000c = j;
    }

    /* renamed from: d */
    public String m13971d() {
        StringBuffer stringBuffer = new StringBuffer();
        C3376f.m14355a();
        if (C3376f.m14363j()) {
            this.f18005h = "&cn=32";
        } else {
            this.f18005h = String.format(Locale.CHINA, "&cn=%d", new Object[]{Integer.valueOf(C3364b.m14262a().m14279e())});
        }
        stringBuffer.append(this.f18005h);
        long j = this.f18004g - this.f18003f;
        if (j < 0 || j > 600000) {
            return null;
        }
        stringBuffer.append(String.format(Locale.CHINA, "&dgps=%d", new Object[]{Long.valueOf(this.f18004g - this.f18003f)}));
        if (this.f18007j != null) {
            stringBuffer.append(this.f18007j);
        }
        stringBuffer.append(C3381b.m14398a().m14399a(false));
        stringBuffer.append(C3181a.m13265a().m13283f());
        return stringBuffer.toString();
    }

    /* renamed from: d */
    public void m13972d(long j) {
        this.f18001d = j;
    }

    /* renamed from: e */
    public void m13973e(long j) {
        this.f18003f = j;
    }

    /* renamed from: f */
    public void m13974f(long j) {
        this.f18004g = j;
    }
}
