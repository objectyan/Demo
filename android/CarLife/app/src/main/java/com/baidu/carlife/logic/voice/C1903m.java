package com.baidu.carlife.logic.voice;

import com.baidu.carlife.core.C1260i;

/* compiled from: VoiceStateSwitcher */
/* renamed from: com.baidu.carlife.logic.voice.m */
public class C1903m {

    /* compiled from: VoiceStateSwitcher */
    /* renamed from: com.baidu.carlife.logic.voice.m$a */
    private static class C1902a {
        /* renamed from: a */
        static final C1903m f5872a = new C1903m();

        private C1902a() {
        }
    }

    private C1903m() {
    }

    /* renamed from: a */
    public static C1903m m7252a() {
        return C1902a.f5872a;
    }

    /* renamed from: b */
    public void m7255b() {
        if (C1912n.m7270a().m7314m()) {
            C1912n.m7270a().m7311j();
            C1260i.m4435b("VoiceStateSwitcher", "stopTTSAndCloseVr");
        } else if (C1912n.m7270a().m7303c()) {
            m7254d();
            C1260i.m4435b("VoiceStateSwitcher", "abortListening");
        } else if (C1912n.m7270a().m7301b()) {
            m7253c();
            C1260i.m4435b("VoiceStateSwitcher", "abortProcessing");
        }
    }

    /* renamed from: c */
    private void m7253c() {
        C1912n.m7270a().m7311j();
        C1912n.m7270a().m7293a(4100);
    }

    /* renamed from: d */
    private void m7254d() {
        C1912n.m7270a().m7311j();
        C1912n.m7270a().m7293a(4100);
    }
}
