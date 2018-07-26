package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Map;

class bm {
    /* renamed from: b */
    private static HandlerThread f19457b = new HandlerThread("EventHandleThread");
    /* renamed from: c */
    private static Handler f19458c;
    /* renamed from: d */
    private static bm f19459d = new bm();
    /* renamed from: a */
    HashMap<String, bs> f19460a = new HashMap();

    private bm() {
        f19457b.start();
        f19457b.setPriority(10);
        f19458c = new Handler(f19457b.getLooper());
    }

    /* renamed from: a */
    public static bm m15495a() {
        return f19459d;
    }

    /* renamed from: a */
    public void m15497a(Context context, String str, String str2, int i, long j, long j2, ExtraInfo extraInfo, Map<String, String> map) {
        DataCore.instance().putEvent(context, str, str2, i, j, j2, "", "", 0, false, extraInfo, map);
        DataCore.instance().flush(context);
    }

    /* renamed from: a */
    public void m15498a(Context context, String str, String str2, int i, long j, long j2, String str3, String str4, int i2, boolean z) {
        DataCore.instance().putEvent(context, str, str2, i, j, j2, str3, str4, i2, z, null, null);
        DataCore.instance().flush(context);
    }

    /* renamed from: a */
    public void m15500a(Context context, String str, String str2, int i, long j, String str3, String str4, int i2, boolean z) {
        f19458c.post(new bn(this, context, str, str2, i, j, str3, str4, i2, z));
    }

    /* renamed from: a */
    public void m15499a(Context context, String str, String str2, int i, long j, ExtraInfo extraInfo, Map<String, String> map) {
        f19458c.post(new bo(this, context, str, str2, i, j, extraInfo, map));
    }

    /* renamed from: a */
    public void m15501a(Context context, String str, String str2, long j) {
        f19458c.post(new bp(this, j, str, str2));
    }

    /* renamed from: a */
    public void m15502a(Context context, String str, String str2, long j, ExtraInfo extraInfo, Map<String, String> map) {
        f19458c.post(new bq(this, str, str2, j, context, extraInfo, map));
    }

    /* renamed from: b */
    public void m15503b(Context context, String str, String str2, long j, ExtraInfo extraInfo, Map<String, String> map) {
        f19458c.post(new br(this, j, context, str, str2, extraInfo, map));
    }

    /* renamed from: a */
    public String m15496a(String str, String str2) {
        return "__sdk_" + str + "$|$" + str2;
    }
}
