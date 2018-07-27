package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navi.fragment.ContentFragment;

public class SettingVoiceFragment extends ContentFragment {
    /* renamed from: a */
    private C1443g f4826a;

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = (ViewGroup) LayoutInflater.from(mActivity).inflate(R.layout.frag_setting_voice, null);
        setCommonTitleBar(this.mContentView, getString(R.string.module_voice));
        m5812a();
        return this.mContentView;
    }

    /* renamed from: a */
    private void m5812a() {
        TextView temp = (TextView) this.mContentView.findViewById(R.id.temp);
        if (CommonParams.jr) {
            temp.setText(R.string.voice_domain_common_detail);
            this.mContentView.findViewById(R.id.temp1).setVisibility(0);
            this.mContentView.findViewById(R.id.temp2).setVisibility(0);
            return;
        }
        temp.setText(R.string.voice_domain_common_detail_closenavi);
        this.mContentView.findViewById(R.id.temp1).setVisibility(8);
        this.mContentView.findViewById(R.id.temp2).setVisibility(8);
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onInitFocusAreas() {
        if (this.f4826a == null) {
            this.f4826a = new C1443g(this.mContentView.findViewById(R.id.title_bar), 2);
            this.f4826a.m5300d(this.mContentView.findViewById(R.id.ib_left));
        }
        C1440d.m5251a().m5256b(this.f4826a);
        C1440d.m5251a().m5268h(this.f4826a);
    }
}
