package com.baidu.carlife.core.connect;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener;
import android.util.Log;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;

public class WifiDirectBroadReceiver extends BroadcastReceiver {
    /* renamed from: b */
    private static final String Tag = "[WifiDirect]";
    private static final String ANDROID_NET_WIFI_WIFI_STATE_CHANGED = "android.net.wifi.WIFI_STATE_CHANGED";
    private static final String ANDROID_NET_WIFI_P2P_THIS_DEVICE_CHANGED = "android.net.wifi.p2p.THIS_DEVICE_CHANGED";
    private static final String ANDROID_NET_WIFI_P2P_STATE_CHANGED = "android.net.wifi.p2p.STATE_CHANGED";
    private static final String ANDROID_NET_WIFI_P2P_PEERS_CHANGED = "android.net.wifi.p2p.PEERS_CHANGED";
    private static final String ANDROID_NET_WIFI_P2P_CONNECTION_STATE_CHANGE = "android.net.wifi.p2p.CONNECTION_STATE_CHANGE";
    private static final String ANDROID_NET_WIFI_P2P_DISCOVERY_STATE_CHANGE = "android.net.wifi.p2p.DISCOVERY_STATE_CHANGE";
    /* renamed from: e */
    private static boolean mPeerConnected = false;
    /* renamed from: a */
    Activity mActivity = null;
    /* renamed from: c */
    private WifiP2pManager mWifiP2pManager;
    /* renamed from: d */
    private Channel mChannel;
    /* renamed from: f */
    private WifiDirectManager mWifiDirectManager = null;

    public WifiDirectBroadReceiver(WifiP2pManager manager, Channel channel, WifiDirectManager uWifiDirectManager) {
        this.mWifiP2pManager = manager;
        this.mChannel = channel;
        this.mWifiDirectManager = uWifiDirectManager;
    }

    public WifiDirectBroadReceiver(WifiP2pManager manager, Channel channel, Activity activity) {
        this.mWifiP2pManager = manager;
        this.mChannel = channel;
        this.mActivity = activity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        LogUtil.d(Tag, "BroadReceiver: -------------- : " + action);
        if (ANDROID_NET_WIFI_WIFI_STATE_CHANGED.equals(action)) {
            wifiState(context, intent);
            return;
        }
        int state;
        if (ANDROID_NET_WIFI_P2P_STATE_CHANGED.equals(action)) {
            state = intent.getIntExtra("wifi_p2p_state", -1);
            if (state == 2) {
                LogUtil.d(Tag, "BroadReceiver: state WIFI_P2P_STATE_ENABLED :" + state);
            } else {
                LogUtil.d(Tag, "BroadReceiver: state WIFI_P2P_STATE_DISABLED :" + state);
            }
        }
        if (ANDROID_NET_WIFI_P2P_PEERS_CHANGED.equals(action) && this.mWifiP2pManager != null) {
            LogUtil.d(Tag, "BroadReceiver: PEERS_CHANGED ");
        }
        if (ANDROID_NET_WIFI_P2P_THIS_DEVICE_CHANGED.equals(action)) {
            WifiP2pDevice device = (WifiP2pDevice) intent.getParcelableExtra("wifiP2pDevice");
            LogUtil.d(Tag, "BroadReceiver: Device status : " + device.status);
            if (device.status == 0) {
                LogUtil.d(Tag, "BroadReceiver: --------------------- peer connected");
                mPeerConnected = true;
            } else if (mPeerConnected) {
                LogUtil.d(Tag, "BroadReceiver: --------------------- peer disconnected reset discover");
                mPeerConnected = false;
                MsgHandlerCenter.dispatchMessageDelay((int) CommonParams.fp, 2000);
            }
        }
        if (ANDROID_NET_WIFI_P2P_CONNECTION_STATE_CHANGE.equals(action)) {
            LogUtil.d(Tag, "BroadReceiver: WIFI_P2P_CONNECTION_CHANGED_ACTION : ");
            if (this.mWifiP2pManager != null) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                LogUtil.d(Tag, "BroadReceiver: NetworkInfo Connect state : " + networkInfo.isConnected());
                if (networkInfo.isConnected()) {
                    LogUtil.d(Tag, "BroadReceiver: Connected to p2p network. Requesting network details");
                    if (this.mWifiDirectManager != null) {
                        this.mWifiP2pManager.requestConnectionInfo(this.mChannel, this.mWifiDirectManager);
                    } else if (this.mActivity != null) {
                        this.mWifiP2pManager.requestConnectionInfo(this.mChannel, (ConnectionInfoListener) this.mActivity);
                    }
                }
            } else {
                return;
            }
        }
        if (ANDROID_NET_WIFI_P2P_DISCOVERY_STATE_CHANGE.equals(action)) {
            state = intent.getIntExtra("discoveryState", -1);
            if (2 == state) {
                Log.d(Tag, "BroadReceiver: -------- WIFI_P2P_DISCOVERY_STARTED");
            } else if (1 == state) {
                Log.d(Tag, "BroadReceiver: -------- WIFI_P2P_DISCOVERY_STOPPED");
            } else {
                Log.d(Tag, "BroadReceiver: -------- Unknown state !");
            }
        }
    }

    /* renamed from: a */
    public void wifiState(Context context, Intent intent) {
        switch (intent.getIntExtra("wifi_state", 0)) {
            case 1:
                LogUtil.d(Tag, "Wifi State: Disabled");
                return;
            case 3:
                LogUtil.d(Tag, "Wifi State: Enabled");
                MsgHandlerCenter.dispatchMessageDelay((int) CommonParams.fq, 1000);
                return;
            default:
                return;
        }
    }
}
