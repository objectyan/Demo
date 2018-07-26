package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.C0623i;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.p033a.C0607h;
import com.baidu.android.pushservice.message.p033a.C0609j;
import com.baidu.android.pushservice.message.p033a.C0612l;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p024c.C0448d;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p025d.C0472c;
import com.baidu.android.pushservice.p029h.C0544j;
import com.baidu.android.pushservice.p029h.C0546l;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p031j.C0574m;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.p031j.C0579q;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.speech.asr.SpeechConstant;
import com.meizu.cloud.pushsdk.PushManager;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PushMessageReceiver extends BroadcastReceiver {
    public static final String TAG = "PushMessageReceiver";

    /* renamed from: com.baidu.android.pushservice.PushMessageReceiver$a */
    private static class C0412a extends Handler {
        /* renamed from: d */
        protected final WeakReference<Context> f1294d;

        public C0412a(Context context) {
            this.f1294d = new WeakReference(context);
        }
    }

    /* renamed from: com.baidu.android.pushservice.PushMessageReceiver$b */
    private enum C0415b {
        MSG_PASS(1),
        MSG_ARRIVED(2),
        MSG_CLICKED(3);
        
        /* renamed from: d */
        private int f1311d;

        private C0415b(int i) {
            this.f1311d = i;
        }

        /* renamed from: a */
        private int m1742a() {
            return this.f1311d;
        }
    }

    private void handleMeizuMessageCallBack(Context context, Intent intent) {
        C0623i c0623i = new C0623i();
        int intExtra = intent.getIntExtra("mz_push_msg_type", 0);
        String c = c0623i.m2749c(context, intent.getStringExtra("mz_notification_self_define_content"));
        if (C0578p.m2608y(context) && !C0578p.m2609y(context, c0623i.f1963l) && PushManager.hwMessageVerify(context, c0623i.f1966o, (c0623i.f1963l + c).replaceAll("\\\\", "")) && intExtra == C0415b.MSG_CLICKED.m1742a()) {
            onNotificationClicked(context, intent.getStringExtra("mz_notification_title"), intent.getStringExtra("mz_notification_content"), c);
            C0553q.m2361a(context, c0623i.f1963l, "010206");
        }
    }

    private void handleOppoMessageCallBack(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("op_notification_sign");
        String stringExtra2 = intent.getStringExtra("op_notification_msg_id");
        Object stringExtra3 = intent.getStringExtra("op_notification_pkg_content");
        String stringExtra4 = intent.getStringExtra("extra_extra_custom_content");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && C0578p.m2608y(context) && !C0578p.m2609y(context, stringExtra2) && C0522f.m2191b(context, stringExtra, stringExtra2 + stringExtra4)) {
            if (!TextUtils.isEmpty(stringExtra3)) {
                try {
                    Intent parseUri = Intent.parseUri(stringExtra3, 0);
                    parseUri.setPackage(context.getPackageName());
                    parseUri.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                    JSONObject jSONObject = new JSONObject(stringExtra4);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        stringExtra = (String) keys.next();
                        parseUri.putExtra(stringExtra, jSONObject.optString(stringExtra));
                    }
                    if (context.getPackageManager().queryIntentActivities(parseUri, 0).size() > 0) {
                        context.startActivity(parseUri);
                    }
                } catch (Exception e) {
                    return;
                }
            }
            try {
                onNotificationClicked(context, null, null, new JSONObject("{\"extras\":" + stringExtra4 + "}").getString("extras"));
                C0553q.m2361a(context, stringExtra2, "010207");
            } catch (Exception e2) {
            }
        }
    }

    private void handleXiaomiMessageCallBack(Context context, MiPushMessage miPushMessage, int i) {
        try {
            String content = miPushMessage.getContent();
            C0623i c0623i = new C0623i();
            String str = "";
            boolean msgFromXMConsole = msgFromXMConsole(content);
            if (msgFromXMConsole) {
                c0623i.f1964m = C0612l.MSG_TYPE_SINGLE_PRIVATE.m2706a();
            } else {
                content = c0623i.m2748b(context, content);
            }
            if (C0578p.m2608y(context) && (i == C0415b.MSG_CLICKED.m1742a() || !C0578p.m2609y(context, c0623i.f1963l))) {
                if (c0623i.f1964m == C0612l.MSG_TYPE_APPSTAT_COMMAND.m2706a()) {
                    C0578p.m2493A(context);
                } else if (c0623i.f1964m == C0612l.MSG_TYPE_LBS_APPLIST_COMMAND.m2706a()) {
                    C0578p.m2495B(context);
                } else if (c0623i.f1964m == C0612l.MSG_TYPE_PRIVATE_MESSAGE.m2706a() || c0623i.f1964m == C0612l.MSG_TYPE_MULTI_PRIVATE.m2706a() || c0623i.f1964m == C0612l.MSG_TYPE_SINGLE_PRIVATE.m2706a() || c0623i.f1964m == C0612l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.m2706a() || c0623i.f1964m == C0612l.MSG_TYPE_SINGLE_PUBLIC.m2706a() || c0623i.f1964m == C0612l.MSG_TYPE_MULTI_PUBLIC.m2706a()) {
                    if (i == C0415b.MSG_PASS.m1742a()) {
                        onMessage(context, content, null);
                    } else if (i == C0415b.MSG_ARRIVED.m1742a()) {
                        onNotificationArrived(context, miPushMessage.getTitle(), miPushMessage.getDescription(), content);
                    } else if (i == C0415b.MSG_CLICKED.m1742a()) {
                        onNotificationClicked(context, miPushMessage.getTitle(), miPushMessage.getDescription(), content);
                    }
                }
            }
            if (!msgFromXMConsole && i == C0415b.MSG_CLICKED.m1742a()) {
                C0553q.m2361a(context, c0623i.f1963l, "010205");
            }
        } catch (Throwable th) {
        }
    }

    private static boolean msgFromXMConsole(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private void sendCallback(Context context, Intent intent, int i) {
        try {
            if (!intent.getBooleanExtra("bdpush_deliver_NO_CALLBACK", false)) {
                intent.putExtra("bd.cross.request.RESULT_CODE", i);
                intent.setClass(context, CommandService.class);
                intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_ACK");
                context.startService(intent);
            }
        } catch (Exception e) {
        }
    }

    public abstract void onBind(Context context, int i, String str, String str2, String str3, String str4);

    public abstract void onDelTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onListTags(Context context, int i, List<String> list, String str);

    public abstract void onMessage(Context context, String str, String str2);

    public abstract void onNotificationArrived(Context context, String str, String str2, String str3);

    public abstract void onNotificationClicked(Context context, String str, String str2, String str3);

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            try {
                intent.getByteArrayExtra("baidu_message_secur_info");
                String action = intent.getAction();
                final byte[] byteArrayExtra;
                final byte[] byteArrayExtra2;
                final String stringExtra;
                if (action.equals(PushConstants.ACTION_MESSAGE)) {
                    if (!C0448d.m1945g(context)) {
                        if (!C0578p.m2608y(context)) {
                            C0522f.m2200g(context);
                        } else if (intent.getExtras() != null) {
                            byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
                            byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
                            stringExtra = intent.getStringExtra("message_id");
                            final int intExtra = intent.getIntExtra("baidu_message_type", -1);
                            final Object stringExtra2 = intent.getStringExtra("app_id");
                            if (byteArrayExtra == null || byteArrayExtra2 == null || TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || intExtra == -1) {
                                sendCallback(context, intent, 2);
                            } else if (C0578p.m2599t(context, stringExtra) || !C0463a.m2013e(context, stringExtra)) {
                                sendCallback(context, intent, 4);
                            } else {
                                final Context context2 = context;
                                final Intent intent2 = intent;
                                final C0412a c04131 = new C0412a(this, context) {
                                    /* renamed from: c */
                                    final /* synthetic */ PushMessageReceiver f1297c;

                                    public void handleMessage(Message message) {
                                        if (this.d.get() != null) {
                                            this.f1297c.onMessage((Context) this.d.get(), message.getData().getString(PushConstants.EXTRA_PUSH_MESSAGE), message.getData().getString("custom_content"));
                                            this.f1297c.sendCallback(context2, intent2, 10);
                                        }
                                    }
                                };
                                final Context context3 = context;
                                final Intent intent3 = intent;
                                new Thread(this) {
                                    /* renamed from: i */
                                    final /* synthetic */ PushMessageReceiver f1306i;

                                    public void run() {
                                        String[] a = C0607h.m2699a(context3, intExtra, stringExtra2, stringExtra, byteArrayExtra, byteArrayExtra2);
                                        if (a == null || a.length != 2) {
                                            this.f1306i.sendCallback(context3, intent3, 9);
                                            return;
                                        }
                                        Message message = new Message();
                                        Bundle bundle = new Bundle();
                                        bundle.putString(PushConstants.EXTRA_PUSH_MESSAGE, a[0]);
                                        bundle.putString("custom_content", a[1]);
                                        message.setData(bundle);
                                        c04131.sendMessage(message);
                                        C0578p.m2546b("message " + a[0] + " at time of " + System.currentTimeMillis(), context3);
                                        if (C0430a.m1857b() > 0) {
                                            C0546l.m2334b(context3, stringExtra2, stringExtra, intExtra, a[0].getBytes(), 0, C0544j.f1797a);
                                        }
                                    }
                                }.start();
                            }
                        }
                    }
                } else if (action.equals(PushConstants.ACTION_RECEIVE)) {
                    r5 = intent.getStringExtra("method");
                    if (!TextUtils.isEmpty(r5)) {
                        int intExtra2 = intent.getIntExtra(PushConstants.EXTRA_ERROR_CODE, 0);
                        String str = intent.getByteArrayExtra("content") != null ? new String(intent.getByteArrayExtra("content")) : "";
                        if (r5.equals("com.baidu.android.pushservice.action.notification.ARRIVED")) {
                            action = intent.getStringExtra("msgid");
                            r5 = intent.getStringExtra("notification_title");
                            r6 = intent.getStringExtra("notification_content");
                            r7 = intent.getStringExtra("extra_extra_custom_content");
                            if (C0578p.m2538a(context, intent.getByteArrayExtra("baidu_message_secur_info"), intent.getStringExtra("com.baidu.pushservice.app_id"), action, intent.getByteArrayExtra("baidu_message_body"))) {
                                onNotificationArrived(context, r5, r6, r7);
                            }
                        } else if (r5.equals(PushConstants.METHOD_BIND) || r5.equals("method_deal_lapp_bind_intent")) {
                            if (intExtra2 != 0 || TextUtils.isEmpty(str)) {
                                onBind(context, intExtra2, null, null, null, null);
                                C0553q.m2358a(context, "020102", context.getPackageName(), intExtra2, str);
                                C0578p.m2546b("onBind from " + context.getPackageName() + " errorCode " + intExtra2 + " errorMsg = " + str + " at time of " + System.currentTimeMillis(), context);
                                return;
                            }
                            try {
                                r4 = new JSONObject(str);
                                r8 = r4.getString("request_id");
                                r4 = r4.getJSONObject("response_params");
                                r6 = r4.getString(SpeechConstant.APP_ID);
                                PushSettings.m1824b(context, r6);
                                r7 = r4.getString("channel_id");
                                stringExtra = r4.getString("user_id");
                                long j = 0;
                                String str2 = null;
                                String str3 = null;
                                if (intent.hasExtra("real_bind")) {
                                    j = System.currentTimeMillis();
                                    str2 = intent.getStringExtra("access_token");
                                    str3 = intent.getStringExtra("secret_key");
                                }
                                C0574m.m2468a(context, r6, r7, r8, stringExtra, true, C0578p.m2559d(context, context.getPackageName()), j, str2, str3);
                                onBind(context, intExtra2, r6, stringExtra, r7, r8);
                                C0578p.m2546b("PushMessageReceiver#onBind from " + context.getPackageName() + ", errorCode= " + intExtra2 + ", appid=  " + r6 + ", userId=" + stringExtra + ", channelId=" + r7 + ", requestId=" + r8 + ", at time of " + System.currentTimeMillis(), context);
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(context.getPackageName());
                                stringBuilder.append(",");
                                stringBuilder.append(r6);
                                stringBuilder.append(",");
                                stringBuilder.append(stringExtra);
                                stringBuilder.append(",");
                                stringBuilder.append("false");
                                stringBuilder.append(",");
                                stringBuilder.append(C0430a.m1854a());
                                action = C0432b.m1870a(context).m1882b(stringBuilder.toString());
                                C0472c.m2038e(context, action);
                                if (C0578p.m2501E(context)) {
                                    C0579q.m2613a(context, context.getPackageName() + ".self_push_sync", "bindinfo", action);
                                }
                            } catch (Exception e) {
                                Exception exception = e;
                                onBind(context, intExtra2, null, null, null, null);
                                C0553q.m2358a(context, "020102", context.getPackageName(), intExtra2, exception.getMessage());
                                C0578p.m2546b("onBind from " + context.getPackageName() + " errorCode " + intExtra2 + " exception " + exception.getMessage() + " at time of " + System.currentTimeMillis(), context);
                            }
                        } else if (r5.equals("method_unbind") || r5.equals("method_lapp_unbind")) {
                            Editor edit = context.getSharedPreferences("bindcache", 0).edit();
                            r4 = !C0448d.m1945g(context) ? 0 : intExtra2;
                            try {
                                onUnbind(context, r4, new JSONObject(str).getString("request_id"));
                                edit.putBoolean("bind_status", false);
                                edit.commit();
                            } catch (JSONException e2) {
                                onUnbind(context, r4, null);
                                edit.putBoolean("bind_status", false);
                                edit.commit();
                            }
                            if (C0448d.m1940c(context)) {
                                MiPushClient.unregisterPush(context);
                            }
                            if (C0448d.m1939b(context)) {
                                Object a = C0574m.m2465a(context, "BD_MEIZU_PROXY_APPID_KEY");
                                Object a2 = C0574m.m2465a(context, "BD_MEIZU_PROXY_APPKEY_KEY");
                                if (!(TextUtils.isEmpty(a) || TextUtils.isEmpty(a2))) {
                                    PushManager.unRegister(context, a, a2);
                                }
                            }
                            C0578p.m2546b("unbind from" + context.getPackageName() + " errorCode " + r4 + " at time of " + System.currentTimeMillis(), context);
                        } else if (r5.equals("method_set_tags") || r5.equals("method_set_lapp_tags")) {
                            try {
                                r4 = new JSONObject(str);
                                stringExtra = r4.getString("request_id");
                                if (TextUtils.isEmpty(r4.optString(PushConstants.EXTRA_ERROR_CODE))) {
                                    r4 = r4.optJSONObject("response_params");
                                    if (r4 != null) {
                                        r5 = r4.getJSONArray("details");
                                        if (r5 != null) {
                                            r7 = new ArrayList();
                                            r8 = new ArrayList();
                                            for (r4 = 0; r4 < r5.length(); r4++) {
                                                r6 = r5.getJSONObject(r4);
                                                r10 = r6.getString("tag");
                                                if (r6.getInt("result") == 0) {
                                                    r7.add(r10);
                                                } else {
                                                    r8.add(r10);
                                                }
                                            }
                                            onSetTags(context, intExtra2, r7, r8, stringExtra);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                onSetTags(context, intExtra2, new ArrayList(), new ArrayList(), stringExtra);
                            } catch (JSONException e3) {
                                onSetTags(context, intExtra2, null, null, null);
                            }
                        } else if (r5.equals("method_del_tags") || r5.equals("method_del_lapp_tags")) {
                            try {
                                r4 = new JSONObject(str);
                                stringExtra = r4.getString("request_id");
                                r4 = r4.getJSONObject("response_params");
                                if (r4 != null) {
                                    r5 = r4.getJSONArray("details");
                                    if (r5 != null) {
                                        r7 = new ArrayList();
                                        r8 = new ArrayList();
                                        for (r4 = 0; r4 < r5.length(); r4++) {
                                            r6 = r5.getJSONObject(r4);
                                            r10 = r6.getString("tag");
                                            if (r6.getInt("result") == 0) {
                                                r7.add(r10);
                                            } else {
                                                r8.add(r10);
                                            }
                                        }
                                        onDelTags(context, intExtra2, r7, r8, stringExtra);
                                    }
                                }
                            } catch (JSONException e4) {
                                onDelTags(context, intExtra2, null, null, null);
                            }
                        } else if (r5.equals("method_listtags") || r5.equals("method_list_lapp_tags")) {
                            try {
                                onListTags(context, intExtra2, intent.getStringArrayListExtra("tags_list"), new JSONObject(str).getString("request_id"));
                            } catch (JSONException e5) {
                                onListTags(context, intExtra2, null, null);
                            }
                        }
                    }
                } else if (action.equals("com.baidu.android.pushservice.action.notification.CLICK")) {
                    r5 = intent.getStringExtra("msgid");
                    r7 = intent.getStringExtra("notification_title");
                    r8 = intent.getStringExtra("notification_content");
                    stringExtra = intent.getStringExtra("extra_extra_custom_content");
                    r6 = intent.getStringExtra("com.baidu.pushservice.app_id");
                    byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
                    byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
                    if (C0578p.m2551b(context, r5, r6, r7, r8, stringExtra) || C0578p.m2538a(context, byteArrayExtra, r6, r5, byteArrayExtra2)) {
                        onNotificationClicked(context, r7, r8, stringExtra);
                    }
                } else if (action.equals("com.huawei.android.push.intent.REGISTRATION")) {
                    if (C0448d.m1941d(context)) {
                        try {
                            action = new String(intent.getByteArrayExtra("device_token"), "UTF-8");
                            if (!TextUtils.isEmpty(action)) {
                                C0522f.m2179a(context, action);
                            }
                        } catch (Exception e6) {
                        }
                    }
                } else if (action.equals("com.huawei.intent.action.PUSH")) {
                    if (C0448d.m1941d(context)) {
                        try {
                            Object str4 = new String(intent.getByteArrayExtra("selfshow_info"), "UTF-8");
                            if (!TextUtils.isEmpty(str4) && context != null) {
                                r4 = C0609j.m2703a(context, str4);
                                PublicMsg a3 = r4.m2745a(context);
                                if (a3 != null && C0578p.m2608y(context)) {
                                    if (!C0578p.m2609y(context, r4.f1963l)) {
                                        PushServiceReceiver.m1810a(context, context.getPackageName(), "com.baidu.android.pushservice.CommandService", a3);
                                    }
                                }
                            }
                        } catch (Exception e7) {
                        }
                    }
                } else if (action.equals("com.huawei.android.push.intent.RECEIVE")) {
                    if (C0448d.m1941d(context)) {
                        byte[] byteArrayExtra3 = intent.getByteArrayExtra("msg_data");
                        byte[] byteArrayExtra4 = intent.getByteArrayExtra("device_token");
                        try {
                            r6 = new String(byteArrayExtra3, "utf-8");
                            action = new String(byteArrayExtra4, "utf-8");
                            r4 = new C0623i();
                            r5 = r4.m2746a(context, r6);
                            if (C0578p.m2608y(context)) {
                                if (!C0578p.m2609y(context, r4.f1963l)) {
                                    if (!PushManager.hwMessageVerify(context, r4.f1966o, r4.f1963l + r5)) {
                                        return;
                                    }
                                    if (r4.f1964m == C0612l.MSG_TYPE_APPSTAT_COMMAND.m2706a()) {
                                        C0578p.m2493A(context);
                                    } else if (r4.f1964m == C0612l.MSG_TYPE_LBS_APPLIST_COMMAND.m2706a()) {
                                        C0578p.m2495B(context);
                                    } else if (r4.f1964m == C0612l.MSG_TYPE_PRIVATE_MESSAGE.m2706a() || r4.f1964m == C0612l.MSG_TYPE_SINGLE_PRIVATE.m2706a()) {
                                        onMessage(context, r5, null);
                                    }
                                }
                            }
                        } catch (Exception e8) {
                        }
                    }
                } else if (action.equals(PushPatchMessageReceiver.XIAOMI_REGISTER)) {
                    if (C0448d.m1940c(context)) {
                        if (intent.hasExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE)) {
                            if (intent.getLongExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE, 0) != 0) {
                                C0522f.m2202i(context);
                                return;
                            }
                            if (intent.hasExtra(PushPatchMessageReceiver.REGID)) {
                                action = intent.getStringExtra(PushPatchMessageReceiver.REGID);
                                if (!TextUtils.isEmpty(action)) {
                                    C0522f.m2179a(context, action);
                                }
                            }
                        }
                    }
                } else if (action.equals(PushPatchMessageReceiver.XIAOMI_PUSH_MSG)) {
                    if (C0448d.m1940c(context)) {
                        if (intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG)) {
                            MiPushMessage miPushMessage = (MiPushMessage) intent.getSerializableExtra(PushPatchMessageReceiver.PUSH_MSG);
                            if (intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE)) {
                                handleXiaomiMessageCallBack(context, miPushMessage, intent.getIntExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE, 0));
                            }
                        }
                    }
                } else if (action.equals("com.meizu.mzpush.REGISTER")) {
                    if (C0448d.m1939b(context)) {
                        if (intent.hasExtra("mz_register_errorcode")) {
                            if (intent.getStringExtra("mz_register_errorcode").equals("200")) {
                                if (intent.hasExtra("mz_pushid")) {
                                    action = intent.getStringExtra("mz_pushid");
                                    if (!TextUtils.isEmpty(action)) {
                                        C0522f.m2179a(context, action);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            C0522f.m2203j(context);
                        }
                    }
                } else if (action.equals("com.meizu.mzpush.PUSH_MSG")) {
                    if (C0448d.m1939b(context)) {
                        if (intent.hasExtra("mz_push_msg_type")) {
                            handleMeizuMessageCallBack(context, intent);
                        }
                    }
                } else if (action.equals("com.baidu.android.pushservice.action.OPPO_CLICK") && C0448d.m1942e(context)) {
                    handleOppoMessageCallBack(context, intent);
                }
            } catch (Exception e9) {
            }
        }
    }

    public abstract void onSetTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onUnbind(Context context, int i, String str);
}
