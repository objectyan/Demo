package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class t
  extends BaseDialog
{
  public t(Context paramContext)
  {
    super(paramContext);
  }
  
  protected View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2130968888, null);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        t.this.d();
      }
    });
    return localView;
  }
  
  protected void b()
  {
    findViewById(2131625498).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
  }
  
  public void f() {}
  
  public int getCustomHeight()
  {
    return this.c.getResources().getDimensionPixelSize(2131361979);
  }
  
  protected int getCustomWidth()
  {
    return this.c.getResources().getDimensionPixelSize(2131361980);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */