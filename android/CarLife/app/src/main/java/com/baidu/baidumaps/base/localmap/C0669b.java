package com.baidu.baidumaps.base.localmap;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.platform.comapi.util.C2911f;

/* compiled from: LMNotificationManager */
/* renamed from: com.baidu.baidumaps.base.localmap.b */
public class C0669b {
    /* renamed from: a */
    private static volatile C0669b f2166a = null;
    /* renamed from: b */
    private static final int f2167b = 1;
    /* renamed from: c */
    private static final int f2168c = 2;
    /* renamed from: d */
    private static final int f2169d = 3;
    /* renamed from: e */
    private static final int f2170e = 4;
    /* renamed from: f */
    private NotificationManager f2171f;
    /* renamed from: g */
    private Notification f2172g;
    /* renamed from: h */
    private Notification f2173h;
    /* renamed from: i */
    private Notification f2174i;
    /* renamed from: j */
    private Notification f2175j;
    /* renamed from: k */
    private int f2176k = 0;
    /* renamed from: l */
    private boolean f2177l = false;
    /* renamed from: m */
    private boolean f2178m = false;

    /* renamed from: a */
    public static C0669b m2851a(Context aContext) {
        if (f2166a == null) {
            synchronized (C0669b.class) {
                if (f2166a == null) {
                    f2166a = new C0669b(aContext);
                }
            }
        }
        return f2166a;
    }

    private C0669b(Context aContext) {
        this.f2171f = (NotificationManager) aContext.getSystemService("notification");
        m2852b(aContext);
        m2853c(aContext);
        m2854d(aContext);
        m2855e(aContext);
    }

    /* renamed from: b */
    private void m2852b(Context aContext) {
        this.f2172g = new Notification();
        this.f2172g.flags = 16;
        this.f2172g.icon = C0965R.drawable.ic_launcher;
        Bundle bundle = new Bundle();
        Intent downloadIntent = new Intent(aContext, CarlifeActivity.class);
        downloadIntent.setFlags(67108864);
        downloadIntent.putExtra("OpenDownloadManager", "openmap");
        this.f2172g.contentIntent = PendingIntent.getActivity(aContext, 1, downloadIntent, 0);
        RemoteViews contentView = new RemoteViews(aContext.getPackageName(), C0965R.layout.status_bar_progress);
        contentView.setTextViewText(C0965R.id.progress_text, "0%");
        this.f2172g.contentView = contentView;
    }

    /* renamed from: c */
    private void m2853c(Context aContext) {
        this.f2173h = new Notification();
        this.f2173h.flags = 16;
        this.f2173h.icon = C0965R.drawable.ic_launcher;
        Bundle bundle = new Bundle();
        Intent pauseIntent = new Intent(aContext, CarlifeActivity.class);
        pauseIntent.setFlags(67108864);
        pauseIntent.putExtra("OpenDownloadManager", "openmap");
        this.f2173h.contentIntent = PendingIntent.getActivity(aContext, 2, pauseIntent, 0);
        RemoteViews contentViewSuspend = new RemoteViews(aContext.getPackageName(), C0965R.layout.status_bar_suspending);
        contentViewSuspend.setTextViewText(C0965R.id.progress_text, this.f2176k + "%");
        this.f2173h.contentView = contentViewSuspend;
    }

    /* renamed from: d */
    private void m2854d(Context aContext) {
        this.f2174i = new Notification();
        this.f2174i.flags = 16;
        this.f2174i.icon = C0965R.drawable.ic_launcher;
        Intent delIntent = new Intent(aContext, LMBroadcastReceiver.class);
        delIntent.setAction("com.baidu.BaiduMap.ON_LM_NOTIFICATION_FINISHED");
        this.f2174i.contentIntent = PendingIntent.getBroadcast(aContext, 3, delIntent, 0);
        this.f2174i.contentView = new RemoteViews(aContext.getPackageName(), C0965R.layout.status_bar_result);
    }

    /* renamed from: e */
    private void m2855e(Context aContext) {
        this.f2175j = new Notification();
        this.f2175j.tickerText = "离线地图导入中...";
        this.f2175j.flags = 16;
        this.f2175j.icon = C0965R.drawable.ic_launcher;
        Bundle bundle = new Bundle();
        Intent importIntent = new Intent(aContext, CarlifeActivity.class);
        importIntent.setFlags(67108864);
        importIntent.putExtra("OpenDownloadManager", "openmap");
        this.f2175j.contentIntent = PendingIntent.getActivity(aContext, 4, importIntent, 0);
        this.f2175j.contentView = new RemoteViews(aContext.getPackageName(), C0965R.layout.off_map_notification);
    }

    /* renamed from: a */
    public void m2859a(String notifTitle, int aProgress) {
        try {
            this.f2171f.cancel(2);
            this.f2171f.cancel(3);
            m2860a(false);
            this.f2176k = aProgress;
            this.f2172g.contentView.setProgressBar(C0965R.id.progress_bar, 100, aProgress, false);
            this.f2172g.contentView.setTextViewText(C0965R.id.title, notifTitle);
            this.f2172g.contentView.setTextViewText(C0965R.id.progress_text, aProgress + "%");
            this.f2171f.notify(1, this.f2172g);
            this.f2178m = true;
        } catch (Exception ex) {
            C2911f.m11009a(C0669b.class.getSimpleName(), "exception", ex);
        }
    }

    /* renamed from: a */
    public void m2858a(String notifTitle) {
        try {
            this.f2171f.cancel(1);
            this.f2173h.contentView.setTextViewText(C0965R.id.title, notifTitle);
            this.f2173h.contentView.setProgressBar(C0965R.id.progress_bar, 100, this.f2176k, false);
            this.f2173h.contentView.setTextViewText(C0965R.id.progress_text, this.f2176k + "%");
            this.f2171f.notify(2, this.f2173h);
        } catch (Exception ex) {
            C2911f.m11009a(C0669b.class.getSimpleName(), "exception", ex);
        }
    }

    /* renamed from: b */
    public void m2862b(String notifTitle) {
        try {
            this.f2171f.cancel(1);
            this.f2171f.cancel(2);
            if (this.f2178m) {
                this.f2174i.contentView.setTextViewText(C0965R.id.title, notifTitle);
                this.f2171f.notify(3, this.f2174i);
                this.f2178m = false;
                m2860a(true);
            } else if (this.f2177l) {
                this.f2174i.contentView.setTextViewText(C0965R.id.title, notifTitle);
                this.f2171f.notify(3, this.f2174i);
            }
        } catch (Exception ex) {
            C2911f.m11009a(C0669b.class.getSimpleName(), "exception", ex);
        }
    }

    /* renamed from: a */
    public void m2857a(int progress, int total, int fail) {
        if (total <= 0 || progress > total) {
            try {
                this.f2171f.cancel(4);
                return;
            } catch (Exception ex) {
                C2911f.m11009a(C0669b.class.getSimpleName(), "exception", ex);
                return;
            }
        }
        this.f2175j.contentView.setProgressBar(C0965R.id.off_map_notification_pbar, total, progress + fail, false);
        if (progress + fail != total) {
            this.f2175j.contentView.setTextViewText(C0965R.id.off_map_notification_tip, "已导入" + progress + "个城市/共" + total + "个城市");
        } else if (fail > 0) {
            this.f2175j.contentView.setTextViewText(C0965R.id.off_map_notification_tip, "共成功导入" + progress + "个城市, 失败" + fail + "个");
        } else {
            this.f2175j.contentView.setTextViewText(C0965R.id.off_map_notification_tip, "导入完成，共导入" + progress + "个城市");
        }
        this.f2171f.notify(4, this.f2175j);
    }

    /* renamed from: a */
    public void m2856a() {
        try {
            this.f2171f.cancel(4);
        } catch (Exception ex) {
            C2911f.m11009a(C0669b.class.getSimpleName(), "cancelImportNotif exception", ex);
        }
    }

    /* renamed from: b */
    public void m2861b() {
        try {
            this.f2171f.cancel(1);
            this.f2171f.cancel(2);
            this.f2171f.cancel(3);
            this.f2171f.cancel(4);
            m2860a(false);
            this.f2178m = false;
        } catch (Exception ex) {
            C2911f.m11009a(C0669b.class.getSimpleName(), "clearAllNotifs exception", ex);
        }
    }

    /* renamed from: a */
    public void m2860a(boolean isShow) {
        this.f2177l = isShow;
    }
}
