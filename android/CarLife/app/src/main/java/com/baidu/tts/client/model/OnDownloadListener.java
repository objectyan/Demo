package com.baidu.tts.client.model;

public abstract interface OnDownloadListener
{
  public abstract void onFinish(String paramString, int paramInt);
  
  public abstract void onProgress(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onStart(String paramString);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/OnDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */