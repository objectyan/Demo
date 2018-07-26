package com.tencent.wxop.stat.p291b;

import android.util.Log;
import com.baidu.mobstat.Config;
import com.tencent.wxop.stat.C6156f;
import com.tencent.wxop.stat.au;

/* renamed from: com.tencent.wxop.stat.b.b */
public final class C6133b {
    /* renamed from: a */
    private String f24887a = "default";
    /* renamed from: b */
    private boolean f24888b = true;
    /* renamed from: c */
    private int f24889c = 2;

    public C6133b(String str) {
        this.f24887a = str;
    }

    /* renamed from: c */
    private String m21817c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + Config.TRACE_TODAY_VISIT_SPLIT + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void m21818a(int i) {
        this.f24889c = i;
    }

    /* renamed from: a */
    public final void m21819a(Object obj) {
        if (this.f24889c <= 4) {
            String c = m21817c();
            c = c == null ? obj.toString() : c + " - " + obj;
            Log.i(this.f24887a, c);
            au A = C6156f.m21966A();
            if (A != null) {
                A.m21805a(c);
            }
        }
    }

    /* renamed from: a */
    public final void m21820a(String str) {
        this.f24887a = str;
    }

    /* renamed from: a */
    public final void m21821a(Throwable th) {
        if (this.f24889c <= 6) {
            Log.e(this.f24887a, "", th);
            au A = C6156f.m21966A();
            if (A != null) {
                A.m21808d(th);
            }
        }
    }

    /* renamed from: a */
    public final void m21822a(boolean z) {
        this.f24888b = z;
    }

    /* renamed from: a */
    public final boolean m21823a() {
        return this.f24888b;
    }

    /* renamed from: b */
    public final int m21824b() {
        return this.f24889c;
    }

    /* renamed from: b */
    public final void m21825b(Object obj) {
        if (m21823a()) {
            m21819a(obj);
        }
    }

    /* renamed from: b */
    public final void m21826b(Throwable th) {
        if (m21823a()) {
            m21821a(th);
        }
    }

    /* renamed from: c */
    public final void m21827c(Object obj) {
        if (this.f24889c <= 2) {
            String c = m21817c();
            c = c == null ? obj.toString() : c + " - " + obj;
            Log.v(this.f24887a, c);
            au A = C6156f.m21966A();
            if (A != null) {
                A.m21806b(c);
            }
        }
    }

    /* renamed from: d */
    public final void m21828d(Object obj) {
        if (m21823a()) {
            m21827c(obj);
        }
    }

    /* renamed from: e */
    public final void m21829e(Object obj) {
        if (this.f24889c <= 5) {
            String c = m21817c();
            c = c == null ? obj.toString() : c + " - " + obj;
            Log.w(this.f24887a, c);
            au A = C6156f.m21966A();
            if (A != null) {
                A.m21807c(c);
            }
        }
    }

    /* renamed from: f */
    public final void m21830f(Object obj) {
        if (m21823a()) {
            m21829e(obj);
        }
    }

    /* renamed from: g */
    public final void m21831g(Object obj) {
        if (this.f24889c <= 6) {
            String c = m21817c();
            c = c == null ? obj.toString() : c + " - " + obj;
            Log.e(this.f24887a, c);
            au A = C6156f.m21966A();
            if (A != null) {
                A.m21808d(c);
            }
        }
    }

    /* renamed from: h */
    public final void m21832h(Object obj) {
        if (m21823a()) {
            m21831g(obj);
        }
    }

    /* renamed from: i */
    public final void m21833i(Object obj) {
        if (this.f24889c <= 3) {
            String c = m21817c();
            c = c == null ? obj.toString() : c + " - " + obj;
            Log.d(this.f24887a, c);
            au A = C6156f.m21966A();
            if (A != null) {
                A.m21809e(c);
            }
        }
    }

    /* renamed from: j */
    public final void m21834j(Object obj) {
        if (m21823a()) {
            m21833i(obj);
        }
    }
}
