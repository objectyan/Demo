package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p108b.C2380c.C2379b;
import com.baidu.carlife.wechat.p110e.C2434b;
import com.baidu.carlife.wechat.p110e.C2434b.C2430d;
import com.baidu.carlife.wechat.p110e.C2436c;
import com.baidu.carlife.wechat.p112f.C2454d;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.facebook.drawee.view.SimpleDraweeView;

public class WechatLogoutFragment extends C2461a {
    /* renamed from: b */
    private ImageButton f8115b;
    /* renamed from: c */
    private TextView f8116c;
    /* renamed from: d */
    private SimpleDraweeView f8117d;
    /* renamed from: e */
    private Button f8118e;
    /* renamed from: f */
    private C1953c f8119f;

    /* renamed from: com.baidu.carlife.wechat.fragment.WechatLogoutFragment$1 */
    class C24891 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ WechatLogoutFragment f8111a;

        C24891(WechatLogoutFragment this$0) {
            this.f8111a = this$0;
        }

        public void onClick(View v) {
            this.f8111a.back();
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.WechatLogoutFragment$2 */
    class C24902 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ WechatLogoutFragment f8112a;

        C24902(WechatLogoutFragment this$0) {
            this.f8112a = this$0;
        }

        public void onClick(View v) {
            this.f8112a.m9465a();
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.WechatLogoutFragment$3 */
    class C24913 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ WechatLogoutFragment f8113a;

        C24913(WechatLogoutFragment this$0) {
            this.f8113a = this$0;
        }

        public void onClick() {
            this.f8113a.m9468b();
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.WechatLogoutFragment$4 */
    class C24924 implements C2430d {
        /* renamed from: a */
        final /* synthetic */ WechatLogoutFragment f8114a;

        C24924(WechatLogoutFragment this$0) {
            this.f8114a = this$0;
        }

        /* renamed from: a */
        public void mo1870a() {
            C2380c.m9070a().m9072a(C2379b.LOGOUT);
            this.f8114a.showFragment(NaviFragmentManager.TYPE_WECHAT_LOGIN, null);
            C2454d.m9369a("已退出微信");
        }

        /* renamed from: b */
        public void mo1871b() {
            C2380c.m9070a().m9072a(C2379b.LOGOUT);
            this.f8114a.showFragment(NaviFragmentManager.TYPE_WECHAT_LOGIN, null);
            C2454d.m9369a("已退出微信");
        }
    }

    public /* bridge */ /* synthetic */ void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View rootView = inflater.inflate(C0965R.layout.fragment_wechat_logout, null);
        rootView.setOnClickListener(null);
        m9466a(rootView);
        return rootView;
    }

    protected void onInitView() {
    }

    /* renamed from: a */
    private void m9466a(View rootView) {
        this.f8115b = (ImageButton) rootView.findViewById(C0965R.id.fragment_wechat_logout_back);
        this.f8115b.setBackground(C2251b.m8527a(getActivity()));
        this.f8115b.setOnClickListener(new C24891(this));
        this.f8116c = (TextView) rootView.findViewById(C0965R.id.fragment_wechat_logout_name);
        this.f8116c.setText(C2380c.m9070a().m9085f().m9133c());
        this.f8117d = (SimpleDraweeView) rootView.findViewById(C0965R.id.fragment_wechat_logout_icon);
        this.f8117d.setImageURI(C2436c.m9320i() + C2380c.m9070a().m9085f().m9135d());
        this.f8118e = (Button) rootView.findViewById(C0965R.id.fragment_wechat_logout_button);
        this.f8118e.setOnClickListener(new C24902(this));
    }

    /* renamed from: a */
    private void m9465a() {
        this.f8119f = new C1953c(getActivity());
        this.f8119f.m7448c("注销");
        this.f8119f.m7444b("确定要注销微信账号么？");
        this.f8119f.m7457g(17);
        this.f8119f.m7451d("确定");
        this.f8119f.m7458q();
        this.f8119f.m7454e("取消");
        this.f8119f.m7438a(new C24913(this));
        showDialog(this.f8119f);
    }

    /* renamed from: b */
    private void m9468b() {
        Toast.makeText(getActivity(), "正在注销微信账号。。。", 0).show();
        C2434b.m9290a(new C24924(this));
    }
}
