package com.baidu.carlife.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.logic.C1868q;

public class PhoneStateService extends Service {
    /* renamed from: a */
    static final String Tag = "PhoneStateService";
    /* renamed from: b */
    private TelephonyManager f6912b;
    /* renamed from: c */
    private C2167a f6913c = null;
    /* renamed from: d */
    private final IBinder f6914d = new C2168b();

    /* renamed from: com.baidu.carlife.service.PhoneStateService$a */
    private class C2167a extends PhoneStateListener {
        /* renamed from: a */
        final /* synthetic */ PhoneStateService f6909a;

        private C2167a(PhoneStateService phoneStateService) {
            this.f6909a = phoneStateService;
        }

        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            LogUtil.d(PhoneStateService.Tag, "============== PhoneState Changed :" + state + " :: " + incomingNumber);
            MsgHandlerCenter.m4458a((int) CommonParams.fW, state, (Object) incomingNumber);
            C1868q.m7089f().m7105a(state, incomingNumber);
            switch (state) {
                case 0:
                    LogUtil.d(PhoneStateService.Tag, "============== CALL_STATE_IDLE:");
                    return;
                case 1:
                    LogUtil.d(PhoneStateService.Tag, "============== CALL_STATE_RINGING: ");
                    if (TextUtils.isEmpty(incomingNumber)) {
                        Log.d(PhoneStateService.Tag, "Cann't Get Phone Number");
                        return;
                    }
                    return;
                case 2:
                    LogUtil.d(PhoneStateService.Tag, "============== CALL_STATE_OFFHOOK:" + incomingNumber);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.carlife.service.PhoneStateService$b */
    public class C2168b extends Binder {
        /* renamed from: a */
        final /* synthetic */ PhoneStateService f6910a;

        private C2168b(PhoneStateService this$0) {
            this.f6910a = this$0;
        }
    }

    /* renamed from: a */
    public static void m8212a(Context context) {
        if (VERSION.SDK_INT >= 24) {
            try {
                LogUtil.d(Tag, "============== PhoneStateService start");
                context.startService(new Intent(context, PhoneStateService.class));
            } catch (Throwable e) {
                LogUtil.m4433a(e);
            }
        }
    }

    /* renamed from: b */
    public static void m8213b(Context context) {
        if (VERSION.SDK_INT >= 24) {
            try {
                LogUtil.d(Tag, "============== PhoneStateService stop");
                context.stopService(new Intent(context, PhoneStateService.class));
            } catch (Throwable e) {
                LogUtil.m4433a(e);
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        LogUtil.d(Tag, "============== PhoneStateService onCreate()");
        this.f6912b = (TelephonyManager) getSystemService("phone");
        this.f6912b.listen(new C2167a(), 32);
    }

    public IBinder onBind(Intent intent) {
        LogUtil.d(Tag, "PhoneStateService onBind()");
        return this.f6914d;
    }

    public boolean onUnbind(Intent intent) {
        LogUtil.d(Tag, "PhoneStateService onUnbind()");
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent) {
        LogUtil.d(Tag, "PhoneStateService onRebind()");
        super.onRebind(intent);
    }

    public void onStart(Intent intent, int startId) {
        LogUtil.d(Tag, "PhoneStateService onStart(), startId = " + startId);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.d(Tag, "PhoneStateService onStartCommand");
        if (this.f6913c == null) {
            Log.e(Tag, "============== Service onStartCommand");
            this.f6912b = (TelephonyManager) getApplicationContext().getSystemService("phone");
            this.f6913c = new C2167a();
            this.f6912b.listen(this.f6913c, 32);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        LogUtil.d(Tag, "PhoneStateService onDestroy()");
        super.onDestroy();
    }
}
