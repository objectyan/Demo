package com.baidu.tts.client;

import com.baidu.tts.f.n;
import com.baidu.tts.tools.ResourceTools;

public class SpeechSynthesizeBag
{
  private String a;
  private String b;
  
  public String getText()
  {
    return this.a;
  }
  
  public String getUtteranceId()
  {
    return this.b;
  }
  
  public int setText(String paramString)
  {
    n localn = ResourceTools.isTextValid(paramString);
    if (localn == null)
    {
      this.a = paramString;
      return 0;
    }
    return localn.b();
  }
  
  public void setUtteranceId(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/SpeechSynthesizeBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */