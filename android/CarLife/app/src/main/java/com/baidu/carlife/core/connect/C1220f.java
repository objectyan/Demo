package com.baidu.carlife.core.connect;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.baidu.carlife.core.C0689h;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import java.util.ArrayList;

/* compiled from: ConnectServiceProxy */
/* renamed from: com.baidu.carlife.core.connect.f */
public class C1220f implements C0689h {
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
        final /* synthetic */ C1220f f3359a;

        public C1219a(C1220f c1220f, Looper looper) {
            this.f3359a = c1220f;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg == null) {
                C1260i.m4445e(C1220f.f3360a, "handleMessage error: msg is null");
                return;
            }
            switch (msg.what) {
                case C1253f.eL /*901*/:
                    this.f3359a.f3362c.add(msg.replyTo);
                    return;
                case C1253f.eM /*902*/:
                    this.f3359a.f3362c.remove(msg.replyTo);
                    return;
                case C1253f.eN /*903*/:
                    return;
                default:
                    if (msg.arg1 == 1001) {
                        C1260i.m4435b(C1220f.f3360a, "Send Msg to Socket, what = 0x" + C1247j.m4317a(msg.what, 8));
                        if (msg.what == C1253f.f3536C || C1218e.m4228a().m4252g()) {
                            C1218e.m4228a().m4235a((C1212c) msg.obj);
                        }
                    }
                    super.handleMessage(msg);
                    return;
            }
        }
    }

    public C1220f(Context context) {
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
