package com.baidu.mapframework.nirvana.runtime.http;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpProxy {
    /* renamed from: a */
    private Map<Class<?>, Object> f19235a = new ConcurrentHashMap();

    static class Holder {
        /* renamed from: a */
        static HttpProxy f19234a = new HttpProxy();

        Holder() {
        }
    }

    public static HttpProxy getDefault() {
        return Holder.f19234a;
    }

    public synchronized <T> T create(final Class<T> service) {
        return Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler(this) {
            /* renamed from: b */
            final /* synthetic */ HttpProxy f19233b;

            public Object invoke(Object proxy, Method method, Object... args) throws Throwable {
                T serviceImpl = this.f19233b.f19235a.get(service);
                if (serviceImpl == null) {
                    serviceImpl = this.f19233b.m15217a(service);
                    if (serviceImpl != null) {
                        this.f19233b.f19235a.put(service, serviceImpl);
                    }
                }
                if (serviceImpl != null) {
                    return method.invoke(serviceImpl, args);
                }
                return null;
            }
        });
    }

    /* renamed from: a */
    private <T> T m15217a(Class<T> service) {
        T t = null;
        String name = service.getName();
        String simpleName = service.getSimpleName();
        try {
            t = service.getClassLoader().loadClass(name.replace("." + simpleName, ".generate." + simpleName + "Impl")).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        return t;
    }
}
