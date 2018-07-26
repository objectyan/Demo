package com.baidu.tts.aop;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public abstract class AInterceptorHandler implements IInterceptorHandler {
    public static final Object DEFAULT = Integer.valueOf(0);
    public static final Object END = Integer.valueOf(1);
    /* renamed from: a */
    protected List<IInterceptor> f20648a;
    /* renamed from: b */
    protected Object f20649b;
    /* renamed from: c */
    protected List<String> f20650c = new ArrayList();

    public Object bind(Object proxied, List<IInterceptor> interceptors) {
        this.f20649b = proxied;
        this.f20648a = interceptors;
        Class cls = this.f20649b.getClass();
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
        LoggerProxy.m17001d("AInterceptorHandler", "proxy=" + newProxyInstance);
        return newProxyInstance;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!canIntercept(method.getName())) {
            return method.invoke(this.f20649b, args);
        }
        if (m16546a(this.f20649b, method, args).equals(END)) {
            return null;
        }
        Object invoke = method.invoke(this.f20649b, args);
        LoggerProxy.m17001d("AInterceptorHandler", "afterResult=" + m16547a(this.f20649b, method, args, invoke));
        return invoke;
    }

    public void registerMethod(String methodName) {
        if (methodName != null) {
            this.f20650c.add(methodName);
        }
    }

    public void unregisterMethod(String methodName) {
        if (methodName != null) {
            this.f20650c.remove(methodName);
        }
    }

    public boolean canIntercept(String methodName) {
        return this.f20650c.contains(methodName);
    }

    /* renamed from: a */
    protected Object m16546a(Object obj, Method method, Object[] objArr) {
        Object obj2 = DEFAULT;
        int size = this.f20648a.size();
        Object obj3 = obj2;
        for (int i = 0; i < size; i++) {
            obj3 = ((IInterceptor) this.f20648a.get(i)).before(obj, method, objArr);
            if (obj3.equals(END)) {
                break;
            }
        }
        return obj3;
    }

    /* renamed from: a */
    protected Object m16547a(Object obj, Method method, Object[] objArr, Object obj2) {
        Object obj3 = DEFAULT;
        int size = this.f20648a.size() - 1;
        while (size >= 0) {
            Object after = ((IInterceptor) this.f20648a.get(size)).after(obj, method, objArr, obj2);
            size--;
            obj3 = after;
        }
        return obj3;
    }
}
