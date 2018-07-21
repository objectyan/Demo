package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class aq
  implements View.OnClickListener
{
  aq(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void onClick(View paramView)
  {
    FeedbackInputActivity.z(this.a).setVisibility(8);
    FeedbackInputActivity.N(this.a);
    FeedbackInputActivity.v(this.a);
    FeedbackInputActivity.a(this.a, Executors.newSingleThreadExecutor());
    FeedbackInputActivity.i(this.a).execute(new ar(this));
    FeedbackInputActivity.H(this.a).obtainMessage(8).sendToTarget();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */