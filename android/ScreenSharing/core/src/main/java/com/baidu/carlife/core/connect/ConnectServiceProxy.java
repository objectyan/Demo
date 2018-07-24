package com.baidu.carlife.core.connect;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import java.util.ArrayList;

/* compiled from: ConnectServiceProxy */
/* renamed from: com.baidu.carlife.core.connect.f */
public class ConnectServiceProxy implements KeepClass {
    /* renamed from: a */
    private static final String f3360a = "ConnectServiceProxy";
    /* renamed from: b */
    private static final String f3361b = "ConnectServiceProxyHandler";
    /* renamed from: c */
    private ArrayList<Messenger> f3362c = new ArrayList();
    /* renamed from: d */
    private Context f3363d;
    /* renamed from: e */
    private Handler f3364e;

    /* compiled from: ConnectServiceProxy */
    /* renamed from: com.baidu.carlife.core.connect.f$a */
    private class C1219a extends Handler {
        /* renamed from: a */
        final /* synthetic */ ConnectServiceProxy f3359a;

        public C1219a(ConnectServiceProxy connectServiceProxy, Looper looper) {
            this.f3359a = connectServiceProxy;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg == null) {
                LogUtil.m4445e(ConnectServiceProxy.f3360a, "handleMessage error: msg is null");
                return;
            }
            switch (msg.what) {
                case CommonParams.eL /*901*/:
                    this.f3359a.f3362c.add(msg.replyTo);
                    return;
                case CommonParams.eM /*902*/:
                    this.f3359a.f3362c.remove(msg.replyTo);
                    return;
                case CommonParams.eN /*903*/:
                    return;
                default:
                    if (msg.arg1 == 1001) {
                        LogUtil.d(ConnectServiceProxy.f3360a, "Send Msg to Socket, what = 0x" + DigitalTrans.m4317a(msg.what, 8));
                        if (msg.what == CommonParams.f3536C || ConnectManager.m4228a().m4252g()) {
                            ConnectManager.m4228a().m4235a((CarlifeCmdMessage) msg.obj);
                        }
                    }
                    super.handleMessage(msg);
                    return;
            }
        }
    }

    public ConnectServiceProxy(Context context) {
        this.f3363d = context;
        HandlerThread handlerThread = new HandlerThread(f3361b);
        handlerThread.start();
        this.f3364e = new C1219a(this, handlerThread.getLooper());
    }

    /* renamed from: a */
    public Handler m4257a() {
        return this.f3364e;
    }
}
