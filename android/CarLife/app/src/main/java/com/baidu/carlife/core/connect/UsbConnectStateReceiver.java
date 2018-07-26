package com.baidu.carlife.core.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;

public class UsbConnectStateReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f3195a = "UsbConnectStateReceiver";
    /* renamed from: b */
    private static final String f3196b = "android.hardware.usb.action.USB_STATE";
    /* renamed from: c */
    private Context f3197c = null;
    /* renamed from: d */
    private Handler f3198d = null;
    /* renamed from: e */
    private boolean f3199e = false;

    public UsbConnectStateReceiver(Context context, Handler handler) {
        this.f3197c = context;
        this.f3198d = handler;
    }

    /* renamed from: a */
    public void m4103a() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(f3196b);
        this.f3197c.registerReceiver(this, filter);
    }

    /* renamed from: b */
    public void m4104b() {
        this.f3197c.unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f3198d == null) {
            C1260i.m4445e(f3195a, "mHandler is null");
            return;
        }
        String action = intent.getAction();
        Message msg = new Message();
        msg.what = 1031;
        if (action.equals(f3196b)) {
            if (intent.getExtras().getBoolean("connected")) {
                C1260i.m4435b(f3195a, "usb connect is changed: connected");
                msg.arg1 = C1253f.fe;
            } else {
                C1260i.m4435b(f3195a, "usb connect is changed: disconnected");
                msg.arg1 = C1253f.ff;
            }
            this.f3198d.sendMessage(msg);
        }
    }
}
