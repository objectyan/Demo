package com.baidu.carlife.logic.voice;

import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.view.C2348h;

/* compiled from: NotFoundPostProcess */
/* renamed from: com.baidu.carlife.logic.voice.d */
public class C1890d extends C1886j {
    public C1890d(C2348h window) {
        super(window);
        this.i = 4;
    }

    /* renamed from: a */
    protected void mo1709a(String voiceHint) {
        m7224b();
        C1915a.m7321a().m7325a(this.j);
        C1915a.m7321a().m7328b(C1157a.m3876a().getString(C0965R.string.error_recog_too_many), 1);
    }
}
