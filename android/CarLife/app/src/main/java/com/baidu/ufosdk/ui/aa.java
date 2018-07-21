package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;

final class aa
  extends TimerTask
{
  aa(z paramz) {}
  
  public final void run()
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    FeedbackFacePageActivity.o(z.a(this.a)).sendMessage(localMessage);
    if (FeedbackFacePageActivity.p(z.a(this.a)) != null)
    {
      FeedbackFacePageActivity.p(z.a(this.a)).cancel();
      FeedbackFacePageActivity.p(z.a(this.a)).purge();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */