package com.baidu.carlife.core.connect;

import android.net.wifi.p2p.WifiP2pManager.ActionListener;

import com.baidu.carlife.core.LogUtil;

/* compiled from: WifiP2pActionListener */
/* renamed from: com.baidu.carlife.core.connect.i */
public class WifiP2pActionListener {
    /* renamed from: a */
    private static final String Tag = "[WifiDirect]";
    /* renamed from: i */
    private static WifiP2pActionListener sP2pActionListener = null;
    /* renamed from: b */
    private ActionListener f3439b = new C1244g(this);
    /* renamed from: c */
    private ActionListener f3440c = new C1240c(this);
    /* renamed from: d */
    private ActionListener f3441d = new C1241d(this);
    /* renamed from: e */
    private ActionListener f3442e = new C1245h(this);
    /* renamed from: f */
    private ActionListener mAddedLocalServiceListener = new AddedLocalServiceListener(this);
    /* renamed from: g */
    private ActionListener mAddServiceRequestListener = new AddServiceRequestListener(this);
    /* renamed from: h */
    private ActionListener f3445h = new C1243f(this);

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$a */
    class AddedLocalServiceListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiP2pActionListener mWifiP2pActionListener;

        AddedLocalServiceListener(WifiP2pActionListener this$0) {
            this.mWifiP2pActionListener = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiP2pActionListener.Tag, ": Added Local Service onSuccess");
        }

        public void onFailure(int error) {
            LogUtil.d(WifiP2pActionListener.Tag, ": onFailure");
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$b */
    class AddServiceRequestListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiP2pActionListener mWifiP2pActionListener;

        AddServiceRequestListener(WifiP2pActionListener this$0) {
            this.mWifiP2pActionListener = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiP2pActionListener.Tag, ": addServiceRequest onSuccess");
        }

        public void onFailure(int arg0) {
            LogUtil.d(WifiP2pActionListener.Tag, ": addServiceRequest onFailure");
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$c */
    class C1240c implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiP2pActionListener f3429a;

        C1240c(WifiP2pActionListener this$0) {
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
        final /* synthetic */ WifiP2pActionListener f3430a;

        C1241d(WifiP2pActionListener this$0) {
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
        final /* synthetic */ WifiP2pActionListener f3431a;
        /* renamed from: b */
        private String f3432b = "Action";
        /* renamed from: c */
        private boolean f3433c = false;

        public C1242e(WifiP2pActionListener this$0, String strType, boolean bShowLog) {
            this.f3431a = this$0;
            this.f3432b = strType;
            this.f3433c = bShowLog;
        }

        public void onSuccess() {
            if (this.f3433c) {
                LogUtil.d(WifiP2pActionListener.Tag, this.f3432b + " : onSuccess");
            }
        }

        public void onFailure(int reason) {
            LogUtil.d(WifiP2pActionListener.Tag, this.f3432b + " : onFailure");
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$f */
    class C1243f implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiP2pActionListener f3434a;

        C1243f(WifiP2pActionListener this$0) {
            this.f3434a = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiP2pActionListener.Tag, ": Service discovery initiated onSuccess");
        }

        public void onFailure(int arg0) {
            LogUtil.d(WifiP2pActionListener.Tag, ": Service discovery initiated onFailure");
        }
    }

    /* compiled from: WifiP2pActionListener */
    /* renamed from: com.baidu.carlife.core.connect.i$g */
    class C1244g implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiP2pActionListener f3435a;

        C1244g(WifiP2pActionListener this$0) {
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
        final /* synthetic */ WifiP2pActionListener f3436a;

        C1245h(WifiP2pActionListener this$0) {
            this.f3436a = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int reason) {
        }
    }

    private WifiP2pActionListener() {
    }

    /* renamed from: a */
    public static WifiP2pActionListener m4306a() {
        if (sP2pActionListener == null) {
            synchronized (WifiP2pActionListener.class) {
                if (sP2pActionListener == null) {
                    sP2pActionListener = new WifiP2pActionListener();
                }
            }
        }
        return sP2pActionListener;
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
        return this.mAddedLocalServiceListener;
    }

    /* renamed from: g */
    public ActionListener m4313g() {
        return this.mAddServiceRequestListener;
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
