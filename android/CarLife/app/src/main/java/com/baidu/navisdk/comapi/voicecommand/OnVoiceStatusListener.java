package com.baidu.navisdk.comapi.voicecommand;

public abstract interface OnVoiceStatusListener
{
  public static final int Status_Listening = 1;
  public static final int Status_NotUnderstand = 3;
  public static final int Status_Speaking = 2;
  public static final int Status_Waiting = 0;
  
  public abstract void onVoiceStatusChanged(int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/voicecommand/OnVoiceStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */