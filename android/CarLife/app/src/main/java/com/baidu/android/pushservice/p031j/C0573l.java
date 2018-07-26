package com.baidu.android.pushservice.p031j;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/* renamed from: com.baidu.android.pushservice.j.l */
public class C0573l {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static int m2463a(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            return ((Integer) Class.forName(AppOpsManager.class.getName()).getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) Class.forName(AppOpsManager.class.getName()).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName})).intValue() == 0 ? 1 : 0;
        } catch (Exception e) {
            return 2;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m2464a(Context context, String str, String str2) {
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, 3);
        notificationChannel.setShowBadge(true);
        notificationChannel.setLockscreenVisibility(1);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
