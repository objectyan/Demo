package com.baidu.che.codriver.sdk;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.che.codriver.C2511b;

/* compiled from: ClientDeathRecipient */
/* renamed from: com.baidu.che.codriver.sdk.a */
public class C2611a implements DeathRecipient {
    /* renamed from: a */
    public static final String f8635a = "ClientDeathRecipient";
    /* renamed from: b */
    private C2618b f8636b;
    /* renamed from: c */
    private C2511b f8637c;
    /* renamed from: d */
    private IBinder f8638d;

    public C2611a(C2618b impl, C2511b listener) {
        if (listener != null) {
            this.f8636b = impl;
            this.f8637c = listener;
            this.f8638d = listener.asBinder();
        }
    }

    public void binderDied() {
        Log.d(f8635a, "binderDied:" + this.f8638d);
        if (this.f8636b != null) {
            try {
                this.f8636b.mo1874a(this.f8637c);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m9835a() {
        if (this.f8638d != null) {
            Log.d(f8635a, "linkToDeath:" + this.f8638d);
            try {
                this.f8638d.linkToDeath(this, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void m9836b() {
        if (this.f8638d != null) {
            Log.d(f8635a, "unlinkToDeath:" + this.f8638d);
            this.f8638d.unlinkToDeath(this, 0);
            this.f8636b = null;
        }
    }
}
