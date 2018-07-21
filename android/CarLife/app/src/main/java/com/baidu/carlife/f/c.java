package com.baidu.carlife.f;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ListView;
import com.baidu.carlife.core.screen.presentation.a.g;

public class c
  extends a
{
  private View.OnKeyListener v;
  
  public c(ListView paramListView, int paramInt)
  {
    super(paramListView, paramInt);
    paramListView.setOnKeyListener(this);
  }
  
  public void a(View.OnKeyListener paramOnKeyListener)
  {
    this.v = paramOnKeyListener;
  }
  
  public void e()
  {
    ((ListView)this.r).setSelection(0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.v != null) && (this.v.onKey(paramView, paramInt, paramKeyEvent))) {}
    do
    {
      do
      {
        return true;
        if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramInt)
        {
        default: 
          return super.onKey(paramView, paramInt, paramKeyEvent);
        }
      } while ((!d()) && (g.a().isDialogShown()) && (!d.a().i()));
      this.r.onKeyDown(20, paramKeyEvent);
      return true;
    } while ((!d()) && (g.a().isDialogShown()) && (!d.a().i()));
    this.r.onKeyDown(19, paramKeyEvent);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */