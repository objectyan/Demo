package com.baidu.che.codriver.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.widget.C2875b.C2882a;

public class DuerOSMicImageView extends ImageView implements C2875b {
    /* renamed from: a */
    private static final String f9433a = "DuerOSMicImageView";
    /* renamed from: b */
    private C2882a f9434b = C2882a.STATE_NORMAL;
    /* renamed from: c */
    private C1880a f9435c;
    /* renamed from: d */
    private C1880a f9436d;
    /* renamed from: e */
    private C1880a f9437e;
    /* renamed from: f */
    private AnimationDrawable f9438f;
    /* renamed from: g */
    private AnimationDrawable f9439g;
    /* renamed from: h */
    private AnimationDrawable f9440h;
    /* renamed from: i */
    private boolean f9441i = false;

    public DuerOSMicImageView(Context context) {
        super(context);
        m10868d();
    }

    public DuerOSMicImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10868d();
    }

    /* renamed from: d */
    private void m10868d() {
        this.f9438f = (AnimationDrawable) getResources().getDrawable(C0965R.drawable.baidu_mic_asr);
        this.f9435c = new C1880a(this, this.f9438f) {
            /* renamed from: a */
            final /* synthetic */ DuerOSMicImageView f9429a;

            /* renamed from: a */
            public void mo1702a() {
                C2725h.m10207b(DuerOSMicImageView.f9433a, "asr animation finished");
                this.f9429a.f9435c.stop();
                this.f9429a.m10876h();
            }
        };
        this.f9439g = (AnimationDrawable) getResources().getDrawable(C0965R.drawable.baidu_mic_asrtonlu);
        this.f9436d = new C1880a(this, this.f9439g) {
            /* renamed from: a */
            final /* synthetic */ DuerOSMicImageView f9430a;

            /* renamed from: a */
            public void mo1702a() {
                C2725h.m10207b(DuerOSMicImageView.f9433a, "asrtonlu animation finished");
                this.f9430a.f9436d.stop();
                this.f9430a.m10878j();
            }
        };
        this.f9440h = (AnimationDrawable) getResources().getDrawable(C0965R.drawable.baidu_mic_nlu);
        this.f9437e = new C1880a(this, this.f9440h) {
            /* renamed from: a */
            final /* synthetic */ DuerOSMicImageView f9431a;

            /* renamed from: a */
            public void mo1702a() {
                C2725h.m10207b(DuerOSMicImageView.f9433a, "nlu animation finished--state:" + this.f9431a.f9434b);
                if (this.f9431a.f9434b != C2882a.STATE_RECORD) {
                    this.f9431a.f9437e.stop();
                    this.f9431a.m10871e();
                }
            }
        };
    }

    /* renamed from: a */
    public void mo1980a() {
        setState(C2882a.STATE_NORMAL);
    }

    /* renamed from: b */
    public void mo1981b() {
        setState(C2882a.STATE_RECORD);
    }

    /* renamed from: c */
    public void mo1982c() {
        setState(C2882a.STATE_REQUEST);
    }

    private void setState(C2882a state) {
        C2725h.m10207b(f9433a, "setState---state = " + state);
        if (this.f9434b == state) {
            C2725h.m10207b(f9433a, "mCurrentState == state");
            return;
        }
        this.f9434b = state;
        switch (state) {
            case STATE_NORMAL:
                C2725h.m10207b(f9433a, "state = STATE_NORMAL");
                m10874g();
                m10877i();
                m10879k();
                m10871e();
                return;
            case STATE_RECORD:
                C2725h.m10207b(f9433a, "state = STATE_RECORD");
                m10873f();
                return;
            case STATE_REQUEST:
                C2725h.m10207b(f9433a, "state = STATE_REQUEST");
                m10874g();
                return;
            default:
                return;
        }
    }

    /* renamed from: e */
    private void m10871e() {
        if (this.f9441i) {
            setBackgroundResource(0);
            setBackgroundResource(C0965R.drawable.baidu_mic_normal);
        }
        this.f9441i = false;
    }

    /* renamed from: f */
    private void m10873f() {
        if (!this.f9441i) {
            setBackgroundResource(0);
            setBackground(this.f9435c);
            this.f9435c.setOneShot(false);
            this.f9435c.start();
            this.f9441i = true;
        }
    }

    /* renamed from: g */
    private void m10874g() {
        if (this.f9435c != null) {
            this.f9435c.setOneShot(true);
        }
    }

    /* renamed from: h */
    private void m10876h() {
        if (this.f9441i) {
            setBackgroundResource(0);
            setBackground(this.f9436d);
            this.f9436d.setOneShot(true);
            this.f9436d.start();
        }
    }

    /* renamed from: i */
    private void m10877i() {
        if (this.f9436d != null) {
            this.f9436d.stop();
        }
    }

    /* renamed from: j */
    private void m10878j() {
        if (this.f9441i) {
            setBackgroundResource(0);
            setBackground(this.f9437e);
            this.f9437e.setOneShot(false);
            this.f9437e.start();
        }
    }

    /* renamed from: k */
    private void m10879k() {
        if (this.f9437e != null) {
            this.f9437e.setOneShot(true);
        }
    }
}
