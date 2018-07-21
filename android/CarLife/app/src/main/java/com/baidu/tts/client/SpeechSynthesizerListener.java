package com.baidu.tts.client;

public abstract interface SpeechSynthesizerListener
{
  public abstract void onError(String paramString, SpeechError paramSpeechError);
  
  public abstract void onSpeechFinish(String paramString);
  
  public abstract void onSpeechProgressChanged(String paramString, int paramInt);
  
  public abstract void onSpeechStart(String paramString);
  
  public abstract void onSynthesizeDataArrived(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void onSynthesizeFinish(String paramString);
  
  public abstract void onSynthesizeStart(String paramString);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/SpeechSynthesizerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */