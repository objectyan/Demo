package com.baidu.che.codriver.h;

import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizerListener;

public abstract class b
  implements SpeechSynthesizerListener
{
  public com.baidu.che.codriver.ui.d.b b;
  
  public final void a(com.baidu.che.codriver.ui.d.b paramb)
  {
    this.b = paramb;
  }
  
  public void onError(String paramString, SpeechError paramSpeechError) {}
  
  public void onSpeechFinish(String paramString) {}
  
  public void onSpeechProgressChanged(String paramString, int paramInt) {}
  
  public void onSpeechStart(String paramString) {}
  
  public void onSynthesizeDataArrived(String paramString, byte[] paramArrayOfByte, int paramInt) {}
  
  public void onSynthesizeFinish(String paramString) {}
  
  public void onSynthesizeStart(String paramString) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */