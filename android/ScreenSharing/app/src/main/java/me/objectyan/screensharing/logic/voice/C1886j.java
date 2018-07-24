package com.baidu.carlife.logic.voice;

import android.widget.TextView;
import com.baidu.baidunavis.tts.IBNTTSVoiceHintListener;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.view.C2348h;

/* compiled from: VoiceBasePostProcess */
/* renamed from: com.baidu.carlife.logic.voice.j */
public class C1886j {
    /* renamed from: a */
    public static final int f5833a = 1;
    /* renamed from: b */
    public static final int f5834b = 2;
    /* renamed from: c */
    public static final int f5835c = 3;
    /* renamed from: d */
    public static final int f5836d = 4;
    /* renamed from: e */
    protected int f5837e = 2;
    /* renamed from: f */
    protected int f5838f;
    /* renamed from: g */
    protected C2348h f5839g;
    /* renamed from: h */
    protected TextView f5840h;
    /* renamed from: i */
    protected int f5841i;
    /* renamed from: j */
    protected IBNTTSVoiceHintListener f5842j = new C18992(this);
    /* renamed from: k */
    private IBNTTSVoiceHintListener f5843k = new C18971(this);

    /* compiled from: VoiceBasePostProcess */
    /* renamed from: com.baidu.carlife.logic.voice.j$1 */
    class C18971 implements IBNTTSVoiceHintListener {
        /* renamed from: a */
        final /* synthetic */ C1886j f5848a;

        /* compiled from: VoiceBasePostProcess */
        /* renamed from: com.baidu.carlife.logic.voice.j$1$1 */
        class C18961 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C18971 f5847a;

            C18961(C18971 this$1) {
                this.f5847a = this$1;
            }

            public void run() {
            }
        }

        C18971(C1886j this$0) {
            this.f5848a = this$0;
        }

        @Deprecated
        public void notifyTTSStart() {
        }

        public void notifyTTSEnd() {
            this.f5848a.f5840h.post(new C18961(this));
        }
    }

    /* compiled from: VoiceBasePostProcess */
    /* renamed from: com.baidu.carlife.logic.voice.j$2 */
    class C18992 implements IBNTTSVoiceHintListener {
        /* renamed from: a */
        final /* synthetic */ C1886j f5850a;

        /* compiled from: VoiceBasePostProcess */
        /* renamed from: com.baidu.carlife.logic.voice.j$2$1 */
        class C18981 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C18992 f5849a;

            C18981(C18992 this$1) {
                this.f5849a = this$1;
            }

            public void run() {
                C1912n.m7270a().m7310i();
            }
        }

        C18992(C1886j this$0) {
            this.f5850a = this$0;
        }

        @Deprecated
        public void notifyTTSStart() {
        }

        public void notifyTTSEnd() {
            this.f5850a.f5840h.post(new C18981(this));
        }
    }

    public C1886j(C2348h window) {
        this.f5839g = window;
        this.f5840h = window.m8924d();
    }

    /* renamed from: b */
    public void m7225b(String voiceHint) {
        this.f5840h.setText(voiceHint);
        this.f5840h.setVisibility(0);
        int i = this.f5838f + 1;
        this.f5838f = i;
        if (i >= this.f5837e) {
            mo1709a(voiceHint);
        } else {
            m7220c(voiceHint);
        }
    }

    /* renamed from: a */
    public void m7222a(int stringId) {
        m7225b(AppContext.m3876a().getString(stringId));
    }

    /* renamed from: a */
    protected void mo1709a(String voiceHint) {
        m7224b();
        C1915a.m7321a().m7325a(this.f5842j);
        C1915a.m7321a().m7328b(voiceHint, 1);
    }

    /* renamed from: c */
    private void m7220c(String voiceHint) {
        C1915a.m7321a().m7325a(this.f5843k);
        C1915a.m7321a().m7328b(voiceHint, 1);
    }

    /* renamed from: a */
    public int m7221a() {
        return this.f5841i;
    }

    /* renamed from: b */
    public void m7224b() {
        this.f5838f = 0;
    }
}
