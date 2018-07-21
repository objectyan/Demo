package com.baidu.carlife.core.screen.presentation;

import android.view.Display;
import android.view.Window;
import com.baidu.carlife.core.screen.presentation.a.f;

public class e
  extends b
{
  public e(AbsCarlifeActivityService paramAbsCarlifeActivityService, Display paramDisplay)
  {
    super(paramAbsCarlifeActivityService, paramDisplay);
  }
  
  public c a(Window paramWindow)
  {
    return new g(paramWindow);
  }
  
  public void show()
  {
    super.show();
    if (com.baidu.carlife.core.screen.presentation.a.g.a().b() != null) {
      com.baidu.carlife.core.screen.presentation.a.g.a().b().h();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */