package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.aop.AInterceptorHandler;

public class TtsListenerInterceptorHandler
  extends AInterceptorHandler
{
  public void registerMethods()
  {
    registerMethod("onSynthesizeDataArrived");
    registerMethod("onPlayProgressUpdate");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/ttslistener/TtsListenerInterceptorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */