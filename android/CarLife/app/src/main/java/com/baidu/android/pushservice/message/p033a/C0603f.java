package com.baidu.android.pushservice.message.p033a;

import android.annotation.SuppressLint;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.media.RingtoneManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0451c;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.p031j.C0572k;
import com.baidu.android.pushservice.p031j.C0577o;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import cz.msebera.android.httpclient.p158b.p294a.C6197b;
import java.util.Locale;

/* renamed from: com.baidu.android.pushservice.message.a.f */
public class C0603f {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m2692a(Context context, PublicMsg publicMsg, String str) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Intent intent = new Intent(context, PushService.class);
        intent.setAction("com.baidu.pushservice.action.publicmsg.CLICK_V2");
        intent.setData(Uri.parse("content://" + str));
        intent.putExtra("public_msg", publicMsg);
        Intent intent2 = new Intent(context, PushService.class);
        intent2.setAction("com.baidu.pushservice.action.publicmsg.DELETE_V2");
        intent2.setData(Uri.parse("content://" + str));
        intent2.putExtra("public_msg", publicMsg);
        intent.setClass(context, PushService.class);
        intent2.setClass(context, PushService.class);
        Builder autoCancel = new Builder(context).setContentTitle(publicMsg.mTitle).setContentText(publicMsg.mDescription).setSmallIcon(17301569).setTicker(publicMsg.mTitle).setSound(RingtoneManager.getDefaultUri(2)).setDeleteIntent(PendingIntent.getService(context, 0, intent2, 0)).setContentIntent(PendingIntent.getService(context, 0, intent, 0)).setAutoCancel(true);
        notificationManager.notify(C0578p.m2544b(str), VERSION.SDK_INT >= 16 ? autoCancel.build() : autoCancel.getNotification());
    }

    /* renamed from: a */
    public static void m2693a(Context context, PublicMsg publicMsg, String str, String str2, int i, byte[] bArr, byte[] bArr2) {
        Intent intent = new Intent();
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("pushService_package_name", context.getPackageName());
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        intent.putExtra("notify_type", C6197b.f25307v);
        intent.putExtra("message_id", str);
        intent.putExtra("app_id", str2);
        intent.putExtra("baidu_message_type", i);
        if (C0578p.m2584m(context, publicMsg.mPkgName) > 45) {
            intent.putExtra("baidu_message_body", bArr2);
            intent.putExtra("baidu_message_secur_info", bArr);
        }
        C0578p.m2545b(context, intent, "com.baidu.android.pushservice.action.notification.SHOW", publicMsg.mPkgName);
    }

    /* renamed from: a */
    public static void m2694a(Context context, String str) {
        try {
            Intent intent = new Intent(PushConstants.ACTION_METHOD);
            intent.putExtra("method", "com.baidu.android.pushservice.action.UNBINDAPP");
            intent.putExtra("app_id", str);
            C0577o.m2484a(context, intent);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m2695a(Context context, String str, PublicMsg publicMsg, String str2, int i, byte[] bArr, byte[] bArr2) {
        Intent intent = new Intent();
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("notify_type", "rich_media");
        intent.putExtra("app_id", str);
        intent.putExtra("message_id", str2);
        intent.putExtra("pushService_package_name", context.getPackageName());
        intent.putExtra("baidu_message_type", i);
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        if (C0578p.m2584m(context, publicMsg.mPkgName) > 45) {
            intent.putExtra("baidu_message_body", bArr2);
            intent.putExtra("baidu_message_secur_info", bArr);
        }
        C0578p.m2545b(context, intent, "com.baidu.android.pushservice.action.notification.SHOW", publicMsg.mPkgName);
    }

    /* renamed from: a */
    public static void m2696a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(str4));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
        C0451c c0451c = new C0451c(str3);
        c0451c.m1979b(16);
        c0451c.m1981c(3);
        c0451c.m1977a(str);
        c0451c.m1980b(str2);
        c0451c.m1978a(C0578p.m2593q(context, intent.getPackage()));
        c0451c.m1976a(context, activity, str5);
    }

    /* renamed from: a */
    public static boolean m2697a(Context context, PublicMsg publicMsg) {
        boolean z;
        if (publicMsg.mNetType == 1) {
            NetworkInfo c = C0572k.m2459c(context);
            z = c != null && C1981b.f6365e.equals(c.getTypeName().toLowerCase(Locale.getDefault()));
            if (!z) {
                return false;
            }
        }
        if (TextUtils.isEmpty(publicMsg.mSupportAppname)) {
            return true;
        }
        try {
            z = context.getPackageManager().getPackageInfo(publicMsg.mSupportAppname, 0) != null;
        } catch (NameNotFoundException e) {
            z = false;
        }
        return (publicMsg.mIsSupportApp && z) || !(publicMsg.mIsSupportApp || z);
    }
}
