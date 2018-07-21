package com.baidu.carlife.radio.b;

import com.baidu.carlife.logic.music.h;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.w;
import java.lang.ref.WeakReference;
import java.util.List;

public class r
  implements u
{
  private WeakReference<com.baidu.carlife.logic.music.r> a;
  
  private r(com.baidu.carlife.logic.music.r paramr)
  {
    this.a = new WeakReference(paramr);
  }
  
  public static u a(com.baidu.carlife.logic.music.r paramr)
  {
    return new r(paramr);
  }
  
  public void a(String paramString)
  {
    if (h.b().q())
    {
      h.b().f(true);
      w.a("节目加载失败，请稍后重试");
    }
  }
  
  public void a(String paramString, List<MusicSongModel> paramList)
  {
    com.baidu.carlife.logic.music.r localr = (com.baidu.carlife.logic.music.r)this.a.get();
    if (localr != null) {
      localr.a(paramList, paramString, 0, 0, 0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */