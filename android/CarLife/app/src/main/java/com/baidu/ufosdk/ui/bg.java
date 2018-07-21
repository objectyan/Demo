package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.e.a;

final class bg
  implements Runnable
{
  bg(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void run()
  {
    a.a(this.a.getApplicationContext());
    if (UfoSDK.clientid.length() != 0) {
      FeedbackInputActivity.H(this.a).obtainMessage(1, null).sendToTarget();
    }
    for (;;)
    {
      Object localObject = this.a.getApplicationContext();
      String str = UfoSDK.clientid;
      localObject = a.c((Context)localObject);
      if (localObject != null) {
        FeedbackInputActivity.H(this.a).obtainMessage(0, localObject).sendToTarget();
      }
      return;
      FeedbackInputActivity.H(this.a).obtainMessage(4, null).sendToTarget();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */