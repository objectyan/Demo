package com.baidu.tts.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class AInterceptor implements IInterceptor {
    /* renamed from: a */
    protected List<String> f20647a = new ArrayList();

    /* renamed from: a */
    protected abstract Object mo3795a(Object obj, Method method, Object[] objArr);

    /* renamed from: a */
    protected abstract void mo3796a();

    public AInterceptor() {
        mo3796a();
    }

    public Object before(Object proxied, Method method, Object[] args) {
        return m16543a(method.getName()) ? mo3795a(proxied, method, args) : AInterceptorHandler.DEFAULT;
    }

    public Object after(Object proxied, Method method, Object[] args, Object methodReturn) {
        return AInterceptorHandler.DEFAULT;
    }

    /* renamed from: a */
    private boolean m16543a(String str) {
        return this.f20647a.contains(str);
    }
}
