package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navi.style.StyleManager;

/* compiled from: CommonProgressDialog */
/* renamed from: com.baidu.carlife.view.dialog.e */
public class C2278e extends BaseDialog {
    /* renamed from: e */
    private TextView f7454e;
    /* renamed from: f */
    private ImageView f7455f;
    /* renamed from: g */
    private ImageView f7456g;
    /* renamed from: h */
    private Animation f7457h;
    /* renamed from: i */
    private C0672b f7458i = null;
    /* renamed from: j */
    private C1443g f7459j;

    /* compiled from: CommonProgressDialog */
    /* renamed from: com.baidu.carlife.view.dialog.e$1 */
    class C22771 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2278e f7453a;

        C22771(C2278e this$0) {
            this.f7453a = this$0;
        }

        public void onClick(View v) {
            if (this.f7453a.f7458i != null) {
                this.f7453a.f7458i.onClick();
            }
            this.f7453a.mo1526d();
        }
    }

    public C2278e(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo1525a(C1277e listener) {
        super.mo1525a(listener);
        this.f7456g.startAnimation(this.f7457h);
    }

    /* renamed from: d */
    public void mo1526d() {
        super.mo1526d();
        this.f7456g.clearAnimation();
    }

    /* renamed from: b */
    public C2278e m8622b(String string) {
        this.f7454e.setText(string);
        return this;
    }

    public void setOnCancelListener(C0672b listener) {
        this.f7458i = listener;
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7459j == null) {
            this.f7459j = new C1443g(findViewById(C0965R.id.common_progress_dialog), 12);
            this.f7459j.m5300d(findViewById(C0965R.id.iv_dialog_close));
        }
        C1440d.m5251a().m5259c(this.f7459j);
    }

    /* renamed from: g */
    public void mo1527g() {
        C1440d.m5251a().m5258c();
    }

    /* renamed from: a */
    protected View mo1528a() {
        return LayoutInflater.from(this.c).inflate(C0965R.layout.common_progress_dialog_animation, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7454e = (TextView) findViewById(C0965R.id.progress_tip_text);
        this.f7455f = (ImageView) findViewById(C0965R.id.iv_dialog_close);
        this.f7456g = (ImageView) findViewById(C0965R.id.progress_cycle_normal);
        this.f7454e.setTextColor(StyleManager.getDayColor(C0965R.color.bnav_loading_text_color));
        this.f7457h = AnimationUtils.loadAnimation(this.c, C0965R.anim.bnav_anim_rotating);
        this.f7455f.setOnClickListener(new C22771(this));
    }
}
