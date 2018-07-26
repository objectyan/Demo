package com.baidu.tts.p225m;

import com.baidu.tts.p218b.p219a.p223b.C5008e.C5006b;
import com.baidu.tts.p218b.p219a.p223b.C5013f.C5010b;
import com.baidu.tts.p224n.C5004a;
import com.baidu.tts.p233f.C5092j;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.tools.DataTool;

/* compiled from: AllSynthesizerParams */
/* renamed from: com.baidu.tts.m.b */
public class C5141b extends C5004a<C5141b> {
    /* renamed from: a */
    private C5010b f21248a = new C5010b();
    /* renamed from: b */
    private C5006b f21249b = new C5006b();
    /* renamed from: c */
    private C5092j f21250c;

    /* renamed from: a */
    public C5010b m17396a() {
        return this.f21248a;
    }

    /* renamed from: b */
    public C5006b m17399b() {
        return this.f21249b;
    }

    /* renamed from: a */
    public void m17398a(String str) {
        this.f21248a.m16775k(str);
        this.f21249b.m16775k(str);
    }

    /* renamed from: b */
    public void m17400b(String str) {
        this.f21248a.m16777m(str);
        this.f21249b.m16777m(str);
    }

    /* renamed from: c */
    public void m17402c(String str) {
        this.f21248a.m16776l(str);
        this.f21249b.m16776l(str);
    }

    /* renamed from: d */
    public int m17403d(String str) {
        if (!DataTool.isLong(str)) {
            return C5097n.TTS_PARAMETER_INVALID.m17284b();
        }
        this.f21248a.m16774j(str);
        this.f21249b.m16774j(str);
        return 0;
    }

    /* renamed from: c */
    public C5092j m17401c() {
        return this.f21250c;
    }

    /* renamed from: a */
    public void m17397a(C5092j c5092j) {
        this.f21250c = c5092j;
    }
}
