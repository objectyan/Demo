package com.baidu.che.codriver.ui.c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.che.codriver.ui.a.e;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.ui.d.h;
import com.baidu.che.codriver.widget.SwitchPageLayout;

public class g
  extends b
{
  b.a a()
  {
    return b.a.d;
  }
  
  void a(View paramView)
  {
    SwitchPageLayout localSwitchPageLayout = (SwitchPageLayout)paramView;
    paramView = new e(paramView.getContext());
    paramView.a((h)b());
    localSwitchPageLayout.setAdapter(paramView);
    localSwitchPageLayout.setTitle(b().g);
  }
  
  View b(View paramView)
  {
    return LayoutInflater.from(paramView.getContext()).inflate(2130969027, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */