package com.baidu.tts.p218b.p219a.p222a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;

/* compiled from: UninitialEngineState */
/* renamed from: com.baidu.tts.b.a.a.h */
public class C4993h extends C4986b {
    public C4993h(C4989c c4989c) {
        super(c4989c);
    }

    /* renamed from: b */
    public TtsError mo3782b() {
        TtsError s = this.a.m16694s();
        m16662a(this.a.m16691p());
        return s;
    }

    /* renamed from: a */
    public void mo3829a(C5146i c5146i) {
        m16711a(C5145h.m17416b(c5146i));
    }

    /* renamed from: a */
    public int mo3824a(C5142e c5142e) {
        m16711a(new C5145h());
        return -1;
    }

    /* renamed from: b */
    public int mo3831b(C5142e c5142e) {
        m16711a(new C5145h());
        return -1;
    }

    /* renamed from: a */
    public int mo3826a(C5144g c5144g) {
        m16711a(new C5145h());
        return -1;
    }

    /* renamed from: a */
    public int mo3825a(C5143f c5143f) {
        m16711a(new C5145h());
        return -1;
    }

    /* renamed from: a */
    private void m16711a(C5145h c5145h) {
        c5145h.m17419a(C5105c.m17295a().m17302b(C5097n.OFFLINE_ENGINE_UNINITIALIZED));
        this.a.m16651e(c5145h);
    }
}
