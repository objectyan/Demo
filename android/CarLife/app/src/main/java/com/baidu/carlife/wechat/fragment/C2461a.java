package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.wechat.C2374a;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p108b.C2380c.C2379b;
import com.baidu.carlife.wechat.p110e.C2434b;
import com.baidu.carlife.wechat.p110e.C2434b.C2430d;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

/* compiled from: WechatBaseFragment */
/* renamed from: com.baidu.carlife.wechat.fragment.a */
abstract class C2461a extends ContentFragment {
    /* renamed from: a */
    C2495a f8028a;

    /* compiled from: WechatBaseFragment */
    /* renamed from: com.baidu.carlife.wechat.fragment.a$1 */
    class C24941 implements C2430d {
        /* renamed from: a */
        final /* synthetic */ C2461a f8127a;

        C24941(C2461a this$0) {
            this.f8127a = this$0;
        }

        /* renamed from: a */
        public void mo1870a() {
            C2380c.m9070a().m9072a(C2379b.LOGOUT);
        }

        /* renamed from: b */
        public void mo1871b() {
            C2380c.m9070a().m9072a(C2379b.LOGOUT);
        }
    }

    /* compiled from: WechatBaseFragment */
    /* renamed from: com.baidu.carlife.wechat.fragment.a$a */
    private class C2495a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C2461a f8128a;

        public C2495a(C2461a c2461a, Looper looper) {
            this.f8128a = c2461a;
            super(looper);
        }

        public void careAbout() {
            addMsg(1002);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1002:
                    this.f8128a.mo1856a();
                    this.f8128a.showFragment(NaviFragmentManager.TYPE_HOME_MORE, null);
                    this.f8128a.removeWeChatFragmentFromStack();
                    C2374a.m9041a();
                    return;
                default:
                    return;
            }
        }
    }

    C2461a() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onResume() {
        super.onResume();
        this.f8028a = new C2495a(this, Looper.getMainLooper());
        C1261k.m4460a(this.f8028a);
    }

    public void onStop() {
        C1261k.m4464b(this.f8028a);
        super.onStop();
    }

    /* renamed from: a */
    private void mo1856a() {
        C2434b.m9290a(new C24941(this));
    }
}
