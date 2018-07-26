package com.baidu.tts.p229d;

import com.baidu.tts.client.model.OnDownloadListener;
import com.baidu.tts.tools.StringTool;

/* compiled from: DownloadParams */
/* renamed from: com.baidu.tts.d.b */
public class C5061b {
    /* renamed from: a */
    private String f20934a;
    /* renamed from: b */
    private OnDownloadListener f20935b;

    /* renamed from: a */
    public String m17165a() {
        return this.f20934a;
    }

    /* renamed from: a */
    public void m17167a(String str) {
        this.f20934a = str;
    }

    /* renamed from: b */
    public boolean m17168b() {
        return !StringTool.isEmpty(this.f20934a);
    }

    /* renamed from: c */
    public OnDownloadListener m17169c() {
        return this.f20935b;
    }

    /* renamed from: a */
    public void m17166a(OnDownloadListener onDownloadListener) {
        this.f20935b = onDownloadListener;
    }
}
