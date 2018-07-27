package com.baidu.carlife.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1442f;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

public class ConnectHelpFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    private ScrollView f4247a;
    /* renamed from: b */
    private ImageButton f4248b;
    /* renamed from: c */
    private TextView f4249c;
    /* renamed from: d */
    private TextView f4250d;
    /* renamed from: e */
    private TextView f4251e;
    /* renamed from: f */
    private TextView f4252f;
    /* renamed from: g */
    private TextView f4253g;
    /* renamed from: h */
    private TextView f4254h;
    /* renamed from: i */
    private View f4255i;
    /* renamed from: j */
    private View f4256j;
    /* renamed from: k */
    private C1443g f4257k;
    /* renamed from: l */
    private C1442f f4258l;

    /* renamed from: com.baidu.carlife.fragment.ConnectHelpFragment$1 */
    class C14481 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ConnectHelpFragment f4244a;

        C14481(ConnectHelpFragment this$0) {
            this.f4244a = this$0;
        }

        public void onClick(View v) {
            this.f4244a.back(null);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.ConnectHelpFragment$2 */
    class C14492 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ConnectHelpFragment f4245a;

        C14492(ConnectHelpFragment this$0) {
            this.f4245a = this$0;
        }

        public void onClick(View v) {
            try {
                this.f4245a.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
            } catch (Exception e) {
                LogUtil.d("Framework", "open adb setting page failed!");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.ConnectHelpFragment$3 */
    class C14503 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ConnectHelpFragment f4246a;

        C14503(ConnectHelpFragment this$0) {
            this.f4246a = this$0;
        }

        public void onClick(View v) {
            this.f4246a.showFragment(NaviFragmentManager.TYPE_AUTHORIZATION_REQUEST_HELP, null);
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(R.layout.frag_connect_help, null);
        this.f4247a = (ScrollView) this.mContentView.findViewById(R.id.scroll_view);
        this.f4247a.setOverScrollMode(2);
        this.f4248b = (ImageButton) this.mContentView.findViewById(R.id.ib_left);
        this.f4249c = (TextView) this.mContentView.findViewById(R.id.tv_title);
        this.f4250d = (TextView) this.mContentView.findViewById(R.id.goto_setting);
        this.f4251e = (TextView) this.mContentView.findViewById(R.id.check_title);
        this.f4252f = (TextView) this.mContentView.findViewById(R.id.check_content);
        this.f4253g = (TextView) this.mContentView.findViewById(R.id.reboot);
        this.f4254h = (TextView) this.mContentView.findViewById(R.id.authorization_request);
        this.f4255i = this.mContentView.findViewById(R.id.goto_setting_layout);
        this.f4256j = this.mContentView.findViewById(R.id.authorization_request_layout);
        this.f4248b.setOnClickListener(new C14481(this));
        this.f4249c.setText(R.string.connectguide_setting_title);
        this.f4250d.setText(R.string.connectguide_setting_goto_setting);
        this.f4250d.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.iv_voice_arrow, 0);
        this.f4255i.setOnClickListener(new C14492(this));
        this.f4256j.setOnClickListener(new C14503(this));
        this.f4251e.setText(R.string.connectguide_setting_check_title);
        this.f4252f.setText(R.string.connectguide_setting_check_content);
        this.f4253g.setText(R.string.connectguide_setting_reboot);
        this.f4254h.setText(R.string.connectguide_setting_authorization_request);
        this.f4254h.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.iv_voice_arrow, 0);
        return this.mContentView;
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

    public void onClick(View v) {
        v.getId();
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4257k == null) {
                this.f4257k = new C1443g(this.mContentView.findViewById(R.id.common_title_bar), 2);
                this.f4257k.m5300d(this.mContentView.findViewById(R.id.ib_left));
            }
            if (this.f4258l == null) {
                this.f4258l = new C1442f(this.f4247a, 4);
            }
            C1440d focusManager = C1440d.m5251a();
            focusManager.m5256b(this.f4257k, this.f4258l);
            focusManager.m5268h(this.f4257k);
        }
    }

    public void driving() {
        LogUtil.d("yftech", "CarModeOfflineDataFragment driving");
        if (C1343b.m4932a().m4935b()) {
            back();
            back();
        }
    }
}
