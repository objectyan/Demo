package com.baidu.tts.p234g.p235a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.ThreadFactory;

/* compiled from: NameThreadFactory */
/* renamed from: com.baidu.tts.g.a.a */
public class C5102a implements ThreadFactory {
    /* renamed from: a */
    private String f21202a;
    /* renamed from: b */
    private int f21203b;

    public C5102a(String str) {
        this.f21202a = str;
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        this.f21203b++;
        String str = this.f21202a + "(" + this.f21203b + ")";
        thread.setName(str);
        LoggerProxy.m17001d("NameThreadFactory", "threadName=" + str);
        return thread;
    }
}
