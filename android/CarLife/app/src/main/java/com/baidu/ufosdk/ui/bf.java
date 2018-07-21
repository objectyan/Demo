package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.util.c;
import com.baidu.ufosdk.util.i;

final class bf
  implements View.OnClickListener
{
  bf(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void onClick(View paramView)
  {
    if (FeedbackInputActivity.M(this.a)) {
      return;
    }
    FeedbackInputActivity.b(this.a, ((Integer)paramView.getTag()).intValue());
    if (i.a() >= 23) {
      c.d(" CommonUtil.getAPILevel() >= 23 ");
    }
    FeedbackInputActivity.S(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */