package com.baidu.carlife.core.screen.presentation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnServiceDiedListener;
import com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService.C1293a;

/* compiled from: CarlifeServiceConnection */
/* renamed from: com.baidu.carlife.core.screen.presentation.f */
public class CarlifeServiceConnection implements ServiceConnection, KeepClass {
    /* renamed from: a */
    private static final String f3815a = "CarlifeActivity#ServiceConnection";
    /* renamed from: b */
    private Activity f3816b;
    /* renamed from: c */
    private DisplaySpec f3817c;
    /* renamed from: d */
    private AbsCarlifeActivityService f3818d;
    /* renamed from: e */
    private IBinder f3819e;
    /* renamed from: f */
    private OnServiceDiedListener f3820f;
    /* renamed from: g */
    private boolean f3821g;
    /* renamed from: h */
    private Class f3822h;
    /* renamed from: i */
    private DeathRecipient f3823i = new C13251(this);

    /* compiled from: CarlifeServiceConnection */
    /* renamed from: com.baidu.carlife.core.screen.presentation.f$1 */
    class C13251 implements DeathRecipient {
        /* renamed from: a */
        final /* synthetic */ CarlifeServiceConnection f3814a;

        C13251(CarlifeServiceConnection this$0) {
            this.f3814a = this$0;
        }

        public void binderDied() {
            LogUtil.d(CarlifeServiceConnection.f3815a, "binderDied()");
            this.f3814a.f3819e.unlinkToDeath(this.f3814a.f3823i, 0);
            if (this.f3814a.f3820f != null) {
                this.f3814a.f3820f.mo1463a();
            }
        }
    }

    public CarlifeServiceConnection(Activity activity, OnServiceDiedListener listener, DisplaySpec spec, Class serviceClass) {
        this.f3816b = activity;
        this.f3817c = spec;
        this.f3820f = listener;
        this.f3822h = serviceClass;
    }

    public void onServiceConnected(ComponentName name, IBinder binder) {
        LogUtil.d(f3815a, "onServiceConnected className=" + name);
        AbsCarlifeActivityService service = ((C1293a) binder).m4596a();
        this.f3821g = true;
        m4751a(binder);
        if (service != null) {
            this.f3818d = service;
            service.m4616b(this.f3817c);
            return;
        }
        try {
            this.f3816b.unbindService(this);
        } catch (IllegalArgumentException e) {
            LogUtil.m4445e(f3815a, e.getMessage());
        }
    }

    /* renamed from: a */
    private void m4751a(IBinder binder) {
        this.f3819e = binder;
        try {
            binder.linkToDeath(this.f3823i, 0);
            LogUtil.d(f3815a, "bindDeathRecipient binder=" + binder);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        LogUtil.d(f3815a, "onServiceDisconnected componentName=" + name);
        try {
            this.f3816b.unbindService(this);
        } catch (IllegalArgumentException e) {
            LogUtil.m4445e(f3815a, e.getMessage());
        }
    }

    /* renamed from: a */
    public void m4754a() {
        LogUtil.d(f3815a, "unBindService()");
        if (this.f3821g) {
            try {
                this.f3816b.unbindService(this);
                this.f3816b.stopService(new Intent(this.f3816b, this.f3822h));
            } catch (Exception e) {
            }
        }
        this.f3821g = false;
    }

    /* renamed from: b */
    public void m4755b() {
        if (this.f3818d != null) {
            this.f3818d.m4615b();
        }
    }
}
