package com.baidu.speech;

public abstract interface EventManager
{
  public abstract void registerListener(EventListener paramEventListener);
  
  public abstract void send(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void unregisterListener(EventListener paramEventListener);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/EventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */