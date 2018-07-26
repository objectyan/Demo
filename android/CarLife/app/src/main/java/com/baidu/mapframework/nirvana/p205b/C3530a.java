package com.baidu.mapframework.nirvana.p205b;

import com.baidu.mapframework.nirvana.C3560n;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.HashMap;
import java.util.concurrent.Executors;

/* compiled from: NirvanaMonitor */
/* renamed from: com.baidu.mapframework.nirvana.b.a */
public class C3530a {
    /* renamed from: a */
    public static final String f19118a = C3530a.class.getSimpleName();
    /* renamed from: b */
    private boolean f19119b;
    /* renamed from: c */
    private HashMap<Integer, C3532b> f19120c = new HashMap();
    /* renamed from: d */
    private HashMap<Integer, C3532b> f19121d = new HashMap();

    /* compiled from: NirvanaMonitor */
    /* renamed from: com.baidu.mapframework.nirvana.b.a$1 */
    class C35291 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3530a f19117a;

        C35291(C3530a this$0) {
            this.f19117a = this$0;
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            if (!(this.f19117a.f19120c.isEmpty() && this.f19117a.f19121d.isEmpty())) {
                this.f19117a.m15140d();
            }
            this.f19117a.m15138c();
        }
    }

    public C3530a(boolean enable) {
        this.f19119b = enable;
    }

    /* renamed from: a */
    public boolean m15145a() {
        return this.f19119b;
    }

    /* renamed from: a */
    public synchronized void m15144a(boolean enable) {
        if (this.f19119b != enable) {
            this.f19119b = enable;
            this.f19120c.clear();
            this.f19121d.clear();
        }
    }

    /* renamed from: a */
    public synchronized void m15142a(C3533c type, Object task, Module module, ScheduleConfig config) {
        if (this.f19119b) {
            this.f19120c.put(Integer.valueOf(task.hashCode()), new C3532b(type, task, module, config));
        }
    }

    /* renamed from: a */
    public synchronized void m15143a(Object task) {
        if (this.f19119b) {
            C3532b record = (C3532b) this.f19120c.get(Integer.valueOf(task.hashCode()));
            if (record != null) {
                this.f19120c.remove(Integer.valueOf(task.hashCode()));
                record.m15148a();
                this.f19121d.put(Integer.valueOf(task.hashCode()), record);
            }
        }
    }

    /* renamed from: b */
    public synchronized void m15146b(Object task) {
        if (this.f19119b) {
            C3532b record = (C3532b) this.f19121d.get(Integer.valueOf(task.hashCode()));
            if (record != null) {
                this.f19121d.remove(Integer.valueOf(task.hashCode()));
                record.m15149b();
                m15135a(record);
            }
        }
    }

    /* renamed from: a */
    private void m15135a(C3532b record) {
        if (record.m15155h() != C3533c.LOOPER || record.m15150c() <= 30) {
            C3560n.m15209a(f19118a, "record: " + record);
            return;
        }
        C3560n.m15215c(f19118a, "LOOPER record: " + record);
        C3560n.m15215c(f19118a, "LOOPER record module: " + record.m15157j());
        C3560n.m15215c(f19118a, "LOOPER record cost: " + record.m15150c());
        C3560n.m15210a(f19118a, "LOOPER record trace: ", record.m15156i());
    }

    /* renamed from: b */
    private String m15136b() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n").append("----------- nirvana status begin -----------").append("\n");
        builder.append("waiting task:").append("\n");
        for (C3532b record : this.f19120c.values()) {
            builder.append(record.toString()).append("\n");
        }
        builder.append("running task:").append("\n");
        for (C3532b record2 : this.f19121d.values()) {
            builder.append(record2.toString()).append("\n");
        }
        builder.append("----------- nirvana status end -----------").append("\n").append("\n");
        return builder.toString();
    }

    /* renamed from: c */
    private synchronized void m15138c() {
        Executors.newSingleThreadExecutor().execute(new C35291(this));
    }

    /* renamed from: d */
    private void m15140d() {
        C3560n.m15209a(f19118a, "-----------                      -----------");
        C3560n.m15209a(f19118a, "----------- nirvana status begin -----------");
        C3560n.m15209a(f19118a, "waiting task:");
        for (C3532b record : this.f19120c.values()) {
            m15135a(record);
        }
        C3560n.m15209a(f19118a, "running task:");
        for (C3532b record2 : this.f19121d.values()) {
            m15135a(record2);
        }
        C3560n.m15209a(f19118a, "----------- nirvana status end -----------");
        C3560n.m15209a(f19118a, "-----------                    -----------");
    }
}
