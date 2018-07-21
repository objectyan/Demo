package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.ufosdk.util.i;

final class ab
  extends Handler
{
  ab(FeedbackHotActivity paramFeedbackHotActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what == 3) && (FeedbackHotActivity.a(this.a).getProgress() < 100))
    {
      FeedbackHotActivity.a(this.a).stopLoading();
      FeedbackHotActivity.b(this.a).setVisibility(8);
      i.a(this.a.getApplicationContext(), FeedbackHotActivity.c(this.a));
      FeedbackHotActivity.d(this.a).setVisibility(0);
      FeedbackHotActivity.a(this.a).setVisibility(8);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */