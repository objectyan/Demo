package com.baidu.carlife.logic.a;

import com.baidu.carlife.logic.music.r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.b.t;
import com.baidu.carlife.radio.c.b;
import java.util.List;

public class l
  extends k
{
  private com.baidu.carlife.radio.b.a a = new t();
  private com.baidu.carlife.radio.b.a b = new com.baidu.carlife.radio.b.w();
  
  public static l a()
  {
    return new l();
  }
  
  private boolean b(r paramr)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (b.a().a(paramr.n()))
    {
      paramr = paramr.C();
      bool1 = bool2;
      if (paramr != null) {
        if (!paramr.contains("\"type\":\"新闻\""))
        {
          bool1 = bool2;
          if (!paramr.contains("\"type\":\"\\u65b0\\u95fb\"")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public MusicSongModel a(boolean paramBoolean, r paramr)
  {
    List localList = paramr.g();
    if ((localList == null) || (localList.isEmpty())) {
      return null;
    }
    int i = paramr.m();
    int j;
    if (paramBoolean)
    {
      j = i + 1;
      i = j;
      if (j >= localList.size())
      {
        if (b(paramr))
        {
          paramr.k("下一首");
          return null;
        }
        paramr.a(0, paramr.n());
        return null;
      }
    }
    else
    {
      j = i - 1;
      i = j;
      if (j < 0)
      {
        if (b(paramr))
        {
          paramr.k("上一首");
          return null;
        }
        com.baidu.carlife.util.w.a(com.baidu.carlife.core.a.a().getString(2131296603), 1);
        return null;
      }
    }
    paramr.f(i);
    return (MusicSongModel)localList.get(i);
  }
  
  public com.baidu.carlife.radio.b.a b()
  {
    return this.b;
  }
  
  public com.baidu.carlife.radio.b.a c()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */