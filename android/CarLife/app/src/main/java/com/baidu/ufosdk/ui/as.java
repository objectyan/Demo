package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import com.baidu.ufosdk.e.a;

final class as
  implements Runnable
{
  as(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void run()
  {
    String str = a.e(this.a.getApplicationContext(), FeedbackInputActivity.l(this.a));
    if ((str != null) && (str.length() != 0)) {
      FeedbackInputActivity.H(this.a).obtainMessage(5, str).sendToTarget();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */