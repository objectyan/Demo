package com.baidu.carlife.logic.a;

import com.baidu.carlife.model.MusicSongModel;

public class c
{
  private static final String a = "600000";
  private static final int b = 2;
  
  public static c a()
  {
    return a.a();
  }
  
  private boolean c(MusicSongModel paramMusicSongModel)
  {
    return (paramMusicSongModel == null) || (a(paramMusicSongModel.a())) || (a(paramMusicSongModel.l())) || (paramMusicSongModel.p() < 0);
  }
  
  public MusicSongModel a(MusicSongModel paramMusicSongModel)
  {
    MusicSongModel localMusicSongModel;
    if (c(paramMusicSongModel)) {
      localMusicSongModel = null;
    }
    do
    {
      return localMusicSongModel;
      if (paramMusicSongModel.r() < 0) {
        paramMusicSongModel.b(2);
      }
      localMusicSongModel = paramMusicSongModel;
    } while (!a(paramMusicSongModel.h()));
    paramMusicSongModel.h("600000");
    return paramMusicSongModel;
  }
  
  public boolean a(String paramString)
  {
    return (paramString == null) || (paramString.isEmpty());
  }
  
  public MusicSongModel b(MusicSongModel paramMusicSongModel)
  {
    MusicSongModel localMusicSongModel;
    if (paramMusicSongModel == null) {
      localMusicSongModel = null;
    }
    do
    {
      return localMusicSongModel;
      if (a(paramMusicSongModel.a())) {
        break;
      }
      localMusicSongModel = paramMusicSongModel;
    } while (!a(paramMusicSongModel.b()));
    return null;
  }
  
  private static class a
  {
    private static final c a = new c(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */