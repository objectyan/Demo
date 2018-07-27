package me.objectyan.screensharing.core.connect;

import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.util.Log;

import me.objectyan.screensharing.core.LogUtil;

/* 2pActionListener */
//
public class WifiP2pActionListener {

    private static final String Tag = "[WifiDirect]";

    private static WifiP2pActionListener sP2pActionListener = null;

    private ActionListener f3439b = new C1244g(this);

    private ActionListener f3440c = new C1240c(this);

    private ActionListener f3441d = new C1241d(this);

    private ActionListener f3442e = new C1245h(this);

    private ActionListener mAddedLocalServiceListener = new AddedLocalServiceListener(this);

    private ActionListener mAddServiceRequestListener = new AddServiceRequestListener(this);

    private ActionListener f3445h = new C1243f(this);

    /* 2pActionListener */
    //
    class AddedLocalServiceListener implements ActionListener {

        final WifiP2pActionListener mWifiP2pActionListener;

        AddedLocalServiceListener(WifiP2pActionListener this$0) {
            this.mWifiP2pActionListener = this$0;
        }

        public void onSuccess() {
            Log.d(WifiP2pActionListener.Tag, ": Added Local Service onSuccess");
        }

        public void onFailure(int error) {
            Log.d(WifiP2pActionListener.Tag, ": onFailure");
        }
    }

    /* 2pActionListener */
    //
    class AddServiceRequestListener implements ActionListener {

        final WifiP2pActionListener mWifiP2pActionListener;

        AddServiceRequestListener(WifiP2pActionListener this$0) {
            this.mWifiP2pActionListener = this$0;
        }

        public void onSuccess() {
            Log.d(WifiP2pActionListener.Tag, ": addServiceRequest onSuccess");
        }

        public void onFailure(int arg0) {
            Log.d(WifiP2pActionListener.Tag, ": addServiceRequest onFailure");
        }
    }

    /* 2pActionListener */
    //
    class C1240c implements ActionListener {

        final WifiP2pActionListener f3429a;

        C1240c(WifiP2pActionListener this$0) {
            this.f3429a = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int reason) {
        }
    }

    /* 2pActionListener */
    //
    class C1241d implements ActionListener {

        final WifiP2pActionListener f3430a;

        C1241d(WifiP2pActionListener this$0) {
            this.f3430a = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int reason) {
        }
    }

    /* 2pActionListener */
    //
    class C1242e implements ActionListener {

        final WifiP2pActionListener f3431a;

        private String f3432b = "Action";

        private boolean f3433c = false;

        public C1242e(WifiP2pActionListener this$0, String strType, boolean bShowLog) {
            this.f3431a = this$0;
            this.f3432b = strType;
            this.f3433c = bShowLog;
        }

        public void onSuccess() {
            if (this.f3433c) {
                Log.d(WifiP2pActionListener.Tag, this.f3432b + " : onSuccess");
            }
        }

        public void onFailure(int reason) {
            Log.d(WifiP2pActionListener.Tag, this.f3432b + " : onFailure");
        }
    }

    /* 2pActionListener */
    //
    class C1243f implements ActionListener {

        final WifiP2pActionListener f3434a;

        C1243f(WifiP2pActionListener this$0) {
            this.f3434a = this$0;
        }

        public void onSuccess() {
            Log.d(WifiP2pActionListener.Tag, ": Service discovery initiated onSuccess");
        }

        public void onFailure(int arg0) {
            Log.d(WifiP2pActionListener.Tag, ": Service discovery initiated onFailure");
        }
    }

    /* 2pActionListener */
    //
    class C1244g implements ActionListener {

        final WifiP2pActionListener f3435a;

        C1244g(WifiP2pActionListener this$0) {
            this.f3435a = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int reason) {
        }
    }

    /* 2pActionListener */
    //
    class C1245h implements ActionListener {

        final WifiP2pActionListener f3436a;

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


    public ActionListener m4308b() {
        return this.f3439b;
    }


    public ActionListener m4309c() {
        return this.f3440c;
    }


    public ActionListener m4310d() {
        return this.f3441d;
    }


    public ActionListener m4311e() {
        return this.f3442e;
    }


    public ActionListener m4312f() {
        return this.mAddedLocalServiceListener;
    }


    public ActionListener m4313g() {
        return this.mAddServiceRequestListener;
    }


    public ActionListener m4314h() {
        return this.f3445h;
    }


    public ActionListener m4307a(String strType, boolean bShowLog) {
        return new C1242e(this, strType, bShowLog);
    }
}
