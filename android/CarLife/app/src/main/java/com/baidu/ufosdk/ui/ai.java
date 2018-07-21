package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;

final class ai
  extends TimerTask
{
  ai(ag paramag) {}
  
  public final void run()
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    FeedbackHotActivity.f(ag.a(this.a)).sendMessage(localMessage);
    FeedbackHotActivity.g(ag.a(this.a)).cancel();
    FeedbackHotActivity.g(ag.a(this.a)).purge();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */