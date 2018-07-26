package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.aop.AProxyFactory;
import com.baidu.tts.aop.IInterceptor;
import com.baidu.tts.aop.IInterceptorHandler;
import java.util.ArrayList;
import java.util.List;

public class TtsListenerFactory extends AProxyFactory<TtsListener> {
    /* renamed from: a */
    private TtsListener f20657a;

    public TtsListenerFactory(TtsListener ttsListener) {
        this.f20657a = ttsListener;
    }

    public TtsListener createProxied() {
        return this.f20657a;
    }

    public IInterceptorHandler createInterceptorHandler() {
        IInterceptorHandler ttsListenerInterceptorHandler = new TtsListenerInterceptorHandler();
        ttsListenerInterceptorHandler.registerMethods();
        return ttsListenerInterceptorHandler;
    }

    public List<IInterceptor> createInterceptors() {
        List<IInterceptor> arrayList = new ArrayList();
        arrayList.add(new ProgressCorrectInterceptor());
        return arrayList;
    }
}
