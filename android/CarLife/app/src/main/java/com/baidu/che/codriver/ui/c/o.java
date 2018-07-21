package com.baidu.che.codriver.ui.c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.vr.a.g;
import com.baidu.che.codriver.widget.SwitchPageLayout;
import com.baidu.che.codriver.widget.c;

public class o
  extends b
{
  b.a a()
  {
    return b.a.a;
  }
  
  void a(View paramView)
  {
    SwitchPageLayout localSwitchPageLayout = (SwitchPageLayout)paramView;
    g localg = (g)b();
    paramView = new c(paramView.getContext());
    paramView.a(localg);
    localSwitchPageLayout.setAdapter(paramView);
    localSwitchPageLayout.setTitle(localg.g);
  }
  
  View b(View paramView)
  {
    return LayoutInflater.from(paramView.getContext()).inflate(2130969027, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/c/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */