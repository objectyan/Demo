package com.baidu.tts.p236h.p238b;

import android.content.Context;
import com.baidu.tts.tools.FileTools;
import com.baidu.tts.tools.GetCUID;
import com.baidu.tts.tools.ResourceTools;
import java.lang.ref.WeakReference;

/* compiled from: AppPersistentValueFlyweight */
/* renamed from: com.baidu.tts.h.b.a */
public class C5106a {
    /* renamed from: a */
    private WeakReference<Context> f21207a;
    /* renamed from: b */
    private String f21208b;
    /* renamed from: c */
    private String f21209c;

    public C5106a(WeakReference<Context> weakReference) {
        this.f21207a = weakReference;
    }

    /* renamed from: a */
    public String m17304a() {
        if (this.f21208b == null) {
            this.f21208b = GetCUID.getCUID(m17303c());
        }
        return this.f21208b;
    }

    /* renamed from: b */
    public String m17305b() {
        if (this.f21209c == null) {
            this.f21209c = FileTools.jointPathAndName(ResourceTools.getAppFilesDirPath(m17303c()), "baidu_tts_license");
        }
        return this.f21209c;
    }

    /* renamed from: c */
    private Context m17303c() {
        return this.f21207a == null ? null : (Context) this.f21207a.get();
    }
}
