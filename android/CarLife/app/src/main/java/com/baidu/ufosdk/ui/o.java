package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ufosdk.util.h;
import java.util.ArrayList;

final class o
  implements View.OnClickListener
{
  o(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onClick(View paramView)
  {
    if (!h.a())
    {
      FeedbackFacePageActivity.q(this.a).setVisibility(8);
      FeedbackFacePageActivity.d(this.a).setVisibility(8);
      FeedbackFacePageActivity.e(this.a).setVisibility(0);
      FeedbackFacePageActivity.s(this.a).setVisibility(8);
      FeedbackFacePageActivity.r(this.a).setVisibility(0);
      FeedbackFacePageActivity.r(this.a).bringToFront();
      FeedbackFacePageActivity.a(this.a).setFocusable(false);
      FeedbackFacePageActivity.a(this.a).setFocusableInTouchMode(false);
    }
    try
    {
      FeedbackFacePageActivity.t(this.a).clear();
      FeedbackFacePageActivity.b(this.a).clear();
      FeedbackFacePageActivity.c(this.a).notifyDataSetChanged();
      if ((this.a.getCurrentFocus() != null) && (this.a.getCurrentFocus().getWindowToken() != null)) {
        ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
      }
      return;
    }
    catch (Exception paramView)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */