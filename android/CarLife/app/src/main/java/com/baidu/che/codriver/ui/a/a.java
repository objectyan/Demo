package com.baidu.che.codriver.ui.a;

import android.view.ViewGroup;
import com.baidu.che.codriver.widget.CompoundRelativeLayout;

public abstract class a
{
  public static int a = -1;
  
  private void a(CompoundRelativeLayout paramCompoundRelativeLayout, int paramInt)
  {
    if ((a > -1) && (paramInt == a)) {
      paramCompoundRelativeLayout.setChecked(true);
    }
  }
  
  protected void a(ViewGroup paramViewGroup, CompoundRelativeLayout paramCompoundRelativeLayout, int paramInt)
  {
    a(paramCompoundRelativeLayout, paramInt);
    paramViewGroup.addView(paramCompoundRelativeLayout);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */