package com.baidu.mapframework.common.p202a;

import android.os.Message;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: AsyncLogger */
/* renamed from: com.baidu.mapframework.common.a.b */
class C3467b implements C3466l {
    /* renamed from: a */
    private final C3471f f18739a;
    /* renamed from: b */
    private final String f18740b;
    /* renamed from: c */
    private final DateFormat f18741c;
    /* renamed from: d */
    private C3469d f18742d;
    /* renamed from: e */
    private C3468c f18743e;
    /* renamed from: f */
    private boolean f18744f = false;

    public C3467b(C3471f defaultLevel, String tag) {
        this.f18739a = defaultLevel;
        this.f18740b = tag;
        this.f18741c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault());
        mo2525a();
    }

    /* renamed from: a */
    public void mo2525a() {
        if (this.f18742d == null) {
            this.f18742d = new C3469d("AsyncLogger", 5);
            this.f18742d.start();
        }
        if (this.f18743e == null) {
            this.f18743e = new C3468c(this.f18742d.getLooper());
        }
        this.f18744f = false;
    }

    /* renamed from: b */
    public void mo2529b() {
        this.f18744f = true;
        if (this.f18742d != null) {
            this.f18742d.quit();
            this.f18742d = null;
        }
        if (this.f18743e != null) {
            this.f18743e.m14906a();
            this.f18743e = null;
        }
    }

    /* renamed from: c */
    public C3471f mo2532c() {
        return this.f18739a;
    }

    /* renamed from: d */
    public String mo2535d() {
        return this.f18740b;
    }

    /* renamed from: a */
    public boolean mo2528a(C3471f level) {
        return level.compareTo(this.f18739a) >= 0;
    }

    /* renamed from: e */
    public boolean mo2540e() {
        return mo2528a(C3471f.DEBUG);
    }

    /* renamed from: f */
    public boolean mo2541f() {
        return mo2528a(C3471f.INFO);
    }

    /* renamed from: g */
    public boolean mo2542g() {
        return mo2528a(C3471f.WARN);
    }

    /* renamed from: h */
    public boolean mo2543h() {
        return mo2528a(C3471f.ERROR);
    }

    /* renamed from: i */
    public boolean mo2544i() {
        return mo2528a(C3471f.FATAL);
    }

    /* renamed from: a */
    public void mo2526a(String msg) {
        m14882a(C3471f.DEBUG, msg, new Object[0]);
    }

    /* renamed from: a */
    public void mo2527a(String format, Object... params) {
        m14882a(C3471f.DEBUG, format, params);
    }

    /* renamed from: b */
    public void mo2530b(String msg) {
        m14882a(C3471f.INFO, msg, new Object[0]);
    }

    /* renamed from: b */
    public void mo2531b(String format, Object... params) {
        m14882a(C3471f.INFO, format, params);
    }

    /* renamed from: c */
    public void mo2533c(String msg) {
        m14882a(C3471f.WARN, msg, new Object[0]);
    }

    /* renamed from: c */
    public void mo2534c(String format, Object... params) {
        m14882a(C3471f.WARN, format, params);
    }

    /* renamed from: d */
    public void mo2536d(String msg) {
        m14882a(C3471f.ERROR, msg, new Object[0]);
    }

    /* renamed from: d */
    public void mo2537d(String format, Object... params) {
        m14882a(C3471f.ERROR, format, params);
    }

    /* renamed from: e */
    public void mo2538e(String msg) {
        m14882a(C3471f.FATAL, msg, new Object[0]);
    }

    /* renamed from: e */
    public void mo2539e(String format, Object... params) {
        m14882a(C3471f.FATAL, format, params);
    }

    /* renamed from: a */
    private void m14882a(C3471f level, String format, Object... params) {
        if (mo2528a(level) && !this.f18744f) {
            m14884f(format, params);
        }
    }

    /* renamed from: f */
    private void m14884f(String format, Object... params) {
        Message msg = this.f18743e.obtainMessage();
        C3474i event = new C3474i();
        event.f18759b = this.f18739a;
        event.f18760c = this.f18740b;
        event.f18763f = Thread.currentThread().getName();
        event.f18761d = System.currentTimeMillis();
        event.f18758a = this.f18741c;
        try {
            event.f18762e = String.format(format, params);
        } catch (Exception e) {
            event.f18762e = format;
        }
        msg.obj = event;
        this.f18743e.sendMessage(msg);
    }

    /* renamed from: a */
    private boolean m14883a(Date date) {
        return System.currentTimeMillis() - date.getTime() <= 0;
    }
}
