package com.baidu.che.codriver.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.che.codriver.C2511b;
import com.baidu.che.codriver.C2520c.C2522a;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2604b;
import com.baidu.che.codriver.util.C2725h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: ICoDriverServiceImpl */
/* renamed from: com.baidu.che.codriver.sdk.b */
public class C2618b extends C2522a implements C2604b {
    /* renamed from: d */
    public static final String f8660d = "[sdk_server] ICoDriverServiceImpl";
    /* renamed from: e */
    private Map<IBinder, C2616a> f8661e = new HashMap();
    /* renamed from: f */
    private Handler f8662f = new Handler();
    /* renamed from: g */
    private HandlerThread f8663g = new HandlerThread("RequestThread");
    /* renamed from: h */
    private Handler f8664h;

    /* compiled from: ICoDriverServiceImpl */
    /* renamed from: com.baidu.che.codriver.sdk.b$a */
    private static class C2616a {
        /* renamed from: a */
        String f8655a;
        /* renamed from: b */
        C2511b f8656b;
        /* renamed from: c */
        C2611a f8657c;
        /* renamed from: d */
        Set<String> f8658d;

        private C2616a() {
        }
    }

    /* renamed from: b */
    public String mo1888b(String pkg, String cmd, String param, String data) {
        C2725h.m10207b(f8660d, "sendCmdToClient pkg=" + pkg + " cmd=" + cmd + " param=" + param);
        for (final C2616a item : this.f8661e.values()) {
            if (item.f8658d.contains(cmd) && item.f8656b != null) {
                final String str = pkg;
                final String str2 = cmd;
                final String str3 = param;
                final String str4 = data;
                this.f8664h.post(new Runnable(this) {
                    /* renamed from: f */
                    final /* synthetic */ C2618b f8644f;

                    public void run() {
                        try {
                            item.f8656b.mo1872a(str, str2, str3, str4);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo1886a(String pkg, String cmdType) {
        for (C2616a item : this.f8661e.values()) {
            if (item.f8655a.equals(pkg)) {
                item.f8658d.add(cmdType);
            } else {
                item.f8658d.remove(cmdType);
            }
        }
    }

    /* renamed from: a */
    public boolean mo1887a(String cmdType) {
        for (C2616a item : this.f8661e.values()) {
            if (item.f8658d.contains(cmdType)) {
                return true;
            }
        }
        return false;
    }

    public C2618b() {
        this.f8663g.start();
        this.f8664h = new Handler(this.f8663g.getLooper());
    }

    /* renamed from: a */
    public String mo1873a(String pkg, String cmd, String param, String data) throws RemoteException {
        C2725h.m10207b(f8660d, "sendCommand pkg=" + pkg + " cmd=" + cmd + " param=" + param);
        final String str = pkg;
        final String str2 = cmd;
        final String str3 = param;
        final String str4 = data;
        this.f8662f.post(new Runnable(this) {
            /* renamed from: e */
            final /* synthetic */ C2618b f8649e;

            public void run() {
                C2606l.m9828a().m9832a(str, str2, str3, str4);
            }
        });
        return null;
    }

    /* renamed from: a */
    public void mo1875a(final String pkg, final C2511b listener) throws RemoteException {
        C2725h.m10207b(f8660d, "registerListener pkg=" + pkg);
        this.f8662f.post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C2618b f8652c;

            public void run() {
                this.f8652c.m9841b(pkg, listener);
            }
        });
    }

    /* renamed from: b */
    private void m9841b(String pkg, C2511b listener) {
        if (listener != null) {
            IBinder binder = listener.asBinder();
            if (this.f8661e.containsKey(binder)) {
                C2725h.m10207b(f8660d, "already registered");
                return;
            }
            C2611a deathRecipient = new C2611a(this, listener);
            deathRecipient.m9835a();
            C2616a data = new C2616a();
            data.f8655a = pkg;
            data.f8656b = listener;
            data.f8657c = deathRecipient;
            data.f8658d = new HashSet();
            this.f8661e.put(binder, data);
        }
    }

    /* renamed from: a */
    public void mo1874a(final C2511b listener) throws RemoteException {
        this.f8662f.post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C2618b f8654b;

            public void run() {
                this.f8654b.m9840b(listener);
            }
        });
    }

    /* renamed from: b */
    private void m9840b(C2511b listener) {
        if (listener != null) {
            C2616a data = (C2616a) this.f8661e.remove(listener.asBinder());
            if (data != null) {
                C2611a deathRecipient = data.f8657c;
                if (deathRecipient != null) {
                    deathRecipient.m9836b();
                }
                for (String cmdType : data.f8658d) {
                    C2725h.m10207b(f8660d, "reset pkg=" + data.f8655a + " cmd=" + cmdType);
                    C2606l.m9828a().m9832a(data.f8655a, cmdType, "reset", null);
                }
                return;
            }
            C2725h.m10207b(f8660d, "already unregistered");
        }
    }
}
