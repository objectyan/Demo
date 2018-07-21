package com.baidu.carlife.core.screen.presentation;

import android.content.Context;
import android.support.v4.app.OnFragmentListener;
import android.view.Display;
import com.baidu.carlife.core.screen.k;
import com.baidu.navi.util.StatisticManager;

public class CarlifeActivityService
  extends AbsCarlifeActivityService
{
  public a a(Context paramContext, Display paramDisplay, k paramk)
  {
    return new d(this, paramDisplay, this);
  }
  
  public b a(AbsCarlifeActivityService paramAbsCarlifeActivityService, Display paramDisplay)
  {
    return new e(this, paramDisplay);
  }
  
  public void a(OnFragmentListener paramOnFragmentListener)
  {
    h.a().a(paramOnFragmentListener);
  }
  
  public void a(String paramString)
  {
    StatisticManager.onEvent("CONNECT_0007", paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/CarlifeActivityService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */