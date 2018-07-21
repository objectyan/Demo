package com.baidu.carlife.radio.c;

import android.content.Context;

public class a
{
  private Context a;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(com.baidu.carlife.core.screen.e parame, final a parama)
  {
    if ((b.a().b()) && (com.baidu.carlife.core.e.s() == 1))
    {
      final com.baidu.carlife.view.dialog.c localc = new com.baidu.carlife.view.dialog.c(this.a);
      localc.b(2131296715).a(2131296713).c(2131296714).q().a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          b.a().a(false);
          parama.a();
        }
      }).d(2131296711).a(1, 8).a(new com.baidu.carlife.core.screen.c()
      {
        public void onCountDown(int paramAnonymousInt)
        {
          if (paramAnonymousInt <= 0)
          {
            localc.d();
            b.a().a(false);
            parama.a();
          }
        }
      });
      parame.showDialog(localc);
      return;
    }
    parama.a();
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */