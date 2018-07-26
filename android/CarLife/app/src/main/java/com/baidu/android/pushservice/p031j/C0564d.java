package com.baidu.android.pushservice.p031j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.android.pushservice.j.d */
public class C0564d {
    /* renamed from: a */
    private static Map<Long, C0566e> f1850a;

    /* renamed from: a */
    public static synchronized void m2426a(long j) {
        synchronized (C0564d.class) {
            if (f1850a.containsKey(Long.valueOf(j))) {
                f1850a.remove(f1850a.get(Long.valueOf(j)));
            }
        }
    }

    /* renamed from: a */
    public static void m2427a(Context context, Intent intent) {
        if (intent.hasExtra("bd.cross.request.COMMAND_TYPE")) {
            String stringExtra = intent.getStringExtra("bd.cross.request.COMMAND_TYPE");
            if (!TextUtils.isEmpty(stringExtra)) {
                if (stringExtra.equals("bd.cross.command.MESSAGE_ACK") || stringExtra.equals("bd.cross.command.ULTRON_ACK")) {
                    long longExtra = intent.getLongExtra("bd.cross.request.ID", 0);
                    if (longExtra != 0 && f1850a != null && f1850a.containsKey(Long.valueOf(longExtra))) {
                        ((C0566e) f1850a.get(Long.valueOf(longExtra))).m2433a(intent);
                        f1850a.remove(f1850a.get(Long.valueOf(longExtra)));
                    }
                } else if (stringExtra.equals("bd.cross.command.ULTRON_DELIVER")) {
                    intent.getLongExtra("bd.cross.request.ID", 0);
                    Object stringExtra2 = intent.getStringExtra("bd.cross.request.SOURCE_SERVICE");
                    String stringExtra3 = intent.getStringExtra("bd.cross.request.SOURCE_PACKAGE");
                    if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3)) {
                        intent.setPackage(stringExtra3);
                        intent.setClassName(stringExtra3, stringExtra2);
                        intent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
                        intent.putExtra("bd.cross.request.SENDING", false);
                        intent.putExtra("bd.cross.request.RESULT_CODE", (short) 10);
                        intent.putExtra("bd.cross.request.RESULT_DATA", "{DATA:\"OK\"}");
                        intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.ULTRON_ACK");
                        try {
                            context.startService(intent);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m2428a(C0566e c0566e) {
        synchronized (C0564d.class) {
            if (f1850a == null) {
                f1850a = Collections.synchronizedMap(new HashMap());
            }
            if (f1850a.containsKey(Long.valueOf(c0566e.m2432a()))) {
                ((C0566e) f1850a.remove(c0566e)).m2432a();
            }
            f1850a.put(Long.valueOf(c0566e.m2432a()), c0566e);
        }
    }
}
