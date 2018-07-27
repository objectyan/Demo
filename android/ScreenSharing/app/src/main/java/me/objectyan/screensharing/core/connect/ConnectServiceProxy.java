package me.objectyan.screensharing.core.connect;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;


import me.objectyan.screensharing.core.LogUtil;

import java.util.ArrayList;


public class ConnectServiceProxy  {

    private static final String Tag = "ConnectServiceProxy";

    private static final String ConnectServiceProxyHandlerTag = "ConnectServiceProxyHandler";

    private ArrayList<Messenger> mMessengers = new ArrayList();

    private Context mContext;

    private Handler mConnectServiceProxyHandler;


    private class ConnectServiceProxyHandler extends Handler {

        final  ConnectServiceProxy mServiceProxy;

        public ConnectServiceProxyHandler(ConnectServiceProxy connectServiceProxy, Looper looper) {
            super(looper);
            this.mServiceProxy = connectServiceProxy;
        }

        public void handleMessage(Message msg) {
            if (msg == null) {
                Log.e(ConnectServiceProxy.Tag, "handleMessage error: msg is null");
                return;
            }
            switch (msg.what) {
                case 901:
                    this.mServiceProxy.mMessengers.add(msg.replyTo);
                    return;
                case 902:
                    this.mServiceProxy.mMessengers.remove(msg.replyTo);
                    return;
                case 903:
                    return;
                default:
                    if (msg.arg1 == 1001) {
                        Log.d(ConnectServiceProxy.Tag, "Send Msg to Socket, what = 0x" + DigitalTrans.m4317a(msg.what, 8));
                        if (msg.what == 65538 || ConnectManager.newInstance().getIS()) {
                            ConnectManager.newInstance().write((CarlifeCmdMessage) msg.obj);
                        }
                    }
                    super.handleMessage(msg);
                    return;
            }
        }
    }

    public ConnectServiceProxy(Context context) {
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread(ConnectServiceProxyHandlerTag);
        handlerThread.start();
        this.mConnectServiceProxyHandler = new ConnectServiceProxyHandler(this, handlerThread.getLooper());
    }


    public Handler getConnectServiceProxyHandler() {
        return this.mConnectServiceProxyHandler;
    }
}
