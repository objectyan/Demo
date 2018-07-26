package com.baidu.carlife.logic.p082b.p095e;

import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.tts.BdTTSPlayer;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.p059c.p064d.C1108f;
import com.baidu.carlife.p059c.p064d.C1115c;

/* compiled from: VoiceSettingViewModel */
/* renamed from: com.baidu.carlife.logic.b.e.a */
public class C1745a extends C1108f {
    /* renamed from: a */
    private C1115c<Boolean> f5275a = new C1115c();
    /* renamed from: b */
    private C1115c<Boolean> f5276b = new C1115c();

    public C1745a() {
        this.f5275a.mo1419b(Boolean.valueOf(C1251e.m4358a().m4398o()));
        this.f5276b.mo1419b(Boolean.valueOf(BaseTTSPlayer.getInstance().getLastTTSVoiceDataPath().contains(BdTTSPlayer.K_TTS_DATA_FILE)));
    }

    /* renamed from: a */
    public C1115c<Boolean> m6330a() {
        return this.f5276b;
    }

    /* renamed from: c */
    public C1115c<Boolean> m6332c() {
        return this.f5275a;
    }

    /* renamed from: b */
    public void mo1628b() {
        super.mo1628b();
        this.f5275a.m3759a();
        this.f5276b.m3759a();
        this.f5275a = null;
        this.f5276b = null;
    }
}
