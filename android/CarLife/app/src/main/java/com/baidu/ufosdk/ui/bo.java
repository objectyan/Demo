package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

final class bo
  implements View.OnClickListener
{
  bo(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void onClick(View paramView)
  {
    if (FeedbackInputActivity.M(this.a)) {
      return;
    }
    if (FeedbackInputActivity.e(this.a).getVisibility() == 0)
    {
      FeedbackInputActivity.e(this.a).setVisibility(8);
      FeedbackInputActivity.f(this.a).setVisibility(8);
      return;
    }
    FeedbackInputActivity.e(this.a).setVisibility(0);
    FeedbackInputActivity.f(this.a).setVisibility(0);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */