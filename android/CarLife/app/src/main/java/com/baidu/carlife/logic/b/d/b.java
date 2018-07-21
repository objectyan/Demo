package com.baidu.carlife.logic.b.d;

import android.os.Bundle;
import com.baidu.carlife.c.d;
import com.baidu.carlife.core.screen.presentation.h;

public class b
  extends d<Void, Void>
{
  private int a;
  private Bundle b;
  
  public b(int paramInt, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = paramBundle;
  }
  
  public void a(Void paramVoid)
  {
    com.baidu.carlife.c.g.b.a().a(new Runnable()
    {
      public void run()
      {
        h.a().showFragment(b.a(b.this), b.b(b.this));
      }
    });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/b/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */