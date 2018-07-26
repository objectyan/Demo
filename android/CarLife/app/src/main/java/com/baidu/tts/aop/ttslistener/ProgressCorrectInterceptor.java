package com.baidu.tts.aop.ttslistener;

import android.text.TextUtils;
import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p225m.C5145h;
import java.lang.reflect.Method;

public class ProgressCorrectInterceptor extends AInterceptor {
    /* renamed from: a */
    protected void mo3796a() {
        this.a.add("onSynthesizeDataArrived");
        this.a.add("onPlayProgressUpdate");
    }

    /* renamed from: a */
    protected Object mo3795a(Object obj, Method method, Object[] objArr) {
        C5145h c5145h = (C5145h) objArr[0];
        if (c5145h != null) {
            Object b = c5145h.m17431e().m17438b();
            if (!TextUtils.isEmpty(b)) {
                int i;
                int length = b.length();
                int c = c5145h.m17427c();
                if (c > length) {
                    i = c - length;
                } else {
                    i = 0;
                }
                LoggerProxy.m17001d("ProgressCorrectInterceptor", "prefixLength=" + length + "--progress=" + c);
                c5145h = (C5145h) c5145h.m16770B();
                c5145h.m17429d(i);
                objArr[0] = c5145h;
            }
        }
        return AInterceptorHandler.DEFAULT;
    }
}
