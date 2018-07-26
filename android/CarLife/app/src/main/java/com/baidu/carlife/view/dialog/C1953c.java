package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0772c;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;

/* compiled from: CommonDialog */
/* renamed from: com.baidu.carlife.view.dialog.c */
public class C1953c extends BaseDialog {
    /* renamed from: e */
    private static final int f6208e = 1;
    /* renamed from: f */
    private static final int f6209f = 2;
    /* renamed from: g */
    private static final int f6210g = 0;
    /* renamed from: n */
    public static final int f6211n = 1;
    /* renamed from: o */
    public static final int f6212o = 2;
    /* renamed from: h */
    private int f6213h = 0;
    /* renamed from: i */
    private int f6214i;
    /* renamed from: j */
    private int f6215j = 5;
    /* renamed from: k */
    private View f6216k;
    /* renamed from: l */
    private RelativeLayout f6217l;
    /* renamed from: m */
    private TextView f6218m;
    /* renamed from: p */
    protected Handler f6219p = new C22701(this);
    /* renamed from: q */
    private TextView f6220q;
    /* renamed from: r */
    private TextView f6221r;
    /* renamed from: s */
    private TextView f6222s;
    /* renamed from: t */
    private View f6223t;
    /* renamed from: u */
    private ImageButton f6224u;
    /* renamed from: v */
    private C0672b f6225v;
    /* renamed from: w */
    private C0672b f6226w;
    /* renamed from: x */
    private C0772c f6227x;
    /* renamed from: y */
    private boolean f6228y;

    /* compiled from: CommonDialog */
    /* renamed from: com.baidu.carlife.view.dialog.c$1 */
    class C22701 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1953c f7440a;

        C22701(C1953c this$0) {
            this.f7440a = this$0;
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    this.f7440a.f6214i = this.f7440a.f6214i - 1;
                    this.f7440a.setTimeText();
                    return;
                case 2:
                    this.f7440a.mo1526d();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: CommonDialog */
    /* renamed from: com.baidu.carlife.view.dialog.c$2 */
    class C22712 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1953c f7441a;

        C22712(C1953c this$0) {
            this.f7441a = this$0;
        }

        public void onClick(View v) {
            if (this.f7441a.f6225v != null) {
                this.f7441a.f6225v.onClick();
            }
            this.f7441a.mo1526d();
        }
    }

    /* compiled from: CommonDialog */
    /* renamed from: com.baidu.carlife.view.dialog.c$3 */
    class C22723 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1953c f7442a;

        C22723(C1953c this$0) {
            this.f7442a = this$0;
        }

        public void onClick(View v) {
            if (this.f7442a.f6226w != null) {
                this.f7442a.f6226w.onClick();
            }
            this.f7442a.mo1526d();
        }
    }

    public C1953c(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected View mo1528a() {
        return LayoutInflater.from(this.c).inflate(C0965R.layout.common_dialog_center, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f6217l = (RelativeLayout) findViewById(C0965R.id.dialog_content);
        this.f6218m = (TextView) findViewById(C0965R.id.dialog_title);
        this.f6220q = (TextView) findViewById(C0965R.id.content_msg);
        this.f6221r = (TextView) findViewById(C0965R.id.first_btn);
        this.f6222s = (TextView) findViewById(C0965R.id.second_btn);
        this.f6223t = findViewById(C0965R.id.temp1);
        this.f6224u = (ImageButton) findViewById(C0965R.id.dialog_title_bnt_right);
        this.f6221r.setOnClickListener(new C22712(this));
        this.f6222s.setOnClickListener(new C22723(this));
    }

    /* renamed from: b */
    public C1953c m7444b(String text) {
        if (text == null) {
            this.f6220q.setVisibility(8);
            this.f6220q.setText("", BufferType.SPANNABLE);
        } else {
            this.f6220q.setVisibility(0);
            this.f6220q.setText(text, BufferType.SPANNABLE);
        }
        return this;
    }

    /* renamed from: a */
    public C1953c m7435a(int resId) {
        return m7444b(this.c.getString(resId));
    }

    /* renamed from: c */
    public C1953c m7448c(String title) {
        this.f6218m.setText(title);
        this.f6218m.setVisibility(0);
        return this;
    }

    /* renamed from: b */
    public C1953c m7442b(int resId) {
        return m7448c(this.c.getString(resId));
    }

    /* renamed from: d */
    public C1953c m7451d(String text) {
        this.f6221r.setText(text);
        this.f6221r.setVisibility(0);
        return this;
    }

    /* renamed from: c */
    public C1953c m7447c(int resId) {
        return m7451d(this.c.getString(resId));
    }

    /* renamed from: e */
    public C1953c m7454e(String text) {
        this.f6222s.setText(text);
        this.f6222s.setVisibility(0);
        this.f6223t.setVisibility(0);
        return this;
    }

    /* renamed from: d */
    public C1953c m7450d(int resId) {
        return m7454e(this.c.getString(resId));
    }

    /* renamed from: q */
    public C1953c m7458q() {
        this.f6221r.setTextColor(this.c.getResources().getColor(C0965R.color.cl_other_c_btn_dialog));
        return this;
    }

    /* renamed from: r */
    public C1953c m7459r() {
        this.f6222s.setTextColor(this.c.getResources().getColor(C0965R.color.cl_other_c_btn_dialog));
        return this;
    }

    /* renamed from: a */
    public C1953c m7440a(boolean enabled) {
        this.f6221r.setEnabled(enabled);
        return this;
    }

    /* renamed from: b */
    public C1953c m7445b(boolean enabled) {
        this.f6222s.setEnabled(enabled);
        return this;
    }

    /* renamed from: a */
    public C1953c m7438a(C0672b listener) {
        this.f6225v = listener;
        return this;
    }

    /* renamed from: b */
    public C1953c m7443b(C0672b listener) {
        this.f6226w = listener;
        return this;
    }

    /* renamed from: a */
    public C1953c m7439a(C0772c listener) {
        this.f6227x = listener;
        return this;
    }

    public TextView getContentView() {
        return this.f6220q;
    }

    public ImageButton getTitlebntRight() {
        return this.f6224u;
    }

    public View getDiyContentView() {
        return this.f6216k;
    }

    /* renamed from: a */
    public C1953c m7437a(View contentView) {
        this.f6217l.removeAllViews();
        contentView.setLayoutParams(new LayoutParams(-1, -2));
        this.f6217l.addView(contentView);
        this.f6216k = contentView;
        return this;
    }

    /* renamed from: e */
    public C1953c m7453e(int layoutId) {
        this.f6217l.removeAllViews();
        this.f6216k = View.inflate(this.c, layoutId, this.f6217l);
        return this;
    }

    /* renamed from: f */
    public C1953c m7455f(int timeFlag) {
        this.f6213h = timeFlag;
        this.f6215j = 5;
        return this;
    }

    /* renamed from: a */
    public C1953c m7436a(int timeFlag, int time) {
        this.f6213h = timeFlag;
        this.f6215j = time;
        return this;
    }

    /* renamed from: g */
    public C1953c m7457g(int gravity) {
        this.f6220q.setGravity(gravity);
        return this;
    }

    /* renamed from: a */
    public void mo1525a(C1277e listener) {
        super.mo1525a(listener);
        this.f6214i = this.f6215j;
        setTimeText();
    }

    /* renamed from: d */
    public void mo1526d() {
        super.mo1526d();
        this.f6219p.removeMessages(1);
    }

    private void setTimeText() {
        TextView tv = null;
        if (this.f6213h == 1) {
            tv = this.f6221r;
        } else if (this.f6213h == 2) {
            tv = this.f6222s;
        }
        if (tv != null) {
            String text = tv.getText().toString();
            if (text.lastIndexOf("(") > 0) {
                tv.setText(text.replaceAll("[(](-)?\\d+[s][)]", "(" + this.f6214i + "s)"));
            } else {
                tv.setText(text + "(" + this.f6214i + "s)");
            }
            if (this.f6214i > 0) {
                this.f6219p.sendEmptyMessageDelayed(1, 1000);
            } else if (this.f6227x != null) {
                this.f6227x.onCountDown(this.f6214i);
            } else {
                this.f6219p.sendEmptyMessageDelayed(2, 1000);
            }
        }
    }

    public TextView getmFirstBtn() {
        return this.f6221r;
    }

    public TextView getmSecondBtn() {
        return this.f6222s;
    }

    /* renamed from: f */
    public void mo1530f() {
        C1443g mFocusDialogDown = new C1443g(findViewById(C0965R.id.bottom_bar), 11);
        mFocusDialogDown.m5300d(this.f6221r).m5300d(this.f6222s);
        mFocusDialogDown.m5244a(true);
        mFocusDialogDown.m5298b(true);
        mFocusDialogDown.m5297b(this.f6228y ? this.f6221r : this.f6222s);
        C1440d.m5251a().m5253a(mFocusDialogDown);
    }

    /* renamed from: c */
    public C1953c m7449c(boolean mIsDefaultFocusFirstView) {
        this.f6228y = mIsDefaultFocusFirstView;
        return this;
    }
}
