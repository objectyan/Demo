package com.baidu.platform.comapi.util;

import android.os.Process;
import com.baidu.platform.basic.C4749b;
import java.util.concurrent.ThreadFactory;

/* compiled from: NamedThreadFactory */
/* renamed from: com.baidu.platform.comapi.util.h */
public class C4824h implements ThreadFactory {
    /* renamed from: a */
    private final boolean f19969a;
    /* renamed from: b */
    private String f19970b;

    public C4824h(String name) {
        this(name, false);
    }

    public C4824h(String name, boolean lowestThreadProperty) {
        this.f19970b = name;
        this.f19969a = lowestThreadProperty;
    }

    public Thread newThread(Runnable r) {
        return new C4749b(this, r, this.f19970b) {
            /* renamed from: b */
            final /* synthetic */ C4824h f19968b;

            public void run() {
                if (this.f19968b.f19969a) {
                    Process.setThreadPriority(19);
                }
                super.run();
            }
        };
    }
}
