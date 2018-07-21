package com.baidu.carlife.core.screen.b;

import android.view.KeyEvent;
import android.view.View;
import com.baidu.carlife.core.i;

public class d
  extends a
{
  private View d;
  private View e;
  
  public d(View paramView1, View paramView2)
  {
    this.d = paramView1;
    this.e = paramView2;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    i.b("ouyang", "-------keyCode:" + paramInt);
    if ((paramInt != 65521) && (paramInt != 65520)) {
      return false;
    }
    if (paramKeyEvent.getAction() == 0)
    {
      i.b("ouyang", "-------ACTION_DOWN----");
      return false;
    }
    if (paramKeyEvent.getAction() == 1) {
      if (paramInt != 65520) {
        break label91;
      }
    }
    label91:
    for (paramView = this.d;; paramView = this.e)
    {
      if (paramView != null) {
        paramView.requestFocus();
      }
      i.b("ouyang", "-------ACTION_UP----");
      return true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */