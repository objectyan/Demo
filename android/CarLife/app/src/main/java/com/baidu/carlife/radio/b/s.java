package com.baidu.carlife.radio.b;

import com.baidu.carlife.logic.music.h;
import com.baidu.carlife.logic.music.r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.w;
import java.lang.ref.WeakReference;
import java.util.List;

public class s
  implements u
{
  private WeakReference<r> a;
  
  private s(r paramr)
  {
    this.a = new WeakReference(paramr);
  }
  
  public static u a(r paramr)
  {
    return new s(paramr);
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
    r localr = (r)this.a.get();
    if ((localr != null) && (paramList != null) && (paramList.size() > 0)) {
      localr.a((MusicSongModel)paramList.get(0), paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */