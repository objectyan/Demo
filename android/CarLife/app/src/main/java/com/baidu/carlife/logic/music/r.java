package com.baidu.carlife.logic.music;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.core.i;
import com.baidu.carlife.logic.a.j;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.b.l.a;
import com.baidu.carlife.radio.b.u;
import com.baidu.carlife.util.p;
import com.baidu.carlife.util.w;
import com.baidu.che.codriver.sdk.a.n.a;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class r
  extends b
{
  private String T;
  private MusicSongModel U;
  
  public r(Context paramContext, int paramInt, String paramString)
  {
    this.C = paramContext;
    this.E = "CarLifeRadio";
    this.F = 101;
    this.I = new ArrayList();
    p.a().b("radio_voice_query", "");
    l("");
  }
  
  private void a(List<MusicSongModel> paramList1, List<MusicSongModel> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {}
    for (;;)
    {
      return;
      int m = paramList1.size();
      int i = paramList2.size();
      if ((m > 0) && (i > 0))
      {
        MusicSongModel localMusicSongModel1;
        MusicSongModel localMusicSongModel2;
        int j;
        if (m < i)
        {
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            localMusicSongModel1 = (MusicSongModel)paramList1.next();
            for (i = 0; i < paramList2.size(); i = j + 1)
            {
              localMusicSongModel2 = (MusicSongModel)paramList2.get(i);
              j = i;
              if (localMusicSongModel1.a.equals(localMusicSongModel2.a))
              {
                paramList2.remove(i);
                j = i - 1;
              }
            }
          }
        }
        else
        {
          j = m - i;
          while (j < m)
          {
            localMusicSongModel1 = (MusicSongModel)paramList1.get(j);
            int k;
            for (i = 0; i < paramList2.size(); i = k + 1)
            {
              localMusicSongModel2 = (MusicSongModel)paramList2.get(i);
              k = i;
              if (localMusicSongModel1.a.equals(localMusicSongModel2.a))
              {
                paramList2.remove(i);
                k = i - 1;
              }
            }
            j += 1;
          }
        }
      }
    }
  }
  
  private boolean m(String paramString)
  {
    return (paramString.equals(String.valueOf(1))) || (paramString.equals(String.valueOf(4)));
  }
  
  public void A()
  {
    this.F = 101;
    this.E = "CarLifeRadio";
  }
  
  public com.baidu.carlife.radio.b.a B()
  {
    return j.a().f().c();
  }
  
  public String C()
  {
    return this.T;
  }
  
  public int a(int paramInt, String paramString)
  {
    e(paramString);
    if (com.baidu.carlife.radio.c.b.a().a(paramString)) {
      b(C(), null);
    }
    for (;;)
    {
      return 0;
      j.a().f().a(this, paramString);
    }
  }
  
  public void a(MusicSongModel paramMusicSongModel, String paramString)
  {
    a(paramString, paramMusicSongModel);
    paramMusicSongModel = h(paramMusicSongModel.a);
    h.b().e(paramMusicSongModel);
  }
  
  public void a(String paramString, MusicSongModel paramMusicSongModel)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMusicSongModel == null)) {}
    for (;;)
    {
      return;
      if ((g(paramString)) && (f(paramString) != null))
      {
        paramString = f(paramString).iterator();
        while (paramString.hasNext())
        {
          MusicSongModel localMusicSongModel = (MusicSongModel)paramString.next();
          if (localMusicSongModel.a().equals(paramMusicSongModel.a())) {
            localMusicSongModel.i(paramMusicSongModel.l());
          }
        }
      }
    }
  }
  
  public void a(final String paramString, final n.a parama)
  {
    new com.baidu.carlife.radio.c.a(this.C).a(com.baidu.carlife.core.screen.presentation.a.g.a().b(), new com.baidu.carlife.radio.c.a.a()
    {
      public void a()
      {
        r.this.b(paramString, parama);
      }
    });
  }
  
  public void a(final String paramString1, String paramString2)
  {
    new com.baidu.carlife.radio.c.a(this.C).a(com.baidu.carlife.core.screen.presentation.a.g.a().b(), new com.baidu.carlife.radio.c.a.a()
    {
      public void a()
      {
        if (paramString1 != null) {
          h.b().c(paramString1);
        }
        com.baidu.carlife.radio.a.a locala;
        do
        {
          return;
          locala = com.baidu.carlife.radio.c.b.a().d();
        } while (locala == null);
        h.b().c(locala.a());
      }
    });
  }
  
  public void a(List<MusicSongModel> paramList, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.U = null;
    if ((paramString == null) || (!paramString.equals(n()))) {}
    do
    {
      do
      {
        return;
        if ((paramList == null) || (paramList.isEmpty())) {
          break label221;
        }
        if (g(paramString)) {
          break;
        }
        this.x.clear();
        localObject = new Pair(paramString, paramList);
        com.baidu.carlife.core.k.a(218, s(), localObject);
      } while (this.G != null);
      e(paramString);
      a(paramString, paramList);
      h.b().e(p());
      return;
      Object localObject = f(paramString);
      if (m(paramString))
      {
        paramInt1 = paramList.size();
        paramInt2 = 0;
        while (paramInt2 < paramInt1) {
          if (((MusicSongModel)paramList.get(paramInt2)).r == 999)
          {
            paramList.remove(paramInt2);
            paramInt1 -= 1;
          }
          else
          {
            paramInt2 += 1;
          }
        }
      }
      a((List)localObject, paramList);
      localObject = new Pair(paramString, paramList);
      com.baidu.carlife.core.k.a(218, s(), localObject);
    } while (this.G != null);
    a(paramString, paramList);
    return;
    label221:
    paramList = f(paramString);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      i.b("CarLifeMusic", "PlatformManager.onGetSongList() - FAIL");
      b(paramString);
    }
    com.baidu.carlife.core.k.b(249, s());
  }
  
  public void b(MusicSongModel paramMusicSongModel)
  {
    this.U = paramMusicSongModel;
  }
  
  public void b(String paramString, final n.a parama)
  {
    StatisticManager.onEvent("VOICE_0019");
    if (!TextUtils.equals(C(), paramString))
    {
      l(paramString);
      f(0);
      this.x.clear();
      h.b().f(true);
    }
    if (!"10".equals(n())) {
      h.b().f(true);
    }
    e("10");
    B().a(l.a.a().d(paramString).a(new u()
    {
      public void a(String paramAnonymousString)
      {
        if (parama != null) {
          parama.b();
        }
        if (h.b().q())
        {
          h.b().f(true);
          w.a("未搜索到结果，请尝试其他节目");
          com.baidu.carlife.m.a.a().a("未搜索到结果，请尝试其他节目", 0);
        }
      }
      
      public void a(String paramAnonymousString, List<MusicSongModel> paramAnonymousList)
      {
        if (parama != null) {
          parama.a();
        }
        if (!TextUtils.isEmpty(r.this.C())) {
          p.a().b("radio_voice_query", r.this.C());
        }
        r.this.a(paramAnonymousList, paramAnonymousString, 0, 0, 0);
        if (paramAnonymousString.equals(r.this.n())) {
          com.baidu.carlife.core.k.b(230);
        }
      }
    }).c());
  }
  
  public void b(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null)
    {
      paramString1 = com.baidu.carlife.radio.c.b.a().d();
      if (paramString1 != null) {}
    }
    do
    {
      return;
      str = paramString1.a();
      paramString2 = paramString1.b();
      paramString1 = new Bundle();
      paramString1.putString("album_id", str);
      paramString1.putString("album_name", paramString2);
      if (s() > 100)
      {
        com.baidu.carlife.core.screen.presentation.h.a().showFragment(595, paramString1);
        return;
      }
    } while (s() <= 0);
    com.baidu.carlife.core.screen.presentation.h.a().showFragment(737, paramString1);
  }
  
  public void b(boolean paramBoolean) {}
  
  public int c(String paramString1, String paramString2)
  {
    com.baidu.carlife.logic.a.k localk = j.a().f();
    if ((localk instanceof com.baidu.carlife.logic.a.g)) {
      ((com.baidu.carlife.logic.a.g)localk).a(this, paramString1, paramString2);
    }
    return 0;
  }
  
  public Bitmap d(String paramString)
  {
    return null;
  }
  
  public void d(int paramInt) {}
  
  public boolean e(int paramInt)
  {
    return true;
  }
  
  public List<MusicSongModel> g()
  {
    List localList = f(n());
    if ((localList == null) || (localList.isEmpty())) {
      a(0, n());
    }
    return localList;
  }
  
  @Deprecated
  public void h() {}
  
  public boolean i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.S.contains(paramString)) {
      return false;
    }
    return true;
  }
  
  public void j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.S.add(paramString);
  }
  
  public void k(String paramString)
  {
    new com.baidu.che.codriver.f.a(new com.baidu.che.codriver.f.a.a()
    {
      public void a(String paramAnonymousString) {}
      
      public void b(String paramAnonymousString)
      {
        r.this.b(paramAnonymousString, null);
      }
    }).a(paramString);
  }
  
  public void l(int paramInt)
  {
    if (paramInt < 0) {}
    for (;;)
    {
      return;
      Object localObject = g();
      if (localObject != null)
      {
        if (paramInt == 0)
        {
          ((List)localObject).clear();
          return;
        }
        if (((List)localObject).size() > paramInt)
        {
          localObject = ((List)localObject).iterator();
          int i = 0;
          while (((Iterator)localObject).hasNext())
          {
            ((Iterator)localObject).next();
            if (i >= paramInt) {
              ((Iterator)localObject).remove();
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public void l(String paramString)
  {
    this.T = paramString;
  }
  
  public MusicSongModel p()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.U != null) {
      localObject1 = this.U;
    }
    List localList;
    do
    {
      do
      {
        return (MusicSongModel)localObject1;
        localList = g();
        localObject1 = localObject2;
      } while (localList == null);
      localObject1 = localObject2;
    } while (localList.isEmpty());
    if (m() >= localList.size())
    {
      f(localList.size());
      a(0, n());
      return null;
    }
    try
    {
      localObject1 = (MusicSongModel)localList.get(m());
      return (MusicSongModel)localObject1;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      f(0);
    }
    return (MusicSongModel)localList.get(m());
  }
  
  public void y()
  {
    e(null);
    this.I.clear();
    this.x.clear();
    super.y();
  }
  
  public void z()
  {
    if (h.b().v()) {
      c.a().a(4, this);
    }
    if (h.b().q())
    {
      h.b().e(true);
      return;
    }
    h.b().x();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */