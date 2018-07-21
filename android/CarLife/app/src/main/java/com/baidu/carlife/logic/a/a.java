package com.baidu.carlife.logic.a;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class a
  implements View.OnClickListener
{
  private long a = 0L;
  private long b = 500L;
  
  private boolean b()
  {
    return (System.currentTimeMillis() - this.a < this.b) || (a());
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  protected abstract void a(View paramView);
  
  protected boolean a()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (b()) {
      return;
    }
    this.a = System.currentTimeMillis();
    a(paramView);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */