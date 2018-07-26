package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.p069b.C1190a;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.carlife.wechat.p105a.p106a.C2359b;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p108b.C2398k;
import com.baidu.carlife.wechat.p110e.C2434b;
import com.baidu.carlife.wechat.p110e.C2434b.C2429c;
import com.baidu.carlife.wechat.p110e.C2434b.C2431e;
import com.baidu.carlife.wechat.p110e.C2434b.C2432h;
import com.baidu.carlife.wechat.p110e.C2434b.C2433i;
import com.baidu.carlife.wechat.p110e.C2436c;
import com.baidu.carlife.wechat.p112f.C2454d;
import com.baidu.carlife.wechat.p113g.C2497a;
import com.baidu.carlife.wechat.p113g.C2499c;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

public class WechatLoginFragment extends C2461a implements OnClickListener {
    /* renamed from: b */
    private ImageView f8100b;
    /* renamed from: c */
    private TextView f8101c;
    /* renamed from: d */
    private ImageView f8102d;
    /* renamed from: e */
    private TextView f8103e;
    /* renamed from: f */
    private TextView f8104f;
    /* renamed from: g */
    private ImageButton f8105g;
    /* renamed from: h */
    private boolean f8106h = true;
    /* renamed from: i */
    private int f8107i = 0;
    /* renamed from: j */
    private int f8108j = 0;
    /* renamed from: k */
    private int f8109k = 0;
    /* renamed from: l */
    private int f8110l = 0;

    /* renamed from: com.baidu.carlife.wechat.fragment.WechatLoginFragment$1 */
    class C24851 implements C2432h {
        /* renamed from: a */
        final /* synthetic */ WechatLoginFragment f8094a;

        C24851(WechatLoginFragment this$0) {
            this.f8094a = this$0;
        }

        /* renamed from: a */
        public void mo1858a(String uuid) {
            this.f8094a.f8107i = 0;
            this.f8094a.m9436a(uuid);
            float density = C2499c.m9502c();
            this.f8094a.f8100b.setImageBitmap(C2499c.m9491a(C2499c.m9492a(C2436c.m9311b(uuid), (int) (116.0f * density), (int) (116.0f * density)), 0.8f));
        }

        /* renamed from: b */
        public void mo1859b(String reason) {
            if (this.f8094a.f8107i < 3) {
                this.f8094a.m9443c();
                return;
            }
            this.f8094a.m9446c("获取二维码失败");
            this.f8094a.f8101c.setText("获取失败，请刷新或检查网络后重试");
            this.f8094a.f8102d.setVisibility(0);
            this.f8094a.f8103e.setText("微信");
            this.f8094a.f8104f.setText(C1190a.m4068d());
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.WechatLoginFragment$4 */
    class C24884 implements C2433i {
        /* renamed from: a */
        final /* synthetic */ WechatLoginFragment f8099a;

        C24884(WechatLoginFragment this$0) {
            this.f8099a = this$0;
        }

        /* renamed from: a */
        public void mo1868a() {
            StatisticManager.onEvent(StatisticConstants.HOME_WECHAT_002);
            this.f8099a.m9452e();
            this.f8099a.showFragment(NaviFragmentManager.TYPE_WECHAT_MAIN, null);
            this.f8099a.removeWeChatFragmentFromStack();
        }

        /* renamed from: a */
        public void mo1869a(String reason) {
            if (this.f8099a.f8110l < 3) {
                this.f8099a.m9449d();
                return;
            }
            this.f8099a.f8110l = 0;
            C2454d.m9369a("数据加载失败");
            this.f8099a.m9446c("数据加载失败，请重新登录");
            this.f8099a.m9439b();
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
        View rootView = inflater.inflate(C0965R.layout.fragment_login, null);
        rootView.setOnClickListener(null);
        m9434a(rootView);
        return rootView;
    }

    protected void onInitView() {
    }

    /* renamed from: a */
    private void m9434a(View rootView) {
        this.f8105g = (ImageButton) rootView.findViewById(C0965R.id.fragment_login_back);
        this.f8105g.setBackground(C2251b.m8527a(getActivity()));
        this.f8105g.setOnClickListener(this);
        this.f8100b = (ImageView) rootView.findViewById(C0965R.id.fragment_login_img);
        this.f8102d = (ImageView) rootView.findViewById(C0965R.id.fragment_login_imgv_refresh);
        this.f8102d.setOnClickListener(this);
        this.f8101c = (TextView) rootView.findViewById(C0965R.id.fragment_login_tips);
        this.f8103e = (TextView) rootView.findViewById(C0965R.id.fragment_login_title);
        this.f8104f = (TextView) rootView.findViewById(C0965R.id.fragment_login_title_desc);
    }

    public void onResume() {
        super.onResume();
        if (this.f8106h) {
            m9439b();
            this.f8106h = !this.f8106h;
        }
    }

    public void onClick(View v) {
        if (v.getId() == C0965R.id.fragment_login_back) {
            if (this.f8103e.getText().toString().equals("微信")) {
                removeWeChatFragmentFromStack();
                back();
                return;
            }
            m9439b();
        } else if (v.getId() == C0965R.id.fragment_login_imgv_refresh) {
            mo1856a();
        }
    }

    public boolean onBackPressed() {
        removeWeChatFragmentFromStack();
        back();
        return true;
    }

    /* renamed from: a */
    public void mo1856a() {
        if (C2359b.m8969a(C1157a.m3876a())) {
            m9439b();
            return;
        }
        Toast.makeText(getActivity(), "网络连接异常，请检查您的网络连接", 0).show();
        C2454d.m9369a("网络连接异常");
    }

    /* renamed from: b */
    private void m9439b() {
        C2434b.m9300a(true);
        m9452e();
        this.f8107i = 0;
        m9443c();
    }

    /* renamed from: c */
    private void m9443c() {
        this.f8107i++;
        C2372c.m9030c("load UUID... times=" + this.f8107i);
        C2380c.m9070a().m9079b();
        C2398k.m9160a().m9191e();
        this.f8100b.setImageBitmap(null);
        this.f8101c.setText(C0965R.string.login_qrcode_tips);
        this.f8102d.setVisibility(8);
        this.f8103e.setText("微信");
        this.f8104f.setText(C1190a.m4068d());
        C2434b.m9292a(new C24851(this));
    }

    /* renamed from: a */
    private void m9436a(final String uuid) {
        C2372c.m9030c("check login...  retry_times=" + this.f8108j);
        C2434b.m9296a(uuid, new C2429c(this) {
            /* renamed from: b */
            final /* synthetic */ WechatLoginFragment f8096b;

            /* renamed from: a */
            public void mo1861a(String redirectUri) {
                this.f8096b.f8109k = 0;
                this.f8096b.m9441b(redirectUri);
            }

            /* renamed from: a */
            public void mo1860a() {
                this.f8096b.f8108j = this.f8096b.f8108j + 1;
                if (this.f8096b.f8108j <= 3) {
                    this.f8096b.m9436a(uuid);
                    return;
                }
                this.f8096b.f8108j = 0;
                this.f8096b.m9439b();
            }

            /* renamed from: b */
            public void mo1862b() {
                this.f8096b.m9439b();
            }

            /* renamed from: b */
            public void mo1863b(String iconUrl) {
                this.f8096b.f8101c.setText("扫描成功，请在手机上点击登录");
                this.f8096b.f8103e.setText("返回二维码登录");
                this.f8096b.f8104f.setVisibility(8);
                this.f8096b.f8102d.setVisibility(8);
                if (TextUtils.isEmpty(iconUrl)) {
                    this.f8096b.f8100b.setImageBitmap(null);
                    return;
                }
                this.f8096b.f8100b.setImageBitmap(C2497a.m9476a(iconUrl.substring("data:img/jpg;base64,".length())));
            }

            /* renamed from: c */
            public void mo1864c() {
                this.f8096b.m9436a(uuid);
            }

            /* renamed from: d */
            public void mo1865d() {
                C2372c.m9036e("login check canceled，登录态轮询检测停止。。。。。。。。。。。。");
            }
        });
    }

    /* renamed from: b */
    private void m9441b(final String redirectUri) {
        this.f8109k++;
        C2372c.m9030c("redirect uri... times = " + this.f8109k);
        m9450d("正在加载数据...");
        C2434b.m9297a(redirectUri, new C2431e(this) {
            /* renamed from: b */
            final /* synthetic */ WechatLoginFragment f8098b;

            /* renamed from: a */
            public void mo1866a() {
                this.f8098b.f8110l = 0;
                this.f8098b.m9449d();
            }

            /* renamed from: b */
            public void mo1867b() {
                if (this.f8098b.f8109k <= 3) {
                    this.f8098b.m9441b(redirectUri);
                    return;
                }
                this.f8098b.f8109k = 0;
                C2454d.m9369a("用户数据加载失败");
                this.f8098b.m9446c("用户数据加载失败");
                this.f8098b.m9439b();
            }
        });
    }

    /* renamed from: d */
    private void m9449d() {
        this.f8110l++;
        C2372c.m9030c("web wx init... webwxInitTimes=" + this.f8110l);
        C2434b.m9293a(new C24884(this));
    }

    /* renamed from: c */
    private void m9446c(String msg) {
        Toast.makeText(getActivity(), msg, 0).show();
    }

    /* renamed from: d */
    private void m9450d(String msg) {
        C2342g.m8864e().m8890a(msg);
    }

    /* renamed from: e */
    private void m9452e() {
        C2342g.m8864e().m8895f();
    }
}
