package com.baidu.carlife.logic.b.e;

import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.carlife.c.d.c;
import com.baidu.carlife.c.d.f;
import com.baidu.carlife.core.e;

public class a
  extends f
{
  private c<Boolean> a = new c();
  private c<Boolean> b = new c();
  
  public a()
  {
    this.a.b(Boolean.valueOf(e.a().o()));
    this.b.b(Boolean.valueOf(BaseTTSPlayer.getInstance().getLastTTSVoiceDataPath().contains("bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat")));
  }
  
  public c<Boolean> a()
  {
    return this.b;
  }
  
  public void b()
  {
    super.b();
    this.a.a();
    this.b.a();
    this.a = null;
    this.b = null;
  }
  
  public c<Boolean> c()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/b/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */