package com.baidu.baidunavis;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import com.baidu.carlife.C0965R;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.platform.comapi.C2907c;

public class ForegroundService extends Service {
    private static final int RES_ID = 2130968580;
    private static final String TAG = "ForegroundService";

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Notification notification = new Notification();
        try {
            if (C2907c.m10977f() != null) {
                notification = new Builder(C2907c.m10977f()).setSmallIcon(C0965R.drawable.ic_launcher).setTicker("正在导航").setWhen(System.currentTimeMillis()).setContentTitle("正在导航").setContentText(StatisticConstants.MAP_BAIDU_MAP).build();
            }
        } catch (Throwable th) {
        }
        startForeground(C0965R.layout.activity_lite, notification);
    }
}
