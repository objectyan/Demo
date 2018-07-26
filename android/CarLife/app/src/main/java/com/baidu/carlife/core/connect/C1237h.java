package com.baidu.carlife.core.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener;
import android.net.wifi.p2p.WifiP2pManager.DnsSdServiceResponseListener;
import android.net.wifi.p2p.WifiP2pManager.DnsSdTxtRecordListener;
import android.net.wifi.p2p.WifiP2pManager.PeerListListener;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.C1260i;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: WifiDirectManager */
/* renamed from: com.baidu.carlife.core.connect.h */
public class C1237h implements ConnectionInfoListener, PeerListListener {
    /* renamed from: a */
    public static final String f3408a = "available";
    /* renamed from: b */
    public static final String f3409b = "_ClfWfd";
    /* renamed from: c */
    public static final String f3410c = "_Clf._Wifi";
    /* renamed from: d */
    public static final int f3411d = 65537;
    /* renamed from: e */
    private static final String f3412e = "[WifiDirect]";
    /* renamed from: f */
    private static C1237h f3413f = null;
    /* renamed from: g */
    private final IntentFilter f3414g = new IntentFilter();
    /* renamed from: h */
    private Context f3415h = null;
    /* renamed from: i */
    private BroadcastReceiver f3416i = null;
    /* renamed from: j */
    private WifiP2pManager f3417j = null;
    /* renamed from: k */
    private Channel f3418k = null;
    /* renamed from: l */
    private WifiManager f3419l = null;
    /* renamed from: m */
    private WifiP2pDnsSdServiceRequest f3420m = null;
    /* renamed from: n */
    private WifiP2pDnsSdServiceInfo f3421n = null;
    /* renamed from: o */
    private WifiP2pDevice f3422o = null;
    /* renamed from: p */
    private InetAddress f3423p = null;
    /* renamed from: q */
    private C1236a f3424q = null;
    /* renamed from: r */
    private HandlerThread f3425r;
    /* renamed from: s */
    private List f3426s = new ArrayList();

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$1 */
    class C12251 implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1237h f3396a;

        C12251(C1237h this$0) {
            this.f3396a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Clear Local Service");
            this.f3396a.m4289j();
        }

        public void onFailure(int reason) {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Clear Local Service failure");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$2 */
    class C12282 implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1237h f3399a;

        /* compiled from: WifiDirectManager */
        /* renamed from: com.baidu.carlife.core.connect.h$2$1 */
        class C12271 implements ActionListener {
            /* renamed from: a */
            final /* synthetic */ C12282 f3398a;

            /* compiled from: WifiDirectManager */
            /* renamed from: com.baidu.carlife.core.connect.h$2$1$1 */
            class C12261 implements ActionListener {
                /* renamed from: a */
                final /* synthetic */ C12271 f3397a;

                C12261(C12271 this$2) {
                    this.f3397a = this$2;
                }

                public void onSuccess() {
                    C1260i.m4435b(C1237h.f3412e, "WifiDirectManager:  --------------------------------");
                }

                public void onFailure(int reason) {
                    C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Wifi P2P discover peers failure !");
                }
            }

            C12271(C12282 this$1) {
                this.f3398a = this$1;
            }

            public void onSuccess() {
                C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Added service discovery request");
                this.f3398a.f3399a.f3417j.discoverPeers(this.f3398a.f3399a.f3418k, new C12261(this));
            }

            public void onFailure(int arg0) {
                C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Failed adding service discovery request");
            }
        }

        C12282(C1237h this$0) {
            this.f3399a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Cleared service discovery request");
            this.f3399a.f3420m = WifiP2pDnsSdServiceRequest.newInstance();
            this.f3399a.f3417j.addServiceRequest(this.f3399a.f3418k, this.f3399a.f3420m, new C12271(this));
        }

        public void onFailure(int reason) {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Failed clearing service discovery request");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$3 */
    class C12293 implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1237h f3400a;

        C12293(C1237h this$0) {
            this.f3400a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(C1237h.f3412e, "@WifiDirectManager: Connect Success!!!");
        }

        public void onFailure(int reason) {
            C1260i.m4445e(C1237h.f3412e, "WifiDirectManager: Failure to connect to peer!!");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$4 */
    class C12304 implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1237h f3401a;

        C12304(C1237h this$0) {
            this.f3401a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: connect to devices：" + this.f3401a.f3422o.deviceName + "ipaddress:" + this.f3401a.f3422o.deviceAddress);
        }

        public void onFailure(int arg0) {
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$5 */
    class C12315 implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1237h f3402a;

        C12315(C1237h this$0) {
            this.f3402a = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int arg0) {
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$6 */
    class C12326 implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1237h f3403a;

        C12326(C1237h this$0) {
            this.f3403a = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int arg0) {
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$7 */
    class C12337 implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1237h f3404a;

        C12337(C1237h this$0) {
            this.f3404a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Set group owener success !");
        }

        public void onFailure(int reason) {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Set group owener failure !");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$8 */
    class C12348 implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1237h f3405a;

        C12348(C1237h this$0) {
            this.f3405a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Removed Local Service");
        }

        public void onFailure(int reason) {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Removed Local Service failure");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$9 */
    class C12359 implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ C1237h f3406a;

        C12359(C1237h this$0) {
            this.f3406a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Clear Local Service");
        }

        public void onFailure(int reason) {
            C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Clear Local Service failure");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$a */
    private class C1236a extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1237h f3407a;

        public C1236a(C1237h c1237h, Looper looper) {
            this.f3407a = c1237h;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg != null) {
                switch (msg.what) {
                    case C1237h.f3411d /*65537*/:
                        C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: peer connect");
                        this.f3407a.m4303f();
                        return;
                    default:
                        super.handleMessage(msg);
                        return;
                }
            }
        }
    }

    /* renamed from: a */
    public static C1237h m4281a() {
        if (f3413f == null) {
            synchronized (C1237h.class) {
                if (f3413f == null) {
                    f3413f = new C1237h();
                }
            }
        }
        return f3413f;
    }

    /* renamed from: a */
    public void m4297a(WifiP2pManager wpm, Channel channel, Context context) {
        this.f3417j = wpm;
        this.f3418k = channel;
        this.f3415h = context;
    }

    /* renamed from: a */
    public void m4295a(Context context) {
        if (context != null) {
            C1260i.m4435b(f3412e, "WifiDirectManager: ++++++++ WifiP2pManager  init ++++++++");
            this.f3415h = context;
            if (this.f3424q == null) {
                this.f3425r = new HandlerThread("WifiDirectManMsgHandlerThread");
                this.f3425r.start();
                this.f3424q = new C1236a(this, this.f3425r.getLooper());
            }
            if (this.f3417j == null) {
                this.f3419l = (WifiManager) context.getSystemService(C1981b.f6365e);
                Context context2 = this.f3415h;
                Context context3 = this.f3415h;
                this.f3417j = (WifiP2pManager) context2.getSystemService("wifip2p");
                C1260i.m4435b(f3412e, "WifiDirectManager: init wifi_p2p_service : " + this.f3417j);
                if (this.f3417j != null) {
                    this.f3418k = this.f3417j.initialize(this.f3415h, Looper.getMainLooper(), null);
                    if (this.f3418k == null) {
                        C1260i.m4435b(f3412e, "WifiDirectManager: setup connection fail");
                        this.f3417j = null;
                    }
                } else {
                    C1260i.m4435b(f3412e, "WifiDirectManager: mWifiP2pManager is null");
                }
            }
            if (!m4291l()) {
                C1260i.m4435b(f3412e, "WifiDirectManager: Wifi is disable, CarLife will open !");
                m4292m();
            }
            m4301d();
        }
    }

    /* renamed from: b */
    public WifiP2pManager m4298b() {
        return this.f3417j;
    }

    /* renamed from: c */
    public Channel m4300c() {
        return this.f3418k;
    }

    /* renamed from: d */
    public boolean m4301d() {
        if (!m4291l()) {
            C1260i.m4435b(f3412e, "WifiDirectManager: Wifi is disable, CarLife will open !");
            m4292m();
        }
        this.f3417j.clearLocalServices(this.f3418k, new C12251(this));
        return true;
    }

    /* renamed from: a */
    public void m4294a(int nWhat, int arg1, int arg2, Object obj) {
        Message msg = Message.obtain();
        msg.what = nWhat;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        this.f3424q.sendMessage(msg);
    }

    /* renamed from: e */
    public void m4302e() {
        if (this.f3421n != null) {
            this.f3417j.removeLocalService(this.f3418k, this.f3421n, new C12348(this));
            this.f3417j.clearLocalServices(this.f3418k, new C12359(this));
        }
        if (this.f3420m != null) {
            this.f3417j.removeServiceRequest(this.f3418k, this.f3420m, new ActionListener(this) {
                /* renamed from: a */
                final /* synthetic */ C1237h f3390a;

                {
                    this.f3390a = this$0;
                }

                public void onSuccess() {
                    C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Removed service discovery request");
                }

                public void onFailure(int reason) {
                    C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Failed removing service discovery request");
                }
            });
            this.f3417j.clearServiceRequests(this.f3418k, new ActionListener(this) {
                /* renamed from: a */
                final /* synthetic */ C1237h f3391a;

                {
                    this.f3391a = this$0;
                }

                public void onSuccess() {
                    C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Cleared service discovery request");
                }

                public void onFailure(int reason) {
                    C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Failed clearing service discovery request");
                }
            });
        }
    }

    /* renamed from: i */
    private void m4288i() {
        this.f3417j.stopPeerDiscovery(this.f3418k, new ActionListener(this) {
            /* renamed from: a */
            final /* synthetic */ C1237h f3392a;

            {
                this.f3392a = this$0;
            }

            public void onSuccess() {
                C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: stop discovery Success");
            }

            public void onFailure(int reason) {
                C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: stop discovery failed");
            }
        });
        C1260i.m4435b(f3412e, "Activity: WifiDirectManager: stopDiscoverServices");
    }

    /* renamed from: j */
    private void m4289j() {
        Map<String, String> record = new HashMap();
        record.put("available", MapObjKey.OBJ_SL_VISI);
        this.f3421n = WifiP2pDnsSdServiceInfo.newInstance("_ClfWfd", "_Clf._Wifi", record);
        this.f3417j.addLocalService(this.f3418k, this.f3421n, new ActionListener(this) {
            /* renamed from: a */
            final /* synthetic */ C1237h f3393a;

            {
                this.f3393a = this$0;
            }

            public void onSuccess() {
                C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Added Local Service");
                this.f3393a.m4290k();
            }

            public void onFailure(int error) {
                C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: Failed to add a service");
            }
        });
    }

    /* renamed from: k */
    private void m4290k() {
        this.f3417j.setDnsSdResponseListeners(this.f3418k, new DnsSdServiceResponseListener(this) {
            /* renamed from: a */
            final /* synthetic */ C1237h f3394a;

            {
                this.f3394a = this$0;
            }

            public void onDnsSdServiceAvailable(String instanceName, String registrationType, WifiP2pDevice srcDevice) {
                C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: discover service : " + instanceName);
                if (instanceName.equalsIgnoreCase("_ClfWfd")) {
                    if (this.f3394a.f3422o == null) {
                        this.f3394a.f3422o = new WifiP2pDevice();
                    }
                    this.f3394a.f3422o = srcDevice;
                    this.f3394a.m4296a(this.f3394a.f3422o);
                }
            }
        }, new DnsSdTxtRecordListener(this) {
            /* renamed from: a */
            final /* synthetic */ C1237h f3395a;

            {
                this.f3395a = this$0;
            }

            public void onDnsSdTxtRecordAvailable(String fullDomainName, Map<String, String> record, WifiP2pDevice device) {
                C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: TxtRecord Available : ---------------");
                C1260i.m4435b(C1237h.f3412e, "WifiDirectManager: " + device.deviceName + " is " + ((String) record.get("available")));
            }
        });
        this.f3417j.clearServiceRequests(this.f3418k, new C12282(this));
    }

    public void onConnectionInfoAvailable(WifiP2pInfo p2pInfo) {
        if (p2pInfo.isGroupOwner) {
            C1260i.m4435b(f3412e, "WifiDirectManager: Activity:Connected as group owner");
            return;
        }
        C1260i.m4435b(f3412e, "WifiDirectManager: Activity:Connected as peer");
        try {
            this.f3423p = p2pInfo.groupOwnerAddress;
        } catch (Exception e) {
            C1260i.m4435b(f3412e, "WifiDirectManager: Failed to create connect thread - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void onPeersAvailable(WifiP2pDeviceList peerList) {
        C1260i.m4435b(f3412e, "WifiDirectManager: onPeersAvailable");
        this.f3426s.clear();
        this.f3426s.addAll(peerList.getDeviceList());
        for (int i = 0; i < this.f3426s.size(); i++) {
            WifiP2pDevice device = (WifiP2pDevice) this.f3426s.get(0);
            C1260i.m4435b(f3412e, "WifiDirectManager: dump device :" + i);
            C1260i.m4435b(f3412e, "WifiDirectManager:  : " + device.toString());
        }
        if (this.f3426s.size() == 0) {
            C1260i.m4435b(f3412e, "WifiDirectManager: No devices found");
        } else {
            C1260i.m4435b(f3412e, "WifiDirectManager: Get peers : " + this.f3426s.size());
        }
    }

    /* renamed from: f */
    public void m4303f() {
        if (this.f3426s.size() == 0) {
            C1260i.m4435b(f3412e, "WifiDirectManager: Peer divice is null !");
            return;
        }
        WifiP2pDevice device = (WifiP2pDevice) this.f3426s.get(0);
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = 0;
        C1260i.m4435b(f3412e, "@WifiDirectManager: Star to Connect device");
        this.f3417j.connect(this.f3418k, config, new C12293(this));
    }

    /* renamed from: a */
    public void m4296a(WifiP2pDevice device) {
        C1260i.m4435b(f3412e, "WifiDirectManager: connectP2P");
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = 0;
        this.f3417j.connect(this.f3418k, config, new C12304(this));
    }

    /* renamed from: b */
    public void m4299b(WifiP2pDevice device) {
        if (this.f3417j == null) {
            return;
        }
        if (device == null || device.status == 0) {
            m4304g();
        } else if (device.status == 3 || device.status == 1) {
            this.f3417j.cancelConnect(this.f3418k, new C12315(this));
        }
    }

    /* renamed from: g */
    public void m4304g() {
        this.f3417j.removeGroup(this.f3418k, new C12326(this));
    }

    /* renamed from: h */
    public void m4305h() {
        C1260i.m4435b(f3412e, "WifiDirectManager: resetData");
        this.f3422o = null;
    }

    /* renamed from: l */
    private boolean m4291l() {
        if (this.f3419l == null) {
            Context context = this.f3415h;
            Context context2 = this.f3415h;
            this.f3419l = (WifiManager) context.getSystemService(C1981b.f6365e);
        }
        if (this.f3419l != null) {
            return this.f3419l.isWifiEnabled();
        }
        return false;
    }

    /* renamed from: m */
    private void m4292m() {
        this.f3419l.setWifiEnabled(true);
    }

    /* renamed from: n */
    private void m4293n() {
        this.f3417j.createGroup(this.f3418k, new C12337(this));
    }
}
