package com.baidu.carlife.f;

import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.baidu.carlife.core.i;

public class h
  extends a
{
  private static final String v = "FocusViewPager";
  private View.OnKeyListener w;
  
  public h(ViewPager paramViewPager, int paramInt)
  {
    super(paramViewPager, paramInt);
    paramViewPager.setOnKeyListener(this);
  }
  
  public void a(View.OnKeyListener paramOnKeyListener)
  {
    this.w = paramOnKeyListener;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.w != null) && (this.w.onKey(paramView, paramInt, paramKeyEvent))) {
      return true;
    }
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0))
    {
      i.c("FocusViewPager", "action=" + paramKeyEvent.getAction() + "keyCode=" + paramInt);
      switch (paramInt)
      {
      }
    }
    do
    {
      return super.onKey(paramView, paramInt, paramKeyEvent);
      ((ViewPager)this.r).arrowScroll(66);
      return true;
      ((ViewPager)this.r).arrowScroll(17);
      return true;
    } while (this.w == null);
    return this.w.onKey(paramView, paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */