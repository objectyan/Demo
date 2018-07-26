package com.baidu.tts.client.model;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p233f.C5094l;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BasicHandler<T> {
    /* renamed from: a */
    private FutureTask<T> f20842a;

    public BasicHandler(FutureTask<T> futureTask) {
        this.f20842a = futureTask;
    }

    public void start() {
        new Thread(this.f20842a).start();
    }

    public boolean cancel() {
        return this.f20842a.cancel(true);
    }

    public T get() {
        T t = null;
        try {
            LoggerProxy.m17001d("BasicHandler", "before get");
            t = this.f20842a.get(C5094l.DEFAULT.m17279a(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            LoggerProxy.m17001d("BasicHandler", e.toString());
        } catch (ExecutionException e2) {
            LoggerProxy.m17001d("BasicHandler", e2.getCause().toString());
        } catch (TimeoutException e3) {
            LoggerProxy.m17001d("BasicHandler", e3.toString());
        }
        return t;
    }
}
