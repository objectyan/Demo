package com.baidu.carlife.logic.voice;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.C1030b;
import com.baidu.carlife.C1080c;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1261k;
import com.baidu.che.codriver.widget.C1880a;

public class LightVoiceMicView extends ImageView implements C1080c {
    /* renamed from: a */
    private static final int f5823a = 0;
    /* renamed from: b */
    private static final int f5824b = 1;
    /* renamed from: c */
    private C0936j f5825c;
    /* renamed from: d */
    private C1880a f5826d;
    /* renamed from: e */
    private C1880a f5827e;
    /* renamed from: f */
    private C1880a f5828f;
    /* renamed from: g */
    private AnimationDrawable f5829g;
    /* renamed from: h */
    private AnimationDrawable f5830h;
    /* renamed from: i */
    private AnimationDrawable f5831i;
    /* renamed from: j */
    private int f5832j;

    /* renamed from: com.baidu.carlife.logic.voice.LightVoiceMicView$a */
    private class C1885a extends C1884l {
        /* renamed from: a */
        final /* synthetic */ LightVoiceMicView f5822a;

        public C1885a(LightVoiceMicView lightVoiceMicView, Looper looper) {
            this.f5822a = lightVoiceMicView;
            super(looper);
        }

        /* renamed from: a */
        void mo1703a() {
            C1903m.m7252a().m7255b();
            this.f5822a.m7211n();
        }

        /* renamed from: b */
        void mo1704b() {
            this.f5822a.m7209l();
        }

        /* renamed from: c */
        void mo1705c() {
            super.mo1705c();
            this.f5822a.f5832j = 1;
        }

        /* renamed from: d */
        void mo1706d() {
            super.mo1706d();
            this.f5822a.m7207j();
        }

        /* renamed from: e */
        void mo1707e() {
            super.mo1707e();
            this.f5822a.m7208k();
        }

        /* renamed from: f */
        void mo1708f() {
            super.mo1708f();
            if (this.f5822a.f5832j != 0) {
                this.f5822a.m7209l();
            }
            this.f5822a.f5832j = 0;
        }
    }

    public LightVoiceMicView(Context context) {
        this(context, null);
    }

    public LightVoiceMicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f5832j = 0;
        m7205h();
        m7206i();
        C1030b.m3276a().m3279a((C1080c) this);
    }

    /* renamed from: h */
    private void m7205h() {
        this.f5825c = new C1885a(this, Looper.getMainLooper());
        C1261k.m4460a(this.f5825c);
    }

    /* renamed from: i */
    private void m7206i() {
        this.f5829g = (AnimationDrawable) getResources().getDrawable(C0965R.drawable.baidu_mic_asr);
        this.f5826d = new C1880a(this, this.f5829g) {
            /* renamed from: a */
            final /* synthetic */ LightVoiceMicView f5819a;

            /* renamed from: a */
            public void mo1702a() {
                this.f5819a.f5826d.stop();
            }
        };
        this.f5830h = (AnimationDrawable) getResources().getDrawable(C0965R.drawable.baidu_mic_asrtonlu);
        this.f5827e = new C1880a(this, this.f5830h) {
            /* renamed from: a */
            final /* synthetic */ LightVoiceMicView f5820a;

            /* renamed from: a */
            public void mo1702a() {
                this.f5820a.f5827e.stop();
            }
        };
        this.f5831i = (AnimationDrawable) getResources().getDrawable(C0965R.drawable.baidu_mic_nlu);
        this.f5828f = new C1880a(this, this.f5831i) {
            /* renamed from: a */
            final /* synthetic */ LightVoiceMicView f5821a;

            /* renamed from: a */
            public void mo1702a() {
                this.f5821a.f5828f.stop();
            }
        };
    }

    /* renamed from: j */
    private void m7207j() {
        if (this.f5832j != 0) {
            setImageResource(0);
            setBackgroundResource(0);
            setBackground(this.f5826d);
            this.f5826d.setOneShot(false);
            this.f5826d.start();
        }
    }

    /* renamed from: k */
    private void m7208k() {
        if (this.f5832j != 0) {
            this.f5826d.setOneShot(true);
            setBackgroundResource(0);
            setBackground(this.f5828f);
            this.f5828f.setOneShot(false);
            this.f5828f.start();
        }
    }

    /* renamed from: l */
    private void m7209l() {
        m7210m();
        setBackgroundResource(C0965R.drawable.com_bg_tab_bottom_selector);
        setImageResource(C0965R.drawable.com_ic_voice_selector);
        setEnabled(true);
    }

    /* renamed from: m */
    private void m7210m() {
        this.f5828f.setOneShot(true);
        this.f5827e.stop();
        this.f5826d.stop();
        this.f5828f.stop();
    }

    /* renamed from: n */
    private void m7211n() {
        m7210m();
        setBackgroundResource(0);
        setImageResource(C0965R.drawable.com_ic_voice_normal01_disable);
        setEnabled(false);
    }

    /* renamed from: g */
    public void m7219g() {
        C1261k.m4452a(4101);
        C1261k.m4452a(4100);
        C1261k.m4452a(4159);
        C1261k.m4464b(this.f5825c);
        this.f5825c.removeCallbacksAndMessages(null);
        this.f5825c = null;
        C1030b.m3276a().m3281b(this);
        this.f5832j = 0;
    }

    /* renamed from: a */
    public void mo1400a() {
    }

    /* renamed from: b */
    public void mo1402b() {
        if (!C1912n.m7270a().m7314m()) {
            C1903m.m7252a().m7255b();
        }
    }

    /* renamed from: c */
    public void mo1403c() {
    }

    /* renamed from: d */
    public void mo1404d() {
    }

    /* renamed from: a */
    public void mo1401a(Intent intent) {
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    /* renamed from: e */
    public void mo1405e() {
    }

    /* renamed from: f */
    public void mo1406f() {
        m7219g();
    }
}
