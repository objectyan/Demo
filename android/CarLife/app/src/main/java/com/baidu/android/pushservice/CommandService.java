package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.p029h.C0546l;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p031j.C0578p;
import java.lang.reflect.Method;

public class CommandService extends Service {
    /* renamed from: a */
    private void m1739a(Intent intent) {
        String c = C0578p.m2554c(this, getPackageName(), intent.getAction());
        C0578p.m2546b("CommandService#onStartCommand#reflectReceiver#recevier = " + c, (Context) this);
        if (TextUtils.isEmpty(c)) {
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
            return;
        }
        try {
            Class cls = Class.forName(c);
            Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            String[] strArr = new String[]{"android.content.Context", "android.content.Intent"};
            Method method = cls.getMethod("onReceive", new Class[]{Context.class, Intent.class});
            intent.setClassName(getPackageName(), c);
            method.invoke(newInstance, new Object[]{getApplicationContext(), intent});
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    private void m1740b(Intent intent) {
        try {
            Object stringExtra = intent.getStringExtra("bd.cross.request.SOURCE_SERVICE");
            String stringExtra2 = intent.getStringExtra("bd.cross.request.SOURCE_PACKAGE");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                intent.setPackage(stringExtra2);
                intent.setClassName(stringExtra2, stringExtra);
                intent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
                intent.putExtra("bd.cross.request.SENDING", false);
                getApplicationContext().startService(intent);
            }
        } catch (Exception e) {
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Object obj = null;
        if (intent != null) {
            String action = intent.getAction();
            C0578p.m2546b("CommandService#onStartCommand#action = " + action, (Context) this);
            try {
                String stringExtra;
                if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(action)) {
                    C0578p.m2546b("push_passthrough: receive  click delete and notified action", getApplicationContext());
                    String stringExtra2 = intent.hasExtra("app_id") ? intent.getStringExtra("app_id") : null;
                    if (intent.hasExtra("msg_id")) {
                        stringExtra = intent.getStringExtra("msg_id");
                    }
                    C0546l.m2333a(getApplicationContext(), stringExtra, stringExtra2, action);
                    if (intent.getBooleanExtra("self_insert", false)) {
                        new C0553q(this).m2367a();
                    }
                    stopSelf();
                } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                    PublicMsg publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
                    String stringExtra3 = intent.getStringExtra("app_id");
                    String stringExtra4 = intent.getStringExtra("msg_id");
                    publicMsg.handlePrivateNotification(getApplicationContext(), action, stringExtra4, stringExtra3, intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"));
                    if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action)) {
                        C0553q.m2361a(getApplicationContext(), stringExtra4, "010203");
                    } else if ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                        C0553q.m2361a(getApplicationContext(), stringExtra4, "010204");
                    }
                    stopSelf();
                } else {
                    if (intent.hasExtra("command_type")) {
                        obj = intent.getStringExtra("command_type");
                    }
                    if ("reflect_receiver".equals(obj)) {
                        m1739a(intent);
                    } else if (intent.hasExtra("bd.cross.request.COMMAND_TYPE")) {
                        stringExtra = intent.getStringExtra("bd.cross.request.COMMAND_TYPE");
                        if ("bd.cross.command.MESSAGE_DELIVER".equals(stringExtra)) {
                            m1739a(intent);
                        } else if ("bd.cross.command.MESSAGE_ACK".equals(stringExtra)) {
                            m1740b(intent);
                        }
                    }
                    stopSelf();
                }
            } catch (RuntimeException e) {
            }
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
