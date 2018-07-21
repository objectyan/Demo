package com.baidu.carlife.logic.a;

import com.baidu.carlife.logic.i;
import com.baidu.carlife.logic.music.r;
import com.baidu.carlife.model.MusicSongModel;

public class j
{
  private k a = k.d();
  private r b;
  private int c = 1;
  private com.baidu.carlife.logic.e d = (com.baidu.carlife.logic.e)d.b().a(com.baidu.carlife.logic.j.class.getName());
  
  private j()
  {
    a(this.d);
  }
  
  public static j a()
  {
    return a.a();
  }
  
  private void a(com.baidu.carlife.logic.e parame)
  {
    if ((parame == null) || (parame.isAlive())) {
      return;
    }
    parame.start();
  }
  
  public MusicSongModel a(boolean paramBoolean)
  {
    return f().a(paramBoolean, c());
  }
  
  public void a(int paramInt)
  {
    if (this.c == paramInt) {
      return;
    }
    this.c = paramInt;
    switch (paramInt)
    {
    default: 
      this.a = k.d();
      this.d = ((com.baidu.carlife.logic.e)d.b().a(com.baidu.carlife.logic.j.class.getName()));
    }
    for (;;)
    {
      a(this.d);
      return;
      this.a = k.f();
      this.d = ((com.baidu.carlife.logic.e)d.b().a(i.class.getName()));
      continue;
      this.a = k.e();
      this.d = ((com.baidu.carlife.logic.e)d.b().a(com.baidu.carlife.logic.j.class.getName()));
      continue;
      this.a = k.g();
      this.d = ((com.baidu.carlife.logic.e)d.b().a(com.baidu.carlife.logic.j.class.getName()));
    }
  }
  
  public void a(r paramr)
  {
    this.b = paramr;
  }
  
  public void a(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      this.c = 10;
      a(this.d);
      return;
      if (!paramString.equals("radio")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("sound_program")) {
        break;
      }
      i = 1;
      break;
      this.a = k.f();
      this.d = ((com.baidu.carlife.logic.e)d.b().a(i.class.getName()));
      continue;
      this.a = k.d();
      this.d = ((com.baidu.carlife.logic.e)d.b().a(com.baidu.carlife.logic.j.class.getName()));
    }
  }
  
  public int b()
  {
    return this.c;
  }
  
  public r c()
  {
    return this.b;
  }
  
  public com.baidu.carlife.logic.e d()
  {
    return this.d;
  }
  
  public void e()
  {
    f().a(c());
  }
  
  public k f()
  {
    return this.a;
  }
  
  public boolean g()
  {
    if (this.a == null) {
      return false;
    }
    return this.a instanceof e;
  }
  
  private static class a
  {
    private static final j a = new j(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */