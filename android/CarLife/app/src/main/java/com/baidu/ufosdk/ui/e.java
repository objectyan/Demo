package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ufosdk.UfoSDK;

final class e
  implements View.OnClickListener
{
  e(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onClick(View paramView)
  {
    FeedbackFacePageActivity.b(this.a, true);
    if (!FeedbackFacePageActivity.w(this.a)) {
      FeedbackFacePageActivity.x(this.a);
    }
    while (UfoSDK.clientid.length() == 0) {
      return;
    }
    FeedbackFacePageActivity.q(this.a).setVisibility(8);
    FeedbackFacePageActivity.s(this.a).setVisibility(8);
    FeedbackFacePageActivity.r(this.a).setVisibility(0);
    FeedbackFacePageActivity.a(this.a).setFocusable(false);
    FeedbackFacePageActivity.a(this.a).setFocusableInTouchMode(false);
    if ((this.a.getCurrentFocus() != null) && (this.a.getCurrentFocus().getWindowToken() != null)) {
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
    }
    FeedbackFacePageActivity.o(this.a).obtainMessage(2, null).sendToTarget();
    FeedbackFacePageActivity.u(this.a).setVisibility(0);
    FeedbackFacePageActivity.v(this.a).setText("常用问题");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */