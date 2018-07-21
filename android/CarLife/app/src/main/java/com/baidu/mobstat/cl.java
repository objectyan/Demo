package com.baidu.mobstat;

import android.content.Context;

class cl
  implements Runnable
{
  cl(ch paramch, Context paramContext) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((ch.b(this.b) > 0L) && (l - ch.b(this.b) > this.b.c())) {
      ch.a(this.b, this.a, false);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */