package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.auth.C4974a;
import com.baidu.tts.auth.C4978b.C4976a;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p225m.C5148j;
import com.baidu.tts.p233f.C5095m;
import com.baidu.tts.p243o.p244a.C5152c;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class OfflineAuthNotificationInterceptor extends AInterceptor {
    /* renamed from: b */
    private AtomicInteger f20652b = new AtomicInteger(-1);

    /* renamed from: a */
    protected void mo3796a() {
        this.a.add("speak");
    }

    /* renamed from: a */
    protected Object mo3795a(Object obj, Method method, Object[] objArr) {
        C5152c c5152c = (C5152c) obj;
        if (c5152c.m17492q()) {
            C5095m mode = c5152c.getMode();
            if (mode == null) {
                c5152c.m17491p();
                return AInterceptorHandler.END;
            }
            switch (mode) {
                case MIX:
                case OFFLINE:
                    int incrementAndGet = this.f20652b.incrementAndGet();
                    LoggerProxy.m17001d("OfflineAuthNotificationInterceptor", "currentCount=" + incrementAndGet);
                    if (incrementAndGet % 20 == 0) {
                        C5146i c5146i = (C5146i) objArr[0];
                        C5148j ttsParams = c5152c.getTtsParams();
                        if (ttsParams != null) {
                            return m16554a(c5152c, ttsParams, c5146i);
                        }
                        c5152c.m17491p();
                        return AInterceptorHandler.END;
                    }
                    break;
            }
            return AInterceptorHandler.DEFAULT;
        }
        c5152c.m17491p();
        return AInterceptorHandler.END;
    }

    /* renamed from: a */
    private Object m16554a(C5152c c5152c, C5148j c5148j, C5146i c5146i) {
        m16555a(C4974a.m16566a().m16573a(c5148j.m17452d()), c5146i);
        return AInterceptorHandler.DEFAULT;
    }

    /* renamed from: a */
    private void m16555a(C4976a c4976a, C5146i c5146i) {
        if (c4976a.m16584d()) {
            int a = c4976a.m16577a();
            c5146i.m17437a(String.format(Locale.US, "百度语音试用服务%d天后到期，", new Object[]{Integer.valueOf(a)}));
        }
        if (c4976a.m16586f()) {
            c5146i.m17437a("百度语音试用服务已经到期，请及时更新授权，");
        }
        c5146i.m17435a();
    }
}
