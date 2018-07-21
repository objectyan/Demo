package com.baidu.tts.aop.tts;

import android.content.Context;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.f.m;
import com.baidu.tts.j.b;
import com.baidu.tts.m.e;
import com.baidu.tts.m.f;
import com.baidu.tts.m.i;
import com.baidu.tts.m.j;

public abstract interface ITts
  extends b
{
  public abstract AuthInfo auth(m paramm);
  
  public abstract int freeCustomResource(e parame);
  
  public abstract m getMode();
  
  public abstract TtsListener getTtsListener();
  
  public abstract j getTtsParams();
  
  public abstract int loadCustomResource(e parame);
  
  public abstract int loadEnglishModel(f paramf);
  
  public abstract int loadModel(com.baidu.tts.m.g paramg);
  
  public abstract int setAudioStreamType(int paramInt);
  
  public abstract void setContext(Context paramContext);
  
  public abstract void setMode(m paramm);
  
  public abstract int setParam(com.baidu.tts.f.g paramg, String paramString);
  
  public abstract int setStereoVolume(float paramFloat1, float paramFloat2);
  
  public abstract void setTtsListener(TtsListener paramTtsListener);
  
  public abstract void speak(i parami);
  
  public abstract void synthesize(i parami);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/tts/ITts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */