package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import com.baidu.tts.p243o.p244a.C5152c;
import com.baidu.tts.tools.ResourceTools;
import java.lang.reflect.Method;

public class ArgsCheckInterceptor extends AInterceptor {
    /* renamed from: a */
    protected void mo3796a() {
        this.a.add("speak");
        this.a.add("synthesize");
    }

    /* renamed from: a */
    protected Object mo3795a(Object obj, Method method, Object[] objArr) {
        C5146i c5146i = (C5146i) objArr[0];
        String c = c5146i.m17440c();
        LoggerProxy.m17001d("ArgsCheckInterceptor", "text=" + c);
        if (ResourceTools.isTextValid(c) == null) {
            return AInterceptorHandler.DEFAULT;
        }
        return m16548a(obj, c5146i, C5097n.TEXT_IS_TOO_LONG);
    }

    /* renamed from: a */
    private Object m16548a(Object obj, C5146i c5146i, C5097n c5097n) {
        C5145h b = C5145h.m17416b(c5146i);
        b.m17419a(C5105c.m17295a().m17302b(c5097n));
        m16549a(obj, b);
        return AInterceptorHandler.END;
    }

    /* renamed from: a */
    private void m16549a(Object obj, C5145h c5145h) {
        TtsListener ttsListener = ((C5152c) obj).getTtsListener();
        if (ttsListener != null) {
            ttsListener.onError(c5145h);
        }
    }
}
