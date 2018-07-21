package com.baidu.carlife.logic.music.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.c.b.a;
import com.baidu.carlife.c.f;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.logic.music.a.a.a;
import com.baidu.carlife.logic.music.h;
import com.baidu.carlife.logic.music.q;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.DiscoverCardView;
import com.baidu.navi.fragment.BaseFragment;
import java.net.URLEncoder;
import java.util.HashMap;

public class a
  extends com.baidu.carlife.c.e.a<com.baidu.carlife.logic.music.a.a>
{
  private static final int a = 0;
  private static final int b = 2;
  private static final int c = 1;
  private static final int d = 3;
  private static final String e = "#408FA5E3";
  private com.baidu.carlife.logic.music.c.a f;
  private com.baidu.carlife.logic.music.b g;
  private boolean h = false;
  private com.baidu.carlife.view.dialog.c i = null;
  
  public a(com.baidu.carlife.logic.music.b paramb)
  {
    this.g = paramb;
    this.f = new com.baidu.carlife.logic.music.c.a(paramb);
  }
  
  private void a(int paramInt, final com.baidu.carlife.logic.music.a.a parama)
  {
    DiscoverCardView localDiscoverCardView = (DiscoverCardView)b().a(paramInt);
    localDiscoverCardView.setBackgroundColor(Color.parseColor("#408FA5E3"));
    localDiscoverCardView.b((String)parama.c().b());
    localDiscoverCardView.setCardDescriptionVisibility(true);
    localDiscoverCardView.a((String)parama.b().b());
    localDiscoverCardView.a(((Integer)parama.d().b()).intValue());
    h localh = h.b();
    paramInt = 0;
    if (localh.n() == 1) {
      paramInt = 1;
    }
    if ((paramInt != 0) && (((String)parama.b().b()).equals(this.g.o()))) {
      localDiscoverCardView.setCardTitleColor(r.a(2131558648));
    }
    for (;;)
    {
      localDiscoverCardView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (paramAnonymousView.getId() == 2131625360)
          {
            if (!q.Y)
            {
              a.a(a.this);
              return;
            }
            f.a().a(a.b(a.this), parama.e().b(), com.baidu.carlife.c.a.a.c());
            return;
          }
          f.a().a(a.b(a.this), parama.e().b(), com.baidu.carlife.c.a.a.c());
        }
      });
      return;
      localDiscoverCardView.setCardTitleColor(r.a(2131558703));
    }
  }
  
  private void g()
  {
    HashMap localHashMap = ((q)this.g).Z;
    if (localHashMap.containsKey("LOCAL_MUSIC")) {
      a("LOCAL_MUSIC", ((Integer)localHashMap.get("LOCAL_MUSIC")).intValue());
    }
    if (localHashMap.containsKey("LAST_PLAYLIST")) {
      a("LAST_PLAYLIST", ((Integer)localHashMap.get("LAST_PLAYLIST")).intValue());
    }
    if (localHashMap.containsKey("MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}")) {
      a("MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}", ((Integer)localHashMap.get("MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}")).intValue());
    }
  }
  
  private void h()
  {
    if (this.i != null) {
      return;
    }
    this.i = new com.baidu.carlife.view.dialog.c(com.baidu.carlife.core.a.a().getApplicationContext());
    this.i.b(2131296863);
    this.i.a(2131296862);
    this.i.a(true);
    this.i.c(2131296259);
    this.i.a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        a.a(a.this, null);
      }
    });
    this.i.b(true);
    this.i.d(2131296264);
    this.i.r();
    this.i.b(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        a.this.f();
        a.a(a.this, null);
      }
    });
    g.a().showDialog(this.i);
  }
  
  public void a()
  {
    if (!this.h)
    {
      a(null);
      g();
    }
  }
  
  protected void a(com.baidu.carlife.logic.music.a.a parama)
  {
    a(2131625359, a.a.a().b(com.baidu.carlife.c.g.a.a(2131296634)).c(com.baidu.carlife.c.g.a.a(2131296864)).d(com.baidu.carlife.c.g.a.a(Integer.valueOf(2130838992))).e(com.baidu.carlife.c.g.a.a(Integer.valueOf(0))).c());
    a(2131625360, a.a.a().b(com.baidu.carlife.c.g.a.a(2131296635)).c(com.baidu.carlife.c.g.a.a(2131296868)).d(com.baidu.carlife.c.g.a.a(Integer.valueOf(2130838993))).e(com.baidu.carlife.c.g.a.a(Integer.valueOf(2))).c());
    a(2131625361, a.a.a().b(com.baidu.carlife.c.g.a.a(2131296638)).c(com.baidu.carlife.c.g.a.a(2131296864)).d(com.baidu.carlife.c.g.a.a(Integer.valueOf(2130838996))).e(com.baidu.carlife.c.g.a.a(Integer.valueOf(1))).c());
    a(2131625362, a.a.a().b(com.baidu.carlife.c.g.a.a(2131296637)).c(com.baidu.carlife.c.g.a.a(2131296865)).d(com.baidu.carlife.c.g.a.a(Integer.valueOf(2130838995))).e(com.baidu.carlife.c.g.a.a(Integer.valueOf(3))).c());
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    b().a().removeCallbacks(paramRunnable);
    b().a().postDelayed(paramRunnable, paramLong);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt < 1) {}
    do
    {
      return;
      this.h = true;
      if ("LOCAL_MUSIC".equals(paramString))
      {
        paramString = (DiscoverCardView)b().a(2131625359);
        localResources = paramString.getContext().getResources();
        paramString.b(localResources.getString(2131296866) + paramInt + localResources.getString(2131296867));
        return;
      }
      if ("LAST_PLAYLIST".equals(paramString))
      {
        paramString = (DiscoverCardView)b().a(2131625361);
        localResources = paramString.getContext().getResources();
        paramString.b(localResources.getString(2131296866) + paramInt + localResources.getString(2131296867));
        return;
      }
    } while (!"MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}".equals(paramString));
    paramString = (DiscoverCardView)b().a(2131625360);
    Resources localResources = paramString.getContext().getResources();
    paramString.b(localResources.getString(2131296866) + paramInt + localResources.getString(2131296867));
  }
  
  protected void f()
  {
    try
    {
      String str = URLEncoder.encode("{\"cmd\":\"login\",\"callbackurl\":\"carlife://login\",\"devicebrand\":\"Baidu\",\"deviceid\":\"xxx\"}", "utf-8");
      str = "qqmusic://qq.com/other/qplayauto?p=" + str;
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(str));
      BaseFragment.getNaviActivity().startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      i.b("qqmusic", "openQQMusicForLogin error:" + localException.getMessage());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */