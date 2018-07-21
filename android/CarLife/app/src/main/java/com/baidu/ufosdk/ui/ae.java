package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.e.a;

final class ae
  implements Runnable
{
  ae(FeedbackHotActivity paramFeedbackHotActivity) {}
  
  public final void run()
  {
    a.a(this.a.getApplicationContext());
    Object localObject = this.a.getApplicationContext();
    String str = UfoSDK.clientid;
    localObject = a.c((Context)localObject);
    if (localObject != null) {
      FeedbackHotActivity.f(this.a).obtainMessage(0, localObject).sendToTarget();
    }
    FeedbackHotActivity.h(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */