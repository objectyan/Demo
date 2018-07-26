package com.baidu.carlife.core.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;

public class UsbConnectStateReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String Tag = "UsbConnectStateReceiver";
    /* renamed from: b */
    private static final String ANDROID_HARDWARE_USB_ACTION_USB_STATE = "android.hardware.usb.action.USB_STATE";
    /* renamed from: c */
    private Context mContext = null;
    /* renamed from: d */
    private Handler mHandler = null;
    /* renamed from: e */
    private boolean f3199e = false;

    public UsbConnectStateReceiver(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
    }

    /* renamed from: a */
    public void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ANDROID_HARDWARE_USB_ACTION_USB_STATE);
        this.mContext.registerReceiver(this, filter);
    }

    /* renamed from: b */
    public void unregisterReceiver() {
        this.mContext.unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.mHandler == null) {
            LogUtil.e(Tag, "mHandler is null");
            return;
        }
        String action = intent.getAction();
        Message msg = new Message();
        msg.what = 1031;
        if (action.equals(ANDROID_HARDWARE_USB_ACTION_USB_STATE)) {
            if (intent.getExtras().getBoolean("connected")) {
                LogUtil.d(Tag, "usb connect is changed: connected");
                msg.arg1 = CommonParams.fe;
            } else {
                LogUtil.d(Tag, "usb connect is changed: disconnected");
                msg.arg1 = CommonParams.ff;
            }
            this.mHandler.sendMessage(msg);
        }
    }
}
