package com.baidu.carlife.core.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;

public class ConnectServiceReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f3190a = "ConnectServiceReceiver";
    /* renamed from: b */
    private static final String f3191b = "com.baidu.carlife.connect.ConnectServiceStart";
    /* renamed from: c */
    private static final String f3192c = "com.baidu.carlife.connect.ConnectServiceStop";
    /* renamed from: d */
    private Context f3193d = null;
    /* renamed from: e */
    private Handler f3194e = null;

    public ConnectServiceReceiver(Context context, Handler handler) {
        this.f3193d = context;
        this.f3194e = handler;
    }

    /* renamed from: a */
    public void m4101a() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(f3191b);
        filter.addAction(f3192c);
        this.f3193d.registerReceiver(this, filter);
    }

    /* renamed from: b */
    public void m4102b() {
        this.f3193d.unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f3194e == null) {
            C1260i.m4445e(f3190a, "mHandler is null");
            return;
        }
        String action = intent.getAction();
        Message msg = new Message();
        msg.what = C1253f.fg;
        if (action.equals(f3191b)) {
            C1260i.m4435b(f3190a, "start connect service");
            msg.arg1 = C1253f.fh;
        } else if (action.equals(f3192c)) {
            C1260i.m4435b(f3190a, "stop connect service");
            msg.arg1 = C1253f.fi;
        }
        this.f3194e.sendMessage(msg);
    }
}
