package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.n;
import com.baidu.tts.m.h;
import com.baidu.tts.m.i;
import com.baidu.tts.tools.ResourceTools;
import java.lang.reflect.Method;
import java.util.List;

public class ArgsCheckInterceptor
  extends AInterceptor
{
  private Object a(Object paramObject, i parami, n paramn)
  {
    parami = h.b(parami);
    parami.a(com.baidu.tts.h.a.c.a().b(paramn));
    a(paramObject, parami);
    return AInterceptorHandler.END;
  }
  
  private void a(Object paramObject, h paramh)
  {
    paramObject = ((com.baidu.tts.o.a.c)paramObject).getTtsListener();
    if (paramObject != null) {
      ((TtsListener)paramObject).onError(paramh);
    }
  }
  
  protected Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramMethod = (i)paramArrayOfObject[0];
    paramArrayOfObject = paramMethod.c();
    LoggerProxy.d("ArgsCheckInterceptor", "text=" + paramArrayOfObject);
    if (ResourceTools.isTextValid(paramArrayOfObject) == null) {
      return AInterceptorHandler.DEFAULT;
    }
    return a(paramObject, paramMethod, n.Q);
  }
  
  protected void a()
  {
    this.a.add("speak");
    this.a.add("synthesize");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/tts/ArgsCheckInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */