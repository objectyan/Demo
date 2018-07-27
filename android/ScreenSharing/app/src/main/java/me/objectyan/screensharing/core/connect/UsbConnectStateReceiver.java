package me.objectyan.screensharing.core.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import me.objectyan.screensharing.core.CommonParams;
import me.objectyan.screensharing.core.LogUtil;

public class UsbConnectStateReceiver extends BroadcastReceiver {

    private static final String Tag = "UsbConnectStateReceiver";

    private static final String ANDROID_HARDWARE_USB_ACTION_USB_STATE = "android.hardware.usb.action.USB_STATE";

    private Context mContext = null;

    private Handler mHandler = null;

    private boolean f3199e = false;

    public UsbConnectStateReceiver(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
    }


    public void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ANDROID_HARDWARE_USB_ACTION_USB_STATE);
        this.mContext.registerReceiver(this, filter);
    }


    public void unregisterReceiver() {
        this.mContext.unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.mHandler == null) {
            Log.e(Tag, "mHandler is null");
            return;
        }
        String action = intent.getAction();
        Message msg = new Message();
        msg.what = 1031;
        if (action.equals(ANDROID_HARDWARE_USB_ACTION_USB_STATE)) {
            if (intent.getExtras().getBoolean("connected")) {
                Log.d(Tag, "usb connect is changed: connected");
                msg.arg1 = CommonParams.fe;
            } else {
                Log.d(Tag, "usb connect is changed: disconnected");
                msg.arg1 = CommonParams.ff;
            }
            this.mHandler.sendMessage(msg);
        }
    }
}
