package com.baidu.carlife.logic.a;

import com.baidu.carlife.logic.music.r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.b.a;
import com.baidu.carlife.radio.b.f;
import java.util.List;

public class e
  extends k
{
  private a a = new com.baidu.carlife.radio.b.e();
  private a b = new f();
  
  public static e a()
  {
    return new e();
  }
  
  public MusicSongModel a(boolean paramBoolean, r paramr)
  {
    List localList = paramr.g();
    if ((localList == null) || (localList.isEmpty())) {
      return null;
    }
    int j = paramr.m();
    int i = 0;
    if (localList.size() > 0) {
      i = (j + 1) % localList.size();
    }
    if (paramBoolean) {}
    for (;;)
    {
      paramr.f(i);
      return (MusicSongModel)localList.get(i);
      if (j == 0) {
        i = localList.size() - 1;
      } else {
        i = j - 1;
      }
    }
  }
  
  public a b()
  {
    return this.b;
  }
  
  public a c()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */