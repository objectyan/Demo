package com.baidu.android.pushservice.p031j;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.p029h.C0543i;
import com.baidu.android.pushservice.p029h.C0553q;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.baidu.android.pushservice.j.j */
public class C0571j {
    /* renamed from: a */
    public static void m2456a(Context context, Intent intent, Intent intent2) {
        long longExtra;
        String stringExtra = intent.getStringExtra("message_id");
        List<C0543i> arrayList = new ArrayList();
        Map hashMap = new HashMap();
        long longExtra2;
        long longExtra3;
        long j;
        if (intent2 != null) {
            longExtra = intent.getLongExtra("bd.message.rate.GET", 0);
            longExtra2 = intent.getLongExtra("bd.message.rate.REDIRECTION", 0);
            longExtra3 = intent2.getLongExtra("bd.message.rate.BACK", 0);
            long longExtra4 = intent2.getLongExtra("bd.message.rate.END", 0);
            j = longExtra4 - longExtra;
            hashMap.put("030801", Long.valueOf(longExtra2 - longExtra));
            hashMap.put("030802", Long.valueOf(longExtra3 - longExtra2));
            hashMap.put("030803", Long.valueOf(longExtra4 - longExtra3));
            longExtra = j;
        } else {
            longExtra = intent.getLongExtra("bd.message.rate.GET", 0);
            longExtra2 = intent.getLongExtra("bd.message.rate.REDIRECTION", 0);
            longExtra3 = intent.getLongExtra("bd.message.rate.TIMEOUT", 0);
            j = longExtra3 - longExtra;
            hashMap.put("030801", Long.valueOf(longExtra2 - longExtra));
            hashMap.put("030803", Long.valueOf(longExtra3 - longExtra2));
            hashMap.put("030805", Long.valueOf(j));
            longExtra = j;
        }
        C0543i c0543i = new C0543i();
        c0543i.d = "030804";
        c0543i.f1795b = stringExtra;
        c0543i.f1796c = longExtra + "";
        c0543i.f = "100%";
        c0543i.i = longExtra + "";
        c0543i.e = System.currentTimeMillis();
        arrayList.add(c0543i);
        for (Entry entry : hashMap.entrySet()) {
            C0543i c0543i2 = new C0543i();
            c0543i2.d = (String) entry.getKey();
            c0543i2.f1795b = stringExtra;
            c0543i2.f1796c = longExtra + "";
            c0543i2.i = entry.getValue() + "";
            c0543i2.f = new DecimalFormat("#.##").format((((double) ((Long) entry.getValue()).longValue()) / ((double) longExtra)) * 100.0d) + "%";
            c0543i2.e = System.currentTimeMillis();
            arrayList.add(c0543i2);
        }
        for (C0543i c0543i3 : arrayList) {
            C0553q.m2354a(context, c0543i3);
        }
    }
}
