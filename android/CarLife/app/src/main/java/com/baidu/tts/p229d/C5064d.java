package com.baidu.tts.p229d;

import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.p241l.C5120a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: DownloaderClient */
/* renamed from: com.baidu.tts.d.d */
public class C5064d {
    /* renamed from: a */
    private C5063c f20943a = C5063c.m17171a();
    /* renamed from: b */
    private ConcurrentMap<String, DownloadHandler> f20944b = new ConcurrentHashMap();
    /* renamed from: c */
    private C5120a f20945c;

    /* renamed from: a */
    public void m17187a() {
        this.f20943a.m17183g();
    }

    /* renamed from: b */
    public void m17189b() {
        m17184c();
        this.f20943a.mo3786e();
    }

    /* renamed from: c */
    private void m17184c() {
        for (DownloadHandler stop : this.f20944b.values()) {
            stop.stop();
        }
    }

    /* renamed from: a */
    public void m17188a(C5120a c5120a) {
        this.f20945c = c5120a;
        this.f20943a.m17177a(c5120a);
    }

    /* renamed from: a */
    public DownloadHandler m17185a(C5061b c5061b) {
        if (c5061b != null && c5061b.m17168b()) {
            DownloadHandler a = m17186a(c5061b.m17165a());
            if (a != null) {
                a.reset(c5061b);
                return this.f20943a.m17176a(a);
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized DownloadHandler m17186a(String str) {
        DownloadHandler downloadHandler;
        try {
            downloadHandler = (DownloadHandler) this.f20944b.get(str);
            if (downloadHandler == null) {
                downloadHandler = new DownloadHandler(this.f20945c);
                this.f20944b.put(str, downloadHandler);
            }
        } catch (Exception e) {
            downloadHandler = null;
        }
        return downloadHandler;
    }
}
