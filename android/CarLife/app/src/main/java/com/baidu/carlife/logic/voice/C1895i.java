package com.baidu.carlife.logic.voice;

import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.view.C2348h;

/* compiled from: UnsupCommandPostProcess */
/* renamed from: com.baidu.carlife.logic.voice.i */
public class C1895i extends C1886j {
    public C1895i(C2348h window) {
        super(window);
        this.i = 1;
    }

    /* renamed from: a */
    public void mo1709a(String voiceHint) {
        this.g.m8923c();
        m7224b();
        C1915a.m7321a().m7325a(null);
        C1915a.m7321a().m7328b(C1157a.m3876a().getString(C0965R.string.error_recog_help), 1);
    }
}
