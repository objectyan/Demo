package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class av
  implements View.OnClickListener
{
  av(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      FeedbackInputActivity.D(this.a).setVisibility(8);
      FeedbackInputActivity.E(this.a).setVisibility(0);
      if ((FeedbackInputActivity.l(this.a) != null) && (FeedbackInputActivity.l(this.a).length() > 0))
      {
        FeedbackInputActivity.a(this.a, Executors.newSingleThreadExecutor());
        FeedbackInputActivity.i(this.a).execute(new aw(this));
      }
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */