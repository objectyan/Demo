package com.baidu.ufosdk.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class bl
  implements TextView.OnEditorActionListener
{
  bl(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      FeedbackInputActivity.J(this.a);
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */