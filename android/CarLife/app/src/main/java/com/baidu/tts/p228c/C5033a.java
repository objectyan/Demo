package com.baidu.tts.p228c;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p234g.p235a.C5102a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: LimitQueueThreadPoolExecutor */
/* renamed from: com.baidu.tts.c.a */
public class C5033a extends ThreadPoolExecutor {

    /* compiled from: LimitQueueThreadPoolExecutor */
    /* renamed from: com.baidu.tts.c.a$a */
    public static class C5032a implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            LoggerProxy.m17001d("LimitQueueThreadPoolExecutor", "rejectedExecution");
            if (!e.isShutdown()) {
                try {
                    e.getQueue().put(r);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public C5033a(int i, String str) {
        this(i, str, new C5032a());
    }

    public C5033a(int i, String str, RejectedExecutionHandler rejectedExecutionHandler) {
        this(i, new C5102a(str), rejectedExecutionHandler);
    }

    public C5033a(int i, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        this(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(i), threadFactory, rejectedExecutionHandler);
    }

    public C5033a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }
}
