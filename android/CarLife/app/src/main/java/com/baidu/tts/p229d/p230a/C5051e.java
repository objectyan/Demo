package com.baidu.tts.p229d.p230a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p229d.p230a.C5048b.C5047a;
import java.util.concurrent.Future;

/* compiled from: EngineDownloadHandler */
/* renamed from: com.baidu.tts.d.a.e */
public class C5051e {
    /* renamed from: a */
    private Future<Void> f20907a;
    /* renamed from: b */
    private C5047a f20908b;

    /* renamed from: a */
    public void m17088a(Future<Void> future) {
        this.f20907a = future;
    }

    /* renamed from: a */
    public void m17087a(C5047a c5047a) {
        this.f20908b = c5047a;
    }

    /* renamed from: a */
    public void m17086a() {
        LoggerProxy.m17001d("EngineDownloadHandler", "before stop");
        try {
            LoggerProxy.m17001d("EngineDownloadHandler", "stop fileId=" + this.f20908b.m17053c().m17074a());
        } catch (Exception e) {
        }
        if (this.f20907a != null) {
            LoggerProxy.m17001d("EngineDownloadHandler", "unDone = " + this.f20907a.cancel(true));
        }
        if (this.f20908b != null) {
            this.f20908b.m17052b();
        }
        LoggerProxy.m17001d("EngineDownloadHandler", "after stop");
    }
}
