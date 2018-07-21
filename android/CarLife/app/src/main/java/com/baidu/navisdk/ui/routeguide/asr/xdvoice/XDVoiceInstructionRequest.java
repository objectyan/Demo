package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

public class XDVoiceInstructionRequest
{
  public String subAction;
  public int topType;
  
  public XDVoiceInstructionRequest(String paramString)
  {
    paseInstruction(paramString);
  }
  
  private void paseInstruction(String paramString)
  {
    if ("remaining_time".equals(paramString)) {
      this.topType = 4;
    }
    for (;;)
    {
      this.subAction = paramString;
      return;
      if ("remaining_distance".equals(paramString)) {
        this.topType = 4;
      } else if ("remaining_distance_and_time".equals(paramString)) {
        this.topType = 4;
      } else if ("traffic_info".equals(paramString)) {
        this.topType = 4;
      } else if ("exit_navigation".equals(paramString)) {
        this.topType = 6;
      } else if ("more_fast".equals(paramString)) {
        this.topType = 6;
      } else if ("avoid_congestion".equals(paramString)) {
        this.topType = 6;
      } else {
        this.topType = 0;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/asr/xdvoice/XDVoiceInstructionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */