package com.baidu.carlife.logic.music;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.carlife.logic.k;
import com.baidu.carlife.util.w;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;

public class j
  implements AdapterView.OnItemClickListener
{
  public static final String a = "LeftBarIndex";
  private static int c = 0;
  private Context b;
  private a d;
  
  public j(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      StatisticManager.onEvent("MUSIC_QQ_0001");
      return;
    case 2: 
      StatisticManager.onEvent("MUSIC_NETEASE_0001");
      return;
    case 3: 
      StatisticManager.onEvent("MUSIC_XMLY_0001");
      return;
    case 4: 
      StatisticManager.onEvent("MUSIC_KAOLA_0001");
      return;
    }
    StatisticManager.onEvent("MUSIC_CYB_0001");
  }
  
  public void a(a parama)
  {
    this.d = parama;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (c == paramInt) {
      if (this.d != null) {
        this.d.a();
      }
    }
    Object localObject;
    ContentFragment localContentFragment;
    do
    {
      return;
      if (k.a().c() != 0)
      {
        w.a(2131296842, 1);
        return;
      }
      h.b().d(paramInt);
      paramAdapterView = com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager();
      localObject = h.b().r();
      paramView = new Bundle();
      paramView.putBoolean("music_type_changed", true);
      localContentFragment = paramAdapterView.getCurrentFragment();
    } while (localContentFragment == null);
    if (((b)localObject).v() == 1) {
      if (localContentFragment.getType() == 737)
      {
        localContentFragment.getArguments().putBundle("show_bundle", paramView);
        localContentFragment.onStart();
      }
    }
    for (;;)
    {
      b(paramInt);
      a(paramInt);
      if (this.d == null) {
        break;
      }
      this.d.a();
      return;
      localObject = paramAdapterView.getLatestFragment(737);
      if ((localObject != null) && (((ContentFragment)localObject).isHidden()))
      {
        ((ContentFragment)localObject).getArguments().putBundle("show_bundle", paramView);
        ((ContentFragment)localObject).onStart();
      }
      paramAdapterView.showFragment(737, paramView);
      continue;
      if (((b)localObject).v() == 0) {
        if (localContentFragment.getType() == 745)
        {
          localContentFragment.getArguments().putBundle("show_bundle", paramView);
          localContentFragment.onStart();
        }
        else
        {
          paramAdapterView.showFragment(745, paramView);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */