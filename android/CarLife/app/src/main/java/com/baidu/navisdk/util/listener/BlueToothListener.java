package com.baidu.navisdk.util.listener;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.util.ArrayList;
import java.util.List;

public class BlueToothListener extends BroadcastReceiver {
    public static final int MSG_TYPE_BT_CHANGE = 10601;
    public static final int MSG_TYPE_BT_SWITCH_CHANGE = 10602;
    private static final String TAG = "BlueToothListener";
    private static BluetoothAdapter ba;
    public static String deviceName = "";
    public static boolean isBTConnect = false;
    private static final List<Handler> outboxHandlers = new ArrayList();
    private static BlueToothListener sInstance = new BlueToothListener();
    public static boolean sIsOpenBTChannel = false;

    /* renamed from: com.baidu.navisdk.util.listener.BlueToothListener$1 */
    static class C47061 implements ServiceListener {
        C47061() {
        }

        public void onServiceDisconnected(int profile) {
            LogUtil.m15791e(BlueToothListener.TAG, "onServiceDisconnected");
        }

        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            LogUtil.m15791e(BlueToothListener.TAG, "onServiceConnected");
            List<BluetoothDevice> mDevices = proxy.getConnectedDevices();
            if (mDevices != null && mDevices.size() > 0) {
                LogUtil.m15791e(BlueToothListener.TAG, "connected devices not null");
                for (BluetoothDevice device : mDevices) {
                    if (device != null) {
                        BlueToothListener.deviceName = device.getName();
                    }
                }
                BlueToothListener.dispatchMessage(BlueToothListener.MSG_TYPE_BT_CHANGE, 1, 2);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_r_1, BlueToothListener.deviceName, null, null);
            }
        }
    }

    public BlueToothListener() {
        ba = BluetoothAdapter.getDefaultAdapter();
    }

    public static boolean isBlueConnect(Context context) {
        try {
            if (ba == null) {
                isBTConnect = false;
            } else if (ba.isEnabled()) {
                int a2dp = ba.getProfileConnectionState(2);
                int headset = ba.getProfileConnectionState(1);
                int health = ba.getProfileConnectionState(3);
                int flag = -1;
                int BluetoothProfileType = 2;
                if (a2dp == 2) {
                    flag = a2dp;
                    BluetoothProfileType = 2;
                } else if (headset == 2) {
                    flag = headset;
                    BluetoothProfileType = 1;
                } else if (health == 2) {
                    flag = health;
                    BluetoothProfileType = 3;
                }
                if (flag != -1) {
                    isBTConnect = true;
                    ba.getProfileProxy(context, new C47061(), BluetoothProfileType);
                }
            }
        } catch (Throwable th) {
        }
        return isBTConnect;
    }

    public static void registerReceiver(Context context) {
        try {
            isBTConnect = false;
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            filter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            filter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            filter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
            context.registerReceiver(sInstance, filter);
        } catch (Exception e) {
        }
    }

    public static void unregisterReceiver(Context context) {
        try {
            isBTConnect = false;
            context.unregisterReceiver(sInstance);
        } catch (Exception e) {
        }
    }

    public static void registerMessageHandler(Handler handler) {
        if (handler != null && !outboxHandlers.contains(handler)) {
            outboxHandlers.add(handler);
        }
    }

    public static void unRegisterMessageHandler(Handler handler) {
        if (handler != null && outboxHandlers.contains(handler)) {
            outboxHandlers.remove(handler);
        }
    }

    private static void dispatchMessage(int what, int arg1, int arg2) {
        if (!outboxHandlers.isEmpty()) {
            for (Handler handler : outboxHandlers) {
                Message.obtain(handler, what, arg1, arg2, null).sendToTarget();
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        LogUtil.m15791e(TAG, "onReceive action = " + action);
        int state;
        if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
            BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            state = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            String addr = "";
            if (device != null) {
                addr = device.getAddress();
            }
            LogUtil.m15791e(TAG, "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED: remote addr = " + addr + "state = " + state);
            switch (state) {
                case 0:
                    LogUtil.m15791e(TAG, "BluetoothProfile is STATE_DISCONNECTED");
                    isBTConnect = false;
                    dispatchMessage(MSG_TYPE_BT_CHANGE, 0, 0);
                    RGMapModeViewController.getInstance().resetAudio();
                    return;
                case 1:
                    LogUtil.m15791e(TAG, "BluetoothProfile is STATE_CONNECTING");
                    return;
                case 2:
                    LogUtil.m15791e(TAG, "BluetoothProfile is STATE_CONNECTED");
                    if (device != null) {
                        deviceName = device.getName();
                    }
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_r_1, deviceName, null, null);
                    isBTConnect = true;
                    dispatchMessage(MSG_TYPE_BT_CHANGE, 1, 0);
                    return;
                default:
                    return;
            }
        } else if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
            state = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 0);
            LogUtil.m15791e(TAG, "BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED: remote state = " + state);
            switch (state) {
                case 0:
                    LogUtil.m15791e(TAG, "BluetoothAdapter is STATE_DISCONNECTED");
                    isBTConnect = false;
                    return;
                case 1:
                    LogUtil.m15791e(TAG, "BluetoothAdapter is STATE_CONNECTING");
                    return;
                case 2:
                    LogUtil.m15791e(TAG, "BluetoothAdapter is STATE_CONNECTED");
                    isBTConnect = true;
                    return;
                default:
                    return;
            }
        } else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10)) {
                case 10:
                    LogUtil.m15791e(TAG, "BluetoothAdapter is STATE_OFF");
                    isBTConnect = false;
                    dispatchMessage(MSG_TYPE_BT_CHANGE, 0, 0);
                    RGMapModeViewController.getInstance().resetAudio();
                    return;
                case 11:
                    LogUtil.m15791e(TAG, "BluetoothAdapter is STATE_TURNING_ON");
                    return;
                case 12:
                    LogUtil.m15791e(TAG, "BluetoothAdapter is STATE_ON");
                    return;
                case 13:
                    LogUtil.m15791e(TAG, "BluetoothAdapter is STATE_TURNING_OFF");
                    return;
                default:
                    return;
            }
        } else if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(action)) {
            state = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            LogUtil.m15791e(TAG, "BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED BluetoothProfile.EXTRA_STATE state = " + state);
            switch (state) {
                case 10:
                    LogUtil.m15791e(TAG, "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED is BluetoothHeadset.STATE_AUDIO_DISCONNECTED");
                    if (!AudioUtils.sIsPhoneUsing) {
                        dispatchMessage(MSG_TYPE_BT_CHANGE, 2, 1);
                        return;
                    }
                    return;
                case 11:
                    LogUtil.m15791e(TAG, "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED is BluetoothHeadset.STATE_AUDIO_CONNECTING");
                    return;
                case 12:
                    LogUtil.m15791e(TAG, "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED is BluetoothHeadset.STATE_AUDIO_CONNECTED");
                    return;
                default:
                    return;
            }
        }
    }
}
