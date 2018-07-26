package com.baidu.location.p187a;

import android.os.HandlerThread;

/* renamed from: com.baidu.location.a.l */
public class C3209l {
    /* renamed from: a */
    private static HandlerThread f17445a = null;

    /* renamed from: a */
    public static synchronized HandlerThread m13436a() {
        HandlerThread handlerThread;
        synchronized (C3209l.class) {
            if (f17445a == null) {
                f17445a = new HandlerThread("ServiceStartArguments", 10);
                f17445a.start();
            }
            handlerThread = f17445a;
        }
        return handlerThread;
    }
}
