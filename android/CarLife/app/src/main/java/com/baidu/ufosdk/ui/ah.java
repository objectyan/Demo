package com.baidu.ufosdk.ui;

import com.baidu.ufosdk.util.i;

final class ah
  implements Runnable
{
  ah(ag paramag) {}
  
  public final void run()
  {
    ag.a(this.a).finish();
    try
    {
      ag.a(this.a).overridePendingTransition(i.a(ag.a(this.a).getApplicationContext(), "ufo_slide_in_from_left"), i.a(ag.a(this.a).getApplicationContext(), "ufo_slide_out_to_right"));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */