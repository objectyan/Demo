package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

public abstract interface XDVoiceCallback
{
  public abstract void cancelAsr();
  
  public abstract void closePanel();
  
  public abstract void showPanel();
  
  public abstract void startAsr();
  
  public abstract void voiceEnable(int paramInt1, int paramInt2);
  
  public abstract void voiceRestore();
  
  public abstract boolean xdIsWakeEnable();
  
  public abstract boolean xdIsWakeUpOn();
  
  public abstract void xdWakeEnable(boolean paramBoolean);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/asr/xdvoice/XDVoiceCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */