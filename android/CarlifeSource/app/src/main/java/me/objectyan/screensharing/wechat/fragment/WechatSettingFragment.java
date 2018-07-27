package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.carlife.wechat.p113g.C2498b;
import com.baidu.navi.fragment.NaviFragmentManager;

public class WechatSettingFragment extends C2461a implements OnClickListener, OnCheckedChangeListener {
    /* renamed from: b */
    private LinearLayout f8121b;
    /* renamed from: c */
    private CheckBox f8122c;
    /* renamed from: d */
    private LinearLayout f8123d;
    /* renamed from: e */
    private CheckBox f8124e;
    /* renamed from: f */
    private LinearLayout f8125f;
    /* renamed from: g */
    private ImageButton f8126g;

    /* renamed from: com.baidu.carlife.wechat.fragment.WechatSettingFragment$1 */
    class C24931 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ WechatSettingFragment f8120a;

        C24931(WechatSettingFragment this$0) {
            this.f8120a = this$0;
        }

        public void onClick(View v) {
            this.f8120a.back();
        }
    }

    public /* bridge */ /* synthetic */ void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View rootView = inflater.inflate(C0965R.layout.fragment_setting, null);
        rootView.setOnClickListener(null);
        m9470a(rootView);
        return rootView;
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onInitView() {
    }

    /* renamed from: a */
    public void mo1856a() {
        this.f8122c.setChecked(C2498b.m9487c());
        this.f8124e.setChecked(C2498b.m9485b());
    }

    /* renamed from: a */
    private void m9470a(View rootView) {
        this.f8126g = (ImageButton) rootView.findViewById(C0965R.id.fragment_setting_back);
        this.f8126g.setBackground(C2251b.m8527a(getActivity()));
        this.f8126g.setOnClickListener(new C24931(this));
        this.f8121b = (LinearLayout) rootView.findViewById(C0965R.id.setting_layout_auto_broadcast);
        this.f8121b.setOnClickListener(this);
        this.f8122c = (CheckBox) rootView.findViewById(C0965R.id.setting_checkbox_auto_broadcast);
        this.f8122c.setOnCheckedChangeListener(this);
        this.f8123d = (LinearLayout) rootView.findViewById(C0965R.id.setting_layout_close_room_msg);
        this.f8123d.setOnClickListener(this);
        this.f8124e = (CheckBox) rootView.findViewById(C0965R.id.setting_checkbox_close_room_msg);
        this.f8124e.setOnCheckedChangeListener(this);
        this.f8125f = (LinearLayout) rootView.findViewById(C0965R.id.setting_layout_blacklist);
        this.f8125f.setOnClickListener(this);
        mo1856a();
    }

    public void onClick(View v) {
        boolean z = true;
        CheckBox checkBox;
        if (v.getId() == C0965R.id.setting_layout_auto_broadcast) {
            checkBox = this.f8122c;
            if (this.f8122c.isChecked()) {
                z = false;
            }
            checkBox.setChecked(z);
        } else if (v.getId() == C0965R.id.setting_layout_close_room_msg) {
            checkBox = this.f8124e;
            if (this.f8124e.isChecked()) {
                z = false;
            }
            checkBox.setChecked(z);
        } else if (v.getId() == C0965R.id.setting_layout_blacklist) {
            showFragment(NaviFragmentManager.TYPE_WECHAT_BLACKLIST, null);
        }
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == C0965R.id.setting_checkbox_auto_broadcast) {
            C2498b.m9486c(isChecked);
        } else if (buttonView.getId() == C0965R.id.setting_checkbox_close_room_msg) {
            C2498b.m9484b(isChecked);
        }
    }
}
