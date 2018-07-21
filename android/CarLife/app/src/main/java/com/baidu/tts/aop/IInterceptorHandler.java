package com.baidu.tts.aop;

import java.lang.reflect.InvocationHandler;
import java.util.List;

public abstract interface IInterceptorHandler
  extends InvocationHandler
{
  public abstract Object bind(Object paramObject, List<IInterceptor> paramList);
  
  public abstract boolean canIntercept(String paramString);
  
  public abstract void registerMethod(String paramString);
  
  public abstract void registerMethods();
  
  public abstract void unregisterMethod(String paramString);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/IInterceptorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */