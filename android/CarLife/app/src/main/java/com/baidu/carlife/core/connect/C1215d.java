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
import com.baidu.carlife.core.C0689h;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;

/* compiled from: ConnectClient */
/* renamed from: com.baidu.carlife.core.connect.d */
public class C1215d implements C0689h {
    /* renamed from: a */
    private static final String f3308a = "ConnectClient";
    /* renamed from: b */
    private static final String f3309b = "ConnectClientHandlerThread";
    /* renamed from: l */
    private static C1215d f3310l = null;
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
        final /* synthetic */ C1215d f3306a;

        C12131(C1215d this$0) {
            this.f3306a = this$0;
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            C1260i.m4435b(C1215d.f3308a, "onServiceConnected");
            this.f3306a.f3319k = true;
            this.f3306a.f3315g = new Messenger(service);
            this.f3306a.m4223a(Message.obtain(null, C1253f.eL));
        }

        public void onServiceDisconnected(ComponentName name) {
            C1260i.m4435b(C1215d.f3308a, "onServiceDisconnected");
            this.f3306a.f3319k = false;
            this.f3306a.f3315g = null;
        }
    }

    /* compiled from: ConnectClient */
    /* renamed from: com.baidu.carlife.core.connect.d$a */
    private class C1214a extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1215d f3307a;

        public C1214a(C1215d c1215d, Looper looper) {
            this.f3307a = c1215d;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg != null) {
                switch (msg.what) {
                    case 1031:
                        if (msg.arg1 == C1253f.fe) {
                            this.f3307a.f3317i = true;
                            C1260i.m4445e(C1215d.f3308a, "USB Cable is connected!");
                            return;
                        } else if (msg.arg1 == C1253f.ff) {
                            this.f3307a.f3317i = false;
                            C1260i.m4445e(C1215d.f3308a, "USB Cable is disconnected!");
                            if (C1218e.m4228a().m4240b() == 2 && this.f3307a.f3318j) {
                                this.f3307a.m4222a(false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case C1253f.fg /*1034*/:
                        if (msg.arg1 == C1253f.fh) {
                            this.f3307a.m4215g();
                            return;
                        } else if (msg.arg1 == C1253f.fi) {
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
    public static C1215d m4207a() {
        if (f3310l == null) {
            synchronized (C1215d.class) {
                if (f3310l == null) {
                    f3310l = new C1215d();
                }
            }
        }
        return f3310l;
    }

    private C1215d() {
    }

    /* renamed from: a */
    public void m4221a(Context context) {
        C1260i.m4435b(f3308a, "init");
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
            C1260i.m4445e(f3308a, "UsbConnectStateManager init fail");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m4224b() {
        C1260i.m4435b(f3308a, "uninit");
        try {
            m4219k();
            m4220l();
            m4216h();
        } catch (Exception e) {
            C1260i.m4445e(f3308a, "UsbConnectStateManager uninit fail");
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m4213e() {
        C1260i.m4435b(f3308a, "start ConnectService");
        this.f3311c.startService(new Intent(this.f3311c, ConnectService.class));
    }

    /* renamed from: f */
    private void m4214f() {
        C1260i.m4435b(f3308a, "stop ConnectService");
        this.f3311c.stopService(new Intent(this.f3311c, ConnectService.class));
    }

    /* renamed from: g */
    private void m4215g() {
        C1260i.m4435b(f3308a, "bind ConnectService");
        this.f3311c.bindService(new Intent(this.f3311c, ConnectService.class), this.f3320m, 1);
    }

    /* renamed from: h */
    private void m4216h() {
        C1260i.m4435b(f3308a, "unbind ConnectService");
        this.f3311c.unbindService(this.f3320m);
        m4223a(Message.obtain(null, C1253f.eM));
    }

    /* renamed from: i */
    private void m4217i() {
        if (this.f3312d != null) {
            this.f3312d.m4101a();
            C1260i.m4435b(f3308a, "register ConnectServiceReceiver");
        }
    }

    /* renamed from: j */
    private void m4218j() {
        if (this.f3313e != null) {
            this.f3313e.m4103a();
            C1260i.m4435b(f3308a, "register UsbConnectStateReceiver");
        }
    }

    /* renamed from: k */
    private void m4219k() {
        if (this.f3312d != null) {
            this.f3312d.m4102b();
            C1260i.m4435b(f3308a, "unregister ConnectServiceReceiver");
        }
    }

    /* renamed from: l */
    private void m4220l() {
        if (this.f3313e != null) {
            this.f3313e.m4104b();
            C1260i.m4435b(f3308a, "unregister UsbConnectStateReceiver");
        }
    }

    /* renamed from: a */
    public boolean m4223a(Message msg) {
        C1260i.m4435b(f3308a, "Send Msg to Service, what = 0x" + C1247j.m4317a(msg.what, 8));
        if (this.f3315g == null) {
            C1260i.m4445e(f3308a, "mConnectService is null");
            return false;
        } else if (this.f3316h == null) {
            C1260i.m4445e(f3308a, "mConnectClient is null");
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
            C1261k.m4461b(1002);
        } else if (!m4225c() && is) {
            this.f3318j = is;
            C1261k.m4461b(1004);
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
