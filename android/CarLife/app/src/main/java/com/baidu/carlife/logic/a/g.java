package com.baidu.carlife.logic.a;

import com.baidu.carlife.logic.music.r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.b.l.a;
import com.baidu.carlife.radio.b.s;
import com.baidu.carlife.radio.b.t;
import com.baidu.carlife.radio.b.x;
import com.baidu.carlife.radio.b.y;
import com.baidu.carlife.util.w;
import java.util.List;

public class g
  extends k
{
  private com.baidu.carlife.radio.b.a a = new t();
  private com.baidu.carlife.radio.b.a b = new y();
  private com.baidu.carlife.radio.b.a c = new x();
  
  public static g a()
  {
    return new g();
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
        w.a(com.baidu.carlife.core.a.a().getString(2131296603), 1);
        return null;
      }
    }
    paramr.f(i);
    return (MusicSongModel)localList.get(i);
  }
  
  public void a(r paramr, String paramString1, String paramString2)
  {
    this.c.a(l.a.a().b(paramString1).a(paramString2).a(s.a(paramr)).c());
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */