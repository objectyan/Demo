package com.baidu.mapframework.common.p202a;

import android.util.Log;
import com.baidu.mapframework.common.p202a.C3465a.C3464a;
import java.util.Date;
import java.util.Locale;

/* compiled from: LogcatAppender */
/* renamed from: com.baidu.mapframework.common.a.k */
class C3477k implements C3465a {
    /* renamed from: a */
    private boolean f18768a = false;

    C3477k() {
    }

    /* renamed from: b */
    public C3464a mo2547b() {
        return C3464a.LOGCAT;
    }

    /* renamed from: a */
    public void mo2546a(C3474i event) {
        if (!this.f18768a) {
            m14919b(event);
        }
    }

    /* renamed from: a */
    public void mo2545a() {
        this.f18768a = true;
    }

    /* renamed from: b */
    private void m14919b(C3474i event) {
        String logMessage = String.format(Locale.getDefault(), "[%d] [%s] [%s] [%s] [%s] [%s]\n", new Object[]{Long.valueOf(event.f18761d), event.f18758a.format(new Date(event.f18761d)), event.f18760c, event.f18759b, event.f18763f, event.f18762e});
        switch (event.f18759b) {
            case DEBUG:
                Log.d(event.f18760c, logMessage);
                return;
            case INFO:
                Log.i(event.f18760c, logMessage);
                return;
            case WARN:
                Log.w(event.f18760c, logMessage);
                return;
            case ERROR:
            case FATAL:
                Log.e(event.f18760c, logMessage);
                return;
            default:
                return;
        }
    }
}
