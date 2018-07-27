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

public class ConnectServiceReceiver extends BroadcastReceiver {

    private static final String Tag = "ConnectServiceReceiver";

    private static final String ConnectServiceStartTag = "me.objectyan.screensharing.connect.ConnectServiceStart";

    private static final String ConnectServiceStopTag = "me.objectyan.screensharing.connect.ConnectServiceStop";

    private Context mContext = null;

    private Handler mHandler = null;

    public ConnectServiceReceiver(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
    }


    public void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectServiceStartTag);
        filter.addAction(ConnectServiceStopTag);
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
        msg.what = CommonParams.fg;
        if (action.equals(ConnectServiceStartTag)) {
            Log.d(Tag, "start connect service");
            msg.arg1 = CommonParams.fh;
        } else if (action.equals(ConnectServiceStopTag)) {
            Log.d(Tag, "stop connect service");
            msg.arg1 = CommonParams.fi;
        }
        this.mHandler.sendMessage(msg);
    }
}
