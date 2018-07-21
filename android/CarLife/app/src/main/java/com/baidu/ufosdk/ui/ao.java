package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class ao
  implements View.OnClickListener
{
  ao(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void onClick(View paramView)
  {
    FeedbackInputActivity.z(this.a).setVisibility(8);
    FeedbackInputActivity.N(this.a);
    FeedbackInputActivity.v(this.a);
    FeedbackInputActivity.a(this.a, Executors.newSingleThreadExecutor());
    FeedbackInputActivity.i(this.a).execute(new ap(this));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */