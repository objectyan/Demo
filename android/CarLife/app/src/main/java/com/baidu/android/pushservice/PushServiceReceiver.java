package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.p033a.C0602e;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p024c.C0448d;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p025d.C0463a.C0459g;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p031j.C0577o;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.richmedia.C0424f;
import com.baidu.android.pushservice.richmedia.C0638a;
import com.baidu.android.pushservice.richmedia.C0639b;
import com.baidu.android.pushservice.richmedia.C0641c;
import com.baidu.android.pushservice.richmedia.C0641c.C0640a;
import com.baidu.android.pushservice.richmedia.C0643d;
import com.baidu.android.pushservice.richmedia.C0644e;
import com.baidu.android.pushservice.richmedia.MediaViewActivity;
import com.baidu.baidumaps.common.network.NetworkListener;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import cz.msebera.android.httpclient.p158b.p294a.C6197b;
import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"NewApi"})
public class PushServiceReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private final ReentrantLock f1342a = new ReentrantLock();

    /* renamed from: com.baidu.android.pushservice.PushServiceReceiver$a */
    private static class C0425a implements C0424f {
        /* renamed from: a */
        public Context f1335a = null;
        /* renamed from: b */
        public RemoteViews f1336b = null;
        /* renamed from: c */
        public int f1337c = 0;
        /* renamed from: d */
        public int f1338d = 0;
        /* renamed from: e */
        public int f1339e = 0;
        /* renamed from: f */
        public int f1340f = 0;
        /* renamed from: g */
        NotificationManager f1341g;

        /* renamed from: com.baidu.android.pushservice.PushServiceReceiver$a$1 */
        class C04221 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C0425a f1332a;

            C04221(C0425a c0425a) {
                this.f1332a = c0425a;
            }

            public void run() {
                Toast.makeText(this.f1332a.f1335a, "富媒体推送没有声明必须的Activity，请检查！", 1).show();
            }
        }

        C0425a(Context context, PublicMsg publicMsg) {
            this.f1335a = context;
            this.f1341g = (NotificationManager) context.getSystemService("notification");
        }

        /* renamed from: a */
        public void mo1273a(C0638a c0638a) {
            Resources resources = this.f1335a.getResources();
            String packageName = this.f1335a.getPackageName();
            if (resources != null) {
                int identifier = resources.getIdentifier("bpush_download_progress", "layout", packageName);
                this.f1336b = new RemoteViews(this.f1335a.getPackageName(), identifier);
                if (identifier != 0) {
                    this.f1337c = resources.getIdentifier("bpush_download_progress", "id", packageName);
                    this.f1338d = resources.getIdentifier("bpush_progress_percent", "id", packageName);
                    this.f1339e = resources.getIdentifier("bpush_progress_text", "id", packageName);
                    this.f1340f = resources.getIdentifier("bpush_download_icon", "id", packageName);
                    this.f1336b.setImageViewResource(this.f1340f, this.f1335a.getApplicationInfo().icon);
                }
            }
        }

        @SuppressLint({"NewApi"})
        /* renamed from: a */
        public void mo1274a(C0638a c0638a, C0639b c0639b) {
            String c = c0638a.f2026d.m2808c();
            if (c0639b.f2028a != c0639b.f2029b && this.f1336b != null) {
                int i = (int) ((((double) c0639b.f2028a) * 100.0d) / ((double) c0639b.f2029b));
                this.f1336b.setTextViewText(this.f1338d, i + "%");
                this.f1336b.setTextViewText(this.f1339e, "正在下载富媒体:" + c);
                this.f1336b.setProgressBar(this.f1337c, 100, i, false);
                Notification build = VERSION.SDK_INT >= 16 ? new Builder(this.f1335a).setSmallIcon(17301633).setWhen(System.currentTimeMillis()).build() : new Notification(17301633, null, System.currentTimeMillis());
                build.contentView = this.f1336b;
                build.contentIntent = PendingIntent.getActivity(this.f1335a, 0, new Intent(), 0);
                build.flags |= 32;
                build.flags |= 2;
                this.f1341g.notify(c, 0, build);
            }
        }

        /* renamed from: a */
        public void mo1275a(C0638a c0638a, C0644e c0644e) {
            String c = c0638a.f2026d.m2808c();
            this.f1341g.cancel(c, 0);
            C0459g a = C0463a.m1996a(this.f1335a, c);
            if (a != null && a.f1490i == C0638a.f2021f) {
                String str = a.f1486e;
                c = a.f1487f;
                if (!TextUtils.isEmpty(c) && c.length() > 0) {
                    Uri insert;
                    c = str + "/" + c.substring(0, c.lastIndexOf(".")) + "/index.html";
                    Intent intent = new Intent();
                    intent.setClass(this.f1335a, MediaViewActivity.class);
                    int A = C0578p.m2492A(this.f1335a, this.f1335a.getPackageName());
                    File file = new File(c);
                    if (A >= 24) {
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put("_data", file.getAbsolutePath());
                        insert = this.f1335a.getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
                    } else {
                        insert = Uri.fromFile(file);
                    }
                    intent.setData(insert);
                    intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                    try {
                        this.f1335a.startActivity(intent);
                    } catch (Throwable e) {
                        new Handler(Looper.getMainLooper()).post(new C04221(this));
                        C0527a.m2217a("PushServiceReceiver", e, this.f1335a);
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo1276a(C0638a c0638a, Throwable th) {
            if (this.f1335a != null) {
                final String c = c0638a.f2026d.m2808c();
                this.f1341g.cancel(c, 0);
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C0425a f1334b;

                    public void run() {
                        Toast makeText = Toast.makeText(this.f1334b.f1335a, "下载富媒体" + Uri.parse(c).getAuthority() + "失败", 1);
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                    }
                });
            }
        }

        /* renamed from: b */
        public void mo1277b(C0638a c0638a) {
            this.f1341g.cancel(c0638a.f2026d.m2808c(), 0);
        }
    }

    /* renamed from: a */
    private static Intent m1807a(String str) {
        try {
            Intent intent = new Intent();
            try {
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                return intent;
            } catch (Exception e) {
                return intent;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m1808a(Context context, PublicMsg publicMsg) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Toast makeText = Toast.makeText(context, "请插入SD卡", 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } else if (publicMsg != null && publicMsg.mUrl != null) {
            Uri parse = Uri.parse(publicMsg.mUrl);
            String path = parse.getPath();
            if (!TextUtils.isEmpty(parse.getPath())) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "baidu/pushservice/files" + "/" + parse.getAuthority() + "/" + path.substring(0, path.lastIndexOf(47)));
                C0641c a = C0643d.m2809a(C0640a.REQ_TYPE_GET_ZIP, parse.toString());
                a.f2032a = publicMsg.mPkgName;
                a.f2033b = file.getAbsolutePath();
                a.f2034c = publicMsg.mTitle;
                a.f2035d = publicMsg.mDescription;
                new C0638a(context, new C0425a(context, publicMsg), a).start();
            }
        }
    }

    /* renamed from: a */
    private static void m1809a(Context context, PublicMsg publicMsg, byte[] bArr, byte[] bArr2) {
        Intent intent = new Intent();
        intent.setPackage(publicMsg.mPkgName);
        intent.putExtra("method", "com.baidu.android.pushservice.action.notification.ARRIVED");
        intent.putExtra("msgid", publicMsg.mMsgId);
        intent.putExtra("notification_title", publicMsg.mTitle);
        intent.putExtra("notification_content", publicMsg.mDescription);
        intent.putExtra("extra_extra_custom_content", publicMsg.mCustomContent);
        intent.putExtra("com.baidu.pushservice.app_id", publicMsg.mAppId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        C0578p.m2536a(context, publicMsg.mMsgId, publicMsg.mAppId, publicMsg.mTitle, publicMsg.mDescription, publicMsg.mCustomContent);
        C0578p.m2545b(context, intent, PushConstants.ACTION_RECEIVE, publicMsg.mPkgName);
    }

    /* renamed from: a */
    public static void m1810a(Context context, String str, String str2, PublicMsg publicMsg) {
        try {
            Intent a;
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (TextUtils.isEmpty(publicMsg.mPkgContent)) {
                a = !TextUtils.isEmpty(publicMsg.mUrl) ? m1807a(publicMsg.mUrl) : m1813b(context, publicMsg);
            } else {
                try {
                    a = Intent.parseUri(publicMsg.mPkgContent, 1);
                    a.setPackage(context.getPackageName());
                } catch (URISyntaxException e) {
                    a = m1813b(context, publicMsg);
                }
            }
            if (a != null) {
                PendingIntent activity = PendingIntent.getActivity(context, 0, a, 0);
                Notification a2 = C0475d.m2051a(context, 0, 7, publicMsg.mTitle, publicMsg.mDescription, false);
                if (a2 != null) {
                    a2.contentIntent = activity;
                    notificationManager.notify(System.currentTimeMillis() + "", 0, a2);
                }
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: b */
    private static Intent m1813b(Context context, PublicMsg publicMsg) {
        try {
            Intent intent = new Intent();
            try {
                intent.setClassName(context.getPackageName(), publicMsg.getLauncherActivityName(context, context.getPackageName()));
                intent.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                return intent;
            } catch (Exception e) {
                return intent;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: b */
    private static void m1814b(Context context, String str, String str2, PublicMsg publicMsg, String str3) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Intent intent = new Intent("com.baidu.android.pushservice.action.media.CLICK");
        intent.setClassName(str, str2);
        intent.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", str3);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 0);
        Intent intent2 = new Intent();
        intent2.setClassName(str, str2);
        intent2.setAction("com.baidu.android.pushservice.action.media.DELETE");
        intent2.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent2.putExtra("public_msg", publicMsg);
        intent2.putExtra("app_id", str3);
        PendingIntent service2 = PendingIntent.getService(context, 0, intent2, 0);
        Notification a = C0475d.m2052a(context, 8888, publicMsg.mTitle, "富媒体消息：点击后下载与查看", C0578p.m2593q(context, publicMsg.mPkgName));
        a.contentIntent = service;
        a.deleteIntent = service2;
        notificationManager.notify(publicMsg.mMsgId, 0, a);
    }

    /* renamed from: b */
    private static void m1815b(Context context, String str, String str2, PublicMsg publicMsg, byte[] bArr, byte[] bArr2) {
        Notification a;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.setAction("com.baidu.android.pushservice.action.privatenotification.CLICK");
        intent.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", publicMsg.mAppId);
        intent.putExtra("msg_id", publicMsg.mMsgId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 0);
        intent = new Intent();
        intent.setClassName(str, str2);
        intent.setAction("com.baidu.android.pushservice.action.privatenotification.DELETE");
        intent.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", publicMsg.mAppId);
        intent.putExtra("msg_id", publicMsg.mMsgId);
        PendingIntent service2 = PendingIntent.getService(context, 0, intent, 0);
        boolean q = C0578p.m2593q(context, publicMsg.mPkgName);
        if (publicMsg.mNotificationBuilder == 0) {
            a = C0475d.m2051a(context, publicMsg.mNotificationBuilder, publicMsg.mNotificationBasicStyle, publicMsg.mTitle, publicMsg.mDescription, q);
        } else {
            a = C0475d.m2052a(context, publicMsg.mNotificationBuilder, publicMsg.mTitle, publicMsg.mDescription, q);
        }
        a.contentIntent = service;
        a.deleteIntent = service2;
        notificationManager.notify(publicMsg.mMsgId, 0, a);
        m1809a(context, publicMsg, bArr, bArr2);
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            if ("android.intent.action.BOOT_COMPLETED".equals(action) || NetworkListener.f2257d.equals(action) || "android.intent.action.USER_PRESENT".equals(action) || "android.intent.action.MEDIA_CHECKING".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action) || "android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                if (!C0448d.m1945g(context) && C0578p.m2574h(context.getApplicationContext()) > 0) {
                    C0577o.m2490d(context);
                }
            } else if ("com.baidu.android.pushservice.action.notification.SHOW".equals(action)) {
                if (!C0448d.m1945g(context)) {
                    if (C0578p.m2608y(context)) {
                        final Object stringExtra = intent.getStringExtra("pushService_package_name");
                        final Object stringExtra2 = intent.getStringExtra("service_name");
                        final String stringExtra3 = intent.getStringExtra("notify_type");
                        final String stringExtra4 = intent.getStringExtra("app_id");
                        final byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_body");
                        final byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_secur_info");
                        int intExtra = intent.getIntExtra("baidu_message_type", -1);
                        final String stringExtra5 = intent.getStringExtra("message_id");
                        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && byteArrayExtra != null && byteArrayExtra2 != null && intExtra != -1 && !C0578p.m2599t(context, stringExtra5)) {
                            final Context context2 = context;
                            C0559d.m2387a().m2388a(new C0420c(this, "showPrivateNotification", (short) 99) {
                                /* renamed from: i */
                                final /* synthetic */ PushServiceReceiver f1331i;

                                /* renamed from: a */
                                public void mo1272a() {
                                    PublicMsg a = C0602e.m2690a(context2, stringExtra4, stringExtra5, byteArrayExtra2, byteArrayExtra);
                                    if (a != null) {
                                        C0578p.m2535a(context2, a);
                                        if (C6197b.f25307v.equals(stringExtra3)) {
                                            PushServiceReceiver.m1815b(context2, stringExtra, stringExtra2, a, byteArrayExtra2, byteArrayExtra);
                                        } else if ("rich_media".equals(stringExtra3)) {
                                            PushServiceReceiver.m1814b(context2, stringExtra, stringExtra2, a, stringExtra4);
                                        }
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    C0522f.m2200g(context);
                }
            } else if ("com.baidu.android.pushservice.action.media.CLICK".equals(action)) {
                C0527a.m2216a("PushServiceReceiver", "Rich media notification clicked", context.getApplicationContext());
                PublicMsg publicMsg = null;
                try {
                    if (intent.hasExtra("public_msg")) {
                        publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
                    }
                    if (C0578p.m2548b(context, publicMsg)) {
                        m1808a(context, publicMsg);
                    }
                } catch (ClassCastException e) {
                }
            }
        } catch (Exception e2) {
        }
    }
}
