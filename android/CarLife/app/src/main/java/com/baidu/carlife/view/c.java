package com.baidu.carlife.view;

import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.screen.d;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.view.dialog.j;

public class c
{
  private static volatile c a = null;
  private j b;
  private com.baidu.carlife.view.dialog.p c;
  private e d;
  
  public static c a()
  {
    if (a == null) {
      a = new c();
    }
    return a;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.c == null) || (this.d == null)) {
      return;
    }
    this.c.a(paramInt1, paramInt2);
    this.d.showDialog(this.c);
  }
  
  public void a(CarlifeActivity paramCarlifeActivity, e parame)
  {
    this.d = parame;
    this.b = new j(paramCarlifeActivity);
    this.b.setOnDialogCancelListener(new d()
    {
      public void onCancel()
      {
        com.baidu.carlife.util.p.a().c("isFristVoiceInHome", false);
      }
    });
  }
  
  public void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.c.a(paramArrayOfInt, paramInt1, paramInt2);
    this.d.showDialog(this.c);
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.b.a(paramArrayOfInt1, paramArrayOfInt2);
    this.d.showDialog(this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */