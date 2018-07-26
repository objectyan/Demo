package com.baidu.mapframework.nirvana.p205b;

import android.os.Looper;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.Date;

/* compiled from: Record */
/* renamed from: com.baidu.mapframework.nirvana.b.b */
class C3532b {
    /* renamed from: a */
    private C3533c f19126a;
    /* renamed from: b */
    private Object f19127b;
    /* renamed from: c */
    private Module f19128c;
    /* renamed from: d */
    private ScheduleConfig f19129d;
    /* renamed from: e */
    private long f19130e = System.currentTimeMillis();
    /* renamed from: f */
    private long f19131f;
    /* renamed from: g */
    private long f19132g;
    /* renamed from: h */
    private String f19133h;
    /* renamed from: i */
    private boolean f19134i;
    /* renamed from: j */
    private Throwable f19135j = new Throwable();

    /* compiled from: Record */
    /* renamed from: com.baidu.mapframework.nirvana.b.b$a */
    enum C3531a {
        WAITING,
        RUNNING,
        FINISH
    }

    C3532b(C3533c type, Object task, Module module, ScheduleConfig config) {
        this.f19126a = type;
        this.f19127b = task;
        this.f19128c = module;
        this.f19129d = config;
    }

    /* renamed from: a */
    void m15148a() {
        this.f19131f = System.currentTimeMillis();
        this.f19133h = Thread.currentThread().getName();
        this.f19134i = m15147k();
    }

    /* renamed from: b */
    void m15149b() {
        this.f19132g = System.currentTimeMillis();
    }

    /* renamed from: c */
    long m15150c() {
        return this.f19132g - this.f19131f;
    }

    /* renamed from: d */
    long m15151d() {
        return this.f19131f - this.f19130e;
    }

    /* renamed from: e */
    String m15152e() {
        return this.f19133h;
    }

    /* renamed from: f */
    Date m15153f() {
        return new Date(this.f19131f);
    }

    /* renamed from: g */
    C3531a m15154g() {
        if (this.f19131f == 0) {
            return C3531a.WAITING;
        }
        if (this.f19132g == 0) {
            return C3531a.RUNNING;
        }
        return C3531a.FINISH;
    }

    /* renamed from: k */
    private boolean m15147k() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: h */
    public C3533c m15155h() {
        return this.f19126a;
    }

    /* renamed from: i */
    public Throwable m15156i() {
        return this.f19135j;
    }

    /* renamed from: j */
    public Module m15157j() {
        return this.f19128c;
    }

    public String toString() {
        return "Record{, module=" + this.f19128c + ", type=" + this.f19126a + ", task=" + this.f19127b.toString() + ", state=" + m15154g() + ", cost=" + m15150c() + ", waitting=" + m15151d() + ", threadInfo=" + this.f19133h + ", isUIThread=" + this.f19134i + ", createTime=" + new Date(this.f19130e) + ", startTime=" + new Date(this.f19131f) + ", endTime=" + new Date(this.f19132g) + ", config=" + this.f19129d + '}';
    }
}
