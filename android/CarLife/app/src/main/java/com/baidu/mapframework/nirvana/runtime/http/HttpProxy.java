package com.baidu.mapframework.nirvana.runtime.http;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpProxy
{
  private Map<Class<?>, Object> a = new ConcurrentHashMap();
  
  private <T> T a(Class<T> paramClass)
  {
    String str1 = paramClass.getName();
    String str2 = paramClass.getSimpleName();
    str1 = str1.replace("." + str2, ".generate." + str2 + "Impl");
    try
    {
      paramClass = paramClass.getClassLoader().loadClass(str1).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return paramClass;
    }
    catch (ClassNotFoundException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static HttpProxy getDefault()
  {
    return Holder.a;
  }
  
  public <T> T create(final Class<T> paramClass)
  {
    try
    {
      ClassLoader localClassLoader = paramClass.getClassLoader();
      InvocationHandler local1 = new InvocationHandler()
      {
        public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object... paramAnonymousVarArgs)
          throws Throwable
        {
          Object localObject = HttpProxy.a(HttpProxy.this).get(paramClass);
          paramAnonymousObject = localObject;
          if (localObject == null)
          {
            localObject = HttpProxy.a(HttpProxy.this, paramClass);
            paramAnonymousObject = localObject;
            if (localObject != null)
            {
              HttpProxy.a(HttpProxy.this).put(paramClass, localObject);
              paramAnonymousObject = localObject;
            }
          }
          if (paramAnonymousObject != null) {
            return paramAnonymousMethod.invoke(paramAnonymousObject, paramAnonymousVarArgs);
          }
          return null;
        }
      };
      paramClass = Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, local1);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  static class Holder
  {
    static HttpProxy a = new HttpProxy();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/runtime/http/HttpProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */