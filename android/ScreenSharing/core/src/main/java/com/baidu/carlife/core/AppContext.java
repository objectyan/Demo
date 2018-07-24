package com.baidu.carlife.core;

import android.content.Context;
import android.content.ContextWrapper;

/* compiled from: AppContext */
/* renamed from: com.baidu.carlife.core.a */
public class AppContext extends ContextWrapper implements KeepClass {
    /* renamed from: a */
    private static AppContext f2967a;

    /* renamed from: a */
    public static AppContext m3876a() {
        return f2967a;
    }

    private AppContext(Context ctx) {
        super(ctx);
    }

    /* renamed from: a */
    public static synchronized void m3877a(Context context) {
        synchronized (AppContext.class) {
            if (f2967a == null) {
                f2967a = new AppContext(context);
            }
        }
    }
}
