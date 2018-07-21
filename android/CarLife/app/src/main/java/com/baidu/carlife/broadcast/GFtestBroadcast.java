package com.baidu.carlife.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.custom.b;
import com.baidu.navi.fragment.NaviFragmentManager;

public class GFtestBroadcast
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    i.b("yftech", "BroadcastReceiver : " + paramIntent.getAction());
    if ((paramIntent.getAction().equals("com.baidu.carlife.driving.start")) && (com.baidu.carlife.l.a.a().N()) && ((com.baidu.carlife.custom.a.a().b()) || (b.a().b())))
    {
      com.baidu.carlife.custom.a.a().a(true);
      h.a().getNaviFragmentManager().driving();
    }
    if ((paramIntent.getAction().equals("com.baidu.carlife.driving.stop")) && (com.baidu.carlife.l.a.a().N()) && ((com.baidu.carlife.custom.a.a().b()) || (b.a().b()))) {
      h.a().getNaviFragmentManager().stopDriving();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/broadcast/GFtestBroadcast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */