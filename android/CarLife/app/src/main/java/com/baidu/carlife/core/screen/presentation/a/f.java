package com.baidu.carlife.core.screen.presentation.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.core.screen.g;
import com.baidu.carlife.core.screen.h;
import com.baidu.carlife.core.screen.i;
import com.baidu.carlife.core.screen.l;
import com.baidu.carlife.core.screen.m;

public abstract class f
  implements e, g, h, i, l, m
{
  protected View a;
  protected Context b;
  
  public f(Context paramContext, int paramInt)
  {
    this.b = paramContext;
    this.a = LayoutInflater.from(paramContext).inflate(paramInt, null);
  }
  
  public abstract Context e();
  
  public abstract void f();
  
  public View g()
  {
    return this.a;
  }
  
  public void h() {}
  
  public boolean i()
  {
    return true;
  }
  
  public boolean j()
  {
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */