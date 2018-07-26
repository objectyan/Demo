package com.baidu.mapframework.common.p202a;

import android.os.HandlerThread;

/* compiled from: AsyncLoggerThread */
/* renamed from: com.baidu.mapframework.common.a.d */
class C3469d extends HandlerThread {
    public C3469d(String name) {
        super(name);
        setDaemon(true);
    }

    public C3469d(String name, int priority) {
        super(name, priority);
        setDaemon(true);
    }
}
