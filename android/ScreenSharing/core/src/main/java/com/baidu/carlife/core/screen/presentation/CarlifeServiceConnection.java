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
import com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService.AbsCarlifeActivityServiceBinder;

/* compiled from: CarlifeServiceConnection */
/* renamed from: com.baidu.carlife.core.screen.presentation.f */
public class CarlifeServiceConnection implements ServiceConnection, KeepClass {
    /* renamed from: a */
    private static final String Tag = "CarlifeActivity#ServiceConnection";
    /* renamed from: b */
    private Activity mActivity;
    /* renamed from: c */
    private DisplaySpec mDisplaySpec;
    /* renamed from: d */
    private AbsCarlifeActivityService mAbsCarlifeActivityService;
    /* renamed from: e */
    private IBinder mIBinder;
    /* renamed from: f */
    private OnServiceDiedListener mOnServiceDiedListener;
    /* renamed from: g */
    private boolean f3821g;
    /* renamed from: h */
    private Class mServiceClass;
    /* renamed from: i */
    private DeathRecipient mDeathRecipient = new ServiceDeathRecipient(this);

    /* compiled from: CarlifeServiceConnection */
    /* renamed from: com.baidu.carlife.core.screen.presentation.f$1 */
    class ServiceDeathRecipient implements DeathRecipient {
        /* renamed from: a */
        final /* synthetic */ CarlifeServiceConnection mCarlifeServiceConnection;

        ServiceDeathRecipient(CarlifeServiceConnection this$0) {
            this.mCarlifeServiceConnection = this$0;
        }

        public void binderDied() {
            LogUtil.d(CarlifeServiceConnection.Tag, "binderDied()");
            this.mCarlifeServiceConnection.mIBinder.unlinkToDeath(this.mCarlifeServiceConnection.mDeathRecipient, 0);
            if (this.mCarlifeServiceConnection.mOnServiceDiedListener != null) {
                this.mCarlifeServiceConnection.mOnServiceDiedListener.mo1463a();
            }
        }
    }

    public CarlifeServiceConnection(Activity activity, OnServiceDiedListener listener,
                                    DisplaySpec spec, Class serviceClass) {
        this.mActivity = activity;
        this.mDisplaySpec = spec;
        this.mOnServiceDiedListener = listener;
        this.mServiceClass = serviceClass;
    }

    public void onServiceConnected(ComponentName name, IBinder binder) {
        LogUtil.d(Tag, "onServiceConnected className=" + name);
        AbsCarlifeActivityService service = ((AbsCarlifeActivityServiceBinder) binder).getCarlifeService();
        this.f3821g = true;
        bindDeathRecipient(binder);
        if (service != null) {
            this.mAbsCarlifeActivityService = service;
            service.m4616b(this.mDisplaySpec);
            return;
        }
        try {
            this.mActivity.unbindService(this);
        } catch (IllegalArgumentException e) {
            LogUtil.e(Tag, e.getMessage());
        }
    }

    /* renamed from: a */
    private void bindDeathRecipient(IBinder binder) {
        this.mIBinder = binder;
        try {
            binder.linkToDeath(this.mDeathRecipient, 0);
            LogUtil.d(Tag, "bindDeathRecipient binder=" + binder);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        LogUtil.d(Tag, "onServiceDisconnected componentName=" + name);
        try {
            this.mActivity.unbindService(this);
        } catch (IllegalArgumentException e) {
            LogUtil.e(Tag, e.getMessage());
        }
    }

    /* renamed from: a */
    public void unBindService() {
        LogUtil.d(Tag, "unBindService()");
        if (this.f3821g) {
            try {
                this.mActivity.unbindService(this);
                this.mActivity.stopService(new Intent(this.mActivity, this.mServiceClass));
            } catch (Exception e) {
            }
        }
        this.f3821g = false;
    }

    /* renamed from: b */
    public void m4755b() {
        if (this.mAbsCarlifeActivityService != null) {
            this.mAbsCarlifeActivityService.m4615b();
        }
    }
}
