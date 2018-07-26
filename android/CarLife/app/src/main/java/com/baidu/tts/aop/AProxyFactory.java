package com.baidu.tts.aop;

import java.util.List;

public abstract class AProxyFactory<T> implements IProxyFactory<T> {
    public T makeProxy() {
        T createProxied = createProxied();
        IInterceptorHandler createInterceptorHandler = createInterceptorHandler();
        List createInterceptors = createInterceptors();
        if (createInterceptorHandler == null || createInterceptors == null) {
            return createProxied;
        }
        return createInterceptorHandler.bind(createProxied, createInterceptors);
    }
}
