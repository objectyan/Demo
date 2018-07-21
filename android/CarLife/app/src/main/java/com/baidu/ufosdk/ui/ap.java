package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import com.baidu.ufosdk.e.a;

final class ap
  implements Runnable
{
  ap(ao paramao) {}
  
  public final void run()
  {
    try
    {
      a.a(FeedbackInputActivity.g(ao.a(this.a)), "1");
      FeedbackInputActivity.H(ao.a(this.a)).obtainMessage(7).sendToTarget();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */