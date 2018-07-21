package com.baidu.ufosdk.a;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.util.c;

public final class a
  extends Thread
{
  private Context a;
  private String b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private final long f = 300L;
  
  public a(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  public final void a()
  {
    this.c = true;
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
  }
  
  public final void b()
  {
    this.c = false;
  }
  
  public final void run()
  {
    if (UfoSDK.clientid.length() == 0) {
      return;
    }
    for (;;)
    {
      c.b("###################");
      try
      {
        Thread.sleep(300L);
        if (!this.d)
        {
          Context localContext = this.a;
          String str = UfoSDK.clientid;
          com.baidu.ufosdk.e.a.d(localContext, this.b);
        }
      }
      catch (InterruptedException localInterruptedException1)
      {
        try
        {
          if (!this.e) {
            Thread.sleep(com.baidu.ufosdk.a.an * 1000);
          }
          if (!this.c) {
            continue;
          }
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */