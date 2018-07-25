package com.baidu.carlife.core.connect;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;

/* compiled from: ConnectClient */
/* renamed from: com.baidu.carlife.core.connect.d */
public class ConnectClient implements KeepClass {
    /* renamed from: a */
    private static final String f3308a = "ConnectClient";
    /* renamed from: b */
    private static final String f3309b = "ConnectClientHandlerThread";
    /* renamed from: l */
    private static ConnectClient sConnectClient = null;
    /* renamed from: c */
    private Context f3311c = null;
    /* renamed from: d */
    private ConnectServiceReceiver f3312d = null;
    /* renamed from: e */
    private UsbConnectStateReceiver f3313e = null;
    /* renamed from: f */
    private C1214a f3314f = null;
    /* renamed from: g */
    private Messenger f3315g = null;
    /* renamed from: h */
    private Messenger f3316h = null;
    /* renamed from: i */
    private boolean f3317i = true;
    /* renamed from: j */
    private boolean f3318j = false;
    /* renamed from: k */
    private boolean f3319k = false;
    /* renamed from: m */
    private ServiceConnection f3320m = new C12131(this);

    /* compiled from: ConnectClient */
    /* renamed from: com.baidu.carlife.core.connect.d$1 */
    class C12131 implements ServiceConnection {
        /* renamed from: a */
        final /* synthetic */ ConnectClient f3306a;

        C12131(ConnectClient this$0) {
            this.f3306a = this$0;
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtil.d(ConnectClient.f3308a, "onServiceConnected");
            this.f3306a.f3319k = true;
            this.f3306a.f3315g = new Messenger(service);
            this.f3306a.m4223a(Message.obtain(null, CommonParams.eL));
        }

        public void onServiceDisconnected(ComponentName name) {
            LogUtil.d(ConnectClient.f3308a, "onServiceDisconnected");
            this.f3306a.f3319k = false;
            this.f3306a.f3315g = null;
        }
    }

    /* compiled from: ConnectClient */
    /* renamed from: com.baidu.carlife.core.connect.d$a */
    private class C1214a extends Handler {
        /* renamed from: a */
        final /* synthetic */ ConnectClient f3307a;

        public C1214a(ConnectClient connectClient, Looper looper) {
            this.f3307a = connectClient;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg != null) {
                switch (msg.what) {
                    case 1031:
                        if (msg.arg1 == CommonParams.fe) {
                            this.f3307a.f3317i = true;
                            LogUtil.e(ConnectClient.f3308a, "USB Cable is connected!");
                            return;
                        } else if (msg.arg1 == CommonParams.ff) {
                            this.f3307a.f3317i = false;
                            LogUtil.e(ConnectClient.f3308a, "USB Cable is disconnected!");
                            if (ConnectManager.newInstance().getType() == 2 && this.f3307a.f3318j) {
                                this.f3307a.m4222a(false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case CommonParams.fg /*1034*/:
                        if (msg.arg1 == CommonParams.fh) {
                            this.f3307a.m4215g();
                            return;
                        } else if (msg.arg1 == CommonParams.fi) {
                            this.f3307a.m4216h();
                            return;
                        } else {
                            return;
                        }
                    default:
                        super.handleMessage(msg);
                        return;
                }
            }
        }
    }

    /* renamed from: a */
    public static ConnectClient newInstance() {
        if (sConnectClient == null) {
            synchronized (ConnectClient.class) {
                if (sConnectClient == null) {
                    sConnectClient = new ConnectClient();
                }
            }
        }
        return sConnectClient;
    }

    private ConnectClient() {
    }

    /* renamed from: a */
    public void m4221a(Context context) {
        LogUtil.d(f3308a, "init");
        this.f3311c = context;
        HandlerThread handlerThread = new HandlerThread(f3309b);
        handlerThread.start();
        this.f3314f = new C1214a(this, handlerThread.getLooper());
        this.f3316h = new Messenger(this.f3314f);
        this.f3312d = new ConnectServiceReceiver(context, this.f3314f);
        this.f3313e = new UsbConnectStateReceiver(context, this.f3314f);
        try {
            m4217i();
            m4218j();
            m4215g();
        } catch (Exception e) {
            LogUtil.e(f3308a, "UsbConnectStateManager init fail");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m4224b() {
        LogUtil.d(f3308a, "uninit");
        try {
            m4219k();
            m4220l();
            m4216h();
        } catch (Exception e) {
            LogUtil.e(f3308a, "UsbConnectStateManager uninit fail");
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m4213e() {
        LogUtil.d(f3308a, "start ConnectService");
        this.f3311c.startService(new Intent(this.f3311c, ConnectService.class));
    }

    /* renamed from: f */
    private void m4214f() {
        LogUtil.d(f3308a, "stop ConnectService");
        this.f3311c.stopService(new Intent(this.f3311c, ConnectService.class));
    }

    /* renamed from: g */
    private void m4215g() {
        LogUtil.d(f3308a, "bind ConnectService");
        this.f3311c.bindService(new Intent(this.f3311c, ConnectService.class), this.f3320m, 1);
    }

    /* renamed from: h */
    private void m4216h() {
        LogUtil.d(f3308a, "unbind ConnectService");
        this.f3311c.unbindService(this.f3320m);
        m4223a(Message.obtain(null, CommonParams.eM));
    }

    /* renamed from: i */
    private void m4217i() {
        if (this.f3312d != null) {
            this.f3312d.m4101a();
            LogUtil.d(f3308a, "register ConnectServiceReceiver");
        }
    }

    /* renamed from: j */
    private void m4218j() {
        if (this.f3313e != null) {
            this.f3313e.m4103a();
            LogUtil.d(f3308a, "register UsbConnectStateReceiver");
        }
    }

    /* renamed from: k */
    private void m4219k() {
        if (this.f3312d != null) {
            this.f3312d.m4102b();
            LogUtil.d(f3308a, "unregister ConnectServiceReceiver");
        }
    }

    /* renamed from: l */
    private void m4220l() {
        if (this.f3313e != null) {
            this.f3313e.m4104b();
            LogUtil.d(f3308a, "unregister UsbConnectStateReceiver");
        }
    }

    /* renamed from: a */
    public boolean m4223a(Message msg) {
        LogUtil.d(f3308a, "Send Msg to Service, what = 0x" + DigitalTrans.m4317a(msg.what, 8));
        if (this.f3315g == null) {
            LogUtil.e(f3308a, "mConnectService is null");
            return false;
        } else if (this.f3316h == null) {
            LogUtil.e(f3308a, "mConnectClient is null");
            return false;
        } else {
            try {
                msg.replyTo = this.f3316h;
                this.f3315g.send(msg);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: a */
    public synchronized void m4222a(boolean is) {
        if (m4225c() && !is) {
            this.f3318j = is;
            MsgHandlerCenter.dispatchMessage(1002);
        } else if (!m4225c() && is) {
            this.f3318j = is;
            MsgHandlerCenter.dispatchMessage(1004);
        }
    }

    /* renamed from: c */
    public boolean m4225c() {
        return this.f3318j;
    }

    /* renamed from: d */
    public boolean m4226d() {
        return this.f3317i;
    }
}
