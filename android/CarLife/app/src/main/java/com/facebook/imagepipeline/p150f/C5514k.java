package com.facebook.imagepipeline.p150f;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* compiled from: PriorityThreadFactory */
/* renamed from: com.facebook.imagepipeline.f.k */
public class C5514k implements ThreadFactory {
    /* renamed from: a */
    private final int f22387a;

    public C5514k(int threadPriority) {
        this.f22387a = threadPriority;
    }

    public Thread newThread(final Runnable runnable) {
        return new Thread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C5514k f22386b;

            public void run() {
                try {
                    Process.setThreadPriority(this.f22386b.f22387a);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        });
    }
}
