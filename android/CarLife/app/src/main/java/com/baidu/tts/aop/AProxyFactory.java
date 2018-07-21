package com.baidu.tts.aop;

import java.util.List;

public abstract class AProxyFactory<T>
  implements IProxyFactory<T>
{
  public T makeProxy()
  {
    Object localObject2 = createProxied();
    IInterceptorHandler localIInterceptorHandler = createInterceptorHandler();
    List localList = createInterceptors();
    Object localObject1 = localObject2;
    if (localIInterceptorHandler != null)
    {
      localObject1 = localObject2;
      if (localList != null) {
        localObject1 = localIInterceptorHandler.bind(localObject2, localList);
      }
    }
    return (T)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/AProxyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */