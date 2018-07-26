package com.baidu.carlife.core;

import android.content.Context;
import android.content.ContextWrapper;

/* compiled from: AppContext */
/* renamed from: com.baidu.carlife.core.a */
public class C1157a extends ContextWrapper implements C0689h {
    /* renamed from: a */
    private static C1157a f2967a;

    /* renamed from: a */
    public static C1157a m3876a() {
        return f2967a;
    }

    private C1157a(Context ctx) {
        super(ctx);
    }

    /* renamed from: a */
    public static synchronized void m3877a(Context context) {
        synchronized (C1157a.class) {
            if (f2967a == null) {
                f2967a = new C1157a(context);
            }
        }
    }
}
