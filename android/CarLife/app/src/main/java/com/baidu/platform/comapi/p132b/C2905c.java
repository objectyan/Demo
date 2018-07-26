package com.baidu.platform.comapi.p132b;

import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comjni.base.logstatistics.NALogStatistics;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: LogStatistics */
/* renamed from: com.baidu.platform.comapi.b.c */
public class C2905c {
    /* renamed from: a */
    private NALogStatistics f12691a;
    /* renamed from: b */
    private ArrayList<C4758b> f12692b;

    private C2905c() {
        this.f12691a = null;
        this.f12692b = new ArrayList();
        m10958d();
    }

    /* renamed from: a */
    public static C2905c m10957a() {
        return c$a.a();
    }

    /* renamed from: d */
    private boolean m10958d() {
        if (this.f12691a == null) {
            this.f12691a = new NALogStatistics();
        }
        return true;
    }

    /* renamed from: b */
    public void m10962b() {
        if (this.f12691a != null) {
            this.f12691a.dispose();
            this.f12691a = null;
        }
    }

    /* renamed from: a */
    public boolean m10960a(int type, int level, String strAction, String actionParam) {
        if (this.f12691a == null) {
            return false;
        }
        return this.f12691a.addLog(type, level, SysOSAPIv2.getInstance().getNetType(), strAction, actionParam);
    }

    /* renamed from: c */
    public boolean m10964c() {
        if (this.f12691a != null) {
            return this.f12691a.saveLog();
        }
        return false;
    }

    /* renamed from: a */
    public boolean m10961a(C4757a logData) {
        if (!(this.f12692b == null || this.f12692b.isEmpty())) {
            Iterator it = this.f12692b.iterator();
            while (it.hasNext()) {
                ((C4758b) it.next()).a(logData);
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m10959a(C4758b printer) {
        if (this.f12692b != null) {
            synchronized (this.f12692b) {
                this.f12692b.add(printer);
            }
        }
    }

    /* renamed from: b */
    public void m10963b(C4758b printer) {
        if (this.f12692b != null) {
            synchronized (this.f12692b) {
                this.f12692b.remove(printer);
            }
        }
    }
}
