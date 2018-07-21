package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.m.h;

public abstract interface TtsListener
{
  public abstract void onError(h paramh);
  
  public abstract void onPlayFinished(h paramh);
  
  public abstract void onPlayProgressUpdate(h paramh);
  
  public abstract void onPlayStart(h paramh);
  
  public abstract void onSynthesizeDataArrived(h paramh);
  
  public abstract void onSynthesizeFinished(h paramh);
  
  public abstract void onSynthesizeStart(h paramh);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/ttslistener/TtsListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */