package com.baidu.che.codriver.ui.c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.che.codriver.ui.a.f;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.ui.d.i;
import com.baidu.che.codriver.ui.d.i.a;
import com.baidu.che.codriver.widget.SwitchPageLayout;

public class m
  extends b
{
  b.a a()
  {
    return b.a.f;
  }
  
  void a(View paramView)
  {
    SwitchPageLayout localSwitchPageLayout = (SwitchPageLayout)paramView;
    i locali = (i)b();
    i.a locala = locali.a();
    localSwitchPageLayout.setAdapter(new f(paramView.getContext(), locali));
    if (locala == i.a.c)
    {
      localSwitchPageLayout.setTitle("");
      return;
    }
    localSwitchPageLayout.setTitle(locali.g);
  }
  
  View b(View paramView)
  {
    return LayoutInflater.from(paramView.getContext()).inflate(2130969027, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */