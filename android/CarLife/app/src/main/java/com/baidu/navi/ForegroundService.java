package com.baidu.navi;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.C1260i;
import com.baidu.navisdk.BNaviEngineManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ForegroundService extends Service {
    static final String ACTION_BACKGROUND = "com.example.android.apis.BACKGROUND";
    static final String ACTION_FOREGROUND = "com.example.android.apis.FOREGROUND";
    private static final Class<?>[] mSetForegroundSignature = new Class[]{Boolean.TYPE};
    private static final Class<?>[] mStartForegroundSignature = new Class[]{Integer.TYPE, Notification.class};
    private static final Class<?>[] mStopForegroundSignature = new Class[]{Boolean.TYPE};
    private NotificationManager mNM;
    private Method mSetForeground;
    private Object[] mSetForegroundArgs = new Object[1];
    private Method mStartForeground;
    private Object[] mStartForegroundArgs = new Object[2];
    private Method mStopForeground;
    private Object[] mStopForegroundArgs = new Object[1];

    void invokeMethod(Method method, Object[] args) {
        try {
            method.invoke(this, args);
        } catch (InvocationTargetException e) {
            C1260i.m4445e("ApiDemos", "Unable to invoke method" + e.getMessage());
        } catch (IllegalAccessException e2) {
            C1260i.m4445e("ApiDemos", "Unable to invoke method" + e2.getMessage());
        }
    }

    void startForegroundCompat(int id, Notification notification) {
        if (this.mStartForeground != null) {
            this.mStartForegroundArgs[0] = Integer.valueOf(id);
            this.mStartForegroundArgs[1] = notification;
            invokeMethod(this.mStartForeground, this.mStartForegroundArgs);
            return;
        }
        this.mSetForegroundArgs[0] = Boolean.TRUE;
        invokeMethod(this.mSetForeground, this.mSetForegroundArgs);
        this.mNM.notify(id, notification);
    }

    void stopForegroundCompat(int id) {
        if (this.mStopForeground != null) {
            this.mStopForegroundArgs[0] = Boolean.TRUE;
            invokeMethod(this.mStopForeground, this.mStopForegroundArgs);
            return;
        }
        this.mNM.cancel(id);
        this.mSetForegroundArgs[0] = Boolean.FALSE;
        invokeMethod(this.mSetForeground, this.mSetForegroundArgs);
    }

    public void onCreate() {
        this.mNM = (NotificationManager) getSystemService("notification");
        try {
            this.mStartForeground = getClass().getMethod("startForeground", mStartForegroundSignature);
            this.mStopForeground = getClass().getMethod("stopForeground", mStopForegroundSignature);
        } catch (NoSuchMethodException e) {
            this.mStopForeground = null;
            this.mStartForeground = null;
            try {
                this.mSetForeground = getClass().getMethod("setForeground", mSetForegroundSignature);
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("OS doesn't have Service.startForeground OR Service.setForeground!");
            }
        }
    }

    public void onDestroy() {
        stopForegroundCompat(C0965R.string.foreground);
    }

    public void onStart(Intent intent, int startId) {
        handleCommand(intent);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            handleCommand(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    void handleCommand(Intent intent) {
        if (intent != null && ACTION_FOREGROUND.equals(intent.getAction())) {
            CharSequence text = getString(C0965R.string.other_service_continue_service);
            Notification notification = new Builder(this).setContentTitle(getString(C0965R.string.app_name)).setContentText(text).setSmallIcon(C0965R.drawable.ic_launcher).setLargeIcon(BitmapFactory.decodeResource(getResources(), C0965R.drawable.ic_launcher)).build();
            notification.setLatestEventInfo(this, getString(C0965R.string.app_name), text, PendingIntent.getActivity(this, 0, new Intent(this, CarlifeActivity.class), 0));
            startForegroundCompat(C0965R.string.foreground, notification);
        } else if (ACTION_BACKGROUND.equals(intent.getAction())) {
            stopForegroundCompat(C0965R.string.foreground);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void start(Context context) {
        try {
            Intent intent = new Intent(ACTION_FOREGROUND);
            intent.setClass(context, ForegroundService.class);
            context.startService(intent);
        } catch (Throwable e) {
            C1260i.m4433a(e);
        }
    }

    public static void stop(Context context) {
        try {
            Intent intent = new Intent(ACTION_FOREGROUND);
            intent.setClass(context, ForegroundService.class);
            context.stopService(intent);
        } catch (Throwable e) {
            C1260i.m4433a(e);
        }
    }

    public void onTaskRemoved(Intent rootIntent) {
        C1260i.m4445e("ForegroundService", "onTaskRemoved");
        super.onTaskRemoved(rootIntent);
        ActivityStack.exitApp(BNaviEngineManager.getInstance().isEngineInitSucc());
    }
}
