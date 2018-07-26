package com.baidu.tts.p218b.p219a.p222a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p216j.C4983a;
import com.baidu.tts.p218b.p219a.C4960b;
import com.baidu.tts.p218b.p219a.p223b.C4995b;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p233f.C5087e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AEngineExecutor */
/* renamed from: com.baidu.tts.b.a.a.a */
public abstract class C4985a extends C4983a implements C4984d {
    /* renamed from: a */
    protected C4995b f20696a;
    /* renamed from: b */
    protected List<C4960b> f20697b = new ArrayList();
    /* renamed from: c */
    protected volatile C4986b f20698c;

    /* renamed from: a */
    public C4986b m16640a() {
        return this.f20698c;
    }

    /* renamed from: a */
    public void m16641a(C4986b c4986b) {
        this.f20698c = c4986b;
    }

    /* renamed from: g */
    protected TtsError mo3832g() {
        return this.f20698c.mo3782b();
    }

    /* renamed from: h */
    protected void mo3833h() {
        this.f20698c.mo3840a();
    }

    /* renamed from: i */
    protected void mo3834i() {
        this.f20698c.mo3784c();
    }

    /* renamed from: j */
    protected void mo3835j() {
        this.f20698c.mo3785d();
    }

    /* renamed from: k */
    protected void mo3836k() {
        this.f20698c.mo3786e();
    }

    /* renamed from: l */
    protected void mo3837l() {
        this.f20698c.mo3787f();
    }

    /* renamed from: a */
    public void mo3827a(C4995b c4995b) {
        this.f20698c.mo3827a(c4995b);
    }

    /* renamed from: a */
    public void mo3828a(C4960b c4960b) {
        this.f20698c.mo3828a(c4960b);
    }

    /* renamed from: a */
    public void mo3830a(Object obj) {
        this.f20698c.mo3830a(obj);
    }

    /* renamed from: a */
    public void mo3829a(C5146i c5146i) {
        this.f20698c.mo3829a(c5146i);
    }

    /* renamed from: a */
    public int mo3824a(C5142e c5142e) {
        return this.f20698c.mo3824a(c5142e);
    }

    /* renamed from: b */
    public int mo3831b(C5142e c5142e) {
        return this.f20698c.mo3831b(c5142e);
    }

    /* renamed from: a */
    public int mo3826a(C5144g c5144g) {
        return this.f20698c.mo3826a(c5144g);
    }

    /* renamed from: a */
    public int mo3825a(C5143f c5143f) {
        return this.f20698c.mo3825a(c5143f);
    }

    /* renamed from: a */
    void m16644a(C5145h c5145h) {
        if (m16613C()) {
            if (c5145h == null) {
                c5145h = new C5145h();
            }
            c5145h.m17421a(C5087e.SYN_START);
            if (this.f20697b != null) {
                for (C4960b c4960b : this.f20697b) {
                    if (c4960b != null) {
                        c4960b.mo3766a(c5145h);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    void m16648b(C5145h c5145h) {
        if (m16613C()) {
            if (c5145h == null) {
                c5145h = new C5145h();
            }
            c5145h.m17421a(C5087e.SYN_DATA);
            if (this.f20697b != null) {
                for (C4960b c4960b : this.f20697b) {
                    if (c4960b != null) {
                        c4960b.mo3768c(c5145h);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    void m16649c(C5145h c5145h) {
        if (m16613C()) {
            if (c5145h == null) {
                c5145h = new C5145h();
            }
            c5145h.m17421a(C5087e.SYN_FINISH);
            if (this.f20697b != null) {
                for (C4960b c4960b : this.f20697b) {
                    if (c4960b != null) {
                        c4960b.mo3767b(c5145h);
                    }
                }
            }
        }
    }

    /* renamed from: d */
    void m16650d(C5145h c5145h) {
        if (c5145h == null) {
            c5145h = new C5145h();
        }
        c5145h.m17421a(C5087e.SYN_STOP);
        if (this.f20697b != null) {
            for (C4960b c4960b : this.f20697b) {
                if (c4960b != null) {
                    c4960b.mo3770e(c5145h);
                }
            }
        }
    }

    /* renamed from: e */
    void m16651e(C5145h c5145h) {
        if (c5145h == null) {
            c5145h = new C5145h();
        }
        c5145h.m17421a(C5087e.SYN_ERROR);
        if (this.f20697b != null) {
            for (C4960b c4960b : this.f20697b) {
                if (c4960b != null) {
                    c4960b.mo3769d(c5145h);
                }
            }
        }
    }
}
