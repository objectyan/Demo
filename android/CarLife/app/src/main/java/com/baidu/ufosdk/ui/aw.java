package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import com.baidu.ufosdk.e.a;

final class aw
  implements Runnable
{
  aw(av paramav) {}
  
  public final void run()
  {
    try
    {
      String str = a.e(av.a(this.a).getApplicationContext(), FeedbackInputActivity.l(av.a(this.a)));
      if ((str != null) && (str.length() != 0)) {
        FeedbackInputActivity.H(av.a(this.a)).obtainMessage(5, str).sendToTarget();
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */