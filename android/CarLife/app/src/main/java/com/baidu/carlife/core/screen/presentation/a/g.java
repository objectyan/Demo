package com.baidu.carlife.core.screen.presentation.a;

import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.e;

public class g
  implements e
{
  private static g b = new g();
  private f a;
  
  public static g a()
  {
    return b;
  }
  
  public void a(f paramf)
  {
    this.a = paramf;
  }
  
  public f b()
  {
    return this.a;
  }
  
  public void cancelDialog()
  {
    this.a.cancelDialog();
  }
  
  public void cancelDialog(BaseDialog paramBaseDialog)
  {
    this.a.cancelDialog(paramBaseDialog);
  }
  
  public void dismissDialog()
  {
    this.a.dismissDialog();
  }
  
  public void dismissDialog(BaseDialog paramBaseDialog)
  {
    this.a.dismissDialog(paramBaseDialog);
  }
  
  public boolean isDialogShown()
  {
    return this.a.isDialogShown();
  }
  
  public void showDialog(BaseDialog paramBaseDialog)
  {
    this.a.showDialog(paramBaseDialog);
  }
  
  public void showDialog(BaseDialog paramBaseDialog, BaseDialog.a parama)
  {
    this.a.showDialog(paramBaseDialog, parama);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */