package com.baidu.carlife.custom;

import android.os.Message;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.protobuf.CarlifeGearInfoProto.CarlifeGearInfo;
import com.baidu.carlife.util.w;
import com.baidu.navi.fragment.NaviFragmentManager;

public class b
{
  private static final String a = "yftech";
  private static final String b = "进入驾驶模式部分功能在停车后可操作";
  private static b c = null;
  private boolean d = false;
  
  public static b a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new b();
      }
      return c;
    }
    finally {}
  }
  
  public void a(Message paramMessage)
  {
    paramMessage = (c)paramMessage.obj;
    for (;;)
    {
      try
      {
        int i = CarlifeGearInfoProto.CarlifeGearInfo.parseFrom(paramMessage.f()).getGear();
        switch (i)
        {
        case 1: 
          i.b("yftech", "ERROR gear =  " + i);
          return;
        }
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
      if (h.a().getNaviFragmentManager() == null) {
        break;
      }
      h.a().getNaviFragmentManager().stopDriving();
      return;
      if (h.a().getNaviFragmentManager() == null) {
        break;
      }
      this.d = true;
      h.a().getNaviFragmentManager().driving();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if ((f.jx == f.a.ad) || (f.jx == f.a.ae) || (f.jx == f.a.af)) {
      bool = true;
    }
    return bool;
  }
  
  public void c()
  {
    if ((b()) && (h.a().getNaviFragmentManager() != null)) {
      h.a().getNaviFragmentManager().stopDriving();
    }
  }
  
  public void d()
  {
    i.b("yftech", "showToast isShowToast =  " + this.d);
    if (this.d)
    {
      w.a("进入驾驶模式部分功能在停车后可操作", 0);
      this.d = false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */