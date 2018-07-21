package com.baidu.carlife.logic.a;

import com.baidu.carlife.core.l;
import com.baidu.carlife.logic.e;
import com.baidu.carlife.logic.music.h;

public class m
{
  public static m a()
  {
    return a.a();
  }
  
  private boolean c()
  {
    return (!h.b().v()) && (j.a().g());
  }
  
  public void b()
  {
    l.a().postDelayed(new Runnable()
    {
      public void run()
      {
        if (m.a(m.this))
        {
          j.a().d().a();
          h.b().A();
          h.b().f(true);
        }
      }
    }, 5000L);
  }
  
  private static class a
  {
    private static final m a = new m(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */