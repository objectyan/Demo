package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p023b.C0437f;
import com.baidu.android.pushservice.p023b.C0439h;
import com.baidu.android.pushservice.p031j.C0577o;
import com.baidu.android.pushservice.p031j.C0578p;

public class RegistrationReceiver extends BroadcastReceiver {
    /* renamed from: a */
    static void m1843a(Context context, C0437f c0437f) {
        Intent intent = new Intent();
        intent.setAction(PushConstants.ACTION_METHOD);
        intent.putExtra("method", "com.baidu.android.pushservice.action.UNBINDAPP");
        intent.putExtra("package_name", c0437f.m1867c());
        intent.putExtra("app_id", c0437f.m1861a());
        intent.putExtra("user_id", c0437f.f1375f);
        C0577o.m2484a(context, intent);
    }

    /* renamed from: c */
    private static void m1845c(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("r_sync_from"))) {
            String stringExtra = intent.getStringExtra("r_sync_rdata_v2");
            if (!TextUtils.isEmpty(stringExtra)) {
                C0432b.m1870a(context).m1881a("r_v2", stringExtra);
            }
        }
    }

    /* renamed from: d */
    private static void m1846d(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("r_sync_sdk_from"))) {
            Object stringExtra = intent.getStringExtra("r_sync_rdata_v2");
            if (!TextUtils.isEmpty(stringExtra)) {
                C0439h.m1902a(context).m1897a("com.baidu.push.sdkr", (String) stringExtra);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                try {
                    CharSequence u = C0578p.m2600u(context);
                    if (TextUtils.isEmpty(u) || context.getPackageName().equals(u)) {
                        action = intent.getData().getSchemeSpecificPart();
                        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                        if (!booleanExtra) {
                            PushSettings.m1826c(context, action);
                        }
                        C0437f c = C0432b.m1870a(context).m1885c(action);
                        if (!booleanExtra && c != null && !context.getPackageName().equals(c.m1867c())) {
                            m1843a(context, c);
                        }
                    }
                } catch (Exception e) {
                }
            } else if ("com.baidu.android.pushservice.action.BIND_SYNC".equals(action)) {
                final Intent intent2 = intent;
                final Context context2 = context;
                C0559d.m2387a().m2388a(new C0420c(this, "register_sync", (short) 99) {
                    /* renamed from: c */
                    final /* synthetic */ RegistrationReceiver f1350c;

                    /* renamed from: a */
                    public void mo1272a() {
                        if (intent2.hasExtra("r_sync_type")) {
                            switch (intent2.getIntExtra("r_sync_type", 0)) {
                                case 0:
                                    RegistrationReceiver.m1845c(context2, intent2);
                                    return;
                                case 3:
                                    RegistrationReceiver.m1846d(context2, intent2);
                                    return;
                                default:
                                    return;
                            }
                        }
                        RegistrationReceiver.m1845c(context2, intent2);
                    }
                });
            } else {
                C0577o.m2488b(context, intent);
            }
        } catch (Exception e2) {
        }
    }
}
