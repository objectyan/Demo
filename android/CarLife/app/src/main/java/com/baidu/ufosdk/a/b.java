package com.baidu.ufosdk.a;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.util.c;

public final class b
  extends Thread
{
  private Context a;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private final long e = 300L;
  private String f = "";
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a()
  {
    this.b = true;
  }
  
  public final void b()
  {
    this.b = false;
  }
  
  public final void run()
  {
    this.f = UfoSDK.clientid;
    if (this.f.length() == 0) {
      return;
    }
    try
    {
      Thread.sleep(300L);
      if (!this.c) {
        com.baidu.ufosdk.e.a.c(this.a);
      }
    }
    catch (InterruptedException localInterruptedException1)
    {
      try
      {
        do
        {
          if (!this.d) {
            Thread.sleep(com.baidu.ufosdk.a.ao * 1000);
          }
        } while (!this.b);
        return;
        localInterruptedException1 = localInterruptedException1;
        c.a("Interrupted!", localInterruptedException1);
      }
      catch (InterruptedException localInterruptedException2)
      {
        for (;;)
        {
          c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */