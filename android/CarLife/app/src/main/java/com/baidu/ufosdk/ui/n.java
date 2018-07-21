package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.util.h;

final class n
  implements View.OnClickListener
{
  n(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onClick(View paramView)
  {
    if (!h.a())
    {
      FeedbackFacePageActivity.q(this.a).setVisibility(0);
      FeedbackFacePageActivity.q(this.a).bringToFront();
      FeedbackFacePageActivity.r(this.a).setVisibility(8);
      FeedbackFacePageActivity.s(this.a).setVisibility(0);
      FeedbackFacePageActivity.a(this.a).setFocusable(true);
      FeedbackFacePageActivity.a(this.a).setFocusableInTouchMode(true);
      FeedbackFacePageActivity.a(this.a).requestFocus();
      FeedbackFacePageActivity.a(this.a).findFocus();
      ((InputMethodManager)FeedbackFacePageActivity.a(this.a).getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */