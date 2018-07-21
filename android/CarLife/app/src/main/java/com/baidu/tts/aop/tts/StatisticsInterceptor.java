package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.lang.reflect.Method;
import java.util.List;

public class StatisticsInterceptor
  extends AInterceptor
{
  protected Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    LoggerProxy.d("StatisticsInterceptor", "statistics");
    return AInterceptorHandler.DEFAULT;
  }
  
  protected void a()
  {
    this.a.add("speak");
    this.a.add("synthesize");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/tts/StatisticsInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */