package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AProxyFactory;
import com.baidu.tts.aop.IInterceptor;
import com.baidu.tts.aop.IInterceptorHandler;
import com.baidu.tts.o.a.c;
import java.util.ArrayList;
import java.util.List;

public class TtsFactory
  extends AProxyFactory<ITts>
{
  public IInterceptorHandler createInterceptorHandler()
  {
    TtsInterceptorHandler localTtsInterceptorHandler = new TtsInterceptorHandler();
    localTtsInterceptorHandler.registerMethods();
    return localTtsInterceptorHandler;
  }
  
  public List<IInterceptor> createInterceptors()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ArgsCheckInterceptor());
    localArrayList.add(new StatisticsInterceptor());
    localArrayList.add(new OfflineAuthNotificationInterceptor());
    localArrayList.add(new CallbackInterceptor());
    return localArrayList;
  }
  
  public ITts createProxied()
  {
    return new c();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/tts/TtsFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */