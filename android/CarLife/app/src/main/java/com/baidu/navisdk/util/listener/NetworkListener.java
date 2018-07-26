package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import java.util.ArrayList;
import java.util.List;

public class NetworkListener extends BroadcastReceiver {
    public static final int MSG_TYPE_NET_WORK_CHANGE = 5555;
    private static final String TAG = "NetworkListener";
    private static Object mListenerLock = new Object();
    private static final List<Handler> outboxHandlers = new ArrayList();
    private boolean mIsCareMobileNetworkChange;

    public NetworkListener() {
        this.mIsCareMobileNetworkChange = false;
        this.mIsCareMobileNetworkChange = false;
    }

    public NetworkListener(boolean careMobileNetworkChange) {
        this.mIsCareMobileNetworkChange = false;
        this.mIsCareMobileNetworkChange = careMobileNetworkChange;
    }

    public static void registerMessageHandler(Handler handler) {
        synchronized (mListenerLock) {
            if (handler != null) {
                if (!outboxHandlers.contains(handler)) {
                    outboxHandlers.add(handler);
                }
            }
        }
    }

    public static void unRegisterMessageHandler(Handler handler) {
        synchronized (mListenerLock) {
            if (handler != null) {
                if (outboxHandlers.contains(handler)) {
                    outboxHandlers.remove(handler);
                }
            }
        }
    }

    private static void dispatchMessage(int what, int arg1, int arg2) {
        LogUtil.m15791e("NetworkListener", "dispatchMessage arg1=" + arg1 + "arg2=" + arg2);
        synchronized (mListenerLock) {
            List<Handler> tempHandlers = new ArrayList(outboxHandlers);
        }
        if (!tempHandlers.isEmpty()) {
            for (Handler handler : tempHandlers) {
                if (handler != null) {
                    Message msg = Message.obtain(handler, what, arg1, arg2, null);
                    if (msg != null) {
                        msg.sendToTarget();
                    }
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetInfo = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                int wifiState;
                int connectState;
                activeNetInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetInfo != null) {
                    int NetworkType = activeNetInfo.getType();
                    boolean bConnected = activeNetInfo.isConnected();
                    switch (NetworkType) {
                        case 0:
                            wifiState = 0;
                            break;
                        case 1:
                            if (bConnected) {
                                wifiState = 1;
                            } else {
                                wifiState = 0;
                            }
                            break;
                        default:
                            wifiState = 0;
                            break;
                    }
                    if (bConnected) {
                        connectState = 1;
                    } else {
                        connectState = 0;
                    }
                } else {
                    wifiState = 0;
                    connectState = 0;
                }
                if (wifiState != NetworkUtils.mWifiState || this.mIsCareMobileNetworkChange) {
                    if (!(wifiState == NetworkUtils.mWifiState && connectState == NetworkUtils.mConnectState)) {
                        LogUtil.m15791e("NetworkListener", "network TYPE=" + wifiState + "CONNECT=" + NetworkUtils.mConnectState);
                        NetworkUtils.mWifiState = wifiState;
                        NetworkUtils.mConnectState = connectState;
                        dispatchMessage(MSG_TYPE_NET_WORK_CHANGE, wifiState, NetworkUtils.mConnectState);
                    }
                    NetworkUtils.mWifiState = wifiState;
                    NetworkUtils.mConnectState = connectState;
                    if (-1 != NetworkUtils.mWifiState) {
                        NetworkUtils.ChangeGprsConnect(context);
                        return;
                    }
                    return;
                }
                NetworkUtils.mConnectState = connectState;
            }
        } catch (Exception e) {
        }
    }
}
