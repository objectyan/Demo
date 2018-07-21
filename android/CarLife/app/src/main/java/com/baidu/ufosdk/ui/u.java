package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class u
  implements View.OnFocusChangeListener
{
  u(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      new Thread(new v(this)).start();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */