package com.baidu.carlife.core;

import android.content.Context;
import android.content.ContextWrapper;

/* compiled from: AppContext */
/* renamed from: com.baidu.carlife.core.a */
public class AppContext extends ContextWrapper implements KeepClass {
    /* renamed from: a */
    private static AppContext sAppContext;

    /* renamed from: a */
    public static AppContext getAppContext() {
        return sAppContext;
    }

    private AppContext(Context ctx) {
        super(ctx);
    }

    /* renamed from: a */
    public static synchronized void newInstance(Context context) {
        synchronized (AppContext.class) {
            if (sAppContext == null) {
                sAppContext = new AppContext(context);
            }
        }
    }
}
