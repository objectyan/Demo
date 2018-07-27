package com.baidu.carlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.logic.C1872t;
import com.baidu.carlife.model.C1934l;
import com.baidu.carlife.model.C1934l.C1933a;
import com.baidu.carlife.p054k.p055a.C1635h;
import com.baidu.carlife.p054k.p055a.C1635h.C1489c;
import com.baidu.carlife.p054k.p055a.C1635h.C1633a;
import com.baidu.carlife.p054k.p055a.C1635h.C1634b;
import com.baidu.carlife.util.C2188r;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class SkinItemView extends RelativeLayout implements C1489c {
    /* renamed from: a */
    private C2235a f7235a;
    /* renamed from: b */
    private DecimalFormat f7236b;
    /* renamed from: c */
    private C1872t f7237c;
    /* renamed from: d */
    private C1934l f7238d;
    /* renamed from: e */
    private C1635h f7239e;
    /* renamed from: f */
    private OnClickListener f7240f;
    /* renamed from: g */
    private OnClickListener f7241g;

    /* renamed from: com.baidu.carlife.view.SkinItemView$1 */
    class C22321 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SkinItemView f7223a;

        C22321(SkinItemView this$0) {
            this.f7223a = this$0;
        }

        public void onClick(View v) {
            if (!this.f7223a.f7237c.m7159c().equals(this.f7223a.f7238d.f6093h)) {
                switch (this.f7223a.f7238d.f6095j) {
                    case 0:
                        this.f7223a.f7237c.m7161d();
                        StatisticManager.onEvent(StatisticConstants.HOME_MY_SKIN_WHICH, StatisticConstants.HOME_MY_SKIN_WHICH_DEFAULT);
                        return;
                    case 1:
                        InputStream rawIn = null;
                        try {
                            rawIn = this.f7223a.getResources().getAssets().open(this.f7223a.f7238d.f6093h);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        this.f7223a.f7237c.m7153a(rawIn, this.f7223a.f7238d.f6093h, this.f7223a.f7238d.f6090e);
                        StatisticManager.onEvent(StatisticConstants.HOME_MY_SKIN_WHICH, StatisticConstants.HOME_MY_SKIN_WHICH_NATIVE);
                        return;
                    case 2:
                        if (this.f7223a.f7238d.f6097l == C1933a.DOWNLOAD) {
                            this.f7223a.m8473a();
                            this.f7223a.f7239e = new C1635h(this.f7223a.f7238d.f6092g, this.f7223a.f7238d.f6093h, this.f7223a);
                            this.f7223a.f7239e.m5924e();
                        } else if (this.f7223a.f7238d.f6097l == C1933a.APPLY) {
                            this.f7223a.f7237c.m7154a(this.f7223a.f7238d.f6093h, this.f7223a.f7238d.f6090e);
                        }
                        StatisticManager.onEvent(StatisticConstants.HOME_MY_SKIN_WHICH, StatisticConstants.HOME_MY_SKIN_WHICH_SERVER);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.view.SkinItemView$2 */
    class C22332 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SkinItemView f7224a;

        C22332(SkinItemView this$0) {
            this.f7224a = this$0;
        }

        public void onClick(View v) {
            if (this.f7224a.f7239e != null) {
                this.f7224a.m8477c();
                this.f7224a.f7239e.m5923d();
                this.f7224a.f7239e.m5919a();
            }
        }
    }

    /* renamed from: com.baidu.carlife.view.SkinItemView$a */
    private class C2235a {
        /* renamed from: a */
        MultiImageView f7227a;
        /* renamed from: b */
        View f7228b;
        /* renamed from: c */
        CircleProgressBarView f7229c;
        /* renamed from: d */
        TriangleStateView f7230d;
        /* renamed from: e */
        ImageView f7231e;
        /* renamed from: f */
        TextView f7232f;
        /* renamed from: g */
        TextView f7233g;
        /* renamed from: h */
        final /* synthetic */ SkinItemView f7234h;

        private C2235a(SkinItemView skinItemView) {
            this.f7234h = skinItemView;
        }
    }

    public SkinItemView(Context context) {
        this(context, null);
    }

    public SkinItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7240f = new C22321(this);
        this.f7241g = new C22332(this);
        m8470a(context);
        this.f7237c = C1872t.m7136a();
        this.f7236b = new DecimalFormat("0.0");
    }

    /* renamed from: a */
    private void m8470a(Context context) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.home_my_skin_item, this, true);
        convertView.setOnClickListener(this.f7240f);
        this.f7235a = new C2235a();
        this.f7235a.f7227a = (MultiImageView) convertView.findViewById(R.id.image_iv);
        this.f7235a.f7228b = convertView.findViewById(R.id.loading_layer);
        this.f7235a.f7229c = (CircleProgressBarView) convertView.findViewById(R.id.progress_view);
        this.f7235a.f7230d = (TriangleStateView) convertView.findViewById(R.id.state_bg_iv);
        this.f7235a.f7231e = (ImageView) convertView.findViewById(R.id.state_iv);
        this.f7235a.f7232f = (TextView) convertView.findViewById(R.id.name_tv);
        this.f7235a.f7233g = (TextView) convertView.findViewById(R.id.size_tv);
    }

    public void setData(C1934l model) {
        if (this.f7239e != null) {
            this.f7239e.m5919a();
        }
        this.f7238d = model;
        switch (model.f6095j) {
            case 0:
            case 1:
                this.f7235a.f7227a.setDefaultDrawableResId(model.f6096k);
                this.f7235a.f7227a.setImageUrl(null);
                this.f7235a.f7228b.setVisibility(8);
                this.f7235a.f7232f.setText(model.f6089d);
                this.f7235a.f7233g.setVisibility(8);
                this.f7235a.f7230d.setVisibility(8);
                this.f7235a.f7231e.setVisibility(8);
                break;
            case 2:
                this.f7235a.f7227a.setDefaultDrawable(C2188r.m8331b(R.drawable.home_ic_my_skin_default));
                this.f7235a.f7227a.setImageUrl(model.f6091f);
                this.f7235a.f7232f.setText(model.f6089d);
                this.f7235a.f7233g.setText(this.f7236b.format((double) ((((float) model.f6094i) / 1000.0f) / 1000.0f)) + "M");
                if (this.f7237c.m7155a(model.f6093h)) {
                    model.f6097l = C1933a.APPLY;
                }
                switch (model.f6097l) {
                    case APPLY:
                        m8476b();
                        break;
                    case DOWNLOAD:
                        m8477c();
                        break;
                    case DOWNLOADING:
                        m8473a();
                        if (this.f7239e != null) {
                            this.f7239e.m5921a((C1489c) this);
                        }
                        this.f7235a.f7229c.setOnClickListener(this.f7241g);
                        break;
                    default:
                        break;
                }
        }
        this.f7235a.f7227a.setBackground(C2188r.m8331b(R.drawable.home_bg_skin_image_selector));
        this.f7235a.f7232f.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_content));
        this.f7235a.f7233g.setTextColor(C2188r.m8328a((int) R.color.cl_text_a2_content));
        if (C1872t.m7136a().m7159c().equals(model.f6093h)) {
            this.f7235a.f7227a.setSelected(true);
            this.f7235a.f7230d.setVisibility(0);
            this.f7235a.f7230d.setBgColor(C2188r.m8328a((int) R.color.cl_btn_b_tab_select));
            this.f7235a.f7231e.setVisibility(0);
            this.f7235a.f7231e.setImageResource(R.drawable.home_ic_my_skin_selected);
            return;
        }
        this.f7235a.f7227a.setSelected(false);
    }

    /* renamed from: a */
    public void m8473a() {
        if (this.f7235a != null) {
            this.f7238d.f6097l = C1933a.DOWNLOADING;
            this.f7235a.f7230d.setVisibility(8);
            this.f7235a.f7231e.setVisibility(8);
            this.f7235a.f7233g.setVisibility(0);
            this.f7235a.f7228b.setVisibility(0);
        }
    }

    /* renamed from: b */
    public void m8476b() {
        if (this.f7235a != null) {
            this.f7238d.f6097l = C1933a.APPLY;
            this.f7235a.f7230d.setVisibility(8);
            this.f7235a.f7231e.setVisibility(8);
            this.f7235a.f7233g.setVisibility(8);
            this.f7235a.f7228b.setVisibility(8);
        }
    }

    /* renamed from: c */
    public void m8477c() {
        if (this.f7235a != null) {
            this.f7238d.f6097l = C1933a.DOWNLOAD;
            this.f7235a.f7230d.setVisibility(0);
            this.f7235a.f7230d.setBgColor(C2188r.m8328a((int) R.color.cl_other_g_bg));
            this.f7235a.f7231e.setVisibility(0);
            this.f7235a.f7231e.setImageResource(R.drawable.home_ic_my_skin_download);
            this.f7235a.f7233g.setVisibility(0);
            this.f7235a.f7228b.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo1561a(C1634b state, C1633a errorCode) {
        switch (state) {
            case CANCEL:
            case ERROR:
                m8477c();
                return;
            case SUCESS:
                if (this.f7239e != null && this.f7237c != null) {
                    this.f7237c.m7152a(this.f7239e.m5922b(), this.f7238d.f6090e);
                    m8476b();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo1560a(long total, int progress) {
        m8473a();
        if (this.f7235a != null) {
            this.f7235a.f7229c.setProgress(progress);
        }
    }
}
