package com.facebook.common.p256c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: DefaultSerialExecutorService */
/* renamed from: com.facebook.common.c.c */
public class C5308c extends C5306b implements C5307g {
    public C5308c(Executor executor) {
        super("SerialExecutor", 1, executor, new LinkedBlockingQueue());
    }

    public synchronized void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
