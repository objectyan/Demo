package com.baidu.carlife.f;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.logic.g;
import com.baidu.carlife.view.HomeCardView;
import java.lang.reflect.Method;

public abstract class a
  implements View.OnKeyListener
{
  protected static final String a = "FocusArea";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 10;
  public static final int m = 11;
  public static final int n = 12;
  public static final int o = 13;
  public static final int p = 14;
  public static final int q = 15;
  protected View r;
  protected int s;
  protected boolean t = false;
  protected boolean u = false;
  
  protected a(View paramView, int paramInt)
  {
    this.r = paramView;
    this.s = paramInt;
    this.t = false;
  }
  
  protected a(View paramView, int paramInt, boolean paramBoolean)
  {
    this.r = paramView;
    this.s = paramInt;
    this.t = paramBoolean;
  }
  
  public void a(View paramView)
  {
    Drawable localDrawable;
    if ((!g.a().c()) && (paramView != null))
    {
      localDrawable = paramView.getBackground();
      if ((paramView instanceof HomeCardView)) {
        ((HomeCardView)paramView).setFocusViewGone();
      }
    }
    else
    {
      return;
    }
    if ((localDrawable != null) && ((localDrawable instanceof StateListDrawable)))
    {
      paramView = (StateListDrawable)localDrawable;
      try
      {
        paramView.selectDrawable(((Integer)StateListDrawable.class.getMethod("getStateDrawableIndex", new Class[] { int[].class }).invoke(paramView, new Object[] { { 16843161 } })).intValue());
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
    }
    paramView.clearFocus();
  }
  
  public void a(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public boolean a()
  {
    i.b("FocusManager", "grantFocus focusArea");
    this.r.setFocusable(true);
    boolean bool = this.r.requestFocus();
    if (bool) {
      a(this.r);
    }
    return bool;
  }
  
  public int b()
  {
    return this.s;
  }
  
  public boolean c()
  {
    return this.r.hasFocus();
  }
  
  public boolean d()
  {
    return this.u;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0)) {}
    switch (paramInt)
    {
    default: 
      if ((paramView != null) && (paramView.isFocused())) {
        a(paramView);
      }
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool;
            paramView = d.a().e(this);
            i.b("FocusManager", "KEYCODE_DPAD_UP focusArea=" + paramView);
          } while (paramView == null);
          paramView.a();
          return true;
          paramView = d.a().d(this);
          i.b("FocusManager", "KEYCODE_DPAD_DOWN focusArea=" + paramView);
        } while (paramView == null);
        paramView.a();
        return true;
        paramView = d.a().f(this);
        i.b("FocusManager", "KEYCODE_DPAD_LEFT focusArea=" + paramView);
      } while (paramView == null);
      paramView.a();
      return true;
      paramView = d.a().g(this);
      i.b("FocusManager", "KEYCODE_DPAD_RIGHT focusArea=" + paramView);
    } while (paramView == null);
    paramView.a();
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */