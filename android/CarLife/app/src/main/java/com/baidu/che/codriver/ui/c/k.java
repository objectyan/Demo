package com.baidu.che.codriver.ui.c;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.che.codriver.ui.a.b.c;
import com.baidu.che.codriver.ui.d.b.a;

public class k
  extends b
{
  b.a a()
  {
    return b.a.c;
  }
  
  void a(View paramView)
  {
    ((b.c)paramView.getTag()).a.setText(b().g);
  }
  
  View b(View paramView)
  {
    paramView = LayoutInflater.from(paramView.getContext()).inflate(2130968848, null);
    b.c localc = new b.c();
    localc.a = ((TextView)paramView.findViewById(2131625299));
    paramView.setTag(localc);
    return paramView;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */