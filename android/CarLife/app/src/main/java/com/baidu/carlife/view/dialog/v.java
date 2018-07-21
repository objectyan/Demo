package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.baidu.carlife.core.j;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.c;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;

public class v
  extends BaseDialog
{
  private FrameLayout e;
  private int f = -1;
  private int g = 0;
  private View.OnKeyListener h = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousInt == 21))
      {
        v.this.d();
        return true;
      }
      return false;
    }
  };
  private g i;
  private c j;
  
  public v(Context paramContext, View paramView, int paramInt)
  {
    super(paramContext, null, 2131427336);
    this.b.removeMsg(4140);
  }
  
  public v(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramContext, paramView, 2131427336);
    paramContext = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    paramContext.gravity = this.g;
    this.e.setLayoutParams(paramContext);
    this.e.addView(paramView);
    paramContext = paramView.getLayoutParams();
    paramContext.width = this.f;
    paramView.setLayoutParams(paramContext);
  }
  
  protected View a()
  {
    this.e = new FrameLayout(this.c);
    return this.e;
  }
  
  protected void b()
  {
    setCanceledOnTouchOutside(true);
  }
  
  public void f()
  {
    if (this.i == null)
    {
      this.i = new g(this.e.findViewById(2131626106), 7);
      this.i.d(this.e.findViewById(2131626107)).d(this.e.findViewById(2131626108));
    }
    if (this.j == null) {
      this.j = new c((ListView)this.e.findViewById(2131626118), 11);
    }
    this.i.a(this.h);
    this.j.a(this.h);
    this.i.a(true);
    this.j.a(true);
    d.a().a(new a[] { this.i, this.j });
  }
  
  public void i()
  {
    d.a().a(new a[] { this.i, this.j });
    d.a().h(this.i);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */