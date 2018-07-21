package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.util.h;

final class bn
  implements View.OnClickListener
{
  bn(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void onClick(View paramView)
  {
    if (!h.a()) {
      FeedbackInputActivity.J(this.a);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */