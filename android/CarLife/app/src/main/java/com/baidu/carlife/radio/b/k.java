package com.baidu.carlife.radio.b;

import com.baidu.carlife.logic.music.h;
import com.baidu.carlife.logic.music.r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.w;
import java.lang.ref.WeakReference;
import java.util.List;

public class k
  implements u
{
  private WeakReference<r> a;
  
  private k(r paramr)
  {
    this.a = new WeakReference(paramr);
  }
  
  public static k a(r paramr)
  {
    return new k(paramr);
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
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramString = (r)this.a.get();
    if (paramString != null) {
      paramString.b((MusicSongModel)paramList.get(0));
    }
    h.b().e((MusicSongModel)paramList.get(0));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */