package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.auth.a;
import com.baidu.tts.auth.b.a;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.m.i;
import com.baidu.tts.m.j;
import com.baidu.tts.o.a.c;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class OfflineAuthNotificationInterceptor
  extends AInterceptor
{
  private AtomicInteger b = new AtomicInteger(-1);
  
  private Object a(c paramc, j paramj, i parami)
  {
    a(a.a().a(paramj.d()), parami);
    return AInterceptorHandler.DEFAULT;
  }
  
  private void a(b.a parama, i parami)
  {
    if (parama.d())
    {
      int i = parama.a();
      parami.a(String.format(Locale.US, "百度语音试用服务%d天后到期，", new Object[] { Integer.valueOf(i) }));
    }
    if (parama.f()) {
      parami.a("百度语音试用服务已经到期，请及时更新授权，");
    }
    parami.a();
  }
  
  protected Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = (c)paramObject;
    if (((c)paramObject).q())
    {
      paramMethod = ((c)paramObject).getMode();
      if (paramMethod == null)
      {
        ((c)paramObject).p();
        return AInterceptorHandler.END;
      }
      switch (1.a[paramMethod.ordinal()])
      {
      }
      int i;
      do
      {
        return AInterceptorHandler.DEFAULT;
        i = this.b.incrementAndGet();
        LoggerProxy.d("OfflineAuthNotificationInterceptor", "currentCount=" + i);
      } while (i % 20 != 0);
      paramMethod = (i)paramArrayOfObject[0];
      paramArrayOfObject = ((c)paramObject).getTtsParams();
      if (paramArrayOfObject != null) {
        return a((c)paramObject, paramArrayOfObject, paramMethod);
      }
      ((c)paramObject).p();
      return AInterceptorHandler.END;
    }
    ((c)paramObject).p();
    return AInterceptorHandler.END;
  }
  
  protected void a()
  {
    this.a.add("speak");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/tts/OfflineAuthNotificationInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */