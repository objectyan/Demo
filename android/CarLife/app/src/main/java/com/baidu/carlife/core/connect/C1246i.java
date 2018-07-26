package com.baidu.carlife.core.connect;

import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import com.baidu.carlife.core.C1260i;

/* compiled from: WifiP2pActionListener */
/* renamed from: com.baidu.carlife.core.connect.i */
public class C1246i {
    /* renamed from: a */
    private static final String f3437a = "[WifiDirect]";
    /* renamed from: i */
    private static C1246i f3438i = null;
    /* renamed from: b */
    private ActionListener f3439b = new C1244g(this);
    /* renamed from: c */
    private ActionListener f3440c = new C1240c(this);
    /* renamed from: d */
    private ActionListener f3441d = new C1241d(this);
    /* renamed from: e */
    private ActionListener f3442e = new C1245h(this);
    /* renamed from: f */
    private ActionListener f3443f = new C1238a(this);
    /* renamed from: g */
    private ActionListener f3444g = new C1239b(this);
    /* renamed from: h */
    private ActionListener f3445h = new C1243f(this);

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$a */
    class C1238a implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1246i f3427a;

        C1238a(C1246i this$0) {
            this.f3427a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(C1246i.f3437a, ": Added Local Service onSuccess");
        }

        public void onFailure(int error) {
            C1260i.m4435b(C1246i.f3437a, ": onFailure");
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$b */
    class C1239b implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1246i f3428a;

        C1239b(C1246i this$0) {
            this.f3428a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(C1246i.f3437a, ": addServiceRequest onSuccess");
        }

        public void onFailure(int arg0) {
            C1260i.m4435b(C1246i.f3437a, ": addServiceRequest onFailure");
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$c */
    class C1240c implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1246i f3429a;

        C1240c(C1246i this$0) {
            this.f3429a = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int reason) {
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$d */
    class C1241d implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1246i f3430a;

        C1241d(C1246i this$0) {
            this.f3430a = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int reason) {
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$e */
    class C1242e implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1246i f3431a;
        /* renamed from: b */
        private String f3432b = "Action";
        /* renamed from: c */
        private boolean f3433c = false;

        public C1242e(C1246i this$0, String strType, boolean bShowLog) {
            this.f3431a = this$0;
            this.f3432b = strType;
            this.f3433c = bShowLog;
        }

        public void onSuccess() {
            if (this.f3433c) {
                C1260i.m4435b(C1246i.f3437a, this.f3432b + " : onSuccess");
            }
        }

        public void onFailure(int reason) {
            C1260i.m4435b(C1246i.f3437a, this.f3432b + " : onFailure");
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$f */
    class C1243f implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1246i f3434a;

        C1243f(C1246i this$0) {
            this.f3434a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(C1246i.f3437a, ": Service discovery initiated onSuccess");
        }

        public void onFailure(int arg0) {
            C1260i.m4435b(C1246i.f3437a, ": Service discovery initiated onFailure");
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$g */
    class C1244g implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1246i f3435a;

        C1244g(C1246i this$0) {
            this.f3435a = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int reason) {
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$h */
    class C1245h implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1246i f3436a;

        C1245h(C1246i this$0) {
            this.f3436a = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int reason) {
        }
    }

    private C1246i() {
    }

    /* renamed from: a */
    public static C1246i m4306a() {
        if (f3438i == null) {
            synchronized (C1246i.class) {
                if (f3438i == null) {
                    f3438i = new C1246i();
                }
            }
        }
        return f3438i;
    }

    /* renamed from: b */
    public ActionListener m4308b() {
        return this.f3439b;
    }

    /* renamed from: c */
    public ActionListener m4309c() {
        return this.f3440c;
    }

    /* renamed from: d */
    public ActionListener m4310d() {
        return this.f3441d;
    }

    /* renamed from: e */
    public ActionListener m4311e() {
        return this.f3442e;
    }

    /* renamed from: f */
    public ActionListener m4312f() {
        return this.f3443f;
    }

    /* renamed from: g */
    public ActionListener m4313g() {
        return this.f3444g;
    }

    /* renamed from: h */
    public ActionListener m4314h() {
        return this.f3445h;
    }

    /* renamed from: a */
    public ActionListener m4307a(String strType, boolean bShowLog) {
        return new C1242e(this, strType, bShowLog);
    }
}
