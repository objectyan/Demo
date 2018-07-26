package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.lang.reflect.Method;

public class StatisticsInterceptor extends AInterceptor {
    /* renamed from: a */
    protected void mo3796a() {
        this.a.add("speak");
        this.a.add("synthesize");
    }

    /* renamed from: a */
    protected Object mo3795a(Object obj, Method method, Object[] objArr) {
        LoggerProxy.m17001d("StatisticsInterceptor", "statistics");
        return AInterceptorHandler.DEFAULT;
    }
}
