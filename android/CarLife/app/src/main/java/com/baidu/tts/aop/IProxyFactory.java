package com.baidu.tts.aop;

import java.util.List;

public interface IProxyFactory<T> {
    IInterceptorHandler createInterceptorHandler();

    List<IInterceptor> createInterceptors();

    T createProxied();

    T makeProxy();
}
