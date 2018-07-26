package com.baidu.carlife.core.connect;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.LogUtil;

import java.util.ArrayList;

/* compiled from: ConnectServiceProxy */
/* renamed from: com.baidu.carlife.core.connect.f */
public class ConnectServiceProxy implements KeepClass {
    /* renamed from: a */
    private static final String Tag = "ConnectServiceProxy";
    /* renamed from: b */
    private static final String ConnectServiceProxyHandlerTag = "ConnectServiceProxyHandler";
    /* renamed from: c */
    private ArrayList<Messenger> mMessengers = new ArrayList();
    /* renamed from: d */
    private Context mContext;
    /* renamed from: e */
    private Handler mConnectServiceProxyHandler;

    /* compiled from: ConnectServiceProxy */
    /* renamed from: com.baidu.carlife.core.connect.f$a */
    private class ConnectServiceProxyHandler extends Handler {
        /* renamed from: a */
        final /* synthetic */ ConnectServiceProxy mServiceProxy;

        public ConnectServiceProxyHandler(ConnectServiceProxy connectServiceProxy, Looper looper) {
            super(looper);
            this.mServiceProxy = connectServiceProxy;
        }

        public void handleMessage(Message msg) {
            if (msg == null) {
                LogUtil.e(ConnectServiceProxy.Tag, "handleMessage error: msg is null");
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
                        LogUtil.d(ConnectServiceProxy.Tag, "Send Msg to Socket, what = 0x" + DigitalTrans.m4317a(msg.what, 8));
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

    /* renamed from: a */
    public Handler getConnectServiceProxyHandler() {
        return this.mConnectServiceProxyHandler;
    }
}
