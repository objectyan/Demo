package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.p031j.C0573l;
import com.baidu.android.pushservice.p031j.C0578p;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.baidu.android.pushservice.c */
public class C0451c {
    /* renamed from: a */
    protected int f1420a;
    /* renamed from: b */
    protected int f1421b;
    /* renamed from: c */
    protected int f1422c;
    /* renamed from: d */
    protected Uri f1423d;
    /* renamed from: e */
    protected long[] f1424e;
    /* renamed from: f */
    protected String f1425f;
    /* renamed from: g */
    protected String f1426g;
    /* renamed from: h */
    protected boolean f1427h = false;
    /* renamed from: i */
    private final String f1428i;

    public C0451c(String str) {
        this.f1428i = str;
    }

    /* renamed from: a */
    public static int m1971a(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    /* renamed from: a */
    private Bitmap m1972a(Drawable drawable, Context context) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        float f = context.getResources().getDisplayMetrics().density;
        drawable.setBounds(0, 0, (int) (48.0f * f), (int) (f * 48.0f));
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public void m1975a(int i) {
        this.f1420a = i;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m1976a(final Context context, final PendingIntent pendingIntent, final String str) {
        int a = C0451c.m1971a(context, "bpush_lapp_notification_status_icon");
        if (a > 0) {
            m1975a(a);
        } else {
            m1975a(17301620);
        }
        if (VERSION.SDK_INT < 16 || TextUtils.isEmpty(this.f1428i)) {
            Notification notification = new Builder(context).setContentTitle(this.f1425f).setContentText(this.f1426g).setSmallIcon(this.f1420a).setContentIntent(pendingIntent).getNotification();
            if (this.f1427h) {
                notification.defaults = 0;
            } else {
                notification.defaults = -1;
                if (this.f1422c != 0) {
                    notification.defaults = this.f1422c;
                }
                if (this.f1423d != null) {
                    notification.sound = this.f1423d;
                }
                if (this.f1424e != null) {
                    notification.vibrate = this.f1424e;
                }
            }
            if (this.f1421b != 0) {
                notification.flags = this.f1421b;
            }
            if (notification != null) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                notification.contentIntent = pendingIntent;
                notificationManager.notify(C0578p.m2544b(str), notification);
                return;
            }
            return;
        }
        new Thread(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ C0451c f1384d;

            public void run() {
                try {
                    Drawable createFromStream = Drawable.createFromStream(new URL(this.f1384d.f1428i).openStream(), null);
                    Builder builder = new Builder(context);
                    if (C0578p.m2503G(context)) {
                        C0573l.m2464a(context, "com.baidu.android.pushservice.push", "Push");
                        builder.setChannelId("com.baidu.android.pushservice.push");
                    }
                    Notification build = builder.setContentTitle(this.f1384d.f1425f).setContentTitle(this.f1384d.f1425f).setContentText(this.f1384d.f1426g).setSmallIcon(this.f1384d.f1420a).setLargeIcon(this.f1384d.m1972a(createFromStream, context)).build();
                    if (this.f1384d.f1421b != 0) {
                        build.flags = this.f1384d.f1421b;
                    }
                    if (this.f1384d.f1427h) {
                        build.defaults = 0;
                    } else {
                        build.defaults = -1;
                        if (this.f1384d.f1422c != 0) {
                            build.defaults = this.f1384d.f1422c;
                        }
                        if (this.f1384d.f1423d != null) {
                            build.sound = this.f1384d.f1423d;
                        }
                        if (this.f1384d.f1424e != null) {
                            build.vibrate = this.f1384d.f1424e;
                        }
                    }
                    build.contentIntent = pendingIntent;
                    ((NotificationManager) context.getSystemService("notification")).notify(str, 0, build);
                } catch (MalformedURLException e) {
                } catch (IOException e2) {
                }
            }
        }, "DownNotiIcon").start();
    }

    /* renamed from: a */
    public void m1977a(String str) {
        this.f1425f = str;
    }

    /* renamed from: a */
    public void m1978a(boolean z) {
        this.f1427h = z;
    }

    /* renamed from: b */
    public void m1979b(int i) {
        this.f1421b = i;
    }

    /* renamed from: b */
    public void m1980b(String str) {
        this.f1426g = str;
    }

    /* renamed from: c */
    public void m1981c(int i) {
        this.f1422c = i;
    }
}
