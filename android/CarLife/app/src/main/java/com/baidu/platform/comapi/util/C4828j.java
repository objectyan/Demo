package com.baidu.platform.comapi.util;

import android.os.Process;
import com.baidu.platform.basic.C4749b;
import java.util.concurrent.ThreadFactory;

/* compiled from: PriorityThreadFactory */
/* renamed from: com.baidu.platform.comapi.util.j */
public class C4828j implements ThreadFactory {
    /* renamed from: a */
    private String f19976a;
    /* renamed from: b */
    private int f19977b;

    public C4828j(String name) {
        this(name, 0);
    }

    public C4828j(String name, int priority) {
        this.f19976a = name;
        this.f19977b = priority;
    }

    public Thread newThread(Runnable r) {
        return new C4749b(this, r, this.f19976a) {
            /* renamed from: b */
            final /* synthetic */ C4828j f19975b;

            public void run() {
                Process.setThreadPriority(this.f19975b.f19977b);
                super.run();
            }
        };
    }
}
