package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.e.a;

final class i
  implements Runnable
{
  i(g paramg) {}
  
  public final void run()
  {
    Object localObject = g.a(this.a).getApplicationContext();
    String str = UfoSDK.clientid;
    localObject = a.c((Context)localObject);
    if (localObject != null) {
      FeedbackFacePageActivity.o(g.a(this.a)).obtainMessage(0, localObject).sendToTarget();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */