package com.baidu.tts.p221k;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* compiled from: Memorizer */
/* renamed from: com.baidu.tts.k.c */
public class C5111c<A extends C4977b<A, R>, R extends C4975a> {
    /* renamed from: a */
    private final ConcurrentMap<A, Future<R>> f21225a = new ConcurrentHashMap();

    /* renamed from: a */
    public R m17338a(A a) throws Exception {
        Future future;
        Future future2;
        Future futureTask;
        C4977b b = m17337b(a);
        if (b != null) {
            future = (Future) this.f21225a.get(b);
        } else {
            future = null;
        }
        if (future != null) {
            LoggerProxy.m17001d("Memorizer", "+ get f=" + future);
            C4975a c4975a = (C4975a) future.get();
            LoggerProxy.m17001d("Memorizer", "- get f=" + future);
            if (!c4975a.mo3801g()) {
                LoggerProxy.m17001d("Memorizer", "arg invalid r=" + c4975a);
                this.f21225a.remove(b);
                future2 = null;
                if (future2 == null) {
                    futureTask = new FutureTask(a);
                    future2 = (Future) this.f21225a.putIfAbsent(a, futureTask);
                    if (future2 == null) {
                        LoggerProxy.m17001d("Memorizer", "+ run f=" + futureTask);
                        futureTask.run();
                        LoggerProxy.m17001d("Memorizer", "- run f=" + futureTask);
                        return (C4975a) futureTask.get();
                    }
                }
                futureTask = future2;
                return (C4975a) futureTask.get();
            }
        }
        future2 = future;
        if (future2 == null) {
            futureTask = new FutureTask(a);
            future2 = (Future) this.f21225a.putIfAbsent(a, futureTask);
            if (future2 == null) {
                LoggerProxy.m17001d("Memorizer", "+ run f=" + futureTask);
                futureTask.run();
                LoggerProxy.m17001d("Memorizer", "- run f=" + futureTask);
                return (C4975a) futureTask.get();
            }
        }
        futureTask = future2;
        try {
            return (C4975a) futureTask.get();
        } catch (ExecutionException e) {
            this.f21225a.remove(a, futureTask);
            throw ((Exception) e.getCause());
        } catch (Exception e2) {
            this.f21225a.remove(a, futureTask);
            throw e2;
        }
    }

    /* renamed from: b */
    private A m17337b(A a) {
        for (C4977b c4977b : this.f21225a.keySet()) {
            if (a.compareTo(c4977b) == 0) {
                return c4977b;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m17339a() {
        if (this.f21225a != null) {
            this.f21225a.clear();
        }
    }
}
