package com.baidu.carlife.logic.codriver.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.view.dialog.BaseDialog;
import com.baidu.carlife.view.dialog.k;

public abstract class AdapterDialog
  extends BaseDialog
{
  protected RelativeLayout e;
  protected boolean f = false;
  private boolean g = false;
  
  public AdapterDialog(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b.removeMsg(4140);
    setDialogShowHideListener(new k()
    {
      public void onDismiss()
      {
        AdapterDialog.this.k();
      }
      
      public void onShow()
      {
        AdapterDialog.this.j();
      }
    });
  }
  
  protected View a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.c).inflate(getLayoutId(), null, false);
    this.e = localRelativeLayout;
    return localRelativeLayout;
  }
  
  protected View a(int paramInt)
  {
    return this.e.findViewById(paramInt);
  }
  
  protected void a(Bundle paramBundle) {}
  
  public void c()
  {
    this.f = true;
    d();
  }
  
  public void d()
  {
    if (this.f)
    {
      super.d();
      this.f = false;
      return;
    }
    this.f = true;
    g.a().dismissDialog(this);
  }
  
  protected abstract int getLayoutId();
  
  public void i()
  {
    if (!this.g)
    {
      a(null);
      this.g = true;
    }
    g.a().showDialog(this);
  }
  
  protected void j() {}
  
  protected void k() {}
  
  public boolean l()
  {
    return !h();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/codriver/adapter/AdapterDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */