package com.baidu.ufosdk.ui;

import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.e.a;

final class am
  implements Runnable
{
  am(aj paramaj) {}
  
  public final void run()
  {
    try
    {
      FeedbackInputActivity localFeedbackInputActivity = aj.a(this.a);
      String str = UfoSDK.clientid;
      a.c(localFeedbackInputActivity, FeedbackInputActivity.g(aj.a(this.a)));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */