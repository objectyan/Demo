package com.baidu.carlife.core.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;

public class ConnectServiceReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String Tag = "ConnectServiceReceiver";
    /* renamed from: b */
    private static final String ConnectServiceStartTag = "com.baidu.carlife.connect.ConnectServiceStart";
    /* renamed from: c */
    private static final String ConnectServiceStopTag = "com.baidu.carlife.connect.ConnectServiceStop";
    /* renamed from: d */
    private Context mContext = null;
    /* renamed from: e */
    private Handler mHandler = null;

    public ConnectServiceReceiver(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
    }

    /* renamed from: a */
    public void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectServiceStartTag);
        filter.addAction(ConnectServiceStopTag);
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
        msg.what = CommonParams.fg;
        if (action.equals(ConnectServiceStartTag)) {
            LogUtil.d(Tag, "start connect service");
            msg.arg1 = CommonParams.fh;
        } else if (action.equals(ConnectServiceStopTag)) {
            LogUtil.d(Tag, "stop connect service");
            msg.arg1 = CommonParams.fi;
        }
        this.mHandler.sendMessage(msg);
    }
}
