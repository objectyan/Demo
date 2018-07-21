package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

final class ch
  implements View.OnClickListener
{
  ch(FeedbackListActivity paramFeedbackListActivity, Context paramContext, String paramString) {}
  
  public final void onClick(View paramView)
  {
    FeedbackListActivity.j(this.a).setVisibility(0);
    new Thread(new ci(this, this.b, this.c)).start();
    if (FeedbackListActivity.n(this.a).isShowing()) {
      FeedbackListActivity.n(this.a).dismiss();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */