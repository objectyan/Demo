package me.objectyan.screensharing.service;

import android.app.Service;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;

public class PhoneStateService extends Service {

    static final String Tag = "[PhoneStateService]";

    private TelephonyManager mTelephonyManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(Tag, "============== PhoneStateService onCreate()");
        this.mTelephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        this.mTelephonyManager.listen(new PhoneStateServiceListener(this
        ), 32);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(Tag, "PhoneStateService onBind()");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(Tag, "PhoneStateService onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v(Tag, "PhoneStateService onRebind()");
        super.onRebind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(Tag, "PhoneStateService onStartCommand");
        if (this.mTelephonyManager == null) {
            Log.e(Tag, "============== Service onStartCommand");
            this.mTelephonyManager = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
            this.mTelephonyManager.listen(new PhoneStateServiceListener(this
            ), 32);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.v(Tag, "PhoneStateService onDestroy()");
        super.onDestroy();
    }

    public static void start(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                Log.v(Tag, "============== PhoneStateService start");
                context.startService(new Intent(context, PhoneStateService.class));
            } catch (Throwable e) {
                Log.e(Tag, e.getMessage());
            }
        }
    }


    public static void stop(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                Log.v(Tag, "============== PhoneStateService stop");
                context.stopService(new Intent(context, PhoneStateService.class));
            } catch (Throwable e) {
                Log.e(Tag, e.getMessage());
            }
        }
    }

    private class PhoneStateServiceListener extends PhoneStateListener {

        final PhoneStateService mPhoneStateService;

        PhoneStateServiceListener(PhoneStateService mPhoneStateService) {
            this.mPhoneStateService = mPhoneStateService;
        }

        @Override
        public void onCallStateChanged(int state, String phoneNumber) {
            super.onCallStateChanged(state, phoneNumber);
            Log.v(PhoneStateService.Tag, "============== PhoneState Changed :" + state + " :: " + phoneNumber);
            switch (state) {
                case 0:
                    Log.v(PhoneStateService.Tag, "============== CALL_STATE_IDLE:");
                    return;
                case 1:
                    Log.v(PhoneStateService.Tag, "============== CALL_STATE_RINGING: ");
                    if (TextUtils.isEmpty(phoneNumber)) {
                        Log.d(PhoneStateService.Tag, "Cann't Get Phone Number");
                        return;
                    }
                    return;
                case 2:
                    Log.v(PhoneStateService.Tag, "============== CALL_STATE_OFFHOOK:" + phoneNumber);
                    return;
                default:
                    return;
            }
        }
    }

}
