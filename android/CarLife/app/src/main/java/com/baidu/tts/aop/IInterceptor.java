package com.baidu.tts.aop;

import java.lang.reflect.Method;

public abstract interface IInterceptor
{
  public abstract Object after(Object paramObject1, Method paramMethod, Object[] paramArrayOfObject, Object paramObject2);
  
  public abstract Object before(Object paramObject, Method paramMethod, Object[] paramArrayOfObject);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/IInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */