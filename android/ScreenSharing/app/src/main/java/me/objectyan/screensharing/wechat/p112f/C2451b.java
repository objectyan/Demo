package com.baidu.carlife.wechat.p112f;

import com.baidu.baidunavis.tts.IBNTTSPlayerWeChatListener;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p108b.C2376b;
import com.baidu.carlife.wechat.p108b.C2382d;
import com.baidu.carlife.wechat.p108b.C2398k;
import com.baidu.carlife.wechat.p112f.C2445a.C2443a;

/* compiled from: WechatSpeechController */
/* renamed from: com.baidu.carlife.wechat.f.b */
public class C2451b implements C2443a {
    /* renamed from: a */
    private C2382d f8012a;
    /* renamed from: b */
    private C2376b f8013b;
    /* renamed from: c */
    private C2445a f8014c;

    /* compiled from: WechatSpeechController */
    /* renamed from: com.baidu.carlife.wechat.f.b$1 */
    class C24461 implements IBNTTSPlayerWeChatListener {
        /* renamed from: a */
        final /* synthetic */ C2451b f8007a;

        C24461(C2451b this$0) {
            this.f8007a = this$0;
        }

        public void notifyTTSStart() {
        }

        public void notifyTTSEnd() {
            C2454d.m9371a(null);
            this.f8007a.f8014c.m9340b();
        }

        public void notifyTTSInterrupt() {
            C2454d.m9371a(null);
            this.f8007a.mo1847c();
        }
    }

    /* compiled from: WechatSpeechController */
    /* renamed from: com.baidu.carlife.wechat.f.b$2 */
    class C24472 implements IBNTTSPlayerWeChatListener {
        /* renamed from: a */
        final /* synthetic */ C2451b f8008a;

        C24472(C2451b this$0) {
            this.f8008a = this$0;
        }

        public void notifyTTSStart() {
        }

        public void notifyTTSEnd() {
            C2454d.m9371a(null);
            this.f8008a.f8014c.m9341c();
        }

        public void notifyTTSInterrupt() {
            C2454d.m9371a(null);
            this.f8008a.mo1847c();
        }
    }

    /* compiled from: WechatSpeechController */
    /* renamed from: com.baidu.carlife.wechat.f.b$3 */
    class C24483 implements IBNTTSPlayerWeChatListener {
        /* renamed from: a */
        final /* synthetic */ C2451b f8009a;

        C24483(C2451b this$0) {
            this.f8009a = this$0;
        }

        public void notifyTTSStart() {
        }

        public void notifyTTSEnd() {
            C2454d.m9371a(null);
            this.f8009a.f8014c.m9342d();
        }

        public void notifyTTSInterrupt() {
            C2454d.m9371a(null);
            this.f8009a.mo1847c();
        }
    }

    /* compiled from: WechatSpeechController */
    /* renamed from: com.baidu.carlife.wechat.f.b$4 */
    class C24494 implements IBNTTSPlayerWeChatListener {
        /* renamed from: a */
        final /* synthetic */ C2451b f8010a;

        C24494(C2451b this$0) {
            this.f8010a = this$0;
        }

        public void notifyTTSStart() {
        }

        public void notifyTTSEnd() {
            C2454d.m9371a(null);
            this.f8010a.f8014c.m9343e();
        }

        public void notifyTTSInterrupt() {
            C2454d.m9371a(null);
            this.f8010a.mo1847c();
        }
    }

    /* compiled from: WechatSpeechController */
    /* renamed from: com.baidu.carlife.wechat.f.b$a */
    private static class C2450a {
        /* renamed from: a */
        private static final C2451b f8011a = new C2451b();

        private C2450a() {
        }
    }

    private C2451b() {
    }

    /* renamed from: d */
    public static C2451b m9347d() {
        return C2450a.f8011a;
    }

    /* renamed from: e */
    public void m9356e() {
        this.f8014c = new C2445a();
        this.f8014c.m9339a((C2443a) this);
        this.f8014c.m9337a();
    }

    /* renamed from: f */
    public void m9357f() {
        this.f8014c.m9344f();
    }

    /* renamed from: a */
    public void mo1845a() {
        C2372c.m9030c("");
        if (this.f8012a != null) {
            C2398k.m9160a().m9187c(this.f8012a);
        } else {
            mo1847c();
        }
    }

    /* renamed from: b */
    public void mo1846b() {
        m9358g();
    }

    /* renamed from: c */
    public void mo1847c() {
        C2372c.m9030c("");
        m9357f();
        C2454d.m9370a();
        C2398k.m9160a().m9192f();
    }

    /* renamed from: a */
    public void m9351a(C2382d msg, String ttsText) {
        this.f8012a = msg;
        C2454d.m9370a();
        C2454d.m9371a(new C24461(this));
        if (C2454d.m9369a(ttsText) < 0) {
            C2454d.m9371a(null);
            mo1847c();
        }
    }

    /* renamed from: b */
    public void m9353b(C2382d msg, String ttsText) {
        this.f8012a = msg;
        C2454d.m9370a();
        C2454d.m9371a(new C24472(this));
        if (C2454d.m9369a(ttsText) < 0) {
            C2454d.m9371a(null);
            mo1847c();
        }
    }

    /* renamed from: c */
    public void m9355c(C2382d msg, String ttsText) {
        this.f8012a = msg;
        C2454d.m9370a();
        C2454d.m9371a(new C24483(this));
        if (C2454d.m9369a(ttsText) < 0) {
            C2454d.m9371a(null);
            mo1847c();
        }
    }

    /* renamed from: a */
    public void m9350a(C2376b contact, String ttsText) {
        C2372c.m9030c("");
        this.f8013b = contact;
        C2454d.m9370a();
        C2454d.m9371a(new C24494(this));
        if (C2454d.m9369a(ttsText) < 0) {
            C2454d.m9371a(null);
            mo1847c();
        }
    }

    /* renamed from: a */
    public void m9349a(C2376b contact) {
        C2372c.m9030c("");
        this.f8013b = contact;
        this.f8014c.m9338a(contact);
    }

    /* renamed from: g */
    public void m9358g() {
        if (this.f8013b != null) {
            m9349a(this.f8013b);
        } else {
            mo1847c();
        }
    }
}
