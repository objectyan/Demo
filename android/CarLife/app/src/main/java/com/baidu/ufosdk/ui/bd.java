package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.util.p;
import java.util.List;

final class bd
  implements View.OnClickListener
{
  bd(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void onClick(View paramView)
  {
    if (FeedbackInputActivity.M(this.a)) {}
    do
    {
      return;
      FeedbackInputActivity.Q(this.a).remove(((Integer)paramView.getTag()).intValue());
      if (FeedbackInputActivity.Q(this.a).size() != 1) {
        break;
      }
      paramView = p.a(this.a.getApplicationContext());
    } while (paramView == null);
    FeedbackInputActivity.Q(this.a).set(0, paramView);
    FeedbackInputActivity.R(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */