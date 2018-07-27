package me.objectyan.screensharing.core.connect;

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
import android.util.Log;

import me.objectyan.screensharing.core.LogUtil;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WifiDirectManager implements ConnectionInfoListener, PeerListListener {

    public static final String AVAILABLE = "available";

    public static final String CLF_WFD = "_ClfWfd";

    public static final String CLF_WIFI = "_Clf._Wifi";

    public static final int f3411d = 65537;

    private static final String Tag = "[WifiDirect]";

    private static WifiDirectManager sWifiDirectManager = null;

    private final IntentFilter mIntentFilter = new IntentFilter();

    private Context mContext = null;

    private BroadcastReceiver mBroadcastReceiver = null;

    private WifiP2pManager mWifiP2pManager = null;

    private Channel mChannel = null;

    private WifiManager mWifiManager = null;

    private WifiP2pDnsSdServiceRequest mWifiP2pDnsSdServiceRequest = null;

    private WifiP2pDnsSdServiceInfo mWifiP2pDnsSdServiceInfo = null;

    private WifiP2pDevice mWifiP2pDevice = null;

    private InetAddress mInetAddress = null;

    private WifiDirectManMsgHandler mDirectManMsgHandler = null;

    private HandlerThread mHandlerThread;

    private List mPeerDivice = new ArrayList();


    class WifiDirectManagerListener implements ActionListener {

        final  WifiDirectManager mWifiDirectManager;

        WifiDirectManagerListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Clear Local Service");
            this.mWifiDirectManager.initLocalService();
        }

        public void onFailure(int reason) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Clear Local Service failure");
        }
    }


    class WifiDirectManagerServiceListener implements ActionListener {

        final  WifiDirectManager mWifiDirectManager;

        /*  */
        //
        class AddServiceListener implements ActionListener {

            final  WifiDirectManagerServiceListener mWifiDirectManagerServiceListener;

            /*  */
            //
            class WifiP2PListener implements ActionListener {

                final  AddServiceListener mAddServiceListener;

                WifiP2PListener(AddServiceListener this$2) {
                    this.mAddServiceListener = this$2;
                }

                public void onSuccess() {
                    Log.d(WifiDirectManager.Tag, "WifiDirectManager:  --------------------------------");
                }

                public void onFailure(int reason) {
                    Log.d(WifiDirectManager.Tag, "WifiDirectManager: Wifi P2P discover peers failure !");
                }
            }

            AddServiceListener(WifiDirectManagerServiceListener this$1) {
                this.mWifiDirectManagerServiceListener = this$1;
            }

            public void onSuccess() {
                Log.d(WifiDirectManager.Tag, "WifiDirectManager: Added service discovery request");
                this.mWifiDirectManagerServiceListener.mWifiDirectManager.mWifiP2pManager.discoverPeers(this.mWifiDirectManagerServiceListener.mWifiDirectManager.mChannel, new WifiP2PListener(this));
            }

            public void onFailure(int arg0) {
                Log.d(WifiDirectManager.Tag, "WifiDirectManager: Failed adding service discovery request");
            }
        }

        WifiDirectManagerServiceListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Cleared service discovery request");
            this.mWifiDirectManager.mWifiP2pDnsSdServiceRequest = WifiP2pDnsSdServiceRequest.newInstance();
            this.mWifiDirectManager.mWifiP2pManager.addServiceRequest(this.mWifiDirectManager.mChannel, this.mWifiDirectManager.mWifiP2pDnsSdServiceRequest, new AddServiceListener(this));
        }

        public void onFailure(int reason) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Failed clearing service discovery request");
        }
    }


    class ConnectListener implements ActionListener {

        final  WifiDirectManager mWifiDirectManager;

        ConnectListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "@WifiDirectManager: Connect Success!!!");
        }

        public void onFailure(int reason) {
            Log.e(WifiDirectManager.Tag, "WifiDirectManager: Failure to connect to peer!!");
        }
    }


    class WifiP2pDeviceListener implements ActionListener {

        final  WifiDirectManager mWifiDirectManager;

        WifiP2pDeviceListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: connect to devices：" + this.mWifiDirectManager.mWifiP2pDevice.deviceName + "ipaddress:" + this.mWifiDirectManager.mWifiP2pDevice.deviceAddress);
        }

        public void onFailure(int arg0) {
        }
    }


    class WifiP2pManagerListener implements ActionListener {

        final  WifiDirectManager mWifiDirectManager;

        WifiP2pManagerListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int arg0) {
        }
    }


    class WifiP2pManagerRemoveListener implements ActionListener {

        final  WifiDirectManager mWifiDirectManager;

        WifiP2pManagerRemoveListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
        }

        public void onFailure(int arg0) {
        }
    }


    class WifiP2pManagerCreateListener implements ActionListener {

        final  WifiDirectManager mWifiDirectManager;

        WifiP2pManagerCreateListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Set group owener success !");
        }

        public void onFailure(int reason) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Set group owener failure !");
        }
    }


    class RemoveLocalServiceListener implements ActionListener {

        final  WifiDirectManager mWifiDirectManager;

        RemoveLocalServiceListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Removed Local Service");
        }

        public void onFailure(int reason) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Removed Local Service failure");
        }
    }


    class ClearLocalServicesListener implements ActionListener {

        final  WifiDirectManager mWifiDirectManager;

        ClearLocalServicesListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Clear Local Service");
        }

        public void onFailure(int reason) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Clear Local Service failure");
        }
    }

    class ClearServiceRequestsListener implements ActionListener {
        final  WifiDirectManager mWifiDirectManager;

        ClearServiceRequestsListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Cleared service discovery request");
        }

        public void onFailure(int reason) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Failed clearing service discovery request");
        }
    }

    class StopPeerDiscoveryListener implements ActionListener {
        final  WifiDirectManager mWifiDirectManager;

        StopPeerDiscoveryListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: stop discovery Success");
        }

        public void onFailure(int reason) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: stop discovery failed");
        }
    }

    class AddLocalServiceListener implements ActionListener

    {
        final  WifiDirectManager mWifiDirectManager;

        AddLocalServiceListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Added Local Service");
            this.mWifiDirectManager.setDnsSdResponseListener();
        }

        public void onFailure(int error) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Failed to add a service");
        }
    }

    class WifManagerDnsSdResponseListeners implements DnsSdServiceResponseListener

    {

        final  WifiDirectManager mWifiDirectManager;

        WifManagerDnsSdResponseListeners(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onDnsSdServiceAvailable(String instanceName, String
                registrationType, WifiP2pDevice srcDevice) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: discover service : " + instanceName);
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

        final  WifiDirectManager mWifiDirectManager;

        WifManagerDnsSdTxtRecordListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onDnsSdTxtRecordAvailable(String fullDomainName, Map<String, String> record, WifiP2pDevice device) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: TxtRecord Available : ---------------");
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: " + device.deviceName + " is " + ((String) record.get(AVAILABLE)));
        }
    }

    class RemoveServiceRequestListener implements ActionListener {

        final  WifiDirectManager mWifiDirectManager;

        RemoveServiceRequestListener(WifiDirectManager this$0) {
            this.mWifiDirectManager = this$0;
        }

        public void onSuccess() {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Removed service discovery request");
        }

        public void onFailure(int reason) {
            Log.d(WifiDirectManager.Tag, "WifiDirectManager: Failed removing service discovery request");
        }
    }


    private class WifiDirectManMsgHandler extends Handler {

        final  WifiDirectManager mWifiDirectManager;

        public WifiDirectManMsgHandler(WifiDirectManager wifiDirectManager, Looper looper) {
            super(looper);
            this.mWifiDirectManager = wifiDirectManager;
        }

        public void handleMessage(Message msg) {
            if (msg != null) {
                switch (msg.what) {
                    case 65537:
                        Log.d(WifiDirectManager.Tag, "WifiDirectManager: peer connect");
                        this.mWifiDirectManager.starToConnect();
                        return;
                    default:
                        super.handleMessage(msg);
                        return;
                }
            }
        }
    }


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


    public void m4297a(WifiP2pManager wpm, Channel channel, Context context) {
        this.mWifiP2pManager = wpm;
        this.mChannel = channel;
        this.mContext = context;
    }


    public void init(Context context) {
        if (context != null) {
            Log.d(Tag, "WifiDirectManager: ++++++++ WifiP2pManager  init ++++++++");
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
                Log.d(Tag, "WifiDirectManager: init wifi_p2p_service : " + this.mWifiP2pManager);
                if (this.mWifiP2pManager != null) {
                    this.mChannel = this.mWifiP2pManager.initialize(this.mContext, Looper.getMainLooper(), null);
                    if (this.mChannel == null) {
                        Log.d(Tag, "WifiDirectManager: setup connection fail");
                        this.mWifiP2pManager = null;
                    }
                } else {
                    Log.d(Tag, "WifiDirectManager: mWifiP2pManager is null");
                }
            }
            if (!isWifiEnabled()) {
                Log.d(Tag, "WifiDirectManager: Wifi is disable, CarLife will open !");
                enabledWifi();
            }
            clearLocalServices();
        }
    }


    public WifiP2pManager getWifiP2pManager() {
        return this.mWifiP2pManager;
    }


    public Channel getChannel() {
        return this.mChannel;
    }


    public boolean clearLocalServices() {
        if (!isWifiEnabled()) {
            Log.d(Tag, "WifiDirectManager: Wifi is disable, CarLife will open !");
            enabledWifi();
        }
        this.mWifiP2pManager.clearLocalServices(this.mChannel, new WifiDirectManagerListener(this));
        return true;
    }


    public void sendMsg(int nWhat, int arg1, int arg2, Object obj) {
        Message msg = Message.obtain();
        msg.what = nWhat;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        this.mDirectManMsgHandler.sendMessage(msg);
    }


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


    private void stopDiscoverServices() {
        this.mWifiP2pManager.stopPeerDiscovery(this.mChannel, new StopPeerDiscoveryListener(this));
        Log.d(Tag, "Activity: WifiDirectManager: stopDiscoverServices");
    }


    private void initLocalService() {
        Map<String, String> record = new HashMap();
        record.put(AVAILABLE, "visible");
        this.mWifiP2pDnsSdServiceInfo = WifiP2pDnsSdServiceInfo.newInstance(CLF_WFD, CLF_WIFI, record);
        this.mWifiP2pManager.addLocalService(this.mChannel, this.mWifiP2pDnsSdServiceInfo, new AddLocalServiceListener(this));
    }


    private void setDnsSdResponseListener() {
        this.mWifiP2pManager.setDnsSdResponseListeners(this.mChannel, new WifManagerDnsSdResponseListeners(this),
                new WifManagerDnsSdTxtRecordListener(this));
        this.mWifiP2pManager.clearServiceRequests(this.mChannel, new WifiDirectManagerServiceListener(this));
    }

    public void onConnectionInfoAvailable(WifiP2pInfo p2pInfo) {
        if (p2pInfo.isGroupOwner) {
            Log.d(Tag, "WifiDirectManager: Activity:Connected as group owner");
            return;
        }
        Log.d(Tag, "WifiDirectManager: Activity:Connected as peer");
        try {
            this.mInetAddress = p2pInfo.groupOwnerAddress;
        } catch (Exception e) {
            Log.d(Tag, "WifiDirectManager: Failed to create connect thread - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void onPeersAvailable(WifiP2pDeviceList peerList) {
        Log.d(Tag, "WifiDirectManager: onPeersAvailable");
        this.mPeerDivice.clear();
        this.mPeerDivice.addAll(peerList.getDeviceList());
        for (int i = 0; i < this.mPeerDivice.size(); i++) {
            WifiP2pDevice device = (WifiP2pDevice) this.mPeerDivice.get(0);
            Log.d(Tag, "WifiDirectManager: dump device :" + i);
            Log.d(Tag, "WifiDirectManager:  : " + device.toString());
        }
        if (this.mPeerDivice.size() == 0) {
            Log.d(Tag, "WifiDirectManager: No devices found");
        } else {
            Log.d(Tag, "WifiDirectManager: Get peers : " + this.mPeerDivice.size());
        }
    }


    public void starToConnect() {
        if (this.mPeerDivice.size() == 0) {
            Log.d(Tag, "WifiDirectManager: Peer divice is null !");
            return;
        }
        WifiP2pDevice device = (WifiP2pDevice) this.mPeerDivice.get(0);
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = 0;
        Log.d(Tag, "@WifiDirectManager: Star to Connect device");
        this.mWifiP2pManager.connect(this.mChannel, config, new ConnectListener(this));
    }


    public void connectP2P(WifiP2pDevice device) {
        Log.d(Tag, "WifiDirectManager: connectP2P");
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = 0;
        this.mWifiP2pManager.connect(this.mChannel, config, new WifiP2pDeviceListener(this));
    }


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


    public void removeWifiP2pListener() {
        this.mWifiP2pManager.removeGroup(this.mChannel, new WifiP2pManagerRemoveListener(this));
    }


    public void m4305h() {
        Log.d(Tag, "WifiDirectManager: resetData");
        this.mWifiP2pDevice = null;
    }


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


    @SuppressLint("MissingPermission")
    private void enabledWifi() {
        this.mWifiManager.setWifiEnabled(true);
    }


    private void createGroupListener() {
        this.mWifiP2pManager.createGroup(this.mChannel, new WifiP2pManagerCreateListener(this));
    }
}
