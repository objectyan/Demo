package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.logic.C1710a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2188r;
import com.baidu.navi.fragment.ContentFragment;

public class SettingAboutFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    private Button f4772a;
    /* renamed from: b */
    private Button f4773b;
    /* renamed from: c */
    private TextView f4774c;
    /* renamed from: d */
    private C1443g f4775d;
    /* renamed from: e */
    private C1443g f4776e;

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(C0965R.layout.frag_setting_about, null);
        setCommonTitleBar(this.mContentView, getString(C0965R.string.module_setting_about));
        this.f4772a = (Button) this.mContentView.findViewById(C0965R.id.btn_check_version);
        if (C1253f.jc.equals(C1253f.jt)) {
            this.f4772a.setVisibility(8);
        } else {
            this.f4772a.setVisibility(0);
            this.f4772a.setOnClickListener(this);
        }
        this.f4773b = (Button) this.mContentView.findViewById(C0965R.id.btn_service_terms);
        this.f4773b.setOnClickListener(this);
        this.f4774c = (TextView) this.mContentView.findViewById(C0965R.id.tv_version_code);
        String temp = getString(C0965R.string.version_code_prefix) + C1251e.m4373g();
        if (!"".equals(C1253f.jq)) {
            temp = temp + " (" + C1253f.jq + ")";
        }
        this.f4774c.setText(temp);
        return this.mContentView;
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
        this.f4774c.setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a5_content));
        this.f4772a.setBackground(C2188r.m8331b(C0965R.drawable.com_bg_btn_a_selector));
        this.f4772a.setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a5_bgtext));
        this.f4773b.setBackground(C2188r.m8331b(C0965R.drawable.com_bg_btn_a_selector));
        this.f4773b.setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a5_bgtext));
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.btn_check_version:
                C1710a.m6207a().m6255a(false);
                return;
            case C0965R.id.btn_service_terms:
                showFragment(540, null);
                return;
            default:
                return;
        }
    }

    public void driving() {
        C1260i.m4435b("yftech", "SettingAboutFragment driving");
        getNaviFragmentManager().back();
        getNaviFragmentManager().back();
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4775d == null) {
                this.f4775d = new C1443g(this.mContentView.findViewById(C0965R.id.title_bar), 2);
                this.f4775d.m5300d(this.mContentView.findViewById(C0965R.id.ib_left));
            }
            if (this.f4776e == null) {
                this.f4776e = new C1443g(this.mContentView, 4);
                if (!C1253f.jc.equals(C1253f.jt)) {
                    this.f4776e.m5300d(this.f4772a);
                }
                this.f4776e.m5300d(this.f4773b);
            }
            C1440d.m5251a().m5256b(this.f4775d, this.f4776e);
            C1440d.m5251a().m5268h(this.f4775d);
        }
    }
}
