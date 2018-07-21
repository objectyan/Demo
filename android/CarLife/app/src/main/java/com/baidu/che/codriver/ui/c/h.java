package com.baidu.che.codriver.ui.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.che.codriver.protocol.data.nlp.CinemaData;
import com.baidu.che.codriver.ui.a.c;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.ui.d.e;
import com.baidu.che.codriver.widget.SwitchPageLayout;
import java.util.List;

public class h
  extends b
{
  b.a a()
  {
    return b.a.g;
  }
  
  void a(View paramView)
  {
    SwitchPageLayout localSwitchPageLayout = (SwitchPageLayout)paramView;
    c localc = new c(paramView.getContext());
    CinemaData localCinemaData = ((e)b()).a;
    localc.a(localCinemaData);
    localSwitchPageLayout.setAdapter(localc);
    if (localCinemaData.list.size() > 3)
    {
      localSwitchPageLayout.setTitle(paramView.getContext().getString(2131297662, new Object[] { Integer.valueOf(localCinemaData.list.size()) }));
      return;
    }
    localSwitchPageLayout.setTitle(paramView.getContext().getString(2131296475));
  }
  
  View b(View paramView)
  {
    return LayoutInflater.from(paramView.getContext()).inflate(2130969027, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */