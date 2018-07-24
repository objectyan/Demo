package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p108b.C2398k;
import com.baidu.carlife.wechat.p108b.C2398k.C2397b;
import com.baidu.carlife.wechat.p109c.C2415a;
import com.baidu.carlife.wechat.p110e.C2436c;
import com.baidu.carlife.wechat.p111d.C2416a;
import com.baidu.carlife.wechat.p112f.C2454d;
import com.baidu.carlife.wechat.p113g.C2498b;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.facebook.drawee.view.SimpleDraweeView;

public class WechatFragment extends C2461a implements OnItemClickListener, C2397b {
    /* renamed from: b */
    public static String f8087b = WechatFragment.class.getSimpleName();
    /* renamed from: c */
    private TextView f8088c;
    /* renamed from: d */
    private ImageButton f8089d;
    /* renamed from: e */
    private GridView f8090e;
    /* renamed from: f */
    private C2416a f8091f;
    /* renamed from: g */
    private SimpleDraweeView f8092g;
    /* renamed from: h */
    private FrameLayout f8093h;

    /* renamed from: com.baidu.carlife.wechat.fragment.WechatFragment$1 */
    class C24801 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ WechatFragment f8080a;

        C24801(WechatFragment this$0) {
            this.f8080a = this$0;
        }

        public void onClick(View v) {
            this.f8080a.showFragment(NaviFragmentManager.TYPE_WECHAT_LOGOUT, null);
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.WechatFragment$2 */
    class C24812 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ WechatFragment f8081a;

        C24812(WechatFragment this$0) {
            this.f8081a = this$0;
        }

        public void onClick(View v) {
            this.f8081a.back();
        }
    }

    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View view = inflater.inflate(C0965R.layout.fragment_wechat, null);
        m9415a(view);
        return view;
    }

    public void onResume() {
        boolean isLogin;
        super.onResume();
        if (TextUtils.isEmpty(C2380c.m9070a().m9085f().m9135d())) {
            isLogin = false;
        } else {
            isLogin = true;
        }
        C2372c.m9030c("isLogin = " + isLogin + " ; firstOpenFlag = " + C2380c.m9070a().m9082c());
        if (isLogin) {
            if (C2380c.m9070a().m9082c()) {
                C2454d.m9369a("微信登录成功");
                C2415a.m9228a().m9242b();
                C2415a.m9228a().m9237a(0);
                m9416b();
                C2380c.m9070a().m9076a(false);
                m9418d();
            }
            C2398k.m9160a().m9176a((C2397b) this);
            mo1856a();
            m9417c();
            return;
        }
        showFragment(NaviFragmentManager.TYPE_WECHAT_LOGIN, null);
    }

    public void onPause() {
        super.onPause();
        C2398k.m9160a().m9183b((C2397b) this);
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    /* renamed from: a */
    private void m9415a(View view) {
        this.f8093h = (FrameLayout) view.findViewById(C0965R.id.fragment_wechat_layout_usericon);
        this.f8093h.setBackground(C2251b.m8527a(getActivity()));
        this.f8093h.setOnClickListener(new C24801(this));
        this.f8092g = (SimpleDraweeView) view.findViewById(C0965R.id.fragment_wechat_img_usericon);
        this.f8090e = (GridView) view.findViewById(C0965R.id.fragment_wechat_gridview);
        this.f8091f = new C2416a(getActivity());
        this.f8090e.setAdapter(this.f8091f);
        this.f8090e.setOnItemClickListener(this);
        this.f8089d = (ImageButton) view.findViewById(C0965R.id.fragment_wechat_back);
        this.f8089d.setBackground(C2251b.m8527a(getActivity()));
        this.f8089d.setOnClickListener(new C24812(this));
        this.f8088c = (TextView) view.findViewById(C0965R.id.fragment_wechat_title_desc);
        this.f8088c.setText(CarlifeConfig.m4068d());
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        switch (this.f8091f.m9248a(position)) {
            case Session:
                showFragment(NaviFragmentManager.TYPE_WECHAT_SESSION, null);
                return;
            case Contact:
                showFragment(NaviFragmentManager.TYPE_WECHAT_CONTACT, null);
                return;
            case Mute:
                C2498b.m9482a(!C2498b.m9483a());
                this.f8091f.notifyDataSetChanged();
                return;
            case Setting:
                showFragment(NaviFragmentManager.TYPE_WECHAT_SETTING, null);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo1856a() {
        this.f8091f.notifyDataSetChanged();
    }

    /* renamed from: b */
    private void m9416b() {
        if (C2380c.m9070a().m9087h().size() > 0) {
            C2372c.m9030c("wechat contact loaded !");
            return;
        }
        C2415a.m9228a().m9243c();
        C2415a.m9228a().m9240a(null);
        C2415a.m9228a().m9241a("0");
    }

    /* renamed from: c */
    private void m9417c() {
        this.f8092g.setImageURI(C2436c.m9320i() + C2380c.m9070a().m9085f().m9135d());
    }

    /* renamed from: d */
    private void m9418d() {
        if (!CarlifeUtil.m4358a().m4398o()) {
            final C1953c commonDialog = new C1953c(AppContext.m3876a());
            commonDialog.m7448c("提示").m7444b("使用微信需开启“小度小度，语音唤醒”，是否确认开启？").m7451d("开启").m7454e("取消").m7438a(new OnBtnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ WechatFragment f8085b;

                public void onClick() {
                    CarlifeUtil.m4358a().m4390a(true);
                    C1912n.m7270a().m7299a(true);
                    C1912n.m7270a().m7308g();
                    this.f8085b.dismissDialog(commonDialog);
                }
            }).m7443b(new OnBtnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ WechatFragment f8083b;

                public void onClick() {
                    this.f8083b.dismissDialog(commonDialog);
                }
            });
            showDialog(commonDialog);
        }
    }
}
