package com.baidu.mapframework.common.p202a;

import com.baidu.mapframework.common.p202a.C3465a.C3464a;

/* compiled from: LogAppenderFactory */
/* renamed from: com.baidu.mapframework.common.a.g */
final class C3472g {
    C3472g() {
    }

    /* renamed from: a */
    public static C3465a m14911a(C3473h conf) {
        if (conf.m14912a().equals(C3464a.LOGCAT)) {
            return new C3477k();
        }
        if (conf.m14912a().equals(C3464a.FILE)) {
            return new C3470e(conf.m14915b());
        }
        return null;
    }
}
