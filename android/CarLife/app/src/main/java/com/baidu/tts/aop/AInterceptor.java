package com.baidu.tts.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class AInterceptor
  implements IInterceptor
{
  protected List<String> a = new ArrayList();
  
  public AInterceptor()
  {
    a();
  }
  
  private boolean a(String paramString)
  {
    return this.a.contains(paramString);
  }
  
  protected abstract Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject);
  
  protected abstract void a();
  
  public Object after(Object paramObject1, Method paramMethod, Object[] paramArrayOfObject, Object paramObject2)
  {
    return AInterceptorHandler.DEFAULT;
  }
  
  public Object before(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (a(paramMethod.getName())) {
      return a(paramObject, paramMethod, paramArrayOfObject);
    }
    return AInterceptorHandler.DEFAULT;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/AInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */