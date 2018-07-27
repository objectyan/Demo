package me.objectyan.screensharing.core.screen.presentation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.util.Log;


import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.screen.OnServiceDiedListener;
import me.objectyan.screensharing.core.screen.presentation.AbsCarlifeActivityService.AbsCarlifeActivityServiceBinder;


public class CarlifeServiceConnection implements ServiceConnection {

    private static final String Tag = "ServiceConnection";

    private Activity mActivity;

    private DisplaySpec mDisplaySpec;

    private AbsCarlifeActivityService mAbsCarlifeActivityService;

    private IBinder mIBinder;

    private OnServiceDiedListener mOnServiceDiedListener;

    private boolean f3821g;

    private Class mServiceClass;

    private DeathRecipient mDeathRecipient = new ServiceDeathRecipient(this);

    
    class ServiceDeathRecipient implements DeathRecipient {

        final CarlifeServiceConnection mCarlifeServiceConnection;

        ServiceDeathRecipient(CarlifeServiceConnection this$0) {
            this.mCarlifeServiceConnection = this$0;
        }

        public void binderDied() {
            Log.d(CarlifeServiceConnection.Tag, "binderDied()");
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
        Log.d(Tag, "onServiceConnected className=" + name);
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
            Log.e(Tag, e.getMessage());
        }
    }


    private void bindDeathRecipient(IBinder binder) {
        this.mIBinder = binder;
        try {
            binder.linkToDeath(this.mDeathRecipient, 0);
            Log.d(Tag, "bindDeathRecipient binder=" + binder);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        Log.d(Tag, "onServiceDisconnected componentName=" + name);
        try {
            this.mActivity.unbindService(this);
        } catch (IllegalArgumentException e) {
            Log.e(Tag, e.getMessage());
        }
    }


    public void unBindService() {
        Log.d(Tag, "unBindService()");
        if (this.f3821g) {
            try {
                this.mActivity.unbindService(this);
                this.mActivity.stopService(new Intent(this.mActivity, this.mServiceClass));
            } catch (Exception e) {
            }
        }
        this.f3821g = false;
    }


    public void m4755b() {
        if (this.mAbsCarlifeActivityService != null) {
            this.mAbsCarlifeActivityService.m4615b();
        }
    }
}
