package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.ufosdk.b.c;
import com.baidu.ufosdk.util.h;
import com.baidu.ufosdk.util.i;

final class ad
  implements View.OnClickListener
{
  ad(FeedbackHotActivity paramFeedbackHotActivity) {}
  
  public final void onClick(View paramView)
  {
    if (!h.a())
    {
      FeedbackHotActivity.b(this.a).setVisibility(0);
      FeedbackHotActivity.d(this.a).setVisibility(8);
      if ((c.b(this.a.getApplicationContext()).contains("UNKNOWN")) || (c.b(this.a.getApplicationContext()).contains("NONE")))
      {
        FeedbackHotActivity.b(this.a).setVisibility(8);
        i.a(this.a.getApplicationContext(), FeedbackHotActivity.c(this.a));
        FeedbackHotActivity.d(this.a).setVisibility(0);
      }
    }
    else
    {
      return;
    }
    FeedbackHotActivity.h(this.a);
    FeedbackHotActivity.d(this.a).setVisibility(8);
    FeedbackHotActivity.a(this.a).setVisibility(0);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */