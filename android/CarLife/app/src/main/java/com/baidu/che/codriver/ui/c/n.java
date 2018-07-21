package com.baidu.che.codriver.ui.c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.che.codriver.ui.a.g;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.ui.d.j;
import com.baidu.che.codriver.widget.SwitchPageLayout;

public class n
  extends b
{
  b.a a()
  {
    return b.a.e;
  }
  
  void a(View paramView)
  {
    SwitchPageLayout localSwitchPageLayout = (SwitchPageLayout)paramView;
    j localj = (j)b();
    paramView = new g(paramView.getContext(), localj.b());
    paramView.a(localj);
    localSwitchPageLayout.setAdapter(paramView);
    localSwitchPageLayout.setTitle(localj.g);
  }
  
  View b(View paramView)
  {
    return LayoutInflater.from(paramView.getContext()).inflate(2130969027, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */