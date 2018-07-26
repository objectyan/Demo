package com.facebook.common.p257e;

import android.util.Log;
import com.baidu.mobstat.Config;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: FLogDefaultLoggingDelegate */
/* renamed from: com.facebook.common.e.b */
public class C5322b implements C5321c {
    /* renamed from: a */
    public static final C5322b f21900a = new C5322b();
    /* renamed from: b */
    private String f21901b = "unknown";
    /* renamed from: c */
    private int f21902c = 5;

    /* renamed from: a */
    public static C5322b m18212a() {
        return f21900a;
    }

    private C5322b() {
    }

    /* renamed from: a */
    public void m18220a(String tag) {
        this.f21901b = tag;
    }

    /* renamed from: a */
    public void mo3999a(int level) {
        this.f21902c = level;
    }

    /* renamed from: b */
    public int mo4003b() {
        return this.f21902c;
    }

    /* renamed from: b */
    public boolean mo4006b(int level) {
        return this.f21902c <= level;
    }

    /* renamed from: a */
    public void mo4001a(String tag, String msg) {
        m18217b(2, tag, msg);
    }

    /* renamed from: a */
    public void mo4002a(String tag, String msg, Throwable tr) {
        m18215a(2, tag, msg, tr);
    }

    /* renamed from: b */
    public void mo4004b(String tag, String msg) {
        m18217b(3, tag, msg);
    }

    /* renamed from: b */
    public void mo4005b(String tag, String msg, Throwable tr) {
        m18215a(3, tag, msg, tr);
    }

    /* renamed from: c */
    public void mo4007c(String tag, String msg) {
        m18217b(4, tag, msg);
    }

    /* renamed from: c */
    public void mo4008c(String tag, String msg, Throwable tr) {
        m18215a(4, tag, msg, tr);
    }

    /* renamed from: d */
    public void mo4009d(String tag, String msg) {
        m18217b(5, tag, msg);
    }

    /* renamed from: d */
    public void mo4010d(String tag, String msg, Throwable tr) {
        m18215a(5, tag, msg, tr);
    }

    /* renamed from: e */
    public void mo4011e(String tag, String msg) {
        m18217b(6, tag, msg);
    }

    /* renamed from: e */
    public void mo4012e(String tag, String msg, Throwable tr) {
        m18215a(6, tag, msg, tr);
    }

    /* renamed from: f */
    public void mo4013f(String tag, String msg) {
        m18217b(6, tag, msg);
    }

    /* renamed from: f */
    public void mo4014f(String tag, String msg, Throwable tr) {
        m18215a(6, tag, msg, tr);
    }

    /* renamed from: a */
    public void mo4000a(int priority, String tag, String msg) {
        m18217b(priority, tag, msg);
    }

    /* renamed from: b */
    private void m18217b(int priority, String tag, String msg) {
        Log.println(priority, m18216b(tag), msg);
    }

    /* renamed from: a */
    private void m18215a(int priority, String tag, String msg, Throwable tr) {
        Log.println(priority, m18216b(tag), C5322b.m18213a(msg, tr));
    }

    /* renamed from: b */
    private String m18216b(String tag) {
        if (this.f21901b != null) {
            return this.f21901b + Config.TRACE_TODAY_VISIT_SPLIT + tag;
        }
        return tag;
    }

    /* renamed from: a */
    private static String m18213a(String msg, Throwable tr) {
        return msg + '\n' + C5322b.m18214a(tr);
    }

    /* renamed from: a */
    private static String m18214a(Throwable tr) {
        if (tr == null) {
            return "";
        }
        StringWriter sw = new StringWriter();
        tr.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
