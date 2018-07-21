package com.baidu.carlife.logic.voice;

import com.baidu.carlife.core.i;

public class m
{
  public static m a()
  {
    return a.a;
  }
  
  private void c()
  {
    n.a().j();
    n.a().a(4100);
  }
  
  private void d()
  {
    n.a().j();
    n.a().a(4100);
  }
  
  public void b()
  {
    if (n.a().m())
    {
      n.a().j();
      i.b("VoiceStateSwitcher", "stopTTSAndCloseVr");
    }
    do
    {
      return;
      if (n.a().c())
      {
        d();
        i.b("VoiceStateSwitcher", "abortListening");
        return;
      }
    } while (!n.a().b());
    c();
    i.b("VoiceStateSwitcher", "abortProcessing");
  }
  
  private static class a
  {
    static final m a = new m(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/voice/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */