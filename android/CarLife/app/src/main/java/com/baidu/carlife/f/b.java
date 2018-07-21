package com.baidu.carlife.f;

import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.a.g;

public class b
  extends a
{
  private static final String v = "FocusGridView";
  
  public b(GridView paramGridView, int paramInt)
  {
    super(paramGridView, paramInt);
    paramGridView.setOnKeyListener(this);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i;
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0))
    {
      i.c("FocusGridView", "action=" + paramKeyEvent.getAction() + "keyCode=" + paramInt);
      i = ((GridView)this.r).getSelectedItemPosition();
      i.c("FocusGridView", "selectedItemPosition=" + i);
      i.c("FocusGridView", "isInTouchMode=" + ((GridView)this.r).isInTouchMode());
    }
    switch (paramInt)
    {
    default: 
      return super.onKey(paramView, paramInt, paramKeyEvent);
    case 300: 
      if ((!d()) && (g.a().isDialogShown()) && (!d.a().i())) {
        return true;
      }
      if (i + 1 >= ((GridView)this.r).getCount()) {
        return true;
      }
      ((GridView)this.r).setSelection(i + 1);
      paramInt = ((GridView)this.r).getSelectedItemPosition();
      i.c("FocusGridView", "newSelectedItemPosition=" + paramInt);
      return true;
    }
    if ((!d()) && (g.a().isDialogShown()) && (!d.a().i())) {
      return true;
    }
    if (i - 1 < 0) {
      return true;
    }
    ((GridView)this.r).setSelection(i - 1);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */