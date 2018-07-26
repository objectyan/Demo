package com.baidu.carlife.core.connect;

import android.annotation.SuppressLint;
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

import com.baidu.carlife.core.LogUtil;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: WifiDirectManager */
/* renamed from: com.baidu.carlife.core.connect.h */
public class WifiDirectManager implements ConnectionInfoListener, PeerListListener {
    /* renamed from: a */
    public static final String AVAILABLE = "available";
    /* renamed from: b */
    public static final String CLF_WFD = "_ClfWfd";
    /* renamed from: c */
    public static final String CLF_WIFI = "_Clf._Wifi";
    /* renamed from: d */
    public static final int f3411d = 65537;
    /* renamed from: e */
    private static final String Tag = "[WifiDirect]";
    /* renamed from: f */
    private static WifiDirectManager sWifiDirectManager = null;
    /* renamed from: g */
    private final IntentFilter mIntentFilter = new IntentFilter();
    /* renamed from: h */
    private Context mContext = null;
    /* renamed from: i */
    private BroadcastReceiver mBroadcastReceiver = null;
    /* renamed from: j */
    private WifiP2pManager mWifiP2pManager = null;
    /* renamed from: k */
    private Channel mChannel = null;
    /* renamed from: l */
    private WifiManager mWifiManager = null;
    /* renamed from: m */
    private WifiP2pDnsSdServiceRequest mWifiP2pDnsSdServiceRequest = null;
    /* renamed from: n */
    private WifiP2pDnsSdServiceInfo mWifiP2pDnsSdServiceInfo = null;
    /* renamed from: o */
    private WifiP2pDevice mWifiP2pDevice = null;
    /* renamed from: p */
    private InetAddress mInetAddress = null;
    /* renamed from: q */
    private WifiDirectManMsgHandler mDirectManMsgHandler = null;
    /* renamed from: r */
    private HandlerThread mHandlerThread;
    /* renamed from: s */
    private List mPeerDivice = new ArrayList();

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$1 */
    class WifiDirectManagerListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        WifiDirectManagerListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Clear Local Service");
            this.mWifiDirectManager.initLocalService();
        }

        public void onFailure(int reason) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Clear Local Service failure");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$2 */
    class WifiDirectManagerServiceListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        /* compiled from: WifiDirectManager */
        /* renamed from: com.baidu.carlife.core.connect.h$2$1 */
        class AddServiceListener implements ActionListener {
            /* renamed from: a */
            final /* synthetic */ WifiDirectManagerServiceListener mWifiDirectManagerServiceListener;

            /* compiled from: WifiDirectManager */
            /* renamed from: com.baidu.carlife.core.connect.h$2$1$1 */
            class WifiP2PListener implements ActionListener {
                /* renamed from: a */
                final /* synthetic */ AddServiceListener mAddServiceListener;

                WifiP2PListener(AddServiceListener this$2) {
                    this.mAddServiceListener = this$2;
                }

                public void onSuccess() {
                    LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager:  --------------------------------");
                }

                public void onFailure(int reason) {
                    LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Wifi P2P discover peers failure !");
                }
            }

            AddServiceListener(WifiDirectManagerServiceListener this$1) {
                this.mWifiDirectManagerServiceListener = this$1;
            }

            public void onSuccess() {
                LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Added service discovery request");
                this.mWifiDirectManagerServiceListener.mWifiDirectManager.mWifiP2pManager.discoverPeers(this.mWifiDirectManagerServiceListener.mWifiDirectManager.mChannel, new WifiP2PListener(this));
            }

            public void onFailure(int arg0) {
                LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Failed adding service discovery request");
            }
        }

        WifiDirectManagerServiceListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Cleared service discovery request");
            this.mWifiDirectManager.mWifiP2pDnsSdServiceRequest = WifiP2pDnsSdServiceRequest.newInstance();
            this.mWifiDirectManager.mWifiP2pManager.addServiceRequest(this.mWifiDirectManager.mChannel, this.mWifiDirectManager.mWifiP2pDnsSdServiceRequest, new AddServiceListener(this));
        }

        public void onFailure(int reason) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Failed clearing service discovery request");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$3 */
    class ConnectListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        ConnectListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "@WifiDirectManager: Connect Success!!!");
        }

        public void onFailure(int reason) {
            LogUtil.e(WifiDirectManager.Tag, "WifiDirectManager: Failure to connect to peer!!");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$4 */
    class WifiP2pDeviceListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        WifiP2pDeviceListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: connect to devices：" + this.mWifiDirectManager.mWifiP2pDevice.deviceName + "ipaddress:" + this.mWifiDirectManager.mWifiP2pDevice.deviceAddress);
        }

        public void onFailure(int arg0) {
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$5 */
    class WifiP2pManagerListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        WifiP2pManagerListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int arg0) {
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$6 */
    class WifiP2pManagerRemoveListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        WifiP2pManagerRemoveListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int arg0) {
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$7 */
    class WifiP2pManagerCreateListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        WifiP2pManagerCreateListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Set group owener success !");
        }

        public void onFailure(int reason) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Set group owener failure !");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$8 */
    class RemoveLocalServiceListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        RemoveLocalServiceListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Removed Local Service");
        }

        public void onFailure(int reason) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Removed Local Service failure");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$9 */
    class ClearLocalServicesListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        ClearLocalServicesListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Clear Local Service");
        }

        public void onFailure(int reason) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Clear Local Service failure");
        }
    }

    class ClearServiceRequestsListener implements ActionListener {
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        ClearServiceRequestsListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Cleared service discovery request");
        }

        public void onFailure(int reason) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Failed clearing service discovery request");
        }
    }

    class StopPeerDiscoveryListener implements ActionListener {
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        StopPeerDiscoveryListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: stop discovery Success");
        }

        public void onFailure(int reason) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: stop discovery failed");
        }
    }

    class AddLocalServiceListener implements ActionListener

    {
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        AddLocalServiceListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Added Local Service");
            this.mWifiDirectManager.setDnsSdResponseListener();
        }

        public void onFailure(int error) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Failed to add a service");
        }
    }

    class WifManagerDnsSdResponseListeners implements DnsSdServiceResponseListener

    {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        WifManagerDnsSdResponseListeners(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onDnsSdServiceAvailable(String instanceName, String
                registrationType, WifiP2pDevice srcDevice) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: discover service : " + instanceName);
            if (instanceName.equalsIgnoreCase("_ClfWfd")) {
                if (this.mWifiDirectManager.mWifiP2pDevice == null) {
                    this.mWifiDirectManager.mWifiP2pDevice = new WifiP2pDevice();
                }
                this.mWifiDirectManager.mWifiP2pDevice = srcDevice;
                this.mWifiDirectManager.connectP2P(this.mWifiDirectManager.mWifiP2pDevice);
            }
        }
    }

    class WifManagerDnsSdTxtRecordListener implements DnsSdTxtRecordListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        WifManagerDnsSdTxtRecordListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onDnsSdTxtRecordAvailable(String fullDomainName, Map<String, String> record, WifiP2pDevice device) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: TxtRecord Available : ---------------");
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: " + device.deviceName + " is " + ((String) record.get(AVAILABLE)));
        }
    }

    class RemoveServiceRequestListener implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        RemoveServiceRequestListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Removed service discovery request");
        }

        public void onFailure(int reason) {
            LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: Failed removing service discovery request");
        }
    }

    /* compiled from: WifiDirectManager */
    /* renamed from: com.baidu.carlife.core.connect.h$a */
    private class WifiDirectManMsgHandler extends Handler {
        /* renamed from: a */
        final /* synthetic */ WifiDirectManager mWifiDirectManager;

        public WifiDirectManMsgHandler(WifiDirectManager wifiDirectManager, Looper looper) {
            super(looper);
            this.mWifiDirectManager = wifiDirectManager;
        }

        public void handleMessage(Message msg) {
            if (msg != null) {
                switch (msg.what) {
                    case 65537:
                        LogUtil.d(WifiDirectManager.Tag, "WifiDirectManager: peer connect");
                        this.mWifiDirectManager.starToConnect();
                        return;
                    default:
                        super.handleMessage(msg);
                        return;
                }
            }
        }
    }

    /* renamed from: a */
    public static WifiDirectManager m4281a() {
        if (sWifiDirectManager == null) {
            synchronized (WifiDirectManager.class) {
                if (sWifiDirectManager == null) {
                    sWifiDirectManager = new WifiDirectManager();
                }
            }
        }
        return sWifiDirectManager;
    }

    /* renamed from: a */
    public void m4297a(WifiP2pManager wpm, Channel channel, Context context) {
        this.mWifiP2pManager = wpm;
        this.mChannel = channel;
        this.mContext = context;
    }

    /* renamed from: a */
    public void init(Context context) {
        if (context != null) {
            LogUtil.d(Tag, "WifiDirectManager: ++++++++ WifiP2pManager  init ++++++++");
            this.mContext = context;
            if (this.mDirectManMsgHandler == null) {
                this.mHandlerThread = new HandlerThread("WifiDirectManMsgHandlerThread");
                this.mHandlerThread.start();
                this.mDirectManMsgHandler = new WifiDirectManMsgHandler(this, this.mHandlerThread.getLooper());
            }
            if (this.mWifiP2pManager == null) {
                this.mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                Context context2 = this.mContext;
                Context context3 = this.mContext;
                this.mWifiP2pManager = (WifiP2pManager) context2.getSystemService(Context.WIFI_P2P_SERVICE);
                LogUtil.d(Tag, "WifiDirectManager: init wifi_p2p_service : " + this.mWifiP2pManager);
                if (this.mWifiP2pManager != null) {
                    this.mChannel = this.mWifiP2pManager.initialize(this.mContext, Looper.getMainLooper(), null);
                    if (this.mChannel == null) {
                        LogUtil.d(Tag, "WifiDirectManager: setup connection fail");
                        this.mWifiP2pManager = null;
                    }
                } else {
                    LogUtil.d(Tag, "WifiDirectManager: mWifiP2pManager is null");
                }
            }
            if (!isWifiEnabled()) {
                LogUtil.d(Tag, "WifiDirectManager: Wifi is disable, CarLife will open !");
                enabledWifi();
            }
            clearLocalServices();
        }
    }

    /* renamed from: b */
    public WifiP2pManager getWifiP2pManager() {
        return this.mWifiP2pManager;
    }

    /* renamed from: c */
    public Channel getChannel() {
        return this.mChannel;
    }

    /* renamed from: d */
    public boolean clearLocalServices() {
        if (!isWifiEnabled()) {
            LogUtil.d(Tag, "WifiDirectManager: Wifi is disable, CarLife will open !");
            enabledWifi();
        }
        this.mWifiP2pManager.clearLocalServices(this.mChannel, new WifiDirectManagerListener(this));
        return true;
    }

    /* renamed from: a */
    public void sendMsg(int nWhat, int arg1, int arg2, Object obj) {
        Message msg = Message.obtain();
        msg.what = nWhat;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        this.mDirectManMsgHandler.sendMessage(msg);
    }

    /* renamed from: e */
    public void removeServices() {
        if (this.mWifiP2pDnsSdServiceInfo != null) {
            this.mWifiP2pManager.removeLocalService(this.mChannel, this.mWifiP2pDnsSdServiceInfo, new RemoveLocalServiceListener(this));
            this.mWifiP2pManager.clearLocalServices(this.mChannel, new ClearLocalServicesListener(this));
        }
        if (this.mWifiP2pDnsSdServiceRequest != null) {
            this.mWifiP2pManager.removeServiceRequest(this.mChannel, this.mWifiP2pDnsSdServiceRequest, new RemoveServiceRequestListener(this));
            this.mWifiP2pManager.clearServiceRequests(this.mChannel, new ClearServiceRequestsListener(this));
        }
    }

    /* renamed from: i */
    private void stopDiscoverServices() {
        this.mWifiP2pManager.stopPeerDiscovery(this.mChannel, new StopPeerDiscoveryListener(this));
        LogUtil.d(Tag, "Activity: WifiDirectManager: stopDiscoverServices");
    }

    /* renamed from: j */
    private void initLocalService() {
        Map<String, String> record = new HashMap();
        record.put(AVAILABLE, "visible");
        this.mWifiP2pDnsSdServiceInfo = WifiP2pDnsSdServiceInfo.newInstance(CLF_WFD, CLF_WIFI, record);
        this.mWifiP2pManager.addLocalService(this.mChannel, this.mWifiP2pDnsSdServiceInfo, new AddLocalServiceListener(this));
    }

    /* renamed from: k */
    private void setDnsSdResponseListener() {
        this.mWifiP2pManager.setDnsSdResponseListeners(this.mChannel, new WifManagerDnsSdResponseListeners(this),
                new WifManagerDnsSdTxtRecordListener(this));
        this.mWifiP2pManager.clearServiceRequests(this.mChannel, new WifiDirectManagerServiceListener(this));
    }

    public void onConnectionInfoAvailable(WifiP2pInfo p2pInfo) {
        if (p2pInfo.isGroupOwner) {
            LogUtil.d(Tag, "WifiDirectManager: Activity:Connected as group owner");
            return;
        }
        LogUtil.d(Tag, "WifiDirectManager: Activity:Connected as peer");
        try {
            this.mInetAddress = p2pInfo.groupOwnerAddress;
        } catch (Exception e) {
            LogUtil.d(Tag, "WifiDirectManager: Failed to create connect thread - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void onPeersAvailable(WifiP2pDeviceList peerList) {
        LogUtil.d(Tag, "WifiDirectManager: onPeersAvailable");
        this.mPeerDivice.clear();
        this.mPeerDivice.addAll(peerList.getDeviceList());
        for (int i = 0; i < this.mPeerDivice.size(); i++) {
            WifiP2pDevice device = (WifiP2pDevice) this.mPeerDivice.get(0);
            LogUtil.d(Tag, "WifiDirectManager: dump device :" + i);
            LogUtil.d(Tag, "WifiDirectManager:  : " + device.toString());
        }
        if (this.mPeerDivice.size() == 0) {
            LogUtil.d(Tag, "WifiDirectManager: No devices found");
        } else {
            LogUtil.d(Tag, "WifiDirectManager: Get peers : " + this.mPeerDivice.size());
        }
    }

    /* renamed from: f */
    public void starToConnect() {
        if (this.mPeerDivice.size() == 0) {
            LogUtil.d(Tag, "WifiDirectManager: Peer divice is null !");
            return;
        }
        WifiP2pDevice device = (WifiP2pDevice) this.mPeerDivice.get(0);
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = 0;
        LogUtil.d(Tag, "@WifiDirectManager: Star to Connect device");
        this.mWifiP2pManager.connect(this.mChannel, config, new ConnectListener(this));
    }

    /* renamed from: a */
    public void connectP2P(WifiP2pDevice device) {
        LogUtil.d(Tag, "WifiDirectManager: connectP2P");
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = 0;
        this.mWifiP2pManager.connect(this.mChannel, config, new WifiP2pDeviceListener(this));
    }

    /* renamed from: b */
    public void cancel(WifiP2pDevice device) {
        if (this.mWifiP2pManager == null) {
            return;
        }
        if (device == null || device.status == 0) {
            removeWifiP2pListener();
        } else if (device.status == 3 || device.status == 1) {
            this.mWifiP2pManager.cancelConnect(this.mChannel, new WifiP2pManagerListener(this));
        }
    }

    /* renamed from: g */
    public void removeWifiP2pListener() {
        this.mWifiP2pManager.removeGroup(this.mChannel, new WifiP2pManagerRemoveListener(this));
    }

    /* renamed from: h */
    public void m4305h() {
        LogUtil.d(Tag, "WifiDirectManager: resetData");
        this.mWifiP2pDevice = null;
    }

    /* renamed from: l */
    private boolean isWifiEnabled() {
        if (this.mWifiManager == null) {
            Context context = this.mContext;
            Context context2 = this.mContext;
            this.mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        }
        if (this.mWifiManager != null) {
            return this.mWifiManager.isWifiEnabled();
        }
        return false;
    }

    /* renamed from: m */
    @SuppressLint("MissingPermission")
    private void enabledWifi() {
        this.mWifiManager.setWifiEnabled(true);
    }

    /* renamed from: n */
    private void createGroupListener() {
        this.mWifiP2pManager.createGroup(this.mChannel, new WifiP2pManagerCreateListener(this));
    }
}
