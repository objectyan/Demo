package com.baidu.carlife.logic.music;

import android.content.Context;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.w;
import com.baidu.che.codriver.c.a;
import com.baidu.che.codriver.sdk.a.f.a;
import com.baidu.che.codriver.sdk.a.f.a.a;
import com.baidu.che.codriver.sdk.a.j.a;
import com.baidu.che.codriver.util.c;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class k
  implements f.a, j.a
{
  public static void a(ArrayList<MusicSongModel> paramArrayList, ArrayList<a> paramArrayList1)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 1) || (paramArrayList1 == null)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      paramArrayList1.clear();
      while (paramArrayList.hasNext())
      {
        MusicSongModel localMusicSongModel = (MusicSongModel)paramArrayList.next();
        a locala = new a();
        locala.e = localMusicSongModel.b;
        locala.f = localMusicSongModel.c;
        locala.i = localMusicSongModel.f;
        paramArrayList1.add(locala);
      }
    }
  }
  
  private void h()
  {
    com.baidu.carlife.core.screen.presentation.h localh = com.baidu.carlife.core.screen.presentation.h.a();
    if (localh.d() != 4004) {
      com.baidu.carlife.core.k.b(4004);
    }
    if (h.b().r().v() == 0) {
      localh.showFragment(737, null);
    }
  }
  
  public void a(int paramInt)
  {
    h.b().e(paramInt);
    StatisticManager.onEvent("VOICE_0006");
    if (paramInt == 0) {
      StatisticManager.onEvent("VOICE_LINK_0003");
    }
    while (paramInt != 1) {
      return;
    }
    StatisticManager.onEvent("VOICE_LINK_0004");
  }
  
  public void a(a parama, int paramInt)
  {
    h.b().k(paramInt);
    StatisticManager.onEvent("VOICE_0006");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, f.a.a parama)
  {
    h.b().a(paramString1, paramString2, parama);
    StatisticManager.onEvent("VOICE_0006");
  }
  
  public void a(List<a> paramList, int paramInt)
  {
    a((a)paramList.get(paramInt), paramInt);
  }
  
  public boolean a()
  {
    return h.b().p();
  }
  
  public void b()
  {
    if (h.b().q())
    {
      h.b().x();
      return;
    }
    if (h.b().z()) {
      h();
    }
    for (;;)
    {
      StatisticManager.onEvent("VOICE_0006");
      return;
      h.b().a(null, null);
    }
  }
  
  public void c()
  {
    if ((!h.b().q()) && (h.b().z())) {
      h();
    }
    for (;;)
    {
      StatisticManager.onEvent("VOICE_0006");
      return;
      h.b().f(true);
    }
  }
  
  public void d()
  {
    if ((!h.b().q()) && (h.b().z())) {
      h();
    }
    for (;;)
    {
      StatisticManager.onEvent("VOICE_0006");
      return;
      h.b().f(true);
    }
  }
  
  public void e()
  {
    h.b().b(false);
    StatisticManager.onEvent("VOICE_0006");
  }
  
  public void f()
  {
    h.b().b(true);
    StatisticManager.onEvent("VOICE_0006");
  }
  
  public void g()
  {
    if (h.b().n() == -1)
    {
      w.a(c.a().getString(2131296611));
      return;
    }
    f();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */