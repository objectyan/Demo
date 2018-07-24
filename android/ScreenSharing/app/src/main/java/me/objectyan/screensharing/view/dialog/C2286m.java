package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.carlife.R;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

@Deprecated
/* compiled from: NaviDialog */
/* renamed from: com.baidu.carlife.view.dialog.m */
public class C2286m extends BaseDialog {
    /* renamed from: e */
    private TextView f7475e;
    /* renamed from: f */
    private FrameLayout f7476f;
    /* renamed from: g */
    private FrameLayout f7477g;
    /* renamed from: h */
    private LinearLayout f7478h;
    /* renamed from: i */
    protected View f7479i;
    /* renamed from: j */
    private TextView f7480j;
    /* renamed from: k */
    private TextView f7481k;
    /* renamed from: l */
    private LinearLayout f7482l;
    /* renamed from: m */
    private TextView f7483m;
    /* renamed from: n */
    private C2302a f7484n;
    /* renamed from: o */
    private C2302a f7485o;
    /* renamed from: p */
    private boolean f7486p;
    /* renamed from: q */
    private boolean f7487q;
    /* renamed from: r */
    private C1443g f7488r;

    /* compiled from: NaviDialog */
    /* renamed from: com.baidu.carlife.view.dialog.m$1 */
    class C22991 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2286m f7553a;

        C22991(C2286m this$0) {
            this.f7553a = this$0;
        }

        public void onClick(View v) {
            if (this.f7553a.f7484n != null) {
                this.f7553a.f7484n.onClick();
            }
            this.f7553a.mo1526d();
        }
    }

    /* compiled from: NaviDialog */
    /* renamed from: com.baidu.carlife.view.dialog.m$2 */
    class C23002 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2286m f7554a;

        C23002(C2286m this$0) {
            this.f7554a = this$0;
        }

        public void onClick(View v) {
            if (this.f7554a.f7485o != null) {
                this.f7554a.f7485o.onClick();
            }
            this.f7554a.mo1526d();
        }
    }

    /* compiled from: NaviDialog */
    /* renamed from: com.baidu.carlife.view.dialog.m$3 */
    class C23013 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2286m f7555a;

        C23013(C2286m this$0) {
            this.f7555a = this$0;
        }

        public void onClick(View v) {
            if (this.f7555a.f7485o != null) {
                this.f7555a.f7485o.onClick();
            }
        }
    }

    /* compiled from: NaviDialog */
    /* renamed from: com.baidu.carlife.view.dialog.m$a */
    public interface C2302a {
        void onClick();
    }

    public C2286m(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected View mo1528a() {
        return LayoutInflater.from(this.c).inflate(R.layout.navi_dialog, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7475e = (TextView) findViewById(R.id.title_bar);
        this.f7478h = (LinearLayout) findViewById(R.id.top_content);
        this.f7476f = (FrameLayout) findViewById(R.id.content);
        this.f7482l = (LinearLayout) findViewById(R.id.layout_list);
        this.f7477g = (FrameLayout) findViewById(R.id.content_list);
        this.f7483m = (TextView) findViewById(R.id.title_bar_list);
        this.f7480j = (TextView) findViewById(R.id.first_btn);
        this.f7481k = (TextView) findViewById(R.id.second_btn);
        this.f7479i = findViewById(R.id.bottom_bar);
        this.f7480j.setOnClickListener(new C22991(this));
        this.f7481k.setOnClickListener(new C23002(this));
        this.f7486p = false;
        this.f7487q = false;
        mo1821l();
        this.f7475e.setVisibility(8);
        this.f7480j.setVisibility(8);
        this.f7481k.setVisibility(8);
    }

    /* renamed from: l */
    private void mo1821l() {
        this.f7475e.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_string_rg_comment_dialog_title));
        this.f7478h.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_dialog_top));
        this.f7480j.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_left));
        this.f7481k.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_right));
        this.f7480j.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_string_rg_comment_dialog_title));
        this.f7481k.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_string_rg_comment_dialog_title));
    }

    /* renamed from: b */
    public C2286m mo1810b(String text) {
        if (text == null) {
            this.f7475e.setVisibility(8);
            this.f7475e.setText("", BufferType.SPANNABLE);
        } else {
            this.f7475e.setVisibility(0);
            this.f7475e.setText(text, BufferType.SPANNABLE);
        }
        return this;
    }

    /* renamed from: a */
    public C2286m mo1803a(int resId) {
        return mo1810b(getContext().getString(resId));
    }

    /* renamed from: c */
    public C2286m mo1813c(String text) {
        if (text == null) {
            this.f7486p = false;
            this.f7480j.setText("", BufferType.SPANNABLE);
        } else {
            this.f7486p = true;
            this.f7480j.setText(text, BufferType.SPANNABLE);
        }
        setBtnVisible();
        return this;
    }

    /* renamed from: b */
    public C2286m mo1807b(int resId) {
        return mo1813c(getContext().getString(resId));
    }

    /* renamed from: i */
    public C2286m mo1630i() {
        this.f7480j.setTextColor(StyleManager.getDayColor(R.color.navi_dialog_high_light));
        return this;
    }

    /* renamed from: j */
    public C2286m mo1820j() {
        this.f7481k.setTextColor(StyleManager.getDayColor(R.color.navi_dialog_high_light));
        return this;
    }

    /* renamed from: d */
    public C2286m mo1815d(String text) {
        if (text == null) {
            this.f7487q = false;
            this.f7481k.setText("", BufferType.SPANNABLE);
        } else {
            this.f7487q = true;
            this.f7481k.setText(text, BufferType.SPANNABLE);
        }
        setBtnVisible();
        return this;
    }

    /* renamed from: c */
    public C2286m mo1812c(int resId) {
        return mo1815d(getContext().getString(resId));
    }

    /* renamed from: a */
    public C2286m mo1804a(View content) {
        this.f7476f.removeAllViews();
        this.f7476f.addView(content);
        return this;
    }

    /* renamed from: b */
    public C2286m mo1808b(View content) {
        this.f7478h.setBackgroundResource(StyleManager.getDayColor(R.drawable.transparent));
        this.f7482l.setVisibility(0);
        this.f7477g.removeAllViews();
        this.f7477g.addView(content);
        return this;
    }

    /* renamed from: a */
    public C2286m m8644a(View content, int parentViewWidth, int parentViewHeight) {
        this.f7476f.removeAllViews();
        LayoutParams layoutParams = (LayoutParams) this.f7476f.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = parentViewWidth;
            layoutParams.height = parentViewHeight;
            this.f7476f.setLayoutParams(layoutParams);
        }
        this.f7476f.addView(content);
        return this;
    }

    /* renamed from: a */
    public C2286m mo1805a(C2302a listener) {
        this.f7484n = listener;
        return this;
    }

    /* renamed from: b */
    public C2286m mo1809b(C2302a listener) {
        this.f7485o = listener;
        return this;
    }

    /* renamed from: k */
    public C2286m m8663k() {
        this.f7481k.setOnClickListener(new C23013(this));
        return this;
    }

    /* renamed from: d */
    public C2286m mo1814d(int width) {
        LayoutParams params = (LayoutParams) this.f7476f.getLayoutParams();
        params.width = width;
        this.f7476f.setLayoutParams(params);
        return this;
    }

    /* renamed from: e */
    public C2286m mo1816e(int height) {
        LayoutParams params = (LayoutParams) this.f7476f.getLayoutParams();
        params.height = height;
        this.f7476f.setLayoutParams(params);
        return this;
    }

    /* renamed from: a */
    public C2286m mo1806a(boolean enabled) {
        this.f7480j.setEnabled(enabled);
        return this;
    }

    /* renamed from: b */
    public C2286m mo1811b(boolean enabled) {
        this.f7481k.setEnabled(enabled);
        return this;
    }

    /* renamed from: e */
    public C2286m mo1817e(String text) {
        if (text == null) {
            this.f7483m.setVisibility(8);
            this.f7483m.setText("", BufferType.SPANNABLE);
        } else {
            this.f7483m.setVisibility(0);
            this.f7483m.setText(text, BufferType.SPANNABLE);
        }
        this.f7483m.setTextColor(StyleManager.getDayColor(R.color.navi_dialog_high_light));
        this.f7483m.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_dialog_top));
        return this;
    }

    private void setBtnVisible() {
        if (!this.f7486p) {
            this.f7480j.setVisibility(8);
            this.f7481k.setVisibility(8);
        } else if (this.f7487q) {
            this.f7480j.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_left));
            this.f7480j.setVisibility(0);
            this.f7481k.setVisibility(0);
        } else {
            this.f7480j.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
            this.f7480j.setVisibility(0);
            this.f7481k.setVisibility(8);
        }
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7488r == null) {
            this.f7488r = new C1443g(this.f7479i, 9);
            this.f7488r.m5300d(this.f7480j).m5300d(this.f7481k);
        }
        this.f7488r.m5244a(true);
        C1440d.m5251a().m5253a(this.f7488r);
    }

    /* renamed from: g */
    public void mo1527g() {
        C1440d.m5251a().m5263e();
    }
}
