package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.aop.AProxyFactory;
import com.baidu.tts.aop.IInterceptor;
import com.baidu.tts.aop.IInterceptorHandler;
import java.util.ArrayList;
import java.util.List;

public class TtsListenerFactory
  extends AProxyFactory<TtsListener>
{
  private TtsListener a;
  
  public TtsListenerFactory(TtsListener paramTtsListener)
  {
    this.a = paramTtsListener;
  }
  
  public IInterceptorHandler createInterceptorHandler()
  {
    TtsListenerInterceptorHandler localTtsListenerInterceptorHandler = new TtsListenerInterceptorHandler();
    localTtsListenerInterceptorHandler.registerMethods();
    return localTtsListenerInterceptorHandler;
  }
  
  public List<IInterceptor> createInterceptors()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ProgressCorrectInterceptor());
    return localArrayList;
  }
  
  public TtsListener createProxied()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/ttslistener/TtsListenerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */