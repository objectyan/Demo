package com.baidu.che.codriver.ui.c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.che.codriver.ui.a.d;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.widget.SwitchPageLayout;

public class f
  extends b
{
  b.a a()
  {
    return b.a.l;
  }
  
  void a(View paramView)
  {
    SwitchPageLayout localSwitchPageLayout = (SwitchPageLayout)paramView;
    paramView = new d(paramView.getContext());
    paramView.a((com.baidu.che.codriver.ui.d.f)b());
    localSwitchPageLayout.setAdapter(paramView);
    localSwitchPageLayout.setTitle(b().g);
  }
  
  View b(View paramView)
  {
    return LayoutInflater.from(paramView.getContext()).inflate(2130969027, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */