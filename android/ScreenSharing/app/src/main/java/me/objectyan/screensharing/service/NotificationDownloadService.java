package com.baidu.carlife.service;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import com.baidu.carlife.R;
import com.baidu.carlife.CarlifeActivity;

public class NotificationDownloadService extends Service {
    /* renamed from: a */
    private NotificationManager f6905a = null;
    /* renamed from: b */
    private Builder f6906b = null;
    /* renamed from: c */
    private final int f6907c = 8193;
    /* renamed from: d */
    private CarlifeActivity f6908d = null;

    /* renamed from: com.baidu.carlife.service.NotificationDownloadService$a */
    public class C2165a extends Binder {
        /* renamed from: a */
        final /* synthetic */ NotificationDownloadService f6904a;

        public C2165a(NotificationDownloadService this$0) {
            this.f6904a = this$0;
        }

        /* renamed from: a */
        public NotificationDownloadService m8208a() {
            return this.f6904a;
        }
    }

    /* renamed from: a */
    public void m8211a(Activity activity) {
        this.f6908d = (CarlifeActivity) activity;
    }

    public IBinder onBind(Intent intent) {
        return new C2165a(this);
    }

    /* renamed from: a */
    public void m8210a(int progress) {
        if (this.f6906b != null || this.f6908d == null) {
            this.f6906b.setProgress(100, progress, false);
            this.f6905a.notify(8193, this.f6906b.build());
            return;
        }
        Intent resultIntent = new Intent(this.f6908d, CarlifeActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this.f6908d);
        stackBuilder.addParentStack(CarlifeActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        this.f6906b = new Builder(this.f6908d).setSmallIcon(R.drawable.ic_launcher).setContentTitle("CarLife 正在下载").setProgress(100, progress, false).setContentIntent(stackBuilder.getPendingIntent(0, 134217728)).setOngoing(true);
        Notification n = this.f6906b.build();
        n.flags |= 16;
        this.f6905a = (NotificationManager) this.f6908d.getSystemService("notification");
        this.f6905a.notify(8193, n);
    }

    /* renamed from: a */
    public void m8209a() {
        if (this.f6905a != null) {
            this.f6905a.cancel(8193);
        }
    }
}
