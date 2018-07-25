package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.baidu.carlife.R;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2186p;

/* compiled from: GuideForHomeDialog */
/* renamed from: com.baidu.carlife.view.dialog.j */
public class C2291j extends BaseDialog implements OnClickListener {
    /* renamed from: e */
    private static final int f7503e = 8000;
    /* renamed from: f */
    private static final int f7504f = 0;
    /* renamed from: g */
    private static final int f7505g = 1;
    /* renamed from: h */
    private static final int f7506h = 2;
    /* renamed from: i */
    private C1443g f7507i;
    /* renamed from: j */
    private RelativeLayout f7508j;
    /* renamed from: k */
    private RelativeLayout f7509k;
    /* renamed from: l */
    private RelativeLayout f7510l;
    /* renamed from: m */
    private ImageView f7511m;
    /* renamed from: n */
    private ImageView f7512n;
    /* renamed from: o */
    private Runnable f7513o = new C22901(this);
    /* renamed from: p */
    private int f7514p = 0;

    /* compiled from: GuideForHomeDialog */
    /* renamed from: com.baidu.carlife.view.dialog.j$1 */
    class C22901 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2291j f7502a;

        C22901(C2291j this$0) {
            this.f7502a = this$0;
        }

        public void run() {
            this.f7502a.m8709i();
        }
    }

    public C2291j(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected View mo1528a() {
        return LayoutInflater.from(this.c).inflate(R.layout.dialog_guide_for_home, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7508j = (RelativeLayout) findViewById(R.id.wrapper_layout_rlt);
        this.f7509k = (RelativeLayout) findViewById(R.id.navi_layout_rlt);
        this.f7510l = (RelativeLayout) findViewById(R.id.radio_layout_rlt);
        this.f7511m = (ImageView) findViewById(R.id.bottom_next_btn);
        this.f7512n = (ImageView) findViewById(R.id.bottom_confirm_btn);
        this.f7508j.setOnClickListener(this);
        this.f7511m.setOnClickListener(this);
        this.f7512n.setOnClickListener(this);
    }

    /* renamed from: a */
    public void mo1525a(OnDialogListener listener) {
        super.mo1525a(listener);
        m8709i();
    }

    /* renamed from: d */
    public void mo1526d() {
        super.mo1526d();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wrapper_layout_rlt:
            case R.id.bottom_next_btn:
            case R.id.bottom_confirm_btn:
                m8710j();
                return;
            default:
                return;
        }
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7511m != null && this.f7512n != null) {
            if (this.f7507i == null) {
                this.f7507i = new C1443g(findViewById(R.id.wrapper_layout_rlt), 12);
                this.f7507i.m5300d(this.f7511m).m5300d(this.f7512n);
            }
            this.f7507i.m5244a(true);
            C1440d.m5251a().m5259c(this.f7507i);
        }
    }

    /* renamed from: g */
    public void mo1527g() {
        C1440d.m5251a().m5258c();
    }

    protected int getCustomWidth() {
        return CarlifeScreenUtil.m4331a().m4351h();
    }

    public int getCustomHeight() {
        return CarlifeScreenUtil.m4331a().m4352i();
    }

    /* renamed from: a */
    public void m8714a(int[] posNaviCard, int[] posRadioCard) {
        if (posNaviCard != null && posNaviCard.length >= 2 && posRadioCard != null && posRadioCard.length >= 2) {
            MarginLayoutParams naviMargin = new MarginLayoutParams(this.f7509k.getLayoutParams());
            naviMargin.setMargins(posNaviCard[0], posNaviCard[1], 0, posNaviCard[1] + naviMargin.height);
            this.f7509k.setLayoutParams(new LayoutParams(naviMargin));
            MarginLayoutParams radioMargin = new MarginLayoutParams(this.f7510l.getLayoutParams());
            radioMargin.setMargins(posRadioCard[0], posRadioCard[1], 0, posRadioCard[1] + radioMargin.height);
            this.f7510l.setLayoutParams(new LayoutParams(radioMargin));
        }
    }

    /* renamed from: a */
    private void m8707a(int index) {
        switch (index) {
            case 0:
                this.f7509k.setVisibility(0);
                this.f7510l.setVisibility(8);
                this.f7511m.setVisibility(0);
                this.f7512n.setVisibility(8);
                return;
            case 1:
                this.f7510l.setVisibility(0);
                this.f7509k.setVisibility(8);
                this.f7511m.setVisibility(8);
                this.f7512n.setVisibility(0);
                this.f7512n.requestFocus();
                return;
            default:
                return;
        }
    }

    /* renamed from: i */
    private void m8709i() {
        if (this.f7514p < 2) {
            m8707a(this.f7514p);
            this.b.postDelayed(this.f7513o, 8000);
        } else {
            m8711k();
        }
        this.f7514p++;
    }

    /* renamed from: j */
    private void m8710j() {
        this.b.removeCallbacks(this.f7513o);
        m8709i();
    }

    /* renamed from: k */
    private void m8711k() {
        this.b.removeCallbacks(this.f7513o);
        C2186p.m8304a().m8323c(CommonParams.SOCKET_VIDEO_WIFI_PORT, false);
        mo1526d();
    }
}
