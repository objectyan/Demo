package com.baidu.carlife.logic.a;

import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.b.a;
import com.baidu.carlife.radio.b.l.a;
import com.baidu.carlife.radio.b.p;
import com.baidu.carlife.radio.b.t;

public class f
  extends k
{
  private static final String a = "0";
  private static final String b = "1";
  private static final String c = "2";
  private static final String d = "3";
  private a e = new p();
  private a f = new t();
  private boolean g = true;
  
  public static f a()
  {
    return a.a();
  }
  
  public MusicSongModel a(boolean paramBoolean, com.baidu.carlife.logic.music.r paramr)
  {
    a locala = this.e;
    l.a locala1 = l.a.a().b(String.valueOf(3));
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      locala.a(locala1.c(str).a(com.baidu.carlife.radio.b.k.a(paramr)).c());
      return null;
    }
  }
  
  public void a(com.baidu.carlife.logic.music.r paramr)
  {
    this.e.a(l.a.a().b(String.valueOf(3)).c("3").a(com.baidu.carlife.radio.b.k.a(paramr)).c());
  }
  
  public void a(com.baidu.carlife.logic.music.r paramr, String paramString)
  {
    String str = "1";
    if (this.g)
    {
      this.g = false;
      str = "0";
    }
    this.e.a(l.a.a().c(str).b(paramString).a(com.baidu.carlife.radio.b.r.a(paramr)).c());
  }
  
  public a b()
  {
    return this.e;
  }
  
  public a c()
  {
    return this.f;
  }
  
  private static final class a
  {
    private static final f a = new f(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */