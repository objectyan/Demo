package com.baidu.navisdk.ui.voice.model;

public class VoiceDataStatus
{
  public static int VOICE_DATA_DOWN_DOWNING = 1;
  public static int VOICE_DATA_DOWN_END = 2;
  public static int VOICE_DATA_DOWN_INVALID = -1;
  public static int VOICE_DATA_DOWN_UNSTART = 0;
  public int status;
  public long unDwonloadSize;
  public long unTotalSize;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/model/VoiceDataStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */