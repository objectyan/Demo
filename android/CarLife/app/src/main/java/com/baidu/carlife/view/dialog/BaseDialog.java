package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.f.d;

public abstract class BaseDialog
  extends com.baidu.carlife.core.screen.BaseDialog
{
  private k e;
  
  public BaseDialog(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseDialog(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(e parame)
  {
    super.a(parame);
    d.a().f();
    this.b.postDelayed(new Runnable()
    {
      public void run()
      {
        if (!BaseDialog.a(BaseDialog.this))
        {
          d.a().g();
          BaseDialog.this.f();
        }
      }
    }, 100L);
    if (this.e != null) {
      this.e.onShow();
    }
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public void d()
  {
    super.d();
    d.a().j();
    if (this.e != null) {
      this.e.onDismiss();
    }
  }
  
  public void g()
  {
    super.g();
    d.a().e();
  }
  
  public void setDialogShowHideListener(k paramk)
  {
    this.e = paramk;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/BaseDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */